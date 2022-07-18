package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Annotation30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.SimpleQuantity30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Boolean30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Date30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.DateTime30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.codesystems.CoverageeligibilityresponseExAuthSupportEnumFactory;
import org.hl7.fhir.r5.model.CodeableReference;

public class Immunization30_50 {

  public static org.hl7.fhir.r5.model.Immunization convertImmunization(org.hl7.fhir.dstu3.model.Immunization src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Immunization tgt = new org.hl7.fhir.r5.model.Immunization();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertImmunizationStatus(src.getStatusElement()));
    if (src.hasVaccineCode())
      tgt.setVaccineCode(CodeableConcept30_50.convertCodeableConcept(src.getVaccineCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference30_50.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference30_50.convertReference(src.getEncounter()));
    if (src.hasDate())
      tgt.setOccurrence(DateTime30_50.convertDateTime(src.getDateElement()));
    if (src.hasPrimarySource())
      tgt.setPrimarySourceElement(Boolean30_50.convertBoolean(src.getPrimarySourceElement()));
    if (src.hasReportOrigin())
      tgt.setInformationSource(new CodeableReference(CodeableConcept30_50.convertCodeableConcept(src.getReportOrigin())));
    if (src.hasLocation())
      tgt.setLocation(Reference30_50.convertReference(src.getLocation()));
    if (src.hasManufacturer())
      tgt.setManufacturer(Reference30_50.convertReference(src.getManufacturer()));
    if (src.hasLotNumber())
      tgt.setLotNumberElement(String30_50.convertString(src.getLotNumberElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(Date30_50.convertDate(src.getExpirationDateElement()));
    if (src.hasSite())
      tgt.setSite(CodeableConcept30_50.convertCodeableConcept(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(CodeableConcept30_50.convertCodeableConcept(src.getRoute()));
    if (src.hasDoseQuantity())
      tgt.setDoseQuantity(SimpleQuantity30_50.convertSimpleQuantity(src.getDoseQuantity()));
    for (org.hl7.fhir.dstu3.model.Immunization.ImmunizationPractitionerComponent t : src.getPractitioner())
      tgt.addPerformer(convertImmunizationPractitionerComponent(t));
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_50.convertAnnotation(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getExplanation().getReason())
      tgt.addReason(Reference30_50.convertCodeableConceptToCodableReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Immunization convertImmunization(org.hl7.fhir.r5.model.Immunization src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Immunization tgt = new org.hl7.fhir.dstu3.model.Immunization();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertImmunizationStatus(src.getStatusElement()));
    if (src.hasVaccineCode())
      tgt.setVaccineCode(CodeableConcept30_50.convertCodeableConcept(src.getVaccineCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference30_50.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference30_50.convertReference(src.getEncounter()));
    if (src.hasOccurrenceDateTimeType())
      tgt.setDateElement(DateTime30_50.convertDateTime(src.getOccurrenceDateTimeType()));
    if (src.hasPrimarySource())
      tgt.setPrimarySourceElement(Boolean30_50.convertBoolean(src.getPrimarySourceElement()));
    if (src.getInformationSource().hasConcept())
      tgt.setReportOrigin(CodeableConcept30_50.convertCodeableConcept(src.getInformationSource().getConcept()));
    if (src.hasLocation())
      tgt.setLocation(Reference30_50.convertReference(src.getLocation()));
    if (src.hasManufacturer())
      tgt.setManufacturer(Reference30_50.convertReference(src.getManufacturer()));
    if (src.hasLotNumber())
      tgt.setLotNumberElement(String30_50.convertString(src.getLotNumberElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(Date30_50.convertDate(src.getExpirationDateElement()));
    if (src.hasSite())
      tgt.setSite(CodeableConcept30_50.convertCodeableConcept(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(CodeableConcept30_50.convertCodeableConcept(src.getRoute()));
    if (src.hasDoseQuantity())
      tgt.setDoseQuantity(SimpleQuantity30_50.convertSimpleQuantity(src.getDoseQuantity()));
    for (org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent t : src.getPerformer())
      tgt.addPractitioner(convertImmunizationPractitionerComponent(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_50.convertAnnotation(t));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.getExplanation().addReason(CodeableConcept30_50.convertCodeableConcept(t.getConcept()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Immunization.ImmunizationPractitionerComponent convertImmunizationPractitionerComponent(org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Immunization.ImmunizationPractitionerComponent tgt = new org.hl7.fhir.dstu3.model.Immunization.ImmunizationPractitionerComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasFunction())
      tgt.setRole(CodeableConcept30_50.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference30_50.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent convertImmunizationPractitionerComponent(org.hl7.fhir.dstu3.model.Immunization.ImmunizationPractitionerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent tgt = new org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasRole())
      tgt.setFunction(CodeableConcept30_50.convertCodeableConcept(src.getRole()));
    if (src.hasActor())
      tgt.setActor(Reference30_50.convertReference(src.getActor()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Immunization.ImmunizationStatus> convertImmunizationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Immunization.ImmunizationStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Immunization.ImmunizationStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Immunization.ImmunizationStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Immunization.ImmunizationStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.Immunization.ImmunizationStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Immunization.ImmunizationStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Immunization.ImmunizationStatusCodes> convertImmunizationStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Immunization.ImmunizationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Immunization.ImmunizationStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Immunization.ImmunizationStatusCodesEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.Immunization.ImmunizationStatusCodes.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Immunization.ImmunizationStatusCodes.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Immunization.ImmunizationStatusCodes.NULL);
        break;
    }
    return tgt;
  }
}