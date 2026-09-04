package org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Url43_N {
  public static org.hl7.fhir.model.core.UrlType convertUrl(org.hl7.fhir.r4b.model.UrlType src) throws FHIRException {
    org.hl7.fhir.model.core.UrlType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UrlType(src.getValueAsString()) : new org.hl7.fhir.model.core.UrlType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.UrlType convertUrl(org.hl7.fhir.model.core.UrlType src) throws FHIRException {
    org.hl7.fhir.r4b.model.UrlType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.UrlType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.UrlType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }
  
  public static org.hl7.fhir.model.core.UrlType convertUriToUrl(org.hl7.fhir.r4b.model.UriType src) throws FHIRException {
    org.hl7.fhir.model.core.UrlType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UrlType(src.getValueAsString()) : new org.hl7.fhir.model.core.UrlType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.UriType convertUrlToUri(org.hl7.fhir.model.core.UrlType src) throws FHIRException {
    org.hl7.fhir.r4b.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.UriType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.UriType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }
  
  public static org.hl7.fhir.model.core.UriType convertUrlToUri(org.hl7.fhir.r4b.model.UrlType src) throws FHIRException {
    org.hl7.fhir.model.core.UriType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UriType(src.getValueAsString()) : new org.hl7.fhir.model.core.UriType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.UrlType convertUriToUrl(org.hl7.fhir.model.core.UriType src) throws FHIRException {
    org.hl7.fhir.r4b.model.UrlType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.UrlType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.UrlType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

}
