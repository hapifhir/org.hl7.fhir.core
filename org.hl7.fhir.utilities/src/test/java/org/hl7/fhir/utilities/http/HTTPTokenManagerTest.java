package org.hl7.fhir.utilities.http;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.hl7.fhir.utilities.settings.OAuthClientCredentialsPOJO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hl7.fhir.utilities.http.OAuthTestSupport.tokenResponse;

class HTTPTokenManagerTest {

  private MockWebServer tokenServer;
  private final AtomicLong clock = new AtomicLong();

  @BeforeEach
  void setup() throws IOException {
    OAuthTestSupport.trustTestCertificate();
    tokenServer = OAuthTestSupport.startHttpsServer();
    HTTPTokenManager.clearCache();
    HTTPTokenManager.nanoClock = clock::get;
  }

  @AfterEach
  void tearDown() throws IOException {
    tokenServer.shutdown();
    HTTPTokenManager.clearCache();
    HTTPTokenManager.nanoClock = System::nanoTime;
    OAuthTestSupport.resetTrust();
  }

  private void advanceSeconds(long seconds) {
    clock.addAndGet(TimeUnit.SECONDS.toNanos(seconds));
  }

  private OAuthClientCredentialsPOJO credentials(String clientId, String clientSecret) {
    return OAuthTestSupport.credentials(tokenServer, clientId, clientSecret);
  }

  /** The mock token endpoint is on a loopback address, so it needs the private-network opt-in. */
  private String getToken(OAuthClientCredentialsPOJO credentials) throws IOException {
    return HTTPTokenManager.getToken(credentials, true);
  }

  @Test
  void testBasicTokenFetch() throws Exception {
    OAuthClientCredentialsPOJO credentials = credentials("myClient", "mySecret");

    tokenServer.enqueue(tokenResponse("abc123", 3600));

    String token = getToken(credentials);
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

    tokenServer.enqueue(tokenResponse("abc123", 3600));

    getToken(credentials(clientId, clientSecret));

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
    OAuthClientCredentialsPOJO credentials = credentials("myClient", "mySecret");

    tokenServer.enqueue(tokenResponse("abc123", 3600));

    String token1 = getToken(credentials);
    String token2 = getToken(credentials);

    assertThat(token1).isEqualTo("abc123");
    assertThat(token2).isEqualTo("abc123");
    assertThat(tokenServer.getRequestCount()).isEqualTo(1);
  }

  @Test
  void testInvalidateTokenForcesRefetch() throws Exception {
    OAuthClientCredentialsPOJO credentials = credentials("myClient", "mySecret");

    tokenServer.enqueue(tokenResponse("token1", 3600));
    tokenServer.enqueue(tokenResponse("token2", 3600));

    assertThat(getToken(credentials)).isEqualTo("token1");

    HTTPTokenManager.invalidateToken(credentials, "token1");

    assertThat(getToken(credentials)).isEqualTo("token2");
    assertThat(tokenServer.getRequestCount()).isEqualTo(2);
  }

