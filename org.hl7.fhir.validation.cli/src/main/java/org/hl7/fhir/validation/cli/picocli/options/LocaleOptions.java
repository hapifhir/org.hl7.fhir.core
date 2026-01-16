package org.hl7.fhir.validation.cli.picocli.options;

import picocli.CommandLine;

import java.util.Locale;

public class LocaleOptions {
  @CommandLine.Option(names = {"-locale"}, description = "The locale. Specified by a valid IETF BCP 47 language tag (en-US, fr-FR, etc.)", scope = CommandLine.ScopeType.INHERIT)
  public void setLocale(String languageTag) {
    Locale forLanguageTag = Locale.forLanguageTag(languageTag);
    Locale.setDefault(forLanguageTag);
  }
}
