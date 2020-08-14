package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class FamilyMemberHistory30_40 {

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyHistoryStatus> convertFamilyHistoryStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyHistoryStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyHistoryStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus> convertFamilyHistoryStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyHistoryStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PARTIAL:
                tgt.setValue(org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus.PARTIAL);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus.ENTEREDINERROR);
                break;
            case HEALTHUNKNOWN:
                tgt.setValue(org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus.HEALTHUNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.FamilyMemberHistory convertFamilyMemberHistory(org.hl7.fhir.r4.model.FamilyMemberHistory src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.FamilyMemberHistory tgt = new org.hl7.fhir.dstu3.model.FamilyMemberHistory();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        for (org.hl7.fhir.r4.model.UriType t : src.getInstantiatesCanonical()) tgt.addDefinition(new org.hl7.fhir.dstu3.model.Reference(t.getValue()));
        if (src.hasStatus())
            tgt.setStatusElement(convertFamilyHistoryStatus(src.getStatusElement()));
        if (src.hasDataAbsentReason())
            tgt.setNotDoneReason(VersionConvertor_30_40.convertCodeableConcept(src.getDataAbsentReason()));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_30_40.convertReference(src.getPatient()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_40.convertString(src.getNameElement()));
        if (src.hasRelationship())
            tgt.setRelationship(VersionConvertor_30_40.convertCodeableConcept(src.getRelationship()));
        if (src.hasBorn())
            tgt.setBorn(VersionConvertor_30_40.convertType(src.getBorn()));
        if (src.hasAge())
            tgt.setAge(VersionConvertor_30_40.convertType(src.getAge()));
        if (src.hasEstimatedAge())
            tgt.setEstimatedAgeElement(VersionConvertor_30_40.convertBoolean(src.getEstimatedAgeElement()));
        if (src.hasDeceased())
            tgt.setDeceased(VersionConvertor_30_40.convertType(src.getDeceased()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) tgt.addReasonReference(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        for (org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent t : src.getCondition()) tgt.addCondition(convertFamilyMemberHistoryConditionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.FamilyMemberHistory convertFamilyMemberHistory(org.hl7.fhir.dstu3.model.FamilyMemberHistory src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.FamilyMemberHistory tgt = new org.hl7.fhir.r4.model.FamilyMemberHistory();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getDefinition()) tgt.addInstantiatesCanonical(t.getReference());
        if (src.hasStatus())
            tgt.setStatusElement(convertFamilyHistoryStatus(src.getStatusElement()));
        if (src.hasNotDoneReason())
            tgt.setDataAbsentReason(VersionConvertor_30_40.convertCodeableConcept(src.getNotDoneReason()));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_30_40.convertReference(src.getPatient()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_40.convertString(src.getNameElement()));
        if (src.hasRelationship())
            tgt.setRelationship(VersionConvertor_30_40.convertCodeableConcept(src.getRelationship()));
        if (src.hasBorn())
            tgt.setBorn(VersionConvertor_30_40.convertType(src.getBorn()));
        if (src.hasAge())
            tgt.setAge(VersionConvertor_30_40.convertType(src.getAge()));
        if (src.hasEstimatedAge())
            tgt.setEstimatedAgeElement(VersionConvertor_30_40.convertBoolean(src.getEstimatedAgeElement()));
        if (src.hasDeceased())
            tgt.setDeceased(VersionConvertor_30_40.convertType(src.getDeceased()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference()) tgt.addReasonReference(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        for (org.hl7.fhir.dstu3.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent t : src.getCondition()) tgt.addCondition(convertFamilyMemberHistoryConditionComponent(t));
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
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
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
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        return tgt;
    }
}