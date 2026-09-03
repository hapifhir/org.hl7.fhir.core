package org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Time40_N {
  public static org.hl7.fhir.model.core.TimeType convertTime(org.hl7.fhir.r4.model.TimeType src) throws FHIRException {
    org.hl7.fhir.model.core.TimeType tgt = src.hasValue() ? new org.hl7.fhir.model.core.TimeType(src.getValue()) : new org.hl7.fhir.model.core.TimeType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TimeType convertTime(org.hl7.fhir.model.core.TimeType src) throws FHIRException {
    org.hl7.fhir.r4.model.TimeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.TimeType(src.getValueAsString()) : new org.hl7.fhir.r4.model.TimeType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }
}
