package org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50;

import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Element30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Code30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Decimal30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Uri30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class SimpleQuantity30_50 {
    public static org.hl7.fhir.r5.model.Quantity convertSimpleQuantity(org.hl7.fhir.dstu3.model.SimpleQuantity src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r5.model.SimpleQuantity tgt = new org.hl7.fhir.r5.model.SimpleQuantity();
      Element30_50.copyElement(src, tgt);
      if (src.hasValue()) tgt.setValueElement(Decimal30_50.convertDecimal(src.getValueElement()));
      if (src.hasComparator()) tgt.setComparatorElement(Quantity30_50.convertQuantityComparator(src.getComparatorElement()));
      if (src.hasUnit()) tgt.setUnitElement(String30_50.convertString(src.getUnitElement()));
      if (src.hasSystem()) tgt.setSystemElement(Uri30_50.convertUri(src.getSystemElement()));
      if (src.hasCode()) tgt.setCodeElement(Code30_50.convertCode(src.getCodeElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.SimpleQuantity convertSimpleQuantity(org.hl7.fhir.r5.model.Quantity src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.SimpleQuantity tgt = new org.hl7.fhir.dstu3.model.SimpleQuantity();
      Element30_50.copyElement(src, tgt);
      if (src.hasValue()) tgt.setValueElement(Decimal30_50.convertDecimal(src.getValueElement()));
      if (src.hasComparator()) tgt.setComparatorElement(Quantity30_50.convertQuantityComparator(src.getComparatorElement()));
      if (src.hasUnit()) tgt.setUnitElement(String30_50.convertString(src.getUnitElement()));
      if (src.hasSystem()) tgt.setSystemElement(Uri30_50.convertUri(src.getSystemElement()));
      if (src.hasCode()) tgt.setCodeElement(Code30_50.convertCode(src.getCodeElement()));
      return tgt;
    }
}
