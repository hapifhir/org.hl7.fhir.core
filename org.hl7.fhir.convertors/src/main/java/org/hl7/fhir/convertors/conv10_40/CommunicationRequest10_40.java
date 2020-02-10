package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.dstu2.model.DateTimeType;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class CommunicationRequest10_40 {

    public static org.hl7.fhir.dstu2.model.CommunicationRequest convertCommunicationRequest(org.hl7.fhir.r4.model.CommunicationRequest src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.CommunicationRequest tgt = new org.hl7.fhir.dstu2.model.CommunicationRequest();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        }
        if (src.hasCategory()) {
            tgt.setCategory(VersionConvertor_10_40.convertCodeableConcept(src.getCategoryFirstRep()));
        }
        if (src.hasSender()) {
            tgt.setSender(VersionConvertor_10_40.convertReference(src.getSender()));
        }
        if (src.hasRecipient()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getRecipient()) tgt.addRecipient(VersionConvertor_10_40.convertReference(t));
        }
        if (src.hasPayload()) {
            for (org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent t : src.getPayload()) tgt.addPayload(convertCommunicationRequestPayloadComponent(t));
        }
        if (src.hasMedium()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getMedium()) tgt.addMedium(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        if (src.hasRequester()) {
            tgt.setRequester(VersionConvertor_10_40.convertReference(src.getRequester()));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertCommunicationRequestStatus(src.getStatus()));
        }
        if (src.hasEncounter()) {
            tgt.setEncounter(VersionConvertor_10_40.convertReference(src.getEncounter()));
        }
        if (src.hasOccurrence()) {
            tgt.setScheduled(VersionConvertor_10_40.convertType(src.getOccurrence()));
        }
        if (src.hasReasonCode()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        if (src.hasAuthoredOnElement()) {
            tgt.setRequestedOnElement((DateTimeType) VersionConvertor_10_40.convertType(src.getAuthoredOnElement()));
        }
        if (src.hasSubject()) {
            tgt.setSubject(VersionConvertor_10_40.convertReference(src.getSubject()));
        }
        if (src.hasPriority()) {
            tgt.setPriority(convertPriorityCode(src.getPriority()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CommunicationRequest convertCommunicationRequest(org.hl7.fhir.dstu2.model.CommunicationRequest src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CommunicationRequest tgt = new org.hl7.fhir.r4.model.CommunicationRequest();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        }
        if (src.hasCategory()) {
            tgt.addCategory(VersionConvertor_10_40.convertCodeableConcept(src.getCategory()));
        }
        if (src.hasSender()) {
            tgt.setSender(VersionConvertor_10_40.convertReference(src.getSender()));
        }
        if (src.hasRecipient()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getRecipient()) tgt.addRecipient(VersionConvertor_10_40.convertReference(t));
        }
        if (src.hasPayload()) {
            for (org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestPayloadComponent t : src.getPayload()) tgt.addPayload(convertCommunicationRequestPayloadComponent(t));
        }
        if (src.hasMedium()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getMedium()) tgt.addMedium(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        if (src.hasRequester()) {
            tgt.setRequester(VersionConvertor_10_40.convertReference(src.getRequester()));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertCommunicationRequestStatus(src.getStatus()));
        }
        if (src.hasEncounter()) {
            tgt.setEncounter(VersionConvertor_10_40.convertReference(src.getEncounter()));
        }
        if (src.hasScheduled()) {
            tgt.setOccurrence(VersionConvertor_10_40.convertType(src.getScheduled()));
        }
        if (src.hasReason()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReason()) tgt.addReasonCode(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        if (src.hasRequestedOnElement()) {
            tgt.setAuthoredOnElement((org.hl7.fhir.r4.model.DateTimeType) VersionConvertor_10_40.convertType(src.getRequestedOnElement()));
        }
        if (src.hasSubject()) {
            tgt.setSubject(VersionConvertor_10_40.convertReference(src.getSubject()));
        }
        if (src.hasPriority()) {
            tgt.setPriority(convertPriorityCode(src.getPriority()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent convertCommunicationRequestPayloadComponent(org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestPayloadComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent tgt = new org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasContent()) {
            tgt.setContent(VersionConvertor_10_40.convertType(src.getContent()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestPayloadComponent convertCommunicationRequestPayloadComponent(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestPayloadComponent tgt = new org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestPayloadComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasContent()) {
            tgt.setContent(VersionConvertor_10_40.convertType(src.getContent()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus convertCommunicationRequestStatus(org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PROPOSED:
                return org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.DRAFT;
            case PLANNED:
                return org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.ACTIVE;
            case REQUESTED:
                return org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.ACTIVE;
            case RECEIVED:
                return org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.ACTIVE;
            case ACCEPTED:
                return org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.ACTIVE;
            case INPROGRESS:
                return org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.ACTIVE;
            case COMPLETED:
                return org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.COMPLETED;
            case SUSPENDED:
                return org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.ONHOLD;
            case REJECTED:
                return org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus convertCommunicationRequestStatus(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DRAFT:
                return org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus.PROPOSED;
            case ACTIVE:
                return org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus.INPROGRESS;
            case COMPLETED:
                return org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus.COMPLETED;
            case ONHOLD:
                return org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus.SUSPENDED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus.REJECTED;
            default:
                return org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu2.model.CodeableConcept convertPriorityCode(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationPriority priority) {
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

    static public org.hl7.fhir.r4.model.CommunicationRequest.CommunicationPriority convertPriorityCode(org.hl7.fhir.dstu2.model.CodeableConcept priority) {
        for (org.hl7.fhir.dstu2.model.Coding c : priority.getCoding()) {
            if ("http://hl7.org/fhir/diagnostic-order-priority".equals(c.getSystem()) && "routine".equals(c.getCode()))
                return org.hl7.fhir.r4.model.CommunicationRequest.CommunicationPriority.ROUTINE;
            if ("http://hl7.org/fhir/diagnostic-order-priority".equals(c.getSystem()) && "urgent".equals(c.getCode()))
                return org.hl7.fhir.r4.model.CommunicationRequest.CommunicationPriority.URGENT;
            if ("http://hl7.org/fhir/diagnostic-order-priority".equals(c.getSystem()) && "stat".equals(c.getCode()))
                return org.hl7.fhir.r4.model.CommunicationRequest.CommunicationPriority.STAT;
            if ("http://hl7.org/fhir/diagnostic-order-priority".equals(c.getSystem()) && "asap".equals(c.getCode()))
                return org.hl7.fhir.r4.model.CommunicationRequest.CommunicationPriority.ASAP;
        }
        return null;
    }
}
