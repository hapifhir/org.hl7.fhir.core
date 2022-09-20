package org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

public class CodeableConcept43_50 {
  public static org.hl7.fhir.r5.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.r4b.model.CodeableConcept src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.CodeableConcept tgt = new org.hl7.fhir.r5.model.CodeableConcept();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    for (org.hl7.fhir.r4b.model.Coding t : src.getCoding()) tgt.addCoding(Coding43_50.convertCoding(t));
    if (src.hasText()) tgt.setTextElement(String43_50.convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.CodeableConcept tgt = new org.hl7.fhir.r4b.model.CodeableConcept();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.Coding t : src.getCoding()) tgt.addCoding(Coding43_50.convertCoding(t));
    if (src.hasText()) tgt.setTextElement(String43_50.convertString(src.getTextElement()));
    return tgt;
  }

  public static CodeableReference convertCodeableConceptToCodeableReference(org.hl7.fhir.r4b.model.CodeableConcept src) {
    CodeableReference tgt = new CodeableReference();
    tgt.setConcept(convertCodeableConcept(src));
    return tgt;
  }
  
  public static org.hl7.fhir.r4b.model.CodeableConcept convertCodeableReferenceToCodeableConcept(CodeableReference src) {
    return convertCodeableConcept(src.getConcept());
  }
}
