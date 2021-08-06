package org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Date30_40 {
  public static org.hl7.fhir.r4.model.DateType convertDate(org.hl7.fhir.dstu3.model.DateType src) throws FHIRException {
    org.hl7.fhir.r4.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.DateType(src.getValueAsString()) : new org.hl7.fhir.r4.model.DateType();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DateTimeType convertDateToDateTime(org.hl7.fhir.dstu3.model.DateType src) throws FHIRException {
    org.hl7.fhir.r4.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.r4.model.DateTimeType();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DateType convertDateTimeToDate(org.hl7.fhir.r4.model.DateTimeType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.DateType();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DateType convertDate(org.hl7.fhir.r4.model.DateType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.DateType();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    return tgt;
  }
}
