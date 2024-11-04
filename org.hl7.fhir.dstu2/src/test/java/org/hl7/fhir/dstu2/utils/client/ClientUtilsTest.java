package org.hl7.fhir.dstu2.utils.client;


import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.hl7.fhir.dstu2.formats.JsonParser;
import org.hl7.fhir.dstu2.model.*;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.http.HTTPHeader;
import org.hl7.fhir.utilities.http.HTTPHeaderUtil;
import org.hl7.fhir.utilities.http.HTTPRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ClientUtilsTest {

  public static final String DUMMY_LOCATION = "http://myhost/Patient/1";
  public static final int TIMEOUT = 5000;
  private MockWebServer server;
  private HttpUrl serverUrl;
  private ClientUtils clientUtils;

  private final Address address = new Address()
    .setCity("Toronto")
    .setState("Ontario")
    .setCountry("Canada");
  private final HumanName humanName = new HumanName()
    .addGiven("Mark")
    .addFamily("Iantorno");
  private final Patient patient = new Patient()
    .addName(humanName)
    .addAddress(address)
    .setGender(Enumerations.AdministrativeGender.MALE);

  @BeforeEach
  void setup() {
    setupMockServer();
    clientUtils = new ClientUtils();
  }

  void setupMockServer() {
    server = new MockWebServer();
    serverUrl = server.url("/v1/endpoint");
  }

  @Test
  @DisplayName("Test resource format headers are added correctly.")
  void addResourceFormatHeadersGET() {
    /* FIXME restore this after refactor
    String testFormat = "yaml";
    HTTPRequest request = new HTTPRequest().withUrl("http://www.google.com").withMethod(HTTPRequest.HttpMethod.GET);

    Iterable<HTTPHeader> headers = FhirRequestBuilder.getResourceFormatHeaders(request, testFormat);

    Map<String, List<String>> headersMap = HTTPHeaderUtil.getMultimap(headers);
    Assertions.assertNotNull(headersMap.get("Accept"), "Accept header null.");
    Assertions.assertEquals(testFormat, headersMap.get("Accept").get(0),
      "Accept header not populated with expected value " + testFormat + ".");

    Assertions.assertNull(headersMap.get("Content-Type"), "Content-Type header null.");

     */
  }

  @Test
  @DisplayName("Test resource format headers are added correctly (POST).")
  void addResourceFormatHeadersPOST() {
   /*FIXME restore this after refactor
    String testFormat = "yaml";
    HTTPRequest request = new HTTPRequest().withUrl("http://www.google.com").withMethod(HTTPRequest.HttpMethod.POST);

    Iterable<HTTPHeader> headers = FhirRequestBuilder.getResourceFormatHeaders(request, testFormat);

    Map<String, List<String>> headersMap = HTTPHeaderUtil.getMultimap(headers);
    Assertions.assertNotNull(headersMap.get("Accept"), "Accept header null.");
    Assertions.assertEquals(testFormat, headersMap.get("Accept").get(0),
      "Accept header not populated with expected value " + testFormat + ".");

    Assertions.assertNotNull(headersMap.get("Content-Type"), "Content-Type header null.");
    Assertions.assertEquals(testFormat + ";charset=" + FhirRequestBuilder.DEFAULT_CHARSET, headersMap.get("Content-Type").get(0),
      "Content-Type header not populated with expected value \"" + testFormat + ";charset=" + FhirRequestBuilder.DEFAULT_CHARSET + "\".");

    */
  }

  @Test
  public void testResourceFormatHeaders_GET() throws IOException, InterruptedException {
    server.enqueue(
      new MockResponse()
        .setBody(new String(generateResourceBytes(patient)))
        .addHeader("Content-Type", ResourceFormat.RESOURCE_JSON)
    );
    ResourceRequest<Patient> resourceRequest = clientUtils.issueGetResourceRequest(serverUrl.uri(), "application/json+fhir",  TIMEOUT);
    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getHeader("Accept")).isEqualTo("application/json+fhir");
  }

  @Test
  public void testResourceFormatHeaders_POST() throws IOException, InterruptedException {
    byte[] payload = generateResourceBytes(patient);
    server.enqueue(
      new MockResponse()
        .setBody(new String(payload))
        .addHeader("Content-Type", "application/json+fhir")
        .setResponseCode(201)
    );
    ResourceRequest<Patient> resourceRequest = clientUtils.issuePostRequest(serverUrl.uri(), payload, "application/json+fhir",  TIMEOUT);
    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getHeader("Accept")).isEqualTo("application/json+fhir");
  }

  @Test
  public void testResourceRequest() {
    ResourceRequest<Patient> request = new ResourceRequest<>(new Patient(), 200, "location");
    request.addSuccessStatus(200);
    assertTrue(request.getPayload().equalsDeep(new Patient()));
    assertThat(request.getHttpStatus()).isEqualTo(200);
    assertThat(request.getLocation()).isEqualTo("location");
    assertTrue(request.isSuccessfulRequest());
    assertFalse(request.isUnsuccessfulRequest());
  }

  @Test
  public void testIssueGetResourceRequest() throws IOException {
    server.enqueue(
      new MockResponse()
        .setBody(new String(generateResourceBytes(patient)))
        .addHeader("Content-Type", "application/json+fhir")
        .addHeader("Location", DUMMY_LOCATION)
    );
    ResourceRequest<Patient> resourceRequest = clientUtils.issueGetResourceRequest(serverUrl.uri(), "application/json+fhir",  TIMEOUT);
    resourceRequest.addSuccessStatus(200);
    assertThat(resourceRequest.getLocation()).isEqualTo(DUMMY_LOCATION);
    assertTrue(resourceRequest.isSuccessfulRequest());
    assertTrue(patient.equalsDeep(resourceRequest.getPayload()));
  }

  @Test
  void testIssueGetResourceRequest_withContentLocation() throws IOException {
    server.enqueue(
      new MockResponse()
        .setBody(new String(generateResourceBytes(patient)))
        .addHeader("Content-Type", "application/json+fhir")
        .addHeader("Content-Location", DUMMY_LOCATION)
    );
    ResourceRequest<Patient> resourceRequest = clientUtils.issueGetResourceRequest(serverUrl.uri(), "application/json+fhir",  TIMEOUT);

    assertThat(resourceRequest.getLocation()).isEqualTo(DUMMY_LOCATION);
  }

  @Test
  @DisplayName("Test that getLocationHeader returns 'location' header when both 'location' and 'content-location' are set.")
  void testIssueGetResourceRequest_ReturnsLocationHeaderWhenBothSet() throws IOException {
    server.enqueue(
      new MockResponse()
        .setBody(new String(generateResourceBytes(patient)))
        .addHeader("Content-Type", "application/json+fhir")
        .addHeader("Location", DUMMY_LOCATION)
        .addHeader("Content-Location", "Wrong wrong wrong")
    );
    ResourceRequest<Patient> resourceRequest = clientUtils.issueGetResourceRequest(serverUrl.uri(), "application/json+fhir",  TIMEOUT);
    assertThat(resourceRequest.getLocation()).isEqualTo(DUMMY_LOCATION);
  }

  @Test
  @DisplayName("Test that getLocationHeader returns 'null' header when neither 'location' or 'content-location' are set.")
  void testIssueGetResourceRequest_ReturnsNullWhenNoHeadersSet() throws IOException {
    server.enqueue(
      new MockResponse()
        .setBody(new String(generateResourceBytes(patient)))
        .addHeader("Content-Type", "application/json+fhir")
    );
    ResourceRequest<Patient> resourceRequest = clientUtils.issueGetResourceRequest(serverUrl.uri(), "application/json+fhir",  TIMEOUT);
    assertThat(resourceRequest.getLocation()).isNull();
  }

  @Test
  public void testIssuePostRequest() throws IOException, InterruptedException {
    byte[] payload = generateResourceBytes(patient);
    server.enqueue(
      new MockResponse()
        .setBody(new String(payload))
        .addHeader("Content-Type", "application/json+fhir")
        .addHeader("Location", DUMMY_LOCATION)
        .setResponseCode(201)
    );
    ResourceRequest<Patient> resourceRequest = clientUtils.issuePostRequest(serverUrl.uri(), payload, "application/json+fhir", TIMEOUT);
    resourceRequest.addSuccessStatus(201);

    RecordedRequest recordedRequest = server.takeRequest();
    assertArrayEquals(payload, recordedRequest.getBody().readByteArray(),
      "PUT request payload does not match send data.");
    assertThat(resourceRequest.getLocation()).isEqualTo(DUMMY_LOCATION);
    assertTrue(resourceRequest.isSuccessfulRequest());
    assertTrue(patient.equalsDeep(resourceRequest.getPayload()));
  }

  @Test
  public void testIssuePutRequest() throws IOException, InterruptedException {
    byte[] payload = generateResourceBytes(patient);
    server.enqueue(
      new MockResponse()
        .setBody(new String(payload))
        .addHeader("Content-Type", "application/json+fhir")
        .addHeader("Location", DUMMY_LOCATION)
        .setResponseCode(200)
    );
    ResourceRequest<Patient> resourceRequest = clientUtils.issuePutRequest(serverUrl.uri(), payload, "application/json+fhir", TIMEOUT);
    resourceRequest.addSuccessStatus(200);
    RecordedRequest recordedRequest = server.takeRequest();
    assertArrayEquals(payload, recordedRequest.getBody().readByteArray(),
      "PUT request payload does not match send data.");

    assertThat(resourceRequest.getLocation()).isEqualTo(DUMMY_LOCATION);
    assertTrue(resourceRequest.isSuccessfulRequest());
    assertTrue(patient.equalsDeep(resourceRequest.getPayload()));
  }

  @Test
  public void testIssueDeleteRequest() throws IOException {
    server.enqueue(
      new MockResponse().addHeader("Location", DUMMY_LOCATION).setResponseCode(204)
    );
    boolean success = clientUtils.issueDeleteRequest(serverUrl.uri());
    assertTrue(success);
  }

  @Test
  public void testIssueDeleteRequest_fail() throws IOException, InterruptedException {
    server.enqueue(
      new MockResponse().addHeader("Location", DUMMY_LOCATION).setResponseCode(500)
    );
    boolean success = clientUtils.issueDeleteRequest(serverUrl.uri());
    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getMethod()).isEqualTo("DELETE");
    assertThat(recordedRequest.getRequestUrl().uri()).isEqualTo(serverUrl.uri());
    assertFalse(success);
  }

  @Test
  @DisplayName("test logger works")
  public void testLogger() throws IOException, InterruptedException {
    byte[] payload = generateResourceBytes(patient);
    server.enqueue(
      new MockResponse()
        .setResponseCode(200)
        .setBody(new String(payload))
    );
    ToolingClientLogger mockLogger = Mockito.mock(ToolingClientLogger.class);
    clientUtils.setLogger(mockLogger);
    clientUtils.issuePostRequest(serverUrl.uri(), payload, "application/json+fhir"
      , null, TIMEOUT);
    server.takeRequest();
    Mockito.verify(mockLogger, Mockito.times(1))
      .logRequest(Mockito.anyString(), Mockito.anyString(), Mockito.anyList(), Mockito.any());
    Mockito.verify(mockLogger, Mockito.times(1))
      .logResponse(Mockito.anyString(), Mockito.anyList(), Mockito.any(), Mockito.anyLong());
  }

  @Test
  @DisplayName("Test that FATAL issue severity triggers error.")
  void hasErrorTestFatal() {
    OperationOutcome outcome = new OperationOutcome();
    outcome.addIssue(new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.INFORMATION));
    outcome.addIssue(new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.NULL));
    outcome.addIssue(new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.WARNING));
    outcome.addIssue(new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.FATAL));
    Assertions.assertTrue(clientUtils.hasError(outcome), "Error check not triggered for FATAL issue severity.");
  }

  @Test
  @DisplayName("Test that ERROR issue severity triggers error.")
  void hasErrorTestError() {
    OperationOutcome outcome = new OperationOutcome();
    outcome.addIssue(new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.INFORMATION));
    outcome.addIssue(new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.NULL));
    outcome.addIssue(new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.WARNING));
    outcome.addIssue(new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.ERROR));
    Assertions.assertTrue(clientUtils.hasError(outcome), "Error check not triggered for ERROR issue severity.");
  }

  @Test
  @DisplayName("Test that no FATAL or ERROR issue severity does not trigger error.")
  void hasErrorTestNoErrors() {
    OperationOutcome outcome = new OperationOutcome();
    outcome.addIssue(new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.INFORMATION));
    outcome.addIssue(new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.NULL));
    outcome.addIssue(new OperationOutcome.OperationOutcomeIssueComponent().setSeverity(OperationOutcome.IssueSeverity.WARNING));
    Assertions.assertFalse(clientUtils.hasError(outcome), "Error check triggered unexpectedly.");
  }

  @Test
  @DisplayName("GET request, test client retries after timeout failure.")
  void test_get_retries_with_timeout() throws IOException, URISyntaxException {
    int failedAttempts = new Random().nextInt(5) + 1;
    System.out.println("Simulating <" + failedAttempts + "> failed connections (timeouts) before success.");
    for (int i = 0; i < failedAttempts; i++) {
      server.enqueue(new MockResponse().setHeadersDelay(TIMEOUT * 10, TimeUnit.MILLISECONDS)
        .setBody(new String(generateResourceBytes(patient))));
    }
    server.enqueue(new MockResponse().setBody(new String(generateResourceBytes(patient))));
    clientUtils.setRetryCount(failedAttempts + 1);

    ResourceRequest<Resource> resourceRequest = clientUtils.issueGetResourceRequest(serverUrl.uri(), "application/json+fhir"
      , TIMEOUT);
    resourceRequest.addSuccessStatus(200);
    Assertions.assertTrue(resourceRequest.isSuccessfulRequest());
    Assertions.assertTrue(patient.equalsDeep(resourceRequest.getPayload()),
      "GET request returned resource does not match expected.");
  }

  @Test
  @DisplayName("GET request, test client retries after bad response.")
  void test_get_retries_with_unsuccessful_response() throws IOException, URISyntaxException {
    int failedAttempts = new Random().nextInt(5) + 1;
    System.out.println("Simulating <" + failedAttempts + "> failed connections (bad response codes) before success.");
    for (int i = 0; i < failedAttempts; i++) {
      server.enqueue(new MockResponse().setResponseCode(400 + i).setBody(new String(generateResourceBytes(patient))));
    }
    server.enqueue(new MockResponse().setBody(new String(generateResourceBytes(patient))));
    clientUtils.setRetryCount(failedAttempts + 1);

    ResourceRequest<Resource> resourceRequest = clientUtils.issueGetResourceRequest(serverUrl.uri(), "application/json+fhir", TIMEOUT);
    resourceRequest.addSuccessStatus(200);
    Assertions.assertTrue(resourceRequest.isSuccessfulRequest());
    Assertions.assertTrue(patient.equalsDeep(resourceRequest.getPayload()),
      "GET request returned resource does not match expected.");
  }


  byte[] generateResourceBytes(Resource resource) throws IOException {
    return new JsonParser().composeBytes(resource);
  }
}
