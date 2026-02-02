package org.hl7.fhir.validation.cli.picocli;

import org.hl7.fhir.validation.cli.picocli.commands.LangRegenerateCommand;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.assertj.core.api.Assertions.assertThat;

public class LangRegenerateCommandTest {

  @Test
  public void testCommandExists() {
    // Basic smoke test to verify command class is properly structured
    LangRegenerateCommand command = new LangRegenerateCommand();
    assertThat(command).isNotNull();
  }

  @Test
  public void testCommandIsHidden() {
    // Verify the command is marked as hidden
    CommandLine commandLine = new CommandLine(new LangRegenerateCommand());
    assertThat(commandLine.getCommandSpec().usageMessage().hidden()).isTrue();
  }

  @Test
  public void testCommandName() {
    // Verify the command has the correct name
    CommandLine commandLine = new CommandLine(new LangRegenerateCommand());
    assertThat(commandLine.getCommandName()).isEqualTo("lang-regen");
  }

  @Test
  public void testCommandHasThreeParameters() {
    // Verify the command has exactly 3 positional parameters
    CommandLine commandLine = new CommandLine(new LangRegenerateCommand());
    long parameterCount = commandLine.getCommandSpec().positionalParameters().size();
    assertThat(parameterCount).isEqualTo(3);
  }
}
