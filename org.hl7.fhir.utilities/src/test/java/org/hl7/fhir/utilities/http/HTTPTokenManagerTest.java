package org.hl7.fhir.utilities.http;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HTTPTokenManagerTest {

  private MockWebServer tokenServer;

  @BeforeEach
  void setup() throws IOException {
    tokenServer = new MockWebServer();
    tokenServer.start();
    HTTPTokenManager.clearCache();
  }

  @AfterEach
  void tearDown() throws IOException {
    tokenServer.shutdown();
    HTTPTokenManager.clearCache();
  }

  private ServerDetailsPOJO buildServer(String clientId, String clientSecret) {
    return ServerDetailsPOJO.builder()
      .url("http://fhir.example.com/fhir")
      .authenticationType("client_credentials")
      .type("fhir")
      .clientId(clientId)
      .clientSecret(clientSecret)
      .tokenEndpoint(tokenServer.url("/token").toString())
      .build();
  }

  @Test
  public void testBasicTokenFetch() throws Exception {
    ServerDetailsPOJO server = buildServer("myClient", "mySecret");

    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"abc123\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    String token = HTTPTokenManager.getToken(server);
    assertThat(token).isEqualTo("abc123");

    RecordedRequest request = tokenServer.takeRequest();
    assertThat(request.getMethod()).isEqualTo("POST");
    assertThat(request.getBody().readUtf8()).contains("grant_type=client_credentials");
    assertThat(request.getBody().toString()).doesNotContain("refresh_token");
  }

  @Test
  public void testTokenCaching() throws Exception {
    ServerDetailsPOJO server = buildServer("myClient", "mySecret");

    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"abc123\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    String token1 = HTTPTokenManager.getToken(server);
    String token2 = HTTPTokenManager.getToken(server);

    assertThat(token1).isEqualTo("abc123");
    assertThat(token2).isEqualTo("abc123");
    assertThat(tokenServer.getRequestCount()).isEqualTo(1);
  }

  @Test
  public void testInvalidateTokenForcesRefetch() throws Exception {
    ServerDetailsPOJO server = buildServer("myClient", "mySecret");

    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"token1\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"token2\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    String token1 = HTTPTokenManager.getToken(server);
    assertThat(token1).isEqualTo("token1");

    HTTPTokenManager.invalidateToken(server);

    String token2 = HTTPTokenManager.getToken(server);
    assertThat(token2).isEqualTo("token2");
    assertThat(tokenServer.getRequestCount()).isEqualTo(2);
  }

  @Test
  public void testTokenEndpointErrorThrowsIOException() {
    ServerDetailsPOJO server = buildServer("myClient", "mySecret");

    tokenServer.enqueue(new MockResponse()
      .setBody("{\"error\":\"invalid_client\"}")
      .setResponseCode(401));

    assertThatThrownBy(() -> HTTPTokenManager.getToken(server))
      .isInstanceOf(IOException.class)
      .hasMessageContaining("Token endpoint returned HTTP 401");
  }

  @Test
  public void testMissingAccessTokenThrowsIOException() {
    ServerDetailsPOJO server = buildServer("myClient", "mySecret");

    tokenServer.enqueue(new MockResponse()
      .setBody("{\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    assertThatThrownBy(() -> HTTPTokenManager.getToken(server))
      .isInstanceOf(IOException.class)
      .hasMessageContaining("missing 'access_token'");
  }

  @Test
  public void testMissingExpiresInDefaultsTo3600() throws Exception {
    ServerDetailsPOJO server = buildServer("myClient", "mySecret");

    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"abc123\",\"token_type\":\"Bearer\"}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    String token = HTTPTokenManager.getToken(server);
    assertThat(token).isEqualTo("abc123");

    // Token should be cached (not expired yet with default 3600s)
    String token2 = HTTPTokenManager.getToken(server);
    assertThat(token2).isEqualTo("abc123");
    assertThat(tokenServer.getRequestCount()).isEqualTo(1);
  }

  @Test
  public void testExpiredTokenTriggersRefetch() throws Exception {
    ServerDetailsPOJO server = buildServer("myClient", "mySecret");

    // First token expires in 1s (within 30s buffer, so immediately "expiring soon")
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"token1\",\"token_type\":\"Bearer\",\"expires_in\":1}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    // Second token request after expiry
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"token2\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    String token1 = HTTPTokenManager.getToken(server);
    assertThat(token1).isEqualTo("token1");

    // Second call — token is expiring soon (1s < 30s buffer), should re-fetch via client_credentials
    String token2 = HTTPTokenManager.getToken(server);
    assertThat(token2).isEqualTo("token2");
    assertThat(tokenServer.getRequestCount()).isEqualTo(2);

    // Both requests should use client_credentials grant
    RecordedRequest firstRequest = tokenServer.takeRequest();
    assertThat(firstRequest.getBody().readUtf8()).contains("grant_type=client_credentials");

    RecordedRequest secondRequest = tokenServer.takeRequest();
    assertThat(secondRequest.getBody().readUtf8()).contains("grant_type=client_credentials");
  }
}
