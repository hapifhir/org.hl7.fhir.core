package org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Canonical40_N {
  public static org.hl7.fhir.model.core.CanonicalType convertCanonical(org.hl7.fhir.r4.model.CanonicalType src) throws FHIRException {
    org.hl7.fhir.model.core.CanonicalType tgt = src.hasValue() ? new org.hl7.fhir.model.core.CanonicalType(src.getValueAsString()) : new org.hl7.fhir.model.core.CanonicalType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CanonicalType convertCanonical(org.hl7.fhir.model.core.CanonicalType src) throws FHIRException {
    org.hl7.fhir.r4.model.CanonicalType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.CanonicalType(src.getValueAsString()) : new org.hl7.fhir.r4.model.CanonicalType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.model.core.UriType convertCanonicalToUri(org.hl7.fhir.r4.model.CanonicalType src) throws FHIRException {
    org.hl7.fhir.model.core.UriType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UriType(src.getValueAsString()) : new org.hl7.fhir.model.core.UriType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.UriType convertCanonicalToUri(org.hl7.fhir.model.core.CanonicalType src) throws FHIRException {
    org.hl7.fhir.r4.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UriType(src.getValueAsString()) : new org.hl7.fhir.r4.model.UriType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }



  public static org.hl7.fhir.model.core.CanonicalType convertUriToCanonical(org.hl7.fhir.r4.model.UriType src) throws FHIRException {
    org.hl7.fhir.model.core.CanonicalType tgt = src.hasValue() ? new org.hl7.fhir.model.core.CanonicalType(src.getValueAsString()) : new org.hl7.fhir.model.core.CanonicalType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CanonicalType convertUriToCanonical(org.hl7.fhir.model.core.UriType src) throws FHIRException {
    org.hl7.fhir.r4.model.CanonicalType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.CanonicalType(src.getValueAsString()) : new org.hl7.fhir.r4.model.CanonicalType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

}
