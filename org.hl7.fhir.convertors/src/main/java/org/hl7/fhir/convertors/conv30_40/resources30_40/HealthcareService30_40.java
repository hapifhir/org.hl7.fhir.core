package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.conv30_40.VersionConvertor_30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.*;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Boolean30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Time30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceEligibilityComponent;

import java.util.stream.Collectors;

public class HealthcareService30_40 {

    public static org.hl7.fhir.dstu3.model.HealthcareService convertHealthcareService(org.hl7.fhir.r4.model.HealthcareService src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.HealthcareService tgt = new org.hl7.fhir.dstu3.model.HealthcareService();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(Boolean30_40.convertBoolean(src.getActiveElement()));
        if (src.hasProvidedBy())
            tgt.setProvidedBy(Reference30_40.convertReference(src.getProvidedBy()));
        if (src.hasCategory())
            tgt.setCategory(CodeableConcept30_40.convertCodeableConcept(src.getCategoryFirstRep()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType()) tgt.addType(CodeableConcept30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(CodeableConcept30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getLocation()) tgt.addLocation(Reference30_40.convertReference(t));
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        if (src.hasComment())
            tgt.setCommentElement(String30_40.convertString(src.getCommentElement()));
        if (src.hasExtraDetails())
            tgt.setExtraDetails(src.getExtraDetails());
        if (src.hasPhoto())
            tgt.setPhoto(Attachment30_40.convertAttachment(src.getPhoto()));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint30_40.convertContactPoint(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getCoverageArea()) tgt.addCoverageArea(Reference30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getServiceProvisionCode()) tgt.addServiceProvisionCode(CodeableConcept30_40.convertCodeableConcept(t));
        if (src.hasEligibility()) {
            tgt.setEligibility(CodeableConcept30_40.convertCodeableConcept(src.getEligibilityFirstRep().getCode()));
            if (src.getEligibilityFirstRep().hasComment())
                tgt.setEligibilityNoteElement(String30_40.convertString(src.getCommentElement()));
        }
        for (CodeableConcept t : src.getProgram()) tgt.addProgramName(t.getText());
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCharacteristic()) tgt.addCharacteristic(CodeableConcept30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReferralMethod()) tgt.addReferralMethod(CodeableConcept30_40.convertCodeableConcept(t));
        if (src.hasAppointmentRequired())
            tgt.setAppointmentRequiredElement(Boolean30_40.convertBoolean(src.getAppointmentRequiredElement()));
        for (org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime()) tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
        for (org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable()) tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
        if (src.hasAvailabilityExceptions())
            tgt.setAvailabilityExceptionsElement(String30_40.convertString(src.getAvailabilityExceptionsElement()));
        for (org.hl7.fhir.r4.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.HealthcareService convertHealthcareService(org.hl7.fhir.dstu3.model.HealthcareService src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.HealthcareService tgt = new org.hl7.fhir.r4.model.HealthcareService();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(Boolean30_40.convertBoolean(src.getActiveElement()));
        if (src.hasProvidedBy())
            tgt.setProvidedBy(Reference30_40.convertReference(src.getProvidedBy()));
        if (src.hasCategory())
            tgt.addCategory(CodeableConcept30_40.convertCodeableConcept(src.getCategory()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getType()) tgt.addType(CodeableConcept30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(CodeableConcept30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getLocation()) tgt.addLocation(Reference30_40.convertReference(t));
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        if (src.hasComment())
            tgt.setCommentElement(String30_40.convertString(src.getCommentElement()));
        if (src.hasExtraDetails())
            tgt.setExtraDetails(src.getExtraDetails());
        if (src.hasPhoto())
            tgt.setPhoto(Attachment30_40.convertAttachment(src.getPhoto()));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint30_40.convertContactPoint(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getCoverageArea()) tgt.addCoverageArea(Reference30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getServiceProvisionCode()) tgt.addServiceProvisionCode(CodeableConcept30_40.convertCodeableConcept(t));
        if (src.hasEligibility() || src.hasEligibilityNote()) {
            HealthcareServiceEligibilityComponent t = tgt.addEligibility();
            t.setCode(CodeableConcept30_40.convertCodeableConcept(src.getEligibility()));
            if (src.hasEligibilityNote())
                t.setComment(src.getEligibilityNote());
        }
        for (org.hl7.fhir.dstu3.model.StringType t : src.getProgramName()) tgt.addProgram().setText(t.getValue());
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCharacteristic()) tgt.addCharacteristic(CodeableConcept30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReferralMethod()) tgt.addReferralMethod(CodeableConcept30_40.convertCodeableConcept(t));
        if (src.hasAppointmentRequired())
            tgt.setAppointmentRequiredElement(Boolean30_40.convertBoolean(src.getAppointmentRequiredElement()));
        for (org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime()) tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
        for (org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable()) tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
        if (src.hasAvailabilityExceptions())
            tgt.setAvailabilityExceptionsElement(String30_40.convertString(src.getAvailabilityExceptionsElement()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
        Element30_40.copyElement(src, tgt);
        tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
                .map(HealthcareService30_40::convertDaysOfWeek)
                .collect(Collectors.toList()));
        if (src.hasAllDay())
            tgt.setAllDayElement(Boolean30_40.convertBoolean(src.getAllDayElement()));
        if (src.hasAvailableStartTime())
            tgt.setAvailableStartTimeElement(Time30_40.convertTime(src.getAvailableStartTimeElement()));
        if (src.hasAvailableEndTime())
            tgt.setAvailableEndTimeElement(Time30_40.convertTime(src.getAvailableEndTimeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
        Element30_40.copyElement(src, tgt);
        tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
                .map(HealthcareService30_40::convertDaysOfWeek)
                .collect(Collectors.toList()));
        if (src.hasAllDay())
            tgt.setAllDayElement(Boolean30_40.convertBoolean(src.getAllDayElement()));
        if (src.hasAvailableStartTime())
            tgt.setAvailableStartTimeElement(Time30_40.convertTime(src.getAvailableStartTimeElement()));
        if (src.hasAvailableEndTime())
            tgt.setAvailableEndTimeElement(Time30_40.convertTime(src.getAvailableEndTimeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
        if (src.hasDuring())
            tgt.setDuring(Period30_40.convertPeriod(src.getDuring()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
        if (src.hasDuring())
            tgt.setDuring(Period30_40.convertPeriod(src.getDuring()));
        return tgt;
    }


    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeek> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.HealthcareService.DaysOfWeekEnumFactory());
        Element30_40.copyElement(src, tgt);
        switch (src.getValue()) {
            case MON:
                tgt.setValue(org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek.MON);
                break;
            case TUE:
                tgt.setValue(org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek.TUE);
                break;
            case WED:
                tgt.setValue(org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek.WED);
                break;
            case THU:
                tgt.setValue(org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek.THU);
                break;
            case FRI:
                tgt.setValue(org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek.FRI);
                break;
            case SAT:
                tgt.setValue(org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek.SAT);
                break;
            case SUN:
                tgt.setValue(org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek.SUN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeek> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeekEnumFactory());
        Element30_40.copyElement(src, tgt);
        switch (src.getValue()) {
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
}