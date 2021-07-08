package org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50;

import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Element30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Uri30_50 {
    public static org.hl7.fhir.r5.model.UriType convertUri(org.hl7.fhir.dstu3.model.UriType src) throws FHIRException {
      org.hl7.fhir.r5.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UriType(src.getValue()) : new org.hl7.fhir.r5.model.UriType();
      Element30_50.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.UriType convertUri(org.hl7.fhir.r5.model.UriType src) throws FHIRException {
      org.hl7.fhir.dstu3.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.UriType(src.getValue()) : new org.hl7.fhir.dstu3.model.UriType();
      Element30_50.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.r5.model.UriType convertCodeToUri(org.hl7.fhir.dstu3.model.CodeType src) throws FHIRException {
      org.hl7.fhir.r5.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UriType(src.getValue()) : new org.hl7.fhir.r5.model.UriType();
      Element30_50.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeType convertUriToCode(org.hl7.fhir.r5.model.UriType src) throws FHIRException {
      org.hl7.fhir.dstu3.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.CodeType(src.getValue()) : new org.hl7.fhir.dstu3.model.CodeType();
      Element30_50.copyElement(src, tgt);
      return tgt;
    }
}
