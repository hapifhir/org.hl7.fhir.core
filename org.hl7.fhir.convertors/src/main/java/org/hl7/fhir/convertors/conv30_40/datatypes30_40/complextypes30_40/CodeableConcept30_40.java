package org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40;

import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext30_40;

public class CodeableConcept30_40 {
    public static org.hl7.fhir.r4.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.dstu3.model.CodeableConcept src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r4.model.CodeableConcept tgt = new org.hl7.fhir.r4.model.CodeableConcept();
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      for (org.hl7.fhir.dstu3.model.Coding t : src.getCoding()) tgt.addCoding(Coding30_40.convertCoding(t));
      if (src.hasText()) tgt.setTextElement(String30_40.convertString(src.getTextElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.r4.model.CodeableConcept src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.CodeableConcept tgt = new org.hl7.fhir.dstu3.model.CodeableConcept();
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      for (org.hl7.fhir.r4.model.Coding t : src.getCoding()) tgt.addCoding(Coding30_40.convertCoding(t));
      if (src.hasText()) tgt.setTextElement(String30_40.convertString(src.getTextElement()));
      return tgt;
    }
}
