package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Annotation43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.ContactPoint43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Quantity43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeType;
import org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionClassificationComponent;
import org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionDeviceVersionComponent;

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
public class DeviceDefinition43_N {

  // R6 dropped DeviceDefinition.owner - carried as the same cross-version extension DeviceDefinition50_N uses
  public static final String OWNER_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-DeviceDefinition.owner";
  private static final String SYSTEM_NAME_TYPE = "http://hl7.org/fhir/device-nametype";
  private static final String SYSTEM_LANG = "urn:ietf:bcp:47";

  public static org.hl7.fhir.model.core.DeviceDefinition convertDeviceDefinition(org.hl7.fhir.r4b.model.DeviceDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DeviceDefinition tgt = new org.hl7.fhir.model.core.DeviceDefinition();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    for (org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent t : src.getUdiDeviceIdentifier())
      tgt.addUdiDeviceIdentifier(convertDeviceDefinitionUdiDeviceIdentifierComponent(t));
    if (src.hasManufacturerReference())
      tgt.setManufacturer(Reference43_N.convertReference(src.getManufacturerReference()));
    for (org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent t : src.getDeviceName())
      tgt.addDeviceName(convertDeviceDefinitionDeviceNameComponent(t));
    if (src.hasModelNumber())
      tgt.setModelNumberElement(String43_N.convertString(src.getModelNumberElement()));
    if (src.hasType())
      tgt.addClassification().setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getVersion())
      tgt.addDeviceVersion().setValueElement(String43_N.convertString(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSafety())
      tgt.addSafety(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.ProductShelfLife t : src.getShelfLifeStorage())
      tgt.addShelfLifeStorage(ProductShelfLife43_N.convertProductShelfLife(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getLanguageCode()) {
      CodeType lang = convertLanguage(t);
      if (lang != null)
        tgt.getOutputLanguageList().add(lang);
    }
    for (org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionPropertyComponent t : src.getProperty())
      tgt.addProperty(convertDeviceDefinitionPropertyComponent(t));
    if (src.hasOwner())
      tgt.addExtension(OWNER_EXTENSION_URL, Reference43_N.convertReference(src.getOwner()));
    for (org.hl7.fhir.r4b.model.ContactPoint t : src.getContact())
      tgt.getContactFirstRep().addTelecom(ContactPoint43_N.convertContactPoint(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote())
      tgt.addNote(Annotation43_N.convertAnnotation(t));
    for (org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionMaterialComponent t : src.getMaterial())
      tgt.addMaterial(convertDeviceDefinitionMaterialComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DeviceDefinition convertDeviceDefinition(org.hl7.fhir.model.core.DeviceDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.DeviceDefinition tgt = new org.hl7.fhir.r4b.model.DeviceDefinition();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt, OWNER_EXTENSION_URL);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    for (org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent t : src.getUdiDeviceIdentifierList())
      tgt.addUdiDeviceIdentifier(convertDeviceDefinitionUdiDeviceIdentifierComponent(t));
    if (src.hasManufacturer())
      tgt.setManufacturer(Reference43_N.convertReference(src.getManufacturer()));
    for (org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionDeviceNameComponent t : src.getDeviceNameList())
      tgt.addDeviceName(convertDeviceDefinitionDeviceNameComponent(t));
    if (src.hasModelNumber())
      tgt.setModelNumberElement(String43_N.convertString(src.getModelNumberElement()));
    for (DeviceDefinitionClassificationComponent t : src.getClassificationList())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(t.getType()));
    for (DeviceDefinitionDeviceVersionComponent t : src.getDeviceVersionList())
      if (t.hasValue())
        tgt.getVersion().add(String43_N.convertString(t.getValueElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getSafetyList())
      tgt.addSafety(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.ProductShelfLife t : src.getShelfLifeStorageList())
      tgt.addShelfLifeStorage(ProductShelfLife43_N.convertProductShelfLife(t));
    for (CodeType t : src.getOutputLanguageList())
      tgt.addLanguageCode(convertLanguage(t));
    for (org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionPropertyComponent t : src.getPropertyList())
      tgt.addProperty(convertDeviceDefinitionPropertyComponent(t));
    if (src.hasExtension(OWNER_EXTENSION_URL))
      tgt.setOwner(Reference43_N.convertReference((org.hl7.fhir.model.core.Reference) src.getExtensionByUrl(OWNER_EXTENSION_URL).getValue()));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getContactList())
      for (org.hl7.fhir.model.core.ContactPoint tt : t.getTelecomList())
        tgt.addContact(ContactPoint43_N.convertContactPoint(tt));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList())
      tgt.addNote(Annotation43_N.convertAnnotation(t));
    for (org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionMaterialComponent t : src.getMaterialList())
      tgt.addMaterial(convertDeviceDefinitionMaterialComponent(t));
    return tgt;
  }

  private static CodeType convertLanguage(org.hl7.fhir.r4b.model.CodeableConcept src) {
    if (src == null || src.isEmpty())
      return null;
    for (org.hl7.fhir.r4b.model.Coding t : src.getCoding()) {
      if (SYSTEM_LANG.equals(t.getSystem()) && t.hasCode()) {
        CodeType tgt = new CodeType(t.getCode());
        ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
        return tgt;
      }
    }
    return null;
  }

  private static org.hl7.fhir.r4b.model.CodeableConcept convertLanguage(CodeType src) {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.CodeableConcept tgt = new org.hl7.fhir.r4b.model.CodeableConcept();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasValue())
      tgt.addCoding().setSystem(SYSTEM_LANG).setCode(src.getValue());
    return tgt;
  }

