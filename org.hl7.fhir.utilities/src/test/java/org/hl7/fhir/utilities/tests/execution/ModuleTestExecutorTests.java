package org.hl7.fhir.utilities.tests.execution;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.hl7.fhir.utilities.tests.execution.junit4.JUnit4TestExecutor;
import org.hl7.fhir.utilities.tests.execution.junit5.JUnit5ModuleTestExecutor;
import org.junit.jupiter.api.Test;

public class ModuleTestExecutorTests {

  @Test
  public void testJUnit4ModuleTestExecutor() {
    ModuleTestExecutor junit4ModuleTestExecutor = new JUnit4TestExecutor("org.hl7.fhir.utilities", Arrays.asList("org.hl7.fhir.utilities.tests.execution.DummyJUnit4Test"));

    assertEquals("org.hl7.fhir.utilities (JUnit4)", junit4ModuleTestExecutor.getModuleName());

    CliTestSummary cliTestSummary = junit4ModuleTestExecutor.executeTests(System.out, null);

    assertEquals(1, cliTestSummary.getTestsFoundCount());
    assertEquals(0, cliTestSummary.getExceptions().size());
    assertEquals(0, cliTestSummary.getTestsFailedCount());
    assertEquals(0, cliTestSummary.getTestsAbortedCount());
    assertEquals(0, cliTestSummary.getTestsSkippedCount());

  }

  @Test
  public void testJUnit5ModuleTestExecutor() {
    ModuleTestExecutor junit5ModuleTestExecutor = new JUnit5ModuleTestExecutor("org.hl7.fhir.utilities", Arrays.asList("org.hl7.fhir.utilities.tests.execution"));

    assertEquals("org.hl7.fhir.utilities", junit5ModuleTestExecutor.getModuleName());

    CliTestSummary cliTestSummary = junit5ModuleTestExecutor.executeTests(System.out, ".*DummyJUnit5Test");

    assertEquals(1, cliTestSummary.getTestsFoundCount());
    assertEquals(0, cliTestSummary.getExceptions().size());
    assertEquals(0, cliTestSummary.getTestsFailedCount());
    assertEquals(0, cliTestSummary.getTestsAbortedCount());
    assertEquals(0, cliTestSummary.getTestsSkippedCount());

  }
}
