package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.cli.param.parsers.NarrativeParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.OutputParametersParser;
import org.hl7.fhir.validation.service.model.OutputParameters;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.cli.Display;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

public class NarrativeTask extends ValidationEngineTask {

  @Override
  public String getName() {
    return "narrative";
  }

  @Override
  public String getDisplayName() {
    return "Narratives";
  }

  @Override
  public boolean isHidden() {
    return false;
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    return Params.hasParam(args, NarrativeParametersParser.NARRATIVE);
  }

  @Override
  public void logHelp(Logger logger) {
    Display.displayHelpDetails( logger,"help/narrative.txt");
  }

  @Override
  protected NarrativeTaskInstance getValidationEngineTaskInstance(Arg[] args) {
    return new NarrativeTaskInstance(args);
  }

  @Override
  public boolean usesInstanceValidatorParameters() {
    return false;
  }

  protected class NarrativeTaskInstance extends ValidationEngineTaskInstance {

    OutputParameters outputParameters;

    NarrativeTaskInstance(Arg[] args) {
      super(args);
    }

    @Override
    protected void buildTaskSpecificParametersFromArgs(Arg[] args) {
      Arg.setProcessed(args, NarrativeParametersParser.NARRATIVE, true);
      OutputParametersParser outputParametersParser = new OutputParametersParser();
      outputParametersParser.parseArgs(args);
      outputParameters = outputParametersParser.getParameterObject();
    }

    @Override
    protected void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) throws Exception {
      validationService.generateNarrative(validationEngine,validationEngineParameters.getSv(), sources, outputParameters.getOutput());
    }
  }
}
