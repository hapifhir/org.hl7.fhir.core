package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeType;

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
public class SearchParameter40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.SearchParameter convertSearchParameter(org.hl7.fhir.r4.model.SearchParameter src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.SearchParameter tgt = new org.hl7.fhir.r5.model.SearchParameter();
        copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        if (src.hasVersion())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasDerivedFrom())
            tgt.setDerivedFromElement(convertCanonical(src.getDerivedFromElement()));
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
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        for (org.hl7.fhir.r4.model.CodeType t : src.getBase()) tgt.getBase().add(convertResourceEnum(t));
        if (src.hasType())
            tgt.setTypeElement(Enumerations40_50.convertSearchParamType(src.getTypeElement()));
        if (src.hasExpression())
            tgt.setExpressionElement(convertString(src.getExpressionElement()));
        if (src.hasXpath())
            tgt.setXpathElement(convertString(src.getXpathElement()));
        if (src.hasXpathUsage())
            tgt.setXpathUsageElement(convertXPathUsageType(src.getXpathUsageElement()));
        for (org.hl7.fhir.r4.model.CodeType t : src.getTarget()) tgt.getTarget().add(convertResourceEnum(t));
        if (src.hasMultipleOr())
            tgt.setMultipleOrElement(convertBoolean(src.getMultipleOrElement()));
        if (src.hasMultipleAnd())
            tgt.setMultipleAndElement(convertBoolean(src.getMultipleAndElement()));
        tgt.setComparator(src.getComparator().stream()
                .map(SearchParameter40_50::convertSearchComparator)
                .collect(Collectors.toList()));
        tgt.setModifier(src.getModifier().stream()
                .map(SearchParameter40_50::convertSearchModifierCode)
                .collect(Collectors.toList()));
        for (org.hl7.fhir.r4.model.StringType t : src.getChain()) tgt.getChain().add(convertString(t));
        for (org.hl7.fhir.r4.model.SearchParameter.SearchParameterComponentComponent t : src.getComponent()) tgt.addComponent(convertSearchParameterComponentComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.SearchParameter convertSearchParameter(org.hl7.fhir.r5.model.SearchParameter src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.SearchParameter tgt = new org.hl7.fhir.r4.model.SearchParameter();
        copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        if (src.hasVersion())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasDerivedFrom())
            tgt.setDerivedFromElement(convertCanonical(src.getDerivedFromElement()));
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
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        for (CodeType t : src.getBase()) tgt.getBase().add(convertResourceEnum(t));
        if (src.hasType())
            tgt.setTypeElement(Enumerations40_50.convertSearchParamType(src.getTypeElement()));
        if (src.hasExpression())
            tgt.setExpressionElement(convertString(src.getExpressionElement()));
        if (src.hasXpath())
            tgt.setXpathElement(convertString(src.getXpathElement()));
        if (src.hasXpathUsage())
            tgt.setXpathUsageElement(convertXPathUsageType(src.getXpathUsageElement()));
        for (CodeType t : src.getTarget()) tgt.getTarget().add(convertResourceEnum(t));
        if (src.hasMultipleOr())
            tgt.setMultipleOrElement(convertBoolean(src.getMultipleOrElement()));
        if (src.hasMultipleAnd())
            tgt.setMultipleAndElement(convertBoolean(src.getMultipleAndElement()));
        tgt.setComparator(src.getComparator().stream()
                .map(SearchParameter40_50::convertSearchComparator)
                .collect(Collectors.toList()));
        tgt.setModifier(src.getModifier().stream()
                .map(SearchParameter40_50::convertSearchModifierCode)
                .collect(Collectors.toList()));
        for (org.hl7.fhir.r5.model.StringType t : src.getChain()) tgt.getChain().add(convertString(t));
        for (org.hl7.fhir.r5.model.SearchParameter.SearchParameterComponentComponent t : src.getComponent()) tgt.addComponent(convertSearchParameterComponentComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.XPathUsageType> convertXPathUsageType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SearchParameter.XPathUsageType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.XPathUsageType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.SearchParameter.XPathUsageTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NORMAL:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.XPathUsageType.NORMAL);
                break;
            case PHONETIC:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.XPathUsageType.PHONETIC);
                break;
            case NEARBY:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.XPathUsageType.NEARBY);
                break;
            case DISTANCE:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.XPathUsageType.DISTANCE);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.XPathUsageType.OTHER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.XPathUsageType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SearchParameter.XPathUsageType> convertXPathUsageType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.XPathUsageType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SearchParameter.XPathUsageType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.SearchParameter.XPathUsageTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NORMAL:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.NORMAL);
                break;
            case PHONETIC:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.PHONETIC);
                break;
            case NEARBY:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.NEARBY);
                break;
            case DISTANCE:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.DISTANCE);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.OTHER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.SearchComparator> convertSearchComparator(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SearchParameter.SearchComparator> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.SearchComparator> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.SearchParameter.SearchComparatorEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case EQ:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchComparator.EQ);
                break;
            case NE:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchComparator.NE);
                break;
            case GT:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchComparator.GT);
                break;
            case LT:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchComparator.LT);
                break;
            case GE:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchComparator.GE);
                break;
            case LE:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchComparator.LE);
                break;
            case SA:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchComparator.SA);
                break;
            case EB:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchComparator.EB);
                break;
            case AP:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchComparator.AP);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchComparator.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SearchParameter.SearchComparator> convertSearchComparator(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.SearchComparator> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SearchParameter.SearchComparator> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.SearchParameter.SearchComparatorEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case EQ:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchComparator.EQ);
                break;
            case NE:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchComparator.NE);
                break;
            case GT:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchComparator.GT);
                break;
            case LT:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchComparator.LT);
                break;
            case GE:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchComparator.GE);
                break;
            case LE:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchComparator.LE);
                break;
            case SA:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchComparator.SA);
                break;
            case EB:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchComparator.EB);
                break;
            case AP:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchComparator.AP);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchComparator.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode> convertSearchModifierCode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.SearchParameter.SearchModifierCodeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case MISSING:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.MISSING);
                break;
            case EXACT:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.EXACT);
                break;
            case CONTAINS:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.CONTAINS);
                break;
            case NOT:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.NOT);
                break;
            case TEXT:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.TEXT);
                break;
            case IN:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.IN);
                break;
            case NOTIN:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.NOTIN);
                break;
            case BELOW:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.BELOW);
                break;
            case ABOVE:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.ABOVE);
                break;
            case TYPE:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.TYPE);
                break;
            case IDENTIFIER:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.IDENTIFIER);
                break;
            case OFTYPE:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.OFTYPE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode> convertSearchModifierCode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.SearchParameter.SearchModifierCodeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case MISSING:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.MISSING);
                break;
            case EXACT:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.EXACT);
                break;
            case CONTAINS:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.CONTAINS);
                break;
            case NOT:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.NOT);
                break;
            case TEXT:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.TEXT);
                break;
            case IN:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.IN);
                break;
            case NOTIN:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.NOTIN);
                break;
            case BELOW:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.BELOW);
                break;
            case ABOVE:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.ABOVE);
                break;
            case TYPE:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.TYPE);
                break;
            case IDENTIFIER:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.IDENTIFIER);
                break;
            case OFTYPE:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.OFTYPE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.SearchParameter.SearchParameterComponentComponent convertSearchParameterComponentComponent(org.hl7.fhir.r4.model.SearchParameter.SearchParameterComponentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.SearchParameter.SearchParameterComponentComponent tgt = new org.hl7.fhir.r5.model.SearchParameter.SearchParameterComponentComponent();
        copyElement(src, tgt);
        if (src.hasDefinition())
            tgt.setDefinitionElement(convertCanonical(src.getDefinitionElement()));
        if (src.hasExpression())
            tgt.setExpressionElement(convertString(src.getExpressionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.SearchParameter.SearchParameterComponentComponent convertSearchParameterComponentComponent(org.hl7.fhir.r5.model.SearchParameter.SearchParameterComponentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.SearchParameter.SearchParameterComponentComponent tgt = new org.hl7.fhir.r4.model.SearchParameter.SearchParameterComponentComponent();
        copyElement(src, tgt);
        if (src.hasDefinition())
            tgt.setDefinitionElement(convertCanonical(src.getDefinitionElement()));
        if (src.hasExpression())
            tgt.setExpressionElement(convertString(src.getExpressionElement()));
        return tgt;
    }
}