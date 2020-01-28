package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class HealthcareService10_40 {

    public static org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek convertDaysOfWeek(org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case MON:
                return org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek.MON;
            case TUE:
                return org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek.TUE;
            case WED:
                return org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek.WED;
            case THU:
                return org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek.THU;
            case FRI:
                return org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek.FRI;
            case SAT:
                return org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek.SAT;
            case SUN:
                return org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek.SUN;
            default:
                return org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek convertDaysOfWeek(org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek src) throws FHIRException {
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

    public static org.hl7.fhir.r4.model.HealthcareService convertHealthcareService(org.hl7.fhir.dstu2.model.HealthcareService src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.HealthcareService tgt = new org.hl7.fhir.r4.model.HealthcareService();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        tgt.setProvidedBy(VersionConvertor_10_40.convertReference(src.getProvidedBy()));
        for (org.hl7.fhir.dstu2.model.HealthcareService.ServiceTypeComponent t : src.getServiceType()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept tj : t.getSpecialty()) tgt.addSpecialty(VersionConvertor_10_40.convertCodeableConcept(tj));
        }
        tgt.addLocation(VersionConvertor_10_40.convertReference(src.getLocation()));
        tgt.setComment(src.getComment());
        tgt.setExtraDetails(src.getExtraDetails());
        tgt.setPhoto(VersionConvertor_10_40.convertAttachment(src.getPhoto()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getCoverageArea()) tgt.addCoverageArea(VersionConvertor_10_40.convertReference(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getServiceProvisionCode()) tgt.addServiceProvisionCode(VersionConvertor_10_40.convertCodeableConcept(t));
        if (src.hasEligibility())
            tgt.getEligibilityFirstRep().setCode(VersionConvertor_10_40.convertCodeableConcept(src.getEligibility()));
        if (src.hasEligibilityNote())
            tgt.getEligibilityFirstRep().setComment(src.getEligibilityNote());
        for (org.hl7.fhir.dstu2.model.StringType t : src.getProgramName()) tgt.addProgram().setText(t.getValue());
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCharacteristic()) tgt.addCharacteristic(VersionConvertor_10_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReferralMethod()) tgt.addReferralMethod(VersionConvertor_10_40.convertCodeableConcept(t));
        tgt.setAppointmentRequired(src.getAppointmentRequired());
        for (org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime()) tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
        for (org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable()) tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
        tgt.setAvailabilityExceptions(src.getAvailabilityExceptions());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.HealthcareService convertHealthcareService(org.hl7.fhir.r4.model.HealthcareService src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.HealthcareService tgt = new org.hl7.fhir.dstu2.model.HealthcareService();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        tgt.setProvidedBy(VersionConvertor_10_40.convertReference(src.getProvidedBy()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialty()) {
            if (!tgt.hasServiceType())
                tgt.addServiceType();
            tgt.getServiceType().get(0).addSpecialty(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        for (org.hl7.fhir.r4.model.Reference t : src.getLocation()) tgt.setLocation(VersionConvertor_10_40.convertReference(t));
        tgt.setComment(src.getComment());
        tgt.setExtraDetails(src.getExtraDetails());
        tgt.setPhoto(VersionConvertor_10_40.convertAttachment(src.getPhoto()));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getCoverageArea()) tgt.addCoverageArea(VersionConvertor_10_40.convertReference(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getServiceProvisionCode()) tgt.addServiceProvisionCode(VersionConvertor_10_40.convertCodeableConcept(t));
        tgt.setEligibility(VersionConvertor_10_40.convertCodeableConcept(src.getEligibilityFirstRep().getCode()));
        tgt.setEligibilityNote(src.getEligibilityFirstRep().getComment());
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProgram()) if (t.hasText())
            tgt.addProgramName(t.getText());
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCharacteristic()) tgt.addCharacteristic(VersionConvertor_10_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReferralMethod()) tgt.addReferralMethod(VersionConvertor_10_40.convertCodeableConcept(t));
        tgt.setAppointmentRequired(src.getAppointmentRequired());
        for (org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime()) tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
        for (org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable()) tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
        tgt.setAvailabilityExceptions(src.getAvailabilityExceptions());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek> t : src.getDaysOfWeek()) VersionConvertor_10_40.copyElement(t, tgt.addDaysOfWeekElement().setValue(convertDaysOfWeek(t.getValue())));
        tgt.setAllDay(src.getAllDay());
        tgt.setAvailableStartTime(src.getAvailableStartTime());
        tgt.setAvailableEndTime(src.getAvailableEndTime());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek> t : src.getDaysOfWeek()) VersionConvertor_10_40.copyElement(t, tgt.addDaysOfWeekElement().setValue(convertDaysOfWeek(t.getValue())));
        tgt.setAllDay(src.getAllDay());
        tgt.setAvailableStartTime(src.getAvailableStartTime());
        tgt.setAvailableEndTime(src.getAvailableEndTime());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setDescription(src.getDescription());
        tgt.setDuring(VersionConvertor_10_40.convertPeriod(src.getDuring()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setDescription(src.getDescription());
        tgt.setDuring(VersionConvertor_10_40.convertPeriod(src.getDuring()));
        return tgt;
    }
}
