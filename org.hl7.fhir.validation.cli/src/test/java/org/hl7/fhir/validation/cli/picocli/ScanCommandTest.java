package org.hl7.fhir.validation.cli.picocli;

import org.hl7.fhir.validation.cli.picocli.commands.ScanCommand;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for ScanCommand.
 *
 * Tests verify that the command is properly configured with Picocli annotations
 * and has the required parameters.
 */
public class ScanCommandTest {

  @Test
  public void testCommandExists() {
    // Basic smoke test to verify command class is properly structured
    ScanCommand command = new ScanCommand();
    assertThat(command).isNotNull();
  }

  @Test
  public void testCommandName() {
    // Verify the command has the correct name
    CommandLine commandLine = new CommandLine(new ScanCommand());
    assertThat(commandLine.getCommandName()).isEqualTo("scan");
  }

  @Test
  public void testCommandIsHidden() {
    // Verify the command is marked as hidden (internal tool)
    CommandLine commandLine = new CommandLine(new ScanCommand());
    assertThat(commandLine.getCommandSpec().usageMessage().hidden()).isTrue();
  }

  @Test
  public void testCommandHasSourceParameters() {
    // Verify the command has positional parameters for sources
    CommandLine commandLine = new CommandLine(new ScanCommand());
    long parameterCount = commandLine.getCommandSpec().positionalParameters().size();
    assertThat(parameterCount).isGreaterThan(0);
  }

  @Test
  public void testCommandHasOutputOption() {
    // Verify the command has -output option
    CommandLine commandLine = new CommandLine(new ScanCommand());
    boolean hasOutputOption = commandLine.getCommandSpec().optionsMap().containsKey("-output");
    assertThat(hasOutputOption).isTrue();
  }

  @Test
  public void testOutputOptionIsRequired() {
    // Verify the -output option is marked as required
    CommandLine commandLine = new CommandLine(new ScanCommand());
    CommandLine.Model.OptionSpec outputOption = commandLine.getCommandSpec().optionsMap().get("-output");
    assertThat(outputOption.required()).isTrue();
  }
}
