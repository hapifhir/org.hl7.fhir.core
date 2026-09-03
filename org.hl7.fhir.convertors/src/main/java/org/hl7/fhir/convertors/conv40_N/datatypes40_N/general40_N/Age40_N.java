package org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N;

import org.hl7.fhir.exceptions.FHIRException;

public class Age40_N {
  public static org.hl7.fhir.model.core.Age convertAge(org.hl7.fhir.r4.model.Age src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Age tgt = new org.hl7.fhir.model.core.Age();
    Quantity40_N.copyQuantity(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Age convertAge(org.hl7.fhir.model.core.Age src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Age tgt = new org.hl7.fhir.r4.model.Age();
    Quantity40_N.copyQuantity(src, tgt);
    return tgt;
  }
}
