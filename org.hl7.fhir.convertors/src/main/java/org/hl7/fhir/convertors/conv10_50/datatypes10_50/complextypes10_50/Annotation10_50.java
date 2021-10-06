package org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.DateTime10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Annotation10_50 {
  public static org.hl7.fhir.r5.model.Annotation convertAnnotation(org.hl7.fhir.dstu2.model.Annotation src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Annotation tgt = new org.hl7.fhir.r5.model.Annotation();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasAuthor())
      tgt.setAuthor(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getAuthor()));
    if (src.hasTimeElement()) tgt.setTimeElement(DateTime10_50.convertDateTime(src.getTimeElement()));
    if (src.hasText()) tgt.setText(src.getText());
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Annotation convertAnnotation(org.hl7.fhir.r5.model.Annotation src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Annotation tgt = new org.hl7.fhir.dstu2.model.Annotation();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasAuthor())
      tgt.setAuthor(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getAuthor()));
    if (src.hasTimeElement()) tgt.setTimeElement(DateTime10_50.convertDateTime(src.getTimeElement()));
    if (src.hasText()) tgt.setText(src.getText());
    return tgt;
  }
}
