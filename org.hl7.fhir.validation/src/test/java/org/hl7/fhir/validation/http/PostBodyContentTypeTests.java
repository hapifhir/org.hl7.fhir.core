package org.hl7.fhir.validation.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import org.hl7.fhir.validation.ValidationEngine;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * A POST that carries a body must declare a JSON or XML content type. A browser can reach this
 * server from any page without a preflight only as a CORS "simple" request, which cannot carry
 * those types - so requiring one turns such requests away while every real client, which always
 * declares what it sends, is unaffected. An empty body is not subject to the check.
 */
class PostBodyContentTypeTests {

  private static final int PORT = 18093;
  private static final String JSON_BODY = "{\"resource\": {\"resourceType\": \"Patient\"}, \"matchetype\": {\"resourceType\": \"Patient\"}}";

  private static FhirValidatorHttpService service;
  private static HttpClient client;

  @BeforeAll
  static void start() throws Exception {
    // The engine is mocked: every case here is decided before a handler touches it.
    service = new FhirValidatorHttpService(mock(ValidationEngine.class), true, PORT);
    service.startServer();
    client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();
  }

  @AfterAll
  static void stop() {
    service.stop();
  }

  private static HttpResponse<String> post(String path, String body, String contentType) throws Exception {
    HttpRequest.Builder b = HttpRequest.newBuilder()
      .uri(URI.create("http://127.0.0.1:" + PORT + path))
      .POST(HttpRequest.BodyPublishers.ofString(body));
    if (contentType != null) {
      b.header("Content-Type", contentType);
    }
    return client.send(b.build(), HttpResponse.BodyHandlers.ofString());
  }

  @Test
  @DisplayName("A body with no Content-Type is refused with 415")
  void missingTypeIsRefused() throws Exception {
    HttpResponse<String> r = post("/matchetype", JSON_BODY, null);
    assertEquals(415, r.statusCode());
    assertTrue(r.body().contains("Content-Type"), r.body());
  }

  @ParameterizedTest
  @DisplayName("The types a CORS-simple request can carry are refused")
  @ValueSource(strings = { "text/plain", "application/x-www-form-urlencoded", "multipart/form-data" })
  void simpleRequestTypesAreRefused(String contentType) throws Exception {
    assertEquals(415, post("/matchetype", JSON_BODY, contentType).statusCode(), contentType);
  }

  @ParameterizedTest
  @DisplayName("Declared JSON and XML types pass the check")
  @ValueSource(strings = { "application/json", "application/fhir+json", "application/fhir+json; charset=utf-8",
                           "application/fhir+xml", "application/xml", "text/xml" })
  void declaredTypesPass(String contentType) throws Exception {
    // With a mocked engine the handler may fail later - what matters is that it was not 415.
    assertNotEquals(415, post("/matchetype", JSON_BODY, contentType).statusCode(), contentType);
  }

  @Test
  @DisplayName("An empty body is left to the handler's own missing-body check")
  void emptyBodyIsNotSubjectToTheCheck() throws Exception {
    // Whatever the handler makes of an empty body is its own business; the point is that the
    // content-type check did not fire on it.
    HttpResponse<String> r = post("/matchetype", "", null);
    assertNotEquals(415, r.statusCode(), r.body());
  }

  @Test
  @DisplayName("The check applies across the POST handlers, not just one")
  void appliesToOtherPostHandlers() throws Exception {
    assertEquals(415, post("/loadIG", "{\"ig\": \"hl7.fhir.us.core#5.0.1\"}", "text/plain").statusCode());
    assertEquals(415, post("/validateResource", "{\"resourceType\": \"Patient\"}", null).statusCode());
  }
}
