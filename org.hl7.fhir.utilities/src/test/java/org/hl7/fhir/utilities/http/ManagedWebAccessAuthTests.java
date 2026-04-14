package org.hl7.fhir.utilities.http;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.apache.commons.net.util.Base64;
import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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
  private MockWebServer server;

  @BeforeEach
  void setup() {
    setupMockServer();
  }

  void setupMockServer() {
    server = new MockWebServer();
  }

  @Test
  void testBaseCase() throws IOException, InterruptedException {
    HttpUrl serverUrl = server.url(PATH_ON_MOCK_SERVER);

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
  void testBasicAuthCase() throws IOException, InterruptedException {
    IHTTPAuthenticationProvider authenticationProvider = Mockito.mock(IHTTPAuthenticationProvider.class);

    URL url = server.url(PATH_ON_MOCK_SERVER).url();
    doReturn(true).when(authenticationProvider).canProvideHeaders(url);
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
    doReturn(true).when(authenticationProvider).canProvideHeaders(url);
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
    doReturn(true).when(authenticationProvider).canProvideHeaders(url);
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
      null, null, null, null);
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
      DUMMY_TOKEN, null, null, null);
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
     null, DUMMY_API_KEY, null, null);
  }

  @Test
  public void verifyAllowedPaths() {
    assertDoesNotThrow(() -> {
      //TODO the allowed paths cannot be set for now, meaning all will be allowed.
      ManagedWebAccess.inAllowedPaths("http://www.anywhere.com");
    });
  }
}