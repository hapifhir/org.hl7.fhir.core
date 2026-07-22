package org.hl7.fhir.validation.cli.picocli;

import org.hl7.fhir.validation.cli.picocli.commands.TxTestsCommand;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.assertj.core.api.Assertions.assertThat;

public class TxTestsCommandTest {

  @Test
  public void testCommandName() {
    CommandLine commandLine = new CommandLine(new TxTestsCommand());
    assertThat(commandLine.getCommandName()).isEqualTo("txTests");
  }

  @Test
  public void testCommandIsHidden() {
    CommandLine commandLine = new CommandLine(new TxTestsCommand());
    assertThat(commandLine.getCommandSpec().usageMessage().hidden()).isTrue();
  }

  @Test
  public void testCommandHasOutputOption() {
    CommandLine commandLine = new CommandLine(new TxTestsCommand());
    boolean hasOption = commandLine.getCommandSpec()
      .optionsMap().containsKey("-output");
    assertThat(hasOption).isTrue();
  }

  @Test
  public void testCommandHasTestVersionOption() {
    CommandLine commandLine = new CommandLine(new TxTestsCommand());
    boolean hasOption = commandLine.getCommandSpec()
      .optionsMap().containsKey("-test-version");
    assertThat(hasOption).isTrue();
  }

  @Test
  public void testCommandHasVersionOption() {
    // -version is the name documented in the tx-ecosystem IG (testcases.md);
    // it is an alias for -test-version
    CommandLine commandLine = new CommandLine(new TxTestsCommand());
    boolean hasOption = commandLine.getCommandSpec()
      .optionsMap().containsKey("-version");
    assertThat(hasOption).isTrue();
  }

  @Test
  public void testCommandHasTxOption() {
    CommandLine commandLine = new CommandLine(new TxTestsCommand());
    boolean hasOption = commandLine.getCommandSpec()
      .optionsMap().containsKey("-tx");
    assertThat(hasOption).isTrue();
  }

  @Test
  public void testCommandHasFilterOption() {
    CommandLine commandLine = new CommandLine(new TxTestsCommand());
    boolean hasOption = commandLine.getCommandSpec()
      .optionsMap().containsKey("-filter");
    assertThat(hasOption).isTrue();
  }

  @Test
  public void testCommandHasSuiteOption() {
    CommandLine commandLine = new CommandLine(new TxTestsCommand());
    boolean hasOption = commandLine.getCommandSpec()
      .optionsMap().containsKey("-suite");
    assertThat(hasOption).isTrue();
  }

  @Test
  public void testCommandHasExternalsOption() {
    CommandLine commandLine = new CommandLine(new TxTestsCommand());
    boolean hasOption = commandLine.getCommandSpec()
      .optionsMap().containsKey("-externals");
    assertThat(hasOption).isTrue();
  }

  @Test
  public void testCommandHasInputOption() {
    CommandLine commandLine = new CommandLine(new TxTestsCommand());
    boolean hasOption = commandLine.getCommandSpec()
      .optionsMap().containsKey("-input");
    assertThat(hasOption).isTrue();
  }

  @Test
  public void testCommandHasModeOption() {
    CommandLine commandLine = new CommandLine(new TxTestsCommand());
    boolean hasOption = commandLine.getCommandSpec()
      .optionsMap().containsKey("-mode");
    assertThat(hasOption).isTrue();
  }

  @Test
  public void testModeOptionSplitsOnCommas() {
    // testcases.md in the tx-ecosystem IG says multiple modes are passed
    // separated by commas
    CommandLine commandLine = new CommandLine(new TxTestsCommand());
    CommandLine.Model.OptionSpec option = commandLine.getCommandSpec()
      .optionsMap().get("-mode");
    assertThat(option.splitRegex()).isEqualTo(",");
  }

  @Test
  public void testOutputOptionIsOptional() {
    CommandLine commandLine = new CommandLine(new TxTestsCommand());
    CommandLine.Model.OptionSpec option = commandLine.getCommandSpec()
      .optionsMap().get("-output");
    assertThat(option.required()).isFalse();
  }
}
