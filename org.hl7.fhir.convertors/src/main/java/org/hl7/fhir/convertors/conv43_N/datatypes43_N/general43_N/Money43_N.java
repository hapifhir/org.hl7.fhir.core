package org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Code43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Decimal43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Money43_N {
  public static org.hl7.fhir.model.core.Money convertMoney(org.hl7.fhir.r4b.model.Money src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Money tgt = new org.hl7.fhir.model.core.Money();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal43_N.convertDecimal(src.getValueElement()));
    if (src.hasCurrency()) tgt.setCurrencyElement(Code43_N.convertCode(src.getCurrencyElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Money convertMoney(org.hl7.fhir.model.core.Money src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Money tgt = new org.hl7.fhir.r4b.model.Money();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal43_N.convertDecimal(src.getValueElement()));
    if (src.hasCurrency()) tgt.setCurrencyElement(Code43_N.convertCode(src.getCurrencyElement()));
    return tgt;
  }
}
