package org.hl7.fhir.utilities.tests.execution;

public interface CliTestException {

  public String getTestId();
  public Throwable getException();
}
