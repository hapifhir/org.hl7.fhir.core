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
public class Location40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.Location convertLocation(org.hl7.fhir.r4.model.Location src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Location tgt = new org.hl7.fhir.r5.model.Location();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertLocationStatus(src.getStatusElement()));
        if (src.hasOperationalStatus())
            tgt.setOperationalStatus(convertCoding(src.getOperationalStatus()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        for (org.hl7.fhir.r4.model.StringType t : src.getAlias()) tgt.getAlias().add(convertString(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasMode())
            tgt.setModeElement(convertLocationMode(src.getModeElement()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType()) tgt.addType(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(convertContactPoint(t));
        if (src.hasAddress())
            tgt.setAddress(convertAddress(src.getAddress()));
        if (src.hasPhysicalType())
            tgt.setPhysicalType(convertCodeableConcept(src.getPhysicalType()));
        if (src.hasPosition())
            tgt.setPosition(convertLocationPositionComponent(src.getPosition()));
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(convertReference(src.getManagingOrganization()));
        if (src.hasPartOf())
            tgt.setPartOf(convertReference(src.getPartOf()));
        for (org.hl7.fhir.r4.model.Location.LocationHoursOfOperationComponent t : src.getHoursOfOperation()) tgt.addHoursOfOperation(convertLocationHoursOfOperationComponent(t));
        if (src.hasAvailabilityExceptions())
            tgt.setAvailabilityExceptionsElement(convertString(src.getAvailabilityExceptionsElement()));
        for (org.hl7.fhir.r4.model.Reference t : src.getEndpoint()) tgt.addEndpoint(convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Location convertLocation(org.hl7.fhir.r5.model.Location src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Location tgt = new org.hl7.fhir.r4.model.Location();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertLocationStatus(src.getStatusElement()));
        if (src.hasOperationalStatus())
            tgt.setOperationalStatus(convertCoding(src.getOperationalStatus()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        for (org.hl7.fhir.r5.model.StringType t : src.getAlias()) tgt.getAlias().add(convertString(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasMode())
            tgt.setModeElement(convertLocationMode(src.getModeElement()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType()) tgt.addType(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(convertContactPoint(t));
        if (src.hasAddress())
            tgt.setAddress(convertAddress(src.getAddress()));
        if (src.hasPhysicalType())
            tgt.setPhysicalType(convertCodeableConcept(src.getPhysicalType()));
        if (src.hasPosition())
            tgt.setPosition(convertLocationPositionComponent(src.getPosition()));
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(convertReference(src.getManagingOrganization()));
        if (src.hasPartOf())
            tgt.setPartOf(convertReference(src.getPartOf()));
        for (org.hl7.fhir.r5.model.Location.LocationHoursOfOperationComponent t : src.getHoursOfOperation()) tgt.addHoursOfOperation(convertLocationHoursOfOperationComponent(t));
        if (src.hasAvailabilityExceptions())
            tgt.setAvailabilityExceptionsElement(convertString(src.getAvailabilityExceptionsElement()));
        for (org.hl7.fhir.r5.model.Reference t : src.getEndpoint()) tgt.addEndpoint(convertReference(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Location.LocationStatus> convertLocationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Location.LocationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Location.LocationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Location.LocationStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
        copyElement(src, tgt);
        if (src.hasLongitude())
            tgt.setLongitudeElement(convertDecimal(src.getLongitudeElement()));
        if (src.hasLatitude())
            tgt.setLatitudeElement(convertDecimal(src.getLatitudeElement()));
        if (src.hasAltitude())
            tgt.setAltitudeElement(convertDecimal(src.getAltitudeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Location.LocationPositionComponent convertLocationPositionComponent(org.hl7.fhir.r5.model.Location.LocationPositionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Location.LocationPositionComponent tgt = new org.hl7.fhir.r4.model.Location.LocationPositionComponent();
        copyElement(src, tgt);
        if (src.hasLongitude())
            tgt.setLongitudeElement(convertDecimal(src.getLongitudeElement()));
        if (src.hasLatitude())
            tgt.setLatitudeElement(convertDecimal(src.getLatitudeElement()));
        if (src.hasAltitude())
            tgt.setAltitudeElement(convertDecimal(src.getAltitudeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Location.LocationHoursOfOperationComponent convertLocationHoursOfOperationComponent(org.hl7.fhir.r4.model.Location.LocationHoursOfOperationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Location.LocationHoursOfOperationComponent tgt = new org.hl7.fhir.r5.model.Location.LocationHoursOfOperationComponent();
        copyElement(src, tgt);
        tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
                .map(Location40_50::convertDaysOfWeek)
                .collect(Collectors.toList()));
        if (src.hasAllDay())
            tgt.setAllDayElement(convertBoolean(src.getAllDayElement()));
        if (src.hasOpeningTime())
            tgt.setOpeningTimeElement(convertTime(src.getOpeningTimeElement()));
        if (src.hasClosingTime())
            tgt.setClosingTimeElement(convertTime(src.getClosingTimeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Location.LocationHoursOfOperationComponent convertLocationHoursOfOperationComponent(org.hl7.fhir.r5.model.Location.LocationHoursOfOperationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Location.LocationHoursOfOperationComponent tgt = new org.hl7.fhir.r4.model.Location.LocationHoursOfOperationComponent();
        copyElement(src, tgt);
        tgt.setDaysOfWeek(src.getDaysOfWeek().stream()
                .map(Location40_50::convertDaysOfWeek)
                .collect(Collectors.toList()));
        if (src.hasAllDay())
            tgt.setAllDayElement(convertBoolean(src.getAllDayElement()));
        if (src.hasOpeningTime())
            tgt.setOpeningTimeElement(convertTime(src.getOpeningTimeElement()));
        if (src.hasClosingTime())
            tgt.setClosingTimeElement(convertTime(src.getClosingTimeElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Location.DaysOfWeek> src) throws FHIRException {
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Location.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Location.DaysOfWeek> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Location.DaysOfWeekEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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