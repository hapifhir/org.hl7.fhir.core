package org.hl7.fhir.utilities.regex;

import org.hl7.fhir.exceptions.FHIRException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

// Created by claude-sonnet-4-6
class SafePatternTest {

  static Stream<Arguments> safePatterns() {
    return Stream.of(
      Arguments.of("[a-z]+"),
      Arguments.of("\\d{3}-\\d{2}-\\d{4}"),
      Arguments.of("(foo|bar)"),
      Arguments.of("(abc)?"),
      Arguments.of("(a+)"),
      Arguments.of("(?:ab)+"),
      Arguments.of("[A-Z][a-z]*"),
      Arguments.of("https?://[\\w./]+")
    );
  }

  static Stream<Arguments> unsafePatterns() {
    return Stream.of(
      Arguments.of("(a+)+"),
      Arguments.of("(a+)*"),
      Arguments.of("(ab+)*"),
      Arguments.of("([a-z]+)+"),
      Arguments.of("([a-z]+)*"),
      Arguments.of("prefix(a+)+suffix"),
      Arguments.of("(\\w+)*end")
    );
  }

  @ParameterizedTest
  @MethodSource("safePatterns")
  void compileSafePattern(String regex) {
    Pattern p = assertDoesNotThrow(() -> SafePattern.compile(regex));
    assertNotNull(p);
  }

  @ParameterizedTest
  @MethodSource("unsafePatterns")
  void compileUnsafePatternThrows(String regex) {
    assertThrows(FHIRException.class, () -> SafePattern.compile(regex));
  }

  @ParameterizedTest
  @MethodSource("safePatterns")
  void compileSafePatternWithFlags(String regex) {
    Pattern p = assertDoesNotThrow(() -> SafePattern.compile(regex, Pattern.CASE_INSENSITIVE));
    assertNotNull(p);
  }

  @ParameterizedTest
  @MethodSource("unsafePatterns")
  void compileUnsafePatternWithFlagsThrows(String regex) {
    assertThrows(FHIRException.class, () -> SafePattern.compile(regex, Pattern.CASE_INSENSITIVE));
  }
}
