package org.hl7.fhir.validation.cli.picocli;

import org.hl7.fhir.validation.cli.picocli.commands.CodeGenCommand;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.assertj.core.api.Assertions.assertThat;

public class CodeGenCommandTest {

  @Test
  public void testCommandName() {
    CommandLine commandLine = new CommandLine(new CodeGenCommand());
    assertThat(commandLine.getCommandName()).isEqualTo("codegen");
  }

  @Test
  public void testCommandIsHidden() {
    CommandLine commandLine = new CommandLine(new CodeGenCommand());
    assertThat(commandLine.getCommandSpec().usageMessage().hidden()).isTrue();
  }

  @Test
  public void testCommandHasPackageNameOption() {
    CommandLine commandLine = new CommandLine(new CodeGenCommand());
    boolean hasOption = commandLine.getCommandSpec()
      .optionsMap().containsKey("-package-name");
    assertThat(hasOption).isTrue();
  }

  @Test
  public void testPackageNameOptionIsRequired() {
    CommandLine commandLine = new CommandLine(new CodeGenCommand());
    CommandLine.Model.OptionSpec option = commandLine.getCommandSpec()
      .optionsMap().get("-package-name");
    assertThat(option.required()).isTrue();
  }

  @Test
  public void testCommandHasOutputOption() {
    CommandLine commandLine = new CommandLine(new CodeGenCommand());
    boolean hasOption = commandLine.getCommandSpec()
      .optionsMap().containsKey("-output");
    assertThat(hasOption).isTrue();
  }

  @Test
  public void testOutputOptionIsRequired() {
    CommandLine commandLine = new CommandLine(new CodeGenCommand());
    CommandLine.Model.OptionSpec option = commandLine.getCommandSpec()
      .optionsMap().get("-output");
    assertThat(option.required()).isTrue();
  }

  @Test
  public void testCommandHasOptionParameter() {
    CommandLine commandLine = new CommandLine(new CodeGenCommand());
    boolean hasOption = commandLine.getCommandSpec()
      .optionsMap().containsKey("-option");
    assertThat(hasOption).isTrue();
  }

  @Test
  public void testOptionParameterIsOptional() {
    CommandLine commandLine = new CommandLine(new CodeGenCommand());
    CommandLine.Model.OptionSpec option = commandLine.getCommandSpec()
      .optionsMap().get("-option");
    assertThat(option.required()).isFalse();
  }
}
