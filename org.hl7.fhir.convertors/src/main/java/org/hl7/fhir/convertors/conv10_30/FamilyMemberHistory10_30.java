package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class FamilyMemberHistory10_30 {

    public static org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyHistoryStatus convertFamilyHistoryStatus(org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PARTIAL:
                return org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyHistoryStatus.PARTIAL;
            case COMPLETED:
                return org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyHistoryStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyHistoryStatus.ENTEREDINERROR;
            case HEALTHUNKNOWN:
                return org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyHistoryStatus.HEALTHUNKNOWN;
            default:
                return org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyHistoryStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatus convertFamilyHistoryStatus(org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyHistoryStatus src) throws FHIRException {
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

    public static org.hl7.fhir.dstu3.model.FamilyMemberHistory convertFamilyMemberHistory(org.hl7.fhir.dstu2.model.FamilyMemberHistory src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.FamilyMemberHistory tgt = new org.hl7.fhir.dstu3.model.FamilyMemberHistory();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasPatient()) {
            tgt.setPatient(VersionConvertor_10_30.convertReference(src.getPatient()));
        }
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu3.model.DateTimeType) VersionConvertor_10_30.convertType(src.getDateElement()));
        if (src.hasStatus()) {
            tgt.setStatus(convertFamilyHistoryStatus(src.getStatus()));
        }
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasRelationship()) {
            tgt.setRelationship(VersionConvertor_10_30.convertCodeableConcept(src.getRelationship()));
        }
        if (src.hasGender()) {
            tgt.setGender(VersionConvertor_10_30.convertAdministrativeGender(src.getGender()));
        }
        if (src.hasBorn()) {
            tgt.setBorn(VersionConvertor_10_30.convertType(src.getBorn()));
        }
        if (src.hasAge()) {
            tgt.setAge(VersionConvertor_10_30.convertType(src.getAge()));
        }
        if (src.hasDeceased()) {
            tgt.setDeceased(VersionConvertor_10_30.convertType(src.getDeceased()));
        }
        if (src.hasCondition()) {
            for (org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent t : src.getCondition()) tgt.addCondition(convertFamilyMemberHistoryConditionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.FamilyMemberHistory convertFamilyMemberHistory(org.hl7.fhir.dstu3.model.FamilyMemberHistory src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.FamilyMemberHistory tgt = new org.hl7.fhir.dstu2.model.FamilyMemberHistory();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasPatient()) {
            tgt.setPatient(VersionConvertor_10_30.convertReference(src.getPatient()));
        }
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu2.model.DateTimeType) VersionConvertor_10_30.convertType(src.getDateElement()));
        if (src.hasStatus()) {
            tgt.setStatus(convertFamilyHistoryStatus(src.getStatus()));
        }
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasRelationship()) {
            tgt.setRelationship(VersionConvertor_10_30.convertCodeableConcept(src.getRelationship()));
        }
        if (src.hasGender()) {
            tgt.setGender(VersionConvertor_10_30.convertAdministrativeGender(src.getGender()));
        }
        if (src.hasBorn()) {
            tgt.setBorn(VersionConvertor_10_30.convertType(src.getBorn()));
        }
        if (src.hasAge()) {
            tgt.setAge(VersionConvertor_10_30.convertType(src.getAge()));
        }
        if (src.hasDeceased()) {
            tgt.setDeceased(VersionConvertor_10_30.convertType(src.getDeceased()));
        }
        if (src.hasCondition()) {
            for (org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent t : src.getCondition()) tgt.addCondition(convertFamilyMemberHistoryConditionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent convertFamilyMemberHistoryConditionComponent(org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent tgt = new org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasCode()) {
            tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        }
        if (src.hasOutcome()) {
            tgt.setOutcome(VersionConvertor_10_30.convertCodeableConcept(src.getOutcome()));
        }
        if (src.hasOnset()) {
            tgt.setOnset(VersionConvertor_10_30.convertType(src.getOnset()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent convertFamilyMemberHistoryConditionComponent(org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent tgt = new org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasCode()) {
            tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        }
        if (src.hasOutcome()) {
            tgt.setOutcome(VersionConvertor_10_30.convertCodeableConcept(src.getOutcome()));
        }
        if (src.hasOnset()) {
            tgt.setOnset(VersionConvertor_10_30.convertType(src.getOnset()));
        }
        return tgt;
    }
}
