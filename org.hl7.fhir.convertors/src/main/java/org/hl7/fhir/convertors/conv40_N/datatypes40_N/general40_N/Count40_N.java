package org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N;

import org.hl7.fhir.exceptions.FHIRException;

public class Count40_N {
  public static org.hl7.fhir.model.core.Count convertCount(org.hl7.fhir.r4.model.Count src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Count tgt = new org.hl7.fhir.model.core.Count();
    Quantity40_N.copyQuantity(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Count convertCount(org.hl7.fhir.model.core.Count src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Count tgt = new org.hl7.fhir.r4.model.Count();
    Quantity40_N.copyQuantity(src, tgt);
    return tgt;
  }
}
