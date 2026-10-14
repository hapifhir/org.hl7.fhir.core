package org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N;

import org.hl7.fhir.exceptions.FHIRException;

public class Age43_N {
  public static org.hl7.fhir.model.core.Age convertAge(org.hl7.fhir.r4b.model.Age src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Age tgt = new org.hl7.fhir.model.core.Age();
    Quantity43_N.copyQuantity(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Age convertAge(org.hl7.fhir.model.core.Age src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Age tgt = new org.hl7.fhir.r4b.model.Age();
    Quantity43_N.copyQuantity(src, tgt);
    return tgt;
  }
}
