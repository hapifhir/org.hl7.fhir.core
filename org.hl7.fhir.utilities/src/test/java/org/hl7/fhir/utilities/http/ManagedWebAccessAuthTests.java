package org.hl7.fhir.utilities.http;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.apache.commons.net.util.Base64;
import org.hl7.fhir.utilities.settings.FhirSettingsPOJO;
import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.doReturn;

public class ManagedWebAccessAuthTests {

  public static final String DUMMY_AGENT = "dummyAgent";
  public static final String DUMMY_USERNAME = "dummy1";
  public static final String DUMMY_PASSWORD = "pass1";

  public static String dummyBasic() {
    byte[] b = Base64.encodeBase64((DUMMY_USERNAME + ":" + DUMMY_PASSWORD).getBytes(StandardCharsets.US_ASCII));
    return "Basic " + new String(b, StandardCharsets.US_ASCII);
  }

  public static final String DUMMY_TOKEN = "dummyToken";
  private static final String DUMMY_API_KEY = "dummyApiKey";
  public static final String PATH_ON_MOCK_SERVER = "blah/blah/blah?arg=blah";
  private static MockWebServer server;
  private MockWebServer tokenServer;

  @BeforeAll
  static void beforeAll() throws IOException {
    server = new MockWebServer();
    server.start();
  }

  @BeforeEach
  void setup() {
    HTTPTokenManager.clearCache();
  }

  @AfterEach
  void tearDown() throws IOException {
    HTTPTokenManager.clearCache();
    if (tokenServer != null) {
      tokenServer.shutdown();
      tokenServer = null;
    }
  }

  @AfterAll
  static void afterAll() throws IOException {
    ManagedWebAccess.loadFromFHIRSettings();
    server.shutdown();
  }

  @Test
  void testBaseCase() throws IOException, InterruptedException {
    HttpUrl serverUrl = server.url(PATH_ON_MOCK_SERVER);

    server.enqueue(
      new MockResponse()
        .setBody("Dummy Response").setResponseCode(200)
    );

    ManagedFhirWebAccessor webAccessor = new ManagedFhirWebAccessor("dummyAgent", null) {
      // This needs to be turned off, or localhost will always get caught by ssrf protection
      @Override
      protected boolean isSSRFProtectionEnabled() {
        return false;
      }
    };
    HTTPResult result = webAccessor.httpCall(new HTTPRequest().withUrl(serverUrl.toString()).withMethod(HTTPRequest.HttpMethod.GET));

    assertThat(result.getCode()).isEqualTo(200);
    assertThat(result.getContentAsString()).isEqualTo("Dummy Response");

    RecordedRequest packageRequest = server.takeRequest();

    assert packageRequest.getRequestUrl() != null;
    assertExpectedHeaders(packageRequest, serverUrl.url().toString(), "GET");

  }


  @Test
  void testBasicAuthCase() throws IOException, InterruptedException {
    IHTTPAuthenticationProvider authenticationProvider = Mockito.mock(IHTTPAuthenticationProvider.class);

    URL url = server.url(PATH_ON_MOCK_SERVER).url();
    doReturn(true).when(authenticationProvider).isProtocolAllowed(url);
    doReturn(true).when(authenticationProvider).canProvideHeaders(url);
    doReturn(true).when(authenticationProvider).isPrivateNetworkAllowed(url);
    doReturn(Map.of("Authorization", dummyBasic())).when(authenticationProvider).getHeaders(url);

    ManagedFhirWebAccessor managedFhirWebAccessor = new ManagedFhirWebAccessor("dummyAgent", authenticationProvider);

    testBasicServerAuth(managedFhirWebAccessor);
  }

  private void testBasicServerAuth(ManagedFhirWebAccessor managedFhirWebAccessor) throws IOException, InterruptedException {
    HttpUrl serverUrl = server.url(PATH_ON_MOCK_SERVER);

    server.enqueue(
      new MockResponse()
        .setBody("Dummy Response").setResponseCode(200)
    );
    HTTPResult result = managedFhirWebAccessor.httpCall(new HTTPRequest().withUrl(serverUrl.toString()).withMethod(HTTPRequest.HttpMethod.GET));

    assertThat(result.getCode()).isEqualTo(200);
    assertThat(result.getContentAsString()).isEqualTo("Dummy Response");

    RecordedRequest packageRequest = server.takeRequest();

    assert packageRequest.getRequestUrl() != null;
    assertExpectedHeaders(packageRequest, serverUrl.url().toString(), "GET");

    assertThat(packageRequest.getHeader("Authorization")).isEqualTo(dummyBasic());
  }

