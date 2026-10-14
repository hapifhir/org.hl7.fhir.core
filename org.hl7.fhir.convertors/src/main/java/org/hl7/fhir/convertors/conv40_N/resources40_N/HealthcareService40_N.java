package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Attachment40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.ContactPoint40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.MarkDown40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.HealthcareService;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;
import org.hl7.fhir.model.core.ExtendedContactDetail;

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

public class HealthcareService40_N {

  public static org.hl7.fhir.model.core.HealthcareService convertHealthcareService(org.hl7.fhir.r4.model.HealthcareService src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.HealthcareService tgt = new org.hl7.fhir.model.core.HealthcareService();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean40_N.convertBoolean(src.getActiveElement()));
    if (src.hasProvidedBy())
      tgt.setProvidedBy(Reference40_N.convertReference(src.getProvidedBy()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialty())
      tgt.addSpecialty(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getLocation()) tgt.addLocation(Reference40_N.convertReference(t));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasComment())
      tgt.setCommentElement(String40_N.convertStringToMarkdown(src.getCommentElement()));
    if (src.hasExtraDetails())
      tgt.setExtraDetailsElement(MarkDown40_N.convertMarkdown(src.getExtraDetailsElement()));
    if (src.hasPhoto())
      tgt.setPhoto(Attachment40_N.convertAttachment(src.getPhoto()));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.getContactFirstRep().addTelecom(ContactPoint40_N.convertContactPoint(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getCoverageArea())
      tgt.addCoverageArea(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getServiceProvisionCode())
      tgt.addServiceProvisionCode(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceEligibilityComponent t : src.getEligibility())
      tgt.addEligibility(convertHealthcareServiceEligibilityComponent(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProgram())
      tgt.addProgram(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCharacteristic())
      tgt.addCharacteristic(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCommunication())
      tgt.addCommunication(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReferralMethod())
      tgt.addReferralMethod(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasAppointmentRequired())
      tgt.setAppointmentRequiredElement(Boolean40_N.convertBoolean(src.getAppointmentRequiredElement()));
//    for (org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTime())
//      tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
//    for (org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailable())
//      tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
//    if (src.hasAvailabilityExceptions())
//      tgt.setAvailabilityExceptionsElement(String40_N.convertString(src.getAvailabilityExceptionsElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference40_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.HealthcareService convertHealthcareService(org.hl7.fhir.model.core.HealthcareService src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.HealthcareService tgt = new org.hl7.fhir.r4.model.HealthcareService();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean40_N.convertBoolean(src.getActiveElement()));
    if (src.hasProvidedBy())
      tgt.setProvidedBy(Reference40_N.convertReference(src.getProvidedBy()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTypeList())
      tgt.addType(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getSpecialtyList())
      tgt.addSpecialty(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.Reference t : src.getLocationList()) tgt.addLocation(Reference40_N.convertReference(t));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasComment())
      tgt.setCommentElement(String40_N.convertString(src.getCommentElement()));
    if (src.hasExtraDetails())
      tgt.setExtraDetailsElement(MarkDown40_N.convertMarkdown(src.getExtraDetailsElement()));
    if (src.hasPhoto())
      tgt.setPhoto(Attachment40_N.convertAttachment(src.getPhoto()));
    for (ExtendedContactDetail t1 : src.getContactList())
      for (org.hl7.fhir.model.core.ContactPoint t : t1.getTelecomList())
        tgt.addTelecom(ContactPoint40_N.convertContactPoint(t));
    for (org.hl7.fhir.model.core.Reference t : src.getCoverageAreaList())
      tgt.addCoverageArea(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getServiceProvisionCodeList())
      tgt.addServiceProvisionCode(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.HealthcareService.HealthcareServiceEligibilityComponent t : src.getEligibilityList())
      tgt.addEligibility(convertHealthcareServiceEligibilityComponent(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getProgramList())
      tgt.addProgram(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCharacteristicList())
      tgt.addCharacteristic(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCommunicationList())
      tgt.addCommunication(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getReferralMethodList())
      tgt.addReferralMethod(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasAppointmentRequired())
      tgt.setAppointmentRequiredElement(Boolean40_N.convertBoolean(src.getAppointmentRequiredElement()));
//    for (org.hl7.fhir.model.core.HealthcareService.HealthcareServiceAvailableTimeComponent t : src.getAvailableTimeList())
//      tgt.addAvailableTime(convertHealthcareServiceAvailableTimeComponent(t));
//    for (org.hl7.fhir.model.core.HealthcareService.HealthcareServiceNotAvailableComponent t : src.getNotAvailableList())
//      tgt.addNotAvailable(convertHealthcareServiceNotAvailableComponent(t));
//    if (src.hasAvailabilityExceptions())
//      tgt.setAvailabilityExceptionsElement(String40_N.convertString(src.getAvailabilityExceptionsElement()));
    for (org.hl7.fhir.model.core.Reference t : src.getEndpointList()) tgt.addEndpoint(Reference40_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.HealthcareService.HealthcareServiceEligibilityComponent convertHealthcareServiceEligibilityComponent(org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceEligibilityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.HealthcareService.HealthcareServiceEligibilityComponent tgt = new org.hl7.fhir.model.core.HealthcareService.HealthcareServiceEligibilityComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasComment())
      tgt.setCommentElement(MarkDown40_N.convertMarkdown(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceEligibilityComponent convertHealthcareServiceEligibilityComponent(org.hl7.fhir.model.core.HealthcareService.HealthcareServiceEligibilityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceEligibilityComponent tgt = new org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceEligibilityComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasComment())
      tgt.setCommentElement(MarkDown40_N.convertMarkdown(src.getCommentElement()));
    return tgt;
  }

//  public static org.hl7.fhir.model.core.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.core.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.model.core.HealthcareService.HealthcareServiceAvailableTimeComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
//      .map(HealthcareService40_N::convertDaysOfWeek)
//      .collect(Collectors.toList()));
//    if (src.hasAllDay())
//      tgt.setAllDayElement(Boolean40_N.convertBoolean(src.getAllDayElement()));
//    if (src.hasAvailableStartTime())
//      tgt.setAvailableStartTimeElement(Time40_N.convertTime(src.getAvailableStartTimeElement()));
//    if (src.hasAvailableEndTime())
//      tgt.setAvailableEndTimeElement(Time40_N.convertTime(src.getAvailableEndTimeElement()));
//    return tgt;
//  }

//  public static org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent convertHealthcareServiceAvailableTimeComponent(org.hl7.fhir.model.core.HealthcareService.HealthcareServiceAvailableTimeComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent tgt = new org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceAvailableTimeComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
//      .map(HealthcareService40_N::convertDaysOfWeek)
//      .collect(Collectors.toList()));
//    if (src.hasAllDay())
//      tgt.setAllDayElement(Boolean40_N.convertBoolean(src.getAllDayElement()));
//    if (src.hasAvailableStartTime())
//      tgt.setAvailableStartTimeElement(Time40_N.convertTime(src.getAvailableStartTimeElement()));
//    if (src.hasAvailableEndTime())
//      tgt.setAvailableEndTimeElement(Time40_N.convertTime(src.getAvailableEndTimeElement()));
//    return tgt;
//  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.DaysOfWeek> tgt = new Enumeration<>(new Enumerations.DaysOfWeekEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case MON:
                  tgt.setValue(Enumerations.DaysOfWeek.MON);
                  break;
              case TUE:
                  tgt.setValue(Enumerations.DaysOfWeek.TUE);
                  break;
              case WED:
                  tgt.setValue(Enumerations.DaysOfWeek.WED);
                  break;
              case THU:
                  tgt.setValue(Enumerations.DaysOfWeek.THU);
                  break;
              case FRI:
                  tgt.setValue(Enumerations.DaysOfWeek.FRI);
                  break;
              case SAT:
                  tgt.setValue(Enumerations.DaysOfWeek.SAT);
                  break;
              case SUN:
                  tgt.setValue(Enumerations.DaysOfWeek.SUN);
                  break;
              default:
                  tgt.setValue(Enumerations.DaysOfWeek.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HealthcareService.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.DaysOfWeek> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<HealthcareService.DaysOfWeek> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new HealthcareService.DaysOfWeekEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case MON:
                  tgt.setValue(HealthcareService.DaysOfWeek.MON);
                  break;
              case TUE:
                  tgt.setValue(HealthcareService.DaysOfWeek.TUE);
                  break;
              case WED:
                  tgt.setValue(HealthcareService.DaysOfWeek.WED);
                  break;
              case THU:
                  tgt.setValue(HealthcareService.DaysOfWeek.THU);
                  break;
              case FRI:
                  tgt.setValue(HealthcareService.DaysOfWeek.FRI);
                  break;
              case SAT:
                  tgt.setValue(HealthcareService.DaysOfWeek.SAT);
                  break;
              case SUN:
                  tgt.setValue(HealthcareService.DaysOfWeek.SUN);
                  break;
              default:
                  tgt.setValue(HealthcareService.DaysOfWeek.NULL);
                  break;
          }
      }
      return tgt;
  }
//
//  public static org.hl7.fhir.model.core.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.core.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.model.core.HealthcareService.HealthcareServiceNotAvailableComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
//    if (src.hasDuring())
//      tgt.setDuring(Period40_N.convertPeriod(src.getDuring()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent convertHealthcareServiceNotAvailableComponent(org.hl7.fhir.model.core.HealthcareService.HealthcareServiceNotAvailableComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent tgt = new org.hl7.fhir.r4.model.HealthcareService.HealthcareServiceNotAvailableComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
//    if (src.hasDuring())
//      tgt.setDuring(Period40_N.convertPeriod(src.getDuring()));
//    return tgt;
//  }
}