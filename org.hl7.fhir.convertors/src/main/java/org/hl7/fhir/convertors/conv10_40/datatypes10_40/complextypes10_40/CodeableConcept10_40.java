package org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40;

import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext10_40;

public class CodeableConcept10_40 {
  public static org.hl7.fhir.r4.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.dstu2.model.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.CodeableConcept tgt = new org.hl7.fhir.r4.model.CodeableConcept();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    for (org.hl7.fhir.dstu2.model.Coding t : src.getCoding()) tgt.addCoding(Coding10_40.convertCoding(t));
    if (src.hasTextElement()) tgt.setTextElement(String10_40.convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.r4.model.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.CodeableConcept tgt = new org.hl7.fhir.dstu2.model.CodeableConcept();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.Coding t : src.getCoding()) tgt.addCoding(Coding10_40.convertCoding(t));
    if (src.hasTextElement()) tgt.setTextElement(String10_40.convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.UsageContext convertCodeableConceptToUsageContext(org.hl7.fhir.dstu2.model.CodeableConcept t) throws FHIRException {
    org.hl7.fhir.r4.model.UsageContext result = new org.hl7.fhir.r4.model.UsageContext();
    result.setValue(convertCodeableConcept(t));
    return result;
  }

  static public boolean hasConcept(org.hl7.fhir.r4.model.CodeableConcept cc, String system, String code) {
    for (org.hl7.fhir.r4.model.Coding c : cc.getCoding()) {
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
