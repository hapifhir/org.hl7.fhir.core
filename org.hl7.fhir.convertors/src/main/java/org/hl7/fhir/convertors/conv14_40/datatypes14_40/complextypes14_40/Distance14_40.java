package org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40;

import org.hl7.fhir.convertors.context.ConversionContext14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Code14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Decimal14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.String14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Uri14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Distance14_40 {
  public static org.hl7.fhir.r4.model.Distance convertDistance(org.hl7.fhir.dstu2016may.model.Distance src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Distance tgt = new org.hl7.fhir.r4.model.Distance();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal14_40.convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparatorElement(Quantity14_40.convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnitElement(String14_40.convertString(src.getUnitElement()));
    if (src.hasSystem()) tgt.setSystemElement(Uri14_40.convertUri(src.getSystemElement()));
    if (src.hasCode()) tgt.setCodeElement(Code14_40.convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Distance convertDistance(org.hl7.fhir.r4.model.Distance src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Distance tgt = new org.hl7.fhir.dstu2016may.model.Distance();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal14_40.convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparatorElement(Quantity14_40.convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnitElement(String14_40.convertString(src.getUnitElement()));
    if (src.hasSystem()) tgt.setSystemElement(Uri14_40.convertUri(src.getSystemElement()));
    if (src.hasCode()) tgt.setCodeElement(Code14_40.convertCode(src.getCodeElement()));
    return tgt;
  }
}
