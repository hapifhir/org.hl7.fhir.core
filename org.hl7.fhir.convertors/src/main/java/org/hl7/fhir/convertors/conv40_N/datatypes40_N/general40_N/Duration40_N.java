package org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N;

import org.hl7.fhir.exceptions.FHIRException;

public class Duration40_N {
  public static org.hl7.fhir.model.core.Duration convertDuration(org.hl7.fhir.r4.model.Duration src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Duration tgt = new org.hl7.fhir.model.core.Duration();
    Quantity40_N.copyQuantity(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Duration convertDuration(org.hl7.fhir.model.core.Duration src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Duration tgt = new org.hl7.fhir.r4.model.Duration();
    Quantity40_N.copyQuantity(src, tgt);
    return tgt;
  }
}
