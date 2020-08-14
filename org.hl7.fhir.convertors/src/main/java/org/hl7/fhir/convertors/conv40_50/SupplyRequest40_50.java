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
public class SupplyRequest40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.SupplyRequest convertSupplyRequest(org.hl7.fhir.r4.model.SupplyRequest src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.SupplyRequest tgt = new org.hl7.fhir.r5.model.SupplyRequest();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertSupplyRequestStatus(src.getStatusElement()));
        if (src.hasCategory())
            tgt.setCategory(convertCodeableConcept(src.getCategory()));
        if (src.hasPriority())
            tgt.setPriorityElement(convertRequestPriority(src.getPriorityElement()));
        if (src.hasItem()) {
          if (src.hasItemCodeableConcept()) {
            tgt.getItem().setConcept(convertCodeableConcept(src.getItemCodeableConcept()));
          } else {
            tgt.getItem().setReference(convertReference(src.getItemReference()));
          }
        }
        if (src.hasQuantity())
            tgt.setQuantity(convertQuantity(src.getQuantity()));
        for (org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestParameterComponent t : src.getParameter()) tgt.addParameter(convertSupplyRequestParameterComponent(t));
        if (src.hasOccurrence())
            tgt.setOccurrence(convertType(src.getOccurrence()));
        if (src.hasAuthoredOn())
            tgt.setAuthoredOnElement(convertDateTime(src.getAuthoredOnElement()));
        if (src.hasRequester())
            tgt.setRequester(convertReference(src.getRequester()));
        for (org.hl7.fhir.r4.model.Reference t : src.getSupplier()) tgt.addSupplier(convertReference(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(convertCodeableConceptToCodeableReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) tgt.addReason(convertReferenceToCodeableReference(t));
        if (src.hasDeliverFrom())
            tgt.setDeliverFrom(convertReference(src.getDeliverFrom()));
        if (src.hasDeliverTo())
            tgt.setDeliverTo(convertReference(src.getDeliverTo()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.SupplyRequest convertSupplyRequest(org.hl7.fhir.r5.model.SupplyRequest src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.SupplyRequest tgt = new org.hl7.fhir.r4.model.SupplyRequest();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertSupplyRequestStatus(src.getStatusElement()));
        if (src.hasCategory())
            tgt.setCategory(convertCodeableConcept(src.getCategory()));
        if (src.hasPriority())
            tgt.setPriorityElement(convertRequestPriority(src.getPriorityElement()));
        if (src.hasItem()) {
            if (src.getItem().hasReference()) {
              tgt.setItem(convertType(src.getItem().getReference()));
            } else {
              tgt.setItem(convertType(src.getItem().getConcept()));
            }
        }
        if (src.hasQuantity())
            tgt.setQuantity(convertQuantity(src.getQuantity()));
        for (org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestParameterComponent t : src.getParameter()) tgt.addParameter(convertSupplyRequestParameterComponent(t));
        if (src.hasOccurrence())
            tgt.setOccurrence(convertType(src.getOccurrence()));
        if (src.hasAuthoredOn())
            tgt.setAuthoredOnElement(convertDateTime(src.getAuthoredOnElement()));
        if (src.hasRequester())
            tgt.setRequester(convertReference(src.getRequester()));
        for (org.hl7.fhir.r5.model.Reference t : src.getSupplier()) tgt.addSupplier(convertReference(t));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReasonCode(convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getReason()) if (t.hasReference())
            tgt.addReasonReference(convertReference(t.getReference()));
        if (src.hasDeliverFrom())
            tgt.setDeliverFrom(convertReference(src.getDeliverFrom()));
        if (src.hasDeliverTo())
            tgt.setDeliverTo(convertReference(src.getDeliverTo()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus> convertSupplyRequestStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DRAFT:
                tgt.setValue(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.DRAFT);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.ACTIVE);
                break;
            case SUSPENDED:
                tgt.setValue(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.SUSPENDED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.CANCELLED);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.ENTEREDINERROR);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus> convertSupplyRequestStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DRAFT:
                tgt.setValue(org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.DRAFT);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.ACTIVE);
                break;
            case SUSPENDED:
                tgt.setValue(org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.SUSPENDED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.CANCELLED);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.ENTEREDINERROR);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> convertRequestPriority(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SupplyRequest.RequestPriority> src) throws FHIRException {
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SupplyRequest.RequestPriority> convertRequestPriority(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SupplyRequest.RequestPriority> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.SupplyRequest.RequestPriorityEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ROUTINE:
                tgt.setValue(org.hl7.fhir.r4.model.SupplyRequest.RequestPriority.ROUTINE);
                break;
            case URGENT:
                tgt.setValue(org.hl7.fhir.r4.model.SupplyRequest.RequestPriority.URGENT);
                break;
            case ASAP:
                tgt.setValue(org.hl7.fhir.r4.model.SupplyRequest.RequestPriority.ASAP);
                break;
            case STAT:
                tgt.setValue(org.hl7.fhir.r4.model.SupplyRequest.RequestPriority.STAT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.SupplyRequest.RequestPriority.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestParameterComponent convertSupplyRequestParameterComponent(org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestParameterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestParameterComponent tgt = new org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestParameterComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasValue())
            tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestParameterComponent convertSupplyRequestParameterComponent(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestParameterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestParameterComponent tgt = new org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestParameterComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasValue())
            tgt.setValue(convertType(src.getValue()));
        return tgt;
    }
}