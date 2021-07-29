package org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.DateTime30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Annotation30_50 {
  public static org.hl7.fhir.r5.model.Annotation convertAnnotation(org.hl7.fhir.dstu3.model.Annotation src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Annotation tgt = new org.hl7.fhir.r5.model.Annotation();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasAuthor()) tgt.setAuthor(VersionConvertorFactory_30_50.convertType(src.getAuthor()));
    if (src.hasTime()) tgt.setTimeElement(DateTime30_50.convertDateTime(src.getTimeElement()));
    if (src.hasText()) tgt.setText(src.getText());
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Annotation convertAnnotation(org.hl7.fhir.r5.model.Annotation src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.Annotation tgt = new org.hl7.fhir.dstu3.model.Annotation();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasAuthor()) tgt.setAuthor(VersionConvertorFactory_30_50.convertType(src.getAuthor()));
    if (src.hasTime()) tgt.setTimeElement(DateTime30_50.convertDateTime(src.getTimeElement()));
    if (src.hasText()) tgt.setText(src.getText());
    return tgt;
  }
}
