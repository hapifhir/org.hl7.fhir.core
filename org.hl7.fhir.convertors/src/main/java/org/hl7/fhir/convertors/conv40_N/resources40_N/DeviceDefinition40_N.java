package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.ContactPoint40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Quantity40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
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
public class DeviceDefinition40_N {

  // R6 dropped DeviceDefinition.owner - carried as the same cross-version extension DeviceDefinition50_N uses
  public static final String OWNER_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-DeviceDefinition.owner";
  private static final String SYSTEM_NAME_TYPE = "http://hl7.org/fhir/device-nametype";
  private static final String SYSTEM_LANG = "urn:ietf:bcp:47";

  public static org.hl7.fhir.model.core.DeviceDefinition convertDeviceDefinition(org.hl7.fhir.r4.model.DeviceDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DeviceDefinition tgt = new org.hl7.fhir.model.core.DeviceDefinition();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent t : src.getUdiDeviceIdentifier())
      tgt.addUdiDeviceIdentifier(convertDeviceDefinitionUdiDeviceIdentifierComponent(t));
    if (src.hasManufacturerReference())
      tgt.setManufacturer(Reference40_N.convertReference(src.getManufacturerReference()));
    for (org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent t : src.getDeviceName())
      tgt.addDeviceName(convertDeviceDefinitionDeviceNameComponent(t));
    if (src.hasModelNumber())
      tgt.setModelNumberElement(String40_N.convertString(src.getModelNumberElement()));
    if (src.hasType())
      tgt.addClassification().setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4.model.StringType t : src.getVersion())
      tgt.addDeviceVersion().setValueElement(String40_N.convertString(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSafety())
      tgt.addSafety(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.ProductShelfLife t : src.getShelfLifeStorage())
      tgt.addShelfLifeStorage(ProductShelfLife40_N.convertProductShelfLife(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getLanguageCode()) {
      CodeType lang = convertLanguage(t);
      if (lang != null)
        tgt.getOutputLanguageList().add(lang);
    }
    for (org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionPropertyComponent t : src.getProperty())
      tgt.addProperty(convertDeviceDefinitionPropertyComponent(t));
    if (src.hasOwner())
      tgt.addExtension(OWNER_EXTENSION_URL, Reference40_N.convertReference(src.getOwner()));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getContact())
      tgt.getContactFirstRep().addTelecom(ContactPoint40_N.convertContactPoint(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote())
      tgt.addNote(Annotation40_N.convertAnnotation(t));
    for (org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionMaterialComponent t : src.getMaterial())
      tgt.addMaterial(convertDeviceDefinitionMaterialComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DeviceDefinition convertDeviceDefinition(org.hl7.fhir.model.core.DeviceDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DeviceDefinition tgt = new org.hl7.fhir.r4.model.DeviceDefinition();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, OWNER_EXTENSION_URL);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent t : src.getUdiDeviceIdentifierList())
      tgt.addUdiDeviceIdentifier(convertDeviceDefinitionUdiDeviceIdentifierComponent(t));
    if (src.hasManufacturer())
      tgt.setManufacturer(Reference40_N.convertReference(src.getManufacturer()));
    for (org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionDeviceNameComponent t : src.getDeviceNameList())
      tgt.addDeviceName(convertDeviceDefinitionDeviceNameComponent(t));
    if (src.hasModelNumber())
      tgt.setModelNumberElement(String40_N.convertString(src.getModelNumberElement()));
    for (DeviceDefinitionClassificationComponent t : src.getClassificationList())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(t.getType()));
    for (DeviceDefinitionDeviceVersionComponent t : src.getDeviceVersionList())
      if (t.hasValue())
        tgt.getVersion().add(String40_N.convertString(t.getValueElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getSafetyList())
      tgt.addSafety(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.ProductShelfLife t : src.getShelfLifeStorageList())
      tgt.addShelfLifeStorage(ProductShelfLife40_N.convertProductShelfLife(t));
    for (CodeType t : src.getOutputLanguageList())
      tgt.addLanguageCode(convertLanguage(t));
    for (org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionPropertyComponent t : src.getPropertyList())
      tgt.addProperty(convertDeviceDefinitionPropertyComponent(t));
    if (src.hasExtension(OWNER_EXTENSION_URL))
      tgt.setOwner(Reference40_N.convertReference((org.hl7.fhir.model.core.Reference) src.getExtensionByUrl(OWNER_EXTENSION_URL).getValue()));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getContactList())
      for (org.hl7.fhir.model.core.ContactPoint tt : t.getTelecomList())
        tgt.addContact(ContactPoint40_N.convertContactPoint(tt));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList())
      tgt.addNote(Annotation40_N.convertAnnotation(t));
    for (org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionMaterialComponent t : src.getMaterialList())
      tgt.addMaterial(convertDeviceDefinitionMaterialComponent(t));
    return tgt;
  }

  private static CodeType convertLanguage(org.hl7.fhir.r4.model.CodeableConcept src) {
    if (src == null || src.isEmpty())
      return null;
    for (org.hl7.fhir.r4.model.Coding t : src.getCoding()) {
      if (SYSTEM_LANG.equals(t.getSystem()) && t.hasCode()) {
        CodeType tgt = new CodeType(t.getCode());
        ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
        return tgt;
      }
    }
    return null;
  }

  private static org.hl7.fhir.r4.model.CodeableConcept convertLanguage(CodeType src) {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.CodeableConcept tgt = new org.hl7.fhir.r4.model.CodeableConcept();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasValue())
      tgt.addCoding().setSystem(SYSTEM_LANG).setCode(src.getValue());
    return tgt;
  }

  public static org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent convertDeviceDefinitionUdiDeviceIdentifierComponent(org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent tgt = new org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasDeviceIdentifier())
      tgt.setDeviceIdentifierElement(String40_N.convertString(src.getDeviceIdentifierElement()));
    if (src.hasIssuer())
      tgt.setIssuerElement(Uri40_N.convertUri(src.getIssuerElement()));
    if (src.hasJurisdiction())
      tgt.setJurisdictionElement(Uri40_N.convertUri(src.getJurisdictionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent convertDeviceDefinitionUdiDeviceIdentifierComponent(org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent tgt = new org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasDeviceIdentifier())
      tgt.setDeviceIdentifierElement(String40_N.convertString(src.getDeviceIdentifierElement()));
    if (src.hasIssuer())
      tgt.setIssuerElement(Uri40_N.convertUri(src.getIssuerElement()));
    if (src.hasJurisdiction())
      tgt.setJurisdictionElement(Uri40_N.convertUri(src.getJurisdictionElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionDeviceNameComponent convertDeviceDefinitionDeviceNameComponent(org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionDeviceNameComponent tgt = new org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionDeviceNameComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasType())
      tgt.setType(convertDeviceNameType(src.getTypeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent convertDeviceDefinitionDeviceNameComponent(org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionDeviceNameComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent tgt = new org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasType())
      tgt.setTypeElement(convertDeviceNameType(src.getType()));
    return tgt;
  }

  // R4 device-nametype codes map onto the R5 codes the same way DeviceDefinition40_50 does; R6 holds the type as a CodeableConcept
  static public org.hl7.fhir.model.core.CodeableConcept convertDeviceNameType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.CodeableConcept tgt = new org.hl7.fhir.model.core.CodeableConcept();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType> convertDeviceNameType(org.hl7.fhir.model.core.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameTypeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    for (org.hl7.fhir.model.core.Coding t : src.getCodingList()) {
      if (SYSTEM_NAME_TYPE.equals(t.getSystem()) && t.hasCode()) {
        switch (t.getCode()) {
          case "user-friendly-name":
            tgt.setValue(org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType.USERFRIENDLYNAME);
            return tgt;
          case "patient-reported-name":
            tgt.setValue(org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType.PATIENTREPORTEDNAME);
            return tgt;
          case "registered-name":
            tgt.setValue(org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType.MANUFACTURERNAME);
            return tgt;
          default:
            break;
        }
      }
    }
    tgt.setValue(org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType.NULL);
    return tgt;
  }
//
//  public static org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionSpecializationComponent convertDeviceDefinitionSpecializationComponent(org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionSpecializationComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionSpecializationComponent tgt = new org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionSpecializationComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    if (src.hasSystemType())
//      tgt.setSystemTypeElement(String40_N.convertString(src.getSystemTypeElement()));
//    if (src.hasVersion())
//      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionSpecializationComponent convertDeviceDefinitionSpecializationComponent(org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionSpecializationComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionSpecializationComponent tgt = new org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionSpecializationComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    if (src.hasSystemType())
//      tgt.setSystemTypeElement(String40_N.convertString(src.getSystemTypeElement()));
//    if (src.hasVersion())
//      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionCapabilityComponent convertDeviceDefinitionCapabilityComponent(org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionCapabilityComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionCapabilityComponent tgt = new org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionCapabilityComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    if (src.hasType())
//      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
//    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getDescription())
//      tgt.addDescription(CodeableConcept40_N.convertCodeableConcept(t));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionCapabilityComponent convertDeviceDefinitionCapabilityComponent(org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionCapabilityComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionCapabilityComponent tgt = new org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionCapabilityComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    if (src.hasType())
//      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
//    for (org.hl7.fhir.model.core.CodeableConcept t : src.getDescription())
//      tgt.addDescription(CodeableConcept40_N.convertCodeableConcept(t));
//    return tgt;
//  }

  public static org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionPropertyComponent convertDeviceDefinitionPropertyComponent(org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionPropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionPropertyComponent tgt = new org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionPropertyComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4.model.Quantity t : src.getValueQuantity())
      tgt.setValue(Quantity40_N.convertQuantity(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getValueCode())
      tgt.setValue(CodeableConcept40_N.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionPropertyComponent convertDeviceDefinitionPropertyComponent(org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionPropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionPropertyComponent tgt = new org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionPropertyComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasValueQuantity())
      tgt.addValueQuantity(Quantity40_N.convertQuantity(src.getValueQuantity()));
    if (src.hasValueCodeableConcept())
      tgt.addValueCode(CodeableConcept40_N.convertCodeableConcept(src.getValueCodeableConcept()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionMaterialComponent convertDeviceDefinitionMaterialComponent(org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionMaterialComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionMaterialComponent tgt = new org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionMaterialComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSubstance())
      tgt.setSubstance(CodeableConcept40_N.convertCodeableConcept(src.getSubstance()));
    if (src.hasAlternate())
      tgt.setAlternateElement(Boolean40_N.convertBoolean(src.getAlternateElement()));
    if (src.hasAllergenicIndicator())
      tgt.setAllergenicIndicatorElement(Boolean40_N.convertBoolean(src.getAllergenicIndicatorElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionMaterialComponent convertDeviceDefinitionMaterialComponent(org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionMaterialComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionMaterialComponent tgt = new org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionMaterialComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSubstance())
      tgt.setSubstance(CodeableConcept40_N.convertCodeableConcept(src.getSubstance()));
    if (src.hasAlternate())
      tgt.setAlternateElement(Boolean40_N.convertBoolean(src.getAlternateElement()));
    if (src.hasAllergenicIndicator())
      tgt.setAllergenicIndicatorElement(Boolean40_N.convertBoolean(src.getAllergenicIndicatorElement()));
    return tgt;
  }
}
