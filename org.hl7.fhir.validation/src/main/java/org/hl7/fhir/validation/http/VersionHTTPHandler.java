package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * Handler for converting a FHIR resource between FHIR versions (e.g., R4 to R5).
 * POST a resource with ?targetVersion=<ver> query parameter.
 * Supported target versions: 1.0 (DSTU2), 3.0 (STU3), 4.0 (R4), 4.3 (R4B), 5.0 (R5).
 */
class VersionHTTPHandler extends BaseHTTPHandler implements HttpHandler {
  private final FhirValidatorHttpService fhirValidatorHttpService;

  public VersionHTTPHandler(FhirValidatorHttpService fhirValidatorHttpService) {
    this.fhirValidatorHttpService = fhirValidatorHttpService;
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    if (!"POST".equals(exchange.getRequestMethod())) {
      sendResponse(exchange, 405, "Method not allowed", "text/plain");
      return;
    }

    try {
      Map<String, String> params = parseQueryParams(exchange.getRequestURI().getQuery());
      String targetVersion = params.get("targetVersion");
      if (targetVersion == null || targetVersion.trim().isEmpty()) {
        sendOperationOutcome(exchange, 400, OperationOutcomeUtilities.createError("Missing required query parameter: targetVersion"), getAcceptHeader(exchange));
        return;
      }

      byte[] resourceBytes = readRequestBody(exchange);
      String contentType = exchange.getRequestHeaders().getFirst("Content-Type");
      FhirFormat format = determineFormat(contentType);

      byte[] result = fhirValidatorHttpService.getValidationEngine().convertVersion(resourceBytes, format, targetVersion);

      String outContentType = format == FhirFormat.XML ? "application/fhir+xml" : "application/fhir+json";
      exchange.getResponseHeaders().set("Content-Type", outContentType);
      exchange.sendResponseHeaders(200, result.length);
      try (OutputStream os = exchange.getResponseBody()) {
        os.write(result);
      }

    } catch (Throwable e) {
      sendOperationOutcome(exchange, 500, OperationOutcomeUtilities.createError("Version conversion failed: " + e.getMessage()), getAcceptHeader(exchange));
    }
  }
}
