package org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50;

import org.hl7.fhir.exceptions.FHIRException;

public class Count43_50 {
  public static org.hl7.fhir.r5.model.Count convertCount(org.hl7.fhir.r4b.model.Count src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Count tgt = new org.hl7.fhir.r5.model.Count();
    Quantity43_50.copyQuantity(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Count convertCount(org.hl7.fhir.r5.model.Count src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Count tgt = new org.hl7.fhir.r4b.model.Count();
    Quantity43_50.copyQuantity(src, tgt);
    return tgt;
  }
}
