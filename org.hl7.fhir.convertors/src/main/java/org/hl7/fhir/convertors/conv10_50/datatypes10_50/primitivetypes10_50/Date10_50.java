package org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50;

import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Element10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Date10_50 {
    public static org.hl7.fhir.r5.model.DateType convertDate(org.hl7.fhir.dstu2.model.DateType src) throws FHIRException {
      org.hl7.fhir.r5.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DateType(src.getValueAsString()) : new org.hl7.fhir.r5.model.DateType();
      Element10_50.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.r5.model.DateType convertDate(org.hl7.fhir.dstu2.model.DateTimeType src) throws FHIRException {
      org.hl7.fhir.r5.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DateType(src.getValueAsString()) : new org.hl7.fhir.r5.model.DateType();
      Element10_50.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DateType convertDate(org.hl7.fhir.r5.model.DateType src) throws FHIRException {
      org.hl7.fhir.dstu2.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu2.model.DateType();
      Element10_50.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DateType convertDate(org.hl7.fhir.r5.model.DateTimeType src) throws FHIRException {
      org.hl7.fhir.dstu2.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu2.model.DateType();
      Element10_50.copyElement(src, tgt);
      return tgt;
    }
}
