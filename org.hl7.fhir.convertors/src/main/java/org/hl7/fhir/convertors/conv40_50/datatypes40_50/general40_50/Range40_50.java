package org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50;

import org.hl7.fhir.convertors.VersionConvertor_40_50_Context;
import org.hl7.fhir.exceptions.FHIRException;

public class Range40_50 {
  public static org.hl7.fhir.r5.model.Range convertRange(org.hl7.fhir.r4.model.Range src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Range tgt = new org.hl7.fhir.r5.model.Range();
    VersionConvertor_40_50_Context.INSTANCE.getVersionConvertor_40_50_a().copyElement(src, tgt);
    if (src.hasLow()) tgt.setLow(SimpleQuantity40_50.convertSimpleQuantity(src.getLow()));
    if (src.hasHigh()) tgt.setHigh(SimpleQuantity40_50.convertSimpleQuantity(src.getHigh()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Range convertRange(org.hl7.fhir.r5.model.Range src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Range tgt = new org.hl7.fhir.r4.model.Range();
    VersionConvertor_40_50_Context.INSTANCE.getVersionConvertor_40_50_a().copyElement(src, tgt);
    if (src.hasLow()) tgt.setLow(SimpleQuantity40_50.convertSimpleQuantity(src.getLow()));
    if (src.hasHigh()) tgt.setHigh(SimpleQuantity40_50.convertSimpleQuantity(src.getHigh()));
    return tgt;
  }
}
