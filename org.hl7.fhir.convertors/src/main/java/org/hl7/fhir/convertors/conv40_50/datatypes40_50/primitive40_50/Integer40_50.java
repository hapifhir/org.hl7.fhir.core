package org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Integer40_50 {
  public static org.hl7.fhir.r5.model.IntegerType convertInteger(org.hl7.fhir.r4.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.r5.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.IntegerType(src.getValueAsString()) : new org.hl7.fhir.r5.model.IntegerType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.IntegerType convertInteger(org.hl7.fhir.r5.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.r4.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.IntegerType(src.getValueAsString()) : new org.hl7.fhir.r4.model.IntegerType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }
  
  public static org.hl7.fhir.r5.model.Integer64Type convertInteger64(org.hl7.fhir.r4.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.r5.model.Integer64Type tgt = src.hasValue() ? new org.hl7.fhir.r5.model.Integer64Type(src.getValueAsString()) : new org.hl7.fhir.r5.model.Integer64Type();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.IntegerType convertInteger64(org.hl7.fhir.r5.model.Integer64Type src) throws FHIRException {
    org.hl7.fhir.r4.model.IntegerType tgt = new org.hl7.fhir.r4.model.IntegerType();
    if (src.hasValue()) {
      try {
        tgt.setValueAsString(src.getValueAsString());
      } catch (Exception e) {
        // nothing?
        tgt.setValueAsString("0");
      }
    }
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

}
