package org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50;

import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Element30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Uuid30_50 {
    public static org.hl7.fhir.r5.model.UuidType convertUuid(org.hl7.fhir.dstu3.model.UuidType src) throws FHIRException {
      org.hl7.fhir.r5.model.UuidType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UuidType(src.getValue()) : new org.hl7.fhir.r5.model.UuidType();
      Element30_50.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.UuidType convertUuid(org.hl7.fhir.r5.model.UuidType src) throws FHIRException {
      org.hl7.fhir.dstu3.model.UuidType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.UuidType(src.getValue()) : new org.hl7.fhir.dstu3.model.UuidType();
      Element30_50.copyElement(src, tgt);
      return tgt;
    }
}
