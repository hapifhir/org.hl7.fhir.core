package org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Date40_50 {
  public static org.hl7.fhir.r5.model.DateType convertDate(org.hl7.fhir.r4.model.DateType src) throws FHIRException {
    org.hl7.fhir.r5.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DateType(src.getValueAsString()) : new org.hl7.fhir.r5.model.DateType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DateType convertDate(org.hl7.fhir.r5.model.DateType src) throws FHIRException {
    org.hl7.fhir.r4.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.DateType(src.getValueAsString()) : new org.hl7.fhir.r4.model.DateType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DateTimeType convertDatetoDateTime(org.hl7.fhir.r4.model.DateType src) {
    org.hl7.fhir.r5.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.r5.model.DateTimeType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DateType convertDateTimeToDate(org.hl7.fhir.r5.model.DateTimeType src) {
    org.hl7.fhir.r4.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.DateType(src.getValueAsString()) : new org.hl7.fhir.r4.model.DateType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }
}
