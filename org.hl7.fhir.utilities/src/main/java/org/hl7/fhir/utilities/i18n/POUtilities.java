package org.hl7.fhir.utilities.i18n;

public class POUtilities {

  public static final String OUTDATED_PREFIX = "!!";

  static String trimQuotes(String s) {
    s = s.trim();
    if (s.startsWith("\"")) {
      s = s.substring(1);
    }
    if (s.endsWith("\"")) {
      s = s.substring(0, s.length()-1);
    }
    return s.trim().replace("\\\"", "\"");
  }

  /**
   * This regex should catch ONLY quotes that haven't already been escaped.
   * <p/>
   * So, " would be found, but not \"
   * <p/>
   * Originally, this appeared as: (?<!\\)", which needs the extra Java escapes below to work.
  **/
  static final String WRAP_REGEX = "(?<!\\\\)\"";

  static String escapeNonEscapedQuotes(String s) {
    /*
      Replace non escaped quotes with \"
      Be mindful that multiple \ characters are needed to escape the escapes in Java
    */
    return s.replaceAll(WRAP_REGEX, "\\\\\"");
  }

  public static boolean isOutdated(String text) {
    return text.startsWith(OUTDATED_PREFIX);
  }
  
  public static String tagAsOutdated(String text) {
    if (isOutdated(text)) {
      return text;
    }
    return OUTDATED_PREFIX + text;
   }
}
