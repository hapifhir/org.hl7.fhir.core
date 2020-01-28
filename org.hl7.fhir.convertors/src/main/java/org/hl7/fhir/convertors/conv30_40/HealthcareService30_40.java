package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceEligibilityComponent;

public class HealthcareService30_40 {

    public static org.hl7.fhir.dstu3.model.HealthcareService convertHealthcareService(org.hl7.fhir.r4.model.HealthcareService src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.HealthcareService tgt = new org.hl7.fhir.dstu3.model.HealthcareService();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActive(src.getActive());
        if (src.hasProvidedBy())
            tgt.setProvidedBy(VersionConvertor_30_40.convertReference(src.getProvidedBy()));
        if (src.hasCategory())
            tgt.setCategory(VersionConvertor_30_40.convertCodeableConcept(src.getCategoryFirstRep()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getLocation()) tgt.addLocation(VersionConvertor_30_40.convertReference(t));
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasComment())
            tgt.setComment(src.getComment());
        if (src.hasExtraDetails())
            tgt.setExtraDetails(src.getExtraDetails());
        if (src.hasPhoto())
            tgt.setPhoto(VersionConvertor_30_40.convertAttachment(src.getPhoto()));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_40.convertContactPoint(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getCoverageArea()) tgt.addCoverageArea(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getServiceProvisionCode()) tgt.addServiceProvisionCode(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasEligibility()) {
            tgt.setEligibility(VersionConvertor_30_40.convertCodeableConcept(src.getEligibilityFirstRep().getCode()));
            if (src.getEligibilityFirstRep().hasComment())
                tgt.setEligibilityNote(src.getEligibilityFirstRep().getComment());
        }
        for (CodeableConcept t : src.getProgram()) tgt.addProgramName(t.getText());
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCharacteristic()) tgt.addCharacteristic(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReferralMethod()) tgt.addReferralMethod(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasAppointmentRequired())
            tgt.setAppointmentRequired(src.getAppointmentRequired());
        for (org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime()) tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
        for (org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable()) tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
        if (src.hasAvailabilityExceptions())
            tgt.setAvailabilityExceptions(src.getAvailabilityExceptions());
        for (org.hl7.fhir.r4.model.Reference t : src.getEndpoint()) tgt.addEndpoint(VersionConvertor_30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.HealthcareService convertHealthcareService(org.hl7.fhir.dstu3.model.HealthcareService src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.HealthcareService tgt = new org.hl7.fhir.r4.model.HealthcareService();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActive(src.getActive());
        if (src.hasProvidedBy())
            tgt.setProvidedBy(VersionConvertor_30_40.convertReference(src.getProvidedBy()));
        if (src.hasCategory())
            tgt.addCategory(VersionConvertor_30_40.convertCodeableConcept(src.getCategory()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getLocation()) tgt.addLocation(VersionConvertor_30_40.convertReference(t));
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasComment())
            tgt.setComment(src.getComment());
        if (src.hasExtraDetails())
            tgt.setExtraDetails(src.getExtraDetails());
        if (src.hasPhoto())
            tgt.setPhoto(VersionConvertor_30_40.convertAttachment(src.getPhoto()));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_40.convertContactPoint(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getCoverageArea()) tgt.addCoverageArea(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getServiceProvisionCode()) tgt.addServiceProvisionCode(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasEligibility() || src.hasEligibilityNote()) {
            HealthcareServiceEligibilityComponent t = tgt.addEligibility();
            t.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getEligibility()));
            if (src.hasEligibilityNote())
                t.setComment(src.getEligibilityNote());
        }
        for (org.hl7.fhir.dstu3.model.StringType t : src.getProgramName()) tgt.addProgram().setText(t.getValue());
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCharacteristic()) tgt.addCharacteristic(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReferralMethod()) tgt.addReferralMethod(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasAppointmentRequired())
            tgt.setAppointmentRequired(src.getAppointmentRequired());
        for (org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime()) tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
        for (org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable()) tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
        if (src.hasAvailabilityExceptions())
            tgt.setAvailabilityExceptions(src.getAvailabilityExceptions());
        for (org.hl7.fhir.dstu3.model.Reference t : src.getEndpoint()) tgt.addEndpoint(VersionConvertor_30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek> t : src.getDaysOfWeek()) VersionConvertor_30_40.copyElement(t, tgt.addDaysOfWeekElement().setValue(VersionConvertor_30_40.convertDaysOfWeek(t.getValue())));
        if (src.hasAllDay())
            tgt.setAllDay(src.getAllDay());
        if (src.hasAvailableStartTime())
            tgt.setAvailableStartTime(src.getAvailableStartTime());
        if (src.hasAvailableEndTime())
            tgt.setAvailableEndTime(src.getAvailableEndTime());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.HealthcareService.DaysOfWeek> t : src.getDaysOfWeek()) VersionConvertor_30_40.copyElement(t, tgt.addDaysOfWeekElement().setValue(VersionConvertor_30_40.convertDaysOfWeek(t.getValue())));
        if (src.hasAllDay())
            tgt.setAllDay(src.getAllDay());
        if (src.hasAvailableStartTime())
            tgt.setAvailableStartTime(src.getAvailableStartTime());
        if (src.hasAvailableEndTime())
            tgt.setAvailableEndTime(src.getAvailableEndTime());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasDuring())
            tgt.setDuring(VersionConvertor_30_40.convertPeriod(src.getDuring()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.dstu3.model.HealthcareService.HealthcareServiceNotAvailableComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasDuring())
            tgt.setDuring(VersionConvertor_30_40.convertPeriod(src.getDuring()));
        return tgt;
    }
}
