package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Annotation43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Duration43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Period43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.SimpleQuantity43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.UnsignedInt43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Dosage43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.DosageDetails;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;
import org.hl7.fhir.model.core.MedicationRequest;

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

public class MedicationRequest43_N {

  public static org.hl7.fhir.model.core.MedicationRequest convertMedicationRequest(org.hl7.fhir.r4b.model.MedicationRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MedicationRequest tgt = new org.hl7.fhir.model.core.MedicationRequest();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationRequestStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept43_N.convertCodeableConcept(src.getStatusReason()));
    if (src.hasIntent())
      tgt.setIntentElement(convertMedicationRequestIntent(src.getIntentElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriorityElement(convertMedicationRequestPriority(src.getPriorityElement()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(Boolean43_N.convertBoolean(src.getDoNotPerformElement()));
    if (src.hasReportedBooleanType())
      tgt.setIsRecordOfRequestElement(Boolean43_N.convertBoolean(src.getReportedBooleanType()));
    if (src.hasReportedReference())
      tgt.addInformationSource(Reference43_N.convertReference(src.getReportedReference()));
    if (src.hasMedicationCodeableConcept())
      tgt.getMedication().setConcept(CodeableConcept43_N.convertCodeableConcept(src.getMedicationCodeableConcept()));
    if (src.hasMedicationReference())
      tgt.getMedication().setReference(Reference43_N.convertReference(src.getMedicationReference()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(Reference43_N.convertReference(t));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime43_N.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(Reference43_N.convertReference(src.getRequester()));
    if (src.hasPerformer())
      tgt.addPerformer(Reference43_N.convertReference(src.getPerformer()));
    if (src.hasPerformerType())
      tgt.setPerformerType(CodeableConcept43_N.convertCodeableConcept(src.getPerformerType()));
    if (src.hasRecorder())
      tgt.setRecorder(Reference43_N.convertReference(src.getRecorder()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason().setConcept(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
      tgt.addReason().setReference(Reference43_N.convertReference(t));
//    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getInstantiatesCanonical())
//      tgt.getInstantiatesCanonical().add(Canonical43_N.convertCanonical(t));
//    for (org.hl7.fhir.r4b.model.UriType t : src.getInstantiatesUri())
//      tgt.getInstantiatesUri().add(Uri43_N.convertUri(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_N.convertReference(t));
    if (src.hasGroupIdentifier())
      tgt.setGroupIdentifier(Identifier43_N.convertIdentifier(src.getGroupIdentifier()));
    if (src.hasCourseOfTherapyType())
      tgt.setCourseOfTherapyType(CodeableConcept43_N.convertCodeableConcept(src.getCourseOfTherapyType()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getInsurance()) tgt.addInsurance(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    for (org.hl7.fhir.r4b.model.Dosage t : src.getDosageInstruction())
      tgt.getDosageInstruction().getStepFirstRep().addComponent(Dosage43_N.convertDosage(t));
    if (src.hasDispenseRequest())
      tgt.setDispenseRequest(convertMedicationRequestDispenseRequestComponent(src.getDispenseRequest()));
    if (src.hasSubstitution())
      tgt.setSubstitution(convertMedicationRequestSubstitutionComponent(src.getSubstitution()));
    if (src.hasPriorPrescription())
      tgt.setPriorPrescription(Reference43_N.convertReference(src.getPriorPrescription()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getDetectedIssue())
//      tgt.addDetectedIssue(Reference43_N.convertReference(t));
//    for (org.hl7.fhir.r4b.model.Reference t : src.getEventHistory())
      tgt.addEventHistory(Reference43_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MedicationRequest convertMedicationRequest(org.hl7.fhir.model.core.MedicationRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MedicationRequest tgt = new org.hl7.fhir.r4b.model.MedicationRequest();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationRequestStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept43_N.convertCodeableConcept(src.getStatusReason()));
    if (src.hasIntent())
      tgt.setIntentElement(convertMedicationRequestIntent(src.getIntentElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriorityElement(convertMedicationRequestPriority(src.getPriorityElement()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(Boolean43_N.convertBoolean(src.getDoNotPerformElement()));
    if (src.hasIsRecordOfRequest())
      tgt.setReported(Boolean43_N.convertBoolean(src.getIsRecordOfRequestElement()));
    if (src.hasInformationSource())
      tgt.setReported(Reference43_N.convertReference(src.getInformationSourceFirstRep()));
    if (src.getMedication().hasReference())
      tgt.setMedication(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getMedication().getReference()));
    if (src.getMedication().hasConcept())
      tgt.setMedication(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getMedication().getConcept()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    for (org.hl7.fhir.model.core.Reference t : src.getSupportingInformationList())
      tgt.addSupportingInformation(Reference43_N.convertReference(t));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime43_N.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(Reference43_N.convertReference(src.getRequester()));
    if (src.hasPerformer())
      tgt.setPerformer(Reference43_N.convertReference(src.getPerformerFirstRep()));
    if (src.hasPerformerType())
      tgt.setPerformerType(CodeableConcept43_N.convertCodeableConcept(src.getPerformerType()));
    if (src.hasRecorder())
      tgt.setRecorder(Reference43_N.convertReference(src.getRecorder()));
    for (org.hl7.fhir.model.core.CodeableReference t : src.getReasonList()) {
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept43_N.convertCodeableConcept(t.getConcept()));
      if (t.hasReference())
        tgt.addReasonReference(Reference43_N.convertReference(t.getReference()));
    }
//    for (org.hl7.fhir.model.core.CanonicalType t : src.getInstantiatesCanonicalList())
//      tgt.getInstantiatesCanonical().add(Canonical43_N.convertCanonical(t));
//    for (org.hl7.fhir.model.core.UriType t : src.getInstantiatesUriList())
//      tgt.getInstantiatesUri().add(Uri43_N.convertUri(t));
    for (org.hl7.fhir.model.core.Reference t : src.getBasedOnList()) tgt.addBasedOn(Reference43_N.convertReference(t));
    if (src.hasGroupIdentifier())
      tgt.setGroupIdentifier(Identifier43_N.convertIdentifier(src.getGroupIdentifier()));
    if (src.hasCourseOfTherapyType())
      tgt.setCourseOfTherapyType(CodeableConcept43_N.convertCodeableConcept(src.getCourseOfTherapyType()));
    for (org.hl7.fhir.model.core.Reference t : src.getInsuranceList()) tgt.addInsurance(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    for (DosageDetails.DosageDetailsStepComponent t : src.getDosageInstruction().getStepList())
      tgt.addDosageInstruction(Dosage43_N.convertDosage(t.getComponentFirstRep()));
    if (src.hasDispenseRequest())
      tgt.setDispenseRequest(convertMedicationRequestDispenseRequestComponent(src.getDispenseRequest()));
    if (src.hasSubstitution())
      tgt.setSubstitution(convertMedicationRequestSubstitutionComponent(src.getSubstitution()));
    if (src.hasPriorPrescription())
      tgt.setPriorPrescription(Reference43_N.convertReference(src.getPriorPrescription()));
//    for (org.hl7.fhir.model.core.Reference t : src.getDetectedIssueList())
//      tgt.addDetectedIssue(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getEventHistoryList())
      tgt.addEventHistory(Reference43_N.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MedicationRequest.MedicationrequestStatus> convertMedicationRequestStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MedicationRequest.MedicationrequestStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<MedicationRequest.MedicationrequestStatus> tgt = new Enumeration<>(new MedicationRequest.MedicationrequestStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(MedicationRequest.MedicationrequestStatus.ACTIVE);
                  break;
              case ONHOLD:
                  tgt.setValue(MedicationRequest.MedicationrequestStatus.ONHOLD);
                  break;
              case CANCELLED:
                  tgt.setValue(MedicationRequest.MedicationrequestStatus.CANCELLED);
                  break;
              case COMPLETED:
                  tgt.setValue(MedicationRequest.MedicationrequestStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(MedicationRequest.MedicationrequestStatus.ENTEREDINERROR);
                  break;
              case STOPPED:
                  tgt.setValue(MedicationRequest.MedicationrequestStatus.STOPPED);
                  break;
              case DRAFT:
                  tgt.setValue(MedicationRequest.MedicationrequestStatus.DRAFT);
                  break;
              case UNKNOWN:
                  tgt.setValue(MedicationRequest.MedicationrequestStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(MedicationRequest.MedicationrequestStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MedicationRequest.MedicationrequestStatus> convertMedicationRequestStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MedicationRequest.MedicationrequestStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MedicationRequest.MedicationrequestStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.MedicationRequest.MedicationrequestStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationRequest.MedicationrequestStatus.ACTIVE);
                  break;
              case ONHOLD:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationRequest.MedicationrequestStatus.ONHOLD);
                  break;
              case CANCELLED:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationRequest.MedicationrequestStatus.CANCELLED);
                  break;
              case COMPLETED:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationRequest.MedicationrequestStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationRequest.MedicationrequestStatus.ENTEREDINERROR);
                  break;
              case STOPPED:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationRequest.MedicationrequestStatus.STOPPED);
                  break;
              case DRAFT:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationRequest.MedicationrequestStatus.DRAFT);
                  break;
              case UNKNOWN:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationRequest.MedicationrequestStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationRequest.MedicationrequestStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MedicationRequest.MedicationRequestIntent> convertMedicationRequestIntent(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<MedicationRequest.MedicationRequestIntent> tgt = new Enumeration<>(new MedicationRequest.MedicationRequestIntentEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PROPOSAL:
                  tgt.setValue(MedicationRequest.MedicationRequestIntent.PROPOSAL);
                  break;
              case PLAN:
                  tgt.setValue(MedicationRequest.MedicationRequestIntent.PLAN);
                  break;
              case ORDER:
                  tgt.setValue(MedicationRequest.MedicationRequestIntent.ORDER);
                  break;
              case ORIGINALORDER:
                  tgt.setValue(MedicationRequest.MedicationRequestIntent.ORIGINALORDER);
                  break;
              case REFLEXORDER:
                  tgt.setValue(MedicationRequest.MedicationRequestIntent.REFLEXORDER);
                  break;
              case FILLERORDER:
                  tgt.setValue(MedicationRequest.MedicationRequestIntent.FILLERORDER);
                  break;
              case INSTANCEORDER:
                  tgt.setValue(MedicationRequest.MedicationRequestIntent.INSTANCEORDER);
                  break;
              case OPTION:
                  tgt.setValue(MedicationRequest.MedicationRequestIntent.OPTION);
                  break;
              default:
                  tgt.setValue(MedicationRequest.MedicationRequestIntent.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestIntent> convertMedicationRequestIntent(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MedicationRequest.MedicationRequestIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestIntent> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestIntentEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PROPOSAL:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestIntent.PROPOSAL);
                  break;
              case PLAN:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestIntent.PLAN);
                  break;
              case ORDER:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestIntent.ORDER);
                  break;
              case ORIGINALORDER:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestIntent.ORIGINALORDER);
                  break;
              case REFLEXORDER:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestIntent.REFLEXORDER);
                  break;
              case FILLERORDER:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestIntent.FILLERORDER);
                  break;
              case INSTANCEORDER:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestIntent.INSTANCEORDER);
                  break;
              case OPTION:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestIntent.OPTION);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestIntent.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestPriority> convertMedicationRequestPriority(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestPriority> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.RequestPriority> tgt = new Enumeration<>(new Enumerations.RequestPriorityEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ROUTINE:
                  tgt.setValue(Enumerations.RequestPriority.ROUTINE);
                  break;
              case URGENT:
                  tgt.setValue(Enumerations.RequestPriority.URGENT);
                  break;
              case ASAP:
                  tgt.setValue(Enumerations.RequestPriority.ASAP);
                  break;
              case STAT:
                  tgt.setValue(Enumerations.RequestPriority.STAT);
                  break;
              default:
                  tgt.setValue(Enumerations.RequestPriority.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestPriority> convertMedicationRequestPriority(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestPriority> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestPriority> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.RequestPriorityEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ROUTINE:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.ROUTINE);
                  break;
              case URGENT:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.URGENT);
                  break;
              case ASAP:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.ASAP);
                  break;
              case STAT:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.STAT);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.MedicationRequest.MedicationRequestDispenseRequestComponent convertMedicationRequestDispenseRequestComponent(org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestDispenseRequestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MedicationRequest.MedicationRequestDispenseRequestComponent tgt = new org.hl7.fhir.model.core.MedicationRequest.MedicationRequestDispenseRequestComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasInitialFill())
      tgt.setInitialFill(convertMedicationRequestDispenseRequestInitialFillComponent(src.getInitialFill()));
    if (src.hasDispenseInterval())
      tgt.setDispenseInterval(Duration43_N.convertDuration(src.getDispenseInterval()));
    if (src.hasValidityPeriod())
      tgt.setValidityPeriod(Period43_N.convertPeriod(src.getValidityPeriod()));
    if (src.hasNumberOfRepeatsAllowed())
      tgt.setNumberOfRepeatsAllowedElement(UnsignedInt43_N.convertUnsignedInt(src.getNumberOfRepeatsAllowedElement()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasExpectedSupplyDuration())
      tgt.setExpectedSupplyDuration(Duration43_N.convertDuration(src.getExpectedSupplyDuration()));
    if (src.hasPerformer())
      tgt.setDispenser(Reference43_N.convertReference(src.getPerformer()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestDispenseRequestComponent convertMedicationRequestDispenseRequestComponent(org.hl7.fhir.model.core.MedicationRequest.MedicationRequestDispenseRequestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestDispenseRequestComponent tgt = new org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestDispenseRequestComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasInitialFill())
      tgt.setInitialFill(convertMedicationRequestDispenseRequestInitialFillComponent(src.getInitialFill()));
    if (src.hasDispenseInterval())
      tgt.setDispenseInterval(Duration43_N.convertDuration(src.getDispenseInterval()));
    if (src.hasValidityPeriod())
      tgt.setValidityPeriod(Period43_N.convertPeriod(src.getValidityPeriod()));
    if (src.hasNumberOfRepeatsAllowed())
      tgt.setNumberOfRepeatsAllowedElement(UnsignedInt43_N.convertUnsignedInt(src.getNumberOfRepeatsAllowedElement()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasExpectedSupplyDuration())
      tgt.setExpectedSupplyDuration(Duration43_N.convertDuration(src.getExpectedSupplyDuration()));
    if (src.hasDispenser())
      tgt.setPerformer(Reference43_N.convertReference(src.getDispenser()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent convertMedicationRequestDispenseRequestInitialFillComponent(org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent tgt = new org.hl7.fhir.model.core.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasDuration())
      tgt.setDuration(Duration43_N.convertDuration(src.getDuration()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent convertMedicationRequestDispenseRequestInitialFillComponent(org.hl7.fhir.model.core.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent tgt = new org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasDuration())
      tgt.setDuration(Duration43_N.convertDuration(src.getDuration()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.MedicationRequest.MedicationRequestSubstitutionComponent convertMedicationRequestSubstitutionComponent(org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestSubstitutionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MedicationRequest.MedicationRequestSubstitutionComponent tgt = new org.hl7.fhir.model.core.MedicationRequest.MedicationRequestSubstitutionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasAllowed())
      tgt.setAllowed(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getAllowed()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept43_N.convertCodeableConcept(src.getReason()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestSubstitutionComponent convertMedicationRequestSubstitutionComponent(org.hl7.fhir.model.core.MedicationRequest.MedicationRequestSubstitutionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestSubstitutionComponent tgt = new org.hl7.fhir.r4b.model.MedicationRequest.MedicationRequestSubstitutionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasAllowed())
      tgt.setAllowed(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getAllowed()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept43_N.convertCodeableConcept(src.getReason()));
    return tgt;
  }
}