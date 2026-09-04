package org.hl7.fhir.utilities.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * PrimitiveRegexes replaces a regex with hand written java, so what matters is that it agrees with the regex
 * on every input, not just the ones anyone thought to write down. These tests compare the two directly over
 * exhaustive short inputs, random inputs, and mutations of realistic values.
 * <p>
 * The alphabet is chosen to be awkward: every character java's \s matches (including vertical tab and form
 * feed), one it doesn't (a non-breaking space - java's \s is ASCII only unless the pattern is in unicode
 * mode), the structural characters of each format, and a surrogate pair
 */
class PrimitiveRegexesTests {

  private static final char[] ALPHABET = { 'a', 'Z', '0', '9', '1', '-', '.', '+', ':', '/', 'u', 'r', 'n',
      't', 'e', 'f', 's', 'x', ' ', '\t', '\n', 0x0B, 0x0C, '\r', 0x00A0, 0xD83D, 0xDE00 };

  private static final String[] SEEDS = { "", " ", "0", "-0", "+12", "007", "12345678901234567890", "true",
      "false", "example-patient.1", "vital-signs", "some code", "a b c", "text with spaces", "line1\nline2",
      "http://hl7.org/fhir/StructureDefinition/Patient", "urn:oid:2.16.840.1.113883.6.1", "urn:oid:0.0",
      "urn:uuid:6d7c8b2e-1a4f-4c3d-9e8a-0b1c2d3e4f50" };

  static Stream<String> knownRegexes() {
    List<String> res = new ArrayList<>();
    PrimitiveRegexes.knownRegexes().forEach(res::add);
    return res.stream();
  }

  @ParameterizedTest
  @MethodSource("knownRegexes")
  void agreesWithTheRegexOnEveryShortInput(String regex) {
    Pattern pattern = Pattern.compile(regex);
    assertAgrees(pattern, regex, "");
    for (char first : ALPHABET) {
      assertAgrees(pattern, regex, String.valueOf(first));
      for (char second : ALPHABET) {
        assertAgrees(pattern, regex, "" + first + second);
        for (char third : ALPHABET) {
          assertAgrees(pattern, regex, "" + first + second + third);
        }
      }
    }
  }

  @ParameterizedTest
  @MethodSource("knownRegexes")
  void agreesWithTheRegexOnRandomInput(String regex) {
    Pattern pattern = Pattern.compile(regex);
    Random random = new Random(regex.hashCode()); // seeded, so a failure is reproducible
    for (int i = 0; i < 50000; i++) {
      StringBuilder value = new StringBuilder();
      int length = random.nextInt(49);
      for (int j = 0; j < length; j++) {
        value.append(ALPHABET[random.nextInt(ALPHABET.length)]);
      }
      assertAgrees(pattern, regex, value.toString());
    }
  }

  @ParameterizedTest
  @MethodSource("knownRegexes")
  void agreesWithTheRegexOnMutationsOfRealisticValues(String regex) {
    Pattern pattern = Pattern.compile(regex);
    Random random = new Random(regex.hashCode());
    for (String seed : SEEDS) {
      assertAgrees(pattern, regex, seed);
      for (int i = 0; i < 2000; i++) {
        StringBuilder value = new StringBuilder(seed);
        for (int mutation = 1 + random.nextInt(3); mutation > 0; mutation--) {
          int operation = random.nextInt(3);
          if (operation == 0 && value.length() > 0) {
            value.deleteCharAt(random.nextInt(value.length()));
          } else if (operation == 1) {
            value.insert(random.nextInt(value.length() + 1), ALPHABET[random.nextInt(ALPHABET.length)]);
          } else if (value.length() > 0) {
            value.setCharAt(random.nextInt(value.length()), ALPHABET[random.nextInt(ALPHABET.length)]);
          }
        }
        assertAgrees(pattern, regex, value.toString());
      }
    }
  }

  /**
   * id is the only one with a length limit, so walk across it
   */
  @Test
  void agreesWithTheRegexAtTheIdLengthBoundary() {
    String regex = "[A-Za-z0-9\\-\\.]{1,64}";
    Pattern pattern = Pattern.compile(regex);
    StringBuilder value = new StringBuilder();
    for (int i = 0; i < 200; i++) {
      assertAgrees(pattern, regex, value.toString());
      value.append('a');
    }
  }

  /**
   * the whole point of the string and markdown entry: the regex reads every character, this doesn't
   */
  @Test
  void doesNotReadTheWholeValueForString() {
    String huge = "x".repeat(2000000);
    assertThat(PrimitiveRegexes.matchesRegex("^[\\s\\S]+$", huge)).isTrue();
    assertThat(PrimitiveRegexes.matchesRegex("^[\\s\\S]+$", "")).isFalse();
  }

  @Test
  void returnsNullForARegexItDoesNotKnow() {
    assertThat(PrimitiveRegexes.matchesRegex("[a-z]+", "abc")).isNull();
  }

  private void assertAgrees(Pattern pattern, String regex, String value) {
    Boolean actual = PrimitiveRegexes.matchesRegex(regex, value);
    assertThat(actual).as("regex %s against %s", regex, escape(value)).isNotNull();
    assertThat(actual.booleanValue()).as("regex %s against %s", regex, escape(value))
        .isEqualTo(pattern.matcher(value).matches());
  }

  private String escape(String value) {
    StringBuilder res = new StringBuilder("\"");
    for (char ch : value.toCharArray()) {
      if (ch < 32 || ch > 126) {
        res.append(String.format("\\u%04x", (int) ch));
      } else {
        res.append(ch);
      }
    }
    return res.append('"').toString();
  }
}
