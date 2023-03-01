package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.ContactDetail43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.UsageContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Canonical43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Code43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.MarkDown43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Url43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.CodeType;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations.CommonLanguages;
import org.hl7.fhir.r5.model.Enumerations.CommonLanguagesEnumFactory;

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
public class TerminologyCapabilities43_50 {

  public static org.hl7.fhir.r5.model.TerminologyCapabilities convertTerminologyCapabilities(org.hl7.fhir.r4b.model.TerminologyCapabilities src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TerminologyCapabilities tgt = new org.hl7.fhir.r5.model.TerminologyCapabilities();
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
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasKind())
      tgt.setKindElement(convertCapabilityStatementKind(src.getKindElement()));
    if (src.hasSoftware())
      tgt.setSoftware(convertTerminologyCapabilitiesSoftwareComponent(src.getSoftware()));
    if (src.hasImplementation())
      tgt.setImplementation(convertTerminologyCapabilitiesImplementationComponent(src.getImplementation()));
    if (src.hasLockedDate())
      tgt.setLockedDateElement(Boolean43_50.convertBoolean(src.getLockedDateElement()));
    for (org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent t : src.getCodeSystem())
      tgt.addCodeSystem(convertTerminologyCapabilitiesCodeSystemComponent(t));
    if (src.hasExpansion())
      tgt.setExpansion(convertTerminologyCapabilitiesExpansionComponent(src.getExpansion()));
    if (src.hasCodeSearch())
      tgt.setCodeSearchElement(convertCodeSearchSupport(src.getCodeSearchElement()));
    if (src.hasValidateCode())
      tgt.setValidateCode(convertTerminologyCapabilitiesValidateCodeComponent(src.getValidateCode()));
    if (src.hasTranslation())
      tgt.setTranslation(convertTerminologyCapabilitiesTranslationComponent(src.getTranslation()));
    if (src.hasClosure())
      tgt.setClosure(convertTerminologyCapabilitiesClosureComponent(src.getClosure()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TerminologyCapabilities convertTerminologyCapabilities(org.hl7.fhir.r5.model.TerminologyCapabilities src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TerminologyCapabilities tgt = new org.hl7.fhir.r4b.model.TerminologyCapabilities();
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
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasKind())
      tgt.setKindElement(convertCapabilityStatementKind(src.getKindElement()));
    if (src.hasSoftware())
      tgt.setSoftware(convertTerminologyCapabilitiesSoftwareComponent(src.getSoftware()));
    if (src.hasImplementation())
      tgt.setImplementation(convertTerminologyCapabilitiesImplementationComponent(src.getImplementation()));
    if (src.hasLockedDate())
      tgt.setLockedDateElement(Boolean43_50.convertBoolean(src.getLockedDateElement()));
    for (org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent t : src.getCodeSystem())
      tgt.addCodeSystem(convertTerminologyCapabilitiesCodeSystemComponent(t));
    if (src.hasExpansion())
      tgt.setExpansion(convertTerminologyCapabilitiesExpansionComponent(src.getExpansion()));
    if (src.hasCodeSearch())
      tgt.setCodeSearchElement(convertCodeSearchSupport(src.getCodeSearchElement()));
    if (src.hasValidateCode())
      tgt.setValidateCode(convertTerminologyCapabilitiesValidateCodeComponent(src.getValidateCode()));
    if (src.hasTranslation())
      tgt.setTranslation(convertTerminologyCapabilitiesTranslationComponent(src.getTranslation()));
    if (src.hasClosure())
      tgt.setClosure(convertTerminologyCapabilitiesClosureComponent(src.getClosure()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind> convertCapabilityStatementKind(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.CapabilityStatementKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKindEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case INSTANCE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind.INSTANCE);
        break;
      case CAPABILITY:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind.CAPABILITY);
        break;
      case REQUIREMENTS:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind.REQUIREMENTS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.CapabilityStatementKind> convertCapabilityStatementKind(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.CapabilityStatementKind> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.CapabilityStatementKindEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case INSTANCE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.CapabilityStatementKind.INSTANCE);
        break;
      case CAPABILITY:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.CapabilityStatementKind.CAPABILITY);
        break;
      case REQUIREMENTS:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.CapabilityStatementKind.REQUIREMENTS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.CapabilityStatementKind.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TerminologyCapabilities.CodeSearchSupport> convertCodeSearchSupport(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TerminologyCapabilities.CodeSearchSupport> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TerminologyCapabilities.CodeSearchSupport> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TerminologyCapabilities.CodeSearchSupportEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case EXPLICIT:
        tgt.setValue(org.hl7.fhir.r5.model.TerminologyCapabilities.CodeSearchSupport.INCOMPOSE);
        break;
      case ALL:
        tgt.setValue(org.hl7.fhir.r5.model.TerminologyCapabilities.CodeSearchSupport.INCOMPOSEOREXPANSION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.TerminologyCapabilities.CodeSearchSupport.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TerminologyCapabilities.CodeSearchSupport> convertCodeSearchSupport(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TerminologyCapabilities.CodeSearchSupport> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TerminologyCapabilities.CodeSearchSupport> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.TerminologyCapabilities.CodeSearchSupportEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case INCOMPOSE:
        tgt.setValue(org.hl7.fhir.r4b.model.TerminologyCapabilities.CodeSearchSupport.EXPLICIT);
        break;
      case INCOMPOSEOREXPANSION:
        tgt.setValue(org.hl7.fhir.r4b.model.TerminologyCapabilities.CodeSearchSupport.ALL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.TerminologyCapabilities.CodeSearchSupport.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesSoftwareComponent convertTerminologyCapabilitiesSoftwareComponent(org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesSoftwareComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesSoftwareComponent tgt = new org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesSoftwareComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesSoftwareComponent convertTerminologyCapabilitiesSoftwareComponent(org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesSoftwareComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesSoftwareComponent tgt = new org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesSoftwareComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesImplementationComponent convertTerminologyCapabilitiesImplementationComponent(org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesImplementationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesImplementationComponent tgt = new org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesImplementationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    if (src.hasUrl())
      tgt.setUrlElement(Url43_50.convertUrl(src.getUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesImplementationComponent convertTerminologyCapabilitiesImplementationComponent(org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesImplementationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesImplementationComponent tgt = new org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesImplementationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    if (src.hasUrl())
      tgt.setUrlElement(Url43_50.convertUrl(src.getUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent convertTerminologyCapabilitiesCodeSystemComponent(org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent tgt = new org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasUri())
      tgt.setUriElement(Canonical43_50.convertCanonical(src.getUriElement()));
    for (org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent t : src.getVersion())
      tgt.addVersion(convertTerminologyCapabilitiesCodeSystemVersionComponent(t));
    if (src.hasSubsumption())
      tgt.setSubsumptionElement(Boolean43_50.convertBoolean(src.getSubsumptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent convertTerminologyCapabilitiesCodeSystemComponent(org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent tgt = new org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasUri())
      tgt.setUriElement(Canonical43_50.convertCanonical(src.getUriElement()));
    for (org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent t : src.getVersion())
      tgt.addVersion(convertTerminologyCapabilitiesCodeSystemVersionComponent(t));
    if (src.hasSubsumption())
      tgt.setSubsumptionElement(Boolean43_50.convertBoolean(src.getSubsumptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent convertTerminologyCapabilitiesCodeSystemVersionComponent(org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent tgt = new org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(String43_50.convertString(src.getCodeElement()));
    if (src.hasIsDefault())
      tgt.setIsDefaultElement(Boolean43_50.convertBoolean(src.getIsDefaultElement()));
    if (src.hasCompositional())
      tgt.setCompositionalElement(Boolean43_50.convertBoolean(src.getCompositionalElement()));
    for (org.hl7.fhir.r4b.model.CodeType t : src.getLanguage()) tgt.getLanguage().add(new Enumeration<CommonLanguages>(new CommonLanguagesEnumFactory(), t.getCode()));
    for (org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent t : src.getFilter())
      tgt.addFilter(convertTerminologyCapabilitiesCodeSystemVersionFilterComponent(t));
    for (org.hl7.fhir.r4b.model.CodeType t : src.getProperty()) tgt.getProperty().add(Code43_50.convertCode(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent convertTerminologyCapabilitiesCodeSystemVersionComponent(org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent tgt = new org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(String43_50.convertString(src.getCodeElement()));
    if (src.hasIsDefault())
      tgt.setIsDefaultElement(Boolean43_50.convertBoolean(src.getIsDefaultElement()));
    if (src.hasCompositional())
      tgt.setCompositionalElement(Boolean43_50.convertBoolean(src.getCompositionalElement()));
    for (Enumeration<CommonLanguages> t : src.getLanguage()) tgt.getLanguage().add(new CodeType(t.getCode()));
    for (org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent t : src.getFilter())
      tgt.addFilter(convertTerminologyCapabilitiesCodeSystemVersionFilterComponent(t));
    for (org.hl7.fhir.r5.model.CodeType t : src.getProperty()) tgt.getProperty().add(Code43_50.convertCode(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent convertTerminologyCapabilitiesCodeSystemVersionFilterComponent(org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent tgt = new org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    for (org.hl7.fhir.r4b.model.CodeType t : src.getOp()) tgt.getOp().add(Code43_50.convertCode(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent convertTerminologyCapabilitiesCodeSystemVersionFilterComponent(org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent tgt = new org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    for (org.hl7.fhir.r5.model.CodeType t : src.getOp()) tgt.getOp().add(Code43_50.convertCode(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionComponent convertTerminologyCapabilitiesExpansionComponent(org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionComponent tgt = new org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasHierarchical())
      tgt.setHierarchicalElement(Boolean43_50.convertBoolean(src.getHierarchicalElement()));
    if (src.hasPaging())
      tgt.setPagingElement(Boolean43_50.convertBoolean(src.getPagingElement()));
    if (src.hasIncomplete())
      tgt.setIncompleteElement(Boolean43_50.convertBoolean(src.getIncompleteElement()));
    for (org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent t : src.getParameter())
      tgt.addParameter(convertTerminologyCapabilitiesExpansionParameterComponent(t));
    if (src.hasTextFilter())
      tgt.setTextFilterElement(MarkDown43_50.convertMarkdown(src.getTextFilterElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionComponent convertTerminologyCapabilitiesExpansionComponent(org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionComponent tgt = new org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasHierarchical())
      tgt.setHierarchicalElement(Boolean43_50.convertBoolean(src.getHierarchicalElement()));
    if (src.hasPaging())
      tgt.setPagingElement(Boolean43_50.convertBoolean(src.getPagingElement()));
    if (src.hasIncomplete())
      tgt.setIncompleteElement(Boolean43_50.convertBoolean(src.getIncompleteElement()));
    for (org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent t : src.getParameter())
      tgt.addParameter(convertTerminologyCapabilitiesExpansionParameterComponent(t));
    if (src.hasTextFilter())
      tgt.setTextFilterElement(MarkDown43_50.convertMarkdown(src.getTextFilterElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent convertTerminologyCapabilitiesExpansionParameterComponent(org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent tgt = new org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Code43_50.convertCode(src.getNameElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String43_50.convertString(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent convertTerminologyCapabilitiesExpansionParameterComponent(org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent tgt = new org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Code43_50.convertCode(src.getNameElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String43_50.convertString(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesValidateCodeComponent convertTerminologyCapabilitiesValidateCodeComponent(org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesValidateCodeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesValidateCodeComponent tgt = new org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesValidateCodeComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasTranslations())
      tgt.setTranslationsElement(Boolean43_50.convertBoolean(src.getTranslationsElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesValidateCodeComponent convertTerminologyCapabilitiesValidateCodeComponent(org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesValidateCodeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesValidateCodeComponent tgt = new org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesValidateCodeComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasTranslations())
      tgt.setTranslationsElement(Boolean43_50.convertBoolean(src.getTranslationsElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesTranslationComponent convertTerminologyCapabilitiesTranslationComponent(org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesTranslationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesTranslationComponent tgt = new org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesTranslationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasNeedsMap())
      tgt.setNeedsMapElement(Boolean43_50.convertBoolean(src.getNeedsMapElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesTranslationComponent convertTerminologyCapabilitiesTranslationComponent(org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesTranslationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesTranslationComponent tgt = new org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesTranslationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasNeedsMap())
      tgt.setNeedsMapElement(Boolean43_50.convertBoolean(src.getNeedsMapElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesClosureComponent convertTerminologyCapabilitiesClosureComponent(org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesClosureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesClosureComponent tgt = new org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesClosureComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasTranslation())
      tgt.setTranslationElement(Boolean43_50.convertBoolean(src.getTranslationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesClosureComponent convertTerminologyCapabilitiesClosureComponent(org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesClosureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesClosureComponent tgt = new org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesClosureComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasTranslation())
      tgt.setTranslationElement(Boolean43_50.convertBoolean(src.getTranslationElement()));
    return tgt;
  }
}