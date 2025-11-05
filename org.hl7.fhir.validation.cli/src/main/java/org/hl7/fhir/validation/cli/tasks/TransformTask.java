package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.cli.param.parsers.MapParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.OutputParametersParser;
import org.hl7.fhir.validation.service.TransformParameters;
import org.hl7.fhir.validation.service.model.MapParameters;
import org.hl7.fhir.validation.service.model.OutputParameters;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.cli.Display;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

public class TransformTask extends ValidationEngineTask {

  @Override
  public String getName() {
    return "transform";
  }

  @Override
  public String getDisplayName() {
    return "Transforms";
  }

  @Override
  public boolean isHidden() {
    return false;
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    return Params.hasParam(args, MapParametersParser.TRANSFORM);
  }

  @Override
  public void logHelp(Logger logger) {
    Display.displayHelpDetails(logger,"help/transform.txt");
  }

  @Override
  protected ValidationEngineTaskInstance getValidationEngineTaskInstance(Arg[] args) {
    return new TransformTaskInstance(args);
  }

  protected class TransformTaskInstance extends ValidationEngineTaskInstance {

    MapParameters mapParameters;
    OutputParameters outputParameters;

    TransformTaskInstance(Arg[] args) {
      super(args);
    }

    @Override
    protected boolean usesInstanceValidatorParameters() {
      return false;
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
      TransformParameters transformParameters = new TransformParameters(validationEngineParameters,mapParameters.getMap(),sources,outputParameters.getOutput());
      validationService.transform(validationEngine,  transformParameters);
    }
  }
}
