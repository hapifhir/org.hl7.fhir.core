package org.hl7.fhir.validation.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.validation.ValidationEngine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * The -nonce option: the server returns it in a header on every response, so that whoever started
 * it can tell it from anything else answering on the port.
 */
class NonceHeaderTests {

  private static final int PORT = 18096;
  private final HttpClient client = HttpClient.newHttpClient();

  private ValidationEngine engine() {
    ValidationEngine engine = mock(ValidationEngine.class);
    SimpleWorkerContext context = mock(SimpleWorkerContext.class);
    when(context.getModelContext()).thenReturn(ModelContext.fullCoreContext());
    when(engine.getContext()).thenReturn(context);
    return engine;
  }

  private HttpResponse<String> send(String method, String path) throws Exception {
    HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:" + PORT + path))
      .method(method, HttpRequest.BodyPublishers.noBody()).build();
    return client.send(request, HttpResponse.BodyHandlers.ofString());
  }

  @ParameterizedTest
  @ValueSource(strings = { "GET /validateResource", "GET /txTest", "GET /openapi.json", "GET /stop", "GET /nope", "GET /" })
  void everyResponseCarriesTheNonce(String call) throws Exception {
    FhirValidatorHttpService service = new FhirValidatorHttpService(engine(), true, false, PORT, "a1b2-c3.d4_e5");
    service.startServer();
    try {
      String[] parts = call.split(" ");
      HttpResponse<String> res = send(parts[0], parts[1]);
      assertEquals("a1b2-c3.d4_e5", res.headers().firstValue(FhirValidatorHttpService.NONCE_HEADER).orElse(null), call + " -> " + res.statusCode());
    } finally {
      service.stop();
    }
  }

  @Test
  void unknownPathIsA404() throws Exception {
    FhirValidatorHttpService service = new FhirValidatorHttpService(engine(), true, false, PORT, "a1b2-c3.d4_e5");
    service.startServer();
    try {
      assertEquals(404, send("GET", "/nope").statusCode());
    } finally {
      service.stop();
    }
  }

  @Test
  void noNonceNoHeader() throws Exception {
    FhirValidatorHttpService service = new FhirValidatorHttpService(engine(), true, false, PORT);
    service.startServer();
    try {
      HttpResponse<String> res = send("GET", "/validateResource");
      assertEquals(405, res.statusCode());
      assertFalse(res.headers().firstValue(FhirValidatorHttpService.NONCE_HEADER).isPresent());
    } finally {
      service.stop();
    }
  }

  @ParameterizedTest
  @ValueSource(strings = { "", "has space", "line\r\nX-Injected: 1", "a/b" })
  void refusesANonceThatIsNotSimple(String nonce) {
    assertThrows(IllegalArgumentException.class, () -> new FhirValidatorHttpService(engine(), true, false, PORT, nonce));
  }

  @Test
  void refusesANonceThatIsTooLong() {
    assertThrows(IllegalArgumentException.class, () -> new FhirValidatorHttpService(engine(), true, false, PORT, "x".repeat(129)));
  }

  @ParameterizedTest
  @ValueSource(strings = { "", "has space", "line\r\nX-Injected: 1", "a/b" })
  void checkNonceReportsANonceThatIsNotSimple(String nonce) {
    assertNotNull(FhirValidatorHttpService.checkNonce(nonce));
  }

  @Test
  void checkNonceLengthLimit() {
    assertNull(FhirValidatorHttpService.checkNonce("x".repeat(128)));
    assertNotNull(FhirValidatorHttpService.checkNonce("x".repeat(129)));
  }

  @Test
  void checkNonceAcceptsASimpleNonceOrNone() {
    assertNull(FhirValidatorHttpService.checkNonce("a1b2-c3.d4_e5"));
    assertNull(FhirValidatorHttpService.checkNonce(null));
  }
}
