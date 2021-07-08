package org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40;

import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class DateTime10_40 {
    public static org.hl7.fhir.r4.model.DateTimeType convertDateToDateTime(org.hl7.fhir.dstu2.model.DateType src) throws FHIRException {
      org.hl7.fhir.r4.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.r4.model.DateTimeType();
      Element10_40.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DateType convertDateTimeToDate(org.hl7.fhir.r4.model.DateTimeType src) throws FHIRException {
      org.hl7.fhir.dstu2.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu2.model.DateType();
      Element10_40.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.r4.model.DateTimeType convertDateTime(org.hl7.fhir.dstu2.model.DateTimeType src) throws FHIRException {
      org.hl7.fhir.r4.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.r4.model.DateTimeType();
      Element10_40.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DateTimeType convertDateTime(org.hl7.fhir.r4.model.DateTimeType src) throws FHIRException {
      org.hl7.fhir.dstu2.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.dstu2.model.DateTimeType();
      Element10_40.copyElement(src, tgt);
      return tgt;
    }
}
