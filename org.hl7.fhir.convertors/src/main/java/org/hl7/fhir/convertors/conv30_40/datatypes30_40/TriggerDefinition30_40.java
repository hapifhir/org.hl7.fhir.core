package org.hl7.fhir.convertors.conv30_40.datatypes30_40;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Coding30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Code30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Type;

public class TriggerDefinition30_40 {
  public static org.hl7.fhir.r4.model.TriggerDefinition convertTriggerDefinition(org.hl7.fhir.dstu3.model.TriggerDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.TriggerDefinition tgt = new org.hl7.fhir.r4.model.TriggerDefinition();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertTriggerType(src.getTypeElement()));
    if (src.hasEventName()) tgt.setNameElement(String30_40.convertString(src.getEventNameElement()));
    if (src.hasEventTiming())
      tgt.setTiming(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getEventTiming()));
    if (src.hasEventData()) tgt.addData(convertDataRequirement(src.getEventData()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TriggerDefinition convertTriggerDefinition(org.hl7.fhir.r4.model.TriggerDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.TriggerDefinition tgt = new org.hl7.fhir.dstu3.model.TriggerDefinition();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertTriggerType(src.getTypeElement()));
    if (src.hasName()) tgt.setEventNameElement(String30_40.convertString(src.getNameElement()));
    if (src.hasTiming())
      tgt.setEventTiming(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getTiming()));
    if (src.hasData()) tgt.setEventData(convertDataRequirement(src.getDataFirstRep()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DataRequirement convertDataRequirement(org.hl7.fhir.dstu3.model.DataRequirement src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.DataRequirement tgt = new org.hl7.fhir.r4.model.DataRequirement();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(Code30_40.convertCode(src.getTypeElement()));
    for (org.hl7.fhir.dstu3.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
    for (org.hl7.fhir.dstu3.model.StringType t : src.getMustSupport()) tgt.addMustSupport(t.getValue());
    for (org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementCodeFilterComponent t : src.getCodeFilter())
      tgt.addCodeFilter(convertDataRequirementCodeFilterComponent(t));
    for (org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementDateFilterComponent t : src.getDateFilter())
      tgt.addDateFilter(convertDataRequirementDateFilterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DataRequirement convertDataRequirement(org.hl7.fhir.r4.model.DataRequirement src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.DataRequirement tgt = new org.hl7.fhir.dstu3.model.DataRequirement();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(Code30_40.convertCode(src.getTypeElement()));
    for (org.hl7.fhir.r4.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
    for (org.hl7.fhir.r4.model.StringType t : src.getMustSupport()) tgt.addMustSupport(t.getValue());
    for (org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent t : src.getCodeFilter())
      tgt.addCodeFilter(convertDataRequirementCodeFilterComponent(t));
    for (org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent t : src.getDateFilter())
      tgt.addDateFilter(convertDataRequirementDateFilterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent convertDataRequirementCodeFilterComponent(org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementCodeFilterComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent tgt = new org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String30_40.convertString(src.getPathElement()));
    if (src.hasValueSet()) {
      Type t = ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getValueSet());
      if (t instanceof org.hl7.fhir.r4.model.Reference)
        tgt.setValueSet(((org.hl7.fhir.r4.model.Reference) t).getReference());
      else tgt.setValueSet(t.primitiveValue());
      tgt.setValueSet(VersionConvertorConstants.refToVS(tgt.getValueSet()));
    }
    for (org.hl7.fhir.dstu3.model.CodeType t : src.getValueCode()) tgt.addCode(Coding30_40.convertCoding(t));
    for (org.hl7.fhir.dstu3.model.Coding t : src.getValueCoding()) tgt.addCode(Coding30_40.convertCoding(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getValueCodeableConcept())
      tgt.addCode(Coding30_40.convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementCodeFilterComponent convertDataRequirementCodeFilterComponent(org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementCodeFilterComponent tgt = new org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementCodeFilterComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String30_40.convertString(src.getPathElement()));
    if (src.hasValueSet()) {
      String vsr = VersionConvertorConstants.vsToRef(src.getValueSet());
      if (vsr != null) tgt.setValueSet(new org.hl7.fhir.dstu3.model.UriType(vsr));
      else tgt.setValueSet(new org.hl7.fhir.dstu3.model.Reference(src.getValueSet()));
    }
    for (org.hl7.fhir.r4.model.Coding t : src.getCode()) {
      tgt.addValueCoding(Coding30_40.convertCoding(t));
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent convertDataRequirementDateFilterComponent(org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementDateFilterComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent tgt = new org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String30_40.convertString(src.getPathElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementDateFilterComponent convertDataRequirementDateFilterComponent(org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementDateFilterComponent tgt = new org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementDateFilterComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String30_40.convertString(src.getPathElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getValue()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TriggerDefinition.TriggerType> convertTriggerType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TriggerDefinition.TriggerType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TriggerDefinition.TriggerTypeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.NULL);
    } else {
      switch (src.getValue()) {
        case NAMEDEVENT:
          tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.NAMEDEVENT);
          break;
        case PERIODIC:
          tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.PERIODIC);
          break;
        case DATAADDED:
          tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.DATAADDED);
          break;
        case DATAMODIFIED:
          tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.DATAMODIFIED);
          break;
        case DATAREMOVED:
          tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.DATAREMOVED);
          break;
        case DATAACCESSED:
          tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.DATAACCESSED);
          break;
        case DATAACCESSENDED:
          tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.DATAACCESSENDED);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType> convertTriggerType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TriggerDefinition.TriggerType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TriggerDefinition.TriggerTypeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
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
