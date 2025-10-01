package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.model.ValidationContext;

import javax.annotation.Nonnull;

public abstract class ValidationServiceTask extends CliTask {
  public abstract void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationContext validationContext, @Nonnull String[] args) throws Exception;
}
