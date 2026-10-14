package org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N;

import org.hl7.fhir.convertors.context.ConversionContext50_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Date50_N {
  public static org.hl7.fhir.model.core.DateType convertDate(org.hl7.fhir.r5.model.DateType src) throws FHIRException {
    org.hl7.fhir.model.core.DateType tgt = src.hasValue() ? new org.hl7.fhir.model.core.DateType(src.getValueAsString()) : new org.hl7.fhir.model.core.DateType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DateType convertDate(org.hl7.fhir.model.core.DateType src) throws FHIRException {
    org.hl7.fhir.r5.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DateType(src.getValueAsString()) : new org.hl7.fhir.r5.model.DateType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.model.core.DateTimeType convertDatetoDateTime(org.hl7.fhir.r5.model.DateType src) {
    org.hl7.fhir.model.core.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.model.core.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.model.core.DateTimeType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DateType convertDateTimeToDate(org.hl7.fhir.model.core.DateTimeType src) {
    org.hl7.fhir.r5.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DateType(src.getValueAsString()) : new org.hl7.fhir.r5.model.DateType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }
}
