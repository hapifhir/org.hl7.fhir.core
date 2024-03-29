package org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Ratio10_50 {
  public static org.hl7.fhir.r5.model.Ratio convertRatio(org.hl7.fhir.dstu2.model.Ratio src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Ratio tgt = new org.hl7.fhir.r5.model.Ratio();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasNumerator()) tgt.setNumerator(Quantity10_50.convertQuantity(src.getNumerator()));
    if (src.hasDenominator()) tgt.setDenominator(Quantity10_50.convertQuantity(src.getDenominator()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Ratio convertRatio(org.hl7.fhir.r5.model.Ratio src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Ratio tgt = new org.hl7.fhir.dstu2.model.Ratio();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasNumerator()) tgt.setNumerator(Quantity10_50.convertQuantity(src.getNumerator()));
    if (src.hasDenominator()) tgt.setDenominator(Quantity10_50.convertQuantity(src.getDenominator()));
    return tgt;
  }
}
