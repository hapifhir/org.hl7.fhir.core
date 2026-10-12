package org.hl7.fhir.utilities.http;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hl7.fhir.utilities.http.OAuthTestSupport.tokenResponse;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.time.Instant;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.ECDSAVerifier;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.ECKey;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.hl7.fhir.utilities.settings.OAuthClientCredentialsPOJO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * End-to-end tests for {@code private_key_jwt}: real keys, a TLS token endpoint, and assertions
 * verified against the public key as an authorization server would.
 */
class PrivateKeyJwtTest {

  private static final KeyPair RSA_2048 = generate("RSA", 2048);
  private static final KeyPair EC_P256 = generateEc("secp256r1");
  private static final KeyPair EC_P384 = generateEc("secp384r1");
  private static final KeyPair EC_P521 = generateEc("secp521r1");

  @TempDir
  Path keyDir;

  private MockWebServer tokenServer;

  @BeforeEach
  void setup() throws IOException {
    OAuthTestSupport.trustTestCertificate();
    tokenServer = OAuthTestSupport.startHttpsServer();
    HTTPTokenManager.clearCache();
  }

  @AfterEach
  void tearDown() throws IOException {
    tokenServer.shutdown();
    HTTPTokenManager.clearCache();
    OAuthTestSupport.resetTrust();
  }

  private static KeyPair generate(String algorithm, int size) {
    try {
      KeyPairGenerator generator = KeyPairGenerator.getInstance(algorithm);
      generator.initialize(size);
      return generator.generateKeyPair();
    } catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }

  private static KeyPair generateEc(String curve) {
    try {
      KeyPairGenerator generator = KeyPairGenerator.getInstance("EC");
      generator.initialize(new ECGenParameterSpec(curve));
      return generator.generateKeyPair();
    } catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }

  private static String pem(String type, byte[] der) {
    return "-----BEGIN " + type + "-----\n"
      + Base64.getMimeEncoder(64, "\n".getBytes(StandardCharsets.US_ASCII)).encodeToString(der)
      + "\n-----END " + type + "-----\n";
  }

  private String writeKey(String name, String content) throws IOException {
    Path file = keyDir.resolve(name);
    Files.writeString(file, content);
    return file.toString();
  }

  private String writePem(KeyPair keyPair) throws IOException {
    return writeKey("key.pem", pem("PRIVATE KEY", keyPair.getPrivate().getEncoded()));
  }

  private static RSAKey rsaJwk(KeyPair keyPair, String kid) {
    return new RSAKey.Builder((RSAPublicKey) keyPair.getPublic()).privateKey(keyPair.getPrivate()).keyID(kid).build();
  }

  private static ECKey ecJwk(Curve curve, KeyPair keyPair, String kid) {
    return new ECKey.Builder(curve, (ECPublicKey) keyPair.getPublic()).privateKey(keyPair.getPrivate()).keyID(kid).build();
  }

  private OAuthClientCredentialsPOJO.OAuthClientCredentialsPOJOBuilder credentials(String privateKeyFile) {
    return OAuthClientCredentialsPOJO.builder()
      .clientId("my-client")
      .clientAuthMethod(OAuthClientCredentialsPOJO.PRIVATE_KEY_JWT)
      .privateKeyFile(privateKeyFile)
      .tokenEndpoint(tokenServer.url("/token").toString());
  }

  /** The mock token endpoint is on a loopback address, so it needs the private-network opt-in. */
  private String getToken(OAuthClientCredentialsPOJO credentials) throws IOException {
    return HTTPTokenManager.getToken(credentials, true);
  }

  private static Map<String, String> form(RecordedRequest request) {
    Map<String, String> form = new HashMap<>();
    for (String pair : request.getBody().readUtf8().split("&")) {
      String[] kv = pair.split("=", 2);
      form.put(URLDecoder.decode(kv[0], StandardCharsets.UTF_8), URLDecoder.decode(kv[1], StandardCharsets.UTF_8));
    }
    return form;
  }

