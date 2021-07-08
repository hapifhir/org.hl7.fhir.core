package org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40;

import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class MarkDown30_40 {
    public static org.hl7.fhir.r4.model.MarkdownType convertMarkdown(org.hl7.fhir.dstu3.model.MarkdownType src) throws FHIRException {
      org.hl7.fhir.r4.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.MarkdownType(src.getValue()) : new org.hl7.fhir.r4.model.MarkdownType();
      Element30_40.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MarkdownType convertMarkdown(org.hl7.fhir.r4.model.MarkdownType src) throws FHIRException {
      org.hl7.fhir.dstu3.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.MarkdownType(src.getValue()) : new org.hl7.fhir.dstu3.model.MarkdownType();
      Element30_40.copyElement(src, tgt);
      return tgt;
    }
}
