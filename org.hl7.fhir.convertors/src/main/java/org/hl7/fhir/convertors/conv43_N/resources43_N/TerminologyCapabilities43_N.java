package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.ContactDetail43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.UsageContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Canonical43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Code43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.MarkDown43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Url43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.CodeType;
import org.hl7.fhir.r4b.model.TerminologyCapabilities;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;

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

public class TerminologyCapabilities43_N {

  public static org.hl7.fhir.model.core.TerminologyCapabilities convertTerminologyCapabilities(org.hl7.fhir.r4b.model.TerminologyCapabilities src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.TerminologyCapabilities tgt = new org.hl7.fhir.model.core.TerminologyCapabilities();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
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
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasKind())
      tgt.setKindElement(convertCapabilityStatementKind(src.getKindElement()));
    if (src.hasSoftware())
      tgt.setSoftware(convertTerminologyCapabilitiesSoftwareComponent(src.getSoftware()));
    if (src.hasImplementation())
      tgt.setImplementation(convertTerminologyCapabilitiesImplementationComponent(src.getImplementation()));
    if (src.hasLockedDate())
      tgt.setLockedDateElement(Boolean43_N.convertBoolean(src.getLockedDateElement()));
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
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TerminologyCapabilities convertTerminologyCapabilities(org.hl7.fhir.model.core.TerminologyCapabilities src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TerminologyCapabilities tgt = new org.hl7.fhir.r4b.model.TerminologyCapabilities();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
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
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasKind())
      tgt.setKindElement(convertCapabilityStatementKind(src.getKindElement()));
    if (src.hasSoftware())
      tgt.setSoftware(convertTerminologyCapabilitiesSoftwareComponent(src.getSoftware()));
    if (src.hasImplementation())
      tgt.setImplementation(convertTerminologyCapabilitiesImplementationComponent(src.getImplementation()));
    if (src.hasLockedDate())
      tgt.setLockedDateElement(Boolean43_N.convertBoolean(src.getLockedDateElement()));
    for (org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent t : src.getCodeSystemList())
      tgt.addCodeSystem(convertTerminologyCapabilitiesCodeSystemComponent(t));
    if (src.hasExpansion())
      tgt.setExpansion(convertTerminologyCapabilitiesExpansionComponent(src.getExpansion()));
    if (src.hasCodeSearch())
      tgt.setCodeSearchElement(convertCodeSearchSupport(src.getCodeSearchElement()));
    if (src.hasValidateCode())
      tgt.setValidateCode(convertTerminologyCapabilitiesValidateCodeComponent(src.getValidateCode()));
    if (src.hasTranslation())
      tgt.setTranslation(convertTerminologyCapabilitiesTranslationComponent(src.getTranslation()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CapabilityStatementKind> convertCapabilityStatementKind(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.CapabilityStatementKind> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.CapabilityStatementKind> tgt = new Enumeration<>(new Enumerations.CapabilityStatementKindEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case INSTANCE:
                  tgt.setValue(Enumerations.CapabilityStatementKind.INSTANCE);
                  break;
              case CAPABILITY:
                  tgt.setValue(Enumerations.CapabilityStatementKind.CAPABILITY);
                  break;
              case REQUIREMENTS:
                  tgt.setValue(Enumerations.CapabilityStatementKind.REQUIREMENTS);
                  break;
              default:
                  tgt.setValue(Enumerations.CapabilityStatementKind.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.CapabilityStatementKind> convertCapabilityStatementKind(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CapabilityStatementKind> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.CapabilityStatementKind> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.CapabilityStatementKindEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.TerminologyCapabilities.CodeSearchSupport> convertCodeSearchSupport(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TerminologyCapabilities.CodeSearchSupport> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.core.TerminologyCapabilities.CodeSearchSupport> tgt = new Enumeration<>(new org.hl7.fhir.model.core.TerminologyCapabilities.CodeSearchSupportEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case EXPLICIT:
                  tgt.setValue(org.hl7.fhir.model.core.TerminologyCapabilities.CodeSearchSupport.INCOMPOSE);
                  break;
              case ALL:
                  tgt.setValue(org.hl7.fhir.model.core.TerminologyCapabilities.CodeSearchSupport.INCOMPOSEOREXPANSION);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.model.core.TerminologyCapabilities.CodeSearchSupport.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TerminologyCapabilities.CodeSearchSupport> convertCodeSearchSupport(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.TerminologyCapabilities.CodeSearchSupport> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<TerminologyCapabilities.CodeSearchSupport> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new TerminologyCapabilities.CodeSearchSupportEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case INCOMPOSE:
                  tgt.setValue(TerminologyCapabilities.CodeSearchSupport.EXPLICIT);
                  break;
              case INCOMPOSEOREXPANSION:
                  tgt.setValue(TerminologyCapabilities.CodeSearchSupport.ALL);
                  break;
              default:
                  tgt.setValue(TerminologyCapabilities.CodeSearchSupport.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesSoftwareComponent convertTerminologyCapabilitiesSoftwareComponent(org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesSoftwareComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesSoftwareComponent tgt = new org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesSoftwareComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesSoftwareComponent convertTerminologyCapabilitiesSoftwareComponent(org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesSoftwareComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesSoftwareComponent tgt = new org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesSoftwareComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesImplementationComponent convertTerminologyCapabilitiesImplementationComponent(org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesImplementationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesImplementationComponent tgt = new org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesImplementationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasUrl())
      tgt.setUrlElement(Url43_N.convertUrl(src.getUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesImplementationComponent convertTerminologyCapabilitiesImplementationComponent(org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesImplementationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesImplementationComponent tgt = new org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesImplementationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    if (src.hasUrl())
      tgt.setUrlElement(Url43_N.convertUrl(src.getUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent convertTerminologyCapabilitiesCodeSystemComponent(org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent tgt = new org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasUri())
      tgt.setUriElement(Canonical43_N.convertCanonical(src.getUriElement()));
    for (org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent t : src.getVersion())
      tgt.addVersion(convertTerminologyCapabilitiesCodeSystemVersionComponent(t));
    if (src.hasSubsumption())
      tgt.setSubsumptionElement(Boolean43_N.convertBoolean(src.getSubsumptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent convertTerminologyCapabilitiesCodeSystemComponent(org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent tgt = new org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasUri())
      tgt.setUriElement(Canonical43_N.convertCanonical(src.getUriElement()));
    for (org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent t : src.getVersionList())
      tgt.addVersion(convertTerminologyCapabilitiesCodeSystemVersionComponent(t));
    if (src.hasSubsumption())
      tgt.setSubsumptionElement(Boolean43_N.convertBoolean(src.getSubsumptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent convertTerminologyCapabilitiesCodeSystemVersionComponent(org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent tgt = new org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setValueElement(String43_N.convertString(src.getCodeElement()));
    if (src.hasIsDefault())
      tgt.setIsDefaultElement(Boolean43_N.convertBoolean(src.getIsDefaultElement()));
    if (src.hasCompositional())
      tgt.setCompositionalElement(Boolean43_N.convertBoolean(src.getCompositionalElement()));
    for (org.hl7.fhir.r4b.model.CodeType t : src.getLanguage()) tgt.getLanguageList().add(Code43_N.convertCode(t));
    for (org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent t : src.getFilter())
      tgt.addFilter(convertTerminologyCapabilitiesCodeSystemVersionFilterComponent(t));
    for (org.hl7.fhir.r4b.model.CodeType t : src.getProperty()) tgt.getPropertyList().add(Code43_N.convertCode(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent convertTerminologyCapabilitiesCodeSystemVersionComponent(org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent tgt = new org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasValue())
      tgt.setCodeElement(String43_N.convertString(src.getValueElement()));
    if (src.hasIsDefault())
      tgt.setIsDefaultElement(Boolean43_N.convertBoolean(src.getIsDefaultElement()));
    if (src.hasCompositional())
      tgt.setCompositionalElement(Boolean43_N.convertBoolean(src.getCompositionalElement()));
    for (org.hl7.fhir.model.core.CodeType t : src.getLanguageList()) tgt.getLanguage().add(Code43_N.convertCode(t));
    for (org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent t : src.getFilterList())
      tgt.addFilter(convertTerminologyCapabilitiesCodeSystemVersionFilterComponent(t));
    for (org.hl7.fhir.model.core.CodeType t : src.getPropertyList()) tgt.getProperty().add(Code43_N.convertCode(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent convertTerminologyCapabilitiesCodeSystemVersionFilterComponent(org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent tgt = new org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_N.convertCode(src.getCodeElement()));
    for (org.hl7.fhir.r4b.model.CodeType t : src.getOp()) tgt.getOpList().add(Code43_N.convertCode(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent convertTerminologyCapabilitiesCodeSystemVersionFilterComponent(org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent tgt = new org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_N.convertCode(src.getCodeElement()));
    for (org.hl7.fhir.model.core.CodeType t : src.getOpList()) tgt.getOp().add(Code43_N.convertCode(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesExpansionComponent convertTerminologyCapabilitiesExpansionComponent(org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesExpansionComponent tgt = new org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesExpansionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasHierarchical())
      tgt.setHierarchicalElement(Boolean43_N.convertBoolean(src.getHierarchicalElement()));
    if (src.hasPaging())
      tgt.setPagingElement(Boolean43_N.convertBoolean(src.getPagingElement()));
    if (src.hasIncomplete())
      tgt.setIncompleteElement(Boolean43_N.convertBoolean(src.getIncompleteElement()));
    for (org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent t : src.getParameter())
      tgt.addParameter(convertTerminologyCapabilitiesExpansionParameterComponent(t));
    if (src.hasTextFilter())
      tgt.setTextFilterElement(MarkDown43_N.convertMarkdown(src.getTextFilterElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionComponent convertTerminologyCapabilitiesExpansionComponent(org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesExpansionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionComponent tgt = new org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasHierarchical())
      tgt.setHierarchicalElement(Boolean43_N.convertBoolean(src.getHierarchicalElement()));
    if (src.hasPaging())
      tgt.setPagingElement(Boolean43_N.convertBoolean(src.getPagingElement()));
    if (src.hasIncomplete())
      tgt.setIncompleteElement(Boolean43_N.convertBoolean(src.getIncompleteElement()));
    for (org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent t : src.getParameterList())
      tgt.addParameter(convertTerminologyCapabilitiesExpansionParameterComponent(t));
    if (src.hasTextFilter())
      tgt.setTextFilterElement(MarkDown43_N.convertMarkdown(src.getTextFilterElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent convertTerminologyCapabilitiesExpansionParameterComponent(org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent tgt = new org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Code43_N.convertCode(src.getNameElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String43_N.convertStringToMarkdown(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent convertTerminologyCapabilitiesExpansionParameterComponent(org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent tgt = new org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Code43_N.convertCode(src.getNameElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String43_N.convertString(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesValidateCodeComponent convertTerminologyCapabilitiesValidateCodeComponent(org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesValidateCodeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesValidateCodeComponent tgt = new org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesValidateCodeComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasTranslations())
      tgt.setTranslationsElement(Boolean43_N.convertBoolean(src.getTranslationsElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesValidateCodeComponent convertTerminologyCapabilitiesValidateCodeComponent(org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesValidateCodeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesValidateCodeComponent tgt = new org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesValidateCodeComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasTranslations())
      tgt.setTranslationsElement(Boolean43_N.convertBoolean(src.getTranslationsElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesTranslationComponent convertTerminologyCapabilitiesTranslationComponent(org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesTranslationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesTranslationComponent tgt = new org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesTranslationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasNeedsMap())
      tgt.setNeedsMapElement(Boolean43_N.convertBoolean(src.getNeedsMapElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesTranslationComponent convertTerminologyCapabilitiesTranslationComponent(org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesTranslationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesTranslationComponent tgt = new org.hl7.fhir.r4b.model.TerminologyCapabilities.TerminologyCapabilitiesTranslationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasNeedsMap())
      tgt.setNeedsMapElement(Boolean43_N.convertBoolean(src.getNeedsMapElement()));
    return tgt;
  }

}