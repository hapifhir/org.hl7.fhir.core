package org.hl7.fhir.utilities.http;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
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

import lombok.extern.slf4j.Slf4j;

import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.settings.OAuthClientCredentialsPOJO;

/**
 * Builds the signed client assertion for {@code private_key_jwt} client authentication
 * (RFC 7523 §2.2 and §3; SMART Backend Services).
 * <p>
 * The key is read from {@link OAuthClientCredentialsPOJO#getPrivateKeyFile()} each time an
 * assertion is built - that is, only when a token is fetched - so a replaced key file takes effect
 * with the next token. Error messages name the file but never include its contents, nor messages
 * from the parsing and signing libraries, which could.
 */
@Slf4j
final class PrivateKeyJwtAssertion {

  static final String CLIENT_ASSERTION_TYPE = "urn:ietf:params:oauth:client-assertion-type:jwt-bearer";

  /**
   * SMART Backend Services requires the assertion to expire no more than five minutes in the
   * future. This stays a minute inside that, so a client clock running slightly ahead of the
   * authorization server's is not rejected.
   */
  static final long LIFETIME_SECONDS = 240;

  private static final JWSAlgorithm DEFAULT_RSA_ALGORITHM = JWSAlgorithm.RS384;
  private static final JWSAlgorithm DEFAULT_RSA_PSS_ALGORITHM = JWSAlgorithm.PS384;

  private static final List<JWSAlgorithm> RSA_PSS_ALGORITHMS = List.of(
    JWSAlgorithm.PS256, JWSAlgorithm.PS384, JWSAlgorithm.PS512);

  private static final List<JWSAlgorithm> RSA_ALGORITHMS = List.of(
    JWSAlgorithm.RS256, JWSAlgorithm.RS384, JWSAlgorithm.RS512,
    JWSAlgorithm.PS256, JWSAlgorithm.PS384, JWSAlgorithm.PS512);

  /** ECDSA fixes the algorithm by curve (RFC 7518 §3.4). */
  private static final Map<Curve, JWSAlgorithm> EC_ALGORITHMS = Map.of(
    Curve.P_256, JWSAlgorithm.ES256,
    Curve.P_384, JWSAlgorithm.ES384,
    Curve.P_521, JWSAlgorithm.ES512);

  /**
   * The key types a PKCS#8 file may hold, by JCA name. "RSASSA-PSS" is an RSA key restricted to
   * PSS signatures (the RSASSA-PSS OID, as {@code openssl genpkey -algorithm RSA-PSS} produces).
   */
  private static final List<String> PKCS8_KEY_ALGORITHMS = List.of("RSA", "RSASSA-PSS", "EC");

