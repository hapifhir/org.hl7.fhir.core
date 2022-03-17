package org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30;

import org.hl7.fhir.convertors.context.ConversionContext14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class PositiveInt14_30 {
  public static org.hl7.fhir.dstu3.model.PositiveIntType convertPositiveInt(org.hl7.fhir.dstu2016may.model.PositiveIntType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.PositiveIntType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.PositiveIntType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.PositiveIntType();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.PositiveIntType convertPositiveInt(org.hl7.fhir.dstu3.model.PositiveIntType src) throws FHIRException {
    org.hl7.fhir.dstu2016may.model.PositiveIntType tgt = src.hasValue() ? new org.hl7.fhir.dstu2016may.model.PositiveIntType(src.getValueAsString()) : new org.hl7.fhir.dstu2016may.model.PositiveIntType();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    return tgt;
  }
}
