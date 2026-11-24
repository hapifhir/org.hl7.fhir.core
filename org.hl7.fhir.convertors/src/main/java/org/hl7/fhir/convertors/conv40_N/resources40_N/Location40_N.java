package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionDatatype40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Availability40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.ExtendedContactDetail40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Address40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Coding40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.ContactPoint40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Decimal40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.*;

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

public class Location40_N {

  // R6 hoursOfOperation is an Availability: R4 hoursOfOperation maps to its availableTime, and the rest are cross-version extensions
  public static final String AVAILABILITY_EXCEPTIONS_EXTENSION_URL = "http://hl7.org/fhir/4.0/StructureDefinition/extension-Location.availabilityExceptions";
  public static final String HOURS_PERIOD_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Location.hoursOfOperation.period";
  public static final String HOURS_NOT_AVAILABLE_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Location.hoursOfOperation.notAvailableTime";

  public static final String CONTACT_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Location.contact";

  public static org.hl7.fhir.model.core.Location convertLocation(org.hl7.fhir.r4.model.Location src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Location tgt = new org.hl7.fhir.model.core.Location();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("Location", "5.0", new String[] {"characteristic", "virtualService"}, CrossVersionElements40_N.urls("Location", "6.0", new String[] {"code"}, CONTACT_EXTENSION_URL, AVAILABILITY_EXCEPTIONS_EXTENSION_URL, HOURS_PERIOD_EXTENSION_URL, HOURS_NOT_AVAILABLE_EXTENSION_URL)));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "characteristic", "virtualService");
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "code");
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR6Code(src.getStatusElement(), convertLocationStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasOperationalStatus())
      tgt.setOperationalStatus(Coding40_N.convertCoding(src.getOperationalStatus()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getAlias()) tgt.getAliasList().add(String40_N.convertString(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasMode())
      tgt.setModeElement(CrossVersionElements40_N.toR6Code(src.getModeElement(), convertLocationMode(src.getModeElement()), src.fhirType(), "mode"));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept40_N.convertCodeableConcept(t));
    ExtendedContactDetail40_N.convertContacts(src.getTelecom(), src.getExtension(), CONTACT_EXTENSION_URL, tgt::addContact);
    if (src.hasAddress())
      tgt.setAddress(Address40_N.convertAddress(src.getAddress()));
    if (src.hasPhysicalType())
      tgt.setForm(CodeableConcept40_N.convertCodeableConcept(src.getPhysicalType()));
    if (src.hasPosition())
      tgt.setPosition(convertLocationPositionComponent(src.getPosition()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference40_N.convertReference(src.getManagingOrganization()));
    if (src.hasPartOf())
      tgt.setPartOf(Reference40_N.convertReference(src.getPartOf()));
    for (org.hl7.fhir.r4.model.Location.LocationHoursOfOperationComponent t : src.getHoursOfOperation())
      tgt.getHoursOfOperation().addAvailableTime(Availability40_N.convertAvailableTime(t, "openingTime", "closingTime"));
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(HOURS_NOT_AVAILABLE_EXTENSION_URL))
      CrossVersionDatatype40_N.populateDatatype(ext, tgt.getHoursOfOperation().addNotAvailableTime());
    if (src.hasExtension(HOURS_PERIOD_EXTENSION_URL))
      tgt.getHoursOfOperation().setPeriod(Period40_N.convertPeriod((org.hl7.fhir.r4.model.Period) src.getExtensionByUrl(HOURS_PERIOD_EXTENSION_URL).getValue()));
    if (src.hasAvailabilityExceptions())
      tgt.addExtension(AVAILABILITY_EXCEPTIONS_EXTENSION_URL, String40_N.convertString(src.getAvailabilityExceptionsElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference40_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Location convertLocation(org.hl7.fhir.model.core.Location src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Location tgt = new org.hl7.fhir.r4.model.Location();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, AVAILABILITY_EXCEPTIONS_EXTENSION_URL);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "characteristic", "virtualService");
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", "code");
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR4Code(src.getStatusElement(), convertLocationStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasOperationalStatus())
      tgt.setOperationalStatus(Coding40_N.convertCoding(src.getOperationalStatus()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    for (org.hl7.fhir.model.core.StringType t : src.getAliasList()) tgt.getAlias().add(String40_N.convertString(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasMode())
      tgt.setModeElement(CrossVersionElements40_N.toR4Code(src.getModeElement(), convertLocationMode(src.getModeElement()), src.fhirType(), "mode"));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTypeList())
      tgt.addType(CodeableConcept40_N.convertCodeableConcept(t));
    ExtendedContactDetail40_N.convertContacts(src.getContactList(), tgt.getTelecom(), tgt.getExtension(), CONTACT_EXTENSION_URL);
    if (src.hasAddress())
      tgt.setAddress(Address40_N.convertAddress(src.getAddress()));
    if (src.hasForm())
      tgt.setPhysicalType(CodeableConcept40_N.convertCodeableConcept(src.getForm()));
    if (src.hasPosition())
      tgt.setPosition(convertLocationPositionComponent(src.getPosition()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference40_N.convertReference(src.getManagingOrganization()));
    if (src.hasPartOf())
      tgt.setPartOf(Reference40_N.convertReference(src.getPartOf()));
    if (src.hasHoursOfOperation()) {
      for (org.hl7.fhir.model.core.Availability.AvailabilityAvailableTimeComponent t : src.getHoursOfOperation().getAvailableTimeList())
        Availability40_N.convertAvailableTime(t, tgt.addHoursOfOperation(), "openingTime", "closingTime");
      // R4 Location has nothing for times it's not available
      for (org.hl7.fhir.model.core.Availability.AvailabilityNotAvailableTimeComponent t : src.getHoursOfOperation().getNotAvailableTimeList())
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(HOURS_NOT_AVAILABLE_EXTENSION_URL, t));
      if (src.getHoursOfOperation().hasPeriod())
        tgt.addExtension(HOURS_PERIOD_EXTENSION_URL, Period40_N.convertPeriod(src.getHoursOfOperation().getPeriod()));
    }
    if (src.hasExtension(AVAILABILITY_EXCEPTIONS_EXTENSION_URL))
      tgt.setAvailabilityExceptionsElement(String40_N.convertString((org.hl7.fhir.model.core.StringType) src.getExtensionByUrl(AVAILABILITY_EXCEPTIONS_EXTENSION_URL).getValue()));
    for (org.hl7.fhir.model.core.Reference t : src.getEndpointList()) tgt.addEndpoint(Reference40_N.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Location.LocationStatus> convertLocationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Location.LocationStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Location.LocationStatus> tgt = new Enumeration<>(new Location.LocationStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(Location.LocationStatus.ACTIVE);
                  break;
              case SUSPENDED:
                  tgt.setValue(Location.LocationStatus.SUSPENDED);
                  break;
              case INACTIVE:
                  tgt.setValue(Location.LocationStatus.INACTIVE);
                  break;
              default:
                  tgt.setValue(Location.LocationStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Location.LocationStatus> convertLocationStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Location.LocationStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Location.LocationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Location.LocationStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Location.LocationMode> convertLocationMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Location.LocationMode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Location.LocationMode> tgt = new Enumeration<>(new Location.LocationModeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case INSTANCE:
                  tgt.setValue(Location.LocationMode.INSTANCE);
                  break;
              case KIND:
                  tgt.setValue(Location.LocationMode.KIND);
                  break;
              default:
                  tgt.setValue(Location.LocationMode.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Location.LocationMode> convertLocationMode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Location.LocationMode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Location.LocationMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Location.LocationModeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Location.LocationPositionComponent convertLocationPositionComponent(org.hl7.fhir.r4.model.Location.LocationPositionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Location.LocationPositionComponent tgt = new org.hl7.fhir.model.core.Location.LocationPositionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasLongitude())
      tgt.setLongitudeElement(Decimal40_N.convertDecimal(src.getLongitudeElement()));
    if (src.hasLatitude())
      tgt.setLatitudeElement(Decimal40_N.convertDecimal(src.getLatitudeElement()));
    if (src.hasAltitude())
      tgt.setAltitudeElement(Decimal40_N.convertDecimal(src.getAltitudeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Location.LocationPositionComponent convertLocationPositionComponent(org.hl7.fhir.model.core.Location.LocationPositionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Location.LocationPositionComponent tgt = new org.hl7.fhir.r4.model.Location.LocationPositionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasLongitude())
      tgt.setLongitudeElement(Decimal40_N.convertDecimal(src.getLongitudeElement()));
    if (src.hasLatitude())
      tgt.setLatitudeElement(Decimal40_N.convertDecimal(src.getLatitudeElement()));
    if (src.hasAltitude())
      tgt.setAltitudeElement(Decimal40_N.convertDecimal(src.getAltitudeElement()));
    return tgt;
  }
//
//  public static org.hl7.fhir.model.core.Location.LocationHoursOfOperationComponent convertLocationHoursOfOperationComponent(org.hl7.fhir.r4.model.Location.LocationHoursOfOperationComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.core.Location.LocationHoursOfOperationComponent tgt = new org.hl7.fhir.model.core.Location.LocationHoursOfOperationComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
//      .map(Location40_N::convertDaysOfWeek)
//      .collect(Collectors.toList()));
//    if (src.hasAllDay())
//      tgt.setAllDayElement(Boolean40_N.convertBoolean(src.getAllDayElement()));
//    if (src.hasOpeningTime())
//      tgt.setOpeningTimeElement(Time40_N.convertTime(src.getOpeningTimeElement()));
//    if (src.hasClosingTime())
//      tgt.setClosingTimeElement(Time40_N.convertTime(src.getClosingTimeElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.Location.LocationHoursOfOperationComponent convertLocationHoursOfOperationComponent(org.hl7.fhir.model.core.Location.LocationHoursOfOperationComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.Location.LocationHoursOfOperationComponent tgt = new org.hl7.fhir.r4.model.Location.LocationHoursOfOperationComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
//      .map(Location40_N::convertDaysOfWeek)
//      .collect(Collectors.toList()));
//    if (src.hasAllDay())
//      tgt.setAllDayElement(Boolean40_N.convertBoolean(src.getAllDayElement()));
//    if (src.hasOpeningTime())
//      tgt.setOpeningTimeElement(Time40_N.convertTime(src.getOpeningTimeElement()));
//    if (src.hasClosingTime())
//      tgt.setClosingTimeElement(Time40_N.convertTime(src.getClosingTimeElement()));
//    return tgt;
//  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Location.DaysOfWeek> src) throws FHIRException {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Location.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.DaysOfWeek> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Location.DaysOfWeek> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Location.DaysOfWeekEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }
}