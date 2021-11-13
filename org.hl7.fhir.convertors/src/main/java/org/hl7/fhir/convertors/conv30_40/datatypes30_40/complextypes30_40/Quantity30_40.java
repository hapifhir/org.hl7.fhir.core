package org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Code30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Decimal30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Uri30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Quantity30_40 {
  public static void copyQuantity(org.hl7.fhir.dstu3.model.Quantity src, org.hl7.fhir.r4.model.Quantity tgt) throws FHIRException {
    if (src == null || tgt == null) return;
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValue(src.getValue());
    if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnit(src.getUnit());
    if (src.hasSystem()) tgt.setSystem(src.getSystem());
    if (src.hasCode()) tgt.setCode(src.getCode());
  }

  public static void copyQuantity(org.hl7.fhir.r4.model.Quantity src, org.hl7.fhir.dstu3.model.Quantity tgt) throws FHIRException {
    if (src == null || tgt == null) return;
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValue(src.getValue());
    if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnit(src.getUnit());
    if (src.hasSystem()) tgt.setSystem(src.getSystem());
    if (src.hasCode()) tgt.setCode(src.getCode());
  }

  public static org.hl7.fhir.r4.model.Quantity convertQuantity(org.hl7.fhir.dstu3.model.Quantity src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Quantity tgt = new org.hl7.fhir.r4.model.Quantity();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal30_40.convertDecimal(src.getValueElement()));
    if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnitElement(String30_40.convertString(src.getUnitElement()));
    if (src.hasSystem()) tgt.setSystemElement(Uri30_40.convertUri(src.getSystemElement()));
    if (src.hasCode()) tgt.setCodeElement(Code30_40.convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Quantity convertQuantity(org.hl7.fhir.r4.model.Quantity src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.Quantity tgt = new org.hl7.fhir.dstu3.model.Quantity();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal30_40.convertDecimal(src.getValueElement()));
    if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnitElement(String30_40.convertString(src.getUnitElement()));
    if (src.hasSystem()) tgt.setSystemElement(Uri30_40.convertUri(src.getSystemElement()));
    if (src.hasCode()) tgt.setCodeElement(Code30_40.convertCode(src.getCodeElement()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Quantity.QuantityComparator> convertQuantityComparator(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Quantity.QuantityComparator> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Quantity.QuantityComparator> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Quantity.QuantityComparatorEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4.model.Quantity.QuantityComparator.NULL);
    } else {
      switch (src.getValue()) {
        case LESS_THAN:
          tgt.setValue(org.hl7.fhir.r4.model.Quantity.QuantityComparator.LESS_THAN);
          break;
        case LESS_OR_EQUAL:
          tgt.setValue(org.hl7.fhir.r4.model.Quantity.QuantityComparator.LESS_OR_EQUAL);
          break;
        case GREATER_OR_EQUAL:
          tgt.setValue(org.hl7.fhir.r4.model.Quantity.QuantityComparator.GREATER_OR_EQUAL);
          break;
        case GREATER_THAN:
          tgt.setValue(org.hl7.fhir.r4.model.Quantity.QuantityComparator.GREATER_THAN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.Quantity.QuantityComparator.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Quantity.QuantityComparator> convertQuantityComparator(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Quantity.QuantityComparator> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Quantity.QuantityComparator> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Quantity.QuantityComparatorEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
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
