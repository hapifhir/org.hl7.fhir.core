package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.model.core.OperationOutcome;
import org.hl7.fhir.model.utilities.OperationOutcomeUtilities;

import java.io.IOException;
import java.util.Map;

/**
 * Handler for static type checking of a FHIRPath expression: given the type it is evaluated on and the expression,
 * the issues the checking finds, as an OperationOutcome. Nothing is evaluated, so there's no resource.
 */
class FhirPathCheckHTTPHandler extends BaseHTTPHandler implements HttpHandler {
  // bounds on what is checked: the checking is in the server's (single) request thread
  static final int MAX_EXPRESSION_LENGTH = 10000;
  static final int MAX_TYPE_LENGTH = 1024;

  private final FhirValidatorHttpService fhirValidatorHttpService;

  public FhirPathCheckHTTPHandler(IModelContext context, FhirValidatorHttpService fhirValidatorHttpService) {
    super(context);
    this.fhirValidatorHttpService = fhirValidatorHttpService;
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    if (!"GET".equals(exchange.getRequestMethod()) && !"POST".equals(exchange.getRequestMethod())) {
      sendResponse(exchange, 405, "Method not allowed", "text/plain");
      return;
    }

    try {
      Map<String, String> params = parseQueryParams(exchange.getRequestURI().getRawQuery());
      String type = params.get("type");
      String expression = params.get("expression");
      if (type == null || type.trim().isEmpty() || expression == null || expression.trim().isEmpty()) {
        sendOperationOutcome(exchange, 400, OperationOutcomeUtilities.createError("Missing required query parameter: " +
          (type == null || type.trim().isEmpty() ? "type" : "expression")), getAcceptHeader(exchange));
        return;
      }
      if (type.length() > MAX_TYPE_LENGTH || expression.length() > MAX_EXPRESSION_LENGTH) {
        sendOperationOutcome(exchange, 400, OperationOutcomeUtilities.createError(type.length() > MAX_TYPE_LENGTH
          ? "The type is longer than " + MAX_TYPE_LENGTH + " characters" : "The expression is longer than " + MAX_EXPRESSION_LENGTH + " characters"), getAcceptHeader(exchange));
        return;
      }
      OperationOutcome outcome = fhirValidatorHttpService.getValidationEngine().checkFhirPath(type.trim(), expression);
      sendResource(exchange, 200, outcome, getAcceptHeader(exchange));
    } catch (Throwable e) {
      sendOperationOutcome(exchange, 500, OperationOutcomeUtilities.createError("FHIRPath checking failed: " + e.getMessage()), getAcceptHeader(exchange));
    }
  }
}
