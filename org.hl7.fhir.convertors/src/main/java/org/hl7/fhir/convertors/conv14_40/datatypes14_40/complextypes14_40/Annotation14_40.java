package org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40;

import org.hl7.fhir.convertors.context.ConversionContext14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.DateTime14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Annotation14_40 {
  public static org.hl7.fhir.r4.model.Annotation convertAnnotation(org.hl7.fhir.dstu2016may.model.Annotation src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Annotation tgt = new org.hl7.fhir.r4.model.Annotation();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    if (src.hasAuthor())
      tgt.setAuthor(ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().convertType(src.getAuthor()));
    if (src.hasTime()) tgt.setTimeElement(DateTime14_40.convertDateTime(src.getTimeElement()));
    tgt.setText(src.getText());
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Annotation convertAnnotation(org.hl7.fhir.r4.model.Annotation src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Annotation tgt = new org.hl7.fhir.dstu2016may.model.Annotation();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    if (src.hasAuthor())
      tgt.setAuthor(ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().convertType(src.getAuthor()));
    if (src.hasTime()) tgt.setTimeElement(DateTime14_40.convertDateTime(src.getTimeElement()));
    tgt.setText(src.getText());
    return tgt;
  }
}
