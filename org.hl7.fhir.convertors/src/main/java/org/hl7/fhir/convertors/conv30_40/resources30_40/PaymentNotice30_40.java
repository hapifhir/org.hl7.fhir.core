package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Date30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.DateTime30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class PaymentNotice30_40 {

  public static org.hl7.fhir.r4.model.PaymentNotice convertPaymentNotice(org.hl7.fhir.dstu3.model.PaymentNotice src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PaymentNotice tgt = new org.hl7.fhir.r4.model.PaymentNotice();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertPaymentNoticeStatus(src.getStatusElement()));
    if (src.hasRequest())
      tgt.setRequest(Reference30_40.convertReference(src.getRequest()));
    if (src.hasResponse())
      tgt.setResponse(Reference30_40.convertReference(src.getResponse()));
    if (src.hasStatusDate())
      tgt.setPaymentDateElement(Date30_40.convertDate(src.getStatusDateElement()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime30_40.convertDateTime(src.getCreatedElement()));
    if (src.hasTarget())
      tgt.setRecipient(Reference30_40.convertReference(src.getTarget()));
    if (src.hasProvider())
      tgt.setProvider(Reference30_40.convertReference(src.getProvider()));
    if (src.hasPaymentStatus())
      tgt.setPaymentStatus(CodeableConcept30_40.convertCodeableConcept(src.getPaymentStatus()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.PaymentNotice convertPaymentNotice(org.hl7.fhir.r4.model.PaymentNotice src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.PaymentNotice tgt = new org.hl7.fhir.dstu3.model.PaymentNotice();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertPaymentNoticeStatus(src.getStatusElement()));
    if (src.hasRequest())
      tgt.setRequest(Reference30_40.convertReference(src.getRequest()));
    if (src.hasResponse())
      tgt.setResponse(Reference30_40.convertReference(src.getResponse()));
    if (src.hasPaymentDate())
      tgt.setStatusDateElement(Date30_40.convertDate(src.getPaymentDateElement()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime30_40.convertDateTime(src.getCreatedElement()));
    if (src.hasRecipient())
      tgt.setTarget(Reference30_40.convertReference(src.getRecipient()));
    if (src.hasProvider())
      tgt.setProvider(Reference30_40.convertReference(src.getProvider()));
    if (src.hasPaymentStatus())
      tgt.setPaymentStatus(CodeableConcept30_40.convertCodeableConcept(src.getPaymentStatus()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PaymentNotice.PaymentNoticeStatus> convertPaymentNoticeStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PaymentNotice.PaymentNoticeStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.PaymentNotice.PaymentNoticeStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4.model.PaymentNotice.PaymentNoticeStatus.ACTIVE);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4.model.PaymentNotice.PaymentNoticeStatus.CANCELLED);
        break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r4.model.PaymentNotice.PaymentNoticeStatus.DRAFT);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.PaymentNotice.PaymentNoticeStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.PaymentNotice.PaymentNoticeStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus> convertPaymentNoticeStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PaymentNotice.PaymentNoticeStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus.ACTIVE);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus.CANCELLED);
        break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus.DRAFT);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus.NULL);
        break;
    }
    return tgt;
  }
}