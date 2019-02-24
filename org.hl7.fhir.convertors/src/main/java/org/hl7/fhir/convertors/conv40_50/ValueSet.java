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


public class ValueSet extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.ValueSet convertValueSet(org.hl7.fhir.r4.model.ValueSet src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ValueSet tgt = new org.hl7.fhir.r5.model.ValueSet();
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
    if (src.hasImmutable())
      tgt.setImmutableElement(convertBoolean(src.getImmutableElement()));
    if (src.hasPurpose())
      tgt.setPurposeElement(convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
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
    if (src.hasImmutable())
      tgt.setImmutableElement(convertBoolean(src.getImmutableElement()));
    if (src.hasPurpose())
      tgt.setPurposeElement(convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
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
    copyElement(src, tgt);
    if (src.hasLockedDate())
      tgt.setLockedDateElement(convertDate(src.getLockedDateElement()));
    if (src.hasInactive())
      tgt.setInactiveElement(convertBoolean(src.getInactiveElement()));
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
    copyElement(src, tgt);
    if (src.hasLockedDate())
      tgt.setLockedDateElement(convertDate(src.getLockedDateElement()));
    if (src.hasInactive())
      tgt.setInactiveElement(convertBoolean(src.getInactiveElement()));
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
    copyElement(src, tgt);
    if (src.hasSystem())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    for (org.hl7.fhir.r4.model.ValueSet.ConceptReferenceComponent t : src.getConcept())
      tgt.addConcept(convertConceptReferenceComponent(t));
    for (org.hl7.fhir.r4.model.ValueSet.ConceptSetFilterComponent t : src.getFilter())
      tgt.addFilter(convertConceptSetFilterComponent(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getValueSet())
      tgt.getValueSet().add(convertCanonical(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ConceptSetComponent();
    copyElement(src, tgt);
    if (src.hasSystem())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    for (org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent t : src.getConcept())
      tgt.addConcept(convertConceptReferenceComponent(t));
    for (org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent t : src.getFilter())
      tgt.addFilter(convertConceptSetFilterComponent(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getValueSet())
      tgt.getValueSet().add(convertCanonical(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.r4.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(convertString(src.getDisplayElement()));
    for (org.hl7.fhir.r4.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation())
      tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ConceptReferenceComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(convertString(src.getDisplayElement()));
    for (org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation())
      tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.r4.model.ValueSet.ConceptReferenceDesignationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent();
    copyElement(src, tgt);
    if (src.hasLanguage())
      tgt.setLanguageElement(convertCode(src.getLanguageElement()));
    if (src.hasUse())
      tgt.setUse(convertCoding(src.getUse()));
    if (src.hasValue())
      tgt.setValueElement(convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ValueSet.ConceptReferenceDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ValueSet.ConceptReferenceDesignationComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ConceptReferenceDesignationComponent();
    copyElement(src, tgt);
    if (src.hasLanguage())
      tgt.setLanguageElement(convertCode(src.getLanguageElement()));
    if (src.hasUse())
      tgt.setUse(convertCoding(src.getUse()));
    if (src.hasValue())
      tgt.setValueElement(convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.r4.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent();
    copyElement(src, tgt);
    if (src.hasProperty())
      tgt.setPropertyElement(convertCode(src.getPropertyElement()));
    if (src.hasOp())
      tgt.setOp(convertFilterOperator(src.getOp()));
    if (src.hasValue())
      tgt.setValueElement(convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ConceptSetFilterComponent();
    copyElement(src, tgt);
    if (src.hasProperty())
      tgt.setPropertyElement(convertCode(src.getPropertyElement()));
    if (src.hasOp())
      tgt.setOp(convertFilterOperator(src.getOp()));
    if (src.hasValue())
      tgt.setValueElement(convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ValueSet.FilterOperator convertFilterOperator(org.hl7.fhir.r4.model.ValueSet.FilterOperator src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case EQUAL: return org.hl7.fhir.r5.model.ValueSet.FilterOperator.EQUAL;
    case ISA: return org.hl7.fhir.r5.model.ValueSet.FilterOperator.ISA;
    case DESCENDENTOF: return org.hl7.fhir.r5.model.ValueSet.FilterOperator.DESCENDENTOF;
    case ISNOTA: return org.hl7.fhir.r5.model.ValueSet.FilterOperator.ISNOTA;
    case REGEX: return org.hl7.fhir.r5.model.ValueSet.FilterOperator.REGEX;
    case IN: return org.hl7.fhir.r5.model.ValueSet.FilterOperator.IN;
    case NOTIN: return org.hl7.fhir.r5.model.ValueSet.FilterOperator.NOTIN;
    case GENERALIZES: return org.hl7.fhir.r5.model.ValueSet.FilterOperator.GENERALIZES;
    case EXISTS: return org.hl7.fhir.r5.model.ValueSet.FilterOperator.EXISTS;
    default: return org.hl7.fhir.r5.model.ValueSet.FilterOperator.NULL;
  }
}

  public static org.hl7.fhir.r4.model.ValueSet.FilterOperator convertFilterOperator(org.hl7.fhir.r5.model.ValueSet.FilterOperator src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case EQUAL: return org.hl7.fhir.r4.model.ValueSet.FilterOperator.EQUAL;
    case ISA: return org.hl7.fhir.r4.model.ValueSet.FilterOperator.ISA;
    case DESCENDENTOF: return org.hl7.fhir.r4.model.ValueSet.FilterOperator.DESCENDENTOF;
    case ISNOTA: return org.hl7.fhir.r4.model.ValueSet.FilterOperator.ISNOTA;
    case REGEX: return org.hl7.fhir.r4.model.ValueSet.FilterOperator.REGEX;
    case IN: return org.hl7.fhir.r4.model.ValueSet.FilterOperator.IN;
    case NOTIN: return org.hl7.fhir.r4.model.ValueSet.FilterOperator.NOTIN;
    case GENERALIZES: return org.hl7.fhir.r4.model.ValueSet.FilterOperator.GENERALIZES;
    case EXISTS: return org.hl7.fhir.r4.model.ValueSet.FilterOperator.EXISTS;
    default: return org.hl7.fhir.r4.model.ValueSet.FilterOperator.NULL;
  }
}

  public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent();
    copyElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifierElement(convertUri(src.getIdentifierElement()));
    if (src.hasTimestamp())
      tgt.setTimestampElement(convertDateTime(src.getTimestampElement()));
    if (src.hasTotal())
      tgt.setTotalElement(convertInteger(src.getTotalElement()));
    if (src.hasOffset())
      tgt.setOffsetElement(convertInteger(src.getOffsetElement()));
    for (org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter())
      tgt.addParameter(convertValueSetExpansionParameterComponent(t));
    for (org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains())
      tgt.addContains(convertValueSetExpansionContainsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionComponent();
    copyElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifierElement(convertUri(src.getIdentifierElement()));
    if (src.hasTimestamp())
      tgt.setTimestampElement(convertDateTime(src.getTimestampElement()));
    if (src.hasTotal())
      tgt.setTotalElement(convertInteger(src.getTotalElement()));
    if (src.hasOffset())
      tgt.setOffsetElement(convertInteger(src.getOffsetElement()));
    for (org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter())
      tgt.addParameter(convertValueSetExpansionParameterComponent(t));
    for (org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains())
      tgt.addContains(convertValueSetExpansionContainsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.setValue(convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionParameterComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.setValue(convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent();
    copyElement(src, tgt);
    if (src.hasSystem())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasAbstract())
      tgt.setAbstractElement(convertBoolean(src.getAbstractElement()));
    if (src.hasInactive())
      tgt.setInactiveElement(convertBoolean(src.getInactiveElement()));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(convertString(src.getDisplayElement()));
    for (org.hl7.fhir.r4.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation())
      tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
    for (org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains())
      tgt.addContains(convertValueSetExpansionContainsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent();
    copyElement(src, tgt);
    if (src.hasSystem())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasAbstract())
      tgt.setAbstractElement(convertBoolean(src.getAbstractElement()));
    if (src.hasInactive())
      tgt.setInactiveElement(convertBoolean(src.getInactiveElement()));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(convertString(src.getDisplayElement()));
    for (org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation())
      tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
    for (org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains())
      tgt.addContains(convertValueSetExpansionContainsComponent(t));
    return tgt;
  }


}
