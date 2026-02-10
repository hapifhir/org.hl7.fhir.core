package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.r5.utils.validation.constants.CheckDisplayOption;
import org.hl7.fhir.r5.utils.validation.constants.IdStatus;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Handler for validating resources
 */
class LoadIGHTTPHandler extends BaseHTTPHandler implements HttpHandler {
  private final FhirValidatorHttpService fhirValidatorHttpService;

  public LoadIGHTTPHandler(FhirValidatorHttpService fhirValidatorHttpService) {
    this.fhirValidatorHttpService = fhirValidatorHttpService;
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    if (!"POST".equals(exchange.getRequestMethod())) {
      sendResponse(exchange, 405, "Method not allowed", "text/plain");
      return;
    }

    try {
      // todo: fill this out
      sendOperationOutcome(exchange, 200, OperationOutcomeUtilities.createSuccess("Not done yet"), getAcceptHeader(exchange));
    } catch (Throwable e) {
      OperationOutcome outcome = OperationOutcomeUtilities.createError("Validation failed: " + e.getMessage());
      sendOperationOutcome(exchange, 500, outcome, getAcceptHeader(exchange));
    }
  }
}
