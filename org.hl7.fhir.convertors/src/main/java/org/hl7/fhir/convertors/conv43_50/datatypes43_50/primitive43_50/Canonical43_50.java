package org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Canonical43_50 {
  public static org.hl7.fhir.r5.model.CanonicalType convertCanonical(org.hl7.fhir.r4b.model.CanonicalType src) throws FHIRException {
    org.hl7.fhir.r5.model.CanonicalType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.CanonicalType(src.getValueAsString()) : new org.hl7.fhir.r5.model.CanonicalType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CanonicalType convertCanonical(org.hl7.fhir.r5.model.CanonicalType src) throws FHIRException {
    org.hl7.fhir.r4b.model.CanonicalType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.CanonicalType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.CanonicalType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }
}
