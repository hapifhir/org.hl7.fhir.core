package org.hl7.fhir.utilities.regex;

/**
 * This class contains regular expressions that are used throughout the codebase.
 * </p>
 * Any regexes here should be evaluated for possible catastrophic backtracking (as much as is possible) and verified to
 * be safe.
 */
public class RegexConstants {
  private RegexConstants() {
    throw new UnsupportedOperationException("This utility class should not be instantiated");
  }

  public static final String ID_REGEX = "[A-Za-z0-9\\-\\.]{1,64}";

  public static final String INSTANT_REGEX =
      "([0-9]([0-9]([0-9][1-9]|[1-9]0)|[1-9]00)|[1-9]000)-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])" +
      "T([01][0-9]|2[0-3]):[0-5][0-9]:([0-5][0-9]|60)(\\.[0-9]{1,9})?" +
      "(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))";

  public static final String DATE_REGEX =
      "([0-9]([0-9]([0-9][1-9]|[1-9]0)|[1-9]00)|[1-9]000)-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])" +
      "(T([01][0-9]|2[0-3]):[0-5][0-9]:([0-5][0-9]|60)(\\.[0-9]{1,9})?" +
      "(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00)))?";

  public static final String URN_UUID_REGEX =
      "urn:uuid:[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}";

  public static final String URL_REGEX =
      "^(((https?)://)(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:|:blank:]])?$";

  public static final String TOKEN_REGEX =
      "[0-9a-zA-Z_][0-9a-zA-Z_\\.\\-]*";
}
