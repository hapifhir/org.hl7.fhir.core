package org.hl7.fhir.utilities.i18n;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.annotation.Nonnull;

import org.junit.jupiter.api.Test;

public class I18nCoverageTest {



  final Set<Locale> locales = Set.of(
    Locale.ENGLISH,
    Locale.GERMAN,
    Locale.forLanguageTag("es"),
    Locale.forLanguageTag("nl"),
    Locale.forLanguageTag("ja")
  );

  @Test
  public void testCoverage() throws IllegalAccessException {

    Field[] fields = I18nConstants.class.getDeclaredFields();
    Map<Locale, I18nBase> testClassMap = new HashMap<>();

    for (Locale locale : locales) {
      testClassMap.put(locale, getI18nTestClass(locale));
    }

    Set<String> messages = new HashSet<>();

    for (Field field : fields) {
      String message = (String)field.get(new String());
      messages.add(message);
      if (field.getType() == String.class) {
       Map<Locale, Boolean> isSingularPhrase = new HashMap<>();
        Map<Locale, Boolean> isPluralPhrase = new HashMap<>();

        for (Locale locale : locales) {
          I18nBase base = testClassMap.get(locale);


          isSingularPhrase.put(locale, base.messageKeyExistsForLocale(message));
          isPluralPhrase.put(locale, existsAsPluralPhrase(base, message));
        }

        assertPhraseTypeAgreement(field, isSingularPhrase, isPluralPhrase);
        logMissingPhrases(field, isSingularPhrase, isPluralPhrase);
      }
    }

    for (Locale locale : locales) {
      ResourceBundle i18nMessages = ResourceBundle.getBundle("Messages", locale);
      for (String message : i18nMessages.keySet()) {
        boolean mapsToConstant = messages.contains(message);
        boolean mapsToPluralPhrase = mapsToPluralPhrase(messages, message, testClassMap.get(locale));
        if (!(mapsToConstant || mapsToPluralPhrase)) {
          System.err.println("Message " + message + " in " + locale.getLanguage() + " properties resource does not have a matching entry in " + I18nConstants.class.getName() );
        }
      }
    }

  }

  private boolean mapsToPluralPhrase(Set<String> messages, String message, I18nBase base) {
    String rootKey = base.getRootKeyFromPlural(message);
    if (rootKey != null) {
      return messages.contains(rootKey);
    }
    return false;
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
      System.err.println("Constant " + field.getName() + " does not exist in any I18n property definition");
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
        System.err.println("Constant " + field.getName() + " is missing in I18n " + phraseType + " phrase property definition for locale " + locale.getLanguage());
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
