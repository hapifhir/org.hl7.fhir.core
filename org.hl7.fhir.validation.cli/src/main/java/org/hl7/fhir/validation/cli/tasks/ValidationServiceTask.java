package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.service.ValidationService;

import javax.annotation.Nonnull;

public abstract class ValidationServiceTask extends CliTask {

  public abstract void executeTask(@Nonnull ValidationService validationService, @Nonnull String[] args) throws Exception;
}
