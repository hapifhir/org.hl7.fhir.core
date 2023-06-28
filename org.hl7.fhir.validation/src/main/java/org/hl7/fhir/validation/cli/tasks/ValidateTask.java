package org.hl7.fhir.validation.cli.tasks;

import ca.uhn.fhir.context.FhirVersionEnum;
import org.hl7.fhir.r5.model.Constants;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.hl7.fhir.validation.cli.services.ValidationService;
import org.hl7.fhir.validation.cli.services.ValidatorWatchMode;
import org.hl7.fhir.validation.cli.utils.Display;

import java.io.PrintStream;

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
  public boolean shouldExecuteTask(CliContext cliContext, String[] args) {
    // There is no explicit way to trigger a validation task.
    // It is the default task.
    return false;
  }

  @Override
  public void printHelp(PrintStream out) {
    Display.displayHelpDetails(out,"help/validate.txt", PLACEHOLDERS);
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

    validationService.validateSources(cliContext, validationEngine, cliContext.getWatchMode(), cliContext.getWatchScanDelay(), cliContext.getWatchSettleTime());

  }
}
