package org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30;

import org.hl7.fhir.convertors.context.ConversionContext14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class MarkDown14_30 {
  public static org.hl7.fhir.dstu3.model.MarkdownType convertMarkdown(org.hl7.fhir.dstu2016may.model.MarkdownType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.MarkdownType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.MarkdownType();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.MarkdownType convertMarkdown(org.hl7.fhir.dstu3.model.MarkdownType src) throws FHIRException {
    org.hl7.fhir.dstu2016may.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.dstu2016may.model.MarkdownType(src.getValueAsString()) : new org.hl7.fhir.dstu2016may.model.MarkdownType();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    return tgt;
  }
}
