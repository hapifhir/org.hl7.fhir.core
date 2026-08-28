package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Attachment43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Money43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Period43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.SimpleQuantity43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Date43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Decimal43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.PositiveInt43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.ClaimResponse;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;

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

public class ClaimResponse43_N {

  public static org.hl7.fhir.model.core.ClaimResponse convertClaimResponse(org.hl7.fhir.r4b.model.ClaimResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse tgt = new org.hl7.fhir.model.core.ClaimResponse();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertClaimResponseStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasSubType())
      tgt.setSubType(CodeableConcept43_N.convertCodeableConcept(src.getSubType()));
    if (src.hasUse())
      tgt.setUseElement(convertUse(src.getUseElement()));
    if (src.hasPatient())
      tgt.setSubject(Reference43_N.convertReference(src.getPatient()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_N.convertDateTime(src.getCreatedElement()));
    if (src.hasInsurer())
      tgt.setInsurer(Reference43_N.convertReference(src.getInsurer()));
    if (src.hasRequestor())
      tgt.setRequestor(Reference43_N.convertReference(src.getRequestor()));
    if (src.hasRequest())
      tgt.setRequest(Reference43_N.convertReference(src.getRequest()));
    if (src.hasOutcome())
      tgt.setOutcomeElement(convertRemittanceOutcome(src.getOutcomeElement()));
    if (src.hasDisposition())
      tgt.setDispositionElement(String43_N.convertString(src.getDispositionElement()));
    if (src.hasPreAuthRef())
      tgt.setPreAuthRefElement(String43_N.convertString(src.getPreAuthRefElement()));
    if (src.hasPreAuthPeriod())
      tgt.setPreAuthPeriod(Period43_N.convertPeriod(src.getPreAuthPeriod()));
    if (src.hasPayeeType())
      tgt.setPayeeType(CodeableConcept43_N.convertCodeableConcept(src.getPayeeType()));
    for (org.hl7.fhir.r4b.model.ClaimResponse.ItemComponent t : src.getItem()) tgt.addItem(convertItemComponent(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.AddedItemComponent t : src.getAddItem())
      tgt.addAddItem(convertAddedItemComponent(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.TotalComponent t : src.getTotal()) tgt.addTotal(convertTotalComponent(t));
    if (src.hasPayment())
      tgt.setPayment(convertPaymentComponent(src.getPayment()));
    if (src.hasFundsReserve())
      tgt.setFundsReserve(CodeableConcept43_N.convertCodeableConcept(src.getFundsReserve()));
    if (src.hasFormCode())
      tgt.setFormCode(CodeableConcept43_N.convertCodeableConcept(src.getFormCode()));
    if (src.hasForm())
      tgt.setForm(Attachment43_N.convertAttachment(src.getForm()));
    for (org.hl7.fhir.r4b.model.ClaimResponse.NoteComponent t : src.getProcessNote())
      tgt.addProcessNote(convertNoteComponent(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getCommunicationRequest())
      tgt.addCommunicationRequest(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.InsuranceComponent t : src.getInsurance())
      tgt.addInsurance(convertInsuranceComponent(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.ErrorComponent t : src.getError()) tgt.addError(convertErrorComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse convertClaimResponse(org.hl7.fhir.model.core.ClaimResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse tgt = new org.hl7.fhir.r4b.model.ClaimResponse();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertClaimResponseStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasSubType())
      tgt.setSubType(CodeableConcept43_N.convertCodeableConcept(src.getSubType()));
    if (src.hasUse())
      tgt.setUseElement(convertUse(src.getUseElement()));
    if (src.hasSubject())
      tgt.setPatient(Reference43_N.convertReference(src.getSubject()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_N.convertDateTime(src.getCreatedElement()));
    if (src.hasInsurer())
      tgt.setInsurer(Reference43_N.convertReference(src.getInsurer()));
    if (src.hasRequestor())
      tgt.setRequestor(Reference43_N.convertReference(src.getRequestor()));
    if (src.hasRequest())
      tgt.setRequest(Reference43_N.convertReference(src.getRequest()));
    if (src.hasOutcome())
      tgt.setOutcomeElement(convertRemittanceOutcome(src.getOutcomeElement()));
    if (src.hasDisposition())
      tgt.setDispositionElement(String43_N.convertString(src.getDispositionElement()));
    if (src.hasPreAuthRef())
      tgt.setPreAuthRefElement(String43_N.convertString(src.getPreAuthRefElement()));
    if (src.hasPreAuthPeriod())
      tgt.setPreAuthPeriod(Period43_N.convertPeriod(src.getPreAuthPeriod()));
    if (src.hasPayeeType())
      tgt.setPayeeType(CodeableConcept43_N.convertCodeableConcept(src.getPayeeType()));
    for (org.hl7.fhir.model.core.ClaimResponse.ItemComponent t : src.getItemList()) tgt.addItem(convertItemComponent(t));
    for (org.hl7.fhir.model.core.ClaimResponse.AddedItemComponent t : src.getAddItemList())
      tgt.addAddItem(convertAddedItemComponent(t));
    for (org.hl7.fhir.model.core.ClaimResponse.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.model.core.ClaimResponse.TotalComponent t : src.getTotalList()) tgt.addTotal(convertTotalComponent(t));
    if (src.hasPayment())
      tgt.setPayment(convertPaymentComponent(src.getPayment()));
    if (src.hasFundsReserve())
      tgt.setFundsReserve(CodeableConcept43_N.convertCodeableConcept(src.getFundsReserve()));
    if (src.hasFormCode())
      tgt.setFormCode(CodeableConcept43_N.convertCodeableConcept(src.getFormCode()));
    if (src.hasForm())
      tgt.setForm(Attachment43_N.convertAttachment(src.getForm()));
    for (org.hl7.fhir.model.core.ClaimResponse.NoteComponent t : src.getProcessNoteList())
      tgt.addProcessNote(convertNoteComponent(t));
    for (org.hl7.fhir.model.core.Reference t : src.getCommunicationRequestList())
      tgt.addCommunicationRequest(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.ClaimResponse.InsuranceComponent t : src.getInsuranceList())
      tgt.addInsurance(convertInsuranceComponent(t));
    for (org.hl7.fhir.model.core.ClaimResponse.ErrorComponent t : src.getErrorList()) tgt.addError(convertErrorComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes> convertClaimResponseStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.FinancialResourceStatusCodes> tgt = new Enumeration<>(new Enumerations.FinancialResourceStatusCodesEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.ACTIVE);
                  break;
              case CANCELLED:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.CANCELLED);
                  break;
              case DRAFT:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.DRAFT);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> convertClaimResponseStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodesEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.Use> convertUse(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.Use> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.Use> tgt = new Enumeration<>(new Enumerations.UseEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case CLAIM:
                  tgt.setValue(Enumerations.Use.CLAIM);
                  break;
              case PREAUTHORIZATION:
                  tgt.setValue(Enumerations.Use.PREAUTHORIZATION);
                  break;
              case PREDETERMINATION:
                  tgt.setValue(Enumerations.Use.PREDETERMINATION);
                  break;
              default:
                  tgt.setValue(Enumerations.Use.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.Use> convertUse(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.Use> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.Use> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.UseEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ClaimProcessingCodes> convertRemittanceOutcome(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcome> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.ClaimProcessingCodes> tgt = new Enumeration<>(new Enumerations.ClaimProcessingCodesEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case QUEUED:
                  tgt.setValue(Enumerations.ClaimProcessingCodes.QUEUED);
                  break;
              case COMPLETE:
                  tgt.setValue(Enumerations.ClaimProcessingCodes.COMPLETE);
                  break;
              case ERROR:
                  tgt.setValue(Enumerations.ClaimProcessingCodes.ERROR);
                  break;
              case PARTIAL:
                  tgt.setValue(Enumerations.ClaimProcessingCodes.PARTIAL);
                  break;
              default:
                  tgt.setValue(Enumerations.ClaimProcessingCodes.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcome> convertRemittanceOutcome(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ClaimProcessingCodes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcome> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcomeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.ClaimResponse.ItemComponent convertItemComponent(org.hl7.fhir.r4b.model.ClaimResponse.ItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse.ItemComponent tgt = new org.hl7.fhir.model.core.ClaimResponse.ItemComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasItemSequence())
      tgt.setItemSequenceElement(PositiveInt43_N.convertPositiveInt(src.getItemSequenceElement()));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumberList().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.ItemDetailComponent t : src.getDetail())
      tgt.addDetail(convertItemDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse.ItemComponent convertItemComponent(org.hl7.fhir.model.core.ClaimResponse.ItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse.ItemComponent tgt = new org.hl7.fhir.r4b.model.ClaimResponse.ItemComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasItemSequence())
      tgt.setItemSequenceElement(PositiveInt43_N.convertPositiveInt(src.getItemSequenceElement()));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getNoteNumberList())
      tgt.getNoteNumber().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.ClaimResponse.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.model.core.ClaimResponse.ItemDetailComponent t : src.getDetailList())
      tgt.addDetail(convertItemDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ClaimResponse.AdjudicationComponent convertAdjudicationComponent(org.hl7.fhir.r4b.model.ClaimResponse.AdjudicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse.AdjudicationComponent tgt = new org.hl7.fhir.model.core.ClaimResponse.AdjudicationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategory()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept43_N.convertCodeableConcept(src.getReason()));
    if (src.hasAmount())
      tgt.setAmount(Money43_N.convertMoney(src.getAmount()));
    if (src.hasValue())
      tgt.setQuantity(Decimal43_N.convertDecimalToQuantity(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse.AdjudicationComponent convertAdjudicationComponent(org.hl7.fhir.model.core.ClaimResponse.AdjudicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse.AdjudicationComponent tgt = new org.hl7.fhir.r4b.model.ClaimResponse.AdjudicationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategory()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept43_N.convertCodeableConcept(src.getReason()));
    if (src.hasAmount())
      tgt.setAmount(Money43_N.convertMoney(src.getAmount()));
    if (src.hasQuantity())
      tgt.setValueElement(Decimal43_N.convertDecimal(src.getQuantity().getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ClaimResponse.ItemDetailComponent convertItemDetailComponent(org.hl7.fhir.r4b.model.ClaimResponse.ItemDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse.ItemDetailComponent tgt = new org.hl7.fhir.model.core.ClaimResponse.ItemDetailComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasDetailSequence())
      tgt.setDetailSequenceElement(PositiveInt43_N.convertPositiveInt(src.getDetailSequenceElement()));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumberList().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.SubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse.ItemDetailComponent convertItemDetailComponent(org.hl7.fhir.model.core.ClaimResponse.ItemDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse.ItemDetailComponent tgt = new org.hl7.fhir.r4b.model.ClaimResponse.ItemDetailComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasDetailSequence())
      tgt.setDetailSequenceElement(PositiveInt43_N.convertPositiveInt(src.getDetailSequenceElement()));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getNoteNumberList())
      tgt.getNoteNumber().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.ClaimResponse.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.model.core.ClaimResponse.SubDetailComponent t : src.getSubDetailList())
      tgt.addSubDetail(convertSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ClaimResponse.SubDetailComponent convertSubDetailComponent(org.hl7.fhir.r4b.model.ClaimResponse.SubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse.SubDetailComponent tgt = new org.hl7.fhir.model.core.ClaimResponse.SubDetailComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSubDetailSequence())
      tgt.setSubDetailSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSubDetailSequenceElement()));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumberList().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse.SubDetailComponent convertSubDetailComponent(org.hl7.fhir.model.core.ClaimResponse.SubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse.SubDetailComponent tgt = new org.hl7.fhir.r4b.model.ClaimResponse.SubDetailComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSubDetailSequence())
      tgt.setSubDetailSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSubDetailSequenceElement()));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getNoteNumberList())
      tgt.getNoteNumber().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.ClaimResponse.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ClaimResponse.AddedItemComponent convertAddedItemComponent(org.hl7.fhir.r4b.model.ClaimResponse.AddedItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse.AddedItemComponent tgt = new org.hl7.fhir.model.core.ClaimResponse.AddedItemComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getItemSequence())
      tgt.getItemSequenceList().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getDetailSequence())
      tgt.getDetailSequenceList().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getSubdetailSequence())
      tgt.getSubdetailSequenceList().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getProvider()) tgt.addProvider(Reference43_N.convertReference(t));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasServiced())
      tgt.setServiced(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getServiced()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getLocation()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_N.convertMoney(src.getNet()));
    if (src.hasBodySite())
      tgt.getBodySiteFirstRep().addSite(CodeableConcept43_N.convertCodeableConceptToCodeableReference(src.getBodySite()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSubSite())
      tgt.getBodySiteFirstRep().addSubSite(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumberList().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.AddedItemDetailComponent t : src.getDetail())
      tgt.addDetail(convertAddedItemDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse.AddedItemComponent convertAddedItemComponent(org.hl7.fhir.model.core.ClaimResponse.AddedItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse.AddedItemComponent tgt = new org.hl7.fhir.r4b.model.ClaimResponse.AddedItemComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getItemSequenceList())
      tgt.getItemSequence().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getDetailSequenceList())
      tgt.getDetailSequence().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getSubdetailSequenceList())
      tgt.getSubdetailSequence().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.Reference t : src.getProviderList()) tgt.addProvider(Reference43_N.convertReference(t));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getModifierList())
      tgt.addModifier(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getProgramCodeList())
      tgt.addProgramCode(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasServiced())
      tgt.setServiced(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getServiced()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getLocation()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_N.convertMoney(src.getNet()));
    if (src.getBodySiteFirstRep().hasSite())
      tgt.setBodySite(CodeableConcept43_N.convertCodeableReferenceToCodeableConcept(src.getBodySiteFirstRep().getSiteFirstRep()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getBodySiteFirstRep().getSubSiteList())
      tgt.addSubSite(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getNoteNumberList())
      tgt.getNoteNumber().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.ClaimResponse.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.model.core.ClaimResponse.AddedItemDetailComponent t : src.getDetailList())
      tgt.addDetail(convertAddedItemDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ClaimResponse.AddedItemDetailComponent convertAddedItemDetailComponent(org.hl7.fhir.r4b.model.ClaimResponse.AddedItemDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse.AddedItemDetailComponent tgt = new org.hl7.fhir.model.core.ClaimResponse.AddedItemDetailComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumberList().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.AddedItemSubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertAddedItemSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse.AddedItemDetailComponent convertAddedItemDetailComponent(org.hl7.fhir.model.core.ClaimResponse.AddedItemDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse.AddedItemDetailComponent tgt = new org.hl7.fhir.r4b.model.ClaimResponse.AddedItemDetailComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getModifierList())
      tgt.addModifier(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getNoteNumberList())
      tgt.getNoteNumber().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.ClaimResponse.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.model.core.ClaimResponse.AddedItemSubDetailComponent t : src.getSubDetailList())
      tgt.addSubDetail(convertAddedItemSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ClaimResponse.AddedItemSubDetailComponent convertAddedItemSubDetailComponent(org.hl7.fhir.r4b.model.ClaimResponse.AddedItemSubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse.AddedItemSubDetailComponent tgt = new org.hl7.fhir.model.core.ClaimResponse.AddedItemSubDetailComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumberList().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse.AddedItemSubDetailComponent convertAddedItemSubDetailComponent(org.hl7.fhir.model.core.ClaimResponse.AddedItemSubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse.AddedItemSubDetailComponent tgt = new org.hl7.fhir.r4b.model.ClaimResponse.AddedItemSubDetailComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getModifierList())
      tgt.addModifier(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getNoteNumberList())
      tgt.getNoteNumber().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.ClaimResponse.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ClaimResponse.TotalComponent convertTotalComponent(org.hl7.fhir.r4b.model.ClaimResponse.TotalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse.TotalComponent tgt = new org.hl7.fhir.model.core.ClaimResponse.TotalComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategory()));
    if (src.hasAmount())
      tgt.setAmount(Money43_N.convertMoney(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse.TotalComponent convertTotalComponent(org.hl7.fhir.model.core.ClaimResponse.TotalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse.TotalComponent tgt = new org.hl7.fhir.r4b.model.ClaimResponse.TotalComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategory()));
    if (src.hasAmount())
      tgt.setAmount(Money43_N.convertMoney(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ClaimResponse.PaymentComponent convertPaymentComponent(org.hl7.fhir.r4b.model.ClaimResponse.PaymentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse.PaymentComponent tgt = new org.hl7.fhir.model.core.ClaimResponse.PaymentComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasAdjustment())
      tgt.setAdjustment(Money43_N.convertMoney(src.getAdjustment()));
    if (src.hasAdjustmentReason())
      tgt.setAdjustmentReason(CodeableConcept43_N.convertCodeableConcept(src.getAdjustmentReason()));
    if (src.hasDate())
      tgt.setDateElement(Date43_N.convertDate(src.getDateElement()));
    if (src.hasAmount())
      tgt.setAmount(Money43_N.convertMoney(src.getAmount()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_N.convertIdentifier(src.getIdentifier()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse.PaymentComponent convertPaymentComponent(org.hl7.fhir.model.core.ClaimResponse.PaymentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse.PaymentComponent tgt = new org.hl7.fhir.r4b.model.ClaimResponse.PaymentComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasAdjustment())
      tgt.setAdjustment(Money43_N.convertMoney(src.getAdjustment()));
    if (src.hasAdjustmentReason())
      tgt.setAdjustmentReason(CodeableConcept43_N.convertCodeableConcept(src.getAdjustmentReason()));
    if (src.hasDate())
      tgt.setDateElement(Date43_N.convertDate(src.getDateElement()));
    if (src.hasAmount())
      tgt.setAmount(Money43_N.convertMoney(src.getAmount()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_N.convertIdentifier(src.getIdentifier()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ClaimResponse.NoteComponent convertNoteComponent(org.hl7.fhir.r4b.model.ClaimResponse.NoteComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse.NoteComponent tgt = new org.hl7.fhir.model.core.ClaimResponse.NoteComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasNumber())
      tgt.setNumberElement(PositiveInt43_N.convertPositiveInt(src.getNumberElement()));
    if (src.hasType())
      tgt.getType().addCoding().setSystem("http://hl7.org/fhir/note-type").setCode(src.getType().toCode());
    if (src.hasText())
      tgt.setTextElement(String43_N.convertStringToMarkdown(src.getTextElement()));
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept43_N.convertCodeableConcept(src.getLanguage()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse.NoteComponent convertNoteComponent(org.hl7.fhir.model.core.ClaimResponse.NoteComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse.NoteComponent tgt = new org.hl7.fhir.r4b.model.ClaimResponse.NoteComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasNumber())
      tgt.setNumberElement(PositiveInt43_N.convertPositiveInt(src.getNumberElement()));
    if (src.hasType() && src.getType().hasCoding("http://hl7.org/fhir/note-type"))
      tgt.setType(org.hl7.fhir.r4b.model.Enumerations.NoteType.fromCode(src.getType().getCode("http://hl7.org/fhir/note-type")));
    if (src.hasText())
      tgt.setTextElement(String43_N.convertString(src.getTextElement()));
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept43_N.convertCodeableConcept(src.getLanguage()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ClaimResponse.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r4b.model.ClaimResponse.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse.InsuranceComponent tgt = new org.hl7.fhir.model.core.ClaimResponse.InsuranceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasFocal())
      tgt.setFocalElement(Boolean43_N.convertBoolean(src.getFocalElement()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference43_N.convertReference(src.getCoverage()));
    if (src.hasBusinessArrangement())
      tgt.setBusinessArrangementElement(String43_N.convertString(src.getBusinessArrangementElement()));
    if (src.hasClaimResponse())
      tgt.setClaimResponse(Reference43_N.convertReference(src.getClaimResponse()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.model.core.ClaimResponse.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse.InsuranceComponent tgt = new org.hl7.fhir.r4b.model.ClaimResponse.InsuranceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasFocal())
      tgt.setFocalElement(Boolean43_N.convertBoolean(src.getFocalElement()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference43_N.convertReference(src.getCoverage()));
    if (src.hasBusinessArrangement())
      tgt.setBusinessArrangementElement(String43_N.convertString(src.getBusinessArrangementElement()));
    if (src.hasClaimResponse())
      tgt.setClaimResponse(Reference43_N.convertReference(src.getClaimResponse()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ClaimResponse.ErrorComponent convertErrorComponent(org.hl7.fhir.r4b.model.ClaimResponse.ErrorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse.ErrorComponent tgt = new org.hl7.fhir.model.core.ClaimResponse.ErrorComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasItemSequence())
      tgt.setItemSequenceElement(PositiveInt43_N.convertPositiveInt(src.getItemSequenceElement()));
    if (src.hasDetailSequence())
      tgt.setDetailSequenceElement(PositiveInt43_N.convertPositiveInt(src.getDetailSequenceElement()));
    if (src.hasSubDetailSequence())
      tgt.setSubDetailSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSubDetailSequenceElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClaimResponse.ErrorComponent convertErrorComponent(org.hl7.fhir.model.core.ClaimResponse.ErrorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClaimResponse.ErrorComponent tgt = new org.hl7.fhir.r4b.model.ClaimResponse.ErrorComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasItemSequence())
      tgt.setItemSequenceElement(PositiveInt43_N.convertPositiveInt(src.getItemSequenceElement()));
    if (src.hasDetailSequence())
      tgt.setDetailSequenceElement(PositiveInt43_N.convertPositiveInt(src.getDetailSequenceElement()));
    if (src.hasSubDetailSequence())
      tgt.setSubDetailSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSubDetailSequenceElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    return tgt;
  }
}