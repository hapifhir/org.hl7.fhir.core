package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Dosage30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Annotation30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.SimpleQuantity30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Boolean30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.DateTime30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class MedicationDispense30_40 {

  public static org.hl7.fhir.dstu3.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.r4.model.MedicationDispense src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.MedicationDispense tgt = new org.hl7.fhir.dstu3.model.MedicationDispense();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference30_40.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationDispenseStatus(src.getStatusElement()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept30_40.convertCodeableConcept(src.getCategory()));
    if (src.hasMedication())
      tgt.setMedication(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getMedication()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setContext(Reference30_40.convertReference(src.getContext()));
    for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(Reference30_40.convertReference(t));
    for (org.hl7.fhir.r4.model.MedicationDispense.MedicationDispensePerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertMedicationDispensePerformerComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getAuthorizingPrescription())
      tgt.addAuthorizingPrescription(Reference30_40.convertReference(t));
    if (src.hasType())
      tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity30_40.convertSimpleQuantity(src.getQuantity()));
    if (src.hasDaysSupply())
      tgt.setDaysSupply(SimpleQuantity30_40.convertSimpleQuantity(src.getDaysSupply()));
    if (src.hasWhenPrepared())
      tgt.setWhenPreparedElement(DateTime30_40.convertDateTime(src.getWhenPreparedElement()));
    if (src.hasWhenHandedOver())
      tgt.setWhenHandedOverElement(DateTime30_40.convertDateTime(src.getWhenHandedOverElement()));
    if (src.hasDestination())
      tgt.setDestination(Reference30_40.convertReference(src.getDestination()));
    for (org.hl7.fhir.r4.model.Reference t : src.getReceiver()) tgt.addReceiver(Reference30_40.convertReference(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_40.convertAnnotation(t));
    for (org.hl7.fhir.r4.model.Dosage t : src.getDosageInstruction())
      tgt.addDosageInstruction(Dosage30_40.convertDosage(t));
    if (src.hasSubstitution())
      tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
    for (org.hl7.fhir.r4.model.Reference t : src.getDetectedIssue())
      tgt.addDetectedIssue(Reference30_40.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getEventHistory())
      tgt.addEventHistory(Reference30_40.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.dstu3.model.MedicationDispense src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicationDispense tgt = new org.hl7.fhir.r4.model.MedicationDispense();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference30_40.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationDispenseStatus(src.getStatusElement()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept30_40.convertCodeableConcept(src.getCategory()));
    if (src.hasMedication())
      tgt.setMedication(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getMedication()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setContext(Reference30_40.convertReference(src.getContext()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(Reference30_40.convertReference(t));
    for (org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispensePerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertMedicationDispensePerformerComponent(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getAuthorizingPrescription())
      tgt.addAuthorizingPrescription(Reference30_40.convertReference(t));
    if (src.hasType())
      tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity30_40.convertSimpleQuantity(src.getQuantity()));
    if (src.hasDaysSupply())
      tgt.setDaysSupply(SimpleQuantity30_40.convertSimpleQuantity(src.getDaysSupply()));
    if (src.hasWhenPrepared())
      tgt.setWhenPreparedElement(DateTime30_40.convertDateTime(src.getWhenPreparedElement()));
    if (src.hasWhenHandedOver())
      tgt.setWhenHandedOverElement(DateTime30_40.convertDateTime(src.getWhenHandedOverElement()));
    if (src.hasDestination())
      tgt.setDestination(Reference30_40.convertReference(src.getDestination()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getReceiver()) tgt.addReceiver(Reference30_40.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_40.convertAnnotation(t));
    for (org.hl7.fhir.dstu3.model.Dosage t : src.getDosageInstruction())
      tgt.addDosageInstruction(Dosage30_40.convertDosage(t));
    if (src.hasSubstitution())
      tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getDetectedIssue())
      tgt.addDetectedIssue(Reference30_40.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getEventHistory())
      tgt.addEventHistory(Reference30_40.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispensePerformerComponent convertMedicationDispensePerformerComponent(org.hl7.fhir.r4.model.MedicationDispense.MedicationDispensePerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispensePerformerComponent tgt = new org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispensePerformerComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasActor())
      tgt.setActor(Reference30_40.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationDispense.MedicationDispensePerformerComponent convertMedicationDispensePerformerComponent(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispensePerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicationDispense.MedicationDispensePerformerComponent tgt = new org.hl7.fhir.r4.model.MedicationDispense.MedicationDispensePerformerComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasActor())
      tgt.setActor(Reference30_40.convertReference(src.getActor()));
    return tgt;
  }

  private static org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseStatus> convertMedicationDispenseStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus> src) {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
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
      case PREPARATION:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseStatus.PREPARATION);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseStatus.STOPPED);
        break;
    }
    return tgt;
  }

  private static org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus> convertMedicationDispenseStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseStatus> src) {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.STOPPED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.COMPLETED);
        break;
      case DECLINED:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.STOPPED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.ENTEREDINERROR);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.INPROGRESS);
        break;
      case NULL:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.NULL);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.ONHOLD);
        break;
      case PREPARATION:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.PREPARATION);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.STOPPED);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasWasSubstituted())
      tgt.setWasSubstitutedElement(Boolean30_40.convertBoolean(src.getWasSubstitutedElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getResponsibleParty())
      tgt.addResponsibleParty(Reference30_40.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasWasSubstituted())
      tgt.setWasSubstitutedElement(Boolean30_40.convertBoolean(src.getWasSubstitutedElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getResponsibleParty())
      tgt.addResponsibleParty(Reference30_40.convertReference(t));
    return tgt;
  }
}