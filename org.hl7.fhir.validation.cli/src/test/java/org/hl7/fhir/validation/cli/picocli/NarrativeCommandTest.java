package org.hl7.fhir.validation.cli.picocli;

import org.hl7.fhir.validation.cli.picocli.commands.NarrativeCommand;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.assertj.core.api.Assertions.assertThat;

public class NarrativeCommandTest {

  @Test
  public void testCommandExists() {
    // Basic smoke test to verify command class is properly structured
    NarrativeCommand command = new NarrativeCommand();
    assertThat(command).isNotNull();
  }

  @Test
  public void testCommandName() {
    // Verify the command has the correct name
    CommandLine commandLine = new CommandLine(new NarrativeCommand());
    assertThat(commandLine.getCommandName()).isEqualTo("narrative");
  }

  @Test
  public void testCommandIsNotHidden() {
    // Verify the command is public (not hidden)
    CommandLine commandLine = new CommandLine(new NarrativeCommand());
    assertThat(commandLine.getCommandSpec().usageMessage().hidden()).isFalse();
  }

  @Test
  public void testCommandHasSourceParameters() {
    // Verify the command has positional parameters for sources
    CommandLine commandLine = new CommandLine(new NarrativeCommand());
    long parameterCount = commandLine.getCommandSpec().positionalParameters().size();
    assertThat(parameterCount).isGreaterThan(0);
  }

  @Test
  public void testCommandHasOutputOption() {
    // Verify the command has -output option
    CommandLine commandLine = new CommandLine(new NarrativeCommand());
    boolean hasOutputOption = commandLine.getCommandSpec().optionsMap().containsKey("-output");
    assertThat(hasOutputOption).isTrue();
  }
}
