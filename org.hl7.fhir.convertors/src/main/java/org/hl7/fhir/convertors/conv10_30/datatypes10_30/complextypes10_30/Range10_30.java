package org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30;

import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Range10_30 {
    public static org.hl7.fhir.dstu3.model.Range convertRange(org.hl7.fhir.dstu2.model.Range src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu3.model.Range tgt = new org.hl7.fhir.dstu3.model.Range();
      Element10_30.copyElement(src, tgt);
      if (src.hasLow()) tgt.setLow(SimpleQuantity10_30.convertSimpleQuantity(src.getLow()));
      if (src.hasHigh()) tgt.setHigh(SimpleQuantity10_30.convertSimpleQuantity(src.getHigh()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Range convertRange(org.hl7.fhir.dstu3.model.Range src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Range tgt = new org.hl7.fhir.dstu2.model.Range();
      Element10_30.copyElement(src, tgt);
      if (src.hasLow()) tgt.setLow(SimpleQuantity10_30.convertSimpleQuantity(src.getLow()));
      if (src.hasHigh()) tgt.setHigh(SimpleQuantity10_30.convertSimpleQuantity(src.getHigh()));
      return tgt;
    }
}
