package org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50;

import org.hl7.fhir.convertors.context.ConversionContext14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Code14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Decimal14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Money14_50 {
  public static org.hl7.fhir.r5.model.Money convertMoney(org.hl7.fhir.dstu2016may.model.Money src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Money tgt = new org.hl7.fhir.r5.model.Money();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal14_50.convertDecimal(src.getValueElement()));
    if (src.hasCode()) tgt.setCurrencyElement(Code14_50.convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Money convertMoney(org.hl7.fhir.r5.model.Money src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Money tgt = new org.hl7.fhir.dstu2016may.model.Money();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal14_50.convertDecimal(src.getValueElement()));
    if (src.hasCurrency()) tgt.setCodeElement(Code14_50.convertCode(src.getCurrencyElement()));
    return tgt;
  }
}
