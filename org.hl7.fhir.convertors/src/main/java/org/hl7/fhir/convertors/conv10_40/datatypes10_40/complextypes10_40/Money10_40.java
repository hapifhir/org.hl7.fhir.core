package org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40;

import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Code10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Decimal10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Money10_40 {
  public static org.hl7.fhir.r4.model.Money convertMoney(org.hl7.fhir.dstu2.model.Money src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Money tgt = new org.hl7.fhir.r4.model.Money();
    Element10_40.copyElement(src, tgt);
    if (src.hasValueElement()) tgt.setValueElement(Decimal10_40.convertDecimal(src.getValueElement()));
    if (src.hasCodeElement()) tgt.setCurrencyElement(Code10_40.convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Money convertMoney(org.hl7.fhir.r4.model.Money src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Money tgt = new org.hl7.fhir.dstu2.model.Money();
    Element10_40.copyElement(src, tgt);
    if (src.hasValueElement()) tgt.setValueElement(Decimal10_40.convertDecimal(src.getValueElement()));
    if (src.hasCurrencyElement()) tgt.setCodeElement(Code10_40.convertCode(src.getCurrencyElement()));
    return tgt;
  }
}
