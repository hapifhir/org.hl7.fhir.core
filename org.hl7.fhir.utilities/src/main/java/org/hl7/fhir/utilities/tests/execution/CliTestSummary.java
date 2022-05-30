package org.hl7.fhir.utilities.tests.execution;

import java.util.List;

public interface CliTestSummary {
  public long getTestsFoundCount();
  public long getTestsFailedCount();
  public long getTestsAbortedCount();
  public long getTestsSkippedCount();

  public List<CliTestException> getExceptions();


}