  @Test
  void testTokenAuthCase() throws IOException, InterruptedException {
    IHTTPAuthenticationProvider authenticationProvider = Mockito.mock(IHTTPAuthenticationProvider.class);
    URL url = server.url(PATH_ON_MOCK_SERVER).url();
    doReturn(true).when(authenticationProvider).isProtocolAllowed(url);
    doReturn(true).when(authenticationProvider).canProvideHeaders(url);
    doReturn(true).when(authenticationProvider).isPrivateNetworkAllowed(url);
    doReturn(Map.of("Authorization", "Bearer "+ DUMMY_TOKEN)).when(authenticationProvider).getHeaders(url);

    ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor("dummyAgent", authenticationProvider);
    testTokenAuthCase(builder);
  }

  private void testTokenAuthCase(ManagedFhirWebAccessor builder) throws IOException, InterruptedException {
    HttpUrl serverUrl = server.url(PATH_ON_MOCK_SERVER);
    server.enqueue(
      new MockResponse()
        .setBody("Dummy Response").setResponseCode(200)
    );
    HTTPResult result = builder.httpCall(new HTTPRequest().withUrl(serverUrl.toString()).withMethod(HTTPRequest.HttpMethod.GET));

    assertThat(result.getCode()).isEqualTo(200);
    assertThat(result.getContentAsString()).isEqualTo("Dummy Response");

    RecordedRequest packageRequest = server.takeRequest();

    assert packageRequest.getRequestUrl() != null;
    assertExpectedHeaders(packageRequest, serverUrl.url().toString(), "GET");

    assertThat(packageRequest.getHeader("Authorization")).isEqualTo("Bearer " + DUMMY_TOKEN);
  }

  private void assertExpectedHeaders(RecordedRequest packageRequest, String expectedUrl, String expectedHttpMethod) {
    assertThat(packageRequest.getRequestUrl().toString()).isEqualTo(expectedUrl);
    assertThat(packageRequest.getMethod()).isEqualTo(expectedHttpMethod);
    assertThat(packageRequest.getHeader("User-Agent")).isEqualTo(DUMMY_AGENT);
  }

  @Test
  public void testApiKeyAuthCase() throws IOException, InterruptedException {
    IHTTPAuthenticationProvider authenticationProvider = Mockito.mock(IHTTPAuthenticationProvider.class);
    URL url = server.url(PATH_ON_MOCK_SERVER).url();
    doReturn(true).when(authenticationProvider).isProtocolAllowed(url);
    doReturn(true).when(authenticationProvider).canProvideHeaders(url);
    doReturn(true).when(authenticationProvider).isPrivateNetworkAllowed(url);
    doReturn(Map.of("Api-Key", DUMMY_API_KEY)).when(authenticationProvider).getHeaders(url);
    ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor("dummyAgent", authenticationProvider);
    testApiKeyAuthCase(builder);
  }

  private void testApiKeyAuthCase(ManagedFhirWebAccessor builder) throws IOException, InterruptedException {
    HttpUrl serverUrl = server.url(PATH_ON_MOCK_SERVER);

    server.enqueue(
      new MockResponse()
        .setBody("Dummy Response").setResponseCode(200)
    );
    HTTPResult result = builder.httpCall(new HTTPRequest().withUrl(serverUrl.toString()).withMethod(HTTPRequest.HttpMethod.GET));

    assertThat(result.getCode()).isEqualTo(200);
    assertThat(result.getContentAsString()).isEqualTo("Dummy Response");

    RecordedRequest packageRequest = server.takeRequest();

    assert packageRequest.getRequestUrl() != null;
    assertExpectedHeaders(packageRequest, serverUrl.url().toString(), "GET");

    assertThat(packageRequest.getHeader("Api-Key")).isEqualTo(DUMMY_API_KEY);
  }

