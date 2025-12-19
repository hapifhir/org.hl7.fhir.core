package org.hl7.fhir.validation.cli.picocli;

import org.hl7.fhir.validation.cli.picocli.commands.AiTestsCommand;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.assertj.core.api.Assertions.assertThat;

public class AiTestsCommandTest {

  @Test
  public void testCommandName() {
    CommandLine commandLine = new CommandLine(new AiTestsCommand());
    assertThat(commandLine.getCommandName()).isEqualTo("aiTests");
  }

  @Test
  public void testCommandIsHidden() {
    CommandLine commandLine = new CommandLine(new AiTestsCommand());
    assertThat(commandLine.getCommandSpec().usageMessage().hidden()).isTrue();
  }

  @Test
  public void testCommandHasSourceOption() {
    CommandLine commandLine = new CommandLine(new AiTestsCommand());
    boolean hasOption = commandLine.getCommandSpec()
      .optionsMap().containsKey("-source");
    assertThat(hasOption).isTrue();
  }

  @Test
  public void testSourceOptionIsRequired() {
    CommandLine commandLine = new CommandLine(new AiTestsCommand());
    CommandLine.Model.OptionSpec option = commandLine.getCommandSpec()
      .optionsMap().get("-source");
    assertThat(option.required()).isTrue();
  }

  @Test
  public void testCommandHasConfigOption() {
    CommandLine commandLine = new CommandLine(new AiTestsCommand());
    boolean hasOption = commandLine.getCommandSpec()
      .optionsMap().containsKey("-config");
    assertThat(hasOption).isTrue();
  }

  @Test
  public void testConfigOptionIsOptional() {
    CommandLine commandLine = new CommandLine(new AiTestsCommand());
    CommandLine.Model.OptionSpec option = commandLine.getCommandSpec()
      .optionsMap().get("-config");
    assertThat(option.required()).isFalse();
  }

  @Test
  public void testCommandHasRunTestsOption() {
    CommandLine commandLine = new CommandLine(new AiTestsCommand());
    boolean hasOption = commandLine.getCommandSpec()
      .optionsMap().containsKey("-run-tests");
    assertThat(hasOption).isTrue();
  }

  @Test
  public void testRunTestsOptionIsOptional() {
    CommandLine commandLine = new CommandLine(new AiTestsCommand());
    CommandLine.Model.OptionSpec option = commandLine.getCommandSpec()
      .optionsMap().get("-run-tests");
    assertThat(option.required()).isFalse();
  }
}
