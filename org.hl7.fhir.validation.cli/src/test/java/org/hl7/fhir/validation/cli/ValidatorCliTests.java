package org.hl7.fhir.validation.cli;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.List;

import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.ValidatorWatchMode;
import org.hl7.fhir.validation.cli.tasks.*;
import org.hl7.fhir.validation.cli.param.Params;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.annotation.Nonnull;

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
  HTTPServerTask serverTask;

  @Spy
  CompileTask compileTask;

  @Spy
  FhirpathTask fhirpathTask;
  @Spy
  InstallTask installTask;

  @Spy
  LangTransformTask langTransformTask;

  @Spy
  LangRegenerateTask langRegenTask;

  @Spy
  NarrativeTask narrativeTask;

  @Spy
  SnapshotTask snapshotTask;
  @Spy
  SpreadsheetTask spreadsheetTask;

  @Spy
  PreloadCacheTask preloadCacheTask = new PreloadCacheTask() {
    @Override
    public void executeTask(@Nonnull ValidationContext validationContext, @Nonnull String[] args) {}
  };

  @Spy
  TestsTask testsTask = new TestsTask() {
      @Override
      public void executeTask(@Nonnull ValidationContext validationContext, @Nonnull String[] args) {}
  };

  @Spy
  TxTestsTask txTestsTask = new TxTestsTask() {
    @Override
    public void executeTask(@Nonnull ValidationContext validationContext, @Nonnull String[] args) {}
  };
  

  AiTestsTask aiTestsTask = new AiTestsTask() {
    @Override
    public void executeTask(@Nonnull ValidationContext validationContext, @Nonnull String[] args) {}
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
    public void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine, @Nonnull ValidationContext validationContext, @Nonnull String[] args) {}
  };
  @Spy
  SpecialTask specialTask = new SpecialTask() {
    @Override
    public void executeTask(@Nonnull ValidationContext validationContext, @Nonnull String[] args) {}
  };

  public ValidatorCli mockValidatorCli() {
    ValidatorCli validatorCli = spy(new ValidatorCli(validationService){
      private void validateScan(ValidationContext validationContext, ValidationEngine validator) {
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
          langRegenTask,
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
          serverTask,
          //validate is the default
          validateTask
        );
      }
    });
    return validatorCli;
  }
  public ValidatorCli mockValidatorCliWithService(ValidationContext validationContext) throws Exception {
    when(validationService.getValidationEngineFromValidationContext(Mockito.same(validationContext), any(org.hl7.fhir.utilities.TimeTracker.class))).thenReturn(validationEngine);
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


  @Test
  public void transformTest() throws Exception {
    final String[] args = new String[]{"-transform", "dummyFile.map", "dummySource.json"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    cli.readGlobalParamsAndExecuteTask(validationContext, args);
    Mockito.verify(validationService).transform(same(validationContext), same(validationEngine));
  }

  @Test
  public void narrativeTest() throws Exception {
    final String[] args = new String[]{"-narrative"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    cli.readGlobalParamsAndExecuteTask(validationContext, args);
    Mockito.verify(validationService).generateNarrative(same(validationContext), same(validationEngine));
  }

  @Test
  public void compileTest() throws Exception {
    final String[] args = new String[]{"-compile", "dummyMap.map"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    cli.readGlobalParamsAndExecuteTask(validationContext, args);
    Mockito.verify(validationService).compile(same(validationContext), same(validationEngine));
  }

  @Test
  public void convertTest() throws Exception {
    final String[] args = new String[]{"-convert"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    cli.readGlobalParamsAndExecuteTask(validationContext, args);
    Mockito.verify(validationService).convertSources(validationContext,validationEngine);
  }
  @Test
  public void snapshotTest() throws Exception {
    final String[] args = new String[]{"-snapshot"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    cli.readGlobalParamsAndExecuteTask(validationContext, args);
    Mockito.verify(validationService).generateSnapshot(same(validationContext), same(validationEngine));
  }

  @Test
  public void installTest() throws Exception {
    final String[] args = new String[]{"-install"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    cli.readGlobalParamsAndExecuteTask(validationContext, args);
    Mockito.verify(validationService).install(same(validationContext), same(validationEngine));
  }

  @Test
  public void spreadsheetTest() throws Exception {
    final String[] args = new String[]{"-spreadsheet"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    cli.readGlobalParamsAndExecuteTask(validationContext, args);
    Mockito.verify(validationService).generateSpreadsheet(same(validationContext), same(validationEngine));
  }

  @Test
  public void fhirpathTest() throws Exception {
    final String[] args = new String[]{"-fhirpath", "dummyExpression"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    cli.readGlobalParamsAndExecuteTask(validationContext, args);
    Mockito.verify(validationService).evaluateFhirpath(same(validationContext), same(validationEngine));
  }

  @Test
  public void versionTest() throws Exception {
    final String[] args = new String[]{"-to-version", "1.2.3"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    cli.readGlobalParamsAndExecuteTask(validationContext, args);
    Mockito.verify(validationService).transformVersion(same(validationContext), same(validationEngine));
  }

  @Test
  public void langTransformTest() throws Exception {
    final String[] args = new String[]{"-lang-transform", "dummyLang"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    cli.readGlobalParamsAndExecuteTask(validationContext, args);
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
    cli.readGlobalParamsAndExecuteTask(validationContext, args);
    Mockito.verify(validationService).validateSources(same(validationContext), same(validationEngine), eq(watchMode), eq(watchScanDelay), eq(watchSettleTime));
  }

  @Test
  public void scanTest() throws Exception {
    final String[] args = new String[]{"-scan"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    cli.readGlobalParamsAndExecuteTask(validationContext, args);
    Mockito.verify(scanTask).executeTask(same(validationService), same(validationEngine), same(validationContext), eq(args));
  }

  @Test
  public void specialTest() throws Exception {
    final String[] args = new String[]{"-special"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCli();
    cli.readGlobalParamsAndExecuteTask(validationContext, args);
    Mockito.verify(specialTask).executeTask(same(validationContext), eq(args));
  }

  @Test
  public void compareTest() throws Exception {
    final String[] args = new String[]{"-compare"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCliWithService(validationContext);
    cli.readGlobalParamsAndExecuteTask(validationContext, args);
    Mockito.verify(compareTask).executeTask(same(validationService), same(validationEngine), same(validationContext), eq(args));
  }

  @Test
  public void preloadCacheTest() throws Exception {
    final String[] args = new String[]{"-preload-cache"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCli();
    cli.readGlobalParamsAndExecuteTask(validationContext, args);
    Mockito.verify(preloadCacheTask).executeTask(same(validationContext), eq(args));
  }

  @Test
  public void txTestsTest() throws Exception {
    final String[] args = new String[]{"txTests"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCli();
    cli.readGlobalParamsAndExecuteTask(validationContext, args);
    Mockito.verify(txTestsTask).executeTask(same(validationContext), eq(args));
  }


  @Test
  public void testsTest() throws Exception {
    final String[] args = new String[]{"-tests"};
    ValidationContext validationContext = Params.loadValidationContext(args);
    ValidatorCli cli = mockValidatorCli();
    cli.readGlobalParamsAndExecuteTask(validationContext, args);
    Mockito.verify(testsTask).executeTask(same(validationContext), eq(args));
  }
}
