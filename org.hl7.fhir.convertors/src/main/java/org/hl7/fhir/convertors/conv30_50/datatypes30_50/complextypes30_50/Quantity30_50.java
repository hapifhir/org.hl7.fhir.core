package org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50;

import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Element30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Code30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Decimal30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Uri30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Quantity30_50 {
    public static void copyQuantity(org.hl7.fhir.dstu3.model.Quantity src, org.hl7.fhir.r5.model.Quantity tgt) throws FHIRException {
      if (src == null || tgt == null) return;
      Element30_50.copyElement(src, tgt);
      if (src.hasValue()) tgt.setValue(src.getValue());
      if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
      if (src.hasUnit()) tgt.setUnitElement(String30_50.convertString(src.getUnitElement()));
      if (src.hasSystem()) tgt.setSystemElement(Uri30_50.convertUri(src.getSystemElement()));
      if (src.hasCode()) tgt.setCodeElement(Code30_50.convertCode(src.getCodeElement()));
    }

    public static void copyQuantity(org.hl7.fhir.r5.model.Quantity src, org.hl7.fhir.dstu3.model.Quantity tgt) throws FHIRException {
      if (src == null || tgt == null) return;
      Element30_50.copyElement(src, tgt);
      if (src.hasValue()) tgt.setValue(src.getValue());
      if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
      if (src.hasUnit()) tgt.setUnitElement(String30_50.convertString(src.getUnitElement()));
      if (src.hasSystem()) tgt.setSystemElement(Uri30_50.convertUri(src.getSystemElement()));
      if (src.hasCode()) tgt.setCodeElement(Code30_50.convertCode(src.getCodeElement()));
    }

    public static org.hl7.fhir.r5.model.Quantity convertQuantity(org.hl7.fhir.dstu3.model.Quantity src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r5.model.Quantity tgt = new org.hl7.fhir.r5.model.Quantity();
      Element30_50.copyElement(src, tgt);
      if (src.hasValue()) tgt.setValueElement(Decimal30_50.convertDecimal(src.getValueElement()));
      if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
      if (src.hasUnit()) tgt.setUnitElement(String30_50.convertString(src.getUnitElement()));
      if (src.hasSystem()) tgt.setSystemElement(Uri30_50.convertUri(src.getSystemElement()));
      if (src.hasCode()) tgt.setCodeElement(Code30_50.convertCode(src.getCodeElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Quantity convertQuantity(org.hl7.fhir.r5.model.Quantity src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.Quantity tgt = new org.hl7.fhir.dstu3.model.Quantity();
      Element30_50.copyElement(src, tgt);
      if (src.hasValue()) tgt.setValueElement(Decimal30_50.convertDecimal(src.getValueElement()));
      if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
      if (src.hasUnit()) tgt.setUnitElement(String30_50.convertString(src.getUnitElement()));
      if (src.hasSystem()) tgt.setSystemElement(Uri30_50.convertUri(src.getSystemElement()));
      if (src.hasCode()) tgt.setCodeElement(Code30_50.convertCode(src.getCodeElement()));
      return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> convertQuantityComparator(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Quantity.QuantityComparator> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.QuantityComparatorEnumFactory());
      Element30_50.copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.QuantityComparator.NULL);
      } else {
        switch (src.getValue()) {
          case LESS_THAN:
            tgt.setValue(org.hl7.fhir.r5.model.Enumerations.QuantityComparator.LESS_THAN);
            break;
          case LESS_OR_EQUAL:
            tgt.setValue(org.hl7.fhir.r5.model.Enumerations.QuantityComparator.LESS_OR_EQUAL);
            break;
          case GREATER_OR_EQUAL:
            tgt.setValue(org.hl7.fhir.r5.model.Enumerations.QuantityComparator.GREATER_OR_EQUAL);
            break;
          case GREATER_THAN:
            tgt.setValue(org.hl7.fhir.r5.model.Enumerations.QuantityComparator.GREATER_THAN);
            break;
          default:
            tgt.setValue(org.hl7.fhir.r5.model.Enumerations.QuantityComparator.NULL);
            break;
        }
      }
      return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Quantity.QuantityComparator> convertQuantityComparator(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Quantity.QuantityComparator> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Quantity.QuantityComparatorEnumFactory());
      Element30_50.copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.dstu3.model.Quantity.QuantityComparator.NULL);
      } else {
        switch (src.getValue()) {
          case LESS_THAN:
            tgt.setValue(org.hl7.fhir.dstu3.model.Quantity.QuantityComparator.LESS_THAN);
            break;
          case LESS_OR_EQUAL:
            tgt.setValue(org.hl7.fhir.dstu3.model.Quantity.QuantityComparator.LESS_OR_EQUAL);
            break;
          case GREATER_OR_EQUAL:
            tgt.setValue(org.hl7.fhir.dstu3.model.Quantity.QuantityComparator.GREATER_OR_EQUAL);
            break;
          case GREATER_THAN:
            tgt.setValue(org.hl7.fhir.dstu3.model.Quantity.QuantityComparator.GREATER_THAN);
            break;
          default:
            tgt.setValue(org.hl7.fhir.dstu3.model.Quantity.QuantityComparator.NULL);
            break;
        }
      }
      return tgt;
    }
}
