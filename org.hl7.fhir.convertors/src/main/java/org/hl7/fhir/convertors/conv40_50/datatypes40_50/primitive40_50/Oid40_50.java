package org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Oid40_50 {
  public static org.hl7.fhir.r5.model.OidType convertOid(org.hl7.fhir.r4.model.OidType src) throws FHIRException {
    org.hl7.fhir.r5.model.OidType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.OidType(src.getValueAsString()) : new org.hl7.fhir.r5.model.OidType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.OidType convertOid(org.hl7.fhir.r5.model.OidType src) throws FHIRException {
    org.hl7.fhir.r4.model.OidType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.OidType(src.getValueAsString()) : new org.hl7.fhir.r4.model.OidType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }
}
