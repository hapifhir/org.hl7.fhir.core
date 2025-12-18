package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.GenerateSnapshotParameters;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import picocli.CommandLine;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Command to generate snapshots for FHIR StructureDefinition profiles.
 * <p/>
 * This command creates a fully expanded view of a profile including all elements
 * from the base resource plus differential constraints. Essential for understanding
 * complete profile structures.
 * <p/>
 * Requires exactly one of {-output, -outputSuffix}:
 * - Use -output for single source/output file
 * - Use -outputSuffix for multiple sources with pattern &lt;source&gt;.&lt;suffix&gt;
 */
@Slf4j
@CommandLine.Command(
  name = "snapshot",
  description = """
    Generate snapshot for FHIR StructureDefinition profiles.

    Creates a fully expanded view of a profile including all elements from
    the base resource plus differential constraints.

    Requires -version (or -ig), -tx, -defn, and one of {-output, -outputSuffix}.
    May use -ig to provide necessary base profiles.

    For single source: use -output <file>
    For multiple sources: use -outputSuffix <suffix> (creates <source>.<suffix>)

    The -output/-outputSuffix filetype (xml, json) may imply a conversion.

    Example: snapshot *.xml -outputSuffix snapshot.json
    Creates: source1.xml.snapshot.json, source2.xml.snapshot.json, etc.
    """,
  hidden = false
)
public class SnapshotCommand extends ValidationEngineCommand implements Callable<Integer> {

  @CommandLine.Parameters(
    description = "The source file(s) to generate snapshots for"
  )
  private String[] sources;

  @CommandLine.Option(
    names = {"-output"},
    description = "Output file path (for single source)"
  )
  private String output;

  @CommandLine.Option(
    names = {"-outputSuffix"},
    description = "Output suffix pattern for multiple sources (creates <source>.<suffix>)"
  )
  private String outputSuffix;

  @Override
  public InstanceValidatorParameters getInstanceValidatorParameters() {
    return null;  // Snapshot generation doesn't use instance validation parameters
  }

  @Override
  public List<String> getSources() {
    return sources == null ? Collections.emptyList() : Arrays.asList(sources);
  }

  @Override
  protected Integer call(@Nonnull ValidationService validationService,
                        @Nonnull ValidationEngine validationEngine) {
    try {
      validateSnapshotParameters();

      validationService.generateSnapshot(
        validationEngine,
        new GenerateSnapshotParameters(
          validationEngineOptions.fhirVersion,
          getSources(),
          output,
          outputSuffix
        )
      );

      log.info("Snapshot generation completed successfully");
      return 0;

    } catch (Exception e) {
      log.error("Error generating snapshot", e);
      return 1;
    }
  }

  private void validateSnapshotParameters() {
    // Check sources
    if (sources == null || sources.length == 0) {
      log.error("snapshot requires at least one source file");
      System.exit(1);
    }

    // Check XOR: exactly one of {output, outputSuffix}
    boolean hasOutput = output != null && !output.isEmpty();
    boolean hasOutputSuffix = outputSuffix != null && !outputSuffix.isEmpty();

    if (!hasOutput && !hasOutputSuffix) {
      log.error("snapshot requires either -output or -outputSuffix parameter");
      System.exit(1);
    }

    if (hasOutput && hasOutputSuffix) {
      log.error("snapshot requires exactly one of {-output, -outputSuffix}, not both");
      System.exit(1);
    }
  }
}
