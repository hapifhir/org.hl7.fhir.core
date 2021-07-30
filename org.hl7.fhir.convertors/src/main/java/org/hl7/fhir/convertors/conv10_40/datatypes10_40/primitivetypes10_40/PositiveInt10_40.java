package org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40;

import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class PositiveInt10_40 {
  public static org.hl7.fhir.r4.model.PositiveIntType convertPositiveInt(org.hl7.fhir.dstu2.model.PositiveIntType src) throws FHIRException {
    org.hl7.fhir.r4.model.PositiveIntType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.PositiveIntType(src.getValue()) : new org.hl7.fhir.r4.model.PositiveIntType();
    Element10_40.copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.PositiveIntType convertPositiveInt(org.hl7.fhir.r4.model.PositiveIntType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.PositiveIntType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.PositiveIntType(src.getValue()) : new org.hl7.fhir.dstu2.model.PositiveIntType();
    Element10_40.copyElement(src, tgt);
    return tgt;
  }
}
