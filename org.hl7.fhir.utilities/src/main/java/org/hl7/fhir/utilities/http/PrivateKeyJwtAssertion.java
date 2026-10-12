package org.hl7.fhir.utilities.http;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.ParseException;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.ECDSASigner;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.ECKey;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.util.JSONObjectUtils;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.settings.OAuthClientCredentialsPOJO;

/**
 * Builds the signed client assertion for {@code private_key_jwt} client authentication
 * (RFC 7523 §2.2 and §3; SMART Backend Services).
 * <p>
 * The key is read from {@link OAuthClientCredentialsPOJO#getPrivateKeyFile()} each time an
 * assertion is built - that is, only when a token is fetched - so a replaced key file takes effect
 * with the next token. Error messages name the file but never include its contents.
 */
final class PrivateKeyJwtAssertion {

  static final String CLIENT_ASSERTION_TYPE = "urn:ietf:params:oauth:client-assertion-type:jwt-bearer";

  /** SMART Backend Services requires the assertion to expire no more than five minutes in the future. */
  static final long LIFETIME_SECONDS = 300;

  private static final JWSAlgorithm DEFAULT_RSA_ALGORITHM = JWSAlgorithm.RS384;

  private static final List<JWSAlgorithm> RSA_ALGORITHMS = List.of(
    JWSAlgorithm.RS256, JWSAlgorithm.RS384, JWSAlgorithm.RS512,
    JWSAlgorithm.PS256, JWSAlgorithm.PS384, JWSAlgorithm.PS512);

  /** ECDSA fixes the algorithm by curve (RFC 7518 §3.4). */
  private static final Map<Curve, JWSAlgorithm> EC_ALGORITHMS = Map.of(
    Curve.P_256, JWSAlgorithm.ES256,
    Curve.P_384, JWSAlgorithm.ES384,
    Curve.P_521, JWSAlgorithm.ES512);

  private static final Pattern PKCS8_PEM = Pattern.compile(
    "-----BEGIN PRIVATE KEY-----([A-Za-z0-9+/=\\s]+)-----END PRIVATE KEY-----");

  /** A private key, with the {@code kid} and {@code alg} its JWK carried, if any. */
  record LoadedKey(PrivateKey privateKey, String keyId, String algorithm) {}

  private PrivateKeyJwtAssertion() {}

  /**
   * @return a signed JWT asserting {@code clientId} to {@code tokenEndpoint}, valid for {@value #LIFETIME_SECONDS} seconds
   * @throws IOException if the key cannot be read, is unsupported, or does not suit the configured algorithm
   */
  static String create(OAuthClientCredentialsPOJO credentials) throws IOException {
    String file = credentials.getPrivateKeyFile();
    LoadedKey key = loadKey(file, credentials.getKeyId());
    JWSAlgorithm algorithm = resolveAlgorithm(file, credentials.getSigningAlgorithm(), key);
    String keyId = credentials.getKeyId() != null ? credentials.getKeyId() : key.keyId();

    Instant now = Instant.now();
    JWTClaimsSet claims = new JWTClaimsSet.Builder()
      .issuer(credentials.getClientId())
      .subject(credentials.getClientId())
      .audience(credentials.getTokenEndpoint())
      .jwtID(UUID.randomUUID().toString())
      .issueTime(Date.from(now))
      .expirationTime(Date.from(now.plusSeconds(LIFETIME_SECONDS)))
      .build();
    JWSHeader header = new JWSHeader.Builder(algorithm)
      .type(JOSEObjectType.JWT)
      .keyID(keyId)
      .build();

    SignedJWT jwt = new SignedJWT(header, claims);
    try {
      jwt.sign(createSigner(file, key.privateKey()));
    } catch (JOSEException e) {
      throw new IOException("privateKeyFile " + file + " could not sign with " + algorithm + ": " + e.getMessage());
    }
    return jwt.serialize();
  }

  /**
   * Reads a PKCS#8 PEM private key, or a JWK or JWK Set. {@code keyId}, if set, selects the key
   * from a JWK Set; otherwise a JWK Set must hold exactly one private key.
   */
  static LoadedKey loadKey(String file, String keyId) throws IOException {
    String content;
    try {
      content = Files.readString(ManagedFileAccess.file(file).toPath(), StandardCharsets.UTF_8).strip();
    } catch (IOException e) {
      throw new IOException("Cannot read privateKeyFile " + file + " (" + e.getClass().getSimpleName() + ")");
    }
    if (content.startsWith("{")) {
      return loadJwk(file, content, keyId);
    }
    if (content.contains("-----BEGIN")) {
      return loadPem(file, content);
    }
    throw new IOException("privateKeyFile " + file + " is neither a PEM private key nor a JWK");
  }

