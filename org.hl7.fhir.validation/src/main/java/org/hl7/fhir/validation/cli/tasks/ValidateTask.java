package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.hl7.fhir.validation.cli.services.ValidationService;

import java.io.PrintStream;

public class ValidateTask extends ValidationServiceTask {

  @Override
  public String getName() {
    return "validate";
  }

  @Override
  public String getDisplayName() {
    return "Validation";
  }

  @Override
  public boolean isHidden() {
    return false;
  }

  @Override
  public boolean shouldExecuteTask(CliContext cliContext, String[] args) {
    // There is no explicit way to trigger a validation task.
    // It is the default task.
    return false;
  }

  @Override
  public void printHelp(PrintStream out) {

  }

  @Override
  public void executeTask(ValidationService validationService, ValidationEngine validationEngine, CliContext cliContext, String[] args, TimeTracker tt, TimeTracker.Session tts) throws Exception {
    for (String s : cliContext.getProfiles()) {
      if (!validationEngine.getContext().hasResource(StructureDefinition.class, s) && !validationEngine.getContext().hasResource(ImplementationGuide.class, s)) {
        System.out.println("  Fetch Profile from " + s);
        validationEngine.loadProfile(cliContext.getLocations().getOrDefault(s, s));
      }
    }
    System.out.println("Validating");

    validationService.validateSources(cliContext, validationEngine);

  }
}
