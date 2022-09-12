package org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class String40_50 {
  public static org.hl7.fhir.r5.model.StringType convertString(org.hl7.fhir.r4.model.StringType src) throws FHIRException {
    org.hl7.fhir.r5.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.StringType(src.getValueAsString()) : new org.hl7.fhir.r5.model.StringType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StringType convertString(org.hl7.fhir.r5.model.StringType src) throws FHIRException {
    org.hl7.fhir.r4.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.StringType(src.getValueAsString()) : new org.hl7.fhir.r4.model.StringType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }
  


  public static org.hl7.fhir.r5.model.MarkdownType convertStringToMarkdown(org.hl7.fhir.r4.model.StringType src) throws FHIRException {
    org.hl7.fhir.r5.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.MarkdownType(src.getValueAsString()) : new org.hl7.fhir.r5.model.MarkdownType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StringType convertMarkdownToString(org.hl7.fhir.r5.model.MarkdownType src) throws FHIRException {
    org.hl7.fhir.r4.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.StringType(src.getValue()) : new org.hl7.fhir.r4.model.StringType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

}
