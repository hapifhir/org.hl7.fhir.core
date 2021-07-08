package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.conv30_50.VersionConvertor_30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Element30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Annotation30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Period30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

public class CareTeam30_50 {

    public static org.hl7.fhir.r5.model.CareTeam convertCareTeam(org.hl7.fhir.dstu3.model.CareTeam src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CareTeam tgt = new org.hl7.fhir.r5.model.CareTeam();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertCareTeamStatus(src.getStatusElement()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory()) tgt.addCategory(CodeableConcept30_50.convertCodeableConcept(t));
        if (src.hasName())
            tgt.setNameElement(String30_50.convertString(src.getNameElement()));
        if (src.hasSubject())
            tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
        if (src.hasPeriod())
            tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.dstu3.model.CareTeam.CareTeamParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertCareTeamParticipantComponent(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(Reference30_50.convertCodeableConceptToCodableReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference()) tgt.addReason(Reference30_50.convertReferenceToCodableReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getManagingOrganization()) tgt.addManagingOrganization(Reference30_50.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_50.convertAnnotation(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CareTeam convertCareTeam(org.hl7.fhir.r5.model.CareTeam src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CareTeam tgt = new org.hl7.fhir.dstu3.model.CareTeam();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertCareTeamStatus(src.getStatusElement()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory()) tgt.addCategory(CodeableConcept30_50.convertCodeableConcept(t));
        if (src.hasName())
            tgt.setNameElement(String30_50.convertString(src.getNameElement()));
        if (src.hasSubject())
            tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
        if (src.hasPeriod())
            tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.r5.model.CareTeam.CareTeamParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertCareTeamParticipantComponent(t));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReasonCode(CodeableConcept30_50.convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getReason()) if (t.hasReference())
            tgt.addReasonReference(Reference30_50.convertReference(t.getReference()));
        for (org.hl7.fhir.r5.model.Reference t : src.getManagingOrganization()) tgt.addManagingOrganization(Reference30_50.convertReference(t));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_50.convertAnnotation(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CareTeam.CareTeamParticipantComponent convertCareTeamParticipantComponent(org.hl7.fhir.r5.model.CareTeam.CareTeamParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CareTeam.CareTeamParticipantComponent tgt = new org.hl7.fhir.dstu3.model.CareTeam.CareTeamParticipantComponent();
        Element30_50.copyElement(src, tgt);
        if (src.hasRole())
            tgt.setRole(CodeableConcept30_50.convertCodeableConcept(src.getRole()));
        if (src.hasMember())
            tgt.setMember(Reference30_50.convertReference(src.getMember()));
        if (src.hasOnBehalfOf())
            tgt.setOnBehalfOf(Reference30_50.convertReference(src.getOnBehalfOf()));
        if (src.hasCoveragePeriod())
            tgt.setPeriod(Period30_50.convertPeriod(src.getCoveragePeriod()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CareTeam.CareTeamParticipantComponent convertCareTeamParticipantComponent(org.hl7.fhir.dstu3.model.CareTeam.CareTeamParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CareTeam.CareTeamParticipantComponent tgt = new org.hl7.fhir.r5.model.CareTeam.CareTeamParticipantComponent();
        Element30_50.copyElement(src, tgt);
        if (src.hasRole())
            tgt.setRole(CodeableConcept30_50.convertCodeableConcept(src.getRole()));
        if (src.hasMember())
            tgt.setMember(Reference30_50.convertReference(src.getMember()));
        if (src.hasOnBehalfOf())
            tgt.setOnBehalfOf(Reference30_50.convertReference(src.getOnBehalfOf()));
        if (src.hasPeriod())
            tgt.setCoverage(Period30_50.convertPeriod(src.getPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus> convertCareTeamStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CareTeam.CareTeamStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatusEnumFactory());
        Element30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PROPOSED:
                tgt.setValue(org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus.PROPOSED);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus.ACTIVE);
                break;
            case SUSPENDED:
                tgt.setValue(org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus.SUSPENDED);
                break;
            case INACTIVE:
                tgt.setValue(org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus.INACTIVE);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CareTeam.CareTeamStatus> convertCareTeamStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CareTeam.CareTeamStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CareTeam.CareTeamStatusEnumFactory());
        Element30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PROPOSED:
                tgt.setValue(org.hl7.fhir.r5.model.CareTeam.CareTeamStatus.PROPOSED);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r5.model.CareTeam.CareTeamStatus.ACTIVE);
                break;
            case SUSPENDED:
                tgt.setValue(org.hl7.fhir.r5.model.CareTeam.CareTeamStatus.SUSPENDED);
                break;
            case INACTIVE:
                tgt.setValue(org.hl7.fhir.r5.model.CareTeam.CareTeamStatus.INACTIVE);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.CareTeam.CareTeamStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.CareTeam.CareTeamStatus.NULL);
                break;
        }
        return tgt;
    }
}