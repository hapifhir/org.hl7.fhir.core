package org.hl7.fhir.utilities.tests.execution.junit4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.hl7.fhir.utilities.tests.execution.CliTestSummary;
import org.hl7.fhir.utilities.tests.execution.ModuleTestExecutor;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import lombok.Getter;
import org.slf4j.Logger;

public class JUnit4TestExecutor extends ModuleTestExecutor {

  @Getter
  private final String moduleName;

  private final List<String> classNames;
  public JUnit4TestExecutor(String moduleName, List<String> classNames) {
    this.moduleName = moduleName + " (JUnit4)";
    this.classNames = Collections.unmodifiableList(new ArrayList<>(classNames));
  }

  private class JUnit4RunListener extends RunListener {

    Logger log;
    public JUnit4RunListener(Logger log) {
      this.log = log;
    }

    @Override
    public void testStarted(Description description) {
      ModuleTestExecutor.printTestStarted(log, description.getDisplayName());
    }

    @Override
    public void testFinished(Description description) {
      ModuleTestExecutor.printTestFinished(log, description.getDisplayName(),
        "FINISHED");
    }

    @Override
    public void testFailure(Failure failure) {
      ModuleTestExecutor.printTestFailed(log,

        failure.getDescription().getDisplayName(),
        failure.getException()
      );
    }
  }

  public CliTestSummary executeTests(Logger log, String classNameFilter) {

    JUnitCore junit = new JUnitCore();

    junit.addListener(new JUnit4RunListener(log));

    Pattern pattern = classNameFilter != null ? Pattern.compile(classNameFilter) : null;

    List<Class<?>> classes = classNames.stream()
      .filter(className -> pattern == null ? true : pattern.matcher(className).matches())
      .map(className -> {
        try {
          return Class.forName(className);
        } catch (ClassNotFoundException e) {
          throw new RuntimeException(e);
        }
      })
      .collect(Collectors.toList());

    Class<?>[] classArray = new Class[classes.size()];
    classes.toArray(classArray);

      org.junit.runner.Result result = junit.run(classArray);
      return new JUnit4TestSummaryAdapter(result);

  }

}
