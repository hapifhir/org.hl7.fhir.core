package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionDatatype40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.SimpleQuantity40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
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

public class MedicationAdministration40_N {

  public static org.hl7.fhir.model.core.MedicationAdministration convertMedicationAdministration(org.hl7.fhir.r4.model.MedicationAdministration src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MedicationAdministration tgt = new org.hl7.fhir.model.core.MedicationAdministration();
    // R6 dropped these
    CrossVersionElements40_N.r4ElementsToExtensions(src, "MedicationAdministration", tgt.getExtension(), "instantiates");
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("MedicationAdministration", "5.0", new String[] {"basedOn", "recorded", "isSubPotent", "subPotentReason"}, CrossVersionElements40_N.urls("MedicationAdministration", "6.0", new String[] {}, CrossVersionElements40_N.url("MedicationAdministration", "5.0", "category"), CrossVersionElements40_N.url("MedicationAdministration", "6.0", "occurrence"), CrossVersionElements40_N.url("MedicationAdministration", "5.0", "device"))));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "basedOn", "recorded", "isSubPotent", "subPotentReason");
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference40_N.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR6Code(src.getStatusElement(), convertMedicationAdministrationStatus(src.getStatusElement()), src.fhirType(), "status"));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getStatusReason())
      tgt.addStatusReason(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasCategory())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "category");
    if (src.hasMedication())
      tgt.setMedication(CodeableConcept40_N.convertChoiceToCodeableReference(src.getMedication()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setEncounter(Reference40_N.convertReference(src.getContext()));
    for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(Reference40_N.convertReference(t));
    if (src.hasEffective())
      tgt.setOccurrence(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getEffective()));
    // R6 occurrence can also be a Timing
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "occurrence");
    for (org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationPerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertMedicationAdministrationPerformerComponent(t));
    CodeableConcept40_N.convertReasonsToR6(src.getReasonCode(), src.getReasonReference(), tgt.getReasonList());
    if (src.hasRequest())
      tgt.setRequest(Reference40_N.convertReference(src.getRequest()));
    for (org.hl7.fhir.r4.model.Reference t : src.getDevice()) tgt.addDevice(Reference40_N.convertReferenceToCodeableReference(t));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "device");
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    if (src.hasDosage())
      tgt.setDosage(convertMedicationAdministrationDosageComponent(src.getDosage()));
    for (org.hl7.fhir.r4.model.Reference t : src.getEventHistory())
      tgt.addEventHistory(Reference40_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationAdministration convertMedicationAdministration(org.hl7.fhir.model.core.MedicationAdministration src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicationAdministration tgt = new org.hl7.fhir.r4.model.MedicationAdministration();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("MedicationAdministration", "4.0", new String[] {"instantiates"}));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "MedicationAdministration", "instantiates");
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "basedOn", "recorded", "isSubPotent", "subPotentReason");
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.model.core.Reference t : src.getPartOfList()) tgt.addPartOf(Reference40_N.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR4Code(src.getStatusElement(), convertMedicationAdministrationStatus(src.getStatusElement()), src.fhirType(), "status"));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getStatusReasonList())
      tgt.addStatusReason(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList()) {
      if (!tgt.hasCategory())
        tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(t));
      else
        tgt.addExtension(CrossVersionElements40_N.url("MedicationAdministration", "5.0", "category"), CodeableConcept40_N.convertCodeableConcept(t));
    }
    if (src.hasMedication())
      tgt.setMedication(CodeableConcept40_N.convertCodeableReferenceToChoice(src.getMedication()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setContext(Reference40_N.convertReference(src.getEncounter()));
    for (org.hl7.fhir.model.core.Reference t : src.getSupportingInformationList())
      tgt.addSupportingInformation(Reference40_N.convertReference(t));
    if (src.hasOccurrenceDateTimeType() || src.hasOccurrencePeriod())
      tgt.setEffective(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getOccurrence()));
    else if (src.hasOccurrence())
      tgt.addExtension(CrossVersionElements40_N.url("MedicationAdministration", "6.0", "occurrence"), ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getOccurrence()));
    for (org.hl7.fhir.model.core.MedicationAdministration.MedicationAdministrationPerformerComponent t : src.getPerformerList())
      tgt.addPerformer(convertMedicationAdministrationPerformerComponent(t));
    CodeableConcept40_N.convertReasonsToR4(src.getReasonList(), tgt.getReasonCode(), tgt.getReasonReference());
    if (src.hasRequest())
      tgt.setRequest(Reference40_N.convertReference(src.getRequest()));
    // R4 device is only a Reference: anything more goes whole in a 5.0 extension
    for (CodeableReference t : src.getDeviceList()) {
      if (t.hasReference() && !t.hasConcept() && !t.hasId() && !t.hasExtension())
        tgt.addDevice(Reference40_N.convertReference(t.getReference()));
      else
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url("MedicationAdministration", "5.0", "device"), t));
    }
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    if (src.hasDosage())
      tgt.setDosage(convertMedicationAdministrationDosageComponent(src.getDosage()));
    for (org.hl7.fhir.model.core.Reference t : src.getEventHistoryList())
      tgt.addEventHistory(Reference40_N.convertReference(t));
    return tgt;
  }

  private static org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MedicationAdministration.MedicationAdministrationStatusCodes> convertMedicationAdministrationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatus> src) {
      if (src == null)
          return null;
      Enumeration<MedicationAdministration.MedicationAdministrationStatusCodes> tgt = new Enumeration<>(new MedicationAdministration.MedicationAdministrationStatusCodesEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  private static org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatus> convertMedicationAdministrationStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MedicationAdministration.MedicationAdministrationStatusCodes> src) {
      if (src == null)
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      //
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.MedicationAdministration.MedicationAdministrationPerformerComponent convertMedicationAdministrationPerformerComponent(org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MedicationAdministration.MedicationAdministrationPerformerComponent tgt = new org.hl7.fhir.model.core.MedicationAdministration.MedicationAdministrationPerformerComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.url("MedicationAdministration.performer", "5.0", "actor"));
    // the whole actor, if it was more than a reference
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "MedicationAdministration.performer", "5.0", "actor");
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept40_N.convertCodeableConcept(src.getFunction()));
    if (src.hasActor() && !tgt.hasActor())
      tgt.setActor(Reference40_N.convertReferenceToCodeableReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationPerformerComponent convertMedicationAdministrationPerformerComponent(org.hl7.fhir.model.core.MedicationAdministration.MedicationAdministrationPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationPerformerComponent tgt = new org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationPerformerComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept40_N.convertCodeableConcept(src.getFunction()));
    if (src.hasActor()) {
      if (src.getActor().hasReference())
        tgt.setActor(Reference40_N.convertReference(src.getActor().getReference()));
      if (src.getActor().hasConcept() || src.getActor().hasId() || src.getActor().hasExtension())
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url("MedicationAdministration.performer", "5.0", "actor"), src.getActor()));
    }
    return tgt;
  }

  public static org.hl7.fhir.model.core.MedicationAdministration.MedicationAdministrationDosageComponent convertMedicationAdministrationDosageComponent(org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationDosageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MedicationAdministration.MedicationAdministrationDosageComponent tgt = new org.hl7.fhir.model.core.MedicationAdministration.MedicationAdministrationDosageComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasText())
      tgt.setTextElement(String40_N.convertString(src.getTextElement()));
    if (src.hasSite())
      tgt.setSite(CodeableConcept40_N.convertCodeableConcept(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(CodeableConcept40_N.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept40_N.convertCodeableConcept(src.getMethod()));
    if (src.hasDose())
      tgt.setDose(SimpleQuantity40_N.convertSimpleQuantity(src.getDose()));
    // the types R4 and R6 allow differ: a value of a type the other version doesn't allow is an extension
    CrossVersionElements40_N.choiceToR6(src, src.getExtension(), src.fhirType(), "rate", tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationDosageComponent convertMedicationAdministrationDosageComponent(org.hl7.fhir.model.core.MedicationAdministration.MedicationAdministrationDosageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationDosageComponent tgt = new org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationDosageComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasText())
      tgt.setTextElement(String40_N.convertString(src.getTextElement()));
    if (src.hasSite())
      tgt.setSite(CodeableConcept40_N.convertCodeableConcept(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(CodeableConcept40_N.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept40_N.convertCodeableConcept(src.getMethod()));
    if (src.hasDose())
      tgt.setDose(SimpleQuantity40_N.convertSimpleQuantity(src.getDose()));
    CrossVersionElements40_N.choiceToR4(src, src.getExtension(), src.fhirType(), "rate", tgt, tgt.getExtension());
    return tgt;
  }
}