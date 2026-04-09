package org.hl7.fhir.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HTMLUtilitiesTest {

  static Stream<Arguments> containsHtmlTagsCases() {
    return Stream.of(
      // Two simple tags
      Arguments.of("<div><span>", true),
      // Tag with attribute followed by a second tag
      Arguments.of("<p class=\"note\"><br>", true),
      // Tag with multiple attributes followed by a second tag
      Arguments.of("<div id=\"main\" style=\"color:red\"><span>", true),
      // Tags embedded in surrounding text
      Arguments.of("some text <em>content<strong>", true),
      // Opening tag followed by closing tag and another opening tag
      Arguments.of("<h1>heading</h1><h2>", true),
      // Table tags
      Arguments.of("<table><tr>", true),

      // Plain text — no angle brackets
      Arguments.of("no html here", false),
      // Single opening tag: current implementation requires a second '<' to detect any tag
      Arguments.of("<div>", false),
      // Closing tags only: content starts with '/', does not match [a-zA-Z]
      Arguments.of("</div></span>", false),
      // Self-closing tag: single '<', content "br/" does not match the tag name pattern
      Arguments.of("<br/>", false),
      // Comparison operators — not angle brackets enclosing a tag
      Arguments.of("3 < 5 > 2", false),
      // Empty string
      Arguments.of("", false),
      // Tag content starting with a digit
      Arguments.of("<123><456>", false)
    );
  }

  @ParameterizedTest
  @MethodSource("containsHtmlTagsCases")
  void testContainsHtmlTags(String input, boolean expected) {
    assertEquals(expected, HTMLUtilities.containsHtmlTags(input));
  }
}
