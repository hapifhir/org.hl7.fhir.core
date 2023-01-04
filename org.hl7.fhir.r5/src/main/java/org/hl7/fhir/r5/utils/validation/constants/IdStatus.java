package org.hl7.fhir.r5.utils.validation.constants;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;

public enum IdStatus {
  OPTIONAL,
  REQUIRED,
  PROHIBITED;

  public static IdStatus fromCode(String v) {
    if (v == null || Utilities.noString(v)) {
      return null;
    } else {
      v = v.toLowerCase();
      if (v.equals("optional")) {
        return OPTIONAL;
      } else if (v.equals("required")) {
        return REQUIRED;
      } else if (v.equals("prohibited")) {
        return PROHIBITED;
      } else {
        throw new FHIRException("Unkonwn Id Status code '"+v+"'");
      }
    }
  }
}
