package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.ContactPoint40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Period40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.exceptions.FHIRException;

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
public class PractitionerRole40_50 {

  public static org.hl7.fhir.r5.model.PractitionerRole convertPractitionerRole(org.hl7.fhir.r4.model.PractitionerRole src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.PractitionerRole tgt = new org.hl7.fhir.r5.model.PractitionerRole();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean40_50.convertBoolean(src.getActiveElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
    if (src.hasPractitioner())
      tgt.setPractitioner(Reference40_50.convertReference(src.getPractitioner()));
    if (src.hasOrganization())
      tgt.setOrganization(Reference40_50.convertReference(src.getOrganization()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialty())
      tgt.addSpecialty(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getLocation()) tgt.addLocation(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getHealthcareService())
      tgt.addHealthcareService(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.getContactFirstRep().addTelecom(ContactPoint40_50.convertContactPoint(t));
//    for (org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleAvailableTimeComponent t : src.getAvailableTime())
//      tgt.addAvailableTime(convertPractitionerRoleAvailableTimeComponent(t));
//    for (org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleNotAvailableComponent t : src.getNotAvailable())
//      tgt.addNotAvailable(convertPractitionerRoleNotAvailableComponent(t));
//    if (src.hasAvailabilityExceptions())
//      tgt.setAvailabilityExceptionsElement(String40_50.convertString(src.getAvailabilityExceptionsElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference40_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PractitionerRole convertPractitionerRole(org.hl7.fhir.r5.model.PractitionerRole src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PractitionerRole tgt = new org.hl7.fhir.r4.model.PractitionerRole();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean40_50.convertBoolean(src.getActiveElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
    if (src.hasPractitioner())
      tgt.setPractitioner(Reference40_50.convertReference(src.getPractitioner()));
    if (src.hasOrganization())
      tgt.setOrganization(Reference40_50.convertReference(src.getOrganization()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialty())
      tgt.addSpecialty(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getLocation()) tgt.addLocation(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getHealthcareService())
      tgt.addHealthcareService(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r5.model.ExtendedContactDetail t1 : src.getContact())
      for (org.hl7.fhir.r5.model.ContactPoint t : t1.getTelecom())
        tgt.addTelecom(ContactPoint40_50.convertContactPoint(t));
//    for (org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent t : src.getAvailableTime())
//      tgt.addAvailableTime(convertPractitionerRoleAvailableTimeComponent(t));
//    for (org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleNotAvailableComponent t : src.getNotAvailable())
//      tgt.addNotAvailable(convertPractitionerRoleNotAvailableComponent(t));
//    if (src.hasAvailabilityExceptions())
//      tgt.setAvailabilityExceptionsElement(String40_50.convertString(src.getAvailabilityExceptionsElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference40_50.convertReference(t));
    return tgt;
  }

//  public static org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent convertPractitionerRoleAvailableTimeComponent(org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleAvailableTimeComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent tgt = new org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent();
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
//    tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
//      .map(PractitionerRole40_50::convertDaysOfWeek)
//      .collect(Collectors.toList()));
//    if (src.hasAllDay())
//      tgt.setAllDayElement(Boolean40_50.convertBoolean(src.getAllDayElement()));
//    if (src.hasAvailableStartTime())
//      tgt.setAvailableStartTimeElement(Time40_50.convertTime(src.getAvailableStartTimeElement()));
//    if (src.hasAvailableEndTime())
//      tgt.setAvailableEndTimeElement(Time40_50.convertTime(src.getAvailableEndTimeElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleAvailableTimeComponent convertPractitionerRoleAvailableTimeComponent(org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleAvailableTimeComponent tgt = new org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleAvailableTimeComponent();
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
//    tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
//      .map(PractitionerRole40_50::convertDaysOfWeek)
//      .collect(Collectors.toList()));
//    if (src.hasAllDay())
//      tgt.setAllDayElement(Boolean40_50.convertBoolean(src.getAllDayElement()));
//    if (src.hasAvailableStartTime())
//      tgt.setAvailableStartTimeElement(Time40_50.convertTime(src.getAvailableStartTimeElement()));
//    if (src.hasAvailableEndTime())
//      tgt.setAvailableEndTimeElement(Time40_50.convertTime(src.getAvailableEndTimeElement()));
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeek> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.DaysOfWeekEnumFactory());
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case MON:
//        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.MON);
//        break;
//      case TUE:
//        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.TUE);
//        break;
//      case WED:
//        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.WED);
//        break;
//      case THU:
//        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.THU);
//        break;
//      case FRI:
//        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.FRI);
//        break;
//      case SAT:
//        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.SAT);
//        break;
//      case SUN:
//        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.SUN);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeek> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeekEnumFactory());
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case MON:
//        tgt.setValue(org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeek.MON);
//        break;
//      case TUE:
//        tgt.setValue(org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeek.TUE);
//        break;
//      case WED:
//        tgt.setValue(org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeek.WED);
//        break;
//      case THU:
//        tgt.setValue(org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeek.THU);
//        break;
//      case FRI:
//        tgt.setValue(org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeek.FRI);
//        break;
//      case SAT:
//        tgt.setValue(org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeek.SAT);
//        break;
//      case SUN:
//        tgt.setValue(org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeek.SUN);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r4.model.PractitionerRole.DaysOfWeek.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleNotAvailableComponent convertPractitionerRoleNotAvailableComponent(org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleNotAvailableComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleNotAvailableComponent tgt = new org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleNotAvailableComponent();
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
//    if (src.hasDuring())
//      tgt.setDuring(Period40_50.convertPeriod(src.getDuring()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleNotAvailableComponent convertPractitionerRoleNotAvailableComponent(org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleNotAvailableComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleNotAvailableComponent tgt = new org.hl7.fhir.r4.model.PractitionerRole.PractitionerRoleNotAvailableComponent();
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
//    if (src.hasDuring())
//      tgt.setDuring(Period40_50.convertPeriod(src.getDuring()));
//    return tgt;
//  }
}