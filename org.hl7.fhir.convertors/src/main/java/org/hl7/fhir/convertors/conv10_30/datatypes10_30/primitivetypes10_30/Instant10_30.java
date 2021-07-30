package org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30;

import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Instant10_30 {
  public static org.hl7.fhir.dstu3.model.InstantType convertInstant(org.hl7.fhir.dstu2.model.InstantType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.InstantType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.InstantType();
    Element10_30.copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.InstantType convertInstant(org.hl7.fhir.dstu3.model.InstantType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.InstantType(src.getValueAsString()) : new org.hl7.fhir.dstu2.model.InstantType();
    Element10_30.copyElement(src, tgt);
    return tgt;
  }
}
