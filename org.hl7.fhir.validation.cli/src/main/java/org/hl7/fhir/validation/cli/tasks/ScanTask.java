package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.validation.Scanner;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.utils.EngineMode;
import org.slf4j.Logger;

public class ScanTask extends ValidationEngineTask {


  @Override
  public String getName() {
    return "scan";
  }

  @Override
  public String getDisplayName() {
    return "Scan";
  }

  @Override
  public boolean isHidden() {
    return true;
  }

  @Override
  public boolean shouldExecuteTask(ValidationContext validationContext, String[] args) {
    return validationContext.getMode() == EngineMode.SCAN;
  }

  @Override
  public void logHelp(Logger logger) {

  }

  @Override
  public void executeTask(ValidationService validationService, ValidationEngine validationEngine, ValidationContext validationContext, String[] args) throws Exception {
    Scanner validationScanner = new Scanner(validationEngine.getContext(), validationEngine.getValidator(null), validationEngine.getIgLoader(), validationEngine.getFhirPathEngine());
    validationScanner.validateScan(validationContext.getOutput(), validationContext.getSources());
  }

}
