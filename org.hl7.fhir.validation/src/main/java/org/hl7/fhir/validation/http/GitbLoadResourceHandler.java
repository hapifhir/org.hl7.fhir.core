package org.hl7.fhir.validation.http;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.validation.ValidationEngine;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * GITB Processing Service for ad-hoc resource registration at {@code /itb/loadResource}.
 * Single operation: {@code loadResource}.
 *
 * <p>Inputs:
 * <ul>
 *   <li>{@code content} (required) — FHIR resource or {@code collection}/{@code batch}/{@code transaction} Bundle, serialised as JSON or XML.</li>
 *   <li>{@code format} (optional) — {@code json} (default) or {@code xml}.</li>
 *   <li>{@code replace} (optional, default {@code false}) — when true, a canonical resource whose URL is already in
 *       the context drops the existing copy first and then registers the new one. The authoring loop where the same
 *       map is iteratively re-submitted under the same canonical URL without bumping {@code version}.</li>
 * </ul>
 * Outputs:
 * <ul>
 *   <li>{@code loaded} — number of resources registered.</li>
 *   <li>{@code resources} — comma-separated list of {@code ResourceType/id (url|version)} descriptors.
 *       A same-URL re-submission is suffixed {@code (skipped, already in context)} when {@code replace=false},
 *       or {@code (replaced)} when {@code replace=true}.</li>
 * </ul>
 * Used to inject artifacts (e.g. a StructureMap parsed via {@code /itb/transform parse}) into the
 * validator's context so the {@code transform} operation can resolve them by canonical URL.</p>
 */
@Slf4j
class GitbLoadResourceHandler extends GitbProcessingServiceHandler {

  GitbLoadResourceHandler(FhirValidatorHttpService service) {
    super(service, "/itb/loadResource");
  }

  @Override
  protected JsonObject buildProcessingModule() {
    JsonObject inputs = typedParameters(
      new TypedParam("content", "binary",  true,  "FHIR resource or collection/batch/transaction Bundle, serialised as JSON or XML."),
      new TypedParam("format",  "string",  false, "Input format: json (default) or xml."),
      new TypedParam("replace", "boolean", false, "When true, overwrite an existing canonical resource that has the same URL. Default: false.")
    );
    JsonObject outputs = typedParameters(
      new TypedParam("loaded",    "number", true,  "Number of resources registered."),
      new TypedParam("resources", "string", false, "Comma-separated list of loaded resources.")
    );
    return processingModule(
      "ResourceLoader",
      metadata("FHIR Resource Loader", GitbFhirHandler.validatorVersion(service.getValidationEngine()),
        "Registers one or more FHIR resources in the running validator's context."),
      new ProcessingOperation("loadResource", inputs, outputs)
    );
  }

  @Override
  protected ProcessResult doProcess(String operation, JsonArray input, String sessionId) throws Exception {
    if (operation != null && !operation.isEmpty() && !"loadResource".equals(operation)) {
      throw new UnknownOperationException(operation, "loadResource");
    }
    String content = requireInput(input, "content");
    String formatStr = optionalInput(input, "format", "json");
    FhirFormat inputFormat = "xml".equalsIgnoreCase(formatStr) ? FhirFormat.XML : FhirFormat.JSON;
    boolean replace = optionalBooleanInput(input, "replace", false);

    ValidationEngine engine = service.getValidationEngine();
    List<String> loaded;
    try {
      loaded = engine.loadResourceFromBytes(content.getBytes(StandardCharsets.UTF_8), inputFormat, replace);
    } catch (Throwable t) {
      log.warn("GITB loadResource failed", t);
      throw new RuntimeException("loadResource failed: " + t.getMessage(), t);
    }

    JsonArray output = new JsonArray();
    output.add(anyContent("loaded", String.valueOf(loaded.size()), "text/plain"));
    output.add(anyContent("resources", String.join(", ", loaded), "text/plain"));
    return ProcessResult.ofOutput(output);
  }
}
