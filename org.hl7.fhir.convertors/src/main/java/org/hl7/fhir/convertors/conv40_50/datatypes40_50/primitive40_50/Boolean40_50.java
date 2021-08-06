package org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Boolean40_50 {
  public static org.hl7.fhir.r5.model.BooleanType convertBoolean(org.hl7.fhir.r4.model.BooleanType src) throws FHIRException {
    org.hl7.fhir.r5.model.BooleanType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.BooleanType(src.getValue()) : new org.hl7.fhir.r5.model.BooleanType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.BooleanType convertBoolean(org.hl7.fhir.r5.model.BooleanType src) throws FHIRException {
    org.hl7.fhir.r4.model.BooleanType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.BooleanType(src.getValue()) : new org.hl7.fhir.r4.model.BooleanType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }
}
