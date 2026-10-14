package org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N;

import org.hl7.fhir.convertors.context.ConversionContext50_N;
import org.hl7.fhir.exceptions.FHIRException;

public class DateTime50_N {
  public static org.hl7.fhir.model.core.DateTimeType convertDateTime(org.hl7.fhir.r5.model.DateTimeType src) throws FHIRException {
    org.hl7.fhir.model.core.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.model.core.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.model.core.DateTimeType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DateTimeType convertDateTime(org.hl7.fhir.model.core.DateTimeType src) throws FHIRException {
    org.hl7.fhir.r5.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.r5.model.DateTimeType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }
  
  public static org.hl7.fhir.model.core.DateType convertDateTimeToDate(org.hl7.fhir.r5.model.DateTimeType src) {
    org.hl7.fhir.model.core.DateType tgt = src.hasValue() ? new org.hl7.fhir.model.core.DateType(src.getValueAsString().substring(0, 10)) : new org.hl7.fhir.model.core.DateType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }
  
  public static org.hl7.fhir.r5.model.DateTimeType convertDateToDateTime(org.hl7.fhir.model.core.DateType src) {
    org.hl7.fhir.r5.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.r5.model.DateTimeType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }


  public static org.hl7.fhir.model.core.DateTimeType convertInstantToDateTime(org.hl7.fhir.r5.model.InstantType src) {
    org.hl7.fhir.model.core.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.model.core.DateTimeType(src.getValueAsString().substring(0, 10)) : new org.hl7.fhir.model.core.DateTimeType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.InstantType convertDateTimeToInstant(org.hl7.fhir.model.core.DateTimeType src) {
    org.hl7.fhir.r5.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.InstantType(src.getValueAsString()) : new org.hl7.fhir.r5.model.InstantType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }
}
