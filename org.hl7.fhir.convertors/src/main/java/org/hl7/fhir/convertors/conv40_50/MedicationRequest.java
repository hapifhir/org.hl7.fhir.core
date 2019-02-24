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


public class MedicationRequest extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.MedicationRequest convertMedicationRequest(org.hl7.fhir.r4.model.MedicationRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationRequest tgt = new org.hl7.fhir.r5.model.MedicationRequest();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertMedicationRequestStatus(src.getStatus()));
    if (src.hasStatusReason())
      tgt.setStatusReason(convertCodeableConcept(src.getStatusReason()));
    if (src.hasIntent())
      tgt.setIntent(convertMedicationRequestIntent(src.getIntent()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriority(convertMedicationRequestPriority(src.getPriority()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(convertBoolean(src.getDoNotPerformElement()));
    if (src.hasReported())
      tgt.setReported(convertType(src.getReported()));
    if (src.hasMedication())
      tgt.setMedication(convertType(src.getMedication()));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(convertReference(src.getEncounter()));
    for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(convertReference(t));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(convertReference(src.getRequester()));
    if (src.hasPerformer())
      tgt.setPerformer(convertReference(src.getPerformer()));
    if (src.hasPerformerType())
      tgt.setPerformerType(convertCodeableConcept(src.getPerformerType()));
    if (src.hasRecorder())
      tgt.setRecorder(convertReference(src.getRecorder()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(convertReference(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(convertCanonical(t));
    for (org.hl7.fhir.r4.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(convertUri(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn())
      tgt.addBasedOn(convertReference(t));
    if (src.hasGroupIdentifier())
      tgt.setGroupIdentifier(convertIdentifier(src.getGroupIdentifier()));
    if (src.hasCourseOfTherapyType())
      tgt.setCourseOfTherapyType(convertCodeableConcept(src.getCourseOfTherapyType()));
    for (org.hl7.fhir.r4.model.Reference t : src.getInsurance())
      tgt.addInsurance(convertReference(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    for (org.hl7.fhir.r4.model.Dosage t : src.getDosageInstruction())
      tgt.addDosageInstruction(convertDosage(t));
    if (src.hasDispenseRequest())
      tgt.setDispenseRequest(convertMedicationRequestDispenseRequestComponent(src.getDispenseRequest()));
    if (src.hasSubstitution())
      tgt.setSubstitution(convertMedicationRequestSubstitutionComponent(src.getSubstitution()));
    if (src.hasPriorPrescription())
      tgt.setPriorPrescription(convertReference(src.getPriorPrescription()));
    for (org.hl7.fhir.r4.model.Reference t : src.getDetectedIssue())
      tgt.addDetectedIssue(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getEventHistory())
      tgt.addEventHistory(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationRequest convertMedicationRequest(org.hl7.fhir.r5.model.MedicationRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicationRequest tgt = new org.hl7.fhir.r4.model.MedicationRequest();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertMedicationRequestStatus(src.getStatus()));
    if (src.hasStatusReason())
      tgt.setStatusReason(convertCodeableConcept(src.getStatusReason()));
    if (src.hasIntent())
      tgt.setIntent(convertMedicationRequestIntent(src.getIntent()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriority(convertMedicationRequestPriority(src.getPriority()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(convertBoolean(src.getDoNotPerformElement()));
    if (src.hasReported())
      tgt.setReported(convertType(src.getReported()));
    if (src.hasMedication())
      tgt.setMedication(convertType(src.getMedication()));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(convertReference(src.getEncounter()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(convertReference(t));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(convertReference(src.getRequester()));
    if (src.hasPerformer())
      tgt.setPerformer(convertReference(src.getPerformer()));
    if (src.hasPerformerType())
      tgt.setPerformerType(convertCodeableConcept(src.getPerformerType()));
    if (src.hasRecorder())
      tgt.setRecorder(convertReference(src.getRecorder()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(convertReference(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(convertCanonical(t));
    for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(convertUri(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn())
      tgt.addBasedOn(convertReference(t));
    if (src.hasGroupIdentifier())
      tgt.setGroupIdentifier(convertIdentifier(src.getGroupIdentifier()));
    if (src.hasCourseOfTherapyType())
      tgt.setCourseOfTherapyType(convertCodeableConcept(src.getCourseOfTherapyType()));
    for (org.hl7.fhir.r5.model.Reference t : src.getInsurance())
      tgt.addInsurance(convertReference(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    for (org.hl7.fhir.r5.model.Dosage t : src.getDosageInstruction())
      tgt.addDosageInstruction(convertDosage(t));
    if (src.hasDispenseRequest())
      tgt.setDispenseRequest(convertMedicationRequestDispenseRequestComponent(src.getDispenseRequest()));
    if (src.hasSubstitution())
      tgt.setSubstitution(convertMedicationRequestSubstitutionComponent(src.getSubstitution()));
    if (src.hasPriorPrescription())
      tgt.setPriorPrescription(convertReference(src.getPriorPrescription()));
    for (org.hl7.fhir.r5.model.Reference t : src.getDetectedIssue())
      tgt.addDetectedIssue(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getEventHistory())
      tgt.addEventHistory(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestStatus convertMedicationRequestStatus(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ACTIVE: return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestStatus.ACTIVE;
    case ONHOLD: return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestStatus.ONHOLD;
    case CANCELLED: return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestStatus.CANCELLED;
    case COMPLETED: return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestStatus.COMPLETED;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestStatus.ENTEREDINERROR;
    case STOPPED: return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestStatus.STOPPED;
    case DRAFT: return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestStatus.DRAFT;
    case UNKNOWN: return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestStatus.UNKNOWN;
    default: return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus convertMedicationRequestStatus(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ACTIVE: return org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.ACTIVE;
    case ONHOLD: return org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.ONHOLD;
    case CANCELLED: return org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.CANCELLED;
    case COMPLETED: return org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.COMPLETED;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.ENTEREDINERROR;
    case STOPPED: return org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.STOPPED;
    case DRAFT: return org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.DRAFT;
    case UNKNOWN: return org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.UNKNOWN;
    default: return org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent convertMedicationRequestIntent(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PROPOSAL: return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.PROPOSAL;
    case PLAN: return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.PLAN;
    case ORDER: return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.ORDER;
    case ORIGINALORDER: return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.ORIGINALORDER;
    case REFLEXORDER: return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.REFLEXORDER;
    case FILLERORDER: return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.FILLERORDER;
    case INSTANCEORDER: return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.INSTANCEORDER;
    case OPTION: return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.OPTION;
    default: return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.NULL;
  }
}

  public static org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent convertMedicationRequestIntent(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PROPOSAL: return org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.PROPOSAL;
    case PLAN: return org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.PLAN;
    case ORDER: return org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.ORDER;
    case ORIGINALORDER: return org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.ORIGINALORDER;
    case REFLEXORDER: return org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.REFLEXORDER;
    case FILLERORDER: return org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.FILLERORDER;
    case INSTANCEORDER: return org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.INSTANCEORDER;
    case OPTION: return org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.OPTION;
    default: return org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.NULL;
  }
}

  public static org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestPriority convertMedicationRequestPriority(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ROUTINE: return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestPriority.ROUTINE;
    case URGENT: return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestPriority.URGENT;
    case ASAP: return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestPriority.ASAP;
    case STAT: return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestPriority.STAT;
    default: return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestPriority.NULL;
  }
}

  public static org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority convertMedicationRequestPriority(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestPriority src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ROUTINE: return org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority.ROUTINE;
    case URGENT: return org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority.URGENT;
    case ASAP: return org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority.ASAP;
    case STAT: return org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority.STAT;
    default: return org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority.NULL;
  }
}

  public static org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestComponent convertMedicationRequestDispenseRequestComponent(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestComponent tgt = new org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestComponent();
    copyElement(src, tgt);
    if (src.hasInitialFill())
      tgt.setInitialFill(convertMedicationRequestDispenseRequestInitialFillComponent(src.getInitialFill()));
    if (src.hasDispenseInterval())
      tgt.setDispenseInterval(convertDuration(src.getDispenseInterval()));
    if (src.hasValidityPeriod())
      tgt.setValidityPeriod(convertPeriod(src.getValidityPeriod()));
    if (src.hasNumberOfRepeatsAllowed())
      tgt.setNumberOfRepeatsAllowedElement(convertUnsignedInt(src.getNumberOfRepeatsAllowedElement()));
    if (src.hasQuantity())
      tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
    if (src.hasExpectedSupplyDuration())
      tgt.setExpectedSupplyDuration(convertDuration(src.getExpectedSupplyDuration()));
    if (src.hasPerformer())
      tgt.setPerformer(convertReference(src.getPerformer()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestComponent convertMedicationRequestDispenseRequestComponent(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestComponent tgt = new org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestComponent();
    copyElement(src, tgt);
    if (src.hasInitialFill())
      tgt.setInitialFill(convertMedicationRequestDispenseRequestInitialFillComponent(src.getInitialFill()));
    if (src.hasDispenseInterval())
      tgt.setDispenseInterval(convertDuration(src.getDispenseInterval()));
    if (src.hasValidityPeriod())
      tgt.setValidityPeriod(convertPeriod(src.getValidityPeriod()));
    if (src.hasNumberOfRepeatsAllowed())
      tgt.setNumberOfRepeatsAllowedElement(convertUnsignedInt(src.getNumberOfRepeatsAllowedElement()));
    if (src.hasQuantity())
      tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
    if (src.hasExpectedSupplyDuration())
      tgt.setExpectedSupplyDuration(convertDuration(src.getExpectedSupplyDuration()));
    if (src.hasPerformer())
      tgt.setPerformer(convertReference(src.getPerformer()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent convertMedicationRequestDispenseRequestInitialFillComponent(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent tgt = new org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent();
    copyElement(src, tgt);
    if (src.hasQuantity())
      tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
    if (src.hasDuration())
      tgt.setDuration(convertDuration(src.getDuration()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent convertMedicationRequestDispenseRequestInitialFillComponent(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent tgt = new org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent();
    copyElement(src, tgt);
    if (src.hasQuantity())
      tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
    if (src.hasDuration())
      tgt.setDuration(convertDuration(src.getDuration()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestSubstitutionComponent convertMedicationRequestSubstitutionComponent(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestSubstitutionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestSubstitutionComponent tgt = new org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestSubstitutionComponent();
    copyElement(src, tgt);
    if (src.hasAllowed())
      tgt.setAllowed(convertType(src.getAllowed()));
    if (src.hasReason())
      tgt.setReason(convertCodeableConcept(src.getReason()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestSubstitutionComponent convertMedicationRequestSubstitutionComponent(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestSubstitutionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestSubstitutionComponent tgt = new org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestSubstitutionComponent();
    copyElement(src, tgt);
    if (src.hasAllowed())
      tgt.setAllowed(convertType(src.getAllowed()));
    if (src.hasReason())
      tgt.setReason(convertCodeableConcept(src.getReason()));
    return tgt;
  }


}
