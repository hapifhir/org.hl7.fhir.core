package org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Url40_N {
  public static org.hl7.fhir.model.core.UrlType convertUrl(org.hl7.fhir.r4.model.UrlType src) throws FHIRException {
    org.hl7.fhir.model.core.UrlType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UrlType(src.getValueAsString()) : new org.hl7.fhir.model.core.UrlType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.UrlType convertUrl(org.hl7.fhir.model.core.UrlType src) throws FHIRException {
    org.hl7.fhir.r4.model.UrlType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UrlType(src.getValueAsString()) : new org.hl7.fhir.r4.model.UrlType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }
  
  public static org.hl7.fhir.model.core.UrlType convertUriToUrl(org.hl7.fhir.r4.model.UriType src) throws FHIRException {
    org.hl7.fhir.model.core.UrlType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UrlType(src.getValueAsString()) : new org.hl7.fhir.model.core.UrlType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.UriType convertUrlToUri(org.hl7.fhir.model.core.UrlType src) throws FHIRException {
    org.hl7.fhir.r4.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UriType(src.getValueAsString()) : new org.hl7.fhir.r4.model.UriType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }
  
  public static org.hl7.fhir.model.core.UriType convertUrlToUri(org.hl7.fhir.r4.model.UrlType src) throws FHIRException {
    org.hl7.fhir.model.core.UriType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UriType(src.getValueAsString()) : new org.hl7.fhir.model.core.UriType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.UrlType convertUriToUrl(org.hl7.fhir.model.core.UriType src) throws FHIRException {
    org.hl7.fhir.r4.model.UrlType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UrlType(src.getValueAsString()) : new org.hl7.fhir.r4.model.UrlType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

}
