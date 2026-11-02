package org.hl7.fhir.r4b.utils;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import org.hl7.fhir.r4b.fhirpath.FHIRLexer;
import org.hl7.fhir.r4b.fhirpath.FHIRLexer.FHIRLexerException;

class FHIRLexerTest {
  @Test
  @DisplayName("Test that a 'null' current value returns 'false' when FHIRLexer.isConstant() is called, and not NPE.")
  void getCurrent() {
    FHIRLexer lexer = new FHIRLexer(null, null);
    String lexerCurrent = lexer.getCurrent();
    Assertions.assertNull(lexerCurrent);
    Assertions.assertFalse(lexer.isConstant());
  }

  @ParameterizedTest
  @ValueSource(strings = {"'\\u'", "'\\u00'", "'\\u004'", "'\\uZZZZ'", "'\\u-041'", "'\\u+041'"})
  void processConstantRejectsInvalidUnicodeEscape(String constant) {
    FHIRLexer lexer = new FHIRLexer(null, null);
    Assertions.assertThrows(FHIRLexerException.class, () -> lexer.processConstant(constant));
  }

  @ParameterizedTest
  @ValueSource(strings = {"'\\u'", "'\\u00'", "'\\u004'", "'\\uZZZZ'", "'\\u-041'", "'\\u+041'"})
  void processFixedNameRejectsInvalidUnicodeEscape(String constant) {
    FHIRLexer lexer = new FHIRLexer(null, null);
    String name = "`" + constant.substring(1, constant.length() - 1) + "`";
    Assertions.assertThrows(FHIRLexerException.class, () -> lexer.processFixedName(name));
  }

  @ParameterizedTest
  @MethodSource("escapes")
  void processConstantReadsEscapes(String constant, String expected) {
    Assertions.assertEquals(expected, new FHIRLexer(null, null).processConstant("'" + constant + "'"));
  }

  @ParameterizedTest
  @MethodSource("escapes")
  void processFixedNameReadsEscapes(String name, String expected) {
    Assertions.assertEquals(expected, new FHIRLexer(null, null).processFixedName("`" + name + "`"));
  }

  private static Stream<Arguments> escapes() {
    return Stream.of(
      Arguments.of("\\u006eame", "name"),
      Arguments.of("na\\tme", "na\tme"),
      Arguments.of("a\\\\b", "a\\b"),
      Arguments.of("a\\`b", "a`b"),
      Arguments.of("a\\'b", "a'b"));
  }
}
