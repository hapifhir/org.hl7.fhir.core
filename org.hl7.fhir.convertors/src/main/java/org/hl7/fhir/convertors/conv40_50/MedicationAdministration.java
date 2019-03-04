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


public class MedicationAdministration extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.MedicationAdministration convertMedicationAdministration(org.hl7.fhir.r4.model.MedicationAdministration src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationAdministration tgt = new org.hl7.fhir.r5.model.MedicationAdministration();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    for (org.hl7.fhir.r4.model.UriType t : src.getInstantiates())
      tgt.getInstantiates().add(convertUri(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getPartOf())
      tgt.addPartOf(convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertCode(src.getStatusElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getStatusReason())
      tgt.addStatusReason(convertCodeableConcept(t));
    if (src.hasCategory())
      tgt.setCategory(convertCodeableConcept(src.getCategory()));
    if (src.hasMedication())
      tgt.setMedication(convertType(src.getMedication()));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setContext(convertReference(src.getContext()));
    for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(convertReference(t));
    if (src.hasEffective())
      tgt.setEffective(convertType(src.getEffective()));
    for (org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationPerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertMedicationAdministrationPerformerComponent(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(convertReference(t));
    if (src.hasRequest())
      tgt.setRequest(convertReference(src.getRequest()));
    for (org.hl7.fhir.r4.model.Reference t : src.getDevice())
      tgt.addDevice(convertReference(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    if (src.hasDosage())
      tgt.setDosage(convertMedicationAdministrationDosageComponent(src.getDosage()));
    for (org.hl7.fhir.r4.model.Reference t : src.getEventHistory())
      tgt.addEventHistory(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationAdministration convertMedicationAdministration(org.hl7.fhir.r5.model.MedicationAdministration src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicationAdministration tgt = new org.hl7.fhir.r4.model.MedicationAdministration();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    for (org.hl7.fhir.r5.model.UriType t : src.getInstantiates())
      tgt.getInstantiates().add(convertUri(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getPartOf())
      tgt.addPartOf(convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertCode(src.getStatusElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getStatusReason())
      tgt.addStatusReason(convertCodeableConcept(t));
    if (src.hasCategory())
      tgt.setCategory(convertCodeableConcept(src.getCategory()));
    if (src.hasMedication())
      tgt.setMedication(convertType(src.getMedication()));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setContext(convertReference(src.getContext()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(convertReference(t));
    if (src.hasEffective())
      tgt.setEffective(convertType(src.getEffective()));
    for (org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationPerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertMedicationAdministrationPerformerComponent(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(convertReference(t));
    if (src.hasRequest())
      tgt.setRequest(convertReference(src.getRequest()));
    for (org.hl7.fhir.r5.model.Reference t : src.getDevice())
      tgt.addDevice(convertReference(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    if (src.hasDosage())
      tgt.setDosage(convertMedicationAdministrationDosageComponent(src.getDosage()));
    for (org.hl7.fhir.r5.model.Reference t : src.getEventHistory())
      tgt.addEventHistory(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationPerformerComponent convertMedicationAdministrationPerformerComponent(org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationPerformerComponent tgt = new org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationPerformerComponent();
    copyElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationPerformerComponent convertMedicationAdministrationPerformerComponent(org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationPerformerComponent tgt = new org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationPerformerComponent();
    copyElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationDosageComponent convertMedicationAdministrationDosageComponent(org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationDosageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationDosageComponent tgt = new org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationDosageComponent();
    copyElement(src, tgt);
    if (src.hasText())
      tgt.setTextElement(convertString(src.getTextElement()));
    if (src.hasSite())
      tgt.setSite(convertCodeableConcept(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(convertCodeableConcept(src.getRoute()));
    if (src.hasMethod())
      tgt.setMethod(convertCodeableConcept(src.getMethod()));
    if (src.hasDose())
      tgt.setDose(convertSimpleQuantity(src.getDose()));
    if (src.hasRate())
      tgt.setRate(convertType(src.getRate()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationDosageComponent convertMedicationAdministrationDosageComponent(org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationDosageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationDosageComponent tgt = new org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationDosageComponent();
    copyElement(src, tgt);
    if (src.hasText())
      tgt.setTextElement(convertString(src.getTextElement()));
    if (src.hasSite())
      tgt.setSite(convertCodeableConcept(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(convertCodeableConcept(src.getRoute()));
    if (src.hasMethod())
      tgt.setMethod(convertCodeableConcept(src.getMethod()));
    if (src.hasDose())
      tgt.setDose(convertSimpleQuantity(src.getDose()));
    if (src.hasRate())
      tgt.setRate(convertType(src.getRate()));
    return tgt;
  }


}
