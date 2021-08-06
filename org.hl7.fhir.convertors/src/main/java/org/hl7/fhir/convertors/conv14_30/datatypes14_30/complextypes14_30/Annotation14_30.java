package org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30;

import org.hl7.fhir.convertors.context.ConversionContext14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.DateTime14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.String14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Annotation14_30 {
  public static org.hl7.fhir.dstu3.model.Annotation convertAnnotation(org.hl7.fhir.dstu2016may.model.Annotation src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Annotation tgt = new org.hl7.fhir.dstu3.model.Annotation();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasAuthor())
      tgt.setAuthor(ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().convertType(src.getAuthor()));
    if (src.hasTime()) tgt.setTimeElement(DateTime14_30.convertDateTime(src.getTimeElement()));
    if (src.hasTextElement()) tgt.setTextElement(String14_30.convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Annotation convertAnnotation(org.hl7.fhir.dstu3.model.Annotation src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Annotation tgt = new org.hl7.fhir.dstu2016may.model.Annotation();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasAuthor())
      tgt.setAuthor(ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().convertType(src.getAuthor()));
    if (src.hasTime()) tgt.setTimeElement(DateTime14_30.convertDateTime(src.getTimeElement()));
    if (src.hasTextElement()) tgt.setTextElement(String14_30.convertString(src.getTextElement()));
    return tgt;
  }
}
