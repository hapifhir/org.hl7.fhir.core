package org.hl7.fhir.utilities.http;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HTTPTokenManagerTest {

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
  void testBasicTokenFetch() throws Exception {
    ServerDetailsPOJO server = buildServer("myClient", "mySecret");

    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"abc123\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    String token = HTTPTokenManager.getToken(server);
    assertThat(token).isEqualTo("abc123");

    RecordedRequest request = tokenServer.takeRequest();
    assertThat(request.getMethod()).isEqualTo("POST");
    String body = request.getBody().readUtf8();
    assertThat(body).contains("grant_type=client_credentials");
    assertThat(body).doesNotContain("refresh_token");
  }

  @Test
  void testClientCredentialsAreFormUrlEncoded() throws Exception {
    String clientId = "cli ent+id";
    String clientSecret = "s3cr3t/+&=value";
    ServerDetailsPOJO server = buildServer(clientId, clientSecret);

    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"abc123\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    HTTPTokenManager.getToken(server);

    RecordedRequest request = tokenServer.takeRequest();
    String body = request.getBody().readUtf8();

    // Parse the form body and URL-decode each value; this proves encoding happened
    // and round-trips regardless of the exact scheme used.
    Map<String, String> params = new HashMap<>();
    for (String pair : body.split("&")) {
      int eq = pair.indexOf('=');
      String key = pair.substring(0, eq);
      String value = pair.substring(eq + 1);
      params.put(key, URLDecoder.decode(value, StandardCharsets.UTF_8));
    }

    assertThat(params).containsEntry("client_id", clientId);
    assertThat(params).containsEntry("client_secret", clientSecret);
  }

  @Test
  void testTokenCaching() throws Exception {
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
  void testInvalidateTokenForcesRefetch() throws Exception {
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
  void testTokenEndpointErrorThrowsIOException() {
    ServerDetailsPOJO server = buildServer("myClient", "mySecret");

    tokenServer.enqueue(new MockResponse()
      .setBody("{\"error\":\"invalid_client\"}")
      .setResponseCode(401));

    assertThatThrownBy(() -> HTTPTokenManager.getToken(server))
      .isInstanceOf(IOException.class)
      .hasMessageContaining("returned HTTP 401")
      .hasMessageContaining("invalid_client")
      .hasMessageNotContaining("(response body suppressed)");
  }

  @Test
  void testMissingAccessTokenThrowsIOException() {
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
  void testMissingExpiresInDefaultsTo3600() throws Exception {
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
  void testExpiredTokenTriggersRefetch() throws Exception {
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

  @Test
  void testNonJsonResponseThrowsIOException() {
    ServerDetailsPOJO server = buildServer("myClient", "mySecret");

    tokenServer.enqueue(new MockResponse()
      .setBody("<html>Bad Gateway</html>")
      .addHeader("Content-Type", "text/html")
      .setResponseCode(200));

    assertThatThrownBy(() -> HTTPTokenManager.getToken(server))
      .isInstanceOf(IOException.class)
      .hasMessageContaining("non-JSON response");
  }
}
