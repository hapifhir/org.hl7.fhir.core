package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Communication;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.model.core.CodeableConcept;
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

public class Communication40_N {

  private static final String PAYLOAD_CONCEPT_URL = CrossVersionElements40_N.url("Communication.payload", "5.0", "content");


  public static org.hl7.fhir.model.core.Communication convertCommunication(org.hl7.fhir.r4.model.Communication src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Communication tgt = new org.hl7.fhir.model.core.Communication();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    // R6 dropped instantiatesCanonical and instantiatesUri
    CrossVersionElements40_N.r4ElementsToExtensions(src, "Communication", tgt.getExtension(), "instantiatesCanonical", "instantiatesUri");
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getInResponseTo())
      tgt.addInResponseTo(Reference40_N.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR6Code(src.getStatusElement(), convertCommunicationStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept40_N.convertCodeableConcept(src.getStatusReason()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriorityElement(CrossVersionElements40_N.toR6Code(src.getPriorityElement(), convertCommunicationPriority(src.getPriorityElement()), src.fhirType(), "priority"));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getMedium())
      tgt.addMedium(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasTopic())
      tgt.setTopic(CodeableConcept40_N.convertCodeableConcept(src.getTopic()));
    for (org.hl7.fhir.r4.model.Reference t : src.getAbout()) tgt.addAbout(Reference40_N.convertReference(t));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasSent())
      tgt.setSentElement(DateTime40_N.convertDateTime(src.getSentElement()));
    if (src.hasReceived())
      tgt.setReceivedElement(DateTime40_N.convertDateTime(src.getReceivedElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getRecipient()) tgt.addRecipient(Reference40_N.convertReference(t));
    if (src.hasSender())
      tgt.setSender(Reference40_N.convertReference(src.getSender()));
    CodeableConcept40_N.convertReasonsToR6(src.getReasonCode(), src.getReasonReference(), tgt.getReasonList());
    for (org.hl7.fhir.r4.model.Communication.CommunicationPayloadComponent t : src.getPayload())
      tgt.addPayload(convertCommunicationPayloadComponent(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Communication convertCommunication(org.hl7.fhir.model.core.Communication src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Communication tgt = new org.hl7.fhir.r4.model.Communication();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("Communication", "4.0", new String[] {"instantiatesCanonical", "instantiatesUri"}));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "Communication", "instantiatesCanonical", "instantiatesUri");
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.getIdentifier().add(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.model.core.Reference t : src.getBasedOnList()) tgt.addBasedOn(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getPartOfList()) tgt.addPartOf(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getInResponseToList())
      tgt.addInResponseTo(Reference40_N.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR4Code(src.getStatusElement(), convertCommunicationStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept40_N.convertCodeableConcept(src.getStatusReason()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriorityElement(CrossVersionElements40_N.toR4Code(src.getPriorityElement(), convertCommunicationPriority(src.getPriorityElement()), src.fhirType(), "priority"));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getMediumList())
      tgt.addMedium(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasTopic())
      tgt.setTopic(CodeableConcept40_N.convertCodeableConcept(src.getTopic()));
    for (org.hl7.fhir.model.core.Reference t : src.getAboutList()) tgt.addAbout(Reference40_N.convertReference(t));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasSent())
      tgt.setSentElement(DateTime40_N.convertDateTime(src.getSentElement()));
    if (src.hasReceived())
      tgt.setReceivedElement(DateTime40_N.convertDateTime(src.getReceivedElement()));
    for (org.hl7.fhir.model.core.Reference t : src.getRecipientList()) tgt.addRecipient(Reference40_N.convertReference(t));
    if (src.hasSender())
      tgt.setSender(Reference40_N.convertReference(src.getSender()));
    CodeableConcept40_N.convertReasonsToR4(src.getReasonList(), tgt.getReasonCode(), tgt.getReasonReference());
    for (org.hl7.fhir.model.core.Communication.CommunicationPayloadComponent t : src.getPayloadList())
      tgt.addPayload(convertCommunicationPayloadComponent(t));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.EventStatus> convertCommunicationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Communication.CommunicationStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.EventStatus> tgt = new Enumeration<>(new Enumerations.EventStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PREPARATION:
                  tgt.setValue(Enumerations.EventStatus.PREPARATION);
                  break;
              case INPROGRESS:
                  tgt.setValue(Enumerations.EventStatus.INPROGRESS);
                  break;
              case NOTDONE:
                  tgt.setValue(Enumerations.EventStatus.NOTDONE);
                  break;
              case ONHOLD:
                  tgt.setValue(Enumerations.EventStatus.ONHOLD);
                  break;
              case STOPPED:
                  tgt.setValue(Enumerations.EventStatus.STOPPED);
                  break;
              case COMPLETED:
                  tgt.setValue(Enumerations.EventStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Enumerations.EventStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(Enumerations.EventStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(Enumerations.EventStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Communication.CommunicationStatus> convertCommunicationStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.EventStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<Communication.CommunicationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new Communication.CommunicationStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PREPARATION:
                  tgt.setValue(Communication.CommunicationStatus.PREPARATION);
                  break;
              case INPROGRESS:
                  tgt.setValue(Communication.CommunicationStatus.INPROGRESS);
                  break;
              case NOTDONE:
                  tgt.setValue(Communication.CommunicationStatus.NOTDONE);
                  break;
              case ONHOLD:
                  tgt.setValue(Communication.CommunicationStatus.ONHOLD);
                  break;
              case STOPPED:
                  tgt.setValue(Communication.CommunicationStatus.STOPPED);
                  break;
              case COMPLETED:
                  tgt.setValue(Communication.CommunicationStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Communication.CommunicationStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(Communication.CommunicationStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(Communication.CommunicationStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestPriority> convertCommunicationPriority(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Communication.CommunicationPriority> src) throws FHIRException {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Communication.CommunicationPriority> convertCommunicationPriority(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestPriority> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<Communication.CommunicationPriority> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new Communication.CommunicationPriorityEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ROUTINE:
                  tgt.setValue(Communication.CommunicationPriority.ROUTINE);
                  break;
              case URGENT:
                  tgt.setValue(Communication.CommunicationPriority.URGENT);
                  break;
              case ASAP:
                  tgt.setValue(Communication.CommunicationPriority.ASAP);
                  break;
              case STAT:
                  tgt.setValue(Communication.CommunicationPriority.STAT);
                  break;
              default:
                  tgt.setValue(Communication.CommunicationPriority.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Communication.CommunicationPayloadComponent convertCommunicationPayloadComponent(org.hl7.fhir.r4.model.Communication.CommunicationPayloadComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Communication.CommunicationPayloadComponent tgt = new org.hl7.fhir.model.core.Communication.CommunicationPayloadComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasContent()) {
      if (src.getContent() instanceof StringType && src.getContent().hasExtension(PAYLOAD_CONCEPT_URL)) {
        // an R6 concept (see below)
        CodeableConcept tgtc = CodeableConcept40_N.convertStringToCodeableConcept(src.getContentStringType(), PAYLOAD_CONCEPT_URL);
        tgtc.getExtension().removeIf(e -> PAYLOAD_CONCEPT_URL.equals(e.getUrl()));
        tgt.setContent(tgtc);
      } else if (src.getContent() instanceof StringType) {
        // R6 has string as well
        tgt.setContent(String40_N.convertString(src.getContentStringType()));
      } else {
        // the types R4 and R6 allow differ: a value of a type the other version doesn't allow is an extension
        CrossVersionElements40_N.choiceToR6(src, src.getExtension(), src.fhirType(), "content", tgt, tgt.getExtension());
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Communication.CommunicationPayloadComponent convertCommunicationPayloadComponent(org.hl7.fhir.model.core.Communication.CommunicationPayloadComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Communication.CommunicationPayloadComponent tgt = new org.hl7.fhir.r4.model.Communication.CommunicationPayloadComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasContent()) {
      if (src.hasContentCodeableConcept()) {
        StringType tgts = new StringType();
        ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src.getContent(), tgts);
        tgts.setValue(src.getContentCodeableConcept().getText());
        // R4 has a string: the text, and the whole concept in a 5.0 extension (R6 has string too, so the extension says
        // it was a concept)
        tgts.addExtension(PAYLOAD_CONCEPT_URL, CodeableConcept40_N.convertCodeableConcept(src.getContentCodeableConcept()));
        tgt.setContent(tgts);
      } else {
        CrossVersionElements40_N.choiceToR4(src, src.getExtension(), src.fhirType(), "content", tgt, tgt.getExtension());
      }
    }
    return tgt;
  }
}