package org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N;

import org.hl7.fhir.convertors.context.ConversionContext50_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Canonical50_N {
  public static org.hl7.fhir.model.core.CanonicalType convertCanonical(org.hl7.fhir.r5.model.CanonicalType src) throws FHIRException {
    org.hl7.fhir.model.core.CanonicalType tgt = src.hasValue() ? new org.hl7.fhir.model.core.CanonicalType(src.getValueAsString()) : new org.hl7.fhir.model.core.CanonicalType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CanonicalType convertCanonical(org.hl7.fhir.model.core.CanonicalType src) throws FHIRException {
    org.hl7.fhir.r5.model.CanonicalType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.CanonicalType(src.getValueAsString()) : new org.hl7.fhir.r5.model.CanonicalType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.model.core.UriType convertCanonicalToUri(org.hl7.fhir.r5.model.CanonicalType src) throws FHIRException {
    org.hl7.fhir.model.core.UriType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UriType(src.getValueAsString()) : new org.hl7.fhir.model.core.UriType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.UriType convertCanonicalToUri(org.hl7.fhir.model.core.CanonicalType src) throws FHIRException {
    org.hl7.fhir.r5.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UriType(src.getValueAsString()) : new org.hl7.fhir.r5.model.UriType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }



  public static org.hl7.fhir.model.core.CanonicalType convertUriToCanonical(org.hl7.fhir.r5.model.UriType src) throws FHIRException {
    org.hl7.fhir.model.core.CanonicalType tgt = src.hasValue() ? new org.hl7.fhir.model.core.CanonicalType(src.getValueAsString()) : new org.hl7.fhir.model.core.CanonicalType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CanonicalType convertUriToCanonical(org.hl7.fhir.model.core.UriType src) throws FHIRException {
    org.hl7.fhir.r5.model.CanonicalType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.CanonicalType(src.getValueAsString()) : new org.hl7.fhir.r5.model.CanonicalType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

}
