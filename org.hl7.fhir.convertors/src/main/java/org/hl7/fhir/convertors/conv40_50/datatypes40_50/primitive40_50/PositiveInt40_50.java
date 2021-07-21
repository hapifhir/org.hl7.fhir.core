package org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50;

import org.hl7.fhir.convertors.VersionConvertor_40_50_Context;
import org.hl7.fhir.exceptions.FHIRException;

public class PositiveInt40_50 {
  public static org.hl7.fhir.r5.model.PositiveIntType convertPositiveInt(org.hl7.fhir.r4.model.PositiveIntType src) throws FHIRException {
    org.hl7.fhir.r5.model.PositiveIntType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.PositiveIntType(src.getValue()) : new org.hl7.fhir.r5.model.PositiveIntType();
    VersionConvertor_40_50_Context.INSTANCE.getVersionConvertor_40_50_a().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PositiveIntType convertPositiveInt(org.hl7.fhir.r5.model.PositiveIntType src) throws FHIRException {
    org.hl7.fhir.r4.model.PositiveIntType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.PositiveIntType(src.getValue()) : new org.hl7.fhir.r4.model.PositiveIntType();
    VersionConvertor_40_50_Context.INSTANCE.getVersionConvertor_40_50_a().copyElement(src, tgt);
    return tgt;
  }
}
