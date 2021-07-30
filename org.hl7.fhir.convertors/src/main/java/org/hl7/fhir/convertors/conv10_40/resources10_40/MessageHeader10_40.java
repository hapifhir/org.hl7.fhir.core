package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.conv10_40.VersionConvertor_10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.CodeableConcept10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Coding10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.ContactPoint10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Id10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class MessageHeader10_40 {

  public static org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent convertMessageDestinationComponent(org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent tgt = new org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent();
    Element10_40.copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_40.convertString(src.getNameElement()));
    if (src.hasTarget())
      tgt.setTarget(Reference10_40.convertReference(src.getTarget()));
    if (src.hasEndpoint())
      tgt.setEndpoint(src.getEndpoint());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent convertMessageDestinationComponent(org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent tgt = new org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent();
    Element10_40.copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_40.convertString(src.getNameElement()));
    if (src.hasTarget())
      tgt.setTarget(Reference10_40.convertReference(src.getTarget()));
    if (src.hasEndpoint())
      tgt.setEndpoint(src.getEndpoint());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MessageHeader convertMessageHeader(org.hl7.fhir.dstu2.model.MessageHeader src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.MessageHeader tgt = new org.hl7.fhir.r4.model.MessageHeader();
    VersionConvertor_10_40.copyDomainResource(src, tgt);
    if (src.hasEvent())
      tgt.setEvent(Coding10_40.convertCoding(src.getEvent()));
    if (src.hasResponse())
      tgt.setResponse(convertMessageHeaderResponseComponent(src.getResponse()));
    if (src.hasSource())
      tgt.setSource(convertMessageSourceComponent(src.getSource()));
    for (org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent t : src.getDestination())
      tgt.addDestination(convertMessageDestinationComponent(t));
    if (src.hasEnterer())
      tgt.setEnterer(Reference10_40.convertReference(src.getEnterer()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference10_40.convertReference(src.getAuthor()));
    if (src.hasResponsible())
      tgt.setResponsible(Reference10_40.convertReference(src.getResponsible()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept10_40.convertCodeableConcept(src.getReason()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getData()) tgt.addFocus(Reference10_40.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MessageHeader convertMessageHeader(org.hl7.fhir.r4.model.MessageHeader src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.MessageHeader tgt = new org.hl7.fhir.dstu2.model.MessageHeader();
    VersionConvertor_10_40.copyDomainResource(src, tgt);
    if (src.hasEventCoding())
      tgt.setEvent(Coding10_40.convertCoding(src.getEventCoding()));
    if (src.hasResponse())
      tgt.setResponse(convertMessageHeaderResponseComponent(src.getResponse()));
    if (src.hasSource())
      tgt.setSource(convertMessageSourceComponent(src.getSource()));
    for (org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent t : src.getDestination())
      tgt.addDestination(convertMessageDestinationComponent(t));
    if (src.hasEnterer())
      tgt.setEnterer(Reference10_40.convertReference(src.getEnterer()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference10_40.convertReference(src.getAuthor()));
    if (src.hasResponsible())
      tgt.setResponsible(Reference10_40.convertReference(src.getResponsible()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept10_40.convertCodeableConcept(src.getReason()));
    for (org.hl7.fhir.r4.model.Reference t : src.getFocus()) tgt.addData(Reference10_40.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MessageHeader.MessageHeaderResponseComponent convertMessageHeaderResponseComponent(org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.MessageHeader.MessageHeaderResponseComponent tgt = new org.hl7.fhir.dstu2.model.MessageHeader.MessageHeaderResponseComponent();
    Element10_40.copyElement(src, tgt);
    if (src.hasIdentifierElement())
      tgt.setIdentifierElement(Id10_40.convertId(src.getIdentifierElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertResponseType(src.getCodeElement()));
    if (src.hasDetails())
      tgt.setDetails(Reference10_40.convertReference(src.getDetails()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent convertMessageHeaderResponseComponent(org.hl7.fhir.dstu2.model.MessageHeader.MessageHeaderResponseComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent tgt = new org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent();
    Element10_40.copyElement(src, tgt);
    if (src.hasIdentifierElement())
      tgt.setIdentifierElement(Id10_40.convertId(src.getIdentifierElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertResponseType(src.getCodeElement()));
    if (src.hasDetails())
      tgt.setDetails(Reference10_40.convertReference(src.getDetails()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent convertMessageSourceComponent(org.hl7.fhir.dstu2.model.MessageHeader.MessageSourceComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent tgt = new org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent();
    Element10_40.copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_40.convertString(src.getNameElement()));
    if (src.hasSoftwareElement())
      tgt.setSoftwareElement(String10_40.convertString(src.getSoftwareElement()));
    if (src.hasVersionElement())
      tgt.setVersionElement(String10_40.convertString(src.getVersionElement()));
    if (src.hasContact())
      tgt.setContact(ContactPoint10_40.convertContactPoint(src.getContact()));
    if (src.hasEndpoint())
      tgt.setEndpoint(src.getEndpoint());
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MessageHeader.MessageSourceComponent convertMessageSourceComponent(org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.MessageHeader.MessageSourceComponent tgt = new org.hl7.fhir.dstu2.model.MessageHeader.MessageSourceComponent();
    Element10_40.copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_40.convertString(src.getNameElement()));
    if (src.hasSoftwareElement())
      tgt.setSoftwareElement(String10_40.convertString(src.getSoftwareElement()));
    if (src.hasVersionElement())
      tgt.setVersionElement(String10_40.convertString(src.getVersionElement()));
    if (src.hasContact())
      tgt.setContact(ContactPoint10_40.convertContactPoint(src.getContact()));
    if (src.hasEndpoint())
      tgt.setEndpoint(src.getEndpoint());
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MessageHeader.ResponseType> convertResponseType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageHeader.ResponseType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MessageHeader.ResponseType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.MessageHeader.ResponseTypeEnumFactory());
    Element10_40.copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageHeader.ResponseType> convertResponseType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MessageHeader.ResponseType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageHeader.ResponseType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MessageHeader.ResponseTypeEnumFactory());
    Element10_40.copyElement(src, tgt);
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