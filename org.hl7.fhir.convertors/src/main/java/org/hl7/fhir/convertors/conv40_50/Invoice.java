package org.hl7.fhir.convertors.conv40_50;

import org.hl7.fhir.exceptions.FHIRException;

import org.hl7.fhir.convertors.VersionConvertor_40_50;


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


public class Invoice extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.Invoice convertInvoice(org.hl7.fhir.r4.model.Invoice src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Invoice tgt = new org.hl7.fhir.r5.model.Invoice();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertInvoiceStatus(src.getStatus()));
    if (src.hasCancelledReason())
      tgt.setCancelledReasonElement(convertString(src.getCancelledReasonElement()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    if (src.hasRecipient())
      tgt.setRecipient(convertReference(src.getRecipient()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    for (org.hl7.fhir.r4.model.Invoice.InvoiceParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertInvoiceParticipantComponent(t));
    if (src.hasIssuer())
      tgt.setIssuer(convertReference(src.getIssuer()));
    if (src.hasAccount())
      tgt.setAccount(convertReference(src.getAccount()));
    for (org.hl7.fhir.r4.model.Invoice.InvoiceLineItemComponent t : src.getLineItem())
      tgt.addLineItem(convertInvoiceLineItemComponent(t));
    for (org.hl7.fhir.r4.model.Invoice.InvoiceLineItemPriceComponentComponent t : src.getTotalPriceComponent())
      tgt.addTotalPriceComponent(convertInvoiceLineItemPriceComponentComponent(t));
    if (src.hasTotalNet())
      tgt.setTotalNet(convertMoney(src.getTotalNet()));
    if (src.hasTotalGross())
      tgt.setTotalGross(convertMoney(src.getTotalGross()));
    if (src.hasPaymentTerms())
      tgt.setPaymentTermsElement(convertMarkdown(src.getPaymentTermsElement()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Invoice convertInvoice(org.hl7.fhir.r5.model.Invoice src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Invoice tgt = new org.hl7.fhir.r4.model.Invoice();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertInvoiceStatus(src.getStatus()));
    if (src.hasCancelledReason())
      tgt.setCancelledReasonElement(convertString(src.getCancelledReasonElement()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    if (src.hasRecipient())
      tgt.setRecipient(convertReference(src.getRecipient()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    for (org.hl7.fhir.r5.model.Invoice.InvoiceParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertInvoiceParticipantComponent(t));
    if (src.hasIssuer())
      tgt.setIssuer(convertReference(src.getIssuer()));
    if (src.hasAccount())
      tgt.setAccount(convertReference(src.getAccount()));
    for (org.hl7.fhir.r5.model.Invoice.InvoiceLineItemComponent t : src.getLineItem())
      tgt.addLineItem(convertInvoiceLineItemComponent(t));
    for (org.hl7.fhir.r5.model.Invoice.InvoiceLineItemPriceComponentComponent t : src.getTotalPriceComponent())
      tgt.addTotalPriceComponent(convertInvoiceLineItemPriceComponentComponent(t));
    if (src.hasTotalNet())
      tgt.setTotalNet(convertMoney(src.getTotalNet()));
    if (src.hasTotalGross())
      tgt.setTotalGross(convertMoney(src.getTotalGross()));
    if (src.hasPaymentTerms())
      tgt.setPaymentTermsElement(convertMarkdown(src.getPaymentTermsElement()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Invoice.InvoiceStatus convertInvoiceStatus(org.hl7.fhir.r4.model.Invoice.InvoiceStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DRAFT: return org.hl7.fhir.r5.model.Invoice.InvoiceStatus.DRAFT;
    case ISSUED: return org.hl7.fhir.r5.model.Invoice.InvoiceStatus.ISSUED;
    case BALANCED: return org.hl7.fhir.r5.model.Invoice.InvoiceStatus.BALANCED;
    case CANCELLED: return org.hl7.fhir.r5.model.Invoice.InvoiceStatus.CANCELLED;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.Invoice.InvoiceStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r5.model.Invoice.InvoiceStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Invoice.InvoiceStatus convertInvoiceStatus(org.hl7.fhir.r5.model.Invoice.InvoiceStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DRAFT: return org.hl7.fhir.r4.model.Invoice.InvoiceStatus.DRAFT;
    case ISSUED: return org.hl7.fhir.r4.model.Invoice.InvoiceStatus.ISSUED;
    case BALANCED: return org.hl7.fhir.r4.model.Invoice.InvoiceStatus.BALANCED;
    case CANCELLED: return org.hl7.fhir.r4.model.Invoice.InvoiceStatus.CANCELLED;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.Invoice.InvoiceStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r4.model.Invoice.InvoiceStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Invoice.InvoiceParticipantComponent convertInvoiceParticipantComponent(org.hl7.fhir.r4.model.Invoice.InvoiceParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Invoice.InvoiceParticipantComponent tgt = new org.hl7.fhir.r5.model.Invoice.InvoiceParticipantComponent();
    copyElement(src, tgt);
    if (src.hasRole())
      tgt.setRole(convertCodeableConcept(src.getRole()));
    if (src.hasActor())
      tgt.setActor(convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Invoice.InvoiceParticipantComponent convertInvoiceParticipantComponent(org.hl7.fhir.r5.model.Invoice.InvoiceParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Invoice.InvoiceParticipantComponent tgt = new org.hl7.fhir.r4.model.Invoice.InvoiceParticipantComponent();
    copyElement(src, tgt);
    if (src.hasRole())
      tgt.setRole(convertCodeableConcept(src.getRole()));
    if (src.hasActor())
      tgt.setActor(convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Invoice.InvoiceLineItemComponent convertInvoiceLineItemComponent(org.hl7.fhir.r4.model.Invoice.InvoiceLineItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Invoice.InvoiceLineItemComponent tgt = new org.hl7.fhir.r5.model.Invoice.InvoiceLineItemComponent();
    copyElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
    if (src.hasChargeItem())
      tgt.setChargeItem(convertType(src.getChargeItem()));
    for (org.hl7.fhir.r4.model.Invoice.InvoiceLineItemPriceComponentComponent t : src.getPriceComponent())
      tgt.addPriceComponent(convertInvoiceLineItemPriceComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Invoice.InvoiceLineItemComponent convertInvoiceLineItemComponent(org.hl7.fhir.r5.model.Invoice.InvoiceLineItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Invoice.InvoiceLineItemComponent tgt = new org.hl7.fhir.r4.model.Invoice.InvoiceLineItemComponent();
    copyElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
    if (src.hasChargeItem())
      tgt.setChargeItem(convertType(src.getChargeItem()));
    for (org.hl7.fhir.r5.model.Invoice.InvoiceLineItemPriceComponentComponent t : src.getPriceComponent())
      tgt.addPriceComponent(convertInvoiceLineItemPriceComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Invoice.InvoiceLineItemPriceComponentComponent convertInvoiceLineItemPriceComponentComponent(org.hl7.fhir.r4.model.Invoice.InvoiceLineItemPriceComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Invoice.InvoiceLineItemPriceComponentComponent tgt = new org.hl7.fhir.r5.model.Invoice.InvoiceLineItemPriceComponentComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertInvoicePriceComponentType(src.getType()));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasFactor())
      tgt.setFactorElement(convertDecimal(src.getFactorElement()));
    if (src.hasAmount())
      tgt.setAmount(convertMoney(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Invoice.InvoiceLineItemPriceComponentComponent convertInvoiceLineItemPriceComponentComponent(org.hl7.fhir.r5.model.Invoice.InvoiceLineItemPriceComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Invoice.InvoiceLineItemPriceComponentComponent tgt = new org.hl7.fhir.r4.model.Invoice.InvoiceLineItemPriceComponentComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertInvoicePriceComponentType(src.getType()));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasFactor())
      tgt.setFactorElement(convertDecimal(src.getFactorElement()));
    if (src.hasAmount())
      tgt.setAmount(convertMoney(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Invoice.InvoicePriceComponentType convertInvoicePriceComponentType(org.hl7.fhir.r4.model.Invoice.InvoicePriceComponentType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case BASE: return org.hl7.fhir.r5.model.Invoice.InvoicePriceComponentType.BASE;
    case SURCHARGE: return org.hl7.fhir.r5.model.Invoice.InvoicePriceComponentType.SURCHARGE;
    case DEDUCTION: return org.hl7.fhir.r5.model.Invoice.InvoicePriceComponentType.DEDUCTION;
    case DISCOUNT: return org.hl7.fhir.r5.model.Invoice.InvoicePriceComponentType.DISCOUNT;
    case TAX: return org.hl7.fhir.r5.model.Invoice.InvoicePriceComponentType.TAX;
    case INFORMATIONAL: return org.hl7.fhir.r5.model.Invoice.InvoicePriceComponentType.INFORMATIONAL;
    default: return org.hl7.fhir.r5.model.Invoice.InvoicePriceComponentType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Invoice.InvoicePriceComponentType convertInvoicePriceComponentType(org.hl7.fhir.r5.model.Invoice.InvoicePriceComponentType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case BASE: return org.hl7.fhir.r4.model.Invoice.InvoicePriceComponentType.BASE;
    case SURCHARGE: return org.hl7.fhir.r4.model.Invoice.InvoicePriceComponentType.SURCHARGE;
    case DEDUCTION: return org.hl7.fhir.r4.model.Invoice.InvoicePriceComponentType.DEDUCTION;
    case DISCOUNT: return org.hl7.fhir.r4.model.Invoice.InvoicePriceComponentType.DISCOUNT;
    case TAX: return org.hl7.fhir.r4.model.Invoice.InvoicePriceComponentType.TAX;
    case INFORMATIONAL: return org.hl7.fhir.r4.model.Invoice.InvoicePriceComponentType.INFORMATIONAL;
    default: return org.hl7.fhir.r4.model.Invoice.InvoicePriceComponentType.NULL;
  }
}


}
