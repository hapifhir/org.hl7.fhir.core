package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.service.model.ValidationContext;
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
  public boolean shouldExecuteTask(@Nonnull ValidationContext validationContext, @Nonnull String[] args) {
    return shouldExecuteTask(args);
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    return Params.hasParam(args, Params.SPREADSHEET);
  }

  @Override
  public void logHelp(Logger logger) {

  }

  //FIXME get rid of ValidationContext usage
  @Override
  public void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine, @Nonnull ValidationContext validationContext, @Nonnull String[] args) throws Exception {
    validationService.generateSpreadsheet(validationContext, validationEngine);
  }

}
