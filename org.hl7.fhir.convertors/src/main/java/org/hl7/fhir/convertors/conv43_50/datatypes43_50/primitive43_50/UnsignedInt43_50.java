package org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class UnsignedInt43_50 {
  public static org.hl7.fhir.r5.model.Integer64Type convertUnsignedIntToInteger64(org.hl7.fhir.r4b.model.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.r5.model.Integer64Type tgt = src.hasValue() ? new org.hl7.fhir.r5.model.Integer64Type(src.getValueAsString()) : new org.hl7.fhir.r5.model.Integer64Type();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.UnsignedIntType convertInteger64ToUnsignedInt(org.hl7.fhir.r5.model.Integer64Type src) throws FHIRException {
    org.hl7.fhir.r4b.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.UnsignedIntType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.UnsignedIntType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.r4b.model.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.r5.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UnsignedIntType(src.getValueAsString()) : new org.hl7.fhir.r5.model.UnsignedIntType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.r5.model.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.r4b.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.UnsignedIntType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.UnsignedIntType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }
}
