package org.hl7.fhir.utilities;

public class ColorUtilities {
  public static final String SYSTEM_COLOR_NAME = "http://hl7.org/fhir/color-names";
  public static final String SYSTEM_COLOR_RGB = "http://hl7.org/fhir/color-rgb";

  public static boolean isRGB(String value) {
    if (value == null || value.length() != 7 || value.charAt(0) != '#') {
      return false;
    }
    for (int i = 1; i < 7; i++) {
      if (Character.digit(value.charAt(i), 16) == -1) {
        return false;
      }
    }
    return true;
  }
}
