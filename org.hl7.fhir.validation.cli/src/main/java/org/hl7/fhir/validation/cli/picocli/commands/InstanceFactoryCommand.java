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

/**
 * Command to generate test instances using a factory definition.
 *
 * This command executes a test data factory to create FHIR resources based on a factory control file.
 * The factory definition format is documented at https://build.fhir.org/ig/FHIR/ig-guidance/testfactory.html
 */
@Slf4j
@CommandLine.Command(
  name = "factory",
  description = """
    Generate test instances using a factory definition.

    Creates test FHIR resources based on a factory control file.
    The factory definition format is documented at:
    https://build.fhir.org/ig/FHIR/ig-guidance/testfactory.html

    The factory executes with the current folder set to the folder containing
    the control file, relevant for resolving links to liquid scripts and data files.

    Requires -factory parameter and -version (or -ig) to specify FHIR version.

    Example:
      java -jar validator_cli.jar factory control.json -version 4.0
    """,
  hidden = true
)
public class InstanceFactoryCommand extends ValidationEngineCommand implements Callable<Integer> {

  @CommandLine.Parameters(
    index = "0",
    description = "Path to the factory control file (JSON configuration)"
  )
  private String factorySource;

  @Override
  public InstanceValidatorParameters getInstanceValidatorParameters() {
    return null;  // Instance factory doesn't use instance validation parameters
  }

  @Override
  public List<String> getSources() {
    return Collections.emptyList();  // Factory source is a control file, not a validation source
  }

  @Override
  protected Integer call(@Nonnull ValidationService validationService,
                        @Nonnull ValidationEngine validationEngine) {
    try {
      validateFactoryParameters();
      validationService.instanceFactory(validationEngine, factorySource);
      return 0;

    } catch (Exception e) {
      log.error("Error executing instance factory", e);
      return 1;
    }
  }

  private void validateFactoryParameters() {
    if (factorySource == null || factorySource.isEmpty()) {
      log.error("-factory requires parameter");
      System.exit(1);
    }
  }
}
