package org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Time43_N {
  public static org.hl7.fhir.model.core.TimeType convertTime(org.hl7.fhir.r4b.model.TimeType src) throws FHIRException {
    org.hl7.fhir.model.core.TimeType tgt = src.hasValue() ? new org.hl7.fhir.model.core.TimeType(src.getValue()) : new org.hl7.fhir.model.core.TimeType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TimeType convertTime(org.hl7.fhir.model.core.TimeType src) throws FHIRException {
    org.hl7.fhir.r4b.model.TimeType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.TimeType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.TimeType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }
}
