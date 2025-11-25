package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.*;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import org.hl7.fhir.validation.service.model.ValidationEngineParameters;
import org.hl7.fhir.validation.service.model.WatchParameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
// Created by Claude Sonnet 4.5
class ValidationEngineTaskTests {


  @Spy
  CodeGenTask codeGenTask;

  @Spy
  CompileTask compileTask;

  @Spy
  ConvertTask convertTask;

  @Spy
  FhirpathTask fhirpathTask;

  @Spy
  InstanceFactoryTask instanceFactoryTask;

  @Spy
  InstallTask installTask;

  @Spy
  LangTransformTask langTransformTask;

  @Spy
  NarrativeTask narrativeTask;

  @Spy
  RePackageTask rePackageTask;

  @Spy
  SnapshotTask snapshotTask;

  @Spy
  SpreadsheetTask spreadsheetTask;

  @Spy
  TransformTask transformTask;

  @Spy
  VersionTask versionTask;

  @Spy
  ValidateTask validateTask;

  @Mock
  ValidationService validationService;

  @Spy
  ValidationEngine validationEngine;

  @BeforeEach
  void setUp() throws Exception {
    when(validationService.determineVersion(anyList(), anyList(), anyBoolean(), anyBoolean())).thenReturn("5.0.1");
  }

  public void mockGetValidator(boolean useInstanceValidatorParameters) throws Exception {
    if (useInstanceValidatorParameters) {
      when(validationService.initializeValidator(any(ValidationEngineParameters.class), any(InstanceValidatorParameters.class), anyString(), any(TimeTracker.class), anyList())).thenReturn(validationEngine);
    } else {
      when(validationService.initializeValidator(any(ValidationEngineParameters.class), isNull(), anyString(), any(TimeTracker.class), anyList())).thenReturn(validationEngine);
    }

  }

  @Test
  void codeGenTest() throws Exception {
    mockGetValidator(true);
    String[] args = {"-codegen"};
    codeGenTask.executeTask(validationService, args);
    verify(validationService).codeGen(same(validationEngine),
      eq(new CodeGenParameters(
        "5.0.1",
            Collections.emptyList(),
            Collections.emptyList(),
        null,
        null
      )));
  }

  @Test
  void compileTest() throws Exception {
    mockGetValidator(false);
    String[] args = {"-compile", "dummyMap.map"};
    compileTask.executeTask(validationService, args);
    verify(validationService).compile(same(validationEngine), eq("dummyMap.map"), isNull(), anyList(), isNull());
  }

  @Test
  void convertTest() throws Exception {
    mockGetValidator(false);
    String[] args = {"-convert"};
    convertTask.executeTask(validationService, args);
    verify(validationService).convertSources(same(validationEngine), eq(Collections.emptyList()), isNull(), isNull());
  }

  @Test
  void fhirpathTest() throws Exception {
    mockGetValidator(false);
    String[] args = {"-fhirpath","dummyExpression"};
    fhirpathTask.executeTask(validationService, args);
    verify(validationService).evaluateFhirpath(same(validationEngine), eq("dummyExpression"), eq(Collections.emptyList()));
  }

  @Test
  void instanceFactoryTaskTest() throws Exception {
    mockGetValidator(false);
    String[] args = {"-factory", "arg1"};
    instanceFactoryTask.executeTask(validationService, args);
    verify(validationService).instanceFactory(same(validationEngine), eq("arg1"));
  }

  @Test
  void installTest() throws Exception {
    mockGetValidator(false);
    String[] args = {"-install"};
    installTask.executeTask(validationService, args);
    verify(validationService).install(eq(Collections.emptyList()), same(validationEngine));
  }

  @Test
  void langTransformTest() throws Exception {
    mockGetValidator(false);
    String[] args = {"-lang-transform", "dummyLang"};
    langTransformTask.executeTask(validationService, args);
    verify(validationService).transformLang(same(validationEngine), eq(new TransformLangParameters("dummyLang", Collections.emptyList(), null, null, Collections.emptyList(), null )));
  }

  @Test
  void narrativeTest() throws Exception {
    mockGetValidator(false);
    String[] args = {"-narrative"};
    narrativeTask.executeTask(validationService, args);
    verify(validationService).generateNarrative(same(validationEngine), eq(
      "5.0.1"), eq(Collections.emptyList()), isNull());
  }

  @Test
  void snapshotTest() throws Exception {
    mockGetValidator(false);
    String[] args = {"-snapshot"};
    snapshotTask.executeTask(validationService, args);
    verify(validationService).generateSnapshot(same(validationEngine),
      eq(new GenerateSnapshotParameters("5.0.1", Collections.emptyList(), null, null)));
  }

  @Test
  void spreadsheetTest() throws Exception {
    mockGetValidator(false);
    String[] args = {"-spreadsheet"};
    spreadsheetTask.executeTask(validationService, args);
    verify(validationService).generateSpreadsheet(same(validationEngine), eq("5.0.1"),  eq(Collections.emptyList()), isNull());
  }

  @Test
  void transformTest() throws Exception {
    mockGetValidator(false);
    String[] args = {"-transform", "dummyFile.map", "dummySource.json"};
    transformTask.executeTask(validationService, args);
    verify(validationService).transform(same(validationEngine), eq(
      new TransformParameters("dummyFile.map", null, "http://tx.fhir.org", List.of("dummySource.json"), null)
    ));
  }

  @Test
  void versionTest() throws Exception {
    mockGetValidator(false);
    String[] args = {"-to-version", "1.2.3"};
    versionTask.executeTask(validationService, args);
    verify(validationService).transformVersion(same(validationEngine),
    eq(new TransformVersionParameters("1.2.3", null, false, Collections.emptyList(), null)));
  }

  @Test
  void validateTest() throws Exception {
    mockGetValidator(true);
    String[] args = {"meh"};

    validateTask.executeTask(validationService, args);
    Mockito.verify(validationService).validateSources(same(validationEngine), eq(
      new ValidateSourceParameters(
        new InstanceValidatorParameters(),
        List.of("meh"),
        null,
        new WatchParameters()
      )
    ));

  }
}
