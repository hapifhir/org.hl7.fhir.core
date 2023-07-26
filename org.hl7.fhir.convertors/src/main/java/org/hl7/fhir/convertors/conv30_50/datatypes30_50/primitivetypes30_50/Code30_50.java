package org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Code30_50 {
  public static org.hl7.fhir.r5.model.CodeType convertCode(org.hl7.fhir.dstu3.model.CodeType src) throws FHIRException {
    org.hl7.fhir.r5.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.CodeType(src.getValueAsString()) : new org.hl7.fhir.r5.model.CodeType();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CodeType convertCode(org.hl7.fhir.r5.model.CodeType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.CodeType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.CodeType();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CodeType convertStringToCode(org.hl7.fhir.dstu3.model.StringType src) throws FHIRException {
    org.hl7.fhir.r5.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.CodeType(src.getValue()) : new org.hl7.fhir.r5.model.CodeType();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.StringType convertCodeToString(org.hl7.fhir.r5.model.CodeType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.StringType(src.getValue()) : new org.hl7.fhir.dstu3.model.StringType();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CodeType convertStringToCode(org.hl7.fhir.r5.model.StringType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.CodeType(src.getValue()) : new org.hl7.fhir.dstu3.model.CodeType();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StringType convertCodeToString(org.hl7.fhir.dstu3.model.CodeType src) throws FHIRException {
    org.hl7.fhir.r5.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.StringType(src.getValue()) : new org.hl7.fhir.r5.model.StringType();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    return tgt;
  }
  

//  public static org.hl7.fhir.r5.model.Enumeration<AllResourceTypes> convertResourceEnum(org.hl7.fhir.dstu3.model.CodeType src) {
//    return new Enumeration<AllResourceTypes>(new org.hl7.fhir.r5.model.Enumerations.AllResourceTypesEnumFactory(), src.getValue());
//  }
//
//  public static org.hl7.fhir.dstu3.model.CodeType convertResourceEnum(org.hl7.fhir.r5.model.Enumeration<AllResourceTypes> src) {
//    return new org.hl7.fhir.dstu3.model.CodeType(src.getCode());
//  }
  
}
