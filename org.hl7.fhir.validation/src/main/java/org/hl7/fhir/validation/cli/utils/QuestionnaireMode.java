package org.hl7.fhir.validation.cli.utils;

import org.hl7.fhir.utilities.Utilities;

public enum QuestionnaireMode {
  NONE,
  CHECK,
  REQUIRED;

  public static QuestionnaireMode fromCode(String v) {
    if (Utilities.noString(v)) {
      return NONE;
    }
    v = v.toLowerCase();
    if (Utilities.existsInList(v, "none", "ignore")) {
      return NONE;
    }
    if (Utilities.existsInList(v, "check")) {
      return CHECK;
    }
    if (Utilities.existsInList(v, "require", "required")) {
      return REQUIRED;
    }
    return NONE;
  }
}
