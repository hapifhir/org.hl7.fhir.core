package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.DateTime10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class ProcedureRequest10_30 {

  public static org.hl7.fhir.dstu3.model.ProcedureRequest convertProcedureRequest(org.hl7.fhir.dstu2.model.ProcedureRequest src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ProcedureRequest tgt = new org.hl7.fhir.dstu3.model.ProcedureRequest();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasSubject())
      tgt.setSubject(Reference10_30.convertReference(src.getSubject()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_30.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(CodeableConcept10_30.convertCodeableConcept(t));
    if (src.hasReasonCodeableConcept())
      tgt.addReasonCode(CodeableConcept10_30.convertCodeableConcept(src.getReasonCodeableConcept()));
    if (src.hasScheduled())
      tgt.setOccurrence(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getScheduled()));
    if (src.hasEncounter())
      tgt.setContext(Reference10_30.convertReference(src.getEncounter()));
    if (src.hasPerformer())
      tgt.setPerformer(Reference10_30.convertReference(src.getPerformer()));
    if (src.hasStatus())
      tgt.setStatusElement(convertProcedureRequestStatus(src.getStatusElement()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getAsNeeded()));
    if (src.hasOrderedOnElement())
      tgt.setAuthoredOnElement(DateTime10_30.convertDateTime(src.getOrderedOnElement()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertProcedureRequestPriority(src.getPriorityElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ProcedureRequest convertProcedureRequest(org.hl7.fhir.dstu3.model.ProcedureRequest src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ProcedureRequest tgt = new org.hl7.fhir.dstu2.model.ProcedureRequest();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasSubject())
      tgt.setSubject(Reference10_30.convertReference(src.getSubject()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_30.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(CodeableConcept10_30.convertCodeableConcept(t));
    if (src.hasReasonCode())
      tgt.setReason(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getReasonCodeFirstRep()));
    if (src.hasOccurrence())
      tgt.setScheduled(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getOccurrence()));
    if (src.hasContext())
      tgt.setEncounter(Reference10_30.convertReference(src.getContext()));
    if (src.hasPerformer())
      tgt.setPerformer(Reference10_30.convertReference(src.getPerformer()));
    if (src.hasStatus())
      tgt.setStatusElement(convertProcedureRequestStatus(src.getStatusElement()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getAsNeeded()));
    if (src.hasAuthoredOnElement())
      tgt.setOrderedOnElement(DateTime10_30.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertProcedureRequestPriority(src.getPriorityElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority> convertProcedureRequestPriority(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestPriority> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriorityEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case ROUTINE:
        tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority.ROUTINE);
        break;
      case URGENT:
        tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority.URGENT);
        break;
      case STAT:
        tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority.STAT);
        break;
      case ASAP:
        tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority.ASAP);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestPriority> convertProcedureRequestPriority(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestPriority> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestPriorityEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case ROUTINE:
        tgt.setValue(org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestPriority.ROUTINE);
        break;
      case URGENT:
        tgt.setValue(org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestPriority.URGENT);
        break;
      case STAT:
        tgt.setValue(org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestPriority.STAT);
        break;
      case ASAP:
        tgt.setValue(org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestPriority.ASAP);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestPriority.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestStatus> convertProcedureRequestStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestStatusEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestStatus.DRAFT);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestStatus.INPROGRESS);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestStatus.COMPLETED);
        break;
      case SUSPENDED:
        tgt.setValue(org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestStatus.SUSPENDED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestStatus.ABORTED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus> convertProcedureRequestStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ProcedureRequest.ProcedureRequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatusEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROPOSED:
        tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.DRAFT);
        break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.DRAFT);
        break;
      case REQUESTED:
        tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.ACTIVE);
        break;
      case RECEIVED:
        tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.ACTIVE);
        break;
      case ACCEPTED:
        tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.ACTIVE);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.ACTIVE);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.COMPLETED);
        break;
      case SUSPENDED:
        tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.SUSPENDED);
        break;
      case ABORTED:
        tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus.NULL);
        break;
    }
    return tgt;
  }
}