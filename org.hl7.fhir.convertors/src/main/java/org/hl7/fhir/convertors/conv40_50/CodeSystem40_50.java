package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.stream.Collectors;

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
public class CodeSystem40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.CodeSystem convertCodeSystem(org.hl7.fhir.r4.model.CodeSystem src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CodeSystem tgt = new org.hl7.fhir.r5.model.CodeSystem();
        copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
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
        if (src.hasCaseSensitive())
            tgt.setCaseSensitiveElement(convertBoolean(src.getCaseSensitiveElement()));
        if (src.hasValueSet())
            tgt.setValueSetElement(convertCanonical(src.getValueSetElement()));
        if (src.hasHierarchyMeaning())
            tgt.setHierarchyMeaningElement(convertCodeSystemHierarchyMeaning(src.getHierarchyMeaningElement()));
        if (src.hasCompositional())
            tgt.setCompositionalElement(convertBoolean(src.getCompositionalElement()));
        if (src.hasVersionNeeded())
            tgt.setVersionNeededElement(convertBoolean(src.getVersionNeededElement()));
        if (src.hasContent())
            tgt.setContentElement(convertCodeSystemContentMode(src.getContentElement()));
        if (src.hasSupplements())
            tgt.setSupplementsElement(convertCanonical(src.getSupplementsElement()));
        if (src.hasCount())
            tgt.setCountElement(convertUnsignedInt(src.getCountElement()));
        for (org.hl7.fhir.r4.model.CodeSystem.CodeSystemFilterComponent t : src.getFilter()) tgt.addFilter(convertCodeSystemFilterComponent(t));
        for (org.hl7.fhir.r4.model.CodeSystem.PropertyComponent t : src.getProperty()) tgt.addProperty(convertPropertyComponent(t));
        for (org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeSystem convertCodeSystem(org.hl7.fhir.r5.model.CodeSystem src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.CodeSystem tgt = new org.hl7.fhir.r4.model.CodeSystem();
        copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
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
        if (src.hasCaseSensitive())
            tgt.setCaseSensitiveElement(convertBoolean(src.getCaseSensitiveElement()));
        if (src.hasValueSet())
            tgt.setValueSetElement(convertCanonical(src.getValueSetElement()));
        if (src.hasHierarchyMeaning())
            tgt.setHierarchyMeaningElement(convertCodeSystemHierarchyMeaning(src.getHierarchyMeaningElement()));
        if (src.hasCompositional())
            tgt.setCompositionalElement(convertBoolean(src.getCompositionalElement()));
        if (src.hasVersionNeeded())
            tgt.setVersionNeededElement(convertBoolean(src.getVersionNeededElement()));
        if (src.hasContent())
            tgt.setContentElement(convertCodeSystemContentMode(src.getContentElement()));
        if (src.hasSupplements())
            tgt.setSupplementsElement(convertCanonical(src.getSupplementsElement()));
        if (src.hasCount())
            tgt.setCountElement(convertUnsignedInt(src.getCountElement()));
        for (org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent t : src.getFilter()) tgt.addFilter(convertCodeSystemFilterComponent(t));
        for (org.hl7.fhir.r5.model.CodeSystem.PropertyComponent t : src.getProperty()) tgt.addProperty(convertPropertyComponent(t));
        for (org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning> convertCodeSystemHierarchyMeaning(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaningEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case GROUPEDBY:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning.GROUPEDBY);
                break;
            case ISA:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning.ISA);
                break;
            case PARTOF:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning.PARTOF);
                break;
            case CLASSIFIEDWITH:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning.CLASSIFIEDWITH);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning> convertCodeSystemHierarchyMeaning(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaningEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case GROUPEDBY:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning.GROUPEDBY);
                break;
            case ISA:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning.ISA);
                break;
            case PARTOF:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning.PARTOF);
                break;
            case CLASSIFIEDWITH:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning.CLASSIFIEDWITH);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode> convertCodeSystemContentMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentModeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NOTPRESENT:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.NOTPRESENT);
                break;
            case EXAMPLE:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.EXAMPLE);
                break;
            case FRAGMENT:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.FRAGMENT);
                break;
            case COMPLETE:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.COMPLETE);
                break;
            case SUPPLEMENT:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.SUPPLEMENT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode> convertCodeSystemContentMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentModeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NOTPRESENT:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode.NOTPRESENT);
                break;
            case EXAMPLE:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode.EXAMPLE);
                break;
            case FRAGMENT:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode.FRAGMENT);
                break;
            case COMPLETE:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode.COMPLETE);
                break;
            case SUPPLEMENT:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode.SUPPLEMENT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent convertCodeSystemFilterComponent(org.hl7.fhir.r4.model.CodeSystem.CodeSystemFilterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        tgt.setOperator(src.getOperator().stream()
                .map(CodeSystem40_50::convertFilterOperator)
                .collect(Collectors.toList()));
        if (src.hasValue())
            tgt.setValueElement(convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeSystem.CodeSystemFilterComponent convertCodeSystemFilterComponent(org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.CodeSystem.CodeSystemFilterComponent tgt = new org.hl7.fhir.r4.model.CodeSystem.CodeSystemFilterComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        tgt.setOperator(src.getOperator().stream()
                .map(CodeSystem40_50::convertFilterOperator)
                .collect(Collectors.toList()));
        if (src.hasValue())
            tgt.setValueElement(convertString(src.getValueElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> convertFilterOperator(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.FilterOperator> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.FilterOperatorEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case EQUAL:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.EQUAL);
                break;
            case ISA:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.ISA);
                break;
            case DESCENDENTOF:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.DESCENDENTOF);
                break;
            case ISNOTA:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.ISNOTA);
                break;
            case REGEX:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.REGEX);
                break;
            case IN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.IN);
                break;
            case NOTIN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.NOTIN);
                break;
            case GENERALIZES:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.GENERALIZES);
                break;
            case EXISTS:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.EXISTS);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.FilterOperator> convertFilterOperator(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.FilterOperator> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CodeSystem.FilterOperatorEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case EQUAL:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.FilterOperator.EQUAL);
                break;
            case ISA:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.FilterOperator.ISA);
                break;
            case DESCENDENTOF:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.FilterOperator.DESCENDENTOF);
                break;
            case ISNOTA:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.FilterOperator.ISNOTA);
                break;
            case REGEX:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.FilterOperator.REGEX);
                break;
            case IN:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.FilterOperator.IN);
                break;
            case NOTIN:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.FilterOperator.NOTIN);
                break;
            case GENERALIZES:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.FilterOperator.GENERALIZES);
                break;
            case EXISTS:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.FilterOperator.EXISTS);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.FilterOperator.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeSystem.PropertyComponent convertPropertyComponent(org.hl7.fhir.r4.model.CodeSystem.PropertyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CodeSystem.PropertyComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.PropertyComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        if (src.hasUri())
            tgt.setUriElement(convertUri(src.getUriElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasType())
            tgt.setTypeElement(convertPropertyType(src.getTypeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeSystem.PropertyComponent convertPropertyComponent(org.hl7.fhir.r5.model.CodeSystem.PropertyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.CodeSystem.PropertyComponent tgt = new org.hl7.fhir.r4.model.CodeSystem.PropertyComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        if (src.hasUri())
            tgt.setUriElement(convertUri(src.getUriElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasType())
            tgt.setTypeElement(convertPropertyType(src.getTypeElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CodeSystem.PropertyType> convertPropertyType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.PropertyType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CodeSystem.PropertyType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CodeSystem.PropertyTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CODE:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.PropertyType.CODE);
                break;
            case CODING:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.PropertyType.CODING);
                break;
            case STRING:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.PropertyType.STRING);
                break;
            case INTEGER:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.PropertyType.INTEGER);
                break;
            case BOOLEAN:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.PropertyType.BOOLEAN);
                break;
            case DATETIME:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.PropertyType.DATETIME);
                break;
            case DECIMAL:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.PropertyType.DECIMAL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.PropertyType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.PropertyType> convertPropertyType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CodeSystem.PropertyType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.PropertyType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CodeSystem.PropertyTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CODE:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.PropertyType.CODE);
                break;
            case CODING:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.PropertyType.CODING);
                break;
            case STRING:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.PropertyType.STRING);
                break;
            case INTEGER:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.PropertyType.INTEGER);
                break;
            case BOOLEAN:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.PropertyType.BOOLEAN);
                break;
            case DATETIME:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.PropertyType.DATETIME);
                break;
            case DECIMAL:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.PropertyType.DECIMAL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.PropertyType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent convertConceptDefinitionComponent(org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(convertString(src.getDisplayElement()));
        if (src.hasDefinition())
            tgt.setDefinitionElement(convertString(src.getDefinitionElement()));
        for (org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptDefinitionDesignationComponent(t));
        for (org.hl7.fhir.r4.model.CodeSystem.ConceptPropertyComponent t : src.getProperty()) tgt.addProperty(convertConceptPropertyComponent(t));
        for (org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent convertConceptDefinitionComponent(org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent tgt = new org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(convertString(src.getDisplayElement()));
        if (src.hasDefinition())
            tgt.setDefinitionElement(convertString(src.getDefinitionElement()));
        for (org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptDefinitionDesignationComponent(t));
        for (org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent t : src.getProperty()) tgt.addProperty(convertConceptPropertyComponent(t));
        for (org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent convertConceptDefinitionDesignationComponent(org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionDesignationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent();
        copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguageElement(convertCode(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(convertCoding(src.getUse()));
        if (src.hasValue())
            tgt.setValueElement(convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionDesignationComponent convertConceptDefinitionDesignationComponent(org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionDesignationComponent();
        copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguageElement(convertCode(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(convertCoding(src.getUse()));
        if (src.hasValue())
            tgt.setValueElement(convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent convertConceptPropertyComponent(org.hl7.fhir.r4.model.CodeSystem.ConceptPropertyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        if (src.hasValue())
            tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeSystem.ConceptPropertyComponent convertConceptPropertyComponent(org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.CodeSystem.ConceptPropertyComponent tgt = new org.hl7.fhir.r4.model.CodeSystem.ConceptPropertyComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        if (src.hasValue())
            tgt.setValue(convertType(src.getValue()));
        return tgt;
    }
}