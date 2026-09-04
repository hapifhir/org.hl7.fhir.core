package org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Boolean43_N {
  public static org.hl7.fhir.model.core.BooleanType convertBoolean(org.hl7.fhir.r4b.model.BooleanType src) throws FHIRException {
    org.hl7.fhir.model.core.BooleanType tgt = src.hasValue() ? new org.hl7.fhir.model.core.BooleanType(src.getValue()) : new org.hl7.fhir.model.core.BooleanType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.BooleanType convertBoolean(org.hl7.fhir.model.core.BooleanType src) throws FHIRException {
    org.hl7.fhir.r4b.model.BooleanType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.BooleanType(src.getValue()) : new org.hl7.fhir.r4b.model.BooleanType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }
}
