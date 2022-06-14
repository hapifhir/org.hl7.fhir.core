package org.hl7.fhir.validation.testexecutor;

import org.hl7.fhir.utilities.tests.TestConfig;
import org.hl7.fhir.utilities.tests.execution.CliTestSummary;
import org.hl7.fhir.utilities.tests.execution.junit4.JUnit4TestExecutor;
import org.hl7.fhir.utilities.tests.execution.junit5.JUnit5ModuleTestExecutor;
import org.hl7.fhir.utilities.tests.execution.ModuleTestExecutor;

import javax.annotation.Nonnull;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hl7.fhir.validation.testexecutor.TestModules.*;

public class TestExecutor {


  public static final String TX_CACHE = "txCache";


  private static String SUMMARY_TEMPLATE = "Tests run: %d, Failures: %d, Errors: %d, Skipped: %d";
  private static final String DOT_PLACEHOLDER = new String(new char[53]).replace("\0", ".");

  private static final int MAX_NAME_LENGTH = 50;

  private static String getModuleResultLine(String moduleName, CliTestSummary moduleTestSummary) {
    return getModuleNameAndSpacer(moduleName)
      + " "
      + getModuleResultString(moduleTestSummary);
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




  public static boolean pathExistsAsDirectory(String directoryPath) {
    Path path = Paths.get(directoryPath);
    return Files.exists(path)
      && Files.isDirectory(path);
  }

  public static void executeTests(String[] moduleNamesArg, String classNameFilterArg, String txCacheDirectoryPath, String testCasesDirectoryPath) {

    long start = System.currentTimeMillis();
    //Our lone JUnit 4 test.
    List<ModuleTestExecutor> jUnit4TestExecutors = getjUnit4TestExecutors(moduleNamesArg);

    TestConfig.getInstance().setRebuildCache(true);

    setUpDirectories(txCacheDirectoryPath, testCasesDirectoryPath);

    List<ModuleTestExecutor> jUnit5TestExecutors = getjUnit5TestExecutors(moduleNamesArg);

    long testsFoundCount = 0;
    long testsFailedCount = 0;
    long testsAbortedCount = 0;
    long testsSkippedCount = 0;

    final Map<String, CliTestSummary> moduleResultMap = new HashMap<>();

    final List<ModuleTestExecutor> orderedModuleTestExecutors = Stream.concat(jUnit5TestExecutors.stream(), jUnit4TestExecutors.stream()).collect(Collectors.toList());

    for (ModuleTestExecutor moduleTestExecutor : orderedModuleTestExecutors) {
      final CliTestSummary testExecutionSummary = moduleTestExecutor.executeTests(System.out, classNameFilterArg);
      testsFoundCount += testExecutionSummary.getTestsFoundCount();
      testsFailedCount += testExecutionSummary.getTestsFailedCount();
      testsAbortedCount += testExecutionSummary.getTestsAbortedCount();
      testsSkippedCount += testExecutionSummary.getTestsSkippedCount();
      moduleResultMap.put(moduleTestExecutor.getModuleName(), testExecutionSummary);
    }

    System.out.println("\n\nAll Tests completed.");

    for (ModuleTestExecutor moduleTestExecutor : orderedModuleTestExecutors) {
      JUnit5ModuleTestExecutor.printSummmary(System.out, moduleResultMap.get(moduleTestExecutor.getModuleName()), moduleTestExecutor.getModuleName());
    }

    System.out.println("\nModule Results:\n");

    for (ModuleTestExecutor moduleTestExecutor : orderedModuleTestExecutors) {
      System.out.println(getModuleResultLine(moduleTestExecutor.getModuleName(), moduleResultMap.get(moduleTestExecutor.getModuleName())));
    }

    System.out.println();
    System.out.println(String.format(SUMMARY_TEMPLATE, testsFoundCount, testsFailedCount, testsAbortedCount, testsSkippedCount));
    System.out.println("\nCompleted in " + (System.currentTimeMillis() - start) + "ms");

    System.exit(0);

  }

  private static void setUpDirectories(String txCacheDirectoryPath, String testCasesDirectoryPath) {
    if (testCasesDirectoryPath != null
      && pathExistsAsDirectory(testCasesDirectoryPath)
    ) {
      TestConfig.getInstance().setFhirTestCasesDirectory(testCasesDirectoryPath);
    } else {
      throw new RuntimeException("fhir-test-cases directory does not exist: " + testCasesDirectoryPath);
    }
    try {
      String txCacheDirectory = getOrCreateTxCacheDirectory(txCacheDirectoryPath);
      if (!pathExistsAsDirectory(testCasesDirectoryPath)) {
        throw new RuntimeException("txCache directory does not exist: " + txCacheDirectory);
      }
      TestConfig.getInstance().setTxCacheDirectory(txCacheDirectory);
    } catch (IOException e) {
      throw new RuntimeException("Unable to create temporary resource directory.", e);
    }
  }

  private static String getOrCreateTxCacheDirectory(String txCacheDirectoryParam) throws IOException {
    final String txCacheDirectory;

    if (txCacheDirectoryParam != null) {
      txCacheDirectory = txCacheDirectoryParam;
    } else {
      txCacheDirectory = Files.createTempDirectory("validator-test-tx-cache").toFile().getAbsolutePath();
      TxCacheResourceExtractor.extractTxCacheResources(txCacheDirectory);
    }

    return txCacheDirectory;
  }

  @Nonnull
  private static List<ModuleTestExecutor> getjUnit5TestExecutors(String[] moduleNamesArg) {
    final String[] moduleNames = moduleNamesArg == null ? JUNIT5_MODULE_NAMES : moduleNamesArg;
    return Arrays.stream(moduleNames)
      .map(moduleName -> JUnit5ModuleTestExecutor.getStandardModuleTestExecutor(moduleName))
      .collect(Collectors.toList());
  }

  @Nonnull
  private static List<ModuleTestExecutor> getjUnit4TestExecutors(String[] moduleNamesArg) {

    final List<ModuleTestExecutor> jUnit4TestExecutors = Arrays.asList(new JUnit4TestExecutor(VALIDATION_MODULE, JUNIT4_CLASSNAMES));

    if (moduleNamesArg == null) {
      return jUnit4TestExecutors;
    }

    return  Arrays.stream(moduleNamesArg).anyMatch(moduleName -> VALIDATION_MODULE.equals(moduleName))
      ? jUnit4TestExecutors
      : Arrays.asList();
  }
}
