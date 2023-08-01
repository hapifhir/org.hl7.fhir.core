package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Coding40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.ContactPoint40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Canonical40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Url40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
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
public class MessageHeader40_50 {

  public static org.hl7.fhir.r5.model.MessageHeader convertMessageHeader(org.hl7.fhir.r4.model.MessageHeader src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MessageHeader tgt = new org.hl7.fhir.r5.model.MessageHeader();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasEventUriType())
      tgt.setEvent(Canonical40_50.convertUriToCanonical(src.getEventUriType()));
    if (src.hasEventCoding())
      tgt.setEvent(Coding40_50.convertCoding(src.getEventCoding()));
    
    for (org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent t : src.getDestination())
      tgt.addDestination(convertMessageDestinationComponent(t));
    if (src.hasSender())
      tgt.setSender(Reference40_50.convertReference(src.getSender()));
//    if (src.hasEnterer())
//      tgt.setEnterer(Reference40_50.convertReference(src.getEnterer()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference40_50.convertReference(src.getAuthor()));
    if (src.hasSource())
      tgt.setSource(convertMessageSourceComponent(src.getSource()));
    if (src.hasResponsible())
      tgt.setResponsible(Reference40_50.convertReference(src.getResponsible()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept40_50.convertCodeableConcept(src.getReason()));
    if (src.hasResponse())
      tgt.setResponse(convertMessageHeaderResponseComponent(src.getResponse()));
    for (org.hl7.fhir.r4.model.Reference t : src.getFocus()) tgt.addFocus(Reference40_50.convertReference(t));
    if (src.hasDefinition())
      tgt.setDefinitionElement(Canonical40_50.convertCanonical(src.getDefinitionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MessageHeader convertMessageHeader(org.hl7.fhir.r5.model.MessageHeader src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MessageHeader tgt = new org.hl7.fhir.r4.model.MessageHeader();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasEventCanonicalType())
      tgt.setEvent(Canonical40_50.convertCanonicalToUri(src.getEventCanonicalType()));
    if (src.hasEventCoding())
      tgt.setEvent(Coding40_50.convertCoding(src.getEventCoding()));
    for (org.hl7.fhir.r5.model.MessageHeader.MessageDestinationComponent t : src.getDestination())
      tgt.addDestination(convertMessageDestinationComponent(t));
    if (src.hasSender())
      tgt.setSender(Reference40_50.convertReference(src.getSender()));
//    if (src.hasEnterer())
//      tgt.setEnterer(Reference40_50.convertReference(src.getEnterer()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference40_50.convertReference(src.getAuthor()));
    if (src.hasSource())
      tgt.setSource(convertMessageSourceComponent(src.getSource()));
    if (src.hasResponsible())
      tgt.setResponsible(Reference40_50.convertReference(src.getResponsible()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept40_50.convertCodeableConcept(src.getReason()));
    if (src.hasResponse())
      tgt.setResponse(convertMessageHeaderResponseComponent(src.getResponse()));
    for (org.hl7.fhir.r5.model.Reference t : src.getFocus()) tgt.addFocus(Reference40_50.convertReference(t));
    if (src.hasDefinition())
      tgt.setDefinitionElement(Canonical40_50.convertCanonical(src.getDefinitionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MessageHeader.MessageDestinationComponent convertMessageDestinationComponent(org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MessageHeader.MessageDestinationComponent tgt = new org.hl7.fhir.r5.model.MessageHeader.MessageDestinationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasTarget())
      tgt.setTarget(Reference40_50.convertReference(src.getTarget()));
    if (src.hasEndpoint()) {
      tgt.setEndpoint(Url40_50.convertUrl(src.getEndpointElement()));
    }
    if (src.hasReceiver())
      tgt.setReceiver(Reference40_50.convertReference(src.getReceiver()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent convertMessageDestinationComponent(org.hl7.fhir.r5.model.MessageHeader.MessageDestinationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent tgt = new org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasTarget())
      tgt.setTarget(Reference40_50.convertReference(src.getTarget()));
    if (src.hasEndpointUrlType()) {
      tgt.setEndpointElement(Url40_50.convertUrl(src.getEndpointUrlType()));
    }
    if (src.hasReceiver())
      tgt.setReceiver(Reference40_50.convertReference(src.getReceiver()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MessageHeader.MessageSourceComponent convertMessageSourceComponent(org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MessageHeader.MessageSourceComponent tgt = new org.hl7.fhir.r5.model.MessageHeader.MessageSourceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasSoftware())
      tgt.setSoftwareElement(String40_50.convertString(src.getSoftwareElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasContact())
      tgt.setContact(ContactPoint40_50.convertContactPoint(src.getContact()));
    if (src.hasEndpoint())
      tgt.setEndpoint(Url40_50.convertUrl(src.getEndpointElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent convertMessageSourceComponent(org.hl7.fhir.r5.model.MessageHeader.MessageSourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent tgt = new org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasSoftware())
      tgt.setSoftwareElement(String40_50.convertString(src.getSoftwareElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasContact())
      tgt.setContact(ContactPoint40_50.convertContactPoint(src.getContact()));
    if (src.hasEndpointUrlType())
      tgt.setEndpointElement(Url40_50.convertUrl(src.getEndpointUrlType()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MessageHeader.MessageHeaderResponseComponent convertMessageHeaderResponseComponent(org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MessageHeader.MessageHeaderResponseComponent tgt = new org.hl7.fhir.r5.model.MessageHeader.MessageHeaderResponseComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(new org.hl7.fhir.r5.model.Identifier().setValue(src.getIdentifier()));
    if (src.hasCode())
      tgt.setCodeElement(convertResponseType(src.getCodeElement()));
    if (src.hasDetails())
      tgt.setDetails(Reference40_50.convertReference(src.getDetails()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent convertMessageHeaderResponseComponent(org.hl7.fhir.r5.model.MessageHeader.MessageHeaderResponseComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent tgt = new org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifierElement(new org.hl7.fhir.r4.model.IdType(src.getIdentifier().getValue()));
    if (src.hasCode())
      tgt.setCodeElement(convertResponseType(src.getCodeElement()));
    if (src.hasDetails())
      tgt.setDetails(Reference40_50.convertReference(src.getDetails()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MessageHeader.ResponseType> convertResponseType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageHeader.ResponseType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MessageHeader.ResponseType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MessageHeader.ResponseTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case OK:
        tgt.setValue(org.hl7.fhir.r5.model.MessageHeader.ResponseType.OK);
        break;
      case TRANSIENTERROR:
        tgt.setValue(org.hl7.fhir.r5.model.MessageHeader.ResponseType.TRANSIENTERROR);
        break;
      case FATALERROR:
        tgt.setValue(org.hl7.fhir.r5.model.MessageHeader.ResponseType.FATALERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.MessageHeader.ResponseType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageHeader.ResponseType> convertResponseType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MessageHeader.ResponseType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageHeader.ResponseType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MessageHeader.ResponseTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case OK:
        tgt.setValue(org.hl7.fhir.r4.model.MessageHeader.ResponseType.OK);
        break;
      case TRANSIENTERROR:
        tgt.setValue(org.hl7.fhir.r4.model.MessageHeader.ResponseType.TRANSIENTERROR);
        break;
      case FATALERROR:
        tgt.setValue(org.hl7.fhir.r4.model.MessageHeader.ResponseType.FATALERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.MessageHeader.ResponseType.NULL);
        break;
    }
    return tgt;
  }
}