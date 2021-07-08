package org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30;

import org.hl7.fhir.convertors.conv14_30.datatypes14_30.Element14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Range14_30 {
    public static org.hl7.fhir.dstu3.model.Range convertRange(org.hl7.fhir.dstu2016may.model.Range src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu3.model.Range tgt = new org.hl7.fhir.dstu3.model.Range();
      Element14_30.copyElement(src, tgt);
      if (src.hasLow()) tgt.setLow(SimpleQuantity14_30.convertSimpleQuantity(src.getLow()));
      if (src.hasHigh()) tgt.setHigh(SimpleQuantity14_30.convertSimpleQuantity(src.getHigh()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Range convertRange(org.hl7.fhir.dstu3.model.Range src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Range tgt = new org.hl7.fhir.dstu2016may.model.Range();
      Element14_30.copyElement(src, tgt);
      if (src.hasLow()) tgt.setLow(SimpleQuantity14_30.convertSimpleQuantity(src.getLow()));
      if (src.hasHigh()) tgt.setHigh(SimpleQuantity14_30.convertSimpleQuantity(src.getHigh()));
      return tgt;
    }
}
