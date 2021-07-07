package org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40;

import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Element14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Code14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Decimal14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Money14_40 {
    public static org.hl7.fhir.r4.model.Money convertMoney(org.hl7.fhir.dstu2016may.model.Money src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Money tgt = new org.hl7.fhir.r4.model.Money();
      Element14_40.copyElement(src, tgt);
      if (src.hasValue()) tgt.setValueElement(Decimal14_40.convertDecimal(src.getValueElement()));
      if (src.hasCode()) tgt.setCurrencyElement(Code14_40.convertCode(src.getCodeElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Money convertMoney(org.hl7.fhir.r4.model.Money src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Money tgt = new org.hl7.fhir.dstu2016may.model.Money();
      Element14_40.copyElement(src, tgt);
      if (src.hasValue()) tgt.setValueElement(Decimal14_40.convertDecimal(src.getValueElement()));
      if (src.hasCurrency()) tgt.setCodeElement(Code14_40.convertCode(src.getCurrencyElement()));
      return tgt;
    }
}
