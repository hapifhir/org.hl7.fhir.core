package org.hl7.fhir.validation.cli.utils;

import org.hl7.fhir.utilities.Utilities;

public enum ValidationLevel {
  HINTS,
  WARNINGS,
  ERRORS;

  public static ValidationLevel fromCode(String v) {
    if (Utilities.noString(v)) {
      return HINTS;
    }
    v = v.toLowerCase();
    if (Utilities.existsInList(v, "h", "i", "hints", "info")) {
      return HINTS;
    }
    if (Utilities.existsInList(v, "w", "warning", "warnings")) {
      return WARNINGS;
    }
    if (Utilities.existsInList(v, "e", "error", "errors")) {
      return ERRORS;
    }
    return HINTS;
  }
}
