package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.Scanner;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.ValidationService;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

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
  public boolean shouldExecuteTask(@Nonnull ValidationContext validationContext, @Nonnull String[] args) {
    return shouldExecuteTask(args);
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    return Params.hasParam(args, Params.SCAN);
  }

  @Override
  public void logHelp(Logger logger) {

  }

  @Override
  public void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine, @Nonnull ValidationContext validationContext, @Nonnull String[] args) throws Exception {
    Scanner validationScanner = new Scanner(validationEngine.getContext(), validationEngine.getValidator(null), validationEngine.getIgLoader(), validationEngine.getFhirPathEngine());
    //FIXME replace ValidationContext
    validationScanner.validateScan(validationContext.getOutput(), validationContext.getSources());
  }

}
