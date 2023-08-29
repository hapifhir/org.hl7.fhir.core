package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Coding10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.ContactPoint10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Uri10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class MessageHeader10_50 {

  public static org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent convertMessageDestinationComponent(org.hl7.fhir.r5.model.MessageHeader.MessageDestinationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent tgt = new org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    if (src.hasTarget())
      tgt.setTarget(Reference10_50.convertReference(src.getTarget()));
    if (src.hasEndpointUrlType())
      tgt.setEndpointElement(Uri10_50.convertUri(src.getEndpointUrlType()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MessageHeader.MessageDestinationComponent convertMessageDestinationComponent(org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.MessageHeader.MessageDestinationComponent tgt = new org.hl7.fhir.r5.model.MessageHeader.MessageDestinationComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    if (src.hasTarget())
      tgt.setTarget(Reference10_50.convertReference(src.getTarget()));
    if (src.hasEndpoint())
      tgt.setEndpoint(Uri10_50.convertUri(src.getEndpointElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MessageHeader convertMessageHeader(org.hl7.fhir.r5.model.MessageHeader src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.MessageHeader tgt = new org.hl7.fhir.dstu2.model.MessageHeader();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    if (src.hasEventCoding())
      tgt.setEvent(Coding10_50.convertCoding(src.getEventCoding()));
    if (src.hasResponse())
      tgt.setResponse(convertMessageHeaderResponseComponent(src.getResponse()));
    if (src.hasSource())
      tgt.setSource(convertMessageSourceComponent(src.getSource()));
    for (org.hl7.fhir.r5.model.MessageHeader.MessageDestinationComponent t : src.getDestination())
      tgt.addDestination(convertMessageDestinationComponent(t));
//    if (src.hasEnterer())
//      tgt.setEnterer(Reference10_50.convertReference(src.getEnterer()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference10_50.convertReference(src.getAuthor()));
    if (src.hasResponsible())
      tgt.setResponsible(Reference10_50.convertReference(src.getResponsible()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept10_50.convertCodeableConcept(src.getReason()));
    for (org.hl7.fhir.r5.model.Reference t : src.getFocus()) tgt.addData(Reference10_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MessageHeader convertMessageHeader(org.hl7.fhir.dstu2.model.MessageHeader src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.MessageHeader tgt = new org.hl7.fhir.r5.model.MessageHeader();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    if (src.hasEvent())
      tgt.setEvent(Coding10_50.convertCoding(src.getEvent()));
    if (src.hasResponse())
      tgt.setResponse(convertMessageHeaderResponseComponent(src.getResponse()));
    if (src.hasSource())
      tgt.setSource(convertMessageSourceComponent(src.getSource()));
    for (org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent t : src.getDestination())
      tgt.addDestination(convertMessageDestinationComponent(t));
//    if (src.hasEnterer())
//      tgt.setEnterer(Reference10_50.convertReference(src.getEnterer()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference10_50.convertReference(src.getAuthor()));
    if (src.hasResponsible())
      tgt.setResponsible(Reference10_50.convertReference(src.getResponsible()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept10_50.convertCodeableConcept(src.getReason()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getData()) tgt.addFocus(Reference10_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MessageHeader.MessageHeaderResponseComponent convertMessageHeaderResponseComponent(org.hl7.fhir.r5.model.MessageHeader.MessageHeaderResponseComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.MessageHeader.MessageHeaderResponseComponent tgt = new org.hl7.fhir.dstu2.model.MessageHeader.MessageHeaderResponseComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasIdentifier())
      tgt.setIdentifierElement(new org.hl7.fhir.dstu2.model.IdType(src.getIdentifier().getValue()));
    if (src.hasCode())
      tgt.setCodeElement(convertResponseType(src.getCodeElement()));
    if (src.hasDetails())
      tgt.setDetails(Reference10_50.convertReference(src.getDetails()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MessageHeader.MessageHeaderResponseComponent convertMessageHeaderResponseComponent(org.hl7.fhir.dstu2.model.MessageHeader.MessageHeaderResponseComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.MessageHeader.MessageHeaderResponseComponent tgt = new org.hl7.fhir.r5.model.MessageHeader.MessageHeaderResponseComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasIdentifierElement())
      tgt.setIdentifier(new org.hl7.fhir.r5.model.Identifier().setValue(src.getIdentifier()));
    if (src.hasCode())
      tgt.setCodeElement(convertResponseType(src.getCodeElement()));
    if (src.hasDetails())
      tgt.setDetails(Reference10_50.convertReference(src.getDetails()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MessageHeader.MessageSourceComponent convertMessageSourceComponent(org.hl7.fhir.r5.model.MessageHeader.MessageSourceComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.MessageHeader.MessageSourceComponent tgt = new org.hl7.fhir.dstu2.model.MessageHeader.MessageSourceComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    if (src.hasSoftwareElement())
      tgt.setSoftwareElement(String10_50.convertString(src.getSoftwareElement()));
    if (src.hasVersionElement())
      tgt.setVersionElement(String10_50.convertString(src.getVersionElement()));
    if (src.hasContact())
      tgt.setContact(ContactPoint10_50.convertContactPoint(src.getContact()));
    if (src.hasEndpointUrlType())
      tgt.setEndpointElement(Uri10_50.convertUri(src.getEndpointUrlType()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MessageHeader.MessageSourceComponent convertMessageSourceComponent(org.hl7.fhir.dstu2.model.MessageHeader.MessageSourceComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.MessageHeader.MessageSourceComponent tgt = new org.hl7.fhir.r5.model.MessageHeader.MessageSourceComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    if (src.hasSoftwareElement())
      tgt.setSoftwareElement(String10_50.convertString(src.getSoftwareElement()));
    if (src.hasVersionElement())
      tgt.setVersionElement(String10_50.convertString(src.getVersionElement()));
    if (src.hasContact())
      tgt.setContact(ContactPoint10_50.convertContactPoint(src.getContact()));
    if (src.hasEndpoint())
      tgt.setEndpoint(Uri10_50.convertUri(src.getEndpointElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MessageHeader.ResponseType> convertResponseType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MessageHeader.ResponseType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MessageHeader.ResponseType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MessageHeader.ResponseTypeEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MessageHeader.ResponseType> convertResponseType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MessageHeader.ResponseType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MessageHeader.ResponseType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.MessageHeader.ResponseTypeEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case OK:
        tgt.setValue(org.hl7.fhir.dstu2.model.MessageHeader.ResponseType.OK);
        break;
      case TRANSIENTERROR:
        tgt.setValue(org.hl7.fhir.dstu2.model.MessageHeader.ResponseType.TRANSIENTERROR);
        break;
      case FATALERROR:
        tgt.setValue(org.hl7.fhir.dstu2.model.MessageHeader.ResponseType.FATALERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.MessageHeader.ResponseType.NULL);
        break;
    }
    return tgt;
  }
}