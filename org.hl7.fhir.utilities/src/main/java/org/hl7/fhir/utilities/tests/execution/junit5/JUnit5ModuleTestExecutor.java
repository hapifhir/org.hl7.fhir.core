package org.hl7.fhir.utilities.tests.execution.junit5;

import lombok.Getter;
import lombok.Setter;
import org.hl7.fhir.utilities.tests.execution.CliTestSummary;
import org.hl7.fhir.utilities.tests.execution.ModuleTestExecutor;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.*;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

/**
 * This class allows JUnit 5 tests to be run in Java runtime.
 *
 * JUnit 4 tests ARE NOT SUPPORTED.
 *
 * This mimics for the most part the output of the Maven Surefire plugin, with
 * additional summaries and unique IDs for diagnosing failing tests.
 */
public class JUnit5ModuleTestExecutor extends ModuleTestExecutor {



  private static final String SUMMARY_TEMPLATE = "Tests run: %d, Failures: %d, Errors: %d, Skipped: %d";

  private static final String MODULE_FINISHED_TEMPLATE = "%s module tests finished.";
  public static final String DEFAULT_CLASSNAME_FILTER = org.junit.platform.engine.discovery.ClassNameFilter.STANDARD_INCLUDE_PATTERN;


  @Getter
  private final String moduleName;

  @Getter
  private final List<String> packageNames;

  public JUnit5ModuleTestExecutor(String moduleName, List<String> packageNames) {
    this.moduleName = moduleName;
    this.packageNames = Collections.unmodifiableList(packageNames);
  }

  private List<org.junit.platform.engine.discovery.PackageSelector> getPackageSelectors() {
    final List<String> packageNames = getPackageNames();
    return packageNames.stream().map(it -> selectPackage(it)).collect(Collectors.toList());
  }

  class ModuleTestExecutionListener extends SummaryGeneratingListener {

    @Setter
    private PrintStream out;

    @Override
    public void executionStarted(TestIdentifier testIdentifier) {
      ModuleTestExecutor.printTestStarted(out, testIdentifier.getDisplayName());
      super.executionStarted(testIdentifier);
    }

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
      //
      if (testExecutionResult.getStatus().equals(TestExecutionResult.Status.FAILED)) {
        ModuleTestExecutor.printTestFailed(out, testIdentifier.getUniqueId(),  testExecutionResult.getThrowable().isPresent()
          ? testExecutionResult.getThrowable().get()
          :null);
      }
      ModuleTestExecutor.printTestFinished(out,
        testIdentifier.getDisplayName(),
        testExecutionResult.getStatus().name()
      );
      super.executionFinished(testIdentifier, testExecutionResult);
    }
  }

  /**
   * Execute all tests defined in this module and return a TestExecutionSummary.
   *
   * Any stack traces required to diagnose test failures will be output at this
   * stage, along with a unique test ID.
   *
   * @param out the PrintStream to log execution or test failure.
   * @param classNameFilter a Regex to use to select tests. If null, this will
   *                        default to the JUnit console filter.
   * @return The test execution summary.
   *
   * @see org.junit.platform.engine.discovery.ClassNameFilter
   */
  public CliTestSummary executeTests(PrintStream out, String classNameFilter) {
    LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
      .selectors(
        getPackageSelectors()
      )
      .filters(
        includeClassNamePatterns(classNameFilter == null ? DEFAULT_CLASSNAME_FILTER : classNameFilter)
      )
      .build();

    ModuleTestExecutionListener moduleTestExecutionlistener = new ModuleTestExecutionListener();
    moduleTestExecutionlistener.setOut(out);

    try (LauncherSession session = LauncherFactory.openSession()) {
      Launcher launcher = session.getLauncher();

      launcher.registerTestExecutionListeners(moduleTestExecutionlistener);

      TestPlan testPlan = launcher.discover(request);
      // Execute test plan
      launcher.execute(testPlan);
      // Alternatively, execute the request directly
      // launcher.execute(request);
    }

    TestExecutionSummary summary = moduleTestExecutionlistener.getSummary();

    out.println("\n" + String.format(MODULE_FINISHED_TEMPLATE, getModuleName()));
    out.println(String.format(SUMMARY_TEMPLATE, summary.getTestsFoundCount(), summary.getTestsFailedCount(), summary.getTestsAbortedCount(), summary.getTestsSkippedCount()));

    return new JUnit5TestSummaryAdapter(summary);
  }



  /**
   * Create a ModuleTestExecutor for the standard case where the module name
   * maps to the package name of the root package containing tests.
   *
   * For example the module "org.hl7.fhir.r5" will be assumed to have all its
   * tests in the "org.hl7.fhir.r5" package or its child packages.
   *
   * @param moduleName The name of the module and root package containing tests.
   * @return the ModuleTestExecutor for the module
   */
  public static JUnit5ModuleTestExecutor getStandardModuleTestExecutor(String moduleName) {
    return  new JUnit5ModuleTestExecutor(moduleName, Arrays.asList(moduleName));
  }
}
