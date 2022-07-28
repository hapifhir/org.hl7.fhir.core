package org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50;

import org.hl7.fhir.exceptions.FHIRException;

public class Distance43_50 {
  public static org.hl7.fhir.r5.model.Distance convertDistance(org.hl7.fhir.r4b.model.Distance src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Distance tgt = new org.hl7.fhir.r5.model.Distance();
    Quantity43_50.copyQuantity(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Distance convertDistance(org.hl7.fhir.r5.model.Distance src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Distance tgt = new org.hl7.fhir.r4b.model.Distance();
    Quantity43_50.copyQuantity(src, tgt);
    return tgt;
  }
}
