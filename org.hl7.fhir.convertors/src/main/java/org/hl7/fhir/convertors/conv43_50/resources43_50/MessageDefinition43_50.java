package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.ContactDetail43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.UsageContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.*;
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
public class MessageDefinition43_50 {

  public static org.hl7.fhir.r5.model.MessageDefinition convertMessageDefinition(org.hl7.fhir.r4b.model.MessageDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MessageDefinition tgt = new org.hl7.fhir.r5.model.MessageDefinition();
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
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getReplaces())
      tgt.getReplaces().add(Canonical43_50.convertCanonical(t));
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
    if (src.hasBase())
      tgt.setBaseElement(Canonical43_50.convertCanonical(src.getBaseElement()));
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getParent())
      tgt.getParent().add(Canonical43_50.convertCanonical(t));
    if (src.hasEvent())
      tgt.setEvent(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getEvent()));
    if (src.hasCategory())
      tgt.setCategoryElement(convertMessageSignificanceCategory(src.getCategoryElement()));
    for (org.hl7.fhir.r4b.model.MessageDefinition.MessageDefinitionFocusComponent t : src.getFocus())
      tgt.addFocus(convertMessageDefinitionFocusComponent(t));
    if (src.hasResponseRequired())
      tgt.setResponseRequiredElement(convertMessageheaderResponseRequest(src.getResponseRequiredElement()));
    for (org.hl7.fhir.r4b.model.MessageDefinition.MessageDefinitionAllowedResponseComponent t : src.getAllowedResponse())
      tgt.addAllowedResponse(convertMessageDefinitionAllowedResponseComponent(t));
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getGraph()) tgt.setGraphElement(Canonical43_50.convertCanonical(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MessageDefinition convertMessageDefinition(org.hl7.fhir.r5.model.MessageDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MessageDefinition tgt = new org.hl7.fhir.r4b.model.MessageDefinition();
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
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getReplaces())
      tgt.getReplaces().add(Canonical43_50.convertCanonical(t));
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
    if (src.hasBase())
      tgt.setBaseElement(Canonical43_50.convertCanonical(src.getBaseElement()));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getParent())
      tgt.getParent().add(Canonical43_50.convertCanonical(t));
    if (src.hasEvent())
      tgt.setEvent(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getEvent()));
    if (src.hasCategory())
      tgt.setCategoryElement(convertMessageSignificanceCategory(src.getCategoryElement()));
    for (org.hl7.fhir.r5.model.MessageDefinition.MessageDefinitionFocusComponent t : src.getFocus())
      tgt.addFocus(convertMessageDefinitionFocusComponent(t));
    if (src.hasResponseRequired())
      tgt.setResponseRequiredElement(convertMessageheaderResponseRequest(src.getResponseRequiredElement()));
    for (org.hl7.fhir.r5.model.MessageDefinition.MessageDefinitionAllowedResponseComponent t : src.getAllowedResponse())
      tgt.addAllowedResponse(convertMessageDefinitionAllowedResponseComponent(t));
    if (src.hasGraph()) 
      tgt.getGraph().add(Canonical43_50.convertCanonical(src.getGraphElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MessageDefinition.MessageSignificanceCategory> convertMessageSignificanceCategory(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MessageDefinition.MessageSignificanceCategory> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MessageDefinition.MessageSignificanceCategory> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MessageDefinition.MessageSignificanceCategoryEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case CONSEQUENCE:
        tgt.setValue(org.hl7.fhir.r5.model.MessageDefinition.MessageSignificanceCategory.CONSEQUENCE);
        break;
      case CURRENCY:
        tgt.setValue(org.hl7.fhir.r5.model.MessageDefinition.MessageSignificanceCategory.CURRENCY);
        break;
      case NOTIFICATION:
        tgt.setValue(org.hl7.fhir.r5.model.MessageDefinition.MessageSignificanceCategory.NOTIFICATION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.MessageDefinition.MessageSignificanceCategory.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MessageDefinition.MessageSignificanceCategory> convertMessageSignificanceCategory(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MessageDefinition.MessageSignificanceCategory> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MessageDefinition.MessageSignificanceCategory> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.MessageDefinition.MessageSignificanceCategoryEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case CONSEQUENCE:
        tgt.setValue(org.hl7.fhir.r4b.model.MessageDefinition.MessageSignificanceCategory.CONSEQUENCE);
        break;
      case CURRENCY:
        tgt.setValue(org.hl7.fhir.r4b.model.MessageDefinition.MessageSignificanceCategory.CURRENCY);
        break;
      case NOTIFICATION:
        tgt.setValue(org.hl7.fhir.r4b.model.MessageDefinition.MessageSignificanceCategory.NOTIFICATION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.MessageDefinition.MessageSignificanceCategory.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MessageDefinition.MessageheaderResponseRequest> convertMessageheaderResponseRequest(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MessageDefinition.MessageheaderResponseRequest> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MessageDefinition.MessageheaderResponseRequest> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MessageDefinition.MessageheaderResponseRequestEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ALWAYS:
        tgt.setValue(org.hl7.fhir.r5.model.MessageDefinition.MessageheaderResponseRequest.ALWAYS);
        break;
      case ONERROR:
        tgt.setValue(org.hl7.fhir.r5.model.MessageDefinition.MessageheaderResponseRequest.ONERROR);
        break;
      case NEVER:
        tgt.setValue(org.hl7.fhir.r5.model.MessageDefinition.MessageheaderResponseRequest.NEVER);
        break;
      case ONSUCCESS:
        tgt.setValue(org.hl7.fhir.r5.model.MessageDefinition.MessageheaderResponseRequest.ONSUCCESS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.MessageDefinition.MessageheaderResponseRequest.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MessageDefinition.MessageheaderResponseRequest> convertMessageheaderResponseRequest(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MessageDefinition.MessageheaderResponseRequest> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MessageDefinition.MessageheaderResponseRequest> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.MessageDefinition.MessageheaderResponseRequestEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ALWAYS:
        tgt.setValue(org.hl7.fhir.r4b.model.MessageDefinition.MessageheaderResponseRequest.ALWAYS);
        break;
      case ONERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.MessageDefinition.MessageheaderResponseRequest.ONERROR);
        break;
      case NEVER:
        tgt.setValue(org.hl7.fhir.r4b.model.MessageDefinition.MessageheaderResponseRequest.NEVER);
        break;
      case ONSUCCESS:
        tgt.setValue(org.hl7.fhir.r4b.model.MessageDefinition.MessageheaderResponseRequest.ONSUCCESS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.MessageDefinition.MessageheaderResponseRequest.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MessageDefinition.MessageDefinitionFocusComponent convertMessageDefinitionFocusComponent(org.hl7.fhir.r4b.model.MessageDefinition.MessageDefinitionFocusComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MessageDefinition.MessageDefinitionFocusComponent tgt = new org.hl7.fhir.r5.model.MessageDefinition.MessageDefinitionFocusComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertResourceEnum(src.getCodeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Canonical43_50.convertCanonical(src.getProfileElement()));
    if (src.hasMin())
      tgt.setMinElement(UnsignedInt43_50.convertUnsignedInt(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(String43_50.convertString(src.getMaxElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MessageDefinition.MessageDefinitionFocusComponent convertMessageDefinitionFocusComponent(org.hl7.fhir.r5.model.MessageDefinition.MessageDefinitionFocusComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MessageDefinition.MessageDefinitionFocusComponent tgt = new org.hl7.fhir.r4b.model.MessageDefinition.MessageDefinitionFocusComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertResourceEnum(src.getCodeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Canonical43_50.convertCanonical(src.getProfileElement()));
    if (src.hasMin())
      tgt.setMinElement(UnsignedInt43_50.convertUnsignedInt(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(String43_50.convertString(src.getMaxElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MessageDefinition.MessageDefinitionAllowedResponseComponent convertMessageDefinitionAllowedResponseComponent(org.hl7.fhir.r4b.model.MessageDefinition.MessageDefinitionAllowedResponseComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MessageDefinition.MessageDefinitionAllowedResponseComponent tgt = new org.hl7.fhir.r5.model.MessageDefinition.MessageDefinitionAllowedResponseComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasMessage())
      tgt.setMessageElement(Canonical43_50.convertCanonical(src.getMessageElement()));
    if (src.hasSituation())
      tgt.setSituationElement(MarkDown43_50.convertMarkdown(src.getSituationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MessageDefinition.MessageDefinitionAllowedResponseComponent convertMessageDefinitionAllowedResponseComponent(org.hl7.fhir.r5.model.MessageDefinition.MessageDefinitionAllowedResponseComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MessageDefinition.MessageDefinitionAllowedResponseComponent tgt = new org.hl7.fhir.r4b.model.MessageDefinition.MessageDefinitionAllowedResponseComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasMessage())
      tgt.setMessageElement(Canonical43_50.convertCanonical(src.getMessageElement()));
    if (src.hasSituation())
      tgt.setSituationElement(MarkDown43_50.convertMarkdown(src.getSituationElement()));
    return tgt;
  }
}