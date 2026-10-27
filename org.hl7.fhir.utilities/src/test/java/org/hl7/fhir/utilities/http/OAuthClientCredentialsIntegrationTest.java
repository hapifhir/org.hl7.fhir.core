package org.hl7.fhir.utilities.http;

import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import okhttp3.mockwebserver.SocketPolicy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hl7.fhir.utilities.settings.FhirSettingsPOJO;
import org.hl7.fhir.utilities.settings.OAuthClientCredentialsPOJO;
import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Isolated;
import org.mockito.ArgumentCaptor;
import org.mockito.MockedStatic;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hl7.fhir.utilities.http.OAuthTestSupport.tokenResponse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

/**
 * End-to-end integration tests for the OAuth client_credentials flow.
 *
 * These tests exercise the full chain from configuration through to authenticated
 * FHIR server requests, verifying that:
 * <ul>
 *   <li>Tokens are fetched from the token endpoint using client_credentials grant</li>
 *   <li>Bearer tokens are attached to FHIR server requests</li>
 *   <li>Expired tokens are transparently refreshed</li>
 *   <li>401 responses trigger token invalidation and retry</li>
 *   <li>The client secret never leaves for anywhere but the configured https token endpoint,
 *       and is sent once per token request</li>
 * </ul>
 * The token endpoint is an https MockWebServer with a self-signed certificate; the FHIR server
 * is plain http, which its {@code allowHttp} permits.
 */
@Isolated
class OAuthClientCredentialsIntegrationTest {

  private MockWebServer tokenServer;
  private MockWebServer fhirServer;

  @BeforeEach
  void setup() throws IOException {
    OAuthTestSupport.trustTestCertificate();
    tokenServer = OAuthTestSupport.startHttpsServer();
    fhirServer = new MockWebServer();
    fhirServer.start();
    HTTPTokenManager.clearCache();
    ManagedWebAccess.setAccessPolicy(ManagedWebAccess.WebAccessPolicy.DIRECT);
  }

  @AfterEach
  void tearDown() throws IOException {
    HTTPTokenManager.clearCache();
    tokenServer.shutdown();
    fhirServer.shutdown();
    OAuthTestSupport.resetTrust();
    // Reset the global ManagedWebAccess state mutated via loadFromSettings()
    // so it does not leak into other test classes.
    ManagedWebAccess.loadFromFHIRSettings();
  }

  // -----------------------------------------------------------------------
  // Test 1: Full flow via ManagedWebAccess top-level API
  //
  // Configures ManagedWebAccess with a client_credentials server (as
  // loadFromFHIRSettings would), then makes a FHIR request via the
  // static ManagedWebAccess.httpCall(). Verifies the token was fetched
  // from the token endpoint and sent as a Bearer header to the FHIR server.
  // (Settings file parsing is separately tested in FhirSettingsTests.)
  // -----------------------------------------------------------------------
  @Test
  void testFullFlowViaManagedWebAccess() throws Exception {
    tokenServer.enqueue(tokenResponse("settings-token-abc", 3600));

    // Set up FHIR server to return a CapabilityStatement
    fhirServer.enqueue(new MockResponse()
      .setBody("{\"resourceType\":\"CapabilityStatement\",\"status\":\"active\"}")
      .addHeader("Content-Type", "application/fhir+json")
      .setResponseCode(200));

    // Configure ManagedWebAccess exactly as a fhir-settings.json entry would.
    // setUserAgent comes after, because applySettings resets it.
    ManagedWebAccess.loadFromSettings(FhirSettingsPOJO.builder()
      .servers(List.of(buildServer()))
      .build());
    ManagedWebAccess.setUserAgent("test-agent");

    // Make a FHIR request through the top-level static API
    String fhirUrl = fhirServer.url("/metadata").toString();
    HTTPResult result = ManagedWebAccess.httpCall(
      new HTTPRequest().withUrl(fhirUrl).withMethod(HTTPRequest.HttpMethod.GET));

    // Verify FHIR response
    assertThat(result.getCode()).isEqualTo(200);
    assertThat(result.getContentAsString()).contains("CapabilityStatement");

    // Verify token was fetched
    RecordedRequest tokenRequest = tokenServer.takeRequest();
    assertThat(tokenRequest.getMethod()).isEqualTo("POST");
    String tokenBody = tokenRequest.getBody().readUtf8();
    assertThat(tokenBody).contains("grant_type=client_credentials");
    assertThat(tokenBody).contains("client_id=test-client");
    assertThat(tokenBody).contains("client_secret=test-secret");

    // Verify FHIR request had Bearer token
    RecordedRequest fhirRequest = fhirServer.takeRequest();
    assertThat(fhirRequest.getHeader("Authorization")).isEqualTo("Bearer settings-token-abc");
  }

