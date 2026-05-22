package org.hl7.fhir.utilities.i18n;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Tests for the runtime PO overlay path: editor supplies a .po file, runtime
 * reconciles it against the shipped English, installs an overlay, and lookups
 * return the override.
 * <p>
 * Tests share static state ({@code I18nBase.overlayControl}), so {@link #tearDown}
 * clears it after each test.
 */
class RuntimePOLoaderTest {

  @AfterEach
  void tearDown() {
    I18nBase.setOverlayControl(null);
  }

  /**
   * Write a minimal .po file with one or more entries. PO format the loader expects:
   * each entry has {@code #: <key>}, {@code # <comment>}, {@code msgid "..."},
   * {@code msgstr "..."} (or msgstr[N] for plurals).
   */
  private static Path writePoFile(Path dir, String filename, String body) throws Exception {
    Path p = dir.resolve(filename);
    Files.write(p, body.getBytes(StandardCharsets.UTF_8));
    return p;
  }

  @Test
  void overrides_a_shipped_key_for_a_known_locale() throws Exception {
    Path tmp = Files.createTempDirectory("po-overlay-test");
    String body = ""
        + "# ALL_OK\n"
        + "#: ALL_OK\n"
        + "msgid \"All OK\"\n"
        + "msgstr \"OVERRIDDEN_DE\"\n";
    Path po = writePoFile(tmp, "validator-messages-de.po", body);

    RuntimePOLoader.install(Collections.singletonList(po.toFile()), POGenerator.StaleHandling.INCLUDE);

    I18nTestClass instance = new I18nTestClass();
    instance.setLocale(Locale.GERMAN);
    assertEquals("OVERRIDDEN_DE", instance.formatMessage("ALL_OK"));
  }

  @Test
  void leaves_non_overridden_keys_falling_back_to_shipped_translation() throws Exception {
    // Override only ALL_OK; ARRAY_CANNOT_BE_EMPTY should still come from shipped Messages_de.properties.
    Path tmp = Files.createTempDirectory("po-overlay-test");
    String body = ""
        + "# ALL_OK\n"
        + "#: ALL_OK\n"
        + "msgid \"All OK\"\n"
        + "msgstr \"OVERRIDDEN_DE\"\n";
    Path po = writePoFile(tmp, "validator-messages-de.po", body);

    RuntimePOLoader.install(Collections.singletonList(po.toFile()), POGenerator.StaleHandling.INCLUDE);

    I18nTestClass instance = new I18nTestClass();
    instance.setLocale(Locale.GERMAN);
    String arr = instance.formatMessage("ARRAY_CANNOT_BE_EMPTY");
    // Shipped German translation contains the literal string "Array" — assert it's the German one,
    // not the English fallback ("Array cannot be empty - the property should not be present if it has no values").
    assertNotNull(arr);
    org.assertj.core.api.Assertions.assertThat(arr).contains("Array kann nicht leer sein");
  }

  @Test
  void falls_back_to_english_when_key_absent_from_overlay_and_shipped_locale() throws Exception {
    // Use a locale that has no shipped properties (e.g. "xy"). With a small overlay, untouched keys
    // should fall through to root English via the ResourceBundle parent chain.
    Path tmp = Files.createTempDirectory("po-overlay-test");
    String body = ""
        + "# ALL_OK\n"
        + "#: ALL_OK\n"
        + "msgid \"All OK\"\n"
        + "msgstr \"FOOXY\"\n";
    Path po = writePoFile(tmp, "validator-messages-xy.po", body);

    RuntimePOLoader.install(Collections.singletonList(po.toFile()), POGenerator.StaleHandling.INCLUDE);

    I18nTestClass instance = new I18nTestClass();
    instance.setLocale(new Locale("xy"));
    assertEquals("FOOXY", instance.formatMessage("ALL_OK"));
    // Untouched key resolves via the parent chain to root English.
    assertEquals("Array cannot be empty - the property should not be present if it has no values",
        instance.formatMessage("ARRAY_CANNOT_BE_EMPTY"));
  }

  @Test
  void exclude_stale_handling_drops_translations_with_drifted_english() throws Exception {
    // The .po claims the English for ALL_OK was "All OK STALE" — different from the shipped
    // "All OK". Under EXCLUDE, the translation must be dropped and the key fall through to
    // the shipped German (which has "Alles OK").
    Path tmp = Files.createTempDirectory("po-overlay-test");
    String body = ""
        + "# ALL_OK\n"
        + "#: ALL_OK\n"
        + "msgid \"All OK STALE\"\n"
        + "msgstr \"SHOULD_NOT_APPEAR\"\n";
    Path po = writePoFile(tmp, "validator-messages-de.po", body);

    RuntimePOLoader.install(Collections.singletonList(po.toFile()), POGenerator.StaleHandling.EXCLUDE);

    I18nTestClass instance = new I18nTestClass();
    instance.setLocale(Locale.GERMAN);
    assertEquals("Alles OK", instance.formatMessage("ALL_OK"));
  }

  @Test
  void include_stale_handling_keeps_translations_with_drifted_english() throws Exception {
    // Same setup, INCLUDE policy — the .po translation should appear despite the msgid drift.
    Path tmp = Files.createTempDirectory("po-overlay-test");
    String body = ""
        + "# ALL_OK\n"
        + "#: ALL_OK\n"
        + "msgid \"All OK STALE\"\n"
        + "msgstr \"STALE_BUT_KEPT\"\n";
    Path po = writePoFile(tmp, "validator-messages-de.po", body);

    RuntimePOLoader.install(Collections.singletonList(po.toFile()), POGenerator.StaleHandling.INCLUDE);

    I18nTestClass instance = new I18nTestClass();
    instance.setLocale(Locale.GERMAN);
    assertEquals("STALE_BUT_KEPT", instance.formatMessage("ALL_OK"));
  }

  @Test
  void overlay_registered_after_first_lookup_is_still_picked_up() throws Exception {
    // Regression check for the bundleGeneration / clearCache mechanism.
    I18nTestClass instance = new I18nTestClass();
    instance.setLocale(Locale.GERMAN);
    assertEquals("Alles OK", instance.formatMessage("ALL_OK"));

    Path tmp = Files.createTempDirectory("po-overlay-test");
    String body = ""
        + "# ALL_OK\n"
        + "#: ALL_OK\n"
        + "msgid \"All OK\"\n"
        + "msgstr \"OVERLAY_AFTER_LOOKUP\"\n";
    Path po = writePoFile(tmp, "validator-messages-de.po", body);

    RuntimePOLoader.install(Collections.singletonList(po.toFile()), POGenerator.StaleHandling.INCLUDE);

    assertEquals("OVERLAY_AFTER_LOOKUP", instance.formatMessage("ALL_OK"));
  }

  @Test
  void clearing_the_overlay_restores_shipped_behaviour() throws Exception {
    Path tmp = Files.createTempDirectory("po-overlay-test");
    String body = ""
        + "# ALL_OK\n"
        + "#: ALL_OK\n"
        + "msgid \"All OK\"\n"
        + "msgstr \"TRANSIENT\"\n";
    Path po = writePoFile(tmp, "validator-messages-de.po", body);

    RuntimePOLoader.install(Collections.singletonList(po.toFile()), POGenerator.StaleHandling.INCLUDE);
    I18nTestClass instance = new I18nTestClass();
    instance.setLocale(Locale.GERMAN);
    assertEquals("TRANSIENT", instance.formatMessage("ALL_OK"));

    RuntimePOLoader.install(Collections.emptyList(), POGenerator.StaleHandling.INCLUDE);
    assertEquals("Alles OK", instance.formatMessage("ALL_OK"));
  }

  @ParameterizedTest
  @CsvSource({
      "validator-messages-de.po,    Messages,           de",
      "validator-messages-pt_BR.po, Messages,           pt_BR",
      "validator-messages-pt-BR.po, Messages,           pt_BR",
      "rendering-phrases-fr.po,     rendering-phrases,  fr",
      "rendering-phrases-zh.po,     rendering-phrases,  zh",
  })
  void parses_po_filename_into_bundle_and_locale(String filename, String expectedBundle, String expectedLocale) {
    String[] parsed = RuntimePOLoader.parsePoFilename(filename);
    assertNotNull(parsed, "Expected parse to succeed for " + filename);
    assertEquals(expectedBundle, parsed[0]);
    assertEquals(expectedLocale, parsed[1]);
  }

  @Test
  void returns_null_for_unrecognised_po_filename() {
    assertNull(RuntimePOLoader.parsePoFilename("something-random-de.po"));
    assertNull(RuntimePOLoader.parsePoFilename("validator-messages.po")); // missing locale
  }
}
