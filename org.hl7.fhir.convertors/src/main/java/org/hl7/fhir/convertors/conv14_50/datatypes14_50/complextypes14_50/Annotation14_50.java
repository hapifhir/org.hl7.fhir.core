package org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50;

import org.hl7.fhir.convertors.context.ConversionContext14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.DateTime14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Annotation14_50 {
  public static org.hl7.fhir.r5.model.Annotation convertAnnotation(org.hl7.fhir.dstu2016may.model.Annotation src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Annotation tgt = new org.hl7.fhir.r5.model.Annotation();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasAuthor())
      tgt.setAuthor(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getAuthor()));
    if (src.hasTime()) tgt.setTimeElement(DateTime14_50.convertDateTime(src.getTimeElement()));
    tgt.setText(src.getText());
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Annotation convertAnnotation(org.hl7.fhir.r5.model.Annotation src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Annotation tgt = new org.hl7.fhir.dstu2016may.model.Annotation();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasAuthor())
      tgt.setAuthor(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getAuthor()));
    if (src.hasTime()) tgt.setTimeElement(DateTime14_50.convertDateTime(src.getTimeElement()));
    tgt.setText(src.getText());
    return tgt;
  }
}
