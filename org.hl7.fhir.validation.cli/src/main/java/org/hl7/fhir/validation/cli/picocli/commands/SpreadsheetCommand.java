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
 * Command to generate spreadsheet representations of FHIR canonical resources.
 * <p/>
 * This command creates Excel/CSV spreadsheet representations of FHIR canonical
 * resources including StructureDefinition, CodeSystem, ValueSet, and ConceptMap.
 * <p/>
 * This is a hidden command intended for advanced users and internal tooling.
 */
@Slf4j
@CommandLine.Command(
  name = "spreadsheet",
  description = """
    Generate spreadsheet representations of FHIR canonical resources.

    Creates Excel/CSV spreadsheet representations of FHIR canonical resources
    including StructureDefinition, CodeSystem, ValueSet, and ConceptMap.

    Requires at least one source file.
    Optionally specify -output for the generated spreadsheet file path.
    """,
  hidden = true
)
public class SpreadsheetCommand extends ValidationEngineCommand implements Callable<Integer> {

  @CommandLine.Parameters(
    description = "The source file(s) containing FHIR canonical resources to convert to spreadsheet format"
  )
  private String[] sources;

  @CommandLine.Option(
    names = {"-output"},
    description = "Output file path for the generated spreadsheet. If not specified, output is written to stdout or default location."
  )
  private String output;

  @Override
  public InstanceValidatorParameters getInstanceValidatorParameters() {
    return null;  // Spreadsheet generation doesn't use instance validation parameters
  }

  @Override
  public List<String> getSources() {
    return sources == null ? Collections.emptyList() : Arrays.asList(sources);
  }

  @Override
  protected Integer call(@Nonnull ValidationService validationService,
                        @Nonnull ValidationEngine validationEngine) {
    try {
      validateSpreadsheetParameters();

      validationService.generateSpreadsheet(
        validationEngine,
        validationEngineOptions.fhirVersion,
        getSources(),
        output
      );

      log.info("Spreadsheet generation completed successfully");
      return 0;

    } catch (Exception e) {
      log.error("Error generating spreadsheet", e);
      return 1;
    }
  }

  private void validateSpreadsheetParameters() {
    if (sources == null || sources.length == 0) {
      log.error("spreadsheet requires at least one source file");
      System.exit(1);
    }
  }
}
