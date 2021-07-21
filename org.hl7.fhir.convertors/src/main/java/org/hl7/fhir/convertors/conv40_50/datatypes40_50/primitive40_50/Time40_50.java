package org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50;

import org.hl7.fhir.convertors.VersionConvertor_40_50_Context;
import org.hl7.fhir.exceptions.FHIRException;

public class Time40_50 {
  public static org.hl7.fhir.r5.model.TimeType convertTime(org.hl7.fhir.r4.model.TimeType src) throws FHIRException {
    org.hl7.fhir.r5.model.TimeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.TimeType(src.getValue()) : new org.hl7.fhir.r5.model.TimeType();
    VersionConvertor_40_50_Context.INSTANCE.getVersionConvertor_40_50_a().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TimeType convertTime(org.hl7.fhir.r5.model.TimeType src) throws FHIRException {
    org.hl7.fhir.r4.model.TimeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.TimeType(src.getValue()) : new org.hl7.fhir.r4.model.TimeType();
    VersionConvertor_40_50_Context.INSTANCE.getVersionConvertor_40_50_a().copyElement(src, tgt);
    return tgt;
  }
}
