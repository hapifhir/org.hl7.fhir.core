package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

public class Communication10_50 {

    public static org.hl7.fhir.r5.model.Communication convertCommunication(org.hl7.fhir.dstu2.model.Communication src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Communication tgt = new org.hl7.fhir.r5.model.Communication();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        }
        if (src.hasCategory()) {
            tgt.addCategory(VersionConvertor_10_50.convertCodeableConcept(src.getCategory()));
        }
        if (src.hasSender()) {
            tgt.setSender(VersionConvertor_10_50.convertReference(src.getSender()));
        }
        if (src.hasRecipient()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getRecipient()) tgt.addRecipient(VersionConvertor_10_50.convertReference(t));
        }
        if (src.hasPayload()) {
            for (org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent t : src.getPayload()) tgt.addPayload(convertCommunicationPayloadComponent(t));
        }
        if (src.hasMedium()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getMedium()) tgt.addMedium(VersionConvertor_10_50.convertCodeableConcept(t));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertCommunicationStatus(src.getStatus()));
        }
        if (src.hasEncounter()) {
            tgt.setEncounter(VersionConvertor_10_50.convertReference(src.getEncounter()));
        }
        if (src.hasSent()) {
            tgt.setSent(src.getSent());
        }
        if (src.hasReceived()) {
            tgt.setReceived(src.getReceived());
        }
        if (src.hasReason()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReason()) tgt.addReason(VersionConvertor_10_50.convertCodeableConceptToCodableReference(t));
        }
        if (src.hasSubject()) {
            tgt.setSubject(VersionConvertor_10_50.convertReference(src.getSubject()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Communication convertCommunication(org.hl7.fhir.r5.model.Communication src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Communication tgt = new org.hl7.fhir.dstu2.model.Communication();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        }
        if (src.hasCategory()) {
            tgt.setCategory(VersionConvertor_10_50.convertCodeableConcept(src.getCategoryFirstRep()));
        }
        if (src.hasSender()) {
            tgt.setSender(VersionConvertor_10_50.convertReference(src.getSender()));
        }
        if (src.hasRecipient()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getRecipient()) tgt.addRecipient(VersionConvertor_10_50.convertReference(t));
        }
        if (src.hasPayload()) {
            for (org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent t : src.getPayload()) tgt.addPayload(convertCommunicationPayloadComponent(t));
        }
        if (src.hasMedium()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getMedium()) tgt.addMedium(VersionConvertor_10_50.convertCodeableConcept(t));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertCommunicationStatus(src.getStatus()));
        }
        if (src.hasEncounter()) {
            tgt.setEncounter(VersionConvertor_10_50.convertReference(src.getEncounter()));
        }
        if (src.hasSent()) {
            tgt.setSent(src.getSent());
        }
        if (src.hasReceived()) {
            tgt.setReceived(src.getReceived());
        }
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReason(VersionConvertor_10_50.convertCodeableConcept(t.getConcept()));
        if (src.hasSubject()) {
            tgt.setSubject(VersionConvertor_10_50.convertReference(src.getSubject()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent convertCommunicationPayloadComponent(org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent tgt = new org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasContent()) {
            tgt.setContent(VersionConvertor_10_50.convertType(src.getContent()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent convertCommunicationPayloadComponent(org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent tgt = new org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasContent()) {
            tgt.setContent(VersionConvertor_10_50.convertType(src.getContent()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Communication.CommunicationStatus convertCommunicationStatus(org.hl7.fhir.r5.model.Enumerations.EventStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INPROGRESS:
                return org.hl7.fhir.dstu2.model.Communication.CommunicationStatus.INPROGRESS;
            case COMPLETED:
                return org.hl7.fhir.dstu2.model.Communication.CommunicationStatus.COMPLETED;
            case ONHOLD:
                return org.hl7.fhir.dstu2.model.Communication.CommunicationStatus.SUSPENDED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu2.model.Communication.CommunicationStatus.REJECTED;
            case NOTDONE:
                return org.hl7.fhir.dstu2.model.Communication.CommunicationStatus.FAILED;
            default:
                return org.hl7.fhir.dstu2.model.Communication.CommunicationStatus.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.Enumerations.EventStatus convertCommunicationStatus(org.hl7.fhir.dstu2.model.Communication.CommunicationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INPROGRESS:
                return org.hl7.fhir.r5.model.Enumerations.EventStatus.INPROGRESS;
            case COMPLETED:
                return org.hl7.fhir.r5.model.Enumerations.EventStatus.COMPLETED;
            case SUSPENDED:
                return org.hl7.fhir.r5.model.Enumerations.EventStatus.ONHOLD;
            case REJECTED:
                return org.hl7.fhir.r5.model.Enumerations.EventStatus.ENTEREDINERROR;
            case FAILED:
                return org.hl7.fhir.r5.model.Enumerations.EventStatus.NOTDONE;
            default:
                return org.hl7.fhir.r5.model.Enumerations.EventStatus.NULL;
        }
    }
}
