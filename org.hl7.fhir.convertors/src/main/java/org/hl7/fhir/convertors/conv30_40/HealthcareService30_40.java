package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceEligibilityComponent;
import java.util.Collections;

public class HealthcareService30_40 {

    public static org.hl7.fhir.dstu3.model.HealthcareService convertHealthcareService(org.hl7.fhir.r4.model.HealthcareService src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.HealthcareService tgt = new org.hl7.fhir.dstu3.model.HealthcareService();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasActiveElement())
            tgt.setActiveElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getActiveElement()));
        if (src.hasProvidedBy())
            tgt.setProvidedBy(VersionConvertor_30_40.convertReference(src.getProvidedBy()));
        if (src.hasCategory())
            tgt.setCategory(VersionConvertor_30_40.convertCodeableConcept(src.getCategoryFirstRep()));
        if (src.hasType()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasSpecialty()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasLocation()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getLocation()) tgt.addLocation(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasCommentElement())
            tgt.setCommentElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getCommentElement()));
        if (src.hasExtraDetailsElement())
            tgt.setExtraDetailsElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getExtraDetailsElement()));
        if (src.hasPhoto())
            tgt.setPhoto(VersionConvertor_30_40.convertAttachment(src.getPhoto()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_40.convertContactPoint(t));
        }
        if (src.hasCoverageArea()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getCoverageArea()) tgt.addCoverageArea(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasServiceProvisionCode()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getServiceProvisionCode()) tgt.addServiceProvisionCode(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasEligibility()) {
            if (src.hasEligibility()) {
                tgt.setEligibility(VersionConvertor_30_40.convertCodeableConcept(src.getEligibilityFirstRep().getCode()));
            }
            if (src.getEligibilityFirstRep().hasComment())
                tgt.setEligibilityNote(src.getEligibilityFirstRep().getComment());
        }
        if (src.hasProgram()) {
            for (CodeableConcept t : src.getProgram()) tgt.addProgramName(t.getText());
        }
        if (src.hasCharacteristic()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCharacteristic()) tgt.addCharacteristic(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasReferralMethod()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReferralMethod()) tgt.addReferralMethod(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasAppointmentRequiredElement())
            tgt.setAppointmentRequiredElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getAppointmentRequiredElement()));
        if (src.hasAvailableTime()) {
            for (org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime()) tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
        }
        if (src.hasNotAvailable()) {
            for (org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable()) tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
        }
        if (src.hasAvailabilityExceptionsElement())
            tgt.setAvailabilityExceptionsElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getAvailabilityExceptionsElement()));
        if (src.hasEndpoint()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getEndpoint()) tgt.addEndpoint(VersionConvertor_30_40.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.HealthcareService convertHealthcareService(org.hl7.fhir.dstu3.model.HealthcareService src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.HealthcareService tgt = new org.hl7.fhir.r4.model.HealthcareService();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasActiveElement())
            tgt.setActiveElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getActiveElement()));
        if (src.hasProvidedBy())
            tgt.setProvidedBy(VersionConvertor_30_40.convertReference(src.getProvidedBy()));
        if (src.hasCategory())
            tgt.addCategory(VersionConvertor_30_40.convertCodeableConcept(src.getCategory()));
        if (src.hasType()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasSpecialty()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasLocation()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getLocation()) tgt.addLocation(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasCommentElement())
            tgt.setCommentElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getCommentElement()));
        if (src.hasExtraDetailsElement())
            tgt.setExtraDetailsElement((org.hl7.fhir.r4.model.MarkdownType) VersionConvertor_30_40.convertType(src.getExtraDetailsElement()));
        if (src.hasPhoto())
            tgt.setPhoto(VersionConvertor_30_40.convertAttachment(src.getPhoto()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_40.convertContactPoint(t));
        }
        if (src.hasCoverageArea()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getCoverageArea()) tgt.addCoverageArea(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasServiceProvisionCode()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getServiceProvisionCode()) tgt.addServiceProvisionCode(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasEligibility() || src.hasEligibilityNote()) {
            HealthcareServiceEligibilityComponent t = tgt.addEligibility();
            if (src.hasEligibility()) {
                t.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getEligibility()));
            }
            if (src.hasEligibilityNote())
                t.setComment(src.getEligibilityNote());
        }
        if (src.hasProgramName()) {
            for (org.hl7.fhir.dstu3.model.StringType t : src.getProgramName()) tgt.addProgram().setText(t.getValue());
        }
        if (src.hasCharacteristic()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCharacteristic()) tgt.addCharacteristic(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasReferralMethod()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReferralMethod()) tgt.addReferralMethod(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasAppointmentRequiredElement())
            tgt.setAppointmentRequiredElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getAppointmentRequiredElement()));
        if (src.hasAvailableTime()) {
            for (org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime()) tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
        }
        if (src.hasNotAvailable()) {
            for (org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable()) tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
        }
        if (src.hasAvailabilityExceptionsElement())
            tgt.setAvailabilityExceptionsElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getAvailabilityExceptionsElement()));
        if (src.hasEndpoint()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getEndpoint()) tgt.addEndpoint(VersionConvertor_30_40.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasDaysOfWeek()) {
            for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek> t : src.getDaysOfWeek()) VersionConvertor_30_40.copyElement(t, tgt.addDaysOfWeekElement().setValue(VersionConvertor_30_40.convertDaysOfWeek(t.getValue())));
        }
        if (src.hasAllDayElement())
            tgt.setAllDayElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getAllDayElement()));
        if (src.hasAvailableStartTimeElement())
            tgt.setAvailableStartTimeElement((org.hl7.fhir.dstu3.model.TimeType) VersionConvertor_30_40.convertType(src.getAvailableStartTimeElement()));
        if (src.hasAvailableEndTimeElement())
            tgt.setAvailableEndTimeElement((org.hl7.fhir.dstu3.model.TimeType) VersionConvertor_30_40.convertType(src.getAvailableEndTimeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasDaysOfWeek()) {
            for (org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeek> t : src.getDaysOfWeek()) VersionConvertor_30_40.copyElement(t, tgt.addDaysOfWeekElement().setValue(VersionConvertor_30_40.convertDaysOfWeek(t.getValue())));
        }
        if (src.hasAllDayElement())
            tgt.setAllDayElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getAllDayElement()));
        if (src.hasAvailableStartTimeElement())
            tgt.setAvailableStartTimeElement((org.hl7.fhir.r4.model.TimeType) VersionConvertor_30_40.convertType(src.getAvailableStartTimeElement()));
        if (src.hasAvailableEndTimeElement())
            tgt.setAvailableEndTimeElement((org.hl7.fhir.r4.model.TimeType) VersionConvertor_30_40.convertType(src.getAvailableEndTimeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasDuring())
            tgt.setDuring(VersionConvertor_30_40.convertPeriod(src.getDuring()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasDuring())
            tgt.setDuring(VersionConvertor_30_40.convertPeriod(src.getDuring()));
        return tgt;
    }
}
