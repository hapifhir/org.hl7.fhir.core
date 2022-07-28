package org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class TriggerDefinition43_50 {
  public static org.hl7.fhir.r5.model.TriggerDefinition convertTriggerDefinition(org.hl7.fhir.r4b.model.TriggerDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.TriggerDefinition tgt = new org.hl7.fhir.r5.model.TriggerDefinition();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertTriggerType(src.getTypeElement()));
    if (src.hasName()) tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getTiming()));
    for (org.hl7.fhir.r4b.model.DataRequirement t : src.getData())
      tgt.addData(DataRequirement43_50.convertDataRequirement(t));
    if (src.hasCondition()) tgt.setCondition(Expression43_50.convertExpression(src.getCondition()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TriggerDefinition convertTriggerDefinition(org.hl7.fhir.r5.model.TriggerDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.TriggerDefinition tgt = new org.hl7.fhir.r4b.model.TriggerDefinition();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertTriggerType(src.getTypeElement()));
    if (src.hasName()) tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getTiming()));
    for (org.hl7.fhir.r5.model.DataRequirement t : src.getData())
      tgt.addData(DataRequirement43_50.convertDataRequirement(t));
    if (src.hasCondition()) tgt.setCondition(Expression43_50.convertExpression(src.getCondition()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TriggerDefinition.TriggerType> convertTriggerType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TriggerDefinition.TriggerType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TriggerDefinition.TriggerType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TriggerDefinition.TriggerTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.NULL);
    } else {
      switch (src.getValue()) {
        case NAMEDEVENT:
          tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.NAMEDEVENT);
          break;
        case PERIODIC:
          tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.PERIODIC);
          break;
        case DATACHANGED:
          tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.DATACHANGED);
          break;
        case DATAADDED:
          tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.DATAADDED);
          break;
        case DATAMODIFIED:
          tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.DATAMODIFIED);
          break;
        case DATAREMOVED:
          tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.DATAREMOVED);
          break;
        case DATAACCESSED:
          tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.DATAACCESSED);
          break;
        case DATAACCESSENDED:
          tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.DATAACCESSENDED);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TriggerDefinition.TriggerType> convertTriggerType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TriggerDefinition.TriggerType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TriggerDefinition.TriggerType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.TriggerDefinition.TriggerTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4b.model.TriggerDefinition.TriggerType.NULL);
    } else {
      switch (src.getValue()) {
        case NAMEDEVENT:
          tgt.setValue(org.hl7.fhir.r4b.model.TriggerDefinition.TriggerType.NAMEDEVENT);
          break;
        case PERIODIC:
          tgt.setValue(org.hl7.fhir.r4b.model.TriggerDefinition.TriggerType.PERIODIC);
          break;
        case DATACHANGED:
          tgt.setValue(org.hl7.fhir.r4b.model.TriggerDefinition.TriggerType.DATACHANGED);
          break;
        case DATAADDED:
          tgt.setValue(org.hl7.fhir.r4b.model.TriggerDefinition.TriggerType.DATAADDED);
          break;
        case DATAMODIFIED:
          tgt.setValue(org.hl7.fhir.r4b.model.TriggerDefinition.TriggerType.DATAMODIFIED);
          break;
        case DATAREMOVED:
          tgt.setValue(org.hl7.fhir.r4b.model.TriggerDefinition.TriggerType.DATAREMOVED);
          break;
        case DATAACCESSED:
          tgt.setValue(org.hl7.fhir.r4b.model.TriggerDefinition.TriggerType.DATAACCESSED);
          break;
        case DATAACCESSENDED:
          tgt.setValue(org.hl7.fhir.r4b.model.TriggerDefinition.TriggerType.DATAACCESSENDED);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4b.model.TriggerDefinition.TriggerType.NULL);
          break;
      }
    }
    return tgt;
  }
}