  /** Fetches a token and returns the client assertion the token endpoint received. */
  private SignedJWT fetchAssertion(OAuthClientCredentialsPOJO credentials) throws Exception {
    tokenServer.enqueue(tokenResponse("the-token", 3600));
    assertThat(getToken(credentials)).isEqualTo("the-token");
    Map<String, String> form = form(tokenServer.takeRequest());
    assertThat(form).containsEntry("grant_type", "client_credentials")
      .containsEntry("client_assertion_type", "urn:ietf:params:oauth:client-assertion-type:jwt-bearer")
      .doesNotContainKeys("client_id", "client_secret");
    return SignedJWT.parse(form.get("client_assertion"));
  }

  private void assertSignedBy(SignedJWT jwt, PublicKey publicKey) throws Exception {
    JWSVerifier verifier = publicKey instanceof RSAPublicKey rsa
      ? new RSASSAVerifier(rsa)
      : new ECDSAVerifier((ECPublicKey) publicKey);
    assertThat(jwt.verify(verifier)).as("signature verifies with the public key").isTrue();
  }

  @Test
  void assertionCarriesTheClaimsRfc7523AndSmartRequire() throws Exception {
    OAuthClientCredentialsPOJO credentials = credentials(writePem(RSA_2048)).keyId("key-1").build();

    Instant before = Instant.now().minusSeconds(1);
    SignedJWT jwt = fetchAssertion(credentials);
    Instant after = Instant.now().plusSeconds(1);

    assertSignedBy(jwt, RSA_2048.getPublic());
    assertThat(jwt.getHeader().getAlgorithm()).isEqualTo(JWSAlgorithm.RS384);
    assertThat(jwt.getHeader().getKeyID()).isEqualTo("key-1");
    assertThat(jwt.getHeader().getType()).isEqualTo(JOSEObjectType.JWT);

    JWTClaimsSet claims = jwt.getJWTClaimsSet();
    assertThat(claims.getIssuer()).isEqualTo("my-client");
    assertThat(claims.getSubject()).isEqualTo("my-client");
    assertThat(claims.getAudience()).containsExactly(credentials.getTokenEndpoint());
    assertThat(claims.getJWTID()).isNotBlank();
    assertThat(claims.getIssueTime().toInstant()).isBetween(before, after);
    assertThat(claims.getExpirationTime().getTime() - claims.getIssueTime().getTime())
      .isEqualTo(PrivateKeyJwtAssertion.LIFETIME_SECONDS * 1000);
  }

  @Test
  void eachTokenRequestUsesAFreshAssertion() throws Exception {
    OAuthClientCredentialsPOJO credentials = credentials(writePem(RSA_2048)).build();

    SignedJWT first = fetchAssertion(credentials);
    HTTPTokenManager.invalidateToken(credentials, "the-token");
    SignedJWT second = fetchAssertion(credentials);

    assertThat(second.getJWTClaimsSet().getJWTID()).isNotEqualTo(first.getJWTClaimsSet().getJWTID());
  }

  @Test
  void tokenIsCachedLikeAnyOther() throws Exception {
    OAuthClientCredentialsPOJO credentials = credentials(writePem(RSA_2048)).build();
    tokenServer.enqueue(tokenResponse("the-token", 3600));

    assertThat(getToken(credentials)).isEqualTo("the-token");
    assertThat(getToken(credentials)).isEqualTo("the-token");
    assertThat(tokenServer.getRequestCount()).isEqualTo(1);
  }

  @Test
  void differentKeysDoNotShareACachedToken() throws Exception {
    tokenServer.enqueue(tokenResponse("token-a", 3600));
    tokenServer.enqueue(tokenResponse("token-b", 3600));

    assertThat(getToken(credentials(writeKey("a.pem", pem("PRIVATE KEY", RSA_2048.getPrivate().getEncoded()))).build()))
      .isEqualTo("token-a");
    assertThat(getToken(credentials(writeKey("b.pem", pem("PRIVATE KEY", EC_P384.getPrivate().getEncoded()))).build()))
      .isEqualTo("token-b");
  }

