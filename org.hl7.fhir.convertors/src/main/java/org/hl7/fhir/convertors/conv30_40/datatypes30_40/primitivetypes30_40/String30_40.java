package org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40;

import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class String30_40 {
    public static org.hl7.fhir.r4.model.StringType convertString(org.hl7.fhir.dstu3.model.StringType src) throws FHIRException {
      org.hl7.fhir.r4.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.StringType(src.getValue()) : new org.hl7.fhir.r4.model.StringType();
      Element30_40.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StringType convertString(org.hl7.fhir.r4.model.StringType src) throws FHIRException {
      org.hl7.fhir.dstu3.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.StringType(src.getValue()) : new org.hl7.fhir.dstu3.model.StringType();
      Element30_40.copyElement(src, tgt);
      return tgt;
    }
}
