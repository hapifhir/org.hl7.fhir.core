package org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class MarkDown30_50 {
  public static org.hl7.fhir.r5.model.MarkdownType convertMarkdown(org.hl7.fhir.dstu3.model.MarkdownType src) throws FHIRException {
    org.hl7.fhir.r5.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.MarkdownType(src.getValue()) : new org.hl7.fhir.r5.model.MarkdownType();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.MarkdownType convertMarkdown(org.hl7.fhir.r5.model.MarkdownType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.MarkdownType(src.getValue()) : new org.hl7.fhir.dstu3.model.MarkdownType();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    return tgt;
  }
}
