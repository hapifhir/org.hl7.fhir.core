package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Coding10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.ContactPoint10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Id10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Instant10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Uri10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class MessageHeader10_30 {

  public static org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent convertMessageDestinationComponent(org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent tgt = new org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_30.convertString(src.getNameElement()));
    if (src.hasTarget())
      tgt.setTarget(Reference10_30.convertReference(src.getTarget()));
    if (src.hasEndpointElement())
      tgt.setEndpointElement(Uri10_30.convertUri(src.getEndpointElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent convertMessageDestinationComponent(org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent tgt = new org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_30.convertString(src.getNameElement()));
    if (src.hasTarget())
      tgt.setTarget(Reference10_30.convertReference(src.getTarget()));
    if (src.hasEndpointElement())
      tgt.setEndpointElement(Uri10_30.convertUri(src.getEndpointElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MessageHeader convertMessageHeader(org.hl7.fhir.dstu3.model.MessageHeader src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.MessageHeader tgt = new org.hl7.fhir.dstu2.model.MessageHeader();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    if (src.hasTimestampElement())
      tgt.setTimestampElement(Instant10_30.convertInstant(src.getTimestampElement()));
    if (src.hasEvent())
      tgt.setEvent(Coding10_30.convertCoding(src.getEvent()));
    if (src.hasResponse())
      tgt.setResponse(convertMessageHeaderResponseComponent(src.getResponse()));
    if (src.hasSource())
      tgt.setSource(convertMessageSourceComponent(src.getSource()));
    for (org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent t : src.getDestination())
      tgt.addDestination(convertMessageDestinationComponent(t));
    if (src.hasEnterer())
      tgt.setEnterer(Reference10_30.convertReference(src.getEnterer()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference10_30.convertReference(src.getAuthor()));
    if (src.hasReceiver())
      tgt.setReceiver(Reference10_30.convertReference(src.getReceiver()));
    if (src.hasResponsible())
      tgt.setResponsible(Reference10_30.convertReference(src.getResponsible()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept10_30.convertCodeableConcept(src.getReason()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getFocus()) tgt.addData(Reference10_30.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.MessageHeader convertMessageHeader(org.hl7.fhir.dstu2.model.MessageHeader src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.MessageHeader tgt = new org.hl7.fhir.dstu3.model.MessageHeader();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    if (src.hasTimestampElement())
      tgt.setTimestampElement(Instant10_30.convertInstant(src.getTimestampElement()));
    if (src.hasEvent())
      tgt.setEvent(Coding10_30.convertCoding(src.getEvent()));
    if (src.hasResponse())
      tgt.setResponse(convertMessageHeaderResponseComponent(src.getResponse()));
    if (src.hasSource())
      tgt.setSource(convertMessageSourceComponent(src.getSource()));
    for (org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent t : src.getDestination())
      tgt.addDestination(convertMessageDestinationComponent(t));
    if (src.hasEnterer())
      tgt.setEnterer(Reference10_30.convertReference(src.getEnterer()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference10_30.convertReference(src.getAuthor()));
    if (src.hasReceiver())
      tgt.setReceiver(Reference10_30.convertReference(src.getReceiver()));
    if (src.hasResponsible())
      tgt.setResponsible(Reference10_30.convertReference(src.getResponsible()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept10_30.convertCodeableConcept(src.getReason()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getData()) tgt.addFocus(Reference10_30.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MessageHeader.MessageHeaderResponseComponent convertMessageHeaderResponseComponent(org.hl7.fhir.dstu3.model.MessageHeader.MessageHeaderResponseComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.MessageHeader.MessageHeaderResponseComponent tgt = new org.hl7.fhir.dstu2.model.MessageHeader.MessageHeaderResponseComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasIdentifierElement())
      tgt.setIdentifierElement(Id10_30.convertId(src.getIdentifierElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertResponseType(src.getCodeElement()));
    if (src.hasDetails())
      tgt.setDetails(Reference10_30.convertReference(src.getDetails()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.MessageHeader.MessageHeaderResponseComponent convertMessageHeaderResponseComponent(org.hl7.fhir.dstu2.model.MessageHeader.MessageHeaderResponseComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.MessageHeader.MessageHeaderResponseComponent tgt = new org.hl7.fhir.dstu3.model.MessageHeader.MessageHeaderResponseComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasIdentifierElement())
      tgt.setIdentifierElement(Id10_30.convertId(src.getIdentifierElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertResponseType(src.getCodeElement()));
    if (src.hasDetails())
      tgt.setDetails(Reference10_30.convertReference(src.getDetails()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.MessageHeader.MessageSourceComponent convertMessageSourceComponent(org.hl7.fhir.dstu2.model.MessageHeader.MessageSourceComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.MessageHeader.MessageSourceComponent tgt = new org.hl7.fhir.dstu3.model.MessageHeader.MessageSourceComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_30.convertString(src.getNameElement()));
    if (src.hasSoftwareElement())
      tgt.setSoftwareElement(String10_30.convertString(src.getSoftwareElement()));
    if (src.hasVersionElement())
      tgt.setVersionElement(String10_30.convertString(src.getVersionElement()));
    if (src.hasContact())
      tgt.setContact(ContactPoint10_30.convertContactPoint(src.getContact()));
    if (src.hasEndpointElement())
      tgt.setEndpointElement(Uri10_30.convertUri(src.getEndpointElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MessageHeader.MessageSourceComponent convertMessageSourceComponent(org.hl7.fhir.dstu3.model.MessageHeader.MessageSourceComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.MessageHeader.MessageSourceComponent tgt = new org.hl7.fhir.dstu2.model.MessageHeader.MessageSourceComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_30.convertString(src.getNameElement()));
    if (src.hasSoftwareElement())
      tgt.setSoftwareElement(String10_30.convertString(src.getSoftwareElement()));
    if (src.hasVersionElement())
      tgt.setVersionElement(String10_30.convertString(src.getVersionElement()));
    if (src.hasContact())
      tgt.setContact(ContactPoint10_30.convertContactPoint(src.getContact()));
    if (src.hasEndpointElement())
      tgt.setEndpointElement(Uri10_30.convertUri(src.getEndpointElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MessageHeader.ResponseType> convertResponseType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MessageHeader.ResponseType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MessageHeader.ResponseType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.MessageHeader.ResponseTypeEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MessageHeader.ResponseType> convertResponseType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MessageHeader.ResponseType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MessageHeader.ResponseType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.MessageHeader.ResponseTypeEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
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