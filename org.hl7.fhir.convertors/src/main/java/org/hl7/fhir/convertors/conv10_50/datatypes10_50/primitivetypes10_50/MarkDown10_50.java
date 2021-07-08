package org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50;

import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Element10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class MarkDown10_50 {
    public static org.hl7.fhir.r5.model.MarkdownType convertMarkdown(org.hl7.fhir.dstu2.model.MarkdownType src) throws FHIRException {
      org.hl7.fhir.r5.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.MarkdownType(src.getValue()) : new org.hl7.fhir.r5.model.MarkdownType();
      Element10_50.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MarkdownType convertMarkdown(org.hl7.fhir.r5.model.MarkdownType src) throws FHIRException {
      org.hl7.fhir.dstu2.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.MarkdownType(src.getValue()) : new org.hl7.fhir.dstu2.model.MarkdownType();
      Element10_50.copyElement(src, tgt);
      return tgt;
    }

  public static org.hl7.fhir.r5.model.MarkdownType convertStringToMarkdown(org.hl7.fhir.dstu2.model.StringType src) throws FHIRException {
    org.hl7.fhir.r5.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.MarkdownType(src.getValue()) : new org.hl7.fhir.r5.model.MarkdownType();
    Element10_50.copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.StringType convertMarkdownToString(org.hl7.fhir.r5.model.MarkdownType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.StringType(src.getValue()) : new org.hl7.fhir.dstu2.model.StringType();
    Element10_50.copyElement(src, tgt);
    return tgt;
  }
}
