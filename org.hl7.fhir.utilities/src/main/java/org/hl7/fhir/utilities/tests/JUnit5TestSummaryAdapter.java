package org.hl7.fhir.utilities.tests;

import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