  @ParameterizedTest
  @ValueSource(strings = {"RS256", "RS384", "RS512", "PS256", "PS384", "PS512"})
  void rsaKeySignsWithConfiguredAlgorithm(String algorithm) throws Exception {
    SignedJWT jwt = fetchAssertion(credentials(writePem(RSA_2048)).signingAlgorithm(algorithm).build());

    assertThat(jwt.getHeader().getAlgorithm().getName()).isEqualTo(algorithm);
    assertSignedBy(jwt, RSA_2048.getPublic());
  }

  static Stream<Arguments> ecCurves() {
    return Stream.of(
      Arguments.of(EC_P256, "ES256"),
      Arguments.of(EC_P384, "ES384"),
      Arguments.of(EC_P521, "ES512"));
  }

  @ParameterizedTest
  @MethodSource("ecCurves")
  void ecKeySignsWithTheAlgorithmItsCurveRequires(KeyPair keyPair, String algorithm) throws Exception {
    String file = writePem(keyPair);

    SignedJWT jwt = fetchAssertion(credentials(file).build());
    assertThat(jwt.getHeader().getAlgorithm().getName()).isEqualTo(algorithm);
    assertSignedBy(jwt, keyPair.getPublic());

    HTTPTokenManager.clearCache();
    SignedJWT explicit = fetchAssertion(credentials(file).signingAlgorithm(algorithm).build());
    assertThat(explicit.getHeader().getAlgorithm().getName()).isEqualTo(algorithm);
  }

  @Test
  void jwkSuppliesKidAndAlgorithm() throws Exception {
    RSAKey jwk = new RSAKey.Builder(rsaJwk(RSA_2048, "jwk-kid")).algorithm(JWSAlgorithm.PS256).build();

    SignedJWT jwt = fetchAssertion(credentials(writeKey("key.json", jwk.toJSONString())).build());

    assertThat(jwt.getHeader().getKeyID()).isEqualTo("jwk-kid");
    assertThat(jwt.getHeader().getAlgorithm()).isEqualTo(JWSAlgorithm.PS256);
    assertSignedBy(jwt, RSA_2048.getPublic());
  }

  @Test
  void configurationOverridesJwkKidAndAlgorithm() throws Exception {
    RSAKey jwk = new RSAKey.Builder(rsaJwk(RSA_2048, "jwk-kid")).algorithm(JWSAlgorithm.PS256).build();
    String file = writeKey("key.json", jwk.toJSONString());

    SignedJWT jwt = fetchAssertion(credentials(file).keyId("configured-kid").signingAlgorithm("RS512").build());

    assertThat(jwt.getHeader().getKeyID()).isEqualTo("configured-kid");
    assertThat(jwt.getHeader().getAlgorithm()).isEqualTo(JWSAlgorithm.RS512);
  }

  @Test
  void ecJwkDefaultsByCurve() throws Exception {
    String file = writeKey("key.json", ecJwk(Curve.P_384, EC_P384, "ec-kid").toJSONString());

    SignedJWT jwt = fetchAssertion(credentials(file).build());

    assertThat(jwt.getHeader().getAlgorithm()).isEqualTo(JWSAlgorithm.ES384);
    assertThat(jwt.getHeader().getKeyID()).isEqualTo("ec-kid");
    assertSignedBy(jwt, EC_P384.getPublic());
  }

  @Test
  void keyIdSelectsFromJwkSet() throws Exception {
    JWKSet set = new JWKSet(List.of(rsaJwk(RSA_2048, "rsa"), ecJwk(Curve.P_384, EC_P384, "ec")));
    String file = writeKey("keys.json", set.toString(false));

    SignedJWT jwt = fetchAssertion(credentials(file).keyId("ec").build());

    assertThat(jwt.getHeader().getKeyID()).isEqualTo("ec");
    assertSignedBy(jwt, EC_P384.getPublic());
  }

  @Test
  void jwkSetWithOnePrivateKeyNeedsNoKeyId() throws Exception {
    JWK publicOnly = ecJwk(Curve.P_256, EC_P256, "public").toPublicJWK();
    JWKSet set = new JWKSet(List.of(publicOnly, rsaJwk(RSA_2048, "rsa")));

    SignedJWT jwt = fetchAssertion(credentials(writeKey("keys.json", set.toString(false))).build());

    assertThat(jwt.getHeader().getKeyID()).isEqualTo("rsa");
  }

