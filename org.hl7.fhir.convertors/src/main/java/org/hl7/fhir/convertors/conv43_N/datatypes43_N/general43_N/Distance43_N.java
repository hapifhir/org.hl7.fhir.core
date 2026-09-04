package org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N;

import org.hl7.fhir.exceptions.FHIRException;

public class Distance43_N {
  public static org.hl7.fhir.model.core.Distance convertDistance(org.hl7.fhir.r4b.model.Distance src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Distance tgt = new org.hl7.fhir.model.core.Distance();
    Quantity43_N.copyQuantity(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Distance convertDistance(org.hl7.fhir.model.core.Distance src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Distance tgt = new org.hl7.fhir.r4b.model.Distance();
    Quantity43_N.copyQuantity(src, tgt);
    return tgt;
  }
}
