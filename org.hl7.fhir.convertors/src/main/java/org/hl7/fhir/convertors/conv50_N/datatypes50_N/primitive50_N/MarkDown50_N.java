package org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N;

import org.hl7.fhir.convertors.context.ConversionContext50_N;
import org.hl7.fhir.exceptions.FHIRException;

public class MarkDown50_N {
  public static org.hl7.fhir.model.core.MarkdownType convertMarkDown(org.hl7.fhir.r5.model.MarkdownType src) throws FHIRException {
    org.hl7.fhir.model.core.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.model.core.MarkdownType(src.getValueAsString()) : new org.hl7.fhir.model.core.MarkdownType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MarkdownType convertMarkDown(org.hl7.fhir.model.core.MarkdownType src) throws FHIRException {
    org.hl7.fhir.r5.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.MarkdownType(src.getValueAsString()) : new org.hl7.fhir.r5.model.MarkdownType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.model.core.MarkdownType convertStringToMarkDown(org.hl7.fhir.r5.model.StringType src) throws FHIRException {
    org.hl7.fhir.model.core.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.model.core.MarkdownType(src.getValueAsString()) : new org.hl7.fhir.model.core.MarkdownType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StringType convertMarkDownToString(org.hl7.fhir.model.core.MarkdownType src) throws FHIRException {
    org.hl7.fhir.r5.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.StringType(src.getValueAsString()) : new org.hl7.fhir.r5.model.StringType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

}
