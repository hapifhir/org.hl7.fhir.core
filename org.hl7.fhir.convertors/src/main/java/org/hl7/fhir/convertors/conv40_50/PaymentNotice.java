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


public class PaymentNotice extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.PaymentNotice convertPaymentNotice(org.hl7.fhir.r4.model.PaymentNotice src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.PaymentNotice tgt = new org.hl7.fhir.r5.model.PaymentNotice();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertPaymentNoticeStatus(src.getStatus()));
    if (src.hasRequest())
      tgt.setRequest(convertReference(src.getRequest()));
    if (src.hasResponse())
      tgt.setResponse(convertReference(src.getResponse()));
    if (src.hasCreated())
      tgt.setCreatedElement(convertDateTime(src.getCreatedElement()));
    if (src.hasProvider())
      tgt.setProvider(convertReference(src.getProvider()));
    if (src.hasPayment())
      tgt.setPayment(convertReference(src.getPayment()));
    if (src.hasPaymentDate())
      tgt.setPaymentDateElement(convertDate(src.getPaymentDateElement()));
    if (src.hasPayee())
      tgt.setPayee(convertReference(src.getPayee()));
    if (src.hasRecipient())
      tgt.setRecipient(convertReference(src.getRecipient()));
    if (src.hasAmount())
      tgt.setAmount(convertMoney(src.getAmount()));
    if (src.hasPaymentStatus())
      tgt.setPaymentStatus(convertCodeableConcept(src.getPaymentStatus()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PaymentNotice convertPaymentNotice(org.hl7.fhir.r5.model.PaymentNotice src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PaymentNotice tgt = new org.hl7.fhir.r4.model.PaymentNotice();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertPaymentNoticeStatus(src.getStatus()));
    if (src.hasRequest())
      tgt.setRequest(convertReference(src.getRequest()));
    if (src.hasResponse())
      tgt.setResponse(convertReference(src.getResponse()));
    if (src.hasCreated())
      tgt.setCreatedElement(convertDateTime(src.getCreatedElement()));
    if (src.hasProvider())
      tgt.setProvider(convertReference(src.getProvider()));
    if (src.hasPayment())
      tgt.setPayment(convertReference(src.getPayment()));
    if (src.hasPaymentDate())
      tgt.setPaymentDateElement(convertDate(src.getPaymentDateElement()));
    if (src.hasPayee())
      tgt.setPayee(convertReference(src.getPayee()));
    if (src.hasRecipient())
      tgt.setRecipient(convertReference(src.getRecipient()));
    if (src.hasAmount())
      tgt.setAmount(convertMoney(src.getAmount()));
    if (src.hasPaymentStatus())
      tgt.setPaymentStatus(convertCodeableConcept(src.getPaymentStatus()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.PaymentNotice.PaymentNoticeStatus convertPaymentNoticeStatus(org.hl7.fhir.r4.model.PaymentNotice.PaymentNoticeStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ACTIVE: return org.hl7.fhir.r5.model.PaymentNotice.PaymentNoticeStatus.ACTIVE;
    case CANCELLED: return org.hl7.fhir.r5.model.PaymentNotice.PaymentNoticeStatus.CANCELLED;
    case DRAFT: return org.hl7.fhir.r5.model.PaymentNotice.PaymentNoticeStatus.DRAFT;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.PaymentNotice.PaymentNoticeStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r5.model.PaymentNotice.PaymentNoticeStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.PaymentNotice.PaymentNoticeStatus convertPaymentNoticeStatus(org.hl7.fhir.r5.model.PaymentNotice.PaymentNoticeStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ACTIVE: return org.hl7.fhir.r4.model.PaymentNotice.PaymentNoticeStatus.ACTIVE;
    case CANCELLED: return org.hl7.fhir.r4.model.PaymentNotice.PaymentNoticeStatus.CANCELLED;
    case DRAFT: return org.hl7.fhir.r4.model.PaymentNotice.PaymentNoticeStatus.DRAFT;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.PaymentNotice.PaymentNoticeStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r4.model.PaymentNotice.PaymentNoticeStatus.NULL;
  }
}


}
