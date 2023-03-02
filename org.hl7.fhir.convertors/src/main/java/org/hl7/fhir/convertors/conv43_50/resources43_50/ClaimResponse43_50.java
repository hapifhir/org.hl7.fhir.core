package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Attachment43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Money43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.SimpleQuantity43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Date43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Decimal43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.PositiveInt43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
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
public class ClaimResponse43_50 {

  public static org.hl7.fhir.r5.model.ClaimResponse convertClaimResponse(org.hl7.fhir.r4b.model.ClaimResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse tgt = new org.hl7.fhir.r5.model.ClaimResponse();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertClaimResponseStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasSubType())
      tgt.setSubType(CodeableConcept43_50.convertCodeableConcept(src.getSubType()));
    if (src.hasUse())
      tgt.setUseElement(convertUse(src.getUseElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_50.convertReference(src.getPatient()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_50.convertDateTime(src.getCreatedElement()));
    if (src.hasInsurer())
      tgt.setInsurer(Reference43_50.convertReference(src.getInsurer()));
    if (src.hasRequestor())
      tgt.setRequestor(Reference43_50.convertReference(src.getRequestor()));
    if (src.hasRequest())
      tgt.setRequest(Reference43_50.convertReference(src.getRequest()));
    if (src.hasOutcome())
      tgt.setOutcomeElement(convertRemittanceOutcome(src.getOutcomeElement()));
    if (src.hasDisposition())
      tgt.setDispositionElement(String43_50.convertString(src.getDispositionElement()));
    if (src.hasPreAuthRef())
      tgt.setPreAuthRefElement(String43_50.convertString(src.getPreAuthRefElement()));
    if (src.hasPreAuthPeriod())
      tgt.setPreAuthPeriod(Period43_50.convertPeriod(src.getPreAuthPeriod()));
    if (src.hasPayeeType())
      tgt.setPayeeType(CodeableConcept43_50.convertCodeableConcept(src.getPayeeType()));
    for (org.hl7.fhir.r4b.model.ClaimResponse.ItemComponent t : src.getItem()) tgt.addItem(convertItemComponent(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.AddedItemComponent t : src.getAddItem())
      tgt.addAddItem(convertAddedItemComponent(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.TotalComponent t : src.getTotal()) tgt.addTotal(convertTotalComponent(t));
    if (src.hasPayment())
      tgt.setPayment(convertPaymentComponent(src.getPayment()));
    if (src.hasFundsReserve())
      tgt.setFundsReserve(CodeableConcept43_50.convertCodeableConcept(src.getFundsReserve()));
    if (src.hasFormCode())
      tgt.setFormCode(CodeableConcept43_50.convertCodeableConcept(src.getFormCode()));
    if (src.hasForm())
      tgt.setForm(Attachment43_50.convertAttachment(src.getForm()));
    for (org.hl7.fhir.r4b.model.ClaimResponse.NoteComponent t : src.getProcessNote())
      tgt.addProcessNote(convertNoteComponent(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getCommunicationRequest())
      tgt.addCommunicationRequest(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.InsuranceComponent t : src.getInsurance())
      tgt.addInsurance(convertInsuranceComponent(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.ErrorComponent t : src.getError()) tgt.addError(convertErrorComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse convertClaimResponse(org.hl7.fhir.r5.model.ClaimResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse tgt = new org.hl7.fhir.r4b.model.ClaimResponse();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertClaimResponseStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasSubType())
      tgt.setSubType(CodeableConcept43_50.convertCodeableConcept(src.getSubType()));
    if (src.hasUse())
      tgt.setUseElement(convertUse(src.getUseElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_50.convertReference(src.getPatient()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_50.convertDateTime(src.getCreatedElement()));
    if (src.hasInsurer())
      tgt.setInsurer(Reference43_50.convertReference(src.getInsurer()));
    if (src.hasRequestor())
      tgt.setRequestor(Reference43_50.convertReference(src.getRequestor()));
    if (src.hasRequest())
      tgt.setRequest(Reference43_50.convertReference(src.getRequest()));
    if (src.hasOutcome())
      tgt.setOutcomeElement(convertRemittanceOutcome(src.getOutcomeElement()));
    if (src.hasDisposition())
      tgt.setDispositionElement(String43_50.convertString(src.getDispositionElement()));
    if (src.hasPreAuthRef())
      tgt.setPreAuthRefElement(String43_50.convertString(src.getPreAuthRefElement()));
    if (src.hasPreAuthPeriod())
      tgt.setPreAuthPeriod(Period43_50.convertPeriod(src.getPreAuthPeriod()));
    if (src.hasPayeeType())
      tgt.setPayeeType(CodeableConcept43_50.convertCodeableConcept(src.getPayeeType()));
    for (org.hl7.fhir.r5.model.ClaimResponse.ItemComponent t : src.getItem()) tgt.addItem(convertItemComponent(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.AddedItemComponent t : src.getAddItem())
      tgt.addAddItem(convertAddedItemComponent(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.TotalComponent t : src.getTotal()) tgt.addTotal(convertTotalComponent(t));
    if (src.hasPayment())
      tgt.setPayment(convertPaymentComponent(src.getPayment()));
    if (src.hasFundsReserve())
      tgt.setFundsReserve(CodeableConcept43_50.convertCodeableConcept(src.getFundsReserve()));
    if (src.hasFormCode())
      tgt.setFormCode(CodeableConcept43_50.convertCodeableConcept(src.getFormCode()));
    if (src.hasForm())
      tgt.setForm(Attachment43_50.convertAttachment(src.getForm()));
    for (org.hl7.fhir.r5.model.ClaimResponse.NoteComponent t : src.getProcessNote())
      tgt.addProcessNote(convertNoteComponent(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getCommunicationRequest())
      tgt.addCommunicationRequest(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.InsuranceComponent t : src.getInsurance())
      tgt.addInsurance(convertInsuranceComponent(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.ErrorComponent t : src.getError()) tgt.addError(convertErrorComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> convertClaimResponseStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> convertClaimResponseStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.Use> convertUse(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.Use> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.Use> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.UseEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case CLAIM:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.Use.CLAIM);
        break;
      case PREAUTHORIZATION:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.Use.PREAUTHORIZATION);
        break;
      case PREDETERMINATION:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.Use.PREDETERMINATION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.Use.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.Use> convertUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.Use> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.Use> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.UseEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case CLAIM:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.Use.CLAIM);
        break;
      case PREAUTHORIZATION:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.Use.PREAUTHORIZATION);
        break;
      case PREDETERMINATION:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.Use.PREDETERMINATION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.Use.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes> convertRemittanceOutcome(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcome> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case QUEUED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes.QUEUED);
        break;
      case COMPLETE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes.COMPLETE);
        break;
      case ERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes.ERROR);
        break;
      case PARTIAL:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes.PARTIAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcome> convertRemittanceOutcome(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcome> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcomeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case QUEUED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcome.QUEUED);
        break;
      case COMPLETE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcome.COMPLETE);
        break;
      case ERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcome.ERROR);
        break;
      case PARTIAL:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcome.PARTIAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcome.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClaimResponse.ItemComponent convertItemComponent(org.hl7.fhir.r4b.model.ClaimResponse.ItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse.ItemComponent tgt = new org.hl7.fhir.r5.model.ClaimResponse.ItemComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasItemSequence())
      tgt.setItemSequenceElement(PositiveInt43_50.convertPositiveInt(src.getItemSequenceElement()));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.ItemDetailComponent t : src.getDetail())
      tgt.addDetail(convertItemDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse.ItemComponent convertItemComponent(org.hl7.fhir.r5.model.ClaimResponse.ItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse.ItemComponent tgt = new org.hl7.fhir.r4b.model.ClaimResponse.ItemComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasItemSequence())
      tgt.setItemSequenceElement(PositiveInt43_50.convertPositiveInt(src.getItemSequenceElement()));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.ItemDetailComponent t : src.getDetail())
      tgt.addDetail(convertItemDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClaimResponse.AdjudicationComponent convertAdjudicationComponent(org.hl7.fhir.r4b.model.ClaimResponse.AdjudicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse.AdjudicationComponent tgt = new org.hl7.fhir.r5.model.ClaimResponse.AdjudicationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategory()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept43_50.convertCodeableConcept(src.getReason()));
    if (src.hasAmount())
      tgt.setAmount(Money43_50.convertMoney(src.getAmount()));
    if (src.hasValue())
      tgt.setQuantity(Decimal43_50.convertDecimalToQuantity(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse.AdjudicationComponent convertAdjudicationComponent(org.hl7.fhir.r5.model.ClaimResponse.AdjudicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse.AdjudicationComponent tgt = new org.hl7.fhir.r4b.model.ClaimResponse.AdjudicationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategory()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept43_50.convertCodeableConcept(src.getReason()));
    if (src.hasAmount())
      tgt.setAmount(Money43_50.convertMoney(src.getAmount()));
    if (src.hasQuantity())
      tgt.setValueElement(Decimal43_50.convertDecimal(src.getQuantity().getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClaimResponse.ItemDetailComponent convertItemDetailComponent(org.hl7.fhir.r4b.model.ClaimResponse.ItemDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse.ItemDetailComponent tgt = new org.hl7.fhir.r5.model.ClaimResponse.ItemDetailComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasDetailSequence())
      tgt.setDetailSequenceElement(PositiveInt43_50.convertPositiveInt(src.getDetailSequenceElement()));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.SubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse.ItemDetailComponent convertItemDetailComponent(org.hl7.fhir.r5.model.ClaimResponse.ItemDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse.ItemDetailComponent tgt = new org.hl7.fhir.r4b.model.ClaimResponse.ItemDetailComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasDetailSequence())
      tgt.setDetailSequenceElement(PositiveInt43_50.convertPositiveInt(src.getDetailSequenceElement()));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.SubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClaimResponse.SubDetailComponent convertSubDetailComponent(org.hl7.fhir.r4b.model.ClaimResponse.SubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse.SubDetailComponent tgt = new org.hl7.fhir.r5.model.ClaimResponse.SubDetailComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSubDetailSequence())
      tgt.setSubDetailSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSubDetailSequenceElement()));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse.SubDetailComponent convertSubDetailComponent(org.hl7.fhir.r5.model.ClaimResponse.SubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse.SubDetailComponent tgt = new org.hl7.fhir.r4b.model.ClaimResponse.SubDetailComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSubDetailSequence())
      tgt.setSubDetailSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSubDetailSequenceElement()));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClaimResponse.AddedItemComponent convertAddedItemComponent(org.hl7.fhir.r4b.model.ClaimResponse.AddedItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse.AddedItemComponent tgt = new org.hl7.fhir.r5.model.ClaimResponse.AddedItemComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getItemSequence())
      tgt.getItemSequence().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getDetailSequence())
      tgt.getDetailSequence().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getSubdetailSequence())
      tgt.getSubdetailSequence().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getProvider()) tgt.addProvider(Reference43_50.convertReference(t));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasServiced())
      tgt.setServiced(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getServiced()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getLocation()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_50.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_50.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_50.convertMoney(src.getNet()));
    if (src.hasBodySite())
      tgt.getBodySiteFirstRep().addSite(CodeableConcept43_50.convertCodeableConceptToCodeableReference(src.getBodySite()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSubSite())
      tgt.getBodySiteFirstRep().addSubSite(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.AddedItemDetailComponent t : src.getDetail())
      tgt.addDetail(convertAddedItemDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse.AddedItemComponent convertAddedItemComponent(org.hl7.fhir.r5.model.ClaimResponse.AddedItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse.AddedItemComponent tgt = new org.hl7.fhir.r4b.model.ClaimResponse.AddedItemComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getItemSequence())
      tgt.getItemSequence().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getDetailSequence())
      tgt.getDetailSequence().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getSubdetailSequence())
      tgt.getSubdetailSequence().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getProvider()) tgt.addProvider(Reference43_50.convertReference(t));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasServiced())
      tgt.setServiced(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getServiced()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getLocation()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_50.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_50.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_50.convertMoney(src.getNet()));
    if (src.getBodySiteFirstRep().hasSite())
      tgt.setBodySite(CodeableConcept43_50.convertCodeableReferenceToCodeableConcept(src.getBodySiteFirstRep().getSiteFirstRep()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getBodySiteFirstRep().getSubSite())
      tgt.addSubSite(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.AddedItemDetailComponent t : src.getDetail())
      tgt.addDetail(convertAddedItemDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClaimResponse.AddedItemDetailComponent convertAddedItemDetailComponent(org.hl7.fhir.r4b.model.ClaimResponse.AddedItemDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse.AddedItemDetailComponent tgt = new org.hl7.fhir.r5.model.ClaimResponse.AddedItemDetailComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_50.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_50.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_50.convertMoney(src.getNet()));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.AddedItemSubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertAddedItemSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse.AddedItemDetailComponent convertAddedItemDetailComponent(org.hl7.fhir.r5.model.ClaimResponse.AddedItemDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse.AddedItemDetailComponent tgt = new org.hl7.fhir.r4b.model.ClaimResponse.AddedItemDetailComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_50.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_50.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_50.convertMoney(src.getNet()));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.AddedItemSubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertAddedItemSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClaimResponse.AddedItemSubDetailComponent convertAddedItemSubDetailComponent(org.hl7.fhir.r4b.model.ClaimResponse.AddedItemSubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse.AddedItemSubDetailComponent tgt = new org.hl7.fhir.r5.model.ClaimResponse.AddedItemSubDetailComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_50.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_50.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_50.convertMoney(src.getNet()));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse.AddedItemSubDetailComponent convertAddedItemSubDetailComponent(org.hl7.fhir.r5.model.ClaimResponse.AddedItemSubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse.AddedItemSubDetailComponent tgt = new org.hl7.fhir.r4b.model.ClaimResponse.AddedItemSubDetailComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_50.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_50.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_50.convertMoney(src.getNet()));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClaimResponse.TotalComponent convertTotalComponent(org.hl7.fhir.r4b.model.ClaimResponse.TotalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse.TotalComponent tgt = new org.hl7.fhir.r5.model.ClaimResponse.TotalComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategory()));
    if (src.hasAmount())
      tgt.setAmount(Money43_50.convertMoney(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse.TotalComponent convertTotalComponent(org.hl7.fhir.r5.model.ClaimResponse.TotalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse.TotalComponent tgt = new org.hl7.fhir.r4b.model.ClaimResponse.TotalComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategory()));
    if (src.hasAmount())
      tgt.setAmount(Money43_50.convertMoney(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClaimResponse.PaymentComponent convertPaymentComponent(org.hl7.fhir.r4b.model.ClaimResponse.PaymentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse.PaymentComponent tgt = new org.hl7.fhir.r5.model.ClaimResponse.PaymentComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasAdjustment())
      tgt.setAdjustment(Money43_50.convertMoney(src.getAdjustment()));
    if (src.hasAdjustmentReason())
      tgt.setAdjustmentReason(CodeableConcept43_50.convertCodeableConcept(src.getAdjustmentReason()));
    if (src.hasDate())
      tgt.setDateElement(Date43_50.convertDate(src.getDateElement()));
    if (src.hasAmount())
      tgt.setAmount(Money43_50.convertMoney(src.getAmount()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_50.convertIdentifier(src.getIdentifier()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse.PaymentComponent convertPaymentComponent(org.hl7.fhir.r5.model.ClaimResponse.PaymentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse.PaymentComponent tgt = new org.hl7.fhir.r4b.model.ClaimResponse.PaymentComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasAdjustment())
      tgt.setAdjustment(Money43_50.convertMoney(src.getAdjustment()));
    if (src.hasAdjustmentReason())
      tgt.setAdjustmentReason(CodeableConcept43_50.convertCodeableConcept(src.getAdjustmentReason()));
    if (src.hasDate())
      tgt.setDateElement(Date43_50.convertDate(src.getDateElement()));
    if (src.hasAmount())
      tgt.setAmount(Money43_50.convertMoney(src.getAmount()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_50.convertIdentifier(src.getIdentifier()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClaimResponse.NoteComponent convertNoteComponent(org.hl7.fhir.r4b.model.ClaimResponse.NoteComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse.NoteComponent tgt = new org.hl7.fhir.r5.model.ClaimResponse.NoteComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasNumber())
      tgt.setNumberElement(PositiveInt43_50.convertPositiveInt(src.getNumberElement()));
    if (src.hasType())
      tgt.getType().addCoding().setSystem("http://hl7.org/fhir/note-type").setCode(src.getType().toCode());
    if (src.hasText())
      tgt.setTextElement(String43_50.convertString(src.getTextElement()));
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept43_50.convertCodeableConcept(src.getLanguage()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse.NoteComponent convertNoteComponent(org.hl7.fhir.r5.model.ClaimResponse.NoteComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse.NoteComponent tgt = new org.hl7.fhir.r4b.model.ClaimResponse.NoteComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasNumber())
      tgt.setNumberElement(PositiveInt43_50.convertPositiveInt(src.getNumberElement()));
    if (src.hasType() && src.getType().hasCoding("http://hl7.org/fhir/note-type"))
      tgt.setType(org.hl7.fhir.r4b.model.Enumerations.NoteType.fromCode(src.getType().getCode("http://hl7.org/fhir/note-type")));
    if (src.hasText())
      tgt.setTextElement(String43_50.convertString(src.getTextElement()));
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept43_50.convertCodeableConcept(src.getLanguage()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClaimResponse.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r4b.model.ClaimResponse.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse.InsuranceComponent tgt = new org.hl7.fhir.r5.model.ClaimResponse.InsuranceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSequenceElement()));
    if (src.hasFocal())
      tgt.setFocalElement(Boolean43_50.convertBoolean(src.getFocalElement()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference43_50.convertReference(src.getCoverage()));
    if (src.hasBusinessArrangement())
      tgt.setBusinessArrangementElement(String43_50.convertString(src.getBusinessArrangementElement()));
    if (src.hasClaimResponse())
      tgt.setClaimResponse(Reference43_50.convertReference(src.getClaimResponse()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r5.model.ClaimResponse.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse.InsuranceComponent tgt = new org.hl7.fhir.r4b.model.ClaimResponse.InsuranceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSequenceElement()));
    if (src.hasFocal())
      tgt.setFocalElement(Boolean43_50.convertBoolean(src.getFocalElement()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference43_50.convertReference(src.getCoverage()));
    if (src.hasBusinessArrangement())
      tgt.setBusinessArrangementElement(String43_50.convertString(src.getBusinessArrangementElement()));
    if (src.hasClaimResponse())
      tgt.setClaimResponse(Reference43_50.convertReference(src.getClaimResponse()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClaimResponse.ErrorComponent convertErrorComponent(org.hl7.fhir.r4b.model.ClaimResponse.ErrorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse.ErrorComponent tgt = new org.hl7.fhir.r5.model.ClaimResponse.ErrorComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasItemSequence())
      tgt.setItemSequenceElement(PositiveInt43_50.convertPositiveInt(src.getItemSequenceElement()));
    if (src.hasDetailSequence())
      tgt.setDetailSequenceElement(PositiveInt43_50.convertPositiveInt(src.getDetailSequenceElement()));
    if (src.hasSubDetailSequence())
      tgt.setSubDetailSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSubDetailSequenceElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse.ErrorComponent convertErrorComponent(org.hl7.fhir.r5.model.ClaimResponse.ErrorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse.ErrorComponent tgt = new org.hl7.fhir.r4b.model.ClaimResponse.ErrorComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasItemSequence())
      tgt.setItemSequenceElement(PositiveInt43_50.convertPositiveInt(src.getItemSequenceElement()));
    if (src.hasDetailSequence())
      tgt.setDetailSequenceElement(PositiveInt43_50.convertPositiveInt(src.getDetailSequenceElement()));
    if (src.hasSubDetailSequence())
      tgt.setSubDetailSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSubDetailSequenceElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    return tgt;
  }
}