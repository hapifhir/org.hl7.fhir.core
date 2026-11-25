package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Money40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Date40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
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

/**
 * R4 PaymentReconciliation <-> R6. R5 reworked it as a record of a payment as well as its reconciliation:
 *
 *   paymentDate <-> date, paymentAmount <-> amount
 *   detail <-> allocation (detail.request <-> allocation.target)
 *   the elements R5 and R6 added are cross-version extensions
 */
public class PaymentReconciliation40_N {

  private static final String[] V5 = {"type", "kind", "enterer", "issuerType", "location", "method", "cardBrand", "accountNumber",
    "expirationDate", "processor", "referenceNumber", "authorization", "tenderedAmount", "returnedAmount"};
  private static final String[] V6 = {"statusReason"};
  private static final String[] ALLOCATION_V5 = {"targetItem", "encounter", "account"};
  private static final String[] ALLOCATION_V6 = {"characteristics", "noteNumber"};

  public static org.hl7.fhir.model.core.PaymentReconciliation convertPaymentReconciliation(org.hl7.fhir.r4.model.PaymentReconciliation src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.PaymentReconciliation tgt = new org.hl7.fhir.model.core.PaymentReconciliation();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt,
      CrossVersionElements40_N.urls("PaymentReconciliation", "5.0", V5, CrossVersionElements40_N.urls("PaymentReconciliation", "6.0", V6)));
    // R6 type is required, but R4 has nothing to say what it is, so it's not populated (and the R6 resource isn't valid)
    // unless there's a cross-version extension; see https://jira.hl7.org/browse/FHIR-59960
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", V5);
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", V6);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus()) {
      tgt.setStatusElement(new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodesEnumFactory()));
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src.getStatusElement(), tgt.getStatusElement());
      tgt.getStatusElement().setValueAsString(src.getStatusElement().getValueAsString());
    }
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime40_N.convertDateTime(src.getCreatedElement()));
    if (src.hasPaymentIssuer())
      tgt.setPaymentIssuer(Reference40_N.convertReference(src.getPaymentIssuer()));
    if (src.hasRequest())
      tgt.setRequest(Reference40_N.convertReference(src.getRequest()));
    if (src.hasRequestor())
      tgt.setRequestor(Reference40_N.convertReference(src.getRequestor()));
    if (src.hasOutcome()) {
      tgt.setOutcomeElement(new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.PaymentReconciliation.PaymentOutcomeEnumFactory()));
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src.getOutcomeElement(), tgt.getOutcomeElement());
      tgt.getOutcomeElement().setValueAsString(src.getOutcomeElement().getValueAsString());
    }
    if (src.hasDisposition())
      tgt.setDispositionElement(String40_N.convertString(src.getDispositionElement()));
    if (src.hasPaymentDate())
      tgt.setDateElement(Date40_N.convertDate(src.getPaymentDateElement()));
    if (src.hasPaymentAmount())
      tgt.setAmount(Money40_N.convertMoney(src.getPaymentAmount()));
    if (src.hasPaymentIdentifier())
      tgt.setPaymentIdentifier(Identifier40_N.convertIdentifier(src.getPaymentIdentifier()));
    for (org.hl7.fhir.r4.model.PaymentReconciliation.DetailsComponent t : src.getDetail())
      tgt.addAllocation(convertDetailsComponent(t));
    if (src.hasFormCode())
      tgt.setFormCode(CodeableConcept40_N.convertCodeableConcept(src.getFormCode()));
    for (org.hl7.fhir.r4.model.PaymentReconciliation.NotesComponent t : src.getProcessNote())
      tgt.addProcessNote(convertNotesComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PaymentReconciliation convertPaymentReconciliation(org.hl7.fhir.model.core.PaymentReconciliation src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PaymentReconciliation tgt = new org.hl7.fhir.r4.model.PaymentReconciliation();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", V5);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", V6);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus()) {
      tgt.setStatusElement(new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.PaymentReconciliation.PaymentReconciliationStatusEnumFactory()));
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src.getStatusElement(), tgt.getStatusElement());
      tgt.getStatusElement().setValueAsString(src.getStatusElement().getValueAsString());
    }
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime40_N.convertDateTime(src.getCreatedElement()));
    if (src.hasPaymentIssuer())
      tgt.setPaymentIssuer(Reference40_N.convertReference(src.getPaymentIssuer()));
    if (src.hasRequest())
      tgt.setRequest(Reference40_N.convertReference(src.getRequest()));
    if (src.hasRequestor())
      tgt.setRequestor(Reference40_N.convertReference(src.getRequestor()));
    if (src.hasOutcome()) {
      tgt.setOutcomeElement(new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.RemittanceOutcomeEnumFactory()));
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src.getOutcomeElement(), tgt.getOutcomeElement());
      tgt.getOutcomeElement().setValueAsString(src.getOutcomeElement().getValueAsString());
    }
    if (src.hasDisposition())
      tgt.setDispositionElement(String40_N.convertString(src.getDispositionElement()));
    if (src.hasDate())
      tgt.setPaymentDateElement(Date40_N.convertDate(src.getDateElement()));
    if (src.hasAmount())
      tgt.setPaymentAmount(Money40_N.convertMoney(src.getAmount()));
    if (src.hasPaymentIdentifier())
      tgt.setPaymentIdentifier(Identifier40_N.convertIdentifier(src.getPaymentIdentifier()));
    for (org.hl7.fhir.model.core.PaymentReconciliation.PaymentReconciliationAllocationComponent t : src.getAllocationList())
      tgt.addDetail(convertDetailsComponent(t));
    if (src.hasFormCode())
      tgt.setFormCode(CodeableConcept40_N.convertCodeableConcept(src.getFormCode()));
    for (org.hl7.fhir.model.core.PaymentReconciliation.NotesComponent t : src.getProcessNoteList())
      tgt.addProcessNote(convertNotesComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.PaymentReconciliation.PaymentReconciliationAllocationComponent convertDetailsComponent(org.hl7.fhir.r4.model.PaymentReconciliation.DetailsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.PaymentReconciliation.PaymentReconciliationAllocationComponent tgt = new org.hl7.fhir.model.core.PaymentReconciliation.PaymentReconciliationAllocationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt,
      CrossVersionElements40_N.urls("PaymentReconciliation.allocation", "5.0", ALLOCATION_V5, CrossVersionElements40_N.urls("PaymentReconciliation.allocation", "6.0", ALLOCATION_V6)));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "PaymentReconciliation.allocation", "5.0", ALLOCATION_V5);
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "PaymentReconciliation.allocation", "6.0", ALLOCATION_V6);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_N.convertIdentifier(src.getIdentifier()));
    if (src.hasPredecessor())
      tgt.setPredecessor(Identifier40_N.convertIdentifier(src.getPredecessor()));
    if (src.hasRequest())
      tgt.setTarget(Reference40_N.convertReference(src.getRequest()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasSubmitter())
      tgt.setSubmitter(Reference40_N.convertReference(src.getSubmitter()));
    if (src.hasResponse())
      tgt.setResponse(Reference40_N.convertReference(src.getResponse()));
    if (src.hasDate())
      tgt.setDateElement(Date40_N.convertDate(src.getDateElement()));
    if (src.hasResponsible())
      tgt.setResponsible(Reference40_N.convertReference(src.getResponsible()));
    if (src.hasPayee())
      tgt.setPayee(Reference40_N.convertReference(src.getPayee()));
    if (src.hasAmount())
      tgt.setAmount(Money40_N.convertMoney(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PaymentReconciliation.DetailsComponent convertDetailsComponent(org.hl7.fhir.model.core.PaymentReconciliation.PaymentReconciliationAllocationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PaymentReconciliation.DetailsComponent tgt = new org.hl7.fhir.r4.model.PaymentReconciliation.DetailsComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    CrossVersionElements40_N.elementsToExtensionsForPath(src, "PaymentReconciliation.allocation", tgt.getExtension(), "5.0", ALLOCATION_V5);
    CrossVersionElements40_N.elementsToExtensionsForPath(src, "PaymentReconciliation.allocation", tgt.getExtension(), "6.0", ALLOCATION_V6);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_N.convertIdentifier(src.getIdentifier()));
    if (src.hasPredecessor())
      tgt.setPredecessor(Identifier40_N.convertIdentifier(src.getPredecessor()));
    if (src.hasTarget())
      tgt.setRequest(Reference40_N.convertReference(src.getTarget()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasSubmitter())
      tgt.setSubmitter(Reference40_N.convertReference(src.getSubmitter()));
    if (src.hasResponse())
      tgt.setResponse(Reference40_N.convertReference(src.getResponse()));
    if (src.hasDate())
      tgt.setDateElement(Date40_N.convertDate(src.getDateElement()));
    if (src.hasResponsible())
      tgt.setResponsible(Reference40_N.convertReference(src.getResponsible()));
    if (src.hasPayee())
      tgt.setPayee(Reference40_N.convertReference(src.getPayee()));
    if (src.hasAmount())
      tgt.setAmount(Money40_N.convertMoney(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.PaymentReconciliation.NotesComponent convertNotesComponent(org.hl7.fhir.r4.model.PaymentReconciliation.NotesComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.PaymentReconciliation.NotesComponent tgt = new org.hl7.fhir.model.core.PaymentReconciliation.NotesComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt,
      CrossVersionElements40_N.urls("PaymentReconciliation.processNote", "6.0", new String[] {"class", "number"}));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "PaymentReconciliation.processNote", "6.0", "class", "number");
    if (src.hasType())
      tgt.setTypeElement(Enumerations40_N.convertNoteType(src.getTypeElement()));
    if (src.hasText())
      tgt.setTextElement(String40_N.convertStringToMarkdown(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PaymentReconciliation.NotesComponent convertNotesComponent(org.hl7.fhir.model.core.PaymentReconciliation.NotesComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PaymentReconciliation.NotesComponent tgt = new org.hl7.fhir.r4.model.PaymentReconciliation.NotesComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    CrossVersionElements40_N.elementsToExtensionsForPath(src, "PaymentReconciliation.processNote", tgt.getExtension(), "6.0", "class", "number");
    if (src.hasType())
      tgt.setTypeElement(Enumerations40_N.convertNoteType(src.getTypeElement()));
    if (src.hasText())
      tgt.setTextElement(String40_N.convertString(src.getTextElement()));
    return tgt;
  }
}
