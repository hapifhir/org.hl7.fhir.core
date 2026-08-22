package org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Oid43_N {
  public static org.hl7.fhir.model.core.OidType convertOid(org.hl7.fhir.r4b.model.OidType src) throws FHIRException {
    org.hl7.fhir.model.core.OidType tgt = src.hasValue() ? new org.hl7.fhir.model.core.OidType(src.getValueAsString()) : new org.hl7.fhir.model.core.OidType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.OidType convertOid(org.hl7.fhir.model.core.OidType src) throws FHIRException {
    org.hl7.fhir.r4b.model.OidType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.OidType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.OidType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }
}
