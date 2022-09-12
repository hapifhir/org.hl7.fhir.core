package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.ContactPoint43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
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
public class PractitionerRole43_50 {

  public static org.hl7.fhir.r5.model.PractitionerRole convertPractitionerRole(org.hl7.fhir.r4b.model.PractitionerRole src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.PractitionerRole tgt = new org.hl7.fhir.r5.model.PractitionerRole();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean43_50.convertBoolean(src.getActiveElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    if (src.hasPractitioner())
      tgt.setPractitioner(Reference43_50.convertReference(src.getPractitioner()));
    if (src.hasOrganization())
      tgt.setOrganization(Reference43_50.convertReference(src.getOrganization()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSpecialty())
      tgt.addSpecialty(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getLocation()) tgt.addLocation(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getHealthcareService())
      tgt.addHealthcareService(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.ContactPoint t : src.getTelecom())
      tgt.getContactFirstRep().addTelecom(ContactPoint43_50.convertContactPoint(t));
//    for (org.hl7.fhir.r4b.model.PractitionerRole.PractitionerRoleAvailableTimeComponent t : src.getAvailableTime())
//      tgt.addAvailableTime(convertPractitionerRoleAvailableTimeComponent(t));
//    for (org.hl7.fhir.r4b.model.PractitionerRole.PractitionerRoleNotAvailableComponent t : src.getNotAvailable())
//      tgt.addNotAvailable(convertPractitionerRoleNotAvailableComponent(t));
//    if (src.hasAvailabilityExceptions())
//      tgt.setAvailabilityExceptionsElement(String43_50.convertString(src.getAvailabilityExceptionsElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference43_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.PractitionerRole convertPractitionerRole(org.hl7.fhir.r5.model.PractitionerRole src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.PractitionerRole tgt = new org.hl7.fhir.r4b.model.PractitionerRole();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean43_50.convertBoolean(src.getActiveElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    if (src.hasPractitioner())
      tgt.setPractitioner(Reference43_50.convertReference(src.getPractitioner()));
    if (src.hasOrganization())
      tgt.setOrganization(Reference43_50.convertReference(src.getOrganization()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialty())
      tgt.addSpecialty(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getLocation()) tgt.addLocation(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getHealthcareService())
      tgt.addHealthcareService(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.ExtendedContactDetail t1 : src.getContact())
      for (org.hl7.fhir.r5.model.ContactPoint t : t1.getTelecom())
        tgt.addTelecom(ContactPoint43_50.convertContactPoint(t));
//    for (org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent t : src.getAvailableTime())
//      tgt.addAvailableTime(convertPractitionerRoleAvailableTimeComponent(t));
//    for (org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleNotAvailableComponent t : src.getNotAvailable())
//      tgt.addNotAvailable(convertPractitionerRoleNotAvailableComponent(t));
//    if (src.hasAvailabilityExceptions())
//      tgt.setAvailabilityExceptionsElement(String43_50.convertString(src.getAvailabilityExceptionsElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference43_50.convertReference(t));
    return tgt;
  }

//  public static org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent convertPractitionerRoleAvailableTimeComponent(org.hl7.fhir.r4b.model.PractitionerRole.PractitionerRoleAvailableTimeComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent tgt = new org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
//    tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
//      .map(PractitionerRole43_50::convertDaysOfWeek)
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
//  public static org.hl7.fhir.r4b.model.PractitionerRole.PractitionerRoleAvailableTimeComponent convertPractitionerRoleAvailableTimeComponent(org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleAvailableTimeComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.PractitionerRole.PractitionerRoleAvailableTimeComponent tgt = new org.hl7.fhir.r4b.model.PractitionerRole.PractitionerRoleAvailableTimeComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
//    tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
//      .map(PractitionerRole43_50::convertDaysOfWeek)
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
//  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.DaysOfWeekEnumFactory());
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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
//  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.DaysOfWeekEnumFactory());
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case MON:
//        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.MON);
//        break;
//      case TUE:
//        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.TUE);
//        break;
//      case WED:
//        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.WED);
//        break;
//      case THU:
//        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.THU);
//        break;
//      case FRI:
//        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.FRI);
//        break;
//      case SAT:
//        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.SAT);
//        break;
//      case SUN:
//        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.SUN);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleNotAvailableComponent convertPractitionerRoleNotAvailableComponent(org.hl7.fhir.r4b.model.PractitionerRole.PractitionerRoleNotAvailableComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleNotAvailableComponent tgt = new org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleNotAvailableComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
//    if (src.hasDuring())
//      tgt.setDuring(Period43_50.convertPeriod(src.getDuring()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.PractitionerRole.PractitionerRoleNotAvailableComponent convertPractitionerRoleNotAvailableComponent(org.hl7.fhir.r5.model.PractitionerRole.PractitionerRoleNotAvailableComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.PractitionerRole.PractitionerRoleNotAvailableComponent tgt = new org.hl7.fhir.r4b.model.PractitionerRole.PractitionerRoleNotAvailableComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
//    if (src.hasDuring())
//      tgt.setDuring(Period43_50.convertPeriod(src.getDuring()));
//    return tgt;
//  }
}