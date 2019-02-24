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


public class ServiceRequest extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.ServiceRequest convertServiceRequest(org.hl7.fhir.r4.model.ServiceRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ServiceRequest tgt = new org.hl7.fhir.r5.model.ServiceRequest();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(convertCanonical(t));
    for (org.hl7.fhir.r4.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(convertUri(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn())
      tgt.addBasedOn(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReplaces())
      tgt.addReplaces(convertReference(t));
    if (src.hasRequisition())
      tgt.setRequisition(convertIdentifier(src.getRequisition()));
    if (src.hasStatus())
      tgt.setStatus(convertServiceRequestStatus(src.getStatus()));
    if (src.hasIntent())
      tgt.setIntent(convertServiceRequestIntent(src.getIntent()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriority(convertServiceRequestPriority(src.getPriority()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(convertBoolean(src.getDoNotPerformElement()));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getOrderDetail())
      tgt.addOrderDetail(convertCodeableConcept(t));
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
    for (org.hl7.fhir.r4.model.Reference t : src.getPerformer())
      tgt.addPerformer(convertReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getLocationCode())
      tgt.addLocationCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getLocationReference())
      tgt.addLocationReference(convertReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getInsurance())
      tgt.addInsurance(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInfo())
      tgt.addSupportingInfo(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getSpecimen())
      tgt.addSpecimen(convertReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    if (src.hasPatientInstruction())
      tgt.setPatientInstructionElement(convertString(src.getPatientInstructionElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getRelevantHistory())
      tgt.addRelevantHistory(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ServiceRequest convertServiceRequest(org.hl7.fhir.r5.model.ServiceRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ServiceRequest tgt = new org.hl7.fhir.r4.model.ServiceRequest();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(convertCanonical(t));
    for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(convertUri(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn())
      tgt.addBasedOn(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getReplaces())
      tgt.addReplaces(convertReference(t));
    if (src.hasRequisition())
      tgt.setRequisition(convertIdentifier(src.getRequisition()));
    if (src.hasStatus())
      tgt.setStatus(convertServiceRequestStatus(src.getStatus()));
    if (src.hasIntent())
      tgt.setIntent(convertServiceRequestIntent(src.getIntent()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriority(convertServiceRequestPriority(src.getPriority()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(convertBoolean(src.getDoNotPerformElement()));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getOrderDetail())
      tgt.addOrderDetail(convertCodeableConcept(t));
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
    for (org.hl7.fhir.r5.model.Reference t : src.getPerformer())
      tgt.addPerformer(convertReference(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getLocationCode())
      tgt.addLocationCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getLocationReference())
      tgt.addLocationReference(convertReference(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getInsurance())
      tgt.addInsurance(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInfo())
      tgt.addSupportingInfo(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getSpecimen())
      tgt.addSpecimen(convertReference(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    if (src.hasPatientInstruction())
      tgt.setPatientInstructionElement(convertString(src.getPatientInstructionElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getRelevantHistory())
      tgt.addRelevantHistory(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestStatus convertServiceRequestStatus(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DRAFT: return org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestStatus.DRAFT;
    case ACTIVE: return org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestStatus.ACTIVE;
    case ONHOLD: return org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestStatus.ONHOLD;
    case REVOKED: return org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestStatus.REVOKED;
    case COMPLETED: return org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestStatus.COMPLETED;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestStatus.ENTEREDINERROR;
    case UNKNOWN: return org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestStatus.UNKNOWN;
    default: return org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus convertServiceRequestStatus(org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DRAFT: return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.DRAFT;
    case ACTIVE: return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.ACTIVE;
    case ONHOLD: return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.ONHOLD;
    case REVOKED: return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.REVOKED;
    case COMPLETED: return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.COMPLETED;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.ENTEREDINERROR;
    case UNKNOWN: return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.UNKNOWN;
    default: return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestIntent convertServiceRequestIntent(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PROPOSAL: return org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestIntent.PROPOSAL;
    case PLAN: return org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestIntent.PLAN;
    case DIRECTIVE: return org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestIntent.DIRECTIVE;
    case ORDER: return org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestIntent.ORDER;
    case ORIGINALORDER: return org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestIntent.ORIGINALORDER;
    case REFLEXORDER: return org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestIntent.REFLEXORDER;
    case FILLERORDER: return org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestIntent.FILLERORDER;
    case INSTANCEORDER: return org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestIntent.INSTANCEORDER;
    case OPTION: return org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestIntent.OPTION;
    default: return org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestIntent.NULL;
  }
}

  public static org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent convertServiceRequestIntent(org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestIntent src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PROPOSAL: return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.PROPOSAL;
    case PLAN: return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.PLAN;
    case DIRECTIVE: return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.DIRECTIVE;
    case ORDER: return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.ORDER;
    case ORIGINALORDER: return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.ORIGINALORDER;
    case REFLEXORDER: return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.REFLEXORDER;
    case FILLERORDER: return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.FILLERORDER;
    case INSTANCEORDER: return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.INSTANCEORDER;
    case OPTION: return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.OPTION;
    default: return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent.NULL;
  }
}

  public static org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestPriority convertServiceRequestPriority(org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ROUTINE: return org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestPriority.ROUTINE;
    case URGENT: return org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestPriority.URGENT;
    case ASAP: return org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestPriority.ASAP;
    case STAT: return org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestPriority.STAT;
    default: return org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestPriority.NULL;
  }
}

  public static org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority convertServiceRequestPriority(org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestPriority src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ROUTINE: return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority.ROUTINE;
    case URGENT: return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority.URGENT;
    case ASAP: return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority.ASAP;
    case STAT: return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority.STAT;
    default: return org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority.NULL;
  }
}


}