  private static final String RSA_PSS_KEY_ALGORITHM = "RSASSA-PSS";

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
    if (keyId == null) {
      // Not an error: RFC 7523 does not require a kid, and an authorization server holding a single
      // key for the client does not need one. SMART Backend Services does require it, though, and
      // the server's rejection (invalid_client) would not say why.
      log.warn("privateKeyFile {} has no key id and no keyId is configured, so the client assertion has no 'kid'"
        + " header; authorization servers that select the key by kid (as SMART Backend Services requires) will reject it", file);
    }

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
      log.debug("Signing with privateKeyFile {} failed", file, e);
      throw new IOException("privateKeyFile " + file + " could not sign with " + algorithm);
    }
    return jwt.serialize();
  }

  /**
   * Reads a PKCS#8 PEM private key, or a JWK or JWK Set. {@code keyId}, if set, selects the key
   * from a JWK Set and must match a single JWK's {@code kid}, if it has one; otherwise a JWK Set
   * must hold exactly one RSA or EC private key.
   */
  static LoadedKey loadKey(String file, String keyId) throws IOException {
    String content = readKeyFile(file);
    if (content.startsWith("{")) {
      return loadJwk(file, content, keyId);
    }
    if (content.contains("-----BEGIN")) {
      return loadPem(file, content);
    }
    throw new IOException("privateKeyFile " + file + " is neither a PEM private key nor a JWK");
  }

  private static String readKeyFile(String file) throws IOException {
    String content;
    // Opened through ManagedFileAccess, so a policy refusal propagates with its own explanation
    try (InputStream in = ManagedFileAccess.inStream(file)) {
      content = new String(in.readAllBytes(), StandardCharsets.UTF_8);
    } catch (FileNotFoundException e) {
      throw new IOException("Cannot read privateKeyFile " + file + " (not found, or not readable)");
    }
    // Editors on Windows commonly save UTF-8 with a byte order mark, which strip() leaves in place
    if (content.startsWith("﻿")) {
      content = content.substring(1);
    }
    return content.strip();
  }

  private static LoadedKey loadJwk(String file, String content, String keyId) throws IOException {
    JWK jwk;
    try {
      Map<String, Object> json = JSONObjectUtils.parse(content);
      if (json.containsKey("keys")) {
        jwk = selectKey(file, JWKSet.parse(json).getKeys(), keyId);
      } else {
        jwk = JWK.parse(json);
        if (keyId != null && jwk.getKeyID() != null && !keyId.equals(jwk.getKeyID())) {
          // The kid would name a key the authorization server does not associate with this one
          throw new IOException("privateKeyFile " + file + " holds a key with kid '" + jwk.getKeyID()
            + "', not the configured keyId '" + keyId + "'");
        }
      }
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

  /**
   * Picks the signing key from a JWK Set: the RSA or EC private key with the configured kid, or
   * the only one. Members of other types are ignored (the parser already drops unknown types).
   */
  private static JWK selectKey(String file, List<JWK> keys, String keyId) throws IOException {
    List<JWK> candidates = keys.stream()
      .filter(k -> k instanceof RSAKey || k instanceof ECKey)
      .filter(JWK::isPrivate)
      .filter(k -> keyId == null || keyId.equals(k.getKeyID()))
      .toList();
    if (candidates.size() == 1) {
      return candidates.get(0);
    }
    String withKid = keyId == null ? "" : " with kid '" + keyId + "'";
    if (candidates.isEmpty()) {
      throw new IOException("privateKeyFile " + file + " holds no RSA or EC private key" + withKid);
    }
    throw new IOException("privateKeyFile " + file + " holds " + candidates.size() + " RSA or EC private keys" + withKid
      + (keyId == null ? "; set keyId to choose one" : ""));
  }

  private static LoadedKey loadPem(String file, String content) throws IOException {
    Matcher matcher = PKCS8_PEM.matcher(content);
    if (!matcher.find()) {
      // Only consulted when there is no usable block, so that a file with a stray marker - in a
      // second block, or a comment left by a conversion tool - still loads.
      if (content.contains("-----BEGIN ENCRYPTED PRIVATE KEY-----")) {
        throw new IOException("privateKeyFile " + file + " is encrypted, which is not supported");
      }
      if (content.contains("-----BEGIN RSA PRIVATE KEY-----") || content.contains("-----BEGIN EC PRIVATE KEY-----")) {
        throw new IOException("privateKeyFile " + file + " is not in PKCS#8 format; convert it with "
          + "'openssl pkcs8 -topk8 -nocrypt -in <key> -out <new key>'");
      }
      throw new IOException("privateKeyFile " + file + " holds no '-----BEGIN PRIVATE KEY-----' block");
    }
    PKCS8EncodedKeySpec spec;
    try {
      spec = new PKCS8EncodedKeySpec(Base64.getMimeDecoder().decode(matcher.group(1)));
    } catch (IllegalArgumentException e) {
      throw new IOException("privateKeyFile " + file + " holds a PEM block that is not valid base64");
    }
    for (String keyAlgorithm : PKCS8_KEY_ALGORITHMS) {
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
   * (PS384 for an RSA key restricted to PSS) or the algorithm an EC key's curve requires - checked
   * against the key either way.
   * <p>
   * A configured {@code signingAlgorithm} deliberately takes precedence over the JWK's {@code alg},
   * so a key can be used without editing its file - but it must still suit the key.
   */
  static JWSAlgorithm resolveAlgorithm(String file, String configured, LoadedKey key) throws IOException {
    String name = configured != null ? configured : key.algorithm();
    if (key.privateKey() instanceof RSAPrivateKey) {
      boolean pssOnly = RSA_PSS_KEY_ALGORITHM.equals(key.privateKey().getAlgorithm());
      if (name == null) {
        return pssOnly ? DEFAULT_RSA_PSS_ALGORITHM : DEFAULT_RSA_ALGORITHM;
      }
      JWSAlgorithm algorithm = JWSAlgorithm.parse(name);
      if (!(pssOnly ? RSA_PSS_ALGORITHMS : RSA_ALGORITHMS).contains(algorithm)) {
        throw new IOException("privateKeyFile " + file + " holds an " + (pssOnly ? "RSA-PSS" : "RSA")
          + " key, which cannot sign with " + name);
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
