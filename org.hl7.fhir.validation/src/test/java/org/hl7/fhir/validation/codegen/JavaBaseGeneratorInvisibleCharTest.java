package org.hl7.fhir.validation.codegen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Tests for the invisible / format character check in {@link JavaBaseGenerator}. That check is what
 * stands between an untrusted FHIR definition and a Trojan Source (CVE-2021-42574) style
 * discrepancy between the generated source a reviewer reads and the code javac actually builds.
 * <p>
 * The characters it must catch matter most, but the ones it must let through are tested just as
 * hard: a check that flagged ordinary text would have escapeJavaString mangling legitimate content
 * and sanitizeComment silently deleting parts of documentation.
 * <p>
 * This file is deliberately plain ascii. Every character under test is written as a java escape in
 * code, and referred to as U+XXXX in prose - a comment here must never contain a bare backslash-u
 * sequence, because javac expands those before it tokenises and the real character would end up in
 * this source
 */
class JavaBaseGeneratorInvisibleCharTest {

  /**
   * Bidirectional formatting - embeddings, overrides, isolates and marks. This is the set the
   * Trojan Source paper is about: they reorder how a line renders without changing what it means
   */
  @ParameterizedTest
  @ValueSource(chars = {
      '\u202A', '\u202B', '\u202C', '\u202D', '\u202E', // LRE RLE PDF LRO RLO
      '\u2066', '\u2067', '\u2068', '\u2069',             // LRI RLI FSI PDI
      '\u200E', '\u200F', '\u061C'                          // LRM RLM ALM
  })
  void bidiControlsAreDangerous(char c) {
    assertTrue(JavaBaseGenerator.isDangerousInvisibleChar(c), name(c));
  }

  /** Zero width and other invisible spacing / joining characters */
  @ParameterizedTest
  @ValueSource(chars = {
      '\u200B', // zero width space
      '\u200C', // zero width non joiner
      '\u200D', // zero width joiner
      '\u2060', // word joiner
      '\uFEFF'  // zero width no break space / BOM
  })
  void zeroWidthCharactersAreDangerous(char c) {
    assertTrue(JavaBaseGenerator.isDangerousInvisibleChar(c), name(c));
  }

  /**
   * Format characters the method does not name explicitly, caught by the general rule: soft hyphen,
   * Mongolian vowel separator, the invisible maths operators, and the interlinear annotation marks
   */
  @ParameterizedTest
  @ValueSource(chars = {
      '\u00AD', '\u180E', '\u2061', '\u2062', '\u2063', '\u2064',
      '\uFFF9', '\uFFFA', '\uFFFB'
  })
  void unnamedFormatCharactersAreDangerous(char c) {
    assertTrue(JavaBaseGenerator.isDangerousInvisibleChar(c), name(c));
  }

  /**
   * The named characters above are all category Cf as well, so the explicit branches for them are
   * redundant against the general rule as things stand. They are worth keeping because they record
   * intent - and this test is what fails if a future JDK's Unicode data reclassifies one, which is
   * exactly the case where the explicit list is what saves us
   */
  @ParameterizedTest
  @ValueSource(chars = {
      '\u202A', '\u202B', '\u202C', '\u202D', '\u202E',
      '\u2066', '\u2067', '\u2068', '\u2069',
      '\u200E', '\u200F', '\u061C',
      '\u200B', '\u200C', '\u200D', '\u2060', '\uFEFF'
  })
  void theNamedCharactersAreAlsoFormatCharacters(char c) {
    assertTrue(Character.getType(c) == Character.FORMAT, name(c) + " is no longer a format character");
  }

  @Test
  void everyFormatCharacterInTheBmpIsDangerous() {
    for (int i = 0; i <= 0xFFFF; i++) {
      char c = (char) i;
      if (Character.getType(c) == Character.FORMAT) {
        assertTrue(JavaBaseGenerator.isDangerousInvisibleChar(c), name(c));
      }
    }
  }

  @Test
  void c0ControlsAreDangerousExceptTabCrAndLf() {
    for (int i = 0; i <= 0x1F; i++) {
      char c = (char) i;
      boolean laidOutByTheGenerators = c == '\t' || c == '\r' || c == '\n';
      assertEquals(!laidOutByTheGenerators, JavaBaseGenerator.isDangerousInvisibleChar(c), name(c));
    }
  }

  /** DEL, and the C1 block - which renders as nothing at all in most editors */
  @Test
  void delAndC1ControlsAreDangerous() {
    for (int i = 0x7F; i <= 0x9F; i++) {
      assertTrue(JavaBaseGenerator.isDangerousInvisibleChar((char) i), name((char) i));
    }
  }

