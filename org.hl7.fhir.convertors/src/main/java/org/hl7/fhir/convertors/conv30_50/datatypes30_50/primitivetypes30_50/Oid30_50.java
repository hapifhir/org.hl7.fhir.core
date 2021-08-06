package org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Oid30_50 {
  public static org.hl7.fhir.r5.model.OidType convertOid(org.hl7.fhir.dstu3.model.OidType src) throws FHIRException {
    org.hl7.fhir.r5.model.OidType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.OidType(src.getValue()) : new org.hl7.fhir.r5.model.OidType();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.OidType convertOid(org.hl7.fhir.r5.model.OidType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.OidType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.OidType(src.getValue()) : new org.hl7.fhir.dstu3.model.OidType();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    return tgt;
  }
}
