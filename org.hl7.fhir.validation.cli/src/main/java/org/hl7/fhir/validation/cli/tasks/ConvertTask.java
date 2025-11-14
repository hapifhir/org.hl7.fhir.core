package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.cli.param.parsers.ConvertParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.OutputParametersParser;
import org.hl7.fhir.validation.service.model.OutputParameters;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.cli.Display;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

public class ConvertTask extends ValidationEngineTask {

  @Override
  public String getName() {
    return "convert";
  }

  @Override
  public String getDisplayName() {
    return "Conversion";
  }

  @Override
  public boolean isHidden() {
    return false;
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    return Params.hasParam(args, ConvertParametersParser.CONVERT);
  }

  @Override
  public void logHelp(Logger logger) {
    Display.displayHelpDetails(logger,"help/convert.txt");
  }

  @Override
  protected ConvertTaskInstance getValidationEngineTaskInstance(Arg[] args) {
    return new ConvertTaskInstance(args);
  }

  @Override
  public boolean usesInstanceValidatorParameters() {
    return false;
  }

  protected class ConvertTaskInstance extends ValidationEngineTaskInstance {

    OutputParameters outputParameters = new OutputParameters();

    ConvertTaskInstance(Arg[] args) {
      super(args);
    }

    @Override
    protected void buildTaskSpecificParametersFromArgs(Arg[] args) {
      Arg.setProcessed(args, ConvertParametersParser.CONVERT, true);
      OutputParametersParser outputParametersParser = new OutputParametersParser();
      outputParametersParser.parseArgs(args);
      outputParameters = outputParametersParser.getParameterObject();
    }

    @Override
    protected void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) throws Exception {
      validationService.convertSources(validationEngine, sources, outputParameters.getOutput(), outputParameters.getOutputSuffix());
    }
  }
}
