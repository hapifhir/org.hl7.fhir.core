package org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50;

import org.hl7.fhir.exceptions.FHIRException;

public class Age43_50 {
  public static org.hl7.fhir.r5.model.Age convertAge(org.hl7.fhir.r4b.model.Age src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Age tgt = new org.hl7.fhir.r5.model.Age();
    Quantity43_50.copyQuantity(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Age convertAge(org.hl7.fhir.r5.model.Age src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Age tgt = new org.hl7.fhir.r4b.model.Age();
    Quantity43_50.copyQuantity(src, tgt);
    return tgt;
  }
}
