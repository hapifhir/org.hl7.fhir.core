package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class FamilyMemberHistory30_40 {

    static public org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyHistoryStatus convertFamilyHistoryStatus(org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus src) throws FHIRException {
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

    static public org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus convertFamilyHistoryStatus(org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyHistoryStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PARTIAL:
                return org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus.PARTIAL;
            case COMPLETED:
                return org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus.ENTEREDINERROR;
            case HEALTHUNKNOWN:
                return org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus.HEALTHUNKNOWN;
            default:
                return org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.FamilyMemberHistory convertFamilyMemberHistory(org.hl7.fhir.r4.model.FamilyMemberHistory src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.FamilyMemberHistory tgt = new org.hl7.fhir.dstu3.model.FamilyMemberHistory();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasInstantiatesCanonical()) {
            for (org.hl7.fhir.r4.model.UriType t : src.getInstantiatesCanonical()) tgt.addDefinition(new org.hl7.fhir.dstu3.model.Reference(t.getValue()));
        }
        if (src.hasStatus())
            tgt.setStatus(convertFamilyHistoryStatus(src.getStatus()));
        if (src.hasDataAbsentReason())
            tgt.setNotDoneReason(VersionConvertor_30_40.convertCodeableConcept(src.getDataAbsentReason()));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_30_40.convertReference(src.getPatient()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasRelationship())
            tgt.setRelationship(VersionConvertor_30_40.convertCodeableConcept(src.getRelationship()));
        if (src.hasBorn())
            tgt.setBorn(VersionConvertor_30_40.convertType(src.getBorn()));
        if (src.hasAge())
            tgt.setAge(VersionConvertor_30_40.convertType(src.getAge()));
        if (src.hasEstimatedAgeElement())
            tgt.setEstimatedAgeElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getEstimatedAgeElement()));
        if (src.hasDeceased())
            tgt.setDeceased(VersionConvertor_30_40.convertType(src.getDeceased()));
        if (src.hasReasonCode()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasReasonReference()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) tgt.addReasonReference(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        }
        if (src.hasCondition()) {
            for (org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent t : src.getCondition()) tgt.addCondition(convertFamilyMemberHistoryConditionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.FamilyMemberHistory convertFamilyMemberHistory(org.hl7.fhir.dstu3.model.FamilyMemberHistory src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.FamilyMemberHistory tgt = new org.hl7.fhir.r4.model.FamilyMemberHistory();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasDefinition()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getDefinition()) tgt.addInstantiatesCanonical(t.getReference());
        }
        if (src.hasStatus())
            tgt.setStatus(convertFamilyHistoryStatus(src.getStatus()));
        if (src.hasNotDoneReason())
            tgt.setDataAbsentReason(VersionConvertor_30_40.convertCodeableConcept(src.getNotDoneReason()));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_30_40.convertReference(src.getPatient()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasRelationship())
            tgt.setRelationship(VersionConvertor_30_40.convertCodeableConcept(src.getRelationship()));
        if (src.hasBorn())
            tgt.setBorn(VersionConvertor_30_40.convertType(src.getBorn()));
        if (src.hasAge())
            tgt.setAge(VersionConvertor_30_40.convertType(src.getAge()));
        if (src.hasEstimatedAgeElement())
            tgt.setEstimatedAgeElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getEstimatedAgeElement()));
        if (src.hasDeceased())
            tgt.setDeceased(VersionConvertor_30_40.convertType(src.getDeceased()));
        if (src.hasReasonCode()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasReasonReference()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference()) tgt.addReasonReference(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        }
        if (src.hasCondition()) {
            for (org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent t : src.getCondition()) tgt.addCondition(convertFamilyMemberHistoryConditionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent convertFamilyMemberHistoryConditionComponent(org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent tgt = new org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        if (src.hasOutcome())
            tgt.setOutcome(VersionConvertor_30_40.convertCodeableConcept(src.getOutcome()));
        if (src.hasOnset())
            tgt.setOnset(VersionConvertor_30_40.convertType(src.getOnset()));
        if (src.hasNote()) {
            for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent convertFamilyMemberHistoryConditionComponent(org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent tgt = new org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        if (src.hasOutcome())
            tgt.setOutcome(VersionConvertor_30_40.convertCodeableConcept(src.getOutcome()));
        if (src.hasOnset())
            tgt.setOnset(VersionConvertor_30_40.convertType(src.getOnset()));
        if (src.hasNote()) {
            for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        }
        return tgt;
    }
}
