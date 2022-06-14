package org.hl7.fhir.utilities.tests.execution;

import org.hl7.fhir.utilities.tests.execution.junit5.JUnit5ModuleTestExecutor;

import java.io.PrintStream;

public abstract class ModuleTestExecutor {
  private static final String FAILURE_SUMMARY_TEMPLATE = "Test failures for module %s (%d):";
  private static final String STARTING_TEST_TEMPLATE = "Starting: %s";

  private static final String FINISHED_TEST_TEMPLATE = "Finished: %s with result: %s";
  private static final String FAILED_TEST_TEMPLATE = "Failed Test ID: %s";

  /**
   * Utility method to print the summary of execution in human-readable
   * format.
   *
   * Any test failures are listed using the same unique IDs output in
   * the {@link JUnit5ModuleTestExecutor#executeTests(PrintStream, String)}
   * method.
   *
   * @param out the PrintStream to log summary data to.
   * @param testExecutionSummary the test summary
   * @param moduleName the module name
   */
  public static void printSummmary(PrintStream out, CliTestSummary testExecutionSummary, String moduleName) {
    if (testExecutionSummary.getTestsFailedCount() > 0) {
      out.println("\n" + String.format(FAILURE_SUMMARY_TEMPLATE, moduleName, testExecutionSummary.getTestsFailedCount()));
      for (CliTestException failure : testExecutionSummary.getExceptions()) {
        out.println("\t" + failure.getTestId() + ": " + failure.getException().getMessage());
      }
      out.println();
    }
  }

  public static void printTestStarted(PrintStream out, String displayName) {
    out.println(String.format(STARTING_TEST_TEMPLATE, displayName));
  }

  public static void printTestFailed(PrintStream out, String uniqueIdentifier, Throwable throwable) {

      out.println(String.format(FAILED_TEST_TEMPLATE, uniqueIdentifier));
        if (throwable != null) {
          throwable.printStackTrace(System.out);
        }
  }

  public static void printTestFinished(PrintStream out, String displayName, String status) {
    out.println(String.format(FINISHED_TEST_TEMPLATE, displayName, status));
  }

  public abstract String getModuleName();

  public abstract CliTestSummary executeTests(PrintStream out, String classNameFilter);

}
