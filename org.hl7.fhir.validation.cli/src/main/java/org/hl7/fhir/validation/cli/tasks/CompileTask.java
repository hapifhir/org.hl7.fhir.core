package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.cli.param.parsers.MapParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.OutputParametersParser;
import org.hl7.fhir.validation.service.model.MapParameters;
import org.hl7.fhir.validation.service.model.OutputParameters;
import org.hl7.fhir.validation.service.ValidationService;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

public class CompileTask extends ValidationEngineTask {

  @Override
  public String getName() {
    return "compile";
  }

  @Override
  public String getDisplayName() {
    return "Compile";
  }

  @Override
  public boolean isHidden() {
    return true;
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    return Params.hasParam(args, MapParametersParser.COMPILE);
  }

  @Override
  public void logHelp(Logger logger) {

  }

  @Override
  public boolean usesInstanceValidatorParameters() {
    return false;
  }

  @Override
  protected CompileTaskInstance getValidationEngineTaskInstance(Arg[] args) {
    return new CompileTaskInstance(args);
  }

  protected class CompileTaskInstance extends ValidationEngineTaskInstance {

    MapParameters mapParameters;
    OutputParameters outputParameters;

    CompileTaskInstance(Arg[] args) {
      super(args);
    }

    @Override
    protected void buildTaskSpecificParametersFromArgs(Arg[] args) {
      MapParametersParser mapParametersParser = new MapParametersParser();
      OutputParametersParser outputParametersParser = new OutputParametersParser();
      mapParametersParser.parseArgs(args);
      outputParametersParser.parseArgs(args);
      mapParameters = mapParametersParser.getParameterObject();
      outputParameters = outputParametersParser.getParameterObject();
    }

    @Override
    protected void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) throws Exception {
      validationService.compile(validationEngine, mapParameters.getMap(), validationEngineParameters.getMapLog(), sources, outputParameters.getOutput());
    }
  }
  
}
