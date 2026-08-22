package org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Code40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Decimal40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Money40_N {
  public static org.hl7.fhir.model.core.Money convertMoney(org.hl7.fhir.r4.model.Money src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Money tgt = new org.hl7.fhir.model.core.Money();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal40_N.convertDecimal(src.getValueElement()));
    if (src.hasCurrency()) tgt.setCurrencyElement(Code40_N.convertCode(src.getCurrencyElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Money convertMoney(org.hl7.fhir.model.core.Money src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Money tgt = new org.hl7.fhir.r4.model.Money();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal40_N.convertDecimal(src.getValueElement()));
    if (src.hasCurrency()) tgt.setCurrencyElement(Code40_N.convertCode(src.getCurrencyElement()));
    return tgt;
  }
}
