package org.hl7.fhir.validation.cli.tasks;

import java.io.PrintStream;

import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.hl7.fhir.validation.cli.utils.Display;
import org.hl7.fhir.validation.cli.utils.Params;
import org.hl7.fhir.validation.testexecutor.TestExecutor;
import org.hl7.fhir.validation.testexecutor.TestExecutorParams;

public class TestsTask extends StandaloneTask{
  @Override
  public String getName() {
    return "tests";
  }

  @Override
  public String getDisplayName() {
    return "Tests";
  }

  @Override
  public boolean isHidden() {
    return false;
  }

  @Override
  public boolean shouldExecuteTask(CliContext cliContext, String[] args) {
    return Params.hasParam(args, Params.TEST);
  }

  @Override
  public void printHelp(PrintStream out) {
    Display.displayHelpDetails(out,"help/tests.txt");
  }

  @Override
  public void executeTask(CliContext cliContext, String[] args, TimeTracker tt, TimeTracker.Session tts) throws Exception {
      final String testModuleParam = Params.getParam(args, Params.TEST_MODULES);
      final String testClassnameFilter = Params.getParam(args, Params.TEST_NAME_FILTER);
      final String testCasesDirectory = Params.getParam(args, Params.TEST);
      if (testCasesDirectory == null) {
        System.out.println("No fhir-test-cases directory provided. Required usage: -tests <fhir-test-cases-directory>");
        System.exit(1);
      }

      final String txCacheDirectory = Params.getParam(args, Params.TERMINOLOGY_CACHE);
      assert TestExecutorParams.isValidModuleParam(testModuleParam) : "Invalid test module param: " + testModuleParam;
      final String[] moduleNamesArg = TestExecutorParams.parseModuleParam(testModuleParam);

      assert TestExecutorParams.isValidClassnameFilterParam(testClassnameFilter) : "Invalid regex for test classname filter: " + testClassnameFilter;

      new TestExecutor(moduleNamesArg).executeTests(testClassnameFilter, txCacheDirectory, testCasesDirectory);

      System.exit(0);
  }
}
