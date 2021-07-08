package org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50;

import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Element14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Code14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Decimal14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.String14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Uri14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class SimpleQuantity14_50 {
    public static org.hl7.fhir.r5.model.Quantity convertSimpleQuantity(org.hl7.fhir.dstu2016may.model.SimpleQuantity src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.SimpleQuantity tgt = new org.hl7.fhir.r5.model.SimpleQuantity();
      Element14_50.copyElement(src, tgt);
      if (src.hasValue()) tgt.setValueElement(Decimal14_50.convertDecimal(src.getValueElement()));
      if (src.hasComparator()) tgt.setComparatorElement(Quantity14_50.convertQuantityComparator(src.getComparatorElement()));
      if (src.hasUnit()) tgt.setUnitElement(String14_50.convertString(src.getUnitElement()));
      if (src.hasSystem()) tgt.setSystemElement(Uri14_50.convertUri(src.getSystemElement()));
      if (src.hasCode()) tgt.setCodeElement(Code14_50.convertCode(src.getCodeElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.SimpleQuantity convertSimpleQuantity(org.hl7.fhir.r5.model.Quantity src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.SimpleQuantity tgt = new org.hl7.fhir.dstu2016may.model.SimpleQuantity();
      Element14_50.copyElement(src, tgt);
      if (src.hasValue()) tgt.setValueElement(Decimal14_50.convertDecimal(src.getValueElement()));
      if (src.hasComparator()) tgt.setComparatorElement(Quantity14_50.convertQuantityComparator(src.getComparatorElement()));
      if (src.hasUnit()) tgt.setUnitElement(String14_50.convertString(src.getUnitElement()));
      if (src.hasSystem()) tgt.setSystemElement(Uri14_50.convertUri(src.getSystemElement()));
      if (src.hasCode()) tgt.setCodeElement(Code14_50.convertCode(src.getCodeElement()));
      return tgt;
    }
}
