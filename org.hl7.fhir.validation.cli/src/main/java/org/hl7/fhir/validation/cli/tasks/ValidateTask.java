package org.hl7.fhir.validation.cli.tasks;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.model.Constants;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.cli.Display;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

@Slf4j
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
  public boolean shouldExecuteTask(@Nonnull ValidationContext validationContext, @Nonnull String[] args) {
    return shouldExecuteTask(args);
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    // There is no explicit way to trigger a validation task.
    // It is the default task.
    return false;
  }

  @Override
  public void logHelp(Logger logger) {
    Display.displayHelpDetails(logger,"help/validate.txt", PLACEHOLDERS);
  }

  @Override
  public void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine, @Nonnull ValidationContext validationContext, @Nonnull String[] args) throws Exception {
  //FIXME replace ValidationContext
    if (validationContext.getExpansionParameters() != null) {
      validationEngine.loadExpansionParameters(validationContext.getExpansionParameters());
    }
    
    for (String s : validationContext.getProfiles()) {
      if (!validationEngine.getContext().hasResource(StructureDefinition.class, s) && !validationEngine.getContext().hasResource(ImplementationGuide.class, s)) {
        log.info("  Fetch Profile from " + s);
        validationEngine.loadProfile(validationContext.getLocations().getOrDefault(s, s));
      }
    }
    log.info("Validating");

    validationService.validateSources(validationContext, validationEngine, validationContext.getWatchMode(), validationContext.getWatchScanDelay(), validationContext.getWatchSettleTime());

    if (validationContext.getAdvisorFile() != null) {
      log.info("Note: Some validation issues might be hidden by the advisor settings in the file "+ validationContext.getAdvisorFile());
    }
  }

  @Override
  public boolean inferFhirVersion() {
    return true;
  }
}
