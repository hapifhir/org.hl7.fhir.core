package org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N;

import org.hl7.fhir.exceptions.FHIRException;

public class Count43_N {
  public static org.hl7.fhir.model.core.Count convertCount(org.hl7.fhir.r4b.model.Count src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Count tgt = new org.hl7.fhir.model.core.Count();
    Quantity43_N.copyQuantity(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Count convertCount(org.hl7.fhir.model.core.Count src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Count tgt = new org.hl7.fhir.r4b.model.Count();
    Quantity43_N.copyQuantity(src, tgt);
    return tgt;
  }
}
