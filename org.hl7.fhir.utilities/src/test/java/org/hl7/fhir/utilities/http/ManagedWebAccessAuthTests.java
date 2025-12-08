package org.hl7.fhir.utilities.http;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.apache.commons.net.util.Base64;
import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
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

  @BeforeEach
  void setup() {
    setupMockServer();
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
    return new ServerDetailsPOJO(
      server.url("").toString(),
      "basic",
      "fhir",
      DUMMY_USERNAME,
      DUMMY_PASSWORD,
      null, null, null);
  }

@Test
public void testTokenAuthFromSettings() throws IOException, InterruptedException {
  ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor(
    "dummyAgent",
    List.of(getTokenAuthServerPojo()));

  testTokenAuthCase(builder);
}

  private ServerDetailsPOJO getTokenAuthServerPojo() {
    return new ServerDetailsPOJO(
      server.url("").toString(),
      "token",
      "fhir",
     null,
      null,
      DUMMY_TOKEN, null, null);
  }

  @Test
  public void testApiKeyAuthFromSettings() throws IOException, InterruptedException {
    ManagedFhirWebAccessor builder = new ManagedFhirWebAccessor(
      "dummyAgent",
      List.of(getApiKeyAuthServerPojo()));

    testApiKeyAuthCase(builder);
  }

  private ServerDetailsPOJO getApiKeyAuthServerPojo() {
    return new ServerDetailsPOJO(
      server.url("").toString(),
      "apikey",
      "fhir",
      null,
      null,
     null, DUMMY_API_KEY, null);
  }

  @Test
  public void verifyAllowedPaths() {
    assertDoesNotThrow(() -> {
      //TODO the allowed paths cannot be set for now, meaning all will be allowed.
      ManagedWebAccess.inAllowedPaths("http://www.anywhere.com");
    });
  }
}