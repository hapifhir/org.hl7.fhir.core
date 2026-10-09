package org.hl7.fhir.validation.http;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.validation.ValidationEngine;

import java.nio.charset.StandardCharsets;

/**
 * GITB Processing Service for FHIRPath evaluation at {@code /itb/fhirPath}.
 * Single operation: {@code evaluate}. Boolean assertion semantics are exposed
 * separately as the {@link GitbFhirPathAssertionHandler} validation service.
 */
@Slf4j
class GitbFhirPathHandler extends GitbProcessingServiceHandler {

  GitbFhirPathHandler(FhirValidatorHttpService service) {
    super(service, "/itb/fhirPath");
  }

  @Override
  protected JsonObject buildProcessingModule() {
    JsonObject inputs = typedParameters(
      new TypedParam("content",    "binary", true,  "FHIR resource (or other FHIRPath context) as JSON."),
      new TypedParam("expression", "string", true,  "FHIRPath expression to evaluate.")
    );
    JsonObject outputs = typedParameters(
      new TypedParam("result", "string", true, "Stringified result of the evaluation.")
    );
    return processingModule(
      "FHIRPathProcessor",
      metadata("FHIR FHIRPath Processor", GitbFhirHandler.validatorVersion(service.getValidationEngine()),
        "Evaluates FHIRPath expressions over a FHIR resource."),
      new ProcessingOperation("evaluate", inputs, outputs)
    );
  }

  @Override
  protected ProcessResult doProcess(String operation, JsonArray input, String sessionId) throws Exception {
    if (operation != null && !operation.isEmpty() && !"evaluate".equals(operation)) {
      throw new UnknownOperationException(operation, "evaluate");
    }
    String content = requireInput(input, "content");
    String expression = requireInput(input, "expression");

    ValidationEngine engine = service.getValidationEngine();
    String result;
    try {
      result = engine.evaluateFhirPath(content.getBytes(StandardCharsets.UTF_8), FhirFormat.JSON, expression);
    } catch (Throwable t) {
      throw new RuntimeException("FHIRPath evaluation failed: " + t.getMessage(), t);
    }

    JsonArray output = new JsonArray();
    output.add(anyContent("result", result == null ? "" : result, "text/plain"));
    return ProcessResult.ofOutput(output);
  }
}
