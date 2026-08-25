package org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N;

import org.hl7.fhir.convertors.context.ConversionContext50_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Uuid50_N {
  public static org.hl7.fhir.model.core.UuidType convertUuid(org.hl7.fhir.r5.model.UuidType src) throws FHIRException {
    org.hl7.fhir.model.core.UuidType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UuidType(src.getValueAsString()) : new org.hl7.fhir.model.core.UuidType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.UuidType convertUuid(org.hl7.fhir.model.core.UuidType src) throws FHIRException {
    org.hl7.fhir.r5.model.UuidType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UuidType(src.getValueAsString()) : new org.hl7.fhir.r5.model.UuidType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }
}
