package org.hl7.fhir.validation.cli.picocli.options;

import picocli.CommandLine;

public class DebugOptions implements GlobalOptions {
  @CommandLine.Option(names = {"-locale"}, description = "The locale. Specified by a valid IETF BCP 47 language tag (en-US, fr-FR, etc.")
  String locale;

  @Override
  public void apply(CommandLine.ParseResult parseResult) {

  }
}
