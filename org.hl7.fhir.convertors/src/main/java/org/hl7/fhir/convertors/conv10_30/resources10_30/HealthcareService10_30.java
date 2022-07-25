package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.*;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Boolean10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Time10_30;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.stream.Collectors;

public class HealthcareService10_30 {

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeek> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeekEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeek> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeekEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case MON:
        tgt.setValue(org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeek.MON);
        break;
      case TUE:
        tgt.setValue(org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeek.TUE);
        break;
      case WED:
        tgt.setValue(org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeek.WED);
        break;
      case THU:
        tgt.setValue(org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeek.THU);
        break;
      case FRI:
        tgt.setValue(org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeek.FRI);
        break;
      case SAT:
        tgt.setValue(org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeek.SAT);
        break;
      case SUN:
        tgt.setValue(org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeek.SUN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeek.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.HealthcareService convertHealthcareService(org.hl7.fhir.dstu3.model.HealthcareService src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.HealthcareService tgt = new org.hl7.fhir.dstu2.model.HealthcareService();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasProvidedBy())
      tgt.setProvidedBy(Reference10_30.convertReference(src.getProvidedBy()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSpecialty()) {
      if (!tgt.hasServiceType())
        tgt.addServiceType();
      tgt.getServiceType().get(0).addSpecialty(CodeableConcept10_30.convertCodeableConcept(t));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getLocation()) tgt.setLocation(Reference10_30.convertReference(t));
    if (src.hasCommentElement())
      tgt.setCommentElement(String10_30.convertString(src.getCommentElement()));
    if (src.hasExtraDetailsElement())
      tgt.setExtraDetailsElement(String10_30.convertString(src.getExtraDetailsElement()));
    if (src.hasPhoto())
      tgt.setPhoto(Attachment10_30.convertAttachment(src.getPhoto()));
    for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_30.convertContactPoint(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getCoverageArea())
      tgt.addCoverageArea(Reference10_30.convertReference(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getServiceProvisionCode())
      tgt.addServiceProvisionCode(CodeableConcept10_30.convertCodeableConcept(t));
    if (src.hasEligibility())
      tgt.setEligibility(CodeableConcept10_30.convertCodeableConcept(src.getEligibility()));
    if (src.hasEligibilityNoteElement())
      tgt.setEligibilityNoteElement(String10_30.convertString(src.getEligibilityNoteElement()));
    for (org.hl7.fhir.dstu3.model.StringType t : src.getProgramName()) tgt.addProgramName(t.getValue());
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCharacteristic())
      tgt.addCharacteristic(CodeableConcept10_30.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReferralMethod())
      tgt.addReferralMethod(CodeableConcept10_30.convertCodeableConcept(t));
    if (src.hasAppointmentRequiredElement())
      tgt.setAppointmentRequiredElement(Boolean10_30.convertBoolean(src.getAppointmentRequiredElement()));
    for (org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime())
      tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
    for (org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable())
      tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
    if (src.hasAvailabilityExceptionsElement())
      tgt.setAvailabilityExceptionsElement(String10_30.convertString(src.getAvailabilityExceptionsElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.HealthcareService convertHealthcareService(org.hl7.fhir.dstu2.model.HealthcareService src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.HealthcareService tgt = new org.hl7.fhir.dstu3.model.HealthcareService();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasProvidedBy())
      tgt.setProvidedBy(Reference10_30.convertReference(src.getProvidedBy()));
    for (org.hl7.fhir.dstu2.model.HealthcareService.ServiceTypeComponent t : src.getServiceType()) {
      for (org.hl7.fhir.dstu2.model.CodeableConcept tj : t.getSpecialty())
        tgt.addSpecialty(CodeableConcept10_30.convertCodeableConcept(tj));
    }
    if (src.hasLocation())
      tgt.addLocation(Reference10_30.convertReference(src.getLocation()));
    if (src.hasCommentElement())
      tgt.setCommentElement(String10_30.convertString(src.getCommentElement()));
    if (src.hasExtraDetailsElement())
      tgt.setExtraDetailsElement(String10_30.convertString(src.getExtraDetailsElement()));
    if (src.hasPhoto())
      tgt.setPhoto(Attachment10_30.convertAttachment(src.getPhoto()));
    for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_30.convertContactPoint(t));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getCoverageArea())
      tgt.addCoverageArea(Reference10_30.convertReference(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getServiceProvisionCode())
      tgt.addServiceProvisionCode(CodeableConcept10_30.convertCodeableConcept(t));
    if (src.hasEligibility())
      tgt.setEligibility(CodeableConcept10_30.convertCodeableConcept(src.getEligibility()));
    if (src.hasEligibilityNoteElement())
      tgt.setEligibilityNoteElement(String10_30.convertString(src.getEligibilityNoteElement()));
    for (org.hl7.fhir.dstu2.model.StringType t : src.getProgramName()) tgt.addProgramName(t.getValue());
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCharacteristic())
      tgt.addCharacteristic(CodeableConcept10_30.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReferralMethod())
      tgt.addReferralMethod(CodeableConcept10_30.convertCodeableConcept(t));
    if (src.hasAppointmentRequiredElement())
      tgt.setAppointmentRequiredElement(Boolean10_30.convertBoolean(src.getAppointmentRequiredElement()));
    for (org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime())
      tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
    for (org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable())
      tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
    if (src.hasAvailabilityExceptionsElement())
      tgt.setAvailabilityExceptionsElement(String10_30.convertString(src.getAvailabilityExceptionsElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyBackboneElement(src,tgt);
    tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
      .map(HealthcareService10_30::convertDaysOfWeek)
      .collect(Collectors.toList()));
    if (src.hasAllDayElement())
      tgt.setAllDayElement(Boolean10_30.convertBoolean(src.getAllDayElement()));
    if (src.hasAvailableStartTimeElement())
      tgt.setAvailableStartTimeElement(Time10_30.convertTime(src.getAvailableStartTimeElement()));
    if (src.hasAvailableEndTimeElement())
      tgt.setAvailableEndTimeElement(Time10_30.convertTime(src.getAvailableEndTimeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyBackboneElement(src,tgt);
    tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
      .map(HealthcareService10_30::convertDaysOfWeek)
      .collect(Collectors.toList()));
    if (src.hasAllDayElement())
      tgt.setAllDayElement(Boolean10_30.convertBoolean(src.getAllDayElement()));
    if (src.hasAvailableStartTimeElement())
      tgt.setAvailableStartTimeElement(Time10_30.convertTime(src.getAvailableStartTimeElement()));
    if (src.hasAvailableEndTimeElement())
      tgt.setAvailableEndTimeElement(Time10_30.convertTime(src.getAvailableEndTimeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyBackboneElement(src,tgt);
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    if (src.hasDuring())
      tgt.setDuring(Period10_30.convertPeriod(src.getDuring()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyBackboneElement(src,tgt);
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    if (src.hasDuring())
      tgt.setDuring(Period10_30.convertPeriod(src.getDuring()));
    return tgt;
  }
}