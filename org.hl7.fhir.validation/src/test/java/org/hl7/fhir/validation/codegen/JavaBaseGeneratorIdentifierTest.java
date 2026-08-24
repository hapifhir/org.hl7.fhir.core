package org.hl7.fhir.validation.codegen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.hl7.fhir.exceptions.FHIRException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Tests for the java identifier safety check in {@link JavaBaseGenerator}. The values that must be
 * refused matter more than the ones that must be accepted: a generator that emits an identifier
 * containing an invisible character produces source that compiles to something other than what a
 * reviewer reads.
 * <p>
 * This file is deliberately plain ascii - every character being tested is written as an escape, so
 * that the test data cannot itself be tampered with invisibly
 */
class JavaBaseGeneratorIdentifierTest {

  @ParameterizedTest
  @ValueSource(strings = {
      "a", "A", "_x", "__",
      "name", "Patient", "HumanName", "valueQuantity", "value_x", "_value", "_1",
      "id0", "x1y2z3", "MAX_VALUE", "CONSTANT_1", "lowerCamelCase", "UpperCamelCase",
      // near misses on the keyword list - all legal, all accepted
      "clazz", "class_", "classes", "trueish", "nullable", "vary", "records", "yielded",
      // not a keyword, whatever isJavaReservedWord says
      "Exception", "String", "toString", "equals"
  })
  void safeTokensAreAccepted(String token) {
    assertTrue(JavaBaseGenerator.isSafeJavaIdentifier(token), token);
  }

  @ParameterizedTest
  @NullSource
  @EmptySource
  void nullAndEmptyAreRefused(String token) {
    assertFalse(JavaBaseGenerator.isSafeJavaIdentifier(token));
  }

  /**
   * Keywords, the three literals, the lone underscore, and the contextual keywords that are
   * restricted in declaration positions
   */
  @ParameterizedTest
  @ValueSource(strings = {
      "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
      "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float",
      "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long",
      "native", "new", "package", "private", "protected", "public", "return", "short", "static",
      "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try",
      "void", "volatile", "while",
      "true", "false", "null",
      "_",
      "var", "yield", "record", "sealed", "permits"
  })
  void unusableTokensAreRefused(String token) {
    assertFalse(JavaBaseGenerator.isSafeJavaIdentifier(token), token);
  }

