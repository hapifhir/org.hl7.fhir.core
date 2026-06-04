package org.hl7.fhir.utilities.http;

import okhttp3.mockwebserver.MockResponse;
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

class ServerDetailsPOJOHTTPAuthProviderTest {

  private MockWebServer tokenServer;

  @BeforeEach
  void setup() throws IOException {
    tokenServer = new MockWebServer();
    tokenServer.start();
    HTTPTokenManager.clearCache();
  }

  @AfterEach
  void tearDown() throws IOException {
    HTTPTokenManager.clearCache();
    tokenServer.shutdown();
  }

  private ServerDetailsPOJO buildClientCredentialsServer() {
    return ServerDetailsPOJO.builder()
      .url("https://fhir.example.org/")
      .authenticationType("client_credentials")
      .type("fhir")
      .clientId("testClient")
      .clientSecret("testSecret")
      .tokenEndpoint(tokenServer.url("/token").toString())
      .build();
  }

  @Test
  void testClientCredentialsHeadersContainBearerToken() throws Exception {
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"abc123\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    ServerDetailsPOJOHTTPAuthProvider provider =
      new ServerDetailsPOJOHTTPAuthProvider(List.of(buildClientCredentialsServer()));

    Map<String, String> headers = provider.getHeaders(new URL("https://fhir.example.org/Patient"));

    assertThat(headers).containsEntry("Authorization", "Bearer abc123");
  }

  @Test
  void testInvalidateTokenIfClientCredentialsMatchingUrl() throws Exception {
    ServerDetailsPOJOHTTPAuthProvider provider =
      new ServerDetailsPOJOHTTPAuthProvider(List.of(buildClientCredentialsServer()));

    assertThat(provider.invalidateTokenIfClientCredentials(new URL("https://fhir.example.org/Patient")))
      .isTrue();
  }

  @Test
  void testInvalidateTokenIfClientCredentialsNonMatchingUrl() throws Exception {
    ServerDetailsPOJOHTTPAuthProvider provider =
      new ServerDetailsPOJOHTTPAuthProvider(List.of(buildClientCredentialsServer()));

    assertThat(provider.invalidateTokenIfClientCredentials(new URL("https://other.example.com/Patient")))
      .isFalse();
  }
}
