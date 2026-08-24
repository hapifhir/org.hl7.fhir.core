package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Handler for generating a human-readable narrative (text.div) for a FHIR resource.
 * POST a resource, receive it back with the narrative populated in resource.text.
 */
class NarrativeHTTPHandler extends BaseHTTPHandler implements HttpHandler {
  private final FhirValidatorHttpService fhirValidatorHttpService;

  public NarrativeHTTPHandler(FhirValidatorHttpService fhirValidatorHttpService) {
    this.fhirValidatorHttpService = fhirValidatorHttpService;
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    if (!"POST".equals(exchange.getRequestMethod())) {
      sendResponse(exchange, 405, "Method not allowed", "text/plain");
      return;
    }

    try {
      byte[] resourceBytes = readRequestBody(exchange);
      String contentType = exchange.getRequestHeaders().getFirst("Content-Type");
      FhirFormat format = determineFormat(contentType);

      byte[] result = fhirValidatorHttpService.getValidationEngine().generateNarrative(resourceBytes, format);

      String outContentType = format == FhirFormat.XML ? "application/fhir+xml" : "application/fhir+json";
      exchange.getResponseHeaders().set("Content-Type", outContentType);
      exchange.sendResponseHeaders(200, result.length);
      try (OutputStream os = exchange.getResponseBody()) {
        os.write(result);
      }

    } catch (Throwable e) {
      sendOperationOutcome(exchange, 500, OperationOutcomeUtilities.createError("Narrative generation failed: " + e.getMessage()), getAcceptHeader(exchange));
    }
  }
}
