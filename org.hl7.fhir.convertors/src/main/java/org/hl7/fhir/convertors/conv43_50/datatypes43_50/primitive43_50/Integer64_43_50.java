package org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Integer64_43_50 {
  public static org.hl7.fhir.r5.model.Integer64Type convertStringToInteger64(org.hl7.fhir.r4b.model.StringType src) throws FHIRException {
    org.hl7.fhir.r5.model.Integer64Type tgt = new org.hl7.fhir.r5.model.Integer64Type();
    if (src.hasValue()) {
      // R4B carries integer64 values in a string, so there's no guarantee it's actually an integer
      try {
        tgt.setValueAsString(src.getValueAsString());
      } catch (IllegalArgumentException e) {
        throw new FHIRException("The value '"+src.getValueAsString()+"' is not a valid integer64", e);
      }
    }
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.StringType convertInteger64ToString(org.hl7.fhir.r5.model.Integer64Type src) throws FHIRException {
    org.hl7.fhir.r4b.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.StringType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.StringType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }
}
