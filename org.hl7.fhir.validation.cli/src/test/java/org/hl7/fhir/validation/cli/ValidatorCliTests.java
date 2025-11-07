package org.hl7.fhir.validation.cli;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.*;

import java.io.File;
import java.nio.file.Files;
import java.util.*;

import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.ValidateSourceParameters;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.cli.tasks.*;
import org.hl7.fhir.validation.service.model.ValidationEngineParameters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.annotation.Nonnull;

@ExtendWith(MockitoExtension.class)
class ValidatorCliTests {

  /**
   * This is called to avoid actual execution of some long running tasks that slow down these tests.
   *
   * @param usesInstanceValidatorParameters if the task parses and uses instanceValidatorParameters
   * @throws Exception won't be thrown but is required
   */
  void mockServiceCalls(boolean usesInstanceValidatorParameters) throws Exception {
    validationService.determineVersion(Collections.EMPTY_LIST, Collections.EMPTY_LIST, false, false);
    validationService.initializeValidator(new ValidationEngineParameters(), usesInstanceValidatorParameters ? new InstanceValidatorParameters() : null, "", new TimeTracker(), new ArrayList<>());
  }

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
    public void executeTask(@Nonnull ValidationService validationService, @Nonnull String[] stringArgs) throws Exception {
      // We're not testing the task itself, just how ValidatorCli decides to execute it
    }
  };

  @Spy
  HTTPClientTask clientTask;

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
  public void executeTask(@Nonnull String[] args) throws Exception {
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
    public void executeTask(@Nonnull String[] args) {
      // We're not testing the task itself, just how ValidatorCli decides to execute it
    }
  };

  @Spy
  TestsTask testsTask = new TestsTask() {
      @Override
      public void executeTask(@Nonnull String[] args) {
        // We're not testing the task itself, just how ValidatorCli decides to execute it
      }
  };

  @Spy
  TxTestsTask txTestsTask = new TxTestsTask() {
    @Override
    public void executeTask(@Nonnull String[] args) {
      // We're not testing the task itself, just how ValidatorCli decides to execute it
    }
  };
  
  @Spy
  AiTestsTask aiTestsTask = new AiTestsTask() {
    @Override
    public void executeTask(@Nonnull String[] args) {
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
  RePackageTask rePackageTask = new RePackageTask() {
    @Override
    public void executeTask(@Nonnull ValidationService validationService, @Nonnull String[] stringArgs) throws Exception {
      mockServiceCalls(true);
    }
  };

  @Spy
  InstanceFactoryTask instanceFactoryTask;

  @Spy
  ScanTask scanTask = new ScanTask() {
    @Override
    public void executeTask(@Nonnull ValidationService validationService, @Nonnull String[] stringArgs) throws Exception {
      mockServiceCalls(false);
    }
  };
  @Spy
  SpecialTask specialTask = new SpecialTask() {
    @Override
    public void executeTask(@Nonnull String[] args) {
      // We're not testing the task itself, just how ValidatorCli decides to execute it
    }
  };

  private List<CliTask> testCliTasks;

  @BeforeEach
  void initializeCliTasks() {
  testCliTasks =List.of(
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
      rePackageTask,
      instanceFactoryTask,
      serverTask,
      clientTask,
      //validate is the default
      validateTask
    );
  }
  public ValidatorCli mockValidatorCli() {
    return spy(
      new ValidatorCli(validationService){
        @Override
        protected List<CliTask> getCliTasks() {
          return testCliTasks;
        }
    });
  }

  public ValidatorCli mockValidatorCliWithService(boolean usesInstanceValidatorParams) throws Exception {
    when(validationService.determineVersion(anyList(), anyList(), anyBoolean(), anyBoolean())).thenReturn("5.0.1");
    if (usesInstanceValidatorParams) {
      when(validationService.initializeValidator(any(ValidationEngineParameters.class), any(InstanceValidatorParameters.class), anyString(), any(TimeTracker.class), anyList())).thenReturn(validationEngine);
    } else {
      when(validationService.initializeValidator(any(ValidationEngineParameters.class), isNull(), anyString(), any(TimeTracker.class), anyList())).thenReturn(validationEngine);
    }
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
  void validationEngineTaskSelectionTest() throws Exception {

      Map<String, ValidationEngineTask> argsAndTasks = Map.ofEntries(
        Map.entry("-compare", compareTask),
        Map.entry("-compile dummyMap.map", compileTask),
        Map.entry("-convert", convertTask),
        Map.entry("-fhirpath Patient.id", fhirpathTask),
        Map.entry("-install", installTask),
        Map.entry("-lang-transform dummyLang", langTransformTask),
        Map.entry("-narrative", narrativeTask),
        Map.entry("-scan", scanTask),
        Map.entry("-snapshot", snapshotTask),
        Map.entry("-spreadsheet", spreadsheetTask),
        Map.entry("-transform dummyFile.map", transformTask),
        Map.entry("-to-version 5.0", versionTask),
        Map.entry("-codegen", codeGenTask),
        Map.entry("-tx-pack package-one,package-two", rePackageTask),
        Map.entry("-factory source1", instanceFactoryTask),
        Map.entry("-server", serverTask)
      );

      for (Map.Entry<String, ValidationEngineTask> entry : argsAndTasks.entrySet()) {
        String[] args = entry.getKey().split("\\s");
        if (entry.getKey().equals("-to-version 5.0")) {
          System.out.println(Arrays.toString(args));
          ValidatorCli cli = mockValidatorCliWithService(entry.getValue().usesInstanceValidatorParameters());
          cli.readGlobalParamsAndExecuteTask(args);
          Mockito.verify(entry.getValue()).executeTask(same(validationService), eq(args));
        }
      }
  }

  @Test
  // This test needs to be separate from the other validationEngineTaskSelectionTest entries because
  // the defaultTask in ValidatorCli is a final, and will be returned instead of our mock.
  void defaultTaskSelectionTest() throws Exception {
    final String[] args = new String[]{"dummyFile.json"};

    ValidatorCli cli = mockValidatorCliWithService(validateTask.usesInstanceValidatorParameters());

    cli.readGlobalParamsAndExecuteTask(args);
    Mockito.verify(validationService).validateSources(
      same(validationEngine),any(ValidateSourceParameters.class));
  }

  @Test
  void standaloneTaskSelectionTest() throws Exception {
    Map<String, StandaloneTask> argsAndTasks = Map.of(
      "txTests", txTestsTask,
      "-preload-cache", preloadCacheTask,
      "-aiTests", aiTestsTask,
      "-special", specialTask,
      "-tests", testsTask,
      "-lang-regen arg1 arg2 arg3", langRegenTask,
      "-client", clientTask
    );

    for (Map.Entry<String, StandaloneTask> entry : argsAndTasks.entrySet()) {
      String[] args = entry.getKey().split("\\s");
      ValidatorCli cli = mockValidatorCli();
      cli.readGlobalParamsAndExecuteTask(args);
      Mockito.verify(entry.getValue()).executeTask(args);
    }
  }

  @Test
  void inferredCodeGenTest() throws Exception{
    final String[] args = new String[]{"-package-name", "mypackage"};
    ValidatorCli cli = mockValidatorCliWithService(codeGenTask.usesInstanceValidatorParameters());
    cli.readGlobalParamsAndExecuteTask(args);
    Mockito.verify(codeGenTask).executeTask(same(validationService), eq(args));
  }

  @Test
  void rePackageTaskTest() throws Exception{
    final String[] args = new String[]{"-re-package", "-package-name", "mypackage"};

    ValidatorCli cli = mockValidatorCli();
    cli.readGlobalParamsAndExecuteTask(args);
    Mockito.verify(rePackageTask).executeTask(same(validationService), eq(args));

    // Make sure -package-name doesn't cause codeGenTask execution
    Mockito.verify(codeGenTask, never()).executeTask(same(validationService), eq(args));
  }

  @Test
  void testFhirSettingsFile() throws Exception {
    File tempFile = ManagedFileAccess.fromPath(Files.createTempFile("fhir-settings", "json"));
    ValidatorCli.GlobalParams globalParams = ValidatorCli.readGlobalParams(new String[]{"-fhir-settings", tempFile.getAbsolutePath()});
    Assertions.assertEquals(tempFile.getAbsolutePath(), globalParams.getFhirSettingsFilePath());
  }

  @Test
  void testFhirSettingsFileDoesntExist() {
    java.lang.Error error = Assertions.assertThrows(java.lang.Error.class, () -> {
       ValidatorCli.readGlobalParams(new String[]{"-fhir-settings", "this-does-not-exist.json"});
    });
    assertThat(error.getMessage()).contains("this-does-not-exist.json");
  }
}
