package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.stream.Collectors;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/
// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0
public class HealthcareService40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.HealthcareService convertHealthcareService(org.hl7.fhir.r4.model.HealthcareService src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.HealthcareService tgt = new org.hl7.fhir.r5.model.HealthcareService();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(convertBoolean(src.getActiveElement()));
        if (src.hasProvidedBy())
            tgt.setProvidedBy(convertReference(src.getProvidedBy()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory()) tgt.addCategory(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType()) tgt.addType(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getLocation()) tgt.addLocation(convertReference(t));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasComment())
            tgt.setCommentElement(convertString(src.getCommentElement()));
        if (src.hasExtraDetails())
            tgt.setExtraDetailsElement(convertMarkdown(src.getExtraDetailsElement()));
        if (src.hasPhoto())
            tgt.setPhoto(convertAttachment(src.getPhoto()));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(convertContactPoint(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getCoverageArea()) tgt.addCoverageArea(convertReference(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getServiceProvisionCode()) tgt.addServiceProvisionCode(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceEligibilityComponent t : src.getEligibility()) tgt.addEligibility(convertHealthcareServiceEligibilityComponent(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProgram()) tgt.addProgram(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCharacteristic()) tgt.addCharacteristic(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCommunication()) tgt.addCommunication(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReferralMethod()) tgt.addReferralMethod(convertCodeableConcept(t));
        if (src.hasAppointmentRequired())
            tgt.setAppointmentRequiredElement(convertBoolean(src.getAppointmentRequiredElement()));
        for (org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime()) tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
        for (org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable()) tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
        if (src.hasAvailabilityExceptions())
            tgt.setAvailabilityExceptionsElement(convertString(src.getAvailabilityExceptionsElement()));
        for (org.hl7.fhir.r4.model.Reference t : src.getEndpoint()) tgt.addEndpoint(convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.HealthcareService convertHealthcareService(org.hl7.fhir.r5.model.HealthcareService src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.HealthcareService tgt = new org.hl7.fhir.r4.model.HealthcareService();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(convertBoolean(src.getActiveElement()));
        if (src.hasProvidedBy())
            tgt.setProvidedBy(convertReference(src.getProvidedBy()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory()) tgt.addCategory(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType()) tgt.addType(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getLocation()) tgt.addLocation(convertReference(t));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasComment())
            tgt.setCommentElement(convertString(src.getCommentElement()));
        if (src.hasExtraDetails())
            tgt.setExtraDetailsElement(convertMarkdown(src.getExtraDetailsElement()));
        if (src.hasPhoto())
            tgt.setPhoto(convertAttachment(src.getPhoto()));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(convertContactPoint(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getCoverageArea()) tgt.addCoverageArea(convertReference(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getServiceProvisionCode()) tgt.addServiceProvisionCode(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceEligibilityComponent t : src.getEligibility()) tgt.addEligibility(convertHealthcareServiceEligibilityComponent(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getProgram()) tgt.addProgram(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCharacteristic()) tgt.addCharacteristic(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCommunication()) tgt.addCommunication(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReferralMethod()) tgt.addReferralMethod(convertCodeableConcept(t));
        if (src.hasAppointmentRequired())
            tgt.setAppointmentRequiredElement(convertBoolean(src.getAppointmentRequiredElement()));
        for (org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime()) tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
        for (org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable()) tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
        if (src.hasAvailabilityExceptions())
            tgt.setAvailabilityExceptionsElement(convertString(src.getAvailabilityExceptionsElement()));
        for (org.hl7.fhir.r5.model.Reference t : src.getEndpoint()) tgt.addEndpoint(convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceEligibilityComponent convertHealthcareServiceEligibilityComponent(org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceEligibilityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceEligibilityComponent tgt = new org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceEligibilityComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasComment())
            tgt.setCommentElement(convertMarkdown(src.getCommentElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceEligibilityComponent convertHealthcareServiceEligibilityComponent(org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceEligibilityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceEligibilityComponent tgt = new org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceEligibilityComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasComment())
            tgt.setCommentElement(convertMarkdown(src.getCommentElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
        copyElement(src, tgt);
        tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
                .map(HealthcareService40_50::convertDaysOfWeek)
                .collect(Collectors.toList()));
        if (src.hasAllDay())
            tgt.setAllDayElement(convertBoolean(src.getAllDayElement()));
        if (src.hasAvailableStartTime())
            tgt.setAvailableStartTimeElement(convertTime(src.getAvailableStartTimeElement()));
        if (src.hasAvailableEndTime())
            tgt.setAvailableEndTimeElement(convertTime(src.getAvailableEndTimeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
        copyElement(src, tgt);
        tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
                .map(HealthcareService40_50::convertDaysOfWeek)
                .collect(Collectors.toList()));
        if (src.hasAllDay())
            tgt.setAllDayElement(convertBoolean(src.getAllDayElement()));
        if (src.hasAvailableStartTime())
            tgt.setAvailableStartTimeElement(convertTime(src.getAvailableStartTimeElement()));
        if (src.hasAvailableEndTime())
            tgt.setAvailableEndTimeElement(convertTime(src.getAvailableEndTimeElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.DaysOfWeekEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.HealthcareService.DaysOfWeekEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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

    public static org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent();
        copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasDuring())
            tgt.setDuring(convertPeriod(src.getDuring()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent();
        copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasDuring())
            tgt.setDuring(convertPeriod(src.getDuring()));
        return tgt;
    }
}