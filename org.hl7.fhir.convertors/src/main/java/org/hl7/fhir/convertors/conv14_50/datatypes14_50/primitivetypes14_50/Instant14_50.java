package org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50;

import org.hl7.fhir.convertors.context.ConversionContext14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Instant14_50 {
  public static org.hl7.fhir.r5.model.InstantType convertInstant(org.hl7.fhir.dstu2016may.model.InstantType src) throws FHIRException {
    org.hl7.fhir.r5.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.InstantType(src.getValueAsString()) : new org.hl7.fhir.r5.model.InstantType();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.InstantType convertInstant(org.hl7.fhir.r5.model.InstantType src) throws FHIRException {
    org.hl7.fhir.dstu2016may.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.dstu2016may.model.InstantType(src.getValueAsString()) : new org.hl7.fhir.dstu2016may.model.InstantType();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    return tgt;
  }
}
