package org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.dstu2.model.DateType;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.DateTimeType;

public class Date10_50 {
  public static org.hl7.fhir.r5.model.DateType convertDate(org.hl7.fhir.dstu2.model.DateType src) throws FHIRException {
    org.hl7.fhir.r5.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DateType(src.getValueAsString()) : new org.hl7.fhir.r5.model.DateType();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DateType convertDate(org.hl7.fhir.dstu2.model.DateTimeType src) throws FHIRException {
    org.hl7.fhir.r5.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DateType(src.getValueAsString()) : new org.hl7.fhir.r5.model.DateType();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.DateType convertDate(org.hl7.fhir.r5.model.DateType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu2.model.DateType();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.DateType convertDate(org.hl7.fhir.r5.model.DateTimeType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu2.model.DateType();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    return tgt;
  }

  public static DateTimeType convertDatetoDateTime(DateType src) {
    org.hl7.fhir.r5.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.r5.model.DateTimeType();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    return tgt;
  }

  public static DateType convertDateTimeToDate(DateTimeType src) {
    org.hl7.fhir.dstu2.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu2.model.DateType();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    return tgt;
  }
}
