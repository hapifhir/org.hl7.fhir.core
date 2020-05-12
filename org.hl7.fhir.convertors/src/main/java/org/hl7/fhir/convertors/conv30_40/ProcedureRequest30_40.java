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
                tgt.setStatusElement(convertProcedureRequestStatus(src.getStatusElement()));
        }
        if (src.hasIntent()) {
            if (src.hasIntent())
                tgt.setIntentElement(convertProcedureRequestIntent(src.getIntentElement()));
        }
        if (src.hasPriority()) {
            if (src.hasPriority())
                tgt.setPriorityElement(convertProcedureRequestPriority(src.getPriorityElement()));
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
                tgt.setStatusElement(convertProcedureRequestStatus(src.getStatusElement()));
        }
        if (src.hasIntent()) {
            if (src.hasIntent())
                tgt.setIntentElement(convertProcedureRequestIntent(src.getIntentElement()));
        }
        if (src.hasPriority()) {
            if (src.hasPriority())
                tgt.setPriorityElement(convertProcedureRequestPriority(src.getPriorityElement()));
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent> convertProcedureRequestIntent(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntentEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case FILLERORDER:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.FILLERORDER);
                break;
            case INSTANCEORDER:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.INSTANCEORDER);
                break;
            case OPTION:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.OPTION);
                break;
            case ORDER:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.ORDER);
                break;
            case ORIGINALORDER:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.ORIGINALORDER);
                break;
            case PLAN:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.PLAN);
                break;
            case PROPOSAL:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.PROPOSAL);
                break;
            case REFLEXORDER:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.REFLEXORDER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent> convertProcedureRequestIntent(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntentEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case DIRECTIVE:
                tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent.NULL);
                break;
            case FILLERORDER:
                tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent.FILLERORDER);
                break;
            case INSTANCEORDER:
                tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent.INSTANCEORDER);
                break;
            case OPTION:
                tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent.OPTION);
                break;
            case ORDER:
                tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent.ORDER);
                break;
            case ORIGINALORDER:
                tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent.ORIGINALORDER);
                break;
            case PLAN:
                tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent.PLAN);
                break;
            case PROPOSAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent.PROPOSAL);
                break;
            case REFLEXORDER:
                tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent.REFLEXORDER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority> convertProcedureRequestPriority(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriorityEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case ASAP:
                tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority.ASAP);
                break;
            case ROUTINE:
                tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority.ROUTINE);
                break;
            case STAT:
                tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority.STAT);
                break;
            case URGENT:
                tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority.URGENT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority> convertProcedureRequestPriority(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriorityEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case ASAP:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority.ASAP);
                break;
            case ROUTINE:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority.ROUTINE);
                break;
            case STAT:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority.STAT);
                break;
            case URGENT:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority.URGENT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus> convertProcedureRequestStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.ACTIVE);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.COMPLETED);
                break;
            case DRAFT:
                tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.DRAFT);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.ENTEREDINERROR);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.SUSPENDED);
                break;
            case REVOKED:
                tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.CANCELLED);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus> convertProcedureRequestStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.ACTIVE);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.REVOKED);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.COMPLETED);
                break;
            case DRAFT:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.DRAFT);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.ENTEREDINERROR);
                break;
            case SUSPENDED:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.ONHOLD);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.NULL);
                break;
        }
        return tgt;
    }
}