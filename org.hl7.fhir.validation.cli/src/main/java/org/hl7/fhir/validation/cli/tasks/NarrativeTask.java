package org.hl7.fhir.validation.cli.tasks;

import java.io.PrintStream;

import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.utils.Display;
import org.hl7.fhir.validation.service.utils.EngineMode;

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
  public boolean shouldExecuteTask(ValidationContext validationContext, String[] args) {
    return validationContext.getMode() == EngineMode.NARRATIVE;
  }

  @Override
  public void printHelp(PrintStream out) {
    Display.displayHelpDetails(out,"help/narrative.txt");
  }

  @Override
  public void executeTask(ValidationService validationService, ValidationEngine validationEngine, ValidationContext validationContext, String[] args, TimeTracker tt, TimeTracker.Session tts) throws Exception {
    validationService.generateNarrative(validationContext, validationEngine);
  }

}
