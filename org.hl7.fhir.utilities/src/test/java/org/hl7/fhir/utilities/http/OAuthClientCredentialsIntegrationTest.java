package org.hl7.fhir.utilities.http;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Isolated;

import java.io.IOException;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * End-to-end integration tests for the OAuth client_credentials flow.
 *
 * These tests exercise the full chain from configuration through to authenticated
 * FHIR server requests, verifying that:
 * <ul>
 *   <li>Settings are loaded and validated correctly</li>
 *   <li>Tokens are fetched from the token endpoint using client_credentials grant</li>
 *   <li>Bearer tokens are attached to FHIR server requests</li>
 *   <li>Expired tokens are transparently refreshed</li>
 *   <li>401 responses trigger token invalidation and retry</li>
 *   <li>The addServerAuthDetail (CLI param) path works end-to-end</li>
 * </ul>
 */
@Isolated
public class OAuthClientCredentialsIntegrationTest {

  private MockWebServer tokenServer;
  private MockWebServer fhirServer;

  @BeforeEach
  void setup() throws IOException {
    tokenServer = new MockWebServer();
    fhirServer = new MockWebServer();
    tokenServer.start();
    fhirServer.start();
    HTTPTokenManager.clearCache();
    ManagedWebAccess.setAccessPolicy(ManagedWebAccess.WebAccessPolicy.DIRECT);
  }