  // -----------------------------------------------------------------------
  // Test 2: Token caching across multiple FHIR requests
  //
  // Makes two FHIR requests. Verifies the token endpoint is only called
  // once (the second request reuses the cached token).
  // -----------------------------------------------------------------------
  @Test
  void testTokenCachingAcrossRequests() throws Exception {
    tokenServer.enqueue(tokenResponse("cached-token", 3600));

    // Two FHIR responses
    fhirServer.enqueue(new MockResponse().setBody("Response 1").setResponseCode(200));
    fhirServer.enqueue(new MockResponse().setBody("Response 2").setResponseCode(200));

    ManagedFhirWebAccessor accessor = fhirAccessor(buildServer());

    String fhirUrl = fhirServer.url("/Patient").toString();

    HTTPResult result1 = accessor.httpCall(
      new HTTPRequest().withUrl(fhirUrl).withMethod(HTTPRequest.HttpMethod.GET));
    HTTPResult result2 = accessor.httpCall(
      new HTTPRequest().withUrl(fhirUrl).withMethod(HTTPRequest.HttpMethod.GET));

    assertThat(result1.getCode()).isEqualTo(200);
    assertThat(result2.getCode()).isEqualTo(200);

    // Only one token request
    assertThat(tokenServer.getRequestCount()).isEqualTo(1);

    // Both FHIR requests used same token
    RecordedRequest fhir1 = fhirServer.takeRequest();
    RecordedRequest fhir2 = fhirServer.takeRequest();
    assertThat(fhir1.getHeader("Authorization")).isEqualTo("Bearer cached-token");
    assertThat(fhir2.getHeader("Authorization")).isEqualTo("Bearer cached-token");
  }

  // -----------------------------------------------------------------------
  // Test 3: Transparent token refresh on expiry
  //
  // The first token has expires_in=1. The 30s early-expiry buffer is clamped to half the token's
  // lifetime, so a 1s token is genuinely usable for its one second rather than being stale on
  // arrival - hence the wait below before the second request.
  // -----------------------------------------------------------------------
  @Test
  void testTransparentTokenRefreshOnExpiry() throws Exception {
    tokenServer.enqueue(tokenResponse("short-lived-token", 1));
    tokenServer.enqueue(tokenResponse("refreshed-token", 3600));

    fhirServer.enqueue(new MockResponse().setBody("Response 1").setResponseCode(200));
    fhirServer.enqueue(new MockResponse().setBody("Response 2").setResponseCode(200));

    ManagedFhirWebAccessor accessor = fhirAccessor(buildServer());

    String fhirUrl = fhirServer.url("/Patient").toString();

    // First request gets the short-lived token
    HTTPResult result1 = accessor.httpCall(
      new HTTPRequest().withUrl(fhirUrl).withMethod(HTTPRequest.HttpMethod.GET));
    assertThat(result1.getCode()).isEqualTo(200);

    // Let the 1s token actually expire
    Thread.sleep(1200);

    // Second request - token has expired, so a new one is fetched transparently
    HTTPResult result2 = accessor.httpCall(
      new HTTPRequest().withUrl(fhirUrl).withMethod(HTTPRequest.HttpMethod.GET));
    assertThat(result2.getCode()).isEqualTo(200);

    // Two token requests were made
    assertThat(tokenServer.getRequestCount()).isEqualTo(2);

    // First FHIR request used short-lived token, second used refreshed token
    RecordedRequest fhir1 = fhirServer.takeRequest();
    RecordedRequest fhir2 = fhirServer.takeRequest();
    assertThat(fhir1.getHeader("Authorization")).isEqualTo("Bearer short-lived-token");
    assertThat(fhir2.getHeader("Authorization")).isEqualTo("Bearer refreshed-token");
  }

