package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Annotation43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Canonical43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.StringType;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.CodeableReference;

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
public class Communication43_50 {

  public static org.hl7.fhir.r5.model.Communication convertCommunication(org.hl7.fhir.r4b.model.Communication src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Communication tgt = new org.hl7.fhir.r5.model.Communication();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(Canonical43_50.convertCanonical(t));
    for (org.hl7.fhir.r4b.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(Uri43_50.convertUri(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getInResponseTo())
      tgt.addInResponseTo(Reference43_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertCommunicationStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept43_50.convertCodeableConcept(src.getStatusReason()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriorityElement(convertCommunicationPriority(src.getPriorityElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getMedium())
      tgt.addMedium(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasTopic())
      tgt.setTopic(CodeableConcept43_50.convertCodeableConcept(src.getTopic()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getAbout()) tgt.addAbout(Reference43_50.convertReference(t));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasSent())
      tgt.setSentElement(DateTime43_50.convertDateTime(src.getSentElement()));
    if (src.hasReceived())
      tgt.setReceivedElement(DateTime43_50.convertDateTime(src.getReceivedElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getRecipient()) tgt.addRecipient(Reference43_50.convertReference(t));
    if (src.hasSender())
      tgt.setSender(Reference43_50.convertReference(src.getSender()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept43_50.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference43_50.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Communication.CommunicationPayloadComponent t : src.getPayload())
      tgt.addPayload(convertCommunicationPayloadComponent(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Communication convertCommunication(org.hl7.fhir.r5.model.Communication src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Communication tgt = new org.hl7.fhir.r4b.model.Communication();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(Canonical43_50.convertCanonical(t));
    for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(Uri43_50.convertUri(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getInResponseTo())
      tgt.addInResponseTo(Reference43_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertCommunicationStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept43_50.convertCodeableConcept(src.getStatusReason()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriorityElement(convertCommunicationPriority(src.getPriorityElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getMedium())
      tgt.addMedium(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasTopic())
      tgt.setTopic(CodeableConcept43_50.convertCodeableConcept(src.getTopic()));
    for (org.hl7.fhir.r5.model.Reference t : src.getAbout()) tgt.addAbout(Reference43_50.convertReference(t));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasSent())
      tgt.setSentElement(DateTime43_50.convertDateTime(src.getSentElement()));
    if (src.hasReceived())
      tgt.setReceivedElement(DateTime43_50.convertDateTime(src.getReceivedElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getRecipient()) tgt.addRecipient(Reference43_50.convertReference(t));
    if (src.hasSender())
      tgt.setSender(Reference43_50.convertReference(src.getSender()));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept43_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReason())
      if (t.hasReference())
        tgt.addReasonReference(Reference43_50.convertReference(t.getReference()));
    for (org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent t : src.getPayload())
      tgt.addPayload(convertCommunicationPayloadComponent(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EventStatus> convertCommunicationStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.EventStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EventStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.EventStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PREPARATION:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.PREPARATION);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.INPROGRESS);
        break;
      case NOTDONE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.NOTDONE);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.ONHOLD);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.STOPPED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.EventStatus> convertCommunicationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EventStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.EventStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.EventStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PREPARATION:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.EventStatus.PREPARATION);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.EventStatus.INPROGRESS);
        break;
      case NOTDONE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.EventStatus.NOTDONE);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.EventStatus.ONHOLD);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.EventStatus.STOPPED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.EventStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.EventStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.EventStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.EventStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> convertCommunicationPriority(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestPriority> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestPriorityEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ROUTINE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.ROUTINE);
        break;
      case URGENT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.URGENT);
        break;
      case ASAP:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.ASAP);
        break;
      case STAT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.STAT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestPriority> convertCommunicationPriority(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestPriority> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.RequestPriorityEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ROUTINE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.ROUTINE);
        break;
      case URGENT:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.URGENT);
        break;
      case ASAP:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.ASAP);
        break;
      case STAT:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.STAT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent convertCommunicationPayloadComponent(org.hl7.fhir.r4b.model.Communication.CommunicationPayloadComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent tgt = new org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasContent()) {
      if (src.getContent() instanceof StringType) {
        CodeableConcept tgtc = new CodeableConcept();
        ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src.getContent(), tgtc);
        tgtc.setText(src.getContentStringType().getValue());
        tgt.setContent(tgtc);
      } else {
        if (src.hasContent())
          tgt.setContent(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getContent()));
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Communication.CommunicationPayloadComponent convertCommunicationPayloadComponent(org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Communication.CommunicationPayloadComponent tgt = new org.hl7.fhir.r4b.model.Communication.CommunicationPayloadComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasContent()) {
      if (src.hasContentCodeableConcept()) {
        StringType tgts = new StringType();
        ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src.getContent(), tgts);
        tgts.setValue(src.getContentCodeableConcept().getText());
        tgt.setContent(tgts);
      } else {
        if (src.hasContent())
          tgt.setContent(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getContent()));
      }
    }
    return tgt;
  }
}