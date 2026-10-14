package org.hl7.fhir.convertors.conv43_N.resources43_N;

import java.util.stream.Collectors;

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
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;
import org.hl7.fhir.model.core.SearchParameter;
import org.hl7.fhir.model.core.UriType;

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

public class SearchParameter43_N {

  public static org.hl7.fhir.model.core.SearchParameter convertSearchParameter(org.hl7.fhir.r4b.model.SearchParameter src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.SearchParameter tgt = new org.hl7.fhir.model.core.SearchParameter();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasDerivedFrom())
      tgt.setDerivedFromElement(Canonical43_N.convertCanonical(src.getDerivedFromElement()));
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
    if (src.hasCode())
      tgt.setCodeElement(Code43_N.convertCode(src.getCodeElement()));
    for (org.hl7.fhir.r4b.model.CodeType t : src.getBase()) tgt.getBaseList().add(Uri43_N.convertUriFromCode(t));
    if (src.hasType())
      tgt.setTypeElement(Enumerations43_N.convertSearchParamType(src.getTypeElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(String43_N.convertString(src.getExpressionElement()));
//    if (src.hasXpath())
//      tgt.setXpathElement(String43_N.convertString(src.getXpathElement()));
    if (src.hasXpathUsage())
      tgt.setProcessingModeElement(convertXPathUsageType(src.getXpathUsageElement()));
    for (org.hl7.fhir.r4b.model.CodeType t : src.getTarget()) tgt.getTargetList().add(Uri43_N.convertUriFromCode(t));
    if (src.hasMultipleOr())
      tgt.setMultipleOrElement(Boolean43_N.convertBoolean(src.getMultipleOrElement()));
    if (src.hasMultipleAnd())
      tgt.setMultipleAndElement(Boolean43_N.convertBoolean(src.getMultipleAndElement()));
    tgt.setComparatorList(src.getComparator().stream()
      .map(SearchParameter43_N::convertSearchComparator)
      .collect(Collectors.toList()));
    tgt.setModifierList(src.getModifier().stream()
      .map(SearchParameter43_N::convertSearchModifierCode)
      .collect(Collectors.toList()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getChain()) tgt.getChainList().add(String43_N.convertString(t));
    for (org.hl7.fhir.r4b.model.SearchParameter.SearchParameterComponentComponent t : src.getComponent())
      tgt.addComponent(convertSearchParameterComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.SearchParameter convertSearchParameter(org.hl7.fhir.model.core.SearchParameter src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.SearchParameter tgt = new org.hl7.fhir.r4b.model.SearchParameter();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasDerivedFrom())
      tgt.setDerivedFromElement(Canonical43_N.convertCanonical(src.getDerivedFromElement()));
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
    if (src.hasCode())
      tgt.setCodeElement(Code43_N.convertCode(src.getCodeElement()));
    for (UriType t : src.getBaseList()) tgt.getBase().add(Uri43_N.convertUriToCode(t));
    if (src.hasType())
      tgt.setTypeElement(Enumerations43_N.convertSearchParamType(src.getTypeElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(String43_N.convertString(src.getExpressionElement()));
//    if (src.hasXpath())
//      tgt.setXpathElement(String43_N.convertString(src.getXpathElement()));
    if (src.hasProcessingMode())
      tgt.setXpathUsageElement(convertXPathUsageType(src.getProcessingModeElement()));
    for (UriType t : src.getTargetList()) tgt.getTarget().add(Uri43_N.convertUriToCode(t));
    if (src.hasMultipleOr())
      tgt.setMultipleOrElement(Boolean43_N.convertBoolean(src.getMultipleOrElement()));
    if (src.hasMultipleAnd())
      tgt.setMultipleAndElement(Boolean43_N.convertBoolean(src.getMultipleAndElement()));
    tgt.setComparator(src.getComparatorList().stream()
      .map(SearchParameter43_N::convertSearchComparator)
      .collect(Collectors.toList()));
    tgt.setModifier(src.getModifierList().stream()
      .map(SearchParameter43_N::convertSearchModifierCode)
      .collect(Collectors.toList()));
    for (org.hl7.fhir.model.core.StringType t : src.getChainList()) tgt.getChain().add(String43_N.convertString(t));
    for (org.hl7.fhir.model.core.SearchParameter.SearchParameterComponentComponent t : src.getComponentList())
      tgt.addComponent(convertSearchParameterComponentComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.SearchParameter.SearchProcessingModeType> convertXPathUsageType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SearchParameter.XPathUsageType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<SearchParameter.SearchProcessingModeType> tgt = new Enumeration<>(new SearchParameter.SearchProcessingModeTypeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case NORMAL:
                  tgt.setValue(SearchParameter.SearchProcessingModeType.NORMAL);
                  break;
              case PHONETIC:
                  tgt.setValue(SearchParameter.SearchProcessingModeType.PHONETIC);
                  break;
              case NEARBY:
                  tgt.setValue(SearchParameter.SearchProcessingModeType.OTHER);
                  break;
              case DISTANCE:
                  tgt.setValue(SearchParameter.SearchProcessingModeType.OTHER);
                  break;
              case OTHER:
                  tgt.setValue(SearchParameter.SearchProcessingModeType.OTHER);
                  break;
              default:
                  tgt.setValue(SearchParameter.SearchProcessingModeType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SearchParameter.XPathUsageType> convertXPathUsageType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.SearchParameter.SearchProcessingModeType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SearchParameter.XPathUsageType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.SearchParameter.XPathUsageTypeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case NORMAL:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.XPathUsageType.NORMAL);
                  break;
              case PHONETIC:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.XPathUsageType.PHONETIC);
                  break;
              case OTHER:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.XPathUsageType.OTHER);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.XPathUsageType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.SearchComparator> convertSearchComparator(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SearchParameter.SearchComparator> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.SearchComparator> tgt = new Enumeration<>(new Enumerations.SearchComparatorEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case EQ:
                  tgt.setValue(Enumerations.SearchComparator.EQ);
                  break;
              case NE:
                  tgt.setValue(Enumerations.SearchComparator.NE);
                  break;
              case GT:
                  tgt.setValue(Enumerations.SearchComparator.GT);
                  break;
              case LT:
                  tgt.setValue(Enumerations.SearchComparator.LT);
                  break;
              case GE:
                  tgt.setValue(Enumerations.SearchComparator.GE);
                  break;
              case LE:
                  tgt.setValue(Enumerations.SearchComparator.LE);
                  break;
              case SA:
                  tgt.setValue(Enumerations.SearchComparator.SA);
                  break;
              case EB:
                  tgt.setValue(Enumerations.SearchComparator.EB);
                  break;
              case AP:
                  tgt.setValue(Enumerations.SearchComparator.AP);
                  break;
              default:
                  tgt.setValue(Enumerations.SearchComparator.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SearchParameter.SearchComparator> convertSearchComparator(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.SearchComparator> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SearchParameter.SearchComparator> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.SearchParameter.SearchComparatorEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case EQ:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.SearchComparator.EQ);
                  break;
              case NE:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.SearchComparator.NE);
                  break;
              case GT:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.SearchComparator.GT);
                  break;
              case LT:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.SearchComparator.LT);
                  break;
              case GE:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.SearchComparator.GE);
                  break;
              case LE:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.SearchComparator.LE);
                  break;
              case SA:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.SearchComparator.SA);
                  break;
              case EB:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.SearchComparator.EB);
                  break;
              case AP:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.SearchComparator.AP);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.SearchComparator.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.SearchParameter.SearchModifierAllCodes> convertSearchModifierCode(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SearchParameter.SearchModifierCode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<SearchParameter.SearchModifierAllCodes> tgt = new Enumeration<>(new SearchParameter.SearchModifierAllCodesEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case MISSING:
                  tgt.setValue(SearchParameter.SearchModifierAllCodes.MISSING);
                  break;
              case EXACT:
                  tgt.setValue(SearchParameter.SearchModifierAllCodes.EXACT);
                  break;
              case CONTAINS:
                  tgt.setValue(SearchParameter.SearchModifierAllCodes.CONTAINS);
                  break;
              case NOT:
                  tgt.setValue(SearchParameter.SearchModifierAllCodes.NOT);
                  break;
              case TEXT:
                  tgt.setValue(SearchParameter.SearchModifierAllCodes.TEXT);
                  break;
              case IN:
                  tgt.setValue(SearchParameter.SearchModifierAllCodes.IN);
                  break;
              case NOTIN:
                  tgt.setValue(SearchParameter.SearchModifierAllCodes.NOTIN);
                  break;
              case BELOW:
                  tgt.setValue(SearchParameter.SearchModifierAllCodes.BELOW);
                  break;
              case ABOVE:
                  tgt.setValue(SearchParameter.SearchModifierAllCodes.ABOVE);
                  break;
              case TYPE:
                  tgt.setValue(SearchParameter.SearchModifierAllCodes.TYPE);
                  break;
              case IDENTIFIER:
                  tgt.setValue(SearchParameter.SearchModifierAllCodes.IDENTIFIER);
                  break;
              case OFTYPE:
                  tgt.setValue(SearchParameter.SearchModifierAllCodes.OFTYPE);
                  break;
              default:
                  tgt.setValue(SearchParameter.SearchModifierAllCodes.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SearchParameter.SearchModifierCode> convertSearchModifierCode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.SearchParameter.SearchModifierAllCodes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SearchParameter.SearchModifierCode> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.SearchParameter.SearchModifierCodeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case MISSING:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.SearchModifierCode.MISSING);
                  break;
              case EXACT:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.SearchModifierCode.EXACT);
                  break;
              case CONTAINS:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.SearchModifierCode.CONTAINS);
                  break;
              case NOT:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.SearchModifierCode.NOT);
                  break;
              case TEXT:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.SearchModifierCode.TEXT);
                  break;
              case IN:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.SearchModifierCode.IN);
                  break;
              case NOTIN:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.SearchModifierCode.NOTIN);
                  break;
              case BELOW:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.SearchModifierCode.BELOW);
                  break;
              case ABOVE:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.SearchModifierCode.ABOVE);
                  break;
              case TYPE:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.SearchModifierCode.TYPE);
                  break;
              case IDENTIFIER:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.SearchModifierCode.IDENTIFIER);
                  break;
              case OFTYPE:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.SearchModifierCode.OFTYPE);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.SearchParameter.SearchModifierCode.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.SearchParameter.SearchParameterComponentComponent convertSearchParameterComponentComponent(org.hl7.fhir.r4b.model.SearchParameter.SearchParameterComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.SearchParameter.SearchParameterComponentComponent tgt = new org.hl7.fhir.model.core.SearchParameter.SearchParameterComponentComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasDefinition())
      tgt.setDefinitionElement(Canonical43_N.convertCanonical(src.getDefinitionElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(String43_N.convertString(src.getExpressionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.SearchParameter.SearchParameterComponentComponent convertSearchParameterComponentComponent(org.hl7.fhir.model.core.SearchParameter.SearchParameterComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.SearchParameter.SearchParameterComponentComponent tgt = new org.hl7.fhir.r4b.model.SearchParameter.SearchParameterComponentComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasDefinition())
      tgt.setDefinitionElement(Canonical43_N.convertCanonical(src.getDefinitionElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(String43_N.convertString(src.getExpressionElement()));
    return tgt;
  }
}