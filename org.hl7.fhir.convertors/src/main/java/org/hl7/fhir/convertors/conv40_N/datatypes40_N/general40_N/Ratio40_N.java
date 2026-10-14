package org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Ratio40_N {
  public static org.hl7.fhir.model.core.Ratio convertRatio(org.hl7.fhir.r4.model.Ratio src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Ratio tgt = new org.hl7.fhir.model.core.Ratio();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasNumerator()) tgt.setNumerator(Quantity40_N.convertQuantity(src.getNumerator()));
    if (src.hasDenominator()) tgt.setDenominator(Quantity40_N.convertQuantity(src.getDenominator()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Ratio convertRatio(org.hl7.fhir.model.core.Ratio src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Ratio tgt = new org.hl7.fhir.r4.model.Ratio();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasNumerator()) tgt.setNumerator(Quantity40_N.convertQuantity(src.getNumerator()));
    if (src.hasDenominator()) tgt.setDenominator(Quantity40_N.convertQuantity(src.getDenominator()));
    return tgt;
  }
}
