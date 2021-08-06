package org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Ratio40_50 {
  public static org.hl7.fhir.r5.model.Ratio convertRatio(org.hl7.fhir.r4.model.Ratio src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Ratio tgt = new org.hl7.fhir.r5.model.Ratio();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasNumerator()) tgt.setNumerator(Quantity40_50.convertQuantity(src.getNumerator()));
    if (src.hasDenominator()) tgt.setDenominator(Quantity40_50.convertQuantity(src.getDenominator()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Ratio convertRatio(org.hl7.fhir.r5.model.Ratio src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Ratio tgt = new org.hl7.fhir.r4.model.Ratio();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasNumerator()) tgt.setNumerator(Quantity40_50.convertQuantity(src.getNumerator()));
    if (src.hasDenominator()) tgt.setDenominator(Quantity40_50.convertQuantity(src.getDenominator()));
    return tgt;
  }
}
