package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationStatusCodes;
import org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationStatusCodesEnumFactory;

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
public class MedicationAdministration40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.MedicationAdministration convertMedicationAdministration(org.hl7.fhir.r4.model.MedicationAdministration src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MedicationAdministration tgt = new org.hl7.fhir.r5.model.MedicationAdministration();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        for (org.hl7.fhir.r4.model.UriType t : src.getInstantiates()) tgt.getInstantiatesUri().add(convertUri(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(convertReference(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationAdministrationStatus(src.getStatusElement()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getStatusReason()) tgt.addStatusReason(convertCodeableConcept(t));
        if (src.hasCategory())
            tgt.addCategory(convertCodeableConcept(src.getCategory()));
        if (src.hasMedicationCodeableConcept())
            tgt.getMedication().setConcept(convertCodeableConcept(src.getMedicationCodeableConcept()));
        if (src.hasMedicationReference())
          tgt.getMedication().setReference(convertReference(src.getMedicationReference()));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasContext())
            tgt.setEncounter(convertReference(src.getContext()));
        for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInformation()) tgt.addSupportingInformation(convertReference(t));
        if (src.hasEffective())
            tgt.setOccurence(convertType(src.getEffective()));
        for (org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationPerformerComponent t : src.getPerformer()) tgt.addPerformer(convertMedicationAdministrationPerformerComponent(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(convertCodeableConceptToCodeableReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) tgt.addReason(convertReferenceToCodeableReference(t));
        if (src.hasRequest())
            tgt.setRequest(convertReference(src.getRequest()));
        for (org.hl7.fhir.r4.model.Reference t : src.getDevice()) tgt.addDevice(convertReference(t));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        if (src.hasDosage())
            tgt.setDosage(convertMedicationAdministrationDosageComponent(src.getDosage()));
        for (org.hl7.fhir.r4.model.Reference t : src.getEventHistory()) tgt.addEventHistory(convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MedicationAdministration convertMedicationAdministration(org.hl7.fhir.r5.model.MedicationAdministration src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MedicationAdministration tgt = new org.hl7.fhir.r4.model.MedicationAdministration();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesUri()) tgt.getInstantiates().add(convertUri(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(convertReference(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationAdministrationStatus(src.getStatusElement()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getStatusReason()) tgt.addStatusReason(convertCodeableConcept(t));
        if (src.hasCategory())
            tgt.setCategory(convertCodeableConcept(src.getCategoryFirstRep()));
        if (src.getMedication().hasConcept())
          tgt.setMedication(convertType(src.getMedication().getConcept()));
        if (src.getMedication().hasReference())
          tgt.setMedication(convertType(src.getMedication().getReference()));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setContext(convertReference(src.getEncounter()));
        for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInformation()) tgt.addSupportingInformation(convertReference(t));
        if (src.hasOccurence())
            tgt.setEffective(convertType(src.getOccurence()));
        for (org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationPerformerComponent t : src.getPerformer()) tgt.addPerformer(convertMedicationAdministrationPerformerComponent(t));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReasonCode(convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getReason()) if (t.hasReference())
            tgt.addReasonReference(convertReference(t.getReference()));
        if (src.hasRequest())
            tgt.setRequest(convertReference(src.getRequest()));
        for (org.hl7.fhir.r5.model.Reference t : src.getDevice()) tgt.addDevice(convertReference(t));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        if (src.hasDosage())
            tgt.setDosage(convertMedicationAdministrationDosageComponent(src.getDosage()));
        for (org.hl7.fhir.r5.model.Reference t : src.getEventHistory()) tgt.addEventHistory(convertReference(t));
        return tgt;
    }

    private static org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationStatusCodes> convertMedicationAdministrationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatus> src) {
      if (src == null)
        return null;
      org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationStatusCodesEnumFactory());
      VersionConvertor_40_50.copyElement(src, tgt);
      // 
      switch(src.getValue()) {
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationStatusCodes.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationStatusCodes.ENTEREDINERROR);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationStatusCodes.INPROGRESS);
        break;
      case NOTDONE:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationStatusCodes.NOTDONE);
        break;
      case NULL:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationStatusCodes.NULL);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationStatusCodes.ONHOLD);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationStatusCodes.STOPPED);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationStatusCodes.UNKNOWN);
        break;
      }
      return tgt;
    }

    private static org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatus> convertMedicationAdministrationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationStatusCodes> src) {
      if (src == null)
        return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatusEnumFactory());
      VersionConvertor_40_50.copyElement(src, tgt);
      // 
      switch(src.getValue()) {
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatus.ENTEREDINERROR);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatus.INPROGRESS);
        break;
      case NOTDONE:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatus.NOTDONE);
        break;
      case NULL:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatus.NULL);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatus.ONHOLD);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatus.STOPPED);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatus.UNKNOWN);
        break;
      }
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