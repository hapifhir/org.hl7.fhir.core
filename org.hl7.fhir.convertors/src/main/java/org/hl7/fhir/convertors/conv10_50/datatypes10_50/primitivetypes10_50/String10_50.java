package org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class String10_50 {
  public static org.hl7.fhir.r5.model.StringType convertString(org.hl7.fhir.dstu2.model.StringType src) throws FHIRException {
    org.hl7.fhir.r5.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.StringType(src.getValueAsString()) : new org.hl7.fhir.r5.model.StringType();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.StringType convertString(org.hl7.fhir.r5.model.StringType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.StringType(src.getValueAsString()) : new org.hl7.fhir.dstu2.model.StringType();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.StringType convertMarkdownToString(org.hl7.fhir.r5.model.MarkdownType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.StringType(src.getValueAsString()) : new org.hl7.fhir.dstu2.model.StringType();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    return tgt;
  }
  
  public static org.hl7.fhir.r5.model.MarkdownType convertStringToMarkdown(org.hl7.fhir.dstu2.model.StringType src) throws FHIRException {
    org.hl7.fhir.r5.model.MarkdownType  tgt = src.hasValue() ? new org.hl7.fhir.r5.model.MarkdownType (src.getValueAsString()) : new org.hl7.fhir.r5.model.MarkdownType ();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    return tgt;
  }
  
}
