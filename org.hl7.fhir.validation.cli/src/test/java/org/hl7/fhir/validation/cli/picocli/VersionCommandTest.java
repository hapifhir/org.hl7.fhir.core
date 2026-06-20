package org.hl7.fhir.validation.cli.picocli;

import org.hl7.fhir.validation.cli.picocli.commands.VersionCommand;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.assertj.core.api.Assertions.assertThat;

public class VersionCommandTest {

  @Test
  public void testCommandName() {
    CommandLine commandLine = new CommandLine(new VersionCommand());
    assertThat(commandLine.getCommandName()).isEqualTo("to-version");
  }

  @Test
  public void testCommandIsNotHidden() {
    CommandLine commandLine = new CommandLine(new VersionCommand());
    assertThat(commandLine.getCommandSpec().usageMessage().hidden()).isFalse();
  }

  @Test
  public void testCommandHasOutputOption() {
    CommandLine commandLine = new CommandLine(new VersionCommand());
    boolean hasOption = commandLine.getCommandSpec()
      .optionsMap().containsKey("-output");
    assertThat(hasOption).isTrue();
  }

  @Test
  public void testOutputOptionIsOptional() {
    CommandLine commandLine = new CommandLine(new VersionCommand());
    CommandLine.Model.OptionSpec option = commandLine.getCommandSpec()
      .optionsMap().get("-output");
    assertThat(option.required()).isFalse();
  }

  @Test
  public void testCommandHasDoNativeOption() {
    CommandLine commandLine = new CommandLine(new VersionCommand());
    boolean hasOption = commandLine.getCommandSpec()
      .optionsMap().containsKey("-do-native");
    assertThat(hasOption).isTrue();
  }

  @Test
  public void testDoNativeOptionIsOptional() {
    CommandLine commandLine = new CommandLine(new VersionCommand());
    CommandLine.Model.OptionSpec option = commandLine.getCommandSpec()
      .optionsMap().get("-do-native");
    assertThat(option.required()).isFalse();
  }

  @Test
  public void testCommandHasNoNativeOption() {
    CommandLine commandLine = new CommandLine(new VersionCommand());
    boolean hasOption = commandLine.getCommandSpec()
      .optionsMap().containsKey("-no-native");
    assertThat(hasOption).isTrue();
  }

  @Test
  public void testNoNativeOptionIsOptional() {
    CommandLine commandLine = new CommandLine(new VersionCommand());
    CommandLine.Model.OptionSpec option = commandLine.getCommandSpec()
      .optionsMap().get("-no-native");
    assertThat(option.required()).isFalse();
  }
}
