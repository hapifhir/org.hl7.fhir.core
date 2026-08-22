package org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class String43_N {
  public static org.hl7.fhir.model.core.StringType convertString(org.hl7.fhir.r4b.model.StringType src) throws FHIRException {
    org.hl7.fhir.model.core.StringType tgt = src.hasValue() ? new org.hl7.fhir.model.core.StringType(src.getValueAsString()) : new org.hl7.fhir.model.core.StringType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.StringType convertString(org.hl7.fhir.model.core.StringType src) throws FHIRException {
    org.hl7.fhir.r4b.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.StringType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.StringType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }
  


  public static org.hl7.fhir.model.core.MarkdownType convertStringToMarkdown(org.hl7.fhir.r4b.model.StringType src) throws FHIRException {
    org.hl7.fhir.model.core.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.model.core.MarkdownType(src.getValueAsString()) : new org.hl7.fhir.model.core.MarkdownType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.StringType convertMarkdownToString(org.hl7.fhir.model.core.MarkdownType src) throws FHIRException {
    org.hl7.fhir.r4b.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.StringType(src.getValue()) : new org.hl7.fhir.r4b.model.StringType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.model.core.UriType convertStringToUri(org.hl7.fhir.r4b.model.StringType src) throws FHIRException {
    org.hl7.fhir.model.core.UriType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UriType(src.getValueAsString()) : new org.hl7.fhir.model.core.UriType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.StringType convertStringFromUri(org.hl7.fhir.model.core.UriType src) throws FHIRException {
    org.hl7.fhir.r4b.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.StringType(src.getValue()) : new org.hl7.fhir.r4b.model.StringType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

}
