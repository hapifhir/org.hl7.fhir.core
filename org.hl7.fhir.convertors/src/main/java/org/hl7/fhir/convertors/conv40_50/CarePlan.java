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


public class CarePlan extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.CarePlan convertCarePlan(org.hl7.fhir.r4.model.CarePlan src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CarePlan tgt = new org.hl7.fhir.r5.model.CarePlan();
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
    for (org.hl7.fhir.r4.model.Reference t : src.getPartOf())
      tgt.addPartOf(convertReference(t));
    if (src.hasStatus())
      tgt.setStatus(convertCarePlanStatus(src.getStatus()));
    if (src.hasIntent())
      tgt.setIntent(convertCarePlanIntent(src.getIntent()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(convertCodeableConcept(t));
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(convertReference(src.getEncounter()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    if (src.hasCreated())
      tgt.setCreatedElement(convertDateTime(src.getCreatedElement()));
    if (src.hasAuthor())
      tgt.setAuthor(convertReference(src.getAuthor()));
    for (org.hl7.fhir.r4.model.Reference t : src.getContributor())
      tgt.addContributor(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getCareTeam())
      tgt.addCareTeam(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getAddresses())
      tgt.addAddresses(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInfo())
      tgt.addSupportingInfo(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getGoal())
      tgt.addGoal(convertReference(t));
    for (org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent t : src.getActivity())
      tgt.addActivity(convertCarePlanActivityComponent(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CarePlan convertCarePlan(org.hl7.fhir.r5.model.CarePlan src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CarePlan tgt = new org.hl7.fhir.r4.model.CarePlan();
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
    for (org.hl7.fhir.r5.model.Reference t : src.getPartOf())
      tgt.addPartOf(convertReference(t));
    if (src.hasStatus())
      tgt.setStatus(convertCarePlanStatus(src.getStatus()));
    if (src.hasIntent())
      tgt.setIntent(convertCarePlanIntent(src.getIntent()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(convertCodeableConcept(t));
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(convertReference(src.getEncounter()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    if (src.hasCreated())
      tgt.setCreatedElement(convertDateTime(src.getCreatedElement()));
    if (src.hasAuthor())
      tgt.setAuthor(convertReference(src.getAuthor()));
    for (org.hl7.fhir.r5.model.Reference t : src.getContributor())
      tgt.addContributor(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getCareTeam())
      tgt.addCareTeam(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getAddresses())
      tgt.addAddresses(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInfo())
      tgt.addSupportingInfo(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getGoal())
      tgt.addGoal(convertReference(t));
    for (org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent t : src.getActivity())
      tgt.addActivity(convertCarePlanActivityComponent(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CarePlan.CarePlanStatus convertCarePlanStatus(org.hl7.fhir.r4.model.CarePlan.CarePlanStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DRAFT: return org.hl7.fhir.r5.model.CarePlan.CarePlanStatus.DRAFT;
    case ACTIVE: return org.hl7.fhir.r5.model.CarePlan.CarePlanStatus.ACTIVE;
    case ONHOLD: return org.hl7.fhir.r5.model.CarePlan.CarePlanStatus.ONHOLD;
    case REVOKED: return org.hl7.fhir.r5.model.CarePlan.CarePlanStatus.REVOKED;
    case COMPLETED: return org.hl7.fhir.r5.model.CarePlan.CarePlanStatus.COMPLETED;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.CarePlan.CarePlanStatus.ENTEREDINERROR;
    case UNKNOWN: return org.hl7.fhir.r5.model.CarePlan.CarePlanStatus.UNKNOWN;
    default: return org.hl7.fhir.r5.model.CarePlan.CarePlanStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.CarePlan.CarePlanStatus convertCarePlanStatus(org.hl7.fhir.r5.model.CarePlan.CarePlanStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DRAFT: return org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.DRAFT;
    case ACTIVE: return org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.ACTIVE;
    case ONHOLD: return org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.ONHOLD;
    case REVOKED: return org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.REVOKED;
    case COMPLETED: return org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.COMPLETED;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.ENTEREDINERROR;
    case UNKNOWN: return org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.UNKNOWN;
    default: return org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.CarePlan.CarePlanIntent convertCarePlanIntent(org.hl7.fhir.r4.model.CarePlan.CarePlanIntent src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PROPOSAL: return org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.PROPOSAL;
    case PLAN: return org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.PLAN;
    case ORDER: return org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.ORDER;
    case OPTION: return org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.OPTION;
    default: return org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.NULL;
  }
}

  public static org.hl7.fhir.r4.model.CarePlan.CarePlanIntent convertCarePlanIntent(org.hl7.fhir.r5.model.CarePlan.CarePlanIntent src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PROPOSAL: return org.hl7.fhir.r4.model.CarePlan.CarePlanIntent.PROPOSAL;
    case PLAN: return org.hl7.fhir.r4.model.CarePlan.CarePlanIntent.PLAN;
    case ORDER: return org.hl7.fhir.r4.model.CarePlan.CarePlanIntent.ORDER;
    case OPTION: return org.hl7.fhir.r4.model.CarePlan.CarePlanIntent.OPTION;
    default: return org.hl7.fhir.r4.model.CarePlan.CarePlanIntent.NULL;
  }
}

  public static org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent convertCarePlanActivityComponent(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent tgt = new org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getOutcomeCodeableConcept())
      tgt.addOutcomeCodeableConcept(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getOutcomeReference())
      tgt.addOutcomeReference(convertReference(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getProgress())
      tgt.addProgress(convertAnnotation(t));
    if (src.hasReference())
      tgt.setReference(convertReference(src.getReference()));
    if (src.hasDetail())
      tgt.setDetail(convertCarePlanActivityDetailComponent(src.getDetail()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent convertCarePlanActivityComponent(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent tgt = new org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getOutcomeCodeableConcept())
      tgt.addOutcomeCodeableConcept(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getOutcomeReference())
      tgt.addOutcomeReference(convertReference(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getProgress())
      tgt.addProgress(convertAnnotation(t));
    if (src.hasReference())
      tgt.setReference(convertReference(src.getReference()));
    if (src.hasDetail())
      tgt.setDetail(convertCarePlanActivityDetailComponent(src.getDetail()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CarePlan.CarePlanActivityDetailComponent convertCarePlanActivityDetailComponent(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CarePlan.CarePlanActivityDetailComponent tgt = new org.hl7.fhir.r5.model.CarePlan.CarePlanActivityDetailComponent();
    copyElement(src, tgt);
    if (src.hasKind())
      tgt.setKind(convertCarePlanActivityKind(src.getKind()));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(convertCanonical(t));
    for (org.hl7.fhir.r4.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(convertUri(t));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getGoal())
      tgt.addGoal(convertReference(t));
    if (src.hasStatus())
      tgt.setStatus(convertCarePlanActivityStatus(src.getStatus()));
    if (src.hasStatusReason())
      tgt.setStatusReason(convertCodeableConcept(src.getStatusReason()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(convertBoolean(src.getDoNotPerformElement()));
    if (src.hasScheduled())
      tgt.setScheduled(convertType(src.getScheduled()));
    if (src.hasLocation())
      tgt.setLocation(convertReference(src.getLocation()));
    for (org.hl7.fhir.r4.model.Reference t : src.getPerformer())
      tgt.addPerformer(convertReference(t));
    if (src.hasProduct())
      tgt.setProduct(convertType(src.getProduct()));
    if (src.hasDailyAmount())
      tgt.setDailyAmount(convertSimpleQuantity(src.getDailyAmount()));
    if (src.hasQuantity())
      tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CarePlan.CarePlanActivityDetailComponent convertCarePlanActivityDetailComponent(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CarePlan.CarePlanActivityDetailComponent tgt = new org.hl7.fhir.r4.model.CarePlan.CarePlanActivityDetailComponent();
    copyElement(src, tgt);
    if (src.hasKind())
      tgt.setKind(convertCarePlanActivityKind(src.getKind()));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(convertCanonical(t));
    for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(convertUri(t));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getGoal())
      tgt.addGoal(convertReference(t));
    if (src.hasStatus())
      tgt.setStatus(convertCarePlanActivityStatus(src.getStatus()));
    if (src.hasStatusReason())
      tgt.setStatusReason(convertCodeableConcept(src.getStatusReason()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(convertBoolean(src.getDoNotPerformElement()));
    if (src.hasScheduled())
      tgt.setScheduled(convertType(src.getScheduled()));
    if (src.hasLocation())
      tgt.setLocation(convertReference(src.getLocation()));
    for (org.hl7.fhir.r5.model.Reference t : src.getPerformer())
      tgt.addPerformer(convertReference(t));
    if (src.hasProduct())
      tgt.setProduct(convertType(src.getProduct()));
    if (src.hasDailyAmount())
      tgt.setDailyAmount(convertSimpleQuantity(src.getDailyAmount()));
    if (src.hasQuantity())
      tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind convertCarePlanActivityKind(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case APPOINTMENT: return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.APPOINTMENT;
    case COMMUNICATIONREQUEST: return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.COMMUNICATIONREQUEST;
    case DEVICEREQUEST: return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.DEVICEREQUEST;
    case MEDICATIONREQUEST: return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.MEDICATIONREQUEST;
    case NUTRITIONORDER: return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.NUTRITIONORDER;
    case TASK: return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.TASK;
    case SERVICEREQUEST: return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.SERVICEREQUEST;
    case VISIONPRESCRIPTION: return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.VISIONPRESCRIPTION;
    default: return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.NULL;
  }
}

  public static org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind convertCarePlanActivityKind(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case APPOINTMENT: return org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.APPOINTMENT;
    case COMMUNICATIONREQUEST: return org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.COMMUNICATIONREQUEST;
    case DEVICEREQUEST: return org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.DEVICEREQUEST;
    case MEDICATIONREQUEST: return org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.MEDICATIONREQUEST;
    case NUTRITIONORDER: return org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.NUTRITIONORDER;
    case TASK: return org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.TASK;
    case SERVICEREQUEST: return org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.SERVICEREQUEST;
    case VISIONPRESCRIPTION: return org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.VISIONPRESCRIPTION;
    default: return org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.NULL;
  }
}

  public static org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus convertCarePlanActivityStatus(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case NOTSTARTED: return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.NOTSTARTED;
    case SCHEDULED: return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.SCHEDULED;
    case INPROGRESS: return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.INPROGRESS;
    case ONHOLD: return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.ONHOLD;
    case COMPLETED: return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.COMPLETED;
    case CANCELLED: return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.CANCELLED;
    case STOPPED: return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.STOPPED;
    case UNKNOWN: return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.UNKNOWN;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus convertCarePlanActivityStatus(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case NOTSTARTED: return org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.NOTSTARTED;
    case SCHEDULED: return org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.SCHEDULED;
    case INPROGRESS: return org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.INPROGRESS;
    case ONHOLD: return org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.ONHOLD;
    case COMPLETED: return org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.COMPLETED;
    case CANCELLED: return org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.CANCELLED;
    case STOPPED: return org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.STOPPED;
    case UNKNOWN: return org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.UNKNOWN;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.NULL;
  }
}


}
