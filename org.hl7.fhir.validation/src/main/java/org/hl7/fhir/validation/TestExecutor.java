package org.hl7.fhir.validation;

import java.util.Arrays;
import java.util.List;

import org.hl7.fhir.utilities.tests.BaseTestingUtilities;
import org.junit.platform.console.ConsoleLauncherExecutionResult;
import org.junit.platform.console.options.CommandLineOptions;
import org.junit.platform.console.tasks.ConsoleTestExecutor;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.io.PrintWriter;

public class TestExecutor {

  public static void main(String[] args) {
    executeTests();
  }
  public static void executeTests() {

    //System.setProperty("java.locale.providers", "COMPAT");

    System.out.println("env : " + System.getenv("java.locale.providers"));
    System.out.println("prop: " + System.getProperty("java.locale.providers"));

    PrintWriter out = new PrintWriter(System.out);
    PrintWriter err = new PrintWriter(System.err);

    //String dir = System.getenv(FHIR_TEST_CASES_ENV);
    //System.out.println("FHIR Test Cases Directory: " + dir);

    CommandLineOptions clo = new CommandLineOptions();

    BaseTestingUtilities.setFhirTestCasesDirectory("/Users/david.otasek/IN/2021-12-02-fhir-test-cases-by-directory/fhir-test-cases");

    clo.setScanClasspath(true);

    //clo.setIncludedEngines(Arrays.asList("junit-vintage","junit-jupiter"));
    //clo.setExcludedPackages(Arrays.asList("org.hl7.fhir.r4.test"));
    //clo.setIncludedPackages(Arrays.asList("org.hl7.fhir.validation.tests"));
    try {
      ConsoleTestExecutor cte = new ConsoleTestExecutor(clo);
      TestExecutionSummary testExecutionSummary = cte.execute(out);


      // A System.exit is necessary because some okhttp3 mockwebserver tests leave threads running for a considerable
      // amount of time beyond the end of all other tests.
      System.exit(0);
    } catch (Exception exception) {
      exception.printStackTrace();
      System.err.println();
    }
  }
}
