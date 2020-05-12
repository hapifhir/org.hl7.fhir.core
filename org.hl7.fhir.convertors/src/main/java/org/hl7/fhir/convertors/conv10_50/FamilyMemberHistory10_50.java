package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class FamilyMemberHistory10_50 {

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus> convertFamilyHistoryStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatusEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PARTIAL:
                tgt.setValue(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus.PARTIAL);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus.ENTEREDINERROR);
                break;
            case HEALTHUNKNOWN:
                tgt.setValue(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus.HEALTHUNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatus> convertFamilyHistoryStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatusEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
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

    public static org.hl7.fhir.r5.model.FamilyMemberHistory convertFamilyMemberHistory(org.hl7.fhir.dstu2.model.FamilyMemberHistory src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.FamilyMemberHistory tgt = new org.hl7.fhir.r5.model.FamilyMemberHistory();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_10_50.convertReference(src.getPatient()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_50.convertDateTime(src.getDateElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertFamilyHistoryStatus(src.getStatusElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_50.convertString(src.getNameElement()));
        if (src.hasRelationship())
            tgt.setRelationship(VersionConvertor_10_50.convertCodeableConcept(src.getRelationship()));
        if (src.hasBorn())
            tgt.setBorn(VersionConvertor_10_50.convertType(src.getBorn()));
        if (src.hasAge())
            tgt.setAge(VersionConvertor_10_50.convertType(src.getAge()));
        if (src.hasDeceased())
            tgt.setDeceased(VersionConvertor_10_50.convertType(src.getDeceased()));
        for (org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent t : src.getCondition()) tgt.addCondition(convertFamilyMemberHistoryConditionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.FamilyMemberHistory convertFamilyMemberHistory(org.hl7.fhir.r5.model.FamilyMemberHistory src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.FamilyMemberHistory tgt = new org.hl7.fhir.dstu2.model.FamilyMemberHistory();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_10_50.convertReference(src.getPatient()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_50.convertDateTime(src.getDateElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertFamilyHistoryStatus(src.getStatusElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_50.convertString(src.getNameElement()));
        if (src.hasRelationship())
            tgt.setRelationship(VersionConvertor_10_50.convertCodeableConcept(src.getRelationship()));
        if (src.hasBorn())
            tgt.setBorn(VersionConvertor_10_50.convertType(src.getBorn()));
        if (src.hasAge())
            tgt.setAge(VersionConvertor_10_50.convertType(src.getAge()));
        if (src.hasDeceased())
            tgt.setDeceased(VersionConvertor_10_50.convertType(src.getDeceased()));
        for (org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent t : src.getCondition()) tgt.addCondition(convertFamilyMemberHistoryConditionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent convertFamilyMemberHistoryConditionComponent(org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent tgt = new org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_50.convertCodeableConcept(src.getCode()));
        if (src.hasOutcome())
            tgt.setOutcome(VersionConvertor_10_50.convertCodeableConcept(src.getOutcome()));
        if (src.hasOnset())
            tgt.setOnset(VersionConvertor_10_50.convertType(src.getOnset()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent convertFamilyMemberHistoryConditionComponent(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent tgt = new org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_50.convertCodeableConcept(src.getCode()));
        if (src.hasOutcome())
            tgt.setOutcome(VersionConvertor_10_50.convertCodeableConcept(src.getOutcome()));
        if (src.hasOnset())
            tgt.setOnset(VersionConvertor_10_50.convertType(src.getOnset()));
        return tgt;
    }
}