package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.conv30_40.VersionConvertor_30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.ContactPoint30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Period30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Boolean30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Time30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.stream.Collectors;

public class PractitionerRole30_40 {

    public static org.hl7.fhir.r4.model.PractitionerRole convertPractitionerRole(org.hl7.fhir.dstu3.model.PractitionerRole src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.PractitionerRole tgt = new org.hl7.fhir.r4.model.PractitionerRole();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(Boolean30_40.convertBoolean(src.getActiveElement()));
        if (src.hasPeriod())
            tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
        if (src.hasPractitioner())
            tgt.setPractitioner(Reference30_40.convertReference(src.getPractitioner()));
        if (src.hasOrganization())
            tgt.setOrganization(Reference30_40.convertReference(src.getOrganization()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCode()) tgt.addCode(CodeableConcept30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(CodeableConcept30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getLocation()) tgt.addLocation(Reference30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getHealthcareService()) tgt.addHealthcareService(Reference30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint30_40.convertContactPoint(t));
        for (org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent t : src.getAvailableTime()) tgt.addAvailableTime(convertPractitionerRoleAvailableTimeComponent(t));
        for (org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleNotAvailableComponent t : src.getNotAvailable()) tgt.addNotAvailable(convertPractitionerRoleNotAvailableComponent(t));
        if (src.hasAvailabilityExceptions())
            tgt.setAvailabilityExceptionsElement(String30_40.convertString(src.getAvailabilityExceptionsElement()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PractitionerRole convertPractitionerRole(org.hl7.fhir.r4.model.PractitionerRole src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PractitionerRole tgt = new org.hl7.fhir.dstu3.model.PractitionerRole();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(Boolean30_40.convertBoolean(src.getActiveElement()));
        if (src.hasPeriod())
            tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
        if (src.hasPractitioner())
            tgt.setPractitioner(Reference30_40.convertReference(src.getPractitioner()));
        if (src.hasOrganization())
            tgt.setOrganization(Reference30_40.convertReference(src.getOrganization()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode()) tgt.addCode(CodeableConcept30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(CodeableConcept30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getLocation()) tgt.addLocation(Reference30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getHealthcareService()) tgt.addHealthcareService(Reference30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint30_40.convertContactPoint(t));
        for (org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleAvailableTimeComponent t : src.getAvailableTime()) tgt.addAvailableTime(convertPractitionerRoleAvailableTimeComponent(t));
        for (org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleNotAvailableComponent t : src.getNotAvailable()) tgt.addNotAvailable(convertPractitionerRoleNotAvailableComponent(t));
        if (src.hasAvailabilityExceptions())
            tgt.setAvailabilityExceptionsElement(String30_40.convertString(src.getAvailabilityExceptionsElement()));
        for (org.hl7.fhir.r4.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent convertPractitionerRoleAvailableTimeComponent(org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleAvailableTimeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent tgt = new org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent();
        Element30_40.copyElement(src, tgt);
        tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
                .map(PractitionerRole30_40::convertDaysOfWeek)
                .collect(Collectors.toList()));
        if (src.hasAllDay())
            tgt.setAllDayElement(Boolean30_40.convertBoolean(src.getAllDayElement()));
        if (src.hasAvailableStartTime())
            tgt.setAvailableStartTimeElement(Time30_40.convertTime(src.getAvailableStartTimeElement()));
        if (src.hasAvailableEndTime())
            tgt.setAvailableEndTimeElement(Time30_40.convertTime(src.getAvailableEndTimeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleAvailableTimeComponent convertPractitionerRoleAvailableTimeComponent(org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleAvailableTimeComponent tgt = new org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleAvailableTimeComponent();
        Element30_40.copyElement(src, tgt);
        tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
                .map(PractitionerRole30_40::convertDaysOfWeek)
                .collect(Collectors.toList()));
        if (src.hasAllDay())
            tgt.setAllDayElement(Boolean30_40.convertBoolean(src.getAllDayElement()));
        if (src.hasAvailableStartTime())
            tgt.setAvailableStartTimeElement(Time30_40.convertTime(src.getAvailableStartTimeElement()));
        if (src.hasAvailableEndTime())
            tgt.setAvailableEndTimeElement(Time30_40.convertTime(src.getAvailableEndTimeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleNotAvailableComponent convertPractitionerRoleNotAvailableComponent(org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleNotAvailableComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleNotAvailableComponent tgt = new org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleNotAvailableComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
        if (src.hasDuring())
            tgt.setDuring(Period30_40.convertPeriod(src.getDuring()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleNotAvailableComponent convertPractitionerRoleNotAvailableComponent(org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleNotAvailableComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleNotAvailableComponent tgt = new org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleNotAvailableComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
        if (src.hasDuring())
            tgt.setDuring(Period30_40.convertPeriod(src.getDuring()));
        return tgt;
    }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeek> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeekEnumFactory());
    Element30_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeek.NULL);
    } else {
      switch (src.getValue()) {
        case MON:
          tgt.setValue(org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeek.MON);
          break;
        case TUE:
          tgt.setValue(org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeek.TUE);
          break;
        case WED:
          tgt.setValue(org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeek.WED);
          break;
        case THU:
          tgt.setValue(org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeek.THU);
          break;
        case FRI:
          tgt.setValue(org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeek.FRI);
          break;
        case SAT:
          tgt.setValue(org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeek.SAT);
          break;
        case SUN:
          tgt.setValue(org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeek.SUN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeek.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeek> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeekEnumFactory());
    Element30_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek.NULL);
    } else {
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
    }
    return tgt;
  }
}