  @Test
  void testTokenEndpointErrorThrowsIOException() {
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"error\":\"invalid_client\"}")
      .setResponseCode(401));

    assertThatThrownBy(() -> getToken(credentials("myClient", "mySecret")))
      .isInstanceOf(IOException.class)
      .hasMessageContaining("returned HTTP 401")
      .hasMessageContaining("invalid_client")
      .hasMessageNotContaining("(response body suppressed)");
  }

  @Test
  void testNonJsonErrorBodyIsNotEchoed() {
    String body = "<html>upstream error for client_secret=mySecret</html>";
    tokenServer.enqueue(new MockResponse()
      .setBody(body)
      .addHeader("Content-Type", "text/html")
      .setResponseCode(500));

    assertThatThrownBy(() -> getToken(credentials("myClient", "mySecret")))
      .isInstanceOf(IOException.class)
      .hasMessageContaining("returned HTTP 500")
      .hasMessageContaining("(response body suppressed)")
      .hasMessageNotContaining("mySecret")
      .hasMessageNotContaining("upstream error");
  }

  @Test
  void testMissingAccessTokenThrowsIOException() {
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    assertThatThrownBy(() -> getToken(credentials("myClient", "mySecret")))
      .isInstanceOf(IOException.class)
      .hasMessageContaining("missing 'access_token'");
  }

  @Test
  void testNonStringAccessTokenThrowsIOException() {
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":12345,\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    assertThatThrownBy(() -> getToken(credentials("myClient", "mySecret")))
      .isInstanceOf(IOException.class)
      .hasMessageContaining("non-string 'access_token'");
  }

  @Test
  void testMissingExpiresInDefaultsTo3600() throws Exception {
    OAuthClientCredentialsPOJO credentials = credentials("myClient", "mySecret");

    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"abc123\",\"token_type\":\"Bearer\"}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));
    tokenServer.enqueue(tokenResponse("def456", 3600));

    assertThat(getToken(credentials)).isEqualTo("abc123");

    // A 3600s token is treated as expired 30s early
    advanceSeconds(3569);
    assertThat(getToken(credentials)).isEqualTo("abc123");
    advanceSeconds(2);
    assertThat(getToken(credentials)).isEqualTo("def456");
    assertThat(tokenServer.getRequestCount()).isEqualTo(2);
  }

  @Test
  void testExcessiveExpiresInIsClamped() throws Exception {
    OAuthClientCredentialsPOJO credentials = credentials("myClient", "mySecret");

    tokenServer.enqueue(tokenResponse("eternal", Integer.MAX_VALUE));
    tokenServer.enqueue(tokenResponse("replacement", 3600));

    assertThat(getToken(credentials)).isEqualTo("eternal");

    advanceSeconds(HTTPTokenManager.MAX_EXPIRES_IN_SECONDS);
    assertThat(getToken(credentials)).isEqualTo("replacement");
    assertThat(tokenServer.getRequestCount()).isEqualTo(2);
  }

  @ParameterizedTest
  @ValueSource(strings = {"\"abc\"", "0", "-5", "{}"})
  void testUnusableExpiresInDefaultsTo3600(String expiresIn) throws Exception {
    OAuthClientCredentialsPOJO credentials = credentials("myClient", "mySecret");

    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"abc123\",\"token_type\":\"Bearer\",\"expires_in\":" + expiresIn + "}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));
    tokenServer.enqueue(tokenResponse("def456", 3600));

    assertThat(getToken(credentials)).isEqualTo("abc123");
    advanceSeconds(3569);
    assertThat(getToken(credentials)).isEqualTo("abc123");
    advanceSeconds(2);
    assertThat(getToken(credentials)).isEqualTo("def456");
  }

  @Test
  void testConcurrentCallersShareOneTokenFetch() throws Exception {
    // The response is delayed so that every caller is waiting while the first fetch is in flight
    tokenServer.enqueue(tokenResponse("shared", 3600).setHeadersDelay(500, TimeUnit.MILLISECONDS));
    tokenServer.enqueue(tokenResponse("second-fetch", 3600));

    OAuthClientCredentialsPOJO credentials = credentials("myClient", "mySecret");
    int callers = 4;
    ExecutorService executor = Executors.newFixedThreadPool(callers);
    try {
      CountDownLatch start = new CountDownLatch(1);
      List<Future<String>> results = new ArrayList<>();
      for (int i = 0; i < callers; i++) {
        results.add(executor.submit(() -> {
          start.await();
          return getToken(credentials);
        }));
      }
      start.countDown();
      for (Future<String> result : results) {
        assertThat(result.get(10, TimeUnit.SECONDS)).isEqualTo("shared");
      }
    } finally {
      executor.shutdownNow();
    }
    assertThat(tokenServer.getRequestCount()).isEqualTo(1);
  }

  @Test
  void testExpiresInBeyondIntRangeIsClampedNotWrapped() throws Exception {
    OAuthClientCredentialsPOJO credentials = credentials("myClient", "mySecret");

    // 2^32 + 1 would wrap to 1 if read as an int, and the token would be refetched every call
    tokenServer.enqueue(tokenResponse("big", 3600).setBody(
      "{\"access_token\":\"big\",\"token_type\":\"Bearer\",\"expires_in\":4294967297}"));

    assertThat(getToken(credentials)).isEqualTo("big");
    advanceSeconds(3600);
    assertThat(getToken(credentials)).isEqualTo("big");
    assertThat(tokenServer.getRequestCount()).isEqualTo(1);
  }

  @Test
  void testExpiredTokenTriggersRefetch() throws Exception {
    OAuthClientCredentialsPOJO credentials = credentials("myClient", "mySecret");

    tokenServer.enqueue(tokenResponse("token1", 1));
    tokenServer.enqueue(tokenResponse("token2", 3600));

    assertThat(getToken(credentials)).isEqualTo("token1");

    // The early-expiry buffer is clamped to half the token's lifetime, so a 1s token is usable
    // for its one second rather than stale on arrival.
    advanceSeconds(1);

    // Token has expired, should re-fetch via client_credentials
    assertThat(getToken(credentials)).isEqualTo("token2");
    assertThat(tokenServer.getRequestCount()).isEqualTo(2);

    // Both requests should use client_credentials grant
    assertThat(tokenServer.takeRequest().getBody().readUtf8()).contains("grant_type=client_credentials");
    assertThat(tokenServer.takeRequest().getBody().readUtf8()).contains("grant_type=client_credentials");
  }

  @Test
  void testNonJsonResponseThrowsIOException() {
    tokenServer.enqueue(new MockResponse()
      .setBody("<html>Bad Gateway</html>")
      .addHeader("Content-Type", "text/html")
      .setResponseCode(200));

    assertThatThrownBy(() -> getToken(credentials("myClient", "mySecret")))
      .isInstanceOf(IOException.class)
      .hasMessageContaining("did not return a JSON object")
      .hasNoCause();
  }

  // The token request carries the client secret, so it must be subject to the same network
  // policy as any other outbound request rather than going out on a raw connection.

  @Test
  void testPlainHttpTokenEndpointRejected() throws IOException {
    MockWebServer plainHttpTokenServer = new MockWebServer();
    plainHttpTokenServer.start();
    try {
      OAuthClientCredentialsPOJO credentials = OAuthTestSupport.credentials(plainHttpTokenServer, "myClient", "mySecret");

      assertThatThrownBy(() -> getToken(credentials))
        .isInstanceOf(IOException.class)
        .hasMessageContaining("https");
      assertThat(plainHttpTokenServer.getRequestCount()).isZero();
    } finally {
      plainHttpTokenServer.shutdown();
    }
  }

  @Test
  void testPrivateNetworkTokenEndpointRejectedWithoutOptIn() {
    // Pinned: other test classes reset this global from the developer's own fhir-settings.json
    boolean previous = ManagedWebAccess.isSsrfProtectionEnabled();
    try {
      ManagedWebAccess.setSsrfProtectionEnabled(true);
      assertThatThrownBy(() -> HTTPTokenManager.getToken(credentials("myClient", "mySecret"), false))
        .isInstanceOf(IOException.class)
        .hasMessageContaining("non-public address");
      assertThat(tokenServer.getRequestCount()).isZero();
    } finally {
      ManagedWebAccess.setSsrfProtectionEnabled(previous);
    }
  }

  @Test
  void testTokenEndpointPolicyOnlyTrustsTheConfiguredEndpoint() throws Exception {
    HTTPTokenManager.TokenEndpointPolicy policy =
      new HTTPTokenManager.TokenEndpointPolicy("https://auth.example.org/oauth/token", true);

    URL tokenEndpoint = new URL("https://auth.example.org/oauth/token");
    assertThat(policy.canProvideHeaders(tokenEndpoint)).isTrue();
    assertThat(policy.isProtocolAllowed(tokenEndpoint)).isTrue();
    assertThat(policy.isPrivateNetworkAllowed(tokenEndpoint)).isTrue();
    assertThat(policy.getHeaders(tokenEndpoint)).isEmpty();

    // Anywhere else falls through to the default policy: none of the server's grants apply
    for (String other : new String[]{
      "https://elsewhere.example.org/oauth/token",
      "http://auth.example.org/oauth/token",
      "https://auth.example.org:8443/oauth/token",
      "https://auth.example.org/other"}) {
      URL url = new URL(other);
      assertThat(policy.canProvideHeaders(url)).as(other).isFalse();
      assertThat(policy.isProtocolAllowed(url)).as(other).isFalse();
      assertThat(policy.isPrivateNetworkAllowed(url)).as(other).isFalse();
    }
  }

  @Test
  void testTokenEndpointHonoursProhibitedAccessPolicy() {
    OAuthClientCredentialsPOJO credentials = credentials("myClient", "mySecret");
    ManagedWebAccess.WebAccessPolicy previous = ManagedWebAccess.getAccessPolicy();
    try {
      ManagedWebAccess.setAccessPolicy(ManagedWebAccess.WebAccessPolicy.PROHIBITED);
      assertThatThrownBy(() -> getToken(credentials))
        .isInstanceOf(IOException.class)
        .hasMessageContaining("not allowed by local security policy");
      assertThat(tokenServer.getRequestCount()).isZero();
    } finally {
      ManagedWebAccess.setAccessPolicy(previous);
    }
  }

  // Incomplete entries can reach here via loadFromSettings/loadFromFHIRSettings(POJO), which do
  // not run the settings-file validation; they must produce a clear IOException, not an NPE.

  @Test
  void testIncompleteClientCredentialsGivesClearError() {
    OAuthClientCredentialsPOJO noTokenEndpoint = credentials("myClient", "mySecret").toBuilder()
      .tokenEndpoint(null).build();
    assertThatThrownBy(() -> getToken(noTokenEndpoint))
      .isInstanceOf(IOException.class)
      .hasMessageContaining("tokenEndpoint");

    assertThatThrownBy(() -> getToken(credentials(null, "mySecret")))
      .isInstanceOf(IOException.class)
      .hasMessageContaining("clientId");

    assertThatThrownBy(() -> getToken(credentials("myClient", " ")))
      .isInstanceOf(IOException.class)
      .hasMessageContaining("clientSecret");

    assertThatThrownBy(() -> getToken(null))
      .isInstanceOf(IOException.class)
      .hasMessageContaining("missing");

    // A malformed endpoint must be an IOException too, not an IllegalArgumentException
    // escaping getHeaders() past every IOException handler
    OAuthClientCredentialsPOJO malformed = credentials("myClient", "mySecret").toBuilder()
      .tokenEndpoint("https://auth.example.org/oauth token").build();
    assertThatThrownBy(() -> getToken(malformed))
      .isInstanceOf(IOException.class)
      .hasMessageContaining("malformed tokenEndpoint");

    assertThat(tokenServer.getRequestCount()).isZero();
  }

  @Test
  void testInvalidateTokenLeavesANewerTokenInPlace() throws Exception {
    // Two concurrent requests are both rejected with token1. The first invalidates it and
    // fetches token2; the second must then retry with token2 - not discard it and fetch a third,
    // and not give up because token1 is already gone.
    OAuthClientCredentialsPOJO credentials = credentials("myClient", "mySecret");
    tokenServer.enqueue(tokenResponse("token1", 3600));
    tokenServer.enqueue(tokenResponse("token2", 3600));

    assertThat(getToken(credentials)).isEqualTo("token1");

    // First request
    assertThat(HTTPTokenManager.invalidateToken(credentials, "token1")).isTrue();
    assertThat(getToken(credentials)).isEqualTo("token2");

    // Second request, rejected with the same stale token
    assertThat(HTTPTokenManager.invalidateToken(credentials, "token1")).isTrue();
    assertThat(getToken(credentials)).isEqualTo("token2");
    assertThat(tokenServer.getRequestCount()).isEqualTo(2);
  }

  @Test
  void testInvalidateTokenWhenAlreadyDiscardedStillAllowsRetry() {
    // A concurrent request has discarded the token but not yet fetched a replacement: the
    // rejected token is no longer cached, so a retry will not reuse it.
    assertThat(HTTPTokenManager.invalidateToken(credentials("myClient", "mySecret"), "token1")).isTrue();
  }

  @Test
  void testInvalidateTokenWithoutARejectedTokenOrCompleteCredentials() {
    assertThat(HTTPTokenManager.invalidateToken(credentials("myClient", "mySecret"), null)).isFalse();
    assertThat(HTTPTokenManager.invalidateToken(null, "token1")).isFalse();
    assertThat(HTTPTokenManager.invalidateToken(credentials("myClient", null), "token1")).isFalse();
  }

  @Test
  void testShortLivedTokenIsStillServedFromCache() throws Exception {
    OAuthClientCredentialsPOJO credentials = credentials("myClient", "mySecret");

    // expires_in below the 30s buffer: without clamping, every call would re-fetch
    tokenServer.enqueue(tokenResponse("short", 20));

    assertThat(getToken(credentials)).isEqualTo("short");
    advanceSeconds(9);
    assertThat(getToken(credentials)).isEqualTo("short");
    assertThat(tokenServer.getRequestCount()).isEqualTo(1);
  }
}
