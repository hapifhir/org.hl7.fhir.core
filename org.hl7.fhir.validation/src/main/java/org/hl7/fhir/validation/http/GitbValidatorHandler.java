package org.hl7.fhir.validation.http;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.r5.utils.validation.constants.IdStatus;
import org.hl7.fhir.utilities.ByteProvider;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.ValidationRecord;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * GITB-compatible FHIR validation service.
 * Wraps /validateResource and /loadIG.
 */
@Slf4j
class GitbValidatorHandler extends GitbServiceHandler {

  GitbValidatorHandler(FhirValidatorHttpService fhirValidatorHttpService) {
    super(fhirValidatorHttpService);
  }

  @Override
  protected JsonObject buildDefinition() {
    return definition("FHIRValidator",
      new String[]{"validate", "loadIG"},
      new InputDef[]{
        new InputDef("resource", "string", false),
        new InputDef("profiles", "string", false),
        new InputDef("ig", "string", false),
        new InputDef("bpWarnings", "string", false),
        new InputDef("resourceIdRule", "string", false)
      },
      new String[]{"outcome", "severity", "errors", "warnings"});
  }

  @Override
  protected JsonObject doProcess(String operation, JsonObject inputs) throws Exception {
    switch (operation) {
      case "validate": return doValidate(inputs);
      case "loadIG": return doLoadIG(inputs);
      default: return failure("Unknown operation: " + operation + ". Supported: validate, loadIG");
    }
  }

  private JsonObject doValidate(JsonObject inputs) throws Exception {
    String resource = requireInput(inputs, "resource");
    String profiles = optionalInput(inputs, "profiles", null);
    String bpWarnings = optionalInput(inputs, "bpWarnings", null);
    String resourceIdRule = optionalInput(inputs, "resourceIdRule", null);

    InstanceValidatorParameters params = new InstanceValidatorParameters();
    if (profiles != null) {
      for (String p : profiles.split(",")) {
        params.addProfile(p.trim());
      }
    }
    if (bpWarnings != null) {
      params.setBestPracticeLevel(BestPracticeWarningLevel.valueOf(bpWarnings));
    }
    if (resourceIdRule != null) {
      params.setResourceIdRule(IdStatus.fromCode(resourceIdRule));
    }

    ValidationEngine engine = fhirValidatorHttpService.getValidationEngine();
    List<ValidationRecord> records = new ArrayList<>();
    OperationOutcome outcome = engine.validate("gitb-request",
      ByteProvider.forBytes(resource.getBytes(StandardCharsets.UTF_8)),
      FhirFormat.JSON, params, records);

    return buildValidationResponse(outcome);
  }

  private JsonObject doLoadIG(JsonObject inputs) throws Exception {
    String ig = requireInput(inputs, "ig");
    try {
      ValidationEngine engine = fhirValidatorHttpService.getValidationEngine();
      log.info("GITB: Loading IG: " + ig);
      engine.getIgLoader().loadIg(engine.getIgs(), engine.getBinaries(), ig, false);
      log.info("GITB: IG loaded successfully: " + ig);

      OperationOutcome outcome = OperationOutcomeUtilities.createSuccess("IG loaded successfully: " + ig);
      return buildValidationResponse(outcome);
    } catch (Exception e) {
      return failure("Failed to load IG: " + e.getMessage());
    }
  }

  private JsonObject buildValidationResponse(OperationOutcome outcome) throws Exception {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    new JsonParser().compose(baos, outcome);
    String outcomeJson = baos.toString(StandardCharsets.UTF_8);

    int errors = 0;
    int warnings = 0;
    String highestSeverity = "information";
    for (OperationOutcome.OperationOutcomeIssueComponent issue : outcome.getIssue()) {
      switch (issue.getSeverity()) {
        case FATAL:
        case ERROR:
          errors++;
          highestSeverity = "error";
          break;
        case WARNING:
          warnings++;
          if (!"error".equals(highestSeverity)) highestSeverity = "warning";
          break;
        default:
          break;
      }
    }

    JsonObject output = new JsonObject();
    output.add("outcome", outcomeJson);
    output.add("severity", highestSeverity);
    output.add("errors", String.valueOf(errors));
    output.add("warnings", String.valueOf(warnings));
    return success(output);
  }
}
