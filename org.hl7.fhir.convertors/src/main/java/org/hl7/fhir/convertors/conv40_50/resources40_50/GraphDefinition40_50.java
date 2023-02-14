package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.ContactDetail40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.UsageContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.MarkDown40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
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
public class GraphDefinition40_50 {

  public static org.hl7.fhir.r5.model.GraphDefinition convertGraphDefinition(org.hl7.fhir.r4.model.GraphDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.GraphDefinition tgt = new org.hl7.fhir.r5.model.GraphDefinition();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
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
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_50.convertMarkdown(src.getPurposeElement()));
//    if (src.hasStart())
//      tgt.setStartElement(Code40_50.convertCode(src.getStartElement()));
//    if (src.hasProfile())
//      tgt.setProfileElement(Canonical40_50.convertCanonical(src.getProfileElement()));
//    for (org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink())
//      tgt.addLink(convertGraphDefinitionLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.GraphDefinition convertGraphDefinition(org.hl7.fhir.r5.model.GraphDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.GraphDefinition tgt = new org.hl7.fhir.r4.model.GraphDefinition();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
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
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_50.convertMarkdown(src.getPurposeElement()));
//    if (src.hasStart())
//      tgt.setStartElement(Code40_50.convertCode(src.getStartElement()));
//    if (src.hasProfile())
//      tgt.setProfileElement(Canonical40_50.convertCanonical(src.getProfileElement()));
//    for (org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink())
//      tgt.addLink(convertGraphDefinitionLinkComponent(t));
    return tgt;
  }
//
//  public static org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent convertGraphDefinitionLinkComponent(org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent tgt = new org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent();
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
//    if (src.hasPath())
//      tgt.setPathElement(String40_50.convertString(src.getPathElement()));
//    if (src.hasSliceName())
//      tgt.setSliceNameElement(String40_50.convertString(src.getSliceNameElement()));
//    if (src.hasMin())
//      tgt.setMinElement(Integer40_50.convertInteger(src.getMinElement()));
//    if (src.hasMax())
//      tgt.setMaxElement(String40_50.convertString(src.getMaxElement()));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
//    for (org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent t : src.getTarget())
//      tgt.addTarget(convertGraphDefinitionLinkTargetComponent(t));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent convertGraphDefinitionLinkComponent(org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent tgt = new org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent();
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
//    if (src.hasPath())
//      tgt.setPathElement(String40_50.convertString(src.getPathElement()));
//    if (src.hasSliceName())
//      tgt.setSliceNameElement(String40_50.convertString(src.getSliceNameElement()));
//    if (src.hasMin())
//      tgt.setMinElement(Integer40_50.convertInteger(src.getMinElement()));
//    if (src.hasMax())
//      tgt.setMaxElement(String40_50.convertString(src.getMaxElement()));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
//    for (org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent t : src.getTarget())
//      tgt.addTarget(convertGraphDefinitionLinkTargetComponent(t));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent convertGraphDefinitionLinkTargetComponent(org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent tgt = new org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent();
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
//    if (src.hasType())
//      tgt.setTypeElement(Code40_50.convertResourceEnum(src.getTypeElement()));
//    if (src.hasParams())
//      tgt.setParamsElement(String40_50.convertString(src.getParamsElement()));
//    if (src.hasProfile())
//      tgt.setProfileElement(Canonical40_50.convertCanonical(src.getProfileElement()));
//    for (org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent t : src.getCompartment())
//      tgt.addCompartment(convertGraphDefinitionLinkTargetCompartmentComponent(t));
//    for (org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink())
//      tgt.addLink(convertGraphDefinitionLinkComponent(t));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent convertGraphDefinitionLinkTargetComponent(org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent tgt = new org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent();
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
//    if (src.hasType())
//      tgt.setTypeElement(Code40_50.convertResourceEnum(src.getTypeElement()));
//    if (src.hasParams())
//      tgt.setParamsElement(String40_50.convertString(src.getParamsElement()));
//    if (src.hasProfile())
//      tgt.setProfileElement(Canonical40_50.convertCanonical(src.getProfileElement()));
//    for (org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent t : src.getCompartment())
//      tgt.addCompartment(convertGraphDefinitionLinkTargetCompartmentComponent(t));
//    for (org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink())
//      tgt.addLink(convertGraphDefinitionLinkComponent(t));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent convertGraphDefinitionLinkTargetCompartmentComponent(org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent tgt = new org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent();
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
//    if (src.hasUse())
//      tgt.setUseElement(convertGraphCompartmentUse(src.getUseElement()));
//    if (src.hasCode())
//      tgt.setCodeElement(convertCompartmentCode(src.getCodeElement()));
//    if (src.hasRule())
//      tgt.setRuleElement(convertGraphCompartmentRule(src.getRuleElement()));
//    if (src.hasExpression())
//      tgt.setExpressionElement(String40_50.convertString(src.getExpressionElement()));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent convertGraphDefinitionLinkTargetCompartmentComponent(org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent tgt = new org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent();
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
//    if (src.hasUse())
//      tgt.setUseElement(convertGraphCompartmentUse(src.getUseElement()));
//    if (src.hasCode())
//      tgt.setCodeElement(convertCompartmentCode(src.getCodeElement()));
//    if (src.hasRule())
//      tgt.setRuleElement(convertGraphCompartmentRule(src.getRuleElement()));
//    if (src.hasExpression())
//      tgt.setExpressionElement(String40_50.convertString(src.getExpressionElement()));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentUse> convertGraphCompartmentUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentUse> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentUseEnumFactory());
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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
//  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentUse> convertGraphCompartmentUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentUse> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentUseEnumFactory());
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case CONDITION:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentUse.CONDITION);
//        break;
//      case REQUIREMENT:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentUse.REQUIREMENT);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentUse.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompartmentType> convertCompartmentCode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompartmentType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.CompartmentTypeEnumFactory());
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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
//  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode> convertCompartmentCode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompartmentType> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.GraphDefinition.CompartmentCodeEnumFactory());
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case PATIENT:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.PATIENT);
//        break;
//      case ENCOUNTER:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.ENCOUNTER);
//        break;
//      case RELATEDPERSON:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.RELATEDPERSON);
//        break;
//      case PRACTITIONER:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.PRACTITIONER);
//        break;
//      case DEVICE:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.DEVICE);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule> convertGraphCompartmentRule(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRuleEnumFactory());
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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
//  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule> convertGraphCompartmentRule(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRuleEnumFactory());
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case IDENTICAL:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.IDENTICAL);
//        break;
//      case MATCHING:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.MATCHING);
//        break;
//      case DIFFERENT:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.DIFFERENT);
//        break;
//      case CUSTOM:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.CUSTOM);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.NULL);
//        break;
//    }
//    return tgt;
//  }
}