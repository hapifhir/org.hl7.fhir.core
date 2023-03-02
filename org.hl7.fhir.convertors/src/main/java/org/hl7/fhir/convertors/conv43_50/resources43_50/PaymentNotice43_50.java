package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Money43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Date43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
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
public class PaymentNotice43_50 {

  public static org.hl7.fhir.r5.model.PaymentNotice convertPaymentNotice(org.hl7.fhir.r4b.model.PaymentNotice src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.PaymentNotice tgt = new org.hl7.fhir.r5.model.PaymentNotice();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertPaymentNoticeStatus(src.getStatusElement()));
    if (src.hasRequest())
      tgt.setRequest(Reference43_50.convertReference(src.getRequest()));
    if (src.hasResponse())
      tgt.setResponse(Reference43_50.convertReference(src.getResponse()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_50.convertDateTime(src.getCreatedElement()));
    if (src.hasProvider())
      tgt.setReporter(Reference43_50.convertReference(src.getProvider()));
    if (src.hasPayment())
      tgt.setPayment(Reference43_50.convertReference(src.getPayment()));
    if (src.hasPaymentDate())
      tgt.setPaymentDateElement(Date43_50.convertDate(src.getPaymentDateElement()));
    if (src.hasPayee())
      tgt.setPayee(Reference43_50.convertReference(src.getPayee()));
    if (src.hasRecipient())
      tgt.setRecipient(Reference43_50.convertReference(src.getRecipient()));
    if (src.hasAmount())
      tgt.setAmount(Money43_50.convertMoney(src.getAmount()));
    if (src.hasPaymentStatus())
      tgt.setPaymentStatus(CodeableConcept43_50.convertCodeableConcept(src.getPaymentStatus()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.PaymentNotice convertPaymentNotice(org.hl7.fhir.r5.model.PaymentNotice src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.PaymentNotice tgt = new org.hl7.fhir.r4b.model.PaymentNotice();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertPaymentNoticeStatus(src.getStatusElement()));
    if (src.hasRequest())
      tgt.setRequest(Reference43_50.convertReference(src.getRequest()));
    if (src.hasResponse())
      tgt.setResponse(Reference43_50.convertReference(src.getResponse()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_50.convertDateTime(src.getCreatedElement()));
    if (src.hasReporter())
      tgt.setProvider(Reference43_50.convertReference(src.getReporter()));
    if (src.hasPayment())
      tgt.setPayment(Reference43_50.convertReference(src.getPayment()));
    if (src.hasPaymentDate())
      tgt.setPaymentDateElement(Date43_50.convertDate(src.getPaymentDateElement()));
    if (src.hasPayee())
      tgt.setPayee(Reference43_50.convertReference(src.getPayee()));
    if (src.hasRecipient())
      tgt.setRecipient(Reference43_50.convertReference(src.getRecipient()));
    if (src.hasAmount())
      tgt.setAmount(Money43_50.convertMoney(src.getAmount()));
    if (src.hasPaymentStatus())
      tgt.setPaymentStatus(CodeableConcept43_50.convertCodeableConcept(src.getPaymentStatus()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> convertPaymentNoticeStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.ACTIVE);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.CANCELLED);
        break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.DRAFT);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> convertPaymentNoticeStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.ACTIVE);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.CANCELLED);
        break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.DRAFT);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.NULL);
        break;
    }
    return tgt;
  }
}