package org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50;

import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Element30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Instant30_50 {
    public static org.hl7.fhir.r5.model.InstantType convertInstant(org.hl7.fhir.dstu3.model.InstantType src) throws FHIRException {
      org.hl7.fhir.r5.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.InstantType(src.getValueAsString()) : new org.hl7.fhir.r5.model.InstantType();
      Element30_50.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.InstantType convertInstant(org.hl7.fhir.r5.model.InstantType src) throws FHIRException {
      org.hl7.fhir.dstu3.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.InstantType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.InstantType();
      Element30_50.copyElement(src, tgt);
      return tgt;
    }
}
