package org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40;

import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Range10_40 {
  public static org.hl7.fhir.r4.model.Range convertRange(org.hl7.fhir.dstu2.model.Range src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Range tgt = new org.hl7.fhir.r4.model.Range();
    Element10_40.copyElement(src, tgt);
    if (src.hasLow()) tgt.setLow(SimpleQuantity10_40.convertSimpleQuantity(src.getLow()));
    if (src.hasHigh()) tgt.setHigh(SimpleQuantity10_40.convertSimpleQuantity(src.getHigh()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Range convertRange(org.hl7.fhir.r4.model.Range src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Range tgt = new org.hl7.fhir.dstu2.model.Range();
    Element10_40.copyElement(src, tgt);
    if (src.hasLow()) tgt.setLow(SimpleQuantity10_40.convertSimpleQuantity(src.getLow()));
    if (src.hasHigh()) tgt.setHigh(SimpleQuantity10_40.convertSimpleQuantity(src.getHigh()));
    return tgt;
  }
}
