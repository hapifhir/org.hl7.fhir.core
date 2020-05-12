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
public class TerminologyCapabilities40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.TerminologyCapabilities convertTerminologyCapabilities(org.hl7.fhir.r4.model.TerminologyCapabilities src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TerminologyCapabilities tgt = new org.hl7.fhir.r5.model.TerminologyCapabilities();
        copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        if (src.hasVersion())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) tgt.addUseContext(convertUsageContext(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(convertMarkdown(src.getPurposeElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
        if (src.hasKind())
            tgt.setKindElement(convertCapabilityStatementKind(src.getKindElement()));
        if (src.hasSoftware())
            tgt.setSoftware(convertTerminologyCapabilitiesSoftwareComponent(src.getSoftware()));
        if (src.hasImplementation())
            tgt.setImplementation(convertTerminologyCapabilitiesImplementationComponent(src.getImplementation()));
        if (src.hasLockedDate())
            tgt.setLockedDateElement(convertBoolean(src.getLockedDateElement()));
        for (org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent t : src.getCodeSystem()) tgt.addCodeSystem(convertTerminologyCapabilitiesCodeSystemComponent(t));
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

    public static org.hl7.fhir.r4.model.TerminologyCapabilities convertTerminologyCapabilities(org.hl7.fhir.r5.model.TerminologyCapabilities src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TerminologyCapabilities tgt = new org.hl7.fhir.r4.model.TerminologyCapabilities();
        copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        if (src.hasVersion())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(convertUsageContext(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(convertMarkdown(src.getPurposeElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
        if (src.hasKind())
            tgt.setKindElement(convertCapabilityStatementKind(src.getKindElement()));
        if (src.hasSoftware())
            tgt.setSoftware(convertTerminologyCapabilitiesSoftwareComponent(src.getSoftware()));
        if (src.hasImplementation())
            tgt.setImplementation(convertTerminologyCapabilitiesImplementationComponent(src.getImplementation()));
        if (src.hasLockedDate())
            tgt.setLockedDateElement(convertBoolean(src.getLockedDateElement()));
        for (org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent t : src.getCodeSystem()) tgt.addCodeSystem(convertTerminologyCapabilitiesCodeSystemComponent(t));
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

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind> convertCapabilityStatementKind(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TerminologyCapabilities.CapabilityStatementKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKindEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TerminologyCapabilities.CapabilityStatementKind> convertCapabilityStatementKind(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TerminologyCapabilities.CapabilityStatementKind> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TerminologyCapabilities.CapabilityStatementKindEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case INSTANCE:
                tgt.setValue(org.hl7.fhir.r4.model.TerminologyCapabilities.CapabilityStatementKind.INSTANCE);
                break;
            case CAPABILITY:
                tgt.setValue(org.hl7.fhir.r4.model.TerminologyCapabilities.CapabilityStatementKind.CAPABILITY);
                break;
            case REQUIREMENTS:
                tgt.setValue(org.hl7.fhir.r4.model.TerminologyCapabilities.CapabilityStatementKind.REQUIREMENTS);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.TerminologyCapabilities.CapabilityStatementKind.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TerminologyCapabilities.CodeSearchSupport> convertCodeSearchSupport(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TerminologyCapabilities.CodeSearchSupport> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TerminologyCapabilities.CodeSearchSupport> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TerminologyCapabilities.CodeSearchSupportEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case EXPLICIT:
                tgt.setValue(org.hl7.fhir.r5.model.TerminologyCapabilities.CodeSearchSupport.EXPLICIT);
                break;
            case ALL:
                tgt.setValue(org.hl7.fhir.r5.model.TerminologyCapabilities.CodeSearchSupport.ALL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.TerminologyCapabilities.CodeSearchSupport.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TerminologyCapabilities.CodeSearchSupport> convertCodeSearchSupport(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TerminologyCapabilities.CodeSearchSupport> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TerminologyCapabilities.CodeSearchSupport> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TerminologyCapabilities.CodeSearchSupportEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case EXPLICIT:
                tgt.setValue(org.hl7.fhir.r4.model.TerminologyCapabilities.CodeSearchSupport.EXPLICIT);
                break;
            case ALL:
                tgt.setValue(org.hl7.fhir.r4.model.TerminologyCapabilities.CodeSearchSupport.ALL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.TerminologyCapabilities.CodeSearchSupport.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesSoftwareComponent convertTerminologyCapabilitiesSoftwareComponent(org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesSoftwareComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesSoftwareComponent tgt = new org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesSoftwareComponent();
        copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasVersion())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesSoftwareComponent convertTerminologyCapabilitiesSoftwareComponent(org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesSoftwareComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesSoftwareComponent tgt = new org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesSoftwareComponent();
        copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasVersion())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesImplementationComponent convertTerminologyCapabilitiesImplementationComponent(org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesImplementationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesImplementationComponent tgt = new org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesImplementationComponent();
        copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasUrl())
            tgt.setUrlElement(convertUrl(src.getUrlElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesImplementationComponent convertTerminologyCapabilitiesImplementationComponent(org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesImplementationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesImplementationComponent tgt = new org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesImplementationComponent();
        copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasUrl())
            tgt.setUrlElement(convertUrl(src.getUrlElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent convertTerminologyCapabilitiesCodeSystemComponent(org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent tgt = new org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent();
        copyElement(src, tgt);
        if (src.hasUri())
            tgt.setUriElement(convertCanonical(src.getUriElement()));
        for (org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent t : src.getVersion()) tgt.addVersion(convertTerminologyCapabilitiesCodeSystemVersionComponent(t));
        if (src.hasSubsumption())
            tgt.setSubsumptionElement(convertBoolean(src.getSubsumptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent convertTerminologyCapabilitiesCodeSystemComponent(org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent tgt = new org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent();
        copyElement(src, tgt);
        if (src.hasUri())
            tgt.setUriElement(convertCanonical(src.getUriElement()));
        for (org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent t : src.getVersion()) tgt.addVersion(convertTerminologyCapabilitiesCodeSystemVersionComponent(t));
        if (src.hasSubsumption())
            tgt.setSubsumptionElement(convertBoolean(src.getSubsumptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent convertTerminologyCapabilitiesCodeSystemVersionComponent(org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent tgt = new org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertString(src.getCodeElement()));
        if (src.hasIsDefault())
            tgt.setIsDefaultElement(convertBoolean(src.getIsDefaultElement()));
        if (src.hasCompositional())
            tgt.setCompositionalElement(convertBoolean(src.getCompositionalElement()));
        for (org.hl7.fhir.r4.model.CodeType t : src.getLanguage()) tgt.getLanguage().add(convertCode(t));
        for (org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent t : src.getFilter()) tgt.addFilter(convertTerminologyCapabilitiesCodeSystemVersionFilterComponent(t));
        for (org.hl7.fhir.r4.model.CodeType t : src.getProperty()) tgt.getProperty().add(convertCode(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent convertTerminologyCapabilitiesCodeSystemVersionComponent(org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent tgt = new org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertString(src.getCodeElement()));
        if (src.hasIsDefault())
            tgt.setIsDefaultElement(convertBoolean(src.getIsDefaultElement()));
        if (src.hasCompositional())
            tgt.setCompositionalElement(convertBoolean(src.getCompositionalElement()));
        for (org.hl7.fhir.r5.model.CodeType t : src.getLanguage()) tgt.getLanguage().add(convertCode(t));
        for (org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent t : src.getFilter()) tgt.addFilter(convertTerminologyCapabilitiesCodeSystemVersionFilterComponent(t));
        for (org.hl7.fhir.r5.model.CodeType t : src.getProperty()) tgt.getProperty().add(convertCode(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent convertTerminologyCapabilitiesCodeSystemVersionFilterComponent(org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent tgt = new org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        for (org.hl7.fhir.r4.model.CodeType t : src.getOp()) tgt.getOp().add(convertCode(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent convertTerminologyCapabilitiesCodeSystemVersionFilterComponent(org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent tgt = new org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        for (org.hl7.fhir.r5.model.CodeType t : src.getOp()) tgt.getOp().add(convertCode(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionComponent convertTerminologyCapabilitiesExpansionComponent(org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionComponent tgt = new org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionComponent();
        copyElement(src, tgt);
        if (src.hasHierarchical())
            tgt.setHierarchicalElement(convertBoolean(src.getHierarchicalElement()));
        if (src.hasPaging())
            tgt.setPagingElement(convertBoolean(src.getPagingElement()));
        if (src.hasIncomplete())
            tgt.setIncompleteElement(convertBoolean(src.getIncompleteElement()));
        for (org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent t : src.getParameter()) tgt.addParameter(convertTerminologyCapabilitiesExpansionParameterComponent(t));
        if (src.hasTextFilter())
            tgt.setTextFilterElement(convertMarkdown(src.getTextFilterElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionComponent convertTerminologyCapabilitiesExpansionComponent(org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionComponent tgt = new org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionComponent();
        copyElement(src, tgt);
        if (src.hasHierarchical())
            tgt.setHierarchicalElement(convertBoolean(src.getHierarchicalElement()));
        if (src.hasPaging())
            tgt.setPagingElement(convertBoolean(src.getPagingElement()));
        if (src.hasIncomplete())
            tgt.setIncompleteElement(convertBoolean(src.getIncompleteElement()));
        for (org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent t : src.getParameter()) tgt.addParameter(convertTerminologyCapabilitiesExpansionParameterComponent(t));
        if (src.hasTextFilter())
            tgt.setTextFilterElement(convertMarkdown(src.getTextFilterElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent convertTerminologyCapabilitiesExpansionParameterComponent(org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent tgt = new org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent();
        copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(convertCode(src.getNameElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent convertTerminologyCapabilitiesExpansionParameterComponent(org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent tgt = new org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent();
        copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(convertCode(src.getNameElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesValidateCodeComponent convertTerminologyCapabilitiesValidateCodeComponent(org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesValidateCodeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesValidateCodeComponent tgt = new org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesValidateCodeComponent();
        copyElement(src, tgt);
        if (src.hasTranslations())
            tgt.setTranslationsElement(convertBoolean(src.getTranslationsElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesValidateCodeComponent convertTerminologyCapabilitiesValidateCodeComponent(org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesValidateCodeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesValidateCodeComponent tgt = new org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesValidateCodeComponent();
        copyElement(src, tgt);
        if (src.hasTranslations())
            tgt.setTranslationsElement(convertBoolean(src.getTranslationsElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesTranslationComponent convertTerminologyCapabilitiesTranslationComponent(org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesTranslationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesTranslationComponent tgt = new org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesTranslationComponent();
        copyElement(src, tgt);
        if (src.hasNeedsMap())
            tgt.setNeedsMapElement(convertBoolean(src.getNeedsMapElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesTranslationComponent convertTerminologyCapabilitiesTranslationComponent(org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesTranslationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesTranslationComponent tgt = new org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesTranslationComponent();
        copyElement(src, tgt);
        if (src.hasNeedsMap())
            tgt.setNeedsMapElement(convertBoolean(src.getNeedsMapElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesClosureComponent convertTerminologyCapabilitiesClosureComponent(org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesClosureComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesClosureComponent tgt = new org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesClosureComponent();
        copyElement(src, tgt);
        if (src.hasTranslation())
            tgt.setTranslationElement(convertBoolean(src.getTranslationElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesClosureComponent convertTerminologyCapabilitiesClosureComponent(org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesClosureComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesClosureComponent tgt = new org.hl7.fhir.r4.model.TerminologyCapabilities.TerminologyCapabilitiesClosureComponent();
        copyElement(src, tgt);
        if (src.hasTranslation())
            tgt.setTranslationElement(convertBoolean(src.getTranslationElement()));
        return tgt;
    }
}