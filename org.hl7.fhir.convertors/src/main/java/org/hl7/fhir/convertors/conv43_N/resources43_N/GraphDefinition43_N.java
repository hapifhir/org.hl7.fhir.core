package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.ContactDetail43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.UsageContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.*;
import org.hl7.fhir.convertors.conv43_N.resources43_N.Enumerations43_N;
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
public class GraphDefinition43_N {

  public static org.hl7.fhir.model.api.GraphDefinition convertGraphDefinition(org.hl7.fhir.r4b.model.GraphDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.api.GraphDefinition tgt = new org.hl7.fhir.model.api.GraphDefinition();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
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
//    if (src.hasStart())
//      tgt.setStartElement(Code43_N.convertCode(src.getStartElement()));
//    if (src.hasProfile())
//      tgt.setProfileElement(Canonical43_N.convertCanonical(src.getProfileElement()));
//    for (org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink())
//      tgt.addLink(convertGraphDefinitionLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.GraphDefinition convertGraphDefinition(org.hl7.fhir.model.api.GraphDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.GraphDefinition tgt = new org.hl7.fhir.r4b.model.GraphDefinition();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
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
//    if (src.hasStart())
//      tgt.setStartElement(Code43_N.convertCode(src.getStartElement()));
//    if (src.hasProfile())
//      tgt.setProfileElement(Canonical43_N.convertCanonical(src.getProfileElement()));
//    for (org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink())
//      tgt.addLink(convertGraphDefinitionLinkComponent(t));
    return tgt;
  }
//
//  public static org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkComponent convertGraphDefinitionLinkComponent(org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkComponent tgt = new org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkComponent();
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
//    if (src.hasPath())
//      tgt.setPathElement(String43_N.convertString(src.getPathElement()));
//    if (src.hasSliceName())
//      tgt.setSliceNameElement(String43_N.convertString(src.getSliceNameElement()));
//    if (src.hasMin())
//      tgt.setMinElement(Integer43_N.convertInteger(src.getMinElement()));
//    if (src.hasMax())
//      tgt.setMaxElement(String43_N.convertString(src.getMaxElement()));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
//    for (org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkTargetComponent t : src.getTarget())
//      tgt.addTarget(convertGraphDefinitionLinkTargetComponent(t));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkComponent convertGraphDefinitionLinkComponent(org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkComponent tgt = new org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkComponent();
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
//    if (src.hasPath())
//      tgt.setPathElement(String43_N.convertString(src.getPathElement()));
//    if (src.hasSliceName())
//      tgt.setSliceNameElement(String43_N.convertString(src.getSliceNameElement()));
//    if (src.hasMin())
//      tgt.setMinElement(Integer43_N.convertInteger(src.getMinElement()));
//    if (src.hasMax())
//      tgt.setMaxElement(String43_N.convertString(src.getMaxElement()));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
//    for (org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkTargetComponent t : src.getTarget())
//      tgt.addTarget(convertGraphDefinitionLinkTargetComponent(t));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkTargetComponent convertGraphDefinitionLinkTargetComponent(org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkTargetComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkTargetComponent tgt = new org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkTargetComponent();
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
//    if (src.hasType())
//      tgt.setTypeElement(Code43_N.convertResourceEnum(src.getTypeElement()));
//    if (src.hasParams())
//      tgt.setParamsElement(String43_N.convertString(src.getParamsElement()));
//    if (src.hasProfile())
//      tgt.setProfileElement(Canonical43_N.convertCanonical(src.getProfileElement()));
//    for (org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent t : src.getCompartment())
//      tgt.addCompartment(convertGraphDefinitionLinkTargetCompartmentComponent(t));
//    for (org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink())
//      tgt.addLink(convertGraphDefinitionLinkComponent(t));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkTargetComponent convertGraphDefinitionLinkTargetComponent(org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkTargetComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkTargetComponent tgt = new org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkTargetComponent();
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
//    if (src.hasType())
//      tgt.setTypeElement(Code43_N.convertResourceEnum(src.getTypeElement()));
//    if (src.hasParams())
//      tgt.setParamsElement(String43_N.convertString(src.getParamsElement()));
//    if (src.hasProfile())
//      tgt.setProfileElement(Canonical43_N.convertCanonical(src.getProfileElement()));
//    for (org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent t : src.getCompartment())
//      tgt.addCompartment(convertGraphDefinitionLinkTargetCompartmentComponent(t));
//    for (org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink())
//      tgt.addLink(convertGraphDefinitionLinkComponent(t));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent convertGraphDefinitionLinkTargetCompartmentComponent(org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent tgt = new org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent();
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
//    if (src.hasUse())
//      tgt.setUseElement(convertGraphCompartmentUse(src.getUseElement()));
//    if (src.hasCode())
//      tgt.setCodeElement(convertCompartmentCode(src.getCodeElement()));
//    if (src.hasRule())
//      tgt.setRuleElement(convertGraphCompartmentRule(src.getRuleElement()));
//    if (src.hasExpression())
//      tgt.setExpressionElement(String43_N.convertString(src.getExpressionElement()));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent convertGraphDefinitionLinkTargetCompartmentComponent(org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent tgt = new org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent();
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
//    if (src.hasUse())
//      tgt.setUseElement(convertGraphCompartmentUse(src.getUseElement()));
//    if (src.hasCode())
//      tgt.setCodeElement(convertCompartmentCode(src.getCodeElement()));
//    if (src.hasRule())
//      tgt.setRuleElement(convertGraphCompartmentRule(src.getRuleElement()));
//    if (src.hasExpression())
//      tgt.setExpressionElement(String43_N.convertString(src.getExpressionElement()));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
//    return tgt;
//  }
//
//  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentUse> convertGraphCompartmentUse(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.GraphDefinition.GraphCompartmentUse> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentUse> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentUseEnumFactory());
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case CONDITION:
//        tgt.setValue(org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentUse.CONDITION);
//        break;
//      case REQUIREMENT:
//        tgt.setValue(org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentUse.REQUIREMENT);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentUse.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.GraphDefinition.GraphCompartmentUse> convertGraphCompartmentUse(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentUse> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.GraphDefinition.GraphCompartmentUse> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.GraphDefinition.GraphCompartmentUseEnumFactory());
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case CONDITION:
//        tgt.setValue(org.hl7.fhir.r4b.model.GraphDefinition.GraphCompartmentUse.CONDITION);
//        break;
//      case REQUIREMENT:
//        tgt.setValue(org.hl7.fhir.r4b.model.GraphDefinition.GraphCompartmentUse.REQUIREMENT);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r4b.model.GraphDefinition.GraphCompartmentUse.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CompartmentType> convertCompartmentCode(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.GraphDefinition.CompartmentCode> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CompartmentType> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.CompartmentTypeEnumFactory());
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case PATIENT:
//        tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompartmentType.PATIENT);
//        break;
//      case ENCOUNTER:
//        tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompartmentType.ENCOUNTER);
//        break;
//      case RELATEDPERSON:
//        tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompartmentType.RELATEDPERSON);
//        break;
//      case PRACTITIONER:
//        tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompartmentType.PRACTITIONER);
//        break;
//      case DEVICE:
//        tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompartmentType.DEVICE);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompartmentType.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.GraphDefinition.CompartmentCode> convertCompartmentCode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CompartmentType> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.GraphDefinition.CompartmentCode> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.GraphDefinition.CompartmentCodeEnumFactory());
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case PATIENT:
//        tgt.setValue(org.hl7.fhir.r4b.model.GraphDefinition.CompartmentCode.PATIENT);
//        break;
//      case ENCOUNTER:
//        tgt.setValue(org.hl7.fhir.r4b.model.GraphDefinition.CompartmentCode.ENCOUNTER);
//        break;
//      case RELATEDPERSON:
//        tgt.setValue(org.hl7.fhir.r4b.model.GraphDefinition.CompartmentCode.RELATEDPERSON);
//        break;
//      case PRACTITIONER:
//        tgt.setValue(org.hl7.fhir.r4b.model.GraphDefinition.CompartmentCode.PRACTITIONER);
//        break;
//      case DEVICE:
//        tgt.setValue(org.hl7.fhir.r4b.model.GraphDefinition.CompartmentCode.DEVICE);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r4b.model.GraphDefinition.CompartmentCode.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentRule> convertGraphCompartmentRule(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.GraphDefinition.GraphCompartmentRule> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentRule> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentRuleEnumFactory());
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case IDENTICAL:
//        tgt.setValue(org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentRule.IDENTICAL);
//        break;
//      case MATCHING:
//        tgt.setValue(org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentRule.MATCHING);
//        break;
//      case DIFFERENT:
//        tgt.setValue(org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentRule.DIFFERENT);
//        break;
//      case CUSTOM:
//        tgt.setValue(org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentRule.CUSTOM);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentRule.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.GraphDefinition.GraphCompartmentRule> convertGraphCompartmentRule(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentRule> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.GraphDefinition.GraphCompartmentRule> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.GraphDefinition.GraphCompartmentRuleEnumFactory());
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case IDENTICAL:
//        tgt.setValue(org.hl7.fhir.r4b.model.GraphDefinition.GraphCompartmentRule.IDENTICAL);
//        break;
//      case MATCHING:
//        tgt.setValue(org.hl7.fhir.r4b.model.GraphDefinition.GraphCompartmentRule.MATCHING);
//        break;
//      case DIFFERENT:
//        tgt.setValue(org.hl7.fhir.r4b.model.GraphDefinition.GraphCompartmentRule.DIFFERENT);
//        break;
//      case CUSTOM:
//        tgt.setValue(org.hl7.fhir.r4b.model.GraphDefinition.GraphCompartmentRule.CUSTOM);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r4b.model.GraphDefinition.GraphCompartmentRule.NULL);
//        break;
//    }
//    return tgt;
//  }
}