  public static org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent convertDeviceDefinitionUdiDeviceIdentifierComponent(org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent tgt = new org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasDeviceIdentifier())
      tgt.setDeviceIdentifierElement(String43_N.convertString(src.getDeviceIdentifierElement()));
    if (src.hasIssuer())
      tgt.setIssuerElement(Uri43_N.convertUri(src.getIssuerElement()));
    if (src.hasJurisdiction())
      tgt.setJurisdictionElement(Uri43_N.convertUri(src.getJurisdictionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent convertDeviceDefinitionUdiDeviceIdentifierComponent(org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent tgt = new org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasDeviceIdentifier())
      tgt.setDeviceIdentifierElement(String43_N.convertString(src.getDeviceIdentifierElement()));
    if (src.hasIssuer())
      tgt.setIssuerElement(Uri43_N.convertUri(src.getIssuerElement()));
    if (src.hasJurisdiction())
      tgt.setJurisdictionElement(Uri43_N.convertUri(src.getJurisdictionElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionDeviceNameComponent convertDeviceDefinitionDeviceNameComponent(org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionDeviceNameComponent tgt = new org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionDeviceNameComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasType())
      tgt.setType(convertDeviceNameType(src.getTypeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent convertDeviceDefinitionDeviceNameComponent(org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionDeviceNameComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent tgt = new org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasType())
      tgt.setTypeElement(convertDeviceNameType(src.getType()));
    return tgt;
  }

  // R4 device-nametype codes map onto the R5 codes the same way DeviceDefinition43_50 does; R6 holds the type as a CodeableConcept
  static public org.hl7.fhir.model.core.CodeableConcept convertDeviceNameType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DeviceNameType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.CodeableConcept tgt = new org.hl7.fhir.model.core.CodeableConcept();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() != null) {
      switch (src.getValue()) {
        case USERFRIENDLYNAME:
        case MODELNAME:
          tgt.addCoding(SYSTEM_NAME_TYPE, "user-friendly-name", "User Friendly name");
          break;
        case PATIENTREPORTEDNAME:
          tgt.addCoding(SYSTEM_NAME_TYPE, "patient-reported-name", "Patient Reported name");
          break;
        case MANUFACTURERNAME:
          tgt.addCoding(SYSTEM_NAME_TYPE, "registered-name", "Registered name");
          break;
        default:
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DeviceNameType> convertDeviceNameType(org.hl7.fhir.model.core.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DeviceNameType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.DeviceNameTypeEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    for (org.hl7.fhir.model.core.Coding t : src.getCodingList()) {
      if (SYSTEM_NAME_TYPE.equals(t.getSystem()) && t.hasCode()) {
        switch (t.getCode()) {
          case "user-friendly-name":
            tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DeviceNameType.USERFRIENDLYNAME);
            return tgt;
          case "patient-reported-name":
            tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DeviceNameType.PATIENTREPORTEDNAME);
            return tgt;
          case "registered-name":
            tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DeviceNameType.MANUFACTURERNAME);
            return tgt;
          default:
            break;
        }
      }
    }
    tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DeviceNameType.NULL);
    return tgt;
  }
//
//  public static org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionSpecializationComponent convertDeviceDefinitionSpecializationComponent(org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionSpecializationComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionSpecializationComponent tgt = new org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionSpecializationComponent();
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
//    if (src.hasSystemType())
//      tgt.setSystemTypeElement(String43_N.convertString(src.getSystemTypeElement()));
//    if (src.hasVersion())
//      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionSpecializationComponent convertDeviceDefinitionSpecializationComponent(org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionSpecializationComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionSpecializationComponent tgt = new org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionSpecializationComponent();
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
//    if (src.hasSystemType())
//      tgt.setSystemTypeElement(String43_N.convertString(src.getSystemTypeElement()));
//    if (src.hasVersion())
//      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionCapabilityComponent convertDeviceDefinitionCapabilityComponent(org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionCapabilityComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionCapabilityComponent tgt = new org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionCapabilityComponent();
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
//    if (src.hasType())
//      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
//    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getDescription())
//      tgt.addDescription(CodeableConcept43_N.convertCodeableConcept(t));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionCapabilityComponent convertDeviceDefinitionCapabilityComponent(org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionCapabilityComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionCapabilityComponent tgt = new org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionCapabilityComponent();
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
//    if (src.hasType())
//      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
//    for (org.hl7.fhir.model.core.CodeableConcept t : src.getDescription())
//      tgt.addDescription(CodeableConcept43_N.convertCodeableConcept(t));
//    return tgt;
//  }

  public static org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionPropertyComponent convertDeviceDefinitionPropertyComponent(org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionPropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionPropertyComponent tgt = new org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionPropertyComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4b.model.Quantity t : src.getValueQuantity())
      tgt.setValue(Quantity43_N.convertQuantity(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getValueCode())
      tgt.setValue(CodeableConcept43_N.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionPropertyComponent convertDeviceDefinitionPropertyComponent(org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionPropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionPropertyComponent tgt = new org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionPropertyComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasValueQuantity())
      tgt.addValueQuantity(Quantity43_N.convertQuantity(src.getValueQuantity()));
    if (src.hasValueCodeableConcept())
      tgt.addValueCode(CodeableConcept43_N.convertCodeableConcept(src.getValueCodeableConcept()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionMaterialComponent convertDeviceDefinitionMaterialComponent(org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionMaterialComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionMaterialComponent tgt = new org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionMaterialComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSubstance())
      tgt.setSubstance(CodeableConcept43_N.convertCodeableConcept(src.getSubstance()));
    if (src.hasAlternate())
      tgt.setAlternateElement(Boolean43_N.convertBoolean(src.getAlternateElement()));
    if (src.hasAllergenicIndicator())
      tgt.setAllergenicIndicatorElement(Boolean43_N.convertBoolean(src.getAllergenicIndicatorElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionMaterialComponent convertDeviceDefinitionMaterialComponent(org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionMaterialComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionMaterialComponent tgt = new org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionMaterialComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSubstance())
      tgt.setSubstance(CodeableConcept43_N.convertCodeableConcept(src.getSubstance()));
    if (src.hasAlternate())
      tgt.setAlternateElement(Boolean43_N.convertBoolean(src.getAlternateElement()));
    if (src.hasAllergenicIndicator())
      tgt.setAllergenicIndicatorElement(Boolean43_N.convertBoolean(src.getAllergenicIndicatorElement()));
    return tgt;
  }
}
