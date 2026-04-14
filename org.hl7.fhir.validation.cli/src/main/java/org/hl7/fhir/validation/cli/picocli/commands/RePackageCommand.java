package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.PackageClient;
import org.hl7.fhir.utilities.npm.PackageInfo;
import org.hl7.fhir.utilities.npm.PackageServer;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.picocli.options.InstanceValidatorOptions;
import org.hl7.fhir.validation.cli.picocli.options.InstanceValidatorOptionsConvertor;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import org.hl7.fhir.validation.special.PackageReGenerator;
import org.hl7.fhir.validation.special.PackageReGenerator.ExpansionPackageGeneratorOutputType;
import org.hl7.fhir.validation.special.PackageReGenerator.ExpansionPackageGeneratorScope;
import picocli.CommandLine;

import javax.annotation.Nonnull;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;

/**
 * Command to regenerate FHIR packages with terminology and conformance resources.
 * <p/>
 * This command generates a package containing all relevant resources for Implementation Guide(s),
 * also known as "Terminology Package Generation". It can create packages with terminology,
 * conformance, and/or API resources from one or more IGs.
 * <p/>
 * Requires -output parameter. The output can be a folder, .zip, or .tgz file.
 * <p/>
 * By default, includes all resource types (tx, cnt, api). Use -mode to filter.
 */
@Slf4j
@CommandLine.Command(
  name = "re-package",
  description = """
    Generate a package containing all relevant resources for Implementation Guide(s).

    Also called "Terminology Package Generation". This command creates a package
    with terminology, conformance, and/or API resources from one or more IGs.

    Requires -output parameter. The output can be a folder, .zip, or .tgz file.

    By default, includes all resource types (tx, cnt, api). Use -mode to filter.

    Example:
      java -jar validator_cli.jar re-package hl7.fhir.us.core#4.0.0 -output ./output.tgz -scope igs -pin
    """,
  hidden = false
)
public class RePackageCommand extends ValidationEngineCommand implements Callable<Integer> {

  @CommandLine.Parameters(
    index = "0",
    split = ",",
    description = "Package ID(s) to regenerate (e.g., hl7.fhir.us.core#4.0.0)"
  )
  private List<String> packages = new ArrayList<>();

  // The remaining parameters are processed as sources
  @CommandLine.Parameters(
    description = "Source file(s) to transform",
    index = "1..*"
  )
  private List<String> sources;

  @CommandLine.Option(
    names = {"-output"},
    required = true,
    description = "Output file or folder (.zip, .tgz, or directory path)"
  )
  private String output;

  @CommandLine.Option(
    names = {"-outputSuffix"},
    description = "Output suffix for generated files"
  )
  private String outputSuffix;

  @CommandLine.Option(
    names = {"-mode"},
    description = """
      Generation mode (can be repeated):
        tx - include terminology (CodeSystem, ValueSet, NamingSystem)
        cnt - include conformance (StructureDefinition)
        api - include API resources (CapabilityStatement, OperationDefinition, SearchParameter)
        expansions - include ValueSet expansions
      If not specified, defaults to tx, cnt, and api.
      """
  )
  private List<String> modes = new ArrayList<>();

  @CommandLine.Option(
    names = {"-pin"},
    description = "Pin versions of version-less references"
  )
  private boolean pin = false;

  @CommandLine.Option(
    names = {"-expand"},
    description = "Expand ValueSets in the output"
  )
  private boolean expand = false;

  @CommandLine.Option(
    names = {"-format"},
    description = "Output format: xml or json (default: json)"
  )
  private String format = "json";

  @CommandLine.Option(
    names = {"-scope"},
    description = """
      Resource scope:
        ig - include resources from this IG only
        igs - include resources from this IG and dependent IGs
        core - include resources from all IGs and core spec
      """
  )
  private String scope;

  @CommandLine.Option(
    names = {"-package-name"},
    description = "NPM package ID for the generated package (goes into package.json)"
  )
  private String packageName;

  @CommandLine.Option(
    names = {"-ignore-list"},
    split = ",",
    description = "Comma-separated list of canonical URLs to exclude from output"
  )
  private List<String> ignoreList = new ArrayList<>();

  @CommandLine.Option(
    names = {"-include-list"},
    split = ",",
    description = "Comma-separated list of canonical URLs to include in output"
  )
  private List<String> includeList = new ArrayList<>();

  @CommandLine.Option(
    names = {"-include-conforms-to"},
    description = "Include resources stated in invariants using FHIRPath conformsTo",
    arity="1"
  )
  private boolean includeConformsTo = false;

  @CommandLine.ArgGroup(validate = false, heading = "Instance Validator Options%n")
  InstanceValidatorOptions instanceValidatorOptions = new InstanceValidatorOptions();

  @Override
  public InstanceValidatorParameters getInstanceValidatorParameters() {
    InstanceValidatorOptionsConvertor convertor = new InstanceValidatorOptionsConvertor();
    return convertor.convert(instanceValidatorOptions);
  }

  @Override
  public List<String> getSources() {
    return sources == null ? Collections.emptyList() : sources;
  }

