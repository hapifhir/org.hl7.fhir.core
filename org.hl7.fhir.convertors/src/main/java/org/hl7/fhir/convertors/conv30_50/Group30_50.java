package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class Group30_50 {

    public static org.hl7.fhir.r5.model.Group convertGroup(org.hl7.fhir.dstu3.model.Group src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Group tgt = new org.hl7.fhir.r5.model.Group();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasActiveElement())
            tgt.setActiveElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_30_50.convertType(src.getActiveElement()));
        if (src.hasType())
            tgt.setType(convertGroupType(src.getType()));
        if (src.hasActualElement())
            tgt.setActualElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_30_50.convertType(src.getActualElement()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getNameElement()));
        if (src.hasQuantityElement())
            tgt.setQuantityElement((org.hl7.fhir.r5.model.UnsignedIntType) VersionConvertor_30_50.convertType(src.getQuantityElement()));
        if (src.hasCharacteristic()) {
            for (org.hl7.fhir.dstu3.model.Group.GroupCharacteristicComponent t : src.getCharacteristic()) tgt.addCharacteristic(convertGroupCharacteristicComponent(t));
        }
        if (src.hasMember()) {
            for (org.hl7.fhir.dstu3.model.Group.GroupMemberComponent t : src.getMember()) tgt.addMember(convertGroupMemberComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Group convertGroup(org.hl7.fhir.r5.model.Group src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Group tgt = new org.hl7.fhir.dstu3.model.Group();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasActiveElement())
            tgt.setActiveElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_50.convertType(src.getActiveElement()));
        if (src.hasType())
            tgt.setType(convertGroupType(src.getType()));
        if (src.hasActualElement())
            tgt.setActualElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_50.convertType(src.getActualElement()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getNameElement()));
        if (src.hasQuantityElement())
            tgt.setQuantityElement((org.hl7.fhir.dstu3.model.UnsignedIntType) VersionConvertor_30_50.convertType(src.getQuantityElement()));
        if (src.hasCharacteristic()) {
            for (org.hl7.fhir.r5.model.Group.GroupCharacteristicComponent t : src.getCharacteristic()) tgt.addCharacteristic(convertGroupCharacteristicComponent(t));
        }
        if (src.hasMember()) {
            for (org.hl7.fhir.r5.model.Group.GroupMemberComponent t : src.getMember()) tgt.addMember(convertGroupMemberComponent(t));
        }
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
        if (src.hasExcludeElement())
            tgt.setExcludeElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_30_50.convertType(src.getExcludeElement()));
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
        if (src.hasExcludeElement())
            tgt.setExcludeElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_50.convertType(src.getExcludeElement()));
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
        if (src.hasInactiveElement())
            tgt.setInactiveElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_50.convertType(src.getInactiveElement()));
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
        if (src.hasInactiveElement())
            tgt.setInactiveElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_30_50.convertType(src.getInactiveElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Group.GroupType convertGroupType(org.hl7.fhir.r5.model.Group.GroupType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PERSON:
                return org.hl7.fhir.dstu3.model.Group.GroupType.PERSON;
            case ANIMAL:
                return org.hl7.fhir.dstu3.model.Group.GroupType.ANIMAL;
            case PRACTITIONER:
                return org.hl7.fhir.dstu3.model.Group.GroupType.PRACTITIONER;
            case DEVICE:
                return org.hl7.fhir.dstu3.model.Group.GroupType.DEVICE;
            case MEDICATION:
                return org.hl7.fhir.dstu3.model.Group.GroupType.MEDICATION;
            case SUBSTANCE:
                return org.hl7.fhir.dstu3.model.Group.GroupType.SUBSTANCE;
            default:
                return org.hl7.fhir.dstu3.model.Group.GroupType.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.Group.GroupType convertGroupType(org.hl7.fhir.dstu3.model.Group.GroupType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PERSON:
                return org.hl7.fhir.r5.model.Group.GroupType.PERSON;
            case ANIMAL:
                return org.hl7.fhir.r5.model.Group.GroupType.ANIMAL;
            case PRACTITIONER:
                return org.hl7.fhir.r5.model.Group.GroupType.PRACTITIONER;
            case DEVICE:
                return org.hl7.fhir.r5.model.Group.GroupType.DEVICE;
            case MEDICATION:
                return org.hl7.fhir.r5.model.Group.GroupType.MEDICATION;
            case SUBSTANCE:
                return org.hl7.fhir.r5.model.Group.GroupType.SUBSTANCE;
            default:
                return org.hl7.fhir.r5.model.Group.GroupType.NULL;
        }
    }
}