  @Test
  public void testDirectDoesNotLeakAuthHeadersToCrossOriginRedirect() throws IOException, InterruptedException {
    HttpUrl serverUrl = server.url(PATH_ON_MOCK_SERVER);
    MockWebServer serverB = new MockWebServer();
    try {
      serverB.start();
      HttpUrl serverBUrl = serverB.url("redirected");

      server.enqueue(
        new MockResponse()
          .setResponseCode(302)
          .addHeader("Location", serverBUrl.url().toString()));
      serverB.enqueue(new MockResponse().setBody("Dummy Response").setResponseCode(200));

      IHTTPAuthenticationProvider authenticationProvider = Mockito.mock(IHTTPAuthenticationProvider.class);
      doReturn(true).when(authenticationProvider).isProtocolAllowed(serverUrl.url());
      doReturn(true).when(authenticationProvider).canProvideHeaders(serverUrl.url());
      doReturn(Map.of("Authorization", dummyBasic())).when(authenticationProvider).getHeaders(serverUrl.url());
      // canProvideHeaders/getHeaders left at their Mockito defaults (false / empty map) for
      // serverBUrl - authenticationProvider is scoped to `server`'s origin only, mirroring a
      // real per-server auth provider like ServerDetailsPOJOHTTPAuthProvider.

      ManagedFhirWebAccessor webAccessor = new ManagedFhirWebAccessor(DUMMY_AGENT, authenticationProvider) {
        // SSRF protection would otherwise catch every loopback address used by both mock
        // servers; that's not what this test is about.
        @Override
        protected boolean isSSRFProtectionEnabled() {
          return false;
        }
      };

      HTTPResult result = webAccessor.httpCall(new HTTPRequest().withUrl(serverUrl.toString()).withMethod(HTTPRequest.HttpMethod.GET));

      assertThat(result.getCode()).isEqualTo(200);
      assertThat(result.getContentAsString()).isEqualTo("Dummy Response");

      RecordedRequest hop1Request = server.takeRequest();
      assertThat(hop1Request.getHeader("Authorization")).isEqualTo(dummyBasic());

      RecordedRequest hop2Request = serverB.takeRequest();
      assertThat(hop2Request.getHeader("Authorization")).isNull();
    } finally {
      serverB.shutdown();
    }
  }

  @Test
  public void testBasicAuthFromSettings() throws IOException, InterruptedException {
    ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor(
      "dummyAgent",
      new ServerDetailsPOJOHTTPAuthProvider(List.of(getBasicAuthServerPojo())));

    testBasicServerAuth(builder);
  }

  private ServerDetailsPOJO getBasicAuthServerPojo() {
    return ServerDetailsPOJO.builder()
      .url(server.url("").toString())
      .authenticationType("basic")
      .type("fhir")
      .username(DUMMY_USERNAME)
      .password(DUMMY_PASSWORD)
      .allowHttp(true)
      .allowPrivateNetwork(true)
      .build();
  }

@Test
public void testTokenAuthFromSettings() throws IOException, InterruptedException {
  ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor(
    "dummyAgent",
    new ServerDetailsPOJOHTTPAuthProvider(List.of(getTokenAuthServerPojo())));

  testTokenAuthCase(builder);
}

  private ServerDetailsPOJO getTokenAuthServerPojo() {
    return ServerDetailsPOJO.builder()
      .url(server.url("").toString())
      .authenticationType("token")
      .type("fhir")
      .token(DUMMY_TOKEN)
      .allowHttp(true)
      .allowPrivateNetwork(true)
      .build();
  }

  @Test
  public void testApiKeyAuthFromSettings() throws IOException, InterruptedException {
    ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor(
      "dummyAgent",
      new ServerDetailsPOJOHTTPAuthProvider(List.of(getApiKeyAuthServerPojo())));

    testApiKeyAuthCase(builder);
  }

  private ServerDetailsPOJO getApiKeyAuthServerPojo() {
    return ServerDetailsPOJO.builder()
      .url(server.url("").toString())
      .authenticationType("apikey")
      .type("fhir")
      .apikey(DUMMY_API_KEY)
      .allowHttp(true)
      .allowPrivateNetwork(true)
      .build();
  }

  @Test
  void testClientCredentialsAuthFromSettings() throws Exception {
    tokenServer = new MockWebServer();
    tokenServer.start();

    // Token endpoint returns an access token
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"oauth-token-123\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    ServerDetailsPOJO serverPojo = ServerDetailsPOJO.builder()
      .url(server.url("").toString())
      .authenticationType("client_credentials")
      .type("fhir")
      .clientId("testClient")
      .clientSecret("testSecret")
      .tokenEndpoint(tokenServer.url("/token").toString())
      .allowHttp(true)
      .allowPrivateNetwork(true)
      .build();

    ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor(DUMMY_AGENT, new ServerDetailsPOJOHTTPAuthProvider(List.of(serverPojo)));

    HttpUrl serverUrl = server.url("blah/blah/blah?arg=blah");
    server.enqueue(new MockResponse()
      .setBody("Dummy Response").setResponseCode(200));

    HTTPResult result = builder.httpCall(new HTTPRequest().withUrl(serverUrl.toString()).withMethod(HTTPRequest.HttpMethod.GET));

    assertThat(result.getCode()).isEqualTo(200);
    assertThat(result.getContentAsString()).isEqualTo("Dummy Response");

    RecordedRequest fhirRequest = server.takeRequest();
    assertThat(fhirRequest.getHeader("Authorization")).isEqualTo("Bearer oauth-token-123");
  }