  // -----------------------------------------------------------------------
  // Test 4: 401 from FHIR server triggers token invalidation and retry
  //
  // Simulates the scenario where a token is valid from the token endpoint's
  // perspective but the FHIR server rejects it (e.g., server-side revocation).
  // The code should invalidate the cached token, fetch a new one, and retry.
  // -----------------------------------------------------------------------
  @Test
  void testRetryOn401FromFhirServer() throws Exception {
    tokenServer.enqueue(tokenResponse("rejected-token", 3600));
    tokenServer.enqueue(tokenResponse("accepted-token", 3600));

    // FHIR server: 401 once, then 200 on the retry with the fresh token
    fhirServer.enqueue(new MockResponse().setBody("Unauthorized").setResponseCode(401));
    fhirServer.enqueue(new MockResponse()
      .setBody("{\"resourceType\":\"Patient\",\"id\":\"123\"}")
      .addHeader("Content-Type", "application/fhir+json")
      .setResponseCode(200));

    ManagedFhirWebAccessor accessor = fhirAccessor(buildServer());

    String fhirUrl = fhirServer.url("/Patient/123").toString();
    HTTPResult result = accessor.httpCall(
      new HTTPRequest().withUrl(fhirUrl).withMethod(HTTPRequest.HttpMethod.GET));

    // Should succeed after retry
    assertThat(result.getCode()).isEqualTo(200);
    assertThat(result.getContentAsString()).contains("Patient");

    // Two token fetches: original + after invalidation
    assertThat(tokenServer.getRequestCount()).isEqualTo(2);

    // The retry request used the new token
    fhirServer.takeRequest(); // 401 with rejected-token
    RecordedRequest retryRequest = fhirServer.takeRequest(); // 200 with accepted-token
    assertThat(retryRequest.getHeader("Authorization")).isEqualTo("Bearer accepted-token");
  }

