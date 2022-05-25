package org.hl7.fhir.utilities.tests;

import org.junit.runner.notification.Failure;

public class JUnit4TestException implements CliTestException {

  private final Failure failure;

  public JUnit4TestException(Failure failure) {
    this.failure = failure;
  }
  @Override
  public String getTestId() {
    return failure.getDescription().getClassName() + failure.getDescription().getMethodName() + failure.getDescription().getDisplayName();
  }

  @Override
  public Throwable getException() {
    return failure.getException();
  }
}
