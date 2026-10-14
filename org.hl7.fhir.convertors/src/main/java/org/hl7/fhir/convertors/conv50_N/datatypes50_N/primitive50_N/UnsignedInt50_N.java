package org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N;

import org.hl7.fhir.convertors.context.ConversionContext50_N;
import org.hl7.fhir.exceptions.FHIRException;

public class UnsignedInt50_N {
  public static org.hl7.fhir.model.core.Integer64Type convertUnsignedIntToInteger64(org.hl7.fhir.r5.model.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.model.core.Integer64Type tgt = src.hasValue() ? new org.hl7.fhir.model.core.Integer64Type(src.getValueAsString()) : new org.hl7.fhir.model.core.Integer64Type();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.UnsignedIntType convertInteger64ToUnsignedInt(org.hl7.fhir.model.core.Integer64Type src) throws FHIRException {
    org.hl7.fhir.r5.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UnsignedIntType(src.getValueAsString()) : new org.hl7.fhir.r5.model.UnsignedIntType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.model.core.UnsignedIntType convertUnsignedInt(org.hl7.fhir.r5.model.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.model.core.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UnsignedIntType(src.getValueAsString()) : new org.hl7.fhir.model.core.UnsignedIntType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.model.core.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.r5.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UnsignedIntType(src.getValueAsString()) : new org.hl7.fhir.r5.model.UnsignedIntType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }
  public static org.hl7.fhir.model.core.UnsignedIntType convertInteger(org.hl7.fhir.r5.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.model.core.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UnsignedIntType(src.getValueAsString()) : new org.hl7.fhir.model.core.UnsignedIntType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.IntegerType convertInteger(org.hl7.fhir.model.core.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.r5.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UnsignedIntType(src.getValueAsString()) : new org.hl7.fhir.r5.model.UnsignedIntType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }
}
