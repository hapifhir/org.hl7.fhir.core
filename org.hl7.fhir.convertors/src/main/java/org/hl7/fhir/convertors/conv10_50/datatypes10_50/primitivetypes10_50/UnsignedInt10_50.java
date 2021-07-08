package org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50;

import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Element10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class UnsignedInt10_50 {
    public static org.hl7.fhir.r5.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.dstu2.model.UnsignedIntType src) throws FHIRException {
      org.hl7.fhir.r5.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UnsignedIntType(src.getValue()) : new org.hl7.fhir.r5.model.UnsignedIntType();
      Element10_50.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.r5.model.UnsignedIntType src) throws FHIRException {
      org.hl7.fhir.dstu2.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.UnsignedIntType(src.getValue()) : new org.hl7.fhir.dstu2.model.UnsignedIntType();
      Element10_50.copyElement(src, tgt);
      return tgt;
    }
}
