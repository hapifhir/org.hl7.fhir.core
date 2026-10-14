package org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class String40_N {
  public static org.hl7.fhir.model.core.StringType convertString(org.hl7.fhir.r4.model.StringType src) throws FHIRException {
    org.hl7.fhir.model.core.StringType tgt = src.hasValue() ? new org.hl7.fhir.model.core.StringType(src.getValueAsString()) : new org.hl7.fhir.model.core.StringType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StringType convertString(org.hl7.fhir.model.core.StringType src) throws FHIRException {
    org.hl7.fhir.r4.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.StringType(src.getValueAsString()) : new org.hl7.fhir.r4.model.StringType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }
  


  public static org.hl7.fhir.model.core.MarkdownType convertStringToMarkdown(org.hl7.fhir.r4.model.StringType src) throws FHIRException {
    org.hl7.fhir.model.core.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.model.core.MarkdownType(src.getValueAsString()) : new org.hl7.fhir.model.core.MarkdownType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StringType convertMarkdownToString(org.hl7.fhir.model.core.MarkdownType src) throws FHIRException {
    org.hl7.fhir.r4.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.StringType(src.getValue()) : new org.hl7.fhir.r4.model.StringType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.model.core.UriType convertStringToUri(org.hl7.fhir.r4.model.StringType src) throws FHIRException {
    org.hl7.fhir.model.core.UriType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UriType(src.getValueAsString()) : new org.hl7.fhir.model.core.UriType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StringType convertStringFromUri(org.hl7.fhir.model.core.UriType src) throws FHIRException {
    org.hl7.fhir.r4.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.StringType(src.getValue()) : new org.hl7.fhir.r4.model.StringType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

}
