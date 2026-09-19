package org.hl7.fhir.validation.http;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.validation.ValidationEngine;

import java.nio.charset.StandardCharsets;

/**
 * GITB Processing Service for FHIR StructureMap operations at {@code /itb/transform}.
 * Operations:
 * <ul>
 *   <li>{@code transform} — apply a (loaded) StructureMap to a source resource</li>
 *   <li>{@code parse}     — parse FHIR Mapping Language (FML) text into a StructureMap resource</li>
 * </ul>
 *
 * <p>Both wrap the same engine machinery used by the legacy native handlers
 * ({@code POST /transform?map=<uri>} and {@code POST /fml}), exposed through the
 * GITB processing-service contract so ITB can drive them.</p>
 *
 * <p>For {@code transform}, the {@code StructureMap} referenced by {@code map} must be
 * loadable from the validator's context — load any IG containing the map via
 * {@code /itb/igManager} {@code loadIG} first.</p>
 */
@Slf4j
class GitbTransformHandler extends GitbProcessingServiceHandler {

  GitbTransformHandler(FhirValidatorHttpService service) {
    super(service, "/itb/transform");
  }

  @Override
  protected JsonObject buildProcessingModule() {
    JsonObject transformInputs = typedParameters(
      new TypedParam("content",     "binary", true,  "Source FHIR resource as JSON or XML."),
      new TypedParam("map",         "string", true,  "Canonical URL of the StructureMap to apply."),
      new TypedParam("contentType", "string", false, "MIME type of content (defaults to application/fhir+json)."),
      new TypedParam("targetFormat","string", false, "Output format: json (default) or xml.")
    );
    JsonObject transformOutputs = typedParameters(
      new TypedParam("result",     "binary", true,  "Transformed FHIR resource as a string."),
      new TypedParam("targetMime", "string", false, "MIME type of the result (application/fhir+json or application/fhir+xml).")
    );

    JsonObject parseInputs = typedParameters(
      new TypedParam("content",      "binary", true,  "FHIR Mapping Language (FML) map source text."),
      new TypedParam("name",         "string", false, "Name for the source, used in parse error messages (defaults to 'map')."),
      new TypedParam("targetFormat", "string", false, "Output format: json (default) or xml.")
    );
    JsonObject parseOutputs = typedParameters(
      new TypedParam("structureMap", "binary", true,  "Parsed StructureMap resource as a string."),
      new TypedParam("targetMime",   "string", false, "MIME type of the result (application/fhir+json or application/fhir+xml).")
    );

    return processingModule(
      "FHIRTransformer",
      metadata("FHIR StructureMap Transformer", GitbFhirHandler.validatorVersion(service.getValidationEngine()),
        "Applies and parses FHIR StructureMaps (FHIR Mapping Language)."),
      new ProcessingOperation("transform", transformInputs, transformOutputs),
      new ProcessingOperation("parse",     parseInputs,     parseOutputs)
    );
  }

  @Override
  protected ProcessResult doProcess(String operation, JsonArray input, String sessionId) throws Exception {
    if ("parse".equals(operation)) {
      return doParse(input);
    }
    if (operation != null && !operation.isEmpty() && !"transform".equals(operation)) {
      throw new UnknownOperationException(operation, "transform, parse");
    }
    return doTransform(input);
  }

  private ProcessResult doTransform(JsonArray input) throws Exception {
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

  private ProcessResult doParse(JsonArray input) throws Exception {
    String fml = requireInput(input, "content");
    String name = optionalInput(input, "name", "map");
    String targetFormatStr = optionalInput(input, "targetFormat", "json");
    FhirFormat outputFormat = "xml".equalsIgnoreCase(targetFormatStr) ? FhirFormat.XML : FhirFormat.JSON;

    ValidationEngine engine = service.getValidationEngine();
    byte[] result;
    try {
      result = engine.parseStructureMap(fml, name, outputFormat);
    } catch (Throwable t) {
      log.warn("GITB FML parse failed", t);
      throw new RuntimeException("FML parse failed: " + t.getMessage(), t);
    }

    String outMime = outputFormat == FhirFormat.XML ? "application/fhir+xml" : "application/fhir+json";
    JsonArray output = new JsonArray();
    output.add(anyContent("structureMap", new String(result, StandardCharsets.UTF_8), outMime));
    output.add(anyContent("targetMime", outMime, "text/plain"));
    return ProcessResult.ofOutput(output);
  }
}
