package org.hl7.fhir.validation.cli.tasks;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.cli.Display;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.testexecutor.TestExecutor;
import org.hl7.fhir.validation.testexecutor.TestExecutorParams;
import org.slf4j.Logger;

@Slf4j
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
  public boolean shouldExecuteTask(ValidationContext validationContext, String[] args) {
    return Params.hasParam(args, Params.TEST);
  }

  @Override
  public void logHelp(Logger logger) {
    Display.displayHelpDetails(logger,"help/tests.txt");
  }

  @Override
  public void executeTask(ValidationContext validationContext, String[] args) throws Exception {
      final String testModuleParam = Params.getParam(args, Params.TEST_MODULES);
      final String testClassnameFilter = Params.getParam(args, Params.TEST_NAME_FILTER);
      final String testCasesDirectory = Params.getParam(args, Params.TEST);
      if (testCasesDirectory == null) {
        log.error("No fhir-test-cases directory provided. Required usage: -tests <fhir-test-cases-directory>");
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
