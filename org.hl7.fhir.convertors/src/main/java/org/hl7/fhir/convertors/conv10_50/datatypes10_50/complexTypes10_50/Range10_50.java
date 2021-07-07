package org.hl7.fhir.convertors.conv10_50.datatypes10_50.complexTypes10_50;

import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Element10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Range10_50 {
    public static org.hl7.fhir.r5.model.Range convertRange(org.hl7.fhir.dstu2.model.Range src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.Range tgt = new org.hl7.fhir.r5.model.Range();
      Element10_50.copyElement(src, tgt);
      if (src.hasLow()) tgt.setLow(SimpleQuantity10_50.convertSimpleQuantity(src.getLow()));
      if (src.hasHigh()) tgt.setHigh(SimpleQuantity10_50.convertSimpleQuantity(src.getHigh()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Range convertRange(org.hl7.fhir.r5.model.Range src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Range tgt = new org.hl7.fhir.dstu2.model.Range();
      Element10_50.copyElement(src, tgt);
      if (src.hasLow()) tgt.setLow(SimpleQuantity10_50.convertSimpleQuantity(src.getLow()));
      if (src.hasHigh()) tgt.setHigh(SimpleQuantity10_50.convertSimpleQuantity(src.getHigh()));
      return tgt;
    }
}
