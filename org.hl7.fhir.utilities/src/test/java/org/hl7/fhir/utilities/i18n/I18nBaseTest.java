package org.hl7.fhir.utilities.i18n;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import com.ibm.icu.text.PluralRules;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.Mockito;

class I18nBaseTest {

  public static final String BAD_STRING_ARG = "THIS_DOES_NOT_EXIST";
  public static final String ARG_1 = "test arg";

  @Test
  void testDefaultLocale() {
    I18nTestClass testClass = new I18nTestClass();
    assertEquals(Locale.getDefault(), testClass.getLocale());
    // Intuitively, this is expected to be Locale.getDefault(), BUT Messages.properties has no locale, thus resolves to
    // Locale.ROOT, which is the "" locale.
    assertEquals(Locale.ROOT, testClass.getMessages().getLocale());
    assertEquals(PluralRules.forLocale(Locale.getDefault()), testClass.getPluralRules());
  }

  @Test
  void testSetLocale() {
    I18nTestClass testClass = new I18nTestClass();
    testClass.setLocale(Locale.GERMAN);
    assertEquals(Locale.GERMAN, testClass.getLocale());
    assertEquals(Locale.GERMAN, testClass.getMessages().getLocale());
    assertEquals( PluralRules.forLocale(Locale.GERMAN), testClass.getPluralRules());
  }

  @Test
  void setUnknownLocale() {
    I18nTestClass testClass = new I18nTestClass();
    Locale locale = Locale.forLanguageTag("lv-LV");
    testClass.setLocale(locale);
    assertEquals(locale, testClass.getLocale());
    // Intuitively, this is expected to be Locale.getDefault(), BUT Messages.properties has no locale, thus resolves to
    // Locale.ROOT, which is the "" locale.
    assertEquals(Locale.ROOT, testClass.getMessages().getLocale());
    assertEquals(PluralRules.forLocale(Locale.getDefault()), testClass.getPluralRules());

  }

  @Test
  @DisplayName("Test argument substitution with initializing Locale.")
  void testFormatMessageWithInitLocale() {
    I18nTestClass testClass = new I18nTestClass();
    ResourceBundle loadedBundle = ResourceBundle.getBundle("Messages", Locale.GERMAN);
    testClass.setLocale(Locale.GERMAN);
    String result = testClass.formatMessage(I18nConstants.BUNDLE_BUNDLE_MULTIPLEMATCHES, ARG_1);
    MessageFormat form = new MessageFormat(loadedBundle.getString(I18nConstants.BUNDLE_BUNDLE_MULTIPLEMATCHES));
    Object[] testArgs = {ARG_1};
    assertEquals(form.format(testArgs), result);
  }
  
  @Test
  @DisplayName("Test argument substitution with initializing Locale(Japanese).")
  void testFormatMessageWithInitLocaleJA() {
    I18nTestClass testClass = new I18nTestClass();
    ResourceBundle loadedBundle = ResourceBundle.getBundle("Messages", Locale.JAPANESE);
    testClass.setLocale(Locale.JAPANESE);
    String result = testClass.formatMessage(I18nConstants.BUNDLE_BUNDLE_MULTIPLEMATCHES, ARG_1);
    MessageFormat form = new MessageFormat(loadedBundle.getString(I18nConstants.BUNDLE_BUNDLE_MULTIPLEMATCHES));
    Object[] testArgs = {ARG_1};
    System.out.println(result);
    assertEquals(form.format(testArgs), result);
  }

  @Test
  void testFormatMessageWithEscapedQuotes() {
    assertDoesNotThrow(() -> {
      I18nTestClass testClass = new I18nTestClass();
      ResourceBundle loadedBundle = ResourceBundle.getBundle("Messages", new Locale("pt"));
      testClass.setLocale(new Locale("pt"));
      String result = testClass.formatMessage(I18nConstants.HTA_SCT_MESSAGE, "test");
      MessageFormat form = new MessageFormat(loadedBundle.getString(I18nConstants.HTA_SCT_MESSAGE));
    });
  }

