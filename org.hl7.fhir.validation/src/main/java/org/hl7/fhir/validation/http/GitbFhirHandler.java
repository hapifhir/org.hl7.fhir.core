package org.hl7.fhir.validation.http;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.r5.utils.validation.constants.IdStatus;
import org.hl7.fhir.utilities.ByteProvider;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * GITB Validation Service for the FHIR validator at {@code /itb/fhir}.
 * Single operation per the GITB validation service contract: {@code validate}.
 * <p>
 * IG loading is handled by the separate {@link GitbIgManagerHandler} processing
 * service ({@code /itb/igManager}); pre-load IGs there before calling validate.
 */
@Slf4j
class GitbFhirHandler extends GitbValidationServiceHandler {

  GitbFhirHandler(FhirValidatorHttpService service) {
    super(service, "/itb/fhir");
  }

  @Override
  protected JsonObject buildValidationModule() {
    JsonObject inputs = typedParameters(
      new TypedParam("contentToValidate", "binary", true,  "FHIR resource to validate (JSON, XML or Turtle, per contentType)."),
      new TypedParam("contentType",       "string", false, "MIME type of contentToValidate; defaults to application/fhir+json."),
      new TypedParam("profiles",          "string", false, "Comma-separated profile canonical URLs."),
      new TypedParam("bpWarnings",        "string", false, "Best-practice warning level: Ignore|Hint|Warning|Error."),
      new TypedParam("resourceIdRule",    "string", false, "OPTIONAL|REQUIRED|PROHIBITED."),
      new TypedParam("displayWarnings",   "boolean", false, "Whether to emit display-mismatch warnings."),
      new TypedParam("failOn",            "string", false, "Severity that flips result to FAILURE: error|warning|information."),
      new TypedParam("includeContentInReport", "boolean", false, "If true (default), content is echoed in TAR context.")
    );
    return validationModule(
      "FHIRValidator",
      "validate",
      metadata(GitbTarBuilder.VALIDATOR_NAME, validatorVersion(service.getValidationEngine()),
        "Validates a FHIR resource against base FHIR + optional profiles, returning a TAR report."),
      inputs);
  }

  @Override
  protected JsonObject doValidate(JsonArray input, JsonArray config, String sessionId) {
    String content = requireInput(input, "contentToValidate");
    String contentType = optionalInput(input, "contentType", "application/fhir+json");
    String profilesStr = optionalInput(input, "profiles", null);
    String bpWarnings = optionalInput(input, "bpWarnings", null);
    String resourceIdRule = optionalInput(input, "resourceIdRule", null);
    String failOn = optionalInput(input, "failOn", "error");
    boolean includeContentInReport = optionalBooleanInput(input, "includeContentInReport", true);

    InstanceValidatorParameters params = new InstanceValidatorParameters();
    if (profilesStr != null) {
      for (String p : profilesStr.split(",")) {
        String trimmed = p.trim();
        if (!trimmed.isEmpty()) params.addProfile(trimmed);
      }
    }
    if (bpWarnings != null) {
      try {
        params.setBestPracticeLevel(BestPracticeWarningLevel.valueOf(bpWarnings));
      } catch (IllegalArgumentException ignored) {
        // leave default
      }
    }
    if (resourceIdRule != null) {
      try {
        params.setResourceIdRule(IdStatus.fromCode(resourceIdRule));
      } catch (Exception ignored) {
        // leave default
      }
    }

    FhirFormat format = formatFor(contentType);
    byte[] sourceBytes = content.getBytes(StandardCharsets.UTF_8);
    ValidationEngine engine = service.getValidationEngine();
    String engineVersion = validatorVersion(engine);

    OperationOutcome outcome;
    try {
      outcome = engine.validate("gitb-validate", ByteProvider.forBytes(sourceBytes), format, params, new ArrayList<>());
    } catch (Throwable t) {
      log.warn("GITB validate failed", t);
      return GitbTarBuilder.buildUndefinedTar(t.getClass().getSimpleName() + ": " + t.getMessage(), sessionId, engineVersion);
    }

    String outcomeJson;
    try {
      outcomeJson = serializeOutcome(outcome);
    } catch (Throwable t) {
      return GitbTarBuilder.buildUndefinedTar("Could not serialise OperationOutcome: " + t.getMessage(), sessionId, engineVersion);
    }

    String contentForReport = includeContentInReport ? content : null;
    return GitbTarBuilder.buildValidationTar(outcome, outcomeJson, contentForReport, contentType, failOn, sessionId, engineVersion);
  }

  static FhirFormat formatFor(String contentType) {
    if (contentType == null) return FhirFormat.JSON;
    String ct = contentType.toLowerCase();
    if (ct.contains("xml")) return FhirFormat.XML;
    if (ct.contains("turtle")) return FhirFormat.TURTLE;
    return FhirFormat.JSON;
  }

  static String serializeOutcome(OperationOutcome outcome) throws java.io.IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    new JsonParser().compose(baos, outcome);
    return baos.toString(StandardCharsets.UTF_8.name());
  }

  static String validatorVersion(ValidationEngine engine) {
    String mavenVersion = GitbFhirHandler.class.getPackage().getImplementationVersion();
    if (mavenVersion != null && !mavenVersion.isEmpty()) return mavenVersion;
    String fhirVersion = engine != null ? engine.getVersion() : null;
    return fhirVersion != null ? "fhir-" + fhirVersion : "dev";
  }
}
