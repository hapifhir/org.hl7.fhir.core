package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class EpisodeOfCare10_50 {

    public static org.hl7.fhir.dstu2.model.EpisodeOfCare convertEpisodeOfCare(org.hl7.fhir.r5.model.EpisodeOfCare src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.EpisodeOfCare tgt = new org.hl7.fhir.dstu2.model.EpisodeOfCare();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertEpisodeOfCareStatus(src.getStatus()));
        }
        if (src.hasStatusHistory()) {
            for (org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent t : src.getStatusHistory()) tgt.addStatusHistory(convertEpisodeOfCareStatusHistoryComponent(t));
        }
        if (src.hasType()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_10_50.convertCodeableConcept(t));
        }
        if (src.hasPatient()) {
            tgt.setPatient(VersionConvertor_10_50.convertReference(src.getPatient()));
        }
        if (src.hasManagingOrganization()) {
            tgt.setManagingOrganization(VersionConvertor_10_50.convertReference(src.getManagingOrganization()));
        }
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_10_50.convertPeriod(src.getPeriod()));
        }
        if (src.hasReferralRequest()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getReferralRequest()) tgt.addReferralRequest(VersionConvertor_10_50.convertReference(t));
        }
        if (src.hasCareManager()) {
            tgt.setCareManager(VersionConvertor_10_50.convertReference(src.getCareManager()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.EpisodeOfCare convertEpisodeOfCare(org.hl7.fhir.dstu2.model.EpisodeOfCare src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.EpisodeOfCare tgt = new org.hl7.fhir.r5.model.EpisodeOfCare();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertEpisodeOfCareStatus(src.getStatus()));
        }
        if (src.hasStatusHistory()) {
            for (org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent t : src.getStatusHistory()) tgt.addStatusHistory(convertEpisodeOfCareStatusHistoryComponent(t));
        }
        if (src.hasType()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_10_50.convertCodeableConcept(t));
        }
        if (src.hasPatient()) {
            tgt.setPatient(VersionConvertor_10_50.convertReference(src.getPatient()));
        }
        if (src.hasManagingOrganization()) {
            tgt.setManagingOrganization(VersionConvertor_10_50.convertReference(src.getManagingOrganization()));
        }
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_10_50.convertPeriod(src.getPeriod()));
        }
        if (src.hasReferralRequest()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getReferralRequest()) tgt.addReferralRequest(VersionConvertor_10_50.convertReference(t));
        }
        if (src.hasCareManager()) {
            tgt.setCareManager(VersionConvertor_10_50.convertReference(src.getCareManager()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus convertEpisodeOfCareStatus(org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PLANNED:
                return org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus.PLANNED;
            case WAITLIST:
                return org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus.WAITLIST;
            case ACTIVE:
                return org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus.ACTIVE;
            case ONHOLD:
                return org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus.ONHOLD;
            case FINISHED:
                return org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus.FINISHED;
            case CANCELLED:
                return org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus.CANCELLED;
            default:
                return org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatus convertEpisodeOfCareStatus(org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus src) throws FHIRException {
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

    public static org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent convertEpisodeOfCareStatusHistoryComponent(org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent tgt = new org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasStatus()) {
            tgt.setStatus(convertEpisodeOfCareStatus(src.getStatus()));
        }
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_10_50.convertPeriod(src.getPeriod()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent convertEpisodeOfCareStatusHistoryComponent(org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent tgt = new org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasStatus()) {
            tgt.setStatus(convertEpisodeOfCareStatus(src.getStatus()));
        }
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_10_50.convertPeriod(src.getPeriod()));
        }
        return tgt;
    }
}
