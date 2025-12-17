package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.picocli.options.InstanceValidatorOptions;
import org.hl7.fhir.validation.cli.picocli.options.InstanceValidatorOptionsConvertor;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import picocli.CommandLine;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Command to generate Java code from FHIR profiles.
 * <p/>
 * This hidden command generates programmatically encoded (PE) Java code for FHIR profiles
 * using the PECodeGenerator. Code generation options control what elements are included
 * in the generated classes.
 * <p/>
 * Requires -package-name for Java package and -output for output directory.
 * Use -profile or -profiles to specify which profiles to generate code for.
 * Supports R4 and R5 FHIR versions only.
 * <p/>
 * This is an internal development tool for code generation.
 */
@Slf4j
@CommandLine.Command(
  name = "codegen",
  description = """
    Generate Java code from FHIR profiles.

    Generates programmatically encoded (PE) Java code for FHIR profiles
    using the PECodeGenerator. Code generation options control what
    elements are included in the generated classes.

    Requires -package-name for Java package and -output for output directory.
    Use -profile or -profiles to specify which profiles to generate code for.
    Supports R4 and R5 FHIR versions only.

    Options available: narrative, meta, contained, all-elements

    Hidden internal tool for code generation.
    """,
  hidden = true
)
public class CodeGenCommand extends ValidationEngineCommand implements Callable<Integer> {

  @CommandLine.Option(
    names = {"-package-name"},
    description = "Java package name for generated code",
    required = true
  )
  private String packageName;

  @CommandLine.Option(
    names = {"-output"},
    description = "Output directory for generated Java code",
    required = true
  )
  private String output;

  @CommandLine.Option(
    names = {"-option"},
    description = "Code generation option (narrative, meta, contained, all-elements). Can be specified multiple times."
  )
  private List<String> options = new ArrayList<>();

  @CommandLine.Option(
    names = {"-options"},
    description = "Compact comma delimited format to set generation option. Can contain any -options parameter"
  )
  private List<String> commaDelimitedOptions = new ArrayList<>();

  @CommandLine.ArgGroup(validate = false, heading = "Instance Validator Options%n")
  InstanceValidatorOptions instanceValidatorOptions = new InstanceValidatorOptions();

  @Override
  public InstanceValidatorParameters getInstanceValidatorParameters() {
    InstanceValidatorOptionsConvertor convertor = new InstanceValidatorOptionsConvertor();
    return convertor.convert(instanceValidatorOptions);
  }

  @Override
  public List<String> getSources() {
    return Collections.emptyList();  // CodeGen doesn't use source files
  }

  @Override
  protected Integer call(@Nonnull ValidationService validationService,
                        @Nonnull ValidationEngine validationEngine) {
    try {

      List<String> allOptions = new ArrayList<>(options);
      for (String compactOptions : commaDelimitedOptions) {
        for (String option : compactOptions.split("\\,")) {
          allOptions.add(option);
        }
      }

      validateCodeGenParameters();

      // Get profiles from instance validator parameters
      InstanceValidatorParameters params = getInstanceValidatorParameters();
      List<String> profiles = params != null ? params.getProfiles() : Collections.emptyList();

      // Get FHIR version from validation engine options
      String fhirVersion = validationEngineOptions != null ? validationEngineOptions.fhirVersion : null;

      // Create service parameters for code generation
      org.hl7.fhir.validation.service.CodeGenParameters serviceParameters =
        new org.hl7.fhir.validation.service.CodeGenParameters(
          fhirVersion,
          profiles,
          allOptions,
          packageName,
          output
        );

      // Execute code generation
      validationService.codeGen(validationEngine, serviceParameters);

      log.info("Code generation completed successfully");
      return 0;

    } catch (Exception e) {
      log.error("Error generating code", e);
      return 1;
    }
  }

  private void validateCodeGenParameters() {
    // Check package name
    if (packageName == null || packageName.isEmpty()) {
      log.error("codegen requires -package-name parameter");
      System.exit(1);
    }

    // Check output
    if (output == null || output.isEmpty()) {
      log.error("codegen requires -output parameter");
      System.exit(1);
    }

    // Check profiles (from instance validator options)
    InstanceValidatorParameters params = getInstanceValidatorParameters();
    if (params == null || params.getProfiles() == null || params.getProfiles().isEmpty()) {
      log.error("codegen requires at least one profile via -profile or -profiles");
      System.exit(1);
    }

    // Check FHIR version
    if (validationEngineOptions == null || validationEngineOptions.fhirVersion == null) {
      log.error("codegen requires -version parameter (R4 or R5 only)");
      System.exit(1);
    }
  }
}
