package org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30;

import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Ratio10_30 {
  public static org.hl7.fhir.dstu3.model.Ratio convertRatio(org.hl7.fhir.dstu2.model.Ratio src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Ratio tgt = new org.hl7.fhir.dstu3.model.Ratio();
    Element10_30.copyElement(src, tgt);
    if (src.hasNumerator()) tgt.setNumerator(Quantity10_30.convertQuantity(src.getNumerator()));
    if (src.hasDenominator()) tgt.setDenominator(Quantity10_30.convertQuantity(src.getDenominator()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Ratio convertRatio(org.hl7.fhir.dstu3.model.Ratio src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Ratio tgt = new org.hl7.fhir.dstu2.model.Ratio();
    Element10_30.copyElement(src, tgt);
    if (src.hasNumerator()) tgt.setNumerator(Quantity10_30.convertQuantity(src.getNumerator()));
    if (src.hasDenominator()) tgt.setDenominator(Quantity10_30.convertQuantity(src.getDenominator()));
    return tgt;
  }
}
