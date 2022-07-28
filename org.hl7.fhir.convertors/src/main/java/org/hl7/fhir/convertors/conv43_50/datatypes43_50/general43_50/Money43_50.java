package org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Code43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Decimal43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Money43_50 {
  public static org.hl7.fhir.r5.model.Money convertMoney(org.hl7.fhir.r4b.model.Money src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Money tgt = new org.hl7.fhir.r5.model.Money();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal43_50.convertDecimal(src.getValueElement()));
    if (src.hasCurrency()) tgt.setCurrencyElement(Code43_50.convertCode(src.getCurrencyElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Money convertMoney(org.hl7.fhir.r5.model.Money src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Money tgt = new org.hl7.fhir.r4b.model.Money();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal43_50.convertDecimal(src.getValueElement()));
    if (src.hasCurrency()) tgt.setCurrencyElement(Code43_50.convertCode(src.getCurrencyElement()));
    return tgt;
  }
}
