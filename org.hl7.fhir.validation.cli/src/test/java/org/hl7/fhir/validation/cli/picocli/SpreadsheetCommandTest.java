package org.hl7.fhir.validation.cli.picocli;

import org.hl7.fhir.validation.cli.picocli.commands.SpreadsheetCommand;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.assertj.core.api.Assertions.assertThat;

public class SpreadsheetCommandTest {

  @Test
  public void testCommandName() {
    CommandLine commandLine = new CommandLine(new SpreadsheetCommand());
    assertThat(commandLine.getCommandName()).isEqualTo("spreadsheet");
  }

  @Test
  public void testCommandIsHidden() {
    CommandLine commandLine = new CommandLine(new SpreadsheetCommand());
    assertThat(commandLine.getCommandSpec().usageMessage().hidden()).isTrue();
  }

  @Test
  public void testCommandHasOutputOption() {
    CommandLine commandLine = new CommandLine(new SpreadsheetCommand());
    boolean hasOutputOption = commandLine.getCommandSpec()
      .optionsMap().containsKey("-output");
    assertThat(hasOutputOption).isTrue();
  }

  @Test
  public void testOutputOptionIsOptional() {
    CommandLine commandLine = new CommandLine(new SpreadsheetCommand());
    CommandLine.Model.OptionSpec outputOption = commandLine.getCommandSpec()
      .optionsMap().get("-output");
    assertThat(outputOption.required()).isFalse();
  }

  @Test
  public void testCommandHasSourcesParameter() {
    CommandLine commandLine = new CommandLine(new SpreadsheetCommand());
    assertThat(commandLine.getCommandSpec().positionalParameters()).isNotEmpty();
  }
}
