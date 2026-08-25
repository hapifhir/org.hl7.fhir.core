package org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class UnsignedInt40_N {
  public static org.hl7.fhir.model.core.Integer64Type convertUnsignedIntToInteger64(org.hl7.fhir.r4.model.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.model.core.Integer64Type tgt = src.hasValue() ? new org.hl7.fhir.model.core.Integer64Type(src.getValueAsString()) : new org.hl7.fhir.model.core.Integer64Type();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.UnsignedIntType convertInteger64ToUnsignedInt(org.hl7.fhir.model.core.Integer64Type src) throws FHIRException {
    org.hl7.fhir.r4.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UnsignedIntType(src.getValueAsString()) : new org.hl7.fhir.r4.model.UnsignedIntType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.model.core.UnsignedIntType convertUnsignedInt(org.hl7.fhir.r4.model.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.model.core.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UnsignedIntType(src.getValueAsString()) : new org.hl7.fhir.model.core.UnsignedIntType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.model.core.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.r4.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UnsignedIntType(src.getValueAsString()) : new org.hl7.fhir.r4.model.UnsignedIntType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }
}
