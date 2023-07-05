package org.hl7.fhir.validation;

import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.hl7.fhir.validation.cli.services.ValidationService;
import org.hl7.fhir.validation.cli.services.ValidatorWatchMode;
import org.hl7.fhir.validation.cli.tasks.*;
import org.hl7.fhir.validation.cli.utils.Params;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ValidatorCliTests {

  @Mock
  ValidationService validationService;

  @Mock
  ValidationEngine validationEngine;

  @Spy
  ConvertTask convertTask;
  @Spy
  CompareTask compareTask;

  @Spy
  CompileTask compileTask;

  @Spy
  FhirpathTask fhirpathTask;
  @Spy
  InstallTask installTask;

  @Spy
  LangTransformTask langTransformTask;

  @Spy
  NarrativeTask narrativeTask;

  @Spy
  SnapshotTask snapshotTask;
  @Spy
  SpreadsheetTask spreadsheetTask;

  @Spy
  TestsTask testsTask = new TestsTask() {
      @Override
      public void executeTask(CliContext cliContext, String[] args, TimeTracker tt, TimeTracker.Session tts) {}
  };

  @Spy
  TxTestsTask txTestsTask = new TxTestsTask() {
    @Override
    public void executeTask(CliContext cliContext, String[] args, TimeTracker tt, TimeTracker.Session tts) {}
  };
  @Spy
  TransformTask transformTask;

  @Spy
  VersionTask versionTask;
  @Spy
  ValidateTask validateTask;

  @Spy
  ScanTask scanTask = new ScanTask() {
    @Override
    public void executeTask(ValidationService validationService, ValidationEngine validationEngine, CliContext cliContext, String[] args, TimeTracker tt, TimeTracker.Session tts) {}
  };
  @Spy
  SpecialTask specialTask = new SpecialTask() {
    @Override
    public void executeTask(CliContext cliContext, String[] args, TimeTracker tt, TimeTracker.Session tts) {}
  };

  public ValidatorCli mockValidatorCli() {
    ValidatorCli validatorCli = spy(new ValidatorCli(validationService){
      protected void validateScan(CliContext cliContext, ValidationEngine validator) {
        // DO NOTHING;
      }

      protected List<CliTask> getCliTasks() {
        return List.of(
          compareTask,
          compileTask,
          convertTask,
          fhirpathTask,
          installTask,
          langTransformTask,
          narrativeTask,
          scanTask,
          snapshotTask,
          specialTask,
          spreadsheetTask,
          testsTask,
          txTestsTask,
          transformTask,
          versionTask,
          //validate is the default
          validateTask
        );
      }
    });
    return validatorCli;
  }
  public ValidatorCli mockValidatorCliWithService(CliContext cliContext) throws Exception {
    when(validationService.determineVersion(Mockito.same(cliContext))).thenReturn("5.0.1");
    when(validationService.initializeValidator(Mockito.same(cliContext), anyString(), any(org.hl7.fhir.utilities.TimeTracker.class))).thenReturn(validationEngine);
    return mockValidatorCli();
  }

  @Test
  public void testCorrectTasksInValidatorCli() {
    ValidatorCli realCli = new ValidatorCli(mock(ValidationService.class));
    ValidatorCli mockCli = mockValidatorCli();

    List<CliTask> realTasks = realCli.getCliTasks();
    List<CliTask> mockTasks = mockCli.getCliTasks();
    assertEquals(mockTasks.size(), realTasks.size());
    for (int i = 0; i < realTasks.size(); i++) {
      assertEquals(mockTasks.get(i).getName(), realTasks.get(i).getName(), "Differing task at index " + i);
    }
  }

  private void assertContainsValidationTask(List<CliTask> tasks, String name) {
    for (CliTask task : tasks) {
      if (task.getName().equals(name)) {
        return;
      }
    }
    fail("Cannot find " + name + " in task list");
  }

  @Test
  public void transformTest() throws Exception {
    final String[] args = new String[]{"-transform", "dummyFile.map", "dummySource.json"};
    CliContext cliContext = Params.loadCliContext(args);
    ValidatorCli cli = mockValidatorCliWithService(cliContext);
    cli.readParamsAndExecuteTask(cliContext, args);
    Mockito.verify(validationService).determineVersion(same(cliContext));
    Mockito.verify(validationService).transform(same(cliContext), same(validationEngine));
  }

  @Test
  public void narrativeTest() throws Exception {
    final String[] args = new String[]{"-narrative"};
    CliContext cliContext = Params.loadCliContext(args);
    ValidatorCli cli = mockValidatorCliWithService(cliContext);
    cli.readParamsAndExecuteTask(cliContext, args);
    Mockito.verify(validationService).determineVersion(same(cliContext));
    Mockito.verify(validationService).generateNarrative(same(cliContext), same(validationEngine));
  }

  @Test
  public void compileTest() throws Exception {
    final String[] args = new String[]{"-compile", "dummyMap.map"};
    CliContext cliContext = Params.loadCliContext(args);
    ValidatorCli cli = mockValidatorCliWithService(cliContext);
    cli.readParamsAndExecuteTask(cliContext, args);
    Mockito.verify(validationService).determineVersion(same(cliContext));
    Mockito.verify(validationService).compile(same(cliContext), same(validationEngine));
  }

  @Test
  public void convertTest() throws Exception {
    final String[] args = new String[]{"-convert"};
    CliContext cliContext = Params.loadCliContext(args);
    ValidatorCli cli = mockValidatorCliWithService(cliContext);
    cli.readParamsAndExecuteTask(cliContext, args);
    Mockito.verify(validationService).determineVersion(same(cliContext));
    Mockito.verify(validationService).convertSources(cliContext,validationEngine);
  }
  @Test
  public void snapshotTest() throws Exception {
    final String[] args = new String[]{"-snapshot"};
    CliContext cliContext = Params.loadCliContext(args);
    ValidatorCli cli = mockValidatorCliWithService(cliContext);
    cli.readParamsAndExecuteTask(cliContext, args);
    Mockito.verify(validationService).determineVersion(same(cliContext));
    Mockito.verify(validationService).generateSnapshot(same(cliContext), same(validationEngine));
  }

  @Test
  public void installTest() throws Exception {
    final String[] args = new String[]{"-install"};
    CliContext cliContext = Params.loadCliContext(args);
    ValidatorCli cli = mockValidatorCliWithService(cliContext);
    cli.readParamsAndExecuteTask(cliContext, args);
    Mockito.verify(validationService).determineVersion(same(cliContext));
    Mockito.verify(validationService).install(same(cliContext), same(validationEngine));
  }

  @Test
  public void spreadsheetTest() throws Exception {
    final String[] args = new String[]{"-spreadsheet"};
    CliContext cliContext = Params.loadCliContext(args);
    ValidatorCli cli = mockValidatorCliWithService(cliContext);
    cli.readParamsAndExecuteTask(cliContext, args);
    Mockito.verify(validationService).determineVersion(same(cliContext));
    Mockito.verify(validationService).generateSpreadsheet(same(cliContext), same(validationEngine));
  }

  @Test
  public void fhirpathTest() throws Exception {
    final String[] args = new String[]{"-fhirpath", "dummyExpression"};
    CliContext cliContext = Params.loadCliContext(args);
    ValidatorCli cli = mockValidatorCliWithService(cliContext);
    cli.readParamsAndExecuteTask(cliContext, args);
    Mockito.verify(validationService).determineVersion(same(cliContext));
    Mockito.verify(validationService).evaluateFhirpath(same(cliContext), same(validationEngine));
  }

  @Test
  public void versionTest() throws Exception {
    final String[] args = new String[]{"-to-version", "1.2.3"};
    CliContext cliContext = Params.loadCliContext(args);
    ValidatorCli cli = mockValidatorCliWithService(cliContext);
    cli.readParamsAndExecuteTask(cliContext, args);
    Mockito.verify(validationService).determineVersion(same(cliContext));
    Mockito.verify(validationService).transformVersion(same(cliContext), same(validationEngine));
  }

  @Test
  public void langTransformTest() throws Exception {
    final String[] args = new String[]{"-lang-transform", "dummyLang"};
    CliContext cliContext = Params.loadCliContext(args);
    ValidatorCli cli = mockValidatorCliWithService(cliContext);
    cli.readParamsAndExecuteTask(cliContext, args);
    Mockito.verify(validationService).determineVersion(same(cliContext));
    Mockito.verify(validationService).transformLang(same(cliContext), same(validationEngine));
  }

  @Test
  public void defaultTest() throws Exception {
    final String[] args = new String[]{"dummyFile.json"};
    CliContext cliContext = Params.loadCliContext(args);
    ValidatorCli cli = mockValidatorCliWithService(cliContext);
    ValidatorWatchMode watchMode = ValidatorWatchMode.NONE;
    int watchScanDelay = 1000;
    int watchSettleTime = 100;
    cli.readParamsAndExecuteTask(cliContext, args);
    Mockito.verify(validationService).determineVersion(same(cliContext));
    Mockito.verify(validationService).validateSources(same(cliContext), same(validationEngine), eq(watchMode), eq(watchScanDelay), eq(watchSettleTime));
  }

  @Test
  public void scanTest() throws Exception {
    final String[] args = new String[]{"-scan"};
    CliContext cliContext = Params.loadCliContext(args);
    ValidatorCli cli = mockValidatorCliWithService(cliContext);
    cli.readParamsAndExecuteTask(cliContext, args);
    Mockito.verify(validationService).determineVersion(same(cliContext));
    Mockito.verify(scanTask).executeTask(same(validationService), same(validationEngine), same(cliContext), eq(args), any(TimeTracker.class), any(TimeTracker.Session.class));
  }

  @Test
  public void specialTest() throws Exception {
    final String[] args = new String[]{"-special"};
    CliContext cliContext = Params.loadCliContext(args);
    ValidatorCli cli = mockValidatorCli();
    cli.readParamsAndExecuteTask(cliContext, args);

    Mockito.verify(specialTask).executeTask(same(cliContext), eq(args), any(TimeTracker.class), any(TimeTracker.Session.class));
  }

  @Test
  public void compareTest() throws Exception {
    final String[] args = new String[]{"-compare"};
    CliContext cliContext = Params.loadCliContext(args);
    ValidatorCli cli = mockValidatorCliWithService(cliContext);
    cli.readParamsAndExecuteTask(cliContext, args);
    Mockito.verify(validationService).determineVersion(same(cliContext));
    Mockito.verify(compareTask).executeTask(same(validationService), same(validationEngine), same(cliContext), eq(args), any(TimeTracker.class), any(TimeTracker.Session.class));
  }

  @Test
  public void txTestsTest() throws Exception {
    final String[] args = new String[]{"-txTests"};
    CliContext cliContext = Params.loadCliContext(args);
    ValidatorCli cli = mockValidatorCli();
    cli.readParamsAndExecuteTask(cliContext, args);

    Mockito.verify(txTestsTask).executeTask(same(cliContext), eq(args), any(TimeTracker.class), any(TimeTracker.Session.class));
  }

  @Test
  public void testsTest() throws Exception {
    final String[] args = new String[]{"-tests"};
    CliContext cliContext = Params.loadCliContext(args);
    ValidatorCli cli = mockValidatorCli();
    cli.readParamsAndExecuteTask(cliContext, args);

    Mockito.verify(testsTask).executeTask(same(cliContext), eq(args), any(TimeTracker.class), any(TimeTracker.Session.class));
  }
}
