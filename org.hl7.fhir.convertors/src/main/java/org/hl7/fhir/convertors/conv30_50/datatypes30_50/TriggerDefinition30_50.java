package org.hl7.fhir.convertors.conv30_50.datatypes30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class TriggerDefinition30_50 {
  public static org.hl7.fhir.r5.model.TriggerDefinition convertTriggerDefinition(org.hl7.fhir.dstu3.model.TriggerDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.TriggerDefinition tgt = new org.hl7.fhir.r5.model.TriggerDefinition();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertTriggerType(src.getTypeElement()));
    if (src.hasEventName()) tgt.setNameElement(String30_50.convertString(src.getEventNameElement()));
    if (src.hasEventTiming())
      tgt.setTiming(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getEventTiming()));
    if (src.hasEventData()) tgt.addData(DataRequirement30_50.convertDataRequirement(src.getEventData()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TriggerDefinition convertTriggerDefinition(org.hl7.fhir.r5.model.TriggerDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.TriggerDefinition tgt = new org.hl7.fhir.dstu3.model.TriggerDefinition();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertTriggerType(src.getTypeElement()));
    if (src.hasName()) tgt.setEventNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasTiming())
      tgt.setEventTiming(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getTiming()));
    if (src.hasData()) tgt.setEventData(DataRequirement30_50.convertDataRequirement(src.getDataFirstRep()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TriggerDefinition.TriggerType> convertTriggerType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TriggerDefinition.TriggerType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TriggerDefinition.TriggerTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType> convertTriggerType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TriggerDefinition.TriggerType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType.NULL);
    } else {
      switch (src.getValue()) {
        case NAMEDEVENT:
          tgt.setValue(org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType.NAMEDEVENT);
          break;
        case PERIODIC:
          tgt.setValue(org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType.PERIODIC);
          break;
        case DATAADDED:
          tgt.setValue(org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType.DATAADDED);
          break;
        case DATAMODIFIED:
          tgt.setValue(org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType.DATAMODIFIED);
          break;
        case DATAREMOVED:
          tgt.setValue(org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType.DATAREMOVED);
          break;
        case DATAACCESSED:
          tgt.setValue(org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType.DATAACCESSED);
          break;
        case DATAACCESSENDED:
          tgt.setValue(org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType.DATAACCESSENDED);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType.NULL);
          break;
      }
    }
    return tgt;
  }
}
