package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceEligibilityComponent;

import java.util.stream.Collectors;

public class HealthcareService30_50 {

    public static org.hl7.fhir.r5.model.HealthcareService convertHealthcareService(org.hl7.fhir.dstu3.model.HealthcareService src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.HealthcareService tgt = new org.hl7.fhir.r5.model.HealthcareService();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(VersionConvertor_30_50.convertBoolean(src.getActiveElement()));
        if (src.hasProvidedBy())
            tgt.setProvidedBy(VersionConvertor_30_50.convertReference(src.getProvidedBy()));
        if (src.hasCategory())
            tgt.addCategory(VersionConvertor_30_50.convertCodeableConcept(src.getCategory()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getLocation()) tgt.addLocation(VersionConvertor_30_50.convertReference(t));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasComment())
            tgt.setCommentElement(VersionConvertor_30_50.convertString(src.getCommentElement()));
        if (src.hasExtraDetails())
            tgt.setExtraDetails(src.getExtraDetails());
        if (src.hasPhoto())
            tgt.setPhoto(VersionConvertor_30_50.convertAttachment(src.getPhoto()));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_50.convertContactPoint(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getCoverageArea()) tgt.addCoverageArea(VersionConvertor_30_50.convertReference(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getServiceProvisionCode()) tgt.addServiceProvisionCode(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasEligibility() || src.hasEligibilityNote()) {
            HealthcareServiceEligibilityComponent t = tgt.addEligibility();
            t.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getEligibility()));
            if (src.hasEligibilityNote())
                t.setComment(src.getEligibilityNote());
        }
        for (org.hl7.fhir.dstu3.model.StringType t : src.getProgramName()) tgt.addProgram().setText(t.getValue());
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCharacteristic()) tgt.addCharacteristic(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReferralMethod()) tgt.addReferralMethod(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasAppointmentRequired())
            tgt.setAppointmentRequiredElement(VersionConvertor_30_50.convertBoolean(src.getAppointmentRequiredElement()));
        for (org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime()) tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
        for (org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable()) tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
        if (src.hasAvailabilityExceptions())
            tgt.setAvailabilityExceptionsElement(VersionConvertor_30_50.convertString(src.getAvailabilityExceptionsElement()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getEndpoint()) tgt.addEndpoint(VersionConvertor_30_50.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.HealthcareService convertHealthcareService(org.hl7.fhir.r5.model.HealthcareService src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.HealthcareService tgt = new org.hl7.fhir.dstu3.model.HealthcareService();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(VersionConvertor_30_50.convertBoolean(src.getActiveElement()));
        if (src.hasProvidedBy())
            tgt.setProvidedBy(VersionConvertor_30_50.convertReference(src.getProvidedBy()));
        if (src.hasCategory())
            tgt.setCategory(VersionConvertor_30_50.convertCodeableConcept(src.getCategoryFirstRep()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getLocation()) tgt.addLocation(VersionConvertor_30_50.convertReference(t));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasComment())
            tgt.setCommentElement(VersionConvertor_30_50.convertString(src.getCommentElement()));
        if (src.hasExtraDetails())
            tgt.setExtraDetails(src.getExtraDetails());
        if (src.hasPhoto())
            tgt.setPhoto(VersionConvertor_30_50.convertAttachment(src.getPhoto()));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_50.convertContactPoint(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getCoverageArea()) tgt.addCoverageArea(VersionConvertor_30_50.convertReference(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getServiceProvisionCode()) tgt.addServiceProvisionCode(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasEligibility()) {
            tgt.setEligibility(VersionConvertor_30_50.convertCodeableConcept(src.getEligibilityFirstRep().getCode()));
            if (src.getEligibilityFirstRep().hasComment())
                tgt.setEligibilityNoteElement(VersionConvertor_30_50.convertString(src.getCommentElement()));
        }
        for (CodeableConcept t : src.getProgram()) tgt.addProgramName(t.getText());
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCharacteristic()) tgt.addCharacteristic(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReferralMethod()) tgt.addReferralMethod(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasAppointmentRequired())
            tgt.setAppointmentRequiredElement(VersionConvertor_30_50.convertBoolean(src.getAppointmentRequiredElement()));
        for (org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime()) tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
        for (org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable()) tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
        if (src.hasAvailabilityExceptions())
            tgt.setAvailabilityExceptionsElement(VersionConvertor_30_50.convertString(src.getAvailabilityExceptionsElement()));
        for (org.hl7.fhir.r5.model.Reference t : src.getEndpoint()) tgt.addEndpoint(VersionConvertor_30_50.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
                .map(HealthcareService30_50::convertDaysOfWeek)
                .collect(Collectors.toList()));
        if (src.hasAllDay())
            tgt.setAllDayElement(VersionConvertor_30_50.convertBoolean(src.getAllDayElement()));
        if (src.hasAvailableStartTime())
            tgt.setAvailableStartTimeElement(VersionConvertor_30_50.convertTime(src.getAvailableStartTimeElement()));
        if (src.hasAvailableEndTime())
            tgt.setAvailableEndTimeElement(VersionConvertor_30_50.convertTime(src.getAvailableEndTimeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
                .map(HealthcareService30_50::convertDaysOfWeek)
                .collect(Collectors.toList()));
        if (src.hasAllDay())
            tgt.setAllDayElement(VersionConvertor_30_50.convertBoolean(src.getAllDayElement()));
        if (src.hasAvailableStartTime())
            tgt.setAvailableStartTimeElement(VersionConvertor_30_50.convertTime(src.getAvailableStartTimeElement()));
        if (src.hasAvailableEndTime())
            tgt.setAvailableEndTimeElement(VersionConvertor_30_50.convertTime(src.getAvailableEndTimeElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeek> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeekEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
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

    public static org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        if (src.hasDuring())
            tgt.setDuring(VersionConvertor_30_50.convertPeriod(src.getDuring()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        if (src.hasDuring())
            tgt.setDuring(VersionConvertor_30_50.convertPeriod(src.getDuring()));
        return tgt;
    }
}