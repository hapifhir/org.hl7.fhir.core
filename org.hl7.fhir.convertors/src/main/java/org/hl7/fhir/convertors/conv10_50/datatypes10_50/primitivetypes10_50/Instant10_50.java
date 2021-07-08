package org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50;

import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Element10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Instant10_50 {
    public static org.hl7.fhir.r5.model.InstantType convertInstant(org.hl7.fhir.dstu2.model.InstantType src) throws FHIRException {
      org.hl7.fhir.r5.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.InstantType(src.getValue()) : new org.hl7.fhir.r5.model.InstantType();
      Element10_50.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.InstantType convertInstant(org.hl7.fhir.r5.model.InstantType src) throws FHIRException {
      org.hl7.fhir.dstu2.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.InstantType(src.getValue()) : new org.hl7.fhir.dstu2.model.InstantType();
      Element10_50.copyElement(src, tgt);
      return tgt;
    }
}
