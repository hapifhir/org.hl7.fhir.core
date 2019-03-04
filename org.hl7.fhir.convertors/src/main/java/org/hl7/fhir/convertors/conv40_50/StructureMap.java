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


public class StructureMap extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.StructureMap convertStructureMap(org.hl7.fhir.r4.model.StructureMap src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.StructureMap tgt = new org.hl7.fhir.r5.model.StructureMap();
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
    for (org.hl7.fhir.r4.model.StructureMap.StructureMapStructureComponent t : src.getStructure())
      tgt.addStructure(convertStructureMapStructureComponent(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getImport())
      tgt.getImport().add(convertCanonical(t));
    for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupComponent t : src.getGroup())
      tgt.addGroup(convertStructureMapGroupComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StructureMap convertStructureMap(org.hl7.fhir.r5.model.StructureMap src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.StructureMap tgt = new org.hl7.fhir.r4.model.StructureMap();
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
    for (org.hl7.fhir.r5.model.StructureMap.StructureMapStructureComponent t : src.getStructure())
      tgt.addStructure(convertStructureMapStructureComponent(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getImport())
      tgt.getImport().add(convertCanonical(t));
    for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent t : src.getGroup())
      tgt.addGroup(convertStructureMapGroupComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StructureMap.StructureMapStructureComponent convertStructureMapStructureComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapStructureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.StructureMap.StructureMapStructureComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapStructureComponent();
    copyElement(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(convertCanonical(src.getUrlElement()));
    if (src.hasMode())
      tgt.setMode(convertStructureMapModelMode(src.getMode()));
    if (src.hasAlias())
      tgt.setAliasElement(convertString(src.getAliasElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertString(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StructureMap.StructureMapStructureComponent convertStructureMapStructureComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapStructureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.StructureMap.StructureMapStructureComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapStructureComponent();
    copyElement(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(convertCanonical(src.getUrlElement()));
    if (src.hasMode())
      tgt.setMode(convertStructureMapModelMode(src.getMode()));
    if (src.hasAlias())
      tgt.setAliasElement(convertString(src.getAliasElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertString(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode convertStructureMapModelMode(org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case SOURCE: return org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode.SOURCE;
    case QUERIED: return org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode.QUERIED;
    case TARGET: return org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode.TARGET;
    case PRODUCED: return org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode.PRODUCED;
    default: return org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode.NULL;
  }
}

  public static org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode convertStructureMapModelMode(org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case SOURCE: return org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode.SOURCE;
    case QUERIED: return org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode.QUERIED;
    case TARGET: return org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode.TARGET;
    case PRODUCED: return org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode.PRODUCED;
    default: return org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode.NULL;
  }
}

  public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent convertStructureMapGroupComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertId(src.getNameElement()));
    if (src.hasExtends())
      tgt.setExtendsElement(convertId(src.getExtendsElement()));
    if (src.hasTypeMode())
      tgt.setTypeMode(convertStructureMapGroupTypeMode(src.getTypeMode()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertString(src.getDocumentationElement()));
    for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupInputComponent t : src.getInput())
      tgt.addInput(convertStructureMapGroupInputComponent(t));
    for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule())
      tgt.addRule(convertStructureMapGroupRuleComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupComponent convertStructureMapGroupComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.StructureMap.StructureMapGroupComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertId(src.getNameElement()));
    if (src.hasExtends())
      tgt.setExtendsElement(convertId(src.getExtendsElement()));
    if (src.hasTypeMode())
      tgt.setTypeMode(convertStructureMapGroupTypeMode(src.getTypeMode()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertString(src.getDocumentationElement()));
    for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupInputComponent t : src.getInput())
      tgt.addInput(convertStructureMapGroupInputComponent(t));
    for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule())
      tgt.addRule(convertStructureMapGroupRuleComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupTypeMode convertStructureMapGroupTypeMode(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case NONE: return org.hl7.fhir.r5.model.StructureMap.StructureMapGroupTypeMode.NONE;
    case TYPES: return org.hl7.fhir.r5.model.StructureMap.StructureMapGroupTypeMode.TYPES;
    case TYPEANDTYPES: return org.hl7.fhir.r5.model.StructureMap.StructureMapGroupTypeMode.TYPEANDTYPES;
    default: return org.hl7.fhir.r5.model.StructureMap.StructureMapGroupTypeMode.NULL;
  }
}

  public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeMode convertStructureMapGroupTypeMode(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupTypeMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case NONE: return org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeMode.NONE;
    case TYPES: return org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeMode.TYPES;
    case TYPEANDTYPES: return org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeMode.TYPEANDTYPES;
    default: return org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeMode.NULL;
  }
}

  public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupInputComponent convertStructureMapGroupInputComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupInputComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.StructureMap.StructureMapGroupInputComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupInputComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertId(src.getNameElement()));
    if (src.hasType())
      tgt.setTypeElement(convertString(src.getTypeElement()));
    if (src.hasMode())
      tgt.setMode(convertStructureMapInputMode(src.getMode()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertString(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupInputComponent convertStructureMapGroupInputComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupInputComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.StructureMap.StructureMapGroupInputComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupInputComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertId(src.getNameElement()));
    if (src.hasType())
      tgt.setTypeElement(convertString(src.getTypeElement()));
    if (src.hasMode())
      tgt.setMode(convertStructureMapInputMode(src.getMode()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertString(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode convertStructureMapInputMode(org.hl7.fhir.r4.model.StructureMap.StructureMapInputMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case SOURCE: return org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode.SOURCE;
    case TARGET: return org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode.TARGET;
    default: return org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode.NULL;
  }
}

  public static org.hl7.fhir.r4.model.StructureMap.StructureMapInputMode convertStructureMapInputMode(org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case SOURCE: return org.hl7.fhir.r4.model.StructureMap.StructureMapInputMode.SOURCE;
    case TARGET: return org.hl7.fhir.r4.model.StructureMap.StructureMapInputMode.TARGET;
    default: return org.hl7.fhir.r4.model.StructureMap.StructureMapInputMode.NULL;
  }
}

  public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent convertStructureMapGroupRuleComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertId(src.getNameElement()));
    for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleSourceComponent t : src.getSource())
      tgt.addSource(convertStructureMapGroupRuleSourceComponent(t));
    for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetComponent t : src.getTarget())
      tgt.addTarget(convertStructureMapGroupRuleTargetComponent(t));
    for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule())
      tgt.addRule(convertStructureMapGroupRuleComponent(t));
    for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleDependentComponent t : src.getDependent())
      tgt.addDependent(convertStructureMapGroupRuleDependentComponent(t));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertString(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent convertStructureMapGroupRuleComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertId(src.getNameElement()));
    for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleSourceComponent t : src.getSource())
      tgt.addSource(convertStructureMapGroupRuleSourceComponent(t));
    for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetComponent t : src.getTarget())
      tgt.addTarget(convertStructureMapGroupRuleTargetComponent(t));
    for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule())
      tgt.addRule(convertStructureMapGroupRuleComponent(t));
    for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent t : src.getDependent())
      tgt.addDependent(convertStructureMapGroupRuleDependentComponent(t));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertString(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleSourceComponent convertStructureMapGroupRuleSourceComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleSourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleSourceComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleSourceComponent();
    copyElement(src, tgt);
    if (src.hasContext())
      tgt.setContextElement(convertId(src.getContextElement()));
    if (src.hasMin())
      tgt.setMinElement(convertInteger(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(convertString(src.getMaxElement()));
    if (src.hasType())
      tgt.setTypeElement(convertString(src.getTypeElement()));
    if (src.hasDefaultValue())
      tgt.setDefaultValue(convertType(src.getDefaultValue()));
    if (src.hasElement())
      tgt.setElementElement(convertString(src.getElementElement()));
    if (src.hasListMode())
      tgt.setListMode(convertStructureMapSourceListMode(src.getListMode()));
    if (src.hasVariable())
      tgt.setVariableElement(convertId(src.getVariableElement()));
    if (src.hasCondition())
      tgt.setConditionElement(convertString(src.getConditionElement()));
    if (src.hasCheck())
      tgt.setCheckElement(convertString(src.getCheckElement()));
    if (src.hasLogMessage())
      tgt.setLogMessageElement(convertString(src.getLogMessageElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleSourceComponent convertStructureMapGroupRuleSourceComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleSourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleSourceComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleSourceComponent();
    copyElement(src, tgt);
    if (src.hasContext())
      tgt.setContextElement(convertId(src.getContextElement()));
    if (src.hasMin())
      tgt.setMinElement(convertInteger(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(convertString(src.getMaxElement()));
    if (src.hasType())
      tgt.setTypeElement(convertString(src.getTypeElement()));
    if (src.hasDefaultValue())
      tgt.setDefaultValue(convertType(src.getDefaultValue()));
    if (src.hasElement())
      tgt.setElementElement(convertString(src.getElementElement()));
    if (src.hasListMode())
      tgt.setListMode(convertStructureMapSourceListMode(src.getListMode()));
    if (src.hasVariable())
      tgt.setVariableElement(convertId(src.getVariableElement()));
    if (src.hasCondition())
      tgt.setConditionElement(convertString(src.getConditionElement()));
    if (src.hasCheck())
      tgt.setCheckElement(convertString(src.getCheckElement()));
    if (src.hasLogMessage())
      tgt.setLogMessageElement(convertString(src.getLogMessageElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode convertStructureMapSourceListMode(org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case FIRST: return org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode.FIRST;
    case NOTFIRST: return org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode.NOTFIRST;
    case LAST: return org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode.LAST;
    case NOTLAST: return org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode.NOTLAST;
    case ONLYONE: return org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode.ONLYONE;
    default: return org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode.NULL;
  }
}

  public static org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode convertStructureMapSourceListMode(org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case FIRST: return org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode.FIRST;
    case NOTFIRST: return org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode.NOTFIRST;
    case LAST: return org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode.LAST;
    case NOTLAST: return org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode.NOTLAST;
    case ONLYONE: return org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode.ONLYONE;
    default: return org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode.NULL;
  }
}

  public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetComponent convertStructureMapGroupRuleTargetComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetComponent();
    copyElement(src, tgt);
    if (src.hasContext())
      tgt.setContextElement(convertId(src.getContextElement()));
    if (src.hasContextType())
      tgt.setContextType(convertStructureMapContextType(src.getContextType()));
    if (src.hasElement())
      tgt.setElementElement(convertString(src.getElementElement()));
    if (src.hasVariable())
      tgt.setVariableElement(convertId(src.getVariableElement()));
    for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode> t : src.getListMode())
      tgt.addListMode(convertStructureMapTargetListMode(t.getValue()));
    if (src.hasListRuleId())
      tgt.setListRuleIdElement(convertId(src.getListRuleIdElement()));
    if (src.hasTransform())
      tgt.setTransform(convertStructureMapTransform(src.getTransform()));
    for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetParameterComponent t : src.getParameter())
      tgt.addParameter(convertStructureMapGroupRuleTargetParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetComponent convertStructureMapGroupRuleTargetComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetComponent();
    copyElement(src, tgt);
    if (src.hasContext())
      tgt.setContextElement(convertId(src.getContextElement()));
    if (src.hasContextType())
      tgt.setContextType(convertStructureMapContextType(src.getContextType()));
    if (src.hasElement())
      tgt.setElementElement(convertString(src.getElementElement()));
    if (src.hasVariable())
      tgt.setVariableElement(convertId(src.getVariableElement()));
    for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode> t : src.getListMode())
      tgt.addListMode(convertStructureMapTargetListMode(t.getValue()));
    if (src.hasListRuleId())
      tgt.setListRuleIdElement(convertId(src.getListRuleIdElement()));
    if (src.hasTransform())
      tgt.setTransform(convertStructureMapTransform(src.getTransform()));
    for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetParameterComponent t : src.getParameter())
      tgt.addParameter(convertStructureMapGroupRuleTargetParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StructureMap.StructureMapContextType convertStructureMapContextType(org.hl7.fhir.r4.model.StructureMap.StructureMapContextType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case TYPE: return org.hl7.fhir.r5.model.StructureMap.StructureMapContextType.TYPE;
    case VARIABLE: return org.hl7.fhir.r5.model.StructureMap.StructureMapContextType.VARIABLE;
    default: return org.hl7.fhir.r5.model.StructureMap.StructureMapContextType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.StructureMap.StructureMapContextType convertStructureMapContextType(org.hl7.fhir.r5.model.StructureMap.StructureMapContextType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case TYPE: return org.hl7.fhir.r4.model.StructureMap.StructureMapContextType.TYPE;
    case VARIABLE: return org.hl7.fhir.r4.model.StructureMap.StructureMapContextType.VARIABLE;
    default: return org.hl7.fhir.r4.model.StructureMap.StructureMapContextType.NULL;
  }
}

  public static org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode convertStructureMapTargetListMode(org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case FIRST: return org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode.FIRST;
    case SHARE: return org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode.SHARE;
    case LAST: return org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode.LAST;
    case COLLATE: return org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode.COLLATE;
    default: return org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode.NULL;
  }
}

  public static org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode convertStructureMapTargetListMode(org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case FIRST: return org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode.FIRST;
    case SHARE: return org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode.SHARE;
    case LAST: return org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode.LAST;
    case COLLATE: return org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode.COLLATE;
    default: return org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode.NULL;
  }
}

  public static org.hl7.fhir.r5.model.StructureMap.StructureMapTransform convertStructureMapTransform(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case CREATE: return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.CREATE;
    case COPY: return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.COPY;
    case TRUNCATE: return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.TRUNCATE;
    case ESCAPE: return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.ESCAPE;
    case CAST: return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.CAST;
    case APPEND: return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.APPEND;
    case TRANSLATE: return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.TRANSLATE;
    case REFERENCE: return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.REFERENCE;
    case DATEOP: return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.DATEOP;
    case UUID: return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.UUID;
    case POINTER: return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.POINTER;
    case EVALUATE: return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.EVALUATE;
    case CC: return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.CC;
    case C: return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.C;
    case QTY: return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.QTY;
    case ID: return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.ID;
    case CP: return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.CP;
    default: return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.NULL;
  }
}

  public static org.hl7.fhir.r4.model.StructureMap.StructureMapTransform convertStructureMapTransform(org.hl7.fhir.r5.model.StructureMap.StructureMapTransform src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case CREATE: return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.CREATE;
    case COPY: return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.COPY;
    case TRUNCATE: return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.TRUNCATE;
    case ESCAPE: return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.ESCAPE;
    case CAST: return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.CAST;
    case APPEND: return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.APPEND;
    case TRANSLATE: return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.TRANSLATE;
    case REFERENCE: return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.REFERENCE;
    case DATEOP: return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.DATEOP;
    case UUID: return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.UUID;
    case POINTER: return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.POINTER;
    case EVALUATE: return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.EVALUATE;
    case CC: return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.CC;
    case C: return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.C;
    case QTY: return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.QTY;
    case ID: return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.ID;
    case CP: return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.CP;
    default: return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.NULL;
  }
}

  public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetParameterComponent convertStructureMapGroupRuleTargetParameterComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetParameterComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetParameterComponent();
    copyElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetParameterComponent convertStructureMapGroupRuleTargetParameterComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetParameterComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetParameterComponent();
    copyElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent convertStructureMapGroupRuleDependentComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleDependentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertId(src.getNameElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getVariable())
      tgt.getVariable().add(convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleDependentComponent convertStructureMapGroupRuleDependentComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleDependentComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleDependentComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertId(src.getNameElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getVariable())
      tgt.getVariable().add(convertString(t));
    return tgt;
  }


}
