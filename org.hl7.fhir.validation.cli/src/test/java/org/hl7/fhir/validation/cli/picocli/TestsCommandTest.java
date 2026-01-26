package org.hl7.fhir.validation.cli.picocli;

import org.hl7.fhir.validation.cli.picocli.commands.TestsCommand;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.assertj.core.api.Assertions.assertThat;

public class TestsCommandTest {

  @Test
  public void testCommandName() {
    CommandLine commandLine = new CommandLine(new TestsCommand());
    assertThat(commandLine.getCommandName()).isEqualTo("tests");
  }

  @Test
  public void testCommandIsNotHidden() {
    CommandLine commandLine = new CommandLine(new TestsCommand());
    assertThat(commandLine.getCommandSpec().usageMessage().hidden()).isFalse();
  }

  @Test
  public void testCommandHasTestCasesDirectoryParameter() {
    CommandLine commandLine = new CommandLine(new TestsCommand());
    assertThat(commandLine.getCommandSpec().positionalParameters()).isNotEmpty();
  }

  @Test
  public void testCommandHasTestModulesOption() {
    CommandLine commandLine = new CommandLine(new TestsCommand());
    boolean hasOption = commandLine.getCommandSpec()
      .optionsMap().containsKey("-test-modules");
    assertThat(hasOption).isTrue();
  }

  @Test
  public void testCommandHasTestClassnameFilterOption() {
    CommandLine commandLine = new CommandLine(new TestsCommand());
    boolean hasOption = commandLine.getCommandSpec()
      .optionsMap().containsKey("-test-classname-filter");
    assertThat(hasOption).isTrue();
  }

  @Test
  public void testCommandHasTxCacheOption() {
    CommandLine commandLine = new CommandLine(new TestsCommand());
    boolean hasOption = commandLine.getCommandSpec()
      .optionsMap().containsKey("-txCache");
    assertThat(hasOption).isTrue();
  }

  @Test
  public void testTestModulesOptionIsOptional() {
    CommandLine commandLine = new CommandLine(new TestsCommand());
    CommandLine.Model.OptionSpec option = commandLine.getCommandSpec()
      .optionsMap().get("-test-modules");
    assertThat(option.required()).isFalse();
  }

  @Test
  public void testTestClassnameFilterOptionIsOptional() {
    CommandLine commandLine = new CommandLine(new TestsCommand());
    CommandLine.Model.OptionSpec option = commandLine.getCommandSpec()
      .optionsMap().get("-test-classname-filter");
    assertThat(option.required()).isFalse();
  }
}
