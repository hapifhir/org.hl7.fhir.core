package org.hl7.fhir.validation.cli;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.*;

import java.util.List;

import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.ValidatorWatchMode;
import org.hl7.fhir.validation.cli.tasks.*;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.service.model.ValidationEngineSettings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.annotation.Nonnull;

@ExtendWith(MockitoExtension.class)
class ValidatorCliTests {

  @Mock
  ValidationService validationService;

  @Mock
  ValidationEngine validationEngine;

  @Spy
  ConvertTask convertTask;
  @Spy
  CompareTask compareTask;
  @Spy
  HTTPServerTask serverTask =  new HTTPServerTask() {
    @Override
    public void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine, @Nonnull ValidationContext validationContext, @Nonnull String[] args) throws Exception {
      // We're not testing the task itself, just how ValidatorCli decides to execute it
    }
  };

  @Spy
  CompileTask compileTask;

  @Spy
  FhirpathTask fhirpathTask;
  @Spy
  InstallTask installTask;

  @Spy
  LangTransformTask langTransformTask;

  @Spy
  LangRegenerateTask langRegenTask = new LangRegenerateTask(){
  @Override
  public void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine, @Nonnull ValidationContext validationContext, @Nonnull String[] args) throws Exception {
    // We're not testing the task itself, just how ValidatorCli decides to execute it
  }
  };

  @Spy
  NarrativeTask narrativeTask;

  @Spy
  SnapshotTask snapshotTask;
  @Spy
  SpreadsheetTask spreadsheetTask;

  @Spy
  PreloadCacheTask preloadCacheTask = new PreloadCacheTask() {
    @Override
    public void executeTask(@Nonnull ValidationContext validationContext, @Nonnull String[] args) {
      // We're not testing the task itself, just how ValidatorCli decides to execute it
    }
  };

  @Spy
  TestsTask testsTask = new TestsTask() {
      @Override
      public void executeTask(@Nonnull ValidationContext validationContext, @Nonnull String[] args) {
        // We're not testing the task itself, just how ValidatorCli decides to execute it
      }
  };

  @Spy
  TxTestsTask txTestsTask = new TxTestsTask() {
    @Override
    public void executeTask(@Nonnull ValidationContext validationContext, @Nonnull String[] args) {
      // We're not testing the task itself, just how ValidatorCli decides to execute it
    }
  };
  
