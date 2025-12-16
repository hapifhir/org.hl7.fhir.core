package org.hl7.fhir.validation.cli.picocli;

import org.hl7.fhir.validation.cli.picocli.commands.PreloadCacheCommand;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.assertj.core.api.Assertions.assertThat;

public class PreloadCacheCommandTest {

  @Test
  public void testCommandExists() {
    // Basic smoke test to verify command class is properly structured
    PreloadCacheCommand command = new PreloadCacheCommand();
    assertThat(command).isNotNull();
  }

  @Test
  public void testCommandName() {
    // Verify the command has the correct name
    CommandLine commandLine = new CommandLine(new PreloadCacheCommand());
    assertThat(commandLine.getCommandName()).isEqualTo("preloadCache");
  }

  @Test
  public void testCommandIsHidden() {
    // Verify the command is marked as hidden
    CommandLine commandLine = new CommandLine(new PreloadCacheCommand());
    assertThat(commandLine.getCommandSpec().usageMessage().hidden()).isTrue();
  }

  @Test
  public void testCommandHasNoParameters() {
    // Verify the command has no positional parameters
    CommandLine commandLine = new CommandLine(new PreloadCacheCommand());
    assertThat(commandLine.getCommandSpec().positionalParameters()).isEmpty();
  }
}
