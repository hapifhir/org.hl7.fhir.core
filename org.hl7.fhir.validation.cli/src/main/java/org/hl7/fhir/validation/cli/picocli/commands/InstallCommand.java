package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import picocli.CommandLine;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

@Slf4j
@CommandLine.Command(name = "install",
  description = "Start a fhir server.")
public class InstallCommand extends ValidationEngineCommand implements Callable<Integer> {

  @Override
  public InstanceValidatorParameters getInstanceValidatorParameters() {
    return null;
  }

  @Override
  public List<String> getSources() {
    return List.of();
  }

  @Override
  protected Integer call(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) {
    try {
      validationService.install(validationEngineOptions.igs, validationEngine);
    } catch (IOException e) {
      log.error("Error installing: " + validationEngineOptions.igs, e);
      return 1;
    }
    return 0;
  }
}
