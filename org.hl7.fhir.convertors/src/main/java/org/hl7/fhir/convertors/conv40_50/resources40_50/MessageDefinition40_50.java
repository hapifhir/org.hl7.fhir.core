package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.ContactDetail40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.UsageContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.*;
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
public class MessageDefinition40_50 {

  public static org.hl7.fhir.r5.model.MessageDefinition convertMessageDefinition(org.hl7.fhir.r4.model.MessageDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MessageDefinition tgt = new org.hl7.fhir.r5.model.MessageDefinition();
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
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getReplaces())
      tgt.getReplaces().add(Canonical40_50.convertCanonical(t));
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
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasBase())
      tgt.setBaseElement(Canonical40_50.convertCanonical(src.getBaseElement()));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getParent())
      tgt.getParent().add(Canonical40_50.convertCanonical(t));
    if (src.hasEvent())
      tgt.setEvent(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getEvent()));
    if (src.hasCategory())
      tgt.setCategoryElement(convertMessageSignificanceCategory(src.getCategoryElement()));
    for (org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent t : src.getFocus())
      tgt.addFocus(convertMessageDefinitionFocusComponent(t));
    if (src.hasResponseRequired())
      tgt.setResponseRequiredElement(convertMessageheaderResponseRequest(src.getResponseRequiredElement()));
    for (org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent t : src.getAllowedResponse())
      tgt.addAllowedResponse(convertMessageDefinitionAllowedResponseComponent(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getGraph()) tgt.getGraph().add(Canonical40_50.convertCanonical(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MessageDefinition convertMessageDefinition(org.hl7.fhir.r5.model.MessageDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MessageDefinition tgt = new org.hl7.fhir.r4.model.MessageDefinition();
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
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getReplaces())
      tgt.getReplaces().add(Canonical40_50.convertCanonical(t));
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
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasBase())
      tgt.setBaseElement(Canonical40_50.convertCanonical(src.getBaseElement()));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getParent())
      tgt.getParent().add(Canonical40_50.convertCanonical(t));
    if (src.hasEvent())
      tgt.setEvent(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getEvent()));
    if (src.hasCategory())
      tgt.setCategoryElement(convertMessageSignificanceCategory(src.getCategoryElement()));
    for (org.hl7.fhir.r5.model.MessageDefinition.MessageDefinitionFocusComponent t : src.getFocus())
      tgt.addFocus(convertMessageDefinitionFocusComponent(t));
    if (src.hasResponseRequired())
      tgt.setResponseRequiredElement(convertMessageheaderResponseRequest(src.getResponseRequiredElement()));
    for (org.hl7.fhir.r5.model.MessageDefinition.MessageDefinitionAllowedResponseComponent t : src.getAllowedResponse())
      tgt.addAllowedResponse(convertMessageDefinitionAllowedResponseComponent(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getGraph()) tgt.getGraph().add(Canonical40_50.convertCanonical(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MessageDefinition.MessageSignificanceCategory> convertMessageSignificanceCategory(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategory> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MessageDefinition.MessageSignificanceCategory> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MessageDefinition.MessageSignificanceCategoryEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategory> convertMessageSignificanceCategory(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MessageDefinition.MessageSignificanceCategory> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategory> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategoryEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case CONSEQUENCE:
        tgt.setValue(org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategory.CONSEQUENCE);
        break;
      case CURRENCY:
        tgt.setValue(org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategory.CURRENCY);
        break;
      case NOTIFICATION:
        tgt.setValue(org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategory.NOTIFICATION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategory.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MessageDefinition.MessageheaderResponseRequest> convertMessageheaderResponseRequest(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageDefinition.MessageheaderResponseRequest> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MessageDefinition.MessageheaderResponseRequest> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MessageDefinition.MessageheaderResponseRequestEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageDefinition.MessageheaderResponseRequest> convertMessageheaderResponseRequest(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MessageDefinition.MessageheaderResponseRequest> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageDefinition.MessageheaderResponseRequest> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MessageDefinition.MessageheaderResponseRequestEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ALWAYS:
        tgt.setValue(org.hl7.fhir.r4.model.MessageDefinition.MessageheaderResponseRequest.ALWAYS);
        break;
      case ONERROR:
        tgt.setValue(org.hl7.fhir.r4.model.MessageDefinition.MessageheaderResponseRequest.ONERROR);
        break;
      case NEVER:
        tgt.setValue(org.hl7.fhir.r4.model.MessageDefinition.MessageheaderResponseRequest.NEVER);
        break;
      case ONSUCCESS:
        tgt.setValue(org.hl7.fhir.r4.model.MessageDefinition.MessageheaderResponseRequest.ONSUCCESS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.MessageDefinition.MessageheaderResponseRequest.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MessageDefinition.MessageDefinitionFocusComponent convertMessageDefinitionFocusComponent(org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MessageDefinition.MessageDefinitionFocusComponent tgt = new org.hl7.fhir.r5.model.MessageDefinition.MessageDefinitionFocusComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code40_50.convertResourceEnum(src.getCodeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Canonical40_50.convertCanonical(src.getProfileElement()));
    if (src.hasMin())
      tgt.setMinElement(UnsignedInt40_50.convertUnsignedInt(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(String40_50.convertString(src.getMaxElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent convertMessageDefinitionFocusComponent(org.hl7.fhir.r5.model.MessageDefinition.MessageDefinitionFocusComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent tgt = new org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code40_50.convertResourceEnum(src.getCodeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Canonical40_50.convertCanonical(src.getProfileElement()));
    if (src.hasMin())
      tgt.setMinElement(UnsignedInt40_50.convertUnsignedInt(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(String40_50.convertString(src.getMaxElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MessageDefinition.MessageDefinitionAllowedResponseComponent convertMessageDefinitionAllowedResponseComponent(org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MessageDefinition.MessageDefinitionAllowedResponseComponent tgt = new org.hl7.fhir.r5.model.MessageDefinition.MessageDefinitionAllowedResponseComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasMessage())
      tgt.setMessageElement(Canonical40_50.convertCanonical(src.getMessageElement()));
    if (src.hasSituation())
      tgt.setSituationElement(MarkDown40_50.convertMarkdown(src.getSituationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent convertMessageDefinitionAllowedResponseComponent(org.hl7.fhir.r5.model.MessageDefinition.MessageDefinitionAllowedResponseComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent tgt = new org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasMessage())
      tgt.setMessageElement(Canonical40_50.convertCanonical(src.getMessageElement()));
    if (src.hasSituation())
      tgt.setSituationElement(MarkDown40_50.convertMarkdown(src.getSituationElement()));
    return tgt;
  }
}