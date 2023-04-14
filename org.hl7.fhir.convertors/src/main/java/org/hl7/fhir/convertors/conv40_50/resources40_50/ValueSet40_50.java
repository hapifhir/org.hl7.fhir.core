package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Coding40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.ContactDetail40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.UsageContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Canonical40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Code40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Date40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Integer40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.MarkDown40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.ValueSet.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionPropertyComponent;

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
public class ValueSet40_50 {

  public static org.hl7.fhir.r5.model.ValueSet convertValueSet(org.hl7.fhir.r4.model.ValueSet src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ValueSet tgt = new org.hl7.fhir.r5.model.ValueSet();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_50.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasImmutable())
      tgt.setImmutableElement(Boolean40_50.convertBoolean(src.getImmutableElement()));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasCompose())
      tgt.setCompose(convertValueSetComposeComponent(src.getCompose()));
    if (src.hasExpansion())
      tgt.setExpansion(convertValueSetExpansionComponent(src.getExpansion()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ValueSet convertValueSet(org.hl7.fhir.r5.model.ValueSet src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ValueSet tgt = new org.hl7.fhir.r4.model.ValueSet();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_50.convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasImmutable())
      tgt.setImmutableElement(Boolean40_50.convertBoolean(src.getImmutableElement()));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasCompose())
      tgt.setCompose(convertValueSetComposeComponent(src.getCompose()));
    if (src.hasExpansion())
      tgt.setExpansion(convertValueSetExpansionComponent(src.getExpansion()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent convertValueSetComposeComponent(org.hl7.fhir.r4.model.ValueSet.ValueSetComposeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasLockedDate())
      tgt.setLockedDateElement(Date40_50.convertDate(src.getLockedDateElement()));
    if (src.hasInactive())
      tgt.setInactiveElement(Boolean40_50.convertBoolean(src.getInactiveElement()));
    for (org.hl7.fhir.r4.model.ValueSet.ConceptSetComponent t : src.getInclude())
      tgt.addInclude(convertConceptSetComponent(t));
    for (org.hl7.fhir.r4.model.ValueSet.ConceptSetComponent t : src.getExclude())
      tgt.addExclude(convertConceptSetComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ValueSet.ValueSetComposeComponent convertValueSetComposeComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ValueSet.ValueSetComposeComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ValueSetComposeComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasLockedDate())
      tgt.setLockedDateElement(Date40_50.convertDate(src.getLockedDateElement()));
    if (src.hasInactive())
      tgt.setInactiveElement(Boolean40_50.convertBoolean(src.getInactiveElement()));
    for (org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent t : src.getInclude())
      tgt.addInclude(convertConceptSetComponent(t));
    for (org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent t : src.getExclude())
      tgt.addExclude(convertConceptSetComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.r4.model.ValueSet.ConceptSetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasSystem())
      tgt.setSystemElement(Uri40_50.convertUri(src.getSystemElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    for (org.hl7.fhir.r4.model.ValueSet.ConceptReferenceComponent t : src.getConcept())
      tgt.addConcept(convertConceptReferenceComponent(t));
    for (org.hl7.fhir.r4.model.ValueSet.ConceptSetFilterComponent t : src.getFilter())
      tgt.addFilter(convertConceptSetFilterComponent(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getValueSet())
      tgt.getValueSet().add(Canonical40_50.convertCanonical(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ConceptSetComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasSystem())
      tgt.setSystemElement(Uri40_50.convertUri(src.getSystemElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    for (org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent t : src.getConcept())
      tgt.addConcept(convertConceptReferenceComponent(t));
    for (org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent t : src.getFilter())
      tgt.addFilter(convertConceptSetFilterComponent(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getValueSet())
      tgt.getValueSet().add(Canonical40_50.convertCanonical(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.r4.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code40_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String40_50.convertString(src.getDisplayElement()));
    for (org.hl7.fhir.r4.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation())
      tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ConceptReferenceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code40_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String40_50.convertString(src.getDisplayElement()));
    for (org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation())
      tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.r4.model.ValueSet.ConceptReferenceDesignationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasLanguage())
      tgt.setLanguageElement(Code40_50.convertCode(src.getLanguageElement()));
    if (src.hasUse())
      tgt.setUse(Coding40_50.convertCoding(src.getUse()));
    if (src.hasValue())
      tgt.setValueElement(String40_50.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ValueSet.ConceptReferenceDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ValueSet.ConceptReferenceDesignationComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ConceptReferenceDesignationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasLanguage())
      tgt.setLanguageElement(Code40_50.convertCode(src.getLanguageElement()));
    if (src.hasUse())
      tgt.setUse(Coding40_50.convertCoding(src.getUse()));
    if (src.hasValue())
      tgt.setValueElement(String40_50.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.r4.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasProperty())
      tgt.setPropertyElement(Code40_50.convertCode(src.getPropertyElement()));
    if (src.hasOp())
      tgt.setOpElement(convertFilterOperator(src.getOpElement()));
    if (src.hasValue())
      tgt.setValueElement(String40_50.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ConceptSetFilterComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasProperty())
      tgt.setPropertyElement(Code40_50.convertCode(src.getPropertyElement()));
    if (src.hasOp())
      tgt.setOpElement(convertFilterOperator(src.getOpElement()));
    if (src.hasValue())
      tgt.setValueElement(String40_50.convertString(src.getValueElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> convertFilterOperator(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ValueSet.FilterOperator> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.FilterOperatorEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ValueSet.FilterOperator> convertFilterOperator(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ValueSet.FilterOperator> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ValueSet.FilterOperatorEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case EQUAL:
        tgt.setValue(org.hl7.fhir.r4.model.ValueSet.FilterOperator.EQUAL);
        break;
      case ISA:
        tgt.setValue(org.hl7.fhir.r4.model.ValueSet.FilterOperator.ISA);
        break;
      case DESCENDENTOF:
        tgt.setValue(org.hl7.fhir.r4.model.ValueSet.FilterOperator.DESCENDENTOF);
        break;
      case ISNOTA:
        tgt.setValue(org.hl7.fhir.r4.model.ValueSet.FilterOperator.ISNOTA);
        break;
      case REGEX:
        tgt.setValue(org.hl7.fhir.r4.model.ValueSet.FilterOperator.REGEX);
        break;
      case IN:
        tgt.setValue(org.hl7.fhir.r4.model.ValueSet.FilterOperator.IN);
        break;
      case NOTIN:
        tgt.setValue(org.hl7.fhir.r4.model.ValueSet.FilterOperator.NOTIN);
        break;
      case GENERALIZES:
        tgt.setValue(org.hl7.fhir.r4.model.ValueSet.FilterOperator.GENERALIZES);
        break;
      case EXISTS:
        tgt.setValue(org.hl7.fhir.r4.model.ValueSet.FilterOperator.EXISTS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.ValueSet.FilterOperator.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt, "http://hl7.org/fhir/5.0/StructureDefinition/extension-ValueSet.expansion.property");
    if (src.hasIdentifier())
      tgt.setIdentifierElement(Uri40_50.convertUri(src.getIdentifierElement()));
    if (src.hasTimestamp())
      tgt.setTimestampElement(DateTime40_50.convertDateTime(src.getTimestampElement()));
    if (src.hasTotal())
      tgt.setTotalElement(Integer40_50.convertInteger(src.getTotalElement()));
    if (src.hasOffset())
      tgt.setOffsetElement(Integer40_50.convertInteger(src.getOffsetElement()));
    for (org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter())
      tgt.addParameter(convertValueSetExpansionParameterComponent(t));
    for (org.hl7.fhir.r4.model.Extension t : src.getExtension()) {
      if ("http://hl7.org/fhir/5.0/StructureDefinition/extension-ValueSet.expansion.property".equals(t.getUrl())) {
        tgt.addProperty().setCode(t.getExtensionString("code")).setUri(t.getExtensionString("uri"));
      }
    }
    for (org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains())
      tgt.addContains(convertValueSetExpansionContainsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifierElement(Uri40_50.convertUri(src.getIdentifierElement()));
    if (src.hasTimestamp())
      tgt.setTimestampElement(DateTime40_50.convertDateTime(src.getTimestampElement()));
    if (src.hasTotal())
      tgt.setTotalElement(Integer40_50.convertInteger(src.getTotalElement()));
    if (src.hasOffset())
      tgt.setOffsetElement(Integer40_50.convertInteger(src.getOffsetElement()));
    for (org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter())
      tgt.addParameter(convertValueSetExpansionParameterComponent(t));
    for (ValueSetExpansionPropertyComponent t : src.getProperty()) {
      org.hl7.fhir.r4.model.Extension ext = tgt.addExtension().setUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-ValueSet.expansion.property");
      ext.addExtension().setUrl("code").setValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(t.getCodeElement()));
      ext.addExtension().setUrl("uri").setValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(t.getUriElement()));
    }
    for (org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains())
      tgt.addContains(convertValueSetExpansionContainsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionParameterComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt, "http://hl7.org/fhir/5.0/StructureDefinition/extension-ValueSet.expansion.contains.property");
    if (src.hasSystem())
      tgt.setSystemElement(Uri40_50.convertUri(src.getSystemElement()));
    if (src.hasAbstract())
      tgt.setAbstractElement(Boolean40_50.convertBoolean(src.getAbstractElement()));
    if (src.hasInactive())
      tgt.setInactiveElement(Boolean40_50.convertBoolean(src.getInactiveElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasCode())
      tgt.setCodeElement(Code40_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String40_50.convertString(src.getDisplayElement()));
    for (org.hl7.fhir.r4.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation())
      tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
    for (org.hl7.fhir.r4.model.Extension t : src.getExtension()) {
      if ("http://hl7.org/fhir/5.0/StructureDefinition/extension-ValueSet.expansion.contains.property".equals(t.getUrl())) {
        tgt.addProperty().setCode(t.getExtensionString("code")).setValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(t.getExtensionByUrl("value").getValue()));
      }
    }
    for (org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains())
      tgt.addContains(convertValueSetExpansionContainsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasSystem())
      tgt.setSystemElement(Uri40_50.convertUri(src.getSystemElement()));
    if (src.hasAbstract())
      tgt.setAbstractElement(Boolean40_50.convertBoolean(src.getAbstractElement()));
    if (src.hasInactive())
      tgt.setInactiveElement(Boolean40_50.convertBoolean(src.getInactiveElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasCode())
      tgt.setCodeElement(Code40_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String40_50.convertString(src.getDisplayElement()));
    for (org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation())
      tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
    for (org.hl7.fhir.r5.model.ValueSet.ConceptPropertyComponent t : src.getProperty()) {
      org.hl7.fhir.r4.model.Extension ext = tgt.addExtension().setUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-ValueSet.expansion.contains.property");
      ext.addExtension().setUrl("code").setValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(t.getCodeElement()));
      ext.addExtension().setUrl("value").setValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(t.getValue()));
    }
    for (org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains())
      tgt.addContains(convertValueSetExpansionContainsComponent(t));
    return tgt;
  }
}