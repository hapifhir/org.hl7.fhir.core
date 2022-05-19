package org.hl7.fhir.validation;

import com.google.common.reflect.ClassPath;

import org.hl7.fhir.utilities.tests.ModuleTestExecutor;

import java.io.File;
import java.io.IOException;

import java.util.*;

import org.junit.platform.launcher.listeners.TestExecutionSummary;

public class TestExecutor {
  private static String SUMMARY_TEMPLATE = "Tests run: %d, Failures: %d, Errors: %d, Skipped: %d";
  private static final String DOT_PLACEHOLDER = new String(new char[53]).replace("\0", ".");

  private static String getModuleResultLine(Map.Entry<String, TestExecutionSummary> moduleResult) {
    return (moduleResult.getKey().length() < 50
      ? moduleResult.getKey() + " " +  DOT_PLACEHOLDER.substring(moduleResult.getKey().length() + 1)
      : moduleResult.getKey().substring(0,50) + "..." )
      + " "
      + ((moduleResult.getValue().getTestsFailedCount() == 0 && moduleResult.getValue().getTestsAbortedCount() == 0) ? "PASSED" : "FAILED");
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
    executeTests();
  }



  public static void executeTests() {
    //printClasspath();

    System.out.println("env : " + System.getenv("java.locale.providers"));
    System.out.println("prop: " + System.getProperty("java.locale.providers"));

    List<ModuleTestExecutor> testExecutors = Arrays.asList(

      ModuleTestExecutor.getStandardModuleTestExecutor("org.hl7.fhir.utilities"),
      ModuleTestExecutor.getStandardModuleTestExecutor("org.hl7.fhir.convertors"),
      ModuleTestExecutor.getStandardModuleTestExecutor("org.hl7.fhir.dstu2"),
      ModuleTestExecutor.getStandardModuleTestExecutor("org.hl7.fhir.dstu2016may"),
      ModuleTestExecutor.getStandardModuleTestExecutor("org.hl7.fhir.dstu3"),
      ModuleTestExecutor.getStandardModuleTestExecutor("org.hl7.fhir.r4"),
      ModuleTestExecutor.getStandardModuleTestExecutor("org.hl7.fhir.r4b"),
      ModuleTestExecutor.getStandardModuleTestExecutor("org.hl7.fhir.r5"),
      ModuleTestExecutor.getStandardModuleTestExecutor("org.hl7.fhir.validation")

      );

    long testsFoundCount = 0;
    long testsFailedCount = 0;
    long testsAbortedCount = 0;
    long testsSkippedCount = 0;

    final Map<String, TestExecutionSummary> moduleResultMap = new HashMap<>();

    for (ModuleTestExecutor moduleTestExecutor : testExecutors) {
      final TestExecutionSummary testExecutionSummary = moduleTestExecutor.executeTests(System.out, null);
      testsFoundCount += testExecutionSummary.getTestsFoundCount();
      testsFailedCount += testExecutionSummary.getTestsFailedCount();
      testsAbortedCount += testExecutionSummary.getTestsAbortedCount();
      testsSkippedCount += testExecutionSummary.getTestsSkippedCount();
      moduleResultMap.put(moduleTestExecutor.getModuleName(), testExecutionSummary);
    }

    //String dir = System.getenv(FHIR_TEST_CASES_ENV);
    //System.out.println("FHIR Test Cases Directory: " + dir);

    System.out.println("\n\nAll Tests completed.");

    for (Map.Entry<String, TestExecutionSummary> moduleResult : moduleResultMap.entrySet()) {
      ModuleTestExecutor.printSummmary(System.out, moduleResult.getValue(), moduleResult.getKey());
    }

    System.out.println("\nModule Results:\n");

    for (Map.Entry<String, TestExecutionSummary> moduleResult : moduleResultMap.entrySet()) {
        System.out.println(getModuleResultLine(moduleResult));
    }

    System.out.println();

    System.out.println(String.format(SUMMARY_TEMPLATE, testsFoundCount, testsFailedCount, testsAbortedCount, testsSkippedCount));

    System.exit(0);

  }
}