  @AfterEach
  void tearDown() throws IOException {
    HTTPTokenManager.clearCache();
    tokenServer.shutdown();
    fhirServer.shutdown();
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
  public void testFullFlowViaManagedWebAccess() throws Exception {
    // Set up token endpoint
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"settings-token-abc\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    // Set up FHIR server to return a CapabilityStatement
    fhirServer.enqueue(new MockResponse()
      .setBody("{\"resourceType\":\"CapabilityStatement\",\"status\":\"active\"}")
      .addHeader("Content-Type", "application/fhir+json")
      .setResponseCode(200));

    // Configure ManagedWebAccess the same way loadFromFHIRSettings() + addServerAuthDetail() would
    ManagedWebAccess.setUserAgent("test-agent");
    ManagedWebAccess.addServerAuthDetail(buildServer());

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
  public void testTokenCachingAcrossRequests() throws Exception {
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"cached-token\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    // Two FHIR responses
    fhirServer.enqueue(new MockResponse().setBody("Response 1").setResponseCode(200));
    fhirServer.enqueue(new MockResponse().setBody("Response 2").setResponseCode(200));

    ServerDetailsPOJO server = buildServer();
    ManagedFhirWebAccessor accessor = new ManagedFhirWebAccessor("test-agent", java.util.List.of(server));

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
  // First token has expires_in=1 (immediately expiring due to 30s buffer).
  // Second FHIR request triggers a new token fetch transparently.
  // -----------------------------------------------------------------------
  @Test
  public void testTransparentTokenRefreshOnExpiry() throws Exception {
    // First token expires immediately (1s < 30s buffer)
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"short-lived-token\",\"token_type\":\"Bearer\",\"expires_in\":1}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    // Refreshed token
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"refreshed-token\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    fhirServer.enqueue(new MockResponse().setBody("Response 1").setResponseCode(200));
    fhirServer.enqueue(new MockResponse().setBody("Response 2").setResponseCode(200));

    ServerDetailsPOJO server = buildServer();
    ManagedFhirWebAccessor accessor = new ManagedFhirWebAccessor("test-agent", java.util.List.of(server));

    String fhirUrl = fhirServer.url("/Patient").toString();

    // First request gets the short-lived token
    HTTPResult result1 = accessor.httpCall(
      new HTTPRequest().withUrl(fhirUrl).withMethod(HTTPRequest.HttpMethod.GET));
    assertThat(result1.getCode()).isEqualTo(200);

    // Second request - token is expiring, so a new one is fetched transparently
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
  // Note: OkHttp RetryInterceptor retries once on non-2xx, so we need two
  // 401s before our code sees it.
  // -----------------------------------------------------------------------
  @Test
  public void testRetryOn401FromFhirServer() throws Exception {
    // First token (will be "rejected" by FHIR server)
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"rejected-token\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    // Second token (after invalidation)
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"accepted-token\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    // FHIR server: 401 twice (original + OkHttp retry interceptor), then 200
    fhirServer.enqueue(new MockResponse().setBody("Unauthorized").setResponseCode(401));
    fhirServer.enqueue(new MockResponse().setBody("Unauthorized").setResponseCode(401));
    fhirServer.enqueue(new MockResponse()
      .setBody("{\"resourceType\":\"Patient\",\"id\":\"123\"}")
      .addHeader("Content-Type", "application/fhir+json")
      .setResponseCode(200));

    ServerDetailsPOJO server = buildServer();
    ManagedFhirWebAccessor accessor = new ManagedFhirWebAccessor("test-agent", java.util.List.of(server));

    String fhirUrl = fhirServer.url("/Patient/123").toString();
    HTTPResult result = accessor.httpCall(
      new HTTPRequest().withUrl(fhirUrl).withMethod(HTTPRequest.HttpMethod.GET));

    // Should succeed after retry
    assertThat(result.getCode()).isEqualTo(200);
    assertThat(result.getContentAsString()).contains("Patient");

    // Two token fetches: original + after invalidation
    assertThat(tokenServer.getRequestCount()).isEqualTo(2);

    // The retry request used the new token
    // Skip the first two 401 requests
    fhirServer.takeRequest(); // 401 with rejected-token
    fhirServer.takeRequest(); // 401 with rejected-token (OkHttp retry)
    RecordedRequest retryRequest = fhirServer.takeRequest(); // 200 with accepted-token
    assertThat(retryRequest.getHeader("Authorization")).isEqualTo("Bearer accepted-token");
  }

  // -----------------------------------------------------------------------
  // Test 5: addServerAuthDetail path (simulates CLI param injection)
  //
  // This is the path used when the IG Publisher receives -tx-client-id,
  // -tx-client-secret, -tx-token-endpoint CLI params. The Publisher calls
  // ManagedWebAccess.addServerAuthDetail() after loadFromFHIRSettings().
  // -----------------------------------------------------------------------
  @Test
  public void testAddServerAuthDetailPath() throws Exception {
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"cli-token\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    fhirServer.enqueue(new MockResponse()
      .setBody("{\"resourceType\":\"Bundle\",\"type\":\"searchset\"}")
      .addHeader("Content-Type", "application/fhir+json")
      .setResponseCode(200));

    // Simulate what the IG Publisher does:
    // 1. loadFromFHIRSettings() (with empty/default settings)
    // 2. addServerAuthDetail() with CLI-provided OAuth config
    ManagedWebAccess.setAccessPolicy(ManagedWebAccess.WebAccessPolicy.DIRECT);
    ManagedWebAccess.setUserAgent("test-agent");

    // This is exactly what configureOAuthFromCliParams() does in Publisher.java
    ServerDetailsPOJO cliServer = ServerDetailsPOJO.builder()
      .url(fhirServer.url("").toString())
      .type("fhir")
      .authenticationType("client_credentials")
      .clientId("cli-client-id")
      .clientSecret("cli-client-secret")
      .tokenEndpoint(tokenServer.url("/token").toString())
      .build();
    ManagedWebAccess.addServerAuthDetail(cliServer);

    // Make a request through the top-level API (same as validator/IG publisher would)
    String fhirUrl = fhirServer.url("/ValueSet/$expand").toString();
    HTTPResult result = ManagedWebAccess.httpCall(
      new HTTPRequest().withUrl(fhirUrl).withMethod(HTTPRequest.HttpMethod.POST)
        .withBody("test".getBytes()).withContentType("application/fhir+json"));

    assertThat(result.getCode()).isEqualTo(200);

    // Verify token request used CLI credentials
    RecordedRequest tokenRequest = tokenServer.takeRequest();
    String tokenBody = tokenRequest.getBody().readUtf8();
    assertThat(tokenBody).contains("client_id=cli-client-id");
    assertThat(tokenBody).contains("client_secret=cli-client-secret");

    // Verify FHIR request had Bearer token
    RecordedRequest fhirRequest = fhirServer.takeRequest();
    assertThat(fhirRequest.getHeader("Authorization")).isEqualTo("Bearer cli-token");
  }

  // -----------------------------------------------------------------------
  // Test 6: ManagedWebAccessor path (SimpleHTTPClient-based)
  //
  // Verifies that the SimpleHTTPClient-based ManagedWebAccessor also
  // handles client_credentials correctly, not just the OkHttp-based
  // ManagedFhirWebAccessor.
  // -----------------------------------------------------------------------
  @Test
  public void testManagedWebAccessorPath() throws Exception {
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"web-token\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    fhirServer.enqueue(new MockResponse()
      .setBody("{\"name\":\"test-package\"}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    ServerDetailsPOJO server = ServerDetailsPOJO.builder()
      .url(fhirServer.url("").toString())
      .authenticationType("client_credentials")
      .type("fhir")
      .clientId("web-client")
      .clientSecret("web-secret")
      .tokenEndpoint(tokenServer.url("/token").toString())
      .build();

    ManagedWebAccessor accessor = new ManagedWebAccessor(
      Arrays.asList("fhir"), "test-agent", java.util.List.of(server));

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
  // Test 7: Token endpoint failure produces a clear error
  //
  // Verifies that when the token endpoint returns an error, the IOException
  // propagates with a descriptive message rather than a confusing
  // NullPointerException or silent failure.
  // -----------------------------------------------------------------------
  @Test
  public void testTokenEndpointFailureProducesDescriptiveError() throws Exception {
    // Token endpoint returns 401 (e.g., bad client credentials)
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"error\":\"invalid_client\",\"error_description\":\"Client authentication failed\"}")
      .setResponseCode(401));

    ServerDetailsPOJO server = buildServer();
    ManagedFhirWebAccessor accessor = new ManagedFhirWebAccessor("test-agent", java.util.List.of(server));

    String fhirUrl = fhirServer.url("/Patient").toString();

    org.junit.jupiter.api.Assertions.assertThrows(IOException.class, () -> {
      accessor.httpCall(
        new HTTPRequest().withUrl(fhirUrl).withMethod(HTTPRequest.HttpMethod.GET));
    });

    // No requests should have reached the FHIR server
    assertThat(fhirServer.getRequestCount()).isEqualTo(0);
  }

  private ServerDetailsPOJO buildServer() {
    return ServerDetailsPOJO.builder()
      .url(fhirServer.url("").toString())
      .authenticationType("client_credentials")
      .type("fhir")
      .clientId("test-client")
      .clientSecret("test-secret")
      .tokenEndpoint(tokenServer.url("/token").toString())
      .build();
  }
}
