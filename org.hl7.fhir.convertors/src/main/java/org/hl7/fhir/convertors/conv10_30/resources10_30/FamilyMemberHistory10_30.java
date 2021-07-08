package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.conv10_30.VersionConvertor_10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Type10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.DateTime10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class FamilyMemberHistory10_30 {

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyHistoryStatus> convertFamilyHistoryStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyHistoryStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyHistoryStatusEnumFactory());
        Element10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case PARTIAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyHistoryStatus.PARTIAL);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyHistoryStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyHistoryStatus.ENTEREDINERROR);
                break;
            case HEALTHUNKNOWN:
                tgt.setValue(org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyHistoryStatus.HEALTHUNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyHistoryStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatus> convertFamilyHistoryStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyHistoryStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatusEnumFactory());
        Element10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case PARTIAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatus.PARTIAL);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatus.ENTEREDINERROR);
                break;
            case HEALTHUNKNOWN:
                tgt.setValue(org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatus.HEALTHUNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.FamilyMemberHistory convertFamilyMemberHistory(org.hl7.fhir.dstu2.model.FamilyMemberHistory src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.FamilyMemberHistory tgt = new org.hl7.fhir.dstu3.model.FamilyMemberHistory();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
        if (src.hasPatient())
            tgt.setPatient(Reference10_30.convertReference(src.getPatient()));
        if (src.hasDate())
            tgt.setDateElement(DateTime10_30.convertDateTime(src.getDateElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertFamilyHistoryStatus(src.getStatusElement()));
        if (src.hasNameElement())
            tgt.setNameElement(String10_30.convertString(src.getNameElement()));
        if (src.hasRelationship())
            tgt.setRelationship(CodeableConcept10_30.convertCodeableConcept(src.getRelationship()));
        if (src.hasGender())
            tgt.setGenderElement(Enumerations10_30.convertAdministrativeGender(src.getGenderElement()));
        if (src.hasBorn())
            tgt.setBorn(Type10_30.convertType(src.getBorn()));
        if (src.hasAge())
            tgt.setAge(Type10_30.convertType(src.getAge()));
        if (src.hasDeceased())
            tgt.setDeceased(Type10_30.convertType(src.getDeceased()));
        for (org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent t : src.getCondition()) tgt.addCondition(convertFamilyMemberHistoryConditionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.FamilyMemberHistory convertFamilyMemberHistory(org.hl7.fhir.dstu3.model.FamilyMemberHistory src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.FamilyMemberHistory tgt = new org.hl7.fhir.dstu2.model.FamilyMemberHistory();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
        if (src.hasPatient())
            tgt.setPatient(Reference10_30.convertReference(src.getPatient()));
        if (src.hasDate())
            tgt.setDateElement(DateTime10_30.convertDateTime(src.getDateElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertFamilyHistoryStatus(src.getStatusElement()));
        if (src.hasNameElement())
            tgt.setNameElement(String10_30.convertString(src.getNameElement()));
        if (src.hasRelationship())
            tgt.setRelationship(CodeableConcept10_30.convertCodeableConcept(src.getRelationship()));
        if (src.hasGender())
            tgt.setGenderElement(Enumerations10_30.convertAdministrativeGender(src.getGenderElement()));
        if (src.hasBorn())
            tgt.setBorn(Type10_30.convertType(src.getBorn()));
        if (src.hasAge())
            tgt.setAge(Type10_30.convertType(src.getAge()));
        if (src.hasDeceased())
            tgt.setDeceased(Type10_30.convertType(src.getDeceased()));
        for (org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent t : src.getCondition()) tgt.addCondition(convertFamilyMemberHistoryConditionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent convertFamilyMemberHistoryConditionComponent(org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent tgt = new org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(CodeableConcept10_30.convertCodeableConcept(src.getCode()));
        if (src.hasOutcome())
            tgt.setOutcome(CodeableConcept10_30.convertCodeableConcept(src.getOutcome()));
        if (src.hasOnset())
            tgt.setOnset(Type10_30.convertType(src.getOnset()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent convertFamilyMemberHistoryConditionComponent(org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent tgt = new org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(CodeableConcept10_30.convertCodeableConcept(src.getCode()));
        if (src.hasOutcome())
            tgt.setOutcome(CodeableConcept10_30.convertCodeableConcept(src.getOutcome()));
        if (src.hasOnset())
            tgt.setOnset(Type10_30.convertType(src.getOnset()));
        return tgt;
    }
}