  @Test
  void testClientCredentials401Retry() throws Exception {
    tokenServer = new MockWebServer();
    tokenServer.start();

    // First token
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"expired-token\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    // Second token after invalidation
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"fresh-token\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    ServerDetailsPOJO serverPojo = ServerDetailsPOJO.builder()
      .url(server.url("").toString())
      .authenticationType("client_credentials")
      .type("fhir")
      .clientId("testClient")
      .clientSecret("testSecret")
      .tokenEndpoint(tokenServer.url("/token").toString())
      .allowHttp(true)
      .allowPrivateNetwork(true)
      .build();

    ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor(DUMMY_AGENT, new ServerDetailsPOJOHTTPAuthProvider(List.of(serverPojo)));

    HttpUrl serverUrl = server.url("blah/blah/blah?arg=blah");

    // The credential refresh happens inside ManagedHTTPClient, on the response it receives, so
    // it is independent of the RetryInterceptor count: one 401 is all it takes.
    server.enqueue(new MockResponse()
      .setBody("Unauthorized").setResponseCode(401));

    // After token invalidation and re-fetch, the fresh token request succeeds
    server.enqueue(new MockResponse()
      .setBody("Success").setResponseCode(200));

    HTTPResult result = builder.httpCall(new HTTPRequest().withUrl(serverUrl.toString()).withMethod(HTTPRequest.HttpMethod.GET));

    assertThat(result.getCode()).isEqualTo(200);
    assertThat(result.getContentAsString()).isEqualTo("Success");

    // First request used the expired token
    RecordedRequest firstRequest = server.takeRequest();
    assertThat(firstRequest.getHeader("Authorization")).isEqualTo("Bearer expired-token");

    // Second request used fresh token after invalidation
    RecordedRequest retryRequest = server.takeRequest();
    assertThat(retryRequest.getHeader("Authorization")).isEqualTo("Bearer fresh-token");

    // Token endpoint was hit exactly twice (cache invalidated, fresh token fetched)
    assertThat(tokenServer.getRequestCount()).isEqualTo(2);
  }

  @Test
  void testClientCredentialsProgrammaticApi() throws Exception {
    tokenServer = new MockWebServer();
    tokenServer.start();

    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"programmatic-token\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    ServerDetailsPOJO serverPojo = ServerDetailsPOJO.builder()
      .url(server.url("").toString())
      .authenticationType("client_credentials")
      .type("fhir")
      .clientId("testClient")
      .clientSecret("testSecret")
      .tokenEndpoint(tokenServer.url("/token").toString())
      .allowHttp(true)
      .allowPrivateNetwork(true)
      .build();

    // Programmatically supply the client_credentials config via the auth provider
    ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor(
      DUMMY_AGENT, new ServerDetailsPOJOHTTPAuthProvider(List.of(serverPojo)));

    HttpUrl serverUrl = server.url("blah/blah/blah?arg=blah");
    server.enqueue(new MockResponse()
      .setBody("Dummy Response").setResponseCode(200));

    HTTPResult result = builder.httpCall(new HTTPRequest().withUrl(serverUrl.toString()).withMethod(HTTPRequest.HttpMethod.GET));

    assertThat(result.getCode()).isEqualTo(200);

    RecordedRequest fhirRequest = server.takeRequest();
    assertThat(fhirRequest.getHeader("Authorization")).isEqualTo("Bearer programmatic-token");
  }

