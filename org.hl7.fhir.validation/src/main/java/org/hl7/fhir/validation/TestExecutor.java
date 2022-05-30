package org.hl7.fhir.validation;

import com.google.common.reflect.ClassPath;

import org.hl7.fhir.utilities.tests.execution.CliTestSummary;
import org.hl7.fhir.utilities.tests.execution.junit4.JUnit4TestExecutor;
import org.hl7.fhir.utilities.tests.execution.junit5.JUnit5ModuleTestExecutor;
import org.hl7.fhir.utilities.tests.execution.ModuleTestExecutor;

import java.io.File;
import java.io.IOException;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestExecutor {

  private static final String VALIDATION_MODULE = "org.hl7.fhir.validation";
  private static final String[] JUNIT5_MODULE_NAMES = {
    "org.hl7.fhir.utilities",
    "org.hl7.fhir.convertors",
    "org.hl7.fhir.dstu2",
    "org.hl7.fhir.dstu2016may",
    "org.hl7.fhir.dstu3",
    "org.hl7.fhir.r4",
    "org.hl7.fhir.r4b",
    "org.hl7.fhir.r5",
    VALIDATION_MODULE
  };
  private static String SUMMARY_TEMPLATE = "Tests run: %d, Failures: %d, Errors: %d, Skipped: %d";
  private static final String DOT_PLACEHOLDER = new String(new char[53]).replace("\0", ".");

  private static final int MAX_NAME_LENGTH = 50;

  private static String getModuleResultLine(Map.Entry<String, CliTestSummary> moduleResult) {
    return getModuleNameAndSpacer(moduleResult.getKey())
      + " "
      + getModuleResultString(moduleResult.getValue());
  }

  protected static String getModuleNameAndSpacer(String moduleName) {
    return moduleName.length() < MAX_NAME_LENGTH
      ? moduleName + " " + DOT_PLACEHOLDER.substring(moduleName.length() + 1)
      : moduleName.substring(0, MAX_NAME_LENGTH) + "...";
  }

  protected static String getModuleResultString(CliTestSummary cliTestSummary) {
    if (cliTestSummary.getTestsFoundCount() == 0) {
      return "NO TESTS";
    }

    return cliTestSummary.getTestsFailedCount() == 0 && cliTestSummary.getTestsAbortedCount() == 0
      ? "PASSED"
      : "FAILED";
  }

  public static void printClasspath() {

    String classpath = System.getProperty("java.class.path");
    String[] classPathValues = classpath.split(File.pathSeparator);
    System.out.println(Arrays.toString(classPathValues));
    try {

      ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
      contextClassLoader = Thread.currentThread().getContextClassLoader();

      ClassPath classPath = ClassPath.from(contextClassLoader);
      Set<ClassPath.ClassInfo> classes = classPath.getAllClasses();

      for (ClassPath.ClassInfo classInfo : classes) {
        if (classInfo.getName().contains("junit") || classInfo.getName().contains("hl7")) {
          System.out.println(" classInfo: " + classInfo.getName());
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }


  }

  public static void main(String[] args) {
    System.out.println(isValidModuleParam("org.hl6"));
    System.out.println(isValidModuleParam("org.hl7.fhir.dstu2"));
    System.out.println(isValidModuleParam("org.hl7.fhir.dstu2,org.hl7.fhir.r4"));

    System.out.println(isValidClassnameFilterParam(".*Tests"));
    //executeTests(null, null);
  }

  private static final String MODULE_DELIMITER = ",";

  public static boolean isValidModuleParam(String param) {
    if (param == null) {
      return true;
    }
    final String[] modules = param.split(MODULE_DELIMITER);
    for (String module : modules) {
      if (Arrays.stream(JUNIT5_MODULE_NAMES).noneMatch(i -> i.equals(module))) {
        return false;
      }
    }
    return true;
  }

  public static String[] parseModuleParam(String param) {
    if (param == null) {
      return null;
    } else {
      return param.split(MODULE_DELIMITER);
    }
  }

  public static boolean isValidClassnameFilterParam(String param) {
    try {
      Pattern.compile(param);
     return true;
    } catch (PatternSyntaxException e) {
     return false;
    }
  }
  public static void executeTests(String[] moduleNamesArg, String classNameFilterArg) {
    //printClasspath();
    long start = System.currentTimeMillis();
    //Our lone JUnit 4 test.
    List<ModuleTestExecutor> jUnit4TestExecutors = moduleNamesArg == null
      ? Arrays.asList(new JUnit4TestExecutor(VALIDATION_MODULE, Arrays.asList("org.hl7.fhir.validation.tests.ValidationTests")))
      : Arrays.stream(moduleNamesArg).anyMatch(moduleName -> VALIDATION_MODULE.equals(moduleName))
        ? Arrays.asList( new JUnit4TestExecutor(VALIDATION_MODULE, Arrays.asList("org.hl7.fhir.validation.tests.ValidationTests")))
      : Arrays.asList();

    System.out.println("env : " + System.getenv("java.locale.providers"));
    System.out.println("prop: " + System.getProperty("java.locale.providers"));

    List<ModuleTestExecutor> jUnit5TestExecutors = Arrays.stream(moduleNamesArg == null ? JUNIT5_MODULE_NAMES : moduleNamesArg)
      .map(moduleName -> JUnit5ModuleTestExecutor.getStandardModuleTestExecutor(moduleName))
      .collect(Collectors.toList());

    long testsFoundCount = 0;
    long testsFailedCount = 0;
    long testsAbortedCount = 0;
    long testsSkippedCount = 0;

    final Map<String, CliTestSummary> moduleResultMap = new HashMap<>();

    for (ModuleTestExecutor moduleTestExecutor : Stream.concat( jUnit4TestExecutors.stream(), jUnit5TestExecutors.stream()).collect(Collectors.toList())) {
      final CliTestSummary testExecutionSummary = moduleTestExecutor.executeTests(System.out, classNameFilterArg);
      testsFoundCount += testExecutionSummary.getTestsFoundCount();
      testsFailedCount += testExecutionSummary.getTestsFailedCount();
      testsAbortedCount += testExecutionSummary.getTestsAbortedCount();
      testsSkippedCount += testExecutionSummary.getTestsSkippedCount();
      moduleResultMap.put(moduleTestExecutor.getModuleName(), testExecutionSummary);
    }

    //String dir = System.getenv(FHIR_TEST_CASES_ENV);
    //System.out.println("FHIR Test Cases Directory: " + dir);

    System.out.println("\n\nAll Tests completed.");

    for (Map.Entry<String, CliTestSummary> moduleResult : moduleResultMap.entrySet()) {
      JUnit5ModuleTestExecutor.printSummmary(System.out, moduleResult.getValue(), moduleResult.getKey());
    }

    System.out.println("\nModule Results:\n");

    for (Map.Entry<String, CliTestSummary> moduleResult : moduleResultMap.entrySet()) {
      System.out.println(getModuleResultLine(moduleResult));
    }

    System.out.println();

    System.out.println(String.format(SUMMARY_TEMPLATE, testsFoundCount, testsFailedCount, testsAbortedCount, testsSkippedCount));

    System.out.println("\nCompleted in " + (System.currentTimeMillis() - start) + "ms");

    System.exit(0);

  }
}
