package org.hl7.fhir.convertors.conv30_40;

import java.util.List;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Reference;

public class ProcedureRequest30_40 {

    static public org.hl7.fhir.r4.model.ServiceRequest convertProcedureRequest(org.hl7.fhir.dstu3.model.ProcedureRequest src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ServiceRequest tgt = new org.hl7.fhir.r4.model.ServiceRequest();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) {
            tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) {
            tgt.addBasedOn(VersionConvertor_30_40.convertReference(t));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getReplaces()) {
            tgt.addReplaces(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasRequisition()) {
            if (src.hasRequisition())
                tgt.setRequisition(VersionConvertor_30_40.convertIdentifier(src.getRequisition()));
        }
        if (src.hasStatus()) {
            if (src.hasStatus())
                tgt.setStatus(convertProcedureRequestStatus(src.getStatus()));
        }
        if (src.hasIntent()) {
            if (src.hasIntent())
                tgt.setIntent(convertProcedureRequestIntent(src.getIntent()));
        }
        if (src.hasPriority()) {
            if (src.hasPriority())
                tgt.setPriority(convertProcedureRequestPriority(src.getPriority()));
        }
        if (src.hasDoNotPerform()) {
            if (src.hasDoNotPerformElement())
                tgt.setDoNotPerformElement(VersionConvertor_30_40.convertBoolean(src.getDoNotPerformElement()));
        }
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory()) {
            tgt.addCategory(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasCode()) {
            if (src.hasCode())
                tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        }
        if (src.hasSubject()) {
            if (src.hasSubject())
                tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        }
        if (src.hasContext()) {
            if (src.hasContext())
                tgt.setEncounter(VersionConvertor_30_40.convertReference(src.getContext()));
        }
        if (src.hasOccurrence()) {
            if (src.hasOccurrence())
                tgt.setOccurrence(VersionConvertor_30_40.convertType(src.getOccurrence()));
        }
        if (src.hasAsNeeded()) {
            if (src.hasAsNeeded())
                tgt.setAsNeeded(VersionConvertor_30_40.convertType(src.getAsNeeded()));
        }
        if (src.hasAuthoredOn()) {
            if (src.hasAuthoredOnElement())
                tgt.setAuthoredOnElement(VersionConvertor_30_40.convertDateTime(src.getAuthoredOnElement()));
        }
        if (src.hasRequester()) {
            org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestRequesterComponent requester = src.getRequester();
            if (requester.hasAgent()) {
                tgt.setRequester(VersionConvertor_30_40.convertReference(requester.getAgent()));
            }
        }
        if (src.hasPerformerType()) {
            if (src.hasPerformerType())
                tgt.setPerformerType(VersionConvertor_30_40.convertCodeableConcept(src.getPerformerType()));
        }
        if (src.hasPerformer()) {
            if (src.hasPerformer())
                tgt.addPerformer(VersionConvertor_30_40.convertReference(src.getPerformer()));
        }
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) {
            tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference()) {
            tgt.addReasonReference(VersionConvertor_30_40.convertReference(t));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getSupportingInfo()) {
            tgt.addSupportingInfo(VersionConvertor_30_40.convertReference(t));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getSpecimen()) {
            tgt.addSpecimen(VersionConvertor_30_40.convertReference(t));
        }
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getBodySite()) {
            tgt.addBodySite(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) {
            tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getRelevantHistory()) {
            tgt.addRelevantHistory(VersionConvertor_30_40.convertReference(t));
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.ProcedureRequest convertProcedureRequest(org.hl7.fhir.r4.model.ServiceRequest src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ProcedureRequest tgt = new org.hl7.fhir.dstu3.model.ProcedureRequest();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) {
            tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) {
            tgt.addBasedOn(VersionConvertor_30_40.convertReference(t));
        }
        for (org.hl7.fhir.r4.model.Reference t : src.getReplaces()) {
            tgt.addReplaces(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasRequisition()) {
            if (src.hasRequisition())
                tgt.setRequisition(VersionConvertor_30_40.convertIdentifier(src.getRequisition()));
        }
        if (src.hasStatus()) {
            if (src.hasStatus())
                tgt.setStatus(convertProcedureRequestStatus(src.getStatus()));
        }
        if (src.hasIntent()) {
            if (src.hasIntent())
                tgt.setIntent(convertProcedureRequestIntent(src.getIntent()));
        }
        if (src.hasPriority()) {
            if (src.hasPriority())
                tgt.setPriority(convertProcedureRequestPriority(src.getPriority()));
        }
        if (src.hasDoNotPerform()) {
            if (src.hasDoNotPerformElement())
                tgt.setDoNotPerformElement(VersionConvertor_30_40.convertBoolean(src.getDoNotPerformElement()));
        }
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory()) {
            tgt.addCategory(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasCode()) {
            if (src.hasCode())
                tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        }
        if (src.hasSubject()) {
            if (src.hasSubject())
                tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        }
        if (src.hasEncounter()) {
            if (src.hasEncounter())
                tgt.setContext(VersionConvertor_30_40.convertReference(src.getEncounter()));
        }
        if (src.hasOccurrence()) {
            if (src.hasOccurrence())
                tgt.setOccurrence(VersionConvertor_30_40.convertType(src.getOccurrence()));
        }
        if (src.hasAsNeeded()) {
            if (src.hasAsNeeded())
                tgt.setAsNeeded(VersionConvertor_30_40.convertType(src.getAsNeeded()));
        }
        if (src.hasAuthoredOn()) {
            if (src.hasAuthoredOnElement())
                tgt.setAuthoredOnElement(VersionConvertor_30_40.convertDateTime(src.getAuthoredOnElement()));
        }
        if (src.hasRequester()) {
            tgt.setRequester(new org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestRequesterComponent(VersionConvertor_30_40.convertReference(src.getRequester())));
        }
        if (src.hasPerformerType()) {
            if (src.hasPerformerType())
                tgt.setPerformerType(VersionConvertor_30_40.convertCodeableConcept(src.getPerformerType()));
        }
        List<Reference> performers = src.getPerformer();
        if (performers.size() > 0) {
            tgt.setPerformer(VersionConvertor_30_40.convertReference(performers.get(0)));
            if (performers.size() > 1) {
            }
        }
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) {
            tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) {
            tgt.addReasonReference(VersionConvertor_30_40.convertReference(t));
        }
        for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInfo()) {
            tgt.addSupportingInfo(VersionConvertor_30_40.convertReference(t));
        }
        for (org.hl7.fhir.r4.model.Reference t : src.getSpecimen()) {
            tgt.addSpecimen(VersionConvertor_30_40.convertReference(t));
        }
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getBodySite()) {
            tgt.addBodySite(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) {
            tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        }
        for (org.hl7.fhir.r4.model.Reference t : src.getRelevantHistory()) {
            tgt.addRelevantHistory(VersionConvertor_30_40.convertReference(t));
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent convertProcedureRequestIntent(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent src) {
        if (src == null)
            return null;
        switch(src) {
            case FILLERORDER:
                return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.FILLERORDER;
            case INSTANCEORDER:
                return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.INSTANCEORDER;
            case OPTION:
                return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.OPTION;
            case ORDER:
                return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.ORDER;
            case ORIGINALORDER:
                return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.ORIGINALORDER;
            case PLAN:
                return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.PLAN;
            case PROPOSAL:
                return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.PROPOSAL;
            case REFLEXORDER:
                return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.REFLEXORDER;
            default:
                return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent convertProcedureRequestIntent(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent src) {
        if (src == null)
            return null;
        switch(src) {
            case DIRECTIVE:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent.NULL;
            case FILLERORDER:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent.FILLERORDER;
            case INSTANCEORDER:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent.INSTANCEORDER;
            case OPTION:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent.OPTION;
            case ORDER:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent.ORDER;
            case ORIGINALORDER:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent.ORIGINALORDER;
            case PLAN:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent.PLAN;
            case PROPOSAL:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent.PROPOSAL;
            case REFLEXORDER:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent.REFLEXORDER;
            default:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority convertProcedureRequestPriority(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority src) {
        if (src == null)
            return null;
        switch(src) {
            case ASAP:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority.ASAP;
            case ROUTINE:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority.ROUTINE;
            case STAT:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority.STAT;
            case URGENT:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority.URGENT;
            default:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority convertProcedureRequestPriority(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority src) {
        if (src == null)
            return null;
        switch(src) {
            case ASAP:
                return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority.ASAP;
            case ROUTINE:
                return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority.ROUTINE;
            case STAT:
                return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority.STAT;
            case URGENT:
                return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority.URGENT;
            default:
                return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus convertProcedureRequestStatus(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.ACTIVE;
            case COMPLETED:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.COMPLETED;
            case DRAFT:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.DRAFT;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.ENTEREDINERROR;
            case ONHOLD:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.SUSPENDED;
            case REVOKED:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.CANCELLED;
            case UNKNOWN:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.UNKNOWN;
            default:
                return org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus convertProcedureRequestStatus(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.ACTIVE;
            case CANCELLED:
                return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.REVOKED;
            case COMPLETED:
                return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.COMPLETED;
            case DRAFT:
                return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.DRAFT;
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.ENTEREDINERROR;
            case SUSPENDED:
                return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.ONHOLD;
            case UNKNOWN:
                return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.UNKNOWN;
            default:
                return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.NULL;
        }
    }
}
