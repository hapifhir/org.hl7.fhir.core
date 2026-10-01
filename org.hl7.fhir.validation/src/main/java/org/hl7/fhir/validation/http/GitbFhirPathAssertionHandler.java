package org.hl7.fhir.validation.http;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.validation.ValidationEngine;

import java.nio.charset.StandardCharsets;

/**
 * GITB Validation Service for FHIRPath boolean assertions at
 * {@code /itb/fhirPathAssertion}. Single operation per the GITB validation
 * service contract: {@code validate}.
 * <p>
 * The expression is expected to evaluate to a singleton Boolean. The TAR
 * result is {@code SUCCESS} when {@code true}, {@code FAILURE} otherwise
 * (including {@code false}, an empty collection, or a non-Boolean value).
 */
@Slf4j
class GitbFhirPathAssertionHandler extends GitbValidationServiceHandler {

  GitbFhirPathAssertionHandler(FhirValidatorHttpService service) {
    super(service, "/itb/fhirPathAssertion");
  }

  @Override
  protected JsonObject buildValidationModule() {
    JsonObject inputs = typedParameters(
      new TypedParam("contentToValidate", "binary", true, "FHIR resource the expression is evaluated against."),
      new TypedParam("expression",         "string", true, "FHIRPath expression that should evaluate to a singleton Boolean."),
      new TypedParam("description",        "string", false, "Free-text description of the invariant being asserted; copied to the TAR item.")
    );
    return validationModule(
      "FHIRPathAssertion",
      "validate",
      metadata("FHIR FHIRPath Assertion", GitbFhirHandler.validatorVersion(service.getValidationEngine()),
        "Asserts that a FHIRPath expression evaluates to true on a given resource."),
      inputs);
  }

  @Override
  protected JsonObject doValidate(JsonArray input, JsonArray config, String sessionId) {
    String content = requireInput(input, "contentToValidate");
    String expression = requireInput(input, "expression");
    String description = optionalInput(input, "description", null);
    ValidationEngine engine = service.getValidationEngine();
    String engineVersion = GitbFhirHandler.validatorVersion(engine);

    String result;
    try {
      result = engine.evaluateFhirPath(content.getBytes(StandardCharsets.UTF_8), FhirFormat.JSON, expression);
    } catch (Throwable t) {
      log.warn("FHIRPath assertion evaluation failed", t);
      return GitbTarBuilder.buildUndefinedTar("FHIRPath evaluation failed: " + t.getMessage(), sessionId, engineVersion);
    }

    JsonArray context = new JsonArray();
    context.add(GitbServiceHandler.anyContent("content", content, "application/fhir+json"));
    context.add(GitbServiceHandler.anyContent("expression", expression, "text/plain"));
    if (result != null) context.add(GitbServiceHandler.anyContent("result", result, "text/plain"));

    if ("true".equalsIgnoreCase(result)) {
      String desc = description != null ? description : "Expression evaluated to true";
      return GitbTarBuilder.buildSimpleTar("SUCCESS", desc, "INFO", context, sessionId, engineVersion);
    }
    String reason = (result == null || result.isEmpty())
      ? "Expression returned empty result"
      : ("false".equalsIgnoreCase(result)
          ? "Expression evaluated to false"
          : "Expression did not evaluate to a Boolean: " + result);
    String desc = description != null ? description + " — " + reason : reason;
    return GitbTarBuilder.buildSimpleTar("FAILURE", desc, "ERROR", context, sessionId, engineVersion);
  }
}
