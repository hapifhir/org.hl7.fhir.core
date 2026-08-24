package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Handler for converting FHIR resources between JSON and XML formats.
 * POST a resource in one format, receive it back in the other.
 * Content-Type determines input format, Accept determines output format.
 */
class ConvertHTTPHandler extends BaseHTTPHandler implements HttpHandler {
  private final FhirValidatorHttpService fhirValidatorHttpService;

  public ConvertHTTPHandler(FhirValidatorHttpService fhirValidatorHttpService) {
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
      FhirFormat inputFormat = determineFormat(contentType);
      String acceptHeader = getAcceptHeader(exchange);
      FhirFormat outputFormat = "xml".equals(acceptHeader) ? FhirFormat.XML : FhirFormat.JSON;

      byte[] result = fhirValidatorHttpService.getValidationEngine().convertFormat(resourceBytes, inputFormat, outputFormat);

      String outContentType = outputFormat == FhirFormat.XML ? "application/fhir+xml" : "application/fhir+json";
      exchange.getResponseHeaders().set("Content-Type", outContentType);
      exchange.sendResponseHeaders(200, result.length);
      try (OutputStream os = exchange.getResponseBody()) {
        os.write(result);
      }

    } catch (Throwable e) {
      sendOperationOutcome(exchange, 500, OperationOutcomeUtilities.createError("Format conversion failed: " + e.getMessage()), getAcceptHeader(exchange));
    }
  }
}
