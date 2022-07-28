package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Annotation43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Money43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.*;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/
// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0
public class Invoice43_50 {

  public static org.hl7.fhir.r5.model.Invoice convertInvoice(org.hl7.fhir.r4b.model.Invoice src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Invoice tgt = new org.hl7.fhir.r5.model.Invoice();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertInvoiceStatus(src.getStatusElement()));
    if (src.hasCancelledReason())
      tgt.setCancelledReasonElement(String43_50.convertString(src.getCancelledReasonElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasRecipient())
      tgt.setRecipient(Reference43_50.convertReference(src.getRecipient()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    for (org.hl7.fhir.r4b.model.Invoice.InvoiceParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertInvoiceParticipantComponent(t));
    if (src.hasIssuer())
      tgt.setIssuer(Reference43_50.convertReference(src.getIssuer()));
    if (src.hasAccount())
      tgt.setAccount(Reference43_50.convertReference(src.getAccount()));
    for (org.hl7.fhir.r4b.model.Invoice.InvoiceLineItemComponent t : src.getLineItem())
      tgt.addLineItem(convertInvoiceLineItemComponent(t));
    for (org.hl7.fhir.r4b.model.Invoice.InvoiceLineItemPriceComponentComponent t : src.getTotalPriceComponent())
      tgt.addTotalPriceComponent(convertInvoiceLineItemPriceComponentComponent(t));
    if (src.hasTotalNet())
      tgt.setTotalNet(Money43_50.convertMoney(src.getTotalNet()));
    if (src.hasTotalGross())
      tgt.setTotalGross(Money43_50.convertMoney(src.getTotalGross()));
    if (src.hasPaymentTerms())
      tgt.setPaymentTermsElement(MarkDown43_50.convertMarkdown(src.getPaymentTermsElement()));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Invoice convertInvoice(org.hl7.fhir.r5.model.Invoice src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Invoice tgt = new org.hl7.fhir.r4b.model.Invoice();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertInvoiceStatus(src.getStatusElement()));
    if (src.hasCancelledReason())
      tgt.setCancelledReasonElement(String43_50.convertString(src.getCancelledReasonElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasRecipient())
      tgt.setRecipient(Reference43_50.convertReference(src.getRecipient()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    for (org.hl7.fhir.r5.model.Invoice.InvoiceParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertInvoiceParticipantComponent(t));
    if (src.hasIssuer())
      tgt.setIssuer(Reference43_50.convertReference(src.getIssuer()));
    if (src.hasAccount())
      tgt.setAccount(Reference43_50.convertReference(src.getAccount()));
    for (org.hl7.fhir.r5.model.Invoice.InvoiceLineItemComponent t : src.getLineItem())
      tgt.addLineItem(convertInvoiceLineItemComponent(t));
    for (org.hl7.fhir.r5.model.Invoice.InvoiceLineItemPriceComponentComponent t : src.getTotalPriceComponent())
      tgt.addTotalPriceComponent(convertInvoiceLineItemPriceComponentComponent(t));
    if (src.hasTotalNet())
      tgt.setTotalNet(Money43_50.convertMoney(src.getTotalNet()));
    if (src.hasTotalGross())
      tgt.setTotalGross(Money43_50.convertMoney(src.getTotalGross()));
    if (src.hasPaymentTerms())
      tgt.setPaymentTermsElement(MarkDown43_50.convertMarkdown(src.getPaymentTermsElement()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Invoice.InvoiceStatus> convertInvoiceStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Invoice.InvoiceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Invoice.InvoiceStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Invoice.InvoiceStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r5.model.Invoice.InvoiceStatus.DRAFT);
        break;
      case ISSUED:
        tgt.setValue(org.hl7.fhir.r5.model.Invoice.InvoiceStatus.ISSUED);
        break;
      case BALANCED:
        tgt.setValue(org.hl7.fhir.r5.model.Invoice.InvoiceStatus.BALANCED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r5.model.Invoice.InvoiceStatus.CANCELLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Invoice.InvoiceStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Invoice.InvoiceStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Invoice.InvoiceStatus> convertInvoiceStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Invoice.InvoiceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Invoice.InvoiceStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Invoice.InvoiceStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r4b.model.Invoice.InvoiceStatus.DRAFT);
        break;
      case ISSUED:
        tgt.setValue(org.hl7.fhir.r4b.model.Invoice.InvoiceStatus.ISSUED);
        break;
      case BALANCED:
        tgt.setValue(org.hl7.fhir.r4b.model.Invoice.InvoiceStatus.BALANCED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4b.model.Invoice.InvoiceStatus.CANCELLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Invoice.InvoiceStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Invoice.InvoiceStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Invoice.InvoiceParticipantComponent convertInvoiceParticipantComponent(org.hl7.fhir.r4b.model.Invoice.InvoiceParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Invoice.InvoiceParticipantComponent tgt = new org.hl7.fhir.r5.model.Invoice.InvoiceParticipantComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasRole())
      tgt.setRole(CodeableConcept43_50.convertCodeableConcept(src.getRole()));
    if (src.hasActor())
      tgt.setActor(Reference43_50.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Invoice.InvoiceParticipantComponent convertInvoiceParticipantComponent(org.hl7.fhir.r5.model.Invoice.InvoiceParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Invoice.InvoiceParticipantComponent tgt = new org.hl7.fhir.r4b.model.Invoice.InvoiceParticipantComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasRole())
      tgt.setRole(CodeableConcept43_50.convertCodeableConcept(src.getRole()));
    if (src.hasActor())
      tgt.setActor(Reference43_50.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Invoice.InvoiceLineItemComponent convertInvoiceLineItemComponent(org.hl7.fhir.r4b.model.Invoice.InvoiceLineItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Invoice.InvoiceLineItemComponent tgt = new org.hl7.fhir.r5.model.Invoice.InvoiceLineItemComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSequenceElement()));
    if (src.hasChargeItem())
      tgt.setChargeItem(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getChargeItem()));
    for (org.hl7.fhir.r4b.model.Invoice.InvoiceLineItemPriceComponentComponent t : src.getPriceComponent())
      tgt.addPriceComponent(convertInvoiceLineItemPriceComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Invoice.InvoiceLineItemComponent convertInvoiceLineItemComponent(org.hl7.fhir.r5.model.Invoice.InvoiceLineItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Invoice.InvoiceLineItemComponent tgt = new org.hl7.fhir.r4b.model.Invoice.InvoiceLineItemComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSequenceElement()));
    if (src.hasChargeItem())
      tgt.setChargeItem(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getChargeItem()));
    for (org.hl7.fhir.r5.model.Invoice.InvoiceLineItemPriceComponentComponent t : src.getPriceComponent())
      tgt.addPriceComponent(convertInvoiceLineItemPriceComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Invoice.InvoiceLineItemPriceComponentComponent convertInvoiceLineItemPriceComponentComponent(org.hl7.fhir.r4b.model.Invoice.InvoiceLineItemPriceComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Invoice.InvoiceLineItemPriceComponentComponent tgt = new org.hl7.fhir.r5.model.Invoice.InvoiceLineItemPriceComponentComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertInvoicePriceComponentType(src.getTypeElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_50.convertDecimal(src.getFactorElement()));
    if (src.hasAmount())
      tgt.setAmount(Money43_50.convertMoney(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Invoice.InvoiceLineItemPriceComponentComponent convertInvoiceLineItemPriceComponentComponent(org.hl7.fhir.r5.model.Invoice.InvoiceLineItemPriceComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Invoice.InvoiceLineItemPriceComponentComponent tgt = new org.hl7.fhir.r4b.model.Invoice.InvoiceLineItemPriceComponentComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertInvoicePriceComponentType(src.getTypeElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_50.convertDecimal(src.getFactorElement()));
    if (src.hasAmount())
      tgt.setAmount(Money43_50.convertMoney(src.getAmount()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.InvoicePriceComponentType> convertInvoicePriceComponentType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.InvoicePriceComponentType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.InvoicePriceComponentType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.InvoicePriceComponentTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case BASE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.InvoicePriceComponentType.BASE);
        break;
      case SURCHARGE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.InvoicePriceComponentType.SURCHARGE);
        break;
      case DEDUCTION:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.InvoicePriceComponentType.DEDUCTION);
        break;
      case DISCOUNT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.InvoicePriceComponentType.DISCOUNT);
        break;
      case TAX:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.InvoicePriceComponentType.TAX);
        break;
      case INFORMATIONAL:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.InvoicePriceComponentType.INFORMATIONAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.InvoicePriceComponentType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.InvoicePriceComponentType> convertInvoicePriceComponentType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.InvoicePriceComponentType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.InvoicePriceComponentType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.InvoicePriceComponentTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case BASE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.InvoicePriceComponentType.BASE);
        break;
      case SURCHARGE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.InvoicePriceComponentType.SURCHARGE);
        break;
      case DEDUCTION:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.InvoicePriceComponentType.DEDUCTION);
        break;
      case DISCOUNT:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.InvoicePriceComponentType.DISCOUNT);
        break;
      case TAX:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.InvoicePriceComponentType.TAX);
        break;
      case INFORMATIONAL:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.InvoicePriceComponentType.INFORMATIONAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.InvoicePriceComponentType.NULL);
        break;
    }
    return tgt;
  }
}