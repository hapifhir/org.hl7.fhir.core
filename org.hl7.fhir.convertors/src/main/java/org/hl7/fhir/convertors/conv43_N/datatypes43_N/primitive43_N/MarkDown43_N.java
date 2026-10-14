package org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class MarkDown43_N {
  public static org.hl7.fhir.model.core.MarkdownType convertMarkdown(org.hl7.fhir.r4b.model.MarkdownType src) throws FHIRException {
    org.hl7.fhir.model.core.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.model.core.MarkdownType(src.getValueAsString()) : new org.hl7.fhir.model.core.MarkdownType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MarkdownType convertMarkdown(org.hl7.fhir.model.core.MarkdownType src) throws FHIRException {
    org.hl7.fhir.r4b.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.MarkdownType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.MarkdownType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.model.core.MarkdownType convertStringToMarkdown(org.hl7.fhir.r4b.model.StringType src) throws FHIRException {
    org.hl7.fhir.model.core.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.model.core.MarkdownType(src.getValueAsString()) : new org.hl7.fhir.model.core.MarkdownType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }
}
