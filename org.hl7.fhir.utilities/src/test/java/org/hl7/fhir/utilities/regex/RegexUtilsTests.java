package org.hl7.fhir.utilities.regex;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegexUtilsTests {

  static Stream<Arguments> splitRegexMatchCases() {
    return Stream.of(
      // OID: split by '.', each entry must be numeric
      Arguments.of("2.16.840.1.113883", "\\.", "[0-9]+", -1, -1, true),
      // NPM package: split by '.', each entry matches NpmPackage.java:212 segment pattern
      Arguments.of("hl7.fhir.r4", "\\.", "[a-z][a-zA-Z0-9\\-]*", 2, -1, true),
      Arguments.of("hl7.fhir", "\\.", "[a-z][a-zA-Z0-9\\-]*", 2, -1, true),
      Arguments.of("hl7", "\\.", "[a-z][a-zA-Z0-9\\-]*", 2, -1, false)
    );
  }

  @ParameterizedTest
  @MethodSource("splitRegexMatchCases")
  void testSplitRegexMatch(String input, String splitRegex, String entryRegex, int minEntries, int maxEntries, boolean expected) {
    assertEquals(expected, RegexUtils.splitRegexMatch(input, splitRegex, entryRegex, minEntries, maxEntries));
  }
}
