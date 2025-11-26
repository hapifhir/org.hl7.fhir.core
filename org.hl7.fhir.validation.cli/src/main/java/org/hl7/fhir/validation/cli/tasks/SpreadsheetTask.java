package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.cli.param.parsers.OutputParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.SpreadsheetParamsParser;
import org.hl7.fhir.validation.service.model.OutputParameters;
import org.hl7.fhir.validation.service.ValidationService;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

public class SpreadsheetTask extends ValidationEngineTask {

  @Override
  public String getName() {
    return "spreadsheet";
  }

  @Override
  public String getDisplayName() {
    return "Spreadsheet";
  }

  @Override
  public boolean isHidden() {
    return true;
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    return Params.hasParam(args, SpreadsheetParamsParser.SPREADSHEET);
  }

  @Override
  public void logHelp(Logger logger) {

  }

  @Override
  protected SpreadsheetTaskInstance getValidationEngineTaskInstance(Arg[] args) {
    return new SpreadsheetTaskInstance(args);
  }

  @Override
  public boolean usesInstanceValidatorParameters() {
    return false;
  }

  protected class SpreadsheetTaskInstance extends ValidationEngineTaskInstance {

    OutputParameters outputParameters;

    SpreadsheetTaskInstance(Arg[] args) {
      super(args);
    }

    @Override
    protected void buildTaskSpecificParametersFromArgs(Arg[] args) {
      Arg.setProcessed(args, SpreadsheetParamsParser.SPREADSHEET, true);
      OutputParametersParser outputParametersParser = new OutputParametersParser();
      outputParametersParser.parseArgs(args);
      outputParameters = outputParametersParser.getParameterObject();
    }

    @Override
    protected void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) throws Exception {
      validationService.generateSpreadsheet(validationEngine, validationEngineParameters.getSv(), sources, outputParameters.getOutput());
    }
  }
}
