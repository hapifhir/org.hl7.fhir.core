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
            tgt.setStatusElement(convertEpisodeOfCareStatus(src.getStatusElement()));
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
            tgt.setStatusElement(convertEpisodeOfCareStatus(src.getStatusElement()));
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus> convertEpisodeOfCareStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PLANNED:
                tgt.setValue(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.PLANNED);
                break;
            case WAITLIST:
                tgt.setValue(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.WAITLIST);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.ACTIVE);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.ONHOLD);
                break;
            case FINISHED:
                tgt.setValue(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.FINISHED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.CANCELLED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatus> convertEpisodeOfCareStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PLANNED:
                tgt.setValue(org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatus.PLANNED);
                break;
            case WAITLIST:
                tgt.setValue(org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatus.WAITLIST);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatus.ACTIVE);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatus.ONHOLD);
                break;
            case FINISHED:
                tgt.setValue(org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatus.FINISHED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatus.CANCELLED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent convertEpisodeOfCareStatusHistoryComponent(org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent tgt = new org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasStatus())
            tgt.setStatusElement(convertEpisodeOfCareStatus(src.getStatusElement()));
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
            tgt.setStatusElement(convertEpisodeOfCareStatus(src.getStatusElement()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        return tgt;
    }
}