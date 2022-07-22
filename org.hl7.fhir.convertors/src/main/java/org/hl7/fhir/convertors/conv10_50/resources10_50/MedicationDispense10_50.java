package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.*;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Boolean10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.DateTime10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Dosage;
import org.hl7.fhir.r5.model.Dosage.DosageDoseAndRateComponent;
import org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodesEnumFactory;

public class MedicationDispense10_50 {

  public static org.hl7.fhir.r5.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.dstu2.model.MedicationDispense src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.MedicationDispense tgt = new org.hl7.fhir.r5.model.MedicationDispense();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(src.getIdentifier()));
    if (src.hasStatusElement())
      tgt.setStatusElement(convertMedicationDispenseStatus(src.getStatusElement()));
    if (src.hasMedicationCodeableConcept())
      tgt.getMedication().setConcept(CodeableConcept10_50.convertCodeableConcept(src.getMedicationCodeableConcept()));
    if (src.hasMedicationReference())
      tgt.getMedication().setReference(Reference10_50.convertReference(src.getMedicationReference()));
    if (src.hasPatient())
      tgt.setSubject(Reference10_50.convertReference(src.getPatient()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getAuthorizingPrescription())
      tgt.addAuthorizingPrescription(Reference10_50.convertReference(t));
    if (src.hasType())
      tgt.setType(CodeableConcept10_50.convertCodeableConcept(src.getType()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity10_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasDaysSupply())
      tgt.setDaysSupply(SimpleQuantity10_50.convertSimpleQuantity(src.getDaysSupply()));
    if (src.hasWhenPreparedElement())
      tgt.setWhenPreparedElement(DateTime10_50.convertDateTime(src.getWhenPreparedElement()));
    if (src.hasWhenHandedOverElement())
      tgt.setWhenHandedOverElement(DateTime10_50.convertDateTime(src.getWhenHandedOverElement()));
    if (src.hasDestination())
      tgt.setDestination(Reference10_50.convertReference(src.getDestination()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getReceiver()) tgt.addReceiver(Reference10_50.convertReference(t));
    if (src.hasNote())
      tgt.addNote().setText(src.getNote());
    for (org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent t : src.getDosageInstruction())
      tgt.addDosageInstruction(convertMedicationDispenseDosageInstructionComponent(t));
    if (src.hasSubstitution())
      tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.r5.model.MedicationDispense src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.MedicationDispense tgt = new org.hl7.fhir.dstu2.model.MedicationDispense();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_50.convertIdentifier(src.getIdentifierFirstRep()));
    if (src.hasStatusElement())
      tgt.setStatusElement(convertMedicationDispenseStatus(src.getStatusElement()));
    if (src.getMedication().hasConcept())
      tgt.setMedication(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getMedication().getConcept()));
    if (src.getMedication().hasReference())
      tgt.setMedication(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getMedication().getReference()));
    if (src.hasSubject())
      tgt.setPatient(Reference10_50.convertReference(src.getSubject()));
    for (org.hl7.fhir.r5.model.Reference t : src.getAuthorizingPrescription())
      tgt.addAuthorizingPrescription(Reference10_50.convertReference(t));
    if (src.hasType())
      tgt.setType(CodeableConcept10_50.convertCodeableConcept(src.getType()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity10_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasDaysSupply())
      tgt.setDaysSupply(SimpleQuantity10_50.convertSimpleQuantity(src.getDaysSupply()));
    if (src.hasWhenPreparedElement())
      tgt.setWhenPreparedElement(DateTime10_50.convertDateTime(src.getWhenPreparedElement()));
    if (src.hasWhenHandedOverElement())
      tgt.setWhenHandedOverElement(DateTime10_50.convertDateTime(src.getWhenHandedOverElement()));
    if (src.hasDestination())
      tgt.setDestination(Reference10_50.convertReference(src.getDestination()));
    for (org.hl7.fhir.r5.model.Reference t : src.getReceiver()) tgt.addReceiver(Reference10_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.setNote(t.getText());
    for (org.hl7.fhir.r5.model.Dosage t : src.getDosageInstruction())
      tgt.addDosageInstruction(convertMedicationDispenseDosageInstructionComponent(t));
    if (src.hasSubstitution())
      tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Dosage convertMedicationDispenseDosageInstructionComponent(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Dosage tgt = new org.hl7.fhir.r5.model.Dosage();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasTextElement())
      tgt.setTextElement(String10_50.convertString(src.getTextElement()));
    if (src.hasTiming())
      tgt.setTiming(Timing10_50.convertTiming(src.getTiming()));
    if (src.hasAsNeededBooleanType())
      tgt.setAsNeededElement(Boolean10_50.convertBoolean(src.getAsNeededBooleanType()));
    if (src.hasSiteCodeableConcept())
      tgt.setSite(CodeableConcept10_50.convertCodeableConcept(src.getSiteCodeableConcept()));
    if (src.hasRoute())
      tgt.setRoute(CodeableConcept10_50.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept10_50.convertCodeableConcept(src.getMethod()));
    if (src.hasDose() || src.hasRate()) {
      DosageDoseAndRateComponent dr = tgt.addDoseAndRate();
      if (src.hasDose())
        dr.setDose(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getDose()));
      if (src.hasRate())
        dr.setRate(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getRate()));
    }
    if (src.hasMaxDosePerPeriod())
      tgt.addMaxDosePerPeriod(Ratio10_50.convertRatio(src.getMaxDosePerPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent convertMedicationDispenseDosageInstructionComponent(Dosage src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent tgt = new org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    tgt.setText(src.getText());
    tgt.setTiming(Timing10_50.convertTiming(src.getTiming()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(Boolean10_50.convertBoolean(src.getAsNeededElement()));
    tgt.setSite(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getSite()));
    tgt.setRoute(CodeableConcept10_50.convertCodeableConcept(src.getRoute()));
    tgt.setMethod(CodeableConcept10_50.convertCodeableConcept(src.getMethod()));
    if (src.hasDoseAndRate() && src.getDoseAndRate().get(0).hasDose())
      tgt.setDose(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getDoseAndRate().get(0).getDose()));
    tgt.setMaxDosePerPeriod(Ratio10_50.convertRatio(src.getMaxDosePerPeriodFirstRep()));
    if (src.hasDoseAndRate() && src.getDoseAndRate().get(0).hasRate())
      tgt.setRate(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getDoseAndRate().get(0).getRate()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes> convertMedicationDispenseStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus> src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new MedicationDispenseStatusCodesEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.COMPLETED);
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
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.STOPPED);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus> convertMedicationDispenseStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes> src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus>(new org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatusEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.ENTEREDINERROR);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.INPROGRESS);
        break;
      case NULL:
        tgt.setValue(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.NULL);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.ONHOLD);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.STOPPED);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept10_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept10_50.convertCodeableConcept(t));
    if (src.hasResponsibleParty())
      tgt.addResponsibleParty(Reference10_50.convertReference(src.getResponsibleParty()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept10_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept10_50.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getResponsibleParty())
      tgt.setResponsibleParty(Reference10_50.convertReference(t));
    return tgt;
  }
}