package org.hl7.fhir.convertors.conv30_40;


import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Patient;

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
public class Device30_40 extends VersionConvertor_30_40 {

  public static org.hl7.fhir.r4.model.Device convertDevice(org.hl7.fhir.dstu3.model.Device src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Device tgt = new org.hl7.fhir.r4.model.Device();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertFHIRDeviceStatus(src.getStatusElement()));
    if (src.hasManufacturer())
      tgt.setManufacturerElement(convertString(src.getManufacturerElement()));
    if (src.hasManufactureDate())
      tgt.setManufactureDateElement(convertDateTime(src.getManufactureDateElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(convertDateTime(src.getExpirationDateElement()));
    if (src.hasLotNumber())
      tgt.setLotNumberElement(convertString(src.getLotNumberElement()));
    if (src.hasPatient())
      tgt.setPatient(convertReference(src.getPatient()));
    if (src.hasOwner())
      tgt.setOwner(convertReference(src.getOwner()));
    if (src.hasOwnerTarget())
      tgt.setOwnerTarget(Organization30_40.convertOrganization(src.getOwnerTarget()));
    for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getContact()) tgt.addContact(convertContactPoint(t));
    if (src.hasLocation())
      tgt.setLocation(convertReference(src.getLocation()));
    if (src.hasLocationTarget())
      tgt.setLocationTarget(Location30_40.convertLocation(src.getLocationTarget()));
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSafety()) tgt.addSafety(convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Device convertDevice(org.hl7.fhir.r4.model.Device src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Device tgt = new org.hl7.fhir.dstu3.model.Device();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertFHIRDeviceStatus(src.getStatusElement()));
    if (src.hasManufacturer())
      tgt.setManufacturerElement(convertString(src.getManufacturerElement()));
    if (src.hasManufactureDate())
      tgt.setManufactureDateElement(convertDateTime(src.getManufactureDateElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(convertDateTime(src.getExpirationDateElement()));
    if (src.hasLotNumber())
      tgt.setLotNumberElement(convertString(src.getLotNumberElement()));
    if (src.hasPatient())
      tgt.setPatient(convertReference(src.getPatient()));
    if (src.hasOwner())
      tgt.setOwner(convertReference(src.getOwner()));
    if (src.hasOwnerTarget())
      tgt.setOwnerTarget(Organization30_40.convertOrganization(src.getOwnerTarget()));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getContact()) tgt.addContact(convertContactPoint(t));
    if (src.hasLocation())
      tgt.setLocation(convertReference(src.getLocation()));
    if (src.hasLocationTarget())
      tgt.setLocationTarget(Location30_40.convertLocation(src.getLocationTarget()));
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSafety()) tgt.addSafety(convertCodeableConcept(t));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.FHIRDeviceStatus> convertFHIRDeviceStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.FHIRDeviceStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Device.FHIRDeviceStatusEnumFactory());
    VersionConvertor_30_40.copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4.model.Device.FHIRDeviceStatus.ACTIVE);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.r4.model.Device.FHIRDeviceStatus.INACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.Device.FHIRDeviceStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4.model.Device.FHIRDeviceStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Device.FHIRDeviceStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus> convertFHIRDeviceStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.FHIRDeviceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatusEnumFactory());
    VersionConvertor_30_40.copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus.ACTIVE);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus.INACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.UDIEntryType> convertUDIEntryType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Device.UDIEntryType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.UDIEntryType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Device.UDIEntryTypeEnumFactory());
    VersionConvertor_30_40.copyElement(src, tgt);
    switch (src.getValue()) {
      case BARCODE:
        tgt.setValue(org.hl7.fhir.r4.model.Device.UDIEntryType.BARCODE);
        break;
      case RFID:
        tgt.setValue(org.hl7.fhir.r4.model.Device.UDIEntryType.RFID);
        break;
      case MANUAL:
        tgt.setValue(org.hl7.fhir.r4.model.Device.UDIEntryType.MANUAL);
        break;
      case CARD:
        tgt.setValue(org.hl7.fhir.r4.model.Device.UDIEntryType.CARD);
        break;
      case SELFREPORTED:
        tgt.setValue(org.hl7.fhir.r4.model.Device.UDIEntryType.SELFREPORTED);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4.model.Device.UDIEntryType.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Device.UDIEntryType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Device.UDIEntryType> convertUDIEntryType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.UDIEntryType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Device.UDIEntryType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Device.UDIEntryTypeEnumFactory());
    VersionConvertor_30_40.copyElement(src, tgt);
    switch (src.getValue()) {
      case BARCODE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Device.UDIEntryType.BARCODE);
        break;
      case RFID:
        tgt.setValue(org.hl7.fhir.dstu3.model.Device.UDIEntryType.RFID);
        break;
      case MANUAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.Device.UDIEntryType.MANUAL);
        break;
      case CARD:
        tgt.setValue(org.hl7.fhir.dstu3.model.Device.UDIEntryType.CARD);
        break;
      case SELFREPORTED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Device.UDIEntryType.SELFREPORTED);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.dstu3.model.Device.UDIEntryType.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Device.UDIEntryType.NULL);
        break;
    }
    return tgt;
  }
}