package org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Oid43_50 {
  public static org.hl7.fhir.r5.model.OidType convertOid(org.hl7.fhir.r4b.model.OidType src) throws FHIRException {
    org.hl7.fhir.r5.model.OidType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.OidType(src.getValueAsString()) : new org.hl7.fhir.r5.model.OidType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.OidType convertOid(org.hl7.fhir.r5.model.OidType src) throws FHIRException {
    org.hl7.fhir.r4b.model.OidType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.OidType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.OidType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }
}
