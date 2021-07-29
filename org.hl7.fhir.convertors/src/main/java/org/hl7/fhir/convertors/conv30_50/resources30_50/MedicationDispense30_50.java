package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Dosage30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Annotation30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.SimpleQuantity30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Boolean30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.DateTime30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class MedicationDispense30_50 {

  public static org.hl7.fhir.dstu3.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.r5.model.MedicationDispense src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.MedicationDispense tgt = new org.hl7.fhir.dstu3.model.MedicationDispense();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference30_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationDispenseStatus(src.getStatusElement()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept30_50.convertCodeableConcept(src.getCategoryFirstRep()));
    if (src.getMedication().hasConcept())
      tgt.setMedication(VersionConvertorFactory_30_50.convertType(src.getMedication().getConcept()));
    if (src.getMedication().hasReference())
      tgt.setMedication(VersionConvertorFactory_30_50.convertType(src.getMedication().getReference()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setContext(Reference30_50.convertReference(src.getEncounter()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(Reference30_50.convertReference(t));
    for (org.hl7.fhir.r5.model.MedicationDispense.MedicationDispensePerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertMedicationDispensePerformerComponent(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getAuthorizingPrescription())
      tgt.addAuthorizingPrescription(Reference30_50.convertReference(t));
    if (src.hasType())
      tgt.setType(CodeableConcept30_50.convertCodeableConcept(src.getType()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity30_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasDaysSupply())
      tgt.setDaysSupply(SimpleQuantity30_50.convertSimpleQuantity(src.getDaysSupply()));
    if (src.hasWhenPrepared())
      tgt.setWhenPreparedElement(DateTime30_50.convertDateTime(src.getWhenPreparedElement()));
    if (src.hasWhenHandedOver())
      tgt.setWhenHandedOverElement(DateTime30_50.convertDateTime(src.getWhenHandedOverElement()));
    if (src.hasDestination())
      tgt.setDestination(Reference30_50.convertReference(src.getDestination()));
    for (org.hl7.fhir.r5.model.Reference t : src.getReceiver()) tgt.addReceiver(Reference30_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_50.convertAnnotation(t));
    for (org.hl7.fhir.r5.model.Dosage t : src.getDosageInstruction())
      tgt.addDosageInstruction(Dosage30_50.convertDosage(t));
    if (src.hasSubstitution())
      tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
    for (org.hl7.fhir.r5.model.Reference t : src.getDetectedIssue())
      tgt.addDetectedIssue(Reference30_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getEventHistory())
      tgt.addEventHistory(Reference30_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.dstu3.model.MedicationDispense src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationDispense tgt = new org.hl7.fhir.r5.model.MedicationDispense();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference30_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationDispenseStatus(src.getStatusElement()));
    if (src.hasCategory())
      tgt.addCategory(CodeableConcept30_50.convertCodeableConcept(src.getCategory()));
    if (src.hasMedicationCodeableConcept())
      tgt.getMedication().setConcept(CodeableConcept30_50.convertCodeableConcept(src.getMedicationCodeableConcept()));
    if (src.hasMedicationReference())
      tgt.getMedication().setReference(Reference30_50.convertReference(src.getMedicationReference()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setEncounter(Reference30_50.convertReference(src.getContext()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(Reference30_50.convertReference(t));
    for (org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispensePerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertMedicationDispensePerformerComponent(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getAuthorizingPrescription())
      tgt.addAuthorizingPrescription(Reference30_50.convertReference(t));
    if (src.hasType())
      tgt.setType(CodeableConcept30_50.convertCodeableConcept(src.getType()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity30_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasDaysSupply())
      tgt.setDaysSupply(SimpleQuantity30_50.convertSimpleQuantity(src.getDaysSupply()));
    if (src.hasWhenPrepared())
      tgt.setWhenPreparedElement(DateTime30_50.convertDateTime(src.getWhenPreparedElement()));
    if (src.hasWhenHandedOver())
      tgt.setWhenHandedOverElement(DateTime30_50.convertDateTime(src.getWhenHandedOverElement()));
    if (src.hasDestination())
      tgt.setDestination(Reference30_50.convertReference(src.getDestination()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getReceiver()) tgt.addReceiver(Reference30_50.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_50.convertAnnotation(t));
    for (org.hl7.fhir.dstu3.model.Dosage t : src.getDosageInstruction())
      tgt.addDosageInstruction(Dosage30_50.convertDosage(t));
    if (src.hasSubstitution())
      tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getDetectedIssue())
      tgt.addDetectedIssue(Reference30_50.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getEventHistory())
      tgt.addEventHistory(Reference30_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicationDispense.MedicationDispensePerformerComponent convertMedicationDispensePerformerComponent(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispensePerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationDispense.MedicationDispensePerformerComponent tgt = new org.hl7.fhir.r5.model.MedicationDispense.MedicationDispensePerformerComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasActor())
      tgt.setActor(Reference30_50.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispensePerformerComponent convertMedicationDispensePerformerComponent(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispensePerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispensePerformerComponent tgt = new org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispensePerformerComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasActor())
      tgt.setActor(Reference30_50.convertReference(src.getActor()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus> convertMedicationDispenseStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes> src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus>();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PREPARATION:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.PREPARATION);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.INPROGRESS);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.ONHOLD);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.ENTEREDINERROR);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.STOPPED);
        break;
      case DECLINED:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.STOPPED);
        break;
      case NULL:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes> convertMedicationDispenseStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus> src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes>(new org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodesEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PREPARATION:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.PREPARATION);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.INPROGRESS);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.ONHOLD);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.ENTEREDINERROR);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.STOPPED);
        break;
      case NULL:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasWasSubstituted())
      tgt.setWasSubstitutedElement(Boolean30_50.convertBoolean(src.getWasSubstitutedElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getResponsibleParty())
      tgt.setResponsibleParty(Reference30_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasWasSubstituted())
      tgt.setWasSubstitutedElement(Boolean30_50.convertBoolean(src.getWasSubstitutedElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasResponsibleParty())
      tgt.addResponsibleParty(Reference30_50.convertReference(src.getResponsibleParty()));
    return tgt;
  }
}