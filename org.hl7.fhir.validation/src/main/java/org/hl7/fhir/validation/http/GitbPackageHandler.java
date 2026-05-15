package org.hl7.fhir.validation.http;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.validation.ValidationEngine;

import java.nio.charset.StandardCharsets;

/**
 * GITB Processing Service for the CRMI {@code $package} operation at
 * {@code /itb/package}. Single operation: {@code package}.
 *
 * <p>Given a root canonical artifact, returns a {@code collection} Bundle containing
 * that artifact plus every artifact it transitively references — profiles, extensions,
 * ValueSets, CodeSystems, Library, ActivityDefinition, PlanDefinition, ConceptMap,
 * NamingSystem, etc. Core FHIR resources are not included. Wraps
 * {@link ValidationEngine#packageResource(String, boolean, FhirFormat)}, the same engine
 * path as the legacy native {@code GET /package?url=<uri>} handler.
 *
 * <p>The root artifact and its dependencies must be loadable from the validator's
 * context — load the IG(s) via {@code /itb/igManager} {@code loadIG} first.</p>
 */
@Slf4j
class GitbPackageHandler extends GitbProcessingServiceHandler {

  GitbPackageHandler(FhirValidatorHttpService service) {
    super(service, "/itb/package");
  }

  @Override
  protected JsonObject buildProcessingModule() {
    JsonObject inputs = typedParameters(
      new TypedParam("resource",        "string",  true,  "Canonical URL of the root artifact to package."),
      new TypedParam("expandValueSets", "boolean", false, "When true, ValueSet entries are replaced by their expansion. Default false."),
      new TypedParam("targetFormat",    "string",  false, "Output format: json (default) or xml.")
    );
    JsonObject outputs = typedParameters(
      new TypedParam("bundle",     "binary", true,  "Collection Bundle of the artifact and its transitive dependencies."),
      new TypedParam("targetMime", "string", false, "MIME type of the result (application/fhir+json or application/fhir+xml).")
    );
    return processingModule(
      "PackageGenerator",
      metadata("FHIR Artifact Packager", GitbFhirHandler.validatorVersion(service.getValidationEngine()),
        "CRMI $package — bundles a canonical artifact with all its transitive dependencies."),
      new ProcessingOperation("package", inputs, outputs)
    );
  }

  @Override
  protected ProcessResult doProcess(String operation, JsonArray input, String sessionId) throws Exception {
    if (operation != null && !operation.isEmpty() && !"package".equals(operation)) {
      throw new UnknownOperationException(operation, "package");
    }
    String rootUrl = requireInput(input, "resource");
    boolean expandValueSets = optionalBooleanInput(input, "expandValueSets", false);
    String targetFormatStr = optionalInput(input, "targetFormat", "json");
    FhirFormat outputFormat = "xml".equalsIgnoreCase(targetFormatStr) ? FhirFormat.XML : FhirFormat.JSON;

    ValidationEngine engine = service.getValidationEngine();
    byte[] result;
    try {
      result = engine.packageResource(rootUrl, expandValueSets, outputFormat);
    } catch (Throwable t) {
      log.warn("GITB package failed", t);
      throw new RuntimeException("Package failed: " + t.getMessage(), t);
    }

    String outMime = outputFormat == FhirFormat.XML ? "application/fhir+xml" : "application/fhir+json";
    JsonArray output = new JsonArray();
    output.add(anyContent("bundle", new String(result, StandardCharsets.UTF_8), outMime));
    output.add(anyContent("targetMime", outMime, "text/plain"));
    return ProcessResult.ofOutput(output);
  }
}