  // -----------------------------------------------------------------------
  // Test 4b: concurrent 401s refresh the token once
  //
  // Two requests are in flight with the same token when it is revoked. Simulated
  // deterministically: while the FHIR server is handling this request, "another request"
  // invalidates the token and fetches a replacement. This request's 401 must then retry with
  // that replacement - not discard it and fetch a third token, and not give up because the
  // rejected token is already gone.
  // -----------------------------------------------------------------------
  @Test
  void testConcurrent401RetriesWithTokenRefreshedByAnotherRequest() throws Exception {
    tokenServer.enqueue(tokenResponse("revoked-token", 3600));
    tokenServer.enqueue(tokenResponse("replacement-token", 3600));

    ServerDetailsPOJO server = buildServer();
    fhirServer.setDispatcher(new Dispatcher() {
      private boolean first = true;

      @Override
      public MockResponse dispatch(RecordedRequest request) {
        if (first) {
          first = false;
          try {
            // The other request got its 401 first, and has already refreshed
            HTTPTokenManager.invalidateToken(server.getOauthClientCredentials(), "revoked-token");
            getToken(server);
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
          return new MockResponse().setResponseCode(401);
        }
        return new MockResponse().setResponseCode(200).setBody("OK");
      }
    });

    HTTPResult result = fhirAccessor(server).httpCall(new HTTPRequest()
      .withUrl(fhirServer.url("/Patient").toString()).withMethod(HTTPRequest.HttpMethod.GET));

    assertThat(result.getCode()).isEqualTo(200);
    assertThat(tokenServer.getRequestCount()).isEqualTo(2);
    assertThat(fhirServer.takeRequest().getHeader("Authorization")).isEqualTo("Bearer revoked-token");
    assertThat(fhirServer.takeRequest().getHeader("Authorization")).isEqualTo("Bearer replacement-token");
  }

  // -----------------------------------------------------------------------
  // Test 5: ManagedWebAccessor path
  //
  // Verifies that ManagedWebAccessor also handles client_credentials correctly,
  // not just ManagedFhirWebAccessor.
  // -----------------------------------------------------------------------
  @Test
  void testManagedWebAccessorPath() throws Exception {
    tokenServer.enqueue(tokenResponse("web-token", 3600));

    fhirServer.enqueue(new MockResponse()
      .setBody("{\"name\":\"test-package\"}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    ServerDetailsPOJO server = OAuthTestSupport.clientCredentialsServer(
      fhirServer.url("").toString(), tokenServer, "web-client", "web-secret");

    ManagedWebAccessor accessor = new ManagedWebAccessor(Arrays.asList("fhir"), "test-agent", new ServerDetailsPOJOHTTPAuthProvider(List.of(server)));

    String url = fhirServer.url("/Package").toString();
    HTTPResult result = accessor.get(url, "application/json");

    assertThat(result.getCode()).isEqualTo(200);

    // Verify token was fetched
    assertThat(tokenServer.getRequestCount()).isEqualTo(1);

    // Verify the GET request had Bearer token
    RecordedRequest webRequest = fhirServer.takeRequest();
    assertThat(webRequest.getHeader("Authorization")).isEqualTo("Bearer web-token");
  }

  // -----------------------------------------------------------------------
  // Test 6: Token endpoint failure produces a clear error
  //
  // Verifies that when the token endpoint returns an error, the IOException
  // propagates with a descriptive message rather than a confusing
  // NullPointerException or silent failure.
  // -----------------------------------------------------------------------
  @Test
  void testTokenEndpointFailureProducesDescriptiveError() {
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"error\":\"invalid_client\",\"error_description\":\"Client authentication failed\"}")
      .setResponseCode(401));

    ManagedFhirWebAccessor accessor = fhirAccessor(buildServer());

    String fhirUrl = fhirServer.url("/Patient").toString();

    // A token-fetch failure is an IOException like any other failed web request, so callers that
    // already handle IOException and degrade gracefully keep working rather than crashing on an
    // unchecked exception escaping from header generation.
    IOException ex = assertThrows(IOException.class, () ->
      accessor.httpCall(new HTTPRequest().withUrl(fhirUrl).withMethod(HTTPRequest.HttpMethod.GET)));
    assertThat(ex.getMessage()).contains("returned HTTP 401");
    assertThat(ex.getMessage()).contains("invalid_client");

    // No requests should have reached the FHIR server
    assertThat(fhirServer.getRequestCount()).isZero();
  }

  // -----------------------------------------------------------------------
  // Test 7: Incomplete configuration fails closed
  //
  // A server configured for oauth_client_credentials but missing part of its credentials must
  // not be sent requests at all - in particular not unauthenticated ones.
  // -----------------------------------------------------------------------
  @Test
  void testIncompleteConfigurationFailsClosed() {
    ServerDetailsPOJO server = buildServer().toBuilder()
      .oauthClientCredentials(buildServer().getOauthClientCredentials().toBuilder().clientSecret(null).build())
      .build();
    ManagedFhirWebAccessor accessor = fhirAccessor(server);

    IOException ex = assertThrows(IOException.class, () -> accessor.httpCall(
      new HTTPRequest().withUrl(fhirServer.url("/Patient").toString()).withMethod(HTTPRequest.HttpMethod.GET)));
    assertThat(ex.getMessage()).contains("clientSecret");

    assertThat(tokenServer.getRequestCount()).isZero();
    assertThat(fhirServer.getRequestCount())
      .as("a misconfigured server must not be sent an unauthenticated request")
      .isZero();
  }

