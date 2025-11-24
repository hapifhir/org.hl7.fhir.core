package org.hl7.fhir.validation.cli.tasks;

import javax.annotation.Nonnull;

public abstract class StandaloneTask extends CliTask{
  public abstract void executeTask(@Nonnull String[] args) throws Exception;
}
