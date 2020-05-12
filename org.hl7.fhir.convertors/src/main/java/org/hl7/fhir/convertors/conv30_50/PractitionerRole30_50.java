package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.stream.Collectors;

public class PractitionerRole30_50 {

    public static org.hl7.fhir.dstu3.model.PractitionerRole convertPractitionerRole(org.hl7.fhir.r5.model.PractitionerRole src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PractitionerRole tgt = new org.hl7.fhir.dstu3.model.PractitionerRole();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(VersionConvertor_30_50.convertBoolean(src.getActiveElement()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_50.convertPeriod(src.getPeriod()));
        if (src.hasPractitioner())
            tgt.setPractitioner(VersionConvertor_30_50.convertReference(src.getPractitioner()));
        if (src.hasOrganization())
            tgt.setOrganization(VersionConvertor_30_50.convertReference(src.getOrganization()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode()) tgt.addCode(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getLocation()) tgt.addLocation(VersionConvertor_30_50.convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getHealthcareService()) tgt.addHealthcareService(VersionConvertor_30_50.convertReference(t));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_50.convertContactPoint(t));
        for (org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent t : src.getAvailableTime()) tgt.addAvailableTime(convertPractitionerRoleAvailableTimeComponent(t));
        for (org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleNotAvailableComponent t : src.getNotAvailable()) tgt.addNotAvailable(convertPractitionerRoleNotAvailableComponent(t));
        if (src.hasAvailabilityExceptions())
            tgt.setAvailabilityExceptionsElement(VersionConvertor_30_50.convertString(src.getAvailabilityExceptionsElement()));
        for (org.hl7.fhir.r5.model.Reference t : src.getEndpoint()) tgt.addEndpoint(VersionConvertor_30_50.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.PractitionerRole convertPractitionerRole(org.hl7.fhir.dstu3.model.PractitionerRole src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.PractitionerRole tgt = new org.hl7.fhir.r5.model.PractitionerRole();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(VersionConvertor_30_50.convertBoolean(src.getActiveElement()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_50.convertPeriod(src.getPeriod()));
        if (src.hasPractitioner())
            tgt.setPractitioner(VersionConvertor_30_50.convertReference(src.getPractitioner()));
        if (src.hasOrganization())
            tgt.setOrganization(VersionConvertor_30_50.convertReference(src.getOrganization()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCode()) tgt.addCode(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getLocation()) tgt.addLocation(VersionConvertor_30_50.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getHealthcareService()) tgt.addHealthcareService(VersionConvertor_30_50.convertReference(t));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_50.convertContactPoint(t));
        for (org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent t : src.getAvailableTime()) tgt.addAvailableTime(convertPractitionerRoleAvailableTimeComponent(t));
        for (org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleNotAvailableComponent t : src.getNotAvailable()) tgt.addNotAvailable(convertPractitionerRoleNotAvailableComponent(t));
        if (src.hasAvailabilityExceptions())
            tgt.setAvailabilityExceptionsElement(VersionConvertor_30_50.convertString(src.getAvailabilityExceptionsElement()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getEndpoint()) tgt.addEndpoint(VersionConvertor_30_50.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent convertPractitionerRoleAvailableTimeComponent(org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent tgt = new org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
                .map(PractitionerRole30_50::convertDaysOfWeek)
                .collect(Collectors.toList()));
        if (src.hasAllDay())
            tgt.setAllDayElement(VersionConvertor_30_50.convertBoolean(src.getAllDayElement()));
        if (src.hasAvailableStartTime())
            tgt.setAvailableStartTimeElement(VersionConvertor_30_50.convertTime(src.getAvailableStartTimeElement()));
        if (src.hasAvailableEndTime())
            tgt.setAvailableEndTimeElement(VersionConvertor_30_50.convertTime(src.getAvailableEndTimeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent convertPractitionerRoleAvailableTimeComponent(org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent tgt = new org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
                .map(PractitionerRole30_50::convertDaysOfWeek)
                .collect(Collectors.toList()));
        if (src.hasAllDay())
            tgt.setAllDayElement(VersionConvertor_30_50.convertBoolean(src.getAllDayElement()));
        if (src.hasAvailableStartTime())
            tgt.setAvailableStartTimeElement(VersionConvertor_30_50.convertTime(src.getAvailableStartTimeElement()));
        if (src.hasAvailableEndTime())
            tgt.setAvailableEndTimeElement(VersionConvertor_30_50.convertTime(src.getAvailableEndTimeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleNotAvailableComponent convertPractitionerRoleNotAvailableComponent(org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleNotAvailableComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleNotAvailableComponent tgt = new org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleNotAvailableComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        if (src.hasDuring())
            tgt.setDuring(VersionConvertor_30_50.convertPeriod(src.getDuring()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleNotAvailableComponent convertPractitionerRoleNotAvailableComponent(org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleNotAvailableComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleNotAvailableComponent tgt = new org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleNotAvailableComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        if (src.hasDuring())
            tgt.setDuring(VersionConvertor_30_50.convertPeriod(src.getDuring()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeekEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.DaysOfWeekEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
}