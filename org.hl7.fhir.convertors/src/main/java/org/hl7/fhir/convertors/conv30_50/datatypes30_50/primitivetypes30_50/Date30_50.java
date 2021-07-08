package org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50;

import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Element30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Date30_50 {
    public static org.hl7.fhir.r5.model.DateType convertDate(org.hl7.fhir.dstu3.model.DateType src) throws FHIRException {
      org.hl7.fhir.r5.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DateType(src.getValueAsString()) : new org.hl7.fhir.r5.model.DateType();
      Element30_50.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.r5.model.DateTimeType convertDateToDateTime(org.hl7.fhir.dstu3.model.DateType src) throws FHIRException {
      org.hl7.fhir.r5.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.r5.model.DateTimeType();
      Element30_50.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DateType convertDateTimeToDate(org.hl7.fhir.r5.model.DateTimeType src) throws FHIRException {
      org.hl7.fhir.dstu3.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.DateType();
      Element30_50.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DateType convertDate(org.hl7.fhir.r5.model.DateType src) throws FHIRException {
      org.hl7.fhir.dstu3.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.DateType();
      Element30_50.copyElement(src, tgt);
      return tgt;
    }
}
