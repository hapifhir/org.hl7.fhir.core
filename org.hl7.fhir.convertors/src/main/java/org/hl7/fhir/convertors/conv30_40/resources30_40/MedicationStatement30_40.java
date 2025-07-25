package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Dosage30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Annotation30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.DateTime30_40;
import org.hl7.fhir.dstu3.model.Enumeration;
import org.hl7.fhir.dstu3.model.MedicationStatement;
import org.hl7.fhir.exceptions.FHIRException;

public class MedicationStatement30_40 {

  public static org.hl7.fhir.dstu3.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.r4.model.MedicationStatement src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.MedicationStatement tgt = new org.hl7.fhir.dstu3.model.MedicationStatement();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt, VersionConvertorConstants.EXT_MED_STAT_STATUS, VersionConvertorConstants.EXT_MED_STAT_TAKEN);

    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn())
      tgt.addBasedOn(Reference30_40.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getPartOf())
      tgt.addPartOf(Reference30_40.convertReference(t));
    if (src.hasContext())
      tgt.setContext(Reference30_40.convertReference(src.getContext()));

    if (src.hasExtension(VersionConvertorConstants.EXT_MED_STAT_STATUS)) {
      org.hl7.fhir.r4.model.Extension statusExtension = src.getExtensionByUrl(VersionConvertorConstants.EXT_MED_STAT_STATUS);
      if (statusExtension.getValue() instanceof org.hl7.fhir.r4.model.StringType) {
        tgt.setStatus(MedicationStatement.MedicationStatementStatus.fromCode(((org.hl7.fhir.r4.model.StringType) statusExtension.getValue()).getValue()));
      }
      if (src.hasExtension(VersionConvertorConstants.EXT_MED_STAT_TAKEN)) {
        org.hl7.fhir.r4.model.Extension takenExtension = src.getExtensionByUrl(VersionConvertorConstants.EXT_MED_STAT_TAKEN);
        if (takenExtension.getValue() instanceof org.hl7.fhir.r4.model.StringType) {
          tgt.setTaken(MedicationStatement.MedicationStatementTaken.fromCode(((org.hl7.fhir.r4.model.StringType) takenExtension.getValue()).getValue()));
        }
      }
    } else if (src.hasStatus()) {
      tgt.setStatusElement(convertMedicationStatementStatus(src.getStatusElement(), tgt));
    }

    if (src.hasCategory())
      tgt.setCategory(CodeableConcept30_40.convertCodeableConcept(src.getCategory()));
    if (src.hasMedication())
      tgt.setMedication(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getMedication()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getEffective()));
    if (src.hasDateAsserted())
      tgt.setDateAssertedElement(DateTime30_40.convertDateTime(src.getDateAssertedElement()));
    if (src.hasInformationSource())
      tgt.setInformationSource(Reference30_40.convertReference(src.getInformationSource()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
    for (org.hl7.fhir.r4.model.Reference t : src.getDerivedFrom())
      tgt.addDerivedFrom(Reference30_40.convertReference(t));

    if (src.getStatus() == org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.NOTTAKEN) {
      for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
        tgt.addReasonNotTaken(CodeableConcept30_40.convertCodeableConcept(t));
    } else {
      for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
        tgt.addReasonCode(CodeableConcept30_40.convertCodeableConcept(t));
    }

    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(Reference30_40.convertReference(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote())
      tgt.addNote(Annotation30_40.convertAnnotation(t));
    for (org.hl7.fhir.r4.model.Dosage t : src.getDosage())
      tgt.addDosage(Dosage30_40.convertDosage(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.dstu3.model.MedicationStatement src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicationStatement tgt = new org.hl7.fhir.r4.model.MedicationStatement();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);

    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn())
      tgt.addBasedOn(Reference30_40.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getPartOf())
      tgt.addPartOf(Reference30_40.convertReference(t));
    if (src.hasContext())
      tgt.setContext(Reference30_40.convertReference(src.getContext()));
    if (src.hasStatus()) {
      tgt.addExtension(new org.hl7.fhir.r4.model.Extension(VersionConvertorConstants.EXT_MED_STAT_STATUS, new org.hl7.fhir.r4.model.StringType(src.getStatus().toCode())));
      tgt.setStatusElement(convertMedicationStatementStatus(src.getStatusElement()));
    }
    if (src.hasTaken()) {
      tgt.addExtension(new org.hl7.fhir.r4.model.Extension(VersionConvertorConstants.EXT_MED_STAT_TAKEN, new org.hl7.fhir.r4.model.StringType(src.getTaken().toCode())));
      if (src.getTaken() == org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementTaken.N) {
        tgt.setStatus(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.NOTTAKEN);
      } else if (src.getTaken() == org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementTaken.UNK) {
        tgt.setStatus(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.UNKNOWN);
      }
    }
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept30_40.convertCodeableConcept(src.getCategory()));
    if (src.hasMedication())
      tgt.setMedication(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getMedication()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getEffective()));
    if (src.hasDateAsserted())
      tgt.setDateAssertedElement(DateTime30_40.convertDateTime(src.getDateAssertedElement()));
    if (src.hasInformationSource())
      tgt.setInformationSource(Reference30_40.convertReference(src.getInformationSource()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getDerivedFrom())
      tgt.addDerivedFrom(Reference30_40.convertReference(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonNotTaken())
      tgt.addReasonCode(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(Reference30_40.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote())
      tgt.addNote(Annotation30_40.convertAnnotation(t));
    for (org.hl7.fhir.dstu3.model.Dosage t : src.getDosage())
      tgt.addDosage(Dosage30_40.convertDosage(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus> convertMedicationStatementStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus> src, org.hl7.fhir.dstu3.model.MedicationStatement medicationStatementTarget) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    Enumeration<MedicationStatement.MedicationStatementStatus> tgt = new Enumeration<>(new MedicationStatement.MedicationStatementStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case ACTIVE:
          tgt.setValue(MedicationStatement.MedicationStatementStatus.ACTIVE);
          break;
        case COMPLETED:
          tgt.setValue(MedicationStatement.MedicationStatementStatus.COMPLETED);
          break;
        case ENTEREDINERROR:
          tgt.setValue(MedicationStatement.MedicationStatementStatus.ENTEREDINERROR);
          break;
        case INTENDED:
          tgt.setValue(MedicationStatement.MedicationStatementStatus.INTENDED);
          break;
        case STOPPED:
          tgt.setValue(MedicationStatement.MedicationStatementStatus.STOPPED);
          break;
        case ONHOLD:
          tgt.setValue(MedicationStatement.MedicationStatementStatus.ONHOLD);
          break;
        case UNKNOWN:
          tgt.setValue(MedicationStatement.MedicationStatementStatus.COMPLETED);
          medicationStatementTarget.setTaken(MedicationStatement.MedicationStatementTaken.UNK);
          break;
        case NOTTAKEN:
          tgt.setValue(MedicationStatement.MedicationStatementStatus.COMPLETED);
          medicationStatementTarget.setTaken(MedicationStatement.MedicationStatementTaken.N);
          break;
        default:
          tgt.setValue(MedicationStatement.MedicationStatementStatus.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus> convertMedicationStatementStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case ACTIVE:
          tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.ACTIVE);
          break;
        case COMPLETED:
          tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.COMPLETED);
          break;
        case ENTEREDINERROR:
          tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.ENTEREDINERROR);
          break;
        case INTENDED:
          tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.INTENDED);
          break;
        case STOPPED:
          tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.STOPPED);
          break;
        case ONHOLD:
          tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.ONHOLD);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.NULL);
          break;
      }
    }
    return tgt;
  }
}