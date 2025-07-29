package org.hl7.fhir.validation.cli.picocli.options;

import org.hl7.fhir.validation.cli.param.Params;
import picocli.CommandLine;

import java.util.Locale;

public class LocaleOptions implements GlobalOptions{
  @CommandLine.Option(names = {"-locale"}, description = "The locale. Specified by a valid IETF BCP 47 language tag (en-US, fr-FR, etc.")
  String locale;

  @Override
  public void apply(CommandLine.ParseResult parseResult) {
    if (!parseResult.hasMatchedOption(Params.LOCALE)) {
      return;
    }
    String languageTag = parseResult.matchedOptionValue(Params.LOCALE, null);
    Locale locale = Locale.forLanguageTag(languageTag);
    Locale.setDefault(locale);
  }
}
