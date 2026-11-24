package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
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

  // R4 elements that R6 removed. (R4 sender is R6 source.sender)
  public static final String ENTERER_EXTENSION_URL = "http://hl7.org/fhir/4.0/StructureDefinition/extension-MessageHeader.enterer";
  public static final String AUTHOR_EXTENSION_URL = "http://hl7.org/fhir/4.0/StructureDefinition/extension-MessageHeader.author";
  public static final String RESPONSIBLE_EXTENSION_URL = "http://hl7.org/fhir/4.0/StructureDefinition/extension-MessageHeader.responsible";
  public static final String DESTINATION_TARGET_EXTENSION_URL = "http://hl7.org/fhir/4.0/StructureDefinition/extension-MessageHeader.destination.target";
  // R5 elements/types R4 doesn't have: endpoint as a Reference(Endpoint), and response.identifier as an Identifier (R4: id)
  public static final String DESTINATION_ENDPOINT_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-MessageHeader.destination.endpoint";
  public static final String SOURCE_ENDPOINT_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-MessageHeader.source.endpoint";
  public static final String RESPONSE_IDENTIFIER_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-MessageHeader.response.identifier";

  public static org.hl7.fhir.model.core.MessageHeader convertMessageHeader(org.hl7.fhir.r4.model.MessageHeader src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MessageHeader tgt = new org.hl7.fhir.model.core.MessageHeader();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasEnterer())
      tgt.addExtension(ENTERER_EXTENSION_URL, Reference40_N.convertReference(src.getEnterer()));
    if (src.hasAuthor())
      tgt.addExtension(AUTHOR_EXTENSION_URL, Reference40_N.convertReference(src.getAuthor()));
    if (src.hasResponsible())
      tgt.addExtension(RESPONSIBLE_EXTENSION_URL, Reference40_N.convertReference(src.getResponsible()));
    // an R4 uri is an R6 canonical, unless it was an R6 uri to start with (see below)
    if (src.hasEventUriType()) {
      if ("uri".equals(src.getEventUriType().getExtensionString(VersionConvertorConstants.EXT_ORIGINAL_DATATYPE))) {
        org.hl7.fhir.model.core.UriType u = Uri40_N.convertUri(src.getEventUriType());
        u.getExtension().removeIf(e -> VersionConvertorConstants.EXT_ORIGINAL_DATATYPE.equals(e.getUrl()));
        tgt.setEvent(u);
      } else
        tgt.setEvent(Canonical40_N.convertUriToCanonical(src.getEventUriType()));
    }
    if (src.hasEventCoding())
      tgt.setEvent(Coding40_N.convertCoding(src.getEventCoding()));
    
    for (org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent t : src.getDestination())
      tgt.addDestination(convertMessageDestinationComponent(t));
    if (src.hasSource())
      tgt.setSource(convertMessageSourceComponent(src.getSource()));
    if (src.hasSender())
      tgt.getSource().setSender(Reference40_N.convertReference(src.getSender()));
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
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, ENTERER_EXTENSION_URL, AUTHOR_EXTENSION_URL, RESPONSIBLE_EXTENSION_URL);
    if (src.hasExtension(ENTERER_EXTENSION_URL))
      tgt.setEnterer(Reference40_N.convertReference((org.hl7.fhir.model.core.Reference) src.getExtensionByUrl(ENTERER_EXTENSION_URL).getValue()));
    if (src.hasExtension(AUTHOR_EXTENSION_URL))
      tgt.setAuthor(Reference40_N.convertReference((org.hl7.fhir.model.core.Reference) src.getExtensionByUrl(AUTHOR_EXTENSION_URL).getValue()));
    if (src.hasExtension(RESPONSIBLE_EXTENSION_URL))
      tgt.setResponsible(Reference40_N.convertReference((org.hl7.fhir.model.core.Reference) src.getExtensionByUrl(RESPONSIBLE_EXTENSION_URL).getValue()));
    if (src.hasEventCanonicalType())
      tgt.setEvent(Canonical40_N.convertCanonicalToUri(src.getEventCanonicalType()));
    if (src.hasEvent() && "uri".equals(src.getEvent().fhirType())) {
      org.hl7.fhir.r4.model.UriType u = Uri40_N.convertUri((org.hl7.fhir.model.core.UriType) src.getEvent());
      u.addExtension(VersionConvertorConstants.EXT_ORIGINAL_DATATYPE, new org.hl7.fhir.r4.model.CodeType("uri"));
      tgt.setEvent(u);
    }
    if (src.hasEventCoding())
      tgt.setEvent(Coding40_N.convertCoding(src.getEventCoding()));
    for (org.hl7.fhir.model.core.MessageHeader.MessageDestinationComponent t : src.getDestinationList())
      tgt.addDestination(convertMessageDestinationComponent(t));
    if (src.hasSource())
      tgt.setSource(convertMessageSourceComponent(src.getSource()));
    if (src.hasSource() && src.getSource().hasSender())
      tgt.setSender(Reference40_N.convertReference(src.getSource().getSender()));
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
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, DESTINATION_ENDPOINT_EXTENSION_URL);
    if (src.hasTarget())
      tgt.addExtension(DESTINATION_TARGET_EXTENSION_URL, Reference40_N.convertReference(src.getTarget()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasEndpoint()) {
      tgt.setEndpoint(Url40_N.convertUrl(src.getEndpointElement()));
    }
    if (src.hasExtension(DESTINATION_ENDPOINT_EXTENSION_URL))
      tgt.setEndpoint(Reference40_N.convertReference((org.hl7.fhir.r4.model.Reference) src.getExtensionByUrl(DESTINATION_ENDPOINT_EXTENSION_URL).getValue()));
    if (src.hasReceiver())
      tgt.setReceiver(Reference40_N.convertReference(src.getReceiver()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent convertMessageDestinationComponent(org.hl7.fhir.model.core.MessageHeader.MessageDestinationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent tgt = new org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, DESTINATION_TARGET_EXTENSION_URL);
    if (src.hasExtension(DESTINATION_TARGET_EXTENSION_URL))
      tgt.setTarget(Reference40_N.convertReference((org.hl7.fhir.model.core.Reference) src.getExtensionByUrl(DESTINATION_TARGET_EXTENSION_URL).getValue()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasEndpointUrlType()) {
      tgt.setEndpointElement(Url40_N.convertUrl(src.getEndpointUrlType()));
    } else if (src.hasEndpointReference()) {
      tgt.addExtension(DESTINATION_ENDPOINT_EXTENSION_URL, Reference40_N.convertReference(src.getEndpointReference()));
    }
    if (src.hasReceiver())
      tgt.setReceiver(Reference40_N.convertReference(src.getReceiver()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.MessageHeader.MessageSourceComponent convertMessageSourceComponent(org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MessageHeader.MessageSourceComponent tgt = new org.hl7.fhir.model.core.MessageHeader.MessageSourceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, SOURCE_ENDPOINT_EXTENSION_URL);
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
    if (src.hasExtension(SOURCE_ENDPOINT_EXTENSION_URL))
      tgt.setEndpoint(Reference40_N.convertReference((org.hl7.fhir.r4.model.Reference) src.getExtensionByUrl(SOURCE_ENDPOINT_EXTENSION_URL).getValue()));
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
    else if (src.hasEndpointReference())
      tgt.addExtension(SOURCE_ENDPOINT_EXTENSION_URL, Reference40_N.convertReference(src.getEndpointReference()));
    // (source.sender is R4 MessageHeader.sender, which convertMessageHeader handles)
    return tgt;
  }

  public static org.hl7.fhir.model.core.MessageHeader.MessageHeaderResponseComponent convertMessageHeaderResponseComponent(org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MessageHeader.MessageHeaderResponseComponent tgt = new org.hl7.fhir.model.core.MessageHeader.MessageHeaderResponseComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, RESPONSE_IDENTIFIER_EXTENSION_URL);
    if (src.hasExtension(RESPONSE_IDENTIFIER_EXTENSION_URL))
      tgt.setIdentifier(Identifier40_N.convertIdentifier((org.hl7.fhir.r4.model.Identifier) src.getExtensionByUrl(RESPONSE_IDENTIFIER_EXTENSION_URL).getValue()));
    else if (src.hasIdentifier())
      tgt.setIdentifier(new org.hl7.fhir.model.core.Identifier().setValue(src.getIdentifier()));
    if (src.hasCode())
      tgt.setCodeElement(CrossVersionElements40_N.toR6Code(src.getCodeElement(), convertResponseType(src.getCodeElement()), src.fhirType(), "code"));
    if (src.hasDetails())
      tgt.setDetails(Reference40_N.convertReference(src.getDetails()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent convertMessageHeaderResponseComponent(org.hl7.fhir.model.core.MessageHeader.MessageHeaderResponseComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent tgt = new org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasIdentifier()) {
      tgt.setIdentifierElement(new org.hl7.fhir.r4.model.IdType(src.getIdentifier().getValue()));
      // R4 only has the value: if there's more, the whole identifier goes in the cross-version extension
      if (!src.getIdentifier().copy(org.hl7.fhir.model.Base.COPY_NOTHING).setValue(null).isEmpty())
        tgt.addExtension(RESPONSE_IDENTIFIER_EXTENSION_URL, Identifier40_N.convertIdentifier(src.getIdentifier()));
    }
    if (src.hasCode())
      tgt.setCodeElement(CrossVersionElements40_N.toR4Code(src.getCodeElement(), convertResponseType(src.getCodeElement()), src.fhirType(), "code"));
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