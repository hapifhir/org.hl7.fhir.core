package org.hl7.fhir.convertors.conv43_N.resources43_N;

import java.util.stream.Collectors;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.ContactDetail43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.UsageContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Canonical43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Code43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Id43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.MarkDown43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Url43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.Extension;
import org.hl7.fhir.r4b.model.MarkdownType;
import org.hl7.fhir.r4b.model.UrlType;
import org.hl7.fhir.model.core.CanonicalType;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.ImplementationGuide;
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

public class ImplementationGuide43_N {

  public static org.hl7.fhir.model.core.ImplementationGuide convertImplementationGuide(org.hl7.fhir.r4b.model.ImplementationGuide src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImplementationGuide tgt = new org.hl7.fhir.model.core.ImplementationGuide();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt, VersionConvertorConstants.EXT_VERSION_ALGORITHM);
    if (tgt.hasImplicitRules() && VersionConvertorConstants.IMPLICIT_RULES_OMITTED_MANDATORY_CODE.equals(tgt.getImplicitRules())) {
      // the marker recorded that a mandatory page name[x] was omitted on the way down to R4; the 
      // page content is restored from the inter-version extensions below, so it no longer applies
      tgt.setImplicitRulesElement(null);
    }
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasExtension(VersionConvertorConstants.EXT_VERSION_ALGORITHM))
      tgt.setVersionAlgorithm(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getExtensionByUrl(VersionConvertorConstants.EXT_VERSION_ALGORITHM).getValue()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean43_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String43_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail43_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext43_N.convertUsageContext(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasPackageId())
      tgt.setPackageIdElement(Id43_N.convertId(src.getPackageIdElement()));
    if (src.hasLicense())
      tgt.setLicenseElement(convertSPDXLicense(src.getLicenseElement()));
    tgt.setFhirVersionList(src.getFhirVersion().stream()
      .map(Enumerations43_N::convertFHIRVersion)
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

  public static org.hl7.fhir.r4b.model.ImplementationGuide convertImplementationGuide(ImplementationGuide src, boolean produceIllegalParameters) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide tgt = new org.hl7.fhir.r4b.model.ImplementationGuide();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasVersionAlgorithm()) {
      tgt.addExtension(VersionConvertorConstants.EXT_VERSION_ALGORITHM,
        ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getVersionAlgorithm()));
    }
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean43_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String43_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getContactList())
      tgt.addContact(ContactDetail43_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.UsageContext t : src.getUseContextList())
      tgt.addUseContext(UsageContext43_N.convertUsageContext(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getJurisdictionList())
      tgt.addJurisdiction(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasPackageId())
      tgt.setPackageIdElement(Id43_N.convertId(src.getPackageIdElement()));
    if (src.hasLicense())
      tgt.setLicenseElement(convertSPDXLicense(src.getLicenseElement()));
    tgt.setFhirVersion(src.getFhirVersionList().stream()
      .map(Enumerations43_N::convertFHIRVersion)
      .collect(Collectors.toList()));
    for (org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDependsOnComponent t : src.getDependsOnList())
      tgt.addDependsOn(convertImplementationGuideDependsOnComponent(t));
    for (org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobalList())
      tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
    if (src.hasDefinition())
      tgt.setDefinition(convertImplementationGuideDefinitionComponent(src.getDefinition(), produceIllegalParameters));
    if (src.hasManifest())
      tgt.setManifest(convertImplementationGuideManifestComponent(src.getManifest()));
    if (tgt.hasDefinition() && tgt.getDefinition().hasPage() && hasOmittedPageName(tgt.getDefinition().getPage())) {
      // at least one page has no name[x] in R4 (the R6 source[x] was not a url, or was absent), 
      // and name[x] is mandatory in R4, so readers that don't understand the omission must not 
      // process the resource
      tgt.setImplicitRules(VersionConvertorConstants.IMPLICIT_RULES_OMITTED_MANDATORY_CODE);
    }
    return tgt;
  }

  private static boolean hasOmittedPageName(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent page) {
    if (page == null)
      return false;
    if (!page.hasName())
      return true;
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent p : page.getPage())
      if (hasOmittedPageName(p))
        return true;
    return false;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ImplementationGuide.SPDXLicense> convertSPDXLicense(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ImplementationGuide.SPDXLicense> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.ImplementationGuide.SPDXLicenseEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    tgt.setValue(org.hl7.fhir.model.core.ImplementationGuide.SPDXLicense.fromCode(src.getValue().toCode()));
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense> convertSPDXLicense(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ImplementationGuide.SPDXLicense> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicenseEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.fromCode(src.getValue().toCode()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDependsOnComponent convertImplementationGuideDependsOnComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDependsOnComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDependsOnComponent tgt = new org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDependsOnComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt, VersionConvertorConstants.EXT_IG_DEPENDSON_REASON);
    if (src.hasUri())
      tgt.setUriElement(Canonical43_N.convertCanonical(src.getUriElement()));
    if (src.hasPackageId())
      tgt.setPackageIdElement(Id43_N.convertId(src.getPackageIdElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasExtension(VersionConvertorConstants.EXT_IG_DEPENDSON_REASON))
      tgt.setReasonElement(MarkDown43_N.convertMarkdown((org.hl7.fhir.r4b.model.MarkdownType)src.getExtensionByUrl(VersionConvertorConstants.EXT_IG_DEPENDSON_REASON).getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDependsOnComponent convertImplementationGuideDependsOnComponent(org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDependsOnComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDependsOnComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDependsOnComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasUri())
      tgt.setUriElement(Canonical43_N.convertCanonical(src.getUriElement()));
    if (src.hasPackageId())
      tgt.setPackageIdElement(Id43_N.convertId(src.getPackageIdElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasReason())
      tgt.addExtension(VersionConvertorConstants.EXT_IG_DEPENDSON_REASON, MarkDown43_N.convertMarkdown(src.getReasonElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideGlobalComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(Uri43_N.convertUriFromCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Canonical43_N.convertCanonical(src.getProfileElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideGlobalComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(Uri43_N.convertUriToCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Canonical43_N.convertCanonical(src.getProfileElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionComponent convertImplementationGuideDefinitionComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionComponent tgt = new org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt, VersionConvertorConstants.EXT_IG_DEFINITION_PARAMETER);
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent t : src.getGrouping())
      tgt.addGrouping(convertImplementationGuideDefinitionGroupingComponent(t));
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent t : src.getResource())
      tgt.addResource(convertImplementationGuideDefinitionResourceComponent(t));
    if (src.hasPage())
      tgt.setPage(convertImplementationGuideDefinitionPageComponent(src.getPage()));
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent t : src.getParameter())
      tgt.addParameter(convertImplementationGuideDefinitionParameterComponent(t));
    for (org.hl7.fhir.r4b.model.Extension e : org.hl7.fhir.r4b.utils.ToolingExtensions.getExtensions(src, VersionConvertorConstants.EXT_IG_DEFINITION_PARAMETER)) {
      org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionParameterComponent p = new org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionParameterComponent();
      p.getCode().setCode(org.hl7.fhir.r4b.utils.ToolingExtensions.readStringExtension(e, "code"));
      p.getCode().setSystem(VersionConvertorConstants.EXT_IG_DEFINITION_PARAM_URL_EXT);
      p.setValue(org.hl7.fhir.r4b.utils.ToolingExtensions.readStringExtension(e, "value"));
      tgt.addParameter(p);
    }
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent t : src.getTemplate())
      tgt.addTemplate(convertImplementationGuideDefinitionTemplateComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionComponent convertImplementationGuideDefinitionComponent(ImplementationGuide.ImplementationGuideDefinitionComponent src, boolean produceIllegalParameters) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent t : src.getGroupingList())
      tgt.addGrouping(convertImplementationGuideDefinitionGroupingComponent(t));
    for (org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionResourceComponent t : src.getResourceList())
      tgt.addResource(convertImplementationGuideDefinitionResourceComponent(t));
    if (src.hasPage())
      tgt.setPage(convertImplementationGuideDefinitionPageComponent(src.getPage()));
    for (org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionParameterComponent t : src.getParameterList()) {
        if (produceIllegalParameters || Utilities.existsInList(t.getCode().getCode(), "apply", "path-resource", "path-pages", "path-tx-cache", "expansion-parameter", "rule-broken-links", "generate-xml", "generate-json", "generate-turtle", "html-template")) {
          tgt.addParameter(convertImplementationGuideDefinitionParameterComponent(t));
        } else {
          org.hl7.fhir.r4b.model.Extension e = new org.hl7.fhir.r4b.model.Extension(VersionConvertorConstants.EXT_IG_DEFINITION_PARAMETER);
          org.hl7.fhir.r4b.model.Extension eCode = new org.hl7.fhir.r4b.model.Extension("code", new org.hl7.fhir.r4b.model.CodeType(t.getCode().getCode()));
          org.hl7.fhir.r4b.model.Extension eValue = new org.hl7.fhir.r4b.model.Extension("value", new org.hl7.fhir.r4b.model.StringType(t.getValue()));
          e.addExtension(eCode);
          e.addExtension(eValue);
          tgt.addExtension(e);
      }
    }
    for (org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent t : src.getTemplateList())
      tgt.addTemplate(convertImplementationGuideDefinitionTemplateComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent convertImplementationGuideDefinitionGroupingComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent tgt = new org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertStringToMarkdown(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent convertImplementationGuideDefinitionGroupingComponent(org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionResourceComponent convertImplementationGuideDefinitionResourceComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionResourceComponent tgt = new org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionResourceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt, VersionConvertorConstants.EXT_IG_DEFINITION_RESOURCE_PROFILE);
    if (src.hasReference())
      tgt.setReference(Reference43_N.convertReference(src.getReference()));
    tgt.setFhirVersionList(src.getFhirVersion().stream()
      .map(Enumerations43_N::convertFHIRVersion)
      .collect(Collectors.toList()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasExampleBooleanType())
      tgt.setIsExampleElement(Boolean43_N.convertBoolean(src.getExampleBooleanType()));
    if (src.hasExampleCanonicalType()) {
      tgt.setIsExample(true);
      tgt.getProfileList().add(Canonical43_N.convertCanonical(src.getExampleCanonicalType()));
    }
    for (Extension ext: src.getExtensionsByUrl(VersionConvertorConstants.EXT_IG_DEFINITION_RESOURCE_PROFILE)) {
      tgt.getProfileList().add(Canonical43_N.convertCanonical((org.hl7.fhir.r4b.model.CanonicalType)ext.getValue()));
    }
    if (src.hasGroupingId())
      tgt.setGroupingIdElement(Id43_N.convertId(src.getGroupingIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent convertImplementationGuideDefinitionResourceComponent(org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasReference())
      tgt.setReference(Reference43_N.convertReference(src.getReference()));
    tgt.setFhirVersion(src.getFhirVersionList().stream()
      .map(Enumerations43_N::convertFHIRVersion)
      .collect(Collectors.toList()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    if (src.hasIsExample())
      tgt.setExample(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getIsExampleElement()));
    boolean profileAsExample = src.hasProfile() && (!src.hasIsExample() || src.getIsExample());
    if (profileAsExample) {
      tgt.setExample(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getProfileList().get(0)));
    }
    // any profile not represented as example[x] is parked on the inter-version extension - 
    // including the first, when the resource is not an example
    for (CanonicalType p : src.getProfileList().subList(profileAsExample ? 1 : 0, src.getProfileList().size())) {
      tgt.addExtension(VersionConvertorConstants.EXT_IG_DEFINITION_RESOURCE_PROFILE, Canonical43_N.convertCanonical(p));
    }
    if (src.hasGroupingId())
      tgt.setGroupingIdElement(Id43_N.convertId(src.getGroupingIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionPageComponent convertImplementationGuideDefinitionPageComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionPageComponent tgt = new org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionPageComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt, VersionConvertorConstants.EXT_IG_DEFINITION_PAGE_NAME, VersionConvertorConstants.EXT_IG_PAGE_SOURCE);
    if (src.hasExtension(VersionConvertorConstants.EXT_IG_DEFINITION_PAGE_NAME)) {
      tgt.setNameElement(Url43_N.convertUrl((UrlType) src.getExtensionByUrl(VersionConvertorConstants.EXT_IG_DEFINITION_PAGE_NAME).getValue()));
    }
    if (src.hasNameReference()) {
      tgt.setSource(new org.hl7.fhir.model.core.UrlType(src.getNameReference().getReference()));
      if (!tgt.hasName()) {
        tgt.setName(tgt.getSourceUrlType().asStringValue());
      }
    }
    if (src.hasNameUrlType()) {
      tgt.setSource(Url43_N.convertUrl(src.getNameUrlType()));
      if (!tgt.hasName()) {
        tgt.setName(tgt.getSourceUrlType().asStringValue());
      }
    }
    if (src.hasExtension(VersionConvertorConstants.EXT_IG_PAGE_SOURCE)) {
      // a string or markdown source, which R4 name[x] cannot represent, parked by the R6->R4 conversion
      org.hl7.fhir.r4b.model.DataType v = src.getExtensionByUrl(VersionConvertorConstants.EXT_IG_PAGE_SOURCE).getValue();
      if (v instanceof org.hl7.fhir.r4b.model.MarkdownType) {
        tgt.setSource(MarkDown43_N.convertMarkdown((org.hl7.fhir.r4b.model.MarkdownType) v));
      } else if (v instanceof org.hl7.fhir.r4b.model.StringType) {
        tgt.setSource(String43_N.convertString((org.hl7.fhir.r4b.model.StringType) v));
      }
    }
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasGeneration())
      tgt.setGenerationElement(convertGuidePageGeneration(src.getGenerationElement()));
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent t : src.getPage())
      tgt.addPage(convertImplementationGuideDefinitionPageComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent convertImplementationGuideDefinitionPageComponent(org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName()) {
      tgt.addExtension().setUrl(VersionConvertorConstants.EXT_IG_DEFINITION_PAGE_NAME).setValue(Url43_N.convertUrl(src.getNameElement()));
    }
    if (src.hasSourceUrlType()) {
      tgt.setName(Url43_N.convertUrl(src.getSourceUrlType()));
    } else if (src.hasSourceStringType()) {
      // R4 name[x] can only hold a url; park the string source on the inter-version extension. 
      // The resource-level converter marks implicitRules because the mandatory name[x] is omitted
      tgt.addExtension(VersionConvertorConstants.EXT_IG_PAGE_SOURCE, String43_N.convertString(src.getSourceStringType()));
    } else if (src.hasSourceMarkdownType()) {
      tgt.addExtension(VersionConvertorConstants.EXT_IG_PAGE_SOURCE, MarkDown43_N.convertMarkdown(src.getSourceMarkdownType()));
    } 
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasGeneration())
      tgt.setGenerationElement(convertGuidePageGeneration(src.getGenerationElement()));
    for (org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionPageComponent t : src.getPageList())
      tgt.addPage(convertImplementationGuideDefinitionPageComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ImplementationGuide.GuidePageGeneration> convertGuidePageGeneration(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ImplementationGuide.GuidePageGeneration> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<ImplementationGuide.GuidePageGeneration> tgt = new Enumeration<>(new ImplementationGuide.GuidePageGenerationEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case HTML:
                  tgt.setValue(ImplementationGuide.GuidePageGeneration.HTML);
                  break;
              case MARKDOWN:
                  tgt.setValue(ImplementationGuide.GuidePageGeneration.MARKDOWN);
                  break;
              case XML:
                  tgt.setValue(ImplementationGuide.GuidePageGeneration.XML);
                  break;
              case GENERATED:
                  tgt.setValue(ImplementationGuide.GuidePageGeneration.GENERATED);
                  break;
              default:
                  tgt.setValue(ImplementationGuide.GuidePageGeneration.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ImplementationGuide.GuidePageGeneration> convertGuidePageGeneration(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ImplementationGuide.GuidePageGeneration> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ImplementationGuide.GuidePageGeneration> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ImplementationGuide.GuidePageGenerationEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionParameterComponent convertImplementationGuideDefinitionParameterComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionParameterComponent tgt = new org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionParameterComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode()) {
      tgt.getCode().setCode(src.getCode());
      if (Utilities.existsInList(tgt.getCode().getCode(), "apply", "path-resource", "path-pages", "path-tx-cache", "expansion-parameter", "rule-broken-links", "generate-xml", "generate-json", "generate-turtle", "html-template")) {
        tgt.getCode().setSystem(VersionConvertorConstants.EXT_IG_DEFINITION_PARAM_URL_BASE);
      } else {
        tgt.getCode().setSystem(VersionConvertorConstants.EXT_IG_DEFINITION_PARAM_URL_EXT);  
      }
    }
    if (src.hasValue())
      tgt.setValueElement(String43_N.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent convertImplementationGuideDefinitionParameterComponent(org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(src.getCode().getCode());
    if (src.hasValue())
      tgt.setValueElement(String43_N.convertString(src.getValueElement()));
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

  public static org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent convertImplementationGuideDefinitionTemplateComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent tgt = new org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_N.convertCode(src.getCodeElement()));
    if (src.hasSource())
      tgt.setSourceElement(String43_N.convertString(src.getSourceElement()));
    if (src.hasScope())
      tgt.setScopeElement(String43_N.convertString(src.getScopeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent convertImplementationGuideDefinitionTemplateComponent(org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_N.convertCode(src.getCodeElement()));
    if (src.hasSource())
      tgt.setSourceElement(String43_N.convertString(src.getSourceElement()));
    if (src.hasScope())
      tgt.setScopeElement(String43_N.convertString(src.getScopeElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideManifestComponent convertImplementationGuideManifestComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideManifestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideManifestComponent tgt = new org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideManifestComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasRendering())
      tgt.setRenderingElement(Url43_N.convertUrl(src.getRenderingElement()));
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ManifestResourceComponent t : src.getResource())
      tgt.addResource(convertManifestResourceComponent(t));
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ManifestPageComponent t : src.getPage())
      tgt.addPage(convertManifestPageComponent(t));
    for (org.hl7.fhir.r4b.model.StringType t : src.getImage()) tgt.getImageList().add(String43_N.convertString(t));
    for (org.hl7.fhir.r4b.model.StringType t : src.getOther()) tgt.getOtherList().add(String43_N.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideManifestComponent convertImplementationGuideManifestComponent(org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideManifestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideManifestComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideManifestComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasRendering())
      tgt.setRenderingElement(Url43_N.convertUrl(src.getRenderingElement()));
    for (org.hl7.fhir.model.core.ImplementationGuide.ManifestResourceComponent t : src.getResourceList())
      tgt.addResource(convertManifestResourceComponent(t));
    for (org.hl7.fhir.model.core.ImplementationGuide.ManifestPageComponent t : src.getPageList())
      tgt.addPage(convertManifestPageComponent(t));
    for (org.hl7.fhir.model.core.StringType t : src.getImageList()) tgt.getImage().add(String43_N.convertString(t));
    for (org.hl7.fhir.model.core.StringType t : src.getOtherList()) tgt.getOther().add(String43_N.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ImplementationGuide.ManifestResourceComponent convertManifestResourceComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ManifestResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImplementationGuide.ManifestResourceComponent tgt = new org.hl7.fhir.model.core.ImplementationGuide.ManifestResourceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt, VersionConvertorConstants.EXT_IG_MANIFEST_RESOURCE_PROFILE);
    if (src.hasReference())
      tgt.setReference(Reference43_N.convertReference(src.getReference()));
    if (src.hasExampleBooleanType())
      tgt.setIsExampleElement(Boolean43_N.convertBoolean(src.getExampleBooleanType()));
    if (src.hasExampleCanonicalType()) {
      tgt.setIsExample(true);
      tgt.getProfileList().add(Canonical43_N.convertCanonical(src.getExampleCanonicalType()));
    }
    for (Extension ext : src.getExtensionsByUrl(VersionConvertorConstants.EXT_IG_MANIFEST_RESOURCE_PROFILE)) {
      tgt.getProfileList().add(Canonical43_N.convertCanonical((org.hl7.fhir.r4b.model.CanonicalType) ext.getValue()));
    }
    if (src.hasRelativePath())
      tgt.setRelativePathElement(Url43_N.convertUrl(src.getRelativePathElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ManifestResourceComponent convertManifestResourceComponent(org.hl7.fhir.model.core.ImplementationGuide.ManifestResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ManifestResourceComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ManifestResourceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasReference())
      tgt.setReference(Reference43_N.convertReference(src.getReference()));
    if (src.hasIsExample())
      tgt.setExample(Boolean43_N.convertBoolean(src.getIsExampleElement()));
    boolean profileAsExample = src.hasProfile() && (!src.hasIsExample() || src.getIsExample());
    if (profileAsExample) {
      tgt.setExample(Canonical43_N.convertCanonical(src.getProfileList().get(0)));
    }
    // any profile not represented as example[x] is parked on the inter-version extension - 
    // including the first, when the resource is not an example
    for (CanonicalType p : src.getProfileList().subList(profileAsExample ? 1 : 0, src.getProfileList().size())) {
      tgt.addExtension(VersionConvertorConstants.EXT_IG_MANIFEST_RESOURCE_PROFILE, Canonical43_N.convertCanonical(p));
    }
    if (src.hasRelativePath())
      tgt.setRelativePathElement(Url43_N.convertUrl(src.getRelativePathElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ImplementationGuide.ManifestPageComponent convertManifestPageComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ManifestPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImplementationGuide.ManifestPageComponent tgt = new org.hl7.fhir.model.core.ImplementationGuide.ManifestPageComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getAnchor()) tgt.getAnchorList().add(String43_N.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ManifestPageComponent convertManifestPageComponent(org.hl7.fhir.model.core.ImplementationGuide.ManifestPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ManifestPageComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ManifestPageComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    for (org.hl7.fhir.model.core.StringType t : src.getAnchorList()) tgt.getAnchor().add(String43_N.convertString(t));
    return tgt;
  }
}