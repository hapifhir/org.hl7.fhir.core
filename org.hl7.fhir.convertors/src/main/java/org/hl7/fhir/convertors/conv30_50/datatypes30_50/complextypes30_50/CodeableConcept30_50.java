package org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50;

import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Element30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class CodeableConcept30_50 {
    public static org.hl7.fhir.r5.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.dstu3.model.CodeableConcept src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r5.model.CodeableConcept tgt = new org.hl7.fhir.r5.model.CodeableConcept();
      Element30_50.copyElement(src, tgt);
      for (org.hl7.fhir.dstu3.model.Coding t : src.getCoding()) tgt.addCoding(Coding30_50.convertCoding(t));
      if (src.hasText()) tgt.setTextElement(String30_50.convertString(src.getTextElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.CodeableConcept tgt = new org.hl7.fhir.dstu3.model.CodeableConcept();
      Element30_50.copyElement(src, tgt);
      for (org.hl7.fhir.r5.model.Coding t : src.getCoding()) tgt.addCoding(Coding30_50.convertCoding(t));
      if (src.hasText()) tgt.setTextElement(String30_50.convertString(src.getTextElement()));
      return tgt;
    }
}
