package org.hl7.fhir.utilities.i18n;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class I18nCoverageTest {

  private final Logger logger = LoggerFactory.getLogger(I18nCoverageTest.class);

  final Set<Locale> locales = Set.of(
    Locale.ENGLISH,
    Locale.GERMAN,
    Locale.forLanguageTag("es"),
    Locale.forLanguageTag("nl")
  );

  @Test
  public void testCoverage() throws IllegalAccessException {
    Field[] fields = I18nConstants.class.getDeclaredFields();
    Map<Locale, I18nBase> testClassMap = new HashMap<>();

    for (Locale locale : locales) {
      testClassMap.put(locale, getI18nTestClass(locale));
    }

    for (Field field : fields) {
      if (field.getType() == String.class) {
       Map<Locale, Boolean> isSingularPhrase = new HashMap<>();
        Map<Locale, Boolean> isPluralPhrase = new HashMap<>();

        for (Locale locale : locales) {
          I18nBase base = testClassMap.get(locale);
          String message = (String)field.get(new String());

          isSingularPhrase.put(locale, base.messageKeyExistsForLocale(message));
          isPluralPhrase.put(locale, existsAsPluralPhrase(base, message));
        }

        assertPhraseTypeAgreement(field, isSingularPhrase, isPluralPhrase);
        logMissingPhrases(field, isSingularPhrase, isPluralPhrase);
      }
    }
  }

  private void assertPhraseTypeAgreement(Field field,
    Map<Locale, Boolean> isSingularPhrase,
    Map<Locale, Boolean> isPluralPhrase) {
    boolean existsAsSingular = isSingularPhrase.values().stream().anyMatch(value -> value == true);
    boolean existsAsPlural = isPluralPhrase.values().stream().anyMatch(value -> value == true);
    assertTrue(
      //The phrase might not exist
      (existsAsPlural == false && existsAsSingular == false)
      // But if it does exist, it must consistently be of singular or plural
        || existsAsPlural ^ existsAsSingular,
      "Constant " + field.getName() + " has inconsistent plural properties in I18n property definitions: " + pluralPropertySummary(isSingularPhrase, isPluralPhrase));
  }

  private void logMissingPhrases(Field field,
                                 Map<Locale, Boolean> isSingularPhrase,
                                 Map<Locale, Boolean> isPluralPhrase) {
    boolean existsAsSingular = isSingularPhrase.values().stream().anyMatch(value -> value == true);
    boolean existsAsPlural = isPluralPhrase.values().stream().anyMatch(value -> value == true);
    boolean existsInSomeLanguage = existsAsSingular
      || existsAsPlural;
    if (!existsInSomeLanguage) {
      logger.warn("Constant " + field.getName() + " does not exist in any I18n property definition");
      return;
    };
    if (existsAsSingular) {
      logMissingPhrases(field, isSingularPhrase, "singular");
    }
    if (existsAsPlural) {
      logMissingPhrases(field, isPluralPhrase, "plural");
    }
  }

  private void logMissingPhrases(Field field, Map<Locale, Boolean> phraseMap, String phraseType) {
    for (Locale locale : locales) {
      if (!phraseMap.get(locale)) {
        logger.warn("Constant " + field.getName() + " is missing in I18n " + phraseType + " phrase property definition for locale " + locale.getLanguage());
      }
    }
  }

  private String pluralPropertySummary( Map<Locale, Boolean> isSingularPhrase,
                                        Map<Locale, Boolean> isPluralPhrase) {
    StringBuilder stringBuilder = new StringBuilder();
    for (Locale locale : locales) {
      stringBuilder.append("locale: " + locale.getDisplayName() + " singular:" + isSingularPhrase.get(locale) + " plural: " + isPluralPhrase.get(locale) + ";");
    }
    return stringBuilder.toString();
  }
  @Nonnull
  private static I18nTestClass getI18nTestClass(Locale locale) {
    I18nTestClass testClass = new I18nTestClass();
    testClass.setLocale(locale);
    testClass.setPluralRules(locale);
    return testClass;
  }

  private boolean existsAsPluralPhrase(I18nBase base, String message) {
    final Set<String> pluralKeys = base.getPluralKeys(message);
    int found = 0;
    for (String pluralKey : pluralKeys) {
      if (base.messageKeyExistsForLocale(pluralKey)) {
        found++;
      }
    }
    assertFalse(found > 0 && found != pluralKeys.size(), "Incomplete plural definition for base key: " + message + " in locale " + base.getLocale().getLanguage() + ". Expected entries for " + base.getPluralKeys(message));

    return found > 0;
  }

}
