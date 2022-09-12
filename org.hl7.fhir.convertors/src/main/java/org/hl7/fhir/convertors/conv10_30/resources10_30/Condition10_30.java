package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Condition10_30 {

  public static org.hl7.fhir.dstu3.model.Condition convertCondition(org.hl7.fhir.dstu2.model.Condition src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Condition tgt = new org.hl7.fhir.dstu3.model.Condition();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasPatient())
      tgt.setSubject(Reference10_30.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setContext(Reference10_30.convertReference(src.getEncounter()));
    if (src.hasAsserter())
      tgt.setAsserter(Reference10_30.convertReference(src.getAsserter()));
    if (src.hasDateRecorded())
      tgt.setAssertedDate(src.getDateRecorded());
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_30.convertCodeableConcept(src.getCode()));
    if (src.hasCategory())
      tgt.addCategory(CodeableConcept10_30.convertCodeableConcept(src.getCategory()));
    try {
      if (src.hasClinicalStatus())
        tgt.setClinicalStatus(org.hl7.fhir.dstu3.model.Condition.ConditionClinicalStatus.fromCode(src.getClinicalStatus()));
    } catch (org.hl7.fhir.exceptions.FHIRException e) {
      throw new FHIRException(e);
    }
    if (src.hasVerificationStatus())
      tgt.setVerificationStatusElement(convertConditionVerificationStatus(src.getVerificationStatusElement()));
    if (src.hasSeverity())
      tgt.setSeverity(CodeableConcept10_30.convertCodeableConcept(src.getSeverity()));
    if (src.hasOnset())
      tgt.setOnset(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getOnset()));
    if (src.hasAbatement())
      tgt.setAbatement(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getAbatement()));
    if (src.hasStage())
      tgt.setStage(convertConditionStageComponent(src.getStage()));
    for (org.hl7.fhir.dstu2.model.Condition.ConditionEvidenceComponent t : src.getEvidence())
      tgt.addEvidence(convertConditionEvidenceComponent(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(CodeableConcept10_30.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Condition convertCondition(org.hl7.fhir.dstu3.model.Condition src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Condition tgt = new org.hl7.fhir.dstu2.model.Condition();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasSubject())
      tgt.setPatient(Reference10_30.convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setEncounter(Reference10_30.convertReference(src.getContext()));
    if (src.hasAsserter())
      tgt.setAsserter(Reference10_30.convertReference(src.getAsserter()));
    if (src.hasAssertedDate())
      tgt.setDateRecorded(src.getAssertedDate());
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_30.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory())
      tgt.setCategory(CodeableConcept10_30.convertCodeableConcept(t));
    tgt.setClinicalStatus(src.getClinicalStatus().toCode());
    if (src.hasVerificationStatus())
      tgt.setVerificationStatusElement(convertConditionVerificationStatus(src.getVerificationStatusElement()));
    if (src.hasSeverity())
      tgt.setSeverity(CodeableConcept10_30.convertCodeableConcept(src.getSeverity()));
    if (src.hasOnset())
      tgt.setOnset(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getOnset()));
    if (src.hasAbatement())
      tgt.setAbatement(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getAbatement()));
    if (src.hasStage())
      tgt.setStage(convertConditionStageComponent(src.getStage()));
    for (org.hl7.fhir.dstu3.model.Condition.ConditionEvidenceComponent t : src.getEvidence())
      tgt.addEvidence(convertConditionEvidenceComponent(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(CodeableConcept10_30.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Condition.ConditionEvidenceComponent convertConditionEvidenceComponent(org.hl7.fhir.dstu3.model.Condition.ConditionEvidenceComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Condition.ConditionEvidenceComponent tgt = new org.hl7.fhir.dstu2.model.Condition.ConditionEvidenceComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.dstu3.model.CodeableConcept cc : src.getCode())
      tgt.setCode(CodeableConcept10_30.convertCodeableConcept(cc));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getDetail()) tgt.addDetail(Reference10_30.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Condition.ConditionEvidenceComponent convertConditionEvidenceComponent(org.hl7.fhir.dstu2.model.Condition.ConditionEvidenceComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Condition.ConditionEvidenceComponent tgt = new org.hl7.fhir.dstu3.model.Condition.ConditionEvidenceComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyBackboneElement(src,tgt);
    if (src.hasCode())
      tgt.addCode(CodeableConcept10_30.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getDetail()) tgt.addDetail(Reference10_30.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Condition.ConditionStageComponent convertConditionStageComponent(org.hl7.fhir.dstu2.model.Condition.ConditionStageComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Condition.ConditionStageComponent tgt = new org.hl7.fhir.dstu3.model.Condition.ConditionStageComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyBackboneElement(src,tgt);
    if (src.hasSummary())
      tgt.setSummary(CodeableConcept10_30.convertCodeableConcept(src.getSummary()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getAssessment())
      tgt.addAssessment(Reference10_30.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Condition.ConditionStageComponent convertConditionStageComponent(org.hl7.fhir.dstu3.model.Condition.ConditionStageComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Condition.ConditionStageComponent tgt = new org.hl7.fhir.dstu2.model.Condition.ConditionStageComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyBackboneElement(src,tgt);
    if (src.hasSummary())
      tgt.setSummary(CodeableConcept10_30.convertCodeableConcept(src.getSummary()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getAssessment())
      tgt.addAssessment(Reference10_30.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Condition.ConditionVerificationStatus> convertConditionVerificationStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Condition.ConditionVerificationStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Condition.ConditionVerificationStatusEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROVISIONAL:
        tgt.setValue(org.hl7.fhir.dstu2.model.Condition.ConditionVerificationStatus.PROVISIONAL);
        break;
      case DIFFERENTIAL:
        tgt.setValue(org.hl7.fhir.dstu2.model.Condition.ConditionVerificationStatus.DIFFERENTIAL);
        break;
      case CONFIRMED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Condition.ConditionVerificationStatus.CONFIRMED);
        break;
      case REFUTED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Condition.ConditionVerificationStatus.REFUTED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu2.model.Condition.ConditionVerificationStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.dstu2.model.Condition.ConditionVerificationStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Condition.ConditionVerificationStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus> convertConditionVerificationStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Condition.ConditionVerificationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatusEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROVISIONAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus.PROVISIONAL);
        break;
      case DIFFERENTIAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus.DIFFERENTIAL);
        break;
      case CONFIRMED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus.CONFIRMED);
        break;
      case REFUTED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus.REFUTED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus.NULL);
        break;
    }
    return tgt;
  }
}