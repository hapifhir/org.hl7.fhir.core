package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Annotation43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.ContactPoint43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Quantity43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
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
public class DeviceDefinition43_50 {

  public static org.hl7.fhir.r5.model.DeviceDefinition convertDeviceDefinition(org.hl7.fhir.r4b.model.DeviceDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DeviceDefinition tgt = new org.hl7.fhir.r5.model.DeviceDefinition();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent t : src.getUdiDeviceIdentifier())
      tgt.addUdiDeviceIdentifier(convertDeviceDefinitionUdiDeviceIdentifierComponent(t));
    if (src.hasManufacturerReference())
      tgt.setManufacturer(Reference43_50.convertReference(src.getManufacturerReference()));
    for (org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent t : src.getDeviceName())
      tgt.addDeviceName(convertDeviceDefinitionDeviceNameComponent(t));
    if (src.hasModelNumber())
      tgt.setModelNumberElement(String43_50.convertString(src.getModelNumberElement()));
    if (src.hasType())
      tgt.addClassification().setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
//    for (org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionSpecializationComponent t : src.getSpecialization())
//      tgt.addSpecialization(convertDeviceDefinitionSpecializationComponent(t));
    for (org.hl7.fhir.r4b.model.StringType t : src.getVersion())
      tgt.getVersion().add(new DeviceDefinitionVersionComponent().setValueElement(String43_50.convertString(t)));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSafety())
      tgt.addSafety(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.ProductShelfLife t : src.getShelfLifeStorage())
      tgt.addShelfLifeStorage(ProductShelfLife43_50.convertProductShelfLife(t));
//    if (src.hasPhysicalCharacteristics())
//      tgt.setPhysicalCharacteristics(ProdCharacteristic43_50.convertProdCharacteristic(src.getPhysicalCharacteristics()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getLanguageCode())
      tgt.addLanguageCode(CodeableConcept43_50.convertCodeableConcept(t));
//    for (org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionCapabilityComponent t : src.getCapability())
//      tgt.addCapability(convertDeviceDefinitionCapabilityComponent(t));
    for (org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionPropertyComponent t : src.getProperty())
      tgt.addProperty(convertDeviceDefinitionPropertyComponent(t));
    if (src.hasOwner())
      tgt.setOwner(Reference43_50.convertReference(src.getOwner()));
    for (org.hl7.fhir.r4b.model.ContactPoint t : src.getContact())
      tgt.addContact(ContactPoint43_50.convertContactPoint(t));
//    if (src.hasOnlineInformation())
//      tgt.setOnlineInformationElement(Uri43_50.convertUri(src.getOnlineInformationElement()));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
//    if (src.hasParentDevice())
//      tgt.setParentDevice(Reference43_50.convertReference(src.getParentDevice()));
    for (org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionMaterialComponent t : src.getMaterial())
      tgt.addMaterial(convertDeviceDefinitionMaterialComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DeviceDefinition convertDeviceDefinition(org.hl7.fhir.r5.model.DeviceDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.DeviceDefinition tgt = new org.hl7.fhir.r4b.model.DeviceDefinition();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent t : src.getUdiDeviceIdentifier())
      tgt.addUdiDeviceIdentifier(convertDeviceDefinitionUdiDeviceIdentifierComponent(t));
    if (src.hasManufacturer())
      tgt.setManufacturer(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getManufacturer()));
    for (org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent t : src.getDeviceName())
      tgt.addDeviceName(convertDeviceDefinitionDeviceNameComponent(t));
    if (src.hasModelNumber())
      tgt.setModelNumberElement(String43_50.convertString(src.getModelNumberElement()));
    for (DeviceDefinitionClassificationComponent t : src.getClassification())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(t.getType()));
//    for (org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionSpecializationComponent t : src.getSpecialization())
//      tgt.addSpecialization(convertDeviceDefinitionSpecializationComponent(t));
    for (DeviceDefinitionVersionComponent t : src.getVersion())
      tgt.getVersion().add(String43_50.convertString(t.getValueElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSafety())
      tgt.addSafety(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.ProductShelfLife t : src.getShelfLifeStorage())
      tgt.addShelfLifeStorage(ProductShelfLife43_50.convertProductShelfLife(t));
//    if (src.hasPhysicalCharacteristics())
//      tgt.setPhysicalCharacteristics(ProdCharacteristic43_50.convertProdCharacteristic(src.getPhysicalCharacteristics()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getLanguageCode())
      tgt.addLanguageCode(CodeableConcept43_50.convertCodeableConcept(t));
//    for (org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionCapabilityComponent t : src.getCapability())
//      tgt.addCapability(convertDeviceDefinitionCapabilityComponent(t));
    for (org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionPropertyComponent t : src.getProperty())
      tgt.addProperty(convertDeviceDefinitionPropertyComponent(t));
    if (src.hasOwner())
      tgt.setOwner(Reference43_50.convertReference(src.getOwner()));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getContact())
      tgt.addContact(ContactPoint43_50.convertContactPoint(t));
