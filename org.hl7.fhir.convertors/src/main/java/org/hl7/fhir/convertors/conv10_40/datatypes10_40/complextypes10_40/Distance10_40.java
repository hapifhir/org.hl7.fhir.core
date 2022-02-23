package org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40;

import org.hl7.fhir.convertors.context.ConversionContext10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Code10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Decimal10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Uri10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Distance10_40 {
  public static org.hl7.fhir.r4.model.Distance convertDistance(org.hl7.fhir.dstu2.model.Distance src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Distance tgt = new org.hl7.fhir.r4.model.Distance();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasValueElement()) tgt.setValueElement(Decimal10_40.convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparatorElement(Quantity10_40.convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnitElement()) tgt.setUnitElement(String10_40.convertString(src.getUnitElement()));
    if (src.hasSystemElement()) tgt.setSystemElement(Uri10_40.convertUri(src.getSystemElement()));
    if (src.hasCodeElement()) tgt.setCodeElement(Code10_40.convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Distance convertDistance(org.hl7.fhir.r4.model.Distance src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Distance tgt = new org.hl7.fhir.dstu2.model.Distance();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasValueElement()) tgt.setValueElement(Decimal10_40.convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparatorElement(Quantity10_40.convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnitElement()) tgt.setUnitElement(String10_40.convertString(src.getUnitElement()));
    if (src.hasSystemElement()) tgt.setSystemElement(Uri10_40.convertUri(src.getSystemElement()));
    if (src.hasCodeElement()) tgt.setCodeElement(Code10_40.convertCode(src.getCodeElement()));
    return tgt;
  }
}
