package org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeableReference;

public class CodeableConcept40_N {
  public static org.hl7.fhir.model.core.CodeableConcept convertCodeableConcept(org.hl7.fhir.r4.model.CodeableConcept src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.CodeableConcept tgt = new org.hl7.fhir.model.core.CodeableConcept();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.Coding t : src.getCoding()) tgt.addCoding(Coding40_N.convertCoding(t));
    if (src.hasText()) tgt.setTextElement(String40_N.convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.model.core.CodeableConcept src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.CodeableConcept tgt = new org.hl7.fhir.r4.model.CodeableConcept();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    for (org.hl7.fhir.model.core.Coding t : src.getCodingList()) tgt.addCoding(Coding40_N.convertCoding(t));
    if (src.hasText()) tgt.setTextElement(String40_N.convertString(src.getTextElement()));
    return tgt;
  }

  public static CodeableReference convertCodeableConceptToCodeableReference(org.hl7.fhir.r4.model.CodeableConcept src) {
    CodeableReference tgt = new CodeableReference();
    tgt.setConcept(convertCodeableConcept(src));
    return tgt;
  }
  

  public static org.hl7.fhir.r4.model.CodeableConcept convertCodeableReferenceToCodeableConcept(CodeableReference src) {
    return convertCodeableConcept(src.getConcept());
  }
}

