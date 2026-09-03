package org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N;

import org.hl7.fhir.convertors.context.ConversionContext50_N;
import org.hl7.fhir.exceptions.FHIRException;

public class PositiveInt50_N {
  public static org.hl7.fhir.model.core.PositiveIntType convertPositiveInt(org.hl7.fhir.r5.model.PositiveIntType src) throws FHIRException {
    org.hl7.fhir.model.core.PositiveIntType tgt = src.hasValue() ? new org.hl7.fhir.model.core.PositiveIntType(src.getValueAsString()) : new org.hl7.fhir.model.core.PositiveIntType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.PositiveIntType convertPositiveInt(org.hl7.fhir.model.core.PositiveIntType src) throws FHIRException {
    org.hl7.fhir.r5.model.PositiveIntType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.PositiveIntType(src.getValueAsString()) : new org.hl7.fhir.r5.model.PositiveIntType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }
}
