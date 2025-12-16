package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.testexecutor.TestExecutor;
import org.hl7.fhir.validation.testexecutor.TestExecutorParams;
import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * Command to run JUnit tests for the FHIR core library against test cases.
 * <p/>
 * This command executes all JUnit tests against a local directory following the
 * conventions of https://github.com/FHIR/fhir-test-cases.
 * <p/>
 * IMPORTANT: Must be executed with Java property: java.locale.providers=COMPAT
 * Example: java -Djava.locale.providers=COMPAT -jar validator_cli.jar tests ./path/to/fhir-test-cases
 */
@Slf4j
@CommandLine.Command(
  name = "tests",
  description = """
    Run JUnit tests for the FHIR core library against test cases.

    Executes all JUnit tests against a local directory following the
    conventions of https://github.com/FHIR/fhir-test-cases.

    Must be executed with Java property: java.locale.providers=COMPAT

    Example: java -Djava.locale.providers=COMPAT -jar validator_cli.jar tests ./path/to/fhir-test-cases
    """,
  hidden = false
)
public class TestsCommand extends ValidationServiceCommand implements Callable<Integer> {

  @CommandLine.Parameters(
    index = "0",
    description = "Path to fhir-test-cases directory (must follow github.com/FHIR/fhir-test-cases conventions)"
  )
  private String testCasesDirectory;

  @CommandLine.Option(
    names = {"-test-modules"},
    description = "Comma-delimited list of Java module names to test (default: all modules). Example: org.hl7.fhir.dstu2,org.hl7.fhir.dstu2016may"
  )
  private String testModules;

  @CommandLine.Option(
    names = {"-test-classname-filter"},
    description = "Regex filter for test Java class names (default: all tests). Example: .*ShexGeneratorTests"
  )
  private String testClassnameFilter;

  @CommandLine.Option(
    names = {"-txCache"},
    description = "Path to terminology cache directory"
  )
  private String txCacheDirectory;

  @Override
  public Integer call() {
    try {
      validateTestsParameters();

      // Parse module names
      final String[] moduleNamesArg = TestExecutorParams.parseModuleParam(testModules);

      // Execute tests using TestExecutor
      new TestExecutor(moduleNamesArg).executeTests(
        testClassnameFilter,
        txCacheDirectory,
        testCasesDirectory
      );

      log.info("Tests completed successfully");
      return 0;

    } catch (Exception e) {
      log.error("Error executing tests", e);
      return 1;
    }
  }

  private void validateTestsParameters() {
    // Validate test cases directory is provided (should be caught by Picocli required, but double check)
    if (testCasesDirectory == null || testCasesDirectory.isEmpty()) {
      log.error("No fhir-test-cases directory provided. Required usage: tests <fhir-test-cases-directory>");
      System.exit(1);
    }

    // Validate module parameter if provided
    if (testModules != null && !TestExecutorParams.isValidModuleParam(testModules)) {
      log.error("Invalid test module param: {}", testModules);
      System.exit(1);
    }

    // Validate classname filter if provided
    if (testClassnameFilter != null && !TestExecutorParams.isValidClassnameFilterParam(testClassnameFilter)) {
      log.error("Invalid regex for test classname filter: {}", testClassnameFilter);
      System.exit(1);
    }
  }
}
