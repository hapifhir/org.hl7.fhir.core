package org.hl7.fhir.validation.http;

import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;

import java.nio.charset.StandardCharsets;

/**
 * GITB-compatible test data generation service.
 * Wraps the existing /testdata endpoint.
 */
class GitbTestDataHandler extends GitbServiceHandler {

  GitbTestDataHandler(FhirValidatorHttpService fhirValidatorHttpService) {
    super(fhirValidatorHttpService);
  }

  @Override
  protected JsonObject buildDefinition() {
    return definition("TestDataGenerator",
      new String[]{"generate", "generateBundle"},
      new InputDef[]{
        new InputDef("profile", "string", true),
        new InputDef("mappings", "string", false),
        new InputDef("data", "string", false),
        new InputDef("bundle", "string", false)
      },
      new String[]{"resource"});
  }

  @Override
  protected JsonObject doProcess(String operation, JsonObject inputs) throws Exception {
    switch (operation) {
      case "generate": return doGenerate(inputs, false);
      case "generateBundle": return doGenerate(inputs, true);
      default: return failure("Unknown operation: " + operation + ". Supported: generate, generateBundle");
    }
  }

  private JsonObject doGenerate(JsonObject inputs, boolean asBundle) throws Exception {
    String profile = requireInput(inputs, "profile");
    String mappingsStr = optionalInput(inputs, "mappings", null);
    String dataStr = optionalInput(inputs, "data", null);

    JsonArray mappings = null;
    if (mappingsStr != null) {
      JsonElement el = org.hl7.fhir.utilities.json.parser.JsonParser.parse(mappingsStr);
      if (el instanceof JsonArray) mappings = (JsonArray) el;
    }
    JsonArray data = null;
    if (dataStr != null) {
      JsonElement el = org.hl7.fhir.utilities.json.parser.JsonParser.parse(dataStr);
      if (el instanceof JsonArray) data = (JsonArray) el;
    }
    if (data == null || data.size() == 0) {
      data = new JsonArray();
      data.add(new JsonObject());
    }

    byte[] result = fhirValidatorHttpService.getValidationEngine()
      .generateTestData(profile, data, mappings, FhirFormat.JSON, asBundle);

    JsonObject output = new JsonObject();
    output.add("resource", new String(result, StandardCharsets.UTF_8));
    return success(output);
  }
}
