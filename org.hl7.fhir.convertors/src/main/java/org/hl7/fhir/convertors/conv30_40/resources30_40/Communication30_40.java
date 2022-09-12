package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Annotation30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.DateTime30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Communication30_40 {

  public static org.hl7.fhir.dstu3.model.Communication convertCommunication(org.hl7.fhir.r4.model.Communication src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Communication tgt = new org.hl7.fhir.dstu3.model.Communication();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.UriType t : src.getInstantiatesCanonical())
      tgt.addDefinition(new org.hl7.fhir.dstu3.model.Reference(t.getValue()));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference30_40.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference30_40.convertReference(t));
    if (src.hasStatus())
      if (src.getStatus() == org.hl7.fhir.r4.model.Communication.CommunicationStatus.NOTDONE)
        tgt.setNotDone(true);
      else
        tgt.setStatusElement(convertCommunicationStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setNotDoneReason(CodeableConcept30_40.convertCodeableConcept(src.getStatusReason()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getMedium())
      tgt.addMedium(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
    for (org.hl7.fhir.r4.model.Reference t : src.getRecipient()) tgt.addRecipient(Reference30_40.convertReference(t));
    if (src.hasEncounter())
      tgt.setContext(Reference30_40.convertReference(src.getEncounter()));
    if (src.hasSent())
      tgt.setSentElement(DateTime30_40.convertDateTime(src.getSentElement()));
    if (src.hasReceived())
      tgt.setReceivedElement(DateTime30_40.convertDateTime(src.getReceivedElement()));
    if (src.hasSender())
      tgt.setSender(Reference30_40.convertReference(src.getSender()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(Reference30_40.convertReference(t));
    for (org.hl7.fhir.r4.model.Communication.CommunicationPayloadComponent t : src.getPayload())
      tgt.addPayload(convertCommunicationPayloadComponent(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_40.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Communication convertCommunication(org.hl7.fhir.dstu3.model.Communication src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Communication tgt = new org.hl7.fhir.r4.model.Communication();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getDefinition()) tgt.addInstantiatesCanonical(t.getReference());
    for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference30_40.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference30_40.convertReference(t));
    if (src.hasNotDone())
      tgt.setStatus(org.hl7.fhir.r4.model.Communication.CommunicationStatus.NOTDONE);
    else if (src.hasStatus())
      tgt.setStatusElement(convertCommunicationStatus(src.getStatusElement()));
    if (src.hasNotDoneReason())
      tgt.setStatusReason(CodeableConcept30_40.convertCodeableConcept(src.getNotDoneReason()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getMedium())
      tgt.addMedium(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getRecipient())
      tgt.addRecipient(Reference30_40.convertReference(t));
    if (src.hasContext())
      tgt.setEncounter(Reference30_40.convertReference(src.getContext()));
    if (src.hasSent())
      tgt.setSentElement(DateTime30_40.convertDateTime(src.getSentElement()));
    if (src.hasReceived())
      tgt.setReceivedElement(DateTime30_40.convertDateTime(src.getReceivedElement()));
    if (src.hasSender())
      tgt.setSender(Reference30_40.convertReference(src.getSender()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(Reference30_40.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent t : src.getPayload())
      tgt.addPayload(convertCommunicationPayloadComponent(t));
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_40.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent convertCommunicationPayloadComponent(org.hl7.fhir.r4.model.Communication.CommunicationPayloadComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent tgt = new org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasContent())
      tgt.setContent(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getContent()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Communication.CommunicationPayloadComponent convertCommunicationPayloadComponent(org.hl7.fhir.dstu3.model.Communication.CommunicationPayloadComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Communication.CommunicationPayloadComponent tgt = new org.hl7.fhir.r4.model.Communication.CommunicationPayloadComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasContent())
      tgt.setContent(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getContent()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Communication.CommunicationStatus> convertCommunicationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Communication.CommunicationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Communication.CommunicationStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Communication.CommunicationStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case PREPARATION:
        tgt.setValue(org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.PREPARATION);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.INPROGRESS);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.SUSPENDED);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.ABORTED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Communication.CommunicationStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Communication.CommunicationStatus> convertCommunicationStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Communication.CommunicationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Communication.CommunicationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Communication.CommunicationStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case PREPARATION:
        tgt.setValue(org.hl7.fhir.r4.model.Communication.CommunicationStatus.PREPARATION);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r4.model.Communication.CommunicationStatus.INPROGRESS);
        break;
      case SUSPENDED:
        tgt.setValue(org.hl7.fhir.r4.model.Communication.CommunicationStatus.ONHOLD);
        break;
      case ABORTED:
        tgt.setValue(org.hl7.fhir.r4.model.Communication.CommunicationStatus.STOPPED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4.model.Communication.CommunicationStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.Communication.CommunicationStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4.model.Communication.CommunicationStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Communication.CommunicationStatus.NULL);
        break;
    }
    return tgt;
  }
}