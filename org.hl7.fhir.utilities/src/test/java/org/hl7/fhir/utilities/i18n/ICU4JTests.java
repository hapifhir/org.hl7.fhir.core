package org.hl7.fhir.utilities.i18n;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.ibm.icu.text.PluralRules;

public class ICU4JTests {

  static final String[] EN_KEYWORDS = {
    PluralRules.KEYWORD_ONE,
    PluralRules.KEYWORD_OTHER
  };

  @Test
  void getEnLocalePlurals() {
    final Set<String> keywords = getPluralKeywords(Locale.ENGLISH);
    assertEquals(keywords, new HashSet<String>(Arrays.asList(EN_KEYWORDS)));
  }

  static final String[] DE_KEYWORDS = {
    PluralRules.KEYWORD_ONE,
    PluralRules.KEYWORD_OTHER
  };

  @Test
  void getDeLocalePlurals() {
    final Set<String> keywords = getPluralKeywords(Locale.GERMAN);
    assertEquals(keywords, new HashSet<String>(Arrays.asList(DE_KEYWORDS)));
  }

  static final String[] NL_KEYWORDS = {
    PluralRules.KEYWORD_ONE,
    PluralRules.KEYWORD_OTHER
  };

  @Test
  void getNlLocalePlurals() {
    final Set<String> keywords = getPluralKeywords(Locale.forLanguageTag("nl"));
    assertEquals(keywords, new HashSet<String>(Arrays.asList(NL_KEYWORDS)));
  }

  private static Set<String> getPluralKeywords(Locale locale) {
    final PluralRules pluralRules = PluralRules.forLocale(locale);
    return pluralRules.getKeywords();
  }
}
