package org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30;

import org.hl7.fhir.convertors.context.ConversionContext14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Code14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.String14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class CodeableConcept14_30 {
  public static org.hl7.fhir.dstu3.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.dstu2016may.model.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.CodeableConcept tgt = new org.hl7.fhir.dstu3.model.CodeableConcept();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu2016may.model.Coding t : src.getCoding()) tgt.addCoding(Code14_30.convertCoding(t));
    if (src.hasText()) tgt.setTextElement(String14_30.convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.dstu3.model.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.CodeableConcept tgt = new org.hl7.fhir.dstu2016may.model.CodeableConcept();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.Coding t : src.getCoding()) tgt.addCoding(Code14_30.convertCoding(t));
    if (src.hasText()) tgt.setTextElement(String14_30.convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.UsageContext convertCodeableConceptToUsageContext(org.hl7.fhir.dstu2016may.model.CodeableConcept t) throws FHIRException {
    org.hl7.fhir.dstu3.model.UsageContext result = new org.hl7.fhir.dstu3.model.UsageContext();
    result.setValue(convertCodeableConcept(t));
    return result;
  }
}
