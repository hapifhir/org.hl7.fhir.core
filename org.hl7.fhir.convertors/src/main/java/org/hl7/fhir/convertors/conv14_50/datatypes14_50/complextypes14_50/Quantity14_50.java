package org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50;

import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Element14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Code14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Decimal14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.String14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Uri14_50;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext14_50; 

public class Quantity14_50 {
    public static org.hl7.fhir.r5.model.Quantity convertQuantity(org.hl7.fhir.dstu2016may.model.Quantity src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.Quantity tgt = new org.hl7.fhir.r5.model.Quantity();
      ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
      if (src.hasValue()) tgt.setValueElement(Decimal14_50.convertDecimal(src.getValueElement()));
      if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
      if (src.hasUnit()) tgt.setUnitElement(String14_50.convertString(src.getUnitElement()));
      if (src.hasSystem()) tgt.setSystemElement(Uri14_50.convertUri(src.getSystemElement()));
      if (src.hasCode()) tgt.setCodeElement(Code14_50.convertCode(src.getCodeElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Quantity convertQuantity(org.hl7.fhir.r5.model.Quantity src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Quantity tgt = new org.hl7.fhir.dstu2016may.model.Quantity();
      ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
      if (src.hasValue()) tgt.setValueElement(Decimal14_50.convertDecimal(src.getValueElement()));
      if (src.hasComparator()) tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
      if (src.hasUnit()) tgt.setUnitElement(String14_50.convertString(src.getUnitElement()));
      if (src.hasSystem()) tgt.setSystemElement(Uri14_50.convertUri(src.getSystemElement()));
      if (src.hasCode()) tgt.setCodeElement(Code14_50.convertCode(src.getCodeElement()));
      return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> convertQuantityComparator(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparator> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.QuantityComparatorEnumFactory());
      ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparator> convertQuantityComparator(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparator> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparatorEnumFactory());
      ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparator.NULL);
      } else {
        switch (src.getValue()) {
          case LESS_THAN:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparator.LESS_THAN);
            break;
          case LESS_OR_EQUAL:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparator.LESS_OR_EQUAL);
            break;
          case GREATER_OR_EQUAL:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparator.GREATER_OR_EQUAL);
            break;
          case GREATER_THAN:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparator.GREATER_THAN);
            break;
          default:
            tgt.setValue(org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparator.NULL);
            break;
        }
      }
      return tgt;
    }
}
