package org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30;

import org.hl7.fhir.convertors.conv14_30.datatypes14_30.Element14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Ratio14_30 {
    public static org.hl7.fhir.dstu3.model.Ratio convertRatio(org.hl7.fhir.dstu2016may.model.Ratio src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu3.model.Ratio tgt = new org.hl7.fhir.dstu3.model.Ratio();
      Element14_30.copyElement(src, tgt);
      if (src.hasNumerator()) tgt.setNumerator(Quantity14_30.convertQuantity(src.getNumerator()));
      if (src.hasDenominator()) tgt.setDenominator(Quantity14_30.convertQuantity(src.getDenominator()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Ratio convertRatio(org.hl7.fhir.dstu3.model.Ratio src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Ratio tgt = new org.hl7.fhir.dstu2016may.model.Ratio();
      Element14_30.copyElement(src, tgt);
      if (src.hasNumerator()) tgt.setNumerator(Quantity14_30.convertQuantity(src.getNumerator()));
      if (src.hasDenominator()) tgt.setDenominator(Quantity14_30.convertQuantity(src.getDenominator()));
      return tgt;
    }
}
