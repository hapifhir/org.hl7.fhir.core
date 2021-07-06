package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.conv10_40.VersionConvertor_10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Type10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.CodeableConcept10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Identifier10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.DateTime10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Communication10_40 {

    public static org.hl7.fhir.r4.model.Communication convertCommunication(org.hl7.fhir.dstu2.model.Communication src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Communication tgt = new org.hl7.fhir.r4.model.Communication();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
        if (src.hasCategory())
            tgt.addCategory(CodeableConcept10_40.convertCodeableConcept(src.getCategory()));
        if (src.hasSender())
            tgt.setSender(Reference10_40.convertReference(src.getSender()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getRecipient()) tgt.addRecipient(Reference10_40.convertReference(t));
        for (org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent t : src.getPayload()) tgt.addPayload(convertCommunicationPayloadComponent(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getMedium()) tgt.addMedium(CodeableConcept10_40.convertCodeableConcept(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertCommunicationStatus(src.getStatusElement()));
        if (src.hasEncounter())
            tgt.setEncounter(Reference10_40.convertReference(src.getEncounter()));
        if (src.hasSentElement())
            tgt.setSentElement(DateTime10_40.convertDateTime(src.getSentElement()));
        if (src.hasReceivedElement())
            tgt.setReceivedElement(DateTime10_40.convertDateTime(src.getReceivedElement()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReason()) tgt.addReasonCode(CodeableConcept10_40.convertCodeableConcept(t));
        if (src.hasSubject())
            tgt.setSubject(Reference10_40.convertReference(src.getSubject()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Communication convertCommunication(org.hl7.fhir.r4.model.Communication src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Communication tgt = new org.hl7.fhir.dstu2.model.Communication();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
        if (src.hasCategory())
            tgt.setCategory(CodeableConcept10_40.convertCodeableConcept(src.getCategoryFirstRep()));
        if (src.hasSender())
            tgt.setSender(Reference10_40.convertReference(src.getSender()));
        for (org.hl7.fhir.r4.model.Reference t : src.getRecipient()) tgt.addRecipient(Reference10_40.convertReference(t));
        for (org.hl7.fhir.r4.model.Communication.CommunicationPayloadComponent t : src.getPayload()) tgt.addPayload(convertCommunicationPayloadComponent(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getMedium()) tgt.addMedium(CodeableConcept10_40.convertCodeableConcept(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertCommunicationStatus(src.getStatusElement()));
        if (src.hasEncounter())
            tgt.setEncounter(Reference10_40.convertReference(src.getEncounter()));
        if (src.hasSentElement())
            tgt.setSentElement(DateTime10_40.convertDateTime(src.getSentElement()));
        if (src.hasReceivedElement())
            tgt.setReceivedElement(DateTime10_40.convertDateTime(src.getReceivedElement()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(CodeableConcept10_40.convertCodeableConcept(t));
        if (src.hasSubject())
            tgt.setSubject(Reference10_40.convertReference(src.getSubject()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent convertCommunicationPayloadComponent(org.hl7.fhir.r4.model.Communication.CommunicationPayloadComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent tgt = new org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent();
        Element10_40.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(Type10_40.convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Communication.CommunicationPayloadComponent convertCommunicationPayloadComponent(org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Communication.CommunicationPayloadComponent tgt = new org.hl7.fhir.r4.model.Communication.CommunicationPayloadComponent();
        Element10_40.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(Type10_40.convertType(src.getContent()));
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Communication.CommunicationStatus> convertCommunicationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Communication.CommunicationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Communication.CommunicationStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Communication.CommunicationStatusEnumFactory());
        Element10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.dstu2.model.Communication.CommunicationStatus.INPROGRESS);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Communication.CommunicationStatus.COMPLETED);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.dstu2.model.Communication.CommunicationStatus.SUSPENDED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu2.model.Communication.CommunicationStatus.REJECTED);
                break;
            case NOTDONE:
                tgt.setValue(org.hl7.fhir.dstu2.model.Communication.CommunicationStatus.FAILED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Communication.CommunicationStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Communication.CommunicationStatus> convertCommunicationStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Communication.CommunicationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Communication.CommunicationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Communication.CommunicationStatusEnumFactory());
        Element10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.r4.model.Communication.CommunicationStatus.INPROGRESS);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r4.model.Communication.CommunicationStatus.COMPLETED);
                break;
            case SUSPENDED:
                tgt.setValue(org.hl7.fhir.r4.model.Communication.CommunicationStatus.ONHOLD);
                break;
            case REJECTED:
                tgt.setValue(org.hl7.fhir.r4.model.Communication.CommunicationStatus.ENTEREDINERROR);
                break;
            case FAILED:
                tgt.setValue(org.hl7.fhir.r4.model.Communication.CommunicationStatus.NOTDONE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Communication.CommunicationStatus.NULL);
                break;
        }
        return tgt;
    }
}