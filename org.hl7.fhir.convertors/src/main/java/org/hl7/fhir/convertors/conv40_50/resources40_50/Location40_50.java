package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Address40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Coding40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.ContactPoint40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Decimal40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.ContactPoint;
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
public class Location40_50 {

  public static org.hl7.fhir.r5.model.Location convertLocation(org.hl7.fhir.r4.model.Location src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Location tgt = new org.hl7.fhir.r5.model.Location();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertLocationStatus(src.getStatusElement()));
    if (src.hasOperationalStatus())
      tgt.setOperationalStatus(Coding40_50.convertCoding(src.getOperationalStatus()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getAlias()) tgt.getAlias().add(String40_50.convertString(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasMode())
      tgt.setModeElement(convertLocationMode(src.getModeElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.getContactFirstRep().addTelecom(ContactPoint40_50.convertContactPoint(t));
    if (src.hasAddress())
      tgt.setAddress(Address40_50.convertAddress(src.getAddress()));
    if (src.hasPhysicalType())
      tgt.setForm(CodeableConcept40_50.convertCodeableConcept(src.getPhysicalType()));
    if (src.hasPosition())
      tgt.setPosition(convertLocationPositionComponent(src.getPosition()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference40_50.convertReference(src.getManagingOrganization()));
    if (src.hasPartOf())
      tgt.setPartOf(Reference40_50.convertReference(src.getPartOf()));
//    for (org.hl7.fhir.r4.model.Location.LocationHoursOfOperationComponent t : src.getHoursOfOperation())
//      tgt.addHoursOfOperation(convertLocationHoursOfOperationComponent(t));
//    if (src.hasAvailabilityExceptions())
//      tgt.setAvailabilityExceptionsElement(String40_50.convertString(src.getAvailabilityExceptionsElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference40_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Location convertLocation(org.hl7.fhir.r5.model.Location src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Location tgt = new org.hl7.fhir.r4.model.Location();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertLocationStatus(src.getStatusElement()));
    if (src.hasOperationalStatus())
      tgt.setOperationalStatus(Coding40_50.convertCoding(src.getOperationalStatus()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getAlias()) tgt.getAlias().add(String40_50.convertString(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    if (src.hasMode())
      tgt.setModeElement(convertLocationMode(src.getModeElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept40_50.convertCodeableConcept(t));
    for (ExtendedContactDetail t1 : src.getContact())
      for (ContactPoint t : t1.getTelecom())
        tgt.addTelecom(ContactPoint40_50.convertContactPoint(t));
    if (src.hasAddress())
      tgt.setAddress(Address40_50.convertAddress(src.getAddress()));
    if (src.hasForm())
      tgt.setPhysicalType(CodeableConcept40_50.convertCodeableConcept(src.getForm()));
    if (src.hasPosition())
      tgt.setPosition(convertLocationPositionComponent(src.getPosition()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference40_50.convertReference(src.getManagingOrganization()));
    if (src.hasPartOf())
      tgt.setPartOf(Reference40_50.convertReference(src.getPartOf()));
//    for (org.hl7.fhir.r5.model.Location.LocationHoursOfOperationComponent t : src.getHoursOfOperation())
//      tgt.addHoursOfOperation(convertLocationHoursOfOperationComponent(t));
//    if (src.hasAvailabilityExceptions())
//      tgt.setAvailabilityExceptionsElement(String40_50.convertString(src.getAvailabilityExceptionsElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference40_50.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Location.LocationStatus> convertLocationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Location.LocationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Location.LocationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Location.LocationStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Location.LocationStatus.ACTIVE);
        break;
      case SUSPENDED:
        tgt.setValue(org.hl7.fhir.r5.model.Location.LocationStatus.SUSPENDED);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Location.LocationStatus.INACTIVE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Location.LocationStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Location.LocationStatus> convertLocationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Location.LocationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Location.LocationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Location.LocationStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4.model.Location.LocationStatus.ACTIVE);
        break;
      case SUSPENDED:
        tgt.setValue(org.hl7.fhir.r4.model.Location.LocationStatus.SUSPENDED);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.r4.model.Location.LocationStatus.INACTIVE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Location.LocationStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Location.LocationMode> convertLocationMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Location.LocationMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Location.LocationMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Location.LocationModeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case INSTANCE:
        tgt.setValue(org.hl7.fhir.r5.model.Location.LocationMode.INSTANCE);
        break;
      case KIND:
        tgt.setValue(org.hl7.fhir.r5.model.Location.LocationMode.KIND);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Location.LocationMode.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Location.LocationMode> convertLocationMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Location.LocationMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Location.LocationMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Location.LocationModeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case INSTANCE:
        tgt.setValue(org.hl7.fhir.r4.model.Location.LocationMode.INSTANCE);
        break;
      case KIND:
        tgt.setValue(org.hl7.fhir.r4.model.Location.LocationMode.KIND);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Location.LocationMode.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Location.LocationPositionComponent convertLocationPositionComponent(org.hl7.fhir.r4.model.Location.LocationPositionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Location.LocationPositionComponent tgt = new org.hl7.fhir.r5.model.Location.LocationPositionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasLongitude())
      tgt.setLongitudeElement(Decimal40_50.convertDecimal(src.getLongitudeElement()));
    if (src.hasLatitude())
      tgt.setLatitudeElement(Decimal40_50.convertDecimal(src.getLatitudeElement()));
    if (src.hasAltitude())
      tgt.setAltitudeElement(Decimal40_50.convertDecimal(src.getAltitudeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Location.LocationPositionComponent convertLocationPositionComponent(org.hl7.fhir.r5.model.Location.LocationPositionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Location.LocationPositionComponent tgt = new org.hl7.fhir.r4.model.Location.LocationPositionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasLongitude())
      tgt.setLongitudeElement(Decimal40_50.convertDecimal(src.getLongitudeElement()));
    if (src.hasLatitude())
      tgt.setLatitudeElement(Decimal40_50.convertDecimal(src.getLatitudeElement()));
    if (src.hasAltitude())
      tgt.setAltitudeElement(Decimal40_50.convertDecimal(src.getAltitudeElement()));
    return tgt;
  }
//
//  public static org.hl7.fhir.r5.model.Location.LocationHoursOfOperationComponent convertLocationHoursOfOperationComponent(org.hl7.fhir.r4.model.Location.LocationHoursOfOperationComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.Location.LocationHoursOfOperationComponent tgt = new org.hl7.fhir.r5.model.Location.LocationHoursOfOperationComponent();
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
//    tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
//      .map(Location40_50::convertDaysOfWeek)
//      .collect(Collectors.toList()));
//    if (src.hasAllDay())
//      tgt.setAllDayElement(Boolean40_50.convertBoolean(src.getAllDayElement()));
//    if (src.hasOpeningTime())
//      tgt.setOpeningTimeElement(Time40_50.convertTime(src.getOpeningTimeElement()));
//    if (src.hasClosingTime())
//      tgt.setClosingTimeElement(Time40_50.convertTime(src.getClosingTimeElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.Location.LocationHoursOfOperationComponent convertLocationHoursOfOperationComponent(org.hl7.fhir.r5.model.Location.LocationHoursOfOperationComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.Location.LocationHoursOfOperationComponent tgt = new org.hl7.fhir.r4.model.Location.LocationHoursOfOperationComponent();
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
//    tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
//      .map(Location40_50::convertDaysOfWeek)
//      .collect(Collectors.toList()));
//    if (src.hasAllDay())
//      tgt.setAllDayElement(Boolean40_50.convertBoolean(src.getAllDayElement()));
//    if (src.hasOpeningTime())
//      tgt.setOpeningTimeElement(Time40_50.convertTime(src.getOpeningTimeElement()));
//    if (src.hasClosingTime())
//      tgt.setClosingTimeElement(Time40_50.convertTime(src.getClosingTimeElement()));
//    return tgt;
//  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Location.DaysOfWeek> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.DaysOfWeekEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Location.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Location.DaysOfWeek> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Location.DaysOfWeekEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case MON:
        tgt.setValue(org.hl7.fhir.r4.model.Location.DaysOfWeek.MON);
        break;
      case TUE:
        tgt.setValue(org.hl7.fhir.r4.model.Location.DaysOfWeek.TUE);
        break;
      case WED:
        tgt.setValue(org.hl7.fhir.r4.model.Location.DaysOfWeek.WED);
        break;
      case THU:
        tgt.setValue(org.hl7.fhir.r4.model.Location.DaysOfWeek.THU);
        break;
      case FRI:
        tgt.setValue(org.hl7.fhir.r4.model.Location.DaysOfWeek.FRI);
        break;
      case SAT:
        tgt.setValue(org.hl7.fhir.r4.model.Location.DaysOfWeek.SAT);
        break;
      case SUN:
        tgt.setValue(org.hl7.fhir.r4.model.Location.DaysOfWeek.SUN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Location.DaysOfWeek.NULL);
        break;
    }
    return tgt;
  }
}