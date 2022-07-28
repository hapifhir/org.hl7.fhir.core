package org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Uuid43_50 {
  public static org.hl7.fhir.r5.model.UuidType convertUuid(org.hl7.fhir.r4b.model.UuidType src) throws FHIRException {
    org.hl7.fhir.r5.model.UuidType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UuidType(src.getValueAsString()) : new org.hl7.fhir.r5.model.UuidType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.UuidType convertUuid(org.hl7.fhir.r5.model.UuidType src) throws FHIRException {
    org.hl7.fhir.r4b.model.UuidType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.UuidType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.UuidType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }
}
