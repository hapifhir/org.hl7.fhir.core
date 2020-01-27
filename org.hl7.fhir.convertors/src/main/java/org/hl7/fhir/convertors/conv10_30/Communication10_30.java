package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Communication10_30 {

    public static org.hl7.fhir.dstu3.model.Communication convertCommunication(org.hl7.fhir.dstu2.model.Communication src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Communication tgt = new org.hl7.fhir.dstu3.model.Communication();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        tgt.addCategory(VersionConvertor_10_30.convertCodeableConcept(src.getCategory()));
        tgt.setSender(VersionConvertor_10_30.convertReference(src.getSender()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getRecipient()) tgt.addRecipient(VersionConvertor_10_30.convertReference(t));
        for (org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent t : src.getPayload()) tgt.addPayload(convertCommunicationPayloadComponent(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getMedium()) tgt.addMedium(VersionConvertor_10_30.convertCodeableConcept(t));
        tgt.setStatus(convertCommunicationStatus(src.getStatus()));
        tgt.setContext(VersionConvertor_10_30.convertReference(src.getEncounter()));
        tgt.setSent(src.getSent());
        tgt.setReceived(src.getReceived());
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReason()) tgt.addReasonCode(VersionConvertor_10_30.convertCodeableConcept(t));
        tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Communication convertCommunication(org.hl7.fhir.dstu3.model.Communication src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Communication tgt = new org.hl7.fhir.dstu2.model.Communication();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        tgt.setCategory(VersionConvertor_10_30.convertCodeableConcept(src.getCategoryFirstRep()));
        tgt.setSender(VersionConvertor_10_30.convertReference(src.getSender()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getRecipient()) tgt.addRecipient(VersionConvertor_10_30.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent t : src.getPayload()) tgt.addPayload(convertCommunicationPayloadComponent(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getMedium()) tgt.addMedium(VersionConvertor_10_30.convertCodeableConcept(t));
        tgt.setStatus(convertCommunicationStatus(src.getStatus()));
        tgt.setEncounter(VersionConvertor_10_30.convertReference(src.getContext()));
        tgt.setSent(src.getSent());
        tgt.setReceived(src.getReceived());
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(VersionConvertor_10_30.convertCodeableConcept(t));
        tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent convertCommunicationPayloadComponent(org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent tgt = new org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setContent(VersionConvertor_10_30.convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent convertCommunicationPayloadComponent(org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent tgt = new org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setContent(VersionConvertor_10_30.convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Communication.CommunicationStatus convertCommunicationStatus(org.hl7.fhir.dstu2.model.Communication.CommunicationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INPROGRESS:
                return org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.INPROGRESS;
            case COMPLETED:
                return org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.COMPLETED;
            case SUSPENDED:
                return org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.SUSPENDED;
            case REJECTED:
                return org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.ENTEREDINERROR;
            case FAILED:
                return org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.ABORTED;
            default:
                return org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Communication.CommunicationStatus convertCommunicationStatus(org.hl7.fhir.dstu3.model.Communication.CommunicationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INPROGRESS:
                return org.hl7.fhir.dstu2.model.Communication.CommunicationStatus.INPROGRESS;
            case COMPLETED:
                return org.hl7.fhir.dstu2.model.Communication.CommunicationStatus.COMPLETED;
            case SUSPENDED:
                return org.hl7.fhir.dstu2.model.Communication.CommunicationStatus.SUSPENDED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu2.model.Communication.CommunicationStatus.REJECTED;
            case ABORTED:
                return org.hl7.fhir.dstu2.model.Communication.CommunicationStatus.FAILED;
            default:
                return org.hl7.fhir.dstu2.model.Communication.CommunicationStatus.NULL;
        }
    }
}