  static Stream<Arguments> unusableKeys() {
    byte[] rsa = RSA_2048.getPrivate().getEncoded();
    return Stream.of(
      Arguments.of("PKCS#1 RSA", pem("RSA PRIVATE KEY", rsa), null, null, "is not in PKCS#8 format"),
      Arguments.of("SEC1 EC", pem("EC PRIVATE KEY", rsa), null, null, "is not in PKCS#8 format"),
      Arguments.of("encrypted", pem("ENCRYPTED PRIVATE KEY", rsa), null, null, "is encrypted"),
      Arguments.of("certificate only", pem("CERTIFICATE", rsa), null, null, "holds no '-----BEGIN PRIVATE KEY-----' block"),
      Arguments.of("not a key", "hello", null, null, "is neither a PEM private key nor a JWK"),
      Arguments.of("bad JSON", "{\"kty\":", null, null, "is not a valid JWK or JWK Set"),
      Arguments.of("Ed25519", pem("PRIVATE KEY", generate("Ed25519", 255).getPrivate().getEncoded()), null, null,
        "neither RSA nor EC"),
      Arguments.of("1024-bit RSA", pem("PRIVATE KEY", generate("RSA", 1024).getPrivate().getEncoded()), null, null,
        "shorter than 2048 bits"),
      Arguments.of("public JWK", rsaJwk(RSA_2048, "k").toPublicJWK().toJSONString(), null, null, "holds a public key only"),
      Arguments.of("symmetric JWK", new OctetSequenceKey.Builder(new byte[32]).build().toJSONString(), null, null,
        "only RSA and EC are supported"),
      Arguments.of("ES256 with P-384", pem("PRIVATE KEY", EC_P384.getPrivate().getEncoded()), null, "ES256",
        "signs with ES384, not ES256"),
      Arguments.of("ES384 with RSA", pem("PRIVATE KEY", rsa), null, "ES384", "RSA key, which cannot sign with ES384"),
      Arguments.of("JWK alg for encryption", new RSAKey.Builder(rsaJwk(RSA_2048, "k"))
        .algorithm(JWEAlgorithm.RSA_OAEP_256).build().toJSONString(), null, null,
        "cannot sign with RSA-OAEP-256"),
      Arguments.of("JWK Set, two keys", new JWKSet(List.of(rsaJwk(RSA_2048, "a"), rsaJwk(RSA_2048, "b")))
        .toString(false), null, null, "holds 2 private keys; set keyId"),
      Arguments.of("JWK Set, unknown kid", new JWKSet(List.of(rsaJwk(RSA_2048, "a"))).toString(false),
        "z", null, "no private key with kid 'z'")
    );
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("unusableKeys")
  void unusableKeyFailsBeforeContactingTheTokenEndpoint(String description, String content, String keyId,
                                                       String algorithm, String problem) throws Exception {
    String file = writeKey("key", content);
    OAuthClientCredentialsPOJO credentials = credentials(file).keyId(keyId).signingAlgorithm(algorithm).build();

    assertThatThrownBy(() -> getToken(credentials))
      .isInstanceOf(IOException.class)
      .hasMessageContaining(file)
      .hasMessageContaining(problem);
    assertThat(tokenServer.getRequestCount()).isZero();
  }

  @Test
  void errorsNeverQuoteTheKeyFile() throws Exception {
    String brokenJwk = rsaJwk(RSA_2048, "k").toJSONString().replace("\"d\":", "\"d\":[");
    String file = writeKey("key.json", brokenJwk);

    assertThatThrownBy(() -> getToken(credentials(file).build()))
      .isInstanceOf(IOException.class)
      .satisfies(e -> assertThat(e.getMessage()).doesNotContain(rsaJwk(RSA_2048, "k").getPrivateExponent().toString()))
      .hasNoCause();
  }

  @Test
  void missingKeyFileFails() {
    String file = keyDir.resolve("absent.pem").toString();

    assertThatThrownBy(() -> getToken(credentials(file).build()))
      .isInstanceOf(IOException.class)
      .hasMessageContaining("Cannot read privateKeyFile " + file);
    assertThat(tokenServer.getRequestCount()).isZero();
  }
}
