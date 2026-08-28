package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Coding40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.ContactPoint40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Url40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.MessageHeader;

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

public class MessageHeader40_N {

  public static org.hl7.fhir.model.core.MessageHeader convertMessageHeader(org.hl7.fhir.r4.model.MessageHeader src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MessageHeader tgt = new org.hl7.fhir.model.core.MessageHeader();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasEventUriType())
      tgt.setEvent(Canonical40_N.convertUriToCanonical(src.getEventUriType()));
    if (src.hasEventCoding())
      tgt.setEvent(Coding40_N.convertCoding(src.getEventCoding()));
    
    for (org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent t : src.getDestination())
      tgt.addDestination(convertMessageDestinationComponent(t));
//    if (src.hasEnterer())
//      tgt.setEnterer(Reference40_N.convertReference(src.getEnterer()));
    if (src.hasSource())
      tgt.setSource(convertMessageSourceComponent(src.getSource()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept40_N.convertCodeableConcept(src.getReason()));
    if (src.hasResponse())
      tgt.setResponse(convertMessageHeaderResponseComponent(src.getResponse()));
    for (org.hl7.fhir.r4.model.Reference t : src.getFocus()) tgt.addFocus(Reference40_N.convertReference(t));
    if (src.hasDefinition())
      tgt.setDefinitionElement(Canonical40_N.convertCanonical(src.getDefinitionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MessageHeader convertMessageHeader(org.hl7.fhir.model.core.MessageHeader src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MessageHeader tgt = new org.hl7.fhir.r4.model.MessageHeader();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasEventCanonicalType())
      tgt.setEvent(Canonical40_N.convertCanonicalToUri(src.getEventCanonicalType()));
    if (src.hasEventCoding())
      tgt.setEvent(Coding40_N.convertCoding(src.getEventCoding()));
    for (org.hl7.fhir.model.core.MessageHeader.MessageDestinationComponent t : src.getDestinationList())
      tgt.addDestination(convertMessageDestinationComponent(t));
//    if (src.hasEnterer())
//      tgt.setEnterer(Reference40_N.convertReference(src.getEnterer()));
    if (src.hasSource())
      tgt.setSource(convertMessageSourceComponent(src.getSource()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept40_N.convertCodeableConcept(src.getReason()));
    if (src.hasResponse())
      tgt.setResponse(convertMessageHeaderResponseComponent(src.getResponse()));
    for (org.hl7.fhir.model.core.Reference t : src.getFocusList()) tgt.addFocus(Reference40_N.convertReference(t));
    if (src.hasDefinition())
      tgt.setDefinitionElement(Canonical40_N.convertCanonical(src.getDefinitionElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.MessageHeader.MessageDestinationComponent convertMessageDestinationComponent(org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MessageHeader.MessageDestinationComponent tgt = new org.hl7.fhir.model.core.MessageHeader.MessageDestinationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasEndpoint()) {
      tgt.setEndpoint(Url40_N.convertUrl(src.getEndpointElement()));
    }
    if (src.hasReceiver())
      tgt.setReceiver(Reference40_N.convertReference(src.getReceiver()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent convertMessageDestinationComponent(org.hl7.fhir.model.core.MessageHeader.MessageDestinationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent tgt = new org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasEndpointUrlType()) {
      tgt.setEndpointElement(Url40_N.convertUrl(src.getEndpointUrlType()));
    }
    if (src.hasReceiver())
      tgt.setReceiver(Reference40_N.convertReference(src.getReceiver()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.MessageHeader.MessageSourceComponent convertMessageSourceComponent(org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MessageHeader.MessageSourceComponent tgt = new org.hl7.fhir.model.core.MessageHeader.MessageSourceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasSoftware())
      tgt.setSoftwareElement(String40_N.convertString(src.getSoftwareElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasContact())
      tgt.setContact(ContactPoint40_N.convertContactPoint(src.getContact()));
    if (src.hasEndpoint())
      tgt.setEndpoint(Url40_N.convertUrl(src.getEndpointElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent convertMessageSourceComponent(org.hl7.fhir.model.core.MessageHeader.MessageSourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent tgt = new org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasSoftware())
      tgt.setSoftwareElement(String40_N.convertString(src.getSoftwareElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasContact())
      tgt.setContact(ContactPoint40_N.convertContactPoint(src.getContact()));
    if (src.hasEndpointUrlType())
      tgt.setEndpointElement(Url40_N.convertUrl(src.getEndpointUrlType()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.MessageHeader.MessageHeaderResponseComponent convertMessageHeaderResponseComponent(org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MessageHeader.MessageHeaderResponseComponent tgt = new org.hl7.fhir.model.core.MessageHeader.MessageHeaderResponseComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(new org.hl7.fhir.model.core.Identifier().setValue(src.getIdentifier()));
    if (src.hasCode())
      tgt.setCodeElement(convertResponseType(src.getCodeElement()));
    if (src.hasDetails())
      tgt.setDetails(Reference40_N.convertReference(src.getDetails()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent convertMessageHeaderResponseComponent(org.hl7.fhir.model.core.MessageHeader.MessageHeaderResponseComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent tgt = new org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifierElement(new org.hl7.fhir.r4.model.IdType(src.getIdentifier().getValue()));
    if (src.hasCode())
      tgt.setCodeElement(convertResponseType(src.getCodeElement()));
    if (src.hasDetails())
      tgt.setDetails(Reference40_N.convertReference(src.getDetails()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MessageHeader.ResponseType> convertResponseType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageHeader.ResponseType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<MessageHeader.ResponseType> tgt = new Enumeration<>(new MessageHeader.ResponseTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case OK:
                  tgt.setValue(MessageHeader.ResponseType.OK);
                  break;
              case TRANSIENTERROR:
                  tgt.setValue(MessageHeader.ResponseType.TRANSIENTERROR);
                  break;
              case FATALERROR:
                  tgt.setValue(MessageHeader.ResponseType.FATALERROR);
                  break;
              default:
                  tgt.setValue(MessageHeader.ResponseType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageHeader.ResponseType> convertResponseType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MessageHeader.ResponseType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageHeader.ResponseType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MessageHeader.ResponseTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }
}