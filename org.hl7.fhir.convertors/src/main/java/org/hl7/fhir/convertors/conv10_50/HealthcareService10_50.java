package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.stream.Collectors;

public class HealthcareService10_50 {

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeek> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.HealthcareService.DaysOfWeekEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
        VersionConvertor_10_50.copyElement(src, tgt);
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

    public static org.hl7.fhir.dstu2.model.HealthcareService convertHealthcareService(org.hl7.fhir.r5.model.HealthcareService src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.HealthcareService tgt = new org.hl7.fhir.dstu2.model.HealthcareService();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        if (src.hasProvidedBy())
            tgt.setProvidedBy(VersionConvertor_10_50.convertReference(src.getProvidedBy()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialty()) {
            if (!tgt.hasServiceType())
                tgt.addServiceType();
            tgt.getServiceType().get(0).addSpecialty(VersionConvertor_10_50.convertCodeableConcept(t));
        }
        for (org.hl7.fhir.r5.model.Reference t : src.getLocation()) tgt.setLocation(VersionConvertor_10_50.convertReference(t));
        if (src.hasCommentElement())
            tgt.setCommentElement(VersionConvertor_10_50.convertString(src.getCommentElement()));
        if (src.hasExtraDetails())
            tgt.setExtraDetails(src.getExtraDetails());
        if (src.hasPhoto())
            tgt.setPhoto(VersionConvertor_10_50.convertAttachment(src.getPhoto()));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_50.convertContactPoint(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getCoverageArea()) tgt.addCoverageArea(VersionConvertor_10_50.convertReference(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getServiceProvisionCode()) tgt.addServiceProvisionCode(VersionConvertor_10_50.convertCodeableConcept(t));
        tgt.setEligibility(VersionConvertor_10_50.convertCodeableConcept(src.getEligibilityFirstRep().getCode()));
        if (src.hasCommentElement())
            tgt.setEligibilityNoteElement(VersionConvertor_10_50.convertString(src.getCommentElement()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getProgram()) if (t.hasText())
            tgt.addProgramName(t.getText());
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCharacteristic()) tgt.addCharacteristic(VersionConvertor_10_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReferralMethod()) tgt.addReferralMethod(VersionConvertor_10_50.convertCodeableConcept(t));
        if (src.hasAppointmentRequiredElement())
            tgt.setAppointmentRequiredElement(VersionConvertor_10_50.convertBoolean(src.getAppointmentRequiredElement()));
        for (org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime()) tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
        for (org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable()) tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
        if (src.hasAvailabilityExceptionsElement())
            tgt.setAvailabilityExceptionsElement(VersionConvertor_10_50.convertString(src.getAvailabilityExceptionsElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.HealthcareService convertHealthcareService(org.hl7.fhir.dstu2.model.HealthcareService src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.HealthcareService tgt = new org.hl7.fhir.r5.model.HealthcareService();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        if (src.hasProvidedBy())
            tgt.setProvidedBy(VersionConvertor_10_50.convertReference(src.getProvidedBy()));
        for (org.hl7.fhir.dstu2.model.HealthcareService.ServiceTypeComponent t : src.getServiceType()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept tj : t.getSpecialty()) tgt.addSpecialty(VersionConvertor_10_50.convertCodeableConcept(tj));
        }
        if (src.hasLocation())
            tgt.addLocation(VersionConvertor_10_50.convertReference(src.getLocation()));
        if (src.hasCommentElement())
            tgt.setCommentElement(VersionConvertor_10_50.convertString(src.getCommentElement()));
        if (src.hasExtraDetails())
            tgt.setExtraDetails(src.getExtraDetails());
        if (src.hasPhoto())
            tgt.setPhoto(VersionConvertor_10_50.convertAttachment(src.getPhoto()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_50.convertContactPoint(t));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getCoverageArea()) tgt.addCoverageArea(VersionConvertor_10_50.convertReference(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getServiceProvisionCode()) tgt.addServiceProvisionCode(VersionConvertor_10_50.convertCodeableConcept(t));
        if (src.hasEligibility())
            tgt.getEligibilityFirstRep().setCode(VersionConvertor_10_50.convertCodeableConcept(src.getEligibility()));
        if (src.hasEligibilityNote())
            tgt.getEligibilityFirstRep().setComment(src.getEligibilityNote());
        for (org.hl7.fhir.dstu2.model.StringType t : src.getProgramName()) tgt.addProgram().setText(t.getValue());
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCharacteristic()) tgt.addCharacteristic(VersionConvertor_10_50.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReferralMethod()) tgt.addReferralMethod(VersionConvertor_10_50.convertCodeableConcept(t));
        if (src.hasAppointmentRequiredElement())
            tgt.setAppointmentRequiredElement(VersionConvertor_10_50.convertBoolean(src.getAppointmentRequiredElement()));
        for (org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime()) tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
        for (org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable()) tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
        if (src.hasAvailabilityExceptionsElement())
            tgt.setAvailabilityExceptionsElement(VersionConvertor_10_50.convertString(src.getAvailabilityExceptionsElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
                .map(HealthcareService10_50::convertDaysOfWeek)
                .collect(Collectors.toList()));
        if (src.hasAllDayElement())
            tgt.setAllDayElement(VersionConvertor_10_50.convertBoolean(src.getAllDayElement()));
        if (src.hasAvailableStartTimeElement())
            tgt.setAvailableStartTimeElement(VersionConvertor_10_50.convertTime(src.getAvailableStartTimeElement()));
        if (src.hasAvailableEndTimeElement())
            tgt.setAvailableEndTimeElement(VersionConvertor_10_50.convertTime(src.getAvailableEndTimeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
                .map(HealthcareService10_50::convertDaysOfWeek)
                .collect(Collectors.toList()));
        if (src.hasAllDayElement())
            tgt.setAllDayElement(VersionConvertor_10_50.convertBoolean(src.getAllDayElement()));
        if (src.hasAvailableStartTimeElement())
            tgt.setAvailableStartTimeElement(VersionConvertor_10_50.convertTime(src.getAvailableStartTimeElement()));
        if (src.hasAvailableEndTimeElement())
            tgt.setAvailableEndTimeElement(VersionConvertor_10_50.convertTime(src.getAvailableEndTimeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(VersionConvertor_10_50.convertString(src.getDescriptionElement()));
        if (src.hasDuring())
            tgt.setDuring(VersionConvertor_10_50.convertPeriod(src.getDuring()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.dstu2.model.HealthcareService.HealthcareServiceNotAvailableComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(VersionConvertor_10_50.convertString(src.getDescriptionElement()));
        if (src.hasDuring())
            tgt.setDuring(VersionConvertor_10_50.convertPeriod(src.getDuring()));
        return tgt;
    }
}