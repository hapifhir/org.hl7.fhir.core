package org.hl7.fhir.utilities.regex;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RegexTimeoutTests {

  public static final String NORMAL_STRING = "a".repeat(10) + "!";
  public static final String EVIL_STRING = "a".repeat(50) + "!";

  public static final String BAD_REGEX = "((a+)+)+";

  // BAD_REGEX causes catastrophic backtracking only for matches() (full-string match).
  // For find/replace/split, the engine greedily matches the leading a's and returns immediately.
  // BAD_SUFFIX_REGEX requires a trailing 'b' that never appears, forcing exhaustive backtracking
  // for find/replace/split as well.
  static final String BAD_SUFFIX_REGEX = "((a+)+)+b";
  static final String EVIL_NO_SUFFIX = "a".repeat(50);

  @Test
  void test_BadRegex_Matches_EvilString() {
    assertThrows( TimeoutException.class, () -> RegexTimeout.matches(EVIL_STRING, BAD_REGEX));
  }

  @Test
  void test_BadRegex_Matches_NormalString() throws TimeoutException {
    Boolean actual = RegexTimeout.matches(NORMAL_STRING, BAD_REGEX);
    assertThat(actual).isEqualTo(NORMAL_STRING.matches(BAD_REGEX));
    assertThat(actual).isFalse();
  }

  // find()

  @Test
  void test_BadRegex_Find_EvilString() {
    assertThrows(TimeoutException.class, () -> RegexTimeout.find(EVIL_NO_SUFFIX, BAD_SUFFIX_REGEX));
  }

  @Test
  void test_BadRegex_Find_NormalString() throws TimeoutException {
    boolean actual = RegexTimeout.find(NORMAL_STRING, BAD_REGEX);
    assertThat(actual).isEqualTo(Pattern.compile(BAD_REGEX).matcher(NORMAL_STRING).find());
    assertThat(actual).isTrue();
  }

  @Test
  void test_NormalRegex_Find_ReturnsFalse() throws TimeoutException {
    assertThat(RegexTimeout.find("123", "[a-z]+")).isFalse();
  }

  // replaceAll()

  @Test
  void test_BadRegex_ReplaceAll_EvilString() {
    assertThrows(TimeoutException.class, () -> RegexTimeout.replaceAll(EVIL_NO_SUFFIX, BAD_SUFFIX_REGEX, "X"));
  }

  @Test
  void test_NormalRegex_ReplaceAll() throws TimeoutException {
    assertThat(RegexTimeout.replaceAll("hello world", "\\w+", "X")).isEqualTo("X X");
  }

  // replaceFirst()

  @Test
  void test_BadRegex_ReplaceFirst_EvilString() {
    assertThrows(TimeoutException.class, () -> RegexTimeout.replaceFirst(EVIL_NO_SUFFIX, BAD_SUFFIX_REGEX, "X"));
  }

  @Test
  void test_NormalRegex_ReplaceFirst() throws TimeoutException {
    assertThat(RegexTimeout.replaceFirst("hello world", "\\w+", "X")).isEqualTo("X world");
  }

  // split()

  @Test
  void test_BadRegex_Split_EvilString() {
    assertThrows(TimeoutException.class, () -> RegexTimeout.split(EVIL_NO_SUFFIX, BAD_SUFFIX_REGEX));
  }

  @Test
  void test_NormalRegex_Split() throws TimeoutException {
    assertThat(RegexTimeout.split("a,b,c", ",")).isEqualTo(new String[]{"a", "b", "c"});
  }

  // split(limit)

  @Test
  void test_BadRegex_SplitWithLimit_EvilString() {
    assertThrows(TimeoutException.class, () -> RegexTimeout.split(EVIL_NO_SUFFIX, BAD_SUFFIX_REGEX, 2));
  }

  @Test
  void test_NormalRegex_SplitWithLimit() throws TimeoutException {
    assertThat(RegexTimeout.split("a,b,c", ",", 2)).isEqualTo(new String[]{"a", "b,c"});
  }
}
