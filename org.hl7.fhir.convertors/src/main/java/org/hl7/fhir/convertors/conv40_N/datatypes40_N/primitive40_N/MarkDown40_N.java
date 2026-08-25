package org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class MarkDown40_N {
  public static org.hl7.fhir.model.core.MarkdownType convertMarkdown(org.hl7.fhir.r4.model.MarkdownType src) throws FHIRException {
    org.hl7.fhir.model.core.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.model.core.MarkdownType(src.getValueAsString()) : new org.hl7.fhir.model.core.MarkdownType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MarkdownType convertMarkdown(org.hl7.fhir.model.core.MarkdownType src) throws FHIRException {
    org.hl7.fhir.r4.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.MarkdownType(src.getValueAsString()) : new org.hl7.fhir.r4.model.MarkdownType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.model.core.MarkdownType convertStringToMarkdown(org.hl7.fhir.r4.model.StringType src) throws FHIRException {
    org.hl7.fhir.model.core.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.model.core.MarkdownType(src.getValueAsString()) : new org.hl7.fhir.model.core.MarkdownType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }
}
