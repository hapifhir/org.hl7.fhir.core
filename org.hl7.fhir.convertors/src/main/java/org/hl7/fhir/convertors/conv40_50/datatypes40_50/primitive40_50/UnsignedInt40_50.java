package org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class UnsignedInt40_50 {
  public static org.hl7.fhir.r5.model.Integer64Type convertUnsignedIntToInteger64(org.hl7.fhir.r4.model.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.r5.model.Integer64Type tgt = src.hasValue() ? new org.hl7.fhir.r5.model.Integer64Type(src.getValueAsString()) : new org.hl7.fhir.r5.model.Integer64Type();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.UnsignedIntType convertInteger64ToUnsignedInt(org.hl7.fhir.r5.model.Integer64Type src) throws FHIRException {
    org.hl7.fhir.r4.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UnsignedIntType(src.getValueAsString()) : new org.hl7.fhir.r4.model.UnsignedIntType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.r4.model.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.r5.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UnsignedIntType(src.getValueAsString()) : new org.hl7.fhir.r5.model.UnsignedIntType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.r5.model.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.r4.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UnsignedIntType(src.getValueAsString()) : new org.hl7.fhir.r4.model.UnsignedIntType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }
}
