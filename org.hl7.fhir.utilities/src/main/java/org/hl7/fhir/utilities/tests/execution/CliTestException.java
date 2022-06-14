package org.hl7.fhir.utilities.tests.execution;

public interface CliTestException {
  String getTestId();
  Throwable getException();
}
