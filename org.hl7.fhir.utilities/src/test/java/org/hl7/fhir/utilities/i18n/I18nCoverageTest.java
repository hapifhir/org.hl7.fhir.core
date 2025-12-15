package org.hl7.fhir.utilities.i18n;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.*;

import javax.annotation.Nonnull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class I18nCoverageTest {

  private static class I18nCoverage {
    final Set<String> englishKeys = new HashSet<>();
    final Set<String> englishPluralKeys = new HashSet<>();
    final HashMap<Locale, Integer> foundKeys = new HashMap<>();
    final HashMap<Locale, Integer> foundPluralKeys = new HashMap<>();
  }

  final Set<Locale> locales = Set.of(
    Locale.ENGLISH,
    Locale.GERMAN,
    Locale.forLanguageTag("es"),
    Locale.forLanguageTag("nl"),
    Locale.forLanguageTag("ja"),
    Locale.forLanguageTag("pt")
  );

  final Locale sourceLocale = Locale.ENGLISH;

  @Test
  public void testPhraseCoverage() {
    assertDoesNotThrow(() -> {
      I18nCoverage messages = getI18nCoverage("Messages");
      I18nCoverage renderingPhrases = getI18nCoverage("rendering-phrases");

      PrintStream out = getCSVOutputStream();
      printPhraseCoverageCSV(out, List.of(messages, renderingPhrases));
    });
  }

  private I18nCoverage getI18nCoverage(String messageFilePrefix) throws IOException {
    I18nCoverage i18nCoverage = new I18nCoverage();

    Properties englishMessages = new Properties();
    englishMessages.load(I18nTestClass.class.getClassLoader().getResourceAsStream(messageFilePrefix + ".properties"));

    I18nTestClass englishTestClass = getI18nTestClass(Locale.ENGLISH);
    Set<String> englishPluralSuffixes = englishTestClass.getPluralSuffixes();

    for (Object objectKey : englishMessages.keySet()) {
      String key = (String) objectKey;
      if (isPluralKey(key, englishPluralSuffixes)) {
        final String pluralKeyRoot = getPluralKeyRoot(key, englishPluralSuffixes);
        i18nCoverage.englishPluralKeys.add(pluralKeyRoot);
      } else {
        i18nCoverage.englishKeys.add(key);
      }
    }

    for (Locale locale : locales) {
      if (!locale.equals(sourceLocale)) {
        Properties translatedMessages = new Properties();
        translatedMessages.load(I18nTestClass.class.getClassLoader().getResourceAsStream(messageFilePrefix + "_" + locale.toString() + ".properties"));
        I18nTestClass translatedTestClass = getI18nTestClass(sourceLocale);
        Set<String> translatedPluralSuffixes = translatedTestClass.getPluralSuffixes();

        Set<String> translatedPluralKeys = new HashSet<>();
        Set<String> translatedKeys = new HashSet<>();

        for (Object objectKey : translatedMessages.keySet()) {
          String key = (String) objectKey;
          Object value = translatedMessages.get(objectKey);
          if (
            value instanceof String &&
              !((String) value).trim().isEmpty()) {
            if (isPluralKey(key, translatedPluralSuffixes)) {
              final String pluralKeyRoot = getPluralKeyRoot(key, englishPluralSuffixes);
              translatedPluralKeys.add(pluralKeyRoot);
            } else {
              translatedKeys.add(key);
            }
          }
        }

        Set<String> intersectionKeys = new HashSet<>(i18nCoverage.englishKeys);
        intersectionKeys.retainAll(translatedKeys);
        Set<String> intersectionPluralKeys = new HashSet<>(i18nCoverage.englishPluralKeys);
        intersectionPluralKeys.retainAll(translatedPluralKeys);

        Set<String> missingKeys = new HashSet<>(i18nCoverage.englishKeys);
        Set<String> missingPluralKeys = new HashSet<>(i18nCoverage.englishPluralKeys);

        missingKeys.removeAll(translatedKeys);
        missingPluralKeys.removeAll(translatedPluralKeys);

        i18nCoverage.foundKeys.put(locale, intersectionKeys.size());
        i18nCoverage.foundPluralKeys.put(locale, intersectionPluralKeys.size());

        for (String missingKey : missingKeys) {
          System.err.println("Missing key for locale " + locale + ": " + missingKey);
        }
        for (String missingPluralKey : missingPluralKeys) {
          System.err.println("Missing plural key for locale " + locale + ": " + missingPluralKey);
        }
      }
    }
    return i18nCoverage;
  }

  private static PrintStream getCSVOutputStream() throws FileNotFoundException {
    String outputFile = System.getenv("I18N_COVERAGE_FILE");

    return outputFile == null
      ? System.out
      : new PrintStream(new File(outputFile));
  }

  private void printPhraseCoverageCSV(PrintStream out, List<I18nCoverage> i18nCoverageList) {
    out.println("Locale,Coverage #,Coverage %");

    List<Locale> sortedLocales = new ArrayList<>(locales);
    sortedLocales.sort(Comparator.comparing(Locale::toString));

    for (Locale locale : sortedLocales) {
      if (!locale.equals(sourceLocale)) {
        int count = 0;
        int total = 0;
        for (I18nCoverage i18nCoverage : i18nCoverageList) {
          int singleCount = i18nCoverage.foundKeys.get(locale);
          int pluralCount = i18nCoverage.foundPluralKeys.get(locale);
          count += singleCount + pluralCount;
          total += i18nCoverage.englishKeys.size() + i18nCoverage.englishPluralKeys.size();
        }
        out.println(locale + "," + count + "," + getPercent(count, total));
      }
    }
  }

  private static String getPercent(int numerator, int denominator) {
    return (int) (((double) numerator / denominator) * 100) + "%";
  }

  private String getPluralKeyRoot(String key, Set<String> pluralKeys) {
    for (String pluralKey : pluralKeys) {
      final String suffix = I18nBase.KEY_DELIMITER + pluralKey;
      if (key.endsWith(suffix)) {
        return key.substring(0, key.lastIndexOf(suffix));
      }
    }
    throw new IllegalArgumentException(key + " does not terminate with a plural suffix. Available: " + pluralKeys);
  }

  private boolean isPluralKey(String key, Set<String> pluralKeys) {
    for (String pluralKey : pluralKeys) {
      if (key.endsWith(I18nBase.KEY_DELIMITER + pluralKey)) {
        return true;
      }
    }
    return false;
  }

  @Test
  @Disabled
  public void testConstantsCoverage() throws IllegalAccessException {

    Field[] fields = I18nConstants.class.getDeclaredFields();
    Map<Locale, I18nBase> testClassMap = new HashMap<>();

    for (Locale locale : locales) {
      testClassMap.put(locale, getI18nTestClass(locale));
    }

    Set<String> messages = new HashSet<>();

    for (Field field : fields) {
      String message = (String) field.get(new String());
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
          System.err.println("Message " + message + " in " + locale.getLanguage() + " properties resource does not have a matching entry in " + I18nConstants.class.getName());
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
    }
    ;
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

  private String pluralPropertySummary(Map<Locale, Boolean> isSingularPhrase,
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
