package org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50;

import org.hl7.fhir.exceptions.FHIRException;

public class Duration43_50 {
  public static org.hl7.fhir.r5.model.Duration convertDuration(org.hl7.fhir.r4b.model.Duration src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Duration tgt = new org.hl7.fhir.r5.model.Duration();
    Quantity43_50.copyQuantity(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Duration convertDuration(org.hl7.fhir.r5.model.Duration src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Duration tgt = new org.hl7.fhir.r4b.model.Duration();
    Quantity43_50.copyQuantity(src, tgt);
    return tgt;
  }
}
