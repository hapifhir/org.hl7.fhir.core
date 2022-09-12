package org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Type;
import org.hl7.fhir.r5.model.DataType;

public class Canonical40_50 {
  public static org.hl7.fhir.r5.model.CanonicalType convertCanonical(org.hl7.fhir.r4.model.CanonicalType src) throws FHIRException {
    org.hl7.fhir.r5.model.CanonicalType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.CanonicalType(src.getValueAsString()) : new org.hl7.fhir.r5.model.CanonicalType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CanonicalType convertCanonical(org.hl7.fhir.r5.model.CanonicalType src) throws FHIRException {
    org.hl7.fhir.r4.model.CanonicalType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.CanonicalType(src.getValueAsString()) : new org.hl7.fhir.r4.model.CanonicalType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.UriType convertCanonicalToUri(org.hl7.fhir.r4.model.CanonicalType src) throws FHIRException {
    org.hl7.fhir.r5.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UriType(src.getValueAsString()) : new org.hl7.fhir.r5.model.UriType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.UriType convertCanonicalToUri(org.hl7.fhir.r5.model.CanonicalType src) throws FHIRException {
    org.hl7.fhir.r4.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UriType(src.getValueAsString()) : new org.hl7.fhir.r4.model.UriType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }



  public static org.hl7.fhir.r5.model.CanonicalType convertUriToCanonical(org.hl7.fhir.r4.model.UriType src) throws FHIRException {
    org.hl7.fhir.r5.model.CanonicalType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.CanonicalType(src.getValueAsString()) : new org.hl7.fhir.r5.model.CanonicalType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CanonicalType convertUriToCanonical(org.hl7.fhir.r5.model.UriType src) throws FHIRException {
    org.hl7.fhir.r4.model.CanonicalType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.CanonicalType(src.getValueAsString()) : new org.hl7.fhir.r4.model.CanonicalType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

}
