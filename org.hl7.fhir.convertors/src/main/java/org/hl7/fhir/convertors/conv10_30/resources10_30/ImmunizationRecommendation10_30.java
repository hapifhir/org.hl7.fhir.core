package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.conv10_30.VersionConvertor_10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.DateTime10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.PositiveInt10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class ImmunizationRecommendation10_30 {

  public static org.hl7.fhir.dstu2.model.ImmunizationRecommendation convertImmunizationRecommendation(org.hl7.fhir.dstu3.model.ImmunizationRecommendation src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ImmunizationRecommendation tgt = new org.hl7.fhir.dstu2.model.ImmunizationRecommendation();
    VersionConvertor_10_30.copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasPatient())
      tgt.setPatient(Reference10_30.convertReference(src.getPatient()));
    for (org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent t : src.getRecommendation())
      tgt.addRecommendation(convertImmunizationRecommendationRecommendationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ImmunizationRecommendation convertImmunizationRecommendation(org.hl7.fhir.dstu2.model.ImmunizationRecommendation src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ImmunizationRecommendation tgt = new org.hl7.fhir.dstu3.model.ImmunizationRecommendation();
    VersionConvertor_10_30.copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasPatient())
      tgt.setPatient(Reference10_30.convertReference(src.getPatient()));
    for (org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent t : src.getRecommendation())
      tgt.addRecommendation(convertImmunizationRecommendationRecommendationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent convertImmunizationRecommendationRecommendationComponent(org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent tgt = new org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(DateTime10_30.convertDateTime(src.getDateElement()));
    if (src.hasVaccineCode())
      tgt.setVaccineCode(CodeableConcept10_30.convertCodeableConcept(src.getVaccineCode()));
    if (src.hasDoseNumberElement())
      tgt.setDoseNumberElement(PositiveInt10_30.convertPositiveInt(src.getDoseNumberElement()));
    if (src.hasForecastStatus())
      tgt.setForecastStatus(CodeableConcept10_30.convertCodeableConcept(src.getForecastStatus()));
    for (org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent t : src.getDateCriterion())
      tgt.addDateCriterion(convertImmunizationRecommendationRecommendationDateCriterionComponent(t));
    if (src.hasProtocol())
      tgt.setProtocol(convertImmunizationRecommendationRecommendationProtocolComponent(src.getProtocol()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getSupportingImmunization())
      tgt.addSupportingImmunization(Reference10_30.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getSupportingPatientInformation())
      tgt.addSupportingPatientInformation(Reference10_30.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent convertImmunizationRecommendationRecommendationComponent(org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent tgt = new org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(DateTime10_30.convertDateTime(src.getDateElement()));
    if (src.hasVaccineCode())
      tgt.setVaccineCode(CodeableConcept10_30.convertCodeableConcept(src.getVaccineCode()));
    if (src.hasDoseNumberElement())
      tgt.setDoseNumberElement(PositiveInt10_30.convertPositiveInt(src.getDoseNumberElement()));
    if (src.hasForecastStatus())
      tgt.setForecastStatus(CodeableConcept10_30.convertCodeableConcept(src.getForecastStatus()));
    for (org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent t : src.getDateCriterion())
      tgt.addDateCriterion(convertImmunizationRecommendationRecommendationDateCriterionComponent(t));
    if (src.hasProtocol())
      tgt.setProtocol(convertImmunizationRecommendationRecommendationProtocolComponent(src.getProtocol()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getSupportingImmunization())
      tgt.addSupportingImmunization(Reference10_30.convertReference(t));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getSupportingPatientInformation())
      tgt.addSupportingPatientInformation(Reference10_30.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent convertImmunizationRecommendationRecommendationDateCriterionComponent(org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent tgt = new org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_30.convertCodeableConcept(src.getCode()));
    if (src.hasValueElement())
      tgt.setValueElement(DateTime10_30.convertDateTime(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent convertImmunizationRecommendationRecommendationDateCriterionComponent(org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent tgt = new org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_30.convertCodeableConcept(src.getCode()));
    if (src.hasValueElement())
      tgt.setValueElement(DateTime10_30.convertDateTime(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationProtocolComponent convertImmunizationRecommendationRecommendationProtocolComponent(org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationProtocolComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationProtocolComponent tgt = new org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationProtocolComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasDoseSequence())
      tgt.setDoseSequence(src.getDoseSequence());
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    if (src.hasAuthority())
      tgt.setAuthority(Reference10_30.convertReference(src.getAuthority()));
    if (src.hasSeriesElement())
      tgt.setSeriesElement(String10_30.convertString(src.getSeriesElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationProtocolComponent convertImmunizationRecommendationRecommendationProtocolComponent(org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationProtocolComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationProtocolComponent tgt = new org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationProtocolComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasDoseSequence())
      tgt.setDoseSequence(src.getDoseSequence());
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    if (src.hasAuthority())
      tgt.setAuthority(Reference10_30.convertReference(src.getAuthority()));
    if (src.hasSeriesElement())
      tgt.setSeriesElement(String10_30.convertString(src.getSeriesElement()));
    return tgt;
  }
}