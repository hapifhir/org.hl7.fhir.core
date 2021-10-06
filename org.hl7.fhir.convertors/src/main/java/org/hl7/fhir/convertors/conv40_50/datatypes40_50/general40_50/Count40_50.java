package org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50;

import org.hl7.fhir.exceptions.FHIRException;

public class Count40_50 {
  public static org.hl7.fhir.r5.model.Count convertCount(org.hl7.fhir.r4.model.Count src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Count tgt = new org.hl7.fhir.r5.model.Count();
    Quantity40_50.copyQuantity(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Count convertCount(org.hl7.fhir.r5.model.Count src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Count tgt = new org.hl7.fhir.r4.model.Count();
    Quantity40_50.copyQuantity(src, tgt);
    return tgt;
  }
}
