package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;

import java.io.IOException;
import java.util.Map;

/**
 * Handler for evaluating FHIRPath expressions against a resource.
 */
class FhirPathHTTPHandler extends BaseHTTPHandler implements HttpHandler {
  private final FhirValidatorHttpService fhirValidatorHttpService;

  public FhirPathHTTPHandler(FhirValidatorHttpService fhirValidatorHttpService) {
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
      String expression = params.get("expression");
      if (expression == null || expression.trim().isEmpty()) {
        sendOperationOutcome(exchange, 400, OperationOutcomeUtilities.createError("Missing required query parameter: expression"), getAcceptHeader(exchange));
        return;
      }

      byte[] resourceBytes = readRequestBody(exchange);
      String contentType = exchange.getRequestHeaders().getFirst("Content-Type");
      FhirFormat format = determineFormat(contentType);

      String result = fhirValidatorHttpService.getValidationEngine().evaluateFhirPath(resourceBytes, format, expression);

      Parameters parameters = new Parameters();
      parameters.addParameter("expression", expression);
      parameters.addParameter("result", result);
      sendResource(exchange, 200, parameters, getAcceptHeader(exchange));

    } catch (Throwable e) {
      sendOperationOutcome(exchange, 500, OperationOutcomeUtilities.createError("FHIRPath evaluation failed: " + e.getMessage()), getAcceptHeader(exchange));
    }
  }
}
