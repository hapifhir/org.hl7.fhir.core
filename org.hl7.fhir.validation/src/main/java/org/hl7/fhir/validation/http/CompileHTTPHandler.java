package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.model.core.OperationOutcome.IssueSeverity;
import org.hl7.fhir.model.core.OperationOutcome.IssueType;
import org.hl7.fhir.model.fml.StructureMap;
import org.hl7.fhir.model.utilities.OperationOutcomeUtilities;
import org.hl7.fhir.model.utilities.formats.FhirFormat;

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

  public CompileHTTPHandler(IModelContext context, FhirValidatorHttpService fhirValidatorHttpService) {
    super(context);
    this.fhirValidatorHttpService = fhirValidatorHttpService;
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    try {
      Map<String, String> params = parseQueryParams(exchange.getRequestURI().getRawQuery());
      String mapUri = params.get("url");
      if (mapUri == null || mapUri.trim().isEmpty()) {
        sendOperationOutcome(exchange, 400, OperationOutcomeUtilities.createError("Missing required query parameter: url"), getAcceptHeader(exchange));
        return;
      }

      // a map the server doesn't have is the client's mistake (load the IG that defines it first), not a failure
      if (fhirValidatorHttpService.getValidationEngine().getContext().fetchResource(StructureMap.class, mapUri) == null) {
        sendOperationOutcome(exchange, 400, OperationOutcomeUtilities.createOutcome("Unable to find map: " + mapUri,
          IssueSeverity.ERROR, IssueType.NOTFOUND), getAcceptHeader(exchange));
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
