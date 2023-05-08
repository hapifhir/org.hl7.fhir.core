package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Annotation30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.SimpleQuantity30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Boolean30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Date30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.DateTime30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Immunization;



public class Immunization30_40 {

  public static final String NOT_GIVEN_EXTENSION_URL = "http://hl7.org/fhir/3.0/StructureDefinition/extension-Immunization.notGiven";

  private static final String[] IGNORED_EXTENSION_URLS = new String[]{
    NOT_GIVEN_EXTENSION_URL
  };

  public static org.hl7.fhir.r4.model.Immunization convertImmunization(org.hl7.fhir.dstu3.model.Immunization src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Immunization tgt = new org.hl7.fhir.r4.model.Immunization();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertImmunizationStatus(src.getStatusElement()));
    if (src.hasNotGiven()) {
      if (src.getNotGiven()) {
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Immunization.ImmunizationStatus> notDoneElement = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Immunization.ImmunizationStatusEnumFactory());
        notDoneElement.setValue(Immunization.ImmunizationStatus.NOTDONE);
        tgt.setStatusElement(notDoneElement);
      }
      tgt.addExtension(getExtensionForNotGiven(src.getNotGiven()));
    }
    if (src.hasVaccineCode())
      tgt.setVaccineCode(CodeableConcept30_40.convertCodeableConcept(src.getVaccineCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference30_40.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference30_40.convertReference(src.getEncounter()));
    if (src.hasDateElement())
      tgt.setOccurrence(DateTime30_40.convertDateTime(src.getDateElement()));
    if (src.hasPrimarySource())
      tgt.setPrimarySourceElement(Boolean30_40.convertBoolean(src.getPrimarySourceElement()));
    if (src.hasReportOrigin())
      tgt.setReportOrigin(CodeableConcept30_40.convertCodeableConcept(src.getReportOrigin()));
    if (src.hasLocation())
      tgt.setLocation(Reference30_40.convertReference(src.getLocation()));
    if (src.hasManufacturer())
      tgt.setManufacturer(Reference30_40.convertReference(src.getManufacturer()));
    if (src.hasLotNumber())
      tgt.setLotNumberElement(String30_40.convertString(src.getLotNumberElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(Date30_40.convertDate(src.getExpirationDateElement()));
    if (src.hasSite())
      tgt.setSite(CodeableConcept30_40.convertCodeableConcept(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(CodeableConcept30_40.convertCodeableConcept(src.getRoute()));
    if (src.hasDoseQuantity())
      tgt.setDoseQuantity(SimpleQuantity30_40.convertSimpleQuantity(src.getDoseQuantity()));
    for (org.hl7.fhir.dstu3.model.Immunization.ImmunizationPractitionerComponent t : src.getPractitioner())
      tgt.addPerformer(convertImmunizationPractitionerComponent(t));
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_40.convertAnnotation(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getExplanation().getReason())
      tgt.addReasonCode(CodeableConcept30_40.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Extension getExtensionForNotGiven(boolean notGiven) {
    org.hl7.fhir.r4.model.Extension extension = new  org.hl7.fhir.r4.model.Extension();
    extension.setUrl(NOT_GIVEN_EXTENSION_URL);
    extension.setValue(new org.hl7.fhir.r4.model.BooleanType(notGiven));
    return extension;
  }

  public static org.hl7.fhir.dstu3.model.Immunization convertImmunization(org.hl7.fhir.r4.model.Immunization src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Immunization tgt = new org.hl7.fhir.dstu3.model.Immunization();

    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt, IGNORED_EXTENSION_URLS);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasStatus()) {
      tgt.setStatusElement(convertImmunizationStatus(src.getStatusElement()));
       if (src.getStatusElement().getValue() == Immunization.ImmunizationStatus.NOTDONE)
         tgt.setNotGivenElement(new org.hl7.fhir.dstu3.model.BooleanType(true));
       else
         tgt.setNotGivenElement(new org.hl7.fhir.dstu3.model.BooleanType(false));
    }
    if (src.hasExtension(NOT_GIVEN_EXTENSION_URL)) {
      Extension notGivenExtension = src.getExtensionByUrl(NOT_GIVEN_EXTENSION_URL);
      if (notGivenExtension.hasValue() && notGivenExtension.getValueAsPrimitive() instanceof org.hl7.fhir.r4.model.BooleanType)
        tgt.setNotGivenElement(new org.hl7.fhir.dstu3.model.BooleanType(((org.hl7.fhir.r4.model.BooleanType)notGivenExtension.getValueAsPrimitive()).getValue()));
    }
    if (src.hasVaccineCode())
      tgt.setVaccineCode(CodeableConcept30_40.convertCodeableConcept(src.getVaccineCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference30_40.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference30_40.convertReference(src.getEncounter()));
    if (src.hasOccurrenceDateTimeType())
      tgt.setDateElement(DateTime30_40.convertDateTime(src.getOccurrenceDateTimeType()));
    if (src.hasPrimarySource())
      tgt.setPrimarySourceElement(Boolean30_40.convertBoolean(src.getPrimarySourceElement()));
    if (src.hasReportOrigin())
      tgt.setReportOrigin(CodeableConcept30_40.convertCodeableConcept(src.getReportOrigin()));
    if (src.hasLocation())
      tgt.setLocation(Reference30_40.convertReference(src.getLocation()));
    if (src.hasManufacturer())
      tgt.setManufacturer(Reference30_40.convertReference(src.getManufacturer()));
    if (src.hasLotNumber())
      tgt.setLotNumberElement(String30_40.convertString(src.getLotNumberElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(Date30_40.convertDate(src.getExpirationDateElement()));
    if (src.hasSite())
      tgt.setSite(CodeableConcept30_40.convertCodeableConcept(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(CodeableConcept30_40.convertCodeableConcept(src.getRoute()));
    if (src.hasDoseQuantity())
      tgt.setDoseQuantity(SimpleQuantity30_40.convertSimpleQuantity(src.getDoseQuantity()));
    for (org.hl7.fhir.r4.model.Immunization.ImmunizationPerformerComponent t : src.getPerformer())
      tgt.addPractitioner(convertImmunizationPractitionerComponent(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_40.convertAnnotation(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.getExplanation().addReason(CodeableConcept30_40.convertCodeableConcept(t));


    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Immunization.ImmunizationPractitionerComponent convertImmunizationPractitionerComponent(org.hl7.fhir.r4.model.Immunization.ImmunizationPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Immunization.ImmunizationPractitionerComponent tgt = new org.hl7.fhir.dstu3.model.Immunization.ImmunizationPractitionerComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasFunction())
      tgt.setRole(CodeableConcept30_40.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference30_40.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Immunization.ImmunizationPerformerComponent convertImmunizationPractitionerComponent(org.hl7.fhir.dstu3.model.Immunization.ImmunizationPractitionerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Immunization.ImmunizationPerformerComponent tgt = new org.hl7.fhir.r4.model.Immunization.ImmunizationPerformerComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasRole())
      tgt.setFunction(CodeableConcept30_40.convertCodeableConcept(src.getRole()));
    if (src.hasActor())
      tgt.setActor(Reference30_40.convertReference(src.getActor()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Immunization.ImmunizationStatus> convertImmunizationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Immunization.ImmunizationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Immunization.ImmunizationStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Immunization.ImmunizationStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case COMPLETED:
      case NOTDONE:
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Immunization.ImmunizationStatus> convertImmunizationStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Immunization.ImmunizationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Immunization.ImmunizationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Immunization.ImmunizationStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4.model.Immunization.ImmunizationStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.Immunization.ImmunizationStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Immunization.ImmunizationStatus.NULL);
        break;
    }
    return tgt;
  }
}