package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class PractitionerRole30_50 {

    static public org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek convertDaysOfWeek2(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case MON:
                return org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek.MON;
            case TUE:
                return org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek.TUE;
            case WED:
                return org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek.WED;
            case THU:
                return org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek.THU;
            case FRI:
                return org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek.FRI;
            case SAT:
                return org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek.SAT;
            case SUN:
                return org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek.SUN;
            default:
                return org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.PractitionerRole convertPractitionerRole(org.hl7.fhir.r5.model.PractitionerRole src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PractitionerRole tgt = new org.hl7.fhir.dstu3.model.PractitionerRole();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasActive())
            tgt.setActive(src.getActive());
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_50.convertPeriod(src.getPeriod()));
        if (src.hasPractitioner())
            tgt.setPractitioner(VersionConvertor_30_50.convertReference(src.getPractitioner()));
        if (src.hasOrganization())
            tgt.setOrganization(VersionConvertor_30_50.convertReference(src.getOrganization()));
        if (src.hasCode()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode()) tgt.addCode(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasSpecialty()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasLocation()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getLocation()) tgt.addLocation(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasHealthcareService()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getHealthcareService()) tgt.addHealthcareService(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasTelecom()) {
            for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_50.convertContactPoint(t));
        }
        if (src.hasAvailableTime()) {
            for (org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent t : src.getAvailableTime()) tgt.addAvailableTime(convertPractitionerRoleAvailableTimeComponent(t));
        }
        if (src.hasNotAvailable()) {
            for (org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleNotAvailableComponent t : src.getNotAvailable()) tgt.addNotAvailable(convertPractitionerRoleNotAvailableComponent(t));
        }
        if (src.hasAvailabilityExceptions())
            tgt.setAvailabilityExceptions(src.getAvailabilityExceptions());
        if (src.hasEndpoint()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getEndpoint()) tgt.addEndpoint(VersionConvertor_30_50.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.PractitionerRole convertPractitionerRole(org.hl7.fhir.dstu3.model.PractitionerRole src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.PractitionerRole tgt = new org.hl7.fhir.r5.model.PractitionerRole();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasActive())
            tgt.setActive(src.getActive());
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_50.convertPeriod(src.getPeriod()));
        if (src.hasPractitioner())
            tgt.setPractitioner(VersionConvertor_30_50.convertReference(src.getPractitioner()));
        if (src.hasOrganization())
            tgt.setOrganization(VersionConvertor_30_50.convertReference(src.getOrganization()));
        if (src.hasCode()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCode()) tgt.addCode(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasSpecialty()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasLocation()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getLocation()) tgt.addLocation(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasHealthcareService()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getHealthcareService()) tgt.addHealthcareService(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_50.convertContactPoint(t));
        }
        if (src.hasAvailableTime()) {
            for (org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent t : src.getAvailableTime()) tgt.addAvailableTime(convertPractitionerRoleAvailableTimeComponent(t));
        }
        if (src.hasNotAvailable()) {
            for (org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleNotAvailableComponent t : src.getNotAvailable()) tgt.addNotAvailable(convertPractitionerRoleNotAvailableComponent(t));
        }
        if (src.hasAvailabilityExceptions())
            tgt.setAvailabilityExceptions(src.getAvailabilityExceptions());
        if (src.hasEndpoint()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getEndpoint()) tgt.addEndpoint(VersionConvertor_30_50.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent convertPractitionerRoleAvailableTimeComponent(org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent tgt = new org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasDaysOfWeek()) {
            for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> t : src.getDaysOfWeek()) VersionConvertor_30_50.copyElement(t, tgt.addDaysOfWeekElement().setValue(convertDaysOfWeek2(t.getValue())));
        }
        if (src.hasAllDay())
            tgt.setAllDay(src.getAllDay());
        if (src.hasAvailableStartTime())
            tgt.setAvailableStartTime(src.getAvailableStartTime());
        if (src.hasAvailableEndTime())
            tgt.setAvailableEndTime(src.getAvailableEndTime());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent convertPractitionerRoleAvailableTimeComponent(org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent tgt = new org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasDaysOfWeek()) {
            for (org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek> t : src.getDaysOfWeek()) VersionConvertor_30_50.copyElement(t, tgt.addDaysOfWeekElement().setValue(VersionConvertor_30_50.convertDaysOfWeek(t.getValue())));
        }
        if (src.hasAllDay())
            tgt.setAllDay(src.getAllDay());
        if (src.hasAvailableStartTime())
            tgt.setAvailableStartTime(src.getAvailableStartTime());
        if (src.hasAvailableEndTime())
            tgt.setAvailableEndTime(src.getAvailableEndTime());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleNotAvailableComponent convertPractitionerRoleNotAvailableComponent(org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleNotAvailableComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleNotAvailableComponent tgt = new org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleNotAvailableComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
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
            tgt.setDescription(src.getDescription());
        if (src.hasDuring())
            tgt.setDuring(VersionConvertor_30_50.convertPeriod(src.getDuring()));
        return tgt;
    }
}
