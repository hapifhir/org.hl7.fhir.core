package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Attachment40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Money40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Period40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.SimpleQuantity40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Date40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Decimal40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.PositiveInt40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
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
public class ClaimResponse40_50 {

  public static org.hl7.fhir.r5.model.ClaimResponse convertClaimResponse(org.hl7.fhir.r4.model.ClaimResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse tgt = new org.hl7.fhir.r5.model.ClaimResponse();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertClaimResponseStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    if (src.hasSubType())
      tgt.setSubType(CodeableConcept40_50.convertCodeableConcept(src.getSubType()));
    if (src.hasUse())
      tgt.setUseElement(convertUse(src.getUseElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference40_50.convertReference(src.getPatient()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime40_50.convertDateTime(src.getCreatedElement()));
    if (src.hasInsurer())
      tgt.setInsurer(Reference40_50.convertReference(src.getInsurer()));
    if (src.hasRequestor())
      tgt.setRequestor(Reference40_50.convertReference(src.getRequestor()));
    if (src.hasRequest())
      tgt.setRequest(Reference40_50.convertReference(src.getRequest()));
    if (src.hasOutcome())
      tgt.setOutcomeElement(convertRemittanceOutcome(src.getOutcomeElement()));
    if (src.hasDisposition())
      tgt.setDispositionElement(String40_50.convertString(src.getDispositionElement()));
    if (src.hasPreAuthRef())
      tgt.setPreAuthRefElement(String40_50.convertString(src.getPreAuthRefElement()));
    if (src.hasPreAuthPeriod())
      tgt.setPreAuthPeriod(Period40_50.convertPeriod(src.getPreAuthPeriod()));
    if (src.hasPayeeType())
      tgt.setPayeeType(CodeableConcept40_50.convertCodeableConcept(src.getPayeeType()));
    for (org.hl7.fhir.r4.model.ClaimResponse.ItemComponent t : src.getItem()) tgt.addItem(convertItemComponent(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.AddedItemComponent t : src.getAddItem())
      tgt.addAddItem(convertAddedItemComponent(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.TotalComponent t : src.getTotal()) tgt.addTotal(convertTotalComponent(t));
    if (src.hasPayment())
      tgt.setPayment(convertPaymentComponent(src.getPayment()));
    if (src.hasFundsReserve())
      tgt.setFundsReserve(CodeableConcept40_50.convertCodeableConcept(src.getFundsReserve()));
    if (src.hasFormCode())
      tgt.setFormCode(CodeableConcept40_50.convertCodeableConcept(src.getFormCode()));
    if (src.hasForm())
      tgt.setForm(Attachment40_50.convertAttachment(src.getForm()));
    for (org.hl7.fhir.r4.model.ClaimResponse.NoteComponent t : src.getProcessNote())
      tgt.addProcessNote(convertNoteComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getCommunicationRequest())
      tgt.addCommunicationRequest(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.InsuranceComponent t : src.getInsurance())
      tgt.addInsurance(convertInsuranceComponent(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.ErrorComponent t : src.getError()) tgt.addError(convertErrorComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse convertClaimResponse(org.hl7.fhir.r5.model.ClaimResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse tgt = new org.hl7.fhir.r4.model.ClaimResponse();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertClaimResponseStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    if (src.hasSubType())
      tgt.setSubType(CodeableConcept40_50.convertCodeableConcept(src.getSubType()));
    if (src.hasUse())
      tgt.setUseElement(convertUse(src.getUseElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference40_50.convertReference(src.getPatient()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime40_50.convertDateTime(src.getCreatedElement()));
    if (src.hasInsurer())
      tgt.setInsurer(Reference40_50.convertReference(src.getInsurer()));
    if (src.hasRequestor())
      tgt.setRequestor(Reference40_50.convertReference(src.getRequestor()));
    if (src.hasRequest())
      tgt.setRequest(Reference40_50.convertReference(src.getRequest()));
    if (src.hasOutcome())
      tgt.setOutcomeElement(convertRemittanceOutcome(src.getOutcomeElement()));
    if (src.hasDisposition())
      tgt.setDispositionElement(String40_50.convertString(src.getDispositionElement()));
    if (src.hasPreAuthRef())
      tgt.setPreAuthRefElement(String40_50.convertString(src.getPreAuthRefElement()));
    if (src.hasPreAuthPeriod())
      tgt.setPreAuthPeriod(Period40_50.convertPeriod(src.getPreAuthPeriod()));
    if (src.hasPayeeType())
      tgt.setPayeeType(CodeableConcept40_50.convertCodeableConcept(src.getPayeeType()));
    for (org.hl7.fhir.r5.model.ClaimResponse.ItemComponent t : src.getItem()) tgt.addItem(convertItemComponent(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.AddedItemComponent t : src.getAddItem())
      tgt.addAddItem(convertAddedItemComponent(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.TotalComponent t : src.getTotal()) tgt.addTotal(convertTotalComponent(t));
    if (src.hasPayment())
      tgt.setPayment(convertPaymentComponent(src.getPayment()));
    if (src.hasFundsReserve())
      tgt.setFundsReserve(CodeableConcept40_50.convertCodeableConcept(src.getFundsReserve()));
    if (src.hasFormCode())
      tgt.setFormCode(CodeableConcept40_50.convertCodeableConcept(src.getFormCode()));
    if (src.hasForm())
      tgt.setForm(Attachment40_50.convertAttachment(src.getForm()));
    for (org.hl7.fhir.r5.model.ClaimResponse.NoteComponent t : src.getProcessNote())
      tgt.addProcessNote(convertNoteComponent(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getCommunicationRequest())
      tgt.addCommunicationRequest(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.InsuranceComponent t : src.getInsurance())
      tgt.addInsurance(convertInsuranceComponent(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.ErrorComponent t : src.getError()) tgt.addError(convertErrorComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> convertClaimResponseStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ClaimResponse.ClaimResponseStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodesEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ClaimResponse.ClaimResponseStatus> convertClaimResponseStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ClaimResponse.ClaimResponseStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ClaimResponse.ClaimResponseStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4.model.ClaimResponse.ClaimResponseStatus.ACTIVE);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4.model.ClaimResponse.ClaimResponseStatus.CANCELLED);
        break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r4.model.ClaimResponse.ClaimResponseStatus.DRAFT);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.ClaimResponse.ClaimResponseStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.ClaimResponse.ClaimResponseStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.Use> convertUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ClaimResponse.Use> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.Use> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.UseEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ClaimResponse.Use> convertUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.Use> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ClaimResponse.Use> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ClaimResponse.UseEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case CLAIM:
        tgt.setValue(org.hl7.fhir.r4.model.ClaimResponse.Use.CLAIM);
        break;
      case PREAUTHORIZATION:
        tgt.setValue(org.hl7.fhir.r4.model.ClaimResponse.Use.PREAUTHORIZATION);
        break;
      case PREDETERMINATION:
        tgt.setValue(org.hl7.fhir.r4.model.ClaimResponse.Use.PREDETERMINATION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.ClaimResponse.Use.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes> convertRemittanceOutcome(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ClaimResponse.RemittanceOutcome> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodesEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ClaimResponse.RemittanceOutcome> convertRemittanceOutcome(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ClaimResponse.RemittanceOutcome> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ClaimResponse.RemittanceOutcomeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case QUEUED:
        tgt.setValue(org.hl7.fhir.r4.model.ClaimResponse.RemittanceOutcome.QUEUED);
        break;
      case COMPLETE:
        tgt.setValue(org.hl7.fhir.r4.model.ClaimResponse.RemittanceOutcome.COMPLETE);
        break;
      case ERROR:
        tgt.setValue(org.hl7.fhir.r4.model.ClaimResponse.RemittanceOutcome.ERROR);
        break;
      case PARTIAL:
        tgt.setValue(org.hl7.fhir.r4.model.ClaimResponse.RemittanceOutcome.PARTIAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.ClaimResponse.RemittanceOutcome.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClaimResponse.ItemComponent convertItemComponent(org.hl7.fhir.r4.model.ClaimResponse.ItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse.ItemComponent tgt = new org.hl7.fhir.r5.model.ClaimResponse.ItemComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasItemSequence())
      tgt.setItemSequenceElement(PositiveInt40_50.convertPositiveInt(src.getItemSequenceElement()));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt40_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.ItemDetailComponent t : src.getDetail())
      tgt.addDetail(convertItemDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse.ItemComponent convertItemComponent(org.hl7.fhir.r5.model.ClaimResponse.ItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse.ItemComponent tgt = new org.hl7.fhir.r4.model.ClaimResponse.ItemComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasItemSequence())
      tgt.setItemSequenceElement(PositiveInt40_50.convertPositiveInt(src.getItemSequenceElement()));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt40_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.ItemDetailComponent t : src.getDetail())
      tgt.addDetail(convertItemDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClaimResponse.AdjudicationComponent convertAdjudicationComponent(org.hl7.fhir.r4.model.ClaimResponse.AdjudicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse.AdjudicationComponent tgt = new org.hl7.fhir.r5.model.ClaimResponse.AdjudicationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_50.convertCodeableConcept(src.getCategory()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept40_50.convertCodeableConcept(src.getReason()));
    if (src.hasAmount())
      tgt.setAmount(Money40_50.convertMoney(src.getAmount()));
    if (src.hasValue())
      tgt.setQuantity(Decimal40_50.convertDecimalToQuantity(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse.AdjudicationComponent convertAdjudicationComponent(org.hl7.fhir.r5.model.ClaimResponse.AdjudicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse.AdjudicationComponent tgt = new org.hl7.fhir.r4.model.ClaimResponse.AdjudicationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_50.convertCodeableConcept(src.getCategory()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept40_50.convertCodeableConcept(src.getReason()));
    if (src.hasAmount())
      tgt.setAmount(Money40_50.convertMoney(src.getAmount()));
    if (src.hasQuantity())
      tgt.setValueElement(Decimal40_50.convertDecimal(src.getQuantity().getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClaimResponse.ItemDetailComponent convertItemDetailComponent(org.hl7.fhir.r4.model.ClaimResponse.ItemDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse.ItemDetailComponent tgt = new org.hl7.fhir.r5.model.ClaimResponse.ItemDetailComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasDetailSequence())
      tgt.setDetailSequenceElement(PositiveInt40_50.convertPositiveInt(src.getDetailSequenceElement()));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt40_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.SubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse.ItemDetailComponent convertItemDetailComponent(org.hl7.fhir.r5.model.ClaimResponse.ItemDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse.ItemDetailComponent tgt = new org.hl7.fhir.r4.model.ClaimResponse.ItemDetailComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasDetailSequence())
      tgt.setDetailSequenceElement(PositiveInt40_50.convertPositiveInt(src.getDetailSequenceElement()));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt40_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.SubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClaimResponse.SubDetailComponent convertSubDetailComponent(org.hl7.fhir.r4.model.ClaimResponse.SubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse.SubDetailComponent tgt = new org.hl7.fhir.r5.model.ClaimResponse.SubDetailComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasSubDetailSequence())
      tgt.setSubDetailSequenceElement(PositiveInt40_50.convertPositiveInt(src.getSubDetailSequenceElement()));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt40_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse.SubDetailComponent convertSubDetailComponent(org.hl7.fhir.r5.model.ClaimResponse.SubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse.SubDetailComponent tgt = new org.hl7.fhir.r4.model.ClaimResponse.SubDetailComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasSubDetailSequence())
      tgt.setSubDetailSequenceElement(PositiveInt40_50.convertPositiveInt(src.getSubDetailSequenceElement()));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt40_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClaimResponse.AddedItemComponent convertAddedItemComponent(org.hl7.fhir.r4.model.ClaimResponse.AddedItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse.AddedItemComponent tgt = new org.hl7.fhir.r5.model.ClaimResponse.AddedItemComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getItemSequence())
      tgt.getItemSequence().add(PositiveInt40_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getDetailSequence())
      tgt.getDetailSequence().add(PositiveInt40_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getSubdetailSequence())
      tgt.getSubdetailSequence().add(PositiveInt40_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getProvider()) tgt.addProvider(Reference40_50.convertReference(t));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept40_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasServiced())
      tgt.setServiced(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getServiced()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getLocation()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money40_50.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal40_50.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money40_50.convertMoney(src.getNet()));
    if (src.hasBodySite())
      tgt.getBodySiteFirstRep().addSite(CodeableConcept40_50.convertCodeableConceptToCodeableReference(src.getBodySite()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSubSite())
      tgt.getBodySiteFirstRep().addSubSite(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt40_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.AddedItemDetailComponent t : src.getDetail())
      tgt.addDetail(convertAddedItemDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse.AddedItemComponent convertAddedItemComponent(org.hl7.fhir.r5.model.ClaimResponse.AddedItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse.AddedItemComponent tgt = new org.hl7.fhir.r4.model.ClaimResponse.AddedItemComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getItemSequence())
      tgt.getItemSequence().add(PositiveInt40_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getDetailSequence())
      tgt.getDetailSequence().add(PositiveInt40_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getSubdetailSequence())
      tgt.getSubdetailSequence().add(PositiveInt40_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getProvider()) tgt.addProvider(Reference40_50.convertReference(t));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept40_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasServiced())
      tgt.setServiced(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getServiced()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getLocation()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money40_50.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal40_50.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money40_50.convertMoney(src.getNet()));
    if (src.getBodySiteFirstRep().hasSite())
      tgt.setBodySite(CodeableConcept40_50.convertCodeableReferenceToCodeableConcept(src.getBodySiteFirstRep().getSiteFirstRep()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getBodySiteFirstRep().getSubSite())
      tgt.addSubSite(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt40_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.AddedItemDetailComponent t : src.getDetail())
      tgt.addDetail(convertAddedItemDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClaimResponse.AddedItemDetailComponent convertAddedItemDetailComponent(org.hl7.fhir.r4.model.ClaimResponse.AddedItemDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse.AddedItemDetailComponent tgt = new org.hl7.fhir.r5.model.ClaimResponse.AddedItemDetailComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept40_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money40_50.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal40_50.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money40_50.convertMoney(src.getNet()));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt40_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.AddedItemSubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertAddedItemSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse.AddedItemDetailComponent convertAddedItemDetailComponent(org.hl7.fhir.r5.model.ClaimResponse.AddedItemDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse.AddedItemDetailComponent tgt = new org.hl7.fhir.r4.model.ClaimResponse.AddedItemDetailComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept40_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money40_50.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal40_50.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money40_50.convertMoney(src.getNet()));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt40_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.AddedItemSubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertAddedItemSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClaimResponse.AddedItemSubDetailComponent convertAddedItemSubDetailComponent(org.hl7.fhir.r4.model.ClaimResponse.AddedItemSubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse.AddedItemSubDetailComponent tgt = new org.hl7.fhir.r5.model.ClaimResponse.AddedItemSubDetailComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept40_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money40_50.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal40_50.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money40_50.convertMoney(src.getNet()));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt40_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse.AddedItemSubDetailComponent convertAddedItemSubDetailComponent(org.hl7.fhir.r5.model.ClaimResponse.AddedItemSubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse.AddedItemSubDetailComponent tgt = new org.hl7.fhir.r4.model.ClaimResponse.AddedItemSubDetailComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept40_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money40_50.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal40_50.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money40_50.convertMoney(src.getNet()));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt40_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClaimResponse.TotalComponent convertTotalComponent(org.hl7.fhir.r4.model.ClaimResponse.TotalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse.TotalComponent tgt = new org.hl7.fhir.r5.model.ClaimResponse.TotalComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_50.convertCodeableConcept(src.getCategory()));
    if (src.hasAmount())
      tgt.setAmount(Money40_50.convertMoney(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse.TotalComponent convertTotalComponent(org.hl7.fhir.r5.model.ClaimResponse.TotalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse.TotalComponent tgt = new org.hl7.fhir.r4.model.ClaimResponse.TotalComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_50.convertCodeableConcept(src.getCategory()));
    if (src.hasAmount())
      tgt.setAmount(Money40_50.convertMoney(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClaimResponse.PaymentComponent convertPaymentComponent(org.hl7.fhir.r4.model.ClaimResponse.PaymentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse.PaymentComponent tgt = new org.hl7.fhir.r5.model.ClaimResponse.PaymentComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    if (src.hasAdjustment())
      tgt.setAdjustment(Money40_50.convertMoney(src.getAdjustment()));
    if (src.hasAdjustmentReason())
      tgt.setAdjustmentReason(CodeableConcept40_50.convertCodeableConcept(src.getAdjustmentReason()));
    if (src.hasDate())
      tgt.setDateElement(Date40_50.convertDate(src.getDateElement()));
    if (src.hasAmount())
      tgt.setAmount(Money40_50.convertMoney(src.getAmount()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_50.convertIdentifier(src.getIdentifier()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse.PaymentComponent convertPaymentComponent(org.hl7.fhir.r5.model.ClaimResponse.PaymentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse.PaymentComponent tgt = new org.hl7.fhir.r4.model.ClaimResponse.PaymentComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    if (src.hasAdjustment())
      tgt.setAdjustment(Money40_50.convertMoney(src.getAdjustment()));
    if (src.hasAdjustmentReason())
      tgt.setAdjustmentReason(CodeableConcept40_50.convertCodeableConcept(src.getAdjustmentReason()));
    if (src.hasDate())
      tgt.setDateElement(Date40_50.convertDate(src.getDateElement()));
    if (src.hasAmount())
      tgt.setAmount(Money40_50.convertMoney(src.getAmount()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_50.convertIdentifier(src.getIdentifier()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClaimResponse.NoteComponent convertNoteComponent(org.hl7.fhir.r4.model.ClaimResponse.NoteComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse.NoteComponent tgt = new org.hl7.fhir.r5.model.ClaimResponse.NoteComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasNumber())
      tgt.setNumberElement(PositiveInt40_50.convertPositiveInt(src.getNumberElement()));
    if (src.hasType())
      tgt.getType().addCoding().setSystem("http://hl7.org/fhir/note-type").setCode(src.getType().toCode());
    if (src.hasText())
      tgt.setTextElement(String40_50.convertString(src.getTextElement()));
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept40_50.convertCodeableConcept(src.getLanguage()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse.NoteComponent convertNoteComponent(org.hl7.fhir.r5.model.ClaimResponse.NoteComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse.NoteComponent tgt = new org.hl7.fhir.r4.model.ClaimResponse.NoteComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasNumber())
      tgt.setNumberElement(PositiveInt40_50.convertPositiveInt(src.getNumberElement()));
    if (src.hasType() && src.getType().hasCoding("http://hl7.org/fhir/note-type"))
      tgt.setType(org.hl7.fhir.r4.model.Enumerations.NoteType.fromCode(src.getType().getCode("http://hl7.org/fhir/note-type")));
    if (src.hasText())
      tgt.setTextElement(String40_50.convertString(src.getTextElement()));
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept40_50.convertCodeableConcept(src.getLanguage()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClaimResponse.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r4.model.ClaimResponse.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse.InsuranceComponent tgt = new org.hl7.fhir.r5.model.ClaimResponse.InsuranceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_50.convertPositiveInt(src.getSequenceElement()));
    if (src.hasFocal())
      tgt.setFocalElement(Boolean40_50.convertBoolean(src.getFocalElement()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference40_50.convertReference(src.getCoverage()));
    if (src.hasBusinessArrangement())
      tgt.setBusinessArrangementElement(String40_50.convertString(src.getBusinessArrangementElement()));
    if (src.hasClaimResponse())
      tgt.setClaimResponse(Reference40_50.convertReference(src.getClaimResponse()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r5.model.ClaimResponse.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse.InsuranceComponent tgt = new org.hl7.fhir.r4.model.ClaimResponse.InsuranceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_50.convertPositiveInt(src.getSequenceElement()));
    if (src.hasFocal())
      tgt.setFocalElement(Boolean40_50.convertBoolean(src.getFocalElement()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference40_50.convertReference(src.getCoverage()));
    if (src.hasBusinessArrangement())
      tgt.setBusinessArrangementElement(String40_50.convertString(src.getBusinessArrangementElement()));
    if (src.hasClaimResponse())
      tgt.setClaimResponse(Reference40_50.convertReference(src.getClaimResponse()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClaimResponse.ErrorComponent convertErrorComponent(org.hl7.fhir.r4.model.ClaimResponse.ErrorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClaimResponse.ErrorComponent tgt = new org.hl7.fhir.r5.model.ClaimResponse.ErrorComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasItemSequence())
      tgt.setItemSequenceElement(PositiveInt40_50.convertPositiveInt(src.getItemSequenceElement()));
    if (src.hasDetailSequence())
      tgt.setDetailSequenceElement(PositiveInt40_50.convertPositiveInt(src.getDetailSequenceElement()));
    if (src.hasSubDetailSequence())
      tgt.setSubDetailSequenceElement(PositiveInt40_50.convertPositiveInt(src.getSubDetailSequenceElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse.ErrorComponent convertErrorComponent(org.hl7.fhir.r5.model.ClaimResponse.ErrorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse.ErrorComponent tgt = new org.hl7.fhir.r4.model.ClaimResponse.ErrorComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasItemSequence())
      tgt.setItemSequenceElement(PositiveInt40_50.convertPositiveInt(src.getItemSequenceElement()));
    if (src.hasDetailSequence())
      tgt.setDetailSequenceElement(PositiveInt40_50.convertPositiveInt(src.getDetailSequenceElement()));
    if (src.hasSubDetailSequence())
      tgt.setSubDetailSequenceElement(PositiveInt40_50.convertPositiveInt(src.getSubDetailSequenceElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    return tgt;
  }
}