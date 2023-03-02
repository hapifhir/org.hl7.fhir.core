package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Annotation40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Duration40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Period40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.SimpleQuantity40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.UnsignedInt40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Dosage40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.exceptions.FHIRException;

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
public class MedicationRequest40_50 {

  public static org.hl7.fhir.r5.model.MedicationRequest convertMedicationRequest(org.hl7.fhir.r4.model.MedicationRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationRequest tgt = new org.hl7.fhir.r5.model.MedicationRequest();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationRequestStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept40_50.convertCodeableConcept(src.getStatusReason()));
    if (src.hasIntent())
      tgt.setIntentElement(convertMedicationRequestIntent(src.getIntentElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriorityElement(convertMedicationRequestPriority(src.getPriorityElement()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(Boolean40_50.convertBoolean(src.getDoNotPerformElement()));
    if (src.hasReportedBooleanType())
      tgt.setReportedElement(Boolean40_50.convertBoolean(src.getReportedBooleanType()));
    if (src.hasReportedReference())
      tgt.addInformationSource(Reference40_50.convertReference(src.getReportedReference()));
    if (src.hasMedicationCodeableConcept())
      tgt.getMedication().setConcept(CodeableConcept40_50.convertCodeableConcept(src.getMedicationCodeableConcept()));
    if (src.hasMedicationReference())
      tgt.getMedication().setReference(Reference40_50.convertReference(src.getMedicationReference()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_50.convertReference(src.getEncounter()));
    for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(Reference40_50.convertReference(t));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime40_50.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(Reference40_50.convertReference(src.getRequester()));
    if (src.hasPerformer())
      tgt.addPerformer(Reference40_50.convertReference(src.getPerformer()));
    if (src.hasPerformerType())
      tgt.setPerformerType(CodeableConcept40_50.convertCodeableConcept(src.getPerformerType()));
    if (src.hasRecorder())
      tgt.setRecorder(Reference40_50.convertReference(src.getRecorder()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason().setConcept(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReason().setReference(Reference40_50.convertReference(t));
//    for (org.hl7.fhir.r4.model.CanonicalType t : src.getInstantiatesCanonical())
//      tgt.getInstantiatesCanonical().add(Canonical40_50.convertCanonical(t));
//    for (org.hl7.fhir.r4.model.UriType t : src.getInstantiatesUri())
//      tgt.getInstantiatesUri().add(Uri40_50.convertUri(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_50.convertReference(t));
    if (src.hasGroupIdentifier())
      tgt.setGroupIdentifier(Identifier40_50.convertIdentifier(src.getGroupIdentifier()));
    if (src.hasCourseOfTherapyType())
      tgt.setCourseOfTherapyType(CodeableConcept40_50.convertCodeableConcept(src.getCourseOfTherapyType()));
    for (org.hl7.fhir.r4.model.Reference t : src.getInsurance()) tgt.addInsurance(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
    for (org.hl7.fhir.r4.model.Dosage t : src.getDosageInstruction())
      tgt.addDosageInstruction(Dosage40_50.convertDosage(t));
    if (src.hasDispenseRequest())
      tgt.setDispenseRequest(convertMedicationRequestDispenseRequestComponent(src.getDispenseRequest()));
    if (src.hasSubstitution())
      tgt.setSubstitution(convertMedicationRequestSubstitutionComponent(src.getSubstitution()));
    if (src.hasPriorPrescription())
      tgt.setPriorPrescription(Reference40_50.convertReference(src.getPriorPrescription()));
    for (org.hl7.fhir.r4.model.Reference t : src.getDetectedIssue())
//      tgt.addDetectedIssue(Reference40_50.convertReference(t));
//    for (org.hl7.fhir.r4.model.Reference t : src.getEventHistory())
      tgt.addEventHistory(Reference40_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationRequest convertMedicationRequest(org.hl7.fhir.r5.model.MedicationRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicationRequest tgt = new org.hl7.fhir.r4.model.MedicationRequest();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationRequestStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept40_50.convertCodeableConcept(src.getStatusReason()));
    if (src.hasIntent())
      tgt.setIntentElement(convertMedicationRequestIntent(src.getIntentElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriorityElement(convertMedicationRequestPriority(src.getPriorityElement()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(Boolean40_50.convertBoolean(src.getDoNotPerformElement()));
    if (src.hasReported())
      tgt.setReported(Boolean40_50.convertBoolean(src.getReportedElement()));
    if (src.hasInformationSource())
      tgt.setReported(Reference40_50.convertReference(src.getInformationSourceFirstRep()));
    if (src.getMedication().hasReference())
      tgt.setMedication(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getMedication().getReference()));
    if (src.getMedication().hasConcept())
      tgt.setMedication(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getMedication().getConcept()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_50.convertReference(src.getEncounter()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(Reference40_50.convertReference(t));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime40_50.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(Reference40_50.convertReference(src.getRequester()));
    if (src.hasPerformer())
      tgt.setPerformer(Reference40_50.convertReference(src.getPerformerFirstRep()));
    if (src.hasPerformerType())
      tgt.setPerformerType(CodeableConcept40_50.convertCodeableConcept(src.getPerformerType()));
    if (src.hasRecorder())
      tgt.setRecorder(Reference40_50.convertReference(src.getRecorder()));
    for (org.hl7.fhir.r5.model.CodeableReference t : src.getReason()) {
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept40_50.convertCodeableConcept(t.getConcept()));
      if (t.hasReference())
        tgt.addReasonReference(Reference40_50.convertReference(t.getReference()));
    }
//    for (org.hl7.fhir.r5.model.CanonicalType t : src.getInstantiatesCanonical())
//      tgt.getInstantiatesCanonical().add(Canonical40_50.convertCanonical(t));
//    for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesUri())
//      tgt.getInstantiatesUri().add(Uri40_50.convertUri(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_50.convertReference(t));
    if (src.hasGroupIdentifier())
      tgt.setGroupIdentifier(Identifier40_50.convertIdentifier(src.getGroupIdentifier()));
    if (src.hasCourseOfTherapyType())
      tgt.setCourseOfTherapyType(CodeableConcept40_50.convertCodeableConcept(src.getCourseOfTherapyType()));
    for (org.hl7.fhir.r5.model.Reference t : src.getInsurance()) tgt.addInsurance(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
    for (org.hl7.fhir.r5.model.Dosage t : src.getDosageInstruction())
      tgt.addDosageInstruction(Dosage40_50.convertDosage(t));
    if (src.hasDispenseRequest())
      tgt.setDispenseRequest(convertMedicationRequestDispenseRequestComponent(src.getDispenseRequest()));
    if (src.hasSubstitution())
      tgt.setSubstitution(convertMedicationRequestSubstitutionComponent(src.getSubstitution()));
    if (src.hasPriorPrescription())
      tgt.setPriorPrescription(Reference40_50.convertReference(src.getPriorPrescription()));
//    for (org.hl7.fhir.r5.model.Reference t : src.getDetectedIssue())
//      tgt.addDetectedIssue(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getEventHistory())
      tgt.addEventHistory(Reference40_50.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus> convertMedicationRequestStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.ACTIVE);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.ONHOLD);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.CANCELLED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.ENTEREDINERROR);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.STOPPED);
        break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.DRAFT);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus> convertMedicationRequestStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.ACTIVE);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.ONHOLD);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.CANCELLED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.ENTEREDINERROR);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.STOPPED);
        break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.DRAFT);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent> convertMedicationRequestIntent(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntentEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROPOSAL:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.PROPOSAL);
        break;
      case PLAN:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.PLAN);
        break;
      case ORDER:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.ORDER);
        break;
      case ORIGINALORDER:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.ORIGINALORDER);
        break;
      case REFLEXORDER:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.REFLEXORDER);
        break;
      case FILLERORDER:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.FILLERORDER);
        break;
      case INSTANCEORDER:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.INSTANCEORDER);
        break;
      case OPTION:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.OPTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent> convertMedicationRequestIntent(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntentEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROPOSAL:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.PROPOSAL);
        break;
      case PLAN:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.PLAN);
        break;
      case ORDER:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.ORDER);
        break;
      case ORIGINALORDER:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.ORIGINALORDER);
        break;
      case REFLEXORDER:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.REFLEXORDER);
        break;
      case FILLERORDER:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.FILLERORDER);
        break;
      case INSTANCEORDER:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.INSTANCEORDER);
        break;
      case OPTION:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.OPTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> convertMedicationRequestPriority(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestPriorityEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority> convertMedicationRequestPriority(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriorityEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ROUTINE:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority.ROUTINE);
        break;
      case URGENT:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority.URGENT);
        break;
      case ASAP:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority.ASAP);
        break;
      case STAT:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority.STAT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestComponent convertMedicationRequestDispenseRequestComponent(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestComponent tgt = new org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasInitialFill())
      tgt.setInitialFill(convertMedicationRequestDispenseRequestInitialFillComponent(src.getInitialFill()));
    if (src.hasDispenseInterval())
      tgt.setDispenseInterval(Duration40_50.convertDuration(src.getDispenseInterval()));
    if (src.hasValidityPeriod())
      tgt.setValidityPeriod(Period40_50.convertPeriod(src.getValidityPeriod()));
    if (src.hasNumberOfRepeatsAllowed())
      tgt.setNumberOfRepeatsAllowedElement(UnsignedInt40_50.convertUnsignedInt(src.getNumberOfRepeatsAllowedElement()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasExpectedSupplyDuration())
      tgt.setExpectedSupplyDuration(Duration40_50.convertDuration(src.getExpectedSupplyDuration()));
    if (src.hasPerformer())
      tgt.setDispenser(Reference40_50.convertReference(src.getPerformer()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestComponent convertMedicationRequestDispenseRequestComponent(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestComponent tgt = new org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasInitialFill())
      tgt.setInitialFill(convertMedicationRequestDispenseRequestInitialFillComponent(src.getInitialFill()));
    if (src.hasDispenseInterval())
      tgt.setDispenseInterval(Duration40_50.convertDuration(src.getDispenseInterval()));
    if (src.hasValidityPeriod())
      tgt.setValidityPeriod(Period40_50.convertPeriod(src.getValidityPeriod()));
    if (src.hasNumberOfRepeatsAllowed())
      tgt.setNumberOfRepeatsAllowedElement(UnsignedInt40_50.convertUnsignedInt(src.getNumberOfRepeatsAllowedElement()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasExpectedSupplyDuration())
      tgt.setExpectedSupplyDuration(Duration40_50.convertDuration(src.getExpectedSupplyDuration()));
    if (src.hasDispenser())
      tgt.setPerformer(Reference40_50.convertReference(src.getDispenser()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent convertMedicationRequestDispenseRequestInitialFillComponent(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent tgt = new org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasDuration())
      tgt.setDuration(Duration40_50.convertDuration(src.getDuration()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent convertMedicationRequestDispenseRequestInitialFillComponent(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent tgt = new org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasDuration())
      tgt.setDuration(Duration40_50.convertDuration(src.getDuration()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestSubstitutionComponent convertMedicationRequestSubstitutionComponent(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestSubstitutionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestSubstitutionComponent tgt = new org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestSubstitutionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasAllowed())
      tgt.setAllowed(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getAllowed()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept40_50.convertCodeableConcept(src.getReason()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestSubstitutionComponent convertMedicationRequestSubstitutionComponent(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestSubstitutionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestSubstitutionComponent tgt = new org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestSubstitutionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasAllowed())
      tgt.setAllowed(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getAllowed()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept40_50.convertCodeableConcept(src.getReason()));
    return tgt;
  }
}