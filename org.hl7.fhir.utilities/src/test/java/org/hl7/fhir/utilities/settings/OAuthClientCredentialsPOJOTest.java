package org.hl7.fhir.utilities.settings;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class OAuthClientCredentialsPOJOTest {

  private static OAuthClientCredentialsPOJO.OAuthClientCredentialsPOJOBuilder secretPost() {
    return OAuthClientCredentialsPOJO.builder()
      .clientId("client")
      .clientSecret("secret")
      .tokenEndpoint("https://auth.example.org/token");
  }

  private static OAuthClientCredentialsPOJO.OAuthClientCredentialsPOJOBuilder privateKeyJwt() {
    return OAuthClientCredentialsPOJO.builder()
      .clientId("client")
      .clientAuthMethod(OAuthClientCredentialsPOJO.PRIVATE_KEY_JWT)
      .privateKeyFile("/keys/client.pem")
      .tokenEndpoint("https://auth.example.org/token");
  }

  @Test
  void clientSecretPostIsTheDefault() {
    OAuthClientCredentialsPOJO credentials = secretPost().build();
    assertThat(credentials.resolvedClientAuthMethod()).isEqualTo(OAuthClientCredentialsPOJO.CLIENT_SECRET_POST);
    assertThat(credentials.findProblem()).isNull();
    assertThat(secretPost().clientAuthMethod("client_secret_post").build().findProblem()).isNull();
    assertThat(secretPost().clientAuthMethod(" ").build().resolvedClientAuthMethod())
      .isEqualTo(OAuthClientCredentialsPOJO.CLIENT_SECRET_POST);
  }

  @Test
  void scopeIsAllowedWithEitherMethod() {
    assertThat(secretPost().scope("system/*.rs").build().findProblem()).isNull();
    assertThat(privateKeyJwt().scope("system/*.rs").build().findProblem()).isNull();
  }

  @ParameterizedTest
  @ValueSource(strings = {"RS256", "RS384", "RS512", "PS256", "PS384", "PS512", "ES256", "ES384", "ES512"})
  void privateKeyJwtAcceptsSupportedAlgorithms(String algorithm) {
    assertThat(privateKeyJwt().signingAlgorithm(algorithm).build().findProblem()).isNull();
  }

  @Test
  void privateKeyJwtNeedsNoAlgorithmOrKeyId() {
    assertThat(privateKeyJwt().build().findProblem()).isNull();
  }

  static Stream<Arguments> problems() {
    return Stream.of(
      Arguments.of(privateKeyJwt().privateKeyFile(null).build(), "missing required field: privateKeyFile"),
      Arguments.of(privateKeyJwt().privateKeyFile(" ").build(), "missing required field: privateKeyFile"),
      Arguments.of(privateKeyJwt().clientSecret("secret").build(), "sets clientSecret"),
      Arguments.of(privateKeyJwt().clientSecret("").build(), "sets clientSecret"),
      Arguments.of(privateKeyJwt().signingAlgorithm("HS256").build(), "unsupported signingAlgorithm 'HS256'"),
      Arguments.of(privateKeyJwt().signingAlgorithm("none").build(), "unsupported signingAlgorithm 'none'"),
      Arguments.of(privateKeyJwt().signingAlgorithm("rs384").build(), "unsupported signingAlgorithm 'rs384'"),
      Arguments.of(privateKeyJwt().tokenEndpoint("http://auth.example.org/token").build(), "does not use https"),
      Arguments.of(privateKeyJwt().clientId(null).build(), "missing required field: clientId"),
      Arguments.of(secretPost().clientAuthMethod("client_secret_jwt").build(), "unsupported clientAuthMethod 'client_secret_jwt'"),
      Arguments.of(secretPost().privateKeyFile("/keys/client.pem").build(), "only used when clientAuthMethod is private_key_jwt"),
      Arguments.of(secretPost().clientSecret(null).privateKeyFile("/keys/client.pem").build(), "missing required field: clientSecret")
    );
  }

  @ParameterizedTest
  @MethodSource("problems")
  void reportsProblem(OAuthClientCredentialsPOJO credentials, String problem) {
    assertThat(credentials.findProblem()).contains(problem);
  }
}
