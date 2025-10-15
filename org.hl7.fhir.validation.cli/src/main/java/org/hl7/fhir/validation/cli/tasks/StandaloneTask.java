package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.model.ValidationContext;

import javax.annotation.Nonnull;

public abstract class StandaloneTask extends CliTask{

  @Deprecated
  public abstract void executeTask(@Nonnull ValidationContext validationContext, @Nonnull String[] args) throws Exception;
  public abstract void executeTask(@Nonnull String[] args) throws Exception;
}
