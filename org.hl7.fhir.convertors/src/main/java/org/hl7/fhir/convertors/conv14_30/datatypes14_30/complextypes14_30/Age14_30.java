package org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30;

import org.hl7.fhir.convertors.context.ConversionContext14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Code14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Decimal14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.String14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Uri14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Age14_30 {
  public static org.hl7.fhir.dstu3.model.Age convertAge(org.hl7.fhir.dstu2016may.model.Age src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Age tgt = new org.hl7.fhir.dstu3.model.Age();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal14_30.convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparatorElement(Quantity14_30.convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnitElement(String14_30.convertString(src.getUnitElement()));
    if (src.hasSystem()) tgt.setSystemElement(Uri14_30.convertUri(src.getSystemElement()));
    if (src.hasCode()) tgt.setCodeElement(Code14_30.convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Age convertAge(org.hl7.fhir.dstu3.model.Age src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Age tgt = new org.hl7.fhir.dstu2016may.model.Age();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal14_30.convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparatorElement(Quantity14_30.convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnitElement(String14_30.convertString(src.getUnitElement()));
    if (src.hasSystem()) tgt.setSystemElement(Uri14_30.convertUri(src.getSystemElement()));
    if (src.hasCode()) tgt.setCodeElement(Code14_30.convertCode(src.getCodeElement()));
    return tgt;
  }
}
