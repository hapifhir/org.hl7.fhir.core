package org.hl7.fhir.convertors.conv10_50.datatypes10_50.complexTypes10_50;

import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Element10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Code10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Decimal10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Uri10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Quantity10_50 {
    public static org.hl7.fhir.r5.model.Quantity convertQuantity(org.hl7.fhir.dstu2.model.Quantity src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.Quantity tgt = new org.hl7.fhir.r5.model.Quantity();
      Element10_50.copyElement(src, tgt);
      if (src.hasValueElement()) tgt.setValueElement(Decimal10_50.convertDecimal(src.getValueElement()));
      if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
      if (src.hasUnitElement()) tgt.setUnitElement(String10_50.convertString(src.getUnitElement()));
      if (src.hasSystemElement()) tgt.setSystemElement(Uri10_50.convertUri(src.getSystemElement()));
      if (src.hasCodeElement()) tgt.setCodeElement(Code10_50.convertCode(src.getCodeElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Quantity convertQuantity(org.hl7.fhir.r5.model.Quantity src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Quantity tgt = new org.hl7.fhir.dstu2.model.Quantity();
      Element10_50.copyElement(src, tgt);
      if (src.hasValueElement()) tgt.setValueElement(Decimal10_50.convertDecimal(src.getValueElement()));
      if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
      if (src.hasUnitElement()) tgt.setUnitElement(String10_50.convertString(src.getUnitElement()));
      if (src.hasSystemElement()) tgt.setSystemElement(Uri10_50.convertUri(src.getSystemElement()));
      if (src.hasCodeElement()) tgt.setCodeElement(Code10_50.convertCode(src.getCodeElement()));
      return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> convertQuantityComparator(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Quantity.QuantityComparator> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.QuantityComparatorEnumFactory());
      Element10_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Quantity.QuantityComparator> convertQuantityComparator(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Quantity.QuantityComparator> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Quantity.QuantityComparatorEnumFactory());
      Element10_50.copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.NULL);
      } else {
        switch (src.getValue()) {
          case LESS_THAN:
            tgt.setValue(org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.LESS_THAN);
            break;
          case LESS_OR_EQUAL:
            tgt.setValue(org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.LESS_OR_EQUAL);
            break;
          case GREATER_OR_EQUAL:
            tgt.setValue(org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.GREATER_OR_EQUAL);
            break;
          case GREATER_THAN:
            tgt.setValue(org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.GREATER_THAN);
            break;
          default:
            tgt.setValue(org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.NULL);
            break;
        }
      }
      return tgt;
    }
}
