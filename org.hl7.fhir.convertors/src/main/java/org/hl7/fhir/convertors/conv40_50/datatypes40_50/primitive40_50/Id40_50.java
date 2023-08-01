package org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Id40_50 {
  public static org.hl7.fhir.r5.model.IdType convertId(org.hl7.fhir.r4.model.IdType src) throws FHIRException {
    org.hl7.fhir.r5.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.IdType(src.getValueAsString()) : new org.hl7.fhir.r5.model.IdType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.IdType convertId(org.hl7.fhir.r5.model.IdType src) throws FHIRException {
    org.hl7.fhir.r4.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.IdType(src.getValueAsString()) : new org.hl7.fhir.r4.model.IdType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }
  

  public static org.hl7.fhir.r5.model.StringType convertIdToString(org.hl7.fhir.r4.model.IdType src) {
    org.hl7.fhir.r5.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.StringType(src.getValueAsString()) : new org.hl7.fhir.r5.model.StringType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }
  

  public static org.hl7.fhir.r4.model.IdType convertId(org.hl7.fhir.r5.model.StringType src) throws FHIRException {
    org.hl7.fhir.r4.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.IdType(src.getValueAsString()) : new org.hl7.fhir.r4.model.IdType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }


  public static org.hl7.fhir.r5.model.CodeType convertIdToCode(org.hl7.fhir.r4.model.IdType src) {
    org.hl7.fhir.r5.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.CodeType(src.getValueAsString()) : new org.hl7.fhir.r5.model.CodeType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }
  

  public static org.hl7.fhir.r4.model.IdType convertId(org.hl7.fhir.r5.model.CodeType src) throws FHIRException {
    org.hl7.fhir.r4.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.IdType(src.getValueAsString()) : new org.hl7.fhir.r4.model.IdType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

}
