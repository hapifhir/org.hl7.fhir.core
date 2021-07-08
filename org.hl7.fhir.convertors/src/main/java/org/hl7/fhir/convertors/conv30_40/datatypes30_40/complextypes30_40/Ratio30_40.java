package org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40;

import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Ratio30_40 {
    public static org.hl7.fhir.r4.model.Ratio convertRatio(org.hl7.fhir.dstu3.model.Ratio src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r4.model.Ratio tgt = new org.hl7.fhir.r4.model.Ratio();
      Element30_40.copyElement(src, tgt);
      if (src.hasNumerator()) tgt.setNumerator(Quantity30_40.convertQuantity(src.getNumerator()));
      if (src.hasDenominator()) tgt.setDenominator(Quantity30_40.convertQuantity(src.getDenominator()));
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Ratio convertRatio(org.hl7.fhir.r4.model.Ratio src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.Ratio tgt = new org.hl7.fhir.dstu3.model.Ratio();
      Element30_40.copyElement(src, tgt);
      if (src.hasNumerator()) tgt.setNumerator(Quantity30_40.convertQuantity(src.getNumerator()));
      if (src.hasDenominator()) tgt.setDenominator(Quantity30_40.convertQuantity(src.getDenominator()));
      return tgt;
    }
}
