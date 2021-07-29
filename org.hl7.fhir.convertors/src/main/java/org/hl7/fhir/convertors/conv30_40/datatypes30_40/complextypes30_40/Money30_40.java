package org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40;

import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Code30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Decimal30_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext30_40;

public class Money30_40 {
    public static org.hl7.fhir.r4.model.Money convertMoney(org.hl7.fhir.dstu3.model.Money src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r4.model.Money tgt = new org.hl7.fhir.r4.model.Money();
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      if (src.hasValue()) tgt.setValueElement(Decimal30_40.convertDecimal(src.getValueElement()));
      if (src.hasCode()) tgt.setCurrencyElement(Code30_40.convertCode(src.getCodeElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Money convertMoney(org.hl7.fhir.r4.model.Money src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.Money tgt = new org.hl7.fhir.dstu3.model.Money();
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      if (src.hasValue()) tgt.setValueElement(Decimal30_40.convertDecimal(src.getValueElement()));
      if (src.hasCurrency()) tgt.setCodeElement(Code30_40.convertCode(src.getCurrencyElement()));
      return tgt;
    }
}