  // -----------------------------------------------------------------------
  // Test 8: MANAGED access policy
  //
  // Under MANAGED every request - the token request included, client secret and all - is handed
  // to the host application's IWebAccessor, which is responsible for enforcing policy on it. The
  // https requirement on the token endpoint is checked before the hand-off.
  // -----------------------------------------------------------------------
  @Test
  void testManagedPolicyHandsTokenRequestAndBearerTokenToHostAccessor() throws Exception {
    ServerDetailsPOJO server = buildServer();
    String tokenEndpoint = server.getOauthClientCredentials().getTokenEndpoint();
    String resourceUrl = fhirServer.url("/Patient").toString();

    ManagedWebAccess.IWebAccessor hostAccessor = mock(ManagedWebAccess.IWebAccessor.class);
    when(hostAccessor.post(any(), eq(tokenEndpoint), any(), any(), any(), any()))
      .thenReturn(new HTTPResult(tokenEndpoint, 200, "OK", "application/json",
        "{\"access_token\":\"managed-token\",\"expires_in\":3600}".getBytes(StandardCharsets.UTF_8)));
    when(hostAccessor.get(any(), eq(resourceUrl), any(), any()))
      .thenReturn(new HTTPResult(resourceUrl, 200, "OK", "text/plain", "OK".getBytes(StandardCharsets.UTF_8)));

    ManagedWebAccess.setAccessPolicy(ManagedWebAccess.WebAccessPolicy.MANAGED);
    try (MockedStatic<ManagedWebAccess> mocked = mockStatic(ManagedWebAccess.class, CALLS_REAL_METHODS)) {
      mocked.when(ManagedWebAccess::getAccessor).thenReturn(hostAccessor);

      ManagedWebAccessor accessor = new ManagedWebAccessor(List.of("fhir"), "test-agent",
        new ServerDetailsPOJOHTTPAuthProvider(List.of(server)));
      assertThat(accessor.get(resourceUrl, "application/json").getCode()).isEqualTo(200);
    } finally {
      ManagedWebAccess.setAccessPolicy(ManagedWebAccess.WebAccessPolicy.DIRECT);
    }

    ArgumentCaptor<byte[]> tokenBody = ArgumentCaptor.forClass(byte[].class);
    verify(hostAccessor).post(any(), eq(tokenEndpoint), tokenBody.capture(),
      eq("application/x-www-form-urlencoded"), eq("application/json"), any());
    assertThat(new String(tokenBody.getValue(), StandardCharsets.UTF_8))
      .contains("grant_type=client_credentials")
      .contains("client_secret=test-secret");

    @SuppressWarnings("unchecked")
    ArgumentCaptor<Map<String, String>> resourceHeaders = ArgumentCaptor.forClass(Map.class);
    verify(hostAccessor).get(any(), eq(resourceUrl), eq("application/json"), resourceHeaders.capture());
    assertThat(resourceHeaders.getValue()).containsEntry("Authorization", "Bearer managed-token");

    // Nothing went out directly
    assertThat(tokenServer.getRequestCount()).isZero();
    assertThat(fhirServer.getRequestCount()).isZero();
  }

  @Test
  void testManagedPolicyStillRejectsCleartextTokenEndpointBeforeHandOff() throws Exception {
    MockWebServer plainHttpTokenServer = new MockWebServer();
    plainHttpTokenServer.start();
    ManagedWebAccess.IWebAccessor hostAccessor = mock(ManagedWebAccess.IWebAccessor.class);
    ManagedWebAccess.setAccessPolicy(ManagedWebAccess.WebAccessPolicy.MANAGED);
    try (MockedStatic<ManagedWebAccess> mocked = mockStatic(ManagedWebAccess.class, CALLS_REAL_METHODS)) {
      mocked.when(ManagedWebAccess::getAccessor).thenReturn(hostAccessor);
      ServerDetailsPOJO server = OAuthTestSupport.clientCredentialsServer(
        fhirServer.url("").toString(), plainHttpTokenServer, "test-client", "test-secret");
      ManagedWebAccessor accessor = new ManagedWebAccessor(List.of("fhir"), "test-agent",
        new ServerDetailsPOJOHTTPAuthProvider(List.of(server)));

      IOException ex = assertThrows(IOException.class,
        () -> accessor.get(fhirServer.url("/Patient").toString(), "application/json"));
      assertThat(ex.getMessage()).contains("https");
    } finally {
      ManagedWebAccess.setAccessPolicy(ManagedWebAccess.WebAccessPolicy.DIRECT);
      plainHttpTokenServer.shutdown();
    }
    verifyNoInteractions(hostAccessor);
  }

