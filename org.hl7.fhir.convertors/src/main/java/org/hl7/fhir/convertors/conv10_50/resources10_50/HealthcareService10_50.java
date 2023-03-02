package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Attachment10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.ContactPoint10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Identifier10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Boolean10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.ExtendedContactDetail;

public class HealthcareService10_50 {

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeekEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.DaysOfWeekEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
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

  public static org.hl7.fhir.dstu2.model.HealthcareService convertHealthcareService(org.hl7.fhir.r5.model.HealthcareService src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.HealthcareService tgt = new org.hl7.fhir.dstu2.model.HealthcareService();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasProvidedBy())
      tgt.setProvidedBy(Reference10_50.convertReference(src.getProvidedBy()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialty()) {
      if (!tgt.hasServiceType())
        tgt.addServiceType();
      tgt.getServiceType().get(0).addSpecialty(CodeableConcept10_50.convertCodeableConcept(t));
    }
    for (org.hl7.fhir.r5.model.Reference t : src.getLocation()) tgt.setLocation(Reference10_50.convertReference(t));
    if (src.hasCommentElement())
      tgt.setCommentElement(String10_50.convertString(src.getCommentElement()));
    if (src.hasExtraDetails())
      tgt.setExtraDetails(src.getExtraDetails());
    if (src.hasPhoto())
      tgt.setPhoto(Attachment10_50.convertAttachment(src.getPhoto()));
    for (ExtendedContactDetail t1 : src.getContact())
      for (org.hl7.fhir.r5.model.ContactPoint t : t1.getTelecom())
      tgt.addTelecom(ContactPoint10_50.convertContactPoint(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getCoverageArea())
      tgt.addCoverageArea(Reference10_50.convertReference(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getServiceProvisionCode())
      tgt.addServiceProvisionCode(CodeableConcept10_50.convertCodeableConcept(t));
    tgt.setEligibility(CodeableConcept10_50.convertCodeableConcept(src.getEligibilityFirstRep().getCode()));
    if (src.hasCommentElement())
      tgt.setEligibilityNoteElement(String10_50.convertString(src.getCommentElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getProgram())
      if (t.hasText())
        tgt.addProgramName(t.getText());
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCharacteristic())
      tgt.addCharacteristic(CodeableConcept10_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReferralMethod())
      tgt.addReferralMethod(CodeableConcept10_50.convertCodeableConcept(t));
    if (src.hasAppointmentRequiredElement())
      tgt.setAppointmentRequiredElement(Boolean10_50.convertBoolean(src.getAppointmentRequiredElement()));
//    for (org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime())
//      tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
//    for (org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable())
//      tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
//    if (src.hasAvailabilityExceptionsElement())
//      tgt.setAvailabilityExceptionsElement(String10_50.convertString(src.getAvailabilityExceptionsElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.HealthcareService convertHealthcareService(org.hl7.fhir.dstu2.model.HealthcareService src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.HealthcareService tgt = new org.hl7.fhir.r5.model.HealthcareService();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasProvidedBy())
      tgt.setProvidedBy(Reference10_50.convertReference(src.getProvidedBy()));
    for (org.hl7.fhir.dstu2.model.HealthcareService.ServiceTypeComponent t : src.getServiceType()) {
      for (org.hl7.fhir.dstu2.model.CodeableConcept tj : t.getSpecialty())
        tgt.addSpecialty(CodeableConcept10_50.convertCodeableConcept(tj));
    }
    if (src.hasLocation())
      tgt.addLocation(Reference10_50.convertReference(src.getLocation()));
    if (src.hasCommentElement())
      tgt.setCommentElement(String10_50.convertStringToMarkdown(src.getCommentElement()));
    if (src.hasExtraDetails())
      tgt.setExtraDetails(src.getExtraDetails());
    if (src.hasPhoto())
      tgt.setPhoto(Attachment10_50.convertAttachment(src.getPhoto()));
    for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom())
      tgt.getContactFirstRep().addTelecom(ContactPoint10_50.convertContactPoint(t));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getCoverageArea())
      tgt.addCoverageArea(Reference10_50.convertReference(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getServiceProvisionCode())
      tgt.addServiceProvisionCode(CodeableConcept10_50.convertCodeableConcept(t));
    if (src.hasEligibility())
      tgt.getEligibilityFirstRep().setCode(CodeableConcept10_50.convertCodeableConcept(src.getEligibility()));
    if (src.hasEligibilityNote())
      tgt.getEligibilityFirstRep().setComment(src.getEligibilityNote());
    for (org.hl7.fhir.dstu2.model.StringType t : src.getProgramName()) tgt.addProgram().setText(t.getValue());
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCharacteristic())
      tgt.addCharacteristic(CodeableConcept10_50.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReferralMethod())
      tgt.addReferralMethod(CodeableConcept10_50.convertCodeableConcept(t));
    if (src.hasAppointmentRequiredElement())
      tgt.setAppointmentRequiredElement(Boolean10_50.convertBoolean(src.getAppointmentRequiredElement()));
//    for (org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime())
//      tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
//    for (org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable())
//      tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
//    if (src.hasAvailabilityExceptionsElement())
//      tgt.setAvailabilityExceptionsElement(String10_50.convertString(src.getAvailabilityExceptionsElement()));
    return tgt;
  }

//  public static org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
//    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
//    tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
//      .map(HealthcareService10_50::convertDaysOfWeek)
//      .collect(Collectors.toList()));
//    if (src.hasAllDayElement())
//      tgt.setAllDayElement(Boolean10_50.convertBoolean(src.getAllDayElement()));
//    if (src.hasAvailableStartTimeElement())
//      tgt.setAvailableStartTimeElement(Time10_50.convertTime(src.getAvailableStartTimeElement()));
//    if (src.hasAvailableEndTimeElement())
//      tgt.setAvailableEndTimeElement(Time10_50.convertTime(src.getAvailableEndTimeElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
//    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
//    tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
//      .map(HealthcareService10_50::convertDaysOfWeek)
//      .collect(Collectors.toList()));
//    if (src.hasAllDayElement())
//      tgt.setAllDayElement(Boolean10_50.convertBoolean(src.getAllDayElement()));
//    if (src.hasAvailableStartTimeElement())
//      tgt.setAvailableStartTimeElement(Time10_50.convertTime(src.getAvailableStartTimeElement()));
//    if (src.hasAvailableEndTimeElement())
//      tgt.setAvailableEndTimeElement(Time10_50.convertTime(src.getAvailableEndTimeElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent();
//    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
//    if (src.hasDescriptionElement())
//      tgt.setDescriptionElement(String10_50.convertString(src.getDescriptionElement()));
//    if (src.hasDuring())
//      tgt.setDuring(Period10_50.convertPeriod(src.getDuring()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent();
//    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
//    if (src.hasDescriptionElement())
//      tgt.setDescriptionElement(String10_50.convertString(src.getDescriptionElement()));
//    if (src.hasDuring())
//      tgt.setDuring(Period10_50.convertPeriod(src.getDuring()));
//    return tgt;
//  }
}