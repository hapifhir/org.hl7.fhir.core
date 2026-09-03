package org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Range43_N {
  public static org.hl7.fhir.model.core.Range convertRange(org.hl7.fhir.r4b.model.Range src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Range tgt = new org.hl7.fhir.model.core.Range();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasLow()) tgt.setLow(SimpleQuantity43_N.convertSimpleQuantity(src.getLow()));
    if (src.hasHigh()) tgt.setHigh(SimpleQuantity43_N.convertSimpleQuantity(src.getHigh()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Range convertRange(org.hl7.fhir.model.core.Range src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Range tgt = new org.hl7.fhir.r4b.model.Range();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasLow()) tgt.setLow(SimpleQuantity43_N.convertSimpleQuantity(src.getLow()));
    if (src.hasHigh()) tgt.setHigh(SimpleQuantity43_N.convertSimpleQuantity(src.getHigh()));
    return tgt;
  }
}
