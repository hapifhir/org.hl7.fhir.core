package org.hl7.fhir.validation.http;

import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.utilities.json.model.JsonObject;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

/**
 * GITB-compatible matchetype comparison service.
 * Wraps the existing /matchetype endpoint.
 */
class GitbMatchetypeHandler extends GitbServiceHandler {

  GitbMatchetypeHandler(FhirValidatorHttpService fhirValidatorHttpService) {
    super(fhirValidatorHttpService);
  }

  @Override
  protected JsonObject buildDefinition() {
    return definition("MatchetypeProcessor",
      new String[]{"compare"},
      new InputDef[]{
        new InputDef("resource", "string", true),
        new InputDef("matchetype", "string", true),
        new InputDef("mode", "string", false)
      },
      new String[]{"outcome", "severity"});
  }

  @Override
  protected JsonObject doProcess(String operation, JsonObject inputs) throws Exception {
    if (!"compare".equals(operation)) {
      return failure("Unknown operation: " + operation + ". Supported: compare");
    }

    String resource = requireInput(inputs, "resource");
    String matchetype = requireInput(inputs, "matchetype");

    byte[] resourceBytes = resource.getBytes(StandardCharsets.UTF_8);
    byte[] matchetypeBytes = matchetype.getBytes(StandardCharsets.UTF_8);

    OperationOutcome outcome = fhirValidatorHttpService.getValidationEngine()
      .compareMatchetype(resourceBytes, FhirFormat.JSON, matchetypeBytes, FhirFormat.JSON);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    new JsonParser().compose(baos, outcome);

    String highestSeverity = "information";
    for (OperationOutcome.OperationOutcomeIssueComponent issue : outcome.getIssue()) {
      switch (issue.getSeverity()) {
        case FATAL:
        case ERROR:
          highestSeverity = "error";
          break;
        case WARNING:
          if (!"error".equals(highestSeverity)) highestSeverity = "warning";
          break;
        default:
          break;
      }
    }

    JsonObject output = new JsonObject();
    output.add("outcome", baos.toString(StandardCharsets.UTF_8));
    output.add("severity", highestSeverity);
    return success(output);
  }
}
