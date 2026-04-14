package org.hl7.fhir.validation.http;

import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.utilities.json.model.JsonObject;

/**
 * GITB-compatible FHIRPath processing service.
 * Wraps the existing /fhirpath endpoint with expression in the POST body.
 */
class GitbFhirPathHandler extends GitbServiceHandler {

  GitbFhirPathHandler(FhirValidatorHttpService fhirValidatorHttpService) {
    super(fhirValidatorHttpService);
  }

  @Override
  protected JsonObject buildDefinition() {
    return definition("FHIRPathProcessor",
      new String[]{"evaluate"},
      new InputDef[]{
        new InputDef("resource", "string", true),
        new InputDef("expression", "string", true)
      },
      new String[]{"result"});
  }

  @Override
  protected JsonObject doProcess(String operation, JsonObject inputs) throws Exception {
    if (!"evaluate".equals(operation)) {
      return failure("Unknown operation: " + operation + ". Supported: evaluate");
    }

    String resource = requireInput(inputs, "resource");
    String expression = requireInput(inputs, "expression");

    String result = fhirValidatorHttpService.getValidationEngine()
      .evaluateFhirPath(resource.getBytes(java.nio.charset.StandardCharsets.UTF_8), FhirFormat.JSON, expression);

    JsonObject output = new JsonObject();
    output.add("result", result);
    return success(output);
  }
}
