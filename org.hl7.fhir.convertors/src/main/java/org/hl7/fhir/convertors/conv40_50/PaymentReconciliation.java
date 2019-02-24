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


public class PaymentReconciliation extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.PaymentReconciliation convertPaymentReconciliation(org.hl7.fhir.r4.model.PaymentReconciliation src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.PaymentReconciliation tgt = new org.hl7.fhir.r5.model.PaymentReconciliation();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertPaymentReconciliationStatus(src.getStatus()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    if (src.hasCreated())
      tgt.setCreatedElement(convertDateTime(src.getCreatedElement()));
    if (src.hasPaymentIssuer())
      tgt.setPaymentIssuer(convertReference(src.getPaymentIssuer()));
    if (src.hasRequest())
      tgt.setRequest(convertReference(src.getRequest()));
    if (src.hasRequestor())
      tgt.setRequestor(convertReference(src.getRequestor()));
    if (src.hasOutcome())
      tgt.setOutcome(convertRemittanceOutcome(src.getOutcome()));
    if (src.hasDisposition())
      tgt.setDispositionElement(convertString(src.getDispositionElement()));
    if (src.hasPaymentDate())
      tgt.setPaymentDateElement(convertDate(src.getPaymentDateElement()));
    if (src.hasPaymentAmount())
      tgt.setPaymentAmount(convertMoney(src.getPaymentAmount()));
    if (src.hasPaymentIdentifier())
      tgt.setPaymentIdentifier(convertIdentifier(src.getPaymentIdentifier()));
    for (org.hl7.fhir.r4.model.PaymentReconciliation.DetailsComponent t : src.getDetail())
      tgt.addDetail(convertDetailsComponent(t));
    if (src.hasFormCode())
      tgt.setFormCode(convertCodeableConcept(src.getFormCode()));
    for (org.hl7.fhir.r4.model.PaymentReconciliation.NotesComponent t : src.getProcessNote())
      tgt.addProcessNote(convertNotesComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PaymentReconciliation convertPaymentReconciliation(org.hl7.fhir.r5.model.PaymentReconciliation src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PaymentReconciliation tgt = new org.hl7.fhir.r4.model.PaymentReconciliation();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertPaymentReconciliationStatus(src.getStatus()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    if (src.hasCreated())
      tgt.setCreatedElement(convertDateTime(src.getCreatedElement()));
    if (src.hasPaymentIssuer())
      tgt.setPaymentIssuer(convertReference(src.getPaymentIssuer()));
    if (src.hasRequest())
      tgt.setRequest(convertReference(src.getRequest()));
    if (src.hasRequestor())
      tgt.setRequestor(convertReference(src.getRequestor()));
    if (src.hasOutcome())
      tgt.setOutcome(convertRemittanceOutcome(src.getOutcome()));
    if (src.hasDisposition())
      tgt.setDispositionElement(convertString(src.getDispositionElement()));
    if (src.hasPaymentDate())
      tgt.setPaymentDateElement(convertDate(src.getPaymentDateElement()));
    if (src.hasPaymentAmount())
      tgt.setPaymentAmount(convertMoney(src.getPaymentAmount()));
    if (src.hasPaymentIdentifier())
      tgt.setPaymentIdentifier(convertIdentifier(src.getPaymentIdentifier()));
    for (org.hl7.fhir.r5.model.PaymentReconciliation.DetailsComponent t : src.getDetail())
      tgt.addDetail(convertDetailsComponent(t));
    if (src.hasFormCode())
      tgt.setFormCode(convertCodeableConcept(src.getFormCode()));
    for (org.hl7.fhir.r5.model.PaymentReconciliation.NotesComponent t : src.getProcessNote())
      tgt.addProcessNote(convertNotesComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.PaymentReconciliation.PaymentReconciliationStatus convertPaymentReconciliationStatus(org.hl7.fhir.r4.model.PaymentReconciliation.PaymentReconciliationStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ACTIVE: return org.hl7.fhir.r5.model.PaymentReconciliation.PaymentReconciliationStatus.ACTIVE;
    case CANCELLED: return org.hl7.fhir.r5.model.PaymentReconciliation.PaymentReconciliationStatus.CANCELLED;
    case DRAFT: return org.hl7.fhir.r5.model.PaymentReconciliation.PaymentReconciliationStatus.DRAFT;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.PaymentReconciliation.PaymentReconciliationStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r5.model.PaymentReconciliation.PaymentReconciliationStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.PaymentReconciliation.PaymentReconciliationStatus convertPaymentReconciliationStatus(org.hl7.fhir.r5.model.PaymentReconciliation.PaymentReconciliationStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ACTIVE: return org.hl7.fhir.r4.model.PaymentReconciliation.PaymentReconciliationStatus.ACTIVE;
    case CANCELLED: return org.hl7.fhir.r4.model.PaymentReconciliation.PaymentReconciliationStatus.CANCELLED;
    case DRAFT: return org.hl7.fhir.r4.model.PaymentReconciliation.PaymentReconciliationStatus.DRAFT;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.PaymentReconciliation.PaymentReconciliationStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r4.model.PaymentReconciliation.PaymentReconciliationStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Enumerations.RemittanceOutcome convertRemittanceOutcome(org.hl7.fhir.r4.model.Enumerations.RemittanceOutcome src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case QUEUED: return org.hl7.fhir.r5.model.Enumerations.RemittanceOutcome.QUEUED;
    case COMPLETE: return org.hl7.fhir.r5.model.Enumerations.RemittanceOutcome.COMPLETE;
    case ERROR: return org.hl7.fhir.r5.model.Enumerations.RemittanceOutcome.ERROR;
    case PARTIAL: return org.hl7.fhir.r5.model.Enumerations.RemittanceOutcome.PARTIAL;
    default: return org.hl7.fhir.r5.model.Enumerations.RemittanceOutcome.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Enumerations.RemittanceOutcome convertRemittanceOutcome(org.hl7.fhir.r5.model.Enumerations.RemittanceOutcome src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case QUEUED: return org.hl7.fhir.r4.model.Enumerations.RemittanceOutcome.QUEUED;
    case COMPLETE: return org.hl7.fhir.r4.model.Enumerations.RemittanceOutcome.COMPLETE;
    case ERROR: return org.hl7.fhir.r4.model.Enumerations.RemittanceOutcome.ERROR;
    case PARTIAL: return org.hl7.fhir.r4.model.Enumerations.RemittanceOutcome.PARTIAL;
    default: return org.hl7.fhir.r4.model.Enumerations.RemittanceOutcome.NULL;
  }
}

  public static org.hl7.fhir.r5.model.PaymentReconciliation.DetailsComponent convertDetailsComponent(org.hl7.fhir.r4.model.PaymentReconciliation.DetailsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.PaymentReconciliation.DetailsComponent tgt = new org.hl7.fhir.r5.model.PaymentReconciliation.DetailsComponent();
    copyElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
    if (src.hasPredecessor())
      tgt.setPredecessor(convertIdentifier(src.getPredecessor()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasRequest())
      tgt.setRequest(convertReference(src.getRequest()));
    if (src.hasSubmitter())
      tgt.setSubmitter(convertReference(src.getSubmitter()));
    if (src.hasResponse())
      tgt.setResponse(convertReference(src.getResponse()));
    if (src.hasDate())
      tgt.setDateElement(convertDate(src.getDateElement()));
    if (src.hasResponsible())
      tgt.setResponsible(convertReference(src.getResponsible()));
    if (src.hasPayee())
      tgt.setPayee(convertReference(src.getPayee()));
    if (src.hasAmount())
      tgt.setAmount(convertMoney(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PaymentReconciliation.DetailsComponent convertDetailsComponent(org.hl7.fhir.r5.model.PaymentReconciliation.DetailsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PaymentReconciliation.DetailsComponent tgt = new org.hl7.fhir.r4.model.PaymentReconciliation.DetailsComponent();
    copyElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
    if (src.hasPredecessor())
      tgt.setPredecessor(convertIdentifier(src.getPredecessor()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasRequest())
      tgt.setRequest(convertReference(src.getRequest()));
    if (src.hasSubmitter())
      tgt.setSubmitter(convertReference(src.getSubmitter()));
    if (src.hasResponse())
      tgt.setResponse(convertReference(src.getResponse()));
    if (src.hasDate())
      tgt.setDateElement(convertDate(src.getDateElement()));
    if (src.hasResponsible())
      tgt.setResponsible(convertReference(src.getResponsible()));
    if (src.hasPayee())
      tgt.setPayee(convertReference(src.getPayee()));
    if (src.hasAmount())
      tgt.setAmount(convertMoney(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.PaymentReconciliation.NotesComponent convertNotesComponent(org.hl7.fhir.r4.model.PaymentReconciliation.NotesComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.PaymentReconciliation.NotesComponent tgt = new org.hl7.fhir.r5.model.PaymentReconciliation.NotesComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(Enumerations.convertNoteType(src.getType()));
    if (src.hasText())
      tgt.setTextElement(convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PaymentReconciliation.NotesComponent convertNotesComponent(org.hl7.fhir.r5.model.PaymentReconciliation.NotesComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PaymentReconciliation.NotesComponent tgt = new org.hl7.fhir.r4.model.PaymentReconciliation.NotesComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(Enumerations.convertNoteType(src.getType()));
    if (src.hasText())
      tgt.setTextElement(convertString(src.getTextElement()));
    return tgt;
  }


}