  @Test
  @DisplayName("Test argument substitution without initializing Locale.")
  void testFormatMessageWithoutInitLocale() {
    I18nTestClass testClass = new I18nTestClass();
    ResourceBundle loadedBundle = ResourceBundle.getBundle("Messages", Locale.US);
    String result = testClass.formatMessage(I18nConstants.BUNDLE_BUNDLE_MULTIPLEMATCHES, ARG_1);
    MessageFormat form = new MessageFormat(loadedBundle.getString(I18nConstants.BUNDLE_BUNDLE_MULTIPLEMATCHES));
    Object[] testArgs = {ARG_1};
    assertEquals(form.format(testArgs), result);
  }

  @Test
  @DisplayName("Test pluralization works without initializing Locale.")
  void testFormatMessagePluralWithoutInitLocale() {
    I18nTestClass testClass = new I18nTestClass();

    //Answer value must be of the type {1}
    String resultOne = testClass.formatMessagePlural(1, I18nConstants.QUESTIONNAIRE_QR_ITEM_WRONGTYPE);
    assertThat(resultOne).contains("be of the type");

    //Answer value must be one of the {0} types {1}
    String resultMany = testClass.formatMessagePlural(3, I18nConstants.QUESTIONNAIRE_QR_ITEM_WRONGTYPE);
    assertThat(resultMany).contains("one of the 3 types ");

  }

  @Test
  @DisplayName("Test pluralization works with initializing Locale.")
  void testFormatMessagePluralWithInitLocale() {
    I18nTestClass testClass = new I18nTestClass();

    testClass.setLocale(Locale.GERMAN);
    //Answer value muss vom Typ {0} sein.
    String resultOne = testClass.formatMessagePlural(1, I18nConstants.QUESTIONNAIRE_QR_ITEM_WRONGTYPE);
    assertThat(resultOne).contains("muss vom Typ");

    //Answer value muss einer der Typen {1} sein
    String resultMany = testClass.formatMessagePlural(3, I18nConstants.QUESTIONNAIRE_QR_ITEM_WRONGTYPE);
    assertThat(resultMany).contains("einer der Typen ");

  }

  @Test
  @DisplayName("Assert no string modification is done when no match is found.")
  void testFormatMessageForNonExistentMessage() {
    I18nTestClass testClass = new I18nTestClass();
    assertEquals(BAD_STRING_ARG, testClass.formatMessage(BAD_STRING_ARG, ARG_1));
  }

  @Test
  @DisplayName("Assert that a warning is only logged once for a non-existent message.")
  void testOnlyOneLogForNonExistentMessages() {
    I18nTestClass testClass = Mockito.spy(new I18nTestClass());

    assertEquals(BAD_STRING_ARG, testClass.formatMessage(BAD_STRING_ARG, ARG_1));

    verify(testClass).logUncontainedMessage(anyString());

    assertEquals(BAD_STRING_ARG, testClass.formatMessage(BAD_STRING_ARG, ARG_1));

    verify(testClass).logUncontainedMessage(anyString());
  }

  @Test
  @DisplayName("Test umlauts display correctly.")
  void testTheGermansAreComing() {
    I18nTestClass testClass = new I18nTestClass();
    ResourceBundle loadedBundle = ResourceBundle.getBundle("Messages", Locale.GERMAN);
    testClass.setLocale(Locale.GERMAN);
    String result = testClass.formatMessage(I18nConstants.BUNDLE_BUNDLE_ENTRY_NOFIRST, ARG_1);
    //Ensure the umlaut is displayed correctly. If not right, will show: Ã¼, not ü
    assertEquals("Documents oder Messages müssen mindestens einen Eintrag enthalten", result);
  }

