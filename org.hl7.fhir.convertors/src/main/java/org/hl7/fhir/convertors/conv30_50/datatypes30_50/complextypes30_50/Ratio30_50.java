package org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50;

import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Element30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Ratio30_50 {
    public static org.hl7.fhir.r5.model.Ratio convertRatio(org.hl7.fhir.dstu3.model.Ratio src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r5.model.Ratio tgt = new org.hl7.fhir.r5.model.Ratio();
      Element30_50.copyElement(src, tgt);
      if (src.hasNumerator()) tgt.setNumerator(Quantity30_50.convertQuantity(src.getNumerator()));
      if (src.hasDenominator()) tgt.setDenominator(Quantity30_50.convertQuantity(src.getDenominator()));
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Ratio convertRatio(org.hl7.fhir.r5.model.Ratio src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.Ratio tgt = new org.hl7.fhir.dstu3.model.Ratio();
      Element30_50.copyElement(src, tgt);
      if (src.hasNumerator()) tgt.setNumerator(Quantity30_50.convertQuantity(src.getNumerator()));
      if (src.hasDenominator()) tgt.setDenominator(Quantity30_50.convertQuantity(src.getDenominator()));
      return tgt;
    }
}
