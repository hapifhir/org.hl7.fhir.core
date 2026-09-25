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
    // The token request now goes through ManagedWebAccessor, so the mock token endpoint - plain
    // http on a loopback address - needs the same opt-ins any internal endpoint would need.
    return ServerDetailsPOJO.builder()
      .url("http://fhir.example.com/fhir")
      .authenticationType("client_credentials")
      .type("fhir")
      .clientId(clientId)
      .clientSecret(clientSecret)
      .tokenEndpoint(tokenServer.url("/token").toString())
      .allowHttp(true)
      .allowPrivateNetwork(true)
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

    // The early-expiry buffer is clamped to half the token's lifetime, so a 1s token is usable
    // for its one second rather than stale on arrival - wait for it to genuinely expire.
    Thread.sleep(1200);

    // Second call - token has expired, should re-fetch via client_credentials
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

  // The token request carries the client secret, so it must be subject to the same network
  // policy as any other outbound request rather than going out on a raw connection.

  @Test
  void testPlainHttpTokenEndpointRejectedWithoutAllowHttp() {
    ServerDetailsPOJO server = buildServer("myClient", "mySecret").toBuilder()
      .allowHttp(null)
      .build();

    assertThatThrownBy(() -> HTTPTokenManager.getToken(server))
      .isInstanceOf(IOException.class)
      .hasMessageContaining("permitted protocol");
    assertThat(tokenServer.getRequestCount()).isEqualTo(0);
  }

  @Test
  void testPrivateNetworkTokenEndpointRejectedWithoutOptIn() {
    ServerDetailsPOJO server = buildServer("myClient", "mySecret").toBuilder()
      .allowPrivateNetwork(null)
      .build();

    assertThatThrownBy(() -> HTTPTokenManager.getToken(server))
      .isInstanceOf(IOException.class);
    assertThat(tokenServer.getRequestCount()).isEqualTo(0);
  }

  @Test
  void testTokenEndpointHonoursProhibitedAccessPolicy() {
    ServerDetailsPOJO server = buildServer("myClient", "mySecret");
    ManagedWebAccess.WebAccessPolicy previous = ManagedWebAccess.getAccessPolicy();
    try {
      ManagedWebAccess.setAccessPolicy(ManagedWebAccess.WebAccessPolicy.PROHIBITED);
      assertThatThrownBy(() -> HTTPTokenManager.getToken(server))
        .isInstanceOf(IOException.class)
        .hasMessageContaining("not allowed by local security policy");
      assertThat(tokenServer.getRequestCount()).isEqualTo(0);
    } finally {
      ManagedWebAccess.setAccessPolicy(previous);
    }
  }

  // Incomplete entries can reach here via loadFromSettings/loadFromFHIRSettings(POJO), which do
  // not run the settings-file validation; they must produce a clear IOException, not an NPE.

  @Test
  void testIncompleteClientCredentialsGivesClearError() {
    ServerDetailsPOJO noTokenEndpoint = buildServer("myClient", "mySecret").toBuilder()
      .tokenEndpoint(null).build();
    assertThatThrownBy(() -> HTTPTokenManager.getToken(noTokenEndpoint))
      .isInstanceOf(IOException.class)
      .hasMessageContaining("tokenEndpoint");

    ServerDetailsPOJO noClientId = buildServer(null, "mySecret");
    assertThatThrownBy(() -> HTTPTokenManager.getToken(noClientId))
      .isInstanceOf(IOException.class)
      .hasMessageContaining("clientId");

    ServerDetailsPOJO noSecret = buildServer("myClient", null);
    assertThatThrownBy(() -> HTTPTokenManager.getToken(noSecret))
      .isInstanceOf(IOException.class)
      .hasMessageContaining("clientSecret");
  }

  @Test
  void testInvalidateTokenReportsWhetherAnythingWasCached() throws Exception {
    ServerDetailsPOJO server = buildServer("myClient", "mySecret");

    // Nothing cached yet - a retry would be pointless, so this must say so
    assertThat(HTTPTokenManager.invalidateToken(server)).isFalse();

    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"abc123\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));
    HTTPTokenManager.getToken(server);

    assertThat(HTTPTokenManager.invalidateToken(server)).isTrue();
    assertThat(HTTPTokenManager.invalidateToken(server)).isFalse();
  }

  @Test
  void testShortLivedTokenIsStillServedFromCache() throws Exception {
    ServerDetailsPOJO server = buildServer("myClient", "mySecret");

    // expires_in below the 30s buffer: without clamping, every call would re-fetch
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"short\",\"token_type\":\"Bearer\",\"expires_in\":20}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    assertThat(HTTPTokenManager.getToken(server)).isEqualTo("short");
    assertThat(HTTPTokenManager.getToken(server)).isEqualTo("short");
    assertThat(tokenServer.getRequestCount()).isEqualTo(1);
  }
}
