package org.hl7.fhir.validation.cli.picocli;

import org.hl7.fhir.validation.cli.picocli.commands.InstanceFactoryCommand;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.assertj.core.api.Assertions.assertThat;

public class InstanceFactoryCommandTest {

  @Test
  public void testCommandExists() {
    InstanceFactoryCommand command = new InstanceFactoryCommand();
    assertThat(command).isNotNull();
  }

  @Test
  public void testCommandName() {
    CommandLine commandLine = new CommandLine(new InstanceFactoryCommand());
    assertThat(commandLine.getCommandName()).isEqualTo("instance-factory");
  }

  @Test
  public void testCommandIsHidden() {
    CommandLine commandLine = new CommandLine(new InstanceFactoryCommand());
    assertThat(commandLine.getCommandSpec().usageMessage().hidden()).isTrue();
  }

  @Test
  public void testGetInstanceValidatorParametersReturnsNull() {
    InstanceFactoryCommand command = new InstanceFactoryCommand();
    assertThat(command.getInstanceValidatorParameters()).isNull();
  }

  @Test
  public void testGetSourcesReturnsEmptyList() {
    InstanceFactoryCommand command = new InstanceFactoryCommand();
    assertThat(command.getSources()).isEmpty();
  }
}
