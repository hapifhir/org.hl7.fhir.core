package org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50;

import org.hl7.fhir.convertors.context.ConversionContext14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Range14_50 {
  public static org.hl7.fhir.r5.model.Range convertRange(org.hl7.fhir.dstu2016may.model.Range src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Range tgt = new org.hl7.fhir.r5.model.Range();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasLow()) tgt.setLow(SimpleQuantity14_50.convertSimpleQuantity(src.getLow()));
    if (src.hasHigh()) tgt.setHigh(SimpleQuantity14_50.convertSimpleQuantity(src.getHigh()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Range convertRange(org.hl7.fhir.r5.model.Range src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Range tgt = new org.hl7.fhir.dstu2016may.model.Range();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasLow()) tgt.setLow(SimpleQuantity14_50.convertSimpleQuantity(src.getLow()));
    if (src.hasHigh()) tgt.setHigh(SimpleQuantity14_50.convertSimpleQuantity(src.getHigh()));
    return tgt;
  }
}
