package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class PractitionerRole30_40 {

    public static org.hl7.fhir.r4.model.PractitionerRole convertPractitionerRole(org.hl7.fhir.dstu3.model.PractitionerRole src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.PractitionerRole tgt = new org.hl7.fhir.r4.model.PractitionerRole();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActive(src.getActive());
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        if (src.hasPractitioner())
            tgt.setPractitioner(VersionConvertor_30_40.convertReference(src.getPractitioner()));
        if (src.hasOrganization())
            tgt.setOrganization(VersionConvertor_30_40.convertReference(src.getOrganization()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCode()) tgt.addCode(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getLocation()) tgt.addLocation(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getHealthcareService()) tgt.addHealthcareService(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_40.convertContactPoint(t));
        for (org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent t : src.getAvailableTime()) tgt.addAvailableTime(convertPractitionerRoleAvailableTimeComponent(t));
        for (org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleNotAvailableComponent t : src.getNotAvailable()) tgt.addNotAvailable(convertPractitionerRoleNotAvailableComponent(t));
        if (src.hasAvailabilityExceptions())
            tgt.setAvailabilityExceptions(src.getAvailabilityExceptions());
        for (org.hl7.fhir.dstu3.model.Reference t : src.getEndpoint()) tgt.addEndpoint(VersionConvertor_30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PractitionerRole convertPractitionerRole(org.hl7.fhir.r4.model.PractitionerRole src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PractitionerRole tgt = new org.hl7.fhir.dstu3.model.PractitionerRole();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActive(src.getActive());
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        if (src.hasPractitioner())
            tgt.setPractitioner(VersionConvertor_30_40.convertReference(src.getPractitioner()));
        if (src.hasOrganization())
            tgt.setOrganization(VersionConvertor_30_40.convertReference(src.getOrganization()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode()) tgt.addCode(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getLocation()) tgt.addLocation(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getHealthcareService()) tgt.addHealthcareService(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_40.convertContactPoint(t));
        for (org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleAvailableTimeComponent t : src.getAvailableTime()) tgt.addAvailableTime(convertPractitionerRoleAvailableTimeComponent(t));
        for (org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleNotAvailableComponent t : src.getNotAvailable()) tgt.addNotAvailable(convertPractitionerRoleNotAvailableComponent(t));
        if (src.hasAvailabilityExceptions())
            tgt.setAvailabilityExceptions(src.getAvailabilityExceptions());
        for (org.hl7.fhir.r4.model.Reference t : src.getEndpoint()) tgt.addEndpoint(VersionConvertor_30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent convertPractitionerRoleAvailableTimeComponent(org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleAvailableTimeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent tgt = new org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeek> t : src.getDaysOfWeek()) VersionConvertor_30_40.copyElement(t, tgt.addDaysOfWeekElement().setValue(VersionConvertor_30_40.convertDaysOfWeek(t.getValue())));
        if (src.hasAllDay())
            tgt.setAllDay(src.getAllDay());
        if (src.hasAvailableStartTime())
            tgt.setAvailableStartTime(src.getAvailableStartTime());
        if (src.hasAvailableEndTime())
            tgt.setAvailableEndTime(src.getAvailableEndTime());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleAvailableTimeComponent convertPractitionerRoleAvailableTimeComponent(org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleAvailableTimeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleAvailableTimeComponent tgt = new org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleAvailableTimeComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PractitionerRole.DaysOfWeek> t : src.getDaysOfWeek()) VersionConvertor_30_40.copyElement(t, tgt.addDaysOfWeekElement().setValue(VersionConvertor_30_40.convertDaysOfWeek(t.getValue())));
        if (src.hasAllDay())
            tgt.setAllDay(src.getAllDay());
        if (src.hasAvailableStartTime())
            tgt.setAvailableStartTime(src.getAvailableStartTime());
        if (src.hasAvailableEndTime())
            tgt.setAvailableEndTime(src.getAvailableEndTime());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleNotAvailableComponent convertPractitionerRoleNotAvailableComponent(org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleNotAvailableComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleNotAvailableComponent tgt = new org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleNotAvailableComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasDuring())
            tgt.setDuring(VersionConvertor_30_40.convertPeriod(src.getDuring()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleNotAvailableComponent convertPractitionerRoleNotAvailableComponent(org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleNotAvailableComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleNotAvailableComponent tgt = new org.hl7.fhir.dstu3.model.PractitionerRole.PractitionerRoleNotAvailableComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasDuring())
            tgt.setDuring(VersionConvertor_30_40.convertPeriod(src.getDuring()));
        return tgt;
    }
}
