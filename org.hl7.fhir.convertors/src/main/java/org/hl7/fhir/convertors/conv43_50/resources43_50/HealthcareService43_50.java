package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Attachment43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.ContactPoint43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.MarkDown43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.ExtendedContactDetail;

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
public class HealthcareService43_50 {

  public static org.hl7.fhir.r5.model.HealthcareService convertHealthcareService(org.hl7.fhir.r4b.model.HealthcareService src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.HealthcareService tgt = new org.hl7.fhir.r5.model.HealthcareService();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean43_50.convertBoolean(src.getActiveElement()));
    if (src.hasProvidedBy())
      tgt.setProvidedBy(Reference43_50.convertReference(src.getProvidedBy()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSpecialty())
      tgt.addSpecialty(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getLocation()) tgt.addLocation(Reference43_50.convertReference(t));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasComment())
      tgt.setCommentElement(String43_50.convertStringToMarkdown(src.getCommentElement()));
    if (src.hasExtraDetails())
      tgt.setExtraDetailsElement(MarkDown43_50.convertMarkdown(src.getExtraDetailsElement()));
    if (src.hasPhoto())
      tgt.setPhoto(Attachment43_50.convertAttachment(src.getPhoto()));
    for (org.hl7.fhir.r4b.model.ContactPoint t : src.getTelecom())
      tgt.getContactFirstRep().addTelecom(ContactPoint43_50.convertContactPoint(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getCoverageArea())
      tgt.addCoverageArea(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getServiceProvisionCode())
      tgt.addServiceProvisionCode(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.HealthcareService.HealthcareServiceEligibilityComponent t : src.getEligibility())
      tgt.addEligibility(convertHealthcareServiceEligibilityComponent(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getProgram())
      tgt.addProgram(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCharacteristic())
      tgt.addCharacteristic(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCommunication())
      tgt.addCommunication(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReferralMethod())
      tgt.addReferralMethod(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasAppointmentRequired())
      tgt.setAppointmentRequiredElement(Boolean43_50.convertBoolean(src.getAppointmentRequiredElement()));
//    for (org.hl7.fhir.r4b.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime())
//      tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
//    for (org.hl7.fhir.r4b.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable())
//      tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
//    if (src.hasAvailabilityExceptions())
//      tgt.setAvailabilityExceptionsElement(String43_50.convertString(src.getAvailabilityExceptionsElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference43_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.HealthcareService convertHealthcareService(org.hl7.fhir.r5.model.HealthcareService src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.HealthcareService tgt = new org.hl7.fhir.r4b.model.HealthcareService();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean43_50.convertBoolean(src.getActiveElement()));
    if (src.hasProvidedBy())
      tgt.setProvidedBy(Reference43_50.convertReference(src.getProvidedBy()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialty())
      tgt.addSpecialty(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getLocation()) tgt.addLocation(Reference43_50.convertReference(t));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasComment())
      tgt.setCommentElement(String43_50.convertString(src.getCommentElement()));
    if (src.hasExtraDetails())
      tgt.setExtraDetailsElement(MarkDown43_50.convertMarkdown(src.getExtraDetailsElement()));
    if (src.hasPhoto())
      tgt.setPhoto(Attachment43_50.convertAttachment(src.getPhoto()));
    for (ExtendedContactDetail t1 : src.getContact())
      for (org.hl7.fhir.r5.model.ContactPoint t : t1.getTelecom())
        tgt.addTelecom(ContactPoint43_50.convertContactPoint(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getCoverageArea())
      tgt.addCoverageArea(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getServiceProvisionCode())
      tgt.addServiceProvisionCode(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceEligibilityComponent t : src.getEligibility())
      tgt.addEligibility(convertHealthcareServiceEligibilityComponent(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getProgram())
      tgt.addProgram(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCharacteristic())
      tgt.addCharacteristic(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCommunication())
      tgt.addCommunication(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReferralMethod())
      tgt.addReferralMethod(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasAppointmentRequired())
      tgt.setAppointmentRequiredElement(Boolean43_50.convertBoolean(src.getAppointmentRequiredElement()));
//    for (org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime())
//      tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
//    for (org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable())
//      tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
//    if (src.hasAvailabilityExceptions())
//      tgt.setAvailabilityExceptionsElement(String43_50.convertString(src.getAvailabilityExceptionsElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference43_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceEligibilityComponent convertHealthcareServiceEligibilityComponent(org.hl7.fhir.r4b.model.HealthcareService.HealthcareServiceEligibilityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceEligibilityComponent tgt = new org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceEligibilityComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasComment())
      tgt.setCommentElement(MarkDown43_50.convertMarkdown(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.HealthcareService.HealthcareServiceEligibilityComponent convertHealthcareServiceEligibilityComponent(org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceEligibilityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.HealthcareService.HealthcareServiceEligibilityComponent tgt = new org.hl7.fhir.r4b.model.HealthcareService.HealthcareServiceEligibilityComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasComment())
      tgt.setCommentElement(MarkDown43_50.convertMarkdown(src.getCommentElement()));
    return tgt;
  }
//
//  public static org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.r4b.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
//    tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
//      .map(HealthcareService43_50::convertDaysOfWeek)
//      .collect(Collectors.toList()));
//    if (src.hasAllDay())
//      tgt.setAllDayElement(Boolean43_50.convertBoolean(src.getAllDayElement()));
//    if (src.hasAvailableStartTime())
//      tgt.setAvailableStartTimeElement(Time43_50.convertTime(src.getAvailableStartTimeElement()));
//    if (src.hasAvailableEndTime())
//      tgt.setAvailableEndTimeElement(Time43_50.convertTime(src.getAvailableEndTimeElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.r4b.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
//    tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
//      .map(HealthcareService43_50::convertDaysOfWeek)
//      .collect(Collectors.toList()));
//    if (src.hasAllDay())
//      tgt.setAllDayElement(Boolean43_50.convertBoolean(src.getAllDayElement()));
//    if (src.hasAvailableStartTime())
//      tgt.setAvailableStartTimeElement(Time43_50.convertTime(src.getAvailableStartTimeElement()));
//    if (src.hasAvailableEndTime())
//      tgt.setAvailableEndTimeElement(Time43_50.convertTime(src.getAvailableEndTimeElement()));
//    return tgt;
//  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.DaysOfWeekEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.DaysOfWeekEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case MON:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.MON);
        break;
      case TUE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.TUE);
        break;
      case WED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.WED);
        break;
      case THU:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.THU);
        break;
      case FRI:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.FRI);
        break;
      case SAT:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.SAT);
        break;
      case SUN:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.SUN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.NULL);
        break;
    }
    return tgt;
  }
//
//  public static org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.r4b.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
//    if (src.hasDuring())
//      tgt.setDuring(Period43_50.convertPeriod(src.getDuring()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.r5.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.r4b.model.HealthcareService.HealthcareServiceNotAvailableComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
//    if (src.hasDuring())
//      tgt.setDuring(Period43_50.convertPeriod(src.getDuring()));
//    return tgt;
//  }
}