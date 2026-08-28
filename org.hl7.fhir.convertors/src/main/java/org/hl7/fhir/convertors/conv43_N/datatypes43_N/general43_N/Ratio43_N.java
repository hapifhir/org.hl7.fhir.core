package org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Ratio43_N {
  public static org.hl7.fhir.model.core.Ratio convertRatio(org.hl7.fhir.r4b.model.Ratio src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Ratio tgt = new org.hl7.fhir.model.core.Ratio();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasNumerator()) tgt.setNumerator(Quantity43_N.convertQuantity(src.getNumerator()));
    if (src.hasDenominator()) tgt.setDenominator(Quantity43_N.convertQuantity(src.getDenominator()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Ratio convertRatio(org.hl7.fhir.model.core.Ratio src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Ratio tgt = new org.hl7.fhir.r4b.model.Ratio();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasNumerator()) tgt.setNumerator(Quantity43_N.convertQuantity(src.getNumerator()));
    if (src.hasDenominator()) tgt.setDenominator(Quantity43_N.convertQuantity(src.getDenominator()));
    return tgt;
  }
}
