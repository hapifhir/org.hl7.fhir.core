package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;
import org.hl7.fhir.utilities.json.model.JsonObject;

import java.io.IOException;

/**
 * Handler for dynamically loading an Implementation Guide into the running server.
 * Accepts a JSON body with an "ig" field specifying the IG package (e.g., "hl7.fhir.us.core#5.0.1").
 */
@Slf4j
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
      byte[] body = readRequestBody(exchange);
      JsonObject wrapper = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(body);

      String ig = wrapper.asString("ig");
      if (ig == null || ig.trim().isEmpty()) {
        sendOperationOutcome(exchange, 400, OperationOutcomeUtilities.createError("Missing required field: ig"), getAcceptHeader(exchange));
        return;
      }

      log.info("Loading IG: " + ig);
      org.hl7.fhir.validation.ValidationEngine engine = fhirValidatorHttpService.getValidationEngine();
      engine.getIgLoader().loadIg(engine.getIgs(), engine.getBinaries(), ig, false);
      log.info("IG loaded successfully: " + ig);

      sendOperationOutcome(exchange, 200, OperationOutcomeUtilities.createSuccess("IG loaded successfully: " + ig), getAcceptHeader(exchange));

    } catch (Throwable e) {
      sendOperationOutcome(exchange, 500, OperationOutcomeUtilities.createError("Failed to load IG: " + e.getMessage()), getAcceptHeader(exchange));
    }
  }
}
