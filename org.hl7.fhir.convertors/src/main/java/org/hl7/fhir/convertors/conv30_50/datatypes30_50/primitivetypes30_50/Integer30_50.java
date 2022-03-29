package org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Integer30_50 {
  public static org.hl7.fhir.r5.model.IntegerType convertInteger(org.hl7.fhir.dstu3.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.r5.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.IntegerType(src.getValueAsString()) : new org.hl7.fhir.r5.model.IntegerType();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.IntegerType convertInteger(org.hl7.fhir.r5.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.IntegerType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.IntegerType();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    return tgt;
  }
}
