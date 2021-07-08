package org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30;

import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Date10_30 {
    public static org.hl7.fhir.dstu3.model.DateType convertDate(org.hl7.fhir.dstu2.model.DateType src) throws FHIRException {
      org.hl7.fhir.dstu3.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.DateType();
      Element10_30.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DateType convertDate(org.hl7.fhir.dstu2.model.DateTimeType src) throws FHIRException {
      org.hl7.fhir.dstu3.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.DateType();
      Element10_30.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DateType convertDate(org.hl7.fhir.dstu3.model.DateType src) throws FHIRException {
      org.hl7.fhir.dstu2.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu2.model.DateType();
      Element10_30.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DateType convertDate(org.hl7.fhir.dstu3.model.DateTimeType src) throws FHIRException {
      org.hl7.fhir.dstu2.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu2.model.DateType();
      Element10_30.copyElement(src, tgt);
      return tgt;
    }
}
