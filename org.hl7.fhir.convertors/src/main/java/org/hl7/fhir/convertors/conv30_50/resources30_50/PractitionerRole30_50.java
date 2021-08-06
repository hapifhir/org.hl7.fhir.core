package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.ContactPoint30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Period30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Boolean30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Time30_50;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.stream.Collectors;

public class PractitionerRole30_50 {

  public static org.hl7.fhir.dstu3.model.PractitionerRole convertPractitionerRole(org.hl7.fhir.r5.model.PractitionerRole src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.PractitionerRole tgt = new org.hl7.fhir.dstu3.model.PractitionerRole();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean30_50.convertBoolean(src.getActiveElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
    if (src.hasPractitioner())
      tgt.setPractitioner(Reference30_50.convertReference(src.getPractitioner()));
    if (src.hasOrganization())
      tgt.setOrganization(Reference30_50.convertReference(src.getOrganization()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialty())
      tgt.addSpecialty(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getLocation()) tgt.addLocation(Reference30_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getHealthcareService())
      tgt.addHealthcareService(Reference30_50.convertReference(t));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint30_50.convertContactPoint(t));
    for (org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent t : src.getAvailableTime())
      tgt.addAvailableTime(convertPractitionerRoleAvailableTimeComponent(t));
    for (org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleNotAvailableComponent t : src.getNotAvailable())
      tgt.addNotAvailable(convertPractitionerRoleNotAvailableComponent(t));
    if (src.hasAvailabilityExceptions())
      tgt.setAvailabilityExceptionsElement(String30_50.convertString(src.getAvailabilityExceptionsElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference30_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.PractitionerRole convertPractitionerRole(org.hl7.fhir.dstu3.model.PractitionerRole src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.PractitionerRole tgt = new org.hl7.fhir.r5.model.PractitionerRole();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean30_50.convertBoolean(src.getActiveElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
    if (src.hasPractitioner())
      tgt.setPractitioner(Reference30_50.convertReference(src.getPractitioner()));
    if (src.hasOrganization())
      tgt.setOrganization(Reference30_50.convertReference(src.getOrganization()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSpecialty())
      tgt.addSpecialty(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getLocation()) tgt.addLocation(Reference30_50.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getHealthcareService())
      tgt.addHealthcareService(Reference30_50.convertReference(t));
    for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint30_50.convertContactPoint(t));
    for (org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent t : src.getAvailableTime())
      tgt.addAvailableTime(convertPractitionerRoleAvailableTimeComponent(t));
    for (org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleNotAvailableComponent t : src.getNotAvailable())
      tgt.addNotAvailable(convertPractitionerRoleNotAvailableComponent(t));
    if (src.hasAvailabilityExceptions())
      tgt.setAvailabilityExceptionsElement(String30_50.convertString(src.getAvailabilityExceptionsElement()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference30_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent convertPractitionerRoleAvailableTimeComponent(org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent tgt = new org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
      .map(PractitionerRole30_50::convertDaysOfWeek)
      .collect(Collectors.toList()));
    if (src.hasAllDay())
      tgt.setAllDayElement(Boolean30_50.convertBoolean(src.getAllDayElement()));
    if (src.hasAvailableStartTime())
      tgt.setAvailableStartTimeElement(Time30_50.convertTime(src.getAvailableStartTimeElement()));
    if (src.hasAvailableEndTime())
      tgt.setAvailableEndTimeElement(Time30_50.convertTime(src.getAvailableEndTimeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent convertPractitionerRoleAvailableTimeComponent(org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent tgt = new org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
      .map(PractitionerRole30_50::convertDaysOfWeek)
      .collect(Collectors.toList()));
    if (src.hasAllDay())
      tgt.setAllDayElement(Boolean30_50.convertBoolean(src.getAllDayElement()));
    if (src.hasAvailableStartTime())
      tgt.setAvailableStartTimeElement(Time30_50.convertTime(src.getAvailableStartTimeElement()));
    if (src.hasAvailableEndTime())
      tgt.setAvailableEndTimeElement(Time30_50.convertTime(src.getAvailableEndTimeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleNotAvailableComponent convertPractitionerRoleNotAvailableComponent(org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleNotAvailableComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleNotAvailableComponent tgt = new org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleNotAvailableComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    if (src.hasDuring())
      tgt.setDuring(Period30_50.convertPeriod(src.getDuring()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleNotAvailableComponent convertPractitionerRoleNotAvailableComponent(org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleNotAvailableComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleNotAvailableComponent tgt = new org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleNotAvailableComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    if (src.hasDuring())
      tgt.setDuring(Period30_50.convertPeriod(src.getDuring()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeekEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case MON:
        tgt.setValue(org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek.MON);
        break;
      case TUE:
        tgt.setValue(org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek.TUE);
        break;
      case WED:
        tgt.setValue(org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek.WED);
        break;
      case THU:
        tgt.setValue(org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek.THU);
        break;
      case FRI:
        tgt.setValue(org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek.FRI);
        break;
      case SAT:
        tgt.setValue(org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek.SAT);
        break;
      case SUN:
        tgt.setValue(org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek.SUN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.DaysOfWeekEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.NULL);
    } else {
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
    }
    return tgt;
  }
}