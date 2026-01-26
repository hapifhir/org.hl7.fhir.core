package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import picocli.CommandLine;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@Slf4j
@CommandLine.Command(name = "compile",
  description = """
  Compile a structure map
  """)
public class CompileCommand extends ValidationEngineCommand implements Callable<Integer> {

  // The first parameter is given special treatment as a result of legacy CLI implementation
  @CommandLine.Parameters(
    description = "A structure map file"
  )
  private String map;

  @CommandLine.Option(
    names = {"-map"},
    description = "A structure map file")
  private String explicitMap;

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
    return Collections.emptyList();
  }

  @Override
  protected Integer call(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) {
    final String resolvedMap = resolveMap();
    validateParameters(resolvedMap);

    String mapLog = validationEngineOptions != null ? validationEngineOptions.mapLog : null;

    try {
      validationService.compile(validationEngine, resolvedMap, mapLog, getSources(), output);
      log.info("Successfully compiled map from {} to {}", resolvedMap, output);
      return 0;
    } catch (Exception e) {
      log.error("Error compiling map.", e);
      return 1;
    }
  }

  private String resolveMap() {
    if (map != null && explicitMap != null) {
      log.error("Provided a map via the default parameter ("+map+") and -map ("+explicitMap+"). Only use one for this command.");
      System.exit(1);
    }
    if (map != null){
      return map;
    }
    if (explicitMap != null) {
      return explicitMap;
    }
    return null;
  }

  private void validateParameters(String map) {
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
