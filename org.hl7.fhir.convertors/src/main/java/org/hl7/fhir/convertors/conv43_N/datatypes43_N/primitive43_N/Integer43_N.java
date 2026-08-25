package org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Integer43_N {
  public static org.hl7.fhir.model.core.IntegerType convertInteger(org.hl7.fhir.r4b.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.model.core.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.model.core.IntegerType(src.getValueAsString()) : new org.hl7.fhir.model.core.IntegerType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.IntegerType convertInteger(org.hl7.fhir.model.core.IntegerType src) throws FHIRException {
    org.hl7.fhir.r4b.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.IntegerType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.IntegerType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }
  
  public static org.hl7.fhir.model.core.Integer64Type convertInteger64(org.hl7.fhir.r4b.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.model.core.Integer64Type tgt = src.hasValue() ? new org.hl7.fhir.model.core.Integer64Type(src.getValueAsString()) : new org.hl7.fhir.model.core.Integer64Type();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.IntegerType convertInteger64(org.hl7.fhir.model.core.Integer64Type src) throws FHIRException {
    org.hl7.fhir.r4b.model.IntegerType tgt = new org.hl7.fhir.r4b.model.IntegerType();
    if (src.hasValue()) {
      try {
        tgt.setValueAsString(src.getValueAsString());
      } catch (Exception e) {
        // nothing?
        tgt.setValueAsString("0");
      }
    }
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.model.core.UnsignedIntType convertIntegerToUnsigned(org.hl7.fhir.r4b.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.model.core.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UnsignedIntType(src.getValueAsString()) : new org.hl7.fhir.model.core.UnsignedIntType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.IntegerType convertInteger(org.hl7.fhir.model.core.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.r4b.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.IntegerType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.IntegerType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

}
