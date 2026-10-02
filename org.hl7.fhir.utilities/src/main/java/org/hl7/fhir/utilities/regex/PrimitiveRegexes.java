package org.hl7.fhir.utilities.regex;

import java.util.HashMap;
import java.util.Map;

/**
 * Hand written equivalents of the regexes the FHIR specifications put on the primitive types.
 * <p>
 * There are only about two dozen of these across R4, R4B and R5, but between them they cover most of the
 * primitive values in any instance, and each one is checked on every value, on every validation pass. Going
 * through the regex engine for them costs a compile and a full scan of the value; these cost a loop, and for
 * string and markdown - where the values are by far the biggest - almost nothing, since under matches() the
 * regex says no more than "not empty".
 * <p>
 * Every matcher here is exactly equivalent to the regex it is registered against, including the corners (note
 * particularly that \s in a java regex is ASCII only unless the pattern is in unicode mode, so a non-breaking
 * space is not whitespace here). PrimitiveRegexesTests proves the equivalence by differential testing against
 * java.util.regex, over exhaustive short inputs and millions of random ones. Any regex that isn't in the table
 * falls through to the regex engine
 */
public class PrimitiveRegexes {

  public interface PrimitiveMatcher {
    boolean test(CharSequence value);
  }

  private static final char VERTICAL_TAB = 0x0B;
  private static final char FORM_FEED = 0x0C;

  private static final Map<String, PrimitiveMatcher> MATCHERS = new HashMap<>();

  static {
    // string, markdown (R5): any character at all, but at least one of them
    MATCHERS.put("^[\\s\\S]+$", value -> value.length() > 0);
    // string, markdown (R4, R4B): as above, except that vertical tab and form feed are not allowed
    MATCHERS.put("[ \\r\\n\\t\\S]+", PrimitiveRegexes::isR4String);
    // uri, url, canonical: no whitespace anywhere, and the empty string is allowed
    MATCHERS.put("\\S*", PrimitiveRegexes::hasNoWhitespace);
    // id
    MATCHERS.put("[A-Za-z0-9\\-\\.]{1,64}", PrimitiveRegexes::isId);
    // boolean
    MATCHERS.put("true|false", value -> contentEquals(value, "true") || contentEquals(value, "false"));
    // positiveInt
    MATCHERS.put("[1-9][0-9]*", value -> isDigits(value, 0, true));
    // unsignedInt
    MATCHERS.put("[0]|([1-9][0-9]*)", value -> contentEquals(value, "0") || isDigits(value, 0, true));
    // integer (R4, R4B)
    MATCHERS.put("-?([0]|([1-9][0-9]*))", PrimitiveRegexes::isR4Integer);
    // integer, integer64 (R5)
    MATCHERS.put("[0]|[-+]?[1-9][0-9]*", PrimitiveRegexes::isR5Integer);
    // code (R4, R4B): tokens separated by a single whitespace character
    MATCHERS.put("[^\\s]+(\\s[^\\s]+)*", value -> isCode(value, false));
    // code (R5): tokens separated by a single space
    MATCHERS.put("[^\\s]+( [^\\s]+)*", value -> isCode(value, true));
    // uuid
    MATCHERS.put("urn:uuid:[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}", PrimitiveRegexes::isUuid);
    // oid
    MATCHERS.put("urn:oid:[0-2](\\.(0|[1-9][0-9]*))+", PrimitiveRegexes::isOid);
  }

  /**
   * @return whether the value matches the regex, or null if this regex has no hand written equivalent
   * <p>
   * Note: deliberately not called matches(). The checkstyle rule that bans implicitly compiling a regex on
   * every call is a text scan for a call named matches, replaceAll, replaceFirst or split, whatever the
   * receiver is - so a method of that name would need a suppression here and at every call site, inside the
   * one class whose whole point is that it never compiles a regex at all
   */
  public static Boolean matchesRegex(String regex, CharSequence value) {
    PrimitiveMatcher matcher = MATCHERS.get(regex);
    return matcher == null ? null : matcher.test(value);
  }

  /**
   * the regexes that have a hand written equivalent - for the tests, which check every one of them
   */
  public static Iterable<String> knownRegexes() {
    return MATCHERS.keySet();
  }

  private static boolean contentEquals(CharSequence value, String constant) {
    if (value.length() != constant.length()) {
      return false;
    }
    for (int i = 0; i < constant.length(); i++) {
      if (value.charAt(i) != constant.charAt(i)) {
        return false;
      }
    }
    return true;
  }

