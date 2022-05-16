package org.hl7.fhir.utilities.tests;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.LauncherSession;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

public abstract class PackageTestExecutor {

  protected abstract List<String> getPackages();

  private List<org.junit.platform.engine.discovery.PackageSelector> getPackageSelectors() {
    final List<String> packageNames = getPackages();
    return packageNames.stream().map(it -> selectPackage(it)).collect(Collectors.toList());
  }

  public void executeTests() {
    LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
      .selectors(
        //selectPackage("org.hl7.fhir.utilities")
        getPackageSelectors()
      )
      .filters(
        includeClassNamePatterns(".*Tests")
      )
      .build();

    SummaryGeneratingListener listener = new SummaryGeneratingListener();

    try (LauncherSession session = LauncherFactory.openSession()) {
      Launcher launcher = session.getLauncher();
      // Register a listener of your choice
      launcher.registerTestExecutionListeners(listener);
      // Discover tests and build a test plan
      TestPlan testPlan = launcher.discover(request);
      // Execute test plan
      launcher.execute(testPlan);
      // Alternatively, execute the request directly
     // launcher.execute(request);
    }

    TestExecutionSummary summary = listener.getSummary();
    System.out.println("Tests failed: " + summary.getTestsFailedCount());
    System.out.println("Tests run   : " + summary.getTestsFoundCount());

  }
}
