package org.hl7.fhir.validation.http;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.validation.ValidationEngine;

/**
 * GITB Processing Service for IG management at {@code /itb/igManager}.
 * Operations: {@code loadIG} (idempotent: re-loading an already-loaded package
 * is a no-op).
 */
@Slf4j
class GitbIgManagerHandler extends GitbProcessingServiceHandler {

  GitbIgManagerHandler(FhirValidatorHttpService service) {
    super(service, "/itb/igManager");
  }

  @Override
  protected JsonObject buildProcessingModule() {
    JsonObject loadIgInputs = typedParameters(
      new TypedParam("ig", "string", true,
        "Package reference (e.g. hl7.fhir.be.core#2.1.2). #current resolves to the latest build.")
    );
    JsonObject loadIgOutputs = typedParameters(
      new TypedParam("loaded", "string", true, "Resolved package#version that was loaded.")
    );
    return processingModule(
      "IGManager",
      metadata("FHIR IG Manager", GitbFhirHandler.validatorVersion(service.getValidationEngine()),
        "Loads FHIR Implementation Guide packages into the validator engine."),
      new ProcessingOperation("loadIG", loadIgInputs, loadIgOutputs)
    );
  }

  @Override
  protected ProcessResult doProcess(String operation, JsonArray input, String sessionId) throws Exception {
    if (operation != null && !operation.isEmpty() && !"loadIG".equals(operation)) {
      throw new UnknownOperationException(operation, "loadIG");
    }
    String ig = requireInput(input, "ig");
    ValidationEngine engine = service.getValidationEngine();
    log.info("GITB loadIG: " + ig);
    engine.getIgLoader().loadIg(engine.getIgs(), engine.getBinaries(), ig, false);
    log.info("GITB loadIG complete: " + ig);

    JsonArray output = new JsonArray();
    output.add(anyContent("loaded", ig, "text/plain"));
    return ProcessResult.ofOutput(output);
  }
}
