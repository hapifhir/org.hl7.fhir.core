package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Identifier10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.DateTime10_50;
import org.hl7.fhir.dstu2.model.Communication;
import org.hl7.fhir.dstu2.model.Enumeration;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.Enumerations;

public class Communication10_50 {

  public static org.hl7.fhir.r5.model.Communication convertCommunication(org.hl7.fhir.dstu2.model.Communication src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Communication tgt = new org.hl7.fhir.r5.model.Communication();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasCategory())
      tgt.addCategory(CodeableConcept10_50.convertCodeableConcept(src.getCategory()));
    if (src.hasSender())
      tgt.setSender(Reference10_50.convertReference(src.getSender()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getRecipient())
      tgt.addRecipient(Reference10_50.convertReference(t));
    for (org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent t : src.getPayload())
      tgt.addPayload(convertCommunicationPayloadComponent(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getMedium())
      tgt.addMedium(CodeableConcept10_50.convertCodeableConcept(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertCommunicationStatus(src.getStatusElement()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference10_50.convertReference(src.getEncounter()));
    if (src.hasSentElement())
      tgt.setSentElement(DateTime10_50.convertDateTime(src.getSentElement()));
    if (src.hasReceivedElement())
      tgt.setReceivedElement(DateTime10_50.convertDateTime(src.getReceivedElement()));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept10_50.convertCodeableConceptToCodableReference(t));
    if (src.hasSubject())
      tgt.setSubject(Reference10_50.convertReference(src.getSubject()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Communication convertCommunication(org.hl7.fhir.r5.model.Communication src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Communication tgt = new org.hl7.fhir.dstu2.model.Communication();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept10_50.convertCodeableConcept(src.getCategoryFirstRep()));
    if (src.hasSender())
      tgt.setSender(Reference10_50.convertReference(src.getSender()));
    for (org.hl7.fhir.r5.model.Reference t : src.getRecipient()) tgt.addRecipient(Reference10_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent t : src.getPayload())
      tgt.addPayload(convertCommunicationPayloadComponent(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getMedium())
      tgt.addMedium(CodeableConcept10_50.convertCodeableConcept(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertCommunicationStatus(src.getStatusElement()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference10_50.convertReference(src.getEncounter()));
    if (src.hasSentElement())
      tgt.setSentElement(DateTime10_50.convertDateTime(src.getSentElement()));
    if (src.hasReceivedElement())
      tgt.setReceivedElement(DateTime10_50.convertDateTime(src.getReceivedElement()));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.addReason(CodeableConcept10_50.convertCodeableConcept(t.getConcept()));
    if (src.hasSubject())
      tgt.setSubject(Reference10_50.convertReference(src.getSubject()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent convertCommunicationPayloadComponent(org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent tgt = new org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasContent())
      tgt.setContent(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getContent()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent convertCommunicationPayloadComponent(org.hl7.fhir.dstu2.model.Communication.CommunicationPayloadComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent tgt = new org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasContent())
      tgt.setContent(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getContent()));
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Communication.CommunicationStatus> convertCommunicationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EventStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Communication.CommunicationStatus> tgt = new Enumeration<>(new Communication.CommunicationStatusEnumFactory());
      ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case INPROGRESS:
                  tgt.setValue(Communication.CommunicationStatus.INPROGRESS);
                  break;
              case COMPLETED:
                  tgt.setValue(Communication.CommunicationStatus.COMPLETED);
                  break;
              case ONHOLD:
                  tgt.setValue(Communication.CommunicationStatus.SUSPENDED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Communication.CommunicationStatus.REJECTED);
                  break;
              case NOTDONE:
                  tgt.setValue(Communication.CommunicationStatus.FAILED);
                  break;
              default:
                  tgt.setValue(Communication.CommunicationStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EventStatus> convertCommunicationStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Communication.CommunicationStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r5.model.Enumeration<Enumerations.EventStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new Enumerations.EventStatusEnumFactory());
      ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case INPROGRESS:
                  tgt.setValue(Enumerations.EventStatus.INPROGRESS);
                  break;
              case COMPLETED:
                  tgt.setValue(Enumerations.EventStatus.COMPLETED);
                  break;
              case SUSPENDED:
                  tgt.setValue(Enumerations.EventStatus.ONHOLD);
                  break;
              case REJECTED:
                  tgt.setValue(Enumerations.EventStatus.ENTEREDINERROR);
                  break;
              case FAILED:
                  tgt.setValue(Enumerations.EventStatus.NOTDONE);
                  break;
              default:
                  tgt.setValue(Enumerations.EventStatus.NULL);
                  break;
          }
      }
      return tgt;
  }
}