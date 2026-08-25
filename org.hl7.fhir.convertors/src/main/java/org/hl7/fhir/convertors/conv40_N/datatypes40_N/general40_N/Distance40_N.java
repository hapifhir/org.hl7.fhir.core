package org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N;

import org.hl7.fhir.exceptions.FHIRException;

public class Distance40_N {
  public static org.hl7.fhir.model.core.Distance convertDistance(org.hl7.fhir.r4.model.Distance src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Distance tgt = new org.hl7.fhir.model.core.Distance();
    Quantity40_N.copyQuantity(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Distance convertDistance(org.hl7.fhir.model.core.Distance src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Distance tgt = new org.hl7.fhir.r4.model.Distance();
    Quantity40_N.copyQuantity(src, tgt);
    return tgt;
  }
}
