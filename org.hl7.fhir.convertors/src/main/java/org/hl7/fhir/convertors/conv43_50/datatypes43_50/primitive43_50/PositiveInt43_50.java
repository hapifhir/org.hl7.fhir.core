package org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class PositiveInt43_50 {
  public static org.hl7.fhir.r5.model.PositiveIntType convertPositiveInt(org.hl7.fhir.r4b.model.PositiveIntType src) throws FHIRException {
    org.hl7.fhir.r5.model.PositiveIntType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.PositiveIntType(src.getValueAsString()) : new org.hl7.fhir.r5.model.PositiveIntType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.PositiveIntType convertPositiveInt(org.hl7.fhir.r5.model.PositiveIntType src) throws FHIRException {
    org.hl7.fhir.r4b.model.PositiveIntType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.PositiveIntType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.PositiveIntType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }
}
