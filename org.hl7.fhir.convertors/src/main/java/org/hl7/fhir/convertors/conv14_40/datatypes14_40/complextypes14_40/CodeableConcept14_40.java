package org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40;

import org.hl7.fhir.convertors.context.ConversionContext14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.String14_40;
import org.hl7.fhir.exceptions.FHIRException;  import org.hl7.fhir.convertors.context.ConversionContext14_40;

public class CodeableConcept14_40 {
    public static org.hl7.fhir.r4.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.dstu2016may.model.CodeableConcept src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.CodeableConcept tgt = new org.hl7.fhir.r4.model.CodeableConcept();
      ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
      for (org.hl7.fhir.dstu2016may.model.Coding t : src.getCoding()) tgt.addCoding(Coding14_40.convertCoding(t));
      if (src.hasText()) tgt.setTextElement(String14_40.convertString(src.getTextElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.r4.model.CodeableConcept src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.CodeableConcept tgt = new org.hl7.fhir.dstu2016may.model.CodeableConcept();
      ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
      for (org.hl7.fhir.r4.model.Coding t : src.getCoding()) tgt.addCoding(Coding14_40.convertCoding(t));
      if (src.hasText()) tgt.setTextElement(String14_40.convertString(src.getTextElement()));
      return tgt;
    }

  public static org.hl7.fhir.r4.model.UsageContext convertCodeableConceptToUsageContext(org.hl7.fhir.dstu2016may.model.CodeableConcept t) throws FHIRException {
    org.hl7.fhir.r4.model.UsageContext result = new org.hl7.fhir.r4.model.UsageContext();
    result.setValue(convertCodeableConcept(t));
    return result;
  }
}
