package org.hl7.fhir.utilities.tests;



import org.junit.internal.TextListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.junit.runner.JUnitCore;

import java.io.PrintStream;

public class JUnit4TestExecutor {
  public void executeTests(PrintStream out, String classNameFilter) {
    JUnitCore junit = new JUnitCore();
    junit.addListener(new TextListener(System.out));
    try {
      Class<?> jUnit4Class = Class.forName("org.hl7.fhir.validation.tests.ValidationTests");
      junit.run(jUnit4Class);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

}
