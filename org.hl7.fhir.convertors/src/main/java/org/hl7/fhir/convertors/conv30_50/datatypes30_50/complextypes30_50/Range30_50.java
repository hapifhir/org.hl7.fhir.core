package org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50;

import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Element30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Range30_50 {
    public static org.hl7.fhir.r5.model.Range convertRange(org.hl7.fhir.dstu3.model.Range src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r5.model.Range tgt = new org.hl7.fhir.r5.model.Range();
      Element30_50.copyElement(src, tgt);
      if (src.hasLow()) tgt.setLow(SimpleQuantity30_50.convertSimpleQuantity(src.getLow()));
      if (src.hasHigh()) tgt.setHigh(SimpleQuantity30_50.convertSimpleQuantity(src.getHigh()));
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Range convertRange(org.hl7.fhir.r5.model.Range src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.Range tgt = new org.hl7.fhir.dstu3.model.Range();
      Element30_50.copyElement(src, tgt);
      if (src.hasLow()) tgt.setLow(SimpleQuantity30_50.convertSimpleQuantity(src.getLow()));
      if (src.hasHigh()) tgt.setHigh(SimpleQuantity30_50.convertSimpleQuantity(src.getHigh()));
      return tgt;
    }
}
