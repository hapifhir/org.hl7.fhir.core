package org.hl7.fhir.validation.http;

import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.utilities.json.model.JsonObject;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

/**
 * GITB-compatible validation results processor.
 * Pure JSON utility — parses an OperationOutcome and extracts counts.
 */
class GitbValidationResultsHandler extends GitbServiceHandler {

  GitbValidationResultsHandler(FhirValidatorHttpService fhirValidatorHttpService) {
    super(fhirValidatorHttpService);
  }

  @Override
  protected JsonObject buildDefinition() {
    return definition("ValidationResultsProcessor",
      new String[]{"summarize", "filterBySeverity", "filterByText"},
      new InputDef[]{
        new InputDef("outcome", "string", true),
        new InputDef("severity", "string", false),
        new InputDef("text", "string", false)
      },
      new String[]{"errors", "warnings", "count"});
  }

  @Override
  protected JsonObject doProcess(String operation, JsonObject inputs) throws Exception {
    switch (operation) {
      case "summarize": return doSummarize(inputs);
      case "filterBySeverity": return doFilterBySeverity(inputs);
      case "filterByText": return doFilterByText(inputs);
      default: return failure("Unknown operation: " + operation + ". Supported: summarize, filterBySeverity, filterByText");
    }
  }

  private OperationOutcome parseOutcome(String outcomeJson) throws Exception {
    Resource r = new JsonParser().parse(new ByteArrayInputStream(outcomeJson.getBytes(StandardCharsets.UTF_8)));
    if (!(r instanceof OperationOutcome)) {
      throw new Exception("Input is not an OperationOutcome");
    }
    return (OperationOutcome) r;
  }

  private JsonObject doSummarize(JsonObject inputs) throws Exception {
    String outcomeStr = requireInput(inputs, "outcome");
    OperationOutcome outcome = parseOutcome(outcomeStr);

    int errors = 0;
    int warnings = 0;
    for (OperationOutcome.OperationOutcomeIssueComponent issue : outcome.getIssue()) {
      switch (issue.getSeverity()) {
        case FATAL:
        case ERROR:
          errors++;
          break;
        case WARNING:
          warnings++;
          break;
        default:
          break;
      }
    }

    JsonObject output = new JsonObject();
    output.add("errors", String.valueOf(errors));
    output.add("warnings", String.valueOf(warnings));
    return success(output);
  }

  private JsonObject doFilterBySeverity(JsonObject inputs) throws Exception {
    String outcomeStr = requireInput(inputs, "outcome");
    String severity = requireInput(inputs, "severity");
    OperationOutcome outcome = parseOutcome(outcomeStr);

    int count = 0;
    for (OperationOutcome.OperationOutcomeIssueComponent issue : outcome.getIssue()) {
      if (issue.getSeverity().toCode().equalsIgnoreCase(severity)) {
        count++;
      }
    }

    JsonObject output = new JsonObject();
    output.add("count", String.valueOf(count));
    return success(output);
  }

  private JsonObject doFilterByText(JsonObject inputs) throws Exception {
    String outcomeStr = requireInput(inputs, "outcome");
    String text = requireInput(inputs, "text");
    OperationOutcome outcome = parseOutcome(outcomeStr);

    int count = 0;
    for (OperationOutcome.OperationOutcomeIssueComponent issue : outcome.getIssue()) {
      if (issue.hasDetails() && issue.getDetails().hasText()
        && issue.getDetails().getText().contains(text)) {
        count++;
      }
    }

    JsonObject output = new JsonObject();
    output.add("count", String.valueOf(count));
    return success(output);
  }
}
