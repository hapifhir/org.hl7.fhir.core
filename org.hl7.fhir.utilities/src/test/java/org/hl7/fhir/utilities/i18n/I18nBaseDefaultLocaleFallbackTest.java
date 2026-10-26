package org.hl7.fhir.utilities.i18n;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import com.ibm.icu.text.PluralRules;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.api.parallel.Isolated;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * An explicitly requested locale must not pick up translations from the JVM default
 * locale: requesting "en" on a machine running in sv-SE has to produce English.
 */
@Isolated
class I18nBaseDefaultLocaleFallbackTest {

  private static final Locale SWEDISH = Locale.forLanguageTag("sv-SE");
  private static final Locale LATVIAN = Locale.forLanguageTag("lv");

  private Locale originalDefault;

  @BeforeEach
  void setUp() {
    originalDefault = Locale.getDefault();
    Locale.setDefault(SWEDISH);
    I18nBase.setOverlayControl(null);
  }

  @AfterEach
  void tearDown() {
    Locale.setDefault(originalDefault);
    I18nBase.setOverlayControl(null);
  }

  @ParameterizedTest
  @ValueSource(strings = {"en", "en-US", "lv-LV"})
  void localeWithoutOwnBundleUsesEnglishNotJvmDefault(String languageTag) {
    I18nTestClass i18n = new I18nTestClass();
    i18n.setLocale(Locale.forLanguageTag(languageTag));
    assertEquals("Error parsing JSON: test", i18n.formatMessage(I18nConstants.ERROR_PARSING_JSON_, "test"));
    assertEquals(Locale.ROOT, i18n.getMessages().getLocale());
  }

  @ParameterizedTest
  @CsvSource(delimiter = '|', value = {
    "de    | Fehler beim Parsen von JSON: test",
    "de-CH | Fehler beim Parsen von JSON: test",
    "pt-BR | Erro ao analisar JSON: test"
  })
  void localeWithOwnBundleStillUsesIt(String languageTag, String expected) {
    I18nTestClass i18n = new I18nTestClass();
    i18n.setLocale(Locale.forLanguageTag(languageTag));
    assertEquals(expected, i18n.formatMessage(I18nConstants.ERROR_PARSING_JSON_, "test"));
  }

  @Test
  void unsetLocaleStillUsesJvmDefault() {
    I18nTestClass i18n = new I18nTestClass();
    assertEquals("Fel vid analys av JSON: test", i18n.formatMessage(I18nConstants.ERROR_PARSING_JSON_, "test"));
  }

  @Test
  void renderingPhrasesEnglishIsNotOverriddenByJvmDefault() {
    RenderingI18nContext context = new RenderingI18nContext();
    context.setLocale(Locale.ENGLISH);
    assertEquals("My IG - Local Development build (v1.0.0) built by the FHIR (HL7® FHIR® Standard) Build Tools. "
        + "See the <a href='http://example.org/history.html'>Directory of published versions</a>",
      context.formatPhrase(RenderingI18nContext.STATUS_MSG_LOCAL_BUILD, "My IG", "1.0.0", "http://example.org"));
  }

  @Test
  @SuppressWarnings("deprecation")
  void setValidationMessageLanguageEnglishIsNotOverriddenByJvmDefault() {
    I18nTestClass i18n = new I18nTestClass();
    i18n.setValidationMessageLanguage(Locale.ENGLISH);
    assertEquals("Error parsing JSON: test", i18n.formatMessage(I18nConstants.ERROR_PARSING_JSON_, "test"));
  }

  @Test
  @SuppressWarnings("deprecation")
  void setValidationMessageLanguageWithUnsetLocaleHandlesMissingKeys() {
    I18nTestClass i18n = new I18nTestClass();
    i18n.setValidationMessageLanguage(Locale.ENGLISH);
    assertEquals("NO_SUCH_KEY", i18n.formatMessage("NO_SUCH_KEY", "arg"));
    assertEquals(Locale.ENGLISH, i18n.getLocale());
    assertEquals("Error parsing JSON: test", i18n.formatMessage(I18nConstants.ERROR_PARSING_JSON_, "test"));
  }

  @Test
  @SuppressWarnings("deprecation")
  void failedSetValidationMessageLanguageLeavesStateUnchanged() {
    I18nTestClass i18n = new I18nTestClass();
    i18n.setLocale(Locale.GERMAN);
    assertThrows(NullPointerException.class, () -> i18n.setValidationMessageLanguage(null));
    assertEquals(Locale.GERMAN, i18n.getLocale());
    assertEquals("Fehler beim Parsen von JSON: test", i18n.formatMessage(I18nConstants.ERROR_PARSING_JSON_, "test"));
  }

  @Test
  void overlayControlWithDefaultFallbackDoesNotUseJvmDefault() {
    // A Control that keeps the JDK's default getFallbackLocale(), i.e. Locale.getDefault()
    I18nBase.setOverlayControl(new ResourceBundle.Control() {});
    I18nTestClass i18n = new I18nTestClass();
    i18n.setLocale(Locale.ENGLISH);
    assertEquals("Error parsing JSON: test", i18n.formatMessage(I18nConstants.ERROR_PARSING_JSON_, "test"));
  }

  @Test
  void poOverlayForLocaleWithoutShippedBundleFallsBackToEnglish(@TempDir Path tmp) throws Exception {
    installLatvianOverlay(tmp);
    I18nTestClass i18n = new I18nTestClass();
    i18n.setLocale(LATVIAN);
    assertEquals("OVERRIDDEN_LV", i18n.formatMessage("ALL_OK"));
    assertEquals("Error parsing JSON: test", i18n.formatMessage(I18nConstants.ERROR_PARSING_JSON_, "test"));
  }

  @Test
  void pluralRulesFollowBundleReloadedForOverlay(@TempDir Path tmp) throws Exception {
    // Swedish plural rules match US ones, so use a default whose rules differ to detect leaks
    Locale.setDefault(Locale.forLanguageTag("ru-RU"));
    I18nTestClass i18n = new I18nTestClass();
    i18n.setLocale(LATVIAN);
    // No shipped lv bundle, so the root bundle and its (US) plural rules are used
    assertEquals(PluralRules.forLocale(Locale.US), i18n.getPluralRules());
    installLatvianOverlay(tmp);
    // A message lookup reloads the bundle for the overlay; plural lookups must then use lv rules
    assertEquals("OVERRIDDEN_LV", i18n.formatMessage("ALL_OK"));
    assertEquals(Set.of("X_zero", "X_one", "X_other"), i18n.getPluralKeys("X"));
    assertEquals(PluralRules.forLocale(LATVIAN), i18n.getPluralRules());
  }

  private static void installLatvianOverlay(Path dir) throws Exception {
    Path po = dir.resolve("validator-messages-lv.po");
    Files.write(po, ("#: ALL_OK\n"
        + "msgid \"All OK\"\n"
        + "msgstr \"OVERRIDDEN_LV\"\n").getBytes(StandardCharsets.UTF_8));
    RuntimePOLoader.install(Collections.singletonList(po.toFile()), POGenerator.StaleHandling.INCLUDE);
  }
}
