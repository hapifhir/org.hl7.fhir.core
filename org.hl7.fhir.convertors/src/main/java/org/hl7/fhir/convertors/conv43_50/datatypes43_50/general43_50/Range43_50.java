package org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Range43_50 {
  public static org.hl7.fhir.r5.model.Range convertRange(org.hl7.fhir.r4b.model.Range src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Range tgt = new org.hl7.fhir.r5.model.Range();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasLow()) tgt.setLow(SimpleQuantity43_50.convertSimpleQuantity(src.getLow()));
    if (src.hasHigh()) tgt.setHigh(SimpleQuantity43_50.convertSimpleQuantity(src.getHigh()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Range convertRange(org.hl7.fhir.r5.model.Range src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Range tgt = new org.hl7.fhir.r4b.model.Range();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasLow()) tgt.setLow(SimpleQuantity43_50.convertSimpleQuantity(src.getLow()));
    if (src.hasHigh()) tgt.setHigh(SimpleQuantity43_50.convertSimpleQuantity(src.getHigh()));
    return tgt;
  }
}
