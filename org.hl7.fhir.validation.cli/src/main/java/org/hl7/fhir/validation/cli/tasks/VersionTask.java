package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.cli.param.parsers.OutputParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.TransformVersionParametersParser;
import org.hl7.fhir.validation.service.model.TransformVersionParameters;
import org.hl7.fhir.validation.service.model.OutputParameters;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.cli.Display;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

public class VersionTask extends ValidationEngineTask {

  @Override
  public String getName() {
    return "to-version";
  }

  @Override
  public String getDisplayName() {
    return "Version Conversion";
  }

  @Override
  public boolean isHidden() {
    return false;
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    return Params.hasParam(args, TransformVersionParametersParser.TO_VERSION);
  }

  @Override
  public void logHelp(Logger logger) {
    Display.displayHelpDetails(logger,"help/version.txt");
  }


  @Override
  protected VersionTaskInstance getValidationEngineTaskInstance(Arg[] args) {
    return new VersionTaskInstance(args);
  }

  @Override
  public boolean usesInstanceValidatorParameters() {
    return false;
  }

  protected class VersionTaskInstance extends ValidationEngineTaskInstance {

    TransformVersionParameters transformVersionParameters;
    OutputParameters outputParameters;

    VersionTaskInstance(Arg[] args) {
      super(args);
    }

    @Override
    protected void buildTaskSpecificParametersFromArgs(Arg[] args) {
      TransformVersionParametersParser transformVersionParametersParser = new TransformVersionParametersParser();
      OutputParametersParser outputParametersParser = new OutputParametersParser();
      transformVersionParametersParser.parseArgs(args);
      outputParametersParser.parseArgs(args);
      transformVersionParameters = transformVersionParametersParser.getParameterObject();
      outputParameters =  outputParametersParser.getParameterObject();
    }

    @Override
    protected void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) throws Exception {
      org.hl7.fhir.validation.service.TransformVersionParameters serviceParameters = new org.hl7.fhir.validation.service.TransformVersionParameters(
        this.transformVersionParameters.getTargetVer(), validationEngineParameters.getMapLog(),
        this.transformVersionParameters.getCanDoNative(),  sources, outputParameters.getOutput()
      );
      validationService.transformVersion(validationEngine,  serviceParameters);
    }
  }
}
