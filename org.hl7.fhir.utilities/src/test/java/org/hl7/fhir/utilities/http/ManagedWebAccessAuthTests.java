package org.hl7.fhir.utilities.http;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.apache.commons.net.util.Base64;
import org.hl7.fhir.utilities.settings.FhirSettingsPOJO;
import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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

  @BeforeAll
  static void beforeAll() throws IOException {
    server = new MockWebServer();
    server.start();

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
    return new ServerDetailsPOJO(
      server.url("").toString(),
      "basic",
      "fhir",
      DUMMY_USERNAME,
      DUMMY_PASSWORD,
      null, null, true, true, null);
  }

@Test
public void testTokenAuthFromSettings() throws IOException, InterruptedException {
  ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor(
    "dummyAgent",
    new ServerDetailsPOJOHTTPAuthProvider(List.of(getTokenAuthServerPojo())));

  testTokenAuthCase(builder);
}

  private ServerDetailsPOJO getTokenAuthServerPojo() {
    return new ServerDetailsPOJO(
      server.url("").toString(),
      "token",
      "fhir",
     null,
      null,
      DUMMY_TOKEN, null, true, true, null);
  }

  @Test
  public void testApiKeyAuthFromSettings() throws IOException, InterruptedException {
    ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor(
      "dummyAgent",
      new ServerDetailsPOJOHTTPAuthProvider(List.of(getApiKeyAuthServerPojo())));

    testApiKeyAuthCase(builder);
  }

  private ServerDetailsPOJO getApiKeyAuthServerPojo() {
    return new ServerDetailsPOJO(
      server.url("").toString(),
      "apikey",
      "fhir",
      null,
      null,
     null, DUMMY_API_KEY, true, true, null);
  }

  @Test
  public void verifyAllowedPaths() {
    assertDoesNotThrow(() -> {
      //TODO the allowed paths cannot be set for now, meaning all will be allowed.
      ManagedWebAccess.inAllowedPaths("http://www.anywhere.com");
    });
  }
}