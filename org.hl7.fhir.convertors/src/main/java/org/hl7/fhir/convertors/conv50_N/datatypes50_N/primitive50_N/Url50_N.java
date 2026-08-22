package org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N;

import org.hl7.fhir.convertors.context.ConversionContext50_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Url50_N {
  public static org.hl7.fhir.model.core.UrlType convertUrl(org.hl7.fhir.r5.model.UrlType src) throws FHIRException {
    org.hl7.fhir.model.core.UrlType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UrlType(src.getValueAsString()) : new org.hl7.fhir.model.core.UrlType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.UrlType convertUrl(org.hl7.fhir.model.core.UrlType src) throws FHIRException {
    org.hl7.fhir.r5.model.UrlType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UrlType(src.getValueAsString()) : new org.hl7.fhir.r5.model.UrlType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }
  
  public static org.hl7.fhir.model.core.UrlType convertUriToUrl(org.hl7.fhir.r5.model.UriType src) throws FHIRException {
    org.hl7.fhir.model.core.UrlType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UrlType(src.getValueAsString()) : new org.hl7.fhir.model.core.UrlType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.UriType convertUrlToUri(org.hl7.fhir.model.core.UrlType src) throws FHIRException {
    org.hl7.fhir.r5.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UriType(src.getValueAsString()) : new org.hl7.fhir.r5.model.UriType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }
  
  public static org.hl7.fhir.model.core.UriType convertUrlToUri(org.hl7.fhir.r5.model.UrlType src) throws FHIRException {
    org.hl7.fhir.model.core.UriType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UriType(src.getValueAsString()) : new org.hl7.fhir.model.core.UriType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.UrlType convertUriToUrl(org.hl7.fhir.model.core.UriType src) throws FHIRException {
    org.hl7.fhir.r5.model.UrlType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UrlType(src.getValueAsString()) : new org.hl7.fhir.r5.model.UrlType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

}
