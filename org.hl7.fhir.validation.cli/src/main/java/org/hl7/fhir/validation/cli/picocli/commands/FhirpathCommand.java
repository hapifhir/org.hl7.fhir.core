package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import picocli.CommandLine;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Nonnull;

@Slf4j
@CommandLine.Command(name = "fhirpath",
  description = """
  Evaluate a FHIRPath expression on a resource or logical model.

  You can use the validator to evaluate a FHIRPath expression on a resource or logical model. To do this, you must provide the -fhirpath parameter with the FHIRPath expression to evaluate, and a parameter with the resource to evaluate against.

  The -ig parameter may be used to provide a logical model if needed.
  """)
public class FhirpathCommand extends ValidationEngineCommand implements Callable<Integer> {

  // The first parameter is given special treatment as a result of legacy CLI implementation
  @CommandLine.Parameters(
    index = "0")
  private String fhirpath;

  // The remaining parameters are processed as sources
  // There is only one allowed source in fhirpath usage
  @CommandLine.Parameters(
    description = "The source resource to evaluate the FHIRPath expression against",
    index = "1"
  )
  private String source;

  @Override
  public InstanceValidatorParameters getInstanceValidatorParameters() {
    return null;
  }

  @Override
  public List<String> getSources() {
    return source == null ? Collections.emptyList() : List.of(source);
  }

  @Override
  protected Integer call(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) {
    if (fhirpath == null || fhirpath.isEmpty()) {
      log.error("No FHIRPath expression provided (-fhirpath parameter)");
      return 1;
    }

    List<String> sources = getSources();
    if (sources.size() != 1) {
      log.error("One source is required");
      return 1;
    }

    try {
      validationService.evaluateFhirpath(validationEngine, fhirpath, sources);
    } catch (Exception e) {
      log.error("Error evaluating FHIRPath expression.", e);
      return 1;
    }
    return 0;
  }
}
