package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.ValidatorWatchMode;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

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
  public void setUp() throws Exception {
    when(validationService.determineVersion(any(ValidationContext.class))).thenReturn("5.0.1");
    when(validationService.initializeValidator(any(ValidationContext.class), anyString(), any(org.hl7.fhir.utilities.TimeTracker.class))).thenReturn(validationEngine);
  }

  @Test
  void codeGenTest() throws Exception {
    String[] args = {"-codegen"};
    codeGenTask.executeTask(validationService, args);
    verify(validationService).codeGen(any(ValidationContext.class), same(validationEngine));
  }

  @Test
  void compileTest() throws Exception {
    String[] args = {"-compile", "dummyMap.map"};
    compileTask.executeTask(validationService, args);
    verify(validationService).compile(any(ValidationContext.class), same(validationEngine));
  }

  @Test
  void convertTest() throws Exception {
    String[] args = {"-convert"};
    convertTask.executeTask(validationService, args);
    verify(validationService).convertSources(any(ValidationContext.class), same(validationEngine));
  }

  @Test
  void fhirpathTest() throws Exception {
    String[] args = {"-fhirpath","dummyExpression"};
    fhirpathTask.executeTask(validationService, args);
    verify(validationService).evaluateFhirpath(any(ValidationContext.class), same(validationEngine));
  }

  @Test
  void instanceFactoryTaskTest() throws Exception {
    String[] args = {"-factory", "arg1"};
    instanceFactoryTask.executeTask(validationService, args);
    verify(validationService).instanceFactory(any(ValidationContext.class), same(validationEngine));
  }

  @Test
  void installTest() throws Exception {
    String[] args = {"-install"};
    installTask.executeTask(validationService, args);
    verify(validationService).install(any(List.class), same(validationEngine));
  }

  @Test
  void langTransformTest() throws Exception {
    String[] args = {"-lang-transform", "dummyLang"};
    langTransformTask.executeTask(validationService, args);
    verify(validationService).transformLang(any(ValidationContext.class), same(validationEngine));
  }

  @Test
  void narrativeTest() throws Exception {
    String[] args = {"-narrative"};
    narrativeTask.executeTask(validationService, args);
    verify(validationService).generateNarrative(any(ValidationContext.class), same(validationEngine));
  }

  @Test
  void snapshotTest() throws Exception {
    String[] args = {"-snapshot"};
    snapshotTask.executeTask(validationService, args);
    verify(validationService).generateSnapshot(any(ValidationContext.class), same(validationEngine));
  }

  @Test
  void spreadsheetTest() throws Exception {
    String[] args = {"-spreadsheet"};
    spreadsheetTask.executeTask(validationService, args);
    //verify(validationService).generateSpreadsheet(any(ValidationContext.class), same(validationEngine));
  }

  @Test
  void transformTest() throws Exception {
    String[] args = {"-transform", "dummyFile.map", "dummySource.json"};
    transformTask.executeTask(validationService, args);
    verify(validationService).transform(any(ValidationContext.class), same(validationEngine));
  }

  @Test
  void versionTest() throws Exception {
    String[] args = {"-to-version", "1.2.3"};
    versionTask.executeTask(validationService, args);
    verify(validationService).transformVersion(any(ValidationContext.class), same(validationEngine));
  }

  @Test
  void validateTest() throws Exception {
    String[] args = {"meh"};
    ValidatorWatchMode watchMode = ValidatorWatchMode.NONE;
    int watchScanDelay = 1000;
    int watchSettleTime = 100;
    validateTask.executeTask(validationService, args);
    Mockito.verify(validationService).validateSources(any(ValidationContext.class), same(validationEngine), eq(watchMode), eq(watchScanDelay), eq(watchSettleTime));

  }
}
