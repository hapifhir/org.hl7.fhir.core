package org.hl7.fhir.validation.cli.picocli;

import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.*;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import org.hl7.fhir.validation.service.model.ValidationEngineParameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for ValidationEngineCommands (Picocli-based commands).
 * <p/>
 * Tests verify that command line string arguments are correctly processed by
 * Picocli commands and result in the expected ValidationService method calls.
 * <p/>
 * This test class is analogous to ValidationEngineTaskTests but uses the new
 * Picocli command structure instead of the legacy task-based approach.
 */
@ExtendWith(MockitoExtension.class)
class ValidationEngineCommandTests {

  @Nested
  @DisplayName("Tests with mocked services")
  class MockedServiceTests {

    @Mock
    ValidationService validationService;

    @Mock
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
      String[] args = {"codegen", "-package-name", "test.pkg", "-output", "/tmp/output", "-profile", "http://example.com/profile"};
      new CLI(validationService).parseArgsAndExecuteCommand(args);
      verify(validationService).codeGen(same(validationEngine),
        eq(new CodeGenParameters(
          "5.0.1",
          List.of("http://example.com/profile"),
          Collections.emptyList(),
          "test.pkg",
          "/tmp/output"
        )));
    }

    @Test
    void compileTest() throws Exception {
      mockGetValidator(false);
      String[] args = {"compile", "dummyMap.map", "-output", "/tmp/output.map"};
      new CLI(validationService).parseArgsAndExecuteCommand(args);
      verify(validationService).compile(same(validationEngine), eq("dummyMap.map"), isNull(), anyList(), eq("/tmp/output.map"));
    }

    @Test
    void convertTest() throws Exception {
      mockGetValidator(false);
      String[] args = {"convert", "source.xml", "-output", "/tmp/output.json"};
      new CLI(validationService).parseArgsAndExecuteCommand(args);
      verify(validationService).convertSources(same(validationEngine), eq(List.of("source.xml")), eq("/tmp/output.json"), isNull());
    }

    @Test
    void fhirpathTest() throws Exception {
      mockGetValidator(false);
      String[] args = {"fhirpath", "dummyExpression", "source.json"};
      new CLI(validationService).parseArgsAndExecuteCommand(args);
      verify(validationService).evaluateFhirpath(same(validationEngine), eq("dummyExpression"), eq(List.of("source.json")));
    }

    @Test
    void instanceFactoryTaskTest() throws Exception {
      mockGetValidator(false);
      String[] args = {"factory", "arg1"};
      new CLI(validationService).parseArgsAndExecuteCommand(args);
      verify(validationService).instanceFactory(same(validationEngine), eq("arg1"));
    }

    @Test
    void installTest() throws Exception {
      mockGetValidator(false);
      String[] args = {"install"};
      new CLI(validationService).parseArgsAndExecuteCommand(args);
      verify(validationService).install(eq(Collections.emptyList()), same(validationEngine));
    }

    @Test
    void langTransformTest() throws Exception {
      mockGetValidator(false);
      String[] args = {"lang-transform", "dummyLang", "source.xml"};
      new CLI(validationService).parseArgsAndExecuteCommand(args);
      verify(validationService).transformLang(same(validationEngine), eq(new TransformLangParameters("dummyLang", Collections.emptyList(), null, null, List.of("source.xml"), null)));
    }

    @Test
    void narrativeTest() throws Exception {
      mockGetValidator(false);
      String[] args = {"narrative", "source.xml"};
      new CLI(validationService).parseArgsAndExecuteCommand(args);
      verify(validationService).generateNarrative(same(validationEngine), eq("5.0.1"), eq(List.of("source.xml")), isNull());
    }

    @Test
    void snapshotTest() throws Exception {
      mockGetValidator(false);
      String[] args = {"snapshot", "source.xml", "-output", "/tmp/output.xml"};
      new CLI(validationService).parseArgsAndExecuteCommand(args);
      verify(validationService).generateSnapshot(same(validationEngine),
        eq(new GenerateSnapshotParameters("5.0.1", List.of("source.xml"), "/tmp/output.xml", null)));
    }

    @Test
    void spreadsheetTest() throws Exception {
      mockGetValidator(false);
      String[] args = {"spreadsheet", "source.xml"};
      new CLI(validationService).parseArgsAndExecuteCommand(args);

      verify(validationService).generateSpreadsheet(same(validationEngine),
        eq("5.0.1"),
        eq(List.of("source.xml")), isNull());
    }

    @Test
    void transformTest() throws Exception {
      mockGetValidator(false);
      String[] args = {"transform", "dummyFile.map", "dummySource.json", "-output", "/tmp/output.json"};
      new CLI(validationService).parseArgsAndExecuteCommand(args);

      verify(validationService).transform(same(validationEngine), eq(
        new TransformParameters("dummyFile.map", null, "http://tx.fhir.org", List.of("dummySource.json"), "/tmp/output.json")
      ));
    }

    @Test
    void versionTest() throws Exception {
      mockGetValidator(false);
      String[] args = {"to-version", "1.2.3", "source.xml", "-output", "/tmp/output.xml"};
      new CLI(validationService).parseArgsAndExecuteCommand(args);
      verify(validationService).transformVersion(same(validationEngine),
        eq(new TransformVersionParameters("1.2.3", null, false, List.of("source.xml"), "/tmp/output.xml")));
    }

    @Test
    void validateTest() throws Exception {
      mockGetValidator(true);
      String[] args = {"meh"};
      new CLI(validationService).parseArgsAndExecuteCommand(args);
      verify(validationService).validateSources(same(validationEngine), eq(
        new ValidateSourceParameters(
          new InstanceValidatorParameters(),
          List.of("meh"),
          null,
          new WatchParameters(ValidatorWatchMode.NONE, 1000, 100)
        )
      ));
    }
  }
}
