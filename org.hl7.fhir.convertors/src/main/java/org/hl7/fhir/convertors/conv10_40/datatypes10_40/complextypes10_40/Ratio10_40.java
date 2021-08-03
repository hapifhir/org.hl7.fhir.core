package org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40;

import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext10_40;

public class Ratio10_40 {
  public static org.hl7.fhir.r4.model.Ratio convertRatio(org.hl7.fhir.dstu2.model.Ratio src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Ratio tgt = new org.hl7.fhir.r4.model.Ratio();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasNumerator()) tgt.setNumerator(Quantity10_40.convertQuantity(src.getNumerator()));
    if (src.hasDenominator()) tgt.setDenominator(Quantity10_40.convertQuantity(src.getDenominator()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Ratio convertRatio(org.hl7.fhir.r4.model.Ratio src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Ratio tgt = new org.hl7.fhir.dstu2.model.Ratio();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasNumerator()) tgt.setNumerator(Quantity10_40.convertQuantity(src.getNumerator()));
    if (src.hasDenominator()) tgt.setDenominator(Quantity10_40.convertQuantity(src.getDenominator()));
    return tgt;
  }
}
