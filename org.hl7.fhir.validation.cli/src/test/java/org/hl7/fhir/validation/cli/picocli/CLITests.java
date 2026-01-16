package org.hl7.fhir.validation.cli.picocli;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.picocli.commands.*;
import org.hl7.fhir.validation.cli.picocli.options.FHIRSettingsOptions;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.special.PackageReGenerator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.junit.jupiter.MockitoExtension;
import picocli.CommandLine;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

/**
 * Integration tests for the CLI class that verify:
 * <ul>
 *   <li>Command selection and routing</li>
 *   <li>Deprecated argument replacement</li>
 *   <li>Special CLI behaviors (codegen inference, re-package precedence)</li>
 *   <li>Global parameter handling (-fhir-settings, etc.)</li>
 * </ul>
 *
 * <p>This test class complements individual CommandTest classes by focusing on
 * CLI-level behaviors rather than individual command structure or execution.</p>
 *
 * <p>This is the Picocli equivalent of the legacy ValidatorCliTests class.</p>
 */
@ExtendWith(MockitoExtension.class)
class CLITests {

  @Nested
  @DisplayName("ValidationEngine Command Selection Tests")
  class ValidationEngineCommandSelectionTests {

    @Mock
    ValidationService validationService;

    @Mock
    ValidationEngine validationEngine;



