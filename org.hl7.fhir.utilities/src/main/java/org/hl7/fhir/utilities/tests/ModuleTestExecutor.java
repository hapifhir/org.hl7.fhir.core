package org.hl7.fhir.utilities.tests;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.*;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

public abstract class ModuleTestExecutor {

  private static final String STARTING_TEST_TEMPLATE = "Starting: %s";
  private static final String FINISHED_TEST_TEMPLATE = "Finished: %s with result: %s";

  private static final String FAILED_TEST_TEMPLATE = "Failed Test ID: %s";
  private static final String SUMMARY_TEMPLATE = "Tests run: %d, Failures: %d, Errors: %d, Skipped: %d";

  public static final String DEFAULT_CLASSNAME_FILTER = ".*Tests";

  public abstract String getModuleName();
  protected abstract List<String> getPackages();

  private List<org.junit.platform.engine.discovery.PackageSelector> getPackageSelectors() {
    final List<String> packageNames = getPackages();
    return packageNames.stream().map(it -> selectPackage(it)).collect(Collectors.toList());
  }

  class ModuleTestExecutionListener extends SummaryGeneratingListener {

    @Override
    public void executionStarted(TestIdentifier testIdentifier) {
      System.out.println(String.format(STARTING_TEST_TEMPLATE, testIdentifier.getDisplayName()));
      super.executionStarted(testIdentifier);
    }
    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
      System.out.println(String.format(FINISHED_TEST_TEMPLATE, testIdentifier.getDisplayName(), testExecutionResult.getStatus()));
      if (testExecutionResult.getStatus().equals(TestExecutionResult.Status.FAILED)) {
        System.out.println(String.format(FAILED_TEST_TEMPLATE, testIdentifier.getUniqueId()));
        if (testExecutionResult.getThrowable().isPresent()) {
          final Throwable throwable = testExecutionResult.getThrowable().get();
          if (throwable != null) {
            throwable.printStackTrace(System.out);
          }
        }
      }
      System.out.println(String.format(FINISHED_TEST_TEMPLATE, testIdentifier.getDisplayName(), testExecutionResult.getStatus()));
      super.executionFinished(testIdentifier, testExecutionResult);
    }
  }
  public TestExecutionSummary executeTests(String classNameFilter) {
    LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
      .selectors(
        getPackageSelectors()
      )
      .filters(
        includeClassNamePatterns(classNameFilter == null ? DEFAULT_CLASSNAME_FILTER : classNameFilter)
      )
      .build();

    ModuleTestExecutionListener moduleTestExecutionlistener = new ModuleTestExecutionListener();

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

    System.out.println("\n\nTests module completed.");
    System.out.println(String.format(SUMMARY_TEMPLATE, summary.getTestsFoundCount(), summary.getTestsFailedCount(), summary.getTestsAbortedCount(), summary.getTestsSkippedCount()));

    System.out.println("\n\nTest failures: ");
    for (TestExecutionSummary.Failure failure : summary.getFailures()) {
      System.out.println("\t" + failure.getTestIdentifier().getUniqueId() + ": " + failure.getException().getMessage());
    }

    return summary;
  }
}