//    if (src.hasOnlineInformation())
//      tgt.setOnlineInformationElement(Uri43_50.convertUri(src.getOnlineInformationElement()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
//    if (src.hasParentDevice())
//      tgt.setParentDevice(Reference43_50.convertReference(src.getParentDevice()));
    for (org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionMaterialComponent t : src.getMaterial())
      tgt.addMaterial(convertDeviceDefinitionMaterialComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent convertDeviceDefinitionUdiDeviceIdentifierComponent(org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent tgt = new org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasDeviceIdentifier())
      tgt.setDeviceIdentifierElement(String43_50.convertString(src.getDeviceIdentifierElement()));
    if (src.hasIssuer())
      tgt.setIssuerElement(Uri43_50.convertUri(src.getIssuerElement()));
    if (src.hasJurisdiction())
      tgt.setJurisdictionElement(Uri43_50.convertUri(src.getJurisdictionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent convertDeviceDefinitionUdiDeviceIdentifierComponent(org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent tgt = new org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasDeviceIdentifier())
      tgt.setDeviceIdentifierElement(String43_50.convertString(src.getDeviceIdentifierElement()));
    if (src.hasIssuer())
      tgt.setIssuerElement(Uri43_50.convertUri(src.getIssuerElement()));
    if (src.hasJurisdiction())
      tgt.setJurisdictionElement(Uri43_50.convertUri(src.getJurisdictionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent convertDeviceDefinitionDeviceNameComponent(org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent tgt = new org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasType())
      tgt.setTypeElement(convertDeviceNameType(src.getTypeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent convertDeviceDefinitionDeviceNameComponent(org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent tgt = new org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
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
//
//  public static org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionSpecializationComponent convertDeviceDefinitionSpecializationComponent(org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionSpecializationComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionSpecializationComponent tgt = new org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionSpecializationComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
//    if (src.hasSystemType())
//      tgt.setSystemTypeElement(String43_50.convertString(src.getSystemTypeElement()));
//    if (src.hasVersion())
//      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionSpecializationComponent convertDeviceDefinitionSpecializationComponent(org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionSpecializationComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionSpecializationComponent tgt = new org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionSpecializationComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
//    if (src.hasSystemType())
//      tgt.setSystemTypeElement(String43_50.convertString(src.getSystemTypeElement()));
//    if (src.hasVersion())
//      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionCapabilityComponent convertDeviceDefinitionCapabilityComponent(org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionCapabilityComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionCapabilityComponent tgt = new org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionCapabilityComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
//    if (src.hasType())
//      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
//    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getDescription())
//      tgt.addDescription(CodeableConcept43_50.convertCodeableConcept(t));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionCapabilityComponent convertDeviceDefinitionCapabilityComponent(org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionCapabilityComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionCapabilityComponent tgt = new org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionCapabilityComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
//    if (src.hasType())
//      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
//    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getDescription())
//      tgt.addDescription(CodeableConcept43_50.convertCodeableConcept(t));
//    return tgt;
//  }

  public static org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionPropertyComponent convertDeviceDefinitionPropertyComponent(org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionPropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionPropertyComponent tgt = new org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionPropertyComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4b.model.Quantity t : src.getValueQuantity())
      tgt.setValue(Quantity43_50.convertQuantity(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getValueCode())
      tgt.setValue(CodeableConcept43_50.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionPropertyComponent convertDeviceDefinitionPropertyComponent(org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionPropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionPropertyComponent tgt = new org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionPropertyComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasValueQuantity())
      tgt.addValueQuantity(Quantity43_50.convertQuantity(src.getValueQuantity()));
    if (src.hasValueCodeableConcept())
      tgt.addValueCode(CodeableConcept43_50.convertCodeableConcept(src.getValueCodeableConcept()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionMaterialComponent convertDeviceDefinitionMaterialComponent(org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionMaterialComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionMaterialComponent tgt = new org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionMaterialComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSubstance())
      tgt.setSubstance(CodeableConcept43_50.convertCodeableConcept(src.getSubstance()));
    if (src.hasAlternate())
      tgt.setAlternateElement(Boolean43_50.convertBoolean(src.getAlternateElement()));
    if (src.hasAllergenicIndicator())
      tgt.setAllergenicIndicatorElement(Boolean43_50.convertBoolean(src.getAllergenicIndicatorElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionMaterialComponent convertDeviceDefinitionMaterialComponent(org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionMaterialComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionMaterialComponent tgt = new org.hl7.fhir.r4b.model.DeviceDefinition.DeviceDefinitionMaterialComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSubstance())
      tgt.setSubstance(CodeableConcept43_50.convertCodeableConcept(src.getSubstance()));
    if (src.hasAlternate())
      tgt.setAlternateElement(Boolean43_50.convertBoolean(src.getAlternateElement()));
    if (src.hasAllergenicIndicator())
      tgt.setAllergenicIndicatorElement(Boolean43_50.convertBoolean(src.getAllergenicIndicatorElement()));
    return tgt;
  }
}
