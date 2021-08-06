package org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Time10_50 {
  public static org.hl7.fhir.r5.model.TimeType convertTime(org.hl7.fhir.dstu2.model.TimeType src) throws FHIRException {
    org.hl7.fhir.r5.model.TimeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.TimeType(src.getValue()) : new org.hl7.fhir.r5.model.TimeType();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TimeType convertTime(org.hl7.fhir.r5.model.TimeType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.TimeType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.TimeType(src.getValue()) : new org.hl7.fhir.dstu2.model.TimeType();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    return tgt;
  }
}
