package org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N;

import org.hl7.fhir.convertors.context.ConversionContext50_N;
import org.hl7.fhir.exceptions.FHIRException;

public class String50_N {
  public static org.hl7.fhir.model.core.StringType convertString(org.hl7.fhir.r5.model.StringType src) throws FHIRException {
    org.hl7.fhir.model.core.StringType tgt = src.hasValue() ? new org.hl7.fhir.model.core.StringType(src.getValueAsString()) : new org.hl7.fhir.model.core.StringType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StringType convertString(org.hl7.fhir.model.core.StringType src) throws FHIRException {
    org.hl7.fhir.r5.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.StringType(src.getValueAsString()) : new org.hl7.fhir.r5.model.StringType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }
  


  public static org.hl7.fhir.model.core.MarkdownType convertStringToMarkdown(org.hl7.fhir.r5.model.StringType src) throws FHIRException {
    org.hl7.fhir.model.core.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.model.core.MarkdownType(src.getValueAsString()) : new org.hl7.fhir.model.core.MarkdownType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StringType convertMarkdownToString(org.hl7.fhir.model.core.MarkdownType src) throws FHIRException {
    org.hl7.fhir.r5.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.StringType(src.getValue()) : new org.hl7.fhir.r5.model.StringType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.model.core.UriType convertStringToUri(org.hl7.fhir.r5.model.StringType src) throws FHIRException {
    org.hl7.fhir.model.core.UriType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UriType(src.getValueAsString()) : new org.hl7.fhir.model.core.UriType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StringType convertStringFromUri(org.hl7.fhir.model.core.UriType src) throws FHIRException {
    org.hl7.fhir.r5.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.StringType(src.getValue()) : new org.hl7.fhir.r5.model.StringType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

}
