package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Annotation43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.SimpleQuantity43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Dosage43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodesEnumFactory;

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
public class MedicationDispense43_50 {

  public static org.hl7.fhir.r5.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.r4b.model.MedicationDispense src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationDispense tgt = new org.hl7.fhir.r5.model.MedicationDispense();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference43_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationStatus(src.getStatusElement()));
//    if (src.hasStatusReasonCodeableConcept())
//      tgt.getStatusReason().setConcept(CodeableConcept43_50.convertCodeableConcept(src.getStatusReasonCodeableConcept()));
//    if (src.hasStatusReasonReference())
//      tgt.getStatusReason().setReference(Reference43_50.convertReference(src.getStatusReasonReference()));
    if (src.hasCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategory()));
    if (src.hasMedicationCodeableConcept())
      tgt.getMedication().setConcept(CodeableConcept43_50.convertCodeableConcept(src.getMedicationCodeableConcept()));
    if (src.hasMedicationReference())
      tgt.getMedication().setReference(Reference43_50.convertReference(src.getMedicationReference()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setEncounter(Reference43_50.convertReference(src.getContext()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispensePerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertMedicationDispensePerformerComponent(t));
    if (src.hasLocation())
      tgt.setLocation(Reference43_50.convertReference(src.getLocation()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getAuthorizingPrescription())
      tgt.addAuthorizingPrescription(Reference43_50.convertReference(t));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasDaysSupply())
      tgt.setDaysSupply(SimpleQuantity43_50.convertSimpleQuantity(src.getDaysSupply()));
    if (src.hasWhenPrepared())
      tgt.setWhenPreparedElement(DateTime43_50.convertDateTime(src.getWhenPreparedElement()));
    if (src.hasWhenHandedOver())
      tgt.setWhenHandedOverElement(DateTime43_50.convertDateTime(src.getWhenHandedOverElement()));
    if (src.hasDestination())
      tgt.setDestination(Reference43_50.convertReference(src.getDestination()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReceiver()) tgt.addReceiver(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    for (org.hl7.fhir.r4b.model.Dosage t : src.getDosageInstruction())
      tgt.addDosageInstruction(Dosage43_50.convertDosage(t));
    if (src.hasSubstitution())
      tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
//    for (org.hl7.fhir.r4b.model.Reference t : src.getDetectedIssue())
//      tgt.addDetectedIssue(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getEventHistory())
      tgt.addEventHistory(Reference43_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.r5.model.MedicationDispense src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MedicationDispense tgt = new org.hl7.fhir.r4b.model.MedicationDispense();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference43_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertStatus(src.getStatusElement()));
//    if (src.getStatusReason().hasConcept())
//      tgt.setStatusReason(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getStatusReason().getConcept()));
//    if (src.getStatusReason().hasReference())
//      tgt.setStatusReason(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getStatusReason().getReference()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategoryFirstRep()));
    if (src.getMedication().hasConcept())
      tgt.setMedication(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getMedication().getConcept()));
    if (src.getMedication().hasReference())
      tgt.setMedication(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getMedication().getReference()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setContext(Reference43_50.convertReference(src.getEncounter()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.MedicationDispense.MedicationDispensePerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertMedicationDispensePerformerComponent(t));
    if (src.hasLocation())
      tgt.setLocation(Reference43_50.convertReference(src.getLocation()));
    for (org.hl7.fhir.r5.model.Reference t : src.getAuthorizingPrescription())
      tgt.addAuthorizingPrescription(Reference43_50.convertReference(t));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasDaysSupply())
      tgt.setDaysSupply(SimpleQuantity43_50.convertSimpleQuantity(src.getDaysSupply()));
    if (src.hasWhenPrepared())
      tgt.setWhenPreparedElement(DateTime43_50.convertDateTime(src.getWhenPreparedElement()));
    if (src.hasWhenHandedOver())
      tgt.setWhenHandedOverElement(DateTime43_50.convertDateTime(src.getWhenHandedOverElement()));
    if (src.hasDestination())
      tgt.setDestination(Reference43_50.convertReference(src.getDestination()));
    for (org.hl7.fhir.r5.model.Reference t : src.getReceiver()) tgt.addReceiver(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    for (org.hl7.fhir.r5.model.Dosage t : src.getDosageInstruction())
      tgt.addDosageInstruction(Dosage43_50.convertDosage(t));
    if (src.hasSubstitution())
      tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
//    for (org.hl7.fhir.r5.model.Reference t : src.getDetectedIssue())
//      tgt.addDetectedIssue(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getEventHistory())
      tgt.addEventHistory(Reference43_50.convertReference(t));
    return tgt;
  }

  private static org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispenseStatusCodes> convertStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes> src) {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispenseStatusCodes> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispenseStatusCodesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispenseStatusCodes.CANCELLED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispenseStatusCodes.COMPLETED);
        break;
      case DECLINED:
        tgt.setValue(org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispenseStatusCodes.DECLINED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispenseStatusCodes.ENTEREDINERROR);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispenseStatusCodes.INPROGRESS);
        break;
      case NULL:
        tgt.setValue(org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispenseStatusCodes.NULL);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispenseStatusCodes.ONHOLD);
        break;
      case PREPARATION:
        tgt.setValue(org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispenseStatusCodes.PREPARATION);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispenseStatusCodes.STOPPED);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispenseStatusCodes.UNKNOWN);
        break;
    }
    return tgt;
  }

  private static org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes> convertMedicationStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispenseStatusCodes> src) {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new MedicationDispenseStatusCodesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.CANCELLED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.COMPLETED);
        break;
      case DECLINED:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.DECLINED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.ENTEREDINERROR);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.INPROGRESS);
        break;
      case NULL:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.NULL);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.ONHOLD);
        break;
      case PREPARATION:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.PREPARATION);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.STOPPED);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.UNKNOWN);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicationDispense.MedicationDispensePerformerComponent convertMedicationDispensePerformerComponent(org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispensePerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationDispense.MedicationDispensePerformerComponent tgt = new org.hl7.fhir.r5.model.MedicationDispense.MedicationDispensePerformerComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept43_50.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference43_50.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispensePerformerComponent convertMedicationDispensePerformerComponent(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispensePerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispensePerformerComponent tgt = new org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispensePerformerComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept43_50.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference43_50.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasWasSubstituted())
      tgt.setWasSubstitutedElement(Boolean43_50.convertBoolean(src.getWasSubstitutedElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getResponsibleParty())
      tgt.setResponsibleParty(Reference43_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.r4b.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasWasSubstituted())
      tgt.setWasSubstitutedElement(Boolean43_50.convertBoolean(src.getWasSubstitutedElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasResponsibleParty())
      tgt.addResponsibleParty(Reference43_50.convertReference(src.getResponsibleParty()));
    return tgt;
  }
}