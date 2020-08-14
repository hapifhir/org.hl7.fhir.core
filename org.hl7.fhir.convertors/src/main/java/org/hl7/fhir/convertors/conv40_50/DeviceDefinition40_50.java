package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
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
public class DeviceDefinition40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.DeviceDefinition convertDeviceDefinition(org.hl7.fhir.r4.model.DeviceDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.DeviceDefinition tgt = new org.hl7.fhir.r5.model.DeviceDefinition();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        for (org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent t : src.getUdiDeviceIdentifier()) tgt.addUdiDeviceIdentifier(convertDeviceDefinitionUdiDeviceIdentifierComponent(t));
        if (src.hasManufacturer())
            tgt.setManufacturer(convertType(src.getManufacturer()));
        for (org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent t : src.getDeviceName()) tgt.addDeviceName(convertDeviceDefinitionDeviceNameComponent(t));
        if (src.hasModelNumber())
            tgt.setModelNumberElement(convertString(src.getModelNumberElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionSpecializationComponent t : src.getSpecialization()) tgt.addSpecialization(convertDeviceDefinitionSpecializationComponent(t));
        for (org.hl7.fhir.r4.model.StringType t : src.getVersion()) tgt.getVersion().add(convertString(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSafety()) tgt.addSafety(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.ProductShelfLife t : src.getShelfLifeStorage()) tgt.addShelfLifeStorage(convertProductShelfLife(t));
        if (src.hasPhysicalCharacteristics())
            tgt.setPhysicalCharacteristics(convertProdCharacteristic(src.getPhysicalCharacteristics()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getLanguageCode()) tgt.addLanguageCode(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionCapabilityComponent t : src.getCapability()) tgt.addCapability(convertDeviceDefinitionCapabilityComponent(t));
        for (org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionPropertyComponent t : src.getProperty()) tgt.addProperty(convertDeviceDefinitionPropertyComponent(t));
        if (src.hasOwner())
            tgt.setOwner(convertReference(src.getOwner()));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getContact()) tgt.addContact(convertContactPoint(t));
        if (src.hasOnlineInformation())
            tgt.setOnlineInformationElement(convertUri(src.getOnlineInformationElement()));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        if (src.hasQuantity())
            tgt.setQuantity(convertQuantity(src.getQuantity()));
        if (src.hasParentDevice())
            tgt.setParentDevice(convertReference(src.getParentDevice()));
        for (org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionMaterialComponent t : src.getMaterial()) tgt.addMaterial(convertDeviceDefinitionMaterialComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DeviceDefinition convertDeviceDefinition(org.hl7.fhir.r5.model.DeviceDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.DeviceDefinition tgt = new org.hl7.fhir.r4.model.DeviceDefinition();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        for (org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent t : src.getUdiDeviceIdentifier()) tgt.addUdiDeviceIdentifier(convertDeviceDefinitionUdiDeviceIdentifierComponent(t));
        if (src.hasManufacturer())
            tgt.setManufacturer(convertType(src.getManufacturer()));
        for (org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent t : src.getDeviceName()) tgt.addDeviceName(convertDeviceDefinitionDeviceNameComponent(t));
        if (src.hasModelNumber())
            tgt.setModelNumberElement(convertString(src.getModelNumberElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionSpecializationComponent t : src.getSpecialization()) tgt.addSpecialization(convertDeviceDefinitionSpecializationComponent(t));
        for (org.hl7.fhir.r5.model.StringType t : src.getVersion()) tgt.getVersion().add(convertString(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSafety()) tgt.addSafety(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.ProductShelfLife t : src.getShelfLifeStorage()) tgt.addShelfLifeStorage(convertProductShelfLife(t));
        if (src.hasPhysicalCharacteristics())
            tgt.setPhysicalCharacteristics(convertProdCharacteristic(src.getPhysicalCharacteristics()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getLanguageCode()) tgt.addLanguageCode(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionCapabilityComponent t : src.getCapability()) tgt.addCapability(convertDeviceDefinitionCapabilityComponent(t));
        for (org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionPropertyComponent t : src.getProperty()) tgt.addProperty(convertDeviceDefinitionPropertyComponent(t));
        if (src.hasOwner())
            tgt.setOwner(convertReference(src.getOwner()));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getContact()) tgt.addContact(convertContactPoint(t));
        if (src.hasOnlineInformation())
            tgt.setOnlineInformationElement(convertUri(src.getOnlineInformationElement()));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        if (src.hasQuantity())
            tgt.setQuantity(convertQuantity(src.getQuantity()));
        if (src.hasParentDevice())
            tgt.setParentDevice(convertReference(src.getParentDevice()));
        for (org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionMaterialComponent t : src.getMaterial()) tgt.addMaterial(convertDeviceDefinitionMaterialComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent convertDeviceDefinitionUdiDeviceIdentifierComponent(org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent tgt = new org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent();
        copyElement(src, tgt);
        if (src.hasDeviceIdentifier())
            tgt.setDeviceIdentifierElement(convertString(src.getDeviceIdentifierElement()));
        if (src.hasIssuer())
            tgt.setIssuerElement(convertUri(src.getIssuerElement()));
        if (src.hasJurisdiction())
            tgt.setJurisdictionElement(convertUri(src.getJurisdictionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent convertDeviceDefinitionUdiDeviceIdentifierComponent(org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent tgt = new org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent();
        copyElement(src, tgt);
        if (src.hasDeviceIdentifier())
            tgt.setDeviceIdentifierElement(convertString(src.getDeviceIdentifierElement()));
        if (src.hasIssuer())
            tgt.setIssuerElement(convertUri(src.getIssuerElement()));
        if (src.hasJurisdiction())
            tgt.setJurisdictionElement(convertUri(src.getJurisdictionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent convertDeviceDefinitionDeviceNameComponent(org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent tgt = new org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent();
        copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasType())
            tgt.setTypeElement(convertDeviceNameType(src.getTypeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent convertDeviceDefinitionDeviceNameComponent(org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent tgt = new org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent();
        copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasType())
            tgt.setTypeElement(convertDeviceNameType(src.getTypeElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DeviceNameType> convertDeviceNameType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DeviceNameType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.DeviceNameTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case UDILABELNAME:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DeviceNameType.UDILABELNAME);
                break;
            case USERFRIENDLYNAME:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DeviceNameType.USERFRIENDLYNAME);
                break;
            case PATIENTREPORTEDNAME:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DeviceNameType.PATIENTREPORTEDNAME);
                break;
            case MANUFACTURERNAME:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DeviceNameType.MANUFACTURERNAME);
                break;
            case MODELNAME:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DeviceNameType.MODELNAME);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DeviceNameType.OTHER);
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
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case UDILABELNAME:
                tgt.setValue(org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType.UDILABELNAME);
                break;
            case USERFRIENDLYNAME:
                tgt.setValue(org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType.USERFRIENDLYNAME);
                break;
            case PATIENTREPORTEDNAME:
                tgt.setValue(org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType.PATIENTREPORTEDNAME);
                break;
            case MANUFACTURERNAME:
                tgt.setValue(org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType.MANUFACTURERNAME);
                break;
            case MODELNAME:
                tgt.setValue(org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType.MODELNAME);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType.OTHER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionSpecializationComponent convertDeviceDefinitionSpecializationComponent(org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionSpecializationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionSpecializationComponent tgt = new org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionSpecializationComponent();
        copyElement(src, tgt);
        if (src.hasSystemType())
            tgt.setSystemTypeElement(convertString(src.getSystemTypeElement()));
        if (src.hasVersion())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionSpecializationComponent convertDeviceDefinitionSpecializationComponent(org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionSpecializationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionSpecializationComponent tgt = new org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionSpecializationComponent();
        copyElement(src, tgt);
        if (src.hasSystemType())
            tgt.setSystemTypeElement(convertString(src.getSystemTypeElement()));
        if (src.hasVersion())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionCapabilityComponent convertDeviceDefinitionCapabilityComponent(org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionCapabilityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionCapabilityComponent tgt = new org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionCapabilityComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getDescription()) tgt.addDescription(convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionCapabilityComponent convertDeviceDefinitionCapabilityComponent(org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionCapabilityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionCapabilityComponent tgt = new org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionCapabilityComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getDescription()) tgt.addDescription(convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionPropertyComponent convertDeviceDefinitionPropertyComponent(org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionPropertyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionPropertyComponent tgt = new org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionPropertyComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r4.model.Quantity t : src.getValueQuantity()) tgt.addValueQuantity(convertQuantity(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getValueCode()) tgt.addValueCode(convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionPropertyComponent convertDeviceDefinitionPropertyComponent(org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionPropertyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionPropertyComponent tgt = new org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionPropertyComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r5.model.Quantity t : src.getValueQuantity()) tgt.addValueQuantity(convertQuantity(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getValueCode()) tgt.addValueCode(convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionMaterialComponent convertDeviceDefinitionMaterialComponent(org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionMaterialComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionMaterialComponent tgt = new org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionMaterialComponent();
        copyElement(src, tgt);
        if (src.hasSubstance())
            tgt.setSubstance(convertCodeableConcept(src.getSubstance()));
        if (src.hasAlternate())
            tgt.setAlternateElement(convertBoolean(src.getAlternateElement()));
        if (src.hasAllergenicIndicator())
            tgt.setAllergenicIndicatorElement(convertBoolean(src.getAllergenicIndicatorElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionMaterialComponent convertDeviceDefinitionMaterialComponent(org.hl7.fhir.r5.model.DeviceDefinition.DeviceDefinitionMaterialComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionMaterialComponent tgt = new org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionMaterialComponent();
        copyElement(src, tgt);
        if (src.hasSubstance())
            tgt.setSubstance(convertCodeableConcept(src.getSubstance()));
        if (src.hasAlternate())
            tgt.setAlternateElement(convertBoolean(src.getAlternateElement()));
        if (src.hasAllergenicIndicator())
            tgt.setAllergenicIndicatorElement(convertBoolean(src.getAllergenicIndicatorElement()));
        return tgt;
    }
}