  @Override
  protected Integer call(@Nonnull ValidationService validationService,
                        @Nonnull ValidationEngine validationEngine) {
    try {
      validateParameters();

      boolean json = !format.equalsIgnoreCase("xml");
      Set<String> modeParams = buildModeParams();

      PackageReGenerator packageReGenerator = new PackageReGenerator()
        .setContext(validationEngine.getContext())
        .setOutput(output)
        .setOutputType(getExpansionPackageGeneratorOutputType(output))
        .setJson(json)
        .setModes(modeParams)
        .setNpmId(packageName)
        .addPackages(packages);

      if (scope != null) {
        packageReGenerator.setScope(getScopeFromString(scope));
      }

      // Load expansion parameters if provided
      InstanceValidatorParameters params = getInstanceValidatorParameters();
      if (params.getExpansionParameters() != null) {
        validationEngine.loadExpansionParameters(params.getExpansionParameters());
        packageReGenerator.setExpansionParameters(validationEngine.getContext().getExpansionParameters());
      }

      // Set ignore/include lists
      if (ignoreList != null && !ignoreList.isEmpty()) {
        packageReGenerator.setIgnoreList(ignoreList);
      }

      if (includeList != null && !includeList.isEmpty()) {
        List<CanonicalResource> canonicalResources = loadResources(
          includeList, validationEngine.getPcm());
        packageReGenerator.setIncludeList(canonicalResources);
      }

      if (includeConformsTo) {
        packageReGenerator.setIncludeConformsTo(true);
      }

      packageReGenerator.generateExpansionPackage();

      log.info("Package regeneration completed successfully");
      return 0;

    } catch (Exception e) {
      log.error("Error regenerating package", e);
      return 1;
    }
  }

  private void validateParameters() {
    // Check packages
    if (packages == null || packages.isEmpty()) {
      log.error("re-package requires at least one package ID");
      System.exit(1);
    }

    // Check output
    if (output == null || output.isEmpty()) {
      log.error("re-package requires -output parameter");
      System.exit(1);
    }

    // Validate scope if provided
    if (scope != null && !scope.matches("ig|igs|core")) {
      log.error("Invalid scope: {}. Must be one of: ig, igs, core", scope);
      System.exit(1);
    }

    // Validate format if provided
    if (format != null && !format.matches("(?i)xml|json")) {
      log.error("Invalid format: {}. Must be xml or json", format);
      System.exit(1);
    }
  }

  private Set<String> buildModeParams() {
    Set<String> modeParams = new HashSet<>();

    // If no modes specified, default to tx, cnt, api (as per original parser)
    if (modes == null || modes.isEmpty()) {
      modeParams.add("tx");
      modeParams.add("cnt");
      modeParams.add("api");
    } else {
      modeParams.addAll(modes);
    }

    // Add pin and expand if flags are set
    if (pin) {
      modeParams.add("pin");
    }
    if (expand) {
      modeParams.add("expand");
    }

    return modeParams;
  }

  private static ExpansionPackageGeneratorOutputType getExpansionPackageGeneratorOutputType(String output) {
    if (output.endsWith(".zip")) {
      return ExpansionPackageGeneratorOutputType.ZIP;
    } else if (output.endsWith(".tgz")) {
      return ExpansionPackageGeneratorOutputType.TGZ;
    }
    return ExpansionPackageGeneratorOutputType.FOLDER;
  }

  private ExpansionPackageGeneratorScope getScopeFromString(String scope) {
    return switch (Objects.requireNonNull(scope)) {
      case "ig" -> ExpansionPackageGeneratorScope.IG_ONLY;
      case "igs" -> ExpansionPackageGeneratorScope.ALL_IGS;
      case "core" -> ExpansionPackageGeneratorScope.EVERYTHING;
      default -> null;
    };
  }

  private List<CanonicalResource> loadResources(List<String> canonicals, FilesystemPackageCacheManager pcm) {
    PackageClient packageClient = new PackageClient(PackageServer.primaryServer());
    List<CanonicalResource> canonicalResources = new ArrayList<>();

    try {
      for (String canonical : canonicals) {
        List<PackageInfo> results = packageClient.search(null, null, null, false, canonical);
        if (!results.isEmpty()) {
          // Take the first result as the most recent and relevant
          PackageInfo result = results.get(0);

          NpmPackage npmPackage = pcm.loadPackage(result.getId(), result.getVersion());
          if (npmPackage == null) {
            log.error("Unable to load package {}#{} for canonical {}", result.getId(), result.getVersion(), canonical);
          } else {
            log.info("Loaded package {}#{} for canonical {}", result.getId(), result.getVersion(), canonical);
            CanonicalResource resource = getCanonicalResource(canonical, npmPackage);
            if (resource != null) {
              canonicalResources.add(resource);
            }
          }
        }
      }
    } catch (Exception e) {
      log.error("Error loading packages for canonicals", e);
    }

    return canonicalResources;
  }

  private static CanonicalResource getCanonicalResource(String canonical, NpmPackage npmPackage) throws Exception {
    InputStream stream = npmPackage.loadByCanonical(canonical);
    if (stream == null) {
      log.warn("Unable to load canonical resource {} from package {}#{}", canonical, npmPackage.name(), npmPackage.version());
      return null;
    }

    CanonicalResource canonicalResource;
    if ("4.0.1".equals(npmPackage.fhirVersion())) {
      IBaseResource r4resource = new org.hl7.fhir.r4.formats.JsonParser().parse(stream);
      canonicalResource = (CanonicalResource) VersionConvertorFactory_40_50.convertResource((org.hl7.fhir.r4.model.Resource) r4resource);
    } else if ("5.0.0".equals(npmPackage.fhirVersion())) {
      canonicalResource = (CanonicalResource) new org.hl7.fhir.r5.formats.JsonParser().parse(stream);
    } else {
      log.warn("Unsupported FHIR version {} for package {}", npmPackage.fhirVersion(), npmPackage.name());
      return null;
    }

    canonicalResource.setSourcePackage(new PackageInformation(npmPackage));
    return canonicalResource;
  }
}
