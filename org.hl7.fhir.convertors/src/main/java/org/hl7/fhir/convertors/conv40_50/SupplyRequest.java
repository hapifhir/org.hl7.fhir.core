package org.hl7.fhir.convertors.conv40_50;

import org.hl7.fhir.exceptions.FHIRException;

import org.hl7.fhir.convertors.VersionConvertor_40_50;


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


public class SupplyRequest extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.SupplyRequest convertSupplyRequest(org.hl7.fhir.r4.model.SupplyRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SupplyRequest tgt = new org.hl7.fhir.r5.model.SupplyRequest();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertSupplyRequestStatus(src.getStatus()));
    if (src.hasCategory())
      tgt.setCategory(convertCodeableConcept(src.getCategory()));
    if (src.hasPriority())
      tgt.setPriority(convertRequestPriority(src.getPriority()));
    if (src.hasItem())
      tgt.setItem(convertType(src.getItem()));
    if (src.hasQuantity())
      tgt.setQuantity(convertQuantity(src.getQuantity()));
    for (org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestParameterComponent t : src.getParameter())
      tgt.addParameter(convertSupplyRequestParameterComponent(t));
    if (src.hasOccurrence())
      tgt.setOccurrence(convertType(src.getOccurrence()));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(convertReference(src.getRequester()));
    for (org.hl7.fhir.r4.model.Reference t : src.getSupplier())
      tgt.addSupplier(convertReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(convertReference(t));
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
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertSupplyRequestStatus(src.getStatus()));
    if (src.hasCategory())
      tgt.setCategory(convertCodeableConcept(src.getCategory()));
    if (src.hasPriority())
      tgt.setPriority(convertRequestPriority(src.getPriority()));
    if (src.hasItem())
      tgt.setItem(convertType(src.getItem()));
    if (src.hasQuantity())
      tgt.setQuantity(convertQuantity(src.getQuantity()));
    for (org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestParameterComponent t : src.getParameter())
      tgt.addParameter(convertSupplyRequestParameterComponent(t));
    if (src.hasOccurrence())
      tgt.setOccurrence(convertType(src.getOccurrence()));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(convertReference(src.getRequester()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSupplier())
      tgt.addSupplier(convertReference(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(convertReference(t));
    if (src.hasDeliverFrom())
      tgt.setDeliverFrom(convertReference(src.getDeliverFrom()));
    if (src.hasDeliverTo())
      tgt.setDeliverTo(convertReference(src.getDeliverTo()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus convertSupplyRequestStatus(org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DRAFT: return org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.DRAFT;
    case ACTIVE: return org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.ACTIVE;
    case SUSPENDED: return org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.SUSPENDED;
    case CANCELLED: return org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.CANCELLED;
    case COMPLETED: return org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.COMPLETED;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.ENTEREDINERROR;
    case UNKNOWN: return org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.UNKNOWN;
    default: return org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus convertSupplyRequestStatus(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DRAFT: return org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.DRAFT;
    case ACTIVE: return org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.ACTIVE;
    case SUSPENDED: return org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.SUSPENDED;
    case CANCELLED: return org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.CANCELLED;
    case COMPLETED: return org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.COMPLETED;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.ENTEREDINERROR;
    case UNKNOWN: return org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.UNKNOWN;
    default: return org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.SupplyRequest.RequestPriority convertRequestPriority(org.hl7.fhir.r4.model.SupplyRequest.RequestPriority src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ROUTINE: return org.hl7.fhir.r5.model.SupplyRequest.RequestPriority.ROUTINE;
    case URGENT: return org.hl7.fhir.r5.model.SupplyRequest.RequestPriority.URGENT;
    case ASAP: return org.hl7.fhir.r5.model.SupplyRequest.RequestPriority.ASAP;
    case STAT: return org.hl7.fhir.r5.model.SupplyRequest.RequestPriority.STAT;
    default: return org.hl7.fhir.r5.model.SupplyRequest.RequestPriority.NULL;
  }
}

  public static org.hl7.fhir.r4.model.SupplyRequest.RequestPriority convertRequestPriority(org.hl7.fhir.r5.model.SupplyRequest.RequestPriority src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ROUTINE: return org.hl7.fhir.r4.model.SupplyRequest.RequestPriority.ROUTINE;
    case URGENT: return org.hl7.fhir.r4.model.SupplyRequest.RequestPriority.URGENT;
    case ASAP: return org.hl7.fhir.r4.model.SupplyRequest.RequestPriority.ASAP;
    case STAT: return org.hl7.fhir.r4.model.SupplyRequest.RequestPriority.STAT;
    default: return org.hl7.fhir.r4.model.SupplyRequest.RequestPriority.NULL;
  }
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
