package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.DosageDetails40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.SimpleQuantity40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Dosage40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.DosageDetails;
import org.hl7.fhir.r4.model.Enumeration;
import org.hl7.fhir.r4.model.MedicationDispense;
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

public class MedicationDispense40_N {

  public static org.hl7.fhir.model.core.MedicationDispense convertMedicationDispense(org.hl7.fhir.r4.model.MedicationDispense src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MedicationDispense tgt = new org.hl7.fhir.model.core.MedicationDispense();
    // R6 dropped these
    CrossVersionElements40_N.r4ElementsToExtensions(src, "MedicationDispense", tgt.getExtension(), "detectedIssue");
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("MedicationDispense", "5.0", new String[] {"basedOn", "statusChanged", "recorded"}, CrossVersionElements40_N.urls("MedicationDispense", "6.0", new String[] {"fillNumber", "doseAdministrationAid"}, CrossVersionElements40_N.url("MedicationDispense", "5.0", "category"))));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "basedOn", "statusChanged", "recorded");
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "fillNumber", "doseAdministrationAid");
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference40_N.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR6Code(src.getStatusElement(), convertMedicationStatus(src.getStatusElement()), src.fhirType(), "status"));
    // R4 statusReason[x] is R6 notPerformedReason
    if (src.hasStatusReason())
      tgt.setNotPerformedReason(CodeableConcept40_N.convertChoiceToCodeableReference(src.getStatusReason()));
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
    for (org.hl7.fhir.r4.model.MedicationDispense.MedicationDispensePerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertMedicationDispensePerformerComponent(t));
    if (src.hasLocation())
      tgt.setLocation(Reference40_N.convertReference(src.getLocation()));
    for (org.hl7.fhir.r4.model.Reference t : src.getAuthorizingPrescription())
      tgt.addAuthorizingPrescription(Reference40_N.convertReference(t));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasDaysSupply())
      tgt.setDaysSupply(SimpleQuantity40_N.convertSimpleQuantity(src.getDaysSupply()));
    if (src.hasWhenPrepared())
      tgt.setWhenPreparedElement(DateTime40_N.convertDateTime(src.getWhenPreparedElement()));
    if (src.hasWhenHandedOver())
      tgt.setWhenHandedOverElement(DateTime40_N.convertDateTime(src.getWhenHandedOverElement()));
    if (src.hasDestination())
      tgt.setDestination(Reference40_N.convertReference(src.getDestination()));
    for (org.hl7.fhir.r4.model.Reference t : src.getReceiver()) tgt.addReceiver(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    DosageDetails40_N.convertDosages(src.getDosageInstruction(), src.getExtension(), tgt.getExtension(), "MedicationDispense.dosageInstruction", tgt.getDosageInstruction());
    if (src.hasSubstitution())
      tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
    for (org.hl7.fhir.r4.model.Reference t : src.getEventHistory())
      tgt.addEventHistory(Reference40_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.model.core.MedicationDispense src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicationDispense tgt = new org.hl7.fhir.r4.model.MedicationDispense();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("MedicationDispense", "4.0", new String[] {"detectedIssue"}));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "MedicationDispense", "detectedIssue");
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "basedOn", "statusChanged", "recorded");
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", "fillNumber", "doseAdministrationAid");
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.model.core.Reference t : src.getPartOfList()) tgt.addPartOf(Reference40_N.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR4Code(src.getStatusElement(), convertStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasNotPerformedReason())
      tgt.setStatusReason(CodeableConcept40_N.convertCodeableReferenceToChoice(src.getNotPerformedReason()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList()) {
      if (!tgt.hasCategory())
        tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(t));
      else
        tgt.addExtension(CrossVersionElements40_N.url("MedicationDispense", "5.0", "category"), CodeableConcept40_N.convertCodeableConcept(t));
    }
    if (src.hasMedication())
      tgt.setMedication(CodeableConcept40_N.convertCodeableReferenceToChoice(src.getMedication()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setContext(Reference40_N.convertReference(src.getEncounter()));
    for (org.hl7.fhir.model.core.Reference t : src.getSupportingInformationList())
      tgt.addSupportingInformation(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.MedicationDispense.MedicationDispensePerformerComponent t : src.getPerformerList())
      tgt.addPerformer(convertMedicationDispensePerformerComponent(t));
    if (src.hasLocation())
      tgt.setLocation(Reference40_N.convertReference(src.getLocation()));
    for (org.hl7.fhir.model.core.Reference t : src.getAuthorizingPrescriptionList())
      tgt.addAuthorizingPrescription(Reference40_N.convertReference(t));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasDaysSupply())
      tgt.setDaysSupply(SimpleQuantity40_N.convertSimpleQuantity(src.getDaysSupply()));
    if (src.hasWhenPrepared())
      tgt.setWhenPreparedElement(DateTime40_N.convertDateTime(src.getWhenPreparedElement()));
    if (src.hasWhenHandedOver())
      tgt.setWhenHandedOverElement(DateTime40_N.convertDateTime(src.getWhenHandedOverElement()));
    if (src.hasDestination())
      tgt.setDestination(Reference40_N.convertReference(src.getDestination()));
    for (org.hl7.fhir.model.core.Reference t : src.getReceiverList()) tgt.addReceiver(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    if (src.hasDosageInstruction())
      DosageDetails40_N.convertDosageDetails(src.getDosageInstruction(), "MedicationDispense.dosageInstruction", tgt.getDosageInstruction(), tgt.getExtension());
    if (src.hasSubstitution())
      tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
    for (org.hl7.fhir.model.core.Reference t : src.getEventHistoryList())
      tgt.addEventHistory(Reference40_N.convertReference(t));
    return tgt;
  }

  private static org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseStatus> convertStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseStatusCodes> src) {
      if (src == null)
          return null;
      Enumeration<MedicationDispense.MedicationDispenseStatus> tgt = new Enumeration<>(new MedicationDispense.MedicationDispenseStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case CANCELLED:
                  tgt.setValue(MedicationDispense.MedicationDispenseStatus.CANCELLED);
                  break;
              case COMPLETED:
                  tgt.setValue(MedicationDispense.MedicationDispenseStatus.COMPLETED);
                  break;
              case DECLINED:
                  tgt.setValue(MedicationDispense.MedicationDispenseStatus.DECLINED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(MedicationDispense.MedicationDispenseStatus.ENTEREDINERROR);
                  break;
              case INPROGRESS:
                  tgt.setValue(MedicationDispense.MedicationDispenseStatus.INPROGRESS);
                  break;
              case NULL:
                  tgt.setValue(MedicationDispense.MedicationDispenseStatus.NULL);
                  break;
              case ONHOLD:
                  tgt.setValue(MedicationDispense.MedicationDispenseStatus.ONHOLD);
                  break;
              case PREPARATION:
                  tgt.setValue(MedicationDispense.MedicationDispenseStatus.PREPARATION);
                  break;
              case UNFULFILLED:
                  tgt.setValue(MedicationDispense.MedicationDispenseStatus.STOPPED);
                  break;
              case UNKNOWN:
                  tgt.setValue(MedicationDispense.MedicationDispenseStatus.UNKNOWN);
                  break;
          }
      }
      return tgt;
  }

  private static org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseStatusCodes> convertMedicationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseStatus> src) {
      if (src == null)
          return null;
      org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseStatusCodes> tgt = new org.hl7.fhir.model.core.Enumeration<>(new MedicationDispenseStatusCodesEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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
              case STOPPED: // R5 renamed stopped to unfulfilled
                  tgt.setValue(org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseStatusCodes.UNFULFILLED);
                  break;
              case UNKNOWN:
                  tgt.setValue(org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseStatusCodes.UNKNOWN);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.MedicationDispense.MedicationDispensePerformerComponent convertMedicationDispensePerformerComponent(org.hl7.fhir.r4.model.MedicationDispense.MedicationDispensePerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MedicationDispense.MedicationDispensePerformerComponent tgt = new org.hl7.fhir.model.core.MedicationDispense.MedicationDispensePerformerComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept40_N.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference40_N.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationDispense.MedicationDispensePerformerComponent convertMedicationDispensePerformerComponent(org.hl7.fhir.model.core.MedicationDispense.MedicationDispensePerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicationDispense.MedicationDispensePerformerComponent tgt = new org.hl7.fhir.r4.model.MedicationDispense.MedicationDispensePerformerComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept40_N.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference40_N.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseSubstitutionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasWasSubstituted())
      tgt.setWasSubstitutedElement(Boolean40_N.convertBoolean(src.getWasSubstitutedElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept40_N.convertCodeableConcept(t));
    // R6 has one responsibleParty: the first, and the rest as 4.0 extensions
    for (org.hl7.fhir.r4.model.Reference t : src.getResponsibleParty())
      if (!tgt.hasResponsibleParty())
        tgt.setResponsibleParty(Reference40_N.convertReference(t));
      else
        tgt.addExtension(CrossVersionElements40_N.url("MedicationDispense.substitution", "4.0", "responsibleParty"), Reference40_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.model.core.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasWasSubstituted())
      tgt.setWasSubstitutedElement(Boolean40_N.convertBoolean(src.getWasSubstitutedElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getReasonList())
      tgt.addReason(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasResponsibleParty())
      tgt.addResponsibleParty(Reference40_N.convertReference(src.getResponsibleParty()));
    String rp = CrossVersionElements40_N.url("MedicationDispense.substitution", "4.0", "responsibleParty");
    tgt.getExtension().removeIf(e -> rp.equals(e.getUrl()));
    for (org.hl7.fhir.model.core.Extension e : src.getExtensionsByUrl(rp))
      tgt.addResponsibleParty(Reference40_N.convertReference((org.hl7.fhir.model.core.Reference) e.getValue()));
    return tgt;
  }
}