@Spy
  AiTestsTask aiTestsTask = new AiTestsTask() {
    @Override
    public void executeTask(@Nonnull ValidationContext validationContext, @Nonnull String[] args) {
      // We're not testing the task itself, just how ValidatorCli decides to execute it
    }
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
  RePackageTask txPackTask = new RePackageTask() {
    @Override
    public void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine, @Nonnull ValidationContext validationContext, @Nonnull String[] args) {
      // We're not testing the task itself, just how ValidatorCli decides to execute it
    }
  };

  @Spy
  InstanceFactoryTask instanceFactoryTask;

  @Spy
  ScanTask scanTask = new ScanTask() {
    @Override
    public void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine, @Nonnull ValidationContext validationContext, @Nonnull String[] args) {
      // We're not testing the task itself, just how ValidatorCli decides to execute it
    }
  };
  @Spy
  SpecialTask specialTask = new SpecialTask() {
    @Override
    public void executeTask(@Nonnull ValidationContext validationContext, @Nonnull String[] args) {
      // We're not testing the task itself, just how ValidatorCli decides to execute it
    }
  };

  public ValidatorCli mockValidatorCli() {
    return spy(new ValidatorCli(validationService){
      private void validateScan(ValidationContext validationContext, ValidationEngine validator) {
        // DO NOTHING;
      }

      @Override
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
  }
  public ValidatorCli mockValidatorCliWithService(ValidationEngineSettings validationEngineSettings, ValidationContext validationContext) throws Exception {
    when(validationService.initializeValidator(Mockito.same(validationEngineSettings), Mockito.same(validationContext), any(org.hl7.fhir.utilities.TimeTracker.class))).thenReturn(validationEngine);
    return mockValidatorCli();
  }

  @Test
  void testCorrectTasksInValidatorCli() {
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
  void transformTest() throws Exception {
    final String[] args = new String[]{"-transform", "dummyFile.map", "dummySource.json"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);
    ValidatorCli cli = mockValidatorCliWithService(validationEngineSettings, validationContext);
    cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);
    Mockito.verify(validationService).transform(same(validationContext), same(validationEngine));
  }

  @Test
  void narrativeTest() throws Exception {
    final String[] args = new String[]{"-narrative"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);
    ValidatorCli cli = mockValidatorCliWithService(validationEngineSettings, validationContext);
    cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);
    Mockito.verify(validationService).generateNarrative(same(validationContext), same(validationEngine));
  }

  @Test
  void compileTest() throws Exception {
    final String[] args = new String[]{"-compile", "dummyMap.map"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);
    ValidatorCli cli = mockValidatorCliWithService(validationEngineSettings, validationContext);
    cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);
    Mockito.verify(validationService).compile(same(validationContext), same(validationEngine));
  }

  @Test
  void convertTest() throws Exception {
    final String[] args = new String[]{"-convert"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);
    ValidatorCli cli = mockValidatorCliWithService(validationEngineSettings, validationContext);
    cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);
    Mockito.verify(validationService).convertSources(validationContext,validationEngine);
  }
  @Test
  void snapshotTest() throws Exception {
    final String[] args = new String[]{"-snapshot"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);
    ValidatorCli cli = mockValidatorCliWithService(validationEngineSettings, validationContext);
    cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);
    Mockito.verify(validationService).generateSnapshot(same(validationContext), same(validationEngine));
  }

  @Test
  void installTest() throws Exception {
    final String[] args = new String[]{"-install"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);
    ValidatorCli cli = mockValidatorCliWithService(validationEngineSettings, validationContext);
    cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);
    Mockito.verify(validationService).install(same(validationContext.getIgs()), same(validationEngine));
  }

  @Test
  void spreadsheetTest() throws Exception {
    final String[] args = new String[]{"-spreadsheet"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);
    ValidatorCli cli = mockValidatorCliWithService(validationEngineSettings, validationContext);
    cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);
    Mockito.verify(validationService).generateSpreadsheet(same(validationContext), same(validationEngine));
  }

  @Test
  void fhirpathTest() throws Exception {
    final String[] args = new String[]{"-fhirpath", "dummyExpression"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);
    ValidatorCli cli = mockValidatorCliWithService(validationEngineSettings, validationContext);
    cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);
    Mockito.verify(validationService).evaluateFhirpath(same(validationContext), same(validationEngine));
  }

  @Test
  void versionTest() throws Exception {
    final String[] args = new String[]{"-to-version", "1.2.3"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);
    ValidatorCli cli = mockValidatorCliWithService(validationEngineSettings, validationContext);
    cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);
    Mockito.verify(validationService).transformVersion(same(validationContext), same(validationEngine));
  }

  @Test
  void langTransformTest() throws Exception {
    final String[] args = new String[]{"-lang-transform", "dummyLang"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);
    ValidatorCli cli = mockValidatorCliWithService(validationEngineSettings, validationContext);
    cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);
    Mockito.verify(validationService).transformLang(same(validationContext), same(validationEngine));
  }

  @Test
  void defaultTest() throws Exception {
    final String[] args = new String[]{"dummyFile.json"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);
    ValidatorCli cli = mockValidatorCliWithService(validationEngineSettings, validationContext);
    ValidatorWatchMode watchMode = ValidatorWatchMode.NONE;
    int watchScanDelay = 1000;
    int watchSettleTime = 100;
    cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);
    Mockito.verify(validationService).validateSources(same(validationContext), same(validationEngine), eq(watchMode), eq(watchScanDelay), eq(watchSettleTime));
  }

  @Test
  void scanTest() throws Exception {
    final String[] args = new String[]{"-scan"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);

    ValidatorCli cli = mockValidatorCliWithService(validationEngineSettings, validationContext);
    cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);
    Mockito.verify(scanTask).executeTask(same(validationService), same(validationEngine), same(validationContext), eq(args));
  }

  @Test
  void specialTest() throws Exception {
    final String[] args = new String[]{"-special"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);
    ValidatorCli cli = mockValidatorCli();
    cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);

    Mockito.verify(specialTask).executeTask(same(validationContext), eq(args));
  }

  @Test
  void compareTest() throws Exception {
    final String[] args = new String[]{"-compare"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);
    ValidatorCli cli = mockValidatorCliWithService(validationEngineSettings, validationContext);
    cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);
    Mockito.verify(compareTask).executeTask(same(validationService), same(validationEngine), same(validationContext), eq(args));
  }

  @Test
  void preloadCacheTest() throws Exception {
    final String[] args = new String[]{"-preload-cache"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);
    ValidatorCli cli = mockValidatorCli();
    cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);

    Mockito.verify(preloadCacheTask).executeTask(same(validationContext), eq(args));
  }

  @Test
  void txTestsTest() throws Exception {
    final String[] args = new String[]{"txTests"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);
    ValidatorCli cli = mockValidatorCli();
    cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);

    Mockito.verify(txTestsTask).executeTask(same(validationContext), eq(args));
  }

  @Test
  void aiTestsTest() throws Exception {
    final String[] args = new String[]{"-aiTests"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);
    ValidatorCli cli = mockValidatorCli();
    cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);

    Mockito.verify(aiTestsTask).executeTask(same(validationContext), eq(args));
  }

  @Test
  void codeGenTest() throws Exception{
    final String[] args = new String[]{"-codegen"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);

    ValidatorCli cli = mockValidatorCliWithService(validationEngineSettings, validationContext);
    cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);
    Mockito.verify(validationService).codeGen(same(validationContext), same(validationEngine));
  }

  @Test
  void inferredCodeGenTest() throws Exception{
    final String[] args = new String[]{"-package-name", "mypackage"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);

    ValidatorCli cli = mockValidatorCliWithService(validationEngineSettings, validationContext);
    cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);
    Mockito.verify(validationService).codeGen(same(validationContext), same(validationEngine));
  }

  @Test
  void rePackageTaskTest() throws Exception{
    final String[] args = new String[]{"-re-package", "-package-name", "mypackage"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);

    ValidatorCli cli = mockValidatorCliWithService(validationEngineSettings, validationContext);
    cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);
    Mockito.verify(txPackTask).executeTask(same(validationService), same(validationEngine), same(validationContext), eq(args));

    // Make sure -package-name doesn't cause codeGenTask execution
    Mockito.verify(validationService, never()).codeGen(same(validationContext), same(validationEngine));
  }

  @Test
  void txRepackageTaskTest() throws Exception {
    final String[] args = new String[]{"-tx-pack", "package-one,package-two"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);
    ValidatorCli cli = mockValidatorCliWithService(validationEngineSettings, validationContext);
    cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);
    Mockito.verify(txPackTask).executeTask(same(validationService), same(validationEngine), same(validationContext), eq(args));
  }

  @Test
  void langRegenTaskTest() throws Exception{
      final String[] args = new String[]{"-lang-regen", "arg1", "arg2", "arg3"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);
    ValidatorCli cli = mockValidatorCliWithService(validationEngineSettings, validationContext);
      cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);
      Mockito.verify(langRegenTask).executeTask(same(validationService), same(validationEngine), same(validationContext), eq(args));
  }

  @Test
  void serverTest() throws Exception{
    final String[] args = new String[]{"-server"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);
    ValidatorCli cli = mockValidatorCliWithService(validationEngineSettings, validationContext);
    cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);
    Mockito.verify(serverTask).executeTask(same(validationService), same(validationEngine), same(validationContext), eq(args));
  }

  @Test
  void instanceFactoryTaskTest() throws Exception{
    final String[] args = new String[]{"-factory", "arg1"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);

    ValidatorCli cli = mockValidatorCliWithService(validationEngineSettings, validationContext);
    cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);
    Mockito.verify(validationService).instanceFactory(validationContext,validationEngine);
  }

  @Test
  void testsTest() throws Exception {
    final String[] args = new String[]{"-tests"};
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();
    ValidationContext validationContext = Params.loadValidationContext(validationEngineSettings,args);
    ValidatorCli cli = mockValidatorCli();
    cli.readGlobalParamsAndExecuteTask(validationEngineSettings, validationContext, args);

    Mockito.verify(testsTask).executeTask(same(validationContext), eq(args));
  }
}
