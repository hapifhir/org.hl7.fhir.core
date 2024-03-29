package org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Code10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Decimal10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Uri10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class SimpleQuantity10_50 {
  public static org.hl7.fhir.r5.model.Quantity convertSimpleQuantity(org.hl7.fhir.dstu2.model.SimpleQuantity src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.SimpleQuantity tgt = new org.hl7.fhir.r5.model.SimpleQuantity();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasValueElement()) tgt.setValueElement(Decimal10_50.convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparatorElement(Quantity10_50.convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnitElement()) tgt.setUnitElement(String10_50.convertString(src.getUnitElement()));
    if (src.hasSystemElement()) tgt.setSystemElement(Uri10_50.convertUri(src.getSystemElement()));
    if (src.hasCodeElement()) tgt.setCodeElement(Code10_50.convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.SimpleQuantity convertSimpleQuantity(org.hl7.fhir.r5.model.Quantity src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.SimpleQuantity tgt = new org.hl7.fhir.dstu2.model.SimpleQuantity();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasValueElement()) tgt.setValueElement(Decimal10_50.convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparatorElement(Quantity10_50.convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnitElement()) tgt.setUnitElement(String10_50.convertString(src.getUnitElement()));
    if (src.hasSystemElement()) tgt.setSystemElement(Uri10_50.convertUri(src.getSystemElement()));
    if (src.hasCodeElement()) tgt.setCodeElement(Code10_50.convertCode(src.getCodeElement()));
    return tgt;
  }
}
