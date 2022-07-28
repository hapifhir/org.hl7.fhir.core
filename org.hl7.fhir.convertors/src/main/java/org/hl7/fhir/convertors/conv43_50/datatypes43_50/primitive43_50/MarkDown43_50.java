package org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class MarkDown43_50 {
  public static org.hl7.fhir.r5.model.MarkdownType convertMarkdown(org.hl7.fhir.r4b.model.MarkdownType src) throws FHIRException {
    org.hl7.fhir.r5.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.MarkdownType(src.getValueAsString()) : new org.hl7.fhir.r5.model.MarkdownType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MarkdownType convertMarkdown(org.hl7.fhir.r5.model.MarkdownType src) throws FHIRException {
    org.hl7.fhir.r4b.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.MarkdownType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.MarkdownType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MarkdownType convertStringToMarkdown(org.hl7.fhir.r4b.model.StringType src) throws FHIRException {
    org.hl7.fhir.r5.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.MarkdownType(src.getValueAsString()) : new org.hl7.fhir.r5.model.MarkdownType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }
}
