package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Communication30_40 {

    public static org.hl7.fhir.dstu3.model.Communication convertCommunication(org.hl7.fhir.r4.model.Communication src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Communication tgt = new org.hl7.fhir.dstu3.model.Communication();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        for (org.hl7.fhir.r4.model.UriType t : src.getInstantiatesCanonical()) tgt.addDefinition(new org.hl7.fhir.dstu3.model.Reference(t.getValue()));
        for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(VersionConvertor_30_40.convertReference(t));
        if (src.hasStatus())
            if (src.getStatus() == org.hl7.fhir.r4.model.Communication.CommunicationStatus.NOTDONE)
                tgt.setNotDone(true);
            else
                tgt.setStatus(convertCommunicationStatus(src.getStatus()));
        if (src.hasStatusReason())
            tgt.setNotDoneReason(VersionConvertor_30_40.convertCodeableConcept(src.getStatusReason()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getMedium()) tgt.addMedium(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        for (org.hl7.fhir.r4.model.Reference t : src.getRecipient()) tgt.addRecipient(VersionConvertor_30_40.convertReference(t));
        if (src.hasEncounter())
            tgt.setContext(VersionConvertor_30_40.convertReference(src.getEncounter()));
        if (src.hasSent())
            tgt.setSentElement(VersionConvertor_30_40.convertDateTime(src.getSentElement()));
        if (src.hasReceived())
            tgt.setReceivedElement(VersionConvertor_30_40.convertDateTime(src.getReceivedElement()));
        if (src.hasSender())
            tgt.setSender(VersionConvertor_30_40.convertReference(src.getSender()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) tgt.addReasonReference(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.Communication.CommunicationPayloadComponent t : src.getPayload()) tgt.addPayload(convertCommunicationPayloadComponent(t));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Communication convertCommunication(org.hl7.fhir.dstu3.model.Communication src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Communication tgt = new org.hl7.fhir.r4.model.Communication();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getDefinition()) tgt.addInstantiatesCanonical(t.getReference());
        for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) tgt.addBasedOn(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getPartOf()) tgt.addPartOf(VersionConvertor_30_40.convertReference(t));
        if (src.hasNotDone())
            tgt.setStatus(org.hl7.fhir.r4.model.Communication.CommunicationStatus.NOTDONE);
        else if (src.hasStatus())
            tgt.setStatus(convertCommunicationStatus(src.getStatus()));
        if (src.hasNotDoneReason())
            tgt.setStatusReason(VersionConvertor_30_40.convertCodeableConcept(src.getNotDoneReason()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getMedium()) tgt.addMedium(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getRecipient()) tgt.addRecipient(VersionConvertor_30_40.convertReference(t));
        if (src.hasContext())
            tgt.setEncounter(VersionConvertor_30_40.convertReference(src.getContext()));
        if (src.hasSent())
            tgt.setSentElement(VersionConvertor_30_40.convertDateTime(src.getSentElement()));
        if (src.hasReceived())
            tgt.setReceivedElement(VersionConvertor_30_40.convertDateTime(src.getReceivedElement()));
        if (src.hasSender())
            tgt.setSender(VersionConvertor_30_40.convertReference(src.getSender()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference()) tgt.addReasonReference(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent t : src.getPayload()) tgt.addPayload(convertCommunicationPayloadComponent(t));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent convertCommunicationPayloadComponent(org.hl7.fhir.r4.model.Communication.CommunicationPayloadComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent tgt = new org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(VersionConvertor_30_40.convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Communication.CommunicationPayloadComponent convertCommunicationPayloadComponent(org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Communication.CommunicationPayloadComponent tgt = new org.hl7.fhir.r4.model.Communication.CommunicationPayloadComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(VersionConvertor_30_40.convertType(src.getContent()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Communication.CommunicationStatus convertCommunicationStatus(org.hl7.fhir.r4.model.Communication.CommunicationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PREPARATION:
                return org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.PREPARATION;
            case INPROGRESS:
                return org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.INPROGRESS;
            case ONHOLD:
                return org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.SUSPENDED;
            case STOPPED:
                return org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.ABORTED;
            case COMPLETED:
                return org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.ENTEREDINERROR;
            case UNKNOWN:
                return org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.UNKNOWN;
            default:
                return org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.Communication.CommunicationStatus convertCommunicationStatus(org.hl7.fhir.dstu3.model.Communication.CommunicationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PREPARATION:
                return org.hl7.fhir.r4.model.Communication.CommunicationStatus.PREPARATION;
            case INPROGRESS:
                return org.hl7.fhir.r4.model.Communication.CommunicationStatus.INPROGRESS;
            case SUSPENDED:
                return org.hl7.fhir.r4.model.Communication.CommunicationStatus.ONHOLD;
            case ABORTED:
                return org.hl7.fhir.r4.model.Communication.CommunicationStatus.STOPPED;
            case COMPLETED:
                return org.hl7.fhir.r4.model.Communication.CommunicationStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.Communication.CommunicationStatus.ENTEREDINERROR;
            case UNKNOWN:
                return org.hl7.fhir.r4.model.Communication.CommunicationStatus.UNKNOWN;
            default:
                return org.hl7.fhir.r4.model.Communication.CommunicationStatus.NULL;
        }
    }
}
