package org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30;

import org.hl7.fhir.convertors.context.ConversionContext14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Time14_30 {
  public static org.hl7.fhir.dstu3.model.TimeType convertTime(org.hl7.fhir.dstu2016may.model.TimeType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.TimeType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.TimeType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.TimeType();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TimeType convertTime(org.hl7.fhir.dstu3.model.TimeType src) throws FHIRException {
    org.hl7.fhir.dstu2016may.model.TimeType tgt = src.hasValue() ? new org.hl7.fhir.dstu2016may.model.TimeType(src.getValueAsString()) : new org.hl7.fhir.dstu2016may.model.TimeType();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    return tgt;
  }
}
