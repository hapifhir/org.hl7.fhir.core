package org.hl7.fhir.utilities.tests;

import lombok.Getter;

import java.io.PrintStream;

public interface ModuleTestExecutor {

  public abstract String getModuleName();

  public abstract CliTestSummary executeTests(PrintStream out, String classNameFilter);


}
