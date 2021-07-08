package org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40;

import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Time10_40 {
    public static org.hl7.fhir.r4.model.TimeType convertTime(org.hl7.fhir.dstu2.model.TimeType src) throws FHIRException {
      org.hl7.fhir.r4.model.TimeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.TimeType(src.getValue()) : new org.hl7.fhir.r4.model.TimeType();
      Element10_40.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TimeType convertTime(org.hl7.fhir.r4.model.TimeType src) throws FHIRException {
      org.hl7.fhir.dstu2.model.TimeType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.TimeType(src.getValue()) : new org.hl7.fhir.dstu2.model.TimeType();
      Element10_40.copyElement(src, tgt);
      return tgt;
    }
}