    @Test
    @DisplayName("Compare command is selected with compare syntax")
    void compareCommandSelection() {

      String[] args = {"compare", "-left", "profile1", "-right", "profile2", "-dest", "/tmp"};

      try (MockedConstruction<CompareCommand> construction = mockConstruction(CompareCommand.class,
        (mock, context) -> {
          // Mock the call method to return success
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("Compile command is selected with compile syntax")
    void compileCommandSelection() {

      String[] args = {"compile", "dummyMap.map", "-output", "/tmp/output.map"};

      try (MockedConstruction<CompileCommand> construction = mockConstruction(CompileCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("Convert command is selected with convert syntax")
    void convertCommandSelection() {

      String[] args = {"convert", "source.xml", "-output", "/tmp/output.json"};

      try (MockedConstruction<ConvertCommand> construction = mockConstruction(ConvertCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("Fhirpath command is selected with fhirpath syntax")
    void fhirpathCommandSelection() {

      String[] args = {"fhirpath", "Patient.id", "source.json"};

      try (MockedConstruction<FhirpathCommand> construction = mockConstruction(FhirpathCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("Install command is selected with install syntax")
    void installCommandSelection() {
      String[] args = {"install"};

      try (MockedConstruction<InstallCommand> construction = mockConstruction(InstallCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("Lang-transform command is selected with lang-transform syntax")
    void langTransformCommandSelection() {

      String[] args = {"lang-transform", "dummyLang", "source.xml"};

      try (MockedConstruction<LangTransformCommand> construction = mockConstruction(LangTransformCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("Narrative command is selected with narrative syntax")
    void narrativeCommandSelection() {

      String[] args = {"narrative", "source.xml"};

      try (MockedConstruction<NarrativeCommand> construction = mockConstruction(NarrativeCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("Scan command is selected with scan syntax")
    void scanCommandSelection() {

      String[] args = {"scan", "source.xml", "-output", "dummyOutput.txt"};

      try (MockedConstruction<ScanCommand> construction = mockConstruction(ScanCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("Snapshot command is selected with snapshot syntax")
    void snapshotCommandSelection() {
      String[] args = {"snapshot", "source.xml", "-output", "/tmp/output.xml"};

      try (MockedConstruction<SnapshotCommand> construction = mockConstruction(SnapshotCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("Spreadsheet command is selected with spreadsheet syntax")
    void spreadsheetCommandSelection() {

      String[] args = {"spreadsheet", "source.xml"};

      try (MockedConstruction<SpreadsheetCommand> construction = mockConstruction(SpreadsheetCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("Transform command is selected with transform syntax")
    void transformCommandSelection() {

      String[] args = {"transform", "dummyFile.map", "dummySource.json", "-output", "/tmp/output.json"};

      try (MockedConstruction<TransformCommand> construction = mockConstruction(TransformCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("Version command is selected with to-version syntax")
    void versionCommandSelection() {

      String[] args = {"to-version", "5.0", "source.xml", "-output", "/tmp/output.xml"};

      try (MockedConstruction<VersionCommand> construction = mockConstruction(VersionCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("CodeGen command is selected with codegen syntax")
    void codeGenCommandSelection() {

      String[] args = {"codegen", "-package-name", "test.pkg", "-output", "/tmp/output"};

      try (MockedConstruction<CodeGenCommand> construction = mockConstruction(CodeGenCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("RePackage command is selected with re-package syntax")
    void rePackageCommandSelection() {

      String[] args = {"re-package", "package-one,package-two", "-output", "/tmp/output.tgz"};

      try (MockedConstruction<RePackageCommand> commandConstruction = mockConstruction(RePackageCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        });
        MockedConstruction<PackageReGenerator> packageConstruction = mockConstruction(
          PackageReGenerator.class,
          (mock, context) -> {
            when(mock.setContext(any())).thenReturn(mock);
            when(mock.setOutput(anyString())).thenReturn(mock);
            when(mock.setOutputType(any())).thenReturn(mock);
            when(mock.setJson(anyBoolean())).thenReturn(mock);
            when(mock.setModes(any())).thenReturn(mock);
            when(mock.setNpmId(anyString())).thenReturn(mock);
            when(mock.addPackages(any())).thenReturn(mock);
            when(mock.setScope(any())).thenReturn(mock);
            when(mock.setIgnoreList(any())).thenReturn(mock);
            when(mock.setIncludeList(any())).thenReturn(mock);
            when(mock.setIncludeConformsTo(anyBoolean())).thenReturn(mock);
          })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(commandConstruction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(commandConstruction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("Factory command is selected with factory syntax")
    void factoryCommandSelection() {

      String[] args = {"factory", "source1"};

      try (MockedConstruction<InstanceFactoryCommand> construction = mockConstruction(InstanceFactoryCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("Server command is selected with server syntax")
    void serverCommandSelection() {

      String[] args = {"server", "8080"};

      try (MockedConstruction<HTTPServerCommand> construction = mockConstruction(HTTPServerCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }
  }

  @Nested
  @DisplayName("Default Command Selection Tests")
  class DefaultCommandSelectionTests {

    @Mock
    ValidationService validationService;

    @Mock
    ValidationEngine validationEngine;

    @Test
    @DisplayName("Default command selection (no command = validate)")
    void defaultCommandSelectionTest() {

      String[] args = {"dummyFile.json"};

      try (MockedConstruction<ValidateCommand> construction = mockConstruction(ValidateCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }
  }

  @Nested
  @DisplayName("Standalone Command Selection Tests")
  class StandaloneCommandSelectionTests {

    @Test
    @DisplayName("TxTests command is selected with txTests syntax")
    void txTestsCommandSelection() {
      ValidationService validationService = mock(ValidationService.class);
      String[] args = {"txTests"};

      try (MockedConstruction<TxTestsCommand> construction = mockConstruction(TxTestsCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("PreloadCache command is selected with preloadCache syntax")
    void preloadCacheCommandSelection() {
      ValidationService validationService = mock(ValidationService.class);
      String[] args = {"preloadCache"};

      try (MockedConstruction<PreloadCacheCommand> construction = mockConstruction(PreloadCacheCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("AiTests command is selected with aiTests syntax")
    void aiTestsCommandSelection() {
      ValidationService validationService = mock(ValidationService.class);
      String[] args = {"aiTests", "-source", "dummySource.json"};

      try (MockedConstruction<AiTestsCommand> construction = mockConstruction(AiTestsCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("Special command is selected with special syntax")
    void specialCommandSelection() {
      ValidationService validationService = mock(ValidationService.class);
      String[] args = {"special", "mode"};

      try (MockedConstruction<SpecialCommand> construction = mockConstruction(SpecialCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("Tests command is selected with tests syntax")
    void testsCommandSelection() {
      ValidationService validationService = mock(ValidationService.class);
      String[] args = {"tests", "directory"};

      try (MockedConstruction<TestsCommand> construction = mockConstruction(TestsCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("Lang-regen command is selected with lang-regen syntax")
    void langRegenCommandSelection() {
      ValidationService validationService = mock(ValidationService.class);
      String[] args = {"lang-regen", "arg1", "arg2", "arg3"};

      try (MockedConstruction<LangRegenerateCommand> construction = mockConstruction(LangRegenerateCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("Client command is selected with client syntax")
    void clientCommandSelection() {
      ValidationService validationService = mock(ValidationService.class);
      String[] args = {"client", "http://localhost:80"};

      try (MockedConstruction<HTTPClientCommand> construction = mockConstruction(HTTPClientCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }
  }

  @Nested
  @DisplayName("Special CLI Behavior Tests")
  class SpecialBehaviorTests {

    @Mock
    ValidationService validationService;

    @Mock
    ValidationEngine validationEngine;


    @Test
    @DisplayName("Package name parameter alone infers codegen command")
    void inferredCodeGenFromPackageNameTest() throws Exception {
      String[] args = {"-package-name", "mypackage", "-output", "/tmp/out"};

      try (MockedConstruction<CodeGenCommand> construction = mockConstruction(CodeGenCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("Re-package command takes precedence over inferred codegen")
    void rePackagePrecedenceOverCodeGenTest() throws Exception {
      String[] args = {"re-package", "some.package#1.0.0", "-package-name", "mypackage", "-output", "/tmp/out.tgz"};

      try (MockedConstruction<RePackageCommand> rePackageConstruction = mockConstruction(RePackageCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        });
        //MockedConstruction<CodeGenCommand> codeGenConstruction = mockConstruction(CodeGenCommand.class);

            ) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        // Verify RePackageCommand was constructed and called
        assertThat(rePackageConstruction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(rePackageConstruction.constructed().get(0), atLeastOnce()).call();

        // Verify CodeGenCommand was NOT constructed or called
        //assertThat(codeGenConstruction.constructed()).isEmpty();
      }
    }
  }

  @Nested
  @DisplayName("Global Parameter Tests")
  class GlobalParameterTests {

    @Mock
    ValidationService validationService;

    @Mock
    ValidationEngine validationEngine;

    @Test
    @DisplayName("Test -fhir-settings is checked by the CLI")
    void fhirSettingsFileExistsTest() {

      String[] args = {"-fhir-settings", "dummySettingsFile.json", "dummyFile.json"};

      try (MockedConstruction<ValidateCommand> construction = mockConstruction(ValidateCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        });
           MockedConstruction<FHIRSettingsOptions> fhirSettingsConstruction = mockConstruction(FHIRSettingsOptions.class,
             (mock, context) -> {
              doNothing().when(mock).setFhirSettingsFile("dummySettingsFile.json");
             })
      ) {
          int result =   new CLI(validationService).parseArgsAndExecuteCommand(args);
          assertThat(result).isZero();
        verify(fhirSettingsConstruction.constructed().get(0), atLeastOnce()).setFhirSettingsFile("dummySettingsFile.json");
      }
    }

    @Test
    @DisplayName("Non-existent fhir-settings file returns error code")
    void fhirSettingsFileNotFoundTest() {

      ValidationService validationService = mock(ValidationService.class);
      String[] args = {"-fhir-settings", "this-does-not-exist.json", "dummyFile.json"};

      Exception exception = assertThrows(IllegalArgumentException.class, () -> {
          new CLI(validationService).parseArgsAndExecuteCommand(args);
      });
      assertThat(exception.getMessage()).contains("Cannot find fhir-settings file");
    }
  }

  @Nested
  @DisplayName("Deprecated Argument Tests")
  class DeprecatedArgumentTests {

    @Mock
    ValidationService validationService;

    @Mock
    ValidationEngine validationEngine;

    @Test
    @DisplayName("Deprecated -compare argument is replaced with compare command")
    void deprecatedCompareArgumentTest() {

      String[] args = {"-compare", "-left", "p1", "-right", "p2", "-dest", "/tmp"};

      try (MockedConstruction<CompareCommand> construction = mockConstruction(CompareCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("Deprecated -compile argument is replaced with compile command")
    void deprecatedCompileArgumentTest() {

      String[] args = {"-compile", "dummyMap.map", "-output", "/tmp/output.map"};

      try (MockedConstruction<CompileCommand> construction = mockConstruction(CompileCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("Deprecated -server argument is replaced with server command")
    void deprecatedServerArgumentTest() {
      String[] args = {"-server", "8080"};

      try (MockedConstruction<HTTPServerCommand> construction = mockConstruction(HTTPServerCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("Deprecated -install argument is replaced with install command")
    void deprecatedInstallArgumentTest() {

      String[] args = {"-install"};

      try (MockedConstruction<InstallCommand> construction = mockConstruction(InstallCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("Deprecated -convert argument is replaced with convert command")
    void deprecatedConvertArgumentTest() {

      String[] args = {"-convert", "source.xml", "-output", "/tmp/output.json"};

      try (MockedConstruction<ConvertCommand> construction = mockConstruction(ConvertCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }

    @Test
    @DisplayName("Deprecated -to-version argument is replaced with to-version command")
    void deprecatedToVersionArgumentTest() {

      String[] args = {"-to-version", "5.0", "source.xml", "-output", "/tmp/output.xml"};

      try (MockedConstruction<VersionCommand> construction = mockConstruction(VersionCommand.class,
        (mock, context) -> {
          when(mock.call()).thenReturn(0);
          doNothing().when(mock).setValidationService(any());
        })) {

        new CLI(validationService).parseArgsAndExecuteCommand(args);

        assertThat(construction.constructed()).hasSizeGreaterThanOrEqualTo(1);
        verify(construction.constructed().get(0), atLeastOnce()).call();
      }
    }
  }

  @Nested
  @DisplayName("Command Registration Tests")
  class CommandRegistrationTests {

    @Test
    @DisplayName("All expected commands are registered in ValidateCommand")
    void allCommandsRegisteredTest() {
      CommandLine commandLine = new CommandLine(new ValidateCommand());
      Map<String, CommandLine> subcommands = commandLine.getCommandSpec().subcommands();

      List<String> expectedCommands = List.of(
        "help", "compare", "compile", "convert", "to-version", "fhirpath",
        "transform", "lang-transform", "lang-regen", "narrative", "codegen",
        "preloadCache", "scan", "snapshot", "special", "spreadsheet", "tests",
        "txTests", "aiTests", "install", "factory", "server", "client", "re-package"
      );

      assertThat(subcommands.keySet()).containsAll(expectedCommands);
    }
  }
}
