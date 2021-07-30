package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.conv10_30.VersionConvertor_10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Type10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.*;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.DateTime10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.dstu3.model.Dosage;
import org.hl7.fhir.exceptions.FHIRException;

public class MedicationDispense10_30 {

  public static org.hl7.fhir.dstu3.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.dstu2.model.MedicationDispense src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.MedicationDispense tgt = new org.hl7.fhir.dstu3.model.MedicationDispense();
    VersionConvertor_10_30.copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(src.getIdentifier()));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationDispenseStatus(src.getStatusElement()));
    if (src.hasMedication())
      tgt.setMedication(Type10_30.convertType(src.getMedication()));
    if (src.hasPatient())
      tgt.setSubject(Reference10_30.convertReference(src.getPatient()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getAuthorizingPrescription())
      tgt.addAuthorizingPrescription(Reference10_30.convertReference(t));
    if (src.hasType())
      tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity10_30.convertSimpleQuantity(src.getQuantity()));
    if (src.hasDaysSupply())
      tgt.setDaysSupply(SimpleQuantity10_30.convertSimpleQuantity(src.getDaysSupply()));
    if (src.hasWhenPreparedElement())
      tgt.setWhenPreparedElement(DateTime10_30.convertDateTime(src.getWhenPreparedElement()));
    if (src.hasWhenHandedOverElement())
      tgt.setWhenHandedOverElement(DateTime10_30.convertDateTime(src.getWhenHandedOverElement()));
    if (src.hasDestination())
      tgt.setDestination(Reference10_30.convertReference(src.getDestination()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getReceiver()) tgt.addReceiver(Reference10_30.convertReference(t));
    if (src.hasNote())
      tgt.addNote().setText(src.getNote());
    for (org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent t : src.getDosageInstruction())
      tgt.addDosageInstruction(convertMedicationDispenseDosageInstructionComponent(t));
    if (src.hasSubstitution())
      tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.dstu3.model.MedicationDispense src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.MedicationDispense tgt = new org.hl7.fhir.dstu2.model.MedicationDispense();
    VersionConvertor_10_30.copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_30.convertIdentifier(src.getIdentifierFirstRep()));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationDispenseStatus(src.getStatusElement()));
    if (src.hasMedication())
      tgt.setMedication(Type10_30.convertType(src.getMedication()));
    if (src.hasSubject())
      tgt.setPatient(Reference10_30.convertReference(src.getSubject()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getAuthorizingPrescription())
      tgt.addAuthorizingPrescription(Reference10_30.convertReference(t));
    if (src.hasType())
      tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity10_30.convertSimpleQuantity(src.getQuantity()));
    if (src.hasDaysSupply())
      tgt.setDaysSupply(SimpleQuantity10_30.convertSimpleQuantity(src.getDaysSupply()));
    if (src.hasWhenPreparedElement())
      tgt.setWhenPreparedElement(DateTime10_30.convertDateTime(src.getWhenPreparedElement()));
    if (src.hasWhenHandedOverElement())
      tgt.setWhenHandedOverElement(DateTime10_30.convertDateTime(src.getWhenHandedOverElement()));
    if (src.hasDestination())
      tgt.setDestination(Reference10_30.convertReference(src.getDestination()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getReceiver()) tgt.addReceiver(Reference10_30.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.setNote(t.getText());
    for (org.hl7.fhir.dstu3.model.Dosage t : src.getDosageInstruction())
      tgt.addDosageInstruction(convertMedicationDispenseDosageInstructionComponent(t));
    if (src.hasSubstitution())
      tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Dosage convertMedicationDispenseDosageInstructionComponent(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Dosage tgt = new org.hl7.fhir.dstu3.model.Dosage();
    Element10_30.copyElement(src, tgt);
    if (src.hasTextElement())
      tgt.setTextElement(String10_30.convertString(src.getTextElement()));
    if (src.hasTiming())
      tgt.setTiming(Timing10_30.convertTiming(src.getTiming()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(Type10_30.convertType(src.getAsNeeded()));
    if (src.hasSiteCodeableConcept())
      tgt.setSite(CodeableConcept10_30.convertCodeableConcept(src.getSiteCodeableConcept()));
    if (src.hasRoute())
      tgt.setRoute(CodeableConcept10_30.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept10_30.convertCodeableConcept(src.getMethod()));
    if (src.hasDose())
      tgt.setDose(Type10_30.convertType(src.getDose()));
    if (src.hasRate())
      tgt.setRate(Type10_30.convertType(src.getRate()));
    if (src.hasMaxDosePerPeriod())
      tgt.setMaxDosePerPeriod(Ratio10_30.convertRatio(src.getMaxDosePerPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent convertMedicationDispenseDosageInstructionComponent(Dosage src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent tgt = new org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent();
    Element10_30.copyElement(src, tgt);
    tgt.setText(src.getText());
    tgt.setTiming(Timing10_30.convertTiming(src.getTiming()));
    tgt.setAsNeeded(Type10_30.convertType(src.getAsNeeded()));
    tgt.setSite(Type10_30.convertType(src.getSite()));
    tgt.setRoute(CodeableConcept10_30.convertCodeableConcept(src.getRoute()));
    tgt.setMethod(CodeableConcept10_30.convertCodeableConcept(src.getMethod()));
    tgt.setDose(Type10_30.convertType(src.getDose()));
    tgt.setRate(Type10_30.convertType(src.getRate()));
    tgt.setMaxDosePerPeriod(Ratio10_30.convertRatio(src.getMaxDosePerPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus> convertMedicationDispenseStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatusEnumFactory());
    Element10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.INPROGRESS);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.ONHOLD);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.ENTEREDINERROR);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.STOPPED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus> convertMedicationDispenseStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatusEnumFactory());
    Element10_30.copyElement(src, tgt);
    switch (src.getValue()) {
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
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept10_30.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getResponsibleParty())
      tgt.addResponsibleParty(Reference10_30.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept10_30.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getResponsibleParty())
      tgt.addResponsibleParty(Reference10_30.convertReference(t));
    return tgt;
  }
}