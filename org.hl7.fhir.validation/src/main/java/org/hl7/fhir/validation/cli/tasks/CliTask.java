package org.hl7.fhir.validation.cli.tasks;

import lombok.Getter;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.validation.cli.model.CliContext;

import java.io.IOException;

public abstract class CliTask {

  public abstract String getName();
  public abstract boolean shouldExecuteTask(CliContext cliContext, String[] args);
  public abstract void printHelp(java.io.PrintStream out);



}
