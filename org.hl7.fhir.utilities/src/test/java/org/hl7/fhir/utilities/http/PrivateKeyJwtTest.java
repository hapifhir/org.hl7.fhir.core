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
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import com.nimbusds.jose.Algorithm;
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
  /** An RSA key under the RSASSA-PSS OID, as {@code openssl genpkey -algorithm RSA-PSS} produces. */
  private static final KeyPair RSA_PSS_2048 = generate("RSASSA-PSS", 2048);

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
      .containsEntry("client_id", credentials.getClientId())
      .doesNotContainKey("client_secret");
    if (credentials.getScope() == null) {
      assertThat(form).doesNotContainKey("scope");
    }
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
    assertThat(PrivateKeyJwtAssertion.LIFETIME_SECONDS)
      .as("SMART Backend Services: exp no more than five minutes in the future, with room for clock skew")
      .isLessThan(300);
  }

  @Test
  void pemKeyWithoutKeyIdSendsNoKid() throws Exception {
    SignedJWT jwt = fetchAssertion(credentials(writePem(RSA_2048)).build());

    assertThat(jwt.getHeader().getKeyID()).isNull();
    assertSignedBy(jwt, RSA_2048.getPublic());
  }

  @Test
  void scopeIsSentWithTheTokenRequest() throws Exception {
    tokenServer.enqueue(tokenResponse("the-token", 3600));

    getToken(credentials(writePem(RSA_2048)).scope(" system/*.rs system/Patient.r ").build());

    assertThat(form(tokenServer.takeRequest())).containsEntry("scope", "system/*.rs system/Patient.r");
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

  static Stream<Arguments> cacheKeyVariations() {
    return Stream.of(
      Arguments.of("keyId", (UnaryOperator<OAuthClientCredentialsPOJO.OAuthClientCredentialsPOJOBuilder>) b -> b.keyId("other")),
      Arguments.of("signingAlgorithm", (UnaryOperator<OAuthClientCredentialsPOJO.OAuthClientCredentialsPOJOBuilder>) b -> b.signingAlgorithm("PS256")),
      Arguments.of("scope", (UnaryOperator<OAuthClientCredentialsPOJO.OAuthClientCredentialsPOJOBuilder>) b -> b.scope("system/*.rs")));
  }

  /** The same key file, configured differently, must not be served the other configuration's token. */
  @ParameterizedTest(name = "{0}")
  @MethodSource("cacheKeyVariations")
  void configurationsDifferingOnlyInOneFieldDoNotShareACachedToken(
      String field, UnaryOperator<OAuthClientCredentialsPOJO.OAuthClientCredentialsPOJOBuilder> variation) throws Exception {
    String file = writePem(RSA_2048);
    OAuthClientCredentialsPOJO base = credentials(file).build();
    OAuthClientCredentialsPOJO varied = variation.apply(credentials(file)).build();
    tokenServer.enqueue(tokenResponse("token-a", 3600));
    tokenServer.enqueue(tokenResponse("token-b", 3600));

    assertThat(getToken(base)).isEqualTo("token-a");
    assertThat(getToken(varied)).isEqualTo("token-b");
    assertThat(getToken(base)).isEqualTo("token-a");
    assertThat(tokenServer.getRequestCount()).isEqualTo(2);
  }

  @Test
  void differentKeyFilesDoNotShareACachedToken() throws Exception {
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
  void configuredAlgorithmOverridesJwkAlgorithm() throws Exception {
    RSAKey jwk = new RSAKey.Builder(rsaJwk(RSA_2048, "jwk-kid")).algorithm(JWSAlgorithm.PS256).build();
    String file = writeKey("key.json", jwk.toJSONString());

    SignedJWT jwt = fetchAssertion(credentials(file).keyId("jwk-kid").signingAlgorithm("RS512").build());

    assertThat(jwt.getHeader().getKeyID()).isEqualTo("jwk-kid");
    assertThat(jwt.getHeader().getAlgorithm()).isEqualTo(JWSAlgorithm.RS512);
  }

  @Test
  void configuredKeyIdNamesAJwkThatHasNoKid() throws Exception {
    String file = writeKey("key.json", rsaJwk(RSA_2048, null).toJSONString());

    SignedJWT jwt = fetchAssertion(credentials(file).keyId("configured-kid").build());

    assertThat(jwt.getHeader().getKeyID()).isEqualTo("configured-kid");
  }

  @Test
  void rsaPssKeyDefaultsToPs384() throws Exception {
    SignedJWT jwt = fetchAssertion(credentials(writePem(RSA_PSS_2048)).build());

    assertThat(jwt.getHeader().getAlgorithm()).isEqualTo(JWSAlgorithm.PS384);
    assertSignedBy(jwt, RSA_PSS_2048.getPublic());
  }

  @Test
  void jwkSetIgnoresKeysThatCannotSign() throws Exception {
    JWKSet set = new JWKSet(List.of(new OctetSequenceKey.Builder(new byte[32]).keyID("oct").build(), rsaJwk(RSA_2048, "rsa")));

    SignedJWT jwt = fetchAssertion(credentials(writeKey("keys.json", set.toString(false))).build());

    assertThat(jwt.getHeader().getKeyID()).isEqualTo("rsa");
  }

  static Stream<Arguments> loadableFiles() {
    String pkcs8 = pem("PRIVATE KEY", RSA_2048.getPrivate().getEncoded());
    return Stream.of(
      Arguments.of("CRLF line endings", pkcs8.replace("\n", "\r\n")),
      Arguments.of("leading text from openssl pkcs12", "Bag Attributes\n    localKeyID: 01 02 03\nKey Attributes: <No Attributes>\n" + pkcs8),
      Arguments.of("stray PKCS#1 marker before the PKCS#8 block", "# was -----BEGIN RSA PRIVATE KEY----- before conversion\n" + pkcs8),
      Arguments.of("UTF-8 byte order mark, PEM", "\uFEFF" + pkcs8),
      Arguments.of("UTF-8 byte order mark, JWK", "\uFEFF" + rsaJwk(RSA_2048, "k").toJSONString()));
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("loadableFiles")
  void keyFileVariantsLoad(String description, String content) throws Exception {
    SignedJWT jwt = fetchAssertion(credentials(writeKey("key", content)).build());

    assertSignedBy(jwt, RSA_2048.getPublic());
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
      Arguments.of("JWK alg none", new RSAKey.Builder(rsaJwk(RSA_2048, "k")).algorithm(Algorithm.NONE).build()
        .toJSONString(), null, null, "cannot sign with none"),
      Arguments.of("JWK alg HS256", new RSAKey.Builder(rsaJwk(RSA_2048, "k")).algorithm(JWSAlgorithm.HS256).build()
        .toJSONString(), null, null, "cannot sign with HS256"),
      Arguments.of("JWK kid differs from keyId", rsaJwk(RSA_2048, "jwk-kid").toJSONString(), "other", null,
        "holds a key with kid 'jwk-kid', not the configured keyId 'other'"),
      Arguments.of("RS256 with RSA-PSS key", pem("PRIVATE KEY", RSA_PSS_2048.getPrivate().getEncoded()), null, "RS256",
        "RSA-PSS key, which cannot sign with RS256"),
      Arguments.of("JWK Set, two keys", new JWKSet(List.of(rsaJwk(RSA_2048, "a"), rsaJwk(RSA_2048, "b")))
        .toString(false), null, null, "holds 2 RSA or EC private keys; set keyId"),
      Arguments.of("JWK Set, two keys with the configured kid", new JWKSet(List.of(rsaJwk(RSA_2048, "a"),
        ecJwk(Curve.P_384, EC_P384, "a"))).toString(false), "a", null, "holds 2 RSA or EC private keys with kid 'a'"),
      Arguments.of("JWK Set, unknown kid", new JWKSet(List.of(rsaJwk(RSA_2048, "a"))).toString(false),
        "z", null, "holds no RSA or EC private key with kid 'z'"),
      Arguments.of("JWK Set, symmetric key only", new JWKSet(List.of(new OctetSequenceKey.Builder(new byte[32]).build()))
        .toString(false), null, null, "holds no RSA or EC private key"),
      Arguments.of("JWK Set, unknown key type", "{\"keys\":[{\"kty\":\"FOO\",\"kid\":\"a\"}]}", null, null,
        "holds no RSA or EC private key")
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

  /** Well-formed JSON that the JWK parser rejects - its messages may quote the members it read. */
  static Stream<Arguments> invalidJwks() {
    String withBadExponent = rsaJwk(RSA_2048, "k").toJSONString().replaceFirst("\"e\":\"[^\"]*\"", "\"e\":5");
    return Stream.of(
      Arguments.of("JWK", withBadExponent),
      Arguments.of("JWK Set", "{\"keys\":[" + withBadExponent + "]}"));
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("invalidJwks")
  void errorsNeverQuoteTheKeyFile(String description, String content) throws Exception {
    assertThat(content).as("the test input must be valid JSON that only fails JWK parsing").contains("\"e\":5");
    String privateExponent = rsaJwk(RSA_2048, "k").getPrivateExponent().toString();
    String file = writeKey("key.json", content);

    assertThatThrownBy(() -> getToken(credentials(file).build()))
      .isInstanceOf(IOException.class)
      .hasMessageContaining("is not a valid JWK or JWK Set")
      .hasNoCause()
      .satisfies(e -> assertThat(e.getMessage()).doesNotContain(privateExponent));
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
