package org.hl7.fhir.utilities.tests.execution;

import java.io.PrintStream;

import org.hl7.fhir.utilities.tests.execution.junit5.JUnit5ModuleTestExecutor;
import org.slf4j.Logger;

public abstract class ModuleTestExecutor {
  private static final String FAILURE_SUMMARY_TEMPLATE = "Test failures for module %s (%d):";
  private static final String STARTING_TEST_TEMPLATE = "Starting: %s";

  private static final String FINISHED_TEST_TEMPLATE = "Finished: %s with result: %s";
  private static final String FAILED_TEST_TEMPLATE = "Failed Test ID: %s";

  /**
   * Utility method to print the summary of execution in human-readable
   * format.
   * <br/>
   * Any test failures are listed using the same unique IDs output in
   * the {@link JUnit5ModuleTestExecutor#executeTests(Logger, String)}
   * method.
   *
   * @param log the log to write summary data to.
   * @param testExecutionSummary the test summary
   * @param moduleName the module name
   */
  public static void logSummary(Logger log, CliTestSummary testExecutionSummary, String moduleName) {
    log.info("\n" + String.format(FAILURE_SUMMARY_TEMPLATE, moduleName, testExecutionSummary.getTestsFailedCount()));
    for (CliTestException failure : testExecutionSummary.getExceptions()) {
      log.info("\t" + failure.getTestId() + ": " + failure.getException().getMessage());
    }
    log.info("");
  }

  public static void printTestStarted(Logger log, String displayName) {
    log.info(String.format(STARTING_TEST_TEMPLATE, displayName));
  }

  public static void printTestFailed(Logger log, String uniqueIdentifier, Throwable throwable) {

      log.info(String.format(FAILED_TEST_TEMPLATE, uniqueIdentifier));
        if (throwable != null) {
          throwable.printStackTrace(System.out);
        }
  }

  public static void printTestFinished(Logger log, String displayName, String status) {
    log.info(String.format(FINISHED_TEST_TEMPLATE, displayName, status));
  }

  public abstract String getModuleName();

  public abstract CliTestSummary executeTests(Logger log, String classNameFilter);

}
