package org.hl7.fhir.utilities.http;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.apache.commons.net.util.Base64;
import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ManagedWebAccessAuthTests {

  public static final String DUMMY_AGENT = "dummyAgent";
  public static final String DUMMY_USERNAME = "dummy1";
  public static final String DUMMY_PASSWORD = "pass1";

  public static final String DUMMY_TOKEN = "dummyToken";
  private static final String DUMMY_API_KEY = "dummyApiKey";
  private MockWebServer server;
  private MockWebServer tokenServer;

  @BeforeEach
  void setup() {
    setupMockServer();
    HTTPTokenManager.clearCache();
  }

  @AfterEach
  void tearDown() throws IOException {
    HTTPTokenManager.clearCache();
    if (tokenServer != null) {
      tokenServer.shutdown();
    }
  }

  void setupMockServer() {
    server = new MockWebServer();
  }

  @Test
  public void testBaseCase() throws IOException, InterruptedException {
    HttpUrl serverUrl = server.url("blah/blah/blah?arg=blah");

    server.enqueue(
      new MockResponse()
        .setBody("Dummy Response").setResponseCode(200)
    );

    ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor("dummyAgent", null);
    HTTPResult result = builder.httpCall(new HTTPRequest().withUrl(serverUrl.toString()).withMethod(HTTPRequest.HttpMethod.GET));

    assertThat(result.getCode()).isEqualTo(200);
    assertThat(result.getContentAsString()).isEqualTo("Dummy Response");

    RecordedRequest packageRequest = server.takeRequest();

    assert packageRequest.getRequestUrl() != null;
    assertExpectedHeaders(packageRequest, serverUrl.url().toString(), "GET");

  }


  @Test
  public void testBasicAuthCase() throws IOException, InterruptedException {

    ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor("dummyAgent", null).withBasicAuth("dummy1", "pass1");

    testBasicServerAuth(builder);
  }

  private void testBasicServerAuth(ManagedFhirWebAccessor builder) throws IOException, InterruptedException {
    HttpUrl serverUrl = server.url("blah/blah/blah?arg=blah");

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

    byte[] b = Base64.encodeBase64((DUMMY_USERNAME + ":" + DUMMY_PASSWORD).getBytes(StandardCharsets.US_ASCII));
    String b64 = new String(b, StandardCharsets.US_ASCII);

    assertThat(packageRequest.getHeader("Authorization")).isEqualTo("Basic " + b64);
  }

  @Test
  public void testTokenAuthCase() throws IOException, InterruptedException {


    ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor("dummyAgent", null).withToken(DUMMY_TOKEN);

    testTokenAuthCase(builder);
  }

  private void testTokenAuthCase(ManagedFhirWebAccessor builder) throws IOException, InterruptedException {
    HttpUrl serverUrl = server.url("blah/blah/blah?arg=blah");

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

    ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor("dummyAgent", null).withApiKey(DUMMY_API_KEY);

    testApiKeyAuthCase(builder);
  }

  private void testApiKeyAuthCase(ManagedFhirWebAccessor builder) throws IOException, InterruptedException {
    HttpUrl serverUrl = server.url("blah/blah/blah?arg=blah");

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
  public void testBasicAuthFromSettings() throws IOException, InterruptedException {
    ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor(
      "dummyAgent",
      List.of(getBasicAuthServerPojo()));

    testBasicServerAuth(builder);
  }

  private ServerDetailsPOJO getBasicAuthServerPojo() {
    return ServerDetailsPOJO.builder()
      .url(server.url("").toString())
      .authenticationType("basic")
      .type("fhir")
      .username(DUMMY_USERNAME)
      .password(DUMMY_PASSWORD)
      .build();
  }

@Test
public void testTokenAuthFromSettings() throws IOException, InterruptedException {
  ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor(
    "dummyAgent",
    List.of(getTokenAuthServerPojo()));

  testTokenAuthCase(builder);
}

  private ServerDetailsPOJO getTokenAuthServerPojo() {
    return ServerDetailsPOJO.builder()
      .url(server.url("").toString())
      .authenticationType("token")
      .type("fhir")
      .token(DUMMY_TOKEN)
      .build();
  }

  @Test
  public void testApiKeyAuthFromSettings() throws IOException, InterruptedException {
    ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor(
      "dummyAgent",
      List.of(getApiKeyAuthServerPojo()));

    testApiKeyAuthCase(builder);
  }

  private ServerDetailsPOJO getApiKeyAuthServerPojo() {
    return ServerDetailsPOJO.builder()
      .url(server.url("").toString())
      .authenticationType("apikey")
      .type("fhir")
      .apikey(DUMMY_API_KEY)
      .build();
  }

  @Test
  public void testClientCredentialsAuthFromSettings() throws Exception {
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
      .build();

    ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor(DUMMY_AGENT, List.of(serverPojo));

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
  public void testClientCredentials401Retry() throws Exception {
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
      .build();

    ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor(DUMMY_AGENT, List.of(serverPojo));

    HttpUrl serverUrl = server.url("blah/blah/blah?arg=blah");

    // OkHttp RetryInterceptor retries once on non-successful responses,
    // so we need two 401s to ensure our code sees the 401 after the interceptor exhausts its retry.
    server.enqueue(new MockResponse()
      .setBody("Unauthorized").setResponseCode(401));
    server.enqueue(new MockResponse()
      .setBody("Unauthorized").setResponseCode(401));

    // After token invalidation and re-fetch, the fresh token request succeeds
    server.enqueue(new MockResponse()
      .setBody("Success").setResponseCode(200));

    HTTPResult result = builder.httpCall(new HTTPRequest().withUrl(serverUrl.toString()).withMethod(HTTPRequest.HttpMethod.GET));

    assertThat(result.getCode()).isEqualTo(200);
    assertThat(result.getContentAsString()).isEqualTo("Success");

    // First two requests used expired token (original + OkHttp retry)
    RecordedRequest firstRequest = server.takeRequest();
    assertThat(firstRequest.getHeader("Authorization")).isEqualTo("Bearer expired-token");
    RecordedRequest retryByInterceptor = server.takeRequest();
    assertThat(retryByInterceptor.getHeader("Authorization")).isEqualTo("Bearer expired-token");

    // Third request used fresh token after invalidation
    RecordedRequest retryRequest = server.takeRequest();
    assertThat(retryRequest.getHeader("Authorization")).isEqualTo("Bearer fresh-token");
  }

  @Test
  public void testClientCredentialsProgrammaticApi() throws Exception {
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
      .build();

    // Use the programmatic .withClientCredentials() API instead of settings-based lookup
    ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor(DUMMY_AGENT, null)
      .withClientCredentials(serverPojo);

    HttpUrl serverUrl = server.url("blah/blah/blah?arg=blah");
    server.enqueue(new MockResponse()
      .setBody("Dummy Response").setResponseCode(200));

    HTTPResult result = builder.httpCall(new HTTPRequest().withUrl(serverUrl.toString()).withMethod(HTTPRequest.HttpMethod.GET));

    assertThat(result.getCode()).isEqualTo(200);

    RecordedRequest fhirRequest = server.takeRequest();
    assertThat(fhirRequest.getHeader("Authorization")).isEqualTo("Bearer programmatic-token");
  }

  @Test
  public void testClientCredentialsProgrammaticApiOnManagedWebAccessor() throws Exception {
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
      .build();

    ManagedWebAccessor accessor = new ManagedWebAccessor(Arrays.asList("fhir"), DUMMY_AGENT, null)
      .withClientCredentials(serverPojo);

    server.enqueue(new MockResponse()
      .setBody("Dummy Response").setResponseCode(200));

    HTTPResult result = accessor.get(server.url("blah").toString(), "application/json");

    assertThat(result.getCode()).isEqualTo(200);

    RecordedRequest webRequest = server.takeRequest();
    assertThat(webRequest.getHeader("Authorization")).isEqualTo("Bearer web-programmatic-token");
  }

  @Test
  public void testManagedWebAccessorRetryOn401() throws Exception {
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
      .build();

    ManagedWebAccessor accessor = new ManagedWebAccessor(Arrays.asList("fhir"), DUMMY_AGENT, List.of(serverPojo));

    // SimpleHTTPClient does not have a retry interceptor, so one 401 is enough
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

    // First request used expired token, second used fresh token
    RecordedRequest firstRequest = server.takeRequest();
    assertThat(firstRequest.getHeader("Authorization")).isEqualTo("Bearer expired-token");
    RecordedRequest retryRequest = server.takeRequest();
    assertThat(retryRequest.getHeader("Authorization")).isEqualTo("Bearer fresh-token");
  }

  @Test
  public void testManagedWebAccessorRetryOn403() throws Exception {
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
      .build();

    ManagedWebAccessor accessor = new ManagedWebAccessor(Arrays.asList("fhir"), DUMMY_AGENT, List.of(serverPojo));

    server.enqueue(new MockResponse()
      .setBody("Forbidden").setResponseCode(403));
    server.enqueue(new MockResponse()
      .setBody("Success").setResponseCode(200));

    HTTPResult result = accessor.get(server.url("blah").toString(), "application/json");

    assertThat(result.getCode()).isEqualTo(200);

    RecordedRequest retryRequest = server.takeRequest();
    assertThat(retryRequest.getHeader("Authorization")).isEqualTo("Bearer old-token");
    RecordedRequest finalRequest = server.takeRequest();
    assertThat(finalRequest.getHeader("Authorization")).isEqualTo("Bearer new-token");
  }

  @Test
  public void verifyAllowedPaths() {
    assertDoesNotThrow(() -> {
      //TODO the allowed paths cannot be set for now, meaning all will be allowed.
      ManagedWebAccess.inAllowedPaths("http://www.anywhere.com");
    });
  }
}