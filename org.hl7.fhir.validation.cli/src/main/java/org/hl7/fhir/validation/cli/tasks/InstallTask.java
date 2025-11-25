package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.cli.param.parsers.InstallParametersParser;
import org.hl7.fhir.validation.service.ValidationService;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

public class InstallTask extends ValidationEngineTask {

  @Override
  public String getName() {
    return "install";
  }

  @Override
  public String getDisplayName() {
    return "Install";
  }

  @Override
  public boolean isHidden() {
    return true;
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    return Params.hasParam(args, InstallParametersParser.INSTALL);
  }

  @Override
  public void logHelp(Logger logger) {

  }

  @Override
  public boolean inferFhirVersion() {
    return true;
  }

  @Override
  protected InstallTaskInstance getValidationEngineTaskInstance(Arg[] args) {
    return new InstallTaskInstance(args);
  }

  @Override
  public boolean usesInstanceValidatorParameters() {
    return false;
  }

  protected class InstallTaskInstance extends ValidationEngineTaskInstance {

    InstallTaskInstance(Arg[] args) {
      super(args);
    }

    @Override
    protected void buildTaskSpecificParametersFromArgs(Arg[] args) {
      for (int i = 0; i < args.length; i++) {
        if (args[i].getValue().equals(InstallParametersParser.INSTALL)) {
          args[i].setProcessed(true);
        }
      }
    }

    @Override
    protected void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) throws Exception {
      validationService.install(validationEngineParameters.getIgs(), validationEngine);
    }
  }
}
