package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.conv10_30.VersionConvertor_10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Period10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.dstu2.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.ReferralRequest.ReferralPriority;
import org.hl7.fhir.exceptions.FHIRException;

public class ReferralRequest10_30 {

  static public org.hl7.fhir.dstu2.model.CodeableConcept convertReferralPriorityCode(org.hl7.fhir.dstu3.model.ReferralRequest.ReferralPriority priority) {
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

  static public ReferralPriority convertReferralPriorityCode(CodeableConcept priority) {
    for (org.hl7.fhir.dstu2.model.Coding c : priority.getCoding()) {
      if ("http://hl7.org/fhir/diagnostic-order-priority".equals(c.getSystem()) && "routine".equals(c.getCode()))
        return org.hl7.fhir.dstu3.model.ReferralRequest.ReferralPriority.ROUTINE;
      if ("http://hl7.org/fhir/diagnostic-order-priority".equals(c.getSystem()) && "urgent".equals(c.getCode()))
        return org.hl7.fhir.dstu3.model.ReferralRequest.ReferralPriority.URGENT;
      if ("http://hl7.org/fhir/diagnostic-order-priority".equals(c.getSystem()) && "stat".equals(c.getCode()))
        return org.hl7.fhir.dstu3.model.ReferralRequest.ReferralPriority.STAT;
      if ("http://hl7.org/fhir/diagnostic-order-priority".equals(c.getSystem()) && "asap".equals(c.getCode()))
        return org.hl7.fhir.dstu3.model.ReferralRequest.ReferralPriority.ASAP;
    }
    return null;
  }

  public static org.hl7.fhir.dstu2.model.ReferralRequest convertReferralRequest(org.hl7.fhir.dstu3.model.ReferralRequest src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ReferralRequest tgt = new org.hl7.fhir.dstu2.model.ReferralRequest();
    VersionConvertor_10_30.copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertReferralStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
    if (src.hasPriority())
      tgt.setPriority(convertReferralPriorityCode(src.getPriority()));
    if (src.hasSubject())
      tgt.setPatient(Reference10_30.convertReference(src.getSubject()));
    if (src.hasOccurrencePeriod())
      tgt.setFulfillmentTime(Period10_30.convertPeriod(src.getOccurrencePeriod()));
    tgt.setRequester(Reference10_30.convertReference(src.getRequester().getAgent()));
    if (src.hasSpecialty())
      tgt.setSpecialty(CodeableConcept10_30.convertCodeableConcept(src.getSpecialty()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getRecipient())
      tgt.addRecipient(Reference10_30.convertReference(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept cc : src.getReasonCode())
      tgt.setReason(CodeableConcept10_30.convertCodeableConcept(cc));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getServiceRequested())
      tgt.addServiceRequested(CodeableConcept10_30.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getSupportingInfo())
      tgt.addSupportingInformation(Reference10_30.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ReferralRequest convertReferralRequest(org.hl7.fhir.dstu2.model.ReferralRequest src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ReferralRequest tgt = new org.hl7.fhir.dstu3.model.ReferralRequest();
    VersionConvertor_10_30.copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertReferralStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
    if (src.hasPriority())
      tgt.setPriority(convertReferralPriorityCode(src.getPriority()));
    if (src.hasPatient())
      tgt.setSubject(Reference10_30.convertReference(src.getPatient()));
    if (src.hasFulfillmentTime())
      tgt.setOccurrence(Period10_30.convertPeriod(src.getFulfillmentTime()));
    tgt.getRequester().setAgent(Reference10_30.convertReference(src.getRequester()));
    if (src.hasSpecialty())
      tgt.setSpecialty(CodeableConcept10_30.convertCodeableConcept(src.getSpecialty()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getRecipient())
      tgt.addRecipient(Reference10_30.convertReference(t));
    if (src.hasReason())
      tgt.addReasonCode(CodeableConcept10_30.convertCodeableConcept(src.getReason()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getServiceRequested())
      tgt.addServiceRequested(CodeableConcept10_30.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInfo(Reference10_30.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ReferralRequest.ReferralStatus> convertReferralStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ReferralRequest.ReferralRequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ReferralRequest.ReferralStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ReferralRequest.ReferralStatusEnumFactory());
    Element10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.dstu2.model.ReferralRequest.ReferralStatus.DRAFT);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu2.model.ReferralRequest.ReferralStatus.ACTIVE);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.dstu2.model.ReferralRequest.ReferralStatus.CANCELLED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu2.model.ReferralRequest.ReferralStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu2.model.ReferralRequest.ReferralStatus.REJECTED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.ReferralRequest.ReferralStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ReferralRequest.ReferralRequestStatus> convertReferralStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ReferralRequest.ReferralStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ReferralRequest.ReferralRequestStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ReferralRequest.ReferralRequestStatusEnumFactory());
    Element10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.dstu3.model.ReferralRequest.ReferralRequestStatus.DRAFT);
        break;
      case REQUESTED:
        tgt.setValue(org.hl7.fhir.dstu3.model.ReferralRequest.ReferralRequestStatus.DRAFT);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.ReferralRequest.ReferralRequestStatus.ACTIVE);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.dstu3.model.ReferralRequest.ReferralRequestStatus.CANCELLED);
        break;
      case ACCEPTED:
        tgt.setValue(org.hl7.fhir.dstu3.model.ReferralRequest.ReferralRequestStatus.ACTIVE);
        break;
      case REJECTED:
        tgt.setValue(org.hl7.fhir.dstu3.model.ReferralRequest.ReferralRequestStatus.ENTEREDINERROR);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu3.model.ReferralRequest.ReferralRequestStatus.COMPLETED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.ReferralRequest.ReferralRequestStatus.NULL);
        break;
    }
    return tgt;
  }
}