package org.hl7.fhir.validation.http;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.validation.ValidationEngine;

import java.nio.charset.StandardCharsets;

/**
 * GITB Processing Service for generating a FHIR Questionnaire from a
 * StructureDefinition profile, at {@code /itb/questionnaire}. Single operation:
 * {@code generate}.
 *
 * <p>Wraps {@link ValidationEngine#generateQuestionnaire(String, FhirFormat)} —
 * the same engine path as the legacy native {@code GET /questionnaire?profile=&lt;url&gt;}
 * handler — exposed through the GITB processing-service contract so ITB can drive it.
 *
 * <p>The profile referenced by {@code profile} must be loadable from the
 * validator's context — load the IG containing it via {@code /itb/igManager}
 * {@code loadIG} first.</p>
 */
@Slf4j
class GitbQuestionnaireHandler extends GitbProcessingServiceHandler {

  GitbQuestionnaireHandler(FhirValidatorHttpService service) {
    super(service, "/itb/questionnaire");
  }

  @Override
  protected JsonObject buildProcessingModule() {
    JsonObject inputs = typedParameters(
      new TypedParam("profile",      "string", true,  "Canonical URL of the StructureDefinition profile to build a Questionnaire from."),
      new TypedParam("targetFormat", "string", false, "Output format: json (default) or xml."),
      new TypedParam("select",       "string", false, "Stringified JSON array of FHIRPath expressions, evaluated against each ElementDefinition of the profile snapshot. The Questionnaire is pruned to elements any expression matches (plus ancestors/descendants). e.g. [\"mustSupport = true\"] or [\"path = 'Patient.name'\"]. Omit for the whole profile.")
    );
    JsonObject outputs = typedParameters(
      new TypedParam("questionnaire", "binary", true,  "Generated FHIR Questionnaire as a string."),
      new TypedParam("targetMime",    "string", false, "MIME type of the result (application/fhir+json or application/fhir+xml).")
    );
    return processingModule(
      "QuestionnaireGenerator",
      metadata("FHIR Questionnaire Generator", GitbFhirHandler.validatorVersion(service.getValidationEngine()),
        "Generates a FHIR Questionnaire from a StructureDefinition profile, expanding coded elements' ValueSets as answer options."),
      new ProcessingOperation("generate", inputs, outputs)
    );
  }

  @Override
  protected ProcessResult doProcess(String operation, JsonArray input, String sessionId) throws Exception {
    if (operation != null && !operation.isEmpty() && !"generate".equals(operation)) {
      throw new UnknownOperationException(operation, "generate");
    }
    String profileUrl = requireInput(input, "profile");
    String targetFormatStr = optionalInput(input, "targetFormat", "json");
    FhirFormat outputFormat = "xml".equalsIgnoreCase(targetFormatStr) ? FhirFormat.XML : FhirFormat.JSON;

    String selectStr = optionalInput(input, "select", null);
    java.util.List<String> selectExpressions = null;
    if (selectStr != null && !selectStr.trim().isEmpty()) {
      org.hl7.fhir.utilities.json.model.JsonElement parsed;
      try {
        parsed = org.hl7.fhir.utilities.json.parser.JsonParser.parse(selectStr);
      } catch (Exception e) {
        throw new InvalidInputException("'select' must be a JSON array of FHIRPath expression strings: " + e.getMessage());
      }
      if (!parsed.isJsonArray()) {
        throw new InvalidInputException("'select' must be a JSON array of FHIRPath expression strings");
      }
      selectExpressions = new java.util.ArrayList<>();
      for (org.hl7.fhir.utilities.json.model.JsonElement el : parsed.asJsonArray()) {
        selectExpressions.add(el.asString());
      }
    }

    ValidationEngine engine = service.getValidationEngine();
    byte[] result;
    try {
      result = engine.generateQuestionnaire(profileUrl, outputFormat, selectExpressions);
    } catch (Throwable t) {
      log.warn("GITB questionnaire generation failed", t);
      throw new RuntimeException("Questionnaire generation failed: " + t.getMessage(), t);
    }

    String outMime = outputFormat == FhirFormat.XML ? "application/fhir+xml" : "application/fhir+json";
    JsonArray output = new JsonArray();
    output.add(anyContent("questionnaire", new String(result, StandardCharsets.UTF_8), outMime));
    output.add(anyContent("targetMime", outMime, "text/plain"));
    return ProcessResult.ofOutput(output);
  }
}
