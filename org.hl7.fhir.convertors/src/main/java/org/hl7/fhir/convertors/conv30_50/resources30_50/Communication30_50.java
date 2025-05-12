package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Annotation30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.DateTime30_50;
import org.hl7.fhir.dstu3.model.Communication;
import org.hl7.fhir.dstu3.model.Enumeration;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.Enumerations;

public class Communication30_50 {

  public static org.hl7.fhir.dstu3.model.Communication convertCommunication(org.hl7.fhir.r5.model.Communication src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Communication tgt = new org.hl7.fhir.dstu3.model.Communication();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesCanonical())
      tgt.addDefinition(new org.hl7.fhir.dstu3.model.Reference(t.getValue()));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference30_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference30_50.convertReference(t));
    if (src.hasStatus())
      if (src.getStatus() == org.hl7.fhir.r5.model.Enumerations.EventStatus.NOTDONE)
        tgt.setNotDone(true);
      else
        tgt.setStatusElement(convertCommunicationStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setNotDoneReason(CodeableConcept30_50.convertCodeableConcept(src.getStatusReason()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getMedium())
      tgt.addMedium(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    for (org.hl7.fhir.r5.model.Reference t : src.getRecipient()) tgt.addRecipient(Reference30_50.convertReference(t));
    if (src.hasEncounter())
      tgt.setContext(Reference30_50.convertReference(src.getEncounter()));
    if (src.hasSent())
      tgt.setSentElement(DateTime30_50.convertDateTime(src.getSentElement()));
    if (src.hasReceived())
      tgt.setReceivedElement(DateTime30_50.convertDateTime(src.getReceivedElement()));
    if (src.hasSender())
      tgt.setSender(Reference30_50.convertReference(src.getSender()));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept30_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReason())
      if (t.hasReference())
        tgt.addReasonReference(Reference30_50.convertReference(t.getReference()));
    for (org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent t : src.getPayload())
      tgt.addPayload(convertCommunicationPayloadComponent(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Communication convertCommunication(org.hl7.fhir.dstu3.model.Communication src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Communication tgt = new org.hl7.fhir.r5.model.Communication();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getDefinition()) tgt.addInstantiatesCanonical(t.getReference());
    for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference30_50.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference30_50.convertReference(t));
    if (src.hasNotDone())
      tgt.setStatus(org.hl7.fhir.r5.model.Enumerations.EventStatus.NOTDONE);
    else if (src.hasStatus())
      tgt.setStatusElement(convertCommunicationStatus(src.getStatusElement()));
    if (src.hasNotDoneReason())
      tgt.setStatusReason(CodeableConcept30_50.convertCodeableConcept(src.getNotDoneReason()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getMedium())
      tgt.addMedium(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getRecipient())
      tgt.addRecipient(Reference30_50.convertReference(t));
    if (src.hasContext())
      tgt.setEncounter(Reference30_50.convertReference(src.getContext()));
    if (src.hasSent())
      tgt.setSentElement(DateTime30_50.convertDateTime(src.getSentElement()));
    if (src.hasReceived())
      tgt.setReceivedElement(DateTime30_50.convertDateTime(src.getReceivedElement()));
    if (src.hasSender())
      tgt.setSender(Reference30_50.convertReference(src.getSender()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(Reference30_50.convertCodeableConceptToCodableReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference30_50.convertReferenceToCodableReference(t));
    for (org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent t : src.getPayload())
      tgt.addPayload(convertCommunicationPayloadComponent(t));
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent convertCommunicationPayloadComponent(org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent tgt = new org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasContent())
      tgt.setContent(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getContent()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent convertCommunicationPayloadComponent(org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent tgt = new org.hl7.fhir.r5.model.Communication.CommunicationPayloadComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasContent())
      tgt.setContent(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getContent()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Communication.CommunicationStatus> convertCommunicationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EventStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Communication.CommunicationStatus> tgt = new Enumeration<>(new Communication.CommunicationStatusEnumFactory());
      ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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
              case ONHOLD:
                  tgt.setValue(Communication.CommunicationStatus.SUSPENDED);
                  break;
              case STOPPED:
                  tgt.setValue(Communication.CommunicationStatus.ABORTED);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EventStatus> convertCommunicationStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Communication.CommunicationStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r5.model.Enumeration<Enumerations.EventStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new Enumerations.EventStatusEnumFactory());
      ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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
              case SUSPENDED:
                  tgt.setValue(Enumerations.EventStatus.ONHOLD);
                  break;
              case ABORTED:
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
}