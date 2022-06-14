package org.hl7.fhir.utilities.tests.execution;

import java.util.List;

public interface CliTestSummary {
  long getTestsFoundCount();
  long getTestsFailedCount();
  long getTestsAbortedCount();
  long getTestsSkippedCount();

  List<CliTestException> getExceptions();

}
