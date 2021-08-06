package org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40;

import org.hl7.fhir.convertors.context.ConversionContext14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Range14_40 {
  public static org.hl7.fhir.r4.model.Range convertRange(org.hl7.fhir.dstu2016may.model.Range src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Range tgt = new org.hl7.fhir.r4.model.Range();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    if (src.hasLow()) tgt.setLow(SimpleQuantity14_40.convertSimpleQuantity(src.getLow()));
    if (src.hasHigh()) tgt.setHigh(SimpleQuantity14_40.convertSimpleQuantity(src.getHigh()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Range convertRange(org.hl7.fhir.r4.model.Range src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Range tgt = new org.hl7.fhir.dstu2016may.model.Range();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    if (src.hasLow()) tgt.setLow(SimpleQuantity14_40.convertSimpleQuantity(src.getLow()));
    if (src.hasHigh()) tgt.setHigh(SimpleQuantity14_40.convertSimpleQuantity(src.getHigh()));
    return tgt;
  }
}
