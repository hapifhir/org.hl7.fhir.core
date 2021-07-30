package org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30;

import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Oid10_30 {
  public static org.hl7.fhir.dstu3.model.OidType convertOid(org.hl7.fhir.dstu2.model.OidType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.OidType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.OidType(src.getValue()) : new org.hl7.fhir.dstu3.model.OidType();
    Element10_30.copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.OidType convertOid(org.hl7.fhir.dstu3.model.OidType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.OidType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.OidType(src.getValue()) : new org.hl7.fhir.dstu2.model.OidType();
    Element10_30.copyElement(src, tgt);
    return tgt;
  }
}
