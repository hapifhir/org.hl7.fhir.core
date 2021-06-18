package org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50;

import org.hl7.fhir.convertors.conv40_50.datatypes40_50.Element40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class CodeableConcept40_50 {
  public static org.hl7.fhir.r5.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.r4.model.CodeableConcept src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.CodeableConcept tgt = new org.hl7.fhir.r5.model.CodeableConcept();
    Element40_50.copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.Coding t : src.getCoding()) tgt.addCoding(Coding40_50.convertCoding(t));
    if (src.hasText()) tgt.setTextElement(String40_50.convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.CodeableConcept tgt = new org.hl7.fhir.r4.model.CodeableConcept();
    Element40_50.copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.Coding t : src.getCoding()) tgt.addCoding(Coding40_50.convertCoding(t));
    if (src.hasText()) tgt.setTextElement(String40_50.convertString(src.getTextElement()));
    return tgt;
  }
}
