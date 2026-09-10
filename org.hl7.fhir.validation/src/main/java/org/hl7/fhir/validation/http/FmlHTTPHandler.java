package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * Handler for parsing FHIR Mapping Language (FML) text into a StructureMap resource.
 * {@code POST /fml?name=<name>&format=json|xml} with the FML map source as the request body.
 *
 * <p>Companion to {@code /transform} (which <i>applies</i> a StructureMap); this one
 * <i>parses</i> FML source into a StructureMap resource.
 */
class FmlHTTPHandler extends BaseHTTPHandler implements HttpHandler {
  private final FhirValidatorHttpService fhirValidatorHttpService;

  public FmlHTTPHandler(FhirValidatorHttpService fhirValidatorHttpService) {
    this.fhirValidatorHttpService = fhirValidatorHttpService;
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    if (!"POST".equals(exchange.getRequestMethod())) {
      sendResponse(exchange, 405, "Method not allowed", "text/plain");
      return;
    }

    try {
      byte[] body = readRequestBody(exchange);
      if (body == null || body.length == 0) {
        sendOperationOutcome(exchange, 400,
          OperationOutcomeUtilities.createError("Missing request body: the FML map source text"),
          getAcceptHeader(exchange));
        return;
      }

      Map<String, String> params = parseQueryParams(exchange.getRequestURI().getQuery());
      String name = params.get("name");
      String format = params.get("format");
      FhirFormat outputFormat = "xml".equalsIgnoreCase(format) ? FhirFormat.XML : FhirFormat.JSON;

      byte[] result = fhirValidatorHttpService.getValidationEngine()
        .parseStructureMap(new String(body, StandardCharsets.UTF_8), name, outputFormat);

      String outContentType = outputFormat == FhirFormat.XML ? "application/fhir+xml" : "application/fhir+json";
      exchange.getResponseHeaders().set("Content-Type", outContentType);
      exchange.sendResponseHeaders(200, result.length);
      try (OutputStream os = exchange.getResponseBody()) {
        os.write(result);
      }

    } catch (Throwable e) {
      sendOperationOutcome(exchange, 500,
        OperationOutcomeUtilities.createError("FML parse failed: " + e.getMessage()),
        getAcceptHeader(exchange));
    }
  }
}
