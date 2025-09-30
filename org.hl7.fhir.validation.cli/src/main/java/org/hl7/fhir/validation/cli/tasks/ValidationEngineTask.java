package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.ValidationService;

import javax.annotation.Nonnull;

public abstract class ValidationEngineTask extends CliTask{

  //FIXME ValidationContext should not be here. The relevant parameters should be passed using another means
  public abstract void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine, @Nonnull ValidationContext validationContext, @Nonnull String[] args) throws Exception;

  public boolean inferFhirVersion() {
    return false;
  }
}
