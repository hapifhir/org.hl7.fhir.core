package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Annotation40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.ContactPoint40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Quantity40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionClassificationComponent;
import org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionVersionComponent;

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
public class DeviceDefinition40_50 {

  public static org.hl7.fhir.r5.model.DeviceDefinition convertDeviceDefinition(org.hl7.fhir.r4.model.DeviceDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DeviceDefinition tgt = new org.hl7.fhir.r5.model.DeviceDefinition();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent t : src.getUdiDeviceIdentifier())
      tgt.addUdiDeviceIdentifier(convertDeviceDefinitionUdiDeviceIdentifierComponent(t));
    if (src.hasManufacturerReference())
      tgt.setManufacturer(Reference40_50.convertReference(src.getManufacturerReference()));
    for (org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent t : src.getDeviceName())
      tgt.addDeviceName(convertDeviceDefinitionDeviceNameComponent(t));
    if (src.hasModelNumber())
      tgt.setModelNumberElement(String40_50.convertString(src.getModelNumberElement()));
    if (src.hasType())
      tgt.addClassification().setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
//    for (org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionSpecializationComponent t : src.getSpecialization())
//      tgt.addSpecialization(convertDeviceDefinitionSpecializationComponent(t));
    for (org.hl7.fhir.r4.model.StringType t : src.getVersion())
      tgt.getVersion().add(new DeviceDefinitionVersionComponent().setValueElement(String40_50.convertString(t)));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSafety())
      tgt.addSafety(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.ProductShelfLife t : src.getShelfLifeStorage())
      tgt.addShelfLifeStorage(ProductShelfLife40_50.convertProductShelfLife(t));
//    if (src.hasPhysicalCharacteristics())
//      tgt.setPhysicalCharacteristics(ProdCharacteristic40_50.convertProdCharacteristic(src.getPhysicalCharacteristics()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getLanguageCode())
      tgt.addLanguageCode(CodeableConcept40_50.convertCodeableConcept(t));
//    for (org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionCapabilityComponent t : src.getCapability())
//      tgt.addCapability(convertDeviceDefinitionCapabilityComponent(t));
    for (org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionPropertyComponent t : src.getProperty())
      tgt.addProperty(convertDeviceDefinitionPropertyComponent(t));
    if (src.hasOwner())
      tgt.setOwner(Reference40_50.convertReference(src.getOwner()));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getContact())
      tgt.addContact(ContactPoint40_50.convertContactPoint(t));
//    if (src.hasOnlineInformation())
//      tgt.setOnlineInformationElement(Uri40_50.convertUri(src.getOnlineInformationElement()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
//    if (src.hasParentDevice())
//      tgt.setParentDevice(Reference40_50.convertReference(src.getParentDevice()));
    for (org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionMaterialComponent t : src.getMaterial())
      tgt.addMaterial(convertDeviceDefinitionMaterialComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DeviceDefinition convertDeviceDefinition(org.hl7.fhir.r5.model.DeviceDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DeviceDefinition tgt = new org.hl7.fhir.r4.model.DeviceDefinition();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent t : src.getUdiDeviceIdentifier())
      tgt.addUdiDeviceIdentifier(convertDeviceDefinitionUdiDeviceIdentifierComponent(t));
    if (src.hasManufacturer())
      tgt.setManufacturer(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getManufacturer()));
    for (org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent t : src.getDeviceName())
      tgt.addDeviceName(convertDeviceDefinitionDeviceNameComponent(t));
    if (src.hasModelNumber())
      tgt.setModelNumberElement(String40_50.convertString(src.getModelNumberElement()));
    for (DeviceDefinitionClassificationComponent t : src.getClassification())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(t.getType()));
//    for (org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionSpecializationComponent t : src.getSpecialization())
//      tgt.addSpecialization(convertDeviceDefinitionSpecializationComponent(t));
    for (DeviceDefinitionVersionComponent t : src.getVersion())
      tgt.getVersion().add(String40_50.convertString(t.getValueElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSafety())
      tgt.addSafety(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.ProductShelfLife t : src.getShelfLifeStorage())
      tgt.addShelfLifeStorage(ProductShelfLife40_50.convertProductShelfLife(t));
//    if (src.hasPhysicalCharacteristics())
//      tgt.setPhysicalCharacteristics(ProdCharacteristic40_50.convertProdCharacteristic(src.getPhysicalCharacteristics()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getLanguageCode())
      tgt.addLanguageCode(CodeableConcept40_50.convertCodeableConcept(t));
//    for (org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionCapabilityComponent t : src.getCapability())
//      tgt.addCapability(convertDeviceDefinitionCapabilityComponent(t));
    for (org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionPropertyComponent t : src.getProperty())
      tgt.addProperty(convertDeviceDefinitionPropertyComponent(t));
    if (src.hasOwner())
      tgt.setOwner(Reference40_50.convertReference(src.getOwner()));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getContact())
      tgt.addContact(ContactPoint40_50.convertContactPoint(t));
