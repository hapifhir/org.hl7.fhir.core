package org.hl7.fhir.validation.cli.picocli;

import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.picocli.commands.RePackageCommand;
import org.hl7.fhir.validation.cli.tasks.RePackageTask;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import org.hl7.fhir.validation.service.model.ValidationEngineParameters;
import org.hl7.fhir.validation.special.PackageReGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.junit.jupiter.MockitoExtension;
import picocli.CommandLine;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for RePackageCommand.
 * <p/>
 * Tests verify that the command is properly configured with Picocli annotations
 * and has the required parameters and options.
 */

@ExtendWith(MockitoExtension.class)
public class RePackageCommandTest {

  @Nested
  @DisplayName("Tests with mocked services")
  class MyMethodATests {
    @Mock
    ValidationService validationService;

    @Mock
    ValidationEngine validationEngine;

    @BeforeEach
    void setUp() throws Exception {
      when(validationService.determineVersion(anyList(), anyList(), anyBoolean(), anyBoolean())).thenReturn("5.0.1");
      when(validationService.initializeValidator(any(ValidationEngineParameters.class), any(InstanceValidatorParameters.class), anyString(), any(TimeTracker.class), anyList())).thenReturn(validationEngine);
    }

    @Test
    void usesRepackageParametersPackages() {

      String[] args = new String[]{"-re-package", "some.package#1.2.3",
        "-scope", "igs", "-mode", "cnt",
        "-mode", "tx", "-mode", "api",
        "-output", "/tmp/uuu/temp/out.tgz",
        "-ignore-list", "urn:ietf:bcp:47,urn:iso:std:iso:3166",
        "-include-conforms-to", "true",
        "-package-name", "some.repackage#1.2.3-patch"};

      try (MockedConstruction<PackageReGenerator> construction = mockConstruction(PackageReGenerator.class, (mock, context) -> {
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

        assertThat(construction.constructed()).hasSize(1);
        PackageReGenerator packageReGenerator = construction.constructed().get(0);
        verify(packageReGenerator).addPackages(eq(List.of("some.package#1.2.3")));
        verify(packageReGenerator).setIgnoreList(eq(List.of("urn:ietf:bcp:47","urn:iso:std:iso:3166")));
      }
    }
  }
  @Test
  public void testCommandExists() {
    // Basic smoke test to verify command class is properly structured
    RePackageCommand command = new RePackageCommand();
    assertThat(command).isNotNull();
  }

  @Test
  public void testCommandName() {
    // Verify the command has the correct name
    CommandLine commandLine = new CommandLine(new RePackageCommand());
    assertThat(commandLine.getCommandName()).isEqualTo("re-package");
  }

  @Test
  public void testCommandIsVisible() {
    // Verify the command is NOT hidden (visible in help)
    CommandLine commandLine = new CommandLine(new RePackageCommand());
    assertThat(commandLine.getCommandSpec().usageMessage().hidden()).isFalse();
  }

  @Test
  public void testCommandHasPackageParameters() {
    // Verify the command has positional parameters for packages
    CommandLine commandLine = new CommandLine(new RePackageCommand());
    long parameterCount = commandLine.getCommandSpec().positionalParameters().size();
    assertThat(parameterCount).isGreaterThan(0);
  }

  @Test
  public void testCommandHasOutputOption() {
    // Verify the command has -output option
    CommandLine commandLine = new CommandLine(new RePackageCommand());
    boolean hasOutputOption = commandLine.getCommandSpec().optionsMap().containsKey("-output");
    assertThat(hasOutputOption).isTrue();
  }

  @Test
  public void testOutputOptionIsRequired() {
    // Verify -output is marked as required
    CommandLine commandLine = new CommandLine(new RePackageCommand());
    CommandLine.Model.OptionSpec outputOption = commandLine.getCommandSpec().optionsMap().get("-output");
    assertThat(outputOption.required()).isTrue();
  }

  @Test
  public void testCommandHasOutputSuffixOption() {
    // Verify the command has -outputSuffix option
    CommandLine commandLine = new CommandLine(new RePackageCommand());
    boolean hasOutputSuffixOption = commandLine.getCommandSpec().optionsMap().containsKey("-outputSuffix");
    assertThat(hasOutputSuffixOption).isTrue();
  }

  @Test
  public void testCommandHasModeOption() {
    // Verify the command has -mode option
    CommandLine commandLine = new CommandLine(new RePackageCommand());
    boolean hasModeOption = commandLine.getCommandSpec().optionsMap().containsKey("-mode");
    assertThat(hasModeOption).isTrue();
  }

  @Test
  public void testCommandHasScopeOption() {
    // Verify the command has -scope option
    CommandLine commandLine = new CommandLine(new RePackageCommand());
    boolean hasScopeOption = commandLine.getCommandSpec().optionsMap().containsKey("-scope");
    assertThat(hasScopeOption).isTrue();
  }

  @Test
  public void testCommandHasFormatOption() {
    // Verify the command has -format option
    CommandLine commandLine = new CommandLine(new RePackageCommand());
    boolean hasFormatOption = commandLine.getCommandSpec().optionsMap().containsKey("-format");
    assertThat(hasFormatOption).isTrue();
  }

  @Test
  public void testCommandHasPackageNameOption() {
    // Verify the command has -package-name option
    CommandLine commandLine = new CommandLine(new RePackageCommand());
    boolean hasPackageNameOption = commandLine.getCommandSpec().optionsMap().containsKey("-package-name");
    assertThat(hasPackageNameOption).isTrue();
  }

  @Test
  public void testCommandHasPinOption() {
    // Verify the command has -pin option
    CommandLine commandLine = new CommandLine(new RePackageCommand());
    boolean hasPinOption = commandLine.getCommandSpec().optionsMap().containsKey("-pin");
    assertThat(hasPinOption).isTrue();
  }

  @Test
  public void testCommandHasExpandOption() {
    // Verify the command has -expand option
    CommandLine commandLine = new CommandLine(new RePackageCommand());
    boolean hasExpandOption = commandLine.getCommandSpec().optionsMap().containsKey("-expand");
    assertThat(hasExpandOption).isTrue();
  }

  @Test
  public void testCommandHasIgnoreListOption() {
    // Verify the command has -ignore-list option
    CommandLine commandLine = new CommandLine(new RePackageCommand());
    boolean hasIgnoreListOption = commandLine.getCommandSpec().optionsMap().containsKey("-ignore-list");
    assertThat(hasIgnoreListOption).isTrue();
  }

  @Test
  public void testCommandHasIncludeListOption() {
    // Verify the command has -include-list option
    CommandLine commandLine = new CommandLine(new RePackageCommand());
    boolean hasIncludeListOption = commandLine.getCommandSpec().optionsMap().containsKey("-include-list");
    assertThat(hasIncludeListOption).isTrue();
  }

  @Test
  public void testCommandHasIncludeConformsToOption() {
    // Verify the command has -include-conforms-to option
    CommandLine commandLine = new CommandLine(new RePackageCommand());
    boolean hasIncludeConformsToOption = commandLine.getCommandSpec().optionsMap().containsKey("-include-conforms-to");
    assertThat(hasIncludeConformsToOption).isTrue();
  }

  @Test
  public void testGetInstanceValidatorParameters() {
    // Verify that instance validator parameters are handled
    RePackageCommand command = new RePackageCommand();
    assertThat(command.getInstanceValidatorParameters()).isNotNull();
  }

  @Test
  public void testGetSourcesReturnsPackageList() {
    // Verify that getSources returns the package list (initially empty)
    RePackageCommand command = new RePackageCommand();
    assertThat(command.getSources()).isNotNull();
  }
}
