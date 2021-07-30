package org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30;

import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class MarkDown10_30 {
  public static org.hl7.fhir.dstu3.model.MarkdownType convertMarkdown(org.hl7.fhir.dstu2.model.MarkdownType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.MarkdownType(src.getValue()) : new org.hl7.fhir.dstu3.model.MarkdownType();
    Element10_30.copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MarkdownType convertMarkdown(org.hl7.fhir.dstu3.model.MarkdownType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.MarkdownType(src.getValue()) : new org.hl7.fhir.dstu2.model.MarkdownType();
    Element10_30.copyElement(src, tgt);
    return tgt;
  }
}
