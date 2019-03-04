package org.hl7.fhir.convertors.conv40_50;

import org.hl7.fhir.exceptions.FHIRException;

import org.hl7.fhir.convertors.VersionConvertor_40_50;


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


public class CodeSystem extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.CodeSystem convertCodeSystem(org.hl7.fhir.r4.model.CodeSystem src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CodeSystem tgt = new org.hl7.fhir.r5.model.CodeSystem();
    copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatus(Enumerations.convertPublicationStatus(src.getStatus()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
    if (src.hasCaseSensitive())
      tgt.setCaseSensitiveElement(convertBoolean(src.getCaseSensitiveElement()));
    if (src.hasValueSet())
      tgt.setValueSetElement(convertCanonical(src.getValueSetElement()));
    if (src.hasHierarchyMeaning())
      tgt.setHierarchyMeaning(convertCodeSystemHierarchyMeaning(src.getHierarchyMeaning()));
    if (src.hasCompositional())
      tgt.setCompositionalElement(convertBoolean(src.getCompositionalElement()));
    if (src.hasVersionNeeded())
      tgt.setVersionNeededElement(convertBoolean(src.getVersionNeededElement()));
    if (src.hasContent())
      tgt.setContent(convertCodeSystemContentMode(src.getContent()));
    if (src.hasSupplements())
      tgt.setSupplementsElement(convertCanonical(src.getSupplementsElement()));
    if (src.hasCount())
      tgt.setCountElement(convertUnsignedInt(src.getCountElement()));
    for (org.hl7.fhir.r4.model.CodeSystem.CodeSystemFilterComponent t : src.getFilter())
      tgt.addFilter(convertCodeSystemFilterComponent(t));
    for (org.hl7.fhir.r4.model.CodeSystem.PropertyComponent t : src.getProperty())
      tgt.addProperty(convertPropertyComponent(t));
    for (org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept())
      tgt.addConcept(convertConceptDefinitionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CodeSystem convertCodeSystem(org.hl7.fhir.r5.model.CodeSystem src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CodeSystem tgt = new org.hl7.fhir.r4.model.CodeSystem();
    copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatus(Enumerations.convertPublicationStatus(src.getStatus()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
    if (src.hasCaseSensitive())
      tgt.setCaseSensitiveElement(convertBoolean(src.getCaseSensitiveElement()));
    if (src.hasValueSet())
      tgt.setValueSetElement(convertCanonical(src.getValueSetElement()));
    if (src.hasHierarchyMeaning())
      tgt.setHierarchyMeaning(convertCodeSystemHierarchyMeaning(src.getHierarchyMeaning()));
    if (src.hasCompositional())
      tgt.setCompositionalElement(convertBoolean(src.getCompositionalElement()));
    if (src.hasVersionNeeded())
      tgt.setVersionNeededElement(convertBoolean(src.getVersionNeededElement()));
    if (src.hasContent())
      tgt.setContent(convertCodeSystemContentMode(src.getContent()));
    if (src.hasSupplements())
      tgt.setSupplementsElement(convertCanonical(src.getSupplementsElement()));
    if (src.hasCount())
      tgt.setCountElement(convertUnsignedInt(src.getCountElement()));
    for (org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent t : src.getFilter())
      tgt.addFilter(convertCodeSystemFilterComponent(t));
    for (org.hl7.fhir.r5.model.CodeSystem.PropertyComponent t : src.getProperty())
      tgt.addProperty(convertPropertyComponent(t));
    for (org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept())
      tgt.addConcept(convertConceptDefinitionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning convertCodeSystemHierarchyMeaning(org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case GROUPEDBY: return org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning.GROUPEDBY;
    case ISA: return org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning.ISA;
    case PARTOF: return org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning.PARTOF;
    case CLASSIFIEDWITH: return org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning.CLASSIFIEDWITH;
    default: return org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning.NULL;
  }
}

  public static org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning convertCodeSystemHierarchyMeaning(org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case GROUPEDBY: return org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning.GROUPEDBY;
    case ISA: return org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning.ISA;
    case PARTOF: return org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning.PARTOF;
    case CLASSIFIEDWITH: return org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning.CLASSIFIEDWITH;
    default: return org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning.NULL;
  }
}

  public static org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode convertCodeSystemContentMode(org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case NOTPRESENT: return org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.NOTPRESENT;
    case EXAMPLE: return org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.EXAMPLE;
    case FRAGMENT: return org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.FRAGMENT;
    case COMPLETE: return org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.COMPLETE;
    case SUPPLEMENT: return org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.SUPPLEMENT;
    default: return org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.NULL;
  }
}

  public static org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode convertCodeSystemContentMode(org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case NOTPRESENT: return org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode.NOTPRESENT;
    case EXAMPLE: return org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode.EXAMPLE;
    case FRAGMENT: return org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode.FRAGMENT;
    case COMPLETE: return org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode.COMPLETE;
    case SUPPLEMENT: return org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode.SUPPLEMENT;
    default: return org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode.NULL;
  }
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
    for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.FilterOperator> t : src.getOperator())
      tgt.addOperator(convertFilterOperator(t.getValue()));
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
    for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CodeSystem.FilterOperator> t : src.getOperator())
      tgt.addOperator(convertFilterOperator(t.getValue()));
    if (src.hasValue())
      tgt.setValueElement(convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CodeSystem.FilterOperator convertFilterOperator(org.hl7.fhir.r4.model.CodeSystem.FilterOperator src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case EQUAL: return org.hl7.fhir.r5.model.CodeSystem.FilterOperator.EQUAL;
    case ISA: return org.hl7.fhir.r5.model.CodeSystem.FilterOperator.ISA;
    case DESCENDENTOF: return org.hl7.fhir.r5.model.CodeSystem.FilterOperator.DESCENDENTOF;
    case ISNOTA: return org.hl7.fhir.r5.model.CodeSystem.FilterOperator.ISNOTA;
    case REGEX: return org.hl7.fhir.r5.model.CodeSystem.FilterOperator.REGEX;
    case IN: return org.hl7.fhir.r5.model.CodeSystem.FilterOperator.IN;
    case NOTIN: return org.hl7.fhir.r5.model.CodeSystem.FilterOperator.NOTIN;
    case GENERALIZES: return org.hl7.fhir.r5.model.CodeSystem.FilterOperator.GENERALIZES;
    case EXISTS: return org.hl7.fhir.r5.model.CodeSystem.FilterOperator.EXISTS;
    default: return org.hl7.fhir.r5.model.CodeSystem.FilterOperator.NULL;
  }
}

  public static org.hl7.fhir.r4.model.CodeSystem.FilterOperator convertFilterOperator(org.hl7.fhir.r5.model.CodeSystem.FilterOperator src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case EQUAL: return org.hl7.fhir.r4.model.CodeSystem.FilterOperator.EQUAL;
    case ISA: return org.hl7.fhir.r4.model.CodeSystem.FilterOperator.ISA;
    case DESCENDENTOF: return org.hl7.fhir.r4.model.CodeSystem.FilterOperator.DESCENDENTOF;
    case ISNOTA: return org.hl7.fhir.r4.model.CodeSystem.FilterOperator.ISNOTA;
    case REGEX: return org.hl7.fhir.r4.model.CodeSystem.FilterOperator.REGEX;
    case IN: return org.hl7.fhir.r4.model.CodeSystem.FilterOperator.IN;
    case NOTIN: return org.hl7.fhir.r4.model.CodeSystem.FilterOperator.NOTIN;
    case GENERALIZES: return org.hl7.fhir.r4.model.CodeSystem.FilterOperator.GENERALIZES;
    case EXISTS: return org.hl7.fhir.r4.model.CodeSystem.FilterOperator.EXISTS;
    default: return org.hl7.fhir.r4.model.CodeSystem.FilterOperator.NULL;
  }
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
      tgt.setType(convertPropertyType(src.getType()));
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
      tgt.setType(convertPropertyType(src.getType()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CodeSystem.PropertyType convertPropertyType(org.hl7.fhir.r4.model.CodeSystem.PropertyType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case CODE: return org.hl7.fhir.r5.model.CodeSystem.PropertyType.CODE;
    case CODING: return org.hl7.fhir.r5.model.CodeSystem.PropertyType.CODING;
    case STRING: return org.hl7.fhir.r5.model.CodeSystem.PropertyType.STRING;
    case INTEGER: return org.hl7.fhir.r5.model.CodeSystem.PropertyType.INTEGER;
    case BOOLEAN: return org.hl7.fhir.r5.model.CodeSystem.PropertyType.BOOLEAN;
    case DATETIME: return org.hl7.fhir.r5.model.CodeSystem.PropertyType.DATETIME;
    case DECIMAL: return org.hl7.fhir.r5.model.CodeSystem.PropertyType.DECIMAL;
    default: return org.hl7.fhir.r5.model.CodeSystem.PropertyType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.CodeSystem.PropertyType convertPropertyType(org.hl7.fhir.r5.model.CodeSystem.PropertyType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case CODE: return org.hl7.fhir.r4.model.CodeSystem.PropertyType.CODE;
    case CODING: return org.hl7.fhir.r4.model.CodeSystem.PropertyType.CODING;
    case STRING: return org.hl7.fhir.r4.model.CodeSystem.PropertyType.STRING;
    case INTEGER: return org.hl7.fhir.r4.model.CodeSystem.PropertyType.INTEGER;
    case BOOLEAN: return org.hl7.fhir.r4.model.CodeSystem.PropertyType.BOOLEAN;
    case DATETIME: return org.hl7.fhir.r4.model.CodeSystem.PropertyType.DATETIME;
    case DECIMAL: return org.hl7.fhir.r4.model.CodeSystem.PropertyType.DECIMAL;
    default: return org.hl7.fhir.r4.model.CodeSystem.PropertyType.NULL;
  }
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
    for (org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionDesignationComponent t : src.getDesignation())
      tgt.addDesignation(convertConceptDefinitionDesignationComponent(t));
    for (org.hl7.fhir.r4.model.CodeSystem.ConceptPropertyComponent t : src.getProperty())
      tgt.addProperty(convertConceptPropertyComponent(t));
    for (org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept())
      tgt.addConcept(convertConceptDefinitionComponent(t));
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
    for (org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent t : src.getDesignation())
      tgt.addDesignation(convertConceptDefinitionDesignationComponent(t));
    for (org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent t : src.getProperty())
      tgt.addProperty(convertConceptPropertyComponent(t));
    for (org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept())
      tgt.addConcept(convertConceptDefinitionComponent(t));
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
