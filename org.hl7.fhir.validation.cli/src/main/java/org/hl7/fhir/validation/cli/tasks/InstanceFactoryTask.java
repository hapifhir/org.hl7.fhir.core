package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.cli.param.parsers.InstanceFactoryParametersParser;
import org.hl7.fhir.validation.service.model.InstanceFactoryParameters;
import org.hl7.fhir.validation.service.ValidationService;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

public class InstanceFactoryTask extends ValidationEngineTask {

  @Override
  public String getName() {
    return "instance-factory";
  }

  @Override
  public String getDisplayName() {
    return "Execute Instance Factory";
  }

  @Override
  public boolean isHidden() {
    return true;
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    return Params.hasParam(args, InstanceFactoryParametersParser.FACTORY);
  }

  @Override
  public void logHelp(Logger logger) {

  }

  @Override
  protected InstanceFactoryTaskInstance getValidationEngineTaskInstance(Arg[] args) {
    return new InstanceFactoryTaskInstance(args);
  }

  @Override
  public boolean usesInstanceValidatorParameters() {
    return false;
  }

  protected class InstanceFactoryTaskInstance extends ValidationEngineTaskInstance {

    InstanceFactoryParameters instanceFactoryParameters;

    InstanceFactoryTaskInstance(Arg[] args) {
      super(args);
    }

    @Override
    protected void buildTaskSpecificParametersFromArgs(Arg[] args) {
      InstanceFactoryParametersParser instanceFactoryParametersParser = new InstanceFactoryParametersParser();
      instanceFactoryParametersParser.parseArgs(args);
      instanceFactoryParameters = instanceFactoryParametersParser.getParameterObject();
    }

    @Override
    protected void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) throws Exception {
      validationService.instanceFactory(validationEngine, instanceFactoryParameters.getSource());
    }
  }
}
