package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.conv10_40.VersionConvertor_10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Type10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.*;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.DateTime10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext10_40;
import org.hl7.fhir.r4.model.Dosage;
import org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent;

public class MedicationDispense10_40 {

  public static org.hl7.fhir.r4.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.dstu2.model.MedicationDispense src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.MedicationDispense tgt = new org.hl7.fhir.r4.model.MedicationDispense();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(src.getIdentifier()));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationDispenseStatus(src.getStatusElement()));
    if (src.hasMedication())
      tgt.setMedication(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getMedication()));
    if (src.hasPatient())
      tgt.setSubject(Reference10_40.convertReference(src.getPatient()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getAuthorizingPrescription())
      tgt.addAuthorizingPrescription(Reference10_40.convertReference(t));
    if (src.hasType())
      tgt.setType(CodeableConcept10_40.convertCodeableConcept(src.getType()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity10_40.convertSimpleQuantity(src.getQuantity()));
    if (src.hasDaysSupply())
      tgt.setDaysSupply(SimpleQuantity10_40.convertSimpleQuantity(src.getDaysSupply()));
    if (src.hasWhenPreparedElement())
      tgt.setWhenPreparedElement(DateTime10_40.convertDateTime(src.getWhenPreparedElement()));
    if (src.hasWhenHandedOverElement())
      tgt.setWhenHandedOverElement(DateTime10_40.convertDateTime(src.getWhenHandedOverElement()));
    if (src.hasDestination())
      tgt.setDestination(Reference10_40.convertReference(src.getDestination()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getReceiver()) tgt.addReceiver(Reference10_40.convertReference(t));
    if (src.hasNote())
      tgt.addNote().setText(src.getNote());
    for (org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent t : src.getDosageInstruction())
      tgt.addDosageInstruction(convertMedicationDispenseDosageInstructionComponent(t));
    if (src.hasSubstitution())
      tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.r4.model.MedicationDispense src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.MedicationDispense tgt = new org.hl7.fhir.dstu2.model.MedicationDispense();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_40.convertIdentifier(src.getIdentifierFirstRep()));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationDispenseStatus(src.getStatusElement()));
    if (src.hasMedication())
      tgt.setMedication(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getMedication()));
    if (src.hasSubject())
      tgt.setPatient(Reference10_40.convertReference(src.getSubject()));
    for (org.hl7.fhir.r4.model.Reference t : src.getAuthorizingPrescription())
      tgt.addAuthorizingPrescription(Reference10_40.convertReference(t));
    if (src.hasType())
      tgt.setType(CodeableConcept10_40.convertCodeableConcept(src.getType()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity10_40.convertSimpleQuantity(src.getQuantity()));
    if (src.hasDaysSupply())
      tgt.setDaysSupply(SimpleQuantity10_40.convertSimpleQuantity(src.getDaysSupply()));
    if (src.hasWhenPreparedElement())
      tgt.setWhenPreparedElement(DateTime10_40.convertDateTime(src.getWhenPreparedElement()));
    if (src.hasWhenHandedOverElement())
      tgt.setWhenHandedOverElement(DateTime10_40.convertDateTime(src.getWhenHandedOverElement()));
    if (src.hasDestination())
      tgt.setDestination(Reference10_40.convertReference(src.getDestination()));
    for (org.hl7.fhir.r4.model.Reference t : src.getReceiver()) tgt.addReceiver(Reference10_40.convertReference(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.setNote(t.getText());
    for (org.hl7.fhir.r4.model.Dosage t : src.getDosageInstruction())
      tgt.addDosageInstruction(convertMedicationDispenseDosageInstructionComponent(t));
    if (src.hasSubstitution())
      tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Dosage convertMedicationDispenseDosageInstructionComponent(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Dosage tgt = new org.hl7.fhir.r4.model.Dosage();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasTextElement())
      tgt.setTextElement(String10_40.convertString(src.getTextElement()));
    if (src.hasTiming())
      tgt.setTiming(Timing10_40.convertTiming(src.getTiming()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getAsNeeded()));
    if (src.hasSiteCodeableConcept())
      tgt.setSite(CodeableConcept10_40.convertCodeableConcept(src.getSiteCodeableConcept()));
    if (src.hasRoute())
      tgt.setRoute(CodeableConcept10_40.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept10_40.convertCodeableConcept(src.getMethod()));
    if (src.hasDose() || src.hasRate()) {
      DosageDoseAndRateComponent dr = tgt.addDoseAndRate();
      if (src.hasDose())
        dr.setDose(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getDose()));
      if (src.hasRate())
        dr.setRate(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getRate()));
    }
    if (src.hasMaxDosePerPeriod())
      tgt.setMaxDosePerPeriod(Ratio10_40.convertRatio(src.getMaxDosePerPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent convertMedicationDispenseDosageInstructionComponent(Dosage src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent tgt = new org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    tgt.setText(src.getText());
    tgt.setTiming(Timing10_40.convertTiming(src.getTiming()));
    tgt.setAsNeeded(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getAsNeeded()));
    tgt.setSite(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getSite()));
    tgt.setRoute(CodeableConcept10_40.convertCodeableConcept(src.getRoute()));
    tgt.setMethod(CodeableConcept10_40.convertCodeableConcept(src.getMethod()));
    if (src.hasDoseAndRate() && src.getDoseAndRate().get(0).hasDose())
      tgt.setDose(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getDoseAndRate().get(0).getDose()));
    tgt.setMaxDosePerPeriod(Ratio10_40.convertRatio(src.getMaxDosePerPeriod()));
    if (src.hasDoseAndRate() && src.getDoseAndRate().get(0).hasRate())
      tgt.setRate(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getDoseAndRate().get(0).getRate()));
    return tgt;
  }

  private static org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseStatus> convertMedicationDispenseStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus> src) {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseStatusEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseStatus.ENTEREDINERROR);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseStatus.INPROGRESS);
        break;
      case NULL:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseStatus.NULL);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseStatus.ONHOLD);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseStatus.STOPPED);
        break;
    }
    return tgt;
  }

  private static org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus> convertMedicationDispenseStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseStatus> src) {
    if (src == null)
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatusEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.STOPPED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.COMPLETED);
        break;
      case DECLINED:
        tgt.setValue(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.STOPPED);
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
      case PREPARATION:
        tgt.setValue(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.INPROGRESS);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.STOPPED);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept10_40.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept10_40.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getResponsibleParty())
      tgt.addResponsibleParty(Reference10_40.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept10_40.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept10_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getResponsibleParty())
      tgt.addResponsibleParty(Reference10_40.convertReference(t));
    return tgt;
  }
}