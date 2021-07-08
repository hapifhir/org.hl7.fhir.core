package org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40;

import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class DateTime30_40 {
    public static org.hl7.fhir.r4.model.DateTimeType convertDateTime(org.hl7.fhir.dstu3.model.DateTimeType src) throws FHIRException {
      org.hl7.fhir.r4.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.r4.model.DateTimeType();
      Element30_40.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DateTimeType convertDateTime(org.hl7.fhir.r4.model.DateTimeType src) throws FHIRException {
      org.hl7.fhir.dstu3.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.DateTimeType();
      Element30_40.copyElement(src, tgt);
      return tgt;
    }
}
