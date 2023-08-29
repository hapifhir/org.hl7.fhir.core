package org.hl7.fhir.convertors.conv43_50.resources43_50;

import java.util.stream.Collectors;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.ContactDetail43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.UsageContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Canonical43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Code43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Id43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.MarkDown43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Url43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;
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
public class ImplementationGuide43_50 {

  static final String EXT_IG_DEFINITION_PARAMETER = "http://hl7.org/fhir/tools/StructureDefinition/ig-parameter";

  public static org.hl7.fhir.r5.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.r4b.model.ImplementationGuide src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide tgt = new org.hl7.fhir.r5.model.ImplementationGuide();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean43_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String43_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail43_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext43_50.convertUsageContext(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasPackageId())
      tgt.setPackageIdElement(Id43_50.convertId(src.getPackageIdElement()));
    if (src.hasLicense())
      tgt.setLicenseElement(convertSPDXLicense(src.getLicenseElement()));
    tgt.setFhirVersion(src.getFhirVersion().stream()
      .map(Enumerations43_50::convertFHIRVersion)
      .collect(Collectors.toList()));
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDependsOnComponent t : src.getDependsOn())
      tgt.addDependsOn(convertImplementationGuideDependsOnComponent(t));
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal())
      tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
    if (src.hasDefinition())
      tgt.setDefinition(convertImplementationGuideDefinitionComponent(src.getDefinition()));
    if (src.hasManifest())
      tgt.setManifest(convertImplementationGuideManifestComponent(src.getManifest()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.r5.model.ImplementationGuide src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide tgt = new org.hl7.fhir.r4b.model.ImplementationGuide();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean43_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String43_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail43_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext43_50.convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasPackageId())
      tgt.setPackageIdElement(Id43_50.convertId(src.getPackageIdElement()));
    if (src.hasLicense())
      tgt.setLicenseElement(convertSPDXLicense(src.getLicenseElement()));
    tgt.setFhirVersion(src.getFhirVersion().stream()
      .map(Enumerations43_50::convertFHIRVersion)
      .collect(Collectors.toList()));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent t : src.getDependsOn())
      tgt.addDependsOn(convertImplementationGuideDependsOnComponent(t));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal())
      tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
    if (src.hasDefinition())
      tgt.setDefinition(convertImplementationGuideDefinitionComponent(src.getDefinition()));
    if (src.hasManifest())
      tgt.setManifest(convertImplementationGuideManifestComponent(src.getManifest()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense> convertSPDXLicense(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicenseEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.fromCode(src.getValue().toCode()));
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense> convertSPDXLicense(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicenseEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.fromCode(src.getValue().toCode()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent convertImplementationGuideDependsOnComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDependsOnComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasUri())
      tgt.setUriElement(Canonical43_50.convertCanonical(src.getUriElement()));
    if (src.hasPackageId())
      tgt.setPackageIdElement(Id43_50.convertId(src.getPackageIdElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDependsOnComponent convertImplementationGuideDependsOnComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDependsOnComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDependsOnComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasUri())
      tgt.setUriElement(Canonical43_50.convertCanonical(src.getUriElement()));
    if (src.hasPackageId())
      tgt.setPackageIdElement(Id43_50.convertId(src.getPackageIdElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(Code43_50.convertCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Canonical43_50.convertCanonical(src.getProfileElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideGlobalComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(Code43_50.convertCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Canonical43_50.convertCanonical(src.getProfileElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionComponent convertImplementationGuideDefinitionComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent t : src.getGrouping())
      tgt.addGrouping(convertImplementationGuideDefinitionGroupingComponent(t));
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent t : src.getResource())
      tgt.addResource(convertImplementationGuideDefinitionResourceComponent(t));
    if (src.hasPage())
      tgt.setPage(convertImplementationGuideDefinitionPageComponent(src.getPage()));
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent t : src.getParameter())
      tgt.addParameter(convertImplementationGuideDefinitionParameterComponent(t));
    for (org.hl7.fhir.r4b.model.Extension e : org.hl7.fhir.r4b.utils.ToolingExtensions.getExtensions(src, EXT_IG_DEFINITION_PARAMETER)) {
      org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent p = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent();
      p.getCode().setCode(org.hl7.fhir.r4b.utils.ToolingExtensions.readStringExtension(e, "code"));
      p.setValue(org.hl7.fhir.r4b.utils.ToolingExtensions.readStringExtension(e, "Value"));
      tgt.addParameter(p);
    }
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent t : src.getTemplate())
      tgt.addTemplate(convertImplementationGuideDefinitionTemplateComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionComponent convertImplementationGuideDefinitionComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent t : src.getGrouping())
      tgt.addGrouping(convertImplementationGuideDefinitionGroupingComponent(t));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent t : src.getResource())
      tgt.addResource(convertImplementationGuideDefinitionResourceComponent(t));
    if (src.hasPage())
      tgt.setPage(convertImplementationGuideDefinitionPageComponent(src.getPage()));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent t : src.getParameter()) {
      if (Utilities.existsInList(t.getCode().getCode(), "apply", "path-resource", "path-pages", "path-tx-cache", "expansion-parameter", "rule-broken-links", "generate-xml", "generate-json", "generate-turtle", "html-template"))
        tgt.addParameter(convertImplementationGuideDefinitionParameterComponent(t));
      else {
        org.hl7.fhir.r4b.model.Extension e = new org.hl7.fhir.r4b.model.Extension(EXT_IG_DEFINITION_PARAMETER);
        org.hl7.fhir.r4b.model.Extension eCode = new org.hl7.fhir.r4b.model.Extension("code", new org.hl7.fhir.r4b.model.CodeType(t.getCode().getCode()));
        org.hl7.fhir.r4b.model.Extension eValue = new org.hl7.fhir.r4b.model.Extension("value", new org.hl7.fhir.r4b.model.StringType(t.getValue()));
        e.addExtension(eCode);
        e.addExtension(eValue);
        tgt.addExtension(e);
      }
    }
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent t : src.getTemplate())
      tgt.addTemplate(convertImplementationGuideDefinitionTemplateComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent convertImplementationGuideDefinitionGroupingComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertStringToMarkdown(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent convertImplementationGuideDefinitionGroupingComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent convertImplementationGuideDefinitionResourceComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasReference())
      tgt.setReference(Reference43_50.convertReference(src.getReference()));
    tgt.setFhirVersion(src.getFhirVersion().stream()
      .map(Enumerations43_50::convertFHIRVersion)
      .collect(Collectors.toList()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasExampleBooleanType())
      tgt.setIsExampleElement(Boolean43_50.convertBoolean(src.getExampleBooleanType()));
    if (src.hasExampleCanonicalType())
      tgt.getProfile().add(Canonical43_50.convertCanonical(src.getExampleCanonicalType()));
    if (src.hasGroupingId())
      tgt.setGroupingIdElement(Id43_50.convertId(src.getGroupingIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent convertImplementationGuideDefinitionResourceComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasReference())
      tgt.setReference(Reference43_50.convertReference(src.getReference()));
    tgt.setFhirVersion(src.getFhirVersion().stream()
      .map(Enumerations43_50::convertFHIRVersion)
      .collect(Collectors.toList()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    if (src.hasIsExample())
      tgt.setExample(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getIsExampleElement()));
    if (src.hasProfile())
      tgt.setExample(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getProfile().get(0)));
    if (src.hasGroupingId())
      tgt.setGroupingIdElement(Id43_50.convertId(src.getGroupingIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent convertImplementationGuideDefinitionPageComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasNameReference())
      tgt.setName(src.getNameReference().getReference());
    else if (src.hasNameUrlType())
      tgt.setName(src.getNameUrlType().getValue());
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasGeneration())
      tgt.setGenerationElement(convertGuidePageGeneration(src.getGenerationElement()));
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent t : src.getPage())
      tgt.addPage(convertImplementationGuideDefinitionPageComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent convertImplementationGuideDefinitionPageComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setName(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasGeneration())
      tgt.setGenerationElement(convertGuidePageGeneration(src.getGenerationElement()));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent t : src.getPage())
      tgt.addPage(convertImplementationGuideDefinitionPageComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration> convertGuidePageGeneration(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ImplementationGuide.GuidePageGeneration> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGenerationEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ImplementationGuide.GuidePageGeneration> convertGuidePageGeneration(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ImplementationGuide.GuidePageGeneration> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ImplementationGuide.GuidePageGenerationEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case HTML:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.GuidePageGeneration.HTML);
        break;
      case MARKDOWN:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.GuidePageGeneration.MARKDOWN);
        break;
      case XML:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.GuidePageGeneration.XML);
        break;
      case GENERATED:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.GuidePageGeneration.GENERATED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.GuidePageGeneration.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent convertImplementationGuideDefinitionParameterComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.getCode().setCode(src.getCode());
    if (src.hasValue())
      tgt.setValueElement(String43_50.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent convertImplementationGuideDefinitionParameterComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.getCodeElement().setValueAsString(src.getCode().getCode());
    if (src.hasValue())
      tgt.setValueElement(String43_50.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.utils.GuideParameterCode convertGuideParameterCode(org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode src) throws FHIRException {
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

  public static org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode convertGuideParameterCode(org.hl7.fhir.r5.utils.GuideParameterCode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
      case APPLY:
        return org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode.APPLY;
      case PATHRESOURCE:
        return org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode.PATHRESOURCE;
      case PATHPAGES:
        return org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode.PATHPAGES;
      case PATHTXCACHE:
        return org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode.PATHTXCACHE;
      case EXPANSIONPARAMETER:
        return org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode.EXPANSIONPARAMETER;
      case RULEBROKENLINKS:
        return org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode.RULEBROKENLINKS;
      case GENERATEXML:
        return org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode.GENERATEXML;
      case GENERATEJSON:
        return org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode.GENERATEJSON;
      case GENERATETURTLE:
        return org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode.GENERATETURTLE;
      case HTMLTEMPLATE:
        return org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode.HTMLTEMPLATE;
      default:
        return org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent convertImplementationGuideDefinitionTemplateComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    if (src.hasSource())
      tgt.setSourceElement(String43_50.convertString(src.getSourceElement()));
    if (src.hasScope())
      tgt.setScopeElement(String43_50.convertString(src.getScopeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent convertImplementationGuideDefinitionTemplateComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    if (src.hasSource())
      tgt.setSourceElement(String43_50.convertString(src.getSourceElement()));
    if (src.hasScope())
      tgt.setScopeElement(String43_50.convertString(src.getScopeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideManifestComponent convertImplementationGuideManifestComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideManifestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideManifestComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideManifestComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasRendering())
      tgt.setRenderingElement(Url43_50.convertUrl(src.getRenderingElement()));
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ManifestResourceComponent t : src.getResource())
      tgt.addResource(convertManifestResourceComponent(t));
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ManifestPageComponent t : src.getPage())
      tgt.addPage(convertManifestPageComponent(t));
    for (org.hl7.fhir.r4b.model.StringType t : src.getImage()) tgt.getImage().add(String43_50.convertString(t));
    for (org.hl7.fhir.r4b.model.StringType t : src.getOther()) tgt.getOther().add(String43_50.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideManifestComponent convertImplementationGuideManifestComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideManifestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideManifestComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideManifestComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasRendering())
      tgt.setRenderingElement(Url43_50.convertUrl(src.getRenderingElement()));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ManifestResourceComponent t : src.getResource())
      tgt.addResource(convertManifestResourceComponent(t));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ManifestPageComponent t : src.getPage())
      tgt.addPage(convertManifestPageComponent(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getImage()) tgt.getImage().add(String43_50.convertString(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getOther()) tgt.getOther().add(String43_50.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ManifestResourceComponent convertManifestResourceComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ManifestResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ManifestResourceComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ManifestResourceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasReference())
      tgt.setReference(Reference43_50.convertReference(src.getReference()));
    if (src.hasExampleBooleanType())
      tgt.setIsExampleElement(Boolean43_50.convertBoolean(src.getExampleBooleanType()));
    if (src.hasExampleCanonicalType())
      tgt.getProfile().add((Canonical43_50.convertCanonical(src.getExampleCanonicalType())));
    if (src.hasRelativePath())
      tgt.setRelativePathElement(Url43_50.convertUrl(src.getRelativePathElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ManifestResourceComponent convertManifestResourceComponent(org.hl7.fhir.r5.model.ImplementationGuide.ManifestResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ManifestResourceComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ManifestResourceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasReference())
      tgt.setReference(Reference43_50.convertReference(src.getReference()));
    if (src.hasIsExample())
      tgt.setExample(Boolean43_50.convertBoolean(src.getIsExampleElement()));
    if (src.hasProfile())
      tgt.setExample(Canonical43_50.convertCanonical(src.getProfile().get(0)));
    if (src.hasRelativePath())
      tgt.setRelativePathElement(Url43_50.convertUrl(src.getRelativePathElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ManifestPageComponent convertManifestPageComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ManifestPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ManifestPageComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ManifestPageComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getAnchor()) tgt.getAnchor().add(String43_50.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ManifestPageComponent convertManifestPageComponent(org.hl7.fhir.r5.model.ImplementationGuide.ManifestPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ManifestPageComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ManifestPageComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getAnchor()) tgt.getAnchor().add(String43_50.convertString(t));
    return tgt;
  }
}