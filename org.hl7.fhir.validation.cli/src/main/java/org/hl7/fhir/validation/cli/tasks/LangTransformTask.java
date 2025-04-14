package org.hl7.fhir.validation.cli.tasks;

import java.io.PrintStream;

import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.model.ValidationContext;
import org.hl7.fhir.validation.cli.services.ValidationService;
import org.hl7.fhir.validation.cli.utils.EngineMode;

public class LangTransformTask extends ValidationEngineTask {

  @Override
  public String getName() {
    return "lang-transform";
  }

  @Override
  public String getDisplayName() {
    return "Lang Transform";
  }

  @Override
  public boolean isHidden() {
    return true;
  }

  @Override
  public boolean shouldExecuteTask(ValidationContext validationContext, String[] args) {
    return validationContext.getMode() == EngineMode.LANG_TRANSFORM;
  }

  @Override
  public void printHelp(PrintStream out) {

  }

  @Override
  public void executeTask(ValidationService validationService, ValidationEngine validationEngine, ValidationContext validationContext, String[] args, TimeTracker tt, TimeTracker.Session tts) throws Exception {
    validationService.transformLang(validationContext, validationEngine);
  }

}
