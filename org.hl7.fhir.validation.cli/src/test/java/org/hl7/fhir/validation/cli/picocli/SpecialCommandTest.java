package org.hl7.fhir.validation.cli.picocli;

import org.hl7.fhir.validation.cli.picocli.commands.SpecialCommand;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for SpecialCommand.
 *
 * Tests verify that the command is properly configured with Picocli annotations
 * and has the required parameters.
 */
public class SpecialCommandTest {

  @Test
  public void testCommandExists() {
    // Basic smoke test to verify command class is properly structured
    SpecialCommand command = new SpecialCommand();
    assertThat(command).isNotNull();
  }

  @Test
  public void testCommandName() {
    // Verify the command has the correct name
    CommandLine commandLine = new CommandLine(new SpecialCommand());
    assertThat(commandLine.getCommandName()).isEqualTo("special");
  }

  @Test
  public void testCommandIsHidden() {
    // Verify the command is marked as hidden (internal tool)
    CommandLine commandLine = new CommandLine(new SpecialCommand());
    assertThat(commandLine.getCommandSpec().usageMessage().hidden()).isTrue();
  }

  @Test
  public void testCommandHasModeParameter() {
    // Verify the command has a positional parameter for mode (index 0)
    CommandLine commandLine = new CommandLine(new SpecialCommand());
    long parameterCount = commandLine.getCommandSpec().positionalParameters().size();
    assertThat(parameterCount).isGreaterThan(0);

    // Verify the first positional parameter is for the mode
    CommandLine.Model.PositionalParamSpec modeParam = commandLine.getCommandSpec().positionalParameters().get(0);
    assertThat(modeParam.index().originalValue()).isEqualTo("0");
  }

  @Test
  public void testCommandHasTargetOption() {
    // Verify the command has -target option
    CommandLine commandLine = new CommandLine(new SpecialCommand());
    boolean hasTargetOption = commandLine.getCommandSpec().optionsMap().containsKey("-target");
    assertThat(hasTargetOption).isTrue();
  }

  @Test
  public void testCommandHasSourceOption() {
    // Verify the command has -source option (optional)
    CommandLine commandLine = new CommandLine(new SpecialCommand());
    boolean hasSourceOption = commandLine.getCommandSpec().optionsMap().containsKey("-source");
    assertThat(hasSourceOption).isTrue();

    // Verify it's not required
    CommandLine.Model.OptionSpec sourceOption = commandLine.getCommandSpec().optionsMap().get("-source");
    assertThat(sourceOption.required()).isFalse();
  }

  @Test
  public void testCommandHasFilterOption() {
    // Verify the command has -filter option (optional)
    CommandLine commandLine = new CommandLine(new SpecialCommand());
    boolean hasFilterOption = commandLine.getCommandSpec().optionsMap().containsKey("-filter");
    assertThat(hasFilterOption).isTrue();

    // Verify it's not required
    CommandLine.Model.OptionSpec filterOption = commandLine.getCommandSpec().optionsMap().get("-filter");
    assertThat(filterOption.required()).isFalse();
  }
}
