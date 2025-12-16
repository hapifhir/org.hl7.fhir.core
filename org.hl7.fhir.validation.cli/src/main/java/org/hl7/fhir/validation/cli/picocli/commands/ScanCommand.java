package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.Scanner;
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
 * Command to scan and validate FHIR resources against loaded Implementation Guides.
 * <p/>
 * This command validates resources against all loaded IGs and generates a comprehensive
 * compliance matrix report showing validation results for the core FHIR specification,
 * each IG's global profile, and all profiles matching the resource type.
 * <p/>
 * The output is an HTML report (scan.html) with a matrix view and individual validation details.
 */
@Slf4j
@CommandLine.Command(
  name = "scan",
  description = """
    Scan and validate FHIR resources against loaded Implementation Guides.

    Validates resources against all loaded IGs and generates a comprehensive
    compliance matrix report showing validation results for core FHIR spec,
    each IG's global profile, and all matching profiles.

    Outputs scan.html with matrix view and individual validation details.

    Requires -version (or -ig) and -tx parameters, plus -output directory.
    """,
  hidden = false
)
public class ScanCommand extends ValidationEngineCommand implements Callable<Integer> {

  @CommandLine.Parameters(
    description = "The source file(s) to scan and validate"
  )
  private String[] sources;

  @CommandLine.Option(
    names = {"-output"},
    required = true,
    description = "Output directory path for scan results (must be an existing directory)"
  )
  private String output;

  @Override
  public InstanceValidatorParameters getInstanceValidatorParameters() {
    return null;
  }

  @Override
  public List<String> getSources() {
    return sources == null ? Collections.emptyList() : Arrays.asList(sources);
  }

  @Override
  protected Integer call(@Nonnull ValidationService validationService,
                        @Nonnull ValidationEngine validationEngine) {
    try {
      validateScanParameters();

      Scanner scanner = new Scanner(
        validationEngine.getContext(),
        validationEngine.getValidator(null),
        validationEngine.getIgLoader(),
        validationEngine.getFhirPathEngine()
      );

      scanner.validateScan(output, getSources());

      log.info("Scan completed successfully");
      return 0;

    } catch (Exception e) {
      log.error("Error performing scan", e);
      return 1;
    }
  }

  private void validateScanParameters() {
    if (sources == null || sources.length == 0) {
      log.error("scan requires at least one source file");
      System.exit(1);
    }
  }
}
