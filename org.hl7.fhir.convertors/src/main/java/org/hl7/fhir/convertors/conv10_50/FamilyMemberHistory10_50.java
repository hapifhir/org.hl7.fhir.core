package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class FamilyMemberHistory10_50 {

    public static org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus convertFamilyHistoryStatus(org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PARTIAL:
                return org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus.PARTIAL;
            case COMPLETED:
                return org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus.ENTEREDINERROR;
            case HEALTHUNKNOWN:
                return org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus.HEALTHUNKNOWN;
            default:
                return org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatus convertFamilyHistoryStatus(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PARTIAL:
                return org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatus.PARTIAL;
            case COMPLETED:
                return org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatus.ENTEREDINERROR;
            case HEALTHUNKNOWN:
                return org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatus.HEALTHUNKNOWN;
            default:
                return org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatus.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.FamilyMemberHistory convertFamilyMemberHistory(org.hl7.fhir.dstu2.model.FamilyMemberHistory src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.FamilyMemberHistory tgt = new org.hl7.fhir.r5.model.FamilyMemberHistory();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        tgt.setPatient(VersionConvertor_10_50.convertReference(src.getPatient()));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setStatus(convertFamilyHistoryStatus(src.getStatus()));
        tgt.setName(src.getName());
        tgt.setRelationship(VersionConvertor_10_50.convertCodeableConcept(src.getRelationship()));
        tgt.setBorn(VersionConvertor_10_50.convertType(src.getBorn()));
        tgt.setAge(VersionConvertor_10_50.convertType(src.getAge()));
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
        tgt.setPatient(VersionConvertor_10_50.convertReference(src.getPatient()));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setStatus(convertFamilyHistoryStatus(src.getStatus()));
        tgt.setName(src.getName());
        tgt.setRelationship(VersionConvertor_10_50.convertCodeableConcept(src.getRelationship()));
        tgt.setBorn(VersionConvertor_10_50.convertType(src.getBorn()));
        tgt.setAge(VersionConvertor_10_50.convertType(src.getAge()));
        tgt.setDeceased(VersionConvertor_10_50.convertType(src.getDeceased()));
        for (org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent t : src.getCondition()) tgt.addCondition(convertFamilyMemberHistoryConditionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent convertFamilyMemberHistoryConditionComponent(org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent tgt = new org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setCode(VersionConvertor_10_50.convertCodeableConcept(src.getCode()));
        tgt.setOutcome(VersionConvertor_10_50.convertCodeableConcept(src.getOutcome()));
        tgt.setOnset(VersionConvertor_10_50.convertType(src.getOnset()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent convertFamilyMemberHistoryConditionComponent(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent tgt = new org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setCode(VersionConvertor_10_50.convertCodeableConcept(src.getCode()));
        tgt.setOutcome(VersionConvertor_10_50.convertCodeableConcept(src.getOutcome()));
        tgt.setOnset(VersionConvertor_10_50.convertType(src.getOnset()));
        return tgt;
    }
}
