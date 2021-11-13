package org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class CodeableConcept10_30 {
  public static org.hl7.fhir.dstu3.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.dstu2.model.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.CodeableConcept tgt = new org.hl7.fhir.dstu3.model.CodeableConcept();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu2.model.Coding t : src.getCoding()) tgt.addCoding(Coding10_30.convertCoding(t));
    if (src.hasTextElement()) tgt.setTextElement(String10_30.convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.dstu3.model.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.CodeableConcept tgt = new org.hl7.fhir.dstu2.model.CodeableConcept();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.Coding t : src.getCoding()) tgt.addCoding(Coding10_30.convertCoding(t));
    if (src.hasTextElement()) tgt.setTextElement(String10_30.convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.UsageContext convertCodeableConceptToUsageContext(org.hl7.fhir.dstu2.model.CodeableConcept t) throws FHIRException {
    org.hl7.fhir.dstu3.model.UsageContext result = new org.hl7.fhir.dstu3.model.UsageContext();
    result.setValue(convertCodeableConcept(t));
    return result;
  }

  static public boolean hasConcept(org.hl7.fhir.dstu3.model.CodeableConcept cc, String system, String code) {
    for (org.hl7.fhir.dstu3.model.Coding c : cc.getCoding()) {
      if (system.equals(c.getSystem()) && code.equals(c.getCode())) return true;
    }
    return false;
  }

  static public boolean hasConcept(org.hl7.fhir.dstu2.model.CodeableConcept cc, String system, String code) {
    for (org.hl7.fhir.dstu2.model.Coding c : cc.getCoding()) {
      if (system.equals(c.getSystem()) && code.equals(c.getCode())) return true;
    }
    return false;
  }
}
