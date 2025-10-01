package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.cli.Display;

import org.slf4j.Logger;

import javax.annotation.Nonnull;

public class SnapshotTask extends ValidationEngineTask {

  @Override
  public String getName() {
    return "snapshot";
  }

  @Override
  public String getDisplayName() {
    return "Snapshots";
  }

  @Override
  public boolean isHidden() {
    return false;
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull ValidationContext validationContext, @Nonnull String[] args) {
    return Params.hasParam(args, Params.SNAPSHOT);
  }

  @Override
  public void logHelp(Logger logger) {
    Display.displayHelpDetails(logger,"help/snapshot.txt");
  }

  @Override
  public void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine, @Nonnull ValidationContext validationContext, @Nonnull String[] args) throws Exception {
    validationService.generateSnapshot(validationContext, validationEngine);
  }

}
