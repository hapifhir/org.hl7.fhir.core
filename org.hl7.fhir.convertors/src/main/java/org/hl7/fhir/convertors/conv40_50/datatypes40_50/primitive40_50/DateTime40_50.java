package org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class DateTime40_50 {
  public static org.hl7.fhir.r5.model.DateTimeType convertDateTime(org.hl7.fhir.r4.model.DateTimeType src) throws FHIRException {
    org.hl7.fhir.r5.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.r5.model.DateTimeType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DateTimeType convertDateTime(org.hl7.fhir.r5.model.DateTimeType src) throws FHIRException {
    org.hl7.fhir.r4.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.r4.model.DateTimeType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }
  
  public static org.hl7.fhir.r5.model.DateType convertDateTimeToDate(org.hl7.fhir.r4.model.DateTimeType src) {
    org.hl7.fhir.r5.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DateType(src.getValueAsString().substring(0, 10)) : new org.hl7.fhir.r5.model.DateType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }
  
  public static org.hl7.fhir.r4.model.DateTimeType convertDateToDateTime(org.hl7.fhir.r5.model.DateType src) {
    org.hl7.fhir.r4.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.r4.model.DateTimeType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }
}
