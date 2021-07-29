package org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Code40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Decimal40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Quantity40_50 {
  public static org.hl7.fhir.r5.model.Quantity convertQuantity(org.hl7.fhir.r4.model.Quantity src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Quantity tgt = new org.hl7.fhir.r5.model.Quantity();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal40_50.convertDecimal(src.getValueElement()));
    if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnitElement(String40_50.convertString(src.getUnitElement()));
    if (src.hasSystem()) tgt.setSystemElement(Uri40_50.convertUri(src.getSystemElement()));
    if (src.hasCode()) tgt.setCodeElement(Code40_50.convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Quantity convertQuantity(org.hl7.fhir.r5.model.Quantity src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Quantity tgt = new org.hl7.fhir.r4.model.Quantity();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal40_50.convertDecimal(src.getValueElement()));
    if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnitElement(String40_50.convertString(src.getUnitElement()));
    if (src.hasSystem()) tgt.setSystemElement(Uri40_50.convertUri(src.getSystemElement()));
    if (src.hasCode()) tgt.setCodeElement(Code40_50.convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> convertQuantityComparator(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Quantity.QuantityComparator> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.QuantityComparatorEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  public static org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Quantity.QuantityComparator> convertQuantityComparator(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Quantity.QuantityComparator> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Quantity.QuantityComparatorEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  public static void copyQuantity(org.hl7.fhir.r4.model.Quantity src, org.hl7.fhir.r5.model.Quantity tgt) throws FHIRException {
    if (src == null || tgt == null) return;
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValue(src.getValue());
    if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnit(src.getUnit());
    if (src.hasSystem()) tgt.setSystem(src.getSystem());
    if (src.hasCode()) tgt.setCode(src.getCode());
  }

  public static void copyQuantity(org.hl7.fhir.r5.model.Quantity src, org.hl7.fhir.r4.model.Quantity tgt) throws FHIRException {
    if (src == null || tgt == null) return;
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValue(src.getValue());
    if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnit(src.getUnit());
    if (src.hasSystem()) tgt.setSystem(src.getSystem());
    if (src.hasCode()) tgt.setCode(src.getCode());
  }
}
