package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.ContactDetail43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.UsageContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Canonical43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Code43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Integer43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.MarkDown43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
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
public class GraphDefinition43_50 {

  public static org.hl7.fhir.r5.model.GraphDefinition convertGraphDefinition(org.hl7.fhir.r4b.model.GraphDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.GraphDefinition tgt = new org.hl7.fhir.r5.model.GraphDefinition();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
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
//    if (src.hasStart())
//      tgt.setStartElement(Code43_50.convertCode(src.getStartElement()));
//    if (src.hasProfile())
//      tgt.setProfileElement(Canonical43_50.convertCanonical(src.getProfileElement()));
//    for (org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink())
//      tgt.addLink(convertGraphDefinitionLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.GraphDefinition convertGraphDefinition(org.hl7.fhir.r5.model.GraphDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.GraphDefinition tgt = new org.hl7.fhir.r4b.model.GraphDefinition();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
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
//    if (src.hasStart())
//      tgt.setStartElement(Code43_50.convertCode(src.getStartElement()));
//    if (src.hasProfile())
//      tgt.setProfileElement(Canonical43_50.convertCanonical(src.getProfileElement()));
//    for (org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink())
//      tgt.addLink(convertGraphDefinitionLinkComponent(t));
    return tgt;
  }
//
//  public static org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent convertGraphDefinitionLinkComponent(org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent tgt = new org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
//    if (src.hasPath())
//      tgt.setPathElement(String43_50.convertString(src.getPathElement()));
//    if (src.hasSliceName())
//      tgt.setSliceNameElement(String43_50.convertString(src.getSliceNameElement()));
//    if (src.hasMin())
//      tgt.setMinElement(Integer43_50.convertInteger(src.getMinElement()));
//    if (src.hasMax())
//      tgt.setMaxElement(String43_50.convertString(src.getMaxElement()));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
//    for (org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkTargetComponent t : src.getTarget())
//      tgt.addTarget(convertGraphDefinitionLinkTargetComponent(t));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkComponent convertGraphDefinitionLinkComponent(org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkComponent tgt = new org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
//    if (src.hasPath())
//      tgt.setPathElement(String43_50.convertString(src.getPathElement()));
//    if (src.hasSliceName())
//      tgt.setSliceNameElement(String43_50.convertString(src.getSliceNameElement()));
//    if (src.hasMin())
//      tgt.setMinElement(Integer43_50.convertInteger(src.getMinElement()));
//    if (src.hasMax())
//      tgt.setMaxElement(String43_50.convertString(src.getMaxElement()));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
//    for (org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent t : src.getTarget())
//      tgt.addTarget(convertGraphDefinitionLinkTargetComponent(t));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent convertGraphDefinitionLinkTargetComponent(org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkTargetComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent tgt = new org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
//    if (src.hasType())
//      tgt.setTypeElement(Code43_50.convertResourceEnum(src.getTypeElement()));
//    if (src.hasParams())
//      tgt.setParamsElement(String43_50.convertString(src.getParamsElement()));
//    if (src.hasProfile())
//      tgt.setProfileElement(Canonical43_50.convertCanonical(src.getProfileElement()));
//    for (org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent t : src.getCompartment())
//      tgt.addCompartment(convertGraphDefinitionLinkTargetCompartmentComponent(t));
//    for (org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink())
//      tgt.addLink(convertGraphDefinitionLinkComponent(t));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkTargetComponent convertGraphDefinitionLinkTargetComponent(org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkTargetComponent tgt = new org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkTargetComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
//    if (src.hasType())
//      tgt.setTypeElement(Code43_50.convertResourceEnum(src.getTypeElement()));
//    if (src.hasParams())
//      tgt.setParamsElement(String43_50.convertString(src.getParamsElement()));
//    if (src.hasProfile())
//      tgt.setProfileElement(Canonical43_50.convertCanonical(src.getProfileElement()));
//    for (org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent t : src.getCompartment())
//      tgt.addCompartment(convertGraphDefinitionLinkTargetCompartmentComponent(t));
//    for (org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink())
//      tgt.addLink(convertGraphDefinitionLinkComponent(t));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent convertGraphDefinitionLinkTargetCompartmentComponent(org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent tgt = new org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
//    if (src.hasUse())
//      tgt.setUseElement(convertGraphCompartmentUse(src.getUseElement()));
//    if (src.hasCode())
//      tgt.setCodeElement(convertCompartmentCode(src.getCodeElement()));
//    if (src.hasRule())
//      tgt.setRuleElement(convertGraphCompartmentRule(src.getRuleElement()));
//    if (src.hasExpression())
//      tgt.setExpressionElement(String43_50.convertString(src.getExpressionElement()));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent convertGraphDefinitionLinkTargetCompartmentComponent(org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent tgt = new org.hl7.fhir.r4b.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
//    if (src.hasUse())
//      tgt.setUseElement(convertGraphCompartmentUse(src.getUseElement()));
//    if (src.hasCode())
//      tgt.setCodeElement(convertCompartmentCode(src.getCodeElement()));
//    if (src.hasRule())
//      tgt.setRuleElement(convertGraphCompartmentRule(src.getRuleElement()));
//    if (src.hasExpression())
//      tgt.setExpressionElement(String43_50.convertString(src.getExpressionElement()));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentUse> convertGraphCompartmentUse(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.GraphDefinition.GraphCompartmentUse> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentUseEnumFactory());
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case CONDITION:
//        tgt.setValue(org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentUse.CONDITION);
//        break;
//      case REQUIREMENT:
//        tgt.setValue(org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentUse.REQUIREMENT);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentUse.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.GraphDefinition.GraphCompartmentUse> convertGraphCompartmentUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentUse> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.GraphDefinition.GraphCompartmentUse> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.GraphDefinition.GraphCompartmentUseEnumFactory());
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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
//  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompartmentType> convertCompartmentCode(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.CompartmentType> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompartmentType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.CompartmentTypeEnumFactory());
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case PATIENT:
//        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.PATIENT);
//        break;
//      case ENCOUNTER:
//        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.ENCOUNTER);
//        break;
//      case RELATEDPERSON:
//        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.RELATEDPERSON);
//        break;
//      case PRACTITIONER:
//        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.PRACTITIONER);
//        break;
//      case DEVICE:
//        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.DEVICE);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.CompartmentType> convertCompartmentCode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompartmentType> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.CompartmentType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.CompartmentTypeEnumFactory());
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case PATIENT:
//        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.CompartmentType.PATIENT);
//        break;
//      case ENCOUNTER:
//        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.CompartmentType.ENCOUNTER);
//        break;
//      case RELATEDPERSON:
//        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.CompartmentType.RELATEDPERSON);
//        break;
//      case PRACTITIONER:
//        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.CompartmentType.PRACTITIONER);
//        break;
//      case DEVICE:
//        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.CompartmentType.DEVICE);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.CompartmentType.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule> convertGraphCompartmentRule(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.GraphDefinition.GraphCompartmentRule> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRuleEnumFactory());
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case IDENTICAL:
//        tgt.setValue(org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule.IDENTICAL);
//        break;
//      case MATCHING:
//        tgt.setValue(org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule.MATCHING);
//        break;
//      case DIFFERENT:
//        tgt.setValue(org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule.DIFFERENT);
//        break;
//      case CUSTOM:
//        tgt.setValue(org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule.CUSTOM);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.GraphDefinition.GraphCompartmentRule> convertGraphCompartmentRule(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.GraphDefinition.GraphCompartmentRule> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.GraphDefinition.GraphCompartmentRuleEnumFactory());
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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