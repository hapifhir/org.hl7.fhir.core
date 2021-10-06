package org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Code40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Decimal40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Money40_50 {
  public static org.hl7.fhir.r5.model.Money convertMoney(org.hl7.fhir.r4.model.Money src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Money tgt = new org.hl7.fhir.r5.model.Money();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal40_50.convertDecimal(src.getValueElement()));
    if (src.hasCurrency()) tgt.setCurrencyElement(Code40_50.convertCode(src.getCurrencyElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Money convertMoney(org.hl7.fhir.r5.model.Money src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Money tgt = new org.hl7.fhir.r4.model.Money();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal40_50.convertDecimal(src.getValueElement()));
    if (src.hasCurrency()) tgt.setCurrencyElement(Code40_50.convertCode(src.getCurrencyElement()));
    return tgt;
  }
}
