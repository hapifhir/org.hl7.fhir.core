package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionDatatype40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
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

  private static final String CONTACT_URL = CrossVersionElements40_N.url("DeviceDefinition", "6.0", "contact");


  // R6 dropped DeviceDefinition.owner - carried as the same cross-version extension DeviceDefinition50_N uses
  public static final String OWNER_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-DeviceDefinition.owner";
  private static final String SYSTEM_NAME_TYPE = "http://hl7.org/fhir/device-nametype";
  private static final String SYSTEM_LANG = "urn:ietf:bcp:47";

  public static org.hl7.fhir.model.core.DeviceDefinition convertDeviceDefinition(org.hl7.fhir.r4.model.DeviceDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DeviceDefinition tgt = new org.hl7.fhir.model.core.DeviceDefinition();
    // R6 dropped these
    CrossVersionElements40_N.r4ElementsToExtensions(src, "DeviceDefinition", tgt.getExtension(), "capability", "onlineInformation", "parentDevice", "physicalCharacteristics", "quantity");
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("DeviceDefinition", "5.0", new String[] {"description", "partNumber", "regulatoryIdentifier", "hasPart", "packaging", "link", "productionIdentifierInUDI", "guideline", "correctiveAction", "chargeItem"}, CrossVersionElements40_N.urls("DeviceDefinition", "6.0", new String[] {"versionAlgorithm", "name", "title", "status", "experimental", "date", "publisher", "useContext", "jurisdiction", "purpose", "copyright", "copyrightLabel", "approvalDate", "lastReviewDate", "effectivePeriod", "additive", "version"}, CrossVersionElements40_N.url("DeviceDefinition", "6.0", "deviceVersion"))));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "description", "partNumber", "regulatoryIdentifier", "hasPart", "packaging", "link", "productionIdentifierInUDI", "guideline", "correctiveAction", "chargeItem");
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "versionAlgorithm", "name", "title", "status", "experimental", "date", "publisher", "useContext", "jurisdiction", "purpose", "copyright", "copyrightLabel", "approvalDate", "lastReviewDate", "effectivePeriod", "additive", "version");
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionUdiDeviceIdentifierComponent t : src.getUdiDeviceIdentifier())
      tgt.addUdiDeviceIdentifier(convertDeviceDefinitionUdiDeviceIdentifierComponent(t));
    if (src.hasManufacturerReference())
      tgt.setManufacturer(Reference40_N.convertReference(src.getManufacturerReference()));
    else if (src.hasManufacturerStringType())
      // R6 manufacturer is only a Reference
      CrossVersionElements40_N.r4ElementsToExtensions(src, "DeviceDefinition", tgt.getExtension(), "manufacturer");
    for (org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent t : src.getDeviceName())
      tgt.addDeviceName(convertDeviceDefinitionDeviceNameComponent(t));
    if (src.hasModelNumber())
      tgt.setModelNumberElement(String40_N.convertString(src.getModelNumberElement()));
    if (src.hasType())
      tgt.addClassification().setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    // the classifications that aren't just a type
    CrossVersionElements40_N.extraValuesToR6(src.getExtension(), tgt, "classification", tgt.getExtension());
    for (org.hl7.fhir.r4.model.StringType t : src.getVersion())
      tgt.addDeviceVersion().setValueElement(String40_N.convertString(t));
    // the R6 deviceVersions that are more than a value
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "deviceVersion");
    for (org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionSpecializationComponent t : src.getSpecialization())
      tgt.addConformsTo(convertSpecialization(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSafety())
      tgt.addSafety(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.ProductShelfLife t : src.getShelfLifeStorage())
      tgt.addShelfLifeStorage(ProductShelfLife40_N.convertProductShelfLife(t));
    // a language code that isn't just the BCP-47 code is kept as a 4.0 extension
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getLanguageCode()) {
      CodeType lang = convertLanguage(t);
      if (lang != null && t.equalsDeep(convertLanguage(lang)))
        tgt.getOutputLanguageList().add(lang);
      else
        tgt.addExtension(CrossVersionElements40_N.url("DeviceDefinition", "4.0", "languageCode"), CodeableConcept40_N.convertCodeableConcept(t));
    }
    // R6 property has a single value: an R4 property with several becomes several properties (as for Device)
    for (org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionPropertyComponent t : src.getProperty()) {
      if (t.getValueQuantity().size() + t.getValueCode().size() <= 1) {
        tgt.addProperty(convertDeviceDefinitionPropertyComponent(t));
      } else {
        for (org.hl7.fhir.r4.model.Quantity q : t.getValueQuantity()) {
          org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionPropertyComponent p = tgt.addProperty();
          ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(t, p);
          if (t.hasType())
            p.setType(CodeableConcept40_N.convertCodeableConcept(t.getType()));
          p.setValue(Quantity40_N.convertQuantity(q));
        }
        for (org.hl7.fhir.r4.model.CodeableConcept c : t.getValueCode()) {
          org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionPropertyComponent p = tgt.addProperty();
          ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(t, p);
          if (t.hasType())
            p.setType(CodeableConcept40_N.convertCodeableConcept(t.getType()));
          p.setValue(CodeableConcept40_N.convertCodeableConcept(c));
        }
      }
    }
    if (src.hasOwner())
      tgt.addExtension(OWNER_EXTENSION_URL, Reference40_N.convertReference(src.getOwner()));
    // R6 contacts that are more than one set of telecoms come back from the extension (see below)
    if (src.hasExtension(CONTACT_URL))
      CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "DeviceDefinition", "6.0", "contact");
    else
      for (org.hl7.fhir.r4.model.ContactPoint t : src.getContact())
        tgt.getContactFirstRep().addTelecom(ContactPoint40_N.convertContactPoint(t));
    tgt.getExtension().removeIf(e -> CONTACT_URL.equals(e.getUrl()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote())
      tgt.addNote(Annotation40_N.convertAnnotation(t));
    for (org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionMaterialComponent t : src.getMaterial())
      tgt.addMaterial(convertDeviceDefinitionMaterialComponent(t));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DeviceDefinition convertDeviceDefinition(org.hl7.fhir.model.core.DeviceDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DeviceDefinition tgt = new org.hl7.fhir.r4.model.DeviceDefinition();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("DeviceDefinition", "4.0", new String[] {"capability", "onlineInformation", "parentDevice", "physicalCharacteristics", "quantity", "manufacturer", "languageCode"}, OWNER_EXTENSION_URL));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "DeviceDefinition", "capability", "onlineInformation", "parentDevice", "physicalCharacteristics", "quantity", "manufacturer", "languageCode");
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "description", "partNumber", "regulatoryIdentifier", "hasPart", "packaging", "link", "productionIdentifierInUDI", "guideline", "correctiveAction", "chargeItem");
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", "versionAlgorithm", "name", "title", "status", "experimental", "date", "publisher", "useContext", "jurisdiction", "purpose", "copyright", "copyrightLabel", "approvalDate", "lastReviewDate", "effectivePeriod", "additive", "version");
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
    // R4 has a single type: the first classification, if it's just a type; the rest in extensions
    DeviceDefinitionClassificationComponent first = src.getClassificationList().isEmpty() ? null : src.getClassificationList().get(0);
    if (first != null && first.hasType() && !first.hasJustification() && !first.hasId() && !first.hasExtension() && !first.hasModifierExtension()) {
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(first.getType()));
      CrossVersionElements40_N.valuesToR4(src, "classification", 1, tgt.getExtension());
    } else
      CrossVersionElements40_N.valuesToR4(src, "classification", 0, tgt.getExtension());
    for (DeviceDefinitionDeviceVersionComponent t : src.getDeviceVersionList())
      if (t.hasValue() && !t.hasType() && !t.hasComponent() && !t.hasId() && !t.hasExtension() && !t.hasModifierExtension())
        tgt.getVersion().add(String40_N.convertString(t.getValueElement()));
      else
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url("DeviceDefinition", "6.0", "deviceVersion"), t));
    for (org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionConformsToComponent t : src.getConformsToList())
      tgt.addSpecialization(convertSpecialization(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getSafetyList())
      tgt.addSafety(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.ProductShelfLife t : src.getShelfLifeStorageList())
      tgt.addShelfLifeStorage(ProductShelfLife40_N.convertProductShelfLife(t));
    for (CodeType t : src.getOutputLanguageList())
      tgt.addLanguageCode(convertLanguage(t));

    // R4 to R6 split an R4 property with several values into one property per value: consecutive properties
    // with the same type are collected into one again (see mergeProperty)
    for (org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionPropertyComponent t : src.getPropertyList()) {
      org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionPropertyComponent p = convertDeviceDefinitionPropertyComponent(t);
      if (tgt.getProperty().isEmpty() || !mergeProperty(tgt.getProperty().get(tgt.getProperty().size() - 1), p))
        tgt.addProperty(p);
    }
    if (src.hasExtension(OWNER_EXTENSION_URL))
      tgt.setOwner(Reference40_N.convertReference((org.hl7.fhir.model.core.Reference) src.getExtensionByUrl(OWNER_EXTENSION_URL).getValue()));
    // R4 contact is the telecoms of the R6 contacts; unless that's all there is (one ContactDetail with only telecoms),
    // the R6 contacts are a 6.0 extension as well
    for (org.hl7.fhir.model.core.ContactDetail t : src.getContactList())
      for (org.hl7.fhir.model.core.ContactPoint tt : t.getTelecomList())
        tgt.addContact(ContactPoint40_N.convertContactPoint(tt));
    if (src.getContactList().size() > 1 || (src.hasContact() && (src.getContactFirstRep().hasName() || src.getContactFirstRep().hasId() || src.getContactFirstRep().hasExtension())))
      CrossVersionElements40_N.elementsToExtensionsForPath(src, "DeviceDefinition", tgt.getExtension(), "6.0", "contact");
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList())
      tgt.addNote(Annotation40_N.convertAnnotation(t));
    for (org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionMaterialComponent t : src.getMaterialList())
      tgt.addMaterial(convertDeviceDefinitionMaterialComponent(t));
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
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

  private static final String CONFORMS_TO = "DeviceDefinition.conformsTo";

  /**
   * R4 specialization is R6 conformsTo (as for Device): systemType (a string) is specification (a CodeableConcept; the
   * concept is kept on the string when it's more than text), version is the first version. category, source, and any
   * other versions are 5.0 extensions
   */
  public static org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionConformsToComponent convertSpecialization(org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionSpecializationComponent src) throws FHIRException {
    org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionConformsToComponent tgt = new org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionConformsToComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls(CONFORMS_TO, "5.0", new String[] {"category", "version", "source"}));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, CONFORMS_TO, "5.0", "category");
    if (src.hasSystemType())
      tgt.setSpecification(CodeableConcept40_N.convertStringToCodeableConcept(src.getSystemTypeElement(), CrossVersionElements40_N.url(CONFORMS_TO, "5.0", "specification")));
    if (src.hasVersion())
      tgt.getVersionList().add(String40_N.convertString(src.getVersionElement()));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, CONFORMS_TO, "5.0", "version", "source");
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionSpecializationComponent convertSpecialization(org.hl7.fhir.model.core.DeviceDefinition.DeviceDefinitionConformsToComponent src) throws FHIRException {
    org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionSpecializationComponent tgt = new org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionSpecializationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    CrossVersionElements40_N.elementsToExtensionsForPath(src, CONFORMS_TO, tgt.getExtension(), "5.0", "category");
    if (src.hasSpecification())
      tgt.setSystemTypeElement(CodeableConcept40_N.convertCodeableConceptToString(src.getSpecification(), CrossVersionElements40_N.url(CONFORMS_TO, "5.0", "specification")));
    for (org.hl7.fhir.model.core.StringType t : src.getVersionList()) {
      if (!tgt.hasVersion())
        tgt.setVersionElement(String40_N.convertString(t));
      else
        tgt.addExtension(CrossVersionElements40_N.url(CONFORMS_TO, "5.0", "version"), String40_N.convertString(t));
    }
    CrossVersionElements40_N.elementsToExtensionsForPath(src, CONFORMS_TO, tgt.getExtension(), "5.0", "source");
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
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
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
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
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
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
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
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
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  // R4 device-nametype codes map onto the R6 codes as for Device40_N. R6 has fewer codes: the R4 code is kept (4.0
  // extension on the concept) unless R6 has it too; the R6 concept is kept (6.0 extension on the code) when the R4 code
  // can't make it again
  public static final String NAME_TYPE_EXTENSION_URL = "http://hl7.org/fhir/4.0/StructureDefinition/extension-DeviceDefinition.deviceName.type";
  public static final String NAME_TYPE_CONCEPT_EXTENSION_URL = "http://hl7.org/fhir/6.0/StructureDefinition/extension-DeviceDefinition.deviceName.type";
  private static final String SYSTEM_NAME_TYPE_THO = "http://terminology.hl7.org/CodeSystem/device-nametype";

  static public org.hl7.fhir.model.core.CodeableConcept convertDeviceNameType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.CodeableConcept kept = CodeableConcept40_N.keptCodeableConcept(src, NAME_TYPE_CONCEPT_EXTENSION_URL);
    if (kept != null)
      return kept;
    org.hl7.fhir.model.core.CodeableConcept tgt = new org.hl7.fhir.model.core.CodeableConcept();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, NAME_TYPE_CONCEPT_EXTENSION_URL);
    if (src.getValue() != null) {
      switch (src.getValue()) {
        case USERFRIENDLYNAME:
        case MODELNAME:
          tgt.addCoding(SYSTEM_NAME_TYPE_THO, "user-friendly-name", "User Friendly name");
          break;
        case PATIENTREPORTEDNAME:
          tgt.addCoding(SYSTEM_NAME_TYPE_THO, "patient-reported-name", "Patient Reported name");
          break;
        case MANUFACTURERNAME:
          tgt.addCoding(SYSTEM_NAME_TYPE_THO, "registered-name", "Registered name");
          break;
        default:
          break;
      }
      if (src.getValue() != org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType.USERFRIENDLYNAME && src.getValue() != org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType.PATIENTREPORTEDNAME
        && src.getValue() != org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType.MANUFACTURERNAME)
        tgt.addExtension(NAME_TYPE_EXTENSION_URL, new org.hl7.fhir.model.core.CodeType(src.getValueAsString()));
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType> convertDeviceNameType(org.hl7.fhir.model.core.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameTypeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, NAME_TYPE_EXTENSION_URL);
    if (src.hasExtension(NAME_TYPE_EXTENSION_URL)) {
      tgt.setValueAsString(src.getExtensionByUrl(NAME_TYPE_EXTENSION_URL).getValue().primitiveValue());
    } else if (src.hasCoding(SYSTEM_NAME_TYPE_THO, "user-friendly-name") || src.hasCoding(SYSTEM_NAME_TYPE, "user-friendly-name")) {
      tgt.setValue(org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType.USERFRIENDLYNAME);
    } else if (src.hasCoding(SYSTEM_NAME_TYPE_THO, "patient-reported-name") || src.hasCoding(SYSTEM_NAME_TYPE, "patient-reported-name")) {
      tgt.setValue(org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType.PATIENTREPORTEDNAME);
    } else if (src.hasCoding(SYSTEM_NAME_TYPE_THO, "registered-name") || src.hasCoding(SYSTEM_NAME_TYPE, "registered-name")) {
      tgt.setValue(org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType.MANUFACTURERNAME);
    } else {
      tgt.setValue(org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameType.OTHER);
    }
    // the R4 code doesn't carry all of the R6 concept: if it can't make the same concept again, keep the concept
    CodeableConcept40_N.keepCodeableConcept(src, tgt, convertDeviceNameType(tgt), NAME_TYPE_CONCEPT_EXTENSION_URL);
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
    // a value of a type R4 doesn't have (see below)
    String valueUrl = CrossVersionElements40_N.url("DeviceDefinition.property", "5.0", "value");
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "DeviceDefinition.property", "5.0", "value");
    tgt.getExtension().removeIf(e -> valueUrl.equals(e.getUrl()));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
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
    // R4 only has quantities and codes
    if (src.hasValue() && !src.hasValueQuantity() && !src.hasValueCodeableConcept())
      CrossVersionElements40_N.elementsToExtensionsForPath(src, "DeviceDefinition.property", tgt.getExtension(), "5.0", "value");
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
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
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
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
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  /**
   * Adds the value of next to last, if they're the same property: same type, nothing else (no id or extensions), and
   * one value in next. R4 holds the quantities before the codes, so a quantity after a code isn't merged (that would
   * change the order of the R6 properties when they come back). The cost: two R4 DeviceDefinition properties with the same type
   * and no other content come back as one
   */
  private static boolean mergeProperty(org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionPropertyComponent last, org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionPropertyComponent next) {
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
