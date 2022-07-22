package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Identifier10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Period10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Boolean10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.UnsignedInt10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Group10_50 {

  public static org.hl7.fhir.dstu2.model.Group convertGroup(org.hl7.fhir.r5.model.Group src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Group tgt = new org.hl7.fhir.dstu2.model.Group();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasType())
      tgt.setTypeElement(convertGroupType(src.getTypeElement()));
    if (src.hasActualElement())
      tgt.setActualElement(Boolean10_50.convertBoolean(src.getActualElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_50.convertCodeableConcept(src.getCode()));
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    if (src.hasQuantityElement())
      tgt.setQuantityElement(UnsignedInt10_50.convertUnsignedInt(src.getQuantityElement()));
    for (org.hl7.fhir.r5.model.Group.GroupCharacteristicComponent t : src.getCharacteristic())
      tgt.addCharacteristic(convertGroupCharacteristicComponent(t));
    for (org.hl7.fhir.r5.model.Group.GroupMemberComponent t : src.getMember())
      tgt.addMember(convertGroupMemberComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Group convertGroup(org.hl7.fhir.dstu2.model.Group src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Group tgt = new org.hl7.fhir.r5.model.Group();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasType())
      tgt.setTypeElement(convertGroupType(src.getTypeElement()));
    if (src.hasActualElement())
      tgt.setActualElement(Boolean10_50.convertBoolean(src.getActualElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_50.convertCodeableConcept(src.getCode()));
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    if (src.hasQuantityElement())
      tgt.setQuantityElement(UnsignedInt10_50.convertUnsignedInt(src.getQuantityElement()));
    for (org.hl7.fhir.dstu2.model.Group.GroupCharacteristicComponent t : src.getCharacteristic())
      tgt.addCharacteristic(convertGroupCharacteristicComponent(t));
    for (org.hl7.fhir.dstu2.model.Group.GroupMemberComponent t : src.getMember())
      tgt.addMember(convertGroupMemberComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Group.GroupCharacteristicComponent convertGroupCharacteristicComponent(org.hl7.fhir.r5.model.Group.GroupCharacteristicComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Group.GroupCharacteristicComponent tgt = new org.hl7.fhir.dstu2.model.Group.GroupCharacteristicComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_50.convertCodeableConcept(src.getCode()));
    if (src.hasValue())
      tgt.setValue(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getValue()));
    if (src.hasExcludeElement())
      tgt.setExcludeElement(Boolean10_50.convertBoolean(src.getExcludeElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Group.GroupCharacteristicComponent convertGroupCharacteristicComponent(org.hl7.fhir.dstu2.model.Group.GroupCharacteristicComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Group.GroupCharacteristicComponent tgt = new org.hl7.fhir.r5.model.Group.GroupCharacteristicComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_50.convertCodeableConcept(src.getCode()));
    if (src.hasValue())
      tgt.setValue(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getValue()));
    if (src.hasExcludeElement())
      tgt.setExcludeElement(Boolean10_50.convertBoolean(src.getExcludeElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Group.GroupMemberComponent convertGroupMemberComponent(org.hl7.fhir.dstu2.model.Group.GroupMemberComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Group.GroupMemberComponent tgt = new org.hl7.fhir.r5.model.Group.GroupMemberComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasEntity())
      tgt.setEntity(Reference10_50.convertReference(src.getEntity()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_50.convertPeriod(src.getPeriod()));
    if (src.hasInactiveElement())
      tgt.setInactiveElement(Boolean10_50.convertBoolean(src.getInactiveElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Group.GroupMemberComponent convertGroupMemberComponent(org.hl7.fhir.r5.model.Group.GroupMemberComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Group.GroupMemberComponent tgt = new org.hl7.fhir.dstu2.model.Group.GroupMemberComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasEntity())
      tgt.setEntity(Reference10_50.convertReference(src.getEntity()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_50.convertPeriod(src.getPeriod()));
    if (src.hasInactiveElement())
      tgt.setInactiveElement(Boolean10_50.convertBoolean(src.getInactiveElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Group.GroupType> convertGroupType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Group.GroupType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Group.GroupType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Group.GroupTypeEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PERSON:
        tgt.setValue(org.hl7.fhir.r5.model.Group.GroupType.PERSON);
        break;
      case ANIMAL:
        tgt.setValue(org.hl7.fhir.r5.model.Group.GroupType.ANIMAL);
        break;
      case PRACTITIONER:
        tgt.setValue(org.hl7.fhir.r5.model.Group.GroupType.PRACTITIONER);
        break;
      case DEVICE:
        tgt.setValue(org.hl7.fhir.r5.model.Group.GroupType.DEVICE);
        break;
      case MEDICATION:
        tgt.setValue(org.hl7.fhir.r5.model.Group.GroupType.MEDICATION);
        break;
      case SUBSTANCE:
        tgt.setValue(org.hl7.fhir.r5.model.Group.GroupType.SUBSTANCE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Group.GroupType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Group.GroupType> convertGroupType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Group.GroupType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Group.GroupType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Group.GroupTypeEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PERSON:
        tgt.setValue(org.hl7.fhir.dstu2.model.Group.GroupType.PERSON);
        break;
      case ANIMAL:
        tgt.setValue(org.hl7.fhir.dstu2.model.Group.GroupType.ANIMAL);
        break;
      case PRACTITIONER:
        tgt.setValue(org.hl7.fhir.dstu2.model.Group.GroupType.PRACTITIONER);
        break;
      case DEVICE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Group.GroupType.DEVICE);
        break;
      case MEDICATION:
        tgt.setValue(org.hl7.fhir.dstu2.model.Group.GroupType.MEDICATION);
        break;
      case SUBSTANCE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Group.GroupType.SUBSTANCE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Group.GroupType.NULL);
        break;
    }
    return tgt;
  }
}