package org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.MarkDown43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Annotation43_50 {
  public static org.hl7.fhir.r5.model.Annotation convertAnnotation(org.hl7.fhir.r4b.model.Annotation src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Annotation tgt = new org.hl7.fhir.r5.model.Annotation();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasAuthor())
      tgt.setAuthor(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getAuthor()));
    if (src.hasTime()) tgt.setTimeElement(DateTime43_50.convertDateTime(src.getTimeElement()));
    if (src.hasText()) tgt.setTextElement(MarkDown43_50.convertMarkdown(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Annotation convertAnnotation(org.hl7.fhir.r5.model.Annotation src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Annotation tgt = new org.hl7.fhir.r4b.model.Annotation();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasAuthor())
      tgt.setAuthor(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getAuthor()));
    if (src.hasTime()) tgt.setTimeElement(DateTime43_50.convertDateTime(src.getTimeElement()));
    if (src.hasText()) tgt.setTextElement(MarkDown43_50.convertMarkdown(src.getTextElement()));
    return tgt;
  }
}
