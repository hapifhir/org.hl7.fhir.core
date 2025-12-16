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
 * Command to generate narrative for FHIR resources.
 *
 * This command reads a FHIR resource file and generates human-readable narrative content.
 * It requires FHIR version configuration (via -version or -ig) and a terminology server (-tx)
 * for proper narrative generation.
 */
@Slf4j
@CommandLine.Command(
  name = "narrative",
  description = """
    Generate narrative for a FHIR resource.

    Reads a FHIR resource file and generates human-readable narrative content.

    Requires -version (or -ig) and -tx parameters for proper narrative generation.
    Optionally use -output to save the resource with generated narrative.
    """
)
public class NarrativeCommand extends ValidationEngineCommand implements Callable<Integer> {

  @CommandLine.Parameters(
    description = "The source file to generate narrative for"
  )
  private String[] sources;

  @CommandLine.Option(
    names = {"-output"},
    description = "Output file path for the resource with generated narrative"
  )
  private String output;

  @Override
  public InstanceValidatorParameters getInstanceValidatorParameters() {
    return null;  // Narrative generation doesn't use instance validation
  }

  @Override
  public List<String> getSources() {
    return sources == null ? Collections.emptyList() : Arrays.asList(sources);
  }

  @Override
  protected Integer call(@Nonnull ValidationService validationService,
                        @Nonnull ValidationEngine validationEngine) {
    try {
      validateNarrativeParameters();

      validationService.generateNarrative(
        validationEngine,
        validationEngine.getVersion(),
        getSources(),
        output
      );

      log.info("Narrative generation completed successfully");
      return 0;

    } catch (Exception e) {
      log.error("Error generating narrative", e);
      return 1;
    }
  }

  private void validateNarrativeParameters() {
    if (sources == null || sources.length == 0) {
      log.error("narrative requires at least one source file");
      System.exit(1);
    }
  }
}
