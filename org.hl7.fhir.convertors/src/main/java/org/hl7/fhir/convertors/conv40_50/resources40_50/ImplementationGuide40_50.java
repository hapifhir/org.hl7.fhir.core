package org.hl7.fhir.convertors.conv40_50.resources40_50;

import java.util.stream.Collectors;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.ContactDetail40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.UsageContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Canonical40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Code40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Id40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.MarkDown40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Url40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.UrlType;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.utilities.Utilities;

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
public class ImplementationGuide40_50 {

  static final String EXT_IG_DEFINITION_PAGE_NAME = "http://hl7.org/fhir/tools/StructureDefinition/ig-page-name";
  static final String EXT_IG_DEFINITION_PARAMETER = "http://hl7.org/fhir/tools/StructureDefinition/ig-parameter";
  static final String EXT_IG_DEFINITION_PARAM_URL_EXT = "http://hl7.org/fhir/tools/CodeSystem/ig-parameters";
  static final String EXT_IG_DEFINITION_PARAM_URL_BASE = "http://hl7.org/fhir/guide-parameter-code";

  public static org.hl7.fhir.r5.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.r4.model.ImplementationGuide src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide tgt = new org.hl7.fhir.r5.model.ImplementationGuide();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_50.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasPackageId())
      tgt.setPackageIdElement(Id40_50.convertId(src.getPackageIdElement()));
    if (src.hasLicense())
      tgt.setLicenseElement(convertSPDXLicense(src.getLicenseElement()));
    tgt.setFhirVersion(src.getFhirVersion().stream()
      .map(Enumerations40_50::convertFHIRVersion)
      .collect(Collectors.toList()));
    for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent t : src.getDependsOn())
      tgt.addDependsOn(convertImplementationGuideDependsOnComponent(t));
    for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal())
      tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
    if (src.hasDefinition())
      tgt.setDefinition(convertImplementationGuideDefinitionComponent(src.getDefinition()));
    if (src.hasManifest())
      tgt.setManifest(convertImplementationGuideManifestComponent(src.getManifest()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide convertImplementationGuide(ImplementationGuide src, boolean produceIllegalParameters) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide tgt = new org.hl7.fhir.r4.model.ImplementationGuide();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_50.convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasPackageId())
      tgt.setPackageIdElement(Id40_50.convertId(src.getPackageIdElement()));
    if (src.hasLicense())
      tgt.setLicenseElement(convertSPDXLicense(src.getLicenseElement()));
    tgt.setFhirVersion(src.getFhirVersion().stream()
      .map(Enumerations40_50::convertFHIRVersion)
      .collect(Collectors.toList()));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent t : src.getDependsOn())
      tgt.addDependsOn(convertImplementationGuideDependsOnComponent(t));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal())
      tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
    if (src.hasDefinition())
      tgt.setDefinition(convertImplementationGuideDefinitionComponent(src.getDefinition(), produceIllegalParameters));
    if (src.hasManifest())
      tgt.setManifest(convertImplementationGuideManifestComponent(src.getManifest()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense> convertSPDXLicense(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicenseEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.fromCode(src.getValue().toCode()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense> convertSPDXLicense(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicenseEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    tgt.setValue(org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.fromCode(src.getValue().toCode()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent convertImplementationGuideDependsOnComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasUri())
      tgt.setUriElement(Canonical40_50.convertCanonical(src.getUriElement()));
    if (src.hasPackageId())
      tgt.setPackageIdElement(Id40_50.convertId(src.getPackageIdElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent convertImplementationGuideDependsOnComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasUri())
      tgt.setUriElement(Canonical40_50.convertCanonical(src.getUriElement()));
    if (src.hasPackageId())
      tgt.setPackageIdElement(Id40_50.convertId(src.getPackageIdElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(Code40_50.convertCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Canonical40_50.convertCanonical(src.getProfileElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(Code40_50.convertCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Canonical40_50.convertCanonical(src.getProfileElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionComponent convertImplementationGuideDefinitionComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent t : src.getGrouping())
      tgt.addGrouping(convertImplementationGuideDefinitionGroupingComponent(t));
    for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent t : src.getResource())
      tgt.addResource(convertImplementationGuideDefinitionResourceComponent(t));
    if (src.hasPage())
      tgt.setPage(convertImplementationGuideDefinitionPageComponent(src.getPage()));
    for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent t : src.getParameter())
      tgt.addParameter(convertImplementationGuideDefinitionParameterComponent(t));
    for (org.hl7.fhir.r4.model.Extension e : org.hl7.fhir.r4.utils.ToolingExtensions.getExtensions(src, EXT_IG_DEFINITION_PARAMETER)) {
      org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent p = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent();
      p.getCode().setCode(org.hl7.fhir.r4.utils.ToolingExtensions.readStringExtension(e, "code"));
      p.getCode().setSystem(EXT_IG_DEFINITION_PARAM_URL_EXT);
      p.setValue(org.hl7.fhir.r4.utils.ToolingExtensions.readStringExtension(e, "value"));
      tgt.addParameter(p);
    }
    for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent t : src.getTemplate())
      tgt.addTemplate(convertImplementationGuideDefinitionTemplateComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionComponent convertImplementationGuideDefinitionComponent(ImplementationGuide.ImplementationGuideDefinitionComponent src, boolean produceIllegalParameters) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent t : src.getGrouping())
      tgt.addGrouping(convertImplementationGuideDefinitionGroupingComponent(t));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent t : src.getResource())
      tgt.addResource(convertImplementationGuideDefinitionResourceComponent(t));
    if (src.hasPage())
      tgt.setPage(convertImplementationGuideDefinitionPageComponent(src.getPage()));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent t : src.getParameter()) {
        if (produceIllegalParameters || Utilities.existsInList(t.getCode().getCode(), "apply", "path-resource", "path-pages", "path-tx-cache", "expansion-parameter", "rule-broken-links", "generate-xml", "generate-json", "generate-turtle", "html-template")) {
          tgt.addParameter(convertImplementationGuideDefinitionParameterComponent(t));
        } else {
          org.hl7.fhir.r4.model.Extension e = new org.hl7.fhir.r4.model.Extension(EXT_IG_DEFINITION_PARAMETER);
          org.hl7.fhir.r4.model.Extension eCode = new org.hl7.fhir.r4.model.Extension("code", new org.hl7.fhir.r4.model.CodeType(t.getCode().getCode()));
          org.hl7.fhir.r4.model.Extension eValue = new org.hl7.fhir.r4.model.Extension("value", new org.hl7.fhir.r4.model.StringType(t.getValue()));
          e.addExtension(eCode);
          e.addExtension(eValue);
          tgt.addExtension(e);
      }
    }
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent t : src.getTemplate())
      tgt.addTemplate(convertImplementationGuideDefinitionTemplateComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent convertImplementationGuideDefinitionGroupingComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertStringToMarkdown(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent convertImplementationGuideDefinitionGroupingComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent convertImplementationGuideDefinitionResourceComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasReference())
      tgt.setReference(Reference40_50.convertReference(src.getReference()));
    tgt.setFhirVersion(src.getFhirVersion().stream()
      .map(Enumerations40_50::convertFHIRVersion)
      .collect(Collectors.toList()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasExampleBooleanType())
      tgt.setIsExampleElement(Boolean40_50.convertBoolean(src.getExampleBooleanType()));
    if (src.hasExampleCanonicalType())
      tgt.getProfile().add(Canonical40_50.convertCanonical(src.getExampleCanonicalType()));
    if (src.hasGroupingId())
      tgt.setGroupingIdElement(Id40_50.convertId(src.getGroupingIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent convertImplementationGuideDefinitionResourceComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasReference())
      tgt.setReference(Reference40_50.convertReference(src.getReference()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    if (src.hasIsExample())
      tgt.setExample(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getIsExampleElement()));
    if (src.hasProfile())
      tgt.setExample(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getProfile().get(0)));
    if (src.hasGroupingId())
      tgt.setGroupingIdElement(Id40_50.convertId(src.getGroupingIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent convertImplementationGuideDefinitionPageComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt, EXT_IG_DEFINITION_PAGE_NAME);
    if (src.hasExtension(EXT_IG_DEFINITION_PAGE_NAME)) {
      tgt.setNameElement(Url40_50.convertUrl((UrlType) src.getExtensionByUrl(EXT_IG_DEFINITION_PAGE_NAME).getValue()));
    }
    if (src.hasNameReference()) {
      tgt.setSource(new org.hl7.fhir.r5.model.UrlType(src.getNameReference().getReference()));
      if (!tgt.hasName()) {
        tgt.setName(tgt.getSourceUrlType().asStringValue());
      }
    }
    if (src.hasNameUrlType()) {
      tgt.setSource(Url40_50.convertUrl(src.getNameUrlType()));
      if (!tgt.hasName()) {
        tgt.setName(tgt.getSourceUrlType().asStringValue());
      }
    }
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasGeneration())
      tgt.setGenerationElement(convertGuidePageGeneration(src.getGenerationElement()));
    for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent t : src.getPage())
      tgt.addPage(convertImplementationGuideDefinitionPageComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent convertImplementationGuideDefinitionPageComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasName()) {
      tgt.addExtension().setUrl(EXT_IG_DEFINITION_PAGE_NAME).setValue(Url40_50.convertUrl(src.getNameElement()));
    }
    if (src.hasSourceUrlType()) {
      tgt.setName(Url40_50.convertUrl(src.getSourceUrlType()));
    } 
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasGeneration())
      tgt.setGenerationElement(convertGuidePageGeneration(src.getGenerationElement()));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent t : src.getPage())
      tgt.addPage(convertImplementationGuideDefinitionPageComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration> convertGuidePageGeneration(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGeneration> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGenerationEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case HTML:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration.HTML);
        break;
      case MARKDOWN:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration.MARKDOWN);
        break;
      case XML:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration.XML);
        break;
      case GENERATED:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration.GENERATED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGeneration> convertGuidePageGeneration(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGeneration> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGenerationEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case HTML:
        tgt.setValue(org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGeneration.HTML);
        break;
      case MARKDOWN:
        tgt.setValue(org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGeneration.MARKDOWN);
        break;
      case XML:
        tgt.setValue(org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGeneration.XML);
        break;
      case GENERATED:
        tgt.setValue(org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGeneration.GENERATED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGeneration.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent convertImplementationGuideDefinitionParameterComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCode()) {
      tgt.getCode().setCode(src.getCode());
      if (Utilities.existsInList(tgt.getCode().getCode(), "apply", "path-resource", "path-pages", "path-tx-cache", "expansion-parameter", "rule-broken-links", "generate-xml", "generate-json", "generate-turtle", "html-template")) {
        tgt.getCode().setSystem(EXT_IG_DEFINITION_PARAM_URL_BASE);
      } else {
        tgt.getCode().setSystem(EXT_IG_DEFINITION_PARAM_URL_EXT);  
      }
    }
    if (src.hasValue())
      tgt.setValueElement(String40_50.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent convertImplementationGuideDefinitionParameterComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(src.getCode().getCode());
    if (src.hasValue())
      tgt.setValueElement(String40_50.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.utils.GuideParameterCode convertGuideParameterCode(org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
      case APPLY:
        return org.hl7.fhir.r5.utils.GuideParameterCode.APPLY;
      case PATHRESOURCE:
        return org.hl7.fhir.r5.utils.GuideParameterCode.PATHRESOURCE;
      case PATHPAGES:
        return org.hl7.fhir.r5.utils.GuideParameterCode.PATHPAGES;
      case PATHTXCACHE:
        return org.hl7.fhir.r5.utils.GuideParameterCode.PATHTXCACHE;
      case EXPANSIONPARAMETER:
        return org.hl7.fhir.r5.utils.GuideParameterCode.EXPANSIONPARAMETER;
      case RULEBROKENLINKS:
        return org.hl7.fhir.r5.utils.GuideParameterCode.RULEBROKENLINKS;
      case GENERATEXML:
        return org.hl7.fhir.r5.utils.GuideParameterCode.GENERATEXML;
      case GENERATEJSON:
        return org.hl7.fhir.r5.utils.GuideParameterCode.GENERATEJSON;
      case GENERATETURTLE:
        return org.hl7.fhir.r5.utils.GuideParameterCode.GENERATETURTLE;
      case HTMLTEMPLATE:
        return org.hl7.fhir.r5.utils.GuideParameterCode.HTMLTEMPLATE;
      default:
        return org.hl7.fhir.r5.utils.GuideParameterCode.NULL;
    }
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode convertGuideParameterCode(org.hl7.fhir.r5.utils.GuideParameterCode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
      case APPLY:
        return org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode.APPLY;
      case PATHRESOURCE:
        return org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode.PATHRESOURCE;
      case PATHPAGES:
        return org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode.PATHPAGES;
      case PATHTXCACHE:
        return org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode.PATHTXCACHE;
      case EXPANSIONPARAMETER:
        return org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode.EXPANSIONPARAMETER;
      case RULEBROKENLINKS:
        return org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode.RULEBROKENLINKS;
      case GENERATEXML:
        return org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode.GENERATEXML;
      case GENERATEJSON:
        return org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode.GENERATEJSON;
      case GENERATETURTLE:
        return org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode.GENERATETURTLE;
      case HTMLTEMPLATE:
        return org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode.HTMLTEMPLATE;
      default:
        return org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent convertImplementationGuideDefinitionTemplateComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code40_50.convertCode(src.getCodeElement()));
    if (src.hasSource())
      tgt.setSourceElement(String40_50.convertString(src.getSourceElement()));
    if (src.hasScope())
      tgt.setScopeElement(String40_50.convertString(src.getScopeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent convertImplementationGuideDefinitionTemplateComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code40_50.convertCode(src.getCodeElement()));
    if (src.hasSource())
      tgt.setSourceElement(String40_50.convertString(src.getSourceElement()));
    if (src.hasScope())
      tgt.setScopeElement(String40_50.convertString(src.getScopeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideManifestComponent convertImplementationGuideManifestComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideManifestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideManifestComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideManifestComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasRendering())
      tgt.setRenderingElement(Url40_50.convertUrl(src.getRenderingElement()));
    for (org.hl7.fhir.r4.model.ImplementationGuide.ManifestResourceComponent t : src.getResource())
      tgt.addResource(convertManifestResourceComponent(t));
    for (org.hl7.fhir.r4.model.ImplementationGuide.ManifestPageComponent t : src.getPage())
      tgt.addPage(convertManifestPageComponent(t));
    for (org.hl7.fhir.r4.model.StringType t : src.getImage()) tgt.getImage().add(String40_50.convertString(t));
    for (org.hl7.fhir.r4.model.StringType t : src.getOther()) tgt.getOther().add(String40_50.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideManifestComponent convertImplementationGuideManifestComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideManifestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideManifestComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideManifestComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasRendering())
      tgt.setRenderingElement(Url40_50.convertUrl(src.getRenderingElement()));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ManifestResourceComponent t : src.getResource())
      tgt.addResource(convertManifestResourceComponent(t));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ManifestPageComponent t : src.getPage())
      tgt.addPage(convertManifestPageComponent(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getImage()) tgt.getImage().add(String40_50.convertString(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getOther()) tgt.getOther().add(String40_50.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ManifestResourceComponent convertManifestResourceComponent(org.hl7.fhir.r4.model.ImplementationGuide.ManifestResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ManifestResourceComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ManifestResourceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasReference())
      tgt.setReference(Reference40_50.convertReference(src.getReference()));
    if (src.hasExampleBooleanType())
      tgt.setIsExampleElement(Boolean40_50.convertBoolean(src.getExampleBooleanType()));
    if (src.hasExampleCanonicalType())
      tgt.getProfile().add((Canonical40_50.convertCanonical(src.getExampleCanonicalType())));
    if (src.hasRelativePath())
      tgt.setRelativePathElement(Url40_50.convertUrl(src.getRelativePathElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ManifestResourceComponent convertManifestResourceComponent(org.hl7.fhir.r5.model.ImplementationGuide.ManifestResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ManifestResourceComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ManifestResourceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasReference())
      tgt.setReference(Reference40_50.convertReference(src.getReference()));
    if (src.hasIsExample())
      tgt.setExample(Boolean40_50.convertBoolean(src.getIsExampleElement()));
    if (src.hasProfile())
      tgt.setExample(Canonical40_50.convertCanonical(src.getProfile().get(0)));
    if (src.hasRelativePath())
      tgt.setRelativePathElement(Url40_50.convertUrl(src.getRelativePathElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ManifestPageComponent convertManifestPageComponent(org.hl7.fhir.r4.model.ImplementationGuide.ManifestPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ManifestPageComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ManifestPageComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getAnchor()) tgt.getAnchor().add(String40_50.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ManifestPageComponent convertManifestPageComponent(org.hl7.fhir.r5.model.ImplementationGuide.ManifestPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ManifestPageComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ManifestPageComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getAnchor()) tgt.getAnchor().add(String40_50.convertString(t));
    return tgt;
  }
}