  // =======================================================================
  // Security regression tests (review of PR #2348)
  // =======================================================================

  // Finding #1: the token request carries the client secret in its body, and following a redirect
  // would re-send that body to the redirect target. RFC 6749 §4.4.3 answers a token request with
  // a token response or an error response, so a 3xx is treated as a failure and not followed.

  @Test
  void tokenEndpointRedirectMustNotForwardClientSecret() throws Exception {
    MockWebServer attackerServer = new MockWebServer();
    attackerServer.start();
    try {
      // The token endpoint 302s to a host that is not configured anywhere in fhir-settings.
      tokenServer.enqueue(new MockResponse()
        .setResponseCode(302)
        .addHeader("Location", attackerServer.url("/steal").toString()));

      // If the client does follow the redirect, this is what it would accept as a token.
      attackerServer.enqueue(tokenResponse("attacker-minted", 3600));

      // A 3xx from the token endpoint is not a valid token response, so this must fail.
      IOException ex = assertThrows(IOException.class, () -> getToken(buildServer()));
      assertThat(ex.getMessage()).contains("redirect");

      // The assertion that matters: the secret never left for the redirect target.
      assertThat(attackerServer.getRequestCount())
        .as("client_secret must not be re-POSTed to a token-endpoint redirect target")
        .isZero();
    } finally {
      attackerServer.shutdown();
    }
  }

  @Test
  void tokenEndpoint307RedirectToPlainHttpMustNotBeFollowed() throws Exception {
    // Same shape as above with a 307, which preserves method and body by definition, to a plain
    // http host - which only the configured server's allowHttp could have permitted. (That the
    // token endpoint policy grants nothing off the configured endpoint, even to a redirect that
    // were followed, is tested directly in HTTPTokenManagerTest.)
    MockWebServer elsewhere = new MockWebServer();
    elsewhere.start();
    try {
      tokenServer.enqueue(new MockResponse()
        .setResponseCode(307)
        .addHeader("Location", elsewhere.url("/token").toString()));
      elsewhere.enqueue(tokenResponse("t", 3600));

      assertThrows(IOException.class, () -> getToken(buildServer()));

      assertThat(elsewhere.getRequestCount())
        .as("an off-origin hop must not inherit the configured server's allowHttp grant")
        .isZero();
    } finally {
      elsewhere.shutdown();
    }
  }

  // Finding #2a: a transport failure must not cause the credential-bearing request to be re-sent.
  // DISCONNECT_AFTER_REQUEST is used so MockWebServer records the request before dropping the
  // socket; two responses are enqueued so a second attempt would be recorded rather than block.

  @Test
  void transportFailureMustNotResendClientSecret() {
    tokenServer.enqueue(new MockResponse().setSocketPolicy(SocketPolicy.DISCONNECT_AFTER_REQUEST));
    tokenServer.enqueue(new MockResponse().setSocketPolicy(SocketPolicy.DISCONNECT_AFTER_REQUEST));

    assertThrows(IOException.class, () -> getToken(buildServer()));

    assertThat(tokenServer.getRequestCount())
      .as("withRetries(0) must mean the credential-bearing request is sent exactly once")
      .isEqualTo(1);
  }

  // Finding #4: RFC 6749 §2.3.1 and §3.2 require TLS for client authentication at the token
  // endpoint, so a plain http token endpoint is rejected regardless of the server's allowHttp.

