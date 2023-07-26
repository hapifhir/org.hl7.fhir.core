package org.hl7.fhir.r4b.utils.client.network;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.hl7.fhir.r4b.context.HTMLClientLogger;
import org.hl7.fhir.r4b.formats.JsonParser;
import org.hl7.fhir.r4b.model.*;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ClientTest {

  private static final long TIMEOUT = 5000;

  private MockWebServer server;
  private HttpUrl serverUrl;
  private Client client;

  private final Address address = new Address().setCity("Toronto").setState("Ontario").setCountry("Canada");
  private final HumanName humanName = new HumanName().addGiven("Mark").setFamily("Iantorno");
  private final Patient patient = new Patient().addName(humanName).addAddress(address)
      .setGender(Enumerations.AdministrativeGender.MALE);

  @BeforeEach
  void setup() {
    setupMockServer();
    client = new Client();
  }

  void setupMockServer() {
    server = new MockWebServer();
    serverUrl = server.url("/v1/endpoint");
  }

  byte[] generateResourceBytes(Resource resource) throws IOException {
    return new JsonParser().composeBytes(resource);
  }

  @Test
  @DisplayName("GET request, happy path.")
  void test_get_happy_path() throws IOException, URISyntaxException {
    server.enqueue(new MockResponse().setBody(new String(generateResourceBytes(patient))));
    ResourceRequest<Resource> resourceRequest = client.issueGetResourceRequest(new URI(serverUrl.toString()), "json",
        null, null, TIMEOUT);
    Assertions.assertTrue(resourceRequest.isSuccessfulRequest());
    Assertions.assertTrue(patient.equalsDeep(resourceRequest.getPayload()),
        "GET request returned resource does not match expected.");
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
    client.setRetryCount(failedAttempts + 1);

    ResourceRequest<Resource> resourceRequest = client.issueGetResourceRequest(new URI(serverUrl.toString()), "json",
        null, null, TIMEOUT);
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
    client.setRetryCount(failedAttempts + 1);

    ResourceRequest<Resource> resourceRequest = client.issueGetResourceRequest(new URI(serverUrl.toString()), "json",
        null, null, TIMEOUT);
    Assertions.assertTrue(resourceRequest.isSuccessfulRequest());
    Assertions.assertTrue(patient.equalsDeep(resourceRequest.getPayload()),
        "GET request returned resource does not match expected.");
  }

  @Test
  @DisplayName("PUT request, test payload received by server matches sent.")
  void test_put() throws IOException, URISyntaxException, InterruptedException {
    byte[] payload = ByteUtils.resourceToByteArray(patient, true, false);
    // Mock server response of 200, with the same resource payload returned that we
    // included in the PUT request
    server.enqueue(new MockResponse().setResponseCode(200).setBody(new String(payload)));

    ResourceRequest<Resource> request = client.issuePutRequest(new URI(serverUrl.toString()), payload, "xml", null,
        TIMEOUT);
    RecordedRequest recordedRequest = server.takeRequest();
    Assertions.assertArrayEquals(payload, recordedRequest.getBody().readByteArray(),
        "PUT request payload does not match send data.");
  }

  @Test
  @DisplayName("POST request, test payload received by server matches sent.")
  void test_post() throws IOException, URISyntaxException, InterruptedException {
    byte[] payload = ByteUtils.resourceToByteArray(patient, true, false);
    // Mock server response of 200, with the same resource payload returned that we
    // included in the PUT request
    server.enqueue(new MockResponse().setResponseCode(200).setBody(new String(payload)));

    ResourceRequest<Resource> request = client.issuePostRequest(new URI(serverUrl.toString()), payload, "xml", null,
        TIMEOUT);
    RecordedRequest recordedRequest = server.takeRequest();
    Assertions.assertArrayEquals(payload, recordedRequest.getBody().readByteArray(),
        "POST request payload does not match send data.");
  }

  @Test
  @DisplayName("Testing the logger works.")
  void test_logger() throws IOException, URISyntaxException, InterruptedException {
    byte[] payload = ByteUtils.resourceToByteArray(patient, true, false);
    server.enqueue(new MockResponse().setResponseCode(200).setBody(new String(payload)));
    HTMLClientLogger mockLogger = Mockito.mock(HTMLClientLogger.class);
    client.setLogger(mockLogger);
    client.issuePostRequest(new URI(serverUrl.toString()), payload, "xml", null, TIMEOUT);
    server.takeRequest();
    Mockito.verify(mockLogger, Mockito.times(1)).logRequest(Mockito.anyString(), Mockito.anyString(), Mockito.anyList(),
        Mockito.any());
    Mockito.verify(mockLogger, Mockito.times(1)).logResponse(Mockito.anyString(), Mockito.anyList(), Mockito.any());
  }
}