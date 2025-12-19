package org.hl7.fhir.validation.cli.picocli;

import org.hl7.fhir.validation.cli.picocli.commands.SnapshotCommand;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for SnapshotCommand.
 *
 * Tests verify that the command is properly configured with Picocli annotations
 * and has the required parameters.
 */
public class SnapshotCommandTest {

  @Test
  public void testCommandExists() {
    // Basic smoke test to verify command class is properly structured
    SnapshotCommand command = new SnapshotCommand();
    assertThat(command).isNotNull();
  }

  @Test
  public void testCommandName() {
    // Verify the command has the correct name
    CommandLine commandLine = new CommandLine(new SnapshotCommand());
    assertThat(commandLine.getCommandName()).isEqualTo("snapshot");
  }

  @Test
  public void testCommandIsVisible() {
    // Verify the command is NOT hidden (visible in help)
    CommandLine commandLine = new CommandLine(new SnapshotCommand());
    assertThat(commandLine.getCommandSpec().usageMessage().hidden()).isFalse();
  }

  @Test
  public void testCommandHasSourceParameters() {
    // Verify the command has positional parameters for sources
    CommandLine commandLine = new CommandLine(new SnapshotCommand());
    long parameterCount = commandLine.getCommandSpec().positionalParameters().size();
    assertThat(parameterCount).isGreaterThan(0);
  }

  @Test
  public void testCommandHasOutputOption() {
    // Verify the command has -output option
    CommandLine commandLine = new CommandLine(new SnapshotCommand());
    boolean hasOutputOption = commandLine.getCommandSpec().optionsMap().containsKey("-output");
    assertThat(hasOutputOption).isTrue();
  }

  @Test
  public void testCommandHasOutputSuffixOption() {
    // Verify the command has -outputSuffix option
    CommandLine commandLine = new CommandLine(new SnapshotCommand());
    boolean hasOutputSuffixOption = commandLine.getCommandSpec().optionsMap().containsKey("-outputSuffix");
    assertThat(hasOutputSuffixOption).isTrue();
  }

  @Test
  public void testOutputOptionNotRequired() {
    // Verify -output is not marked as required (XOR validation happens at runtime)
    CommandLine commandLine = new CommandLine(new SnapshotCommand());
    CommandLine.Model.OptionSpec outputOption = commandLine.getCommandSpec().optionsMap().get("-output");
    assertThat(outputOption.required()).isFalse();
  }

  @Test
  public void testOutputSuffixOptionNotRequired() {
    // Verify -outputSuffix is not marked as required (XOR validation happens at runtime)
    CommandLine commandLine = new CommandLine(new SnapshotCommand());
    CommandLine.Model.OptionSpec outputSuffixOption = commandLine.getCommandSpec().optionsMap().get("-outputSuffix");
    assertThat(outputSuffixOption.required()).isFalse();
  }
}
