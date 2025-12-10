package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@Slf4j
@CommandLine.Command(name = "compile",
  description = """
  Compile a structure map
  """)
public class CompileCommand extends ValidationEngineCommand implements Callable<Integer> {

  @CommandLine.Parameters(
    description = "A structure map file"
  )
  private String map;

  @CommandLine.Option(
    names = {"-output"},
    required = true,
    description = "The file to output to")
  private String output;

  @Override
  public InstanceValidatorParameters getInstanceValidatorParameters() {
    return null;
  }

  @Override
  public List<String> getSources() {
    return new ArrayList<>();
  }

  @Override
  protected Integer call(@NonNull ValidationService validationService, @NonNull ValidationEngine validationEngine) {
    validateParameters();

    String mapLog = validationEngineOptions != null ? validationEngineOptions.mapLog : null;

    try {
      validationService.compile(validationEngine, map, mapLog, getSources(), output);
      log.info("Successfully compiled map from {} to {}", map, output);
      return 0;
    } catch (Exception e) {
      log.error("Error compiling map.", e);
      return 1;
    }
  }

  private void validateParameters() {
    if (map == null) {
      log.error("Must provide a map when compiling a transform");
      System.exit(1);
    }
    if (output == null) {
      log.error("Must provide an output file when compiling a transform");
      System.exit(1);
    }
  }
}
