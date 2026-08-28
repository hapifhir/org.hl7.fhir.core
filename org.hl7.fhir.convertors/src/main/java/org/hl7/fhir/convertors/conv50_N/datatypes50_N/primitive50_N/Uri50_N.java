package org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N;

import org.hl7.fhir.convertors.context.ConversionContext50_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Uri50_N {
  public static org.hl7.fhir.model.core.UriType convertUri(org.hl7.fhir.r5.model.UriType src) throws FHIRException {
    org.hl7.fhir.model.core.UriType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UriType(src.getValueAsString()) : new org.hl7.fhir.model.core.UriType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.UriType convertUri(org.hl7.fhir.model.core.UriType src) throws FHIRException {
    org.hl7.fhir.r5.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UriType(src.getValueAsString()) : new org.hl7.fhir.r5.model.UriType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }


  public static org.hl7.fhir.model.core.UriType convertUriFromCode(org.hl7.fhir.r5.model.CodeType src) throws FHIRException {
    org.hl7.fhir.model.core.UriType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UriType(src.getValueAsString()) : new org.hl7.fhir.model.core.UriType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CodeType convertUriToCode(org.hl7.fhir.model.core.UriType src) throws FHIRException {
    org.hl7.fhir.r5.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.CodeType(src.getValueAsString()) : new org.hl7.fhir.r5.model.CodeType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.model.core.UriType convertUriFromString(org.hl7.fhir.r5.model.StringType src) throws FHIRException {
    org.hl7.fhir.model.core.UriType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UriType(src.getValueAsString()) : new org.hl7.fhir.model.core.UriType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StringType convertUriToString(org.hl7.fhir.model.core.UriType src) throws FHIRException {
    org.hl7.fhir.r5.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.StringType(src.getValueAsString()) : new org.hl7.fhir.r5.model.StringType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }
}
