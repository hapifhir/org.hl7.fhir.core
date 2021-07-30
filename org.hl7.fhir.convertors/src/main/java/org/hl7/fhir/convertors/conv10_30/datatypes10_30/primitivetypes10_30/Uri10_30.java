package org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30;

import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Uri10_30 {
  public static org.hl7.fhir.dstu3.model.UriType convertUri(org.hl7.fhir.dstu2.model.UriType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.UriType(src.getValue()) : new org.hl7.fhir.dstu3.model.UriType();
    Element10_30.copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.UriType convertUri(org.hl7.fhir.dstu3.model.UriType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.UriType(src.getValue()) : new org.hl7.fhir.dstu2.model.UriType();
    Element10_30.copyElement(src, tgt);
    return tgt;
  }
}
