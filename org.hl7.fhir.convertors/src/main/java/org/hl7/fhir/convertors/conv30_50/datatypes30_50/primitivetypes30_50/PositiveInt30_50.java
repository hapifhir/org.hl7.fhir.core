package org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50;

import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Element30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class PositiveInt30_50 {
    public static org.hl7.fhir.r5.model.PositiveIntType convertPositiveInt(org.hl7.fhir.dstu3.model.PositiveIntType src) throws FHIRException {
      org.hl7.fhir.r5.model.PositiveIntType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.PositiveIntType(src.getValue()) : new org.hl7.fhir.r5.model.PositiveIntType();
      Element30_50.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PositiveIntType convertPositiveInt(org.hl7.fhir.r5.model.PositiveIntType src) throws FHIRException {
      org.hl7.fhir.dstu3.model.PositiveIntType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.PositiveIntType(src.getValue()) : new org.hl7.fhir.dstu3.model.PositiveIntType();
      Element30_50.copyElement(src, tgt);
      return tgt;
    }
}