  @Test
  void testClientCredentialsProgrammaticApiOnManagedWebAccessor() throws Exception {
    tokenServer = new MockWebServer();
    tokenServer.start();

    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"web-programmatic-token\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    ServerDetailsPOJO serverPojo = ServerDetailsPOJO.builder()
      .url(server.url("").toString())
      .authenticationType("client_credentials")
      .type("fhir")
      .clientId("testClient")
      .clientSecret("testSecret")
      .tokenEndpoint(tokenServer.url("/token").toString())
      .allowHttp(true)
      .allowPrivateNetwork(true)
      .build();

    ManagedWebAccessor accessor = new ManagedWebAccessor(
      Arrays.asList("fhir"), DUMMY_AGENT, new ServerDetailsPOJOHTTPAuthProvider(List.of(serverPojo)));

    server.enqueue(new MockResponse()
      .setBody("Dummy Response").setResponseCode(200));

    HTTPResult result = accessor.get(server.url("blah").toString(), "application/json");

    assertThat(result.getCode()).isEqualTo(200);

    RecordedRequest webRequest = server.takeRequest();
    assertThat(webRequest.getHeader("Authorization")).isEqualTo("Bearer web-programmatic-token");
  }

  @Test
  void testManagedWebAccessorRetryOn401() throws Exception {
    tokenServer = new MockWebServer();
    tokenServer.start();

    // First token
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"expired-token\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    // Second token after invalidation
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"fresh-token\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    ServerDetailsPOJO serverPojo = ServerDetailsPOJO.builder()
      .url(server.url("").toString())
      .authenticationType("client_credentials")
      .type("fhir")
      .clientId("testClient")
      .clientSecret("testSecret")
      .tokenEndpoint(tokenServer.url("/token").toString())
      .allowHttp(true)
      .allowPrivateNetwork(true)
      .build();

    ManagedWebAccessor accessor = new ManagedWebAccessor(Arrays.asList("fhir"), DUMMY_AGENT, new ServerDetailsPOJOHTTPAuthProvider(List.of(serverPojo)));

    // ManagedWebAccessor builds its ManagedHTTPClient without an explicit retry count, so it gets
    // DEFAULT_RETRIES (1): the RetryInterceptor makes one extra attempt before our retry logic
    // sees the 401, hence two 401s.
    server.enqueue(new MockResponse()
      .setBody("Unauthorized").setResponseCode(401));
    server.enqueue(new MockResponse()
      .setBody("Unauthorized").setResponseCode(401));

    // After token invalidation and re-fetch, the fresh token request succeeds
    server.enqueue(new MockResponse()
      .setBody("Success").setResponseCode(200));

    HTTPResult result = accessor.get(server.url("blah").toString(), "application/json");

    assertThat(result.getCode()).isEqualTo(200);
    assertThat(result.getContentAsString()).isEqualTo("Success");

    // Two token fetches
    assertThat(tokenServer.getRequestCount()).isEqualTo(2);

    // First two requests used expired token (original + interceptor retry), then fresh token
    RecordedRequest firstRequest = server.takeRequest();
    assertThat(firstRequest.getHeader("Authorization")).isEqualTo("Bearer expired-token");
    RecordedRequest retryByInterceptor = server.takeRequest();
    assertThat(retryByInterceptor.getHeader("Authorization")).isEqualTo("Bearer expired-token");
    RecordedRequest retryRequest = server.takeRequest();
    assertThat(retryRequest.getHeader("Authorization")).isEqualTo("Bearer fresh-token");
  }

  @Test
  void testManagedWebAccessorRetryOn403() throws Exception {
    tokenServer = new MockWebServer();
    tokenServer.start();

    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"old-token\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"new-token\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    ServerDetailsPOJO serverPojo = ServerDetailsPOJO.builder()
      .url(server.url("").toString())
      .authenticationType("client_credentials")
      .type("fhir")
      .clientId("testClient")
      .clientSecret("testSecret")
      .tokenEndpoint(tokenServer.url("/token").toString())
      .allowHttp(true)
      .allowPrivateNetwork(true)
      .build();

    ManagedWebAccessor accessor = new ManagedWebAccessor(Arrays.asList("fhir"), DUMMY_AGENT, new ServerDetailsPOJOHTTPAuthProvider(List.of(serverPojo)));

    // Two 403s: the original attempt plus the RetryInterceptor's default extra attempt
    server.enqueue(new MockResponse()
      .setBody("Forbidden").setResponseCode(403));
    server.enqueue(new MockResponse()
      .setBody("Forbidden").setResponseCode(403));
    server.enqueue(new MockResponse()
      .setBody("Success").setResponseCode(200));

    HTTPResult result = accessor.get(server.url("blah").toString(), "application/json");

    assertThat(result.getCode()).isEqualTo(200);

    RecordedRequest retryRequest = server.takeRequest();
    assertThat(retryRequest.getHeader("Authorization")).isEqualTo("Bearer old-token");
    RecordedRequest retryByInterceptor = server.takeRequest();
    assertThat(retryByInterceptor.getHeader("Authorization")).isEqualTo("Bearer old-token");
    RecordedRequest finalRequest = server.takeRequest();
    assertThat(finalRequest.getHeader("Authorization")).isEqualTo("Bearer new-token");
  }

