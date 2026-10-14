package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CommunicationRequest;
import org.hl7.fhir.model.core.CodeableReference;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;

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

public class CommunicationRequest40_N {

  public static org.hl7.fhir.model.core.CommunicationRequest convertCommunicationRequest(org.hl7.fhir.r4.model.CommunicationRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CommunicationRequest tgt = new org.hl7.fhir.model.core.CommunicationRequest();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReplaces()) tgt.addReplaces(Reference40_N.convertReference(t));
    if (src.hasGroupIdentifier())
      tgt.setGroupIdentifier(Identifier40_N.convertIdentifier(src.getGroupIdentifier()));
    if (src.hasStatus())
      tgt.setStatusElement(convertCommunicationRequestStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept40_N.convertCodeableConcept(src.getStatusReason()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriorityElement(convertCommunicationPriority(src.getPriorityElement()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(Boolean40_N.convertBoolean(src.getDoNotPerformElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getMedium())
      tgt.addMedium(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    for (org.hl7.fhir.r4.model.Reference t : src.getAbout()) tgt.addAbout(Reference40_N.convertReference(t));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    for (org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent t : src.getPayload())
      tgt.addPayload(convertCommunicationRequestPayloadComponent(t));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getOccurrence()));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime40_N.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(Reference40_N.convertReference(src.getRequester()));
    for (org.hl7.fhir.r4.model.Reference t : src.getRecipient()) tgt.addRecipient(Reference40_N.convertReference(t));
    if (src.hasSender())
      tgt.addInformationProvider(Reference40_N.convertReference(src.getSender()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept40_N.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference40_N.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CommunicationRequest convertCommunicationRequest(org.hl7.fhir.model.core.CommunicationRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CommunicationRequest tgt = new org.hl7.fhir.r4.model.CommunicationRequest();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.model.core.Reference t : src.getBasedOnList()) tgt.addBasedOn(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getReplacesList()) tgt.addReplaces(Reference40_N.convertReference(t));
    if (src.hasGroupIdentifier())
      tgt.setGroupIdentifier(Identifier40_N.convertIdentifier(src.getGroupIdentifier()));
    if (src.hasStatus())
      tgt.setStatusElement(convertCommunicationRequestStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept40_N.convertCodeableConcept(src.getStatusReason()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriorityElement(convertCommunicationPriority(src.getPriorityElement()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(Boolean40_N.convertBoolean(src.getDoNotPerformElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getMediumList())
      tgt.addMedium(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    for (org.hl7.fhir.model.core.Reference t : src.getAboutList()) tgt.addAbout(Reference40_N.convertReference(t));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    for (org.hl7.fhir.model.core.CommunicationRequest.CommunicationRequestPayloadComponent t : src.getPayloadList())
      tgt.addPayload(convertCommunicationRequestPayloadComponent(t));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getOccurrence()));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime40_N.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(Reference40_N.convertReference(src.getRequester()));
    for (org.hl7.fhir.model.core.Reference t : src.getRecipientList()) tgt.addRecipient(Reference40_N.convertReference(t));
    if (src.hasInformationProvider())
      tgt.setSender(Reference40_N.convertReference(src.getInformationProviderFirstRep()));
    for (CodeableReference t : src.getReasonList())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept40_N.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReasonList())
      if (t.hasReference())
        tgt.addReasonReference(Reference40_N.convertReference(t.getReference()));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestStatus> convertCommunicationRequestStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.RequestStatus> tgt = new Enumeration<>(new Enumerations.RequestStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DRAFT:
                  tgt.setValue(Enumerations.RequestStatus.DRAFT);
                  break;
              case ACTIVE:
                  tgt.setValue(Enumerations.RequestStatus.ACTIVE);
                  break;
              case ONHOLD:
                  tgt.setValue(Enumerations.RequestStatus.ONHOLD);
                  break;
              case REVOKED:
                  tgt.setValue(Enumerations.RequestStatus.REVOKED);
                  break;
              case COMPLETED:
                  tgt.setValue(Enumerations.RequestStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Enumerations.RequestStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(Enumerations.RequestStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(Enumerations.RequestStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus> convertCommunicationRequestStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<CommunicationRequest.CommunicationRequestStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new CommunicationRequest.CommunicationRequestStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DRAFT:
                  tgt.setValue(CommunicationRequest.CommunicationRequestStatus.DRAFT);
                  break;
              case ACTIVE:
                  tgt.setValue(CommunicationRequest.CommunicationRequestStatus.ACTIVE);
                  break;
              case ONHOLD:
                  tgt.setValue(CommunicationRequest.CommunicationRequestStatus.ONHOLD);
                  break;
              case REVOKED:
                  tgt.setValue(CommunicationRequest.CommunicationRequestStatus.REVOKED);
                  break;
              case COMPLETED:
                  tgt.setValue(CommunicationRequest.CommunicationRequestStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(CommunicationRequest.CommunicationRequestStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(CommunicationRequest.CommunicationRequestStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(CommunicationRequest.CommunicationRequestStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestPriority> convertCommunicationPriority(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CommunicationRequest.CommunicationPriority> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.RequestPriority> tgt = new Enumeration<>(new Enumerations.RequestPriorityEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ROUTINE:
                  tgt.setValue(Enumerations.RequestPriority.ROUTINE);
                  break;
              case URGENT:
                  tgt.setValue(Enumerations.RequestPriority.URGENT);
                  break;
              case ASAP:
                  tgt.setValue(Enumerations.RequestPriority.ASAP);
                  break;
              case STAT:
                  tgt.setValue(Enumerations.RequestPriority.STAT);
                  break;
              default:
                  tgt.setValue(Enumerations.RequestPriority.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CommunicationRequest.CommunicationPriority> convertCommunicationPriority(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestPriority> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<CommunicationRequest.CommunicationPriority> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new CommunicationRequest.CommunicationPriorityEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ROUTINE:
                  tgt.setValue(CommunicationRequest.CommunicationPriority.ROUTINE);
                  break;
              case URGENT:
                  tgt.setValue(CommunicationRequest.CommunicationPriority.URGENT);
                  break;
              case ASAP:
                  tgt.setValue(CommunicationRequest.CommunicationPriority.ASAP);
                  break;
              case STAT:
                  tgt.setValue(CommunicationRequest.CommunicationPriority.STAT);
                  break;
              default:
                  tgt.setValue(CommunicationRequest.CommunicationPriority.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.CommunicationRequest.CommunicationRequestPayloadComponent convertCommunicationRequestPayloadComponent(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CommunicationRequest.CommunicationRequestPayloadComponent tgt = new org.hl7.fhir.model.core.CommunicationRequest.CommunicationRequestPayloadComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (org.hl7.fhir.r4.utils.ToolingExtensions.hasExtension(src, VersionConvertorConstants.EXT_PAYLOAD_CONTENT)) {
      org.hl7.fhir.r4.model.Extension e = org.hl7.fhir.r4.utils.ToolingExtensions.getExtension(src, VersionConvertorConstants.EXT_PAYLOAD_CONTENT);
      tgt.setContent(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(e.getValue()));
      org.hl7.fhir.model.extensions.ExtensionUtilities.removeExtension(tgt, VersionConvertorConstants.EXT_PAYLOAD_CONTENT);
    } else if (src.hasContent()) {
      org.hl7.fhir.r4.model.Type content = src.getContent();
      if (content instanceof org.hl7.fhir.r4.model.StringType) {
        org.hl7.fhir.r4.model.StringType string = (org.hl7.fhir.r4.model.StringType) content;
        org.hl7.fhir.model.core.CodeableConcept code = new org.hl7.fhir.model.core.CodeableConcept();
        code.setTextElement((org.hl7.fhir.model.core.StringType) ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(string));
        tgt.setContent(code);
      } else
        tgt.setContent(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(content));
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent convertCommunicationRequestPayloadComponent(org.hl7.fhir.model.core.CommunicationRequest.CommunicationRequestPayloadComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent tgt = new org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasContent()) {
      org.hl7.fhir.model.core.DataType content = src.getContent();
      if (content instanceof org.hl7.fhir.model.core.CodeableConcept) {
        org.hl7.fhir.model.core.CodeableConcept code = (org.hl7.fhir.model.core.CodeableConcept) content;
        if (code.hasText())
          tgt.setContent(new org.hl7.fhir.r4.model.StringType(code.getText()));
        if (code.hasCoding() || code.hasExtension()) {
          org.hl7.fhir.r4.model.Extension e = new org.hl7.fhir.r4.model.Extension(VersionConvertorConstants.EXT_PAYLOAD_CONTENT);
          e.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(code));
          tgt.addExtension(e);
        }
      } else
        tgt.setContent(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(content));
    }
    return tgt;
  }
}