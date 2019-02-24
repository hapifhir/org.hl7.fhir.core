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


public class DeviceRequest extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.DeviceRequest convertDeviceRequest(org.hl7.fhir.r4.model.DeviceRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DeviceRequest tgt = new org.hl7.fhir.r5.model.DeviceRequest();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(convertCanonical(t));
    for (org.hl7.fhir.r4.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(convertUri(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn())
      tgt.addBasedOn(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getPriorRequest())
      tgt.addPriorRequest(convertReference(t));
    if (src.hasGroupIdentifier())
      tgt.setGroupIdentifier(convertIdentifier(src.getGroupIdentifier()));
    if (src.hasStatus())
      tgt.setStatus(convertDeviceRequestStatus(src.getStatus()));
    if (src.hasIntent())
      tgt.setIntent(convertRequestIntent(src.getIntent()));
    if (src.hasPriority())
      tgt.setPriority(convertRequestPriority(src.getPriority()));
    if (src.hasCode())
      tgt.setCode(convertType(src.getCode()));
    for (org.hl7.fhir.r4.model.DeviceRequest.DeviceRequestParameterComponent t : src.getParameter())
      tgt.addParameter(convertDeviceRequestParameterComponent(t));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(convertType(src.getOccurrence()));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(convertReference(src.getRequester()));
    if (src.hasPerformerType())
      tgt.setPerformerType(convertCodeableConcept(src.getPerformerType()));
    if (src.hasPerformer())
      tgt.setPerformer(convertReference(src.getPerformer()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getInsurance())
      tgt.addInsurance(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInfo())
      tgt.addSupportingInfo(convertReference(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getRelevantHistory())
      tgt.addRelevantHistory(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DeviceRequest convertDeviceRequest(org.hl7.fhir.r5.model.DeviceRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DeviceRequest tgt = new org.hl7.fhir.r4.model.DeviceRequest();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(convertCanonical(t));
    for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(convertUri(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn())
      tgt.addBasedOn(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getPriorRequest())
      tgt.addPriorRequest(convertReference(t));
    if (src.hasGroupIdentifier())
      tgt.setGroupIdentifier(convertIdentifier(src.getGroupIdentifier()));
    if (src.hasStatus())
      tgt.setStatus(convertDeviceRequestStatus(src.getStatus()));
    if (src.hasIntent())
      tgt.setIntent(convertRequestIntent(src.getIntent()));
    if (src.hasPriority())
      tgt.setPriority(convertRequestPriority(src.getPriority()));
    if (src.hasCode())
      tgt.setCode(convertType(src.getCode()));
    for (org.hl7.fhir.r5.model.DeviceRequest.DeviceRequestParameterComponent t : src.getParameter())
      tgt.addParameter(convertDeviceRequestParameterComponent(t));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(convertType(src.getOccurrence()));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(convertReference(src.getRequester()));
    if (src.hasPerformerType())
      tgt.setPerformerType(convertCodeableConcept(src.getPerformerType()));
    if (src.hasPerformer())
      tgt.setPerformer(convertReference(src.getPerformer()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getInsurance())
      tgt.addInsurance(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInfo())
      tgt.addSupportingInfo(convertReference(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getRelevantHistory())
      tgt.addRelevantHistory(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DeviceRequest.DeviceRequestStatus convertDeviceRequestStatus(org.hl7.fhir.r4.model.DeviceRequest.DeviceRequestStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DRAFT: return org.hl7.fhir.r5.model.DeviceRequest.DeviceRequestStatus.DRAFT;
    case ACTIVE: return org.hl7.fhir.r5.model.DeviceRequest.DeviceRequestStatus.ACTIVE;
    case ONHOLD: return org.hl7.fhir.r5.model.DeviceRequest.DeviceRequestStatus.ONHOLD;
    case REVOKED: return org.hl7.fhir.r5.model.DeviceRequest.DeviceRequestStatus.REVOKED;
    case COMPLETED: return org.hl7.fhir.r5.model.DeviceRequest.DeviceRequestStatus.COMPLETED;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.DeviceRequest.DeviceRequestStatus.ENTEREDINERROR;
    case UNKNOWN: return org.hl7.fhir.r5.model.DeviceRequest.DeviceRequestStatus.UNKNOWN;
    default: return org.hl7.fhir.r5.model.DeviceRequest.DeviceRequestStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.DeviceRequest.DeviceRequestStatus convertDeviceRequestStatus(org.hl7.fhir.r5.model.DeviceRequest.DeviceRequestStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DRAFT: return org.hl7.fhir.r4.model.DeviceRequest.DeviceRequestStatus.DRAFT;
    case ACTIVE: return org.hl7.fhir.r4.model.DeviceRequest.DeviceRequestStatus.ACTIVE;
    case ONHOLD: return org.hl7.fhir.r4.model.DeviceRequest.DeviceRequestStatus.ONHOLD;
    case REVOKED: return org.hl7.fhir.r4.model.DeviceRequest.DeviceRequestStatus.REVOKED;
    case COMPLETED: return org.hl7.fhir.r4.model.DeviceRequest.DeviceRequestStatus.COMPLETED;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.DeviceRequest.DeviceRequestStatus.ENTEREDINERROR;
    case UNKNOWN: return org.hl7.fhir.r4.model.DeviceRequest.DeviceRequestStatus.UNKNOWN;
    default: return org.hl7.fhir.r4.model.DeviceRequest.DeviceRequestStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.DeviceRequest.RequestIntent convertRequestIntent(org.hl7.fhir.r4.model.DeviceRequest.RequestIntent src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PROPOSAL: return org.hl7.fhir.r5.model.DeviceRequest.RequestIntent.PROPOSAL;
    case PLAN: return org.hl7.fhir.r5.model.DeviceRequest.RequestIntent.PLAN;
    case DIRECTIVE: return org.hl7.fhir.r5.model.DeviceRequest.RequestIntent.DIRECTIVE;
    case ORDER: return org.hl7.fhir.r5.model.DeviceRequest.RequestIntent.ORDER;
    case ORIGINALORDER: return org.hl7.fhir.r5.model.DeviceRequest.RequestIntent.ORIGINALORDER;
    case REFLEXORDER: return org.hl7.fhir.r5.model.DeviceRequest.RequestIntent.REFLEXORDER;
    case FILLERORDER: return org.hl7.fhir.r5.model.DeviceRequest.RequestIntent.FILLERORDER;
    case INSTANCEORDER: return org.hl7.fhir.r5.model.DeviceRequest.RequestIntent.INSTANCEORDER;
    case OPTION: return org.hl7.fhir.r5.model.DeviceRequest.RequestIntent.OPTION;
    default: return org.hl7.fhir.r5.model.DeviceRequest.RequestIntent.NULL;
  }
}

  public static org.hl7.fhir.r4.model.DeviceRequest.RequestIntent convertRequestIntent(org.hl7.fhir.r5.model.DeviceRequest.RequestIntent src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PROPOSAL: return org.hl7.fhir.r4.model.DeviceRequest.RequestIntent.PROPOSAL;
    case PLAN: return org.hl7.fhir.r4.model.DeviceRequest.RequestIntent.PLAN;
    case DIRECTIVE: return org.hl7.fhir.r4.model.DeviceRequest.RequestIntent.DIRECTIVE;
    case ORDER: return org.hl7.fhir.r4.model.DeviceRequest.RequestIntent.ORDER;
    case ORIGINALORDER: return org.hl7.fhir.r4.model.DeviceRequest.RequestIntent.ORIGINALORDER;
    case REFLEXORDER: return org.hl7.fhir.r4.model.DeviceRequest.RequestIntent.REFLEXORDER;
    case FILLERORDER: return org.hl7.fhir.r4.model.DeviceRequest.RequestIntent.FILLERORDER;
    case INSTANCEORDER: return org.hl7.fhir.r4.model.DeviceRequest.RequestIntent.INSTANCEORDER;
    case OPTION: return org.hl7.fhir.r4.model.DeviceRequest.RequestIntent.OPTION;
    default: return org.hl7.fhir.r4.model.DeviceRequest.RequestIntent.NULL;
  }
}

  public static org.hl7.fhir.r5.model.DeviceRequest.RequestPriority convertRequestPriority(org.hl7.fhir.r4.model.DeviceRequest.RequestPriority src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ROUTINE: return org.hl7.fhir.r5.model.DeviceRequest.RequestPriority.ROUTINE;
    case URGENT: return org.hl7.fhir.r5.model.DeviceRequest.RequestPriority.URGENT;
    case ASAP: return org.hl7.fhir.r5.model.DeviceRequest.RequestPriority.ASAP;
    case STAT: return org.hl7.fhir.r5.model.DeviceRequest.RequestPriority.STAT;
    default: return org.hl7.fhir.r5.model.DeviceRequest.RequestPriority.NULL;
  }
}

  public static org.hl7.fhir.r4.model.DeviceRequest.RequestPriority convertRequestPriority(org.hl7.fhir.r5.model.DeviceRequest.RequestPriority src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ROUTINE: return org.hl7.fhir.r4.model.DeviceRequest.RequestPriority.ROUTINE;
    case URGENT: return org.hl7.fhir.r4.model.DeviceRequest.RequestPriority.URGENT;
    case ASAP: return org.hl7.fhir.r4.model.DeviceRequest.RequestPriority.ASAP;
    case STAT: return org.hl7.fhir.r4.model.DeviceRequest.RequestPriority.STAT;
    default: return org.hl7.fhir.r4.model.DeviceRequest.RequestPriority.NULL;
  }
}

  public static org.hl7.fhir.r5.model.DeviceRequest.DeviceRequestParameterComponent convertDeviceRequestParameterComponent(org.hl7.fhir.r4.model.DeviceRequest.DeviceRequestParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DeviceRequest.DeviceRequestParameterComponent tgt = new org.hl7.fhir.r5.model.DeviceRequest.DeviceRequestParameterComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasValue())
      tgt.setValue(convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DeviceRequest.DeviceRequestParameterComponent convertDeviceRequestParameterComponent(org.hl7.fhir.r5.model.DeviceRequest.DeviceRequestParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DeviceRequest.DeviceRequestParameterComponent tgt = new org.hl7.fhir.r4.model.DeviceRequest.DeviceRequestParameterComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasValue())
      tgt.setValue(convertType(src.getValue()));
    return tgt;
  }


}
