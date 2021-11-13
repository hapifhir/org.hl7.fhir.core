package org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50;

import org.hl7.fhir.exceptions.FHIRException;

public class Age40_50 {
  public static org.hl7.fhir.r5.model.Age convertAge(org.hl7.fhir.r4.model.Age src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Age tgt = new org.hl7.fhir.r5.model.Age();
    Quantity40_50.copyQuantity(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Age convertAge(org.hl7.fhir.r5.model.Age src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Age tgt = new org.hl7.fhir.r4.model.Age();
    Quantity40_50.copyQuantity(src, tgt);
    return tgt;
  }
}
