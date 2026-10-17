package org.hl7.fhir.validation.http;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

/**
 * GITB Processing Service at {@code /itb/validationResults}. Pure JSON utility —
 * does not call the validation engine. Operations: {@code summarize},
 * {@code filterBySeverity}, {@code filterByText}.
 */
@Slf4j
class GitbValidationResultsHandler extends GitbProcessingServiceHandler {

  GitbValidationResultsHandler(FhirValidatorHttpService service) {
    super(service, "/itb/validationResults");
  }

  @Override
  protected JsonObject buildProcessingModule() {
    JsonObject summarizeInputs = typedParameters(
      new TypedParam("outcome", "binary", true, "OperationOutcome (FHIR JSON).")
    );
    JsonObject summarizeOutputs = typedParameters(
      new TypedParam("errors",      "string", true, "Error count."),
      new TypedParam("warnings",    "string", true, "Warning count."),
      new TypedParam("information", "string", true, "Information count.")
    );
    JsonObject filterBySeverityInputs = typedParameters(
      new TypedParam("outcome",  "binary", true, "OperationOutcome (FHIR JSON)."),
      new TypedParam("severity", "string", true, "fatal | error | warning | information.")
    );
    JsonObject filterBySeverityOutputs = typedParameters(
      new TypedParam("count",   "string", true, "Count of issues at the requested severity."),
      new TypedParam("outcome", "binary", true, "Filtered OperationOutcome (FHIR JSON).")
    );
    JsonObject filterByTextInputs = typedParameters(
      new TypedParam("outcome", "binary", true, "OperationOutcome (FHIR JSON)."),
      new TypedParam("text",    "string", true, "Substring to match against issue.details.text.")
    );
    JsonObject filterByTextOutputs = filterBySeverityOutputs;

    return processingModule(
      "ValidationResultsProcessor",
      metadata("FHIR Validation Results Processor",
        GitbFhirHandler.validatorVersion(service.getValidationEngine()),
        "Summarises and filters a FHIR OperationOutcome."),
      new ProcessingOperation("summarize",        summarizeInputs,        summarizeOutputs),
      new ProcessingOperation("filterBySeverity", filterBySeverityInputs, filterBySeverityOutputs),
      new ProcessingOperation("filterByText",     filterByTextInputs,     filterByTextOutputs)
    );
  }

  @Override
  protected ProcessResult doProcess(String operation, JsonArray input, String sessionId) throws Exception {
    String op = operation == null ? "" : operation;
    switch (op) {
      case "summarize":
      case "filterBySeverity":
      case "filterByText":
        break;
      default:
        throw new UnknownOperationException(op, "summarize, filterBySeverity, filterByText");
    }

    String outcomeStr = requireInput(input, "outcome");
    JsonObject outcome = parseOutcome(outcomeStr);
    JsonArray issues = outcome.has("issue") && outcome.get("issue").isJsonArray()
      ? outcome.getJsonArray("issue")
      : new JsonArray();

    switch (op) {
      case "summarize":
        return doSummarize(issues);
      case "filterBySeverity":
        return doFilterBySeverity(issues, requireInput(input, "severity"));
      case "filterByText":
        return doFilterByText(issues, requireInput(input, "text"));
      default:
        throw new UnknownOperationException(op, "summarize, filterBySeverity, filterByText");
    }
  }

  private ProcessResult doSummarize(JsonArray issues) {
    int errors = 0, warnings = 0, infos = 0;
    for (JsonElement el : issues) {
      if (!el.isJsonObject()) continue;
      String sev = el.asJsonObject().asString("severity");
      if (sev == null) continue;
      switch (sev.toLowerCase()) {
        case "fatal":
        case "error":
          errors++;
          break;
        case "warning":
          warnings++;
          break;
        case "information":
          infos++;
          break;
      }
    }
    JsonArray output = new JsonArray();
    output.add(anyContent("errors", String.valueOf(errors), "text/plain"));
    output.add(anyContent("warnings", String.valueOf(warnings), "text/plain"));
    output.add(anyContent("information", String.valueOf(infos), "text/plain"));
    return ProcessResult.ofOutput(output);
  }

  private ProcessResult doFilterBySeverity(JsonArray issues, String severity) {
    JsonArray filtered = new JsonArray();
    int count = 0;
    for (JsonElement el : issues) {
      if (!el.isJsonObject()) continue;
      String sev = el.asJsonObject().asString("severity");
      if (sev != null && sev.equalsIgnoreCase(severity)) {
        filtered.add(el);
        count++;
      }
    }
    return filteredOutput(filtered, count);
  }

  private ProcessResult doFilterByText(JsonArray issues, String text) {
    JsonArray filtered = new JsonArray();
    int count = 0;
    for (JsonElement el : issues) {
      if (!el.isJsonObject()) continue;
      JsonObject issue = el.asJsonObject();
      String detailsText = null;
      if (issue.has("details") && issue.get("details").isJsonObject()) {
        detailsText = issue.getJsonObject("details").asString("text");
      }
      if (detailsText != null && detailsText.contains(text)) {
        filtered.add(el);
        count++;
      }
    }
    return filteredOutput(filtered, count);
  }

  private ProcessResult filteredOutput(JsonArray filteredIssues, int count) {
    JsonObject filteredOutcome = new JsonObject();
    filteredOutcome.add("resourceType", "OperationOutcome");
    filteredOutcome.add("issue", filteredIssues);

    JsonArray output = new JsonArray();
    output.add(anyContent("count", String.valueOf(count), "text/plain"));
    output.add(anyContent("outcome", JsonParser.compose(filteredOutcome), "application/fhir+json"));
    return ProcessResult.ofOutput(output);
  }

  private static JsonObject parseOutcome(String s) {
    try {
      return JsonParser.parseObject(s);
    } catch (Exception e) {
      throw new InvalidInputException("Invalid OperationOutcome JSON: " + e.getMessage());
    }
  }
}
