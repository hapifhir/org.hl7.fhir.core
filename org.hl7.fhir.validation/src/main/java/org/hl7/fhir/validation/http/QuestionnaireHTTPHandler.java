package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * Handler for generating a FHIR Questionnaire from a StructureDefinition profile.
 * {@code GET /questionnaire?profile=<canonical-url>&format=json|xml}
 *
 * <p>Optional {@code select} query parameter — a stringified JSON array of FHIRPath
 * expressions evaluated against each {@code ElementDefinition} of the profile snapshot.
 * The Questionnaire is built in full, then pruned to elements for which any expression
 * is true (plus their ancestors/descendants). Examples:</p>
 * <ul>
 *   <li>{@code select=["mustSupport = true"]} — only mustSupport elements</li>
 *   <li>{@code select=["path = 'Patient.name'","path = 'Patient.birthDate'"]} — specific elements</li>
 *   <li>{@code select=["min > 0"]} — required elements</li>
 * </ul>
 *
 * <p>Coded elements have their ValueSets expanded and attached as answer options.
 * The profile must already be loaded into the validator's context (e.g. via
 * {@code /loadIG} or at startup).
 */
class QuestionnaireHTTPHandler extends BaseHTTPHandler implements HttpHandler {
  private final FhirValidatorHttpService fhirValidatorHttpService;

  public QuestionnaireHTTPHandler(FhirValidatorHttpService fhirValidatorHttpService) {
    this.fhirValidatorHttpService = fhirValidatorHttpService;
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    if (!"GET".equals(exchange.getRequestMethod())) {
      sendResponse(exchange, 405, "Method not allowed", "text/plain");
      return;
    }

    try {
      Map<String, String> params = parseQueryParams(exchange.getRequestURI().getQuery());
      String profile = params.get("profile");
      if (profile == null || profile.trim().isEmpty()) {
        sendOperationOutcome(exchange, 400,
          OperationOutcomeUtilities.createError("Missing required query parameter: profile"),
          getAcceptHeader(exchange));
        return;
      }

      String format = params.get("format");
      FhirFormat outputFormat = "xml".equalsIgnoreCase(format) ? FhirFormat.XML : FhirFormat.JSON;

      java.util.List<String> selectExpressions = parseStringArray(params.get("select"));

      byte[] result = fhirValidatorHttpService.getValidationEngine()
        .generateQuestionnaire(profile.trim(), outputFormat, selectExpressions);

      String outContentType = outputFormat == FhirFormat.XML ? "application/fhir+xml" : "application/fhir+json";
      exchange.getResponseHeaders().set("Content-Type", outContentType);
      exchange.sendResponseHeaders(200, result.length);
      try (OutputStream os = exchange.getResponseBody()) {
        os.write(result);
      }

    } catch (Throwable e) {
      sendOperationOutcome(exchange, 500,
        OperationOutcomeUtilities.createError("Questionnaire generation failed: " + e.getMessage()),
        getAcceptHeader(exchange));
    }
  }

  /** Parse a stringified JSON array of strings; null/blank yields null (no selection). */
  private static java.util.List<String> parseStringArray(String json) throws IOException {
    if (json == null || json.trim().isEmpty()) {
      return null;
    }
    org.hl7.fhir.utilities.json.model.JsonElement parsed =
      org.hl7.fhir.utilities.json.parser.JsonParser.parse(json);
    if (!parsed.isJsonArray()) {
      throw new IllegalArgumentException("'select' must be a JSON array of FHIRPath expression strings");
    }
    java.util.List<String> result = new java.util.ArrayList<>();
    for (org.hl7.fhir.utilities.json.model.JsonElement el : parsed.asJsonArray()) {
      result.add(el.asString());
    }
    return result;
  }
}
