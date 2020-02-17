package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class EpisodeOfCare30_40 {

    public static org.hl7.fhir.r4.model.EpisodeOfCare convertEpisodeOfCare(org.hl7.fhir.dstu3.model.EpisodeOfCare src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.EpisodeOfCare tgt = new org.hl7.fhir.r4.model.EpisodeOfCare();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatus(convertEpisodeOfCareStatus(src.getStatus()));
        for (org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent t : src.getStatusHistory()) tgt.addStatusHistory(convertEpisodeOfCareStatusHistoryComponent(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.EpisodeOfCare.DiagnosisComponent t : src.getDiagnosis()) tgt.addDiagnosis(VersionConvertor_30_40.convertDiagnosisComponent(t));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_30_40.convertReference(src.getPatient()));
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(VersionConvertor_30_40.convertReference(src.getManagingOrganization()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getReferralRequest()) tgt.addReferralRequest(VersionConvertor_30_40.convertReference(t));
        if (src.hasCareManager())
            tgt.setCareManager(VersionConvertor_30_40.convertReference(src.getCareManager()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getTeam()) tgt.addTeam(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getAccount()) tgt.addAccount(VersionConvertor_30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.EpisodeOfCare convertEpisodeOfCare(org.hl7.fhir.r4.model.EpisodeOfCare src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.EpisodeOfCare tgt = new org.hl7.fhir.dstu3.model.EpisodeOfCare();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatus(convertEpisodeOfCareStatus(src.getStatus()));
        for (org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent t : src.getStatusHistory()) tgt.addStatusHistory(convertEpisodeOfCareStatusHistoryComponent(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.EpisodeOfCare.DiagnosisComponent t : src.getDiagnosis()) tgt.addDiagnosis(VersionConvertor_30_40.convertDiagnosisComponent(t));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_30_40.convertReference(src.getPatient()));
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(VersionConvertor_30_40.convertReference(src.getManagingOrganization()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.r4.model.Reference t : src.getReferralRequest()) tgt.addReferralRequest(VersionConvertor_30_40.convertReference(t));
        if (src.hasCareManager())
            tgt.setCareManager(VersionConvertor_30_40.convertReference(src.getCareManager()));
        for (org.hl7.fhir.r4.model.Reference t : src.getTeam()) tgt.addTeam(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getAccount()) tgt.addAccount(VersionConvertor_30_40.convertReference(t));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus convertEpisodeOfCareStatus(org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PLANNED:
                return org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.PLANNED;
            case WAITLIST:
                return org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.WAITLIST;
            case ACTIVE:
                return org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.ACTIVE;
            case ONHOLD:
                return org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.ONHOLD;
            case FINISHED:
                return org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.FINISHED;
            case CANCELLED:
                return org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.CANCELLED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatus convertEpisodeOfCareStatus(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PLANNED:
                return org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatus.PLANNED;
            case WAITLIST:
                return org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatus.WAITLIST;
            case ACTIVE:
                return org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatus.ACTIVE;
            case ONHOLD:
                return org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatus.ONHOLD;
            case FINISHED:
                return org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatus.FINISHED;
            case CANCELLED:
                return org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatus.CANCELLED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatus.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent convertEpisodeOfCareStatusHistoryComponent(org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent tgt = new org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasStatus())
            tgt.setStatus(convertEpisodeOfCareStatus(src.getStatus()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent convertEpisodeOfCareStatusHistoryComponent(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent tgt = new org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasStatus())
            tgt.setStatus(convertEpisodeOfCareStatus(src.getStatus()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        return tgt;
    }
}
