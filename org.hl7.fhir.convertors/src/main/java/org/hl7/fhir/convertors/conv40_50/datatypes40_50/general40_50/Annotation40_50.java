package org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.MarkDown40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Annotation40_50 {
  public static org.hl7.fhir.r5.model.Annotation convertAnnotation(org.hl7.fhir.r4.model.Annotation src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Annotation tgt = new org.hl7.fhir.r5.model.Annotation();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasAuthor())
      tgt.setAuthor(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getAuthor()));
    if (src.hasTime()) tgt.setTimeElement(DateTime40_50.convertDateTime(src.getTimeElement()));
    if (src.hasText()) tgt.setTextElement(MarkDown40_50.convertMarkdown(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Annotation convertAnnotation(org.hl7.fhir.r5.model.Annotation src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Annotation tgt = new org.hl7.fhir.r4.model.Annotation();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasAuthor())
      tgt.setAuthor(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getAuthor()));
    if (src.hasTime()) tgt.setTimeElement(DateTime40_50.convertDateTime(src.getTimeElement()));
    if (src.hasText()) tgt.setTextElement(MarkDown40_50.convertMarkdown(src.getTextElement()));
    return tgt;
  }
}
