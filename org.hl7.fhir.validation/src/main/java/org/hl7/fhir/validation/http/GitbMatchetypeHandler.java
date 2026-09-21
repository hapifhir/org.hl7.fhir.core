package org.hl7.fhir.validation.http;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.special.TxTesterNormalizer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * GITB Validation Service for matchetype comparison at {@code /itb/matchetype}.
 * Single operation per the GITB validation service contract: {@code validate}.
 * <p>
 * Inputs: {@code contentToValidate} (the actual resource) and {@code matchetype} (the expected
 * pattern); optional {@code mode} ({@code complete} or {@code partial}), {@code normalize}
 * ("tx"), {@code version} (the FHIR version of the actual) and {@code modes}.
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
      new TypedParam("matchetype",        "binary", true,  "Expected pattern (JSON, may use $string$, $date$, $uuid$, $choice:...$ wildcards, and the $optional$, $optional-properties$, $only$ and $count-arrays$ markers). Content the validator's FHIR version does not define is reported, not ignored."),
      new TypedParam("normalize",         "string", false, "Optional. \"tx\": before comparing, normalise contentToValidate with the rules the validator's terminology test runner uses - server detail such as narrative, meta and diagnostics removed; parameters, parts, expansion contents, designations and issues sorted. Use it whenever the comparison should not fail on array order or server detail: comparing a terminology server's answer with the HL7 terminology test set's expected files is the case it was built for, but it applies to any Parameters, ValueSet, OperationOutcome, CapabilityStatement or TerminologyCapabilities. Applies to contentToValidate only; the matchetype is used as given. Absent: compared as given."),
      new TypedParam("mode",              "string", false, "complete (default): the resource must match the matchetype exactly, apart from the matchetype's own wildcards. partial: the matchetype is a subset the resource must contain - elements and array entries it does not mention are allowed in the resource. This is what the validator's terminology test runner uses for the metadata and terminology-capabilities tests, whose expected files list only what every server must offer."),
      new TypedParam("version",           "string", false, "Optional. The FHIR version contentToValidate is in (3.0, 4.0, 4.3, 5.0 or 6.0, with or without a patch number, e.g. 4.0.1). When it differs from the validator's own version, contentToValidate is converted to that version first - the way the terminology test runner converts a server's answer - so an R4 server's answer compares against an R5-shaped expected file, with R4's cross-version extensions becoming the R5 elements they stand for. It is also the version the matchetype's version filters ($only$: \"version:4\", $version$) are evaluated against. Absent: no conversion, and no version filter passes."),
      new TypedParam("modes",             "string", false, "Optional. Comma-separated modes the matchetype's mode filters are evaluated against, e.g. tx.fhir.org: an item marked $optional$: \"tx.fhir.org\" is optional only when that mode is given, one marked \"!tx.fhir.org\" only when it is not. Absent: no modes, so negated filters pass and named ones do not.")
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
    String mode = optionalInput(input, "mode", "complete");
    if (!"complete".equals(mode) && !"partial".equals(mode)) {
      throw new InvalidInputException("Unknown mode '" + mode + "'; supported: complete, partial");
    }
    String normalize = optionalInput(input, "normalize", null);
    if (normalize != null && !"tx".equals(normalize)) {
      throw new InvalidInputException("Unknown normalize value '" + normalize + "'; supported: tx");
    }
    String version = optionalInput(input, "version", null);
    if (version != null && !isSupportedVersion(version)) {
      throw new InvalidInputException("Unknown version '" + version + "'; supported: 3.0, 4.0, 4.3, 5.0, 6.0 (with or without a patch number)");
    }
    Set<String> modes = new HashSet<>();
    String modesInput = optionalInput(input, "modes", null);
    if (modesInput != null) {
      for (String m : modesInput.split(",")) {
        if (!m.trim().isEmpty()) {
          modes.add(m.trim());
        }
      }
    }

    ValidationEngine engine = service.getValidationEngine();
    String engineVersion = GitbFhirHandler.validatorVersion(engine);

    byte[] actual = resource.getBytes(StandardCharsets.UTF_8);
    String targetVersion = engine.getVersion() == null ? "5.0.0" : engine.getVersion();
    if (version != null) {
      // The actual is in the server's version; the comparison happens in the validator's.
      // Convert first, as the terminology test runner converts a server's answer, so that
      // for instance an R4 expansion's cross-version extensions become the R5 elements the
      // expected file lists. The report echoes what was compared.
      try {
        actual = convertToVersion(actual, version, targetVersion);
        resource = new String(actual, StandardCharsets.UTF_8);
      } catch (Throwable t) {
        return GitbTarBuilder.buildUndefinedTar("Could not convert contentToValidate from FHIR " + version + " to " + targetVersion + ": " + t.getMessage(), sessionId, engineVersion);
      }
    }
    if ("tx".equals(normalize)) {
      // Scrub and sort the actual with the terminology test runner's rules - the form the
      // HL7 terminology test set's expected files are stored in, and a sensible form for any
      // comparison that should not fail on array order or server detail. The actual only,
      // never the matchetype. The report echoes what was compared.
      try {
        actual = TxTesterNormalizer.normalizeJson(actual, false);
        resource = new String(actual, StandardCharsets.UTF_8);
      } catch (Throwable t) {
        return GitbTarBuilder.buildUndefinedTar("Could not normalise contentToValidate: " + t.getMessage(), sessionId, engineVersion);
      }
    }

    Map<String, String> variables = new HashMap<>();
    if (version != null) {
      variables.put("version", version);
    }
    OperationOutcome outcome;
    try {
      outcome = engine.compareMatchetype(
        actual, FhirFormat.JSON,
        matchetype.getBytes(StandardCharsets.UTF_8), FhirFormat.JSON,
        "partial".equals(mode), modes, variables);
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

  static boolean isSupportedVersion(String version) {
    return VersionUtilities.isR3Ver(version) || VersionUtilities.isR4Ver(version) || VersionUtilities.isR4BVer(version)
      || VersionUtilities.isR5Ver(version) || VersionUtilities.isR6Ver(version);
  }

  /**
   * Convert a JSON resource from one FHIR version to another through the R5 model, with the
   * version convertors the validator uses everywhere else. Returns the input unchanged when
   * the two versions are the same publication (R5 and R6 share the model here).
   */
  static byte[] convertToVersion(byte[] json, String from, String to) throws IOException {
    if (sameModel(from, to)) {
      return json;
    }
    org.hl7.fhir.r5.model.Resource r5;
    if (VersionUtilities.isR4Ver(from)) {
      r5 = org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50.convertResource(new org.hl7.fhir.r4.formats.JsonParser().parse(json));
    } else if (VersionUtilities.isR4BVer(from)) {
      r5 = org.hl7.fhir.convertors.factory.VersionConvertorFactory_43_50.convertResource(new org.hl7.fhir.r4b.formats.JsonParser().parse(json));
    } else if (VersionUtilities.isR3Ver(from)) {
      r5 = org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50.convertResource(new org.hl7.fhir.dstu3.formats.JsonParser().parse(json));
    } else {
      r5 = new org.hl7.fhir.r5.formats.JsonParser().parse(json);
    }
    if (VersionUtilities.isR4Ver(to)) {
      return new org.hl7.fhir.r4.formats.JsonParser().composeBytes(org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50.convertResource(r5));
    } else if (VersionUtilities.isR4BVer(to)) {
      return new org.hl7.fhir.r4b.formats.JsonParser().composeBytes(org.hl7.fhir.convertors.factory.VersionConvertorFactory_43_50.convertResource(r5));
    } else if (VersionUtilities.isR3Ver(to)) {
      return new org.hl7.fhir.dstu3.formats.JsonParser().composeBytes(org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50.convertResource(r5));
    } else {
      return new org.hl7.fhir.r5.formats.JsonParser().composeBytes(r5);
    }
  }

  private static boolean sameModel(String v1, String v2) {
    return (VersionUtilities.isR3Ver(v1) && VersionUtilities.isR3Ver(v2))
      || (VersionUtilities.isR4Ver(v1) && VersionUtilities.isR4Ver(v2))
      || (VersionUtilities.isR4BVer(v1) && VersionUtilities.isR4BVer(v2))
      || (VersionUtilities.isR5Plus(v1) && VersionUtilities.isR5Plus(v2));
  }
}