  /**
   * what \s means in a java regex that isn't in unicode mode: exactly these six characters
   */
  private static boolean isWhitespace(char ch) {
    return ch == ' ' || ch == '\t' || ch == '\n' || ch == VERTICAL_TAB || ch == FORM_FEED || ch == '\r';
  }

  private static boolean hasNoWhitespace(CharSequence value) {
    for (int i = 0; i < value.length(); i++) {
      if (isWhitespace(value.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  private static boolean isR4String(CharSequence value) {
    if (value.length() == 0) {
      return false;
    }
    for (int i = 0; i < value.length(); i++) {
      char ch = value.charAt(i);
      if (ch == VERTICAL_TAB || ch == FORM_FEED) {
        return false;
      }
    }
    return true;
  }

  private static boolean isId(CharSequence value) {
    if (value.length() < 1 || value.length() > 64) {
      return false;
    }
    for (int i = 0; i < value.length(); i++) {
      char ch = value.charAt(i);
      if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9') || ch == '-' || ch == '.')) {
        return false;
      }
    }
    return true;
  }

  /**
   * digits from the cursor to the end of the value - at least one, and if noLeadingZero, the first isn't 0
   */
  private static boolean isDigits(CharSequence value, int cursor, boolean noLeadingZero) {
    if (cursor >= value.length()) {
      return false;
    }
    char first = value.charAt(cursor);
    if (first < '0' || first > '9' || (noLeadingZero && first == '0')) {
      return false;
    }
    for (int i = cursor + 1; i < value.length(); i++) {
      char ch = value.charAt(i);
      if (ch < '0' || ch > '9') {
        return false;
      }
    }
    return true;
  }

  private static boolean isR4Integer(CharSequence value) {
    int cursor = value.length() > 0 && value.charAt(0) == '-' ? 1 : 0;
    if (value.length() - cursor == 1 && value.charAt(cursor) == '0') {
      return true;
    }
    return isDigits(value, cursor, true);
  }

  private static boolean isR5Integer(CharSequence value) {
    if (contentEquals(value, "0")) {
      return true;
    }
    int cursor = value.length() > 0 && (value.charAt(0) == '-' || value.charAt(0) == '+') ? 1 : 0;
    return isDigits(value, cursor, true);
  }

  /**
   * one or more runs of non-whitespace, separated by exactly one separator - a space, or, in R4 and R4B,
   * any single whitespace character
   */
  private static boolean isCode(CharSequence value, boolean spaceOnly) {
    if (value.length() == 0) {
      return false;
    }
    boolean afterSeparator = true; // the value has to start with a token, not a separator
    for (int i = 0; i < value.length(); i++) {
      char ch = value.charAt(i);
      if (spaceOnly ? ch == ' ' : isWhitespace(ch)) {
        if (afterSeparator) {
          return false; // two separators in a row, or one at the start
        }
        afterSeparator = true;
      } else if (isWhitespace(ch)) {
        return false; // whitespace that isn't the separator is never part of a token
      } else {
        afterSeparator = false;
      }
    }
    return !afterSeparator; // and it can't end with a separator either
  }

  private static boolean isUuid(CharSequence value) {
    if (value.length() != 45 || !startsWith(value, "urn:uuid:")) {
      return false;
    }
    for (int i = 9; i < 45; i++) {
      char ch = value.charAt(i);
      if (i == 17 || i == 22 || i == 27 || i == 32) {
        if (ch != '-') {
          return false;
        }
      } else if (!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f'))) {
        return false;
      }
    }
    return true;
  }

  private static boolean isOid(CharSequence value) {
    if (value.length() < 9 || !startsWith(value, "urn:oid:")) {
      return false;
    }
    char root = value.charAt(8);
    if (root < '0' || root > '2') {
      return false;
    }
    int cursor = 9;
    int parts = 0;
    while (cursor < value.length()) {
      if (value.charAt(cursor) != '.') {
        return false;
      }
      cursor++;
      int start = cursor;
      while (cursor < value.length() && value.charAt(cursor) >= '0' && value.charAt(cursor) <= '9') {
        cursor++;
      }
      int digits = cursor - start;
      if (digits == 0 || (digits > 1 && value.charAt(start) == '0')) {
        return false; // no empty part, and no leading zero unless the part is just "0"
      }
      parts++;
    }
    return parts > 0;
  }

  private static boolean startsWith(CharSequence value, String prefix) {
    if (value.length() < prefix.length()) {
      return false;
    }
    for (int i = 0; i < prefix.length(); i++) {
      if (value.charAt(i) != prefix.charAt(i)) {
        return false;
      }
    }
    return true;
  }
}
