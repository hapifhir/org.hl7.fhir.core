package org.hl7.fhir.convertors.conv40_50;

import org.hl7.fhir.exceptions.FHIRException;

import org.hl7.fhir.convertors.VersionConvertor_40_50;


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


public class Device extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.Device convertDevice(org.hl7.fhir.r4.model.Device src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Device tgt = new org.hl7.fhir.r5.model.Device();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasDefinition())
      tgt.setDefinition(convertReference(src.getDefinition()));
    for (org.hl7.fhir.r4.model.Device.DeviceUdiCarrierComponent t : src.getUdiCarrier())
      tgt.addUdiCarrier(convertDeviceUdiCarrierComponent(t));
    if (src.hasStatus())
      tgt.setStatus(convertFHIRDeviceStatus(src.getStatus()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getStatusReason())
      tgt.addStatusReason(convertCodeableConcept(t));
    if (src.hasDistinctIdentifier())
      tgt.setDistinctIdentifierElement(convertString(src.getDistinctIdentifierElement()));
    if (src.hasManufacturer())
      tgt.setManufacturerElement(convertString(src.getManufacturerElement()));
    if (src.hasManufactureDate())
      tgt.setManufactureDateElement(convertDateTime(src.getManufactureDateElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(convertDateTime(src.getExpirationDateElement()));
    if (src.hasLotNumber())
      tgt.setLotNumberElement(convertString(src.getLotNumberElement()));
    if (src.hasSerialNumber())
      tgt.setSerialNumberElement(convertString(src.getSerialNumberElement()));
    for (org.hl7.fhir.r4.model.Device.DeviceDeviceNameComponent t : src.getDeviceName())
      tgt.addDeviceName(convertDeviceDeviceNameComponent(t));
    if (src.hasModelNumber())
      tgt.setModelNumberElement(convertString(src.getModelNumberElement()));
    if (src.hasPartNumber())
      tgt.setPartNumberElement(convertString(src.getPartNumberElement()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4.model.Device.DeviceSpecializationComponent t : src.getSpecialization())
      tgt.addSpecialization(convertDeviceSpecializationComponent(t));
    for (org.hl7.fhir.r4.model.Device.DeviceVersionComponent t : src.getVersion())
      tgt.addVersion(convertDeviceVersionComponent(t));
    for (org.hl7.fhir.r4.model.Device.DevicePropertyComponent t : src.getProperty())
      tgt.addProperty(convertDevicePropertyComponent(t));
    if (src.hasPatient())
      tgt.setPatient(convertReference(src.getPatient()));
    if (src.hasOwner())
      tgt.setOwner(convertReference(src.getOwner()));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getContact())
      tgt.addContact(convertContactPoint(t));
    if (src.hasLocation())
      tgt.setLocation(convertReference(src.getLocation()));
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSafety())
      tgt.addSafety(convertCodeableConcept(t));
    if (src.hasParent())
      tgt.setParent(convertReference(src.getParent()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Device convertDevice(org.hl7.fhir.r5.model.Device src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Device tgt = new org.hl7.fhir.r4.model.Device();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasDefinition())
      tgt.setDefinition(convertReference(src.getDefinition()));
    for (org.hl7.fhir.r5.model.Device.DeviceUdiCarrierComponent t : src.getUdiCarrier())
      tgt.addUdiCarrier(convertDeviceUdiCarrierComponent(t));
    if (src.hasStatus())
      tgt.setStatus(convertFHIRDeviceStatus(src.getStatus()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getStatusReason())
      tgt.addStatusReason(convertCodeableConcept(t));
    if (src.hasDistinctIdentifier())
      tgt.setDistinctIdentifierElement(convertString(src.getDistinctIdentifierElement()));
    if (src.hasManufacturer())
      tgt.setManufacturerElement(convertString(src.getManufacturerElement()));
    if (src.hasManufactureDate())
      tgt.setManufactureDateElement(convertDateTime(src.getManufactureDateElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(convertDateTime(src.getExpirationDateElement()));
    if (src.hasLotNumber())
      tgt.setLotNumberElement(convertString(src.getLotNumberElement()));
    if (src.hasSerialNumber())
      tgt.setSerialNumberElement(convertString(src.getSerialNumberElement()));
    for (org.hl7.fhir.r5.model.Device.DeviceDeviceNameComponent t : src.getDeviceName())
      tgt.addDeviceName(convertDeviceDeviceNameComponent(t));
    if (src.hasModelNumber())
      tgt.setModelNumberElement(convertString(src.getModelNumberElement()));
    if (src.hasPartNumber())
      tgt.setPartNumberElement(convertString(src.getPartNumberElement()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r5.model.Device.DeviceSpecializationComponent t : src.getSpecialization())
      tgt.addSpecialization(convertDeviceSpecializationComponent(t));
    for (org.hl7.fhir.r5.model.Device.DeviceVersionComponent t : src.getVersion())
      tgt.addVersion(convertDeviceVersionComponent(t));
    for (org.hl7.fhir.r5.model.Device.DevicePropertyComponent t : src.getProperty())
      tgt.addProperty(convertDevicePropertyComponent(t));
    if (src.hasPatient())
      tgt.setPatient(convertReference(src.getPatient()));
    if (src.hasOwner())
      tgt.setOwner(convertReference(src.getOwner()));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getContact())
      tgt.addContact(convertContactPoint(t));
    if (src.hasLocation())
      tgt.setLocation(convertReference(src.getLocation()));
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSafety())
      tgt.addSafety(convertCodeableConcept(t));
    if (src.hasParent())
      tgt.setParent(convertReference(src.getParent()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Device.FHIRDeviceStatus convertFHIRDeviceStatus(org.hl7.fhir.r4.model.Device.FHIRDeviceStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ACTIVE: return org.hl7.fhir.r5.model.Device.FHIRDeviceStatus.ACTIVE;
    case INACTIVE: return org.hl7.fhir.r5.model.Device.FHIRDeviceStatus.INACTIVE;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.Device.FHIRDeviceStatus.ENTEREDINERROR;
    case UNKNOWN: return org.hl7.fhir.r5.model.Device.FHIRDeviceStatus.UNKNOWN;
    default: return org.hl7.fhir.r5.model.Device.FHIRDeviceStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Device.FHIRDeviceStatus convertFHIRDeviceStatus(org.hl7.fhir.r5.model.Device.FHIRDeviceStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ACTIVE: return org.hl7.fhir.r4.model.Device.FHIRDeviceStatus.ACTIVE;
    case INACTIVE: return org.hl7.fhir.r4.model.Device.FHIRDeviceStatus.INACTIVE;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.Device.FHIRDeviceStatus.ENTEREDINERROR;
    case UNKNOWN: return org.hl7.fhir.r4.model.Device.FHIRDeviceStatus.UNKNOWN;
    default: return org.hl7.fhir.r4.model.Device.FHIRDeviceStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Device.DeviceUdiCarrierComponent convertDeviceUdiCarrierComponent(org.hl7.fhir.r4.model.Device.DeviceUdiCarrierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Device.DeviceUdiCarrierComponent tgt = new org.hl7.fhir.r5.model.Device.DeviceUdiCarrierComponent();
    copyElement(src, tgt);
    if (src.hasDeviceIdentifier())
      tgt.setDeviceIdentifierElement(convertString(src.getDeviceIdentifierElement()));
    if (src.hasIssuer())
      tgt.setIssuerElement(convertUri(src.getIssuerElement()));
    if (src.hasJurisdiction())
      tgt.setJurisdictionElement(convertUri(src.getJurisdictionElement()));
    if (src.hasCarrierAIDC())
      tgt.setCarrierAIDCElement(convertBase64Binary(src.getCarrierAIDCElement()));
    if (src.hasCarrierHRF())
      tgt.setCarrierHRFElement(convertString(src.getCarrierHRFElement()));
    if (src.hasEntryType())
      tgt.setEntryType(convertUDIEntryType(src.getEntryType()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Device.DeviceUdiCarrierComponent convertDeviceUdiCarrierComponent(org.hl7.fhir.r5.model.Device.DeviceUdiCarrierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Device.DeviceUdiCarrierComponent tgt = new org.hl7.fhir.r4.model.Device.DeviceUdiCarrierComponent();
    copyElement(src, tgt);
    if (src.hasDeviceIdentifier())
      tgt.setDeviceIdentifierElement(convertString(src.getDeviceIdentifierElement()));
    if (src.hasIssuer())
      tgt.setIssuerElement(convertUri(src.getIssuerElement()));
    if (src.hasJurisdiction())
      tgt.setJurisdictionElement(convertUri(src.getJurisdictionElement()));
    if (src.hasCarrierAIDC())
      tgt.setCarrierAIDCElement(convertBase64Binary(src.getCarrierAIDCElement()));
    if (src.hasCarrierHRF())
      tgt.setCarrierHRFElement(convertString(src.getCarrierHRFElement()));
    if (src.hasEntryType())
      tgt.setEntryType(convertUDIEntryType(src.getEntryType()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Device.UDIEntryType convertUDIEntryType(org.hl7.fhir.r4.model.Device.UDIEntryType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case BARCODE: return org.hl7.fhir.r5.model.Device.UDIEntryType.BARCODE;
    case RFID: return org.hl7.fhir.r5.model.Device.UDIEntryType.RFID;
    case MANUAL: return org.hl7.fhir.r5.model.Device.UDIEntryType.MANUAL;
    case CARD: return org.hl7.fhir.r5.model.Device.UDIEntryType.CARD;
    case SELFREPORTED: return org.hl7.fhir.r5.model.Device.UDIEntryType.SELFREPORTED;
    case UNKNOWN: return org.hl7.fhir.r5.model.Device.UDIEntryType.UNKNOWN;
    default: return org.hl7.fhir.r5.model.Device.UDIEntryType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Device.UDIEntryType convertUDIEntryType(org.hl7.fhir.r5.model.Device.UDIEntryType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case BARCODE: return org.hl7.fhir.r4.model.Device.UDIEntryType.BARCODE;
    case RFID: return org.hl7.fhir.r4.model.Device.UDIEntryType.RFID;
    case MANUAL: return org.hl7.fhir.r4.model.Device.UDIEntryType.MANUAL;
    case CARD: return org.hl7.fhir.r4.model.Device.UDIEntryType.CARD;
    case SELFREPORTED: return org.hl7.fhir.r4.model.Device.UDIEntryType.SELFREPORTED;
    case UNKNOWN: return org.hl7.fhir.r4.model.Device.UDIEntryType.UNKNOWN;
    default: return org.hl7.fhir.r4.model.Device.UDIEntryType.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Device.DeviceDeviceNameComponent convertDeviceDeviceNameComponent(org.hl7.fhir.r4.model.Device.DeviceDeviceNameComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Device.DeviceDeviceNameComponent tgt = new org.hl7.fhir.r5.model.Device.DeviceDeviceNameComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasType())
      tgt.setType(convertDeviceNameType(src.getType()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Device.DeviceDeviceNameComponent convertDeviceDeviceNameComponent(org.hl7.fhir.r5.model.Device.DeviceDeviceNameComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Device.DeviceDeviceNameComponent tgt = new org.hl7.fhir.r4.model.Device.DeviceDeviceNameComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasType())
      tgt.setType(convertDeviceNameType(src.getType()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Device.DeviceNameType convertDeviceNameType(org.hl7.fhir.r4.model.Device.DeviceNameType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case UDILABELNAME: return org.hl7.fhir.r5.model.Device.DeviceNameType.UDILABELNAME;
    case USERFRIENDLYNAME: return org.hl7.fhir.r5.model.Device.DeviceNameType.USERFRIENDLYNAME;
    case PATIENTREPORTEDNAME: return org.hl7.fhir.r5.model.Device.DeviceNameType.PATIENTREPORTEDNAME;
    case MANUFACTURERNAME: return org.hl7.fhir.r5.model.Device.DeviceNameType.MANUFACTURERNAME;
    case MODELNAME: return org.hl7.fhir.r5.model.Device.DeviceNameType.MODELNAME;
    case OTHER: return org.hl7.fhir.r5.model.Device.DeviceNameType.OTHER;
    default: return org.hl7.fhir.r5.model.Device.DeviceNameType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Device.DeviceNameType convertDeviceNameType(org.hl7.fhir.r5.model.Device.DeviceNameType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case UDILABELNAME: return org.hl7.fhir.r4.model.Device.DeviceNameType.UDILABELNAME;
    case USERFRIENDLYNAME: return org.hl7.fhir.r4.model.Device.DeviceNameType.USERFRIENDLYNAME;
    case PATIENTREPORTEDNAME: return org.hl7.fhir.r4.model.Device.DeviceNameType.PATIENTREPORTEDNAME;
    case MANUFACTURERNAME: return org.hl7.fhir.r4.model.Device.DeviceNameType.MANUFACTURERNAME;
    case MODELNAME: return org.hl7.fhir.r4.model.Device.DeviceNameType.MODELNAME;
    case OTHER: return org.hl7.fhir.r4.model.Device.DeviceNameType.OTHER;
    default: return org.hl7.fhir.r4.model.Device.DeviceNameType.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Device.DeviceSpecializationComponent convertDeviceSpecializationComponent(org.hl7.fhir.r4.model.Device.DeviceSpecializationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Device.DeviceSpecializationComponent tgt = new org.hl7.fhir.r5.model.Device.DeviceSpecializationComponent();
    copyElement(src, tgt);
    if (src.hasSystemType())
      tgt.setSystemType(convertCodeableConcept(src.getSystemType()));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Device.DeviceSpecializationComponent convertDeviceSpecializationComponent(org.hl7.fhir.r5.model.Device.DeviceSpecializationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Device.DeviceSpecializationComponent tgt = new org.hl7.fhir.r4.model.Device.DeviceSpecializationComponent();
    copyElement(src, tgt);
    if (src.hasSystemType())
      tgt.setSystemType(convertCodeableConcept(src.getSystemType()));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Device.DeviceVersionComponent convertDeviceVersionComponent(org.hl7.fhir.r4.model.Device.DeviceVersionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Device.DeviceVersionComponent tgt = new org.hl7.fhir.r5.model.Device.DeviceVersionComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasComponent())
      tgt.setComponent(convertIdentifier(src.getComponent()));
    if (src.hasValue())
      tgt.setValueElement(convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Device.DeviceVersionComponent convertDeviceVersionComponent(org.hl7.fhir.r5.model.Device.DeviceVersionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Device.DeviceVersionComponent tgt = new org.hl7.fhir.r4.model.Device.DeviceVersionComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasComponent())
      tgt.setComponent(convertIdentifier(src.getComponent()));
    if (src.hasValue())
      tgt.setValueElement(convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Device.DevicePropertyComponent convertDevicePropertyComponent(org.hl7.fhir.r4.model.Device.DevicePropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Device.DevicePropertyComponent tgt = new org.hl7.fhir.r5.model.Device.DevicePropertyComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4.model.Quantity t : src.getValueQuantity())
      tgt.addValueQuantity(convertQuantity(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getValueCode())
      tgt.addValueCode(convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Device.DevicePropertyComponent convertDevicePropertyComponent(org.hl7.fhir.r5.model.Device.DevicePropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Device.DevicePropertyComponent tgt = new org.hl7.fhir.r4.model.Device.DevicePropertyComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r5.model.Quantity t : src.getValueQuantity())
      tgt.addValueQuantity(convertQuantity(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getValueCode())
      tgt.addValueCode(convertCodeableConcept(t));
    return tgt;
  }


}
