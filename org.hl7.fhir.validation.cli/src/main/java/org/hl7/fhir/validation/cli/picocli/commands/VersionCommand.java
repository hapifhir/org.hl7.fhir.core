package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import picocli.CommandLine;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Command to convert FHIR resources between different FHIR versions.
 * <p/>
 * This command converts resources between FHIR versions (R2, R3, R4, R5) using
 * either internal Java routines or structure maps from the FHIR interversion package.
 * <p/>
 * By default, internal routines are used for resources with canonical URLs
 * (CodeSystem, ValueSet, etc.) and structure maps for others. If internal
 * routines fail, structure maps are used as fallback.
 * <p/>
 * Requires -to-version to specify target FHIR version.
 * Use -output for single source or -outputSuffix for multiple sources.
 */
@Slf4j
@CommandLine.Command(
  name = "to-version",
  description = """
    Convert resources between FHIR versions (R2, R3, R4, R5).

    The validator can use either internal Java routines or structure maps from
    https://github.com/FHIR/packages/tree/master/interversion.

    By default, internal routines are used for resources with canonical URLs
    (CodeSystem, ValueSet, etc.) and structure maps for others. If internal
    routines fail, structure maps are used as fallback.

    Use -do-native to force internal routines for all resources.
    Use -no-native to disable internal routines completely.

    Requires -to-version to specify target FHIR version.
    For single source: use -output <file>

    Example: version observation.xml -to-version 4.0 -output observation4.json
    """,
  hidden = false
)
public class VersionCommand extends ValidationEngineCommand implements Callable<Integer> {

  @CommandLine.Parameters(
    description = "Target FHIR version (e.g., 3.0, 4.0, 5.0)",
    index = "0"
  )
  private String toVersion;

  // The remaining parameters are processed as sources
  @CommandLine.Parameters(
    description = "Source file(s) to transform",
    index = "1..*"
  )
  private List<String> sources;

  @CommandLine.Option(
    names = {"-do-native"},
    description = "Force use of internal Java routines for all resources"
  )
  private Boolean doNative;

  @CommandLine.Option(
    names = {"-no-native"},
    description = "Disable internal Java routines, use structure maps only"
  )
  private Boolean noNative;

  @CommandLine.Option(
    names = {"-output"},
    description = "Output file path (for single source)"
  )
  private String output;

  @Override
  public InstanceValidatorParameters getInstanceValidatorParameters() {
    return null;  // Version conversion doesn't use instance validation parameters
  }

  @Override
  public List<String> getSources() {
    return sources == null ? Collections.emptyList() : sources;
  }

  @Override
  protected Integer call(@Nonnull ValidationService validationService,
                        @Nonnull ValidationEngine validationEngine) {
    try {
      validateVersionParameters();

      // Determine canDoNative value
      boolean canDoNative = false;
      if (doNative != null && doNative) {
        canDoNative = true;
      }

      // Get mapLog from validationEngineOptions if available
      String mapLog = validationEngineOptions != null ? validationEngineOptions.mapLog : null;

      // Create service parameters for version transformation
      org.hl7.fhir.validation.service.TransformVersionParameters serviceParameters =
        new org.hl7.fhir.validation.service.TransformVersionParameters(
          toVersion,
          mapLog,
          canDoNative,
          getSources(),
          output
        );

      // Execute version transformation
      validationService.transformVersion(validationEngine, serviceParameters);

      log.info("Version conversion completed successfully");
      return 0;

    } catch (Exception e) {
      log.error("Error converting version", e);
      return 1;
    }
  }

  private void validateVersionParameters() {
    // Check to-version
    if (toVersion == null || toVersion.isEmpty()) {
      log.error("-to-version parameter is required");
      System.exit(1);
    }

    // Mutual exclusion for native flags
    if ((doNative != null && doNative) && (noNative != null && noNative)) {
      log.error("version cannot use both -do-native and -no-native");
      System.exit(1);
    }
  }
}
