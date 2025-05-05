package org.hl7.fhir.validation.cli.tasks;

import java.io.PrintStream;

import org.hl7.fhir.r5.model.Constants;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.utils.Display;

public class ValidateTask extends ValidationEngineTask {

  final static String[][] PLACEHOLDERS = {
    { "XML_AND_JSON_FHIR_VERSIONS", "1.0, 1.4, 3.0, 4.0, " + Constants.VERSION_MM + ", 6.0" },
    { "TURTLE_FHIR_VERSIONS", "3.0, 4.0, " + Constants.VERSION_MM },
    { "FHIR_MAJOR_VERSIONS", VersionUtilities.listSupportedMajorVersions()},
    { "FHIR_MINOR_VERSIONS", VersionUtilities.listSupportedVersions() },
    { "FHIR_CURRENT_VERSION", Constants.VERSION_MM}
  };

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
  public boolean shouldExecuteTask(ValidationContext validationContext, String[] args) {
    // There is no explicit way to trigger a validation task.
    // It is the default task.
    return false;
  }

  @Override
  public void printHelp(PrintStream out) {
    Display.displayHelpDetails(out,"help/validate.txt", PLACEHOLDERS);
  }

  @Override
  public void executeTask(ValidationService validationService, ValidationEngine validationEngine, ValidationContext validationContext, String[] args, TimeTracker tt, TimeTracker.Session tts) throws Exception {
    if (validationContext.getExpansionParameters() != null) {
      validationEngine.loadExpansionParameters(validationContext.getExpansionParameters());
    }
    
    for (String s : validationContext.getProfiles()) {
      if (!validationEngine.getContext().hasResource(StructureDefinition.class, s) && !validationEngine.getContext().hasResource(ImplementationGuide.class, s)) {
        System.out.println("  Fetch Profile from " + s);
        validationEngine.loadProfile(validationContext.getLocations().getOrDefault(s, s));
      }
    }
    System.out.println("Validating");

    validationService.validateSources(validationContext, validationEngine, validationContext.getWatchMode(), validationContext.getWatchScanDelay(), validationContext.getWatchSettleTime());

  }
}
