package org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40;

import org.hl7.fhir.convertors.context.ConversionContext14_40;
import org.hl7.fhir.exceptions.FHIRException;  import org.hl7.fhir.convertors.context.ConversionContext14_40;

public class Ratio14_40 {
    public static org.hl7.fhir.r4.model.Ratio convertRatio(org.hl7.fhir.dstu2016may.model.Ratio src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Ratio tgt = new org.hl7.fhir.r4.model.Ratio();
      ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
      if (src.hasNumerator()) tgt.setNumerator(Quantity14_40.convertQuantity(src.getNumerator()));
      if (src.hasDenominator()) tgt.setDenominator(Quantity14_40.convertQuantity(src.getDenominator()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Ratio convertRatio(org.hl7.fhir.r4.model.Ratio src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Ratio tgt = new org.hl7.fhir.dstu2016may.model.Ratio();
      ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
      if (src.hasNumerator()) tgt.setNumerator(Quantity14_40.convertQuantity(src.getNumerator()));
      if (src.hasDenominator()) tgt.setDenominator(Quantity14_40.convertQuantity(src.getDenominator()));
      return tgt;
    }
}
