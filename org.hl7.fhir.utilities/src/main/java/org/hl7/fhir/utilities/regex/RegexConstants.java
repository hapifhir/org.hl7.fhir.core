package org.hl7.fhir.utilities.regex;

public class RegexConstants {
  private RegexConstants() {
    throw new UnsupportedOperationException("This utility class should not be instantiated");
  }

  public static final String ID_REGEX = "[A-Za-z0-9\\-\\.]{1,64}";
}
