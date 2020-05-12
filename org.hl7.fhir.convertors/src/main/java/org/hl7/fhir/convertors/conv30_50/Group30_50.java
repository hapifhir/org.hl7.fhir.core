package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Group30_50 {

    public static org.hl7.fhir.r5.model.Group convertGroup(org.hl7.fhir.dstu3.model.Group src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Group tgt = new org.hl7.fhir.r5.model.Group();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(VersionConvertor_30_50.convertBoolean(src.getActiveElement()));
        if (src.hasType())
            tgt.setTypeElement(convertGroupType(src.getTypeElement()));
        if (src.hasActual())
            tgt.setActualElement(VersionConvertor_30_50.convertBoolean(src.getActualElement()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasQuantity())
            tgt.setQuantityElement(VersionConvertor_30_50.convertUnsignedInt(src.getQuantityElement()));
        for (org.hl7.fhir.dstu3.model.Group.GroupCharacteristicComponent t : src.getCharacteristic()) tgt.addCharacteristic(convertGroupCharacteristicComponent(t));
        for (org.hl7.fhir.dstu3.model.Group.GroupMemberComponent t : src.getMember()) tgt.addMember(convertGroupMemberComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Group convertGroup(org.hl7.fhir.r5.model.Group src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Group tgt = new org.hl7.fhir.dstu3.model.Group();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(VersionConvertor_30_50.convertBoolean(src.getActiveElement()));
        if (src.hasType())
            tgt.setTypeElement(convertGroupType(src.getTypeElement()));
        if (src.hasActual())
            tgt.setActualElement(VersionConvertor_30_50.convertBoolean(src.getActualElement()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasQuantity())
            tgt.setQuantityElement(VersionConvertor_30_50.convertUnsignedInt(src.getQuantityElement()));
        for (org.hl7.fhir.r5.model.Group.GroupCharacteristicComponent t : src.getCharacteristic()) tgt.addCharacteristic(convertGroupCharacteristicComponent(t));
        for (org.hl7.fhir.r5.model.Group.GroupMemberComponent t : src.getMember()) tgt.addMember(convertGroupMemberComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Group.GroupCharacteristicComponent convertGroupCharacteristicComponent(org.hl7.fhir.dstu3.model.Group.GroupCharacteristicComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Group.GroupCharacteristicComponent tgt = new org.hl7.fhir.r5.model.Group.GroupCharacteristicComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_30_50.convertType(src.getValue()));
        if (src.hasExclude())
            tgt.setExcludeElement(VersionConvertor_30_50.convertBoolean(src.getExcludeElement()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_50.convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Group.GroupCharacteristicComponent convertGroupCharacteristicComponent(org.hl7.fhir.r5.model.Group.GroupCharacteristicComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Group.GroupCharacteristicComponent tgt = new org.hl7.fhir.dstu3.model.Group.GroupCharacteristicComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_30_50.convertType(src.getValue()));
        if (src.hasExclude())
            tgt.setExcludeElement(VersionConvertor_30_50.convertBoolean(src.getExcludeElement()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_50.convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Group.GroupMemberComponent convertGroupMemberComponent(org.hl7.fhir.r5.model.Group.GroupMemberComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Group.GroupMemberComponent tgt = new org.hl7.fhir.dstu3.model.Group.GroupMemberComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasEntity())
            tgt.setEntity(VersionConvertor_30_50.convertReference(src.getEntity()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_50.convertPeriod(src.getPeriod()));
        if (src.hasInactive())
            tgt.setInactiveElement(VersionConvertor_30_50.convertBoolean(src.getInactiveElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Group.GroupMemberComponent convertGroupMemberComponent(org.hl7.fhir.dstu3.model.Group.GroupMemberComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Group.GroupMemberComponent tgt = new org.hl7.fhir.r5.model.Group.GroupMemberComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasEntity())
            tgt.setEntity(VersionConvertor_30_50.convertReference(src.getEntity()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_50.convertPeriod(src.getPeriod()));
        if (src.hasInactive())
            tgt.setInactiveElement(VersionConvertor_30_50.convertBoolean(src.getInactiveElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Group.GroupType> convertGroupType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Group.GroupType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Group.GroupType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Group.GroupTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PERSON:
                tgt.setValue(org.hl7.fhir.dstu3.model.Group.GroupType.PERSON);
                break;
            case ANIMAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.Group.GroupType.ANIMAL);
                break;
            case PRACTITIONER:
                tgt.setValue(org.hl7.fhir.dstu3.model.Group.GroupType.PRACTITIONER);
                break;
            case DEVICE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Group.GroupType.DEVICE);
                break;
            case MEDICATION:
                tgt.setValue(org.hl7.fhir.dstu3.model.Group.GroupType.MEDICATION);
                break;
            case SUBSTANCE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Group.GroupType.SUBSTANCE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Group.GroupType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Group.GroupType> convertGroupType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Group.GroupType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Group.GroupType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Group.GroupTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
}