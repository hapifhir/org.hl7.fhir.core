package org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N;

import org.hl7.fhir.exceptions.FHIRException;

public class Duration43_N {
  public static org.hl7.fhir.model.core.Duration convertDuration(org.hl7.fhir.r4b.model.Duration src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Duration tgt = new org.hl7.fhir.model.core.Duration();
    Quantity43_N.copyQuantity(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Duration convertDuration(org.hl7.fhir.model.core.Duration src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Duration tgt = new org.hl7.fhir.r4b.model.Duration();
    Quantity43_N.copyQuantity(src, tgt);
    return tgt;
  }
}
