package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

public class CareTeam30_50 {

    public static org.hl7.fhir.r5.model.CareTeam convertCareTeam(org.hl7.fhir.dstu3.model.CareTeam src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CareTeam tgt = new org.hl7.fhir.r5.model.CareTeam();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatus(convertCareTeamStatus(src.getStatus()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_50.convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.dstu3.model.CareTeam.CareTeamParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertCareTeamParticipantComponent(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(VersionConvertor_30_50.convertCodeableConceptToCodableReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference()) tgt.addReason(VersionConvertor_30_50.convertReferenceToCodableReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getManagingOrganization()) tgt.addManagingOrganization(VersionConvertor_30_50.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CareTeam convertCareTeam(org.hl7.fhir.r5.model.CareTeam src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CareTeam tgt = new org.hl7.fhir.dstu3.model.CareTeam();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatus(convertCareTeamStatus(src.getStatus()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_50.convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.r5.model.CareTeam.CareTeamParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertCareTeamParticipantComponent(t));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReasonCode(VersionConvertor_30_50.convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getReason()) if (t.hasReference())
            tgt.addReasonReference(VersionConvertor_30_50.convertReference(t.getReference()));
        for (org.hl7.fhir.r5.model.Reference t : src.getManagingOrganization()) tgt.addManagingOrganization(VersionConvertor_30_50.convertReference(t));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CareTeam.CareTeamParticipantComponent convertCareTeamParticipantComponent(org.hl7.fhir.r5.model.CareTeam.CareTeamParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CareTeam.CareTeamParticipantComponent tgt = new org.hl7.fhir.dstu3.model.CareTeam.CareTeamParticipantComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasRole())
            tgt.setRole(VersionConvertor_30_50.convertCodeableConcept(src.getRole()));
        if (src.hasMember())
            tgt.setMember(VersionConvertor_30_50.convertReference(src.getMember()));
        if (src.hasOnBehalfOf())
            tgt.setOnBehalfOf(VersionConvertor_30_50.convertReference(src.getOnBehalfOf()));
        if (src.hasCoveragePeriod())
            tgt.setPeriod(VersionConvertor_30_50.convertPeriod(src.getCoveragePeriod()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CareTeam.CareTeamParticipantComponent convertCareTeamParticipantComponent(org.hl7.fhir.dstu3.model.CareTeam.CareTeamParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CareTeam.CareTeamParticipantComponent tgt = new org.hl7.fhir.r5.model.CareTeam.CareTeamParticipantComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasRole())
            tgt.setRole(VersionConvertor_30_50.convertCodeableConcept(src.getRole()));
        if (src.hasMember())
            tgt.setMember(VersionConvertor_30_50.convertReference(src.getMember()));
        if (src.hasOnBehalfOf())
            tgt.setOnBehalfOf(VersionConvertor_30_50.convertReference(src.getOnBehalfOf()));
        if (src.hasPeriod())
            tgt.setCoverage(VersionConvertor_30_50.convertPeriod(src.getPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus convertCareTeamStatus(org.hl7.fhir.r5.model.CareTeam.CareTeamStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PROPOSED:
                return org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus.PROPOSED;
            case ACTIVE:
                return org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus.ACTIVE;
            case SUSPENDED:
                return org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus.SUSPENDED;
            case INACTIVE:
                return org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus.INACTIVE;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.CareTeam.CareTeamStatus convertCareTeamStatus(org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PROPOSED:
                return org.hl7.fhir.r5.model.CareTeam.CareTeamStatus.PROPOSED;
            case ACTIVE:
                return org.hl7.fhir.r5.model.CareTeam.CareTeamStatus.ACTIVE;
            case SUSPENDED:
                return org.hl7.fhir.r5.model.CareTeam.CareTeamStatus.SUSPENDED;
            case INACTIVE:
                return org.hl7.fhir.r5.model.CareTeam.CareTeamStatus.INACTIVE;
            case ENTEREDINERROR:
                return org.hl7.fhir.r5.model.CareTeam.CareTeamStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r5.model.CareTeam.CareTeamStatus.NULL;
        }
    }
}