  @Test
  @DisplayName("Test double single quotes behaviour.")
  void testDoubleSingleQuotes() {
    I18nTestClass testClass = new I18nTestClass();
    testClass.setLocale(Locale.US);
    String actualMessageA = testClass.formatMessage(I18nConstants.VALUESET_EXAMPLE_SYSTEM_HINT, "Mazooma");
    assertEquals("Example System 'Mazooma' specified, so Concepts and Filters can't be checked", actualMessageA);

    String actualMessageB = testClass.formatMessage(I18nConstants.VALUESET_NO_SYSTEM_WARNING);
    System.out.println(actualMessageB);
    assertEquals("No System specified, so Concepts and Filters can't be checked", actualMessageB);
  }


  @Test
  @DisplayName("Test German localization file contains no umlauts.")
  void testThatNoOneHasMessedWithTheGermans() {
    I18nTestClass testClass = new I18nTestClass();
    InputStream is = getClass().getClassLoader().getResourceAsStream("Messages_de.properties");
    try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader)) {
        String line;
        while ((line = reader.readLine()) != null) {
//          System.out.println("Searching for umlauts -> " + line);
          assertFalse(stringContainsItemFromList(line, UMLAUTS));
        }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private final String[] UMLAUTS = {"Ä", "Ö", "Ü", "ä", "ö", "ü"};

  public static boolean stringContainsItemFromList(String inputStr, String[] items) {
    return Arrays.stream(items).anyMatch(inputStr::contains);
  }

  @Test
  public void testRootKeyFromPlural() {
    I18nTestClass esLocale = new I18nTestClass();
    esLocale.setLocale(Locale.forLanguageTag("es"));

    final String rootKey = "MY_KEY";

    assertEquals(rootKey, esLocale.getRootKeyFromPlural(rootKey + "_one"));
    assertEquals(rootKey, esLocale.getRootKeyFromPlural(rootKey + "_many"));
    assertEquals(rootKey, esLocale.getRootKeyFromPlural(rootKey + "_other"));

    I18nTestClass enLocale = new I18nTestClass();
    enLocale.setLocale(Locale.forLanguageTag("en"));

    assertEquals(rootKey, enLocale.getRootKeyFromPlural(rootKey + "_one"));
    assertEquals(rootKey, enLocale.getRootKeyFromPlural(rootKey + "_other"));
    assertNull(enLocale.getRootKeyFromPlural(rootKey + "_many"));
  }

  @Test
  public void testMessagesChangeWhenLocaleDoes() {
    I18nTestClass i18nInstance = new I18nTestClass();
    i18nInstance.setLocale(Locale.forLanguageTag("de"));

    String deMessage = i18nInstance.formatMessage(I18nConstants.ERROR_PARSING_JSON_, "test");
    assertEquals("Fehler beim Parsen von JSON: test", deMessage);

    i18nInstance.setLocale(Locale.forLanguageTag("en"));
    String enMessage = i18nInstance.formatMessage(I18nConstants.ERROR_PARSING_JSON_, "test");
    assertEquals("Error parsing JSON: test", enMessage);

  }

  @Test
  @DisplayName("A message key lookup right after setLocale() loads the bundle instead of throwing.")
  void testMessageKeyLookupAfterSetLocale() {
    I18nTestClass testClass = new I18nTestClass();
    testClass.setLocale(Locale.ENGLISH);
    assertFalse(testClass.messageKeyExistsForLocale(BAD_STRING_ARG));
    testClass.setLocale(Locale.ENGLISH);
    assertTrue(testClass.messageKeyExistsForLocale(I18nConstants.BUNDLE_BUNDLE_MULTIPLEMATCHES));
  }

  @Test
  @DisplayName("Setting the locale that is already set keeps the loaded bundle.")
  void testSetSameLocaleKeepsTheLoadedBundle() {
    AtomicInteger loads = new AtomicInteger();
    I18nTestClass testClass = new I18nTestClass() {
      @Override
      protected String getMessagesSourceFileName() {
        loads.incrementAndGet();
        return super.getMessagesSourceFileName();
      }
    };
    testClass.setLocale(Locale.GERMAN);
    String german = testClass.formatMessage(I18nConstants.BUNDLE_BUNDLE_MULTIPLEMATCHES, ARG_1);
    testClass.setLocale(Locale.GERMAN);
    assertEquals(german, testClass.formatMessage(I18nConstants.BUNDLE_BUNDLE_MULTIPLEMATCHES, ARG_1));
    assertEquals(1, loads.get());
  }

  @Test
  @Timeout(60)
  @DisplayName("Formatting messages while another thread calls setLocale() on the same instance never fails.")
  void testFormatMessageWhileLocaleIsSetOnAnotherThread() throws Exception {
    I18nTestClass testClass = new I18nTestClass();
    testClass.setLocale(Locale.ENGLISH);
    String english = testClass.formatMessage(I18nConstants.BUNDLE_BUNDLE_MULTIPLEMATCHES, ARG_1);
    // en and en-US are different locales with the same text, so each call still replaces the state
    assertNull(formatWhileSettingLocale(testClass, english, Locale.ENGLISH, english, Locale.US));
  }

  @Test
  @Timeout(60)
  @DisplayName("Formatting while another thread switches between two locales gives the text of one of them.")
  void testFormatMessageWhileLocaleSwitchesOnAnotherThread() throws Exception {
    I18nTestClass testClass = new I18nTestClass();
    testClass.setLocale(Locale.GERMAN);
    String german = testClass.formatMessage(I18nConstants.BUNDLE_BUNDLE_MULTIPLEMATCHES, ARG_1);
    testClass.setLocale(Locale.ENGLISH);
    String english = testClass.formatMessage(I18nConstants.BUNDLE_BUNDLE_MULTIPLEMATCHES, ARG_1);
    assertNotEquals(english, german);
    assertNull(formatWhileSettingLocale(testClass, english, Locale.ENGLISH, german, Locale.GERMAN));
  }

  @Test
  @Timeout(60)
  @DisplayName("Formatting while another thread switches between a locale and no locale gives the text of one of them.")
  void testFormatMessageWhileLocaleIsClearedOnAnotherThread() throws Exception {
    String defaultText = new I18nTestClass().formatMessage(I18nConstants.BUNDLE_BUNDLE_MULTIPLEMATCHES, ARG_1);
    I18nTestClass testClass = new I18nTestClass();
    testClass.setLocale(Locale.GERMAN);
    String german = testClass.formatMessage(I18nConstants.BUNDLE_BUNDLE_MULTIPLEMATCHES, ARG_1);
    assertNull(formatWhileSettingLocale(testClass, german, Locale.GERMAN, defaultText, null));
  }

  /**
   * Formats a message 20,000 times while a second thread keeps calling setLocale() with the
   * given locales in turn. Returns the first problem: an exception, or a result that is not
   * one of the expected texts.
   */
  private static Object formatWhileSettingLocale(I18nTestClass testClass, Object... textsAndLocales) throws InterruptedException {
    Set<Object> texts = new HashSet<>();
    List<Locale> locales = new ArrayList<>();
    for (int i = 0; i < textsAndLocales.length; i += 2) {
      texts.add(textsAndLocales[i]);
      locales.add((Locale) textsAndLocales[i + 1]);
    }
    AtomicBoolean done = new AtomicBoolean(false);
    Thread setter = new Thread(() -> {
      int i = 0;
      while (!done.get()) {
        testClass.setLocale(locales.get(i++ % locales.size()));
      }
    });
    setter.start();
    try {
      for (int i = 0; i < 20000; i++) {
        try {
          String result = testClass.formatMessage(I18nConstants.BUNDLE_BUNDLE_MULTIPLEMATCHES, ARG_1);
          if (!texts.contains(result)) {
            return result;
          }
        } catch (Throwable e) {
          return e;
        }
      }
    } finally {
      done.set(true);
      setter.join();
    }
    return null;
  }
}