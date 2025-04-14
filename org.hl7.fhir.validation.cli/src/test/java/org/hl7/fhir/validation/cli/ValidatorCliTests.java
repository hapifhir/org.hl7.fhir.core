package org.hl7.fhir.validation.cli;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.List;

import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.model.ValidationContext;
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
  PreloadCacheTask preloadCacheTask = new PreloadCacheTask() {
    @Override
    public void executeTask(ValidationContext validationContext, String[] args, TimeTracker tt, TimeTracker.Session tts) {}
  };

  @Spy
  TestsTask testsTask = new TestsTask() {
      @Override
      public void executeTask(ValidationContext validationContext, String[] args, TimeTracker tt, TimeTracker.Session tts) {}
  };

  @Spy
  TxTestsTask txTestsTask = new TxTestsTask() {
    @Override
    public void executeTask(ValidationContext validationContext, String[] args, TimeTracker tt, TimeTracker.Session tts) {}
  };
  

  AiTestsTask aiTestsTask = new AiTestsTask() {
    @Override
    public void executeTask(ValidationContext validationContext, String[] args, TimeTracker tt, TimeTracker.Session tts) {}
  };
  @Spy
  TransformTask transformTask;

  @Spy
  VersionTask versionTask;
  @Spy
  ValidateTask validateTask;

  @Spy
  CodeGenTask codeGenTask;

  @Spy
  RePackageTask txPackTask;

  @Spy
  InstanceFactoryTask instanceFactoryTask;

  @Spy
  ScanTask scanTask = new ScanTask() {
    @Override
    public void executeTask(ValidationService validationService, ValidationEngine validationEngine, ValidationContext validationContext, String[] args, TimeTracker tt, TimeTracker.Session tts) {}
  };
  @Spy
  SpecialTask specialTask = new SpecialTask() {
    @Override
    public void executeTask(ValidationContext validationContext, String[] args, TimeTracker tt, TimeTracker.Session tts) {}
  };

  public ValidatorCli mockValidatorCli() {
    ValidatorCli validatorCli = spy(new ValidatorCli(validationService){
      protected void validateScan(ValidationContext validationContext, ValidationEngine validator) {
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
          preloadCacheTask,
          scanTask,
          snapshotTask,
          specialTask,
          spreadsheetTask,
          testsTask,
          txTestsTask,
          aiTestsTask,
          transformTask,
          versionTask,
          codeGenTask,
          txPackTask,
          instanceFactoryTask,
          //validate is the default
          validateTask
        );
      }
    });
    return validatorCli;
  }
  public ValidatorCli mockValidatorCliWithService(ValidationContext validationContext) throws Exception {
    when(validationService.determineVersion(Mockito.same(validationContext))).thenReturn("5.0.1");
    when(validationService.initializeValidator(Mockito.same(validationContext), anyString(), any(org.hl7.fhir.utilities.TimeTracker.class))).thenReturn(validationEngine);
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
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    cli.readParamsAndExecuteTask(validationContext, args);
    Mockito.verify(validationService).determineVersion(same(validationContext));
    Mockito.verify(validationService).transform(same(validationContext), same(validationEngine));
  }

  @Test
  public void narrativeTest() throws Exception {
    final String[] args = new String[]{"-narrative"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    cli.readParamsAndExecuteTask(validationContext, args);
    Mockito.verify(validationService).determineVersion(same(validationContext));
    Mockito.verify(validationService).generateNarrative(same(validationContext), same(validationEngine));
  }

  @Test
  public void compileTest() throws Exception {
    final String[] args = new String[]{"-compile", "dummyMap.map"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    cli.readParamsAndExecuteTask(validationContext, args);
    Mockito.verify(validationService).determineVersion(same(validationContext));
    Mockito.verify(validationService).compile(same(validationContext), same(validationEngine));
  }

  @Test
  public void convertTest() throws Exception {
    final String[] args = new String[]{"-convert"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    cli.readParamsAndExecuteTask(validationContext, args);
    Mockito.verify(validationService).determineVersion(same(validationContext));
    Mockito.verify(validationService).convertSources(validationContext,validationEngine);
  }
  @Test
  public void snapshotTest() throws Exception {
    final String[] args = new String[]{"-snapshot"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    cli.readParamsAndExecuteTask(validationContext, args);
    Mockito.verify(validationService).determineVersion(same(validationContext));
    Mockito.verify(validationService).generateSnapshot(same(validationContext), same(validationEngine));
  }

  @Test
  public void installTest() throws Exception {
    final String[] args = new String[]{"-install"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    cli.readParamsAndExecuteTask(validationContext, args);
    Mockito.verify(validationService).determineVersion(same(validationContext));
    Mockito.verify(validationService).install(same(validationContext), same(validationEngine));
  }

  @Test
  public void spreadsheetTest() throws Exception {
    final String[] args = new String[]{"-spreadsheet"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    cli.readParamsAndExecuteTask(validationContext, args);
    Mockito.verify(validationService).determineVersion(same(validationContext));
    Mockito.verify(validationService).generateSpreadsheet(same(validationContext), same(validationEngine));
  }

  @Test
  public void fhirpathTest() throws Exception {
    final String[] args = new String[]{"-fhirpath", "dummyExpression"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    cli.readParamsAndExecuteTask(validationContext, args);
    Mockito.verify(validationService).determineVersion(same(validationContext));
    Mockito.verify(validationService).evaluateFhirpath(same(validationContext), same(validationEngine));
  }

  @Test
  public void versionTest() throws Exception {
    final String[] args = new String[]{"-to-version", "1.2.3"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    cli.readParamsAndExecuteTask(validationContext, args);
    Mockito.verify(validationService).determineVersion(same(validationContext));
    Mockito.verify(validationService).transformVersion(same(validationContext), same(validationEngine));
  }

  @Test
  public void langTransformTest() throws Exception {
    final String[] args = new String[]{"-lang-transform", "dummyLang"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    cli.readParamsAndExecuteTask(validationContext, args);
    Mockito.verify(validationService).determineVersion(same(validationContext));
    Mockito.verify(validationService).transformLang(same(validationContext), same(validationEngine));
  }

  @Test
  public void defaultTest() throws Exception {
    final String[] args = new String[]{"dummyFile.json"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    ValidatorWatchMode watchMode = ValidatorWatchMode.NONE;
    int watchScanDelay = 1000;
    int watchSettleTime = 100;
    cli.readParamsAndExecuteTask(validationContext, args);
    Mockito.verify(validationService).determineVersion(same(validationContext));
    Mockito.verify(validationService).validateSources(same(validationContext), same(validationEngine), eq(watchMode), eq(watchScanDelay), eq(watchSettleTime));
  }

  @Test
  public void scanTest() throws Exception {
    final String[] args = new String[]{"-scan"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    cli.readParamsAndExecuteTask(validationContext, args);
    Mockito.verify(validationService).determineVersion(same(validationContext));
    Mockito.verify(scanTask).executeTask(same(validationService), same(validationEngine), same(validationContext), eq(args), any(TimeTracker.class), any(TimeTracker.Session.class));
  }

  @Test
  public void specialTest() throws Exception {
    final String[] args = new String[]{"-special"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCli();
    cli.readParamsAndExecuteTask(validationContext, args);

    Mockito.verify(specialTask).executeTask(same(validationContext), eq(args), any(TimeTracker.class), any(TimeTracker.Session.class));
  }

  @Test
  public void compareTest() throws Exception {
    final String[] args = new String[]{"-compare"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    cli.readParamsAndExecuteTask(validationContext, args);
    Mockito.verify(validationService).determineVersion(same(validationContext));
    Mockito.verify(compareTask).executeTask(same(validationService), same(validationEngine), same(validationContext), eq(args), any(TimeTracker.class), any(TimeTracker.Session.class));
  }

  @Test
  public void preloadCacheTest() throws Exception {
    final String[] args = new String[]{"-preload-cache"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCli();
    cli.readParamsAndExecuteTask(validationContext, args);

    Mockito.verify(preloadCacheTask).executeTask(same(validationContext), eq(args), any(TimeTracker.class), any(TimeTracker.Session.class));
  }

  @Test
  public void txTestsTest() throws Exception {
    final String[] args = new String[]{"-txTests"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCli();
    cli.readParamsAndExecuteTask(validationContext, args);

    Mockito.verify(txTestsTask).executeTask(same(validationContext), eq(args), any(TimeTracker.class), any(TimeTracker.Session.class));
  }


  @Test
  public void testsTest() throws Exception {
    final String[] args = new String[]{"-tests"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCli();
    cli.readParamsAndExecuteTask(validationContext, args);

    Mockito.verify(testsTask).executeTask(same(validationContext), eq(args), any(TimeTracker.class), any(TimeTracker.Session.class));
  }
}
