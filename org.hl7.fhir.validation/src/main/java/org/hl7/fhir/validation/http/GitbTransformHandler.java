package org.hl7.fhir.validation.http;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.validation.ValidationEngine;

import java.nio.charset.StandardCharsets;

/**
 * GITB Processing Service for FHIR StructureMap transformation at
 * {@code /itb/transform}. Single operation: {@code transform}.
 *
 * <p>Wraps the same {@link ValidationEngine#transform(byte[], FhirFormat, String, FhirFormat)}
 * machinery used by the legacy native {@code POST /transform?map=&lt;uri&gt;} handler,
 * but exposes it through the GITB processing-service contract so ITB can drive it.
 *
 * <p>The {@code StructureMap} referenced by {@code map} must be loadable from
 * the validator's context — load any IG containing the map via
 * {@code /itb/igManager} {@code loadIG} first.</p>
 */
@Slf4j
class GitbTransformHandler extends GitbProcessingServiceHandler {

  GitbTransformHandler(FhirValidatorHttpService service) {
    super(service, "/itb/transform");
  }

  @Override
  protected JsonObject buildProcessingModule() {
    JsonObject inputs = typedParameters(
      new TypedParam("content",     "binary", true,  "Source FHIR resource as JSON or XML."),
      new TypedParam("map",         "string", true,  "Canonical URL of the StructureMap to apply."),
      new TypedParam("contentType", "string", false, "MIME type of content (defaults to application/fhir+json)."),
      new TypedParam("targetFormat","string", false, "Output format: json (default) or xml.")
    );
    JsonObject outputs = typedParameters(
      new TypedParam("result",     "binary", true,  "Transformed FHIR resource as a string."),
      new TypedParam("targetMime", "string", false, "MIME type of the result (application/fhir+json or application/fhir+xml).")
    );
    return processingModule(
      "FHIRTransformer",
      metadata("FHIR StructureMap Transformer", GitbFhirHandler.validatorVersion(service.getValidationEngine()),
        "Applies a FHIR StructureMap (Mapping Language) transformation to a FHIR resource."),
      new ProcessingOperation("transform", inputs, outputs)
    );
  }

  @Override
  protected ProcessResult doProcess(String operation, JsonArray input, String sessionId) throws Exception {
    if (operation != null && !operation.isEmpty() && !"transform".equals(operation)) {
      throw new UnknownOperationException(operation, "transform");
    }
    String content = requireInput(input, "content");
    String mapUri = requireInput(input, "map");
    String contentType = optionalInput(input, "contentType", "application/fhir+json");
    String targetFormatStr = optionalInput(input, "targetFormat", "json");

    FhirFormat inputFormat = GitbFhirHandler.formatFor(contentType);
    FhirFormat outputFormat = "xml".equalsIgnoreCase(targetFormatStr) ? FhirFormat.XML : FhirFormat.JSON;

    ValidationEngine engine = service.getValidationEngine();
    byte[] result;
    try {
      result = engine.transform(content.getBytes(StandardCharsets.UTF_8), inputFormat, mapUri, outputFormat);
    } catch (Throwable t) {
      log.warn("GITB transform failed", t);
      throw new RuntimeException("Transform failed: " + t.getMessage(), t);
    }

    String outMime = outputFormat == FhirFormat.XML ? "application/fhir+xml" : "application/fhir+json";
    JsonArray output = new JsonArray();
    output.add(anyContent("result", new String(result, StandardCharsets.UTF_8), outMime));
    output.add(anyContent("targetMime", outMime, "text/plain"));
    return ProcessResult.ofOutput(output);
  }
}
