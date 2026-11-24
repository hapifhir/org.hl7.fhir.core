package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
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

  // R6 name.type has fewer codes than R4 deviceName.type: the R4 code is kept here when R6 doesn't have it
  // the R6 name.type concept, when the R4 code can't carry all of it
  public static final String NAME_TYPE_CONCEPT_EXTENSION_URL = "http://hl7.org/fhir/6.0/StructureDefinition/extension-Device.name.type";

  public static final String NAME_TYPE_EXTENSION_URL = "http://hl7.org/fhir/4.0/StructureDefinition/extension-Device.deviceName.type";

  // R5 added udiCarrier.entryType codes that R4 doesn't have
  public static final String UDI_ENTRY_TYPE_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Device.udiCarrier.entryType";

  // R4 distinctIdentifier is a string: when R6 biologicalSourceEvent has more than a value, the whole identifier goes here
  public static final String BIOLOGICAL_SOURCE_EVENT_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Device.biologicalSourceEvent";

  public static org.hl7.fhir.model.core.Device convertDevice(org.hl7.fhir.r4.model.Device src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Device tgt = new org.hl7.fhir.model.core.Device();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("Device", "5.0", new String[] {"availabilityStatus", "category", "type"},
      CrossVersionElements40_N.urls("Device", "6.0", new String[] {"additive"}, BIOLOGICAL_SOURCE_EVENT_EXTENSION_URL)));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "availabilityStatus", "category");
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "additive");
    // R4 elements that R6 dropped
    CrossVersionElements40_N.r4ElementsToExtensions(src, "Device", tgt.getExtension(), "statusReason", "patient", "owner", "url");
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasDefinition())
      tgt.setDefinitionElement(Reference40_N.convertReferenceToCanonical(src.getDefinition()));
    for (org.hl7.fhir.r4.model.Device.DeviceUdiCarrierComponent t : src.getUdiCarrier())
      tgt.addUdiCarrier(convertDeviceUdiCarrierComponent(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR6Code(src.getStatusElement(), convertFHIRDeviceStatus(src.getStatusElement()), src.fhirType(), "status"));
//    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getStatusReason())
//      tgt.addStatusReason(CodeableConcept40_N.convertCodeableConcept(t));
    // R4 only has the identifier's value: if there's more than that, the whole identifier is in the extension
    if (src.hasExtension(BIOLOGICAL_SOURCE_EVENT_EXTENSION_URL))
      tgt.setBiologicalSourceEvent(Identifier40_N.convertIdentifier((org.hl7.fhir.r4.model.Identifier) src.getExtensionByUrl(BIOLOGICAL_SOURCE_EVENT_EXTENSION_URL).getValue()));
    else if (src.hasDistinctIdentifier())
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
    // the other types (R4 only has one)
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "type");
    for (org.hl7.fhir.r4.model.Device.DeviceSpecializationComponent t : src.getSpecialization())
      tgt.addConformsTo(convertDeviceSpecializationComponent(t));
    for (org.hl7.fhir.r4.model.Device.DeviceVersionComponent t : src.getVersion())
      tgt.addDeviceVersion(convertDeviceVersionComponent(t));
    // R6 property has a single value: an R4 property with several becomes several properties (they're
    // collected together again going back, see mergeProperty)
    for (org.hl7.fhir.r4.model.Device.DevicePropertyComponent t : src.getProperty()) {
      if (t.getValueQuantity().size() + t.getValueCode().size() <= 1) {
        tgt.addProperty(convertDevicePropertyComponent(t));
      } else {
        for (org.hl7.fhir.r4.model.Quantity q : t.getValueQuantity())
          convertDevicePropertyHeader(t, tgt.addProperty()).setValue(Quantity40_N.convertQuantity(q));
        for (org.hl7.fhir.r4.model.CodeableConcept c : t.getValueCode())
          convertDevicePropertyHeader(t, tgt.addProperty()).setValue(CodeableConcept40_N.convertCodeableConcept(c));
      }
    }
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
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("Device", "4.0", new String[] {"statusReason", "patient", "owner", "url"}));
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "availabilityStatus", "category");
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", "additive");
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "Device", "statusReason", "patient", "owner", "url");
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasDefinition())
      tgt.setDefinition(Reference40_N.convertCanonicalToReference(src.getDefinitionElement()));
    for (org.hl7.fhir.model.core.Device.DeviceUdiCarrierComponent t : src.getUdiCarrierList())
      tgt.addUdiCarrier(convertDeviceUdiCarrierComponent(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR4Code(src.getStatusElement(), convertFHIRDeviceStatus(src.getStatusElement()), src.fhirType(), "status"));
//    for (org.hl7.fhir.model.core.CodeableConcept t : src.getStatusReasonList())
//      tgt.addStatusReason(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasBiologicalSourceEvent()) {
      org.hl7.fhir.model.core.Identifier bse = src.getBiologicalSourceEvent();
      if (bse.hasValue())
        tgt.setDistinctIdentifierElement(String40_N.convertString(bse.getValueElement()));
      if (bse.hasSystem() || bse.hasUse() || bse.hasType() || bse.hasPeriod() || bse.hasAssigner() || bse.hasId() || bse.hasExtension())
        tgt.addExtension(BIOLOGICAL_SOURCE_EVENT_EXTENSION_URL, Identifier40_N.convertIdentifier(bse));
    }
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
    // R4 only has one type: the first, and the rest in the extension
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTypeList()) {
      if (!tgt.hasType())
        tgt.setType(CodeableConcept40_N.convertCodeableConcept(t));
      else
        tgt.addExtension(CrossVersionElements40_N.url("Device", "5.0", "type"), CodeableConcept40_N.convertCodeableConcept(t));
    }
    for (org.hl7.fhir.model.core.Device.DeviceConformsToComponent t : src.getConformsToList())
      tgt.addSpecialization(convertDeviceSpecializationComponent(t));
    for (org.hl7.fhir.model.core.Device.DeviceDeviceVersionComponent t : src.getDeviceVersionList())
      tgt.addVersion(convertDeviceVersionComponent(t));
    // R4 to R6 split an R4 property with several values into one property per value: consecutive properties
    // with the same type are collected into one again (see mergeProperty)
    for (org.hl7.fhir.model.core.Device.DevicePropertyComponent t : src.getPropertyList()) {
      org.hl7.fhir.r4.model.Device.DevicePropertyComponent p = convertDevicePropertyComponent(t);
      if (tgt.getProperty().isEmpty() || !mergeProperty(tgt.getProperty().get(tgt.getProperty().size() - 1), p))
        tgt.addProperty(p);
    }
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
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls("Device.udiCarrier", "6.0", new String[] {"deviceIdentifierSystem"}));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "Device.udiCarrier", "6.0", "deviceIdentifierSystem");
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
      tgt.setEntryTypeElement(CrossVersionElements40_N.toR6Code(src.getEntryTypeElement(), convertUDIEntryType(src.getEntryTypeElement()), src.fhirType(), "entryType"));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Device.DeviceUdiCarrierComponent convertDeviceUdiCarrierComponent(org.hl7.fhir.model.core.Device.DeviceUdiCarrierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Device.DeviceUdiCarrierComponent tgt = new org.hl7.fhir.r4.model.Device.DeviceUdiCarrierComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    CrossVersionElements40_N.elementsToExtensionsForPath(src, "Device.udiCarrier", tgt.getExtension(), "6.0", "deviceIdentifierSystem");
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
      tgt.setEntryTypeElement(CrossVersionElements40_N.toR4Code(src.getEntryTypeElement(), convertUDIEntryType(src.getEntryTypeElement()), src.fhirType(), "entryType"));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Device.UDIEntryType> convertUDIEntryType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.UDIEntryType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Device.UDIEntryType> tgt = new Enumeration<>(new Device.UDIEntryTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, UDI_ENTRY_TYPE_EXTENSION_URL);
      if (src.hasExtension(UDI_ENTRY_TYPE_EXTENSION_URL)) {
        tgt.setValue(Device.UDIEntryType.fromCode(src.getExtensionByUrl(UDI_ENTRY_TYPE_EXTENSION_URL).getValue().primitiveValue()));
        return tgt;
      }
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
                  // a code R4 doesn't have (electronic-transmission): keep it in an extension
                  tgt.setValue(null);
                  tgt.addExtension(UDI_ENTRY_TYPE_EXTENSION_URL, new org.hl7.fhir.r4.model.CodeType(src.getCode()));
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Device.DeviceNameComponent convertDeviceDeviceNameComponent(org.hl7.fhir.r4.model.Device.DeviceDeviceNameComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Device.DeviceNameComponent tgt = new org.hl7.fhir.model.core.Device.DeviceNameComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls("Device.name", "5.0", new String[] {"display"}));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "Device.name", "5.0", "display");
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
    CrossVersionElements40_N.elementsToExtensionsForPath(src, "Device.name", tgt.getExtension(), "5.0", "display");
    if (src.hasValue())
      tgt.setNameElement(String40_N.convertString(src.getValueElement()));
    if (src.hasType()) {
      tgt.setTypeElement(convertDeviceNameType(src.getType()));
      // the R4 code doesn't carry the R6 concept's display, other codings or text: if it can't make the same
      // concept again, keep the whole concept
      org.hl7.fhir.model.core.CodeableConcept regenerated = convertDeviceNameType(tgt.getTypeElement());
      if (regenerated == null || !src.getType().equalsDeep(regenerated))
        tgt.getTypeElement().addExtension(NAME_TYPE_CONCEPT_EXTENSION_URL, CodeableConcept40_N.convertCodeableConcept(src.getType()));
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.CodeableConcept convertDeviceNameType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.DeviceNameType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      // the R6 concept, when the R4 code couldn't carry all of it
      if (src.hasExtension(NAME_TYPE_CONCEPT_EXTENSION_URL))
        return CodeableConcept40_N.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src.getExtensionByUrl(NAME_TYPE_CONCEPT_EXTENSION_URL).getValue());
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
      // R6 has fewer codes: unless the R4 code is one R6 has too, keep it
      if (src.getValue() != null && src.getValue() != org.hl7.fhir.r4.model.Device.DeviceNameType.USERFRIENDLYNAME && src.getValue() != org.hl7.fhir.r4.model.Device.DeviceNameType.PATIENTREPORTEDNAME)
        tgt.addExtension(NAME_TYPE_EXTENSION_URL, new org.hl7.fhir.model.core.CodeType(src.getCode()));
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.DeviceNameType> convertDeviceNameType(org.hl7.fhir.model.core.CodeableConcept src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.DeviceNameType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Device.DeviceNameTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, NAME_TYPE_EXTENSION_URL);
      if (src.hasExtension(NAME_TYPE_EXTENSION_URL)) {
        tgt.setValue(org.hl7.fhir.r4.model.Device.DeviceNameType.fromCode(src.getExtensionByUrl(NAME_TYPE_EXTENSION_URL).getValue().primitiveValue()));
        return tgt;
      }
      if (src.hasCoding("http://terminology.hl7.org/CodeSystem/device-nametype", "user-friendly-name") || src.hasCoding("http://hl7.org/fhir/device-nametype", "user-friendly-name")) {
        tgt.setValue(org.hl7.fhir.r4.model.Device.DeviceNameType.USERFRIENDLYNAME);
      } else if (src.hasCoding("http://terminology.hl7.org/CodeSystem/device-nametype", "patient-reported-name") || src.hasCoding("http://hl7.org/fhir/device-nametype", "patient-reported-name")) {
        tgt.setValue(org.hl7.fhir.r4.model.Device.DeviceNameType.PATIENTREPORTEDNAME);
      } else if (src.hasCoding("http://terminology.hl7.org/CodeSystem/device-nametype", "registered-name") || src.hasCoding("http://hl7.org/fhir/device-nametype", "registered-name")) {
        tgt.setValue(org.hl7.fhir.r4.model.Device.DeviceNameType.MANUFACTURERNAME);
      }
      return tgt;
  }

  /**
   * R4 specialization is R6 conformsTo: systemType is specification. R4 has no category, so that's an extension
   */
  public static org.hl7.fhir.model.core.Device.DeviceConformsToComponent convertDeviceSpecializationComponent(org.hl7.fhir.r4.model.Device.DeviceSpecializationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Device.DeviceConformsToComponent tgt = new org.hl7.fhir.model.core.Device.DeviceConformsToComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls("Device.conformsTo", "5.0", new String[] {"category"}));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "Device.conformsTo", "5.0", "category");
    if (src.hasSystemType())
      tgt.setSpecification(CodeableConcept40_N.convertCodeableConcept(src.getSystemType()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Device.DeviceSpecializationComponent convertDeviceSpecializationComponent(org.hl7.fhir.model.core.Device.DeviceConformsToComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Device.DeviceSpecializationComponent tgt = new org.hl7.fhir.r4.model.Device.DeviceSpecializationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    CrossVersionElements40_N.elementsToExtensionsForPath(src, "Device.conformsTo", tgt.getExtension(), "5.0", "category");
    if (src.hasSpecification())
      tgt.setSystemType(CodeableConcept40_N.convertCodeableConcept(src.getSpecification()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Device.DeviceDeviceVersionComponent convertDeviceVersionComponent(org.hl7.fhir.r4.model.Device.DeviceVersionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Device.DeviceDeviceVersionComponent tgt = new org.hl7.fhir.model.core.Device.DeviceDeviceVersionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls("Device.version", "5.0", new String[] {"installDate"}));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "Device.version", "5.0", "installDate");
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
    CrossVersionElements40_N.elementsToExtensionsForPath(src, "Device.version", tgt.getExtension(), "5.0", "installDate");
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasComponent())
      tgt.setComponent(Identifier40_N.convertIdentifier(src.getComponent()));
    if (src.hasValue())
      tgt.setValueElement(String40_N.convertString(src.getValueElement()));
    return tgt;
  }

  private static org.hl7.fhir.model.core.Device.DevicePropertyComponent convertDevicePropertyHeader(org.hl7.fhir.r4.model.Device.DevicePropertyComponent src, org.hl7.fhir.model.core.Device.DevicePropertyComponent tgt) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Device.DevicePropertyComponent convertDevicePropertyComponent(org.hl7.fhir.r4.model.Device.DevicePropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Device.DevicePropertyComponent tgt = new org.hl7.fhir.model.core.Device.DevicePropertyComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls("Device.property", "5.0", new String[] {"value"}));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "Device.property", "5.0", "value");
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
    if (src.hasValue() && !src.hasValueQuantity() && !src.hasValueCodeableConcept())
      CrossVersionElements40_N.elementsToExtensionsForPath(src, "Device.property", tgt.getExtension(), "5.0", "value");
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasValueQuantity()) tgt.addValueQuantity(Quantity40_N.convertQuantity(src.getValueQuantity()));
    if (src.hasValueCodeableConcept())
      tgt.addValueCode(CodeableConcept40_N.convertCodeableConcept(src.getValueCodeableConcept()));
    return tgt;
  }

  /**
   * Adds the value of next to last, if they're the same property: same type, nothing else (no id or extensions), and
   * one value in next. R4 holds the quantities before the codes, so a quantity after a code isn't merged (that would
   * change the order of the R6 properties when they come back). The cost: two R4 Device properties with the same type
   * and no other content come back as one
   */
  private static boolean mergeProperty(org.hl7.fhir.r4.model.Device.DevicePropertyComponent last, org.hl7.fhir.r4.model.Device.DevicePropertyComponent next) {
    if (!last.hasType() || !next.hasType() || !last.getType().equalsDeep(next.getType()))
      return false;
    if (last.hasId() || last.hasExtension() || last.hasModifierExtension() || next.hasId() || next.hasExtension() || next.hasModifierExtension())
      return false;
    if (last.getValueQuantity().size() + last.getValueCode().size() == 0 || next.getValueQuantity().size() + next.getValueCode().size() != 1)
      return false;
    if (next.hasValueQuantity() && last.hasValueCode())
      return false;
    last.getValueQuantity().addAll(next.getValueQuantity());
    last.getValueCode().addAll(next.getValueCode());
    return true;
  }
}
