package org.hl7.fhir.validation.testexecutor;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.hl7.fhir.utilities.tests.execution.CliTestSummary;
import org.hl7.fhir.utilities.tests.execution.ModuleTestExecutor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestExecutorTests {

  private static ModuleTestExecutor mockModuleTestExecutor(String moduleName) {
    ModuleTestExecutor moduleTestExecutor = mock(ModuleTestExecutor.class);
    doReturn(moduleName).when(moduleTestExecutor).getModuleName();
    CliTestSummary testSummary = mock(CliTestSummary.class);
    doReturn(testSummary).when(moduleTestExecutor).executeTests(any(), any());
    return moduleTestExecutor;
  }

  @Test
  public void testTestExecutor() {

    ModuleTestExecutor junit4TestExecutor = mockModuleTestExecutor("dummy.junit4");

    List<ModuleTestExecutor> junit4TestExecutors = Arrays.asList(
      junit4TestExecutor
    );

    ModuleTestExecutor junit5TestExecutor = mockModuleTestExecutor("dummy.junit5");

    List<ModuleTestExecutor> junit5TestExecutors = Arrays.asList(
      junit5TestExecutor
    );

    TestExecutor testExecutor = Mockito.spy(new TestExecutor(junit4TestExecutors, junit5TestExecutors));

    final String txCacheDirectoryPath = "dummyTxCacheDirectoryPath";

    final String testCasesDirectoryPath = System.getProperty("user.dir");

    doNothing().when(testExecutor).setUpDirectories(txCacheDirectoryPath, testCasesDirectoryPath);

    testExecutor.executeTests(null, txCacheDirectoryPath, testCasesDirectoryPath);

    verify(testExecutor).getJUnit4TestExecutors();

  }
}
