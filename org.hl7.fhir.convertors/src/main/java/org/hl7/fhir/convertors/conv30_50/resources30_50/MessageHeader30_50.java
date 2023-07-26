package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Coding30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.ContactPoint30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Uri30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class MessageHeader30_50 {

  public static org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent convertMessageDestinationComponent(org.hl7.fhir.r5.model.MessageHeader.MessageDestinationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent tgt = new org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasTarget())
      tgt.setTarget(Reference30_50.convertReference(src.getTarget()));
    if (src.hasEndpointUrlType())
      tgt.setEndpointElement(Uri30_50.convertUrl(src.getEndpointUrlType()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MessageHeader.MessageDestinationComponent convertMessageDestinationComponent(org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MessageHeader.MessageDestinationComponent tgt = new org.hl7.fhir.r5.model.MessageHeader.MessageDestinationComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasTarget())
      tgt.setTarget(Reference30_50.convertReference(src.getTarget()));
    if (src.hasEndpoint())
      tgt.setEndpoint(Uri30_50.convertUri(src.getEndpointElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MessageHeader convertMessageHeader(org.hl7.fhir.dstu3.model.MessageHeader src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MessageHeader tgt = new org.hl7.fhir.r5.model.MessageHeader();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.hasEvent())
      tgt.setEvent(Coding30_50.convertCoding(src.getEvent()));
    for (org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent t : src.getDestination())
      tgt.addDestination(convertMessageDestinationComponent(t));
    if (src.hasSender())
      tgt.setSender(Reference30_50.convertReference(src.getSender()));
//    if (src.hasEnterer())
//      tgt.setEnterer(Reference30_50.convertReference(src.getEnterer()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference30_50.convertReference(src.getAuthor()));
    if (src.hasSource())
      tgt.setSource(convertMessageSourceComponent(src.getSource()));
    if (src.hasResponsible())
      tgt.setResponsible(Reference30_50.convertReference(src.getResponsible()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept30_50.convertCodeableConcept(src.getReason()));
    if (src.hasResponse())
      tgt.setResponse(convertMessageHeaderResponseComponent(src.getResponse()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getFocus()) tgt.addFocus(Reference30_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.MessageHeader convertMessageHeader(org.hl7.fhir.r5.model.MessageHeader src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.MessageHeader tgt = new org.hl7.fhir.dstu3.model.MessageHeader();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.hasEventCoding())
      tgt.setEvent(Coding30_50.convertCoding(src.getEventCoding()));
    for (org.hl7.fhir.r5.model.MessageHeader.MessageDestinationComponent t : src.getDestination())
      tgt.addDestination(convertMessageDestinationComponent(t));
    if (src.hasSender())
      tgt.setSender(Reference30_50.convertReference(src.getSender()));
//    if (src.hasEnterer())
//      tgt.setEnterer(Reference30_50.convertReference(src.getEnterer()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference30_50.convertReference(src.getAuthor()));
    if (src.hasSource())
      tgt.setSource(convertMessageSourceComponent(src.getSource()));
    if (src.hasResponsible())
      tgt.setResponsible(Reference30_50.convertReference(src.getResponsible()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept30_50.convertCodeableConcept(src.getReason()));
    if (src.hasResponse())
      tgt.setResponse(convertMessageHeaderResponseComponent(src.getResponse()));
    for (org.hl7.fhir.r5.model.Reference t : src.getFocus()) tgt.addFocus(Reference30_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MessageHeader.MessageHeaderResponseComponent convertMessageHeaderResponseComponent(org.hl7.fhir.dstu3.model.MessageHeader.MessageHeaderResponseComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MessageHeader.MessageHeaderResponseComponent tgt = new org.hl7.fhir.r5.model.MessageHeader.MessageHeaderResponseComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(new org.hl7.fhir.r5.model.Identifier().setValue(src.getIdentifier()));
    if (src.hasCode())
      tgt.setCodeElement(convertResponseType(src.getCodeElement()));
    if (src.hasDetails())
      tgt.setDetails(Reference30_50.convertReference(src.getDetails()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.MessageHeader.MessageHeaderResponseComponent convertMessageHeaderResponseComponent(org.hl7.fhir.r5.model.MessageHeader.MessageHeaderResponseComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.MessageHeader.MessageHeaderResponseComponent tgt = new org.hl7.fhir.dstu3.model.MessageHeader.MessageHeaderResponseComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasIdentifier())
      tgt.setIdentifierElement(new org.hl7.fhir.dstu3.model.IdType(src.getIdentifier().getValue()));
    if (src.hasCode())
      tgt.setCodeElement(convertResponseType(src.getCodeElement()));
    if (src.hasDetails())
      tgt.setDetails(Reference30_50.convertReference(src.getDetails()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.MessageHeader.MessageSourceComponent convertMessageSourceComponent(org.hl7.fhir.r5.model.MessageHeader.MessageSourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.MessageHeader.MessageSourceComponent tgt = new org.hl7.fhir.dstu3.model.MessageHeader.MessageSourceComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasSoftware())
      tgt.setSoftwareElement(String30_50.convertString(src.getSoftwareElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String30_50.convertString(src.getVersionElement()));
    if (src.hasContact())
      tgt.setContact(ContactPoint30_50.convertContactPoint(src.getContact()));
    if (src.hasEndpointUrlType())
      tgt.setEndpointElement(Uri30_50.convertUrl(src.getEndpointUrlType()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MessageHeader.MessageSourceComponent convertMessageSourceComponent(org.hl7.fhir.dstu3.model.MessageHeader.MessageSourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MessageHeader.MessageSourceComponent tgt = new org.hl7.fhir.r5.model.MessageHeader.MessageSourceComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasSoftware())
      tgt.setSoftwareElement(String30_50.convertString(src.getSoftwareElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String30_50.convertString(src.getVersionElement()));
    if (src.hasContact())
      tgt.setContact(ContactPoint30_50.convertContactPoint(src.getContact()));
    if (src.hasEndpoint())
      tgt.setEndpoint(Uri30_50.convertUri(src.getEndpointElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MessageHeader.ResponseType> convertResponseType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MessageHeader.ResponseType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MessageHeader.ResponseType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MessageHeader.ResponseTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MessageHeader.ResponseType> convertResponseType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MessageHeader.ResponseType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MessageHeader.ResponseType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.MessageHeader.ResponseTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case OK:
        tgt.setValue(org.hl7.fhir.dstu3.model.MessageHeader.ResponseType.OK);
        break;
      case TRANSIENTERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.MessageHeader.ResponseType.TRANSIENTERROR);
        break;
      case FATALERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.MessageHeader.ResponseType.FATALERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.MessageHeader.ResponseType.NULL);
        break;
    }
    return tgt;
  }
}