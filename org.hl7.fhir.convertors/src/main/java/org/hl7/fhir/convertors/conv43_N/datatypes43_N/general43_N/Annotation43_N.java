package org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.MarkDown43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Annotation43_N {
  public static org.hl7.fhir.model.core.Annotation convertAnnotation(org.hl7.fhir.r4b.model.Annotation src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Annotation tgt = new org.hl7.fhir.model.core.Annotation();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasAuthor())
      tgt.setAuthor(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getAuthor()));
    if (src.hasTime()) tgt.setTimeElement(DateTime43_N.convertDateTime(src.getTimeElement()));
    if (src.hasText()) tgt.setTextElement(MarkDown43_N.convertMarkdown(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Annotation convertAnnotation(org.hl7.fhir.model.core.Annotation src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Annotation tgt = new org.hl7.fhir.r4b.model.Annotation();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasAuthor())
      tgt.setAuthor(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getAuthor()));
    if (src.hasTime()) tgt.setTimeElement(DateTime43_N.convertDateTime(src.getTimeElement()));
    if (src.hasText()) tgt.setTextElement(MarkDown43_N.convertMarkdown(src.getTextElement()));
    return tgt;
  }
}
