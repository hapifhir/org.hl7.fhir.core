package org.hl7.fhir.convertors.conv40_N.resources40_N;

import java.util.stream.Collectors;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.ContactDetail40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.UsageContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Code40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Id40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.MarkDown40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Url40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.MarkdownType;
import org.hl7.fhir.r4.model.UrlType;
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

public class ImplementationGuide40_N {

  public static org.hl7.fhir.model.core.ImplementationGuide convertImplementationGuide(org.hl7.fhir.r4.model.ImplementationGuide src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImplementationGuide tgt = new org.hl7.fhir.model.core.ImplementationGuide();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, VersionConvertorConstants.EXT_VERSION_ALGORITHM);
    if (tgt.hasImplicitRules() && VersionConvertorConstants.IMPLICIT_RULES_OMITTED_MANDATORY_CODE.equals(tgt.getImplicitRules())) {
      // the marker recorded that a mandatory page name[x] was omitted on the way down to R4; the 
      // page content is restored from the inter-version extensions below, so it no longer applies
      tgt.setImplicitRulesElement(null);
    }
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasExtension(VersionConvertorConstants.EXT_VERSION_ALGORITHM))
      tgt.setVersionAlgorithm(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getExtensionByUrl(VersionConvertorConstants.EXT_VERSION_ALGORITHM).getValue()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_N.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasPackageId())
      tgt.setPackageIdElement(Id40_N.convertId(src.getPackageIdElement()));
    if (src.hasLicense())
      tgt.setLicenseElement(convertSPDXLicense(src.getLicenseElement()));
    tgt.setFhirVersionList(src.getFhirVersion().stream()
      .map(Enumerations40_N::convertFHIRVersion)
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
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasVersionAlgorithm()) {
      tgt.addExtension(VersionConvertorConstants.EXT_VERSION_ALGORITHM,
        ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getVersionAlgorithm()));
    }
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getContactList())
      tgt.addContact(ContactDetail40_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.UsageContext t : src.getUseContextList())
      tgt.addUseContext(UsageContext40_N.convertUsageContext(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getJurisdictionList())
      tgt.addJurisdiction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasPackageId())
      tgt.setPackageIdElement(Id40_N.convertId(src.getPackageIdElement()));
    if (src.hasLicense())
      tgt.setLicenseElement(convertSPDXLicense(src.getLicenseElement()));
    tgt.setFhirVersion(src.getFhirVersionList().stream()
      .map(Enumerations40_N::convertFHIRVersion)
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

  private static boolean hasOmittedPageName(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent page) {
    if (page == null)
      return false;
    if (!page.hasName())
      return true;
    for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent p : page.getPage())
      if (hasOmittedPageName(p))
        return true;
    return false;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ImplementationGuide.SPDXLicense> convertSPDXLicense(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ImplementationGuide.SPDXLicense> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.ImplementationGuide.SPDXLicenseEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    tgt.setValue(org.hl7.fhir.model.core.ImplementationGuide.SPDXLicense.fromCode(src.getValue().toCode()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense> convertSPDXLicense(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ImplementationGuide.SPDXLicense> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicenseEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    tgt.setValue(org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.fromCode(src.getValue().toCode()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDependsOnComponent convertImplementationGuideDependsOnComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDependsOnComponent tgt = new org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDependsOnComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, VersionConvertorConstants.EXT_IG_DEPENDSON_REASON);
    if (src.hasUri())
      tgt.setUriElement(Canonical40_N.convertCanonical(src.getUriElement()));
    if (src.hasPackageId())
      tgt.setPackageIdElement(Id40_N.convertId(src.getPackageIdElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasExtension(VersionConvertorConstants.EXT_IG_DEPENDSON_REASON))
      tgt.setReasonElement(MarkDown40_N.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType)src.getExtensionByUrl(VersionConvertorConstants.EXT_IG_DEPENDSON_REASON).getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent convertImplementationGuideDependsOnComponent(org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDependsOnComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasUri())
      tgt.setUriElement(Canonical40_N.convertCanonical(src.getUriElement()));
    if (src.hasPackageId())
      tgt.setPackageIdElement(Id40_N.convertId(src.getPackageIdElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasReason())
      tgt.addExtension(VersionConvertorConstants.EXT_IG_DEPENDSON_REASON, MarkDown40_N.convertMarkdown(src.getReasonElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideGlobalComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(Uri40_N.convertUriFromCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Canonical40_N.convertCanonical(src.getProfileElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(Uri40_N.convertUriToCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Canonical40_N.convertCanonical(src.getProfileElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionComponent convertImplementationGuideDefinitionComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionComponent tgt = new org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, VersionConvertorConstants.EXT_IG_DEFINITION_PARAMETER);
    for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent t : src.getGrouping())
      tgt.addGrouping(convertImplementationGuideDefinitionGroupingComponent(t));
    for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent t : src.getResource())
      tgt.addResource(convertImplementationGuideDefinitionResourceComponent(t));
    if (src.hasPage())
      tgt.setPage(convertImplementationGuideDefinitionPageComponent(src.getPage()));
    for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent t : src.getParameter())
      tgt.addParameter(convertImplementationGuideDefinitionParameterComponent(t));
    for (org.hl7.fhir.r4.model.Extension e : org.hl7.fhir.r4.utils.ToolingExtensions.getExtensions(src, VersionConvertorConstants.EXT_IG_DEFINITION_PARAMETER)) {
      org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionParameterComponent p = new org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionParameterComponent();
      p.getCode().setCode(org.hl7.fhir.r4.utils.ToolingExtensions.readStringExtension(e, "code"));
      p.getCode().setSystem(VersionConvertorConstants.EXT_IG_DEFINITION_PARAM_URL_EXT);
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
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
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
          org.hl7.fhir.r4.model.Extension e = new org.hl7.fhir.r4.model.Extension(VersionConvertorConstants.EXT_IG_DEFINITION_PARAMETER);
          org.hl7.fhir.r4.model.Extension eCode = new org.hl7.fhir.r4.model.Extension("code", new org.hl7.fhir.r4.model.CodeType(t.getCode().getCode()));
          org.hl7.fhir.r4.model.Extension eValue = new org.hl7.fhir.r4.model.Extension("value", new org.hl7.fhir.r4.model.StringType(t.getValue()));
          e.addExtension(eCode);
          e.addExtension(eValue);
          tgt.addExtension(e);
      }
    }
    for (org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent t : src.getTemplateList())
      tgt.addTemplate(convertImplementationGuideDefinitionTemplateComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent convertImplementationGuideDefinitionGroupingComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent tgt = new org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertStringToMarkdown(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent convertImplementationGuideDefinitionGroupingComponent(org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionResourceComponent convertImplementationGuideDefinitionResourceComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionResourceComponent tgt = new org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionResourceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, VersionConvertorConstants.EXT_IG_DEFINITION_RESOURCE_PROFILE);
    if (src.hasReference())
      tgt.setReference(Reference40_N.convertReference(src.getReference()));
    tgt.setFhirVersionList(src.getFhirVersion().stream()
      .map(Enumerations40_N::convertFHIRVersion)
      .collect(Collectors.toList()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasExampleBooleanType())
      tgt.setIsExampleElement(Boolean40_N.convertBoolean(src.getExampleBooleanType()));
    if (src.hasExampleCanonicalType()) {
      tgt.setIsExample(true);
      tgt.getProfileList().add(Canonical40_N.convertCanonical(src.getExampleCanonicalType()));
    }
    for (Extension ext: src.getExtensionsByUrl(VersionConvertorConstants.EXT_IG_DEFINITION_RESOURCE_PROFILE)) {
      tgt.getProfileList().add(Canonical40_N.convertCanonical((org.hl7.fhir.r4.model.CanonicalType)ext.getValue()));
    }
    if (src.hasGroupingId())
      tgt.setGroupingIdElement(Id40_N.convertId(src.getGroupingIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent convertImplementationGuideDefinitionResourceComponent(org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasReference())
      tgt.setReference(Reference40_N.convertReference(src.getReference()));
    tgt.setFhirVersion(src.getFhirVersionList().stream()
      .map(Enumerations40_N::convertFHIRVersion)
      .collect(Collectors.toList()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasIsExample())
      tgt.setExample(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getIsExampleElement()));
    boolean profileAsExample = src.hasProfile() && (!src.hasIsExample() || src.getIsExample());
    if (profileAsExample) {
      tgt.setExample(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getProfileList().get(0)));
    }
    // any profile not represented as example[x] is parked on the inter-version extension - 
    // including the first, when the resource is not an example
    for (CanonicalType p : src.getProfileList().subList(profileAsExample ? 1 : 0, src.getProfileList().size())) {
      tgt.addExtension(VersionConvertorConstants.EXT_IG_DEFINITION_RESOURCE_PROFILE, Canonical40_N.convertCanonical(p));
    }
    if (src.hasGroupingId())
      tgt.setGroupingIdElement(Id40_N.convertId(src.getGroupingIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionPageComponent convertImplementationGuideDefinitionPageComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionPageComponent tgt = new org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionPageComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, VersionConvertorConstants.EXT_IG_DEFINITION_PAGE_NAME, VersionConvertorConstants.EXT_IG_PAGE_SOURCE);
    if (src.hasExtension(VersionConvertorConstants.EXT_IG_DEFINITION_PAGE_NAME)) {
      tgt.setNameElement(Url40_N.convertUrl((UrlType) src.getExtensionByUrl(VersionConvertorConstants.EXT_IG_DEFINITION_PAGE_NAME).getValue()));
    }
    if (src.hasNameReference()) {
      tgt.setSource(new org.hl7.fhir.model.core.UrlType(src.getNameReference().getReference()));
      if (!tgt.hasName()) {
        tgt.setName(tgt.getSourceUrlType().asStringValue());
      }
    }
    if (src.hasNameUrlType()) {
      tgt.setSource(Url40_N.convertUrl(src.getNameUrlType()));
      if (!tgt.hasName()) {
        tgt.setName(tgt.getSourceUrlType().asStringValue());
      }
    }
    if (src.hasExtension(VersionConvertorConstants.EXT_IG_PAGE_SOURCE)) {
      // a string or markdown source, which R4 name[x] cannot represent, parked by the R6->R4 conversion
      org.hl7.fhir.r4.model.Type v = src.getExtensionByUrl(VersionConvertorConstants.EXT_IG_PAGE_SOURCE).getValue();
      if (v instanceof org.hl7.fhir.r4.model.MarkdownType) {
        tgt.setSource(MarkDown40_N.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) v));
      } else if (v instanceof org.hl7.fhir.r4.model.StringType) {
        tgt.setSource(String40_N.convertString((org.hl7.fhir.r4.model.StringType) v));
      }
    }
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasGeneration())
      tgt.setGenerationElement(convertGuidePageGeneration(src.getGenerationElement()));
    for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent t : src.getPage())
      tgt.addPage(convertImplementationGuideDefinitionPageComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent convertImplementationGuideDefinitionPageComponent(org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName()) {
      tgt.addExtension().setUrl(VersionConvertorConstants.EXT_IG_DEFINITION_PAGE_NAME).setValue(Url40_N.convertUrl(src.getNameElement()));
    }
    if (src.hasSourceUrlType()) {
      tgt.setName(Url40_N.convertUrl(src.getSourceUrlType()));
    } else if (src.hasSourceStringType()) {
      // R4 name[x] can only hold a url; park the string source on the inter-version extension. 
      // The resource-level converter marks implicitRules because the mandatory name[x] is omitted
      tgt.addExtension(VersionConvertorConstants.EXT_IG_PAGE_SOURCE, String40_N.convertString(src.getSourceStringType()));
    } else if (src.hasSourceMarkdownType()) {
      tgt.addExtension(VersionConvertorConstants.EXT_IG_PAGE_SOURCE, MarkDown40_N.convertMarkdown(src.getSourceMarkdownType()));
    } 
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasGeneration())
      tgt.setGenerationElement(convertGuidePageGeneration(src.getGenerationElement()));
    for (org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionPageComponent t : src.getPageList())
      tgt.addPage(convertImplementationGuideDefinitionPageComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ImplementationGuide.GuidePageGeneration> convertGuidePageGeneration(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGeneration> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<ImplementationGuide.GuidePageGeneration> tgt = new Enumeration<>(new ImplementationGuide.GuidePageGenerationEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGeneration> convertGuidePageGeneration(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ImplementationGuide.GuidePageGeneration> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGeneration> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGenerationEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionParameterComponent convertImplementationGuideDefinitionParameterComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionParameterComponent tgt = new org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionParameterComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode()) {
      tgt.getCode().setCode(src.getCode());
      if (Utilities.existsInList(tgt.getCode().getCode(), "apply", "path-resource", "path-pages", "path-tx-cache", "expansion-parameter", "rule-broken-links", "generate-xml", "generate-json", "generate-turtle", "html-template")) {
        tgt.getCode().setSystem(VersionConvertorConstants.EXT_IG_DEFINITION_PARAM_URL_BASE);
      } else {
        tgt.getCode().setSystem(VersionConvertorConstants.EXT_IG_DEFINITION_PARAM_URL_EXT);  
      }
    }
    if (src.hasValue())
      tgt.setValueElement(String40_N.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent convertImplementationGuideDefinitionParameterComponent(org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(src.getCode().getCode());
    if (src.hasValue())
      tgt.setValueElement(String40_N.convertString(src.getValueElement()));
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

  public static org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent convertImplementationGuideDefinitionTemplateComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent tgt = new org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code40_N.convertCode(src.getCodeElement()));
    if (src.hasSource())
      tgt.setSourceElement(String40_N.convertString(src.getSourceElement()));
    if (src.hasScope())
      tgt.setScopeElement(String40_N.convertString(src.getScopeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent convertImplementationGuideDefinitionTemplateComponent(org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code40_N.convertCode(src.getCodeElement()));
    if (src.hasSource())
      tgt.setSourceElement(String40_N.convertString(src.getSourceElement()));
    if (src.hasScope())
      tgt.setScopeElement(String40_N.convertString(src.getScopeElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideManifestComponent convertImplementationGuideManifestComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideManifestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideManifestComponent tgt = new org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideManifestComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasRendering())
      tgt.setRenderingElement(Url40_N.convertUrl(src.getRenderingElement()));
    for (org.hl7.fhir.r4.model.ImplementationGuide.ManifestResourceComponent t : src.getResource())
      tgt.addResource(convertManifestResourceComponent(t));
    for (org.hl7.fhir.r4.model.ImplementationGuide.ManifestPageComponent t : src.getPage())
      tgt.addPage(convertManifestPageComponent(t));
    for (org.hl7.fhir.r4.model.StringType t : src.getImage()) tgt.getImageList().add(String40_N.convertString(t));
    for (org.hl7.fhir.r4.model.StringType t : src.getOther()) tgt.getOtherList().add(String40_N.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideManifestComponent convertImplementationGuideManifestComponent(org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideManifestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideManifestComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideManifestComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasRendering())
      tgt.setRenderingElement(Url40_N.convertUrl(src.getRenderingElement()));
    for (org.hl7.fhir.model.core.ImplementationGuide.ManifestResourceComponent t : src.getResourceList())
      tgt.addResource(convertManifestResourceComponent(t));
    for (org.hl7.fhir.model.core.ImplementationGuide.ManifestPageComponent t : src.getPageList())
      tgt.addPage(convertManifestPageComponent(t));
    for (org.hl7.fhir.model.core.StringType t : src.getImageList()) tgt.getImage().add(String40_N.convertString(t));
    for (org.hl7.fhir.model.core.StringType t : src.getOtherList()) tgt.getOther().add(String40_N.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ImplementationGuide.ManifestResourceComponent convertManifestResourceComponent(org.hl7.fhir.r4.model.ImplementationGuide.ManifestResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImplementationGuide.ManifestResourceComponent tgt = new org.hl7.fhir.model.core.ImplementationGuide.ManifestResourceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, VersionConvertorConstants.EXT_IG_MANIFEST_RESOURCE_PROFILE);
    if (src.hasReference())
      tgt.setReference(Reference40_N.convertReference(src.getReference()));
    if (src.hasExampleBooleanType())
      tgt.setIsExampleElement(Boolean40_N.convertBoolean(src.getExampleBooleanType()));
    if (src.hasExampleCanonicalType()) {
      tgt.setIsExample(true);
      tgt.getProfileList().add(Canonical40_N.convertCanonical(src.getExampleCanonicalType()));
    }
    for (Extension ext : src.getExtensionsByUrl(VersionConvertorConstants.EXT_IG_MANIFEST_RESOURCE_PROFILE)) {
      tgt.getProfileList().add(Canonical40_N.convertCanonical((org.hl7.fhir.r4.model.CanonicalType) ext.getValue()));
    }
    if (src.hasRelativePath())
      tgt.setRelativePathElement(Url40_N.convertUrl(src.getRelativePathElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ManifestResourceComponent convertManifestResourceComponent(org.hl7.fhir.model.core.ImplementationGuide.ManifestResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ManifestResourceComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ManifestResourceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasReference())
      tgt.setReference(Reference40_N.convertReference(src.getReference()));
    if (src.hasIsExample())
      tgt.setExample(Boolean40_N.convertBoolean(src.getIsExampleElement()));
    boolean profileAsExample = src.hasProfile() && (!src.hasIsExample() || src.getIsExample());
    if (profileAsExample) {
      tgt.setExample(Canonical40_N.convertCanonical(src.getProfileList().get(0)));
    }
    // any profile not represented as example[x] is parked on the inter-version extension - 
    // including the first, when the resource is not an example
    for (CanonicalType p : src.getProfileList().subList(profileAsExample ? 1 : 0, src.getProfileList().size())) {
      tgt.addExtension(VersionConvertorConstants.EXT_IG_MANIFEST_RESOURCE_PROFILE, Canonical40_N.convertCanonical(p));
    }
    if (src.hasRelativePath())
      tgt.setRelativePathElement(Url40_N.convertUrl(src.getRelativePathElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ImplementationGuide.ManifestPageComponent convertManifestPageComponent(org.hl7.fhir.r4.model.ImplementationGuide.ManifestPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImplementationGuide.ManifestPageComponent tgt = new org.hl7.fhir.model.core.ImplementationGuide.ManifestPageComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getAnchor()) tgt.getAnchorList().add(String40_N.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ManifestPageComponent convertManifestPageComponent(org.hl7.fhir.model.core.ImplementationGuide.ManifestPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ManifestPageComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ManifestPageComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    for (org.hl7.fhir.model.core.StringType t : src.getAnchorList()) tgt.getAnchor().add(String40_N.convertString(t));
    return tgt;
  }
}