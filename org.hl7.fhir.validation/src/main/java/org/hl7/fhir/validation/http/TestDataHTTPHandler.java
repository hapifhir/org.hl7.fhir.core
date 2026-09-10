package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Handler for generating test data from a profile.
 * Expects a JSON body with:
 *   "profile": URL of the StructureDefinition (required)
 *   "data": array of row objects with column values (optional, defaults to one empty row)
 *   "mappings": array of mapping objects for field mappings (optional)
 *   "format": "json" or "xml" (optional, default "json")
 *   "bundle": boolean - wrap all rows in a Bundle (optional, default false)
 */
class TestDataHTTPHandler extends BaseHTTPHandler implements HttpHandler {
  private final FhirValidatorHttpService fhirValidatorHttpService;

  public TestDataHTTPHandler(FhirValidatorHttpService fhirValidatorHttpService) {
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

      String profileUrl = wrapper.asString("profile");
      if (profileUrl == null || profileUrl.trim().isEmpty()) {
        sendOperationOutcome(exchange, 400, OperationOutcomeUtilities.createError("Missing required field: profile"), getAcceptHeader(exchange));
        return;
      }

      JsonArray data = wrapper.has("data") ? wrapper.forceArray("data") : null;
      if (data == null || data.size() == 0) {
        data = new JsonArray();
        data.add(new JsonObject());
      }
      JsonArray mappings = wrapper.has("mappings") ? wrapper.forceArray("mappings") : null;
      String formatStr = wrapper.has("format") ? wrapper.asString("format") : "json";
      FhirFormat outputFormat = "xml".equalsIgnoreCase(formatStr) ? FhirFormat.XML : FhirFormat.JSON;
      boolean asBundle = wrapper.has("bundle") && "true".equals(wrapper.asString("bundle"));
      boolean requiredOnly = wrapper.has("requiredOnly") && "true".equals(wrapper.asString("requiredOnly"));

      byte[] result = fhirValidatorHttpService.getValidationEngine().generateTestData(profileUrl, data, mappings, outputFormat, asBundle, requiredOnly);

      String contentType = outputFormat == FhirFormat.XML ? "application/fhir+xml" : "application/fhir+json";
      exchange.getResponseHeaders().set("Content-Type", contentType);
      exchange.sendResponseHeaders(200, result.length);
      try (OutputStream os = exchange.getResponseBody()) {
        os.write(result);
      }

    } catch (Throwable e) {
      sendOperationOutcome(exchange, 500, OperationOutcomeUtilities.createError("Test data generation failed: " + e.getMessage()), getAcceptHeader(exchange));
    }
  }
}
