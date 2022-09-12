package org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Instant43_50 {
  public static org.hl7.fhir.r5.model.InstantType convertInstant(org.hl7.fhir.r4b.model.InstantType src) throws FHIRException {
    org.hl7.fhir.r5.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.InstantType(src.getValueAsString()) : new org.hl7.fhir.r5.model.InstantType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.InstantType convertInstant(org.hl7.fhir.r5.model.InstantType src) throws FHIRException {
    org.hl7.fhir.r4b.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.InstantType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.InstantType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }
}
