package org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.exceptions.FHIRException;
public class Code43_50 {
  public static org.hl7.fhir.r5.model.CodeType convertCode(org.hl7.fhir.r4b.model.CodeType src) throws FHIRException {
    org.hl7.fhir.r5.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.CodeType(src.getValueAsString()) : new org.hl7.fhir.r5.model.CodeType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CodeType convertCode(org.hl7.fhir.r5.model.CodeType src) throws FHIRException {
    org.hl7.fhir.r4b.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.CodeType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.CodeType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }
//
//  public static org.hl7.fhir.r5.model.Enumeration<AllResourceTypes> convertResourceEnum(org.hl7.fhir.r4b.model.CodeType src) {
//    return new Enumeration<AllResourceTypes>(new org.hl7.fhir.r5.model.Enumerations.AllResourceTypesEnumFactory(), src.getCode());
//  }
//
//  public static org.hl7.fhir.r4b.model.CodeType convertResourceEnum(org.hl7.fhir.r5.model.Enumeration<AllResourceTypes> src) {
//    return new org.hl7.fhir.r4b.model.CodeType(src.getCode());
//  }
}
