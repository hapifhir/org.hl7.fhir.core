package org.hl7.fhir.utilities.turtle;

import java.util.regex.Pattern;

// Created by claude-sonnet-4-6
public class TurtleIRIUtil {

  private TurtleIRIUtil() {
    throw new UnsupportedOperationException("Utility class");
  }

  //   %XX          a percent-encoded octet (two hex digits)
  @SuppressWarnings("checkstyle:patternUsage")
  //fixed-width hex pair, safe
  private static final Pattern HEX_PAIR = Pattern.compile("[0-9a-fA-F]{2}");
  //   [...]        a literal IRI character: ASCII unreserved (alphanumeric, -._~),
  //                sub-delimiters (!$&'()*+,;=), gen-delimiters (:@/?#),
  //                slash (/), and non-ASCII Unicode (U+00A0–U+10FFFF)
  @SuppressWarnings("checkstyle:patternUsage")
  //fixed-width IRI character class, safe
  private static final Pattern IRI_CHAR  = Pattern.compile("[&'()*+,;:@_~?!$/\\-#.=a-zA-Z0-9\\x{00A0}-\\x{10FFFF}]");

  @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
  //False positive: not using String.matches
  private static boolean isHexDigit(String twoChars) {
    return HEX_PAIR.matcher(twoChars).matches();
  }

  @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
  //False positive: not using String.matches
  private static boolean isIriChar(int cp) {
    return IRI_CHAR.matcher(new String(Character.toChars(cp))).matches();
  }

  public static boolean isValidIRI(String uri) {
    if (uri.isEmpty()) return false;
    int i = 0;
    while (i < uri.length()) {
      if (uri.charAt(i) == '%') {
        if (i + 2 >= uri.length() || !isHexDigit(uri.substring(i + 1, i + 3)))
          return false;
        i += 3;
      } else {
        int cp = uri.codePointAt(i);
        if (!isIriChar(cp)) return false;
        // BMP code points (U+0000–U+FFFF) occupy one char; supplementary code points (U+10000–U+10FFFF) occupy two (a surrogate pair).
        i += Character.charCount(cp);
      }
    }
    return true;
  }
}
