package org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50;

import org.hl7.fhir.convertors.VersionConvertor_40_50_Context;
import org.hl7.fhir.exceptions.FHIRException;

public class Uuid40_50 {
  public static org.hl7.fhir.r5.model.UuidType convertUuid(org.hl7.fhir.r4.model.UuidType src) throws FHIRException {
    org.hl7.fhir.r5.model.UuidType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UuidType(src.getValue()) : new org.hl7.fhir.r5.model.UuidType();
    VersionConvertor_40_50_Context.INSTANCE.getVersionConvertor_40_50_a().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.UuidType convertUuid(org.hl7.fhir.r5.model.UuidType src) throws FHIRException {
    org.hl7.fhir.r4.model.UuidType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UuidType(src.getValue()) : new org.hl7.fhir.r4.model.UuidType();
    VersionConvertor_40_50_Context.INSTANCE.getVersionConvertor_40_50_a().copyElement(src, tgt);
    return tgt;
  }
}
