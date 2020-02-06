package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class HealthcareService10_50 {

    public static org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek convertDaysOfWeek(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case MON:
                return org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek.MON;
            case TUE:
                return org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek.TUE;
            case WED:
                return org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek.WED;
            case THU:
                return org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek.THU;
            case FRI:
                return org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek.FRI;
            case SAT:
                return org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek.SAT;
            case SUN:
                return org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek.SUN;
            default:
                return org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.Enumerations.DaysOfWeek convertDaysOfWeek(org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case MON:
                return org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.MON;
            case TUE:
                return org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.TUE;
            case WED:
                return org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.WED;
            case THU:
                return org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.THU;
            case FRI:
                return org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.FRI;
            case SAT:
                return org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.SAT;
            case SUN:
                return org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.SUN;
            default:
                return org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.HealthcareService convertHealthcareService(org.hl7.fhir.r5.model.HealthcareService src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.HealthcareService tgt = new org.hl7.fhir.dstu2.model.HealthcareService();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        }
        if (src.hasProvidedBy()) {
            tgt.setProvidedBy(VersionConvertor_10_50.convertReference(src.getProvidedBy()));
        }
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialty()) {
            if (!tgt.hasServiceType())
                tgt.addServiceType();
            tgt.getServiceType().get(0).addSpecialty(VersionConvertor_10_50.convertCodeableConcept(t));
        }
        if (src.hasLocation()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getLocation()) tgt.setLocation(VersionConvertor_10_50.convertReference(t));
        }
        if (src.hasComment()) {
            tgt.setComment(src.getComment());
        }
        if (src.hasExtraDetails()) {
            tgt.setExtraDetails(src.getExtraDetails());
        }
        if (src.hasPhoto()) {
            tgt.setPhoto(VersionConvertor_10_50.convertAttachment(src.getPhoto()));
        }
        if (src.hasTelecom()) {
            for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_50.convertContactPoint(t));
        }
        if (src.hasCoverageArea()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getCoverageArea()) tgt.addCoverageArea(VersionConvertor_10_50.convertReference(t));
        }
        if (src.hasServiceProvisionCode()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getServiceProvisionCode()) tgt.addServiceProvisionCode(VersionConvertor_10_50.convertCodeableConcept(t));
        }
        if (src.hasEligibility()) {
            tgt.setEligibility(VersionConvertor_10_50.convertCodeableConcept(src.getEligibilityFirstRep().getCode()));
        }
        if (src.hasEligibility()) {
            tgt.setEligibilityNote(src.getEligibilityFirstRep().getComment());
        }
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getProgram()) if (t.hasText())
            tgt.addProgramName(t.getText());
        if (src.hasCharacteristic()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCharacteristic()) tgt.addCharacteristic(VersionConvertor_10_50.convertCodeableConcept(t));
        }
        if (src.hasReferralMethod()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReferralMethod()) tgt.addReferralMethod(VersionConvertor_10_50.convertCodeableConcept(t));
        }
        if (src.hasAppointmentRequired()) {
            tgt.setAppointmentRequired(src.getAppointmentRequired());
        }
        if (src.hasAvailableTime()) {
            for (org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime()) tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
        }
        if (src.hasNotAvailable()) {
            for (org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable()) tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
        }
        if (src.hasAvailabilityExceptions()) {
            tgt.setAvailabilityExceptions(src.getAvailabilityExceptions());
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.HealthcareService convertHealthcareService(org.hl7.fhir.dstu2.model.HealthcareService src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.HealthcareService tgt = new org.hl7.fhir.r5.model.HealthcareService();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        }
        if (src.hasProvidedBy()) {
            tgt.setProvidedBy(VersionConvertor_10_50.convertReference(src.getProvidedBy()));
        }
        for (org.hl7.fhir.dstu2.model.HealthcareService.ServiceTypeComponent t : src.getServiceType()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept tj : t.getSpecialty()) tgt.addSpecialty(VersionConvertor_10_50.convertCodeableConcept(tj));
        }
        if (src.hasLocation()) {
            tgt.addLocation(VersionConvertor_10_50.convertReference(src.getLocation()));
        }
        if (src.hasComment()) {
            tgt.setComment(src.getComment());
        }
        if (src.hasExtraDetails()) {
            tgt.setExtraDetails(src.getExtraDetails());
        }
        if (src.hasPhoto()) {
            tgt.setPhoto(VersionConvertor_10_50.convertAttachment(src.getPhoto()));
        }
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_50.convertContactPoint(t));
        }
        if (src.hasCoverageArea()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getCoverageArea()) tgt.addCoverageArea(VersionConvertor_10_50.convertReference(t));
        }
        if (src.hasServiceProvisionCode()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getServiceProvisionCode()) tgt.addServiceProvisionCode(VersionConvertor_10_50.convertCodeableConcept(t));
        }
        if (src.hasEligibility())
            tgt.getEligibilityFirstRep().setCode(VersionConvertor_10_50.convertCodeableConcept(src.getEligibility()));
        if (src.hasEligibilityNote())
            tgt.getEligibilityFirstRep().setComment(src.getEligibilityNote());
        if (src.hasProgramName()) {
            for (org.hl7.fhir.dstu2.model.StringType t : src.getProgramName()) tgt.addProgram().setText(t.getValue());
        }
        if (src.hasCharacteristic()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCharacteristic()) tgt.addCharacteristic(VersionConvertor_10_50.convertCodeableConcept(t));
        }
        if (src.hasReferralMethod()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReferralMethod()) tgt.addReferralMethod(VersionConvertor_10_50.convertCodeableConcept(t));
        }
        if (src.hasAppointmentRequired()) {
            tgt.setAppointmentRequired(src.getAppointmentRequired());
        }
        if (src.hasAvailableTime()) {
            for (org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime()) tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
        }
        if (src.hasNotAvailable()) {
            for (org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable()) tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
        }
        if (src.hasAvailabilityExceptions()) {
            tgt.setAvailabilityExceptions(src.getAvailabilityExceptions());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasDaysOfWeek()) {
            for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> t : src.getDaysOfWeek()) VersionConvertor_10_50.copyElement(t, tgt.addDaysOfWeekElement().setValue(convertDaysOfWeek(t.getValue())));
        }
        if (src.hasAllDay()) {
            tgt.setAllDay(src.getAllDay());
        }
        if (src.hasAvailableStartTime()) {
            tgt.setAvailableStartTime(src.getAvailableStartTime());
        }
        if (src.hasAvailableEndTime()) {
            tgt.setAvailableEndTime(src.getAvailableEndTime());
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasDaysOfWeek()) {
            for (org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek> t : src.getDaysOfWeek()) VersionConvertor_10_50.copyElement(t, tgt.addDaysOfWeekElement().setValue(convertDaysOfWeek(t.getValue())));
        }
        if (src.hasAllDay()) {
            tgt.setAllDay(src.getAllDay());
        }
        if (src.hasAvailableStartTime()) {
            tgt.setAvailableStartTime(src.getAvailableStartTime());
        }
        if (src.hasAvailableEndTime()) {
            tgt.setAvailableEndTime(src.getAvailableEndTime());
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
        if (src.hasDuring()) {
            tgt.setDuring(VersionConvertor_10_50.convertPeriod(src.getDuring()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
        if (src.hasDuring()) {
            tgt.setDuring(VersionConvertor_10_50.convertPeriod(src.getDuring()));
        }
        return tgt;
    }
}
