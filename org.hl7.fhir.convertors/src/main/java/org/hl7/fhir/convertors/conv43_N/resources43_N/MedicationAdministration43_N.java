package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Annotation43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.SimpleQuantity43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeableReference;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.MedicationAdministration;

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

public class MedicationAdministration43_N {

  public static org.hl7.fhir.model.core.MedicationAdministration convertMedicationAdministration(org.hl7.fhir.r4b.model.MedicationAdministration src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MedicationAdministration tgt = new org.hl7.fhir.model.core.MedicationAdministration();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
//    for (org.hl7.fhir.r4b.model.UriType t : src.getInstantiates()) tgt.getInstantiatesUri().add(Uri43_N.convertUri(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference43_N.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationAdministrationStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getStatusReason())
      tgt.addStatusReason(CodeableConcept43_N.convertCodeableConcept(t));
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
    if (src.hasEffective())
      tgt.setOccurrence(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getEffective()));
    for (org.hl7.fhir.r4b.model.MedicationAdministration.MedicationAdministrationPerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertMedicationAdministrationPerformerComponent(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept43_N.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference43_N.convertReferenceToCodeableReference(t));
    if (src.hasRequest())
      tgt.setRequest(Reference43_N.convertReference(src.getRequest()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getDevice()) tgt.addDevice(Reference43_N.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    if (src.hasDosage())
      tgt.setDosage(convertMedicationAdministrationDosageComponent(src.getDosage()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getEventHistory())
      tgt.addEventHistory(Reference43_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MedicationAdministration convertMedicationAdministration(org.hl7.fhir.model.core.MedicationAdministration src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MedicationAdministration tgt = new org.hl7.fhir.r4b.model.MedicationAdministration();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
//    for (org.hl7.fhir.model.core.UriType t : src.getInstantiatesUriList()) tgt.getInstantiates().add(Uri43_N.convertUri(t));
    for (org.hl7.fhir.model.core.Reference t : src.getPartOfList()) tgt.addPartOf(Reference43_N.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationAdministrationStatus(src.getStatusElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getStatusReasonList())
      tgt.addStatusReason(CodeableConcept43_N.convertCodeableConcept(t));
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
    if (src.hasOccurrence())
      tgt.setEffective(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getOccurrence()));
    for (org.hl7.fhir.model.core.MedicationAdministration.MedicationAdministrationPerformerComponent t : src.getPerformerList())
      tgt.addPerformer(convertMedicationAdministrationPerformerComponent(t));
    for (CodeableReference t : src.getReasonList())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept43_N.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReasonList())
      if (t.hasReference())
        tgt.addReasonReference(Reference43_N.convertReference(t.getReference()));
    if (src.hasRequest())
      tgt.setRequest(Reference43_N.convertReference(src.getRequest()));
    for (CodeableReference t : src.getDeviceList())
      if (t.hasReference())
        tgt.addDevice(Reference43_N.convertReference(t.getReference()));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    if (src.hasDosage())
      tgt.setDosage(convertMedicationAdministrationDosageComponent(src.getDosage()));
    for (org.hl7.fhir.model.core.Reference t : src.getEventHistoryList())
      tgt.addEventHistory(Reference43_N.convertReference(t));
    return tgt;
  }

  private static org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MedicationAdministration.MedicationAdministrationStatusCodes> convertMedicationAdministrationStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MedicationAdministration.MedicationAdministrationStatusCodes> src) {
      if (src == null)
          return null;
      Enumeration<MedicationAdministration.MedicationAdministrationStatusCodes> tgt = new Enumeration<>(new MedicationAdministration.MedicationAdministrationStatusCodesEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      //
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case COMPLETED:
                  tgt.setValue(MedicationAdministration.MedicationAdministrationStatusCodes.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(MedicationAdministration.MedicationAdministrationStatusCodes.ENTEREDINERROR);
                  break;
              case INPROGRESS:
                  tgt.setValue(MedicationAdministration.MedicationAdministrationStatusCodes.INPROGRESS);
                  break;
              case NOTDONE:
                  tgt.setValue(MedicationAdministration.MedicationAdministrationStatusCodes.NOTDONE);
                  break;
              case NULL:
                  tgt.setValue(MedicationAdministration.MedicationAdministrationStatusCodes.NULL);
                  break;
              case ONHOLD:
                  tgt.setValue(MedicationAdministration.MedicationAdministrationStatusCodes.ONHOLD);
                  break;
              case STOPPED:
                  tgt.setValue(MedicationAdministration.MedicationAdministrationStatusCodes.STOPPED);
                  break;
              case UNKNOWN:
                  tgt.setValue(MedicationAdministration.MedicationAdministrationStatusCodes.UNKNOWN);
                  break;
          }
      }
      return tgt;
  }

  private static org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MedicationAdministration.MedicationAdministrationStatusCodes> convertMedicationAdministrationStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MedicationAdministration.MedicationAdministrationStatusCodes> src) {
      if (src == null)
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MedicationAdministration.MedicationAdministrationStatusCodes> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.MedicationAdministration.MedicationAdministrationStatusCodesEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      //
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case COMPLETED:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationAdministration.MedicationAdministrationStatusCodes.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationAdministration.MedicationAdministrationStatusCodes.ENTEREDINERROR);
                  break;
              case INPROGRESS:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationAdministration.MedicationAdministrationStatusCodes.INPROGRESS);
                  break;
              case NOTDONE:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationAdministration.MedicationAdministrationStatusCodes.NOTDONE);
                  break;
              case NULL:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationAdministration.MedicationAdministrationStatusCodes.NULL);
                  break;
              case ONHOLD:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationAdministration.MedicationAdministrationStatusCodes.ONHOLD);
                  break;
              case STOPPED:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationAdministration.MedicationAdministrationStatusCodes.STOPPED);
                  break;
              case UNKNOWN:
                  tgt.setValue(org.hl7.fhir.r4b.model.MedicationAdministration.MedicationAdministrationStatusCodes.UNKNOWN);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.MedicationAdministration.MedicationAdministrationPerformerComponent convertMedicationAdministrationPerformerComponent(org.hl7.fhir.r4b.model.MedicationAdministration.MedicationAdministrationPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MedicationAdministration.MedicationAdministrationPerformerComponent tgt = new org.hl7.fhir.model.core.MedicationAdministration.MedicationAdministrationPerformerComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept43_N.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference43_N.convertReferenceToCodeableReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MedicationAdministration.MedicationAdministrationPerformerComponent convertMedicationAdministrationPerformerComponent(org.hl7.fhir.model.core.MedicationAdministration.MedicationAdministrationPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MedicationAdministration.MedicationAdministrationPerformerComponent tgt = new org.hl7.fhir.r4b.model.MedicationAdministration.MedicationAdministrationPerformerComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept43_N.convertCodeableConcept(src.getFunction()));
    if (src.hasActor() && src.getActor().hasReference())
      tgt.setActor(Reference43_N.convertReference(src.getActor().getReference()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.MedicationAdministration.MedicationAdministrationDosageComponent convertMedicationAdministrationDosageComponent(org.hl7.fhir.r4b.model.MedicationAdministration.MedicationAdministrationDosageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MedicationAdministration.MedicationAdministrationDosageComponent tgt = new org.hl7.fhir.model.core.MedicationAdministration.MedicationAdministrationDosageComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasText())
      tgt.setTextElement(String43_N.convertString(src.getTextElement()));
    if (src.hasSite())
      tgt.setSite(CodeableConcept43_N.convertCodeableConcept(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(CodeableConcept43_N.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept43_N.convertCodeableConcept(src.getMethod()));
    if (src.hasDose())
      tgt.setDose(SimpleQuantity43_N.convertSimpleQuantity(src.getDose()));
    if (src.hasRate())
      tgt.setRate(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getRate()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MedicationAdministration.MedicationAdministrationDosageComponent convertMedicationAdministrationDosageComponent(org.hl7.fhir.model.core.MedicationAdministration.MedicationAdministrationDosageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MedicationAdministration.MedicationAdministrationDosageComponent tgt = new org.hl7.fhir.r4b.model.MedicationAdministration.MedicationAdministrationDosageComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasText())
      tgt.setTextElement(String43_N.convertString(src.getTextElement()));
    if (src.hasSite())
      tgt.setSite(CodeableConcept43_N.convertCodeableConcept(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(CodeableConcept43_N.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept43_N.convertCodeableConcept(src.getMethod()));
    if (src.hasDose())
      tgt.setDose(SimpleQuantity43_N.convertSimpleQuantity(src.getDose()));
    if (src.hasRate())
      tgt.setRate(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getRate()));
    return tgt;
  }
}