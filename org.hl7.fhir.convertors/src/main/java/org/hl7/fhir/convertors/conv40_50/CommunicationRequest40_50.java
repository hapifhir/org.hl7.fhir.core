package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/
// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0
public class CommunicationRequest40_50 extends VersionConvertor_40_50 {

    public final static String EXT_PAYLOAD_CONTENT = "http://hl7.org/fhir/4.0/StructureDefinition/extension-CommunicationRequest.payload.content";

    public static org.hl7.fhir.r5.model.CommunicationRequest convertCommunicationRequest(org.hl7.fhir.r4.model.CommunicationRequest src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CommunicationRequest tgt = new org.hl7.fhir.r5.model.CommunicationRequest();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getReplaces()) tgt.addReplaces(convertReference(t));
        if (src.hasGroupIdentifier())
            tgt.setGroupIdentifier(convertIdentifier(src.getGroupIdentifier()));
        if (src.hasStatus())
            tgt.setStatusElement(convertCommunicationRequestStatus(src.getStatusElement()));
        if (src.hasStatusReason())
            tgt.setStatusReason(convertCodeableConcept(src.getStatusReason()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory()) tgt.addCategory(convertCodeableConcept(t));
        if (src.hasPriority())
            tgt.setPriorityElement(convertCommunicationPriority(src.getPriorityElement()));
        if (src.hasDoNotPerform())
            tgt.setDoNotPerformElement(convertBoolean(src.getDoNotPerformElement()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getMedium()) tgt.addMedium(convertCodeableConcept(t));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        for (org.hl7.fhir.r4.model.Reference t : src.getAbout()) tgt.addAbout(convertReference(t));
        if (src.hasEncounter())
            tgt.setEncounter(convertReference(src.getEncounter()));
        for (org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent t : src.getPayload()) tgt.addPayload(convertCommunicationRequestPayloadComponent(t));
        if (src.hasOccurrence())
            tgt.setOccurrence(convertType(src.getOccurrence()));
        if (src.hasAuthoredOn())
            tgt.setAuthoredOnElement(convertDateTime(src.getAuthoredOnElement()));
        if (src.hasRequester())
            tgt.setRequester(convertReference(src.getRequester()));
        for (org.hl7.fhir.r4.model.Reference t : src.getRecipient()) tgt.addRecipient(convertReference(t));
        if (src.hasSender())
            tgt.addInformationProvider(convertReference(src.getSender()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(convertCodeableConceptToCodeableReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) tgt.addReason(convertReferenceToCodeableReference(t));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CommunicationRequest convertCommunicationRequest(org.hl7.fhir.r5.model.CommunicationRequest src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.CommunicationRequest tgt = new org.hl7.fhir.r4.model.CommunicationRequest();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getReplaces()) tgt.addReplaces(convertReference(t));
        if (src.hasGroupIdentifier())
            tgt.setGroupIdentifier(convertIdentifier(src.getGroupIdentifier()));
        if (src.hasStatus())
            tgt.setStatusElement(convertCommunicationRequestStatus(src.getStatusElement()));
        if (src.hasStatusReason())
            tgt.setStatusReason(convertCodeableConcept(src.getStatusReason()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory()) tgt.addCategory(convertCodeableConcept(t));
        if (src.hasPriority())
            tgt.setPriorityElement(convertCommunicationPriority(src.getPriorityElement()));
        if (src.hasDoNotPerform())
            tgt.setDoNotPerformElement(convertBoolean(src.getDoNotPerformElement()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getMedium()) tgt.addMedium(convertCodeableConcept(t));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        for (org.hl7.fhir.r5.model.Reference t : src.getAbout()) tgt.addAbout(convertReference(t));
        if (src.hasEncounter())
            tgt.setEncounter(convertReference(src.getEncounter()));
        for (org.hl7.fhir.r5.model.CommunicationRequest.CommunicationRequestPayloadComponent t : src.getPayload()) tgt.addPayload(convertCommunicationRequestPayloadComponent(t));
        if (src.hasOccurrence())
            tgt.setOccurrence(convertType(src.getOccurrence()));
        if (src.hasAuthoredOn())
            tgt.setAuthoredOnElement(convertDateTime(src.getAuthoredOnElement()));
        if (src.hasRequester())
            tgt.setRequester(convertReference(src.getRequester()));
        for (org.hl7.fhir.r5.model.Reference t : src.getRecipient()) tgt.addRecipient(convertReference(t));
        if (src.hasInformationProvider())
            tgt.setSender(convertReference(src.getInformationProviderFirstRep()));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReasonCode(convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getReason()) if (t.hasReference())
            tgt.addReasonReference(convertReference(t.getReference()));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> convertCommunicationRequestStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DRAFT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.DRAFT);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.ACTIVE);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.ONHOLD);
                break;
            case REVOKED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.REVOKED);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.ENTEREDINERROR);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus> convertCommunicationRequestStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DRAFT:
                tgt.setValue(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.DRAFT);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.ACTIVE);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.ONHOLD);
                break;
            case REVOKED:
                tgt.setValue(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.REVOKED);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.ENTEREDINERROR);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> convertCommunicationPriority(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CommunicationRequest.CommunicationPriority> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestPriorityEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ROUTINE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.ROUTINE);
                break;
            case URGENT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.URGENT);
                break;
            case ASAP:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.ASAP);
                break;
            case STAT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.STAT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CommunicationRequest.CommunicationPriority> convertCommunicationPriority(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CommunicationRequest.CommunicationPriority> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CommunicationRequest.CommunicationPriorityEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ROUTINE:
                tgt.setValue(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationPriority.ROUTINE);
                break;
            case URGENT:
                tgt.setValue(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationPriority.URGENT);
                break;
            case ASAP:
                tgt.setValue(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationPriority.ASAP);
                break;
            case STAT:
                tgt.setValue(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationPriority.STAT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationPriority.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CommunicationRequest.CommunicationRequestPayloadComponent convertCommunicationRequestPayloadComponent(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CommunicationRequest.CommunicationRequestPayloadComponent tgt = new org.hl7.fhir.r5.model.CommunicationRequest.CommunicationRequestPayloadComponent();
        copyElement(src, tgt);
        if (org.hl7.fhir.r4.utils.ToolingExtensions.hasExtension(src, EXT_PAYLOAD_CONTENT)) {
            org.hl7.fhir.r4.model.Extension e = org.hl7.fhir.r4.utils.ToolingExtensions.getExtension(src, EXT_PAYLOAD_CONTENT);
            tgt.setContent(convertType(e.getValue()));
            org.hl7.fhir.r5.utils.ToolingExtensions.removeExtension(tgt, EXT_PAYLOAD_CONTENT);
        } else if (src.hasContent()) {
            org.hl7.fhir.r4.model.Type content = src.getContent();
            if (content instanceof org.hl7.fhir.r4.model.StringType) {
                org.hl7.fhir.r4.model.StringType string = (org.hl7.fhir.r4.model.StringType) content;
                org.hl7.fhir.r5.model.CodeableConcept code = new org.hl7.fhir.r5.model.CodeableConcept();
                code.setTextElement((org.hl7.fhir.r5.model.StringType) convertType(string));
                tgt.setContent(code);
            } else
                tgt.setContent(convertType(content));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent convertCommunicationRequestPayloadComponent(org.hl7.fhir.r5.model.CommunicationRequest.CommunicationRequestPayloadComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent tgt = new org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent();
        copyElement(src, tgt);
        if (src.hasContent()) {
            org.hl7.fhir.r5.model.DataType content = src.getContent();
            if (content instanceof org.hl7.fhir.r5.model.CodeableConcept) {
                org.hl7.fhir.r5.model.CodeableConcept code = (org.hl7.fhir.r5.model.CodeableConcept) content;
                if (code.hasText())
                    tgt.setContent(new org.hl7.fhir.r4.model.StringType(code.getText()));
                if (code.hasCoding() || code.hasExtension()) {
                    org.hl7.fhir.r4.model.Extension e = new org.hl7.fhir.r4.model.Extension(EXT_PAYLOAD_CONTENT);
                    e.setValue(convertType(code));
                    tgt.addExtension(e);
                }
            } else
                tgt.setContent(convertType(content));
        }
        return tgt;
    }
}