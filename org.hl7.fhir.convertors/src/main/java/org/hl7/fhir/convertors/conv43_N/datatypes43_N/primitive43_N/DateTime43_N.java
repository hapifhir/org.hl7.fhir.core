package org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class DateTime43_N {
  public static org.hl7.fhir.model.core.DateTimeType convertDateTime(org.hl7.fhir.r4b.model.DateTimeType src) throws FHIRException {
    org.hl7.fhir.model.core.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.model.core.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.model.core.DateTimeType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DateTimeType convertDateTime(org.hl7.fhir.model.core.DateTimeType src) throws FHIRException {
    org.hl7.fhir.r4b.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.DateTimeType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }
  
  public static org.hl7.fhir.model.core.DateType convertDateTimeToDate(org.hl7.fhir.r4b.model.DateTimeType src) {
    org.hl7.fhir.model.core.DateType tgt = src.hasValue() ? new org.hl7.fhir.model.core.DateType(src.getValueAsString().substring(0, 10)) : new org.hl7.fhir.model.core.DateType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }
  
  public static org.hl7.fhir.r4b.model.DateTimeType convertDateToDateTime(org.hl7.fhir.model.core.DateType src) {
    org.hl7.fhir.r4b.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.DateTimeType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }
}
