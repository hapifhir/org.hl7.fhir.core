package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.r5.utils.validation.constants.CheckDisplayOption;
import org.hl7.fhir.r5.utils.validation.constants.IdStatus;
import org.hl7.fhir.utilities.ByteProvider;
import org.hl7.fhir.validation.ValidationRecord;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Handler for validating resources
 */
class ValidateResourceHTTPHandler extends BaseHTTPHandler implements HttpHandler {
  public static final String VALIDATE_LOCATION = "http-request";

  private final FhirValidatorHttpService fhirValidatorHttpService;

  public ValidateResourceHTTPHandler(FhirValidatorHttpService fhirValidatorHttpService) {
    this.fhirValidatorHttpService = fhirValidatorHttpService;
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    if (!"POST".equals(exchange.getRequestMethod())) {
      sendResponse(exchange, 405, "Method not allowed", "text/plain");
      return;
    }

    List<String> profiles = null;
    IdStatus resourceIdRule = null;
    boolean anyExtensionsAllowed = false;
    BestPracticeWarningLevel bpWarnings = null;
    CheckDisplayOption displayOption = null;
    byte[] resourceBytes = null;
    Manager.FhirFormat format = null;

    try {
      // Read resource bytes from request body
      resourceBytes = readRequestBody(exchange);
      // Get content type and determine format
      String contentType = exchange.getRequestHeaders().getFirst("Content-Type");
      format = determineFormat(contentType);

      // Parse validation parameters from query string
      Map<String, String> params = parseQueryParams(exchange.getRequestURI().getQuery());

      profiles = parseListParameter(params.get("profiles"));
      resourceIdRule = parseIdStatus(params.get("resourceIdRule"));
      anyExtensionsAllowed = parseBooleanParameter(params.get("anyExtensionsAllowed"), true);
      bpWarnings = parseBestPracticeWarningLevel(params.get("bpWarnings"));
      displayOption = parseCheckDisplayOption(params.get("displayOption"));
    } catch (Exception e) {
      OperationOutcome outcome = OperationOutcomeUtilities.createError("Operation failed: " + e.getMessage());
      sendOperationOutcome(exchange, 400, outcome, getAcceptHeader(exchange));
      return;
    }
    try {
      ByteProvider byteProvider = ByteProvider.forBytes(resourceBytes);
      List<ValidationRecord> validationRecords = new ArrayList<>();
      // Validate the resource using ValidationEngine
     // validate("dummy location", byteProvider, format, profiles, validationRecords)
      //OperationOutcome outcome = fhirValidatorHttpService.getValidationEngine().validate(VALIDATE_LOCATION, resourceBytes, format, profiles,
      //  resourceIdRule, anyExtensionsAllowed, bpWarnings, displayOption);
      OperationOutcome outcome = fhirValidatorHttpService.getValidationEngine().validate(VALIDATE_LOCATION, byteProvider, format, profiles, validationRecords);

      sendOperationOutcome(exchange, 200, outcome, getAcceptHeader(exchange));

    } catch (Throwable e) {
      OperationOutcome outcome = OperationOutcomeUtilities.createError("Validation failed: " + e.getMessage());
      sendOperationOutcome(exchange, 500, outcome, getAcceptHeader(exchange));
    }
  }
}
