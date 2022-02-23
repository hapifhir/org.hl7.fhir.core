package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Annotation10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.SimpleQuantity10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.*;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.Immunization.ImmunizationPractitionerComponent;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.List;

public class Immunization10_30 {

  public static org.hl7.fhir.dstu2.model.Immunization convertImmunization(org.hl7.fhir.dstu3.model.Immunization src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Immunization tgt = new org.hl7.fhir.dstu2.model.Immunization();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    tgt.setStatus(src.getStatus().toCode());
    if (src.hasDate())
      tgt.setDateElement(DateTime10_30.convertDateTime(src.getDateElement()));
    if (src.hasVaccineCode())
      tgt.setVaccineCode(CodeableConcept10_30.convertCodeableConcept(src.getVaccineCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference10_30.convertReference(src.getPatient()));
    if (src.hasNotGivenElement())
      tgt.setWasNotGivenElement(Boolean10_30.convertBoolean(src.getNotGivenElement()));
    tgt.setReported(!src.getPrimarySource());
    tgt.setPerformer(Reference10_30.convertReference(getPerformer(src.getPractitioner())));
    tgt.setRequester(Reference10_30.convertReference(getRequester(src.getPractitioner())));
    if (src.hasEncounter())
      tgt.setEncounter(Reference10_30.convertReference(src.getEncounter()));
    if (src.hasManufacturer())
      tgt.setManufacturer(Reference10_30.convertReference(src.getManufacturer()));
    if (src.hasLocation())
      tgt.setLocation(Reference10_30.convertReference(src.getLocation()));
    if (src.hasLotNumberElement())
      tgt.setLotNumberElement(String10_30.convertString(src.getLotNumberElement()));
    if (src.hasExpirationDateElement())
      tgt.setExpirationDateElement(Date10_30.convertDate(src.getExpirationDateElement()));
    if (src.hasSite())
      tgt.setSite(CodeableConcept10_30.convertCodeableConcept(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(CodeableConcept10_30.convertCodeableConcept(src.getRoute()));
    if (src.hasDoseQuantity())
      tgt.setDoseQuantity(SimpleQuantity10_30.convertSimpleQuantity(src.getDoseQuantity()));
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(Annotation10_30.convertAnnotation(t));
    if (src.hasExplanation())
      tgt.setExplanation(convertImmunizationExplanationComponent(src.getExplanation()));
    for (org.hl7.fhir.dstu3.model.Immunization.ImmunizationReactionComponent t : src.getReaction())
      tgt.addReaction(convertImmunizationReactionComponent(t));
    for (org.hl7.fhir.dstu3.model.Immunization.ImmunizationVaccinationProtocolComponent t : src.getVaccinationProtocol())
      tgt.addVaccinationProtocol(convertImmunizationVaccinationProtocolComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Immunization convertImmunization(org.hl7.fhir.dstu2.model.Immunization src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Immunization tgt = new org.hl7.fhir.dstu3.model.Immunization();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    try {
      if (src.hasStatus())
        tgt.setStatus(org.hl7.fhir.dstu3.model.Immunization.ImmunizationStatus.fromCode(src.getStatus()));
    } catch (org.hl7.fhir.exceptions.FHIRException e) {
      throw new FHIRException(e);
    }
    if (src.hasDate())
      tgt.setDateElement(DateTime10_30.convertDateTime(src.getDateElement()));
    if (src.hasVaccineCode())
      tgt.setVaccineCode(CodeableConcept10_30.convertCodeableConcept(src.getVaccineCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference10_30.convertReference(src.getPatient()));
    if (src.hasWasNotGivenElement())
      tgt.setNotGivenElement(Boolean10_30.convertBoolean(src.getWasNotGivenElement()));
    tgt.setPrimarySource(!src.getReported());
    if (src.hasPerformer())
      tgt.addPractitioner().setActor(Reference10_30.convertReference(src.getPerformer())).setRole(new org.hl7.fhir.dstu3.model.CodeableConcept().addCoding(new Coding().setSystem("http://hl7.org/fhir/v2/0443").setCode("AP")));
    if (src.hasRequester())
      tgt.addPractitioner().setActor(Reference10_30.convertReference(src.getRequester())).setRole(new org.hl7.fhir.dstu3.model.CodeableConcept().addCoding(new Coding().setSystem("http://hl7.org/fhir/v2/0443").setCode("OP")));
    if (src.hasEncounter())
      tgt.setEncounter(Reference10_30.convertReference(src.getEncounter()));
    if (src.hasManufacturer())
      tgt.setManufacturer(Reference10_30.convertReference(src.getManufacturer()));
    if (src.hasLocation())
      tgt.setLocation(Reference10_30.convertReference(src.getLocation()));
    if (src.hasLotNumberElement())
      tgt.setLotNumberElement(String10_30.convertString(src.getLotNumberElement()));
    if (src.hasExpirationDateElement())
      tgt.setExpirationDateElement(Date10_30.convertDate(src.getExpirationDateElement()));
    if (src.hasSite())
      tgt.setSite(CodeableConcept10_30.convertCodeableConcept(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(CodeableConcept10_30.convertCodeableConcept(src.getRoute()));
    if (src.hasDoseQuantity())
      tgt.setDoseQuantity(SimpleQuantity10_30.convertSimpleQuantity(src.getDoseQuantity()));
    for (org.hl7.fhir.dstu2.model.Annotation t : src.getNote()) tgt.addNote(Annotation10_30.convertAnnotation(t));
    if (src.hasExplanation())
      tgt.setExplanation(convertImmunizationExplanationComponent(src.getExplanation()));
    for (org.hl7.fhir.dstu2.model.Immunization.ImmunizationReactionComponent t : src.getReaction())
      tgt.addReaction(convertImmunizationReactionComponent(t));
    for (org.hl7.fhir.dstu2.model.Immunization.ImmunizationVaccinationProtocolComponent t : src.getVaccinationProtocol())
      tgt.addVaccinationProtocol(convertImmunizationVaccinationProtocolComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Immunization.ImmunizationExplanationComponent convertImmunizationExplanationComponent(org.hl7.fhir.dstu3.model.Immunization.ImmunizationExplanationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Immunization.ImmunizationExplanationComponent tgt = new org.hl7.fhir.dstu2.model.Immunization.ImmunizationExplanationComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept10_30.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonNotGiven())
      tgt.addReasonNotGiven(CodeableConcept10_30.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Immunization.ImmunizationExplanationComponent convertImmunizationExplanationComponent(org.hl7.fhir.dstu2.model.Immunization.ImmunizationExplanationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Immunization.ImmunizationExplanationComponent tgt = new org.hl7.fhir.dstu3.model.Immunization.ImmunizationExplanationComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept10_30.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReasonNotGiven())
      tgt.addReasonNotGiven(CodeableConcept10_30.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Immunization.ImmunizationReactionComponent convertImmunizationReactionComponent(org.hl7.fhir.dstu2.model.Immunization.ImmunizationReactionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Immunization.ImmunizationReactionComponent tgt = new org.hl7.fhir.dstu3.model.Immunization.ImmunizationReactionComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(DateTime10_30.convertDateTime(src.getDateElement()));
    if (src.hasDetail())
      tgt.setDetail(Reference10_30.convertReference(src.getDetail()));
    if (src.hasReportedElement())
      tgt.setReportedElement(Boolean10_30.convertBoolean(src.getReportedElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Immunization.ImmunizationReactionComponent convertImmunizationReactionComponent(org.hl7.fhir.dstu3.model.Immunization.ImmunizationReactionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Immunization.ImmunizationReactionComponent tgt = new org.hl7.fhir.dstu2.model.Immunization.ImmunizationReactionComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(DateTime10_30.convertDateTime(src.getDateElement()));
    if (src.hasDetail())
      tgt.setDetail(Reference10_30.convertReference(src.getDetail()));
    if (src.hasReportedElement())
      tgt.setReportedElement(Boolean10_30.convertBoolean(src.getReportedElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Immunization.ImmunizationVaccinationProtocolComponent convertImmunizationVaccinationProtocolComponent(org.hl7.fhir.dstu3.model.Immunization.ImmunizationVaccinationProtocolComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Immunization.ImmunizationVaccinationProtocolComponent tgt = new org.hl7.fhir.dstu2.model.Immunization.ImmunizationVaccinationProtocolComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasDoseSequenceElement())
      tgt.setDoseSequenceElement(PositiveInt10_30.convertPositiveInt(src.getDoseSequenceElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    if (src.hasAuthority())
      tgt.setAuthority(Reference10_30.convertReference(src.getAuthority()));
    if (src.hasSeriesElement())
      tgt.setSeriesElement(String10_30.convertString(src.getSeriesElement()));
    if (src.hasSeriesDosesElement())
      tgt.setSeriesDosesElement(PositiveInt10_30.convertPositiveInt(src.getSeriesDosesElement()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getTargetDisease())
      tgt.addTargetDisease(CodeableConcept10_30.convertCodeableConcept(t));
    if (src.hasDoseStatus())
      tgt.setDoseStatus(CodeableConcept10_30.convertCodeableConcept(src.getDoseStatus()));
    if (src.hasDoseStatusReason())
      tgt.setDoseStatusReason(CodeableConcept10_30.convertCodeableConcept(src.getDoseStatusReason()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Immunization.ImmunizationVaccinationProtocolComponent convertImmunizationVaccinationProtocolComponent(org.hl7.fhir.dstu2.model.Immunization.ImmunizationVaccinationProtocolComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Immunization.ImmunizationVaccinationProtocolComponent tgt = new org.hl7.fhir.dstu3.model.Immunization.ImmunizationVaccinationProtocolComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasDoseSequenceElement())
      tgt.setDoseSequenceElement(PositiveInt10_30.convertPositiveInt(src.getDoseSequenceElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    if (src.hasAuthority())
      tgt.setAuthority(Reference10_30.convertReference(src.getAuthority()));
    if (src.hasSeriesElement())
      tgt.setSeriesElement(String10_30.convertString(src.getSeriesElement()));
    if (src.hasSeriesDosesElement())
      tgt.setSeriesDosesElement(PositiveInt10_30.convertPositiveInt(src.getSeriesDosesElement()));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getTargetDisease())
      tgt.addTargetDisease(CodeableConcept10_30.convertCodeableConcept(t));
    if (src.hasDoseStatus())
      tgt.setDoseStatus(CodeableConcept10_30.convertCodeableConcept(src.getDoseStatus()));
    if (src.hasDoseStatusReason())
      tgt.setDoseStatusReason(CodeableConcept10_30.convertCodeableConcept(src.getDoseStatusReason()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Reference getPerformer(List<ImmunizationPractitionerComponent> practitioner) {
    for (ImmunizationPractitionerComponent p : practitioner) {
      if (CodeableConcept10_30.hasConcept(p.getRole(), "http://hl7.org/fhir/v2/0443", "AP"))
        return p.getActor();
    }
    return null;
  }

  static public org.hl7.fhir.dstu3.model.Reference getRequester(List<ImmunizationPractitionerComponent> practitioner) {
    for (ImmunizationPractitionerComponent p : practitioner) {
      if (CodeableConcept10_30.hasConcept(p.getRole(), "http://hl7.org/fhir/v2/0443", "OP"))
        return p.getActor();
    }
    return null;
  }
}