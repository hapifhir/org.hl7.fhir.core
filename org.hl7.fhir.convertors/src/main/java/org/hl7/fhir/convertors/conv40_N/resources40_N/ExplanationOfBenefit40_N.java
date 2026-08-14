package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Attachment40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Coding40_N;
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
import org.hl7.fhir.model.core.CodeableConcept;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;
import org.hl7.fhir.model.core.ExplanationOfBenefit;

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

public class ExplanationOfBenefit40_N {

  public static org.hl7.fhir.model.core.ExplanationOfBenefit convertExplanationOfBenefit(org.hl7.fhir.r4.model.ExplanationOfBenefit src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertExplanationOfBenefitStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasSubType())
      tgt.setSubType(CodeableConcept40_N.convertCodeableConcept(src.getSubType()));
    if (src.hasUse())
      tgt.setUseElement(convertUse(src.getUseElement()));
    if (src.hasPatient())
      tgt.setSubject(Reference40_N.convertReference(src.getPatient()));
    if (src.hasBillablePeriod())
      tgt.setBillablePeriod(Period40_N.convertPeriod(src.getBillablePeriod()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime40_N.convertDateTime(src.getCreatedElement()));
    if (src.hasEnterer())
      tgt.setEnterer(Reference40_N.convertReference(src.getEnterer()));
    if (src.hasInsurer())
      tgt.setInsurer(Reference40_N.convertReference(src.getInsurer()));
    if (src.hasProvider())
      tgt.setProvider(Reference40_N.convertReference(src.getProvider()));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept40_N.convertCodeableConcept(src.getPriority()));
    if (src.hasFundsReserveRequested())
      tgt.setFundsReserveRequested(CodeableConcept40_N.convertCodeableConcept(src.getFundsReserveRequested()));
    if (src.hasFundsReserve())
      tgt.setFundsReserve(CodeableConcept40_N.convertCodeableConcept(src.getFundsReserve()));
    for (org.hl7.fhir.r4.model.ExplanationOfBenefit.RelatedClaimComponent t : src.getRelated())
      tgt.addRelated(convertRelatedClaimComponent(t));
    if (src.hasPrescription())
      tgt.setRequest(Reference40_N.convertReference(src.getPrescription()));
    if (src.hasPayee())
      tgt.setPayee(convertPayeeComponent(src.getPayee()));
    if (src.hasReferral())
      tgt.setReferral(Reference40_N.convertReference(src.getReferral()));
    if (src.hasFacility())
      tgt.setFacility(Reference40_N.convertReference(src.getFacility()));
    if (src.hasClaim())
      tgt.setClaim(Reference40_N.convertReference(src.getClaim()));
    if (src.hasClaimResponse())
      tgt.setClaimResponse(Reference40_N.convertReference(src.getClaimResponse()));
    if (src.hasOutcome())
      tgt.setOutcomeElement(convertRemittanceOutcome(src.getOutcomeElement()));
    if (src.hasDisposition())
      tgt.setDispositionElement(String40_N.convertString(src.getDispositionElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getPreAuthRef())
      tgt.getPreAuthRefList().add(String40_N.convertString(t));
    for (org.hl7.fhir.r4.model.Period t : src.getPreAuthRefPeriod())
      tgt.addPreAuthRefPeriod(Period40_N.convertPeriod(t));
    for (org.hl7.fhir.r4.model.ExplanationOfBenefit.CareTeamComponent t : src.getCareTeam())
      tgt.addCareTeam(convertCareTeamComponent(t));
    for (org.hl7.fhir.r4.model.ExplanationOfBenefit.SupportingInformationComponent t : src.getSupportingInfo())
      tgt.addSupportingInfo(convertSupportingInformationComponent(t));
    for (org.hl7.fhir.r4.model.ExplanationOfBenefit.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.r4.model.ExplanationOfBenefit.ProcedureComponent t : src.getProcedure())
      tgt.addProcedure(convertProcedureComponent(t));
    if (src.hasPrecedence())
      tgt.setPrecedenceElement(PositiveInt40_N.convertPositiveInt(src.getPrecedenceElement()));
    for (org.hl7.fhir.r4.model.ExplanationOfBenefit.InsuranceComponent t : src.getInsurance())
      tgt.addInsurance(convertInsuranceComponent(t));
    if (src.hasAccident())
      tgt.setAccident(convertAccidentComponent(src.getAccident()));
    for (org.hl7.fhir.r4.model.ExplanationOfBenefit.ItemComponent t : src.getItem())
      tgt.addItem(convertItemComponent(t));
    for (org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemComponent t : src.getAddItem())
      tgt.addAddItem(convertAddedItemComponent(t));
    for (org.hl7.fhir.r4.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4.model.ExplanationOfBenefit.TotalComponent t : src.getTotal())
      tgt.addTotal(convertTotalComponent(t));
    if (src.hasPayment())
      tgt.setPayment(convertPaymentComponent(src.getPayment()));
    if (src.hasFormCode())
      tgt.setFormCode(CodeableConcept40_N.convertCodeableConcept(src.getFormCode()));
    if (src.hasForm())
      tgt.setForm(Attachment40_N.convertAttachment(src.getForm()));
    for (org.hl7.fhir.r4.model.ExplanationOfBenefit.NoteComponent t : src.getProcessNote())
      tgt.addProcessNote(convertNoteComponent(t));
    if (src.hasBenefitPeriod())
      tgt.setBenefitPeriod(Period40_N.convertPeriod(src.getBenefitPeriod()));
    for (org.hl7.fhir.r4.model.ExplanationOfBenefit.BenefitBalanceComponent t : src.getBenefitBalance())
      tgt.addBenefitBalance(convertBenefitBalanceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExplanationOfBenefit convertExplanationOfBenefit(org.hl7.fhir.model.core.ExplanationOfBenefit src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExplanationOfBenefit tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertExplanationOfBenefitStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasSubType())
      tgt.setSubType(CodeableConcept40_N.convertCodeableConcept(src.getSubType()));
    if (src.hasUse())
      tgt.setUseElement(convertUse(src.getUseElement()));
    if (src.hasSubject())
      tgt.setPatient(Reference40_N.convertReference(src.getSubject()));
    if (src.hasBillablePeriod())
      tgt.setBillablePeriod(Period40_N.convertPeriod(src.getBillablePeriod()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime40_N.convertDateTime(src.getCreatedElement()));
    if (src.hasEnterer())
      tgt.setEnterer(Reference40_N.convertReference(src.getEnterer()));
    if (src.hasInsurer())
      tgt.setInsurer(Reference40_N.convertReference(src.getInsurer()));
    if (src.hasProvider())
      tgt.setProvider(Reference40_N.convertReference(src.getProvider()));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept40_N.convertCodeableConcept(src.getPriority()));
    if (src.hasFundsReserveRequested())
      tgt.setFundsReserveRequested(CodeableConcept40_N.convertCodeableConcept(src.getFundsReserveRequested()));
    if (src.hasFundsReserve())
      tgt.setFundsReserve(CodeableConcept40_N.convertCodeableConcept(src.getFundsReserve()));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.RelatedClaimComponent t : src.getRelatedList())
      tgt.addRelated(convertRelatedClaimComponent(t));
    if (src.hasRequest())
      tgt.setPrescription(Reference40_N.convertReference(src.getRequest()));
    if (src.hasPayee())
      tgt.setPayee(convertPayeeComponent(src.getPayee()));
    if (src.hasReferral())
      tgt.setReferral(Reference40_N.convertReference(src.getReferral()));
    if (src.hasFacility())
      tgt.setFacility(Reference40_N.convertReference(src.getFacility()));
    if (src.hasClaim())
      tgt.setClaim(Reference40_N.convertReference(src.getClaim()));
    if (src.hasClaimResponse())
      tgt.setClaimResponse(Reference40_N.convertReference(src.getClaimResponse()));
    if (src.hasOutcome())
      tgt.setOutcomeElement(convertRemittanceOutcome(src.getOutcomeElement()));
    if (src.hasDisposition())
      tgt.setDispositionElement(String40_N.convertString(src.getDispositionElement()));
    for (org.hl7.fhir.model.core.StringType t : src.getPreAuthRefList())
      tgt.getPreAuthRef().add(String40_N.convertString(t));
    for (org.hl7.fhir.model.core.Period t : src.getPreAuthRefPeriodList())
      tgt.addPreAuthRefPeriod(Period40_N.convertPeriod(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.CareTeamComponent t : src.getCareTeamList())
      tgt.addCareTeam(convertCareTeamComponent(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.SupportingInformationComponent t : src.getSupportingInfoList())
      tgt.addSupportingInfo(convertSupportingInformationComponent(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.DiagnosisComponent t : src.getDiagnosisList())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.ProcedureComponent t : src.getProcedureList())
      tgt.addProcedure(convertProcedureComponent(t));
    if (src.hasPrecedence())
      tgt.setPrecedenceElement(PositiveInt40_N.convertPositiveInt(src.getPrecedenceElement()));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.InsuranceComponent t : src.getInsuranceList())
      tgt.addInsurance(convertInsuranceComponent(t));
    if (src.hasAccident())
      tgt.setAccident(convertAccidentComponent(src.getAccident()));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.ItemComponent t : src.getItemList())
      tgt.addItem(convertItemComponent(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemComponent t : src.getAddItemList())
      tgt.addAddItem(convertAddedItemComponent(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.TotalComponent t : src.getTotalList())
      tgt.addTotal(convertTotalComponent(t));
    if (src.hasPayment())
      tgt.setPayment(convertPaymentComponent(src.getPayment()));
    if (src.hasFormCode())
      tgt.setFormCode(CodeableConcept40_N.convertCodeableConcept(src.getFormCode()));
    if (src.hasForm())
      tgt.setForm(Attachment40_N.convertAttachment(src.getForm()));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.NoteComponent t : src.getProcessNoteList())
      tgt.addProcessNote(convertNoteComponent(t));
    if (src.hasBenefitPeriod())
      tgt.setBenefitPeriod(Period40_N.convertPeriod(src.getBenefitPeriod()));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.BenefitBalanceComponent t : src.getBenefitBalanceList())
      tgt.addBenefitBalance(convertBenefitBalanceComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ExplanationOfBenefit.ExplanationOfBenefitStatus> convertExplanationOfBenefitStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExplanationOfBenefit.ExplanationOfBenefitStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<ExplanationOfBenefit.ExplanationOfBenefitStatus> tgt = new Enumeration<>(new ExplanationOfBenefit.ExplanationOfBenefitStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(ExplanationOfBenefit.ExplanationOfBenefitStatus.ACTIVE);
                  break;
              case CANCELLED:
                  tgt.setValue(ExplanationOfBenefit.ExplanationOfBenefitStatus.CANCELLED);
                  break;
              case DRAFT:
                  tgt.setValue(ExplanationOfBenefit.ExplanationOfBenefitStatus.DRAFT);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(ExplanationOfBenefit.ExplanationOfBenefitStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(ExplanationOfBenefit.ExplanationOfBenefitStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExplanationOfBenefit.ExplanationOfBenefitStatus> convertExplanationOfBenefitStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ExplanationOfBenefit.ExplanationOfBenefitStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExplanationOfBenefit.ExplanationOfBenefitStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ExplanationOfBenefit.ExplanationOfBenefitStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.ExplanationOfBenefitStatus.ACTIVE);
                  break;
              case CANCELLED:
                  tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.ExplanationOfBenefitStatus.CANCELLED);
                  break;
              case DRAFT:
                  tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.ExplanationOfBenefitStatus.DRAFT);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.ExplanationOfBenefitStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.ExplanationOfBenefitStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.Use> convertUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExplanationOfBenefit.Use> src) throws FHIRException {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExplanationOfBenefit.Use> convertUse(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.Use> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExplanationOfBenefit.Use> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ExplanationOfBenefit.UseEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case CLAIM:
                  tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.Use.CLAIM);
                  break;
              case PREAUTHORIZATION:
                  tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.Use.PREAUTHORIZATION);
                  break;
              case PREDETERMINATION:
                  tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.Use.PREDETERMINATION);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.Use.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ClaimProcessingCodes> convertRemittanceOutcome(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExplanationOfBenefit.RemittanceOutcome> src) throws FHIRException {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExplanationOfBenefit.RemittanceOutcome> convertRemittanceOutcome(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ClaimProcessingCodes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExplanationOfBenefit.RemittanceOutcome> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ExplanationOfBenefit.RemittanceOutcomeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case QUEUED:
                  tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.RemittanceOutcome.QUEUED);
                  break;
              case COMPLETE:
                  tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.RemittanceOutcome.COMPLETE);
                  break;
              case ERROR:
                  tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.RemittanceOutcome.ERROR);
                  break;
              case PARTIAL:
                  tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.RemittanceOutcome.PARTIAL);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.RemittanceOutcome.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.RelatedClaimComponent convertRelatedClaimComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.RelatedClaimComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.RelatedClaimComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.RelatedClaimComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasClaim())
      tgt.setClaim(Reference40_N.convertReference(src.getClaim()));
    if (src.hasRelationship())
      tgt.setRelationship(CodeableConcept40_N.convertCodeableConcept(src.getRelationship()));
    if (src.hasReference())
      tgt.setReference(Identifier40_N.convertIdentifier(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExplanationOfBenefit.RelatedClaimComponent convertRelatedClaimComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.RelatedClaimComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExplanationOfBenefit.RelatedClaimComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.RelatedClaimComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasClaim())
      tgt.setClaim(Reference40_N.convertReference(src.getClaim()));
    if (src.hasRelationship())
      tgt.setRelationship(CodeableConcept40_N.convertCodeableConcept(src.getRelationship()));
    if (src.hasReference())
      tgt.setReference(Identifier40_N.convertIdentifier(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.PayeeComponent convertPayeeComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.PayeeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.PayeeComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.PayeeComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasParty())
      tgt.setParty(Reference40_N.convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExplanationOfBenefit.PayeeComponent convertPayeeComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.PayeeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExplanationOfBenefit.PayeeComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.PayeeComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasParty())
      tgt.setParty(Reference40_N.convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.CareTeamComponent convertCareTeamComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.CareTeamComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.CareTeamComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.CareTeamComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasProvider())
      tgt.setProvider(Reference40_N.convertReference(src.getProvider()));
    if (src.hasRole())
      tgt.setRole(CodeableConcept40_N.convertCodeableConcept(src.getRole()));
    if (src.hasQualification())
      tgt.setSpecialty(CodeableConcept40_N.convertCodeableConcept(src.getQualification()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExplanationOfBenefit.CareTeamComponent convertCareTeamComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.CareTeamComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExplanationOfBenefit.CareTeamComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.CareTeamComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasProvider())
      tgt.setProvider(Reference40_N.convertReference(src.getProvider()));
    if (src.hasRole())
      tgt.setRole(CodeableConcept40_N.convertCodeableConcept(src.getRole()));
    if (src.hasSpecialty())
      tgt.setQualification(CodeableConcept40_N.convertCodeableConcept(src.getSpecialty()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.SupportingInformationComponent convertSupportingInformationComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.SupportingInformationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.SupportingInformationComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.SupportingInformationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getTiming()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    if (src.hasReason())
      tgt.setReason(Coding40_N.convertCoding(src.getReason()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExplanationOfBenefit.SupportingInformationComponent convertSupportingInformationComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.SupportingInformationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExplanationOfBenefit.SupportingInformationComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.SupportingInformationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getTiming()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    if (src.hasReason())
      tgt.setReason(Coding40_N.convertCoding(src.getReason()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.DiagnosisComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.DiagnosisComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasDiagnosisReference()) {
      tgt.getDiagnosis().setReference(Reference40_N.convertReference(src.getDiagnosisReference()));
    } else if (src.hasDiagnosisCodeableConcept()) {
      tgt.getDiagnosis().setConcept(CodeableConcept40_N.convertCodeableConcept(src.getDiagnosisCodeableConcept()));
    }
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasOnAdmission())
      tgt.setOnAdmission(CodeableConcept40_N.convertCodeableConcept(src.getOnAdmission()));
//    if (src.hasPackageCode())
//      tgt.setPackageCode(CodeableConcept40_N.convertCodeableConcept(src.getPackageCode()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExplanationOfBenefit.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExplanationOfBenefit.DiagnosisComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.DiagnosisComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasDiagnosis())
      tgt.setDiagnosis(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getDiagnosis()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTypeList())
      tgt.addType(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasOnAdmission())
      tgt.setOnAdmission(CodeableConcept40_N.convertCodeableConcept(src.getOnAdmission()));
//    if (src.hasPackageCode())
//      tgt.setPackageCode(CodeableConcept40_N.convertCodeableConcept(src.getPackageCode()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.ProcedureComponent convertProcedureComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.ProcedureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.ProcedureComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.ProcedureComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasProcedureReference())
      tgt.getProcedure().setReference(Reference40_N.convertReference(src.getProcedureReference()));
    if (src.hasProcedureCodeableConcept())
      tgt.getProcedure().setConcept(CodeableConcept40_N.convertCodeableConcept(src.getProcedureCodeableConcept()));
    for (org.hl7.fhir.r4.model.Reference t : src.getUdi()) tgt.addUdi(Reference40_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExplanationOfBenefit.ProcedureComponent convertProcedureComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.ProcedureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExplanationOfBenefit.ProcedureComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.ProcedureComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTypeList())
      tgt.addType(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasProcedure())
      tgt.setProcedure(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getProcedure()));
    for (org.hl7.fhir.model.core.Reference t : src.getUdiList()) tgt.addUdi(Reference40_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.InsuranceComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.InsuranceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasFocal())
      tgt.setFocalElement(Boolean40_N.convertBoolean(src.getFocalElement()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference40_N.convertReference(src.getCoverage()));
    for (org.hl7.fhir.r4.model.StringType t : src.getPreAuthRef())
      tgt.getPreAuthRefList().add(String40_N.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExplanationOfBenefit.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExplanationOfBenefit.InsuranceComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.InsuranceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasFocal())
      tgt.setFocalElement(Boolean40_N.convertBoolean(src.getFocalElement()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference40_N.convertReference(src.getCoverage()));
    for (org.hl7.fhir.model.core.StringType t : src.getPreAuthRefList())
      tgt.getPreAuthRef().add(String40_N.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.AccidentComponent convertAccidentComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.AccidentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.AccidentComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.AccidentComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(Date40_N.convertDate(src.getDateElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getLocation()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExplanationOfBenefit.AccidentComponent convertAccidentComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.AccidentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExplanationOfBenefit.AccidentComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.AccidentComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(Date40_N.convertDate(src.getDateElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getLocation()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.ItemComponent convertItemComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.ItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.ItemComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.ItemComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getCareTeamSequence())
      tgt.getCareTeamSequenceList().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getDiagnosisSequence())
      tgt.getDiagnosisSequenceList().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getProcedureSequence())
      tgt.getProcedureSequenceList().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getInformationSequence())
      tgt.getInformationSequenceList().add(PositiveInt40_N.convertPositiveInt(t));
    if (src.hasRevenue())
      tgt.setRevenue(CodeableConcept40_N.convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
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
    for (org.hl7.fhir.r4.model.Reference t : src.getUdi()) tgt.addUdi(Reference40_N.convertReference(t));
    if (src.hasBodySite())
      tgt.getBodySiteFirstRep().addSite(CodeableConcept40_N.convertCodeableConceptToCodeableReference(src.getBodySite()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSubSite())
      tgt.getBodySiteFirstRep().addSubSite(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getEncounter()) tgt.addEncounter(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumberList().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4.model.ExplanationOfBenefit.DetailComponent t : src.getDetail())
      tgt.addDetail(convertDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExplanationOfBenefit.ItemComponent convertItemComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.ItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExplanationOfBenefit.ItemComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.ItemComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getCareTeamSequenceList())
      tgt.getCareTeamSequence().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getDiagnosisSequenceList())
      tgt.getDiagnosisSequence().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getProcedureSequenceList())
      tgt.getProcedureSequence().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getInformationSequenceList())
      tgt.getInformationSequence().add(PositiveInt40_N.convertPositiveInt(t));
    if (src.hasRevenue())
      tgt.setRevenue(CodeableConcept40_N.convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
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
    for (org.hl7.fhir.model.core.Reference t : src.getUdiList()) tgt.addUdi(Reference40_N.convertReference(t));
    if (src.getBodySiteFirstRep().hasSite())
      tgt.setBodySite(CodeableConcept40_N.convertCodeableReferenceToCodeableConcept(src.getBodySiteFirstRep().getSiteFirstRep()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getBodySiteFirstRep().getSubSiteList())
      tgt.addSubSite(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.Reference t : src.getEncounterList()) tgt.addEncounter(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getNoteNumberList())
      tgt.getNoteNumber().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.DetailComponent t : src.getDetailList())
      tgt.addDetail(convertDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.AdjudicationComponent convertAdjudicationComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.AdjudicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.AdjudicationComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.AdjudicationComponent();
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

  public static org.hl7.fhir.r4.model.ExplanationOfBenefit.AdjudicationComponent convertAdjudicationComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.AdjudicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExplanationOfBenefit.AdjudicationComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.AdjudicationComponent();
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

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.DetailComponent convertDetailComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.DetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.DetailComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.DetailComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasRevenue())
      tgt.setRevenue(CodeableConcept40_N.convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept40_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money40_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal40_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money40_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.r4.model.Reference t : src.getUdi()) tgt.addUdi(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumberList().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4.model.ExplanationOfBenefit.SubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExplanationOfBenefit.DetailComponent convertDetailComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.DetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExplanationOfBenefit.DetailComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.DetailComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasRevenue())
      tgt.setRevenue(CodeableConcept40_N.convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept40_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getModifierList())
      tgt.addModifier(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getProgramCodeList())
      tgt.addProgramCode(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money40_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal40_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money40_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.model.core.Reference t : src.getUdiList()) tgt.addUdi(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getNoteNumberList())
      tgt.getNoteNumber().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.SubDetailComponent t : src.getSubDetailList())
      tgt.addSubDetail(convertSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.SubDetailComponent convertSubDetailComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.SubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.SubDetailComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.SubDetailComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasRevenue())
      tgt.setRevenue(CodeableConcept40_N.convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept40_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money40_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal40_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money40_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.r4.model.Reference t : src.getUdi()) tgt.addUdi(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumberList().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExplanationOfBenefit.SubDetailComponent convertSubDetailComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.SubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExplanationOfBenefit.SubDetailComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.SubDetailComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasRevenue())
      tgt.setRevenue(CodeableConcept40_N.convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept40_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getModifierList())
      tgt.addModifier(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getProgramCodeList())
      tgt.addProgramCode(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money40_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal40_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money40_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.model.core.Reference t : src.getUdiList()) tgt.addUdi(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getNoteNumberList())
      tgt.getNoteNumber().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemComponent convertAddedItemComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getItemSequence())
      tgt.getItemSequenceList().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getDetailSequence())
      tgt.getDetailSequenceList().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getSubDetailSequence())
      tgt.getSubDetailSequenceList().add(PositiveInt40_N.convertPositiveInt(t));
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
    for (org.hl7.fhir.r4.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemDetailComponent t : src.getDetail())
      tgt.addDetail(convertAddedItemDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemComponent convertAddedItemComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getItemSequenceList())
      tgt.getItemSequence().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getDetailSequenceList())
      tgt.getDetailSequence().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getSubDetailSequenceList())
      tgt.getSubDetailSequence().add(PositiveInt40_N.convertPositiveInt(t));
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
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemDetailComponent t : src.getDetailList())
      tgt.addDetail(convertAddedItemDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemDetailComponent convertAddedItemDetailComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemDetailComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemDetailComponent();
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
    for (org.hl7.fhir.r4.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertAddedItemDetailSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemDetailComponent convertAddedItemDetailComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemDetailComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemDetailComponent();
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
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemDetailSubDetailComponent t : src.getSubDetailList())
      tgt.addSubDetail(convertAddedItemDetailSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemDetailSubDetailComponent convertAddedItemDetailSubDetailComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemDetailSubDetailComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemDetailSubDetailComponent();
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
    for (org.hl7.fhir.r4.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent convertAddedItemDetailSubDetailComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemDetailSubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent();
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
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.TotalComponent convertTotalComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.TotalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.TotalComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.TotalComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasAmount())
      tgt.setAmount(Money40_N.convertMoney(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExplanationOfBenefit.TotalComponent convertTotalComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.TotalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExplanationOfBenefit.TotalComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.TotalComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasAmount())
      tgt.setAmount(Money40_N.convertMoney(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.PaymentComponent convertPaymentComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.PaymentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.PaymentComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.PaymentComponent();
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

  public static org.hl7.fhir.r4.model.ExplanationOfBenefit.PaymentComponent convertPaymentComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.PaymentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExplanationOfBenefit.PaymentComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.PaymentComponent();
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

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.NoteComponent convertNoteComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.NoteComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.NoteComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.NoteComponent();
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

  public static org.hl7.fhir.r4.model.ExplanationOfBenefit.NoteComponent convertNoteComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.NoteComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExplanationOfBenefit.NoteComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.NoteComponent();
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

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.BenefitBalanceComponent convertBenefitBalanceComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.BenefitBalanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.BenefitBalanceComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.BenefitBalanceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasExcluded())
      tgt.setExcludedElement(Boolean40_N.convertBoolean(src.getExcludedElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasNetwork())
      tgt.setNetwork(CodeableConcept40_N.convertCodeableConcept(src.getNetwork()));
    if (src.hasUnit())
      tgt.setUnit(CodeableConcept40_N.convertCodeableConcept(src.getUnit()));
    if (src.hasTerm())
      tgt.setTerm(CodeableConcept40_N.convertCodeableConcept(src.getTerm()));
    for (org.hl7.fhir.r4.model.ExplanationOfBenefit.BenefitComponent t : src.getFinancial())
      tgt.addFinancial(convertBenefitComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExplanationOfBenefit.BenefitBalanceComponent convertBenefitBalanceComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.BenefitBalanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExplanationOfBenefit.BenefitBalanceComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.BenefitBalanceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasExcluded())
      tgt.setExcludedElement(Boolean40_N.convertBoolean(src.getExcludedElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasNetwork())
      tgt.setNetwork(CodeableConcept40_N.convertCodeableConcept(src.getNetwork()));
    if (src.hasUnit())
      tgt.setUnit(CodeableConcept40_N.convertCodeableConcept(src.getUnit()));
    if (src.hasTerm())
      tgt.setTerm(CodeableConcept40_N.convertCodeableConcept(src.getTerm()));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.BenefitComponent t : src.getFinancialList())
      tgt.addFinancial(convertBenefitComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.BenefitComponent convertBenefitComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.BenefitComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.BenefitComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.BenefitComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasAllowed())
      tgt.setAllowed(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getAllowed()));
    if (src.hasUsed())
      tgt.setUsed(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getUsed()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExplanationOfBenefit.BenefitComponent convertBenefitComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.BenefitComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExplanationOfBenefit.BenefitComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.BenefitComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasAllowed())
      tgt.setAllowed(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getAllowed()));
    if (src.hasUsed())
      tgt.setUsed(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getUsed()));
    return tgt;
  }
}