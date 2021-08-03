package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.context.ConversionContext10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.*;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Boolean10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Time10_40;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.stream.Collectors;

public class HealthcareService10_40 {

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.HealthcareService.DaysOfWeekEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case MON:
        tgt.setValue(org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek.MON);
        break;
      case TUE:
        tgt.setValue(org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek.TUE);
        break;
      case WED:
        tgt.setValue(org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek.WED);
        break;
      case THU:
        tgt.setValue(org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek.THU);
        break;
      case FRI:
        tgt.setValue(org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek.FRI);
        break;
      case SAT:
        tgt.setValue(org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek.SAT);
        break;
      case SUN:
        tgt.setValue(org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek.SUN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeekEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case MON:
        tgt.setValue(org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek.MON);
        break;
      case TUE:
        tgt.setValue(org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek.TUE);
        break;
      case WED:
        tgt.setValue(org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek.WED);
        break;
      case THU:
        tgt.setValue(org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek.THU);
        break;
      case FRI:
        tgt.setValue(org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek.FRI);
        break;
      case SAT:
        tgt.setValue(org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek.SAT);
        break;
      case SUN:
        tgt.setValue(org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek.SUN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.HealthcareService convertHealthcareService(org.hl7.fhir.dstu2.model.HealthcareService src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.HealthcareService tgt = new org.hl7.fhir.r4.model.HealthcareService();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasProvidedBy())
      tgt.setProvidedBy(Reference10_40.convertReference(src.getProvidedBy()));
    for (org.hl7.fhir.dstu2.model.HealthcareService.ServiceTypeComponent t : src.getServiceType()) {
      for (org.hl7.fhir.dstu2.model.CodeableConcept tj : t.getSpecialty())
        tgt.addSpecialty(CodeableConcept10_40.convertCodeableConcept(tj));
    }
    if (src.hasLocation())
      tgt.addLocation(Reference10_40.convertReference(src.getLocation()));
    if (src.hasCommentElement())
      tgt.setCommentElement(String10_40.convertString(src.getCommentElement()));
    if (src.hasExtraDetails())
      tgt.setExtraDetails(src.getExtraDetails());
    if (src.hasPhoto())
      tgt.setPhoto(Attachment10_40.convertAttachment(src.getPhoto()));
    for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_40.convertContactPoint(t));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getCoverageArea())
      tgt.addCoverageArea(Reference10_40.convertReference(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getServiceProvisionCode())
      tgt.addServiceProvisionCode(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasEligibility())
      tgt.getEligibilityFirstRep().setCode(CodeableConcept10_40.convertCodeableConcept(src.getEligibility()));
    if (src.hasEligibilityNote())
      tgt.getEligibilityFirstRep().setComment(src.getEligibilityNote());
    for (org.hl7.fhir.dstu2.model.StringType t : src.getProgramName()) tgt.addProgram().setText(t.getValue());
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCharacteristic())
      tgt.addCharacteristic(CodeableConcept10_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReferralMethod())
      tgt.addReferralMethod(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasAppointmentRequiredElement())
      tgt.setAppointmentRequiredElement(Boolean10_40.convertBoolean(src.getAppointmentRequiredElement()));
    for (org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime())
      tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
    for (org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable())
      tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
    if (src.hasAvailabilityExceptionsElement())
      tgt.setAvailabilityExceptionsElement(String10_40.convertString(src.getAvailabilityExceptionsElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.HealthcareService convertHealthcareService(org.hl7.fhir.r4.model.HealthcareService src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.HealthcareService tgt = new org.hl7.fhir.dstu2.model.HealthcareService();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasProvidedBy())
      tgt.setProvidedBy(Reference10_40.convertReference(src.getProvidedBy()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialty()) {
      if (!tgt.hasServiceType())
        tgt.addServiceType();
      tgt.getServiceType().get(0).addSpecialty(CodeableConcept10_40.convertCodeableConcept(t));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getLocation()) tgt.setLocation(Reference10_40.convertReference(t));
    if (src.hasCommentElement())
      tgt.setCommentElement(String10_40.convertString(src.getCommentElement()));
    if (src.hasExtraDetails())
      tgt.setExtraDetails(src.getExtraDetails());
    if (src.hasPhoto())
      tgt.setPhoto(Attachment10_40.convertAttachment(src.getPhoto()));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_40.convertContactPoint(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getCoverageArea())
      tgt.addCoverageArea(Reference10_40.convertReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getServiceProvisionCode())
      tgt.addServiceProvisionCode(CodeableConcept10_40.convertCodeableConcept(t));
    tgt.setEligibility(CodeableConcept10_40.convertCodeableConcept(src.getEligibilityFirstRep().getCode()));
    if (src.hasCommentElement())
      tgt.setEligibilityNoteElement(String10_40.convertString(src.getCommentElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProgram())
      if (t.hasText())
        tgt.addProgramName(t.getText());
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCharacteristic())
      tgt.addCharacteristic(CodeableConcept10_40.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReferralMethod())
      tgt.addReferralMethod(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasAppointmentRequiredElement())
      tgt.setAppointmentRequiredElement(Boolean10_40.convertBoolean(src.getAppointmentRequiredElement()));
    for (org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime())
      tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
    for (org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable())
      tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
    if (src.hasAvailabilityExceptionsElement())
      tgt.setAvailabilityExceptionsElement(String10_40.convertString(src.getAvailabilityExceptionsElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
      .map(HealthcareService10_40::convertDaysOfWeek)
      .collect(Collectors.toList()));
    if (src.hasAllDayElement())
      tgt.setAllDayElement(Boolean10_40.convertBoolean(src.getAllDayElement()));
    if (src.hasAvailableStartTimeElement())
      tgt.setAvailableStartTimeElement(Time10_40.convertTime(src.getAvailableStartTimeElement()));
    if (src.hasAvailableEndTimeElement())
      tgt.setAvailableEndTimeElement(Time10_40.convertTime(src.getAvailableEndTimeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
      .map(HealthcareService10_40::convertDaysOfWeek)
      .collect(Collectors.toList()));
    if (src.hasAllDayElement())
      tgt.setAllDayElement(Boolean10_40.convertBoolean(src.getAllDayElement()));
    if (src.hasAvailableStartTimeElement())
      tgt.setAvailableStartTimeElement(Time10_40.convertTime(src.getAvailableStartTimeElement()));
    if (src.hasAvailableEndTimeElement())
      tgt.setAvailableEndTimeElement(Time10_40.convertTime(src.getAvailableEndTimeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_40.convertString(src.getDescriptionElement()));
    if (src.hasDuring())
      tgt.setDuring(Period10_40.convertPeriod(src.getDuring()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_40.convertString(src.getDescriptionElement()));
    if (src.hasDuring())
      tgt.setDuring(Period10_40.convertPeriod(src.getDuring()));
    return tgt;
  }
}