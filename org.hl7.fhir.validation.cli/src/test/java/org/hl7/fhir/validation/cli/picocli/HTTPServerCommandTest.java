package org.hl7.fhir.validation.cli.picocli;

import org.hl7.fhir.validation.cli.picocli.commands.HTTPServerCommand;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for HTTPServerCommand.
 *
 * Tests verify that the command is properly configured with Picocli annotations
 * and has the required options.
 */
public class HTTPServerCommandTest {

  @Test
  public void testCommandExists() {
    // Basic smoke test to verify command class is properly structured
    HTTPServerCommand command = new HTTPServerCommand();
    assertThat(command).isNotNull();
  }

  @Test
  public void testCommandName() {
    // Verify the command has the correct name
    CommandLine commandLine = new CommandLine(new HTTPServerCommand());
    assertThat(commandLine.getCommandName()).isEqualTo("server");
  }

  @Test
  public void testCommandIsNotHidden() {
    // Verify the command is not hidden (public command)
    CommandLine commandLine = new CommandLine(new HTTPServerCommand());
    assertThat(commandLine.getCommandSpec().usageMessage().hidden()).isFalse();
  }

  @Test
  public void testGetInstanceValidatorParameters() {
    // Verify that instance validator parameters are handled
    // The command should return a non-null InstanceValidatorParameters object
    HTTPServerCommand command = new HTTPServerCommand();
    assertThat(command.getInstanceValidatorParameters()).isNotNull();
  }

  @Test
  public void testGetSourcesReturnsEmptyList() {
    // Server command doesn't validate sources, so should return empty list
    HTTPServerCommand command = new HTTPServerCommand();
    assertThat(command.getSources()).isEmpty();
  }
}
