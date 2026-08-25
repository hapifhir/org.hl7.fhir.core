package org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Code40_N {
  public static org.hl7.fhir.model.core.CodeType convertCode(org.hl7.fhir.r4.model.CodeType src) throws FHIRException {
    org.hl7.fhir.model.core.CodeType tgt = src.hasValue() ? new org.hl7.fhir.model.core.CodeType(src.getValueAsString()) : new org.hl7.fhir.model.core.CodeType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CodeType convertCode(org.hl7.fhir.model.core.CodeType src) throws FHIRException {
    org.hl7.fhir.r4.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.CodeType(src.getValueAsString()) : new org.hl7.fhir.r4.model.CodeType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }
  public static org.hl7.fhir.model.core.UriType convertCodeToUri(org.hl7.fhir.r4.model.CodeType src) throws FHIRException {
    org.hl7.fhir.model.core.UriType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UriType(src.getValueAsString()) : new org.hl7.fhir.model.core.UriType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CodeType convertCodeFromUri(org.hl7.fhir.model.core.UriType src) throws FHIRException {
    org.hl7.fhir.r4.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.CodeType(src.getValueAsString()) : new org.hl7.fhir.r4.model.CodeType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

//
//  public static org.hl7.fhir.model.core.Enumeration<AllResourceTypes> convertResourceEnum(org.hl7.fhir.r4.model.CodeType src) {
//    return new Enumeration<AllResourceTypes>(new org.hl7.fhir.model.core.Enumerations.AllResourceTypesEnumFactory(), src.getCode());
//  }
//
//  public static org.hl7.fhir.r4.model.CodeType convertResourceEnum(org.hl7.fhir.model.core.Enumeration<AllResourceTypes> src) {
//    return new org.hl7.fhir.r4.model.CodeType(src.getCode());
//  }
  
}
