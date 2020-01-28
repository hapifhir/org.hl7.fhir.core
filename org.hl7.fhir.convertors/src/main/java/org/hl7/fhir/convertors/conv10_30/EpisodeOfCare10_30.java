package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class EpisodeOfCare10_30 {

    public static org.hl7.fhir.dstu3.model.EpisodeOfCare convertEpisodeOfCare(org.hl7.fhir.dstu2.model.EpisodeOfCare src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.EpisodeOfCare tgt = new org.hl7.fhir.dstu3.model.EpisodeOfCare();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        tgt.setStatus(convertEpisodeOfCareStatus(src.getStatus()));
        for (org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent t : src.getStatusHistory()) tgt.addStatusHistory(convertEpisodeOfCareStatusHistoryComponent(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_10_30.convertCodeableConcept(t));
        tgt.setPatient(VersionConvertor_10_30.convertReference(src.getPatient()));
        tgt.setManagingOrganization(VersionConvertor_10_30.convertReference(src.getManagingOrganization()));
        tgt.setPeriod(VersionConvertor_10_30.convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getReferralRequest()) tgt.addReferralRequest(VersionConvertor_10_30.convertReference(t));
        tgt.setCareManager(VersionConvertor_10_30.convertReference(src.getCareManager()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.EpisodeOfCare convertEpisodeOfCare(org.hl7.fhir.dstu3.model.EpisodeOfCare src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.EpisodeOfCare tgt = new org.hl7.fhir.dstu2.model.EpisodeOfCare();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        tgt.setStatus(convertEpisodeOfCareStatus(src.getStatus()));
        for (org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent t : src.getStatusHistory()) tgt.addStatusHistory(convertEpisodeOfCareStatusHistoryComponent(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_10_30.convertCodeableConcept(t));
        tgt.setPatient(VersionConvertor_10_30.convertReference(src.getPatient()));
        tgt.setManagingOrganization(VersionConvertor_10_30.convertReference(src.getManagingOrganization()));
        tgt.setPeriod(VersionConvertor_10_30.convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getReferralRequest()) tgt.addReferralRequest(VersionConvertor_10_30.convertReference(t));
        tgt.setCareManager(VersionConvertor_10_30.convertReference(src.getCareManager()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatus convertEpisodeOfCareStatus(org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PLANNED:
                return org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatus.PLANNED;
            case WAITLIST:
                return org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatus.WAITLIST;
            case ACTIVE:
                return org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatus.ACTIVE;
            case ONHOLD:
                return org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatus.ONHOLD;
            case FINISHED:
                return org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatus.FINISHED;
            case CANCELLED:
                return org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatus.CANCELLED;
            default:
                return org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatus convertEpisodeOfCareStatus(org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatus src) throws FHIRException {
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
            default:
                return org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent convertEpisodeOfCareStatusHistoryComponent(org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent tgt = new org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setStatus(convertEpisodeOfCareStatus(src.getStatus()));
        tgt.setPeriod(VersionConvertor_10_30.convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent convertEpisodeOfCareStatusHistoryComponent(org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent tgt = new org.hl7.fhir.dstu3.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setStatus(convertEpisodeOfCareStatus(src.getStatus()));
        tgt.setPeriod(VersionConvertor_10_30.convertPeriod(src.getPeriod()));
        return tgt;
    }
}
