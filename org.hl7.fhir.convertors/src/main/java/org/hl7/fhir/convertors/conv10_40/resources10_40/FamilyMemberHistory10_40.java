package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.conv10_40.VersionConvertor_10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Type10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.CodeableConcept10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Identifier10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.DateTime10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class FamilyMemberHistory10_40 {

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus> convertFamilyHistoryStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatusEnumFactory());
        Element10_40.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatus> convertFamilyHistoryStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyHistoryStatusEnumFactory());
        Element10_40.copyElement(src, tgt);
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

    public static org.hl7.fhir.r4.model.FamilyMemberHistory convertFamilyMemberHistory(org.hl7.fhir.dstu2.model.FamilyMemberHistory src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.FamilyMemberHistory tgt = new org.hl7.fhir.r4.model.FamilyMemberHistory();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
        if (src.hasPatient())
            tgt.setPatient(Reference10_40.convertReference(src.getPatient()));
        if (src.hasDate())
            tgt.setDateElement(DateTime10_40.convertDateTime(src.getDateElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertFamilyHistoryStatus(src.getStatusElement()));
        if (src.hasNameElement())
            tgt.setNameElement(String10_40.convertString(src.getNameElement()));
        if (src.hasRelationship())
            tgt.setRelationship(CodeableConcept10_40.convertCodeableConcept(src.getRelationship()));
        if (src.hasBorn())
            tgt.setBorn(Type10_40.convertType(src.getBorn()));
        if (src.hasAge())
            tgt.setAge(Type10_40.convertType(src.getAge()));
        if (src.hasDeceased())
            tgt.setDeceased(Type10_40.convertType(src.getDeceased()));
        for (org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent t : src.getCondition()) tgt.addCondition(convertFamilyMemberHistoryConditionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.FamilyMemberHistory convertFamilyMemberHistory(org.hl7.fhir.r4.model.FamilyMemberHistory src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.FamilyMemberHistory tgt = new org.hl7.fhir.dstu2.model.FamilyMemberHistory();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
        if (src.hasPatient())
            tgt.setPatient(Reference10_40.convertReference(src.getPatient()));
        if (src.hasDate())
            tgt.setDateElement(DateTime10_40.convertDateTime(src.getDateElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertFamilyHistoryStatus(src.getStatusElement()));
        if (src.hasNameElement())
            tgt.setNameElement(String10_40.convertString(src.getNameElement()));
        if (src.hasRelationship())
            tgt.setRelationship(CodeableConcept10_40.convertCodeableConcept(src.getRelationship()));
        if (src.hasBorn())
            tgt.setBorn(Type10_40.convertType(src.getBorn()));
        if (src.hasAge())
            tgt.setAge(Type10_40.convertType(src.getAge()));
        if (src.hasDeceased())
            tgt.setDeceased(Type10_40.convertType(src.getDeceased()));
        for (org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent t : src.getCondition()) tgt.addCondition(convertFamilyMemberHistoryConditionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent convertFamilyMemberHistoryConditionComponent(org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent tgt = new org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent();
        Element10_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(CodeableConcept10_40.convertCodeableConcept(src.getCode()));
        if (src.hasOutcome())
            tgt.setOutcome(CodeableConcept10_40.convertCodeableConcept(src.getOutcome()));
        if (src.hasOnset())
            tgt.setOnset(Type10_40.convertType(src.getOnset()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent convertFamilyMemberHistoryConditionComponent(org.hl7.fhir.dstu2.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent tgt = new org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent();
        Element10_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(CodeableConcept10_40.convertCodeableConcept(src.getCode()));
        if (src.hasOutcome())
            tgt.setOutcome(CodeableConcept10_40.convertCodeableConcept(src.getOutcome()));
        if (src.hasOnset())
            tgt.setOnset(Type10_40.convertType(src.getOnset()));
        return tgt;
    }
}