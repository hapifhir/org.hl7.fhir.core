package org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Uri10_50 {
  public static org.hl7.fhir.r5.model.UriType convertUri(org.hl7.fhir.dstu2.model.UriType src) throws FHIRException {
    org.hl7.fhir.r5.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UriType(src.getValueAsString()) : new org.hl7.fhir.r5.model.UriType();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.UriType convertUri(org.hl7.fhir.r5.model.UriType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.UriType(src.getValueAsString()) : new org.hl7.fhir.dstu2.model.UriType();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    return tgt;
  }
  

  public static org.hl7.fhir.r5.model.CanonicalType convertCanonical(org.hl7.fhir.dstu2.model.UriType src) throws FHIRException {
    org.hl7.fhir.r5.model.CanonicalType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.CanonicalType(src.getValueAsString()) : new org.hl7.fhir.r5.model.CanonicalType();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.UriType convertCanonical(org.hl7.fhir.r5.model.CanonicalType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.UriType(src.getValueAsString()) : new org.hl7.fhir.dstu2.model.UriType();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    return tgt;
  }
  
}
