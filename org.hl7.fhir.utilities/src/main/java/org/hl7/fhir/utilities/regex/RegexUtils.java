package org.hl7.fhir.utilities.regex;

import java.util.regex.Pattern;

public class RegexUtils {
  private RegexUtils() {
    throw new UnsupportedOperationException("This utility class should not be instantiated");
  }


  /**
   * <p>
   * A utility to simplify the verification of strings expected to be split into multiple entries (OIDs, NPM package names, etc.)
   * </p>
   *
   * @apiNote This method accepts caller provided regular expressions, and its usage should be restricted to known or
   * evaluated safe regular expressions.
   *
   * @param string A string to split into entries and match against a regex
   * @param splitRegex The regex to split the string by
   * @param entryRegex The regex to match each entry by
   * @param minEntries The minimum expected number of entries, or -1 to not check
   * @param maxEntries The maximum expected number of entries, or -1 to not check
   * @return true if the regex matches all entries
   */
  public static boolean splitRegexMatch(final String string, final String splitRegex, String entryRegex, int minEntries, int maxEntries) {
    final String[] entries = string.split(splitRegex);
    if (minEntries >= 0 && entries.length < minEntries) {
      return false;
    }
    if (maxEntries >= 0 && entries.length > maxEntries) {
      return false;
    }
    Pattern pattern = Pattern.compile(entryRegex);

    for (String entry : entries) {
      if (!pattern.matcher(entry).matches()) {
        return false;
      }
    }
    return true;
  }
}