  @Test
  void cleartextTokenEndpointMustBeRejected() throws IOException {
    MockWebServer plainHttpTokenServer = new MockWebServer();
    plainHttpTokenServer.start();
    try {
      ServerDetailsPOJO server = OAuthTestSupport.clientCredentialsServer(
        fhirServer.url("").toString(), plainHttpTokenServer, "test-client", "test-secret");

      IOException ex = assertThrows(IOException.class, () -> getToken(server));
      assertThat(ex.getMessage())
        .as("rejecting a cleartext token endpoint should say so explicitly")
        .containsIgnoringCase("https");

      assertThat(plainHttpTokenServer.getRequestCount())
        .as("the secret must not go out at all over cleartext")
        .isZero();
    } finally {
      plainHttpTokenServer.shutdown();
    }
  }

  // Finding #5: Gson embeds the offending content in its exception messages, so the "(body
  // suppressed)" exception must not chain the Gson exception as its cause.

  @Test
  void nonJsonTokenResponseMustNotLeakBodyViaCause() {
    String sensitive = "eyJhbGciOiJIUzI1NiJ9.leaked-token-material";

    // A quoted JSON string is valid JSON but not an object, so getAsJsonObject() throws
    // IllegalStateException("Not a JSON Object: \"...\"") - with the body inlined.
    tokenServer.enqueue(new MockResponse()
      .setBody("\"" + sensitive + "\"")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    IOException ex = assertThrows(IOException.class, () -> getToken(buildServer()));

    assertThat(ex.getMessage()).contains("(body suppressed)");
    assertThat(ExceptionUtils.getStackTrace(ex))
      .as("a suppressed body must not reappear through the chained cause")
      .doesNotContain(sensitive);
  }

  // Finding #9: a non-string access_token must produce an IOException, not an unchecked
  // exception escaping getHeaders() past every IOException handler.

  @Test
  void nonPrimitiveAccessTokenMustThrowIOException() {
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":{},\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    assertThrows(IOException.class, () -> getToken(buildServer()));
  }

  @Test
  void arrayAccessTokenMustThrowIOException() {
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":[\"a\",\"b\"],\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    assertThrows(IOException.class, () -> getToken(buildServer()));
  }

  // Finding #6: only a 401 triggers the credential refresh and retry. RFC 6750 §3.1: an expired
  // or invalid token is answered with 401 invalid_token, whereas 403 insufficient_scope means the
  // token was valid but not permitted - a fresh token for the same client cannot change that.

  @Test
  void forbiddenResponseMustNotReplayPostBody() throws Exception {
    tokenServer.enqueue(tokenResponse("first-token", 3600));
    tokenServer.enqueue(tokenResponse("second-token", 3600));

    fhirServer.enqueue(new MockResponse().setBody("Forbidden").setResponseCode(403));
    fhirServer.enqueue(new MockResponse().setBody("Forbidden").setResponseCode(403));

    ManagedFhirWebAccessor accessor = fhirAccessor(buildServer());

    byte[] payload = "{\"resourceType\":\"Patient\",\"id\":\"submitted-once\"}".getBytes(StandardCharsets.UTF_8);
    HTTPResult result = accessor.httpCall(new HTTPRequest()
      .withUrl(fhirServer.url("/Patient").toString())
      .withMethod(HTTPRequest.HttpMethod.POST)
      .withContentType("application/fhir+json")
      .withBody(payload));

    assertThat(result.getCode()).isEqualTo(403);

    assertThat(fhirServer.getRequestCount())
      .as("a 403 must not cause a request body to be resubmitted")
      .isEqualTo(1);
    assertThat(tokenServer.getRequestCount()).isEqualTo(1);

    RecordedRequest submitted = fhirServer.takeRequest();
    assertThat(submitted.getBody().readUtf8()).contains("submitted-once");
  }

  // A 401 does replay the request, whatever its method: 401 means the request was not
  // authenticated (RFC 9110 §15.5.2), so the server has not acted on it. FHIR terminology
  // operations ($expand, $validate-code, ...) are routinely POSTed, so restricting the retry to
  // GET would remove it from most of the traffic it exists for. It happens at most once, and only
  // when a cached token was actually discarded.

  @Test
  void unauthorizedResponseReplaysPutOnceWithFreshToken() throws Exception {
    tokenServer.enqueue(tokenResponse("first-token", 3600));
    tokenServer.enqueue(tokenResponse("second-token", 3600));

    fhirServer.enqueue(new MockResponse().setResponseCode(401));
    fhirServer.enqueue(new MockResponse().setResponseCode(401));

    ManagedFhirWebAccessor accessor = fhirAccessor(buildServer());

    HTTPResult result = accessor.httpCall(new HTTPRequest()
      .withUrl(fhirServer.url("/Patient/123").toString())
      .withMethod(HTTPRequest.HttpMethod.PUT)
      .withContentType("application/fhir+json")
      .withBody("{\"resourceType\":\"Patient\",\"id\":\"123\"}".getBytes(StandardCharsets.UTF_8)));

    // Refreshed and retried once; the second 401 is returned rather than retried again
    assertThat(result.getCode()).isEqualTo(401);
    assertThat(fhirServer.getRequestCount()).isEqualTo(2);
    assertThat(tokenServer.getRequestCount()).isEqualTo(2);

    assertThat(fhirServer.takeRequest().getHeader("Authorization")).isEqualTo("Bearer first-token");
    assertThat(fhirServer.takeRequest().getHeader("Authorization")).isEqualTo("Bearer second-token");
  }

  // Finding #10: cached tokens must not outlive the settings they were minted under, nor be
  // shared between configurations that differ only in their secret. (The expires_in clamp is
  // tested in HTTPTokenManagerTest, which can control the clock.)

  @Test
  void settingsReloadMustEvictCachedTokens() throws Exception {
    tokenServer.enqueue(tokenResponse("token-before-reload", 3600));
    tokenServer.enqueue(tokenResponse("token-after-reload", 3600));

    ServerDetailsPOJO server = buildServer();
    ManagedWebAccess.loadFromSettings(FhirSettingsPOJO.builder().servers(List.of(server)).build());
    assertThat(getToken(server)).isEqualTo("token-before-reload");

    // Reloading even identical settings discards cached tokens: the operator may have revoked
    // the client at the authorization server, and a reload is how they get the tool to notice.
    ManagedWebAccess.loadFromSettings(FhirSettingsPOJO.builder().servers(List.of(server)).build());

    assertThat(getToken(server))
      .as("a settings reload must not keep serving a token minted before it")
      .isEqualTo("token-after-reload");
    assertThat(tokenServer.getRequestCount()).isEqualTo(2);
  }

  @Test
  void cacheKeyMustDistinguishDifferentSecrets() throws Exception {
    tokenServer.enqueue(tokenResponse("token-a", 3600));
    tokenServer.enqueue(tokenResponse("token-b", 3600));

    ServerDetailsPOJO a = buildServer();
    ServerDetailsPOJO b = a.toBuilder()
      .oauthClientCredentials(a.getOauthClientCredentials().toBuilder().clientSecret("a-different-secret").build())
      .build();

    assertThat(getToken(a)).isEqualTo("token-a");
    assertThat(getToken(b))
      .as("two configs sharing tokenEndpoint|clientId but differing in secret must not share a token")
      .isEqualTo("token-b");
  }

  private static String getToken(ServerDetailsPOJO server) throws IOException {
    OAuthClientCredentialsPOJO credentials = server.getOauthClientCredentials();
    return HTTPTokenManager.getToken(credentials, Boolean.TRUE.equals(server.getAllowPrivateNetwork()));
  }

  private static ManagedFhirWebAccessor fhirAccessor(ServerDetailsPOJO server) {
    return new ManagedFhirWebAccessor("test-agent", new ServerDetailsPOJOHTTPAuthProvider(List.of(server)));
  }

  private ServerDetailsPOJO buildServer() {
    return OAuthTestSupport.clientCredentialsServer(fhirServer.url("").toString(), tokenServer, "test-client", "test-secret");
  }
}
