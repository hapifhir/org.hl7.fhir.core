package org.hl7.fhir.utilities.tests;

import org.junit.platform.launcher.listeners.TestExecutionSummary;

public class JUnit5TestException implements CliTestException {

  private final TestExecutionSummary.Failure ex;
  public JUnit5TestException(TestExecutionSummary.Failure ex) {
    this.ex = ex;
  }

  @Override
  public String getTestId() {
    return ex.getTestIdentifier().getUniqueId();
  }

  @Override
  public Throwable getException() {
    return ex.getException();
  }
}
