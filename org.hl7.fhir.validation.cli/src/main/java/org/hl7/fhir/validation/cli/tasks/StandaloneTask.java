package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.service.model.ValidationContext;

import javax.annotation.Nonnull;

public abstract class StandaloneTask extends CliTask{

  public abstract void executeTask(@Nonnull ValidationContext validationContext, @Nonnull String[] args) throws Exception;
  
}