  /**
   * The three the generators lay code out with. sanitizeComment turns them into spaces and
   * escapeJava turns CR and LF into their escapes, so none of them reaches the generated source
   * raw - but the check itself has to let them past, or every comment would lose its whitespace
   */
  @Test
  void tabCrAndLfAreNotDangerous() {
    assertFalse(JavaBaseGenerator.isDangerousInvisibleChar('\t'));
    assertFalse(JavaBaseGenerator.isDangerousInvisibleChar('\r'));
    assertFalse(JavaBaseGenerator.isDangerousInvisibleChar('\n'));
  }

  @Test
  void printableAsciiIsNotDangerous() {
    for (int i = 0x20; i <= 0x7E; i++) {
      assertFalse(JavaBaseGenerator.isDangerousInvisibleChar((char) i), name((char) i));
    }
  }

  /** Accented letters, a homoglyph, han characters, currency and punctuation - all have glyphs */
  @ParameterizedTest
  @ValueSource(chars = {
      '\u00E9', '\u00C9', '\u00B5', '\u0430', '\u6F22', '\u5B57',
      '\u20AC', '\u2013', '\u2019'
  })
  void visibleNonAsciiCharactersAreNotDangerous(char c) {
    assertFalse(JavaBaseGenerator.isDangerousInvisibleChar(c), name(c));
  }

  /**
   * escapeJavaString and sanitizeComment walk chars, so each half of a supplementary code point is
   * seen on its own. Surrogates are category Cs, neither format nor control, and have to pass
   * through untouched or a character outside the BMP would be corrupted rather than escaped
   */
  @ParameterizedTest
  @ValueSource(chars = { '\uD83D', '\uDE00' })
  void surrogatesAreNotDangerous(char c) {
    assertFalse(JavaBaseGenerator.isDangerousInvisibleChar(c), name(c));
  }

  /**
   * Not flagged, deliberately: these are separators (Zs, Zl, Zp), not format or control characters.
   * None of them terminates a line or a string literal as far as javac is concerned, so none can
   * break out of a comment or a literal - they are a rendering nuisance rather than a soundness
   * problem. Pinned here so that changing our mind about them has to be a deliberate act
   */
  @ParameterizedTest
  @ValueSource(chars = {
      '\u00A0', // no break space
      '\u2007', // figure space
      '\u202F', // narrow no break space
      '\u2028', // line separator
      '\u2029', // paragraph separator
      '\u3000'  // ideographic space
  })
  void separatorsAreNotFlagged(char c) {
    assertFalse(JavaBaseGenerator.isDangerousInvisibleChar(c), name(c));
  }

  /**
   * The converse of the sweeps above, and the guarantee the two callers actually rely on: whatever
   * the check flags is a format or a control character, so no letter, digit, mark, symbol,
   * punctuation, separator or surrogate is ever escaped out of, or stripped from, generated content
   */
  @Test
  void nothingOutsideFormatAndControlIsFlagged() {
    for (int i = 0; i <= 0xFFFF; i++) {
      char c = (char) i;
      if (JavaBaseGenerator.isDangerousInvisibleChar(c)) {
        int type = Character.getType(c);
        assertTrue(type == Character.FORMAT || type == Character.CONTROL,
            name(c) + " is flagged but is neither a format nor a control character (type " + type + ")");
      }
    }
  }

  /**
   * The check is only worth anything through its callers, so pin both. escapeJavaString turns a
   * flagged character into an explicit escape - the source stays ascii and the runtime string is
   * unchanged; sanitizeComment drops it, since a comment has no escape to fall back on
   */
  @Test
  void escapeJavaStringEscapesWhatTheCheckFlags() {
    assertEquals("na\\u200bme", JavaBaseGenerator.escapeJavaString("na\u200Bme"));
    assertEquals("na\\u202eme", JavaBaseGenerator.escapeJavaString("na\u202Eme"));
    assertEquals("name", JavaBaseGenerator.escapeJavaString("name"));
  }

  @Test
  void sanitizeCommentStripsWhatTheCheckFlags() {
    assertEquals("name", JavaBaseGenerator.sanitizeComment("na\u200Bme"));
    assertEquals("name", JavaBaseGenerator.sanitizeComment("na\u202Eme"));
    assertEquals("na me", JavaBaseGenerator.sanitizeComment("na\nme"));
  }

  private static String name(char c) {
    return "U+" + String.format("%04X", (int) c);
  }
}
