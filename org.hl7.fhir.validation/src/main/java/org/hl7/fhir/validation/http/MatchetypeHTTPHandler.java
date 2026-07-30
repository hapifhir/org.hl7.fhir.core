package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;
import org.hl7.fhir.utilities.json.model.JsonObject;

import java.io.IOException;

/**
 * Handler for comparing a resource against a matchetype pattern.
 * Expects a JSON body with "resource" and "matchetype" fields, both containing FHIR resources.
 */
class MatchetypeHTTPHandler extends BaseHTTPHandler implements HttpHandler {
  private final FhirValidatorHttpService fhirValidatorHttpService;

  public MatchetypeHTTPHandler(FhirValidatorHttpService fhirValidatorHttpService) {
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
      JsonObject wrapper = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(body);

      if (!wrapper.has("resource") || !wrapper.has("matchetype")) {
        sendOperationOutcome(exchange, 400, OperationOutcomeUtilities.createError("Request must contain both 'resource' and 'matchetype' JSON fields"), getAcceptHeader(exchange));
        return;
      }

      byte[] resourceBytes = org.hl7.fhir.utilities.json.parser.JsonParser.composeBytes(wrapper.getJsonObject("resource"));
      byte[] matchetypeBytes = org.hl7.fhir.utilities.json.parser.JsonParser.composeBytes(wrapper.getJsonObject("matchetype"));

      OperationOutcome outcome = fhirValidatorHttpService.getValidationEngine().compareMatchetype(resourceBytes, FhirFormat.JSON, matchetypeBytes, FhirFormat.JSON);
      sendOperationOutcome(exchange, 200, outcome, getAcceptHeader(exchange));

    } catch (Throwable e) {
      sendOperationOutcome(exchange, 500, OperationOutcomeUtilities.createError("Matchetype comparison failed: " + e.getMessage()), getAcceptHeader(exchange));
    }
  }
}
