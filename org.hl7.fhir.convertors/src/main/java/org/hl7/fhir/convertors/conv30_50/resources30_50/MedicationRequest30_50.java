package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Dosage30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Annotation30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Duration30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Period30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.SimpleQuantity30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Boolean30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.DateTime30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

public class MedicationRequest30_50 {

  public static org.hl7.fhir.dstu3.model.MedicationRequest convertMedicationRequest(org.hl7.fhir.r5.model.MedicationRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.MedicationRequest tgt = new org.hl7.fhir.dstu3.model.MedicationRequest();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference30_50.convertReference(t));
    if (src.hasGroupIdentifier())
      tgt.setGroupIdentifier(Identifier30_50.convertIdentifier(src.getGroupIdentifier()));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationRequestStatus(src.getStatusElement()));
    if (src.hasIntent())
      tgt.setIntentElement(convertMedicationRequestIntent(src.getIntentElement()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertMedicationRequestPriority(src.getPriorityElement()));
    if (src.getMedication().hasConcept())
      tgt.setMedication(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getMedication().getConcept()));
    if (src.getMedication().hasReference())
      tgt.setMedication(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getMedication().getReference()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setContext(Reference30_50.convertReference(src.getEncounter()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(Reference30_50.convertReference(t));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime30_50.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRecorder())
      tgt.setRecorder(Reference30_50.convertReference(src.getRecorder()));
    for (CodeableReference t : src.getReason()) {
      if (t.hasConcept()) {
        tgt.addReasonCode(CodeableConcept30_50.convertCodeableConcept(t.getConcept()));
      }
      if (t.hasReference()) {
        tgt.addReasonReference(Reference30_50.convertReference(t.getReference()));
      }
    }
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_50.convertAnnotation(t));
    for (org.hl7.fhir.r5.model.Dosage t : src.getDosageInstruction())
      tgt.addDosageInstruction(Dosage30_50.convertDosage(t));
    if (src.hasDispenseRequest())
      tgt.setDispenseRequest(convertMedicationRequestDispenseRequestComponent(src.getDispenseRequest()));
    if (src.hasSubstitution())
      tgt.setSubstitution(convertMedicationRequestSubstitutionComponent(src.getSubstitution()));
    if (src.hasPriorPrescription())
      tgt.setPriorPrescription(Reference30_50.convertReference(src.getPriorPrescription()));
//    for (org.hl7.fhir.r5.model.Reference t : src.getDetectedIssue())
//      tgt.addDetectedIssue(Reference30_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getEventHistory())
      tgt.addEventHistory(Reference30_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicationRequest convertMedicationRequest(org.hl7.fhir.dstu3.model.MedicationRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationRequest tgt = new org.hl7.fhir.r5.model.MedicationRequest();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference30_50.convertReference(t));
    if (src.hasGroupIdentifier())
      tgt.setGroupIdentifier(Identifier30_50.convertIdentifier(src.getGroupIdentifier()));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationRequestStatus(src.getStatusElement()));
    if (src.hasIntent())
      tgt.setIntentElement(convertMedicationRequestIntent(src.getIntentElement()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertMedicationRequestPriority(src.getPriorityElement()));
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
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime30_50.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRecorder())
      tgt.setRecorder(Reference30_50.convertReference(src.getRecorder()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(new CodeableReference().setConcept(CodeableConcept30_50.convertCodeableConcept(t)));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference())
      tgt.addReason(new CodeableReference().setReference(Reference30_50.convertReference(t)));
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_50.convertAnnotation(t));
    for (org.hl7.fhir.dstu3.model.Dosage t : src.getDosageInstruction())
      tgt.addDosageInstruction(Dosage30_50.convertDosage(t));
    if (src.hasDispenseRequest())
      tgt.setDispenseRequest(convertMedicationRequestDispenseRequestComponent(src.getDispenseRequest()));
    if (src.hasSubstitution())
      tgt.setSubstitution(convertMedicationRequestSubstitutionComponent(src.getSubstitution()));
    if (src.hasPriorPrescription())
      tgt.setPriorPrescription(Reference30_50.convertReference(src.getPriorPrescription()));
//    for (org.hl7.fhir.dstu3.model.Reference t : src.getDetectedIssue())
//      tgt.addDetectedIssue(Reference30_50.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getEventHistory())
      tgt.addEventHistory(Reference30_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestComponent convertMedicationRequestDispenseRequestComponent(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestDispenseRequestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestComponent tgt = new org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasValidityPeriod())
      tgt.setValidityPeriod(Period30_50.convertPeriod(src.getValidityPeriod()));
    if (src.hasNumberOfRepeatsAllowed())
      tgt.setNumberOfRepeatsAllowed(src.getNumberOfRepeatsAllowed());
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity30_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasExpectedSupplyDuration())
      tgt.setExpectedSupplyDuration(Duration30_50.convertDuration(src.getExpectedSupplyDuration()));
    if (src.hasPerformer())
      tgt.setDispenser(Reference30_50.convertReference(src.getPerformer()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestDispenseRequestComponent convertMedicationRequestDispenseRequestComponent(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestDispenseRequestComponent tgt = new org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestDispenseRequestComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasValidityPeriod())
      tgt.setValidityPeriod(Period30_50.convertPeriod(src.getValidityPeriod()));
    if (src.hasNumberOfRepeatsAllowed())
      tgt.setNumberOfRepeatsAllowed(src.getNumberOfRepeatsAllowed());
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity30_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasExpectedSupplyDuration())
      tgt.setExpectedSupplyDuration(Duration30_50.convertDuration(src.getExpectedSupplyDuration()));
    if (src.hasDispenser())
      tgt.setPerformer(Reference30_50.convertReference(src.getDispenser()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent> convertMedicationRequestIntent(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntent> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntentEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROPOSAL:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.PROPOSAL);
        break;
      case PLAN:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.PLAN);
        break;
      case ORDER:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.ORDER);
        break;
      case INSTANCEORDER:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.INSTANCEORDER);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntent> convertMedicationRequestIntent(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntent> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntentEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROPOSAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntent.PROPOSAL);
        break;
      case PLAN:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntent.PLAN);
        break;
      case ORDER:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntent.ORDER);
        break;
      case INSTANCEORDER:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntent.INSTANCEORDER);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntent.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> convertMedicationRequestPriority(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriority> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestPriorityEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ROUTINE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.ROUTINE);
        break;
      case URGENT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.URGENT);
        break;
      case STAT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.STAT);
        break;
      case ASAP:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.ASAP);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriority> convertMedicationRequestPriority(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriority> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriorityEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ROUTINE:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriority.ROUTINE);
        break;
      case URGENT:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriority.URGENT);
        break;
      case STAT:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriority.STAT);
        break;
      case ASAP:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriority.ASAP);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriority.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus> convertMedicationRequestStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.ACTIVE);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.ONHOLD);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.CANCELLED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.ENTEREDINERROR);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.STOPPED);
        break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.DRAFT);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus> convertMedicationRequestStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.ACTIVE);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.ONHOLD);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.CANCELLED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.ENTEREDINERROR);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.STOPPED);
        break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.DRAFT);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestSubstitutionComponent convertMedicationRequestSubstitutionComponent(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestSubstitutionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestSubstitutionComponent tgt = new org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestSubstitutionComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasAllowed())
      tgt.setAllowed(Boolean30_50.convertBoolean(src.getAllowedElement()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept30_50.convertCodeableConcept(src.getReason()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestSubstitutionComponent convertMedicationRequestSubstitutionComponent(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestSubstitutionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestSubstitutionComponent tgt = new org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestSubstitutionComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasAllowedBooleanType())
      tgt.setAllowedElement(Boolean30_50.convertBoolean(src.getAllowedBooleanType()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept30_50.convertCodeableConcept(src.getReason()));
    return tgt;
  }
}