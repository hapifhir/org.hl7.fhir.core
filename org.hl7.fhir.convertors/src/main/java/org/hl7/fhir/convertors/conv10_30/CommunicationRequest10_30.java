package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class CommunicationRequest10_30 {

    public static org.hl7.fhir.dstu2.model.CommunicationRequest convertCommunicationRequest(org.hl7.fhir.dstu3.model.CommunicationRequest src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.CommunicationRequest tgt = new org.hl7.fhir.dstu2.model.CommunicationRequest();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        if (src.hasCategory())
            tgt.setCategory(VersionConvertor_10_30.convertCodeableConcept(src.getCategoryFirstRep()));
        if (src.hasSender())
            tgt.setSender(VersionConvertor_10_30.convertReference(src.getSender()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getRecipient()) tgt.addRecipient(VersionConvertor_10_30.convertReference(t));
        for (org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestPayloadComponent t : src.getPayload()) tgt.addPayload(convertCommunicationRequestPayloadComponent(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getMedium()) tgt.addMedium(VersionConvertor_10_30.convertCodeableConcept(t));
        tgt.setRequester(VersionConvertor_10_30.convertReference(src.getRequester().getAgent()));
        if (src.hasStatus())
            tgt.setStatusElement(convertCommunicationRequestStatus(src.getStatusElement()));
        if (src.hasContext())
            tgt.setEncounter(VersionConvertor_10_30.convertReference(src.getContext()));
        if (src.hasOccurrence())
            tgt.setScheduled(VersionConvertor_10_30.convertType(src.getOccurrence()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(VersionConvertor_10_30.convertCodeableConcept(t));
        if (src.hasAuthoredOnElement())
            tgt.setRequestedOnElement(VersionConvertor_10_30.convertDateTime(src.getAuthoredOnElement()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        if (src.hasPriority())
            tgt.setPriority(convertPriorityCode(src.getPriority()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CommunicationRequest convertCommunicationRequest(org.hl7.fhir.dstu2.model.CommunicationRequest src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CommunicationRequest tgt = new org.hl7.fhir.dstu3.model.CommunicationRequest();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        if (src.hasCategory())
            tgt.addCategory(VersionConvertor_10_30.convertCodeableConcept(src.getCategory()));
        if (src.hasSender())
            tgt.setSender(VersionConvertor_10_30.convertReference(src.getSender()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getRecipient()) tgt.addRecipient(VersionConvertor_10_30.convertReference(t));
        for (org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestPayloadComponent t : src.getPayload()) tgt.addPayload(convertCommunicationRequestPayloadComponent(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getMedium()) tgt.addMedium(VersionConvertor_10_30.convertCodeableConcept(t));
        tgt.getRequester().setAgent(VersionConvertor_10_30.convertReference(src.getRequester()));
        if (src.hasStatus())
            tgt.setStatusElement(convertCommunicationRequestStatus(src.getStatusElement()));
        if (src.hasEncounter())
            tgt.setContext(VersionConvertor_10_30.convertReference(src.getEncounter()));
        if (src.hasScheduled())
            tgt.setOccurrence(VersionConvertor_10_30.convertType(src.getScheduled()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReason()) tgt.addReasonCode(VersionConvertor_10_30.convertCodeableConcept(t));
        if (src.hasRequestedOnElement())
            tgt.setAuthoredOnElement(VersionConvertor_10_30.convertDateTime(src.getRequestedOnElement()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        if (src.hasPriority())
            tgt.setPriority(convertPriorityCode(src.getPriority()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestPayloadComponent convertCommunicationRequestPayloadComponent(org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestPayloadComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestPayloadComponent tgt = new org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestPayloadComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(VersionConvertor_10_30.convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestPayloadComponent convertCommunicationRequestPayloadComponent(org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestPayloadComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestPayloadComponent tgt = new org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestPayloadComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(VersionConvertor_10_30.convertType(src.getContent()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestStatus> convertCommunicationRequestStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestStatusEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case PROPOSED:
                tgt.setValue(org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestStatus.DRAFT);
                break;
            case PLANNED:
                tgt.setValue(org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestStatus.ACTIVE);
                break;
            case REQUESTED:
                tgt.setValue(org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestStatus.ACTIVE);
                break;
            case RECEIVED:
                tgt.setValue(org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestStatus.ACTIVE);
                break;
            case ACCEPTED:
                tgt.setValue(org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestStatus.ACTIVE);
                break;
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestStatus.ACTIVE);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestStatus.COMPLETED);
                break;
            case SUSPENDED:
                tgt.setValue(org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestStatus.SUSPENDED);
                break;
            case REJECTED:
                tgt.setValue(org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus> convertCommunicationRequestStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatusEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case DRAFT:
                tgt.setValue(org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus.PROPOSED);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus.INPROGRESS);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus.COMPLETED);
                break;
            case SUSPENDED:
                tgt.setValue(org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus.SUSPENDED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus.REJECTED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.CodeableConcept convertPriorityCode(org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationPriority priority) {
        org.hl7.fhir.dstu2.model.CodeableConcept cc = new org.hl7.fhir.dstu2.model.CodeableConcept();
        switch(priority) {
            case ROUTINE:
                cc.addCoding().setSystem("http://hl7.org/fhir/diagnostic-order-priority").setCode("routine");
                break;
            case URGENT:
                cc.addCoding().setSystem("http://hl7.org/fhir/diagnostic-order-priority").setCode("urgent");
                break;
            case STAT:
                cc.addCoding().setSystem("http://hl7.org/fhir/diagnostic-order-priority").setCode("stat");
                break;
            case ASAP:
                cc.addCoding().setSystem("http://hl7.org/fhir/diagnostic-order-priority").setCode("asap");
                break;
            default:
                return null;
        }
        return cc;
    }

    static public org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationPriority convertPriorityCode(org.hl7.fhir.dstu2.model.CodeableConcept priority) {
        for (org.hl7.fhir.dstu2.model.Coding c : priority.getCoding()) {
            if ("http://hl7.org/fhir/diagnostic-order-priority".equals(c.getSystem()) && "routine".equals(c.getCode()))
                return org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationPriority.ROUTINE;
            if ("http://hl7.org/fhir/diagnostic-order-priority".equals(c.getSystem()) && "urgent".equals(c.getCode()))
                return org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationPriority.URGENT;
            if ("http://hl7.org/fhir/diagnostic-order-priority".equals(c.getSystem()) && "stat".equals(c.getCode()))
                return org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationPriority.STAT;
            if ("http://hl7.org/fhir/diagnostic-order-priority".equals(c.getSystem()) && "asap".equals(c.getCode()))
                return org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationPriority.ASAP;
        }
        return null;
    }
}