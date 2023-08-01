package org.hl7.fhir.utilities.tests.execution.junit5;

import java.util.List;
import java.util.stream.Collectors;

import org.hl7.fhir.utilities.tests.execution.CliTestException;
import org.hl7.fhir.utilities.tests.execution.CliTestSummary;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

public class JUnit5TestSummaryAdapter implements CliTestSummary {


  final TestExecutionSummary testExecutionSummary;

  public JUnit5TestSummaryAdapter( TestExecutionSummary testExecutionSummary) {
    this.testExecutionSummary = testExecutionSummary;
  }

  @Override
  public long getTestsFoundCount() {
    return testExecutionSummary.getTestsFoundCount();
  }

  @Override
  public long getTestsFailedCount() {
    return testExecutionSummary.getTestsFailedCount();
  }

  @Override
  public long getTestsAbortedCount() {
    return testExecutionSummary.getTestsAbortedCount();
  }

  @Override
  public long getTestsSkippedCount() {
    return testExecutionSummary.getTestsSkippedCount();
  }

  @Override
  public List<CliTestException> getExceptions() {
    return testExecutionSummary.getFailures().stream().map(ex -> new JUnit5TestException(ex)).collect(Collectors.toList());
  }
}
