package org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class PositiveInt40_N {
  public static org.hl7.fhir.model.core.PositiveIntType convertPositiveInt(org.hl7.fhir.r4.model.PositiveIntType src) throws FHIRException {
    org.hl7.fhir.model.core.PositiveIntType tgt = src.hasValue() ? new org.hl7.fhir.model.core.PositiveIntType(src.getValueAsString()) : new org.hl7.fhir.model.core.PositiveIntType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PositiveIntType convertPositiveInt(org.hl7.fhir.model.core.PositiveIntType src) throws FHIRException {
    org.hl7.fhir.r4.model.PositiveIntType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.PositiveIntType(src.getValueAsString()) : new org.hl7.fhir.r4.model.PositiveIntType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }
}
