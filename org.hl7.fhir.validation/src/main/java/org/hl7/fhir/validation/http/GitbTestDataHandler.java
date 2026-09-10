package org.hl7.fhir.validation.http;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.validation.ValidationEngine;

import java.nio.charset.StandardCharsets;

/**
 * GITB Processing Service for test-data generation and modification at {@code /itb/testdata}.
 * Operations:
 * <ul>
 *   <li>{@code generate}       — synthesise a single resource from a profile + mappings</li>
 *   <li>{@code generateBundle} — synthesise multiple resources wrapped in a Bundle</li>
 *   <li>{@code modify}         — apply set/add/remove ops to an existing resource,
 *                                optionally validating the result against a profile</li>
 * </ul>
 */
@Slf4j
class GitbTestDataHandler extends GitbProcessingServiceHandler {

  GitbTestDataHandler(FhirValidatorHttpService service) {
    super(service, "/itb/testdata");
  }

  @Override
  protected JsonObject buildProcessingModule() {
    JsonObject genInputs = typedParameters(
      new TypedParam("profile",      "string",  true,  "Canonical URL of the StructureDefinition to generate against."),
      new TypedParam("mappings",     "string",  false, "Optional stringified JSON array of mapping objects."),
      new TypedParam("data",         "string",  false, "Optional stringified JSON array of data rows."),
      new TypedParam("requiredOnly", "boolean", false, "When true, only populate required elements (min > 0). Default false.")
    );
    JsonObject genOutputs = typedParameters(
      new TypedParam("resource", "binary", true, "Generated FHIR resource as stringified JSON.")
    );

    JsonObject modifyInputs = typedParameters(
      new TypedParam("resource",   "binary",  true,  "Existing FHIR resource (stringified JSON) to modify."),
      new TypedParam("operations", "string",  true,  "Stringified JSON array of {op, path, value|parts} entries (op: set|add|remove)."),
      new TypedParam("profile",    "string",  false, "Optional canonical URL of a StructureDefinition for post-modification validation."),
      new TypedParam("enforce",    "boolean", false, "When true (default), validate the modified resource and return an OperationOutcome. When false, skip validation entirely.")
    );
    JsonObject modifyOutputs = typedParameters(
      new TypedParam("resource", "binary", true,  "Modified FHIR resource as stringified JSON."),
      new TypedParam("outcome",  "binary", false, "OperationOutcome from post-modification validation. Present iff enforce=true.")
    );

    return processingModule(
      "TestDataGenerator",
      metadata("FHIR Test Data Generator", GitbFhirHandler.validatorVersion(service.getValidationEngine()),
        "Synthesises and modifies FHIR resources against profiles."),
      new ProcessingOperation("generate",       genInputs,    genOutputs),
      new ProcessingOperation("generateBundle", genInputs,    genOutputs),
      new ProcessingOperation("modify",         modifyInputs, modifyOutputs)
    );
  }

  @Override
  protected ProcessResult doProcess(String operation, JsonArray input, String sessionId) throws Exception {
    if ("modify".equals(operation)) {
      return doModify(input);
    }
    boolean asBundle;
    if (operation == null || operation.isEmpty() || "generate".equals(operation)) {
      asBundle = false;
    } else if ("generateBundle".equals(operation)) {
      asBundle = true;
    } else {
      throw new UnknownOperationException(operation, "generate, generateBundle, modify");
    }
    return doGenerate(input, asBundle);
  }

  private ProcessResult doGenerate(JsonArray input, boolean asBundle) throws Exception {
    String profileUrl = requireInput(input, "profile");
    String mappingsStr = optionalInput(input, "mappings", null);
    String dataStr = optionalInput(input, "data", null);
    boolean requiredOnly = "true".equalsIgnoreCase(optionalInput(input, "requiredOnly", "false"));

    JsonArray data = parseArrayOrEmpty(dataStr);
    JsonArray mappings = parseArrayOrEmpty(mappingsStr);
    if (data.size() == 0) data.add(new JsonObject());

    ValidationEngine engine = service.getValidationEngine();
    byte[] result;
    try {
      result = engine.generateTestData(profileUrl, data,
        mappings.size() == 0 ? null : mappings, FhirFormat.JSON, asBundle, requiredOnly);
    } catch (Throwable t) {
      log.warn("GITB test-data generate failed", t);
      throw new RuntimeException("Test data generation failed: " + t.getMessage(), t);
    }

    JsonArray output = new JsonArray();
    output.add(anyContent("resource", new String(result, StandardCharsets.UTF_8), "application/fhir+json"));
    return ProcessResult.ofOutput(output);
  }

  private ProcessResult doModify(JsonArray input) throws Exception {
    String resource = requireInput(input, "resource");
    String operationsStr = requireInput(input, "operations");
    String profileUrl = optionalInput(input, "profile", null);
    boolean enforce = optionalBooleanInput(input, "enforce", true);

    JsonArray operations = parseArrayOrEmpty(operationsStr);
    if (operations.size() == 0) {
      throw new InvalidInputException("'operations' must be a non-empty JSON array");
    }

    ValidationEngine engine = service.getValidationEngine();
    ValidationEngine.ManipulationResult result;
    try {
      result = engine.manipulateResource(
        resource.getBytes(StandardCharsets.UTF_8),
        FhirFormat.JSON,
        profileUrl,
        operations,
        enforce,
        FhirFormat.JSON);
    } catch (Throwable t) {
      log.warn("GITB test-data modify failed", t);
      throw new RuntimeException("Modification failed: " + t.getMessage(), t);
    }

    JsonArray output = new JsonArray();
    output.add(anyContent("resource", new String(result.getResource(), StandardCharsets.UTF_8), "application/fhir+json"));
    OperationOutcome outcome = result.getOutcome();
    if (outcome != null) {
      String outcomeJson;
      try {
        outcomeJson = GitbFhirHandler.serializeOutcome(outcome);
      } catch (Throwable t) {
        throw new RuntimeException("Could not serialise OperationOutcome: " + t.getMessage(), t);
      }
      output.add(anyContent("outcome", outcomeJson, "application/fhir+json"));
    }
    return ProcessResult.ofOutput(output);
  }

  private static JsonArray parseArrayOrEmpty(String json) {
    if (json == null || json.trim().isEmpty()) return new JsonArray();
    try {
      JsonElement parsed = JsonParser.parse(json);
      if (!parsed.isJsonArray()) {
        throw new InvalidInputException("Expected JSON array");
      }
      return parsed.asJsonArray();
    } catch (InvalidInputException e) {
      throw e;
    } catch (Exception e) {
      throw new InvalidInputException("Invalid JSON array: " + e.getMessage());
    }
  }
}
