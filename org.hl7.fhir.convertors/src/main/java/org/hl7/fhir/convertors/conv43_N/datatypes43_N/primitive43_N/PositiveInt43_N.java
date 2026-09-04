package org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class PositiveInt43_N {
  public static org.hl7.fhir.model.core.PositiveIntType convertPositiveInt(org.hl7.fhir.r4b.model.PositiveIntType src) throws FHIRException {
    org.hl7.fhir.model.core.PositiveIntType tgt = src.hasValue() ? new org.hl7.fhir.model.core.PositiveIntType(src.getValueAsString()) : new org.hl7.fhir.model.core.PositiveIntType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.PositiveIntType convertPositiveInt(org.hl7.fhir.model.core.PositiveIntType src) throws FHIRException {
    org.hl7.fhir.r4b.model.PositiveIntType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.PositiveIntType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.PositiveIntType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }
}
