package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.ContactDetail40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.UsageContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Code40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.MarkDown40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.UnsignedInt40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.MessageDefinition;

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

public class MessageDefinition40_N {

  public static org.hl7.fhir.model.core.MessageDefinition convertMessageDefinition(org.hl7.fhir.r4.model.MessageDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MessageDefinition tgt = new org.hl7.fhir.model.core.MessageDefinition();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getReplaces())
      tgt.getReplacesList().add(Canonical40_N.convertCanonical(t));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_N.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasBase())
      tgt.setBaseElement(Canonical40_N.convertCanonical(src.getBaseElement()));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getParent())
      tgt.getParentList().add(Canonical40_N.convertCanonical(t));
    if (src.hasEvent())
      tgt.setEvent(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getEvent()));
    if (src.hasCategory())
      tgt.setCategoryElement(convertMessageSignificanceCategory(src.getCategoryElement()));
    for (org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent t : src.getFocus())
      tgt.addFocus(convertMessageDefinitionFocusComponent(t));
    if (src.hasResponseRequired())
      tgt.setResponseRequiredElement(convertMessageheaderResponseRequest(src.getResponseRequiredElement()));
    for (org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent t : src.getAllowedResponse())
      tgt.addAllowedResponse(convertMessageDefinitionAllowedResponseComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MessageDefinition convertMessageDefinition(org.hl7.fhir.model.core.MessageDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MessageDefinition tgt = new org.hl7.fhir.r4.model.MessageDefinition();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getReplacesList())
      tgt.getReplaces().add(Canonical40_N.convertCanonical(t));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getContactList())
      tgt.addContact(ContactDetail40_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.UsageContext t : src.getUseContextList())
      tgt.addUseContext(UsageContext40_N.convertUsageContext(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getJurisdictionList())
      tgt.addJurisdiction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasBase())
      tgt.setBaseElement(Canonical40_N.convertCanonical(src.getBaseElement()));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getParentList())
      tgt.getParent().add(Canonical40_N.convertCanonical(t));
    if (src.hasEvent())
      tgt.setEvent(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getEvent()));
    if (src.hasCategory())
      tgt.setCategoryElement(convertMessageSignificanceCategory(src.getCategoryElement()));
    for (org.hl7.fhir.model.core.MessageDefinition.MessageDefinitionFocusComponent t : src.getFocusList())
      tgt.addFocus(convertMessageDefinitionFocusComponent(t));
    if (src.hasResponseRequired())
      tgt.setResponseRequiredElement(convertMessageheaderResponseRequest(src.getResponseRequiredElement()));
    for (org.hl7.fhir.model.core.MessageDefinition.MessageDefinitionAllowedResponseComponent t : src.getAllowedResponseList())
      tgt.addAllowedResponse(convertMessageDefinitionAllowedResponseComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MessageDefinition.MessageSignificanceCategory> convertMessageSignificanceCategory(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategory> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<MessageDefinition.MessageSignificanceCategory> tgt = new Enumeration<>(new MessageDefinition.MessageSignificanceCategoryEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case CONSEQUENCE:
                  tgt.setValue(MessageDefinition.MessageSignificanceCategory.CONSEQUENCE);
                  break;
              case CURRENCY:
                  tgt.setValue(MessageDefinition.MessageSignificanceCategory.CURRENCY);
                  break;
              case NOTIFICATION:
                  tgt.setValue(MessageDefinition.MessageSignificanceCategory.NOTIFICATION);
                  break;
              default:
                  tgt.setValue(MessageDefinition.MessageSignificanceCategory.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategory> convertMessageSignificanceCategory(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MessageDefinition.MessageSignificanceCategory> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategory> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategoryEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MessageDefinition.MessageheaderResponseRequest> convertMessageheaderResponseRequest(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageDefinition.MessageheaderResponseRequest> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<MessageDefinition.MessageheaderResponseRequest> tgt = new Enumeration<>(new MessageDefinition.MessageheaderResponseRequestEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ALWAYS:
                  tgt.setValue(MessageDefinition.MessageheaderResponseRequest.ALWAYS);
                  break;
              case ONERROR:
                  tgt.setValue(MessageDefinition.MessageheaderResponseRequest.ONERROR);
                  break;
              case NEVER:
                  tgt.setValue(MessageDefinition.MessageheaderResponseRequest.NEVER);
                  break;
              case ONSUCCESS:
                  tgt.setValue(MessageDefinition.MessageheaderResponseRequest.ONSUCCESS);
                  break;
              default:
                  tgt.setValue(MessageDefinition.MessageheaderResponseRequest.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageDefinition.MessageheaderResponseRequest> convertMessageheaderResponseRequest(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MessageDefinition.MessageheaderResponseRequest> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageDefinition.MessageheaderResponseRequest> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MessageDefinition.MessageheaderResponseRequestEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.MessageDefinition.MessageDefinitionFocusComponent convertMessageDefinitionFocusComponent(org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MessageDefinition.MessageDefinitionFocusComponent tgt = new org.hl7.fhir.model.core.MessageDefinition.MessageDefinitionFocusComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Uri40_N.convertUriFromCode(src.getCodeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Canonical40_N.convertCanonical(src.getProfileElement()));
    if (src.hasMin())
      tgt.setMinElement(UnsignedInt40_N.convertUnsignedInt(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(String40_N.convertString(src.getMaxElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent convertMessageDefinitionFocusComponent(org.hl7.fhir.model.core.MessageDefinition.MessageDefinitionFocusComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent tgt = new org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Uri40_N.convertUriToCode(src.getCodeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Canonical40_N.convertCanonical(src.getProfileElement()));
    if (src.hasMin())
      tgt.setMinElement(UnsignedInt40_N.convertUnsignedInt(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(String40_N.convertString(src.getMaxElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.MessageDefinition.MessageDefinitionAllowedResponseComponent convertMessageDefinitionAllowedResponseComponent(org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MessageDefinition.MessageDefinitionAllowedResponseComponent tgt = new org.hl7.fhir.model.core.MessageDefinition.MessageDefinitionAllowedResponseComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasMessage())
      tgt.setMessageElement(Canonical40_N.convertCanonical(src.getMessageElement()));
    if (src.hasSituation())
      tgt.setSituationElement(MarkDown40_N.convertMarkdown(src.getSituationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent convertMessageDefinitionAllowedResponseComponent(org.hl7.fhir.model.core.MessageDefinition.MessageDefinitionAllowedResponseComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent tgt = new org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasMessage())
      tgt.setMessageElement(Canonical40_N.convertCanonical(src.getMessageElement()));
    if (src.hasSituation())
      tgt.setSituationElement(MarkDown40_N.convertMarkdown(src.getSituationElement()));
    return tgt;
  }
}