//    if (src.hasOnlineInformation())
//      tgt.setOnlineInformationElement(Uri40_50.convertUri(src.getOnlineInformationElement()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
//    if (src.hasParentDevice())
//      tgt.setParentDevice(Reference40_50.convertReference(src.getParentDevice()));
    for (org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionMaterialComponent t : src.getMaterial())
      tgt.addMaterial(convertDeviceDefinitionMaterialComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent convertDeviceDefinitionUdiDeviceIdentifierComponent(org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent tgt = new org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasDeviceIdentifier())
      tgt.setDeviceIdentifierElement(String40_50.convertString(src.getDeviceIdentifierElement()));
    if (src.hasIssuer())
      tgt.setIssuerElement(Uri40_50.convertUri(src.getIssuerElement()));
    if (src.hasJurisdiction())
      tgt.setJurisdictionElement(Uri40_50.convertUri(src.getJurisdictionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent convertDeviceDefinitionUdiDeviceIdentifierComponent(org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent tgt = new org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasDeviceIdentifier())
      tgt.setDeviceIdentifierElement(String40_50.convertString(src.getDeviceIdentifierElement()));
    if (src.hasIssuer())
      tgt.setIssuerElement(Uri40_50.convertUri(src.getIssuerElement()));
    if (src.hasJurisdiction())
      tgt.setJurisdictionElement(Uri40_50.convertUri(src.getJurisdictionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent convertDeviceDefinitionDeviceNameComponent(org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent tgt = new org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasType())
      tgt.setTypeElement(convertDeviceNameType(src.getTypeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent convertDeviceDefinitionDeviceNameComponent(org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent tgt = new org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasType())
      tgt.setTypeElement(convertDeviceNameType(src.getTypeElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DeviceNameType> convertDeviceNameType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DeviceNameType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.DeviceNameTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DeviceNameType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType> convertDeviceNameType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DeviceNameType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case USERFRIENDLYNAME:
        tgt.setValue(org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType.USERFRIENDLYNAME);
        break;
      case PATIENTREPORTEDNAME:
        tgt.setValue(org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType.PATIENTREPORTEDNAME);
        break;
      case REGISTEREDNAME:
        tgt.setValue(org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType.MANUFACTURERNAME);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType.NULL);
        break;
    }
    return tgt;
  }
//
//  public static org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionSpecializationComponent convertDeviceDefinitionSpecializationComponent(org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionSpecializationComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionSpecializationComponent tgt = new org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionSpecializationComponent();
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
//    if (src.hasSystemType())
//      tgt.setSystemTypeElement(String40_50.convertString(src.getSystemTypeElement()));
//    if (src.hasVersion())
//      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionSpecializationComponent convertDeviceDefinitionSpecializationComponent(org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionSpecializationComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionSpecializationComponent tgt = new org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionSpecializationComponent();
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
//    if (src.hasSystemType())
//      tgt.setSystemTypeElement(String40_50.convertString(src.getSystemTypeElement()));
//    if (src.hasVersion())
//      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionCapabilityComponent convertDeviceDefinitionCapabilityComponent(org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionCapabilityComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionCapabilityComponent tgt = new org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionCapabilityComponent();
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
//    if (src.hasType())
//      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
//    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getDescription())
//      tgt.addDescription(CodeableConcept40_50.convertCodeableConcept(t));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionCapabilityComponent convertDeviceDefinitionCapabilityComponent(org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionCapabilityComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionCapabilityComponent tgt = new org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionCapabilityComponent();
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
//    if (src.hasType())
//      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
//    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getDescription())
//      tgt.addDescription(CodeableConcept40_50.convertCodeableConcept(t));
//    return tgt;
//  }

  public static org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionPropertyComponent convertDeviceDefinitionPropertyComponent(org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionPropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionPropertyComponent tgt = new org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionPropertyComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4.model.Quantity t : src.getValueQuantity())
      tgt.setValue(Quantity40_50.convertQuantity(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getValueCode())
      tgt.setValue(CodeableConcept40_50.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionPropertyComponent convertDeviceDefinitionPropertyComponent(org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionPropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionPropertyComponent tgt = new org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionPropertyComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    if (src.hasValueQuantity())
      tgt.addValueQuantity(Quantity40_50.convertQuantity(src.getValueQuantity()));
    if (src.hasValueCodeableConcept())
      tgt.addValueCode(CodeableConcept40_50.convertCodeableConcept(src.getValueCodeableConcept()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionMaterialComponent convertDeviceDefinitionMaterialComponent(org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionMaterialComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionMaterialComponent tgt = new org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionMaterialComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasSubstance())
      tgt.setSubstance(CodeableConcept40_50.convertCodeableConcept(src.getSubstance()));
    if (src.hasAlternate())
      tgt.setAlternateElement(Boolean40_50.convertBoolean(src.getAlternateElement()));
    if (src.hasAllergenicIndicator())
      tgt.setAllergenicIndicatorElement(Boolean40_50.convertBoolean(src.getAllergenicIndicatorElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionMaterialComponent convertDeviceDefinitionMaterialComponent(org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionMaterialComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionMaterialComponent tgt = new org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionMaterialComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasSubstance())
      tgt.setSubstance(CodeableConcept40_50.convertCodeableConcept(src.getSubstance()));
    if (src.hasAlternate())
      tgt.setAlternateElement(Boolean40_50.convertBoolean(src.getAlternateElement()));
    if (src.hasAllergenicIndicator())
      tgt.setAllergenicIndicatorElement(Boolean40_50.convertBoolean(src.getAllergenicIndicatorElement()));
    return tgt;
  }
}
