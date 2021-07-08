package org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40;

import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Code10_40 {
    public static org.hl7.fhir.r4.model.CodeType convertCode(org.hl7.fhir.dstu2.model.CodeType src) throws FHIRException {
      org.hl7.fhir.r4.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.CodeType(src.getValue()) : new org.hl7.fhir.r4.model.CodeType();
      Element10_40.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.CodeType convertCode(org.hl7.fhir.r4.model.CodeType src) throws FHIRException {
      org.hl7.fhir.dstu2.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.CodeType(src.getValue()) : new org.hl7.fhir.dstu2.model.CodeType();
      Element10_40.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.r4.model.UriType convertCodeToUri(org.hl7.fhir.dstu2.model.CodeType src) throws FHIRException {
      org.hl7.fhir.r4.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UriType(src.getValue()) : new org.hl7.fhir.r4.model.UriType();
      Element10_40.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.CodeType convertUriToCode(org.hl7.fhir.r4.model.UriType src) throws FHIRException {
      org.hl7.fhir.dstu2.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.CodeType(src.getValue()) : new org.hl7.fhir.dstu2.model.CodeType();
      Element10_40.copyElement(src, tgt);
      return tgt;
    }
}
