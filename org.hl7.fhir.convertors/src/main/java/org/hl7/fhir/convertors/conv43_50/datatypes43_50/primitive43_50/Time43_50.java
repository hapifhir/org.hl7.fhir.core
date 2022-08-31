package org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Time43_50 {
  public static org.hl7.fhir.r5.model.TimeType convertTime(org.hl7.fhir.r4b.model.TimeType src) throws FHIRException {
    org.hl7.fhir.r5.model.TimeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.TimeType(src.getValue()) : new org.hl7.fhir.r5.model.TimeType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TimeType convertTime(org.hl7.fhir.r5.model.TimeType src) throws FHIRException {
    org.hl7.fhir.r4b.model.TimeType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.TimeType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.TimeType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }
}
