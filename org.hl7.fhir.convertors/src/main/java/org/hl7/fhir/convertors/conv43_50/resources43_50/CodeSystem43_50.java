package org.hl7.fhir.convertors.conv43_50.resources43_50;

import java.util.stream.Collectors;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Coding43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.ContactDetail43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.UsageContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Canonical43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Code43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.MarkDown43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.UnsignedInt43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
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
public class CodeSystem43_50 {

  public static org.hl7.fhir.r5.model.CodeSystem convertCodeSystem(org.hl7.fhir.r4b.model.CodeSystem src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CodeSystem tgt = new org.hl7.fhir.r5.model.CodeSystem();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
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
    if (src.hasCaseSensitive())
      tgt.setCaseSensitiveElement(Boolean43_50.convertBoolean(src.getCaseSensitiveElement()));
    if (src.hasValueSet())
      tgt.setValueSetElement(Canonical43_50.convertCanonical(src.getValueSetElement()));
    if (src.hasHierarchyMeaning())
      tgt.setHierarchyMeaningElement(convertCodeSystemHierarchyMeaning(src.getHierarchyMeaningElement()));
    if (src.hasCompositional())
      tgt.setCompositionalElement(Boolean43_50.convertBoolean(src.getCompositionalElement()));
    if (src.hasVersionNeeded())
      tgt.setVersionNeededElement(Boolean43_50.convertBoolean(src.getVersionNeededElement()));
    if (src.hasContent())
      tgt.setContentElement(convertCodeSystemContentMode(src.getContentElement()));
    if (src.hasSupplements())
      tgt.setSupplementsElement(Canonical43_50.convertCanonical(src.getSupplementsElement()));
    if (src.hasCount())
      tgt.setCountElement(UnsignedInt43_50.convertUnsignedInt(src.getCountElement()));
    for (org.hl7.fhir.r4b.model.CodeSystem.CodeSystemFilterComponent t : src.getFilter())
      tgt.addFilter(convertCodeSystemFilterComponent(t));
    for (org.hl7.fhir.r4b.model.CodeSystem.PropertyComponent t : src.getProperty())
      tgt.addProperty(convertPropertyComponent(t));
    for (org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept())
      tgt.addConcept(convertConceptDefinitionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CodeSystem convertCodeSystem(org.hl7.fhir.r5.model.CodeSystem src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CodeSystem tgt = new org.hl7.fhir.r4b.model.CodeSystem();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
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
    if (src.hasCaseSensitive())
      tgt.setCaseSensitiveElement(Boolean43_50.convertBoolean(src.getCaseSensitiveElement()));
    if (src.hasValueSet())
      tgt.setValueSetElement(Canonical43_50.convertCanonical(src.getValueSetElement()));
    if (src.hasHierarchyMeaning())
      tgt.setHierarchyMeaningElement(convertCodeSystemHierarchyMeaning(src.getHierarchyMeaningElement()));
    if (src.hasCompositional())
      tgt.setCompositionalElement(Boolean43_50.convertBoolean(src.getCompositionalElement()));
    if (src.hasVersionNeeded())
      tgt.setVersionNeededElement(Boolean43_50.convertBoolean(src.getVersionNeededElement()));
    if (src.hasContent())
      tgt.setContentElement(convertCodeSystemContentMode(src.getContentElement()));
    if (src.hasSupplements())
      tgt.setSupplementsElement(Canonical43_50.convertCanonical(src.getSupplementsElement()));
    if (src.hasCount())
      tgt.setCountElement(UnsignedInt43_50.convertUnsignedInt(src.getCountElement()));
    for (org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent t : src.getFilter())
      tgt.addFilter(convertCodeSystemFilterComponent(t));
    for (org.hl7.fhir.r5.model.CodeSystem.PropertyComponent t : src.getProperty())
      tgt.addProperty(convertPropertyComponent(t));
    for (org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept())
      tgt.addConcept(convertConceptDefinitionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning> convertCodeSystemHierarchyMeaning(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CodeSystem.CodeSystemHierarchyMeaning> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaningEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CodeSystem.CodeSystemHierarchyMeaning> convertCodeSystemHierarchyMeaning(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CodeSystem.CodeSystemHierarchyMeaning> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.CodeSystem.CodeSystemHierarchyMeaningEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case GROUPEDBY:
        tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.CodeSystemHierarchyMeaning.GROUPEDBY);
        break;
      case ISA:
        tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.CodeSystemHierarchyMeaning.ISA);
        break;
      case PARTOF:
        tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.CodeSystemHierarchyMeaning.PARTOF);
        break;
      case CLASSIFIEDWITH:
        tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.CodeSystemHierarchyMeaning.CLASSIFIEDWITH);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.CodeSystemHierarchyMeaning.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode> convertCodeSystemContentMode(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CodeSystem.CodeSystemContentMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.CodeSystemContentModeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case NOTPRESENT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode.NOTPRESENT);
        break;
      case EXAMPLE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode.EXAMPLE);
        break;
      case FRAGMENT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode.FRAGMENT);
        break;
      case COMPLETE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode.COMPLETE);
        break;
      case SUPPLEMENT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode.SUPPLEMENT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CodeSystem.CodeSystemContentMode> convertCodeSystemContentMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CodeSystem.CodeSystemContentMode> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.CodeSystem.CodeSystemContentModeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case NOTPRESENT:
        tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.CodeSystemContentMode.NOTPRESENT);
        break;
      case EXAMPLE:
        tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.CodeSystemContentMode.EXAMPLE);
        break;
      case FRAGMENT:
        tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.CodeSystemContentMode.FRAGMENT);
        break;
      case COMPLETE:
        tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.CodeSystemContentMode.COMPLETE);
        break;
      case SUPPLEMENT:
        tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.CodeSystemContentMode.SUPPLEMENT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.CodeSystemContentMode.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent convertCodeSystemFilterComponent(org.hl7.fhir.r4b.model.CodeSystem.CodeSystemFilterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    tgt.setOperator(src.getOperator().stream()
      .map(CodeSystem43_50::convertFilterOperator)
      .collect(Collectors.toList()));
    if (src.hasValue())
      tgt.setValueElement(String43_50.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CodeSystem.CodeSystemFilterComponent convertCodeSystemFilterComponent(org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CodeSystem.CodeSystemFilterComponent tgt = new org.hl7.fhir.r4b.model.CodeSystem.CodeSystemFilterComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    tgt.setOperator(src.getOperator().stream()
      .map(CodeSystem43_50::convertFilterOperator)
      .collect(Collectors.toList()));
    if (src.hasValue())
      tgt.setValueElement(String43_50.convertString(src.getValueElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> convertFilterOperator(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FilterOperator> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.FilterOperatorEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FilterOperator> convertFilterOperator(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FilterOperator> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.FilterOperatorEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case EQUAL:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FilterOperator.EQUAL);
        break;
      case ISA:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FilterOperator.ISA);
        break;
      case DESCENDENTOF:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FilterOperator.DESCENDENTOF);
        break;
      case ISNOTA:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FilterOperator.ISNOTA);
        break;
      case REGEX:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FilterOperator.REGEX);
        break;
      case IN:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FilterOperator.IN);
        break;
      case NOTIN:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FilterOperator.NOTIN);
        break;
      case GENERALIZES:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FilterOperator.GENERALIZES);
        break;
      case EXISTS:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FilterOperator.EXISTS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FilterOperator.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CodeSystem.PropertyComponent convertPropertyComponent(org.hl7.fhir.r4b.model.CodeSystem.PropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CodeSystem.PropertyComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.PropertyComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri43_50.convertUri(src.getUriElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    if (src.hasType())
      tgt.setTypeElement(convertPropertyType(src.getTypeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CodeSystem.PropertyComponent convertPropertyComponent(org.hl7.fhir.r5.model.CodeSystem.PropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CodeSystem.PropertyComponent tgt = new org.hl7.fhir.r4b.model.CodeSystem.PropertyComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri43_50.convertUri(src.getUriElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    if (src.hasType())
      tgt.setTypeElement(convertPropertyType(src.getTypeElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CodeSystem.PropertyType> convertPropertyType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CodeSystem.PropertyType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CodeSystem.PropertyType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CodeSystem.PropertyTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CodeSystem.PropertyType> convertPropertyType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CodeSystem.PropertyType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CodeSystem.PropertyType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.CodeSystem.PropertyTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case CODE:
        tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.PropertyType.CODE);
        break;
      case CODING:
        tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.PropertyType.CODING);
        break;
      case STRING:
        tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.PropertyType.STRING);
        break;
      case INTEGER:
        tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.PropertyType.INTEGER);
        break;
      case BOOLEAN:
        tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.PropertyType.BOOLEAN);
        break;
      case DATETIME:
        tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.PropertyType.DATETIME);
        break;
      case DECIMAL:
        tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.PropertyType.DECIMAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.PropertyType.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent convertConceptDefinitionComponent(org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String43_50.convertString(src.getDisplayElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(String43_50.convertString(src.getDefinitionElement()));
    for (org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionDesignationComponent t : src.getDesignation())
      tgt.addDesignation(convertConceptDefinitionDesignationComponent(t));
    for (org.hl7.fhir.r4b.model.CodeSystem.ConceptPropertyComponent t : src.getProperty())
      tgt.addProperty(convertConceptPropertyComponent(t));
    for (org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept())
      tgt.addConcept(convertConceptDefinitionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionComponent convertConceptDefinitionComponent(org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionComponent tgt = new org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String43_50.convertString(src.getDisplayElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(String43_50.convertString(src.getDefinitionElement()));
    for (org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent t : src.getDesignation())
      tgt.addDesignation(convertConceptDefinitionDesignationComponent(t));
    for (org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent t : src.getProperty())
      tgt.addProperty(convertConceptPropertyComponent(t));
    for (org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept())
      tgt.addConcept(convertConceptDefinitionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent convertConceptDefinitionDesignationComponent(org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionDesignationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasLanguage())
      tgt.setLanguageElement(Code43_50.convertCode(src.getLanguageElement()));
    if (src.hasUse())
      tgt.setUse(Coding43_50.convertCoding(src.getUse()));
    if (src.hasValue())
      tgt.setValueElement(String43_50.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionDesignationComponent convertConceptDefinitionDesignationComponent(org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionDesignationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasLanguage())
      tgt.setLanguageElement(Code43_50.convertCode(src.getLanguageElement()));
    if (src.hasUse())
      tgt.setUse(Coding43_50.convertCoding(src.getUse()));
    if (src.hasValue())
      tgt.setValueElement(String43_50.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent convertConceptPropertyComponent(org.hl7.fhir.r4b.model.CodeSystem.ConceptPropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CodeSystem.ConceptPropertyComponent convertConceptPropertyComponent(org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CodeSystem.ConceptPropertyComponent tgt = new org.hl7.fhir.r4b.model.CodeSystem.ConceptPropertyComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getValue()));
    return tgt;
  }
}