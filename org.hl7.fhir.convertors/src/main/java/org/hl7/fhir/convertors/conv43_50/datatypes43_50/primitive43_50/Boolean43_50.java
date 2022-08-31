package org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Boolean43_50 {
  public static org.hl7.fhir.r5.model.BooleanType convertBoolean(org.hl7.fhir.r4b.model.BooleanType src) throws FHIRException {
    org.hl7.fhir.r5.model.BooleanType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.BooleanType(src.getValue()) : new org.hl7.fhir.r5.model.BooleanType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.BooleanType convertBoolean(org.hl7.fhir.r5.model.BooleanType src) throws FHIRException {
    org.hl7.fhir.r4b.model.BooleanType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.BooleanType(src.getValue()) : new org.hl7.fhir.r4b.model.BooleanType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }
}
