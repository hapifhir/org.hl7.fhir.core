package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Dosage30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Annotation30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.DateTime30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

public class MedicationStatement30_50 {

  public static org.hl7.fhir.r5.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.dstu3.model.MedicationStatement src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationStatement tgt = new org.hl7.fhir.r5.model.MedicationStatement();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
//    for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference30_50.convertReference(t));
//    for (org.hl7.fhir.dstu3.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference30_50.convertReference(t));
    if (src.hasContext())
      tgt.setEncounter(Reference30_50.convertReference(src.getContext()));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationStatementStatus(src.getStatusElement()));
    if (src.hasCategory())
      tgt.addCategory(CodeableConcept30_50.convertCodeableConcept(src.getCategory()));
    if (src.hasMedicationCodeableConcept()) {
      tgt.getMedication().setConcept(CodeableConcept30_50.convertCodeableConcept(src.getMedicationCodeableConcept()));
    }
    if (src.hasMedicationReference()) {
      tgt.getMedication().setReference(Reference30_50.convertReference(src.getMedicationReference()));
    }
    if (src.hasEffective())
      tgt.setEffective(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getEffective()));
    if (src.hasDateAsserted())
      tgt.setDateAssertedElement(DateTime30_50.convertDateTime(src.getDateAssertedElement()));
    if (src.hasInformationSource())
      tgt.addInformationSource(Reference30_50.convertReference(src.getInformationSource()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getDerivedFrom())
      tgt.addDerivedFrom(Reference30_50.convertReference(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(Reference30_50.convertCodeableConceptToCodableReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference30_50.convertReferenceToCodableReference(t));
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_50.convertAnnotation(t));
    for (org.hl7.fhir.dstu3.model.Dosage t : src.getDosage()) tgt.addDosage(Dosage30_50.convertDosage(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.r5.model.MedicationStatement src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.MedicationStatement tgt = new org.hl7.fhir.dstu3.model.MedicationStatement();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
//    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference30_50.convertReference(t));
//    for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference30_50.convertReference(t));
    if (src.hasEncounter())
      tgt.setContext(Reference30_50.convertReference(src.getEncounter()));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationStatementStatus(src.getStatusElement()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept30_50.convertCodeableConcept(src.getCategoryFirstRep()));
    if (src.getMedication().hasConcept()) {
      tgt.setMedication(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getMedication().getConcept()));
    }
    if (src.getMedication().hasReference()) {
      tgt.setMedication(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getMedication().getReference()));
    }
    if (src.hasEffective())
      tgt.setEffective(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getEffective()));
    if (src.hasDateAsserted())
      tgt.setDateAssertedElement(DateTime30_50.convertDateTime(src.getDateAssertedElement()));
    if (src.hasInformationSource())
      tgt.setInformationSource(Reference30_50.convertReference(src.getInformationSourceFirstRep()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    for (org.hl7.fhir.r5.model.Reference t : src.getDerivedFrom())
      tgt.addDerivedFrom(Reference30_50.convertReference(t));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept30_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReason())
      if (t.hasReference())
        tgt.addReasonReference(Reference30_50.convertReference(t.getReference()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_50.convertAnnotation(t));
    for (org.hl7.fhir.r5.model.Dosage t : src.getDosage()) tgt.addDosage(Dosage30_50.convertDosage(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus> convertMedicationStatementStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
//            case ACTIVE:
//                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.ACTIVE);
//                break;
      case RECORDED:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.ENTEREDINERROR);
        break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.COMPLETED);
        break;
//            case STOPPED:
//                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.STOPPED);
//                break;
//            case ONHOLD:
//                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.ONHOLD);
//                break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes> convertMedicationStatementStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodesEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes.RECORDED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes.RECORDED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes.ENTEREDINERROR);
        break;
      case INTENDED:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes.RECORDED);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes.RECORDED);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes.RECORDED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes.NULL);
        break;
    }
    return tgt;
  }
}