package org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50;

import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Element14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.String14_50;
import org.hl7.fhir.dstu2016may.model.CodeableConcept;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext14_50; 

public class CodeableConcept14_50 {
    public static org.hl7.fhir.r5.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.dstu2016may.model.CodeableConcept src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.CodeableConcept tgt = new org.hl7.fhir.r5.model.CodeableConcept();
      ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
      for (org.hl7.fhir.dstu2016may.model.Coding t : src.getCoding()) tgt.addCoding(Coding14_50.convertCoding(t));
      if (src.hasText()) tgt.setTextElement(String14_50.convertString(src.getTextElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.CodeableConcept tgt = new org.hl7.fhir.dstu2016may.model.CodeableConcept();
      ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
      for (org.hl7.fhir.r5.model.Coding t : src.getCoding()) tgt.addCoding(Coding14_50.convertCoding(t));
      if (src.hasText()) tgt.setTextElement(String14_50.convertString(src.getTextElement()));
      return tgt;
    }

  static public boolean isJurisdiction(CodeableConcept t) {
    return t.hasCoding() && ("http://unstats.un.org/unsd/methods/m49/m49.htm".equals(t.getCoding().get(0).getSystem()) || "urn:iso:std:iso:3166".equals(t.getCoding().get(0).getSystem()) || "https://www.usps.com/".equals(t.getCoding().get(0).getSystem()));
  }

  public static org.hl7.fhir.r5.model.UsageContext convertCodeableConceptToUsageContext(CodeableConcept t) throws FHIRException {
    org.hl7.fhir.r5.model.UsageContext result = new org.hl7.fhir.r5.model.UsageContext();
    result.setValue(convertCodeableConcept(t));
    return result;
  }
}
