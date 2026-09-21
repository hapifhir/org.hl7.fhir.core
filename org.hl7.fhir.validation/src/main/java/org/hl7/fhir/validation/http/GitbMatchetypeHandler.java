package org.hl7.fhir.validation.http;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.special.TxTesterNormalizer;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

/**
 * GITB Validation Service for matchetype comparison at {@code /itb/matchetype}.
 * Single operation per the GITB validation service contract: {@code validate}.
 * <p>
 * Inputs: {@code contentToValidate} (the actual resource), {@code matchetype}, optional {@code normalize} ("tx"),
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
      new TypedParam("normalize",         "string", false, "Optional. \"tx\": before comparing, normalise contentToValidate with the rules the validator's terminology test runner uses - server detail such as narrative, meta and diagnostics removed; parameters, parts, expansion contents, designations and issues sorted. Use it whenever the comparison should not fail on array order or server detail: comparing a terminology server's answer with the HL7 terminology test set's expected files is the case it was built for, but it applies to any Parameters, ValueSet, OperationOutcome, CapabilityStatement, TerminologyCapabilities or ConceptMap. Applies to contentToValidate only; the matchetype is used as given. Absent: compared as given."),
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
    String normalize = optionalInput(input, "normalize", null);
    if (normalize != null && !"tx".equals(normalize)) {
      throw new InvalidInputException("Unknown normalize value '" + normalize + "'; supported: tx");
    }
    // Note: mode is currently advisory; the engine's compareMatchetype always
    // does a structural comparison. partial-mode behaviour is not yet wired.

    ValidationEngine engine = service.getValidationEngine();
    String engineVersion = GitbFhirHandler.validatorVersion(engine);

    byte[] actual = resource.getBytes(StandardCharsets.UTF_8);
    if ("tx".equals(normalize)) {
      // Scrub and sort the actual with the terminology test runner's rules - the form the
      // HL7 terminology test set's expected files are stored in, and a sensible form for any
      // comparison that should not fail on array order or server detail. The actual only,
      // never the matchetype. The report echoes what was compared.
      try {
        actual = TxTesterNormalizer.normalizeJson(engine.getContext().getModelContext(), actual, false);
        resource = new String(actual, StandardCharsets.UTF_8);
      } catch (Throwable t) {
        return GitbTarBuilder.buildUndefinedTar("Could not normalise contentToValidate as a terminology response: " + t.getMessage(), sessionId, engineVersion);
      }
    }

    OperationOutcome outcome;
    try {
      outcome = engine.compareMatchetype(
        actual, FhirFormat.JSON,
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
