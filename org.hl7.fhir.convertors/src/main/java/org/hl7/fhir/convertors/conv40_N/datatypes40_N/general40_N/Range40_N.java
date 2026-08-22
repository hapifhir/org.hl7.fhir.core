package org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Range40_N {
  public static org.hl7.fhir.model.core.Range convertRange(org.hl7.fhir.r4.model.Range src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Range tgt = new org.hl7.fhir.model.core.Range();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasLow()) tgt.setLow(SimpleQuantity40_N.convertSimpleQuantity(src.getLow()));
    if (src.hasHigh()) tgt.setHigh(SimpleQuantity40_N.convertSimpleQuantity(src.getHigh()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Range convertRange(org.hl7.fhir.model.core.Range src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Range tgt = new org.hl7.fhir.r4.model.Range();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasLow()) tgt.setLow(SimpleQuantity40_N.convertSimpleQuantity(src.getLow()));
    if (src.hasHigh()) tgt.setHigh(SimpleQuantity40_N.convertSimpleQuantity(src.getHigh()));
    return tgt;
  }
}
