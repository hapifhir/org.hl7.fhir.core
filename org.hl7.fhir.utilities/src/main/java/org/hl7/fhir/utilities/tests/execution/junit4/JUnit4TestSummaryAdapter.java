package org.hl7.fhir.utilities.tests.execution.junit4;

import java.util.List;
import java.util.stream.Collectors;

import org.hl7.fhir.utilities.tests.execution.CliTestException;
import org.hl7.fhir.utilities.tests.execution.CliTestSummary;
import org.junit.runner.Result;

public class JUnit4TestSummaryAdapter implements CliTestSummary {

  private final Result result;

  public JUnit4TestSummaryAdapter(Result result) {
    this.result = result;
  }
  @Override
  public long getTestsFoundCount() {
    return result.getRunCount();
  }

  @Override
  public long getTestsFailedCount() {
    return result.getFailureCount();
  }

  @Override
  public long getTestsAbortedCount() {
    return 0;
  }

  @Override
  public long getTestsSkippedCount() {
    return 0;
  }

  @Override
  public List<CliTestException> getExceptions() {
    return result.getFailures().stream().map(ex -> new JUnit4TestException(ex)).collect(Collectors.toList());
  }
}
