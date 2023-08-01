package org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Url40_50 {
  public static org.hl7.fhir.r5.model.UrlType convertUrl(org.hl7.fhir.r4.model.UrlType src) throws FHIRException {
    org.hl7.fhir.r5.model.UrlType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UrlType(src.getValueAsString()) : new org.hl7.fhir.r5.model.UrlType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.UrlType convertUrl(org.hl7.fhir.r5.model.UrlType src) throws FHIRException {
    org.hl7.fhir.r4.model.UrlType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UrlType(src.getValueAsString()) : new org.hl7.fhir.r4.model.UrlType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }
  
  public static org.hl7.fhir.r5.model.UrlType convertUriToUrl(org.hl7.fhir.r4.model.UriType src) throws FHIRException {
    org.hl7.fhir.r5.model.UrlType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UrlType(src.getValueAsString()) : new org.hl7.fhir.r5.model.UrlType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.UriType convertUrlToUri(org.hl7.fhir.r5.model.UrlType src) throws FHIRException {
    org.hl7.fhir.r4.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UriType(src.getValueAsString()) : new org.hl7.fhir.r4.model.UriType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }
  
  public static org.hl7.fhir.r5.model.UriType convertUrlToUri(org.hl7.fhir.r4.model.UrlType src) throws FHIRException {
    org.hl7.fhir.r5.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UriType(src.getValueAsString()) : new org.hl7.fhir.r5.model.UriType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.UrlType convertUriToUrl(org.hl7.fhir.r5.model.UriType src) throws FHIRException {
    org.hl7.fhir.r4.model.UrlType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UrlType(src.getValueAsString()) : new org.hl7.fhir.r4.model.UrlType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

}
