package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.TransformParameters;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import picocli.CommandLine;

import java.util.List;
import java.util.concurrent.Callable;

import javax.annotation.Nonnull;

@Slf4j
@CommandLine.Command(name = "transform",
  description = """
  Execute a transformation as described by a structure map
  """)
public class TransformCommand extends ValidationEngineCommand implements Callable<Integer> {

  // The first parameter is given special treatment as a result of legacy CLI implementation
  @CommandLine.Parameters(
    description = "A structure map file",
    index = "0"
  )
  private String map;

  // The remaining parameters are processed as sources
  @CommandLine.Parameters(
    description = "Source file(s) to transform",
    index = "1..*"
  )
  private List<String> sources;
  
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
    return sources;
  }

  @Override
  protected Integer call(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) {
    final String resolvedMap = resolveMap();
    validateParameters(resolvedMap);

    String mapLog = validationEngineOptions != null ? validationEngineOptions.mapLog : null;
    String txServer = validationEngineOptions != null ? validationEngineOptions.txServer : null;

    TransformParameters transformParameters = TransformParameters.builder()
      .map(resolvedMap)
      .mapLog(mapLog)
      .txServer(txServer)
      .sources(sources)
      .output(output)
      .build();

    try {
      validationService.transform(validationEngine, transformParameters);
      log.info("Successfully transformed source(s) using map {} to {}", resolvedMap, output);
      return 0;
    } catch (Exception e) {
      log.error("Error transforming source(s).", e);
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
      log.error("Must provide a map when performing a transform");
      System.exit(1);
    }
    if (output == null) {
      log.error("Must provide an output file when performing a transform");
      System.exit(1);
    }
    if (sources == null || sources.isEmpty()) {
      log.error("Must provide at least one source file when performing a transform");
      System.exit(1);
    }
  }
}
