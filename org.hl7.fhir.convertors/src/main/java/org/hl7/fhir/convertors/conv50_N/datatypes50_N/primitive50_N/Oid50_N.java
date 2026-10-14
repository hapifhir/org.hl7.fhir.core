package org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N;

import org.hl7.fhir.convertors.context.ConversionContext50_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Oid50_N {
  public static org.hl7.fhir.model.core.OidType convertOid(org.hl7.fhir.r5.model.OidType src) throws FHIRException {
    org.hl7.fhir.model.core.OidType tgt = src.hasValue() ? new org.hl7.fhir.model.core.OidType(src.getValueAsString()) : new org.hl7.fhir.model.core.OidType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.OidType convertOid(org.hl7.fhir.model.core.OidType src) throws FHIRException {
    org.hl7.fhir.r5.model.OidType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.OidType(src.getValueAsString()) : new org.hl7.fhir.r5.model.OidType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.model.core.OidType convertOidFromCode(org.hl7.fhir.r5.model.CodeType src) throws FHIRException {
    org.hl7.fhir.model.core.OidType tgt = src.hasValue() ? new org.hl7.fhir.model.core.OidType(src.getValueAsString()) : new org.hl7.fhir.model.core.OidType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CodeType convertOidToCode(org.hl7.fhir.model.core.OidType src) throws FHIRException {
    org.hl7.fhir.r5.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.CodeType(src.getValueAsString()) : new org.hl7.fhir.r5.model.CodeType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }


  public static org.hl7.fhir.model.core.OidType convertOidFromCoding(org.hl7.fhir.r5.model.Coding src) throws FHIRException {
    org.hl7.fhir.model.core.OidType tgt = src.hasCode() ? new org.hl7.fhir.model.core.OidType(src.getCode()) : new org.hl7.fhir.model.core.OidType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Coding convertOidToCoding(org.hl7.fhir.model.core.OidType src) throws FHIRException {
    org.hl7.fhir.r5.model.Coding tgt = src.hasValue() ? new org.hl7.fhir.r5.model.Coding().setCode(src.getValue()) : new org.hl7.fhir.r5.model.Coding();
    if (tgt.hasCode()) {
      tgt.setSystem("urn:ietf:rfc:3986");
    }
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }
}
