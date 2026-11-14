package org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Integer64_43_N {
  public static org.hl7.fhir.model.core.Integer64Type convertStringToInteger64(org.hl7.fhir.r4b.model.StringType src) throws FHIRException {
    org.hl7.fhir.model.core.Integer64Type tgt = src.hasValue() ? new org.hl7.fhir.model.core.Integer64Type(src.getValueAsString()) : new org.hl7.fhir.model.core.Integer64Type();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.StringType convertInteger64ToString(org.hl7.fhir.model.core.Integer64Type src) throws FHIRException {
    org.hl7.fhir.r4b.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.StringType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.StringType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }
}
