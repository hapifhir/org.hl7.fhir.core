package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.ContactPoint40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Quantity40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Base64Binary40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Device;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;

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

public class Device40_N {

  public static org.hl7.fhir.model.core.Device convertDevice(org.hl7.fhir.r4.model.Device src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Device tgt = new org.hl7.fhir.model.core.Device();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.Device.DeviceUdiCarrierComponent t : src.getUdiCarrier())
      tgt.addUdiCarrier(convertDeviceUdiCarrierComponent(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertFHIRDeviceStatus(src.getStatusElement()));
//    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getStatusReason())
//      tgt.addStatusReason(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasDistinctIdentifier())
      tgt.getBiologicalSourceEvent().setValueElement(String40_N.convertString(src.getDistinctIdentifierElement()));
    if (src.hasManufacturer())
      tgt.setManufacturerElement(String40_N.convertString(src.getManufacturerElement()));
    if (src.hasManufactureDate())
      tgt.setManufactureDateElement(DateTime40_N.convertDateTime(src.getManufactureDateElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(DateTime40_N.convertDateTime(src.getExpirationDateElement()));
    if (src.hasLotNumber())
      tgt.setLotNumberElement(String40_N.convertString(src.getLotNumberElement()));
    if (src.hasSerialNumber())
      tgt.setSerialNumberElement(String40_N.convertString(src.getSerialNumberElement()));
    for (org.hl7.fhir.r4.model.Device.DeviceDeviceNameComponent t : src.getDeviceName())
      tgt.addName(convertDeviceDeviceNameComponent(t));
    if (src.hasModelNumber())
      tgt.setModelNumberElement(String40_N.convertString(src.getModelNumberElement()));
    if (src.hasPartNumber())
      tgt.setPartNumberElement(String40_N.convertString(src.getPartNumberElement()));
    if (src.hasType())
      tgt.addType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
//    for (org.hl7.fhir.r4.model.Device.DeviceSpecializationComponent t : src.getSpecialization())
//      tgt.addSpecialization(convertDeviceSpecializationComponent(t));
    for (org.hl7.fhir.r4.model.Device.DeviceVersionComponent t : src.getVersion())
      tgt.addDeviceVersion(convertDeviceVersionComponent(t));
    for (org.hl7.fhir.r4.model.Device.DevicePropertyComponent t : src.getProperty())
      tgt.addProperty(convertDevicePropertyComponent(t));
//    if (src.hasPatient())
//      tgt.getAssociationFirstRep().setHumanSubject(Reference40_N.convertReference(src.getPatient()));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getContact())
      tgt.addContact(ContactPoint40_N.convertContactPoint(t));
    if (src.hasLocation())
      tgt.setLocation(Reference40_N.convertReference(src.getLocation()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSafety())
      tgt.addSafety(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasParent())
      tgt.setParent(Reference40_N.convertReference(src.getParent()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Device convertDevice(org.hl7.fhir.model.core.Device src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Device tgt = new org.hl7.fhir.r4.model.Device();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.model.core.Device.DeviceUdiCarrierComponent t : src.getUdiCarrierList())
      tgt.addUdiCarrier(convertDeviceUdiCarrierComponent(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertFHIRDeviceStatus(src.getStatusElement()));
//    for (org.hl7.fhir.model.core.CodeableConcept t : src.getStatusReasonList())
//      tgt.addStatusReason(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasBiologicalSourceEvent())
      tgt.setDistinctIdentifierElement(String40_N.convertString(src.getBiologicalSourceEvent().getValueElement()));
    if (src.hasManufacturer())
      tgt.setManufacturerElement(String40_N.convertString(src.getManufacturerElement()));
    if (src.hasManufactureDate())
      tgt.setManufactureDateElement(DateTime40_N.convertDateTime(src.getManufactureDateElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(DateTime40_N.convertDateTime(src.getExpirationDateElement()));
    if (src.hasLotNumber())
      tgt.setLotNumberElement(String40_N.convertString(src.getLotNumberElement()));
    if (src.hasSerialNumber())
      tgt.setSerialNumberElement(String40_N.convertString(src.getSerialNumberElement()));
    for (org.hl7.fhir.model.core.Device.DeviceNameComponent t : src.getNameList())
      tgt.addDeviceName(convertDeviceDeviceNameComponent(t));
    if (src.hasModelNumber())
      tgt.setModelNumberElement(String40_N.convertString(src.getModelNumberElement()));
    if (src.hasPartNumber())
      tgt.setPartNumberElement(String40_N.convertString(src.getPartNumberElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getTypeFirstRep()));
//    for (org.hl7.fhir.model.core.Device.DeviceSpecializationComponent t : src.getSpecializationList())
//      tgt.addSpecialization(convertDeviceSpecializationComponent(t));
    for (org.hl7.fhir.model.core.Device.DeviceDeviceVersionComponent t : src.getDeviceVersionList())
      tgt.addVersion(convertDeviceVersionComponent(t));
    for (org.hl7.fhir.model.core.Device.DevicePropertyComponent t : src.getPropertyList())
      tgt.addProperty(convertDevicePropertyComponent(t));
//    if (src.getAssociationFirstRep().hasHumanSubject())
//      tgt.setPatient(Reference40_N.convertReference(src.getAssociationFirstRep().getHumanSubject()));
    for (org.hl7.fhir.model.core.ContactPoint t : src.getContactList())
      tgt.addContact(ContactPoint40_N.convertContactPoint(t));
    if (src.hasLocation())
      tgt.setLocation(Reference40_N.convertReference(src.getLocation()));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getSafetyList())
      tgt.addSafety(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasParent())
      tgt.setParent(Reference40_N.convertReference(src.getParent()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Device.FHIRDeviceStatus> convertFHIRDeviceStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.FHIRDeviceStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Device.FHIRDeviceStatus> tgt = new Enumeration<>(new Device.FHIRDeviceStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(Device.FHIRDeviceStatus.ACTIVE);
                  break;
              case INACTIVE:
                  tgt.setValue(Device.FHIRDeviceStatus.INACTIVE);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Device.FHIRDeviceStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(Device.FHIRDeviceStatus.NULL);
                  break;
              default:
                  tgt.setValue(Device.FHIRDeviceStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.FHIRDeviceStatus> convertFHIRDeviceStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Device.FHIRDeviceStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.FHIRDeviceStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Device.FHIRDeviceStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.Device.FHIRDeviceStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Device.DeviceUdiCarrierComponent convertDeviceUdiCarrierComponent(org.hl7.fhir.r4.model.Device.DeviceUdiCarrierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Device.DeviceUdiCarrierComponent tgt = new org.hl7.fhir.model.core.Device.DeviceUdiCarrierComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasDeviceIdentifier())
      tgt.setDeviceIdentifierElement(String40_N.convertString(src.getDeviceIdentifierElement()));
    if (src.hasIssuer())
      tgt.setIssuerElement(Uri40_N.convertUri(src.getIssuerElement()));
    if (src.hasJurisdiction())
      tgt.setJurisdictionElement(Uri40_N.convertUri(src.getJurisdictionElement()));
    if (src.hasCarrierAIDC())
      tgt.setCarrierAIDCElement(Base64Binary40_N.convertBase64Binary(src.getCarrierAIDCElement()));
    if (src.hasCarrierHRF())
      tgt.setCarrierHRFElement(String40_N.convertString(src.getCarrierHRFElement()));
    if (src.hasEntryType())
      tgt.setEntryTypeElement(convertUDIEntryType(src.getEntryTypeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Device.DeviceUdiCarrierComponent convertDeviceUdiCarrierComponent(org.hl7.fhir.model.core.Device.DeviceUdiCarrierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Device.DeviceUdiCarrierComponent tgt = new org.hl7.fhir.r4.model.Device.DeviceUdiCarrierComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasDeviceIdentifier())
      tgt.setDeviceIdentifierElement(String40_N.convertString(src.getDeviceIdentifierElement()));
    if (src.hasIssuer())
      tgt.setIssuerElement(Uri40_N.convertUri(src.getIssuerElement()));
    if (src.hasJurisdiction())
      tgt.setJurisdictionElement(Uri40_N.convertUri(src.getJurisdictionElement()));
    if (src.hasCarrierAIDC())
      tgt.setCarrierAIDCElement(Base64Binary40_N.convertBase64Binary(src.getCarrierAIDCElement()));
    if (src.hasCarrierHRF())
      tgt.setCarrierHRFElement(String40_N.convertString(src.getCarrierHRFElement()));
    if (src.hasEntryType())
      tgt.setEntryTypeElement(convertUDIEntryType(src.getEntryTypeElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Device.UDIEntryType> convertUDIEntryType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.UDIEntryType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Device.UDIEntryType> tgt = new Enumeration<>(new Device.UDIEntryTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case BARCODE:
                  tgt.setValue(Device.UDIEntryType.BARCODE);
                  break;
              case RFID:
                  tgt.setValue(Device.UDIEntryType.RFID);
                  break;
              case MANUAL:
                  tgt.setValue(Device.UDIEntryType.MANUAL);
                  break;
              case CARD:
                  tgt.setValue(Device.UDIEntryType.CARD);
                  break;
              case SELFREPORTED:
                  tgt.setValue(Device.UDIEntryType.SELFREPORTED);
                  break;
              case UNKNOWN:
                  tgt.setValue(Device.UDIEntryType.UNKNOWN);
                  break;
              default:
                  tgt.setValue(Device.UDIEntryType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.UDIEntryType> convertUDIEntryType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Device.UDIEntryType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.UDIEntryType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Device.UDIEntryTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Device.DeviceNameComponent convertDeviceDeviceNameComponent(org.hl7.fhir.r4.model.Device.DeviceDeviceNameComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Device.DeviceNameComponent tgt = new org.hl7.fhir.model.core.Device.DeviceNameComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setValueElement(String40_N.convertString(src.getNameElement()));
    if (src.hasType())
      tgt.setType(convertDeviceNameType(src.getTypeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Device.DeviceDeviceNameComponent convertDeviceDeviceNameComponent(org.hl7.fhir.model.core.Device.DeviceNameComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Device.DeviceDeviceNameComponent tgt = new org.hl7.fhir.r4.model.Device.DeviceDeviceNameComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasValue())
      tgt.setNameElement(String40_N.convertString(src.getValueElement()));
    if (src.hasType())
      tgt.setTypeElement(convertDeviceNameType(src.getType()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.CodeableConcept convertDeviceNameType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.DeviceNameType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.model.core.CodeableConcept tgt = new org.hl7.fhir.model.core.CodeableConcept();
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() != null) {
          switch (src.getValue()) {
              case USERFRIENDLYNAME:
                  tgt.addCoding("http://terminology.hl7.org/CodeSystem/device-nametype", "user-friendly-name", "User Friendly name");
                  break;
              case PATIENTREPORTEDNAME:
                tgt.addCoding("http://terminology.hl7.org/CodeSystem/device-nametype", "patient-reported-name", "Patient Reported name");
                  break;
              case MANUFACTURERNAME:
              case MODELNAME:
                  tgt.addCoding("http://terminology.hl7.org/CodeSystem/device-nametype", "registered-name", "Registered name");
                  break;
              case OTHER:
                  break;
              default:
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.DeviceNameType> convertDeviceNameType(org.hl7.fhir.model.core.CodeableConcept src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.DeviceNameType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Device.DeviceNameTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.hasCoding("http://terminology.hl7.org/CodeSystem/device-nametype", "user-friendly-name")) {
        tgt.setValue(org.hl7.fhir.r4.model.Device.DeviceNameType.USERFRIENDLYNAME);
      } else if (src.hasCoding("http://terminology.hl7.org/CodeSystem/device-nametype", "patient-reported-name")) {
        tgt.setValue(org.hl7.fhir.r4.model.Device.DeviceNameType.PATIENTREPORTEDNAME);
      } else if (src.hasCoding("http://terminology.hl7.org/CodeSystem/device-nametype", "registered-name")) {
        tgt.setValue(org.hl7.fhir.r4.model.Device.DeviceNameType.MANUFACTURERNAME);
      }
      return tgt;
  }

//  public static org.hl7.fhir.model.core.Device.DeviceSpecializationComponent convertDeviceSpecializationComponent(org.hl7.fhir.r4.model.Device.DeviceSpecializationComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.core.Device.DeviceSpecializationComponent tgt = new org.hl7.fhir.model.core.Device.DeviceSpecializationComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    if (src.hasSystemType())
//      tgt.setSystemType(CodeableConcept40_N.convertCodeableConcept(src.getSystemType()));
//    if (src.hasVersion())
//      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.Device.DeviceSpecializationComponent convertDeviceSpecializationComponent(org.hl7.fhir.model.core.Device.DeviceSpecializationComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.Device.DeviceSpecializationComponent tgt = new org.hl7.fhir.r4.model.Device.DeviceSpecializationComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    if (src.hasSystemType())
//      tgt.setSystemType(CodeableConcept40_N.convertCodeableConcept(src.getSystemType()));
//    if (src.hasVersion())
//      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
//    return tgt;
//  }

  public static org.hl7.fhir.model.core.Device.DeviceDeviceVersionComponent convertDeviceVersionComponent(org.hl7.fhir.r4.model.Device.DeviceVersionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Device.DeviceDeviceVersionComponent tgt = new org.hl7.fhir.model.core.Device.DeviceDeviceVersionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasComponent())
      tgt.setComponent(Identifier40_N.convertIdentifier(src.getComponent()));
    if (src.hasValue())
      tgt.setValueElement(String40_N.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Device.DeviceVersionComponent convertDeviceVersionComponent(org.hl7.fhir.model.core.Device.DeviceDeviceVersionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Device.DeviceVersionComponent tgt = new org.hl7.fhir.r4.model.Device.DeviceVersionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasComponent())
      tgt.setComponent(Identifier40_N.convertIdentifier(src.getComponent()));
    if (src.hasValue())
      tgt.setValueElement(String40_N.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Device.DevicePropertyComponent convertDevicePropertyComponent(org.hl7.fhir.r4.model.Device.DevicePropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Device.DevicePropertyComponent tgt = new org.hl7.fhir.model.core.Device.DevicePropertyComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4.model.Quantity t : src.getValueQuantity()) tgt.setValue(Quantity40_N.convertQuantity(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getValueCode())
      tgt.setValue(CodeableConcept40_N.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Device.DevicePropertyComponent convertDevicePropertyComponent(org.hl7.fhir.model.core.Device.DevicePropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Device.DevicePropertyComponent tgt = new org.hl7.fhir.r4.model.Device.DevicePropertyComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasValueQuantity()) tgt.addValueQuantity(Quantity40_N.convertQuantity(src.getValueQuantity()));
    if (src.hasValueCodeableConcept())
      tgt.addValueCode(CodeableConcept40_N.convertCodeableConcept(src.getValueCodeableConcept()));
    return tgt;
  }
}
