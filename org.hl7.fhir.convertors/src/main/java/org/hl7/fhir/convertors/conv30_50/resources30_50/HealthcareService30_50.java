package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Attachment30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.ContactPoint30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Boolean30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.ExtendedContactDetail;
import org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceEligibilityComponent;

public class HealthcareService30_50 {

  public static org.hl7.fhir.r5.model.HealthcareService convertHealthcareService(org.hl7.fhir.dstu3.model.HealthcareService src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.HealthcareService tgt = new org.hl7.fhir.r5.model.HealthcareService();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean30_50.convertBoolean(src.getActiveElement()));
    if (src.hasProvidedBy())
      tgt.setProvidedBy(Reference30_50.convertReference(src.getProvidedBy()));
    if (src.hasCategory())
      tgt.addCategory(CodeableConcept30_50.convertCodeableConcept(src.getCategory()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSpecialty())
      tgt.addSpecialty(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getLocation()) tgt.addLocation(Reference30_50.convertReference(t));
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasComment())
      tgt.setCommentElement(String30_50.convertStringToMarkdown(src.getCommentElement()));
    if (src.hasExtraDetails())
      tgt.setExtraDetails(src.getExtraDetails());
    if (src.hasPhoto())
      tgt.setPhoto(Attachment30_50.convertAttachment(src.getPhoto()));
    for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom())
      tgt.getContactFirstRep().addTelecom(ContactPoint30_50.convertContactPoint(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getCoverageArea())
      tgt.addCoverageArea(Reference30_50.convertReference(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getServiceProvisionCode())
      tgt.addServiceProvisionCode(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasEligibility() || src.hasEligibilityNote()) {
      HealthcareServiceEligibilityComponent t = tgt.addEligibility();
      t.setCode(CodeableConcept30_50.convertCodeableConcept(src.getEligibility()));
      if (src.hasEligibilityNote())
        t.setComment(src.getEligibilityNote());
    }
    for (org.hl7.fhir.dstu3.model.StringType t : src.getProgramName()) tgt.addProgram().setText(t.getValue());
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCharacteristic())
      tgt.addCharacteristic(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReferralMethod())
      tgt.addReferralMethod(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasAppointmentRequired())
      tgt.setAppointmentRequiredElement(Boolean30_50.convertBoolean(src.getAppointmentRequiredElement()));
//    for (org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime())
//      tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
//    for (org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable())
//      tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
//    if (src.hasAvailabilityExceptions())
//      tgt.setAvailabilityExceptionsElement(String30_50.convertString(src.getAvailabilityExceptionsElement()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference30_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.HealthcareService convertHealthcareService(org.hl7.fhir.r5.model.HealthcareService src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.HealthcareService tgt = new org.hl7.fhir.dstu3.model.HealthcareService();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean30_50.convertBoolean(src.getActiveElement()));
    if (src.hasProvidedBy())
      tgt.setProvidedBy(Reference30_50.convertReference(src.getProvidedBy()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept30_50.convertCodeableConcept(src.getCategoryFirstRep()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialty())
      tgt.addSpecialty(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getLocation()) tgt.addLocation(Reference30_50.convertReference(t));
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasComment())
      tgt.setCommentElement(String30_50.convertString(src.getCommentElement()));
    if (src.hasExtraDetails())
      tgt.setExtraDetails(src.getExtraDetails());
    if (src.hasPhoto())
      tgt.setPhoto(Attachment30_50.convertAttachment(src.getPhoto()));
    for (ExtendedContactDetail t1 : src.getContact())
      for (org.hl7.fhir.r5.model.ContactPoint t : t1.getTelecom())
        tgt.addTelecom(ContactPoint30_50.convertContactPoint(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getCoverageArea())
      tgt.addCoverageArea(Reference30_50.convertReference(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getServiceProvisionCode())
      tgt.addServiceProvisionCode(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasEligibility()) {
      tgt.setEligibility(CodeableConcept30_50.convertCodeableConcept(src.getEligibilityFirstRep().getCode()));
      if (src.getEligibilityFirstRep().hasComment())
        tgt.setEligibilityNoteElement(String30_50.convertString(src.getCommentElement()));
    }
    for (CodeableConcept t : src.getProgram()) tgt.addProgramName(t.getText());
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCharacteristic())
      tgt.addCharacteristic(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReferralMethod())
      tgt.addReferralMethod(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasAppointmentRequired())
      tgt.setAppointmentRequiredElement(Boolean30_50.convertBoolean(src.getAppointmentRequiredElement()));
//    for (org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime())
//      tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
//    for (org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable())
//      tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
//    if (src.hasAvailabilityExceptions())
//      tgt.setAvailabilityExceptionsElement(String30_50.convertString(src.getAvailabilityExceptionsElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference30_50.convertReference(t));
    return tgt;
  }

//  public static org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
//    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
//    tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
//      .map(HealthcareService30_50::convertDaysOfWeek)
//      .collect(Collectors.toList()));
//    if (src.hasAllDay())
//      tgt.setAllDayElement(Boolean30_50.convertBoolean(src.getAllDayElement()));
//    if (src.hasAvailableStartTime())
//      tgt.setAvailableStartTimeElement(Time30_50.convertTime(src.getAvailableStartTimeElement()));
//    if (src.hasAvailableEndTime())
//      tgt.setAvailableEndTimeElement(Time30_50.convertTime(src.getAvailableEndTimeElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
//    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
//    tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
//      .map(HealthcareService30_50::convertDaysOfWeek)
//      .collect(Collectors.toList()));
//    if (src.hasAllDay())
//      tgt.setAllDayElement(Boolean30_50.convertBoolean(src.getAllDayElement()));
//    if (src.hasAvailableStartTime())
//      tgt.setAvailableStartTimeElement(Time30_50.convertTime(src.getAvailableStartTimeElement()));
//    if (src.hasAvailableEndTime())
//      tgt.setAvailableEndTimeElement(Time30_50.convertTime(src.getAvailableEndTimeElement()));
//    return tgt;
//  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeek> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeekEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeek> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.DaysOfWeekEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case MON:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.MON);
        break;
      case TUE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.TUE);
        break;
      case WED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.WED);
        break;
      case THU:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.THU);
        break;
      case FRI:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.FRI);
        break;
      case SAT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.SAT);
        break;
      case SUN:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.SUN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.NULL);
        break;
    }
    return tgt;
  }
//
//  public static org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent();
//    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
//    if (src.hasDuring())
//      tgt.setDuring(Period30_50.convertPeriod(src.getDuring()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent();
//    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
//    if (src.hasDuring())
//      tgt.setDuring(Period30_50.convertPeriod(src.getDuring()));
//    return tgt;
//  }
}