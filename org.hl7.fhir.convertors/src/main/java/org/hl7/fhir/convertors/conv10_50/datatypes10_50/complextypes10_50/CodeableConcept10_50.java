package org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50;

import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Element10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.dstu2.model.CodeableConcept;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

public class CodeableConcept10_50 {
    public static org.hl7.fhir.r5.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.dstu2.model.CodeableConcept src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.CodeableConcept tgt = new org.hl7.fhir.r5.model.CodeableConcept();
      Element10_50.copyElement(src, tgt);
      for (org.hl7.fhir.dstu2.model.Coding t : src.getCoding()) tgt.addCoding(Coding10_50.convertCoding(t));
      if (src.hasTextElement()) tgt.setTextElement(String10_50.convertString(src.getTextElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.CodeableConcept tgt = new org.hl7.fhir.dstu2.model.CodeableConcept();
      Element10_50.copyElement(src, tgt);
      for (org.hl7.fhir.r5.model.Coding t : src.getCoding()) tgt.addCoding(Coding10_50.convertCoding(t));
      if (src.hasTextElement()) tgt.setTextElement(String10_50.convertString(src.getTextElement()));
      return tgt;
    }

  static public CodeableReference convertCodeableConceptToCodableReference(CodeableConcept src) {
    CodeableReference tgt = new CodeableReference();
    tgt.setConcept(convertCodeableConcept(src));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.UsageContext convertCodeableConceptToUsageContext(CodeableConcept t) throws FHIRException {
    org.hl7.fhir.r5.model.UsageContext result = new org.hl7.fhir.r5.model.UsageContext();
    result.setValue(convertCodeableConcept(t));
    return result;
  }

  static public boolean hasConcept(org.hl7.fhir.r5.model.CodeableConcept cc, String system, String code) {
    for (org.hl7.fhir.r5.model.Coding c : cc.getCoding()) {
      if (system.equals(c.getSystem()) && code.equals(c.getCode())) return true;
    }
    return false;
  }

  static public boolean hasConcept(CodeableConcept cc, String system, String code) {
    for (org.hl7.fhir.dstu2.model.Coding c : cc.getCoding()) {
      if (system.equals(c.getSystem()) && code.equals(c.getCode())) return true;
    }
    return false;
  }
}
