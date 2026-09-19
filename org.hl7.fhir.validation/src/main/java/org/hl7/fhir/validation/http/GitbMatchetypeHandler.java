package org.hl7.fhir.validation.http;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.validation.ValidationEngine;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

/**
 * GITB Validation Service for matchetype comparison at {@code /itb/matchetype}.
 * Single operation per the GITB validation service contract: {@code validate}.
 * <p>
 * Inputs: {@code contentToValidate} (the actual resource), {@code matchetype}
 * (the expected pattern), and an optional {@code mode} ({@code complete} or
 * {@code partial}).
 */
@Slf4j
class GitbMatchetypeHandler extends GitbValidationServiceHandler {

  GitbMatchetypeHandler(FhirValidatorHttpService service) {
    super(service, "/itb/matchetype");
  }

  @Override
  protected JsonObject buildValidationModule() {
    JsonObject inputs = typedParameters(
      new TypedParam("contentToValidate", "binary", true,  "Actual FHIR resource (JSON)."),
      new TypedParam("matchetype",        "binary", true,  "Expected pattern (JSON, may use $string$, $date$, $uuid$, $choice:...$ wildcards)."),
      new TypedParam("mode",              "string", false, "complete (default) or partial.")
    );
    return validationModule(
      "MatchetypeValidator",
      "validate",
      metadata("FHIR Matchetype Validator", GitbFhirHandler.validatorVersion(service.getValidationEngine()),
        "Compares a FHIR resource against an expected matchetype pattern."),
      inputs);
  }

  @Override
  protected JsonObject doValidate(JsonArray input, JsonArray config, String sessionId) {
    String resource = requireInput(input, "contentToValidate");
    String matchetype = requireInput(input, "matchetype");
    optionalInput(input, "mode", "complete");
    // Note: mode is currently advisory; the engine's compareMatchetype always
    // does a structural comparison. partial-mode behaviour is not yet wired.

    ValidationEngine engine = service.getValidationEngine();
    String engineVersion = GitbFhirHandler.validatorVersion(engine);

    OperationOutcome outcome;
    try {
      outcome = engine.compareMatchetype(
        resource.getBytes(StandardCharsets.UTF_8), FhirFormat.JSON,
        matchetype.getBytes(StandardCharsets.UTF_8), FhirFormat.JSON);
    } catch (Throwable t) {
      log.warn("GITB matchetype compare failed", t);
      return GitbTarBuilder.buildUndefinedTar("Matchetype comparison failed: " + t.getMessage(), sessionId, engineVersion);
    }

    String outcomeJson;
    try {
      outcomeJson = GitbFhirHandler.serializeOutcome(outcome);
    } catch (Throwable t) {
      return GitbTarBuilder.buildUndefinedTar("Could not serialise OperationOutcome: " + t.getMessage(), sessionId, engineVersion);
    }
    return GitbTarBuilder.buildValidationTar(outcome, outcomeJson, resource, "application/fhir+json", "error", sessionId, engineVersion);
  }
}
