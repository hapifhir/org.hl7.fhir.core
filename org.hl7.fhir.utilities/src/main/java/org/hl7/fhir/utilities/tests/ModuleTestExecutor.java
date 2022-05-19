package org.hl7.fhir.utilities.tests;

import lombok.Getter;
import lombok.Setter;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.*;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

public class ModuleTestExecutor {

  private static final String STARTING_TEST_TEMPLATE = "Starting: %s";
  private static final String FINISHED_TEST_TEMPLATE = "Finished: %s with result: %s";
  private static final String FAILED_TEST_TEMPLATE = "Failed Test ID: %s";

  private static final String FAILURE_SUMMARY_TEMPLATE = "Test failures for module %s (%d):";
  private static final String SUMMARY_TEMPLATE = "Tests run: %d, Failures: %d, Errors: %d, Skipped: %d";

  private static final String MODULE_FINISHED_TEMPLATE = "%s module tests finished.";
  public static final String DEFAULT_CLASSNAME_FILTER = org.junit.platform.engine.discovery.ClassNameFilter.STANDARD_INCLUDE_PATTERN;


  @Getter
  private final String moduleName;

  @Getter
  private final List<String> packageNames;

  public ModuleTestExecutor(String moduleName, List<String> packageNames) {
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
      out.println(String.format(STARTING_TEST_TEMPLATE, testIdentifier.getDisplayName()));
      super.executionStarted(testIdentifier);
    }

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
      if (testExecutionResult.getStatus().equals(TestExecutionResult.Status.FAILED)) {
        out.println(String.format(FAILED_TEST_TEMPLATE, testIdentifier.getUniqueId()));
        if (testExecutionResult.getThrowable().isPresent()) {
          final Throwable throwable = testExecutionResult.getThrowable().get();
          if (throwable != null) {
            throwable.printStackTrace(System.out);
          }
        }
      }
      out.println(String.format(FINISHED_TEST_TEMPLATE, testIdentifier.getDisplayName(), testExecutionResult.getStatus()));
      super.executionFinished(testIdentifier, testExecutionResult);
    }
  }

  public TestExecutionSummary executeTests(PrintStream out, String classNameFilter) {
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

    return summary;
  }

  public static void printSummmary(PrintStream out, TestExecutionSummary testExecutionSummary, String moduleName) {
    if (testExecutionSummary.getTotalFailureCount() > 0) {
      out.println("\n" + String.format(FAILURE_SUMMARY_TEMPLATE, moduleName, testExecutionSummary.getTotalFailureCount()));
      for (TestExecutionSummary.Failure failure : testExecutionSummary.getFailures()) {
        out.println("\t" + failure.getTestIdentifier().getUniqueId() + ": " + failure.getException().getMessage());
      }
      out.println();
    }
  }

}
