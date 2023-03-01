package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Annotation43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.ContactPoint43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Quantity43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Base64Binary43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
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
public class Device43_50 {

  public static org.hl7.fhir.r5.model.Device convertDevice(org.hl7.fhir.r4b.model.Device src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Device tgt = new org.hl7.fhir.r5.model.Device();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasDefinition())
      tgt.getDefinition().setReference(Reference43_50.convertReference(src.getDefinition()));
    for (org.hl7.fhir.r4b.model.Device.DeviceUdiCarrierComponent t : src.getUdiCarrier())
      tgt.addUdiCarrier(convertDeviceUdiCarrierComponent(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertFHIRDeviceStatus(src.getStatusElement()));
//    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getStatusReason())
//      tgt.addStatusReason(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasDistinctIdentifier())
      tgt.getBiologicalSourceEvent().setValueElement(String43_50.convertString(src.getDistinctIdentifierElement()));
    if (src.hasManufacturer())
      tgt.setManufacturerElement(String43_50.convertString(src.getManufacturerElement()));
    if (src.hasManufactureDate())
      tgt.setManufactureDateElement(DateTime43_50.convertDateTime(src.getManufactureDateElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(DateTime43_50.convertDateTime(src.getExpirationDateElement()));
    if (src.hasLotNumber())
      tgt.setLotNumberElement(String43_50.convertString(src.getLotNumberElement()));
    if (src.hasSerialNumber())
      tgt.setSerialNumberElement(String43_50.convertString(src.getSerialNumberElement()));
    for (org.hl7.fhir.r4b.model.Device.DeviceDeviceNameComponent t : src.getDeviceName())
      tgt.addName(convertDeviceDeviceNameComponent(t));
    if (src.hasModelNumber())
      tgt.setModelNumberElement(String43_50.convertString(src.getModelNumberElement()));
    if (src.hasPartNumber())
      tgt.setPartNumberElement(String43_50.convertString(src.getPartNumberElement()));
    if (src.hasType())
      tgt.addType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
//    for (org.hl7.fhir.r4b.model.Device.DeviceSpecializationComponent t : src.getSpecialization())
//      tgt.addSpecialization(convertDeviceSpecializationComponent(t));
    for (org.hl7.fhir.r4b.model.Device.DeviceVersionComponent t : src.getVersion())
      tgt.addVersion(convertDeviceVersionComponent(t));
    for (org.hl7.fhir.r4b.model.Device.DevicePropertyComponent t : src.getProperty())
      tgt.addProperty(convertDevicePropertyComponent(t));
//    if (src.hasPatient())
//      tgt.getAssociationFirstRep().setHumanSubject(Reference43_50.convertReference(src.getPatient()));
    if (src.hasOwner())
      tgt.setOwner(Reference43_50.convertReference(src.getOwner()));
    for (org.hl7.fhir.r4b.model.ContactPoint t : src.getContact())
      tgt.addContact(ContactPoint43_50.convertContactPoint(t));
    if (src.hasLocation())
      tgt.setLocation(Reference43_50.convertReference(src.getLocation()));
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSafety())
      tgt.addSafety(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasParent())
      tgt.setParent(Reference43_50.convertReference(src.getParent()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Device convertDevice(org.hl7.fhir.r5.model.Device src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Device tgt = new org.hl7.fhir.r4b.model.Device();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.getDefinition().hasReference())
      tgt.setDefinition(Reference43_50.convertReference(src.getDefinition().getReference()));
    for (org.hl7.fhir.r5.model.Device.DeviceUdiCarrierComponent t : src.getUdiCarrier())
      tgt.addUdiCarrier(convertDeviceUdiCarrierComponent(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertFHIRDeviceStatus(src.getStatusElement()));
//    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getStatusReason())
//      tgt.addStatusReason(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasBiologicalSourceEvent())
      tgt.setDistinctIdentifierElement(String43_50.convertString(src.getBiologicalSourceEvent().getValueElement()));
    if (src.hasManufacturer())
      tgt.setManufacturerElement(String43_50.convertString(src.getManufacturerElement()));
    if (src.hasManufactureDate())
      tgt.setManufactureDateElement(DateTime43_50.convertDateTime(src.getManufactureDateElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(DateTime43_50.convertDateTime(src.getExpirationDateElement()));
    if (src.hasLotNumber())
      tgt.setLotNumberElement(String43_50.convertString(src.getLotNumberElement()));
    if (src.hasSerialNumber())
      tgt.setSerialNumberElement(String43_50.convertString(src.getSerialNumberElement()));
    for (org.hl7.fhir.r5.model.Device.DeviceNameComponent t : src.getName())
      tgt.addDeviceName(convertDeviceDeviceNameComponent(t));
    if (src.hasModelNumber())
      tgt.setModelNumberElement(String43_50.convertString(src.getModelNumberElement()));
    if (src.hasPartNumber())
      tgt.setPartNumberElement(String43_50.convertString(src.getPartNumberElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getTypeFirstRep()));
//    for (org.hl7.fhir.r5.model.Device.DeviceSpecializationComponent t : src.getSpecialization())
//      tgt.addSpecialization(convertDeviceSpecializationComponent(t));
    for (org.hl7.fhir.r5.model.Device.DeviceVersionComponent t : src.getVersion())
      tgt.addVersion(convertDeviceVersionComponent(t));
    for (org.hl7.fhir.r5.model.Device.DevicePropertyComponent t : src.getProperty())
      tgt.addProperty(convertDevicePropertyComponent(t));
//    if (src.getAssociationFirstRep().hasHumanSubject())
//      tgt.setPatient(Reference43_50.convertReference(src.getAssociationFirstRep().getHumanSubject()));
    if (src.hasOwner())
      tgt.setOwner(Reference43_50.convertReference(src.getOwner()));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getContact())
      tgt.addContact(ContactPoint43_50.convertContactPoint(t));
    if (src.hasLocation())
      tgt.setLocation(Reference43_50.convertReference(src.getLocation()));
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSafety())
      tgt.addSafety(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasParent())
      tgt.setParent(Reference43_50.convertReference(src.getParent()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Device.FHIRDeviceStatus> convertFHIRDeviceStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Device.FHIRDeviceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Device.FHIRDeviceStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Device.FHIRDeviceStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Device.FHIRDeviceStatus.ACTIVE);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Device.FHIRDeviceStatus.INACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Device.FHIRDeviceStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r5.model.Device.FHIRDeviceStatus.NULL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Device.FHIRDeviceStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Device.FHIRDeviceStatus> convertFHIRDeviceStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Device.FHIRDeviceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Device.FHIRDeviceStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Device.FHIRDeviceStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.Device.FHIRDeviceStatus.ACTIVE);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.Device.FHIRDeviceStatus.INACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Device.FHIRDeviceStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Device.FHIRDeviceStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Device.DeviceUdiCarrierComponent convertDeviceUdiCarrierComponent(org.hl7.fhir.r4b.model.Device.DeviceUdiCarrierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Device.DeviceUdiCarrierComponent tgt = new org.hl7.fhir.r5.model.Device.DeviceUdiCarrierComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasDeviceIdentifier())
      tgt.setDeviceIdentifierElement(String43_50.convertString(src.getDeviceIdentifierElement()));
    if (src.hasIssuer())
      tgt.setIssuerElement(Uri43_50.convertUri(src.getIssuerElement()));
    if (src.hasJurisdiction())
      tgt.setJurisdictionElement(Uri43_50.convertUri(src.getJurisdictionElement()));
    if (src.hasCarrierAIDC())
      tgt.setCarrierAIDCElement(Base64Binary43_50.convertBase64Binary(src.getCarrierAIDCElement()));
    if (src.hasCarrierHRF())
      tgt.setCarrierHRFElement(String43_50.convertString(src.getCarrierHRFElement()));
    if (src.hasEntryType())
      tgt.setEntryTypeElement(convertUDIEntryType(src.getEntryTypeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Device.DeviceUdiCarrierComponent convertDeviceUdiCarrierComponent(org.hl7.fhir.r5.model.Device.DeviceUdiCarrierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Device.DeviceUdiCarrierComponent tgt = new org.hl7.fhir.r4b.model.Device.DeviceUdiCarrierComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasDeviceIdentifier())
      tgt.setDeviceIdentifierElement(String43_50.convertString(src.getDeviceIdentifierElement()));
    if (src.hasIssuer())
      tgt.setIssuerElement(Uri43_50.convertUri(src.getIssuerElement()));
    if (src.hasJurisdiction())
      tgt.setJurisdictionElement(Uri43_50.convertUri(src.getJurisdictionElement()));
    if (src.hasCarrierAIDC())
      tgt.setCarrierAIDCElement(Base64Binary43_50.convertBase64Binary(src.getCarrierAIDCElement()));
    if (src.hasCarrierHRF())
      tgt.setCarrierHRFElement(String43_50.convertString(src.getCarrierHRFElement()));
    if (src.hasEntryType())
      tgt.setEntryTypeElement(convertUDIEntryType(src.getEntryTypeElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Device.UDIEntryType> convertUDIEntryType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Device.UDIEntryType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Device.UDIEntryType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Device.UDIEntryTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case BARCODE:
        tgt.setValue(org.hl7.fhir.r5.model.Device.UDIEntryType.BARCODE);
        break;
      case RFID:
        tgt.setValue(org.hl7.fhir.r5.model.Device.UDIEntryType.RFID);
        break;
      case MANUAL:
        tgt.setValue(org.hl7.fhir.r5.model.Device.UDIEntryType.MANUAL);
        break;
      case CARD:
        tgt.setValue(org.hl7.fhir.r5.model.Device.UDIEntryType.CARD);
        break;
      case SELFREPORTED:
        tgt.setValue(org.hl7.fhir.r5.model.Device.UDIEntryType.SELFREPORTED);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r5.model.Device.UDIEntryType.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Device.UDIEntryType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Device.UDIEntryType> convertUDIEntryType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Device.UDIEntryType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Device.UDIEntryType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Device.UDIEntryTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case BARCODE:
        tgt.setValue(org.hl7.fhir.r4b.model.Device.UDIEntryType.BARCODE);
        break;
      case RFID:
        tgt.setValue(org.hl7.fhir.r4b.model.Device.UDIEntryType.RFID);
        break;
      case MANUAL:
        tgt.setValue(org.hl7.fhir.r4b.model.Device.UDIEntryType.MANUAL);
        break;
      case CARD:
        tgt.setValue(org.hl7.fhir.r4b.model.Device.UDIEntryType.CARD);
        break;
      case SELFREPORTED:
        tgt.setValue(org.hl7.fhir.r4b.model.Device.UDIEntryType.SELFREPORTED);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4b.model.Device.UDIEntryType.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Device.UDIEntryType.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Device.DeviceNameComponent convertDeviceDeviceNameComponent(org.hl7.fhir.r4b.model.Device.DeviceDeviceNameComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Device.DeviceNameComponent tgt = new org.hl7.fhir.r5.model.Device.DeviceNameComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setValueElement(String43_50.convertString(src.getNameElement()));
    if (src.hasType())
      tgt.setTypeElement(convertDeviceNameType(src.getTypeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Device.DeviceDeviceNameComponent convertDeviceDeviceNameComponent(org.hl7.fhir.r5.model.Device.DeviceNameComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Device.DeviceDeviceNameComponent tgt = new org.hl7.fhir.r4b.model.Device.DeviceDeviceNameComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasValue())
      tgt.setNameElement(String43_50.convertString(src.getValueElement()));
    if (src.hasType())
      tgt.setTypeElement(convertDeviceNameType(src.getTypeElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DeviceNameType> convertDeviceNameType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DeviceNameType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DeviceNameType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.DeviceNameTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case USERFRIENDLYNAME:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DeviceNameType.USERFRIENDLYNAME);
        break;
      case PATIENTREPORTEDNAME:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DeviceNameType.PATIENTREPORTEDNAME);
        break;
      case MANUFACTURERNAME:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DeviceNameType.REGISTEREDNAME);
        break;
      case MODELNAME:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DeviceNameType.USERFRIENDLYNAME);
        break;
      case OTHER:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DeviceNameType.NULL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DeviceNameType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DeviceNameType> convertDeviceNameType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DeviceNameType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DeviceNameType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.DeviceNameTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case USERFRIENDLYNAME:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DeviceNameType.USERFRIENDLYNAME);
        break;
      case PATIENTREPORTEDNAME:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DeviceNameType.PATIENTREPORTEDNAME);
        break;
      case REGISTEREDNAME:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DeviceNameType.MANUFACTURERNAME);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DeviceNameType.NULL);
        break;
    }
    return tgt;
  }

//  public static org.hl7.fhir.r5.model.Device.DeviceSpecializationComponent convertDeviceSpecializationComponent(org.hl7.fhir.r4b.model.Device.DeviceSpecializationComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.Device.DeviceSpecializationComponent tgt = new org.hl7.fhir.r5.model.Device.DeviceSpecializationComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
//    if (src.hasSystemType())
//      tgt.setSystemType(CodeableConcept43_50.convertCodeableConcept(src.getSystemType()));
//    if (src.hasVersion())
//      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.Device.DeviceSpecializationComponent convertDeviceSpecializationComponent(org.hl7.fhir.r5.model.Device.DeviceSpecializationComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.Device.DeviceSpecializationComponent tgt = new org.hl7.fhir.r4b.model.Device.DeviceSpecializationComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
//    if (src.hasSystemType())
//      tgt.setSystemType(CodeableConcept43_50.convertCodeableConcept(src.getSystemType()));
//    if (src.hasVersion())
//      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
//    return tgt;
//  }

  public static org.hl7.fhir.r5.model.Device.DeviceVersionComponent convertDeviceVersionComponent(org.hl7.fhir.r4b.model.Device.DeviceVersionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Device.DeviceVersionComponent tgt = new org.hl7.fhir.r5.model.Device.DeviceVersionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasComponent())
      tgt.setComponent(Identifier43_50.convertIdentifier(src.getComponent()));
    if (src.hasValue())
      tgt.setValueElement(String43_50.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Device.DeviceVersionComponent convertDeviceVersionComponent(org.hl7.fhir.r5.model.Device.DeviceVersionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Device.DeviceVersionComponent tgt = new org.hl7.fhir.r4b.model.Device.DeviceVersionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasComponent())
      tgt.setComponent(Identifier43_50.convertIdentifier(src.getComponent()));
    if (src.hasValue())
      tgt.setValueElement(String43_50.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Device.DevicePropertyComponent convertDevicePropertyComponent(org.hl7.fhir.r4b.model.Device.DevicePropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Device.DevicePropertyComponent tgt = new org.hl7.fhir.r5.model.Device.DevicePropertyComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4b.model.Quantity t : src.getValueQuantity()) tgt.setValue(Quantity43_50.convertQuantity(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getValueCode())
      tgt.setValue(CodeableConcept43_50.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Device.DevicePropertyComponent convertDevicePropertyComponent(org.hl7.fhir.r5.model.Device.DevicePropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Device.DevicePropertyComponent tgt = new org.hl7.fhir.r4b.model.Device.DevicePropertyComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasValueQuantity()) tgt.addValueQuantity(Quantity43_50.convertQuantity(src.getValueQuantity()));
    if (src.hasValueCodeableConcept())
      tgt.addValueCode(CodeableConcept43_50.convertCodeableConcept(src.getValueCodeableConcept()));
    return tgt;
  }
}
