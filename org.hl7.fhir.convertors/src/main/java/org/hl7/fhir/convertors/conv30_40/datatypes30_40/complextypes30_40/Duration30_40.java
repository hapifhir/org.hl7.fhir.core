package org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40;

import org.hl7.fhir.exceptions.FHIRException;

public class Duration30_40 {
  public static org.hl7.fhir.r4.model.Duration convertDuration(org.hl7.fhir.dstu3.model.Duration src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Duration tgt = new org.hl7.fhir.r4.model.Duration();
    Quantity30_40.copyQuantity(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Duration convertDuration(org.hl7.fhir.r4.model.Duration src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.Duration tgt = new org.hl7.fhir.dstu3.model.Duration();
    Quantity30_40.copyQuantity(src, tgt);
    return tgt;
  }
}
