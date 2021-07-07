package org.hl7.fhir.convertors.conv10_50.datatypes10_50.complexTypes10_50;

import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Element10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Code10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Decimal10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Money10_50 {
    public static org.hl7.fhir.r5.model.Money convertMoney(org.hl7.fhir.dstu2.model.Money src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.Money tgt = new org.hl7.fhir.r5.model.Money();
      Element10_50.copyElement(src, tgt);
      if (src.hasValueElement()) tgt.setValueElement(Decimal10_50.convertDecimal(src.getValueElement()));
      if (src.hasCodeElement()) tgt.setCurrencyElement(Code10_50.convertCode(src.getCodeElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Money convertMoney(org.hl7.fhir.r5.model.Money src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Money tgt = new org.hl7.fhir.dstu2.model.Money();
      Element10_50.copyElement(src, tgt);
      if (src.hasValueElement()) tgt.setValueElement(Decimal10_50.convertDecimal(src.getValueElement()));
      if (src.hasCurrencyElement()) tgt.setCodeElement(Code10_50.convertCode(src.getCurrencyElement()));
      return tgt;
    }
}
