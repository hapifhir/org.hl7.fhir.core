package org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Integer40_N {
  public static org.hl7.fhir.model.core.IntegerType convertInteger(org.hl7.fhir.r4.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.model.core.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.model.core.IntegerType(src.getValueAsString()) : new org.hl7.fhir.model.core.IntegerType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.IntegerType convertInteger(org.hl7.fhir.model.core.IntegerType src) throws FHIRException {
    org.hl7.fhir.r4.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.IntegerType(src.getValueAsString()) : new org.hl7.fhir.r4.model.IntegerType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }
  
  public static org.hl7.fhir.model.core.Integer64Type convertInteger64(org.hl7.fhir.r4.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.model.core.Integer64Type tgt = src.hasValue() ? new org.hl7.fhir.model.core.Integer64Type(src.getValueAsString()) : new org.hl7.fhir.model.core.Integer64Type();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.IntegerType convertInteger64(org.hl7.fhir.model.core.Integer64Type src) throws FHIRException {
    org.hl7.fhir.r4.model.IntegerType tgt = new org.hl7.fhir.r4.model.IntegerType();
    if (src.hasValue()) {
      try {
        tgt.setValueAsString(src.getValueAsString());
      } catch (Exception e) {
        // nothing?
        tgt.setValueAsString("0");
      }
    }
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.model.core.UnsignedIntType convertIntegerToUnsigned(org.hl7.fhir.r4.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.model.core.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UnsignedIntType(src.getValueAsString()) : new org.hl7.fhir.model.core.UnsignedIntType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.IntegerType convertInteger(org.hl7.fhir.model.core.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.r4.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.IntegerType(src.getValueAsString()) : new org.hl7.fhir.r4.model.IntegerType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

}
