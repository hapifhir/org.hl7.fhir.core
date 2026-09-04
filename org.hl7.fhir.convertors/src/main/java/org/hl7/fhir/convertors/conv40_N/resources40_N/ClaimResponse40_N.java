package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Attachment40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Money40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.SimpleQuantity40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Date40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Decimal40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.PositiveInt40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.ClaimResponse;
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

public class ClaimResponse40_N {

  public static org.hl7.fhir.model.core.ClaimResponse convertClaimResponse(org.hl7.fhir.r4.model.ClaimResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse tgt = new org.hl7.fhir.model.core.ClaimResponse();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertClaimResponseStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasSubType())
      tgt.setSubType(CodeableConcept40_N.convertCodeableConcept(src.getSubType()));
    if (src.hasUse())
      tgt.setUseElement(convertUse(src.getUseElement()));
    if (src.hasPatient())
      tgt.setSubject(Reference40_N.convertReference(src.getPatient()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime40_N.convertDateTime(src.getCreatedElement()));
    if (src.hasInsurer())
      tgt.setInsurer(Reference40_N.convertReference(src.getInsurer()));
    if (src.hasRequestor())
      tgt.setRequestor(Reference40_N.convertReference(src.getRequestor()));
    if (src.hasRequest())
      tgt.setRequest(Reference40_N.convertReference(src.getRequest()));
    if (src.hasOutcome())
      tgt.setOutcomeElement(convertRemittanceOutcome(src.getOutcomeElement()));
    if (src.hasDisposition())
      tgt.setDispositionElement(String40_N.convertString(src.getDispositionElement()));
    if (src.hasPreAuthRef())
      tgt.setPreAuthRefElement(String40_N.convertString(src.getPreAuthRefElement()));
    if (src.hasPreAuthPeriod())
      tgt.setPreAuthPeriod(Period40_N.convertPeriod(src.getPreAuthPeriod()));
    if (src.hasPayeeType())
      tgt.setPayeeType(CodeableConcept40_N.convertCodeableConcept(src.getPayeeType()));
    for (org.hl7.fhir.r4.model.ClaimResponse.ItemComponent t : src.getItem()) tgt.addItem(convertItemComponent(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.AddedItemComponent t : src.getAddItem())
      tgt.addAddItem(convertAddedItemComponent(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.TotalComponent t : src.getTotal()) tgt.addTotal(convertTotalComponent(t));
    if (src.hasPayment())
      tgt.setPayment(convertPaymentComponent(src.getPayment()));
    if (src.hasFundsReserve())
      tgt.setFundsReserve(CodeableConcept40_N.convertCodeableConcept(src.getFundsReserve()));
    if (src.hasFormCode())
      tgt.setFormCode(CodeableConcept40_N.convertCodeableConcept(src.getFormCode()));
    if (src.hasForm())
      tgt.setForm(Attachment40_N.convertAttachment(src.getForm()));
    for (org.hl7.fhir.r4.model.ClaimResponse.NoteComponent t : src.getProcessNote())
      tgt.addProcessNote(convertNoteComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getCommunicationRequest())
      tgt.addCommunicationRequest(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.InsuranceComponent t : src.getInsurance())
      tgt.addInsurance(convertInsuranceComponent(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.ErrorComponent t : src.getError()) tgt.addError(convertErrorComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse convertClaimResponse(org.hl7.fhir.model.core.ClaimResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse tgt = new org.hl7.fhir.r4.model.ClaimResponse();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertClaimResponseStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasSubType())
      tgt.setSubType(CodeableConcept40_N.convertCodeableConcept(src.getSubType()));
    if (src.hasUse())
      tgt.setUseElement(convertUse(src.getUseElement()));
    if (src.hasSubject())
      tgt.setPatient(Reference40_N.convertReference(src.getSubject()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime40_N.convertDateTime(src.getCreatedElement()));
    if (src.hasInsurer())
      tgt.setInsurer(Reference40_N.convertReference(src.getInsurer()));
    if (src.hasRequestor())
      tgt.setRequestor(Reference40_N.convertReference(src.getRequestor()));
    if (src.hasRequest())
      tgt.setRequest(Reference40_N.convertReference(src.getRequest()));
    if (src.hasOutcome())
      tgt.setOutcomeElement(convertRemittanceOutcome(src.getOutcomeElement()));
    if (src.hasDisposition())
      tgt.setDispositionElement(String40_N.convertString(src.getDispositionElement()));
    if (src.hasPreAuthRef())
      tgt.setPreAuthRefElement(String40_N.convertString(src.getPreAuthRefElement()));
    if (src.hasPreAuthPeriod())
      tgt.setPreAuthPeriod(Period40_N.convertPeriod(src.getPreAuthPeriod()));
    if (src.hasPayeeType())
      tgt.setPayeeType(CodeableConcept40_N.convertCodeableConcept(src.getPayeeType()));
    for (org.hl7.fhir.model.core.ClaimResponse.ItemComponent t : src.getItemList()) tgt.addItem(convertItemComponent(t));
    for (org.hl7.fhir.model.core.ClaimResponse.AddedItemComponent t : src.getAddItemList())
      tgt.addAddItem(convertAddedItemComponent(t));
    for (org.hl7.fhir.model.core.ClaimResponse.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.model.core.ClaimResponse.TotalComponent t : src.getTotalList()) tgt.addTotal(convertTotalComponent(t));
    if (src.hasPayment())
      tgt.setPayment(convertPaymentComponent(src.getPayment()));
    if (src.hasFundsReserve())
      tgt.setFundsReserve(CodeableConcept40_N.convertCodeableConcept(src.getFundsReserve()));
    if (src.hasFormCode())
      tgt.setFormCode(CodeableConcept40_N.convertCodeableConcept(src.getFormCode()));
    if (src.hasForm())
      tgt.setForm(Attachment40_N.convertAttachment(src.getForm()));
    for (org.hl7.fhir.model.core.ClaimResponse.NoteComponent t : src.getProcessNoteList())
      tgt.addProcessNote(convertNoteComponent(t));
    for (org.hl7.fhir.model.core.Reference t : src.getCommunicationRequestList())
      tgt.addCommunicationRequest(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.ClaimResponse.InsuranceComponent t : src.getInsuranceList())
      tgt.addInsurance(convertInsuranceComponent(t));
    for (org.hl7.fhir.model.core.ClaimResponse.ErrorComponent t : src.getErrorList()) tgt.addError(convertErrorComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes> convertClaimResponseStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ClaimResponse.ClaimResponseStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.FinancialResourceStatusCodes> tgt = new Enumeration<>(new Enumerations.FinancialResourceStatusCodesEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ClaimResponse.ClaimResponseStatus> convertClaimResponseStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<ClaimResponse.ClaimResponseStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new ClaimResponse.ClaimResponseStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(ClaimResponse.ClaimResponseStatus.ACTIVE);
                  break;
              case CANCELLED:
                  tgt.setValue(ClaimResponse.ClaimResponseStatus.CANCELLED);
                  break;
              case DRAFT:
                  tgt.setValue(ClaimResponse.ClaimResponseStatus.DRAFT);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(ClaimResponse.ClaimResponseStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(ClaimResponse.ClaimResponseStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.Use> convertUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ClaimResponse.Use> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.Use> tgt = new Enumeration<>(new Enumerations.UseEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ClaimResponse.Use> convertUse(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.Use> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<ClaimResponse.Use> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new ClaimResponse.UseEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case CLAIM:
                  tgt.setValue(ClaimResponse.Use.CLAIM);
                  break;
              case PREAUTHORIZATION:
                  tgt.setValue(ClaimResponse.Use.PREAUTHORIZATION);
                  break;
              case PREDETERMINATION:
                  tgt.setValue(ClaimResponse.Use.PREDETERMINATION);
                  break;
              default:
                  tgt.setValue(ClaimResponse.Use.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ClaimProcessingCodes> convertRemittanceOutcome(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ClaimResponse.RemittanceOutcome> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.ClaimProcessingCodes> tgt = new Enumeration<>(new Enumerations.ClaimProcessingCodesEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ClaimResponse.RemittanceOutcome> convertRemittanceOutcome(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ClaimProcessingCodes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<ClaimResponse.RemittanceOutcome> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new ClaimResponse.RemittanceOutcomeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case QUEUED:
                  tgt.setValue(ClaimResponse.RemittanceOutcome.QUEUED);
                  break;
              case COMPLETE:
                  tgt.setValue(ClaimResponse.RemittanceOutcome.COMPLETE);
                  break;
              case ERROR:
                  tgt.setValue(ClaimResponse.RemittanceOutcome.ERROR);
                  break;
              case PARTIAL:
                  tgt.setValue(ClaimResponse.RemittanceOutcome.PARTIAL);
                  break;
              default:
                  tgt.setValue(ClaimResponse.RemittanceOutcome.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.ClaimResponse.ItemComponent convertItemComponent(org.hl7.fhir.r4.model.ClaimResponse.ItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse.ItemComponent tgt = new org.hl7.fhir.model.core.ClaimResponse.ItemComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasItemSequence())
      tgt.setItemSequenceElement(PositiveInt40_N.convertPositiveInt(src.getItemSequenceElement()));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumberList().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.ItemDetailComponent t : src.getDetail())
      tgt.addDetail(convertItemDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse.ItemComponent convertItemComponent(org.hl7.fhir.model.core.ClaimResponse.ItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse.ItemComponent tgt = new org.hl7.fhir.r4.model.ClaimResponse.ItemComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasItemSequence())
      tgt.setItemSequenceElement(PositiveInt40_N.convertPositiveInt(src.getItemSequenceElement()));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getNoteNumberList())
      tgt.getNoteNumber().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.ClaimResponse.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.model.core.ClaimResponse.ItemDetailComponent t : src.getDetailList())
      tgt.addDetail(convertItemDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ClaimResponse.AdjudicationComponent convertAdjudicationComponent(org.hl7.fhir.r4.model.ClaimResponse.AdjudicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse.AdjudicationComponent tgt = new org.hl7.fhir.model.core.ClaimResponse.AdjudicationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept40_N.convertCodeableConcept(src.getReason()));
    if (src.hasAmount())
      tgt.setAmount(Money40_N.convertMoney(src.getAmount()));
    if (src.hasValue())
      tgt.setQuantity(Decimal40_N.convertDecimalToQuantity(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse.AdjudicationComponent convertAdjudicationComponent(org.hl7.fhir.model.core.ClaimResponse.AdjudicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse.AdjudicationComponent tgt = new org.hl7.fhir.r4.model.ClaimResponse.AdjudicationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept40_N.convertCodeableConcept(src.getReason()));
    if (src.hasAmount())
      tgt.setAmount(Money40_N.convertMoney(src.getAmount()));
    if (src.hasQuantity())
      tgt.setValueElement(Decimal40_N.convertDecimal(src.getQuantity().getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ClaimResponse.ItemDetailComponent convertItemDetailComponent(org.hl7.fhir.r4.model.ClaimResponse.ItemDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse.ItemDetailComponent tgt = new org.hl7.fhir.model.core.ClaimResponse.ItemDetailComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasDetailSequence())
      tgt.setDetailSequenceElement(PositiveInt40_N.convertPositiveInt(src.getDetailSequenceElement()));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumberList().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.SubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse.ItemDetailComponent convertItemDetailComponent(org.hl7.fhir.model.core.ClaimResponse.ItemDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse.ItemDetailComponent tgt = new org.hl7.fhir.r4.model.ClaimResponse.ItemDetailComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasDetailSequence())
      tgt.setDetailSequenceElement(PositiveInt40_N.convertPositiveInt(src.getDetailSequenceElement()));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getNoteNumberList())
      tgt.getNoteNumber().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.ClaimResponse.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.model.core.ClaimResponse.SubDetailComponent t : src.getSubDetailList())
      tgt.addSubDetail(convertSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ClaimResponse.SubDetailComponent convertSubDetailComponent(org.hl7.fhir.r4.model.ClaimResponse.SubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse.SubDetailComponent tgt = new org.hl7.fhir.model.core.ClaimResponse.SubDetailComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSubDetailSequence())
      tgt.setSubDetailSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSubDetailSequenceElement()));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumberList().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse.SubDetailComponent convertSubDetailComponent(org.hl7.fhir.model.core.ClaimResponse.SubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse.SubDetailComponent tgt = new org.hl7.fhir.r4.model.ClaimResponse.SubDetailComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSubDetailSequence())
      tgt.setSubDetailSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSubDetailSequenceElement()));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getNoteNumberList())
      tgt.getNoteNumber().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.ClaimResponse.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ClaimResponse.AddedItemComponent convertAddedItemComponent(org.hl7.fhir.r4.model.ClaimResponse.AddedItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse.AddedItemComponent tgt = new org.hl7.fhir.model.core.ClaimResponse.AddedItemComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getItemSequence())
      tgt.getItemSequenceList().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getDetailSequence())
      tgt.getDetailSequenceList().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getSubdetailSequence())
      tgt.getSubdetailSequenceList().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getProvider()) tgt.addProvider(Reference40_N.convertReference(t));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept40_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasServiced())
      tgt.setServiced(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getServiced()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getLocation()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money40_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal40_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money40_N.convertMoney(src.getNet()));
    if (src.hasBodySite())
      tgt.getBodySiteFirstRep().addSite(CodeableConcept40_N.convertCodeableConceptToCodeableReference(src.getBodySite()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSubSite())
      tgt.getBodySiteFirstRep().addSubSite(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumberList().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.AddedItemDetailComponent t : src.getDetail())
      tgt.addDetail(convertAddedItemDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse.AddedItemComponent convertAddedItemComponent(org.hl7.fhir.model.core.ClaimResponse.AddedItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse.AddedItemComponent tgt = new org.hl7.fhir.r4.model.ClaimResponse.AddedItemComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getItemSequenceList())
      tgt.getItemSequence().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getDetailSequenceList())
      tgt.getDetailSequence().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getSubdetailSequenceList())
      tgt.getSubdetailSequence().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.Reference t : src.getProviderList()) tgt.addProvider(Reference40_N.convertReference(t));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept40_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getModifierList())
      tgt.addModifier(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getProgramCodeList())
      tgt.addProgramCode(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasServiced())
      tgt.setServiced(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getServiced()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getLocation()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money40_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal40_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money40_N.convertMoney(src.getNet()));
    if (src.getBodySiteFirstRep().hasSite())
      tgt.setBodySite(CodeableConcept40_N.convertCodeableReferenceToCodeableConcept(src.getBodySiteFirstRep().getSiteFirstRep()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getBodySiteFirstRep().getSubSiteList())
      tgt.addSubSite(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getNoteNumberList())
      tgt.getNoteNumber().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.ClaimResponse.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.model.core.ClaimResponse.AddedItemDetailComponent t : src.getDetailList())
      tgt.addDetail(convertAddedItemDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ClaimResponse.AddedItemDetailComponent convertAddedItemDetailComponent(org.hl7.fhir.r4.model.ClaimResponse.AddedItemDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse.AddedItemDetailComponent tgt = new org.hl7.fhir.model.core.ClaimResponse.AddedItemDetailComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept40_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money40_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal40_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money40_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumberList().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.AddedItemSubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertAddedItemSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse.AddedItemDetailComponent convertAddedItemDetailComponent(org.hl7.fhir.model.core.ClaimResponse.AddedItemDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse.AddedItemDetailComponent tgt = new org.hl7.fhir.r4.model.ClaimResponse.AddedItemDetailComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept40_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getModifierList())
      tgt.addModifier(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money40_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal40_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money40_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getNoteNumberList())
      tgt.getNoteNumber().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.ClaimResponse.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.model.core.ClaimResponse.AddedItemSubDetailComponent t : src.getSubDetailList())
      tgt.addSubDetail(convertAddedItemSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ClaimResponse.AddedItemSubDetailComponent convertAddedItemSubDetailComponent(org.hl7.fhir.r4.model.ClaimResponse.AddedItemSubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse.AddedItemSubDetailComponent tgt = new org.hl7.fhir.model.core.ClaimResponse.AddedItemSubDetailComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept40_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money40_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal40_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money40_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumberList().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.ClaimResponse.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse.AddedItemSubDetailComponent convertAddedItemSubDetailComponent(org.hl7.fhir.model.core.ClaimResponse.AddedItemSubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse.AddedItemSubDetailComponent tgt = new org.hl7.fhir.r4.model.ClaimResponse.AddedItemSubDetailComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept40_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getModifierList())
      tgt.addModifier(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money40_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal40_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money40_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getNoteNumberList())
      tgt.getNoteNumber().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.ClaimResponse.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ClaimResponse.TotalComponent convertTotalComponent(org.hl7.fhir.r4.model.ClaimResponse.TotalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse.TotalComponent tgt = new org.hl7.fhir.model.core.ClaimResponse.TotalComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasAmount())
      tgt.setAmount(Money40_N.convertMoney(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse.TotalComponent convertTotalComponent(org.hl7.fhir.model.core.ClaimResponse.TotalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse.TotalComponent tgt = new org.hl7.fhir.r4.model.ClaimResponse.TotalComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasAmount())
      tgt.setAmount(Money40_N.convertMoney(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ClaimResponse.PaymentComponent convertPaymentComponent(org.hl7.fhir.r4.model.ClaimResponse.PaymentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse.PaymentComponent tgt = new org.hl7.fhir.model.core.ClaimResponse.PaymentComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasAdjustment())
      tgt.setAdjustment(Money40_N.convertMoney(src.getAdjustment()));
    if (src.hasAdjustmentReason())
      tgt.setAdjustmentReason(CodeableConcept40_N.convertCodeableConcept(src.getAdjustmentReason()));
    if (src.hasDate())
      tgt.setDateElement(Date40_N.convertDate(src.getDateElement()));
    if (src.hasAmount())
      tgt.setAmount(Money40_N.convertMoney(src.getAmount()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_N.convertIdentifier(src.getIdentifier()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse.PaymentComponent convertPaymentComponent(org.hl7.fhir.model.core.ClaimResponse.PaymentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse.PaymentComponent tgt = new org.hl7.fhir.r4.model.ClaimResponse.PaymentComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasAdjustment())
      tgt.setAdjustment(Money40_N.convertMoney(src.getAdjustment()));
    if (src.hasAdjustmentReason())
      tgt.setAdjustmentReason(CodeableConcept40_N.convertCodeableConcept(src.getAdjustmentReason()));
    if (src.hasDate())
      tgt.setDateElement(Date40_N.convertDate(src.getDateElement()));
    if (src.hasAmount())
      tgt.setAmount(Money40_N.convertMoney(src.getAmount()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_N.convertIdentifier(src.getIdentifier()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ClaimResponse.NoteComponent convertNoteComponent(org.hl7.fhir.r4.model.ClaimResponse.NoteComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse.NoteComponent tgt = new org.hl7.fhir.model.core.ClaimResponse.NoteComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasNumber())
      tgt.setNumberElement(PositiveInt40_N.convertPositiveInt(src.getNumberElement()));
    if (src.hasType())
      tgt.getType().addCoding().setSystem("http://hl7.org/fhir/note-type").setCode(src.getType().toCode());
    if (src.hasText())
      tgt.setTextElement(String40_N.convertStringToMarkdown(src.getTextElement()));
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept40_N.convertCodeableConcept(src.getLanguage()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse.NoteComponent convertNoteComponent(org.hl7.fhir.model.core.ClaimResponse.NoteComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse.NoteComponent tgt = new org.hl7.fhir.r4.model.ClaimResponse.NoteComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasNumber())
      tgt.setNumberElement(PositiveInt40_N.convertPositiveInt(src.getNumberElement()));
    if (src.hasType() && src.getType().hasCoding("http://hl7.org/fhir/note-type"))
      tgt.setType(org.hl7.fhir.r4.model.Enumerations.NoteType.fromCode(src.getType().getCode("http://hl7.org/fhir/note-type")));
    if (src.hasText())
      tgt.setTextElement(String40_N.convertString(src.getTextElement()));
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept40_N.convertCodeableConcept(src.getLanguage()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ClaimResponse.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r4.model.ClaimResponse.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse.InsuranceComponent tgt = new org.hl7.fhir.model.core.ClaimResponse.InsuranceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasFocal())
      tgt.setFocalElement(Boolean40_N.convertBoolean(src.getFocalElement()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference40_N.convertReference(src.getCoverage()));
    if (src.hasBusinessArrangement())
      tgt.setBusinessArrangementElement(String40_N.convertString(src.getBusinessArrangementElement()));
    if (src.hasClaimResponse())
      tgt.setClaimResponse(Reference40_N.convertReference(src.getClaimResponse()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.model.core.ClaimResponse.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse.InsuranceComponent tgt = new org.hl7.fhir.r4.model.ClaimResponse.InsuranceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasFocal())
      tgt.setFocalElement(Boolean40_N.convertBoolean(src.getFocalElement()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference40_N.convertReference(src.getCoverage()));
    if (src.hasBusinessArrangement())
      tgt.setBusinessArrangementElement(String40_N.convertString(src.getBusinessArrangementElement()));
    if (src.hasClaimResponse())
      tgt.setClaimResponse(Reference40_N.convertReference(src.getClaimResponse()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ClaimResponse.ErrorComponent convertErrorComponent(org.hl7.fhir.r4.model.ClaimResponse.ErrorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ClaimResponse.ErrorComponent tgt = new org.hl7.fhir.model.core.ClaimResponse.ErrorComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasItemSequence())
      tgt.setItemSequenceElement(PositiveInt40_N.convertPositiveInt(src.getItemSequenceElement()));
    if (src.hasDetailSequence())
      tgt.setDetailSequenceElement(PositiveInt40_N.convertPositiveInt(src.getDetailSequenceElement()));
    if (src.hasSubDetailSequence())
      tgt.setSubDetailSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSubDetailSequenceElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ClaimResponse.ErrorComponent convertErrorComponent(org.hl7.fhir.model.core.ClaimResponse.ErrorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ClaimResponse.ErrorComponent tgt = new org.hl7.fhir.r4.model.ClaimResponse.ErrorComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasItemSequence())
      tgt.setItemSequenceElement(PositiveInt40_N.convertPositiveInt(src.getItemSequenceElement()));
    if (src.hasDetailSequence())
      tgt.setDetailSequenceElement(PositiveInt40_N.convertPositiveInt(src.getDetailSequenceElement()));
    if (src.hasSubDetailSequence())
      tgt.setSubDetailSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSubDetailSequenceElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    return tgt;
  }
}