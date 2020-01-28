package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

public class FamilyMemberHistory30_50 {

    static public org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyHistoryStatus convertFamilyHistoryStatus(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus src) throws FHIRException {
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

    static public org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus convertFamilyHistoryStatus(org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyHistoryStatus src) throws FHIRException {
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

    public static org.hl7.fhir.dstu3.model.FamilyMemberHistory convertFamilyMemberHistory(org.hl7.fhir.r5.model.FamilyMemberHistory src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.FamilyMemberHistory tgt = new org.hl7.fhir.dstu3.model.FamilyMemberHistory();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesCanonical()) tgt.addDefinition(new org.hl7.fhir.dstu3.model.Reference(t.getValue()));
        if (src.hasStatus())
            tgt.setStatus(convertFamilyHistoryStatus(src.getStatus()));
        if (src.hasDataAbsentReason())
            tgt.setNotDoneReason(VersionConvertor_30_50.convertCodeableConcept(src.getDataAbsentReason()));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_30_50.convertReference(src.getPatient()));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasRelationship())
            tgt.setRelationship(VersionConvertor_30_50.convertCodeableConcept(src.getRelationship()));
        if (src.hasBorn())
            tgt.setBorn(VersionConvertor_30_50.convertType(src.getBorn()));
        if (src.hasAge())
            tgt.setAge(VersionConvertor_30_50.convertType(src.getAge()));
        if (src.hasEstimatedAge())
            tgt.setEstimatedAge(src.getEstimatedAge());
        if (src.hasDeceased())
            tgt.setDeceased(VersionConvertor_30_50.convertType(src.getDeceased()));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReasonCode(VersionConvertor_30_50.convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getReason()) if (t.hasReference())
            tgt.addReasonReference(VersionConvertor_30_50.convertReference(t.getReference()));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        for (org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent t : src.getCondition()) tgt.addCondition(convertFamilyMemberHistoryConditionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.FamilyMemberHistory convertFamilyMemberHistory(org.hl7.fhir.dstu3.model.FamilyMemberHistory src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.FamilyMemberHistory tgt = new org.hl7.fhir.r5.model.FamilyMemberHistory();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getDefinition()) tgt.addInstantiatesCanonical(t.getReference());
        if (src.hasStatus())
            tgt.setStatus(convertFamilyHistoryStatus(src.getStatus()));
        if (src.hasNotDoneReason())
            tgt.setDataAbsentReason(VersionConvertor_30_50.convertCodeableConcept(src.getNotDoneReason()));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_30_50.convertReference(src.getPatient()));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasRelationship())
            tgt.setRelationship(VersionConvertor_30_50.convertCodeableConcept(src.getRelationship()));
        if (src.hasBorn())
            tgt.setBorn(VersionConvertor_30_50.convertType(src.getBorn()));
        if (src.hasAge())
            tgt.setAge(VersionConvertor_30_50.convertType(src.getAge()));
        if (src.hasEstimatedAge())
            tgt.setEstimatedAge(src.getEstimatedAge());
        if (src.hasDeceased())
            tgt.setDeceased(VersionConvertor_30_50.convertType(src.getDeceased()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(VersionConvertor_30_50.convertCodeableConceptToCodableReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference()) tgt.addReason(VersionConvertor_30_50.convertReferenceToCodableReference(t));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        for (org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent t : src.getCondition()) tgt.addCondition(convertFamilyMemberHistoryConditionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent convertFamilyMemberHistoryConditionComponent(org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent tgt = new org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasOutcome())
            tgt.setOutcome(VersionConvertor_30_50.convertCodeableConcept(src.getOutcome()));
        if (src.hasOnset())
            tgt.setOnset(VersionConvertor_30_50.convertType(src.getOnset()));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent convertFamilyMemberHistoryConditionComponent(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent tgt = new org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasOutcome())
            tgt.setOutcome(VersionConvertor_30_50.convertCodeableConcept(src.getOutcome()));
        if (src.hasOnset())
            tgt.setOnset(VersionConvertor_30_50.convertType(src.getOnset()));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        return tgt;
    }
}
