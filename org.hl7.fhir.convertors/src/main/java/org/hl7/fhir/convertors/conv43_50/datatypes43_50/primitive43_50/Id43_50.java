package org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.exceptions.FHIRException;


public class Id43_50 {
  public static org.hl7.fhir.r5.model.IdType convertId(org.hl7.fhir.r4b.model.IdType src) throws FHIRException {
    org.hl7.fhir.r5.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.IdType(src.getValueAsString()) : new org.hl7.fhir.r5.model.IdType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.IdType convertId(org.hl7.fhir.r5.model.IdType src) throws FHIRException {
    org.hl7.fhir.r4b.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.IdType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.IdType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StringType convertIdToString(org.hl7.fhir.r4b.model.IdType src) {
    org.hl7.fhir.r5.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.StringType(src.getValueAsString()) : new org.hl7.fhir.r5.model.StringType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }
  
  public static org.hl7.fhir.r4b.model.IdType convertId(org.hl7.fhir.r5.model.StringType src) throws FHIRException {
    org.hl7.fhir.r4b.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.IdType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.IdType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CodeType convertIdToCode(org.hl7.fhir.r4b.model.IdType src) {
    org.hl7.fhir.r5.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.CodeType(src.getValueAsString()) : new org.hl7.fhir.r5.model.CodeType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }
  
  public static org.hl7.fhir.r4b.model.IdType convertId(org.hl7.fhir.r5.model.CodeType src) throws FHIRException {
    org.hl7.fhir.r4b.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.IdType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.IdType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

}
