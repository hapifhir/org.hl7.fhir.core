package org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Url43_50 {
  public static org.hl7.fhir.r5.model.UrlType convertUrl(org.hl7.fhir.r4b.model.UrlType src) throws FHIRException {
    org.hl7.fhir.r5.model.UrlType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UrlType(src.getValueAsString()) : new org.hl7.fhir.r5.model.UrlType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.UrlType convertUrl(org.hl7.fhir.r5.model.UrlType src) throws FHIRException {
    org.hl7.fhir.r4b.model.UrlType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.UrlType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.UrlType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }
}
