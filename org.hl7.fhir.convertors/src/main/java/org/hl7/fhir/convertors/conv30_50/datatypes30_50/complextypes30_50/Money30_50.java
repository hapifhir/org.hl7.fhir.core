package org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Code30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Decimal30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Money30_50 {
  public static org.hl7.fhir.r5.model.Money convertMoney(org.hl7.fhir.dstu3.model.Money src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Money tgt = new org.hl7.fhir.r5.model.Money();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal30_50.convertDecimal(src.getValueElement()));
    if (src.hasCode()) tgt.setCurrencyElement(Code30_50.convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Money convertMoney(org.hl7.fhir.r5.model.Money src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.Money tgt = new org.hl7.fhir.dstu3.model.Money();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal30_50.convertDecimal(src.getValueElement()));
    if (src.hasCurrency()) tgt.setCodeElement(Code30_50.convertCode(src.getCurrencyElement()));
    return tgt;
  }
}
