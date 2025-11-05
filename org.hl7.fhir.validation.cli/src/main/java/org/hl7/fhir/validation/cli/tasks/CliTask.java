package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.service.model.ValidationContext;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

public abstract class CliTask {

  public abstract String getName();

  public abstract String getDisplayName();

  public abstract boolean isHidden();

  public abstract boolean shouldExecuteTask(@Nonnull String[] args);

  public abstract void logHelp(Logger logger);

}
