package org.hl7.fhir.r4.utils;

import org.hl7.fhir.utilities.Utilities;

public class FHIRPathConstant {

  public static boolean isFHIRPathConstant(String string) {
    return !Utilities.noString(string) && ((string.charAt(0) == '\'' || string.charAt(0) == '"') || string.charAt(0) == '@' || string.charAt(0) == '%' ||
      string.charAt(0) == '-' || string.charAt(0) == '+' || (string.charAt(0) >= '0' && string.charAt(0) <= '9') ||
      string.equals("true") || string.equals("false") || string.equals("{}"));
  }

  public static boolean isFHIRPathFixedName(String string) {
    return string != null && (string.charAt(0) == '`');
  }

  public static boolean isFHIRPathStringConstant(String string) {
    return string.charAt(0) == '\'' || string.charAt(0) == '"' || string.charAt(0) == '`';
  }
}
