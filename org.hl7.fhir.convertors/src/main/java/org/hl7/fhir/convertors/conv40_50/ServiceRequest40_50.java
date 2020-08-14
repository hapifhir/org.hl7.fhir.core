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
public class ServiceRequest40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.ServiceRequest convertServiceRequest(org.hl7.fhir.r4.model.ServiceRequest src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ServiceRequest tgt = new org.hl7.fhir.r5.model.ServiceRequest();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        for (org.hl7.fhir.r4.model.CanonicalType t : src.getInstantiatesCanonical()) tgt.getInstantiatesCanonical().add(convertCanonical(t));
        for (org.hl7.fhir.r4.model.UriType t : src.getInstantiatesUri()) tgt.getInstantiatesUri().add(convertUri(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getReplaces()) tgt.addReplaces(convertReference(t));
        if (src.hasRequisition())
            tgt.setRequisition(convertIdentifier(src.getRequisition()));
        if (src.hasStatus())
            tgt.setStatusElement(convertServiceRequestStatus(src.getStatusElement()));
        if (src.hasIntent())
            tgt.setIntentElement(convertServiceRequestIntent(src.getIntentElement()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory()) tgt.addCategory(convertCodeableConcept(t));
        if (src.hasPriority())
            tgt.setPriorityElement(convertServiceRequestPriority(src.getPriorityElement()));
        if (src.hasDoNotPerform())
            tgt.setDoNotPerformElement(convertBoolean(src.getDoNotPerformElement()));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getOrderDetail()) tgt.addOrderDetail(convertCodeableConcept(t));
        if (src.hasQuantity())
            tgt.setQuantity(convertType(src.getQuantity()));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(convertReference(src.getEncounter()));
        if (src.hasOccurrence())
            tgt.setOccurrence(convertType(src.getOccurrence()));
        if (src.hasAsNeeded())
            tgt.setAsNeeded(convertType(src.getAsNeeded()));
        if (src.hasAuthoredOn())
            tgt.setAuthoredOnElement(convertDateTime(src.getAuthoredOnElement()));
        if (src.hasRequester())
            tgt.setRequester(convertReference(src.getRequester()));
        if (src.hasPerformerType())
            tgt.setPerformerType(convertCodeableConcept(src.getPerformerType()));
        for (org.hl7.fhir.r4.model.Reference t : src.getPerformer()) tgt.addPerformer(convertReference(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getLocationCode()) tgt.addLocation(convertCodeableConceptToCodeableReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getLocationReference()) tgt.addLocation(convertReferenceToCodeableReference(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(convertCodeableConceptToCodeableReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) tgt.addReason(convertReferenceToCodeableReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getInsurance()) tgt.addInsurance(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInfo()) tgt.addSupportingInfo(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getSpecimen()) tgt.addSpecimen(convertReference(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getBodySite()) tgt.addBodySite(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        if (src.hasPatientInstruction())
            tgt.setPatientInstructionElement(convertString(src.getPatientInstructionElement()));
        for (org.hl7.fhir.r4.model.Reference t : src.getRelevantHistory()) tgt.addRelevantHistory(convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ServiceRequest convertServiceRequest(org.hl7.fhir.r5.model.ServiceRequest src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ServiceRequest tgt = new org.hl7.fhir.r4.model.ServiceRequest();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        for (org.hl7.fhir.r5.model.CanonicalType t : src.getInstantiatesCanonical()) tgt.getInstantiatesCanonical().add(convertCanonical(t));
        for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesUri()) tgt.getInstantiatesUri().add(convertUri(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getReplaces()) tgt.addReplaces(convertReference(t));
        if (src.hasRequisition())
            tgt.setRequisition(convertIdentifier(src.getRequisition()));
        if (src.hasStatus())
            tgt.setStatusElement(convertServiceRequestStatus(src.getStatusElement()));
        if (src.hasIntent())
            tgt.setIntentElement(convertServiceRequestIntent(src.getIntentElement()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory()) tgt.addCategory(convertCodeableConcept(t));
        if (src.hasPriority())
            tgt.setPriorityElement(convertServiceRequestPriority(src.getPriorityElement()));
        if (src.hasDoNotPerform())
            tgt.setDoNotPerformElement(convertBoolean(src.getDoNotPerformElement()));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getOrderDetail()) tgt.addOrderDetail(convertCodeableConcept(t));
        if (src.hasQuantity())
            tgt.setQuantity(convertType(src.getQuantity()));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(convertReference(src.getEncounter()));
        if (src.hasOccurrence())
            tgt.setOccurrence(convertType(src.getOccurrence()));
        if (src.hasAsNeeded())
            tgt.setAsNeeded(convertType(src.getAsNeeded()));
        if (src.hasAuthoredOn())
            tgt.setAuthoredOnElement(convertDateTime(src.getAuthoredOnElement()));
        if (src.hasRequester())
            tgt.setRequester(convertReference(src.getRequester()));
        if (src.hasPerformerType())
            tgt.setPerformerType(convertCodeableConcept(src.getPerformerType()));
        for (org.hl7.fhir.r5.model.Reference t : src.getPerformer()) tgt.addPerformer(convertReference(t));
        for (CodeableReference t : src.getLocation()) if (t.hasConcept())
            tgt.addLocationCode(convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getLocation()) if (t.hasReference())
            tgt.addLocationReference(convertReference(t.getReference()));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReasonCode(convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getReason()) if (t.hasReference())
            tgt.addReasonReference(convertReference(t.getReference()));
        for (org.hl7.fhir.r5.model.Reference t : src.getInsurance()) tgt.addInsurance(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInfo()) tgt.addSupportingInfo(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getSpecimen()) tgt.addSpecimen(convertReference(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getBodySite()) tgt.addBodySite(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        if (src.hasPatientInstruction())
            tgt.setPatientInstructionElement(convertString(src.getPatientInstructionElement()));
        for (org.hl7.fhir.r5.model.Reference t : src.getRelevantHistory()) tgt.addRelevantHistory(convertReference(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> convertServiceRequestStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus> src) throws FHIRException {
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus> convertServiceRequestStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DRAFT:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.DRAFT);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.ACTIVE);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.ONHOLD);
                break;
            case REVOKED:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.REVOKED);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.ENTEREDINERROR);
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

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestIntent> convertServiceRequestIntent(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestIntent> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestIntentEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PROPOSAL:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.PROPOSAL);
                break;
            case PLAN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.PLAN);
                break;
            case DIRECTIVE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.DIRECTIVE);
                break;
            case ORDER:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.ORDER);
                break;
            case ORIGINALORDER:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.ORIGINALORDER);
                break;
            case REFLEXORDER:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.REFLEXORDER);
                break;
            case FILLERORDER:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.FILLERORDER);
                break;
            case INSTANCEORDER:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.INSTANCEORDER);
                break;
            case OPTION:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.OPTION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent> convertServiceRequestIntent(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestIntent> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntentEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PROPOSAL:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.PROPOSAL);
                break;
            case PLAN:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.PLAN);
                break;
            case DIRECTIVE:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.DIRECTIVE);
                break;
            case ORDER:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.ORDER);
                break;
            case ORIGINALORDER:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.ORIGINALORDER);
                break;
            case REFLEXORDER:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.REFLEXORDER);
                break;
            case FILLERORDER:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.FILLERORDER);
                break;
            case INSTANCEORDER:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.INSTANCEORDER);
                break;
            case OPTION:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.OPTION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> convertServiceRequestPriority(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority> src) throws FHIRException {
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority> convertServiceRequestPriority(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriorityEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ROUTINE:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority.ROUTINE);
                break;
            case URGENT:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority.URGENT);
                break;
            case ASAP:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority.ASAP);
                break;
            case STAT:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority.STAT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority.NULL);
                break;
        }
        return tgt;
    }
}