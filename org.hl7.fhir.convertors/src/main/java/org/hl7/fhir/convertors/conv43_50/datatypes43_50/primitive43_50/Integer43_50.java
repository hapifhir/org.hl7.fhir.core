package org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Integer43_50 {
  public static org.hl7.fhir.r5.model.IntegerType convertInteger(org.hl7.fhir.r4b.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.r5.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.IntegerType(src.getValueAsString()) : new org.hl7.fhir.r5.model.IntegerType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.IntegerType convertInteger(org.hl7.fhir.r5.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.r4b.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.IntegerType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.IntegerType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }
}
