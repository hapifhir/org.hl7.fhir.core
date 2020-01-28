package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class ProcedureRequest10_30 {

    public static org.hl7.fhir.dstu3.model.ProcedureRequest convertProcedureRequest(org.hl7.fhir.dstu2.model.ProcedureRequest src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ProcedureRequest tgt = new org.hl7.fhir.dstu3.model.ProcedureRequest();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getBodySite()) tgt.addBodySite(VersionConvertor_10_30.convertCodeableConcept(t));
        if (src.hasReasonCodeableConcept())
            tgt.addReasonCode(VersionConvertor_10_30.convertCodeableConcept(src.getReasonCodeableConcept()));
        tgt.setOccurrence(VersionConvertor_10_30.convertType(src.getScheduled()));
        tgt.setContext(VersionConvertor_10_30.convertReference(src.getEncounter()));
        tgt.setPerformer(VersionConvertor_10_30.convertReference(src.getPerformer()));
        tgt.setStatus(convertProcedureRequestStatus(src.getStatus()));
        tgt.setAsNeeded(VersionConvertor_10_30.convertType(src.getAsNeeded()));
        tgt.setAuthoredOn(src.getOrderedOn());
        tgt.setPriority(convertProcedureRequestPriority(src.getPriority()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ProcedureRequest convertProcedureRequest(org.hl7.fhir.dstu3.model.ProcedureRequest src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ProcedureRequest tgt = new org.hl7.fhir.dstu2.model.ProcedureRequest();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getBodySite()) tgt.addBodySite(VersionConvertor_10_30.convertCodeableConcept(t));
        tgt.setReason(VersionConvertor_10_30.convertType(src.getReasonCodeFirstRep()));
        tgt.setScheduled(VersionConvertor_10_30.convertType(src.getOccurrence()));
        tgt.setEncounter(VersionConvertor_10_30.convertReference(src.getContext()));
        tgt.setPerformer(VersionConvertor_10_30.convertReference(src.getPerformer()));
        tgt.setStatus(convertProcedureRequestStatus(src.getStatus()));
        tgt.setAsNeeded(VersionConvertor_10_30.convertType(src.getAsNeeded()));
        tgt.setOrderedOn(src.getAuthoredOn());
        tgt.setPriority(convertProcedureRequestPriority(src.getPriority()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority convertProcedureRequestPriority(org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestPriority src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ROUTINE:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority.ROUTINE;
            case URGENT:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority.URGENT;
            case STAT:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority.STAT;
            case ASAP:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority.ASAP;
            default:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestPriority convertProcedureRequestPriority(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ROUTINE:
                return org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestPriority.ROUTINE;
            case URGENT:
                return org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestPriority.URGENT;
            case STAT:
                return org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestPriority.STAT;
            case ASAP:
                return org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestPriority.ASAP;
            default:
                return org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestPriority.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestStatus convertProcedureRequestStatus(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DRAFT:
                return org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestStatus.DRAFT;
            case ACTIVE:
                return org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestStatus.INPROGRESS;
            case COMPLETED:
                return org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestStatus.COMPLETED;
            case SUSPENDED:
                return org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestStatus.SUSPENDED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestStatus.ABORTED;
            default:
                return org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus convertProcedureRequestStatus(org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PROPOSED:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.DRAFT;
            case DRAFT:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.DRAFT;
            case REQUESTED:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.ACTIVE;
            case RECEIVED:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.ACTIVE;
            case ACCEPTED:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.ACTIVE;
            case INPROGRESS:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.ACTIVE;
            case COMPLETED:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.COMPLETED;
            case SUSPENDED:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.SUSPENDED;
            case ABORTED:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.NULL;
        }
    }
}
