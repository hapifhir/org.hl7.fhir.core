package org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Code43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Decimal43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.Quantity;
import org.hl7.fhir.model.core.Enumerations;

public class Quantity43_N {
  public static org.hl7.fhir.model.core.Quantity convertQuantity(org.hl7.fhir.r4b.model.Quantity src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Quantity tgt = new org.hl7.fhir.model.core.Quantity();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal43_N.convertDecimal(src.getValueElement()));
    if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnitElement(String43_N.convertString(src.getUnitElement()));
    if (src.hasSystem()) tgt.setSystemElement(Uri43_N.convertUri(src.getSystemElement()));
    if (src.hasCode()) tgt.setCodeElement(Code43_N.convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Quantity convertQuantity(org.hl7.fhir.model.core.Quantity src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Quantity tgt = new org.hl7.fhir.r4b.model.Quantity();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValueElement(Decimal43_N.convertDecimal(src.getValueElement()));
    if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnitElement(String43_N.convertString(src.getUnitElement()));
    if (src.hasSystem()) tgt.setSystemElement(Uri43_N.convertUri(src.getSystemElement()));
    if (src.hasCode()) tgt.setCodeElement(Code43_N.convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.QuantityComparator> convertQuantityComparator(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.QuantityComparator> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.QuantityComparator> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.QuantityComparatorEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  public static org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.QuantityComparator> convertQuantityComparator(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.QuantityComparator> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.QuantityComparator> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.QuantityComparatorEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
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

  public static void copyQuantity(org.hl7.fhir.r4b.model.Quantity src, org.hl7.fhir.model.core.Quantity tgt) throws FHIRException {
    if (src == null || tgt == null) return;
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValue(src.getValue());
    if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnit(src.getUnit());
    if (src.hasSystem()) tgt.setSystem(src.getSystem());
    if (src.hasCode()) tgt.setCode(src.getCode());
  }

  public static void copyQuantity(org.hl7.fhir.model.core.Quantity src, org.hl7.fhir.r4b.model.Quantity tgt) throws FHIRException {
    if (src == null || tgt == null) return;
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasValue()) tgt.setValue(src.getValue());
    if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnit()) tgt.setUnit(src.getUnit());
    if (src.hasSystem()) tgt.setSystem(src.getSystem());
    if (src.hasCode()) tgt.setCode(src.getCode());
  }
}
