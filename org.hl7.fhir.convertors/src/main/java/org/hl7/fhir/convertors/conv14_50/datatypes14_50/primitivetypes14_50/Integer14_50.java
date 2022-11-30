package org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50;

import org.hl7.fhir.convertors.context.ConversionContext14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Integer14_50 {
  public static org.hl7.fhir.r5.model.IntegerType convertInteger(org.hl7.fhir.dstu2016may.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.r5.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.IntegerType(src.getValueAsString()) : new org.hl7.fhir.r5.model.IntegerType();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.IntegerType convertInteger(org.hl7.fhir.r5.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.dstu2016may.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.dstu2016may.model.IntegerType(src.getValueAsString()) : new org.hl7.fhir.dstu2016may.model.IntegerType();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    return tgt;
  }
  
  public static org.hl7.fhir.r5.model.Integer64Type convertInteger64(org.hl7.fhir.dstu2016may.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.r5.model.Integer64Type tgt = src.hasValue() ? new org.hl7.fhir.r5.model.Integer64Type(src.getValueAsString()) : new org.hl7.fhir.r5.model.Integer64Type();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.IntegerType convertInteger64(org.hl7.fhir.r5.model.Integer64Type src) throws FHIRException {
    org.hl7.fhir.dstu2016may.model.IntegerType tgt = new org.hl7.fhir.dstu2016may.model.IntegerType();
    if (src.hasValue()) {
      try {
        tgt.setValueAsString(src.getValueAsString());
      } catch (Exception e) {
        // nothing?
        tgt.setValueAsString("0");
      }
    }
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    return tgt;
  }

}
