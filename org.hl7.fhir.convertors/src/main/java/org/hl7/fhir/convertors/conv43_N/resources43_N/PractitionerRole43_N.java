package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.ContactPoint43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Period43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
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

public class PractitionerRole43_N {

  public static org.hl7.fhir.model.core.PractitionerRole convertPractitionerRole(org.hl7.fhir.r4b.model.PractitionerRole src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.PractitionerRole tgt = new org.hl7.fhir.model.core.PractitionerRole();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean43_N.convertBoolean(src.getActiveElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    if (src.hasPractitioner())
      tgt.setPractitioner(Reference43_N.convertReference(src.getPractitioner()));
    if (src.hasOrganization())
      tgt.setOrganization(Reference43_N.convertReference(src.getOrganization()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSpecialty())
      tgt.addSpecialty(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getLocation()) tgt.addLocation(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getHealthcareService())
      tgt.addHealthcareService(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.ContactPoint t : src.getTelecom())
      tgt.getContactFirstRep().addTelecom(ContactPoint43_N.convertContactPoint(t));
//    for (org.hl7.fhir.r4b.model.PractitionerRole.PractitionerRoleAvailableTimeComponent t : src.getAvailableTime())
//      tgt.addAvailableTime(convertPractitionerRoleAvailableTimeComponent(t));
//    for (org.hl7.fhir.r4b.model.PractitionerRole.PractitionerRoleNotAvailableComponent t : src.getNotAvailable())
//      tgt.addNotAvailable(convertPractitionerRoleNotAvailableComponent(t));
//    if (src.hasAvailabilityExceptions())
//      tgt.setAvailabilityExceptionsElement(String43_N.convertString(src.getAvailabilityExceptionsElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference43_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.PractitionerRole convertPractitionerRole(org.hl7.fhir.model.core.PractitionerRole src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.PractitionerRole tgt = new org.hl7.fhir.r4b.model.PractitionerRole();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean43_N.convertBoolean(src.getActiveElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    if (src.hasPractitioner())
      tgt.setPractitioner(Reference43_N.convertReference(src.getPractitioner()));
    if (src.hasOrganization())
      tgt.setOrganization(Reference43_N.convertReference(src.getOrganization()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCodeList())
      tgt.addCode(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getSpecialtyList())
      tgt.addSpecialty(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.Reference t : src.getLocationList()) tgt.addLocation(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getHealthcareServiceList())
      tgt.addHealthcareService(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.ExtendedContactDetail t1 : src.getContactList())
      for (org.hl7.fhir.model.core.ContactPoint t : t1.getTelecomList())
        tgt.addTelecom(ContactPoint43_N.convertContactPoint(t));
//    for (org.hl7.fhir.model.core.PractitionerRole.PractitionerRoleAvailableTimeComponent t : src.getAvailableTimeList())
//      tgt.addAvailableTime(convertPractitionerRoleAvailableTimeComponent(t));
//    for (org.hl7.fhir.model.core.PractitionerRole.PractitionerRoleNotAvailableComponent t : src.getNotAvailableList())
//      tgt.addNotAvailable(convertPractitionerRoleNotAvailableComponent(t));
//    if (src.hasAvailabilityExceptions())
//      tgt.setAvailabilityExceptionsElement(String43_N.convertString(src.getAvailabilityExceptionsElement()));
    for (org.hl7.fhir.model.core.Reference t : src.getEndpointList()) tgt.addEndpoint(Reference43_N.convertReference(t));
    return tgt;
  }

//  public static org.hl7.fhir.model.core.PractitionerRole.PractitionerRoleAvailableTimeComponent convertPractitionerRoleAvailableTimeComponent(org.hl7.fhir.r4b.model.PractitionerRole.PractitionerRoleAvailableTimeComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.core.PractitionerRole.PractitionerRoleAvailableTimeComponent tgt = new org.hl7.fhir.model.core.PractitionerRole.PractitionerRoleAvailableTimeComponent();
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
//    tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
//      .map(PractitionerRole43_N::convertDaysOfWeek)
//      .collect(Collectors.toList()));
//    if (src.hasAllDay())
//      tgt.setAllDayElement(Boolean43_N.convertBoolean(src.getAllDayElement()));
//    if (src.hasAvailableStartTime())
//      tgt.setAvailableStartTimeElement(Time43_N.convertTime(src.getAvailableStartTimeElement()));
//    if (src.hasAvailableEndTime())
//      tgt.setAvailableEndTimeElement(Time43_N.convertTime(src.getAvailableEndTimeElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.PractitionerRole.PractitionerRoleAvailableTimeComponent convertPractitionerRoleAvailableTimeComponent(org.hl7.fhir.model.core.PractitionerRole.PractitionerRoleAvailableTimeComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.PractitionerRole.PractitionerRoleAvailableTimeComponent tgt = new org.hl7.fhir.r4b.model.PractitionerRole.PractitionerRoleAvailableTimeComponent();
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
//    tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
//      .map(PractitionerRole43_N::convertDaysOfWeek)
//      .collect(Collectors.toList()));
//    if (src.hasAllDay())
//      tgt.setAllDayElement(Boolean43_N.convertBoolean(src.getAllDayElement()));
//    if (src.hasAvailableStartTime())
//      tgt.setAvailableStartTimeElement(Time43_N.convertTime(src.getAvailableStartTimeElement()));
//    if (src.hasAvailableEndTime())
//      tgt.setAvailableEndTimeElement(Time43_N.convertTime(src.getAvailableEndTimeElement()));
//    return tgt;
//  }
//
//  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.PractitionerRole.DaysOfWeek> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.DaysOfWeek> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.DaysOfWeekEnumFactory());
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case MON:
//        tgt.setValue(org.hl7.fhir.model.core.Enumerations.DaysOfWeek.MON);
//        break;
//      case TUE:
//        tgt.setValue(org.hl7.fhir.model.core.Enumerations.DaysOfWeek.TUE);
//        break;
//      case WED:
//        tgt.setValue(org.hl7.fhir.model.core.Enumerations.DaysOfWeek.WED);
//        break;
//      case THU:
//        tgt.setValue(org.hl7.fhir.model.core.Enumerations.DaysOfWeek.THU);
//        break;
//      case FRI:
//        tgt.setValue(org.hl7.fhir.model.core.Enumerations.DaysOfWeek.FRI);
//        break;
//      case SAT:
//        tgt.setValue(org.hl7.fhir.model.core.Enumerations.DaysOfWeek.SAT);
//        break;
//      case SUN:
//        tgt.setValue(org.hl7.fhir.model.core.Enumerations.DaysOfWeek.SUN);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.model.core.Enumerations.DaysOfWeek.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.PractitionerRole.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.DaysOfWeek> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.PractitionerRole.DaysOfWeek> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.PractitionerRole.DaysOfWeekEnumFactory());
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case MON:
//        tgt.setValue(org.hl7.fhir.r4b.model.PractitionerRole.DaysOfWeek.MON);
//        break;
//      case TUE:
//        tgt.setValue(org.hl7.fhir.r4b.model.PractitionerRole.DaysOfWeek.TUE);
//        break;
//      case WED:
//        tgt.setValue(org.hl7.fhir.r4b.model.PractitionerRole.DaysOfWeek.WED);
//        break;
//      case THU:
//        tgt.setValue(org.hl7.fhir.r4b.model.PractitionerRole.DaysOfWeek.THU);
//        break;
//      case FRI:
//        tgt.setValue(org.hl7.fhir.r4b.model.PractitionerRole.DaysOfWeek.FRI);
//        break;
//      case SAT:
//        tgt.setValue(org.hl7.fhir.r4b.model.PractitionerRole.DaysOfWeek.SAT);
//        break;
//      case SUN:
//        tgt.setValue(org.hl7.fhir.r4b.model.PractitionerRole.DaysOfWeek.SUN);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r4b.model.PractitionerRole.DaysOfWeek.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  public static org.hl7.fhir.model.core.PractitionerRole.PractitionerRoleNotAvailableComponent convertPractitionerRoleNotAvailableComponent(org.hl7.fhir.r4b.model.PractitionerRole.PractitionerRoleNotAvailableComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.core.PractitionerRole.PractitionerRoleNotAvailableComponent tgt = new org.hl7.fhir.model.core.PractitionerRole.PractitionerRoleNotAvailableComponent();
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
//    if (src.hasDuring())
//      tgt.setDuring(Period43_N.convertPeriod(src.getDuring()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.PractitionerRole.PractitionerRoleNotAvailableComponent convertPractitionerRoleNotAvailableComponent(org.hl7.fhir.model.core.PractitionerRole.PractitionerRoleNotAvailableComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.PractitionerRole.PractitionerRoleNotAvailableComponent tgt = new org.hl7.fhir.r4b.model.PractitionerRole.PractitionerRoleNotAvailableComponent();
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
//    if (src.hasDuring())
//      tgt.setDuring(Period43_N.convertPeriod(src.getDuring()));
//    return tgt;
//  }
}