package org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Oid40_N {
  public static org.hl7.fhir.model.core.OidType convertOid(org.hl7.fhir.r4.model.OidType src) throws FHIRException {
    org.hl7.fhir.model.core.OidType tgt = src.hasValue() ? new org.hl7.fhir.model.core.OidType(src.getValueAsString()) : new org.hl7.fhir.model.core.OidType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.OidType convertOid(org.hl7.fhir.model.core.OidType src) throws FHIRException {
    org.hl7.fhir.r4.model.OidType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.OidType(src.getValueAsString()) : new org.hl7.fhir.r4.model.OidType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }
}
