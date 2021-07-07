package org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30;

import org.hl7.fhir.convertors.conv14_30.datatypes14_30.Element14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Code14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Decimal14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.String14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Uri14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Distance14_30 {
    public static org.hl7.fhir.dstu3.model.Distance convertDistance(org.hl7.fhir.dstu2016may.model.Distance src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu3.model.Distance tgt = new org.hl7.fhir.dstu3.model.Distance();
      Element14_30.copyElement(src, tgt);
      if (src.hasValue()) tgt.setValueElement(Decimal14_30.convertDecimal(src.getValueElement()));
      if (src.hasComparator()) tgt.setComparatorElement(Quantity14_30.convertQuantityComparator(src.getComparatorElement()));
      if (src.hasUnit()) tgt.setUnitElement(String14_30.convertString(src.getUnitElement()));
      if (src.hasSystem()) tgt.setSystemElement(Uri14_30.convertUri(src.getSystemElement()));
      if (src.hasCode()) tgt.setCodeElement(Code14_30.convertCode(src.getCodeElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Distance convertDistance(org.hl7.fhir.dstu3.model.Distance src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Distance tgt = new org.hl7.fhir.dstu2016may.model.Distance();
      Element14_30.copyElement(src, tgt);
      if (src.hasValue()) tgt.setValueElement(Decimal14_30.convertDecimal(src.getValueElement()));
      if (src.hasComparator()) tgt.setComparatorElement(Quantity14_30.convertQuantityComparator(src.getComparatorElement()));
      if (src.hasUnit()) tgt.setUnitElement(String14_30.convertString(src.getUnitElement()));
      if (src.hasSystem()) tgt.setSystemElement(Uri14_30.convertUri(src.getSystemElement()));
      if (src.hasCode()) tgt.setCodeElement(Code14_30.convertCode(src.getCodeElement()));
      return tgt;
    }
}
