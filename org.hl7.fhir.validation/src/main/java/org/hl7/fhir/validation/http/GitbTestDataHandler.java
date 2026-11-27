package org.hl7.fhir.validation.http;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.model.utilities.formats.FhirFormat;
import org.hl7.fhir.model.core.OperationOutcome;
import org.hl7.fhir.model.ModelContext;
import java.util.ArrayList;
import java.util.List;
import org.hl7.fhir.model.core.Parameters;
import org.hl7.fhir.model.core.Resource;
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
      new TypedParam("operations", "string",  true,  "A FHIRPath Patch: a Parameters resource (stringified JSON) of add / insert / delete / replace / move operations, as accepted on PATCH by a FHIR server."),
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

    Parameters patch = parsePatch(operationsStr);

    ValidationEngine engine = service.getValidationEngine();
    byte[] patched;
    try {
      patched = engine.patchResource(resource.getBytes(StandardCharsets.UTF_8), FhirFormat.JSON, patch, FhirFormat.JSON);
    } catch (Throwable t) {
      log.warn("GITB test-data modify failed", t);
      throw new RuntimeException("Modification failed: " + t.getMessage(), t);
    }

    JsonArray output = new JsonArray();
    output.add(anyContent("resource", new String(patched, StandardCharsets.UTF_8), "application/fhir+json"));
    if (enforce) {
      // the patch itself checks nothing; the caller asked for the result to be validated
      List<String> profiles = new ArrayList<>();
      if (profileUrl != null) {
        profiles.add(profileUrl);
      }
      OperationOutcome outcome;
      try {
        outcome = engine.validate(patched, FhirFormat.JSON, profiles, new ArrayList<>());
      } catch (Throwable t) {
        log.warn("GITB test-data modify: validation of the result failed", t);
        throw new RuntimeException("Validation of the modified resource failed: " + t.getMessage(), t);
      }
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

  /** The operations input: a FHIRPath Patch, which is a Parameters resource in JSON. */
  private static Parameters parsePatch(String json) {
    if (json == null || json.trim().isEmpty()) {
      throw new InvalidInputException("'operations' must be a FHIRPath Patch: a Parameters resource in JSON");
    }
    Resource parsed;
    try {
      parsed = new org.hl7.fhir.model.core.formats.JsonParser(ModelContext.fullCoreContext()).parse(json);
    } catch (Exception e) {
      throw new InvalidInputException("'operations' is not a FHIR resource in JSON: " + e.getMessage());
    }
    if (!(parsed instanceof Parameters)) {
      throw new InvalidInputException("'operations' must be a Parameters resource (a FHIRPath Patch), not " + parsed.fhirType());
    }
    Parameters patch = (Parameters) parsed;
    if (patch.getParameterList().isEmpty()) {
      throw new InvalidInputException("'operations' holds no operation");
    }
    return patch;
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
