package org.hl7.fhir.validation.cli.tasks;

import java.io.PrintStream;

import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.hl7.fhir.validation.cli.services.ValidationService;
import org.hl7.fhir.validation.cli.utils.EngineMode;

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
  public boolean shouldExecuteTask(CliContext cliContext, String[] args) {
    return cliContext.getMode() == EngineMode.COMPILE;
  }

  @Override
  public void printHelp(PrintStream out) {

  }

  @Override
  public void executeTask(ValidationService validationService, ValidationEngine validationEngine, CliContext cliContext, String[] args, TimeTracker tt, TimeTracker.Session tts) throws Exception {
    validationService.compile(cliContext, validationEngine);
  }

}
