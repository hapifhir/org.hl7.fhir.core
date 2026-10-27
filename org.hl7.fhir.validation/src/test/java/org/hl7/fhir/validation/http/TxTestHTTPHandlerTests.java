package org.hl7.fhir.validation.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.validation.ValidationEngine;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * The requests the /txTest endpoints refuse before loading any tests or connecting to any server.
 */
class TxTestHTTPHandlerTests {

  private static final int PORT = 18093;
  private static final int NETWORK_PORT = 18094;
  private static final int DISABLED_PORT = 18095;
  private FhirValidatorHttpService service;
  private final HttpClient client = HttpClient.newHttpClient();

  @BeforeEach
  void start() throws IOException {
    ValidationEngine engine = mock(ValidationEngine.class);
    SimpleWorkerContext context = mock(SimpleWorkerContext.class);
    when(context.getModelContext()).thenReturn(ModelContext.fullCoreContext());
    when(engine.getContext()).thenReturn(context);
    service = new FhirValidatorHttpService(engine, true, true, PORT);
    service.startServer();
  }

  @AfterEach
  void stop() {
    service.stop();
  }

  private HttpResponse<String> send(String method, String path, String body) throws IOException, InterruptedException {
    HttpRequest.Builder b = HttpRequest.newBuilder(URI.create("http://localhost:" + PORT + path));
    b.method(method, body == null ? HttpRequest.BodyPublishers.noBody() : HttpRequest.BodyPublishers.ofString(body));
    return client.send(b.build(), HttpResponse.BodyHandlers.ofString());
  }

  @ParameterizedTest
  @CsvSource(delimiter = '|', quoteCharacter = '`', value = {
    "POST|/txTest/setup||400|needs a JSON object",
    "POST|/txTest/setup|not json|400|not a JSON object",
    "POST|/txTest/setup|{\"test-version\":\"1.9.6\"}|400|'server'",
    "POST|/txTest/setup|{\"server\":\"http://localhost:1/fhir\",\"mode\":\"general\"}|400|Unknown setup parameter 'mode'",
    "POST|/txTest/setup|{\"server\":\"http://localhost:1/fhir\",\"test-version\":\"../../etc\"}|400|not a path",
    "POST|/txTest/setup|{\"server\":\"http://localhost:1/fhir\",\"externals\":3}|400|'externals'",
    "POST|/txTest/setup|{\"server\":\"http://localhost:1/fhir\",\"folder\":\"a/b\"}|400|'folder'",
    "GET|/txTest?suite=a&test=b||400|'session'",
    "GET|/txTest?test=b&session=x||400|'suite'",
    "GET|/txTest?suite=a&test=b&session=x&server=http://localhost:1||400|fixed for the session",
    "GET|/txTest?suite=a&test=b&session=x&version=4.0||400|the FHIR version is the server's",
    "GET|/txTest?suite=a&test=b&session=x||404|Unknown session 'x'",
    "POST|/txTest/teardown||400|'session'",
    "POST|/txTest/teardown?session=x||404|Unknown session 'x'",
    "POST|/txTest/teardown?session=server:http://localhost:1||404|Unknown session 'server:http://localhost:1'",
    "POST|/txTest/teardown?server=http://localhost:1||404|No tests have been run",
    "GET|/txTest/other||404|Unknown path",
  })
  void refused(String method, String path, String body, int status, String message) throws Exception {
    HttpResponse<String> res = send(method, path, body);
    assertEquals(status, res.statusCode(), res.body());
    assertTrue(res.body().contains(message), res.body());
  }

  @ParameterizedTest
  @CsvSource({ "GET,/txTest/setup", "GET,/txTest/teardown", "POST,/txTest" })
  void wrongMethod(String method, String path) throws Exception {
    assertEquals(405, send(method, path, null).statusCode());
  }

  @ParameterizedTest
  @CsvSource(delimiter = '|', quoteCharacter = '`', value = {
    "POST|/txTest/setup|{\"server\":\"https://not-configured.invalid/fhir\"}",
    "GET|/txTest?suite=a&test=b&server=https://not-configured.invalid/fhir|",
  })
  void networkModeRefusesUnconfiguredServer(String method, String path, String body) throws Exception {
    // no fhir-settings file names this server, so a network-reachable service must refuse it
    // before loading any tests or connecting to it
    FhirValidatorHttpService network = new FhirValidatorHttpService(service.getValidationEngine(), false, true, NETWORK_PORT);
    network.startServer();
    try {
      HttpRequest.Builder b = HttpRequest.newBuilder(URI.create("http://127.0.0.1:" + NETWORK_PORT + path));
      b.method(method, body == null ? HttpRequest.BodyPublishers.noBody() : HttpRequest.BodyPublishers.ofString(body));
      HttpResponse<String> res = client.send(b.build(), HttpResponse.BodyHandlers.ofString());
      assertEquals(403, res.statusCode(), res.body());
      assertTrue(res.body().contains("not configured in fhir-settings"), res.body());
    } finally {
      network.stop();
    }
  }

  @ParameterizedTest
  @CsvSource(delimiter = '|', quoteCharacter = '`', value = {
    "POST|/txTest/setup|{\"server\":\"http://localhost:1/fhir\"}",
    "GET|/txTest?suite=a&test=b&session=x|",
    "POST|/txTest/teardown?session=x|",
  })
  void offUnlessEnabled(String method, String path, String body) throws Exception {
    // the three-argument constructor leaves the tx test endpoints off, as the command line does without -txTests
    FhirValidatorHttpService disabled = new FhirValidatorHttpService(service.getValidationEngine(), true, DISABLED_PORT);
    disabled.startServer();
    try {
      HttpRequest.Builder b = HttpRequest.newBuilder(URI.create("http://localhost:" + DISABLED_PORT + path));
      b.method(method, body == null ? HttpRequest.BodyPublishers.noBody() : HttpRequest.BodyPublishers.ofString(body));
      HttpResponse<String> res = client.send(b.build(), HttpResponse.BodyHandlers.ofString());
      assertEquals(404, res.statusCode(), res.body());
      assertTrue(res.body().contains("-txTests"), res.body());
    } finally {
      disabled.stop();
    }
  }

  @Test
  void defaultModesLeaveOutTxFhirOrg() {
    assertFalse(TxTestHTTPHandler.DEFAULT_MODES.contains("tx.fhir.org"));
    assertTrue(TxTestHTTPHandler.DEFAULT_MODES.contains("general"));
  }
}
