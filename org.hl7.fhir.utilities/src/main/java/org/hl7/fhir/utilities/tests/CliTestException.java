package org.hl7.fhir.utilities.tests;

public interface CliTestException {

  public String getTestId();
  public Throwable getException();
}
