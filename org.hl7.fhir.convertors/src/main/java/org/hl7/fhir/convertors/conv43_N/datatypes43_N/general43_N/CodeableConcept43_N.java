package org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeableReference;

public class CodeableConcept43_N {
  public static org.hl7.fhir.model.core.CodeableConcept convertCodeableConcept(org.hl7.fhir.r4b.model.CodeableConcept src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.CodeableConcept tgt = new org.hl7.fhir.model.core.CodeableConcept();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    for (org.hl7.fhir.r4b.model.Coding t : src.getCoding()) tgt.addCoding(Coding43_N.convertCoding(t));
    if (src.hasText()) tgt.setTextElement(String43_N.convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.model.core.CodeableConcept src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.CodeableConcept tgt = new org.hl7.fhir.r4b.model.CodeableConcept();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    for (org.hl7.fhir.model.core.Coding t : src.getCodingList()) tgt.addCoding(Coding43_N.convertCoding(t));
    if (src.hasText()) tgt.setTextElement(String43_N.convertString(src.getTextElement()));
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

