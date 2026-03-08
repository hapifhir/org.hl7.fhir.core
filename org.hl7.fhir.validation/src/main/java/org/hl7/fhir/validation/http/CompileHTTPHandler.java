package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * Handler for fetching/compiling a StructureMap by its canonical URL.
 * GET or POST with ?url=<mapUri> query parameter.
 * Returns the StructureMap resource.
 */
class CompileHTTPHandler extends BaseHTTPHandler implements HttpHandler {
  private final FhirValidatorHttpService fhirValidatorHttpService;

  public CompileHTTPHandler(FhirValidatorHttpService fhirValidatorHttpService) {
    this.fhirValidatorHttpService = fhirValidatorHttpService;
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    try {
      Map<String, String> params = parseQueryParams(exchange.getRequestURI().getQuery());
      String mapUri = params.get("url");
      if (mapUri == null || mapUri.trim().isEmpty()) {
        sendOperationOutcome(exchange, 400, OperationOutcomeUtilities.createError("Missing required query parameter: url"), getAcceptHeader(exchange));
        return;
      }

      String acceptHeader = getAcceptHeader(exchange);
      FhirFormat outputFormat = "xml".equals(acceptHeader) ? FhirFormat.XML : FhirFormat.JSON;

      byte[] result = fhirValidatorHttpService.getValidationEngine().compileMap(mapUri, outputFormat);

      String outContentType = outputFormat == FhirFormat.XML ? "application/fhir+xml" : "application/fhir+json";
      exchange.getResponseHeaders().set("Content-Type", outContentType);
      exchange.sendResponseHeaders(200, result.length);
      try (OutputStream os = exchange.getResponseBody()) {
        os.write(result);
      }

    } catch (Throwable e) {
      sendOperationOutcome(exchange, 500, OperationOutcomeUtilities.createError("Compile map failed: " + e.getMessage()), getAcceptHeader(exchange));
    }
  }
}
