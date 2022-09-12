package org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Uri43_50 {
  public static org.hl7.fhir.r5.model.UriType convertUri(org.hl7.fhir.r4b.model.UriType src) throws FHIRException {
    org.hl7.fhir.r5.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UriType(src.getValueAsString()) : new org.hl7.fhir.r5.model.UriType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.UriType convertUri(org.hl7.fhir.r5.model.UriType src) throws FHIRException {
    org.hl7.fhir.r4b.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.UriType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.UriType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }
}
