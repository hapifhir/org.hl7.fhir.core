package org.hl7.fhir.validation.cli.picocli;

import org.hl7.fhir.validation.cli.picocli.commands.HTTPClientCommand;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for HTTPClientCommand.
 *
 * Tests verify that the command is properly configured with Picocli annotations
 * and behaves correctly as a stub/placeholder command.
 */
public class HTTPClientCommandTest {

  @Test
  public void testCommandExists() {
    // Basic smoke test to verify command class is properly structured
    HTTPClientCommand command = new HTTPClientCommand();
    assertThat(command).isNotNull();
  }

  @Test
  public void testCommandName() {
    // Verify the command has the correct name
    CommandLine commandLine = new CommandLine(new HTTPClientCommand());
    assertThat(commandLine.getCommandName()).isEqualTo("client");
  }

  @Test
  public void testCommandIsNotHidden() {
    // Verify the command is not hidden (public command)
    CommandLine commandLine = new CommandLine(new HTTPClientCommand());
    assertThat(commandLine.getCommandSpec().usageMessage().hidden()).isFalse();
  }

  @Test
  public void testNoSourcesReturnsZero() {
    // Verify no validations return success (exit code 0)
    CommandLine cmd = new CommandLine(new HTTPClientCommand());
    Integer result = cmd.execute(new String[0]);
    assertThat(result).isEqualTo(0);
  }
}
