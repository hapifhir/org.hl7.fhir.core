package org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Canonical43_N {
  public static org.hl7.fhir.model.core.CanonicalType convertCanonical(org.hl7.fhir.r4b.model.CanonicalType src) throws FHIRException {
    org.hl7.fhir.model.core.CanonicalType tgt = src.hasValue() ? new org.hl7.fhir.model.core.CanonicalType(src.getValueAsString()) : new org.hl7.fhir.model.core.CanonicalType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CanonicalType convertCanonical(org.hl7.fhir.model.core.CanonicalType src) throws FHIRException {
    org.hl7.fhir.r4b.model.CanonicalType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.CanonicalType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.CanonicalType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.model.core.UriType convertCanonicalToUri(org.hl7.fhir.r4b.model.CanonicalType src) throws FHIRException {
    org.hl7.fhir.model.core.UriType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UriType(src.getValueAsString()) : new org.hl7.fhir.model.core.UriType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.UriType convertCanonicalToUri(org.hl7.fhir.model.core.CanonicalType src) throws FHIRException {
    org.hl7.fhir.r4b.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.UriType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.UriType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }



  public static org.hl7.fhir.model.core.CanonicalType convertUriToCanonical(org.hl7.fhir.r4b.model.UriType src) throws FHIRException {
    org.hl7.fhir.model.core.CanonicalType tgt = src.hasValue() ? new org.hl7.fhir.model.core.CanonicalType(src.getValueAsString()) : new org.hl7.fhir.model.core.CanonicalType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CanonicalType convertUriToCanonical(org.hl7.fhir.model.core.UriType src) throws FHIRException {
    org.hl7.fhir.r4b.model.CanonicalType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.CanonicalType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.CanonicalType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

}