  private static LoadedKey loadJwk(String file, String content, String keyId) throws IOException {
    JWK jwk;
    try {
      Map<String, Object> json = JSONObjectUtils.parse(content);
      jwk = json.containsKey("keys") ? selectKey(file, JWKSet.parse(json).getKeys(), keyId) : JWK.parse(json);
    } catch (ParseException e) {
      // The cause is not chained or quoted: parser messages can include the key material
      throw new IOException("privateKeyFile " + file + " is not a valid JWK or JWK Set");
    }
    if (!jwk.isPrivate()) {
      throw new IOException("privateKeyFile " + file + " holds a public key only");
    }
    PrivateKey privateKey;
    try {
      if (jwk instanceof RSAKey rsaKey) {
        privateKey = rsaKey.toPrivateKey();
      } else if (jwk instanceof ECKey ecKey) {
        privateKey = ecKey.toPrivateKey();
      } else {
        throw new IOException("privateKeyFile " + file + " holds a " + jwk.getKeyType() + " key; only RSA and EC are supported");
      }
    } catch (JOSEException e) {
      throw new IOException("privateKeyFile " + file + " holds a key that cannot be used");
    }
    return new LoadedKey(privateKey, jwk.getKeyID(), jwk.getAlgorithm() == null ? null : jwk.getAlgorithm().getName());
  }

  private static JWK selectKey(String file, List<JWK> keys, String keyId) throws IOException {
    List<JWK> candidates = keys.stream()
      .filter(JWK::isPrivate)
      .filter(k -> keyId == null || keyId.equals(k.getKeyID()))
      .toList();
    if (candidates.size() == 1) {
      return candidates.get(0);
    }
    if (keyId != null) {
      throw new IOException("privateKeyFile " + file + " holds no private key with kid '" + keyId + "'");
    }
    throw new IOException("privateKeyFile " + file + " holds " + candidates.size()
      + " private keys; set keyId to choose one");
  }

  private static LoadedKey loadPem(String file, String content) throws IOException {
    if (content.contains("-----BEGIN ENCRYPTED PRIVATE KEY-----")) {
      throw new IOException("privateKeyFile " + file + " is encrypted, which is not supported");
    }
    if (content.contains("-----BEGIN RSA PRIVATE KEY-----") || content.contains("-----BEGIN EC PRIVATE KEY-----")) {
      throw new IOException("privateKeyFile " + file + " is not in PKCS#8 format; convert it with "
        + "'openssl pkcs8 -topk8 -nocrypt -in <key> -out <new key>'");
    }
    Matcher matcher = PKCS8_PEM.matcher(content);
    if (!matcher.find()) {
      throw new IOException("privateKeyFile " + file + " holds no '-----BEGIN PRIVATE KEY-----' block");
    }
    PKCS8EncodedKeySpec spec;
    try {
      spec = new PKCS8EncodedKeySpec(Base64.getMimeDecoder().decode(matcher.group(1)));
    } catch (IllegalArgumentException e) {
      throw new IOException("privateKeyFile " + file + " holds a PEM block that is not valid base64");
    }
    for (String keyAlgorithm : List.of("RSA", "EC")) {
      try {
        return new LoadedKey(KeyFactory.getInstance(keyAlgorithm).generatePrivate(spec), null, null);
      } catch (GeneralSecurityException e) {
        // not a key of this type - try the next
      }
    }
    throw new IOException("privateKeyFile " + file + " holds a private key that is neither RSA nor EC");
  }

  /**
   * The configured {@code signingAlgorithm}, else the JWK's {@code alg}, else RS384 for an RSA key
   * or the algorithm an EC key's curve requires - checked against the key either way.
   */
  static JWSAlgorithm resolveAlgorithm(String file, String configured, LoadedKey key) throws IOException {
    String name = configured != null ? configured : key.algorithm();
    if (key.privateKey() instanceof RSAPrivateKey) {
      if (name == null) {
        return DEFAULT_RSA_ALGORITHM;
      }
      JWSAlgorithm algorithm = JWSAlgorithm.parse(name);
      if (!RSA_ALGORITHMS.contains(algorithm)) {
        throw new IOException("privateKeyFile " + file + " holds an RSA key, which cannot sign with " + name);
      }
      return algorithm;
    }
    if (key.privateKey() instanceof ECPrivateKey ecKey) {
      Curve curve = Curve.forECParameterSpec(ecKey.getParams());
      JWSAlgorithm curveAlgorithm = curve == null ? null : EC_ALGORITHMS.get(curve);
      if (curveAlgorithm == null) {
        throw new IOException("privateKeyFile " + file + " holds an EC key on an unsupported curve; use P-256, P-384 or P-521");
      }
      if (name != null && !curveAlgorithm.getName().equals(name)) {
        throw new IOException("privateKeyFile " + file + " holds a " + curve.getName() + " key, which signs with "
          + curveAlgorithm + ", not " + name);
      }
      return curveAlgorithm;
    }
    throw new IOException("privateKeyFile " + file + " holds a " + key.privateKey().getAlgorithm()
      + " key; only RSA and EC are supported");
  }

  private static JWSSigner createSigner(String file, PrivateKey privateKey) throws IOException, JOSEException {
    if (privateKey instanceof ECPrivateKey ecKey) {
      return new ECDSASigner(ecKey);
    }
    try {
      return new RSASSASigner(privateKey);
    } catch (IllegalArgumentException e) {
      // RSASSASigner rejects keys under 2048 bits (RFC 7518 §3.3)
      throw new IOException("privateKeyFile " + file + " holds an RSA key shorter than 2048 bits");
    }
  }
}