  @Test
  void testManagedWebAccessorPostRetryOn401() throws Exception {
    tokenServer = new MockWebServer();
    tokenServer.start();

    // First token
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"expired-token\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    // Second token after invalidation
    tokenServer.enqueue(new MockResponse()
      .setBody("{\"access_token\":\"fresh-token\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
      .addHeader("Content-Type", "application/json")
      .setResponseCode(200));

    ServerDetailsPOJO serverPojo = ServerDetailsPOJO.builder()
      .url(server.url("").toString())
      .authenticationType("client_credentials")
      .type("fhir")
      .clientId("testClient")
      .clientSecret("testSecret")
      .tokenEndpoint(tokenServer.url("/token").toString())
      .allowHttp(true)
      .allowPrivateNetwork(true)
      .build();

    ManagedWebAccessor accessor = new ManagedWebAccessor(Arrays.asList("fhir"), DUMMY_AGENT, new ServerDetailsPOJOHTTPAuthProvider(List.of(serverPojo)));

    // ManagedWebAccessor's client uses DEFAULT_RETRIES (1), so the interceptor makes one extra
    // attempt: two 401s before our retry logic sees it, then 200.
    server.enqueue(new MockResponse()
      .setBody("Unauthorized").setResponseCode(401));
    server.enqueue(new MockResponse()
      .setBody("Unauthorized").setResponseCode(401));
    server.enqueue(new MockResponse()
      .setBody("Success").setResponseCode(200));

    HTTPResult result = accessor.post(server.url("blah").toString(), "{}".getBytes(StandardCharsets.UTF_8), "application/json");

    assertThat(result.getCode()).isEqualTo(200);
    assertThat(result.getContentAsString()).isEqualTo("Success");

    // Two token fetches (cache invalidated, fresh token fetched)
    assertThat(tokenServer.getRequestCount()).isEqualTo(2);

    RecordedRequest firstRequest = server.takeRequest();
    assertThat(firstRequest.getHeader("Authorization")).isEqualTo("Bearer expired-token");
    RecordedRequest retryByInterceptor = server.takeRequest();
    assertThat(retryByInterceptor.getHeader("Authorization")).isEqualTo("Bearer expired-token");
    RecordedRequest retryRequest = server.takeRequest();
    assertThat(retryRequest.getHeader("Authorization")).isEqualTo("Bearer fresh-token");
  }

  @Test
  void testNonClientCredentialsAuthDoesNotRetry() throws Exception {
    ServerDetailsPOJO serverPojo = ServerDetailsPOJO.builder()
      .url(server.url("").toString())
      .authenticationType("token")
      .type("fhir")
      .token(DUMMY_TOKEN)
      .allowHttp(true)
      .allowPrivateNetwork(true)
      .build();

    ManagedWebAccessor accessor = new ManagedWebAccessor(Arrays.asList("fhir"), DUMMY_AGENT, new ServerDetailsPOJOHTTPAuthProvider(List.of(serverPojo)));

    // The RetryInterceptor still makes its one default attempt, but no client_credentials token
    // refresh happens for non-cc auth, so the 401 is returned after exactly those two attempts.
    server.enqueue(new MockResponse()
      .setBody("Unauthorized").setResponseCode(401));
    server.enqueue(new MockResponse()
      .setBody("Unauthorized").setResponseCode(401));

    int requestsBefore = server.getRequestCount();

    HTTPResult result = accessor.get(server.url("blah").toString(), "application/json");

    assertThat(result.getCode()).isEqualTo(401);
    assertThat(server.getRequestCount() - requestsBefore).isEqualTo(2);
    assertThat(server.takeRequest().getHeader("Authorization")).isEqualTo("Bearer " + DUMMY_TOKEN);
    assertThat(server.takeRequest().getHeader("Authorization")).isEqualTo("Bearer " + DUMMY_TOKEN);
  }

  @Test
  public void verifyAllowedPaths() {
    assertDoesNotThrow(() -> {
      //TODO the allowed paths cannot be set for now, meaning all will be allowed.
      ManagedWebAccess.inAllowedPaths("http://www.anywhere.com");
    });
  }
}