package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.hl7.fhir.validation.cli.services.ValidationService;
import org.hl7.fhir.validation.cli.utils.Display;
import org.hl7.fhir.validation.cli.utils.EngineMode;

import java.io.PrintStream;

public class TestScriptQuestionnaireTask extends ValidationEngineTask {

  @Override
  public String getName() {
    return "script-questionnaire";
  }

  @Override
  public String getDisplayName() {
    return "Generate Test Script Questionnaire";
  }

  @Override
  public boolean isHidden() {
    return false;
  }

  @Override
  public boolean shouldExecuteTask(CliContext cliContext, String[] args) {
    return cliContext.getMode() == EngineMode.SCRIPT_QUESTIONNAIRE;
  }

  @Override
  public void printHelp(PrintStream out) {
    Display.displayHelpDetails(out,"help/script-questionnaire.txt");
  }

  @Override
  public void executeTask(ValidationService validationService, ValidationEngine validationEngine, CliContext cliContext, String[] args, TimeTracker tt, TimeTracker.Session tts) throws Exception {
    validationService.genScriptQuestionnaire(cliContext, validationEngine);
  }

}