  /**
   * Keyword matching is case sensitive, as java is
   */
  @ParameterizedTest
  @ValueSource(strings = { "Class", "CLASS", "True", "Null", "Var", "Record" })
  void keywordsInOtherCasesAreAccepted(String token) {
    assertTrue(JavaBaseGenerator.isSafeJavaIdentifier(token), token);
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "1name", "0", "9lives",      // cannot start with a digit
      " name", "name ", "na me",   // whitespace anywhere
      "na-me", "na.me", "na:me", "na/me", "na+me", "na*me", "na'me", "na\"me", "na;me",
      "name()", "name[]", "name{}", "na\\me", "@name", "#name", "%name",
      "name\t", "name\r", "name\n"  // line and comment breakout material
  })
  void punctuationAndWhitespaceAreRefused(String token) {
    assertFalse(JavaBaseGenerator.isSafeJavaIdentifier(token), token);
  }

  /**
   * '$' is legal java but is refused - it is the separator in the binary names of nested and
   * synthetic classes, so a token carrying one can collide with a class no one meant to name
   */
  @ParameterizedTest
  @ValueSource(strings = { "$", "$name", "na$me", "name$", "Outer$Inner" })
  void dollarIsRefused(String token) {
    assertFalse(JavaBaseGenerator.isSafeJavaIdentifier(token), token);
    assertTrue(isJavaLegalIdentifier(token), token + " should still be legal java");
  }

  /**
   * Every value here compiles as an identifier. They are refused because a reviewer cannot see, or
   * cannot reliably distinguish, what the compiler is reading
   */
  @ParameterizedTest
  @ValueSource(strings = {
      "na\u200bme",   // zero width space
      "na\u200cme",   // zero width non joiner
      "na\u200dme",   // zero width joiner
      "na\u2060me",   // word joiner
      "na\ufeffme",   // zero width no break space / BOM
      "na\u202eme",   // right to left override - Trojan Source
      "na\u2066me",   // left to right isolate
      "na\u200eme",   // left to right mark
      "na\u00adme",   // soft hyphen
      "na\0me",       // NUL - an ignorable character, and so legal in a java identifier
      "na\bme"        // backspace - likewise
  })
  void invisibleAndFormatCharactersAreRefused(String token) {
    assertFalse(JavaBaseGenerator.isSafeJavaIdentifier(token), describe(token));
    assertTrue(isJavaLegalIdentifier(token), describe(token) + " should still be legal java");
  }

  /**
   * Non ascii letters are legal java identifiers and are refused here: FHIR definitions are ascii by
   * convention, and homoglyphs (the cyrillic 'a' below) are indistinguishable in review
   */
  @ParameterizedTest
  @ValueSource(strings = {
      "na\u00efve",       // i with diaeresis
      "\u00c9clair",      // E acute
      "\u6f22\u5b57",     // han characters
      "n\u0430me",        // cyrillic small a - a homoglyph for ascii 'a'
      "na\u00b5me"        // micro sign
  })
  void nonAsciiLettersAreRefused(String token) {
    assertFalse(JavaBaseGenerator.isSafeJavaIdentifier(token), describe(token));
  }

  /**
   * Supplementary code points are two chars in java. The check walks chars, which is only safe
   * because everything above U+007F is refused - this pins that down
   */
  @ParameterizedTest
  @ValueSource(strings = {
      "na\ud83d\ude00me",  // grinning face, a well formed surrogate pair
      "na\ud83dme",        // a high surrogate on its own
      "na\ude00me"         // a low surrogate on its own
  })
  void surrogatesAreRefused(String token) {
    assertFalse(JavaBaseGenerator.isSafeJavaIdentifier(token), describe(token));
  }

  @Test
  void lengthIsBounded() {
    assertTrue(JavaBaseGenerator.isSafeJavaIdentifier(repeat('a', JavaBaseGenerator.MAX_JAVA_IDENTIFIER_LENGTH)));
    assertFalse(JavaBaseGenerator.isSafeJavaIdentifier(repeat('a', JavaBaseGenerator.MAX_JAVA_IDENTIFIER_LENGTH + 1)));
  }

  @Test
  void checkPassesForASafeToken() {
    JavaBaseGenerator.checkJavaIdentifier("valueQuantity", "element Observation.value[x]");
  }

  @ParameterizedTest
  @MethodSource("unsafeTokensWithReasons")
  void checkThrowsAndExplains(String token, String expectedFragment) {
    FHIRException e = assertThrows(FHIRException.class,
        () -> JavaBaseGenerator.checkJavaIdentifier(token, "element Patient.name"));
    assertTrue(e.getMessage().contains(expectedFragment),
        "expected \"" + expectedFragment + "\" in: " + e.getMessage());
    assertTrue(e.getMessage().contains("element Patient.name"), e.getMessage());
  }

  static Stream<Arguments> unsafeTokensWithReasons() {
    return Stream.of(
        Arguments.of(null, "it is null"),
        Arguments.of("", "it is empty"),
        Arguments.of("class", "java keyword"),
        Arguments.of("1name", "first character"),
        Arguments.of("na me", "position 2"),
        Arguments.of("na\u200bme", "U+200B"),
        Arguments.of(repeat('a', 256), "characters long"));
  }

  /**
   * The message quotes an untrusted value and may be logged or rendered into an OperationOutcome, so
   * it must not carry the value's control or invisible characters through
   */
  @ParameterizedTest
  @ValueSource(strings = {
      "na\u200bme", "na\u202eme", "na\0me", "name\n", "na\u6f22me", "na\"me", "na\\me"
  })
  void messageIsPrintableAscii(String token) {
    FHIRException e = assertThrows(FHIRException.class,
        () -> JavaBaseGenerator.checkJavaIdentifier(token, "element Patient.name"));
    for (char c : e.getMessage().toCharArray()) {
      assertTrue(c >= ' ' && c <= '~',
          "non printable char U+" + Integer.toHexString(c) + " in: " + describe(e.getMessage()));
    }
  }

  @Test
  void longTokensAreTruncatedInTheMessage() {
    FHIRException e = assertThrows(FHIRException.class,
        () -> JavaBaseGenerator.checkJavaIdentifier(repeat('a', 4000), "element Patient.name"));
    assertTrue(e.getMessage().length() < 300, "message length " + e.getMessage().length());
    assertTrue(e.getMessage().contains("..."), e.getMessage());
  }

  /**
   * Everything the check accepts must also be legal java - this is a narrowing of the JLS, never a
   * widening of it
   */
  @ParameterizedTest
  @ValueSource(strings = { "a", "_x", "name", "Patient", "value_x", "MAX_VALUE", "x1", "__" })
  void acceptedTokensAreLegalJava(String token) {
    assertTrue(JavaBaseGenerator.isSafeJavaIdentifier(token), token);
    assertTrue(isJavaLegalIdentifier(token), token);
  }

  /**
   * What the JLS actually allows, for the tests that assert this check is stricter than javac
   */
  private static boolean isJavaLegalIdentifier(String s) {
    if (s == null || s.length() == 0 || !Character.isJavaIdentifierStart(s.charAt(0))) {
      return false;
    }
    for (int i = 1; i < s.length(); i++) {
      if (!Character.isJavaIdentifierPart(s.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  private static String repeat(char c, int count) {
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < count; i++) {
      b.append(c);
    }
    return b.toString();
  }

  /**
   * Render a value for an assertion message without letting its invisible characters into the build
   * log
   */
  private static String describe(String s) {
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c >= ' ' && c <= '~') {
        b.append(c);
      } else {
        b.append("<U+").append(Integer.toHexString(c).toUpperCase()).append('>');
      }
    }
    return b.toString();
  }

  @Test
  void assertionHelperIsSane() {
    assertEquals("na<U+200B>me", describe("na\u200bme"));
  }
}
