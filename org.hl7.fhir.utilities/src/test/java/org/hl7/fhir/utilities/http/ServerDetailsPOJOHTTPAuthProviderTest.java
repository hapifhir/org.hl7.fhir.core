package org.hl7.fhir.utilities.http;

import okhttp3.mockwebserver.MockWebServer;
import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hl7.fhir.utilities.http.OAuthTestSupport.tokenResponse;

class ServerDetailsPOJOHTTPAuthProviderTest {

  private MockWebServer tokenServer;

  @BeforeEach
  void setup() throws IOException {
    OAuthTestSupport.trustTestCertificate();
    tokenServer = OAuthTestSupport.startHttpsServer();
    HTTPTokenManager.clearCache();
  }

  @AfterEach
  void tearDown() throws IOException {
    HTTPTokenManager.clearCache();
    tokenServer.shutdown();
    OAuthTestSupport.resetTrust();
  }

  private ServerDetailsPOJO buildClientCredentialsServer() {
    return OAuthTestSupport.clientCredentialsServer("https://fhir.example.org/", tokenServer, "testClient", "testSecret");
  }

  @Test
  void testClientCredentialsHeadersContainBearerToken() throws Exception {
    tokenServer.enqueue(tokenResponse("abc123", 3600));

    ServerDetailsPOJOHTTPAuthProvider provider =
      new ServerDetailsPOJOHTTPAuthProvider(List.of(buildClientCredentialsServer()));

    Map<String, String> headers = provider.getHeaders(new URL("https://fhir.example.org/Patient"));

    assertThat(headers).containsEntry("Authorization", "Bearer abc123");
  }

  @Test
  void testMissingClientCredentialsFailsClosed() throws Exception {
    ServerDetailsPOJO server = buildClientCredentialsServer().toBuilder().oauthClientCredentials(null).build();
    ServerDetailsPOJOHTTPAuthProvider provider = new ServerDetailsPOJOHTTPAuthProvider(List.of(server));

    assertThatThrownBy(() -> provider.getHeaders(new URL("https://fhir.example.org/Patient")))
      .isInstanceOf(IOException.class)
      .hasMessageContaining("https://fhir.example.org/")
      .hasMessageContaining("oauthClientCredentials");
    assertThat(tokenServer.getRequestCount()).isZero();
  }

  @Test
  void testCanRefreshCredentialsOnlyForClientCredentials() throws Exception {
    ServerDetailsPOJO tokenAuthServer = ServerDetailsPOJO.builder()
      .url("https://static.example.org/")
      .authenticationType("token")
      .token("static")
      .build();
    ServerDetailsPOJOHTTPAuthProvider provider =
      new ServerDetailsPOJOHTTPAuthProvider(List.of(buildClientCredentialsServer(), tokenAuthServer));

    assertThat(provider.canRefreshCredentials(new URL("https://fhir.example.org/Patient"))).isTrue();
    assertThat(provider.canRefreshCredentials(new URL("https://static.example.org/Patient"))).isFalse();
    assertThat(provider.canRefreshCredentials(new URL("https://other.example.com/Patient"))).isFalse();
  }

  @Test
  void testInvalidateTokenIfClientCredentialsMatchingUrl() throws Exception {
    tokenServer.enqueue(tokenResponse("abc123", 3600));
    tokenServer.enqueue(tokenResponse("def456", 3600));

    ServerDetailsPOJOHTTPAuthProvider provider =
      new ServerDetailsPOJOHTTPAuthProvider(List.of(buildClientCredentialsServer()));
    URL url = new URL("https://fhir.example.org/Patient");

    String rejected = provider.getHeaders(url).get("Authorization");

    assertThat(provider.invalidateCachedCredentials(url, rejected)).isTrue();
    assertThat(provider.getHeaders(url)).containsEntry("Authorization", "Bearer def456");
    assertThat(tokenServer.getRequestCount()).isEqualTo(2);
  }

  @Test
  void testInvalidateTokenRequiresARejectedBearerToken() throws Exception {
    ServerDetailsPOJOHTTPAuthProvider provider =
      new ServerDetailsPOJOHTTPAuthProvider(List.of(buildClientCredentialsServer()));
    URL url = new URL("https://fhir.example.org/Patient");

    assertThat(provider.invalidateCachedCredentials(url, null)).isFalse();
    assertThat(provider.invalidateCachedCredentials(url, "Basic abc")).isFalse();
  }

  @Test
  void testInvalidateTokenIfClientCredentialsNonMatchingUrl() throws Exception {
    ServerDetailsPOJOHTTPAuthProvider provider =
      new ServerDetailsPOJOHTTPAuthProvider(List.of(buildClientCredentialsServer()));

    assertThat(provider.invalidateCachedCredentials(new URL("https://other.example.com/Patient"), "Bearer abc123"))
      .isFalse();
  }
}
