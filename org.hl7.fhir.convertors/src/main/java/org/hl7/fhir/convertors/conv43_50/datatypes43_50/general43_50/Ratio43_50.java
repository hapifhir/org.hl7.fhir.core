package org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Ratio43_50 {
  public static org.hl7.fhir.r5.model.Ratio convertRatio(org.hl7.fhir.r4b.model.Ratio src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Ratio tgt = new org.hl7.fhir.r5.model.Ratio();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasNumerator()) tgt.setNumerator(Quantity43_50.convertQuantity(src.getNumerator()));
    if (src.hasDenominator()) tgt.setDenominator(Quantity43_50.convertQuantity(src.getDenominator()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Ratio convertRatio(org.hl7.fhir.r5.model.Ratio src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Ratio tgt = new org.hl7.fhir.r4b.model.Ratio();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasNumerator()) tgt.setNumerator(Quantity43_50.convertQuantity(src.getNumerator()));
    if (src.hasDenominator()) tgt.setDenominator(Quantity43_50.convertQuantity(src.getDenominator()));
    return tgt;
  }
}
