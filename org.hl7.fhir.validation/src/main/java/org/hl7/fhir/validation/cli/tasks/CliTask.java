package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.cli.model.CliContext;

public abstract class CliTask {

  public abstract String getName();

  public abstract String getDisplayName();

  public abstract boolean isHidden();
  public abstract boolean shouldExecuteTask(CliContext cliContext, String[] args);
  public abstract void printHelp(java.io.PrintStream out);



}
