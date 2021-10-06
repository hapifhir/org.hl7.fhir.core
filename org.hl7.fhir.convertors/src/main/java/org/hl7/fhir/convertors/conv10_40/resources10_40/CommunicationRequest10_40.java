package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.context.ConversionContext10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.CodeableConcept10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Identifier10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.DateTime10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class CommunicationRequest10_40 {

  public static org.hl7.fhir.dstu2.model.CommunicationRequest convertCommunicationRequest(org.hl7.fhir.r4.model.CommunicationRequest src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.CommunicationRequest tgt = new org.hl7.fhir.dstu2.model.CommunicationRequest();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept10_40.convertCodeableConcept(src.getCategoryFirstRep()));
    if (src.hasSender())
      tgt.setSender(Reference10_40.convertReference(src.getSender()));
    for (org.hl7.fhir.r4.model.Reference t : src.getRecipient()) tgt.addRecipient(Reference10_40.convertReference(t));
    for (org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent t : src.getPayload())
      tgt.addPayload(convertCommunicationRequestPayloadComponent(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getMedium())
      tgt.addMedium(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasRequester())
      tgt.setRequester(Reference10_40.convertReference(src.getRequester()));
    if (src.hasStatus())
      tgt.setStatusElement(convertCommunicationRequestStatus(src.getStatusElement()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference10_40.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setScheduled(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getOccurrence()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasAuthoredOnElement())
      tgt.setRequestedOnElement(DateTime10_40.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference10_40.convertReference(src.getSubject()));
    if (src.hasPriority())
      tgt.setPriority(convertPriorityCode(src.getPriority()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CommunicationRequest convertCommunicationRequest(org.hl7.fhir.dstu2.model.CommunicationRequest src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.CommunicationRequest tgt = new org.hl7.fhir.r4.model.CommunicationRequest();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasCategory())
      tgt.addCategory(CodeableConcept10_40.convertCodeableConcept(src.getCategory()));
    if (src.hasSender())
      tgt.setSender(Reference10_40.convertReference(src.getSender()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getRecipient())
      tgt.addRecipient(Reference10_40.convertReference(t));
    for (org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestPayloadComponent t : src.getPayload())
      tgt.addPayload(convertCommunicationRequestPayloadComponent(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getMedium())
      tgt.addMedium(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasRequester())
      tgt.setRequester(Reference10_40.convertReference(src.getRequester()));
    if (src.hasStatus())
      tgt.setStatusElement(convertCommunicationRequestStatus(src.getStatusElement()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference10_40.convertReference(src.getEncounter()));
    if (src.hasScheduled())
      tgt.setOccurrence(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getScheduled()));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReason())
      tgt.addReasonCode(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasRequestedOnElement())
      tgt.setAuthoredOnElement(DateTime10_40.convertDateTime(src.getRequestedOnElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference10_40.convertReference(src.getSubject()));
    if (src.hasPriority())
      tgt.setPriority(convertPriorityCode(src.getPriority()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent convertCommunicationRequestPayloadComponent(org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestPayloadComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent tgt = new org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasContent())
      tgt.setContent(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getContent()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestPayloadComponent convertCommunicationRequestPayloadComponent(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestPayloadComponent tgt = new org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestPayloadComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasContent())
      tgt.setContent(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getContent()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus> convertCommunicationRequestStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatusEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROPOSED:
        tgt.setValue(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.DRAFT);
        break;
      case PLANNED:
        tgt.setValue(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.ACTIVE);
        break;
      case REQUESTED:
        tgt.setValue(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.ACTIVE);
        break;
      case RECEIVED:
        tgt.setValue(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.ACTIVE);
        break;
      case ACCEPTED:
        tgt.setValue(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.ACTIVE);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.ACTIVE);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.COMPLETED);
        break;
      case SUSPENDED:
        tgt.setValue(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.ONHOLD);
        break;
      case REJECTED:
        tgt.setValue(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus> convertCommunicationRequestStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatusEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus.PROPOSED);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus.INPROGRESS);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus.COMPLETED);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus.SUSPENDED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus.REJECTED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.CommunicationRequest.CommunicationRequestStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.CodeableConcept convertPriorityCode(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationPriority priority) {
    org.hl7.fhir.dstu2.model.CodeableConcept cc = new org.hl7.fhir.dstu2.model.CodeableConcept();
    switch (priority) {
      case ROUTINE:
        cc.addCoding().setSystem("http://hl7.org/fhir/diagnostic-order-priority").setCode("routine");
        break;
      case URGENT:
        cc.addCoding().setSystem("http://hl7.org/fhir/diagnostic-order-priority").setCode("urgent");
        break;
      case STAT:
        cc.addCoding().setSystem("http://hl7.org/fhir/diagnostic-order-priority").setCode("stat");
        break;
      case ASAP:
        cc.addCoding().setSystem("http://hl7.org/fhir/diagnostic-order-priority").setCode("asap");
        break;
      default:
        return null;
    }
    return cc;
  }

  static public org.hl7.fhir.r4.model.CommunicationRequest.CommunicationPriority convertPriorityCode(org.hl7.fhir.dstu2.model.CodeableConcept priority) {
    for (org.hl7.fhir.dstu2.model.Coding c : priority.getCoding()) {
      if ("http://hl7.org/fhir/diagnostic-order-priority".equals(c.getSystem()) && "routine".equals(c.getCode()))
        return org.hl7.fhir.r4.model.CommunicationRequest.CommunicationPriority.ROUTINE;
      if ("http://hl7.org/fhir/diagnostic-order-priority".equals(c.getSystem()) && "urgent".equals(c.getCode()))
        return org.hl7.fhir.r4.model.CommunicationRequest.CommunicationPriority.URGENT;
      if ("http://hl7.org/fhir/diagnostic-order-priority".equals(c.getSystem()) && "stat".equals(c.getCode()))
        return org.hl7.fhir.r4.model.CommunicationRequest.CommunicationPriority.STAT;
      if ("http://hl7.org/fhir/diagnostic-order-priority".equals(c.getSystem()) && "asap".equals(c.getCode()))
        return org.hl7.fhir.r4.model.CommunicationRequest.CommunicationPriority.ASAP;
    }
    return null;
  }
}