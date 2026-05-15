package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * Handler for the CRMI {@code $package} operation: given a root canonical artifact,
 * return a collection Bundle of that artifact plus its transitive dependencies.
 * {@code GET /package?url=<canonical-url>&expand=true|false&format=json|xml}
 *
 * <p>Core FHIR resources are not included. The root artifact and its dependencies
 * must already be loaded into the validator's context (e.g. via {@code /loadIG}).
 */
class PackageHTTPHandler extends BaseHTTPHandler implements HttpHandler {
  private final FhirValidatorHttpService fhirValidatorHttpService;

  public PackageHTTPHandler(FhirValidatorHttpService fhirValidatorHttpService) {
    this.fhirValidatorHttpService = fhirValidatorHttpService;
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    if (!"GET".equals(exchange.getRequestMethod())) {
      sendResponse(exchange, 405, "Method not allowed", "text/plain");
      return;
    }

    try {
      Map<String, String> params = parseQueryParams(exchange.getRequestURI().getQuery());
      String url = params.get("url");
      if (url == null || url.trim().isEmpty()) {
        sendOperationOutcome(exchange, 400,
          OperationOutcomeUtilities.createError("Missing required query parameter: url"),
          getAcceptHeader(exchange));
        return;
      }

      boolean expandValueSets = "true".equalsIgnoreCase(params.get("expand"));
      String format = params.get("format");
      FhirFormat outputFormat = "xml".equalsIgnoreCase(format) ? FhirFormat.XML : FhirFormat.JSON;

      byte[] result = fhirValidatorHttpService.getValidationEngine()
        .packageResource(url.trim(), expandValueSets, outputFormat);

      String outContentType = outputFormat == FhirFormat.XML ? "application/fhir+xml" : "application/fhir+json";
      exchange.getResponseHeaders().set("Content-Type", outContentType);
      exchange.sendResponseHeaders(200, result.length);
      try (OutputStream os = exchange.getResponseBody()) {
        os.write(result);
      }

    } catch (Throwable e) {
      sendOperationOutcome(exchange, 500,
        OperationOutcomeUtilities.createError("Package failed: " + e.getMessage()),
        getAcceptHeader(exchange));
    }
  }
}
