package org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Date43_50 {
  public static org.hl7.fhir.r5.model.DateType convertDate(org.hl7.fhir.r4b.model.DateType src) throws FHIRException {
    org.hl7.fhir.r5.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DateType(src.getValueAsString()) : new org.hl7.fhir.r5.model.DateType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DateType convertDate(org.hl7.fhir.r5.model.DateType src) throws FHIRException {
    org.hl7.fhir.r4b.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.DateType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.DateType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DateTimeType convertDatetoDateTime(org.hl7.fhir.r4b.model.DateType src) {
    org.hl7.fhir.r5.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.r5.model.DateTimeType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DateType convertDateTimeToDate(org.hl7.fhir.r5.model.DateTimeType src) {
    org.hl7.fhir.r4b.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.DateType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.DateType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }
}
