package org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Code40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Decimal40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.model.core.Enumerations;

public class Quantity40_N {
  public static org.hl7.fhir.model.core.Quantity convertQuantity(org.hl7.fhir.r4.model.Quantity src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Quantity tgt = new org.hl7.fhir.model.core.Quantity();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal40_N.convertDecimal(src.getValueElement()));
    if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnitElement(String40_N.convertString(src.getUnitElement()));
    if (src.hasSystem()) tgt.setSystemElement(Uri40_N.convertUri(src.getSystemElement()));
    if (src.hasCode()) tgt.setCodeElement(Code40_N.convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Quantity convertQuantity(org.hl7.fhir.model.core.Quantity src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Quantity tgt = new org.hl7.fhir.r4.model.Quantity();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal40_N.convertDecimal(src.getValueElement()));
    if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnitElement(String40_N.convertString(src.getUnitElement()));
    if (src.hasSystem()) tgt.setSystemElement(Uri40_N.convertUri(src.getSystemElement()));
    if (src.hasCode()) tgt.setCodeElement(Code40_N.convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.QuantityComparator> convertQuantityComparator(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Quantity.QuantityComparator> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.QuantityComparator> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.QuantityComparatorEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case LESS_THAN:
                    tgt.setValue(Enumerations.QuantityComparator.LESS_THAN);
                    break;
                case LESS_OR_EQUAL:
                    tgt.setValue(Enumerations.QuantityComparator.LESS_OR_EQUAL);
                    break;
                case GREATER_OR_EQUAL:
                    tgt.setValue(Enumerations.QuantityComparator.GREATER_OR_EQUAL);
                    break;
                case GREATER_THAN:
                    tgt.setValue(Enumerations.QuantityComparator.GREATER_THAN);
                    break;
                default:
                    tgt.setValue(Enumerations.QuantityComparator.NULL);
                    break;
       }
}
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Quantity.QuantityComparator> convertQuantityComparator(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.QuantityComparator> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Quantity.QuantityComparator> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Quantity.QuantityComparatorEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case LESS_THAN:
                    tgt.setValue(Quantity.QuantityComparator.LESS_THAN);
                    break;
                case LESS_OR_EQUAL:
                    tgt.setValue(Quantity.QuantityComparator.LESS_OR_EQUAL);
                    break;
                case GREATER_OR_EQUAL:
                    tgt.setValue(Quantity.QuantityComparator.GREATER_OR_EQUAL);
                    break;
                case GREATER_THAN:
                    tgt.setValue(Quantity.QuantityComparator.GREATER_THAN);
                    break;
                default:
                    tgt.setValue(Quantity.QuantityComparator.NULL);
                    break;
       }
}
    return tgt;
  }

  public static void copyQuantity(org.hl7.fhir.r4.model.Quantity src, org.hl7.fhir.model.core.Quantity tgt) throws FHIRException {
    if (src == null || tgt == null) return;
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValue(src.getValue());
    if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnit(src.getUnit());
    if (src.hasSystem()) tgt.setSystem(src.getSystem());
    if (src.hasCode()) tgt.setCode(src.getCode());
  }

  public static void copyQuantity(org.hl7.fhir.model.core.Quantity src, org.hl7.fhir.r4.model.Quantity tgt) throws FHIRException {
    if (src == null || tgt == null) return;
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValue(src.getValue());
    if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnit(src.getUnit());
    if (src.hasSystem()) tgt.setSystem(src.getSystem());
    if (src.hasCode()) tgt.setCode(src.getCode());
  }
}
