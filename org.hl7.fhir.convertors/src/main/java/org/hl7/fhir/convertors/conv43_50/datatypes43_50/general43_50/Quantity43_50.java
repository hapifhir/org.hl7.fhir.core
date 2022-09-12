package org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Code43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Decimal43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Quantity43_50 {
  public static org.hl7.fhir.r5.model.Quantity convertQuantity(org.hl7.fhir.r4b.model.Quantity src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Quantity tgt = new org.hl7.fhir.r5.model.Quantity();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal43_50.convertDecimal(src.getValueElement()));
    if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnitElement(String43_50.convertString(src.getUnitElement()));
    if (src.hasSystem()) tgt.setSystemElement(Uri43_50.convertUri(src.getSystemElement()));
    if (src.hasCode()) tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Quantity convertQuantity(org.hl7.fhir.r5.model.Quantity src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Quantity tgt = new org.hl7.fhir.r4b.model.Quantity();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal43_50.convertDecimal(src.getValueElement()));
    if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnitElement(String43_50.convertString(src.getUnitElement()));
    if (src.hasSystem()) tgt.setSystemElement(Uri43_50.convertUri(src.getSystemElement()));
    if (src.hasCode()) tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> convertQuantityComparator(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.QuantityComparator> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.QuantityComparatorEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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

  public static org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.QuantityComparator> convertQuantityComparator(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.QuantityComparator> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.QuantityComparatorEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.QuantityComparator.NULL);
    } else {
      switch (src.getValue()) {
        case LESS_THAN:
          tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.QuantityComparator.LESS_THAN);
          break;
        case LESS_OR_EQUAL:
          tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.QuantityComparator.LESS_OR_EQUAL);
          break;
        case GREATER_OR_EQUAL:
          tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.QuantityComparator.GREATER_OR_EQUAL);
          break;
        case GREATER_THAN:
          tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.QuantityComparator.GREATER_THAN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.QuantityComparator.NULL);
          break;
      }
    }
    return tgt;
  }

  public static void copyQuantity(org.hl7.fhir.r4b.model.Quantity src, org.hl7.fhir.r5.model.Quantity tgt) throws FHIRException {
    if (src == null || tgt == null) return;
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValue(src.getValue());
    if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnit(src.getUnit());
    if (src.hasSystem()) tgt.setSystem(src.getSystem());
    if (src.hasCode()) tgt.setCode(src.getCode());
  }

  public static void copyQuantity(org.hl7.fhir.r5.model.Quantity src, org.hl7.fhir.r4b.model.Quantity tgt) throws FHIRException {
    if (src == null || tgt == null) return;
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValue(src.getValue());
    if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnit(src.getUnit());
    if (src.hasSystem()) tgt.setSystem(src.getSystem());
    if (src.hasCode()) tgt.setCode(src.getCode());
  }
}
