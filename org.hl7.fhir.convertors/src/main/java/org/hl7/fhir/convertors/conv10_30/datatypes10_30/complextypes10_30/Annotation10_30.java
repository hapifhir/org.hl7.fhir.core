package org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30;

import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Type10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.DateTime10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Annotation10_30 {
  public static org.hl7.fhir.dstu3.model.Annotation convertAnnotation(org.hl7.fhir.dstu2.model.Annotation src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Annotation tgt = new org.hl7.fhir.dstu3.model.Annotation();
    Element10_30.copyElement(src, tgt);
    if (src.hasAuthor()) tgt.setAuthor(Type10_30.convertType(src.getAuthor()));
    if (src.hasTimeElement()) tgt.setTimeElement(DateTime10_30.convertDateTime(src.getTimeElement()));
    if (src.hasTextElement()) tgt.setTextElement(String10_30.convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Annotation convertAnnotation(org.hl7.fhir.dstu3.model.Annotation src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Annotation tgt = new org.hl7.fhir.dstu2.model.Annotation();
    Element10_30.copyElement(src, tgt);
    if (src.hasAuthor()) tgt.setAuthor(Type10_30.convertType(src.getAuthor()));
    if (src.hasTimeElement()) tgt.setTimeElement(DateTime10_30.convertDateTime(src.getTimeElement()));
    if (src.hasTextElement()) tgt.setTextElement(String10_30.convertString(src.getTextElement()));
    return tgt;
  }
}
