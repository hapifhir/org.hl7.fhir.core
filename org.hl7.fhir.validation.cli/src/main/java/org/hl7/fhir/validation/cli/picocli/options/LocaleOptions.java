package org.hl7.fhir.validation.cli.picocli.options;

import org.hl7.fhir.validation.cli.param.parsers.GlobalParametersParser;
import picocli.CommandLine;

import java.util.Locale;

public class LocaleOptions implements GlobalOptions{
  @CommandLine.Option(names = {"-locale"}, description = "The locale. Specified by a valid IETF BCP 47 language tag (en-US, fr-FR, etc.)")
  String locale;

  @Override
  public int apply(CommandLine.ParseResult parseResult) {
    if (!parseResult.hasMatchedOption(GlobalParametersParser.LOCALE)) {
      return 0;
    }
    String languageTag = parseResult.matchedOptionValue(GlobalParametersParser.LOCALE, null);
    Locale forLanguageTag = Locale.forLanguageTag(languageTag);
    Locale.setDefault(forLanguageTag);
    return 0;
  }
}
