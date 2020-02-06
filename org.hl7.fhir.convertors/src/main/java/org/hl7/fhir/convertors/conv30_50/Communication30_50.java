package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

public class Communication30_50 {

    public static org.hl7.fhir.dstu3.model.Communication convertCommunication(org.hl7.fhir.r5.model.Communication src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Communication tgt = new org.hl7.fhir.dstu3.model.Communication();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasInstantiatesCanonical()) {
            for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesCanonical()) tgt.addDefinition(new org.hl7.fhir.dstu3.model.Reference(t.getValue()));
        }
        if (src.hasBasedOn()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasPartOf()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasStatus())
            if (src.getStatus() == org.hl7.fhir.r5.model.Enumerations.EventStatus.NOTDONE)
                tgt.setNotDone(true);
            else
                tgt.setStatus(convertCommunicationStatus(src.getStatus()));
        if (src.hasStatusReason())
            tgt.setNotDoneReason(VersionConvertor_30_50.convertCodeableConcept(src.getStatusReason()));
        if (src.hasCategory()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasMedium()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getMedium()) tgt.addMedium(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasRecipient()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getRecipient()) tgt.addRecipient(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasEncounter())
            tgt.setContext(VersionConvertor_30_50.convertReference(src.getEncounter()));
        if (src.hasSent())
            tgt.setSent(src.getSent());
        if (src.hasReceived())
            tgt.setReceived(src.getReceived());
        if (src.hasSender())
            tgt.setSender(VersionConvertor_30_50.convertReference(src.getSender()));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReasonCode(VersionConvertor_30_50.convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getReason()) if (t.hasReference())
            tgt.addReasonReference(VersionConvertor_30_50.convertReference(t.getReference()));
        if (src.hasPayload()) {
            for (org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent t : src.getPayload()) tgt.addPayload(convertCommunicationPayloadComponent(t));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Communication convertCommunication(org.hl7.fhir.dstu3.model.Communication src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Communication tgt = new org.hl7.fhir.r5.model.Communication();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasDefinition()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getDefinition()) tgt.addInstantiatesCanonical(t.getReference());
        }
        if (src.hasBasedOn()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) tgt.addBasedOn(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasPartOf()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getPartOf()) tgt.addPartOf(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasNotDone())
            tgt.setStatus(org.hl7.fhir.r5.model.Enumerations.EventStatus.NOTDONE);
        else if (src.hasStatus())
            tgt.setStatus(convertCommunicationStatus(src.getStatus()));
        if (src.hasNotDoneReason())
            tgt.setStatusReason(VersionConvertor_30_50.convertCodeableConcept(src.getNotDoneReason()));
        if (src.hasCategory()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasMedium()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getMedium()) tgt.addMedium(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasRecipient()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getRecipient()) tgt.addRecipient(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasContext())
            tgt.setEncounter(VersionConvertor_30_50.convertReference(src.getContext()));
        if (src.hasSent())
            tgt.setSent(src.getSent());
        if (src.hasReceived())
            tgt.setReceived(src.getReceived());
        if (src.hasSender())
            tgt.setSender(VersionConvertor_30_50.convertReference(src.getSender()));
        if (src.hasReasonCode()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(VersionConvertor_30_50.convertCodeableConceptToCodableReference(t));
        }
        if (src.hasReasonReference()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference()) tgt.addReason(VersionConvertor_30_50.convertReferenceToCodableReference(t));
        }
        if (src.hasPayload()) {
            for (org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent t : src.getPayload()) tgt.addPayload(convertCommunicationPayloadComponent(t));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent convertCommunicationPayloadComponent(org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent tgt = new org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(VersionConvertor_30_50.convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent convertCommunicationPayloadComponent(org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent tgt = new org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(VersionConvertor_30_50.convertType(src.getContent()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Communication.CommunicationStatus convertCommunicationStatus(org.hl7.fhir.r5.model.Enumerations.EventStatus src) throws FHIRException {
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

    static public org.hl7.fhir.r5.model.Enumerations.EventStatus convertCommunicationStatus(org.hl7.fhir.dstu3.model.Communication.CommunicationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PREPARATION:
                return org.hl7.fhir.r5.model.Enumerations.EventStatus.PREPARATION;
            case INPROGRESS:
                return org.hl7.fhir.r5.model.Enumerations.EventStatus.INPROGRESS;
            case SUSPENDED:
                return org.hl7.fhir.r5.model.Enumerations.EventStatus.ONHOLD;
            case ABORTED:
                return org.hl7.fhir.r5.model.Enumerations.EventStatus.STOPPED;
            case COMPLETED:
                return org.hl7.fhir.r5.model.Enumerations.EventStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r5.model.Enumerations.EventStatus.ENTEREDINERROR;
            case UNKNOWN:
                return org.hl7.fhir.r5.model.Enumerations.EventStatus.UNKNOWN;
            default:
                return org.hl7.fhir.r5.model.Enumerations.EventStatus.NULL;
        }
    }
}
