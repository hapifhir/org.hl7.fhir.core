package org.hl7.fhir.utilities.regex;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RegexConstantsTests {

  // Created by claude-sonnet-4-6
  static Stream<Arguments> urlRegexParams() {
    return Stream.of(
      Arguments.of("http://example.com", true),
      Arguments.of("https://example.com", true),
      Arguments.of("http://www.example.com/path", true),
      Arguments.of("https://hl7.org/fhir/", true),
      Arguments.of("http://example.com/path?query=value&other=123", true),
      Arguments.of("ftp://example.com", false),
      Arguments.of("not-a-url", false),
      Arguments.of("http://", false)
    );
  }

  @ParameterizedTest
  @MethodSource("urlRegexParams")
  void testUrlRegex(String url, boolean expectedMatch) {
    assertEquals(expectedMatch, url.matches(RegexConstants.URL_REGEX));
  }
}
