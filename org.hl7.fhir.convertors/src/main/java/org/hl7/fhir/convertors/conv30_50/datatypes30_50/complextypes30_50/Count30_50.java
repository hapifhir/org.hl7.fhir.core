package org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50;

import org.hl7.fhir.exceptions.FHIRException;

public class Count30_50 {
    public static org.hl7.fhir.r5.model.Count convertCount(org.hl7.fhir.dstu3.model.Count src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r5.model.Count tgt = new org.hl7.fhir.r5.model.Count();
      Quantity30_50.copyQuantity(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Count convertCount(org.hl7.fhir.r5.model.Count src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.Count tgt = new org.hl7.fhir.dstu3.model.Count();
      Quantity30_50.copyQuantity(src, tgt);
      return tgt;
    }
}
