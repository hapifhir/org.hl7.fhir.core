package org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class DateTime40_N {
  public static org.hl7.fhir.model.core.DateTimeType convertDateTime(org.hl7.fhir.r4.model.DateTimeType src) throws FHIRException {
    org.hl7.fhir.model.core.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.model.core.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.model.core.DateTimeType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DateTimeType convertDateTime(org.hl7.fhir.model.core.DateTimeType src) throws FHIRException {
    org.hl7.fhir.r4.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.r4.model.DateTimeType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }
  
  public static org.hl7.fhir.model.core.DateType convertDateTimeToDate(org.hl7.fhir.r4.model.DateTimeType src) {
    org.hl7.fhir.model.core.DateType tgt = src.hasValue() ? new org.hl7.fhir.model.core.DateType(src.getValueAsString().substring(0, 10)) : new org.hl7.fhir.model.core.DateType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }
  
  public static org.hl7.fhir.r4.model.DateTimeType convertDateToDateTime(org.hl7.fhir.model.core.DateType src) {
    org.hl7.fhir.r4.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.r4.model.DateTimeType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }
}
