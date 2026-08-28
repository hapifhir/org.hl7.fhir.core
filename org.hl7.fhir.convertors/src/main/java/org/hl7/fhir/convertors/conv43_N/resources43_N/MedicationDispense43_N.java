package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Annotation43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.SimpleQuantity43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Dosage43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.DosageDetails;
import org.hl7.fhir.r4b.model.Enumeration;
import org.hl7.fhir.r4b.model.MedicationDispense;
import org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseStatusCodesEnumFactory;

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

public class MedicationDispense43_N {

  public static org.hl7.fhir.model.core.MedicationDispense convertMedicationDispense(org.hl7.fhir.r4b.model.MedicationDispense src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MedicationDispense tgt = new org.hl7.fhir.model.core.MedicationDispense();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference43_N.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationStatus(src.getStatusElement()));
//    if (src.hasStatusReasonCodeableConcept())
//      tgt.getStatusReason().setConcept(CodeableConcept43_N.convertCodeableConcept(src.getStatusReasonCodeableConcept()));
//    if (src.hasStatusReasonReference())
//      tgt.getStatusReason().setReference(Reference43_N.convertReference(src.getStatusReasonReference()));
    if (src.hasCategory())
      tgt.addCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategory()));
    if (src.hasMedicationCodeableConcept())
      tgt.getMedication().setConcept(CodeableConcept43_N.convertCodeableConcept(src.getMedicationCodeableConcept()));
    if (src.hasMedicationReference())
      tgt.getMedication().setReference(Reference43_N.convertReference(src.getMedicationReference()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setEncounter(Reference43_N.convertReference(src.getContext()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispensePerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertMedicationDispensePerformerComponent(t));
    if (src.hasLocation())
      tgt.setLocation(Reference43_N.convertReference(src.getLocation()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getAuthorizingPrescription())
      tgt.addAuthorizingPrescription(Reference43_N.convertReference(t));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasDaysSupply())
      tgt.setDaysSupply(SimpleQuantity43_N.convertSimpleQuantity(src.getDaysSupply()));
    if (src.hasWhenPrepared())
      tgt.setWhenPreparedElement(DateTime43_N.convertDateTime(src.getWhenPreparedElement()));
    if (src.hasWhenHandedOver())
      tgt.setWhenHandedOverElement(DateTime43_N.convertDateTime(src.getWhenHandedOverElement()));
    if (src.hasDestination())
      tgt.setDestination(Reference43_N.convertReference(src.getDestination()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReceiver()) tgt.addReceiver(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    for (org.hl7.fhir.r4b.model.Dosage t : src.getDosageInstruction())
      tgt.getDosageInstruction().getStepFirstRep().addComponent(Dosage43_N.convertDosage(t));
    if (src.hasSubstitution())
      tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
//    for (org.hl7.fhir.r4b.model.Reference t : src.getDetectedIssue())
//      tgt.addDetectedIssue(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getEventHistory())
      tgt.addEventHistory(Reference43_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.model.core.MedicationDispense src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MedicationDispense tgt = new org.hl7.fhir.r4b.model.MedicationDispense();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    for (org.hl7.fhir.model.core.Reference t : src.getPartOfList()) tgt.addPartOf(Reference43_N.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertStatus(src.getStatusElement()));
//    if (src.getStatusReason().hasConcept())
//      tgt.setStatusReason(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getStatusReason().getConcept()));
//    if (src.getStatusReason().hasReference())
//      tgt.setStatusReason(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getStatusReason().getReference()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategoryFirstRep()));
    if (src.getMedication().hasConcept())
      tgt.setMedication(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getMedication().getConcept()));
    if (src.getMedication().hasReference())
      tgt.setMedication(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getMedication().getReference()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setContext(Reference43_N.convertReference(src.getEncounter()));
    for (org.hl7.fhir.model.core.Reference t : src.getSupportingInformationList())
      tgt.addSupportingInformation(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.MedicationDispense.MedicationDispensePerformerComponent t : src.getPerformerList())
      tgt.addPerformer(convertMedicationDispensePerformerComponent(t));
    if (src.hasLocation())
      tgt.setLocation(Reference43_N.convertReference(src.getLocation()));
    for (org.hl7.fhir.model.core.Reference t : src.getAuthorizingPrescriptionList())
      tgt.addAuthorizingPrescription(Reference43_N.convertReference(t));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasDaysSupply())
      tgt.setDaysSupply(SimpleQuantity43_N.convertSimpleQuantity(src.getDaysSupply()));
    if (src.hasWhenPrepared())
      tgt.setWhenPreparedElement(DateTime43_N.convertDateTime(src.getWhenPreparedElement()));
    if (src.hasWhenHandedOver())
      tgt.setWhenHandedOverElement(DateTime43_N.convertDateTime(src.getWhenHandedOverElement()));
    if (src.hasDestination())
      tgt.setDestination(Reference43_N.convertReference(src.getDestination()));
    for (org.hl7.fhir.model.core.Reference t : src.getReceiverList()) tgt.addReceiver(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    for (DosageDetails.DosageDetailsStepComponent t : src.getDosageInstruction().getStepList())
      tgt.addDosageInstruction(Dosage43_N.convertDosage(t.getComponentFirstRep()));
    if (src.hasSubstitution())
      tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
//    for (org.hl7.fhir.model.core.Reference t : src.getDetectedIssueList())
//      tgt.addDetectedIssue(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getEventHistoryList())
      tgt.addEventHistory(Reference43_N.convertReference(t));
    return tgt;
  }

  private static org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispenseStatusCodes> convertStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseStatusCodes> src) {
      if (src == null)
          return null;
      Enumeration<MedicationDispense.MedicationDispenseStatusCodes> tgt = new Enumeration<>(new MedicationDispense.MedicationDispenseStatusCodesEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case CANCELLED:
                  tgt.setValue(MedicationDispense.MedicationDispenseStatusCodes.CANCELLED);
                  break;
              case COMPLETED:
                  tgt.setValue(MedicationDispense.MedicationDispenseStatusCodes.COMPLETED);
                  break;
              case DECLINED:
                  tgt.setValue(MedicationDispense.MedicationDispenseStatusCodes.DECLINED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(MedicationDispense.MedicationDispenseStatusCodes.ENTEREDINERROR);
                  break;
              case INPROGRESS:
                  tgt.setValue(MedicationDispense.MedicationDispenseStatusCodes.INPROGRESS);
                  break;
              case NULL:
                  tgt.setValue(MedicationDispense.MedicationDispenseStatusCodes.NULL);
                  break;
              case ONHOLD:
                  tgt.setValue(MedicationDispense.MedicationDispenseStatusCodes.ONHOLD);
                  break;
              case PREPARATION:
                  tgt.setValue(MedicationDispense.MedicationDispenseStatusCodes.PREPARATION);
                  break;
              case UNKNOWN:
                  tgt.setValue(MedicationDispense.MedicationDispenseStatusCodes.UNKNOWN);
                  break;
          }
      }
      return tgt;
  }

  private static org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseStatusCodes> convertMedicationStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispenseStatusCodes> src) {
      if (src == null)
          return null;
      org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseStatusCodes> tgt = new org.hl7.fhir.model.core.Enumeration<>(new MedicationDispenseStatusCodesEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case CANCELLED:
                  tgt.setValue(org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseStatusCodes.CANCELLED);
                  break;
              case COMPLETED:
                  tgt.setValue(org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseStatusCodes.COMPLETED);
                  break;
              case DECLINED:
                  tgt.setValue(org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseStatusCodes.DECLINED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseStatusCodes.ENTEREDINERROR);
                  break;
              case INPROGRESS:
                  tgt.setValue(org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseStatusCodes.INPROGRESS);
                  break;
              case NULL:
                  tgt.setValue(org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseStatusCodes.NULL);
                  break;
              case ONHOLD:
                  tgt.setValue(org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseStatusCodes.ONHOLD);
                  break;
              case PREPARATION:
                  tgt.setValue(org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseStatusCodes.PREPARATION);
                  break;
              case STOPPED:
                  tgt.setValue(org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseStatusCodes.ONHOLD);
                  break;
              case UNKNOWN:
                  tgt.setValue(org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseStatusCodes.UNKNOWN);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.MedicationDispense.MedicationDispensePerformerComponent convertMedicationDispensePerformerComponent(org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispensePerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MedicationDispense.MedicationDispensePerformerComponent tgt = new org.hl7.fhir.model.core.MedicationDispense.MedicationDispensePerformerComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept43_N.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference43_N.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispensePerformerComponent convertMedicationDispensePerformerComponent(org.hl7.fhir.model.core.MedicationDispense.MedicationDispensePerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispensePerformerComponent tgt = new org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispensePerformerComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept43_N.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference43_N.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseSubstitutionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasWasSubstituted())
      tgt.setWasSubstitutedElement(Boolean43_N.convertBoolean(src.getWasSubstitutedElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getResponsibleParty())
      tgt.setResponsibleParty(Reference43_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasWasSubstituted())
      tgt.setWasSubstitutedElement(Boolean43_N.convertBoolean(src.getWasSubstitutedElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getReasonList())
      tgt.addReason(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasResponsibleParty())
      tgt.addResponsibleParty(Reference43_N.convertReference(src.getResponsibleParty()));
    return tgt;
  }
}