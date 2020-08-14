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
        if (src.hasCategory())
            tgt.addCategory(VersionConvertor_10_30.convertCodeableConcept(src.getCategory()));
        if (src.hasSender())
            tgt.setSender(VersionConvertor_10_30.convertReference(src.getSender()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getRecipient()) tgt.addRecipient(VersionConvertor_10_30.convertReference(t));
        for (org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent t : src.getPayload()) tgt.addPayload(convertCommunicationPayloadComponent(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getMedium()) tgt.addMedium(VersionConvertor_10_30.convertCodeableConcept(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertCommunicationStatus(src.getStatusElement()));
        if (src.hasEncounter())
            tgt.setContext(VersionConvertor_10_30.convertReference(src.getEncounter()));
        if (src.hasSentElement())
            tgt.setSentElement(VersionConvertor_10_30.convertDateTime(src.getSentElement()));
        if (src.hasReceivedElement())
            tgt.setReceivedElement(VersionConvertor_10_30.convertDateTime(src.getReceivedElement()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReason()) tgt.addReasonCode(VersionConvertor_10_30.convertCodeableConcept(t));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Communication convertCommunication(org.hl7.fhir.dstu3.model.Communication src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Communication tgt = new org.hl7.fhir.dstu2.model.Communication();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        if (src.hasCategory())
            tgt.setCategory(VersionConvertor_10_30.convertCodeableConcept(src.getCategoryFirstRep()));
        if (src.hasSender())
            tgt.setSender(VersionConvertor_10_30.convertReference(src.getSender()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getRecipient()) tgt.addRecipient(VersionConvertor_10_30.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent t : src.getPayload()) tgt.addPayload(convertCommunicationPayloadComponent(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getMedium()) tgt.addMedium(VersionConvertor_10_30.convertCodeableConcept(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertCommunicationStatus(src.getStatusElement()));
        if (src.hasContext())
            tgt.setEncounter(VersionConvertor_10_30.convertReference(src.getContext()));
        if (src.hasSentElement())
            tgt.setSentElement(VersionConvertor_10_30.convertDateTime(src.getSentElement()));
        if (src.hasReceivedElement())
            tgt.setReceivedElement(VersionConvertor_10_30.convertDateTime(src.getReceivedElement()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(VersionConvertor_10_30.convertCodeableConcept(t));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent convertCommunicationPayloadComponent(org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent tgt = new org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(VersionConvertor_10_30.convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent convertCommunicationPayloadComponent(org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent tgt = new org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(VersionConvertor_10_30.convertType(src.getContent()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Communication.CommunicationStatus> convertCommunicationStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Communication.CommunicationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Communication.CommunicationStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Communication.CommunicationStatusEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.INPROGRESS);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.COMPLETED);
                break;
            case SUSPENDED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.SUSPENDED);
                break;
            case REJECTED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.ENTEREDINERROR);
                break;
            case FAILED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.ABORTED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Communication.CommunicationStatus> convertCommunicationStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Communication.CommunicationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Communication.CommunicationStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Communication.CommunicationStatusEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.dstu2.model.Communication.CommunicationStatus.INPROGRESS);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Communication.CommunicationStatus.COMPLETED);
                break;
            case SUSPENDED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Communication.CommunicationStatus.SUSPENDED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu2.model.Communication.CommunicationStatus.REJECTED);
                break;
            case ABORTED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Communication.CommunicationStatus.FAILED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Communication.CommunicationStatus.NULL);
                break;
        }
        return tgt;
    }
}