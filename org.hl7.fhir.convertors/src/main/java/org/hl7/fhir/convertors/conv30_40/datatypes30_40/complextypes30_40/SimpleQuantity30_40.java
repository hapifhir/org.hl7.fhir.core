package org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40;

import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Code30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Decimal30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Uri30_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext30_40;

public class SimpleQuantity30_40 {
  public static org.hl7.fhir.r4.model.Quantity convertSimpleQuantity(org.hl7.fhir.dstu3.model.SimpleQuantity src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.SimpleQuantity tgt = new org.hl7.fhir.r4.model.SimpleQuantity();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal30_40.convertDecimal(src.getValueElement()));
    if (src.hasComparator()) tgt.setComparatorElement(Quantity30_40.convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnitElement(String30_40.convertString(src.getUnitElement()));
    if (src.hasSystem()) tgt.setSystemElement(Uri30_40.convertUri(src.getSystemElement()));
    if (src.hasCode()) tgt.setCodeElement(Code30_40.convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.SimpleQuantity convertSimpleQuantity(org.hl7.fhir.r4.model.Quantity src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.SimpleQuantity tgt = new org.hl7.fhir.dstu3.model.SimpleQuantity();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal30_40.convertDecimal(src.getValueElement()));
    if (src.hasComparator()) tgt.setComparatorElement(Quantity30_40.convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnitElement(String30_40.convertString(src.getUnitElement()));
    if (src.hasSystem()) tgt.setSystemElement(Uri30_40.convertUri(src.getSystemElement()));
    if (src.hasCode()) tgt.setCodeElement(Code30_40.convertCode(src.getCodeElement()));
    return tgt